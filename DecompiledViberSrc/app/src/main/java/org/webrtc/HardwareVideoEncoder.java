package org.webrtc;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Bundle;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@TargetApi(19)
class HardwareVideoEncoder
  implements VideoEncoder
{
  private static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US = 100000;
  private static final String KEY_BITRATE_MODE = "bitrate-mode";
  private static final int MAX_ENCODER_Q_SIZE = 2;
  private static final int MAX_VIDEO_FRAMERATE = 30;
  private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
  private static final String TAG = "HardwareVideoEncoder";
  private static final int VIDEO_AVC_LEVEL_3 = 256;
  private static final int VIDEO_AVC_PROFILE_HIGH = 8;
  private static final int VIDEO_ControlRateConstant = 2;
  private int adjustedBitrate;
  private boolean automaticResizeOn;
  private final BitrateAdjuster bitrateAdjuster;
  private VideoEncoder.Callback callback;

  @Nullable
  private MediaCodecWrapper codec;
  private final String codecName;
  private final VideoCodecType codecType;

  @Nullable
  private ByteBuffer configBuffer = null;
  private final ThreadUtils.ThreadChecker encodeThreadChecker = new ThreadUtils.ThreadChecker();
  private final long forcedKeyFrameNs;
  private int height;
  private final int keyFrameIntervalSec;
  private long lastKeyFrameNs;
  private final MediaCodecWrapperFactory mediaCodecWrapperFactory;
  private final BlockingDeque<EncodedImage.Builder> outputBuilders = new LinkedBlockingDeque();

  @Nullable
  private Thread outputThread;
  private final ThreadUtils.ThreadChecker outputThreadChecker = new ThreadUtils.ThreadChecker();
  private final Map<String, String> params;
  private volatile boolean running = false;
  private final EglBase14.Context sharedContext;

  @Nullable
  private volatile Exception shutdownException = null;
  private final Integer surfaceColorFormat;
  private final GlRectDrawer textureDrawer = new GlRectDrawer();

  @Nullable
  private EglBase14 textureEglBase;

  @Nullable
  private Surface textureInputSurface;
  private boolean useSurfaceMode;
  private final VideoFrameDrawer videoFrameDrawer = new VideoFrameDrawer();
  private int width;
  private final Integer yuvColorFormat;
  private final YuvFormat yuvFormat;

  public HardwareVideoEncoder(MediaCodecWrapperFactory paramMediaCodecWrapperFactory, String paramString, VideoCodecType paramVideoCodecType, Integer paramInteger1, Integer paramInteger2, Map<String, String> paramMap, int paramInt1, int paramInt2, BitrateAdjuster paramBitrateAdjuster, EglBase14.Context paramContext)
  {
    this.mediaCodecWrapperFactory = paramMediaCodecWrapperFactory;
    this.codecName = paramString;
    this.codecType = paramVideoCodecType;
    this.surfaceColorFormat = paramInteger1;
    this.yuvColorFormat = paramInteger2;
    this.yuvFormat = YuvFormat.valueOf(paramInteger2.intValue());
    this.params = paramMap;
    this.keyFrameIntervalSec = paramInt1;
    this.forcedKeyFrameNs = TimeUnit.MILLISECONDS.toNanos(paramInt2);
    this.bitrateAdjuster = paramBitrateAdjuster;
    this.sharedContext = paramContext;
    this.encodeThreadChecker.detachThread();
  }

  private boolean canUseSurface()
  {
    return (this.sharedContext != null) && (this.surfaceColorFormat != null);
  }

  private Thread createOutputThread()
  {
    return new Thread()
    {
      public void run()
      {
        while (HardwareVideoEncoder.this.running)
          HardwareVideoEncoder.this.deliverEncodedImage();
        HardwareVideoEncoder.this.releaseCodecOnOutputThread();
      }
    };
  }

  // ERROR //
  private VideoCodecStatus encodeByteBuffer(VideoFrame paramVideoFrame, VideoFrame.Buffer paramBuffer, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 108	org/webrtc/HardwareVideoEncoder:encodeThreadChecker	Lorg/webrtc/ThreadUtils$ThreadChecker;
    //   4: invokevirtual 185	org/webrtc/ThreadUtils$ThreadChecker:checkIsOnValidThread	()V
    //   7: ldc2_w 186
    //   10: aload_1
    //   11: invokevirtual 193	org/webrtc/VideoFrame:getTimestampNs	()J
    //   14: ladd
    //   15: ldc2_w 194
    //   18: ldiv
    //   19: lstore 4
    //   21: aload_0
    //   22: getfield 197	org/webrtc/HardwareVideoEncoder:codec	Lorg/webrtc/MediaCodecWrapper;
    //   25: lconst_0
    //   26: invokeinterface 203 3 0
    //   31: istore 7
    //   33: iload 7
    //   35: iconst_m1
    //   36: if_icmpne +29 -> 65
    //   39: ldc 25
    //   41: ldc 205
    //   43: invokestatic 211	org/webrtc/Logging:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: getstatic 217	org/webrtc/VideoCodecStatus:NO_OUTPUT	Lorg/webrtc/VideoCodecStatus;
    //   49: areturn
    //   50: astore 6
    //   52: ldc 25
    //   54: ldc 219
    //   56: aload 6
    //   58: invokestatic 223	org/webrtc/Logging:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   61: getstatic 226	org/webrtc/VideoCodecStatus:ERROR	Lorg/webrtc/VideoCodecStatus;
    //   64: areturn
    //   65: aload_0
    //   66: getfield 197	org/webrtc/HardwareVideoEncoder:codec	Lorg/webrtc/MediaCodecWrapper;
    //   69: invokeinterface 230 1 0
    //   74: iload 7
    //   76: aaload
    //   77: astore 9
    //   79: aload_0
    //   80: aload 9
    //   82: aload_2
    //   83: invokevirtual 234	org/webrtc/HardwareVideoEncoder:fillInputBuffer	(Ljava/nio/ByteBuffer;Lorg/webrtc/VideoFrame$Buffer;)V
    //   86: aload_0
    //   87: getfield 197	org/webrtc/HardwareVideoEncoder:codec	Lorg/webrtc/MediaCodecWrapper;
    //   90: iload 7
    //   92: iconst_0
    //   93: iload_3
    //   94: lload 4
    //   96: iconst_0
    //   97: invokeinterface 238 7 0
    //   102: getstatic 241	org/webrtc/VideoCodecStatus:OK	Lorg/webrtc/VideoCodecStatus;
    //   105: areturn
    //   106: astore 8
    //   108: ldc 25
    //   110: ldc 243
    //   112: aload 8
    //   114: invokestatic 223	org/webrtc/Logging:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   117: getstatic 226	org/webrtc/VideoCodecStatus:ERROR	Lorg/webrtc/VideoCodecStatus;
    //   120: areturn
    //   121: astore 10
    //   123: ldc 25
    //   125: ldc 245
    //   127: aload 10
    //   129: invokestatic 223	org/webrtc/Logging:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   132: getstatic 226	org/webrtc/VideoCodecStatus:ERROR	Lorg/webrtc/VideoCodecStatus;
    //   135: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   21	33	50	java/lang/IllegalStateException
    //   65	79	106	java/lang/IllegalStateException
    //   86	102	121	java/lang/IllegalStateException
  }

  private VideoCodecStatus encodeTextureBuffer(VideoFrame paramVideoFrame)
  {
    this.encodeThreadChecker.checkIsOnValidThread();
    try
    {
      GLES20.glClear(16384);
      VideoFrame localVideoFrame = new VideoFrame(paramVideoFrame.getBuffer(), 0, paramVideoFrame.getTimestampNs());
      this.videoFrameDrawer.drawFrame(localVideoFrame, this.textureDrawer, null);
      this.textureEglBase.swapBuffers(paramVideoFrame.getTimestampNs());
      return VideoCodecStatus.OK;
    }
    catch (RuntimeException localRuntimeException)
    {
      Logging.e("HardwareVideoEncoder", "encodeTexture failed", localRuntimeException);
    }
    return VideoCodecStatus.ERROR;
  }

  private VideoCodecStatus initEncodeInternal()
  {
    this.encodeThreadChecker.checkIsOnValidThread();
    this.lastKeyFrameNs = -1L;
    try
    {
      this.codec = this.mediaCodecWrapperFactory.createByCodecName(this.codecName);
      if (this.useSurfaceMode)
      {
        localInteger = this.surfaceColorFormat;
        i = localInteger.intValue();
      }
    }
    catch (IOException localIOException)
    {
      try
      {
        Integer localInteger;
        int i;
        MediaFormat localMediaFormat = MediaFormat.createVideoFormat(this.codecType.mimeType(), this.width, this.height);
        localMediaFormat.setInteger("bitrate", this.adjustedBitrate);
        localMediaFormat.setInteger("bitrate-mode", 2);
        localMediaFormat.setInteger("color-format", i);
        localMediaFormat.setInteger("frame-rate", this.bitrateAdjuster.getCodecConfigFramerate());
        localMediaFormat.setInteger("i-frame-interval", this.keyFrameIntervalSec);
        if (this.codecType == VideoCodecType.H264)
        {
          str1 = (String)this.params.get("profile-level-id");
          if (str1 == null)
          {
            str2 = "42e01f";
            j = -1;
          }
        }
        else
        {
          switch (str2.hashCode())
          {
          case 1595523974:
            Logging.w("HardwareVideoEncoder", "Unknown profile level id: " + str2);
          case 1537948542:
            while (true)
            {
              Logging.d("HardwareVideoEncoder", "Format: " + localMediaFormat);
              this.codec.configure(localMediaFormat, null, null, 1);
              if (this.useSurfaceMode)
              {
                this.textureEglBase = new EglBase14(this.sharedContext, EglBase.CONFIG_RECORDABLE);
                this.textureInputSurface = this.codec.createInputSurface();
                this.textureEglBase.createSurface(this.textureInputSurface);
                this.textureEglBase.makeCurrent();
              }
              this.codec.start();
              this.running = true;
              this.outputThreadChecker.detachThread();
              this.outputThread = createOutputThread();
              this.outputThread.start();
              return VideoCodecStatus.OK;
              localIOException = localIOException;
              Logging.e("HardwareVideoEncoder", "Cannot create media encoder " + this.codecName);
              return VideoCodecStatus.FALLBACK_SOFTWARE;
              localInteger = this.yuvColorFormat;
              break;
              if (!str2.equals("640c1f"))
                break label493;
              j = 0;
              break label493;
              if (!str2.equals("42e01f"))
                break label493;
              j = 1;
              break label493;
              localMediaFormat.setInteger("profile", 8);
              localMediaFormat.setInteger("level", 256);
            }
          }
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Logging.e("HardwareVideoEncoder", "initEncodeInternal failed", localIllegalStateException);
        release();
        return VideoCodecStatus.FALLBACK_SOFTWARE;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      int j;
      while (true)
      {
        String str1;
        continue;
        String str2 = str1;
      }
      label493: switch (j)
      {
      default:
      case 1:
      case 0:
      }
    }
  }

  private void releaseCodecOnOutputThread()
  {
    this.outputThreadChecker.checkIsOnValidThread();
    Logging.d("HardwareVideoEncoder", "Releasing MediaCodec on output thread");
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
          this.configBuffer = null;
          Logging.d("HardwareVideoEncoder", "Release on output thread done");
          return;
          localException1 = localException1;
          Logging.e("HardwareVideoEncoder", "Media encoder stop failed", localException1);
        }
      }
      catch (Exception localException2)
      {
        while (true)
        {
          Logging.e("HardwareVideoEncoder", "Media encoder release failed", localException2);
          this.shutdownException = localException2;
        }
      }
    }
  }

  private void requestKeyFrame(long paramLong)
  {
    this.encodeThreadChecker.checkIsOnValidThread();
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("request-sync", 0);
      this.codec.setParameters(localBundle);
      this.lastKeyFrameNs = paramLong;
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Logging.e("HardwareVideoEncoder", "requestKeyFrame failed", localIllegalStateException);
    }
  }

  private VideoCodecStatus resetCodec(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.encodeThreadChecker.checkIsOnValidThread();
    VideoCodecStatus localVideoCodecStatus = release();
    if (localVideoCodecStatus != VideoCodecStatus.OK)
      return localVideoCodecStatus;
    this.width = paramInt1;
    this.height = paramInt2;
    this.useSurfaceMode = paramBoolean;
    return initEncodeInternal();
  }

  private boolean shouldForceKeyFrame(long paramLong)
  {
    this.encodeThreadChecker.checkIsOnValidThread();
    return (this.forcedKeyFrameNs > 0L) && (paramLong > this.lastKeyFrameNs + this.forcedKeyFrameNs);
  }

  private VideoCodecStatus updateBitrate()
  {
    this.outputThreadChecker.checkIsOnValidThread();
    this.adjustedBitrate = this.bitrateAdjuster.getAdjustedBitrateBps();
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("video-bitrate", this.adjustedBitrate);
      this.codec.setParameters(localBundle);
      VideoCodecStatus localVideoCodecStatus = VideoCodecStatus.OK;
      return localVideoCodecStatus;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Logging.e("HardwareVideoEncoder", "updateBitrate failed", localIllegalStateException);
    }
    return VideoCodecStatus.ERROR;
  }

  public long createNativeVideoEncoder()
  {
    return VideoEncoder..CC.createNativeVideoEncoder(this);
  }

  protected void deliverEncodedImage()
  {
    this.outputThreadChecker.checkIsOnValidThread();
    MediaCodec.BufferInfo localBufferInfo;
    ByteBuffer localByteBuffer1;
    try
    {
      localBufferInfo = new MediaCodec.BufferInfo();
      int i = this.codec.dequeueOutputBuffer(localBufferInfo, 100000L);
      if (i < 0)
        return;
      localByteBuffer1 = this.codec.getOutputBuffers()[i];
      localByteBuffer1.position(localBufferInfo.offset);
      localByteBuffer1.limit(localBufferInfo.offset + localBufferInfo.size);
      if ((0x2 & localBufferInfo.flags) != 0)
      {
        Logging.d("HardwareVideoEncoder", "Config frame generated. Offset: " + localBufferInfo.offset + ". Size: " + localBufferInfo.size);
        this.configBuffer = ByteBuffer.allocateDirect(localBufferInfo.size);
        this.configBuffer.put(localByteBuffer1);
        this.codec.releaseOutputBuffer(i, false);
        return;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Logging.e("HardwareVideoEncoder", "deliverOutput failed", localIllegalStateException);
      return;
    }
    this.bitrateAdjuster.reportEncodedFrame(localBufferInfo.size);
    if (this.adjustedBitrate != this.bitrateAdjuster.getAdjustedBitrateBps())
      updateBitrate();
    if ((0x1 & localBufferInfo.flags) != 0);
    for (int j = 1; ; j = 0)
    {
      if (j != 0)
        Logging.d("HardwareVideoEncoder", "Sync frame generated");
      ByteBuffer localByteBuffer2;
      if ((j != 0) && (this.codecType == VideoCodecType.H264))
      {
        Logging.d("HardwareVideoEncoder", "Prepending config frame of size " + this.configBuffer.capacity() + " to output buffer with offset " + localBufferInfo.offset + ", size " + localBufferInfo.size);
        ByteBuffer localByteBuffer3 = ByteBuffer.allocateDirect(localBufferInfo.size + this.configBuffer.capacity());
        this.configBuffer.rewind();
        localByteBuffer3.put(this.configBuffer);
        localByteBuffer3.put(localByteBuffer1);
        localByteBuffer3.rewind();
        localByteBuffer2 = localByteBuffer3;
        label350: if (j == 0)
          break label421;
      }
      label421: EncodedImage.FrameType localFrameType;
      for (Object localObject = EncodedImage.FrameType.VideoFrameKey; ; localObject = localFrameType)
      {
        EncodedImage.Builder localBuilder = (EncodedImage.Builder)this.outputBuilders.poll();
        localBuilder.setBuffer(localByteBuffer2).setFrameType((EncodedImage.FrameType)localObject);
        this.callback.onEncodedFrame(localBuilder.createEncodedImage(), new VideoEncoder.CodecSpecificInfo());
        break;
        localByteBuffer2 = localByteBuffer1.slice();
        break label350;
        localFrameType = EncodedImage.FrameType.VideoFrameDelta;
      }
    }
  }

  public VideoCodecStatus encode(VideoFrame paramVideoFrame, VideoEncoder.EncodeInfo paramEncodeInfo)
  {
    int i = 0;
    this.encodeThreadChecker.checkIsOnValidThread();
    VideoCodecStatus localVideoCodecStatus;
    if (this.codec == null)
      localVideoCodecStatus = VideoCodecStatus.UNINITIALIZED;
    while (true)
    {
      return localVideoCodecStatus;
      VideoFrame.Buffer localBuffer = paramVideoFrame.getBuffer();
      boolean bool1 = localBuffer instanceof VideoFrame.TextureBuffer;
      int j = paramVideoFrame.getBuffer().getWidth();
      int k = paramVideoFrame.getBuffer().getHeight();
      if ((canUseSurface()) && (bool1));
      for (boolean bool2 = true; ; bool2 = false)
      {
        if ((j != this.width) || (k != this.height) || (bool2 != this.useSurfaceMode))
        {
          localVideoCodecStatus = resetCodec(j, k, bool2);
          if (localVideoCodecStatus != VideoCodecStatus.OK)
            break;
        }
        if (this.outputBuilders.size() <= 2)
          break label152;
        Logging.e("HardwareVideoEncoder", "Dropped frame, encoder queue full");
        return VideoCodecStatus.NO_OUTPUT;
      }
      label152: EncodedImage.FrameType[] arrayOfFrameType = paramEncodeInfo.frameTypes;
      int m = arrayOfFrameType.length;
      int n = 0;
      while (i < m)
      {
        if (arrayOfFrameType[i] == EncodedImage.FrameType.VideoFrameKey)
          n = 1;
        i++;
      }
      if ((n != 0) || (shouldForceKeyFrame(paramVideoFrame.getTimestampNs())))
        requestKeyFrame(paramVideoFrame.getTimestampNs());
      int i1 = 3 * (localBuffer.getHeight() * localBuffer.getWidth()) / 2;
      EncodedImage.Builder localBuilder = EncodedImage.builder().setCaptureTimeNs(paramVideoFrame.getTimestampNs()).setCompleteFrame(true).setEncodedWidth(paramVideoFrame.getBuffer().getWidth()).setEncodedHeight(paramVideoFrame.getBuffer().getHeight()).setRotation(paramVideoFrame.getRotation());
      this.outputBuilders.offer(localBuilder);
      if (this.useSurfaceMode);
      for (localVideoCodecStatus = encodeTextureBuffer(paramVideoFrame); localVideoCodecStatus != VideoCodecStatus.OK; localVideoCodecStatus = encodeByteBuffer(paramVideoFrame, localBuffer, i1))
      {
        this.outputBuilders.pollLast();
        return localVideoCodecStatus;
      }
    }
  }

  protected void fillInputBuffer(ByteBuffer paramByteBuffer, VideoFrame.Buffer paramBuffer)
  {
    this.yuvFormat.fillBuffer(paramByteBuffer, paramBuffer);
  }

  public String getImplementationName()
  {
    return "HWEncoder";
  }

  public VideoEncoder.ScalingSettings getScalingSettings()
  {
    this.encodeThreadChecker.checkIsOnValidThread();
    if (this.automaticResizeOn)
    {
      if (this.codecType == VideoCodecType.VP8)
        return new VideoEncoder.ScalingSettings(29, 95);
      if (this.codecType == VideoCodecType.H264)
        return new VideoEncoder.ScalingSettings(24, 37);
    }
    return VideoEncoder.ScalingSettings.OFF;
  }

  public VideoCodecStatus initEncode(VideoEncoder.Settings paramSettings, VideoEncoder.Callback paramCallback)
  {
    this.encodeThreadChecker.checkIsOnValidThread();
    this.callback = paramCallback;
    this.automaticResizeOn = paramSettings.automaticResizeOn;
    this.width = paramSettings.width;
    this.height = paramSettings.height;
    this.useSurfaceMode = canUseSurface();
    if ((paramSettings.startBitrate != 0) && (paramSettings.maxFramerate != 0))
      this.bitrateAdjuster.setTargets(1000 * paramSettings.startBitrate, paramSettings.maxFramerate);
    this.adjustedBitrate = this.bitrateAdjuster.getAdjustedBitrateBps();
    Logging.d("HardwareVideoEncoder", "initEncode: " + this.width + " x " + this.height + ". @ " + paramSettings.startBitrate + "kbps. Fps: " + paramSettings.maxFramerate + " Use surface mode: " + this.useSurfaceMode);
    return initEncodeInternal();
  }

  public boolean isHardwareEncoder()
  {
    return VideoEncoder..CC.isHardwareEncoder(this);
  }

  public VideoCodecStatus release()
  {
    this.encodeThreadChecker.checkIsOnValidThread();
    VideoCodecStatus localVideoCodecStatus;
    if (this.outputThread == null)
      localVideoCodecStatus = VideoCodecStatus.OK;
    while (true)
    {
      this.textureDrawer.release();
      this.videoFrameDrawer.release();
      if (this.textureEglBase != null)
      {
        this.textureEglBase.release();
        this.textureEglBase = null;
      }
      if (this.textureInputSurface != null)
      {
        this.textureInputSurface.release();
        this.textureInputSurface = null;
      }
      this.outputBuilders.clear();
      this.codec = null;
      this.outputThread = null;
      this.encodeThreadChecker.detachThread();
      return localVideoCodecStatus;
      this.running = false;
      if (!ThreadUtils.joinUninterruptibly(this.outputThread, 5000L))
      {
        Logging.e("HardwareVideoEncoder", "Media encoder release timeout");
        localVideoCodecStatus = VideoCodecStatus.TIMEOUT;
      }
      else if (this.shutdownException != null)
      {
        Logging.e("HardwareVideoEncoder", "Media encoder release exception", this.shutdownException);
        localVideoCodecStatus = VideoCodecStatus.ERROR;
      }
      else
      {
        localVideoCodecStatus = VideoCodecStatus.OK;
      }
    }
  }

  public VideoCodecStatus setChannelParameters(short paramShort, long paramLong)
  {
    this.encodeThreadChecker.checkIsOnValidThread();
    return VideoCodecStatus.OK;
  }

  public VideoCodecStatus setRateAllocation(VideoEncoder.BitrateAllocation paramBitrateAllocation, int paramInt)
  {
    this.encodeThreadChecker.checkIsOnValidThread();
    if (paramInt > 30)
      paramInt = 30;
    this.bitrateAdjuster.setTargets(paramBitrateAllocation.getSum(), paramInt);
    return VideoCodecStatus.OK;
  }

  private static abstract enum YuvFormat
  {
    static
    {
      YuvFormat[] arrayOfYuvFormat = new YuvFormat[2];
      arrayOfYuvFormat[0] = I420;
      arrayOfYuvFormat[1] = NV12;
    }

    static YuvFormat valueOf(int paramInt)
    {
      switch (paramInt)
      {
      default:
        throw new IllegalArgumentException("Unsupported colorFormat: " + paramInt);
      case 19:
        return I420;
      case 21:
      case 2141391872:
      case 2141391876:
      }
      return NV12;
    }

    abstract void fillBuffer(ByteBuffer paramByteBuffer, VideoFrame.Buffer paramBuffer);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.HardwareVideoEncoder
 * JD-Core Version:    0.6.2
 */