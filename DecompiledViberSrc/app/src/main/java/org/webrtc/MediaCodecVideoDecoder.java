package org.webrtc;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@Deprecated
public class MediaCodecVideoDecoder
{
  private static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
  private static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar16m4ka = 2141391874;
  private static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar32m4ka = 2141391873;
  private static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar64x32Tile2m8ka = 2141391875;
  private static final int DEQUEUE_INPUT_TIMEOUT = 500000;
  private static final String FORMAT_KEY_CROP_BOTTOM = "crop-bottom";
  private static final String FORMAT_KEY_CROP_LEFT = "crop-left";
  private static final String FORMAT_KEY_CROP_RIGHT = "crop-right";
  private static final String FORMAT_KEY_CROP_TOP = "crop-top";
  private static final String FORMAT_KEY_SLICE_HEIGHT = "slice-height";
  private static final String FORMAT_KEY_STRIDE = "stride";
  private static final String H264_MIME_TYPE = "video/avc";
  private static final long MAX_DECODE_TIME_MS = 200L;
  private static final int MAX_QUEUED_OUTPUTBUFFERS = 3;
  private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
  private static final String TAG = "MediaCodecVideoDecoder";
  private static final String VP8_MIME_TYPE = "video/x-vnd.on2.vp8";
  private static final String VP9_MIME_TYPE = "video/x-vnd.on2.vp9";
  private static int codecErrors = 0;

  @Nullable
  private static EglBase eglBase;

  @Nullable
  private static MediaCodecVideoDecoderErrorCallback errorCallback;
  private static Set<String> hwDecoderDisabledTypes;

  @Nullable
  private static MediaCodecVideoDecoder runningInstance = null;
  private static final List<Integer> supportedColorList = Arrays.asList(arrayOfInteger);
  private static final String supportedExynosH264HighProfileHwCodecPrefix = "OMX.Exynos.";
  private static final String supportedMediaTekH264HighProfileHwCodecPrefix = "OMX.MTK.";
  private static final String supportedQcomH264HighProfileHwCodecPrefix = "OMX.qcom.";
  private static final String[] supportedVp9HwCodecPrefixes;
  private int colorFormat;
  private final Queue<TimeStamps> decodeStartTimeMs = new ArrayDeque();
  private final Queue<DecodedOutputBuffer> dequeuedSurfaceOutputBuffers = new ArrayDeque();
  private int droppedFrames;
  private boolean hasDecodedFirstFrame;
  private int height;
  private ByteBuffer[] inputBuffers;

  @Nullable
  private MediaCodec mediaCodec;

  @Nullable
  private Thread mediaCodecThread;
  private ByteBuffer[] outputBuffers;
  private int sliceHeight;
  private int stride;

  @Nullable
  private Surface surface = null;

  @Nullable
  private TextureListener textureListener;
  private int width;

  static
  {
    errorCallback = null;
    codecErrors = 0;
    hwDecoderDisabledTypes = new HashSet();
    supportedVp9HwCodecPrefixes = new String[] { "OMX.qcom.", "OMX.Exynos." };
    Integer[] arrayOfInteger = new Integer[7];
    arrayOfInteger[0] = Integer.valueOf(19);
    arrayOfInteger[1] = Integer.valueOf(21);
    arrayOfInteger[2] = Integer.valueOf(2141391872);
    arrayOfInteger[3] = Integer.valueOf(2141391873);
    arrayOfInteger[4] = Integer.valueOf(2141391874);
    arrayOfInteger[5] = Integer.valueOf(2141391875);
    arrayOfInteger[6] = Integer.valueOf(2141391876);
  }

  private void MaybeRenderDecodedTextureBuffer()
  {
    if ((this.dequeuedSurfaceOutputBuffers.isEmpty()) || (this.textureListener.isWaitingForTexture()))
      return;
    DecodedOutputBuffer localDecodedOutputBuffer = (DecodedOutputBuffer)this.dequeuedSurfaceOutputBuffers.remove();
    this.textureListener.addBufferToRender(localDecodedOutputBuffer);
    this.mediaCodec.releaseOutputBuffer(localDecodedOutputBuffer.index, true);
  }

  private void checkOnMediaCodecThread()
    throws IllegalStateException
  {
    if (this.mediaCodecThread.getId() != Thread.currentThread().getId())
      throw new IllegalStateException("MediaCodecVideoDecoder previously operated on " + this.mediaCodecThread + " but is now called on " + Thread.currentThread());
  }

  public static VideoDecoderFactory createFactory()
  {
    return new DefaultVideoDecoderFactory(new HwDecoderFactory());
  }

  @CalledByNativeUnchecked
  private int dequeueInputBuffer()
  {
    checkOnMediaCodecThread();
    try
    {
      int i = this.mediaCodec.dequeueInputBuffer(500000L);
      return i;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Logging.e("MediaCodecVideoDecoder", "dequeueIntputBuffer failed", localIllegalStateException);
    }
    return -2;
  }

  @Nullable
  @CalledByNativeUnchecked
  private DecodedOutputBuffer dequeueOutputBuffer(int paramInt)
  {
    long l1 = 200L;
    checkOnMediaCodecThread();
    if (this.decodeStartTimeMs.isEmpty())
      return null;
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    int i = this.mediaCodec.dequeueOutputBuffer(localBufferInfo, TimeUnit.MILLISECONDS.toMicros(paramInt));
    TimeStamps localTimeStamps;
    long l2;
    switch (i)
    {
    default:
      this.hasDecodedFirstFrame = true;
      localTimeStamps = (TimeStamps)this.decodeStartTimeMs.remove();
      l2 = SystemClock.elapsedRealtime() - localTimeStamps.decodeStartTimeMs;
      if (l2 > l1)
        Logging.e("MediaCodecVideoDecoder", "Very high decode time: " + l2 + "ms. Q size: " + this.decodeStartTimeMs.size() + ". Might be caused by resuming H264 decoding after a pause.");
      break;
    case -3:
    case -2:
    case -1:
    }
    while (true)
    {
      return new DecodedOutputBuffer(i, localBufferInfo.offset, localBufferInfo.size, TimeUnit.MICROSECONDS.toMillis(localBufferInfo.presentationTimeUs), localTimeStamps.timeStampMs, localTimeStamps.ntpTimeStampMs, l1, SystemClock.elapsedRealtime());
      this.outputBuffers = this.mediaCodec.getOutputBuffers();
      Logging.d("MediaCodecVideoDecoder", "Decoder output buffers changed: " + this.outputBuffers.length);
      if (!this.hasDecodedFirstFrame)
        break;
      throw new RuntimeException("Unexpected output buffer change event.");
      MediaFormat localMediaFormat = this.mediaCodec.getOutputFormat();
      Logging.d("MediaCodecVideoDecoder", "Decoder format changed: " + localMediaFormat.toString());
      int j;
      if ((localMediaFormat.containsKey("crop-left")) && (localMediaFormat.containsKey("crop-right")) && (localMediaFormat.containsKey("crop-bottom")) && (localMediaFormat.containsKey("crop-top")))
        j = 1 + localMediaFormat.getInteger("crop-right") - localMediaFormat.getInteger("crop-left");
      for (int k = 1 + localMediaFormat.getInteger("crop-bottom") - localMediaFormat.getInteger("crop-top"); (this.hasDecodedFirstFrame) && ((j != this.width) || (k != this.height)); k = localMediaFormat.getInteger("height"))
      {
        throw new RuntimeException("Unexpected size change. Configured " + this.width + "*" + this.height + ". New " + j + "*" + k);
        j = localMediaFormat.getInteger("width");
      }
      this.width = j;
      this.height = k;
      if (this.textureListener != null)
        this.textureListener.setSize(this.width, this.height);
      if ((!useSurface()) && (localMediaFormat.containsKey("color-format")))
      {
        this.colorFormat = localMediaFormat.getInteger("color-format");
        Logging.d("MediaCodecVideoDecoder", "Color: 0x" + Integer.toHexString(this.colorFormat));
        if (!supportedColorList.contains(Integer.valueOf(this.colorFormat)))
          throw new IllegalStateException("Non supported color format: " + this.colorFormat);
      }
      if (localMediaFormat.containsKey("stride"))
        this.stride = localMediaFormat.getInteger("stride");
      if (localMediaFormat.containsKey("slice-height"))
        this.sliceHeight = localMediaFormat.getInteger("slice-height");
      Logging.d("MediaCodecVideoDecoder", "Frame stride and slice height: " + this.stride + " x " + this.sliceHeight);
      this.stride = Math.max(this.width, this.stride);
      this.sliceHeight = Math.max(this.height, this.sliceHeight);
      break;
      return null;
      l1 = l2;
    }
  }

  @Nullable
  @CalledByNativeUnchecked
  private DecodedTextureBuffer dequeueTextureBuffer(int paramInt)
  {
    checkOnMediaCodecThread();
    if (!useSurface())
      throw new IllegalStateException("dequeueTexture() called for byte buffer decoding.");
    DecodedOutputBuffer localDecodedOutputBuffer1 = dequeueOutputBuffer(paramInt);
    if (localDecodedOutputBuffer1 != null)
      this.dequeuedSurfaceOutputBuffers.add(localDecodedOutputBuffer1);
    MaybeRenderDecodedTextureBuffer();
    DecodedTextureBuffer localDecodedTextureBuffer1 = this.textureListener.dequeueTextureBuffer(paramInt);
    DecodedTextureBuffer localDecodedTextureBuffer2;
    if (localDecodedTextureBuffer1 != null)
    {
      MaybeRenderDecodedTextureBuffer();
      localDecodedTextureBuffer2 = localDecodedTextureBuffer1;
    }
    boolean bool;
    do
    {
      do
      {
        return localDecodedTextureBuffer2;
        if (this.dequeuedSurfaceOutputBuffers.size() >= Math.min(3, this.outputBuffers.length))
          break;
        localDecodedTextureBuffer2 = null;
      }
      while (paramInt <= 0);
      bool = this.dequeuedSurfaceOutputBuffers.isEmpty();
      localDecodedTextureBuffer2 = null;
    }
    while (bool);
    this.droppedFrames = (1 + this.droppedFrames);
    DecodedOutputBuffer localDecodedOutputBuffer2 = (DecodedOutputBuffer)this.dequeuedSurfaceOutputBuffers.remove();
    if (paramInt > 0)
      Logging.w("MediaCodecVideoDecoder", "Draining decoder. Dropping frame with TS: " + localDecodedOutputBuffer2.presentationTimeStampMs + ". Total number of dropped frames: " + this.droppedFrames);
    while (true)
    {
      this.mediaCodec.releaseOutputBuffer(localDecodedOutputBuffer2.index, false);
      return new DecodedTextureBuffer(null, localDecodedOutputBuffer2.presentationTimeStampMs, localDecodedOutputBuffer2.timeStampMs, localDecodedOutputBuffer2.ntpTimeStampMs, localDecodedOutputBuffer2.decodeTimeMs, SystemClock.elapsedRealtime() - localDecodedOutputBuffer2.endDecodeTimeMs);
      Logging.w("MediaCodecVideoDecoder", "Too many output buffers " + this.dequeuedSurfaceOutputBuffers.size() + ". Dropping frame with TS: " + localDecodedOutputBuffer2.presentationTimeStampMs + ". Total number of dropped frames: " + this.droppedFrames);
    }
  }

  public static void disableH264HwCodec()
  {
    Logging.w("MediaCodecVideoDecoder", "H.264 decoding is disabled by application.");
    hwDecoderDisabledTypes.add("video/avc");
  }

  public static void disableVp8HwCodec()
  {
    Logging.w("MediaCodecVideoDecoder", "VP8 decoding is disabled by application.");
    hwDecoderDisabledTypes.add("video/x-vnd.on2.vp8");
  }

  public static void disableVp9HwCodec()
  {
    Logging.w("MediaCodecVideoDecoder", "VP9 decoding is disabled by application.");
    hwDecoderDisabledTypes.add("video/x-vnd.on2.vp9");
  }

  public static void disposeEglContext()
  {
    if (eglBase != null)
    {
      eglBase.release();
      eglBase = null;
    }
  }

  @Nullable
  private static DecoderProperties findDecoder(String paramString, String[] paramArrayOfString)
  {
    if (Build.VERSION.SDK_INT < 19)
      return null;
    Logging.d("MediaCodecVideoDecoder", "Trying to find HW decoder for mime " + paramString);
    int i = 0;
    if (i < MediaCodecList.getCodecCount());
    label454: label460: 
    while (true)
    {
      MediaCodecInfo localMediaCodecInfo1;
      String[] arrayOfString;
      int j;
      int k;
      try
      {
        MediaCodecInfo localMediaCodecInfo2 = MediaCodecList.getCodecInfoAt(i);
        localMediaCodecInfo1 = localMediaCodecInfo2;
        if ((localMediaCodecInfo1 == null) || (localMediaCodecInfo1.isEncoder()))
          i++;
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        Logging.e("MediaCodecVideoDecoder", "Cannot retrieve decoder codec info", localIllegalArgumentException1);
        localMediaCodecInfo1 = null;
        continue;
        arrayOfString = localMediaCodecInfo1.getSupportedTypes();
        j = arrayOfString.length;
        k = 0;
      }
      if (k < j)
        if (!arrayOfString[k].equals(paramString));
      for (String str = localMediaCodecInfo1.getName(); ; str = null)
      {
        if (str == null)
          break label460;
        Logging.d("MediaCodecVideoDecoder", "Found candidate decoder " + str);
        int m = paramArrayOfString.length;
        int n = 0;
        if (n < m)
          if (!str.startsWith(paramArrayOfString[n]));
        for (int i1 = 1; ; i1 = 0)
        {
          MediaCodecInfo.CodecCapabilities localCodecCapabilities;
          while (true)
          {
            if (i1 == 0)
              break label454;
            try
            {
              localCodecCapabilities = localMediaCodecInfo1.getCapabilitiesForType(paramString);
              for (int i8 : localCodecCapabilities.colorFormats)
                Logging.v("MediaCodecVideoDecoder", "   Color: 0x" + Integer.toHexString(i8));
              k++;
              break;
              n++;
            }
            catch (IllegalArgumentException localIllegalArgumentException2)
            {
              Logging.e("MediaCodecVideoDecoder", "Cannot retrieve decoder capabilities", localIllegalArgumentException2);
            }
          }
          break;
          Iterator localIterator = supportedColorList.iterator();
          while (localIterator.hasNext())
          {
            int i4 = ((Integer)localIterator.next()).intValue();
            for (int i7 : localCodecCapabilities.colorFormats)
              if (i7 == i4)
              {
                Logging.d("MediaCodecVideoDecoder", "Found target decoder " + str + ". Color: 0x" + Integer.toHexString(i7));
                return new DecoderProperties(str, i7);
              }
          }
          Logging.d("MediaCodecVideoDecoder", "No HW decoder found for mime " + paramString);
          return null;
        }
        break;
      }
    }
  }

  @CalledByNativeUnchecked
  private boolean initDecode(VideoCodecType paramVideoCodecType, int paramInt1, int paramInt2)
  {
    if (this.mediaCodecThread != null)
      throw new RuntimeException("initDecode: Forgot to release()?");
    String str;
    String[] arrayOfString;
    if (paramVideoCodecType == VideoCodecType.VIDEO_CODEC_VP8)
    {
      str = "video/x-vnd.on2.vp8";
      arrayOfString = supportedVp8HwCodecPrefixes();
    }
    DecoderProperties localDecoderProperties;
    while (true)
    {
      localDecoderProperties = findDecoder(str, arrayOfString);
      if (localDecoderProperties != null)
        break label142;
      throw new RuntimeException("Cannot find HW decoder for " + paramVideoCodecType);
      if (paramVideoCodecType == VideoCodecType.VIDEO_CODEC_VP9)
      {
        str = "video/x-vnd.on2.vp9";
        arrayOfString = supportedVp9HwCodecPrefixes;
      }
      else
      {
        if (paramVideoCodecType != VideoCodecType.VIDEO_CODEC_H264)
          break;
        str = "video/avc";
        arrayOfString = supportedH264HwCodecPrefixes();
      }
    }
    throw new RuntimeException("initDecode: Non-supported codec " + paramVideoCodecType);
    label142: Logging.d("MediaCodecVideoDecoder", "Java initDecode: " + paramVideoCodecType + " : " + paramInt1 + " x " + paramInt2 + ". Color: 0x" + Integer.toHexString(localDecoderProperties.colorFormat) + ". Use Surface: " + useSurface());
    runningInstance = this;
    this.mediaCodecThread = Thread.currentThread();
    try
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.stride = paramInt1;
      this.sliceHeight = paramInt2;
      if (useSurface())
      {
        SurfaceTextureHelper localSurfaceTextureHelper = SurfaceTextureHelper.create("Decoder SurfaceTextureHelper", eglBase.getEglBaseContext());
        if (localSurfaceTextureHelper != null)
        {
          this.textureListener = new TextureListener(localSurfaceTextureHelper);
          this.textureListener.setSize(paramInt1, paramInt2);
          this.surface = new Surface(localSurfaceTextureHelper.getSurfaceTexture());
        }
      }
      MediaFormat localMediaFormat = MediaFormat.createVideoFormat(str, paramInt1, paramInt2);
      if (!useSurface())
        localMediaFormat.setInteger("color-format", localDecoderProperties.colorFormat);
      Logging.d("MediaCodecVideoDecoder", "  Format: " + localMediaFormat);
      this.mediaCodec = MediaCodecVideoEncoder.createByCodecName(localDecoderProperties.codecName);
      if (this.mediaCodec == null)
      {
        Logging.e("MediaCodecVideoDecoder", "Can not create media decoder");
        return false;
      }
      this.mediaCodec.configure(localMediaFormat, this.surface, null, 0);
      this.mediaCodec.start();
      this.colorFormat = localDecoderProperties.colorFormat;
      this.outputBuffers = this.mediaCodec.getOutputBuffers();
      this.inputBuffers = this.mediaCodec.getInputBuffers();
      this.decodeStartTimeMs.clear();
      this.hasDecodedFirstFrame = false;
      this.dequeuedSurfaceOutputBuffers.clear();
      this.droppedFrames = 0;
      Logging.d("MediaCodecVideoDecoder", "Input buffers: " + this.inputBuffers.length + ". Output buffers: " + this.outputBuffers.length);
      return true;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Logging.e("MediaCodecVideoDecoder", "initDecode failed", localIllegalStateException);
    }
    return false;
  }

  public static boolean isH264HighProfileHwSupported()
  {
    if (hwDecoderDisabledTypes.contains("video/avc"));
    do
      do
      {
        return false;
        if (Build.VERSION.SDK_INT >= 21)
          if (findDecoder("video/avc", new String[] { "OMX.qcom." }) != null)
            return true;
        if (Build.VERSION.SDK_INT >= 23)
          if (findDecoder("video/avc", new String[] { "OMX.Exynos." }) != null)
            return true;
      }
      while ((!PeerConnectionFactory.fieldTrialsFindFullName("WebRTC-MediaTekH264").equals("Enabled")) || (Build.VERSION.SDK_INT < 27));
    while (findDecoder("video/avc", new String[] { "OMX.MTK." }) == null);
    return true;
  }

  public static boolean isH264HwSupported()
  {
    return (!hwDecoderDisabledTypes.contains("video/avc")) && (findDecoder("video/avc", supportedH264HwCodecPrefixes()) != null);
  }

  public static boolean isVp8HwSupported()
  {
    return (!hwDecoderDisabledTypes.contains("video/x-vnd.on2.vp8")) && (findDecoder("video/x-vnd.on2.vp8", supportedVp8HwCodecPrefixes()) != null);
  }

  public static boolean isVp9HwSupported()
  {
    return (!hwDecoderDisabledTypes.contains("video/x-vnd.on2.vp9")) && (findDecoder("video/x-vnd.on2.vp9", supportedVp9HwCodecPrefixes) != null);
  }

  private static native long nativeCreateDecoder(String paramString, boolean paramBoolean);

  public static void printStackTrace()
  {
    if ((runningInstance != null) && (runningInstance.mediaCodecThread != null))
    {
      StackTraceElement[] arrayOfStackTraceElement = runningInstance.mediaCodecThread.getStackTrace();
      if (arrayOfStackTraceElement.length > 0)
      {
        Logging.d("MediaCodecVideoDecoder", "MediaCodecVideoDecoder stacks trace:");
        int i = arrayOfStackTraceElement.length;
        for (int j = 0; j < i; j++)
          Logging.d("MediaCodecVideoDecoder", arrayOfStackTraceElement[j].toString());
      }
    }
  }

  @CalledByNativeUnchecked
  private boolean queueInputBuffer(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3)
  {
    checkOnMediaCodecThread();
    try
    {
      this.inputBuffers[paramInt1].position(0);
      this.inputBuffers[paramInt1].limit(paramInt2);
      this.decodeStartTimeMs.add(new TimeStamps(SystemClock.elapsedRealtime(), paramLong2, paramLong3));
      this.mediaCodec.queueInputBuffer(paramInt1, 0, paramInt2, paramLong1, 0);
      return true;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Logging.e("MediaCodecVideoDecoder", "decode failed", localIllegalStateException);
    }
    return false;
  }

  @CalledByNativeUnchecked
  private void release()
  {
    Logging.d("MediaCodecVideoDecoder", "Java releaseDecoder. Total number of dropped frames: " + this.droppedFrames);
    checkOnMediaCodecThread();
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          Logging.d("MediaCodecVideoDecoder", "Java releaseDecoder on release thread");
          MediaCodecVideoDecoder.this.mediaCodec.stop();
          MediaCodecVideoDecoder.this.mediaCodec.release();
          Logging.d("MediaCodecVideoDecoder", "Java releaseDecoder on release thread done");
          localCountDownLatch.countDown();
          return;
        }
        catch (Exception localException)
        {
          while (true)
            Logging.e("MediaCodecVideoDecoder", "Media decoder release failed", localException);
        }
      }
    }).start();
    if (!ThreadUtils.awaitUninterruptibly(localCountDownLatch, 5000L))
    {
      Logging.e("MediaCodecVideoDecoder", "Media decoder release timeout");
      codecErrors = 1 + codecErrors;
      if (errorCallback != null)
      {
        Logging.e("MediaCodecVideoDecoder", "Invoke codec error callback. Errors: " + codecErrors);
        errorCallback.onMediaCodecVideoDecoderCriticalError(codecErrors);
      }
    }
    this.mediaCodec = null;
    this.mediaCodecThread = null;
    runningInstance = null;
    if (useSurface())
    {
      this.surface.release();
      this.surface = null;
      this.textureListener.release();
    }
    Logging.d("MediaCodecVideoDecoder", "Java releaseDecoder done");
  }

  @CalledByNativeUnchecked
  private void reset(int paramInt1, int paramInt2)
  {
    if ((this.mediaCodecThread == null) || (this.mediaCodec == null))
      throw new RuntimeException("Incorrect reset call for non-initialized decoder.");
    Logging.d("MediaCodecVideoDecoder", "Java reset: " + paramInt1 + " x " + paramInt2);
    this.mediaCodec.flush();
    this.width = paramInt1;
    this.height = paramInt2;
    if (this.textureListener != null)
      this.textureListener.setSize(paramInt1, paramInt2);
    this.decodeStartTimeMs.clear();
    this.dequeuedSurfaceOutputBuffers.clear();
    this.hasDecodedFirstFrame = false;
    this.droppedFrames = 0;
  }

  @CalledByNativeUnchecked
  private void returnDecodedOutputBuffer(int paramInt)
    throws IllegalStateException, MediaCodec.CodecException
  {
    checkOnMediaCodecThread();
    if (useSurface())
      throw new IllegalStateException("returnDecodedOutputBuffer() called for surface decoding.");
    this.mediaCodec.releaseOutputBuffer(paramInt, false);
  }

  public static void setEglContext(EglBase.Context paramContext)
  {
    if (eglBase != null)
    {
      Logging.w("MediaCodecVideoDecoder", "Egl context already set.");
      eglBase.release();
    }
    eglBase = EglBase..CC.create$$STATIC$$(paramContext);
  }

  public static void setErrorCallback(MediaCodecVideoDecoderErrorCallback paramMediaCodecVideoDecoderErrorCallback)
  {
    Logging.d("MediaCodecVideoDecoder", "Set error callback");
    errorCallback = paramMediaCodecVideoDecoderErrorCallback;
  }

  private static final String[] supportedH264HwCodecPrefixes()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("OMX.qcom.");
    localArrayList.add("OMX.Intel.");
    localArrayList.add("OMX.Exynos.");
    if ((PeerConnectionFactory.fieldTrialsFindFullName("WebRTC-MediaTekH264").equals("Enabled")) && (Build.VERSION.SDK_INT >= 27))
      localArrayList.add("OMX.MTK.");
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }

  private static final String[] supportedVp8HwCodecPrefixes()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("OMX.qcom.");
    localArrayList.add("OMX.Nvidia.");
    localArrayList.add("OMX.Exynos.");
    localArrayList.add("OMX.Intel.");
    if ((PeerConnectionFactory.fieldTrialsFindFullName("WebRTC-MediaTekVP8").equals("Enabled")) && (Build.VERSION.SDK_INT >= 24))
      localArrayList.add("OMX.MTK.");
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }

  static boolean useSurface()
  {
    return eglBase != null;
  }

  @CalledByNative
  int getColorFormat()
  {
    return this.colorFormat;
  }

  @CalledByNative
  int getHeight()
  {
    return this.height;
  }

  @CalledByNative
  ByteBuffer[] getInputBuffers()
  {
    return this.inputBuffers;
  }

  @CalledByNative
  ByteBuffer[] getOutputBuffers()
  {
    return this.outputBuffers;
  }

  @CalledByNative
  int getSliceHeight()
  {
    return this.sliceHeight;
  }

  @CalledByNative
  int getStride()
  {
    return this.stride;
  }

  @CalledByNative
  int getWidth()
  {
    return this.width;
  }

  private static class DecodedOutputBuffer
  {
    private final long decodeTimeMs;
    private final long endDecodeTimeMs;
    private final int index;
    private final long ntpTimeStampMs;
    private final int offset;
    private final long presentationTimeStampMs;
    private final int size;
    private final long timeStampMs;

    public DecodedOutputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
    {
      this.index = paramInt1;
      this.offset = paramInt2;
      this.size = paramInt3;
      this.presentationTimeStampMs = paramLong1;
      this.timeStampMs = paramLong2;
      this.ntpTimeStampMs = paramLong3;
      this.decodeTimeMs = paramLong4;
      this.endDecodeTimeMs = paramLong5;
    }

    @CalledByNative("DecodedOutputBuffer")
    long getDecodeTimeMs()
    {
      return this.decodeTimeMs;
    }

    @CalledByNative("DecodedOutputBuffer")
    int getIndex()
    {
      return this.index;
    }

    @CalledByNative("DecodedOutputBuffer")
    long getNtpTimestampMs()
    {
      return this.ntpTimeStampMs;
    }

    @CalledByNative("DecodedOutputBuffer")
    int getOffset()
    {
      return this.offset;
    }

    @CalledByNative("DecodedOutputBuffer")
    long getPresentationTimestampMs()
    {
      return this.presentationTimeStampMs;
    }

    @CalledByNative("DecodedOutputBuffer")
    int getSize()
    {
      return this.size;
    }

    @CalledByNative("DecodedOutputBuffer")
    long getTimestampMs()
    {
      return this.timeStampMs;
    }
  }

  private static class DecodedTextureBuffer
  {
    private final long decodeTimeMs;
    private final long frameDelayMs;
    private final long ntpTimeStampMs;
    private final long presentationTimeStampMs;
    private final long timeStampMs;
    private final VideoFrame.Buffer videoFrameBuffer;

    public DecodedTextureBuffer(VideoFrame.Buffer paramBuffer, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
    {
      this.videoFrameBuffer = paramBuffer;
      this.presentationTimeStampMs = paramLong1;
      this.timeStampMs = paramLong2;
      this.ntpTimeStampMs = paramLong3;
      this.decodeTimeMs = paramLong4;
      this.frameDelayMs = paramLong5;
    }

    @CalledByNative("DecodedTextureBuffer")
    long getDecodeTimeMs()
    {
      return this.decodeTimeMs;
    }

    @CalledByNative("DecodedTextureBuffer")
    long getFrameDelayMs()
    {
      return this.frameDelayMs;
    }

    @CalledByNative("DecodedTextureBuffer")
    long getNtpTimestampMs()
    {
      return this.ntpTimeStampMs;
    }

    @CalledByNative("DecodedTextureBuffer")
    long getPresentationTimestampMs()
    {
      return this.presentationTimeStampMs;
    }

    @CalledByNative("DecodedTextureBuffer")
    long getTimeStampMs()
    {
      return this.timeStampMs;
    }

    @CalledByNative("DecodedTextureBuffer")
    VideoFrame.Buffer getVideoFrameBuffer()
    {
      return this.videoFrameBuffer;
    }
  }

  private static class DecoderProperties
  {
    public final String codecName;
    public final int colorFormat;

    public DecoderProperties(String paramString, int paramInt)
    {
      this.codecName = paramString;
      this.colorFormat = paramInt;
    }
  }

  static class HwDecoderFactory
    implements VideoDecoderFactory
  {
    private final VideoCodecInfo[] supportedHardwareCodecs = getSupportedHardwareCodecs();

    private static VideoCodecInfo[] getSupportedHardwareCodecs()
    {
      ArrayList localArrayList = new ArrayList();
      if (MediaCodecVideoDecoder.isVp8HwSupported())
      {
        Logging.d("MediaCodecVideoDecoder", "VP8 HW Decoder supported.");
        localArrayList.add(new VideoCodecInfo("VP8", new HashMap()));
      }
      if (MediaCodecVideoDecoder.isVp9HwSupported())
      {
        Logging.d("MediaCodecVideoDecoder", "VP9 HW Decoder supported.");
        localArrayList.add(new VideoCodecInfo("VP9", new HashMap()));
      }
      if (MediaCodecVideoDecoder.isH264HighProfileHwSupported())
      {
        Logging.d("MediaCodecVideoDecoder", "H.264 High Profile HW Decoder supported.");
        localArrayList.add(H264Utils.DEFAULT_H264_HIGH_PROFILE_CODEC);
      }
      if (MediaCodecVideoDecoder.isH264HwSupported())
      {
        Logging.d("MediaCodecVideoDecoder", "H.264 HW Decoder supported.");
        localArrayList.add(H264Utils.DEFAULT_H264_BASELINE_PROFILE_CODEC);
      }
      return (VideoCodecInfo[])localArrayList.toArray(new VideoCodecInfo[localArrayList.size()]);
    }

    private static boolean isCodecSupported(VideoCodecInfo[] paramArrayOfVideoCodecInfo, VideoCodecInfo paramVideoCodecInfo)
    {
      int i = paramArrayOfVideoCodecInfo.length;
      for (int j = 0; ; j++)
      {
        boolean bool = false;
        if (j < i)
        {
          if (isSameCodec(paramArrayOfVideoCodecInfo[j], paramVideoCodecInfo))
            bool = true;
        }
        else
          return bool;
      }
    }

    private static boolean isSameCodec(VideoCodecInfo paramVideoCodecInfo1, VideoCodecInfo paramVideoCodecInfo2)
    {
      if (!paramVideoCodecInfo1.name.equalsIgnoreCase(paramVideoCodecInfo2.name))
        return false;
      if (paramVideoCodecInfo1.name.equalsIgnoreCase("H264"))
        return H264Utils.isSameH264Profile(paramVideoCodecInfo1.params, paramVideoCodecInfo2.params);
      return true;
    }

    public VideoDecoder createDecoder(String paramString)
    {
      return VideoDecoderFactory..CC.createDecoder(this, paramString);
    }

    @Nullable
    public VideoDecoder createDecoder(final VideoCodecInfo paramVideoCodecInfo)
    {
      if (!isCodecSupported(this.supportedHardwareCodecs, paramVideoCodecInfo))
      {
        Logging.d("MediaCodecVideoDecoder", "No HW video decoder for codec " + paramVideoCodecInfo.name);
        return null;
      }
      Logging.d("MediaCodecVideoDecoder", "Create HW video decoder for " + paramVideoCodecInfo.name);
      return new WrappedNativeVideoDecoder()
      {
        public long createNativeVideoDecoder()
        {
          return MediaCodecVideoDecoder.nativeCreateDecoder(paramVideoCodecInfo.name, MediaCodecVideoDecoder.useSurface());
        }
      };
    }

    public VideoCodecInfo[] getSupportedCodecs()
    {
      return this.supportedHardwareCodecs;
    }
  }

  public static abstract interface MediaCodecVideoDecoderErrorCallback
  {
    public abstract void onMediaCodecVideoDecoderCriticalError(int paramInt);
  }

  private class TextureListener
    implements VideoSink
  {

    @Nullable
    private MediaCodecVideoDecoder.DecodedOutputBuffer bufferToRender;
    private final Object newFrameLock = new Object();

    @Nullable
    private MediaCodecVideoDecoder.DecodedTextureBuffer renderedBuffer;
    private final SurfaceTextureHelper surfaceTextureHelper;

    public TextureListener(SurfaceTextureHelper arg2)
    {
      Object localObject;
      this.surfaceTextureHelper = localObject;
      localObject.startListening(this);
    }

    public void addBufferToRender(MediaCodecVideoDecoder.DecodedOutputBuffer paramDecodedOutputBuffer)
    {
      if (this.bufferToRender != null)
      {
        Logging.e("MediaCodecVideoDecoder", "Unexpected addBufferToRender() called while waiting for a texture.");
        throw new IllegalStateException("Waiting for a texture.");
      }
      this.bufferToRender = paramDecodedOutputBuffer;
    }

    @Nullable
    public MediaCodecVideoDecoder.DecodedTextureBuffer dequeueTextureBuffer(int paramInt)
    {
      synchronized (this.newFrameLock)
      {
        if ((this.renderedBuffer == null) && (paramInt > 0))
        {
          boolean bool = isWaitingForTexture();
          if (!bool);
        }
        try
        {
          this.newFrameLock.wait(paramInt);
          MediaCodecVideoDecoder.DecodedTextureBuffer localDecodedTextureBuffer = this.renderedBuffer;
          this.renderedBuffer = null;
          return localDecodedTextureBuffer;
        }
        catch (InterruptedException localInterruptedException)
        {
          while (true)
            Thread.currentThread().interrupt();
        }
      }
    }

    public boolean isWaitingForTexture()
    {
      while (true)
      {
        synchronized (this.newFrameLock)
        {
          if (this.bufferToRender != null)
          {
            bool = true;
            return bool;
          }
        }
        boolean bool = false;
      }
    }

    public void onFrame(VideoFrame paramVideoFrame)
    {
      synchronized (this.newFrameLock)
      {
        if (this.renderedBuffer != null)
        {
          Logging.e("MediaCodecVideoDecoder", "Unexpected onFrame() called while already holding a texture.");
          throw new IllegalStateException("Already holding a texture.");
        }
      }
      VideoFrame.Buffer localBuffer = paramVideoFrame.getBuffer();
      localBuffer.retain();
      this.renderedBuffer = new MediaCodecVideoDecoder.DecodedTextureBuffer(localBuffer, this.bufferToRender.presentationTimeStampMs, this.bufferToRender.timeStampMs, this.bufferToRender.ntpTimeStampMs, this.bufferToRender.decodeTimeMs, SystemClock.elapsedRealtime() - this.bufferToRender.endDecodeTimeMs);
      this.bufferToRender = null;
      this.newFrameLock.notifyAll();
    }

    public void release()
    {
      this.surfaceTextureHelper.stopListening();
      synchronized (this.newFrameLock)
      {
        if (this.renderedBuffer != null)
        {
          this.renderedBuffer.getVideoFrameBuffer().release();
          this.renderedBuffer = null;
        }
        this.surfaceTextureHelper.dispose();
        return;
      }
    }

    public void setSize(int paramInt1, int paramInt2)
    {
      this.surfaceTextureHelper.setTextureSize(paramInt1, paramInt2);
    }
  }

  private static class TimeStamps
  {
    private final long decodeStartTimeMs;
    private final long ntpTimeStampMs;
    private final long timeStampMs;

    public TimeStamps(long paramLong1, long paramLong2, long paramLong3)
    {
      this.decodeStartTimeMs = paramLong1;
      this.timeStampMs = paramLong2;
      this.ntpTimeStampMs = paramLong3;
    }
  }

  public static enum VideoCodecType
  {
    static
    {
      VIDEO_CODEC_H264 = new VideoCodecType("VIDEO_CODEC_H264", 3);
      VideoCodecType[] arrayOfVideoCodecType = new VideoCodecType[4];
      arrayOfVideoCodecType[0] = VIDEO_CODEC_UNKNOWN;
      arrayOfVideoCodecType[1] = VIDEO_CODEC_VP8;
      arrayOfVideoCodecType[2] = VIDEO_CODEC_VP9;
      arrayOfVideoCodecType[3] = VIDEO_CODEC_H264;
    }

    @CalledByNative("VideoCodecType")
    static VideoCodecType fromNativeIndex(int paramInt)
    {
      return values()[paramInt];
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.MediaCodecVideoDecoder
 * JD-Core Version:    0.6.2
 */