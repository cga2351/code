package org.webrtc;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@TargetApi(16)
class HardwareVideoDecoder
  implements VideoDecoder, VideoSink
{
  private static final int DEQUEUE_INPUT_TIMEOUT_US = 500000;
  private static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US = 100000;
  private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
  private static final String MEDIA_FORMAT_KEY_CROP_BOTTOM = "crop-bottom";
  private static final String MEDIA_FORMAT_KEY_CROP_LEFT = "crop-left";
  private static final String MEDIA_FORMAT_KEY_CROP_RIGHT = "crop-right";
  private static final String MEDIA_FORMAT_KEY_CROP_TOP = "crop-top";
  private static final String MEDIA_FORMAT_KEY_SLICE_HEIGHT = "slice-height";
  private static final String MEDIA_FORMAT_KEY_STRIDE = "stride";
  private static final String TAG = "HardwareVideoDecoder";

  @Nullable
  private VideoDecoder.Callback callback;

  @Nullable
  private MediaCodecWrapper codec = null;
  private final String codecName;
  private final VideoCodecType codecType;
  private int colorFormat;
  private ThreadUtils.ThreadChecker decoderThreadChecker;
  private final Object dimensionLock = new Object();
  private final BlockingDeque<FrameInfo> frameInfos;
  private boolean hasDecodedFirstFrame;
  private int height;
  private boolean keyFrameRequired;
  private final MediaCodecWrapperFactory mediaCodecWrapperFactory;

  @Nullable
  private Thread outputThread;
  private ThreadUtils.ThreadChecker outputThreadChecker;

  @Nullable
  private DecodedTextureMetadata renderedTextureMetadata;
  private final Object renderedTextureMetadataLock = new Object();
  private volatile boolean running = false;
  private final EglBase.Context sharedContext;

  @Nullable
  private volatile Exception shutdownException = null;
  private int sliceHeight;
  private int stride;

  @Nullable
  private Surface surface = null;

  @Nullable
  private SurfaceTextureHelper surfaceTextureHelper;
  private int width;

  HardwareVideoDecoder(MediaCodecWrapperFactory paramMediaCodecWrapperFactory, String paramString, VideoCodecType paramVideoCodecType, int paramInt, EglBase.Context paramContext)
  {
    if (!isSupportedColorFormat(paramInt))
      throw new IllegalArgumentException("Unsupported color format: " + paramInt);
    this.mediaCodecWrapperFactory = paramMediaCodecWrapperFactory;
    this.codecName = paramString;
    this.codecType = paramVideoCodecType;
    this.colorFormat = paramInt;
    this.sharedContext = paramContext;
    this.frameInfos = new LinkedBlockingDeque();
  }

  private VideoFrame.Buffer copyI420Buffer(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 % 2 != 0)
      throw new AssertionError("Stride is not divisible by two: " + paramInt1);
    int i = (paramInt3 + 1) / 2;
    if (paramInt2 % 2 == 0);
    for (int j = (paramInt4 + 1) / 2; ; j = paramInt4 / 2)
    {
      int k = paramInt1 / 2;
      int m = 0 + paramInt1 * paramInt4;
      int n = 0 + paramInt1 * paramInt2;
      int i1 = n + k * j;
      int i2 = n + k * paramInt2 / 2;
      int i3 = i2 + k * j;
      VideoFrame.I420Buffer localI420Buffer = allocateI420Buffer(paramInt3, paramInt4);
      paramByteBuffer.limit(m);
      paramByteBuffer.position(0);
      copyPlane(paramByteBuffer.slice(), paramInt1, localI420Buffer.getDataY(), localI420Buffer.getStrideY(), paramInt3, paramInt4);
      paramByteBuffer.limit(i1);
      paramByteBuffer.position(n);
      copyPlane(paramByteBuffer.slice(), k, localI420Buffer.getDataU(), localI420Buffer.getStrideU(), i, j);
      if (paramInt2 % 2 == 1)
      {
        paramByteBuffer.position(n + k * (j - 1));
        ByteBuffer localByteBuffer2 = localI420Buffer.getDataU();
        localByteBuffer2.position(j * localI420Buffer.getStrideU());
        localByteBuffer2.put(paramByteBuffer);
      }
      paramByteBuffer.limit(i3);
      paramByteBuffer.position(i2);
      copyPlane(paramByteBuffer.slice(), k, localI420Buffer.getDataV(), localI420Buffer.getStrideV(), i, j);
      if (paramInt2 % 2 == 1)
      {
        paramByteBuffer.position(i2 + k * (j - 1));
        ByteBuffer localByteBuffer1 = localI420Buffer.getDataV();
        localByteBuffer1.position(j * localI420Buffer.getStrideV());
        localByteBuffer1.put(paramByteBuffer);
      }
      return localI420Buffer;
    }
  }

  private VideoFrame.Buffer copyNV12ToI420Buffer(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new NV12Buffer(paramInt3, paramInt4, paramInt1, paramInt2, paramByteBuffer, null).toI420();
  }

  private Thread createOutputThread()
  {
    return new Thread("HardwareVideoDecoder.outputThread")
    {
      public void run()
      {
        HardwareVideoDecoder.access$002(HardwareVideoDecoder.this, new ThreadUtils.ThreadChecker());
        while (HardwareVideoDecoder.this.running)
          HardwareVideoDecoder.this.deliverDecodedFrame();
        HardwareVideoDecoder.this.releaseCodecOnOutputThread();
      }
    };
  }

  private void deliverByteFrame(int paramInt1, MediaCodec.BufferInfo paramBufferInfo, int paramInt2, Integer paramInteger)
  {
    int i;
    int j;
    int k;
    int m;
    synchronized (this.dimensionLock)
    {
      i = this.width;
      j = this.height;
      k = this.stride;
      m = this.sliceHeight;
      if (paramBufferInfo.size < 3 * (i * j) / 2)
      {
        Logging.e("HardwareVideoDecoder", "Insufficient output buffer size: " + paramBufferInfo.size);
        return;
      }
    }
    if ((paramBufferInfo.size < 3 * (k * j) / 2) && (m == j) && (k > i))
      k = 2 * paramBufferInfo.size / (j * 3);
    ByteBuffer localByteBuffer1 = this.codec.getOutputBuffers()[paramInt1];
    localByteBuffer1.position(paramBufferInfo.offset);
    localByteBuffer1.limit(paramBufferInfo.offset + paramBufferInfo.size);
    ByteBuffer localByteBuffer2 = localByteBuffer1.slice();
    if (this.colorFormat == 19);
    for (VideoFrame.Buffer localBuffer = copyI420Buffer(localByteBuffer2, k, m, i, j); ; localBuffer = copyNV12ToI420Buffer(localByteBuffer2, k, m, i, j))
    {
      this.codec.releaseOutputBuffer(paramInt1, false);
      VideoFrame localVideoFrame = new VideoFrame(localBuffer, paramInt2, 1000L * paramBufferInfo.presentationTimeUs);
      this.callback.onDecodedFrame(localVideoFrame, paramInteger, null);
      localVideoFrame.release();
      return;
    }
  }

  private void deliverTextureFrame(int paramInt1, MediaCodec.BufferInfo paramBufferInfo, int paramInt2, Integer paramInteger)
  {
    int i;
    int j;
    synchronized (this.dimensionLock)
    {
      i = this.width;
      j = this.height;
    }
    synchronized (this.renderedTextureMetadataLock)
    {
      if (this.renderedTextureMetadata != null)
      {
        this.codec.releaseOutputBuffer(paramInt1, false);
        return;
        localObject2 = finally;
        throw localObject2;
      }
      this.surfaceTextureHelper.setTextureSize(i, j);
      this.surfaceTextureHelper.setFrameRotation(paramInt2);
      this.renderedTextureMetadata = new DecodedTextureMetadata(paramBufferInfo.presentationTimeUs, paramInteger);
      this.codec.releaseOutputBuffer(paramInt1, true);
      return;
    }
  }

  private VideoCodecStatus initDecodeInternal(int paramInt1, int paramInt2)
  {
    this.decoderThreadChecker.checkIsOnValidThread();
    Logging.d("HardwareVideoDecoder", "initDecodeInternal");
    if (this.outputThread != null)
    {
      Logging.e("HardwareVideoDecoder", "initDecodeInternal called while the codec is already running");
      return VideoCodecStatus.FALLBACK_SOFTWARE;
    }
    this.width = paramInt1;
    this.height = paramInt2;
    this.stride = paramInt1;
    this.sliceHeight = paramInt2;
    this.hasDecodedFirstFrame = false;
    this.keyFrameRequired = true;
    try
    {
      this.codec = this.mediaCodecWrapperFactory.createByCodecName(this.codecName);
    }
    catch (IOException localIOException)
    {
      try
      {
        MediaFormat localMediaFormat = MediaFormat.createVideoFormat(this.codecType.mimeType(), paramInt1, paramInt2);
        if (this.sharedContext == null)
          localMediaFormat.setInteger("color-format", this.colorFormat);
        this.codec.configure(localMediaFormat, this.surface, null, 0);
        this.codec.start();
        this.running = true;
        this.outputThread = createOutputThread();
        this.outputThread.start();
        Logging.d("HardwareVideoDecoder", "initDecodeInternal done");
        return VideoCodecStatus.OK;
        localIOException = localIOException;
        Logging.e("HardwareVideoDecoder", "Cannot create media decoder " + this.codecName);
        return VideoCodecStatus.FALLBACK_SOFTWARE;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Logging.e("HardwareVideoDecoder", "initDecode failed", localIllegalStateException);
        release();
        return VideoCodecStatus.FALLBACK_SOFTWARE;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label174: break label174;
    }
  }

  private boolean isSupportedColorFormat(int paramInt)
  {
    int[] arrayOfInt = MediaCodecUtils.DECODER_COLOR_FORMATS;
    int i = arrayOfInt.length;
    for (int j = 0; ; j++)
    {
      boolean bool = false;
      if (j < i)
      {
        if (arrayOfInt[j] == paramInt)
          bool = true;
      }
      else
        return bool;
    }
  }

  private void reformat(MediaFormat paramMediaFormat)
  {
    this.outputThreadChecker.checkIsOnValidThread();
    Logging.d("HardwareVideoDecoder", "Decoder format changed: " + paramMediaFormat.toString());
    int i;
    int j;
    if ((paramMediaFormat.containsKey("crop-left")) && (paramMediaFormat.containsKey("crop-right")) && (paramMediaFormat.containsKey("crop-bottom")) && (paramMediaFormat.containsKey("crop-top")))
    {
      i = 1 + paramMediaFormat.getInteger("crop-right") - paramMediaFormat.getInteger("crop-left");
      j = 1 + paramMediaFormat.getInteger("crop-bottom") - paramMediaFormat.getInteger("crop-top");
    }
    synchronized (this.dimensionLock)
    {
      while ((this.hasDecodedFirstFrame) && ((this.width != i) || (this.height != j)))
      {
        stopOnOutputThread(new RuntimeException("Unexpected size change. Configured " + this.width + "*" + this.height + ". New " + i + "*" + j));
        return;
        i = paramMediaFormat.getInteger("width");
        j = paramMediaFormat.getInteger("height");
      }
      this.width = i;
      this.height = j;
      if ((this.surfaceTextureHelper == null) && (paramMediaFormat.containsKey("color-format")))
      {
        this.colorFormat = paramMediaFormat.getInteger("color-format");
        Logging.d("HardwareVideoDecoder", "Color: 0x" + Integer.toHexString(this.colorFormat));
        if (!isSupportedColorFormat(this.colorFormat))
        {
          stopOnOutputThread(new IllegalStateException("Unsupported color format: " + this.colorFormat));
          return;
        }
      }
    }
    synchronized (this.dimensionLock)
    {
      if (paramMediaFormat.containsKey("stride"))
        this.stride = paramMediaFormat.getInteger("stride");
      if (paramMediaFormat.containsKey("slice-height"))
        this.sliceHeight = paramMediaFormat.getInteger("slice-height");
      Logging.d("HardwareVideoDecoder", "Frame stride and slice height: " + this.stride + " x " + this.sliceHeight);
      this.stride = Math.max(this.width, this.stride);
      this.sliceHeight = Math.max(this.height, this.sliceHeight);
      return;
    }
  }

  private VideoCodecStatus reinitDecode(int paramInt1, int paramInt2)
  {
    this.decoderThreadChecker.checkIsOnValidThread();
    VideoCodecStatus localVideoCodecStatus = releaseInternal();
    if (localVideoCodecStatus != VideoCodecStatus.OK)
      return localVideoCodecStatus;
    return initDecodeInternal(paramInt1, paramInt2);
  }

  private void releaseCodecOnOutputThread()
  {
    this.outputThreadChecker.checkIsOnValidThread();
    Logging.d("HardwareVideoDecoder", "Releasing MediaCodec on output thread");
    try
    {
      this.codec.stop();
    }
    catch (Exception localException1)
    {
      try
      {
        while (true)
        {
          this.codec.release();
          Logging.d("HardwareVideoDecoder", "Release on output thread done");
          return;
          localException1 = localException1;
          Logging.e("HardwareVideoDecoder", "Media decoder stop failed", localException1);
        }
      }
      catch (Exception localException2)
      {
        while (true)
        {
          Logging.e("HardwareVideoDecoder", "Media decoder release failed", localException2);
          this.shutdownException = localException2;
        }
      }
    }
  }

  private VideoCodecStatus releaseInternal()
  {
    if (!this.running)
    {
      Logging.d("HardwareVideoDecoder", "release: Decoder is not running.");
      return VideoCodecStatus.OK;
    }
    try
    {
      this.running = false;
      if (!ThreadUtils.joinUninterruptibly(this.outputThread, 5000L))
      {
        Logging.e("HardwareVideoDecoder", "Media decoder release timeout", new RuntimeException());
        VideoCodecStatus localVideoCodecStatus2 = VideoCodecStatus.TIMEOUT;
        return localVideoCodecStatus2;
      }
      if (this.shutdownException != null)
      {
        Logging.e("HardwareVideoDecoder", "Media decoder release error", new RuntimeException(this.shutdownException));
        this.shutdownException = null;
        VideoCodecStatus localVideoCodecStatus1 = VideoCodecStatus.ERROR;
        return localVideoCodecStatus1;
      }
      return VideoCodecStatus.OK;
    }
    finally
    {
      this.codec = null;
      this.outputThread = null;
    }
  }

  private void stopOnOutputThread(Exception paramException)
  {
    this.outputThreadChecker.checkIsOnValidThread();
    this.running = false;
    this.shutdownException = paramException;
  }

  protected VideoFrame.I420Buffer allocateI420Buffer(int paramInt1, int paramInt2)
  {
    return JavaI420Buffer.allocate(paramInt1, paramInt2);
  }

  protected void copyPlane(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, int paramInt3, int paramInt4)
  {
    YuvHelper.copyPlane(paramByteBuffer1, paramInt1, paramByteBuffer2, paramInt2, paramInt3, paramInt4);
  }

  public long createNativeVideoDecoder()
  {
    return VideoDecoder..CC.createNativeVideoDecoder(this);
  }

  protected SurfaceTextureHelper createSurfaceTextureHelper()
  {
    return SurfaceTextureHelper.create("decoder-texture-thread", this.sharedContext);
  }

  public VideoCodecStatus decode(EncodedImage paramEncodedImage, VideoDecoder.DecodeInfo paramDecodeInfo)
  {
    this.decoderThreadChecker.checkIsOnValidThread();
    boolean bool;
    VideoCodecStatus localVideoCodecStatus;
    if ((this.codec == null) || (this.callback == null))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("decode uninitalized, codec: ");
      if (this.codec != null)
      {
        bool = true;
        Logging.d("HardwareVideoDecoder", bool + ", callback: " + this.callback);
        localVideoCodecStatus = VideoCodecStatus.UNINITIALIZED;
      }
    }
    int i;
    while (true)
    {
      return localVideoCodecStatus;
      bool = false;
      break;
      if (paramEncodedImage.buffer == null)
      {
        Logging.e("HardwareVideoDecoder", "decode() - no input data");
        return VideoCodecStatus.ERR_PARAMETER;
      }
      i = paramEncodedImage.buffer.remaining();
      if (i == 0)
      {
        Logging.e("HardwareVideoDecoder", "decode() - input buffer empty");
        return VideoCodecStatus.ERR_PARAMETER;
      }
      synchronized (this.dimensionLock)
      {
        int j = this.width;
        int k = this.height;
        if ((paramEncodedImage.encodedWidth * paramEncodedImage.encodedHeight > 0) && ((paramEncodedImage.encodedWidth != j) || (paramEncodedImage.encodedHeight != k)))
        {
          localVideoCodecStatus = reinitDecode(paramEncodedImage.encodedWidth, paramEncodedImage.encodedHeight);
          if (localVideoCodecStatus != VideoCodecStatus.OK);
        }
        else
        {
          if (!this.keyFrameRequired)
            break label263;
          if (paramEncodedImage.frameType != EncodedImage.FrameType.VideoFrameKey)
          {
            Logging.e("HardwareVideoDecoder", "decode() - key frame required first");
            return VideoCodecStatus.NO_OUTPUT;
          }
        }
      }
    }
    if (!paramEncodedImage.completeFrame)
    {
      Logging.e("HardwareVideoDecoder", "decode() - complete frame required first");
      return VideoCodecStatus.NO_OUTPUT;
    }
    label263: int m;
    try
    {
      m = this.codec.dequeueInputBuffer(500000L);
      if (m < 0)
      {
        Logging.e("HardwareVideoDecoder", "decode() - no HW buffers available; decoder falling behind");
        return VideoCodecStatus.ERROR;
      }
    }
    catch (IllegalStateException localIllegalStateException1)
    {
      Logging.e("HardwareVideoDecoder", "dequeueInputBuffer failed", localIllegalStateException1);
      return VideoCodecStatus.ERROR;
    }
    ByteBuffer localByteBuffer;
    try
    {
      localByteBuffer = this.codec.getInputBuffers()[m];
      if (localByteBuffer.capacity() < i)
      {
        Logging.e("HardwareVideoDecoder", "decode() - HW buffer too small");
        return VideoCodecStatus.ERROR;
      }
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      Logging.e("HardwareVideoDecoder", "getInputBuffers failed", localIllegalStateException2);
      return VideoCodecStatus.ERROR;
    }
    localByteBuffer.put(paramEncodedImage.buffer);
    this.frameInfos.offer(new FrameInfo(SystemClock.elapsedRealtime(), paramEncodedImage.rotation));
    try
    {
      this.codec.queueInputBuffer(m, 0, i, TimeUnit.NANOSECONDS.toMicros(paramEncodedImage.captureTimeNs), 0);
      if (this.keyFrameRequired)
        this.keyFrameRequired = false;
      return VideoCodecStatus.OK;
    }
    catch (IllegalStateException localIllegalStateException3)
    {
      Logging.e("HardwareVideoDecoder", "queueInputBuffer failed", localIllegalStateException3);
      this.frameInfos.pollLast();
    }
    return VideoCodecStatus.ERROR;
  }

  protected void deliverDecodedFrame()
  {
    this.outputThreadChecker.checkIsOnValidThread();
    MediaCodec.BufferInfo localBufferInfo;
    int i;
    try
    {
      localBufferInfo = new MediaCodec.BufferInfo();
      i = this.codec.dequeueOutputBuffer(localBufferInfo, 100000L);
      if (i == -2)
      {
        reformat(this.codec.getOutputFormat());
        return;
      }
      if (i < 0)
      {
        Logging.v("HardwareVideoDecoder", "dequeueOutputBuffer returned " + i);
        return;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Logging.e("HardwareVideoDecoder", "deliverDecodedFrame failed", localIllegalStateException);
      return;
    }
    FrameInfo localFrameInfo = (FrameInfo)this.frameInfos.poll();
    Integer localInteger;
    int j;
    if (localFrameInfo != null)
    {
      localInteger = Integer.valueOf((int)(SystemClock.elapsedRealtime() - localFrameInfo.decodeStartTimeMs));
      j = localFrameInfo.rotation;
    }
    while (true)
    {
      this.hasDecodedFirstFrame = true;
      if (this.surfaceTextureHelper != null)
      {
        deliverTextureFrame(i, localBufferInfo, j, localInteger);
        return;
      }
      deliverByteFrame(i, localBufferInfo, j, localInteger);
      return;
      j = 0;
      localInteger = null;
    }
  }

  public String getImplementationName()
  {
    return "HWDecoder";
  }

  public boolean getPrefersLateDecoding()
  {
    return true;
  }

  public VideoCodecStatus initDecode(VideoDecoder.Settings paramSettings, VideoDecoder.Callback paramCallback)
  {
    this.decoderThreadChecker = new ThreadUtils.ThreadChecker();
    this.callback = paramCallback;
    if (this.sharedContext != null)
    {
      this.surfaceTextureHelper = createSurfaceTextureHelper();
      this.surface = new Surface(this.surfaceTextureHelper.getSurfaceTexture());
      this.surfaceTextureHelper.startListening(this);
    }
    return initDecodeInternal(paramSettings.width, paramSettings.height);
  }

  public void onFrame(VideoFrame paramVideoFrame)
  {
    synchronized (this.renderedTextureMetadataLock)
    {
      if (this.renderedTextureMetadata == null)
        throw new IllegalStateException("Rendered texture metadata was null in onTextureFrameAvailable.");
    }
    long l = 1000L * this.renderedTextureMetadata.presentationTimestampUs;
    int i = this.renderedTextureMetadata.decodeTimeMs.intValue();
    this.renderedTextureMetadata = null;
    VideoFrame localVideoFrame = new VideoFrame(paramVideoFrame.getBuffer(), paramVideoFrame.getRotation(), l);
    this.callback.onDecodedFrame(localVideoFrame, Integer.valueOf(i), null);
  }

  public VideoCodecStatus release()
  {
    Logging.d("HardwareVideoDecoder", "release");
    VideoCodecStatus localVideoCodecStatus = releaseInternal();
    if (this.surface != null)
    {
      releaseSurface();
      this.surface = null;
      this.surfaceTextureHelper.stopListening();
      this.surfaceTextureHelper.dispose();
      this.surfaceTextureHelper = null;
    }
    synchronized (this.renderedTextureMetadataLock)
    {
      this.renderedTextureMetadata = null;
      this.callback = null;
      this.frameInfos.clear();
      return localVideoCodecStatus;
    }
  }

  protected void releaseSurface()
  {
    this.surface.release();
  }

  private static class DecodedTextureMetadata
  {
    final Integer decodeTimeMs;
    final long presentationTimestampUs;

    DecodedTextureMetadata(long paramLong, Integer paramInteger)
    {
      this.presentationTimestampUs = paramLong;
      this.decodeTimeMs = paramInteger;
    }
  }

  private static class FrameInfo
  {
    final long decodeStartTimeMs;
    final int rotation;

    FrameInfo(long paramLong, int paramInt)
    {
      this.decodeStartTimeMs = paramLong;
      this.rotation = paramInt;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.HardwareVideoDecoder
 * JD-Core Version:    0.6.2
 */