package org.webrtc;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@Deprecated
@TargetApi(19)
public class MediaCodecVideoEncoder
{
  private static final int BITRATE_ADJUSTMENT_FPS = 30;
  private static final double BITRATE_CORRECTION_MAX_SCALE = 4.0D;
  private static final double BITRATE_CORRECTION_SEC = 3.0D;
  private static final int BITRATE_CORRECTION_STEPS = 20;
  private static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
  private static final int DEQUEUE_TIMEOUT = 0;
  private static final String[] H264_HW_EXCEPTION_MODELS = { "SAMSUNG-SGH-I337", "Nexus 7", "Nexus 4" };
  private static final String H264_MIME_TYPE = "video/avc";
  private static final int MAXIMUM_INITIAL_FPS = 30;
  private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
  private static final long QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_L_MS = 15000L;
  private static final long QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_M_MS = 20000L;
  private static final long QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_N_MS = 15000L;
  private static final String TAG = "MediaCodecVideoEncoder";
  private static final int VIDEO_AVCLevel3 = 256;
  private static final int VIDEO_AVCProfileHigh = 8;
  private static final int VIDEO_ControlRateConstant = 2;
  private static final String VP8_MIME_TYPE = "video/x-vnd.on2.vp8";
  private static final String VP9_MIME_TYPE = "video/x-vnd.on2.vp9";
  private static int codecErrors;

  @Nullable
  private static MediaCodecVideoEncoderErrorCallback errorCallback;
  private static final MediaCodecProperties exynosH264HighProfileHwProperties;
  private static final MediaCodecProperties exynosH264HwProperties;
  private static final MediaCodecProperties exynosVp8HwProperties;
  private static final MediaCodecProperties exynosVp9HwProperties;
  private static final MediaCodecProperties[] h264HighProfileHwList;
  private static Set<String> hwEncoderDisabledTypes;
  private static final MediaCodecProperties intelVp8HwProperties;
  private static final MediaCodecProperties mediatekH264HwProperties;
  private static final MediaCodecProperties qcomH264HwProperties;
  private static final MediaCodecProperties qcomVp8HwProperties;
  private static final MediaCodecProperties qcomVp9HwProperties;

  @Nullable
  private static MediaCodecVideoEncoder runningInstance = null;

  @Nullable
  private static EglBase staticEglBase;
  private static final int[] supportedColorList = { 19, 21, 2141391872, 2141391876 };
  private static final int[] supportedSurfaceColorList = { 2130708361 };
  private static final MediaCodecProperties[] vp9HwList;
  private double bitrateAccumulator;
  private double bitrateAccumulatorMax;
  private int bitrateAdjustmentScaleExp;
  private BitrateAdjustmentType bitrateAdjustmentType = BitrateAdjustmentType.NO_ADJUSTMENT;
  private double bitrateObservationTimeMs;
  private int colorFormat;

  @Nullable
  private ByteBuffer configData = null;

  @Nullable
  private GlRectDrawer drawer;

  @Nullable
  private EglBase14 eglBase;
  private long forcedKeyFrameMs;
  private int height;

  @Nullable
  private Surface inputSurface;
  private long lastKeyFrameMs;

  @Nullable
  private MediaCodec mediaCodec;

  @Nullable
  private Thread mediaCodecThread;
  private ByteBuffer[] outputBuffers;
  private int profile;
  private int targetBitrateBps;
  private int targetFps;
  private VideoCodecType type;
  private int width;

  static
  {
    errorCallback = null;
    codecErrors = 0;
    hwEncoderDisabledTypes = new HashSet();
    qcomVp8HwProperties = new MediaCodecProperties("OMX.qcom.", 19, BitrateAdjustmentType.NO_ADJUSTMENT);
    exynosVp8HwProperties = new MediaCodecProperties("OMX.Exynos.", 23, BitrateAdjustmentType.DYNAMIC_ADJUSTMENT);
    intelVp8HwProperties = new MediaCodecProperties("OMX.Intel.", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
    qcomVp9HwProperties = new MediaCodecProperties("OMX.qcom.", 24, BitrateAdjustmentType.NO_ADJUSTMENT);
    exynosVp9HwProperties = new MediaCodecProperties("OMX.Exynos.", 24, BitrateAdjustmentType.FRAMERATE_ADJUSTMENT);
    MediaCodecProperties[] arrayOfMediaCodecProperties1 = new MediaCodecProperties[2];
    arrayOfMediaCodecProperties1[0] = qcomVp9HwProperties;
    arrayOfMediaCodecProperties1[1] = exynosVp9HwProperties;
    vp9HwList = arrayOfMediaCodecProperties1;
    qcomH264HwProperties = new MediaCodecProperties("OMX.qcom.", 19, BitrateAdjustmentType.NO_ADJUSTMENT);
    exynosH264HwProperties = new MediaCodecProperties("OMX.Exynos.", 21, BitrateAdjustmentType.FRAMERATE_ADJUSTMENT);
    mediatekH264HwProperties = new MediaCodecProperties("OMX.MTK.", 27, BitrateAdjustmentType.FRAMERATE_ADJUSTMENT);
    exynosH264HighProfileHwProperties = new MediaCodecProperties("OMX.Exynos.", 23, BitrateAdjustmentType.FRAMERATE_ADJUSTMENT);
    MediaCodecProperties[] arrayOfMediaCodecProperties2 = new MediaCodecProperties[1];
    arrayOfMediaCodecProperties2[0] = exynosH264HighProfileHwProperties;
    h264HighProfileHwList = arrayOfMediaCodecProperties2;
  }

  private void checkOnMediaCodecThread()
  {
    if (this.mediaCodecThread.getId() != Thread.currentThread().getId())
      throw new RuntimeException("MediaCodecVideoEncoder previously operated on " + this.mediaCodecThread + " but is now called on " + Thread.currentThread());
  }

  @Nullable
  static MediaCodec createByCodecName(String paramString)
  {
    try
    {
      MediaCodec localMediaCodec = MediaCodec.createByCodecName(paramString);
      return localMediaCodec;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static VideoEncoderFactory createFactory()
  {
    return new DefaultVideoEncoderFactory(new HwEncoderFactory());
  }

  public static void disableH264HwCodec()
  {
    Logging.w("MediaCodecVideoEncoder", "H.264 encoding is disabled by application.");
    hwEncoderDisabledTypes.add("video/avc");
  }

  public static void disableVp8HwCodec()
  {
    Logging.w("MediaCodecVideoEncoder", "VP8 encoding is disabled by application.");
    hwEncoderDisabledTypes.add("video/x-vnd.on2.vp8");
  }

  public static void disableVp9HwCodec()
  {
    Logging.w("MediaCodecVideoEncoder", "VP9 encoding is disabled by application.");
    hwEncoderDisabledTypes.add("video/x-vnd.on2.vp9");
  }

  public static void disposeEglContext()
  {
    if (staticEglBase != null)
    {
      staticEglBase.release();
      staticEglBase = null;
    }
  }

  @Nullable
  private static EncoderProperties findHwEncoder(String paramString, MediaCodecProperties[] paramArrayOfMediaCodecProperties, int[] paramArrayOfInt)
  {
    if (Build.VERSION.SDK_INT < 19)
      return null;
    if ((paramString.equals("video/avc")) && (Arrays.asList(H264_HW_EXCEPTION_MODELS).contains(Build.MODEL)))
    {
      Logging.w("MediaCodecVideoEncoder", "Model: " + Build.MODEL + " has black listed H.264 encoder.");
      return null;
    }
    int i = 0;
    if (i < MediaCodecList.getCodecCount());
    label605: label611: 
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
        if ((localMediaCodecInfo1 == null) || (!localMediaCodecInfo1.isEncoder()))
          i++;
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        Logging.e("MediaCodecVideoEncoder", "Cannot retrieve encoder codec info", localIllegalArgumentException1);
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
          break label611;
        Logging.v("MediaCodecVideoEncoder", "Found candidate encoder " + str);
        BitrateAdjustmentType localBitrateAdjustmentType1 = BitrateAdjustmentType.NO_ADJUSTMENT;
        int m = paramArrayOfMediaCodecProperties.length;
        int n = 0;
        BitrateAdjustmentType localBitrateAdjustmentType2;
        while (true)
          if (n < m)
          {
            MediaCodecProperties localMediaCodecProperties = paramArrayOfMediaCodecProperties[n];
            if (str.startsWith(localMediaCodecProperties.codecPrefix))
            {
              if (Build.VERSION.SDK_INT < localMediaCodecProperties.minSdk)
                Logging.w("MediaCodecVideoEncoder", "Codec " + str + " is disabled due to SDK version " + Build.VERSION.SDK_INT);
            }
            else
            {
              n++;
              continue;
              k++;
              break;
            }
            if (localMediaCodecProperties.bitrateAdjustmentType != BitrateAdjustmentType.NO_ADJUSTMENT)
            {
              localBitrateAdjustmentType1 = localMediaCodecProperties.bitrateAdjustmentType;
              Logging.w("MediaCodecVideoEncoder", "Codec " + str + " requires bitrate adjustment: " + localBitrateAdjustmentType1);
            }
            localBitrateAdjustmentType2 = localBitrateAdjustmentType1;
          }
        for (int i1 = 1; ; i1 = 0)
        {
          if (i1 == 0)
            break label605;
          MediaCodecInfo.CodecCapabilities localCodecCapabilities;
          try
          {
            localCodecCapabilities = localMediaCodecInfo1.getCapabilitiesForType(paramString);
            for (int i10 : localCodecCapabilities.colorFormats)
              Logging.v("MediaCodecVideoEncoder", "   Color: 0x" + Integer.toHexString(i10));
          }
          catch (IllegalArgumentException localIllegalArgumentException2)
          {
            Logging.e("MediaCodecVideoEncoder", "Cannot retrieve encoder capabilities", localIllegalArgumentException2);
          }
          break;
          int i4 = paramArrayOfInt.length;
          for (int i5 = 0; i5 < i4; i5++)
          {
            int i6 = paramArrayOfInt[i5];
            for (int i9 : localCodecCapabilities.colorFormats)
              if (i9 == i6)
              {
                Logging.d("MediaCodecVideoEncoder", "Found target encoder for mime " + paramString + " : " + str + ". Color: 0x" + Integer.toHexString(i9) + ". Bitrate adjustment: " + localBitrateAdjustmentType2);
                return new EncoderProperties(str, i9, localBitrateAdjustmentType2);
              }
          }
          break;
          return null;
          localBitrateAdjustmentType2 = localBitrateAdjustmentType1;
        }
        break;
      }
    }
  }

  private double getBitrateScale(int paramInt)
  {
    return Math.pow(4.0D, paramInt / 20.0D);
  }

  @Nullable
  static EglBase.Context getEglContext()
  {
    if (staticEglBase == null)
      return null;
    return staticEglBase.getEglBaseContext();
  }

  private static final MediaCodecProperties[] h264HwList()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(qcomH264HwProperties);
    localArrayList.add(exynosH264HwProperties);
    if (PeerConnectionFactory.fieldTrialsFindFullName("WebRTC-MediaTekH264").equals("Enabled"))
      localArrayList.add(mediatekH264HwProperties);
    return (MediaCodecProperties[])localArrayList.toArray(new MediaCodecProperties[localArrayList.size()]);
  }

  public static boolean isH264HighProfileHwSupported()
  {
    return (!hwEncoderDisabledTypes.contains("video/avc")) && (findHwEncoder("video/avc", h264HighProfileHwList, supportedColorList) != null);
  }

  public static boolean isH264HwSupported()
  {
    return (!hwEncoderDisabledTypes.contains("video/avc")) && (findHwEncoder("video/avc", h264HwList(), supportedColorList) != null);
  }

  public static boolean isH264HwSupportedUsingTextures()
  {
    return (!hwEncoderDisabledTypes.contains("video/avc")) && (findHwEncoder("video/avc", h264HwList(), supportedSurfaceColorList) != null);
  }

  @CalledByNative
  static boolean isTextureBuffer(VideoFrame.Buffer paramBuffer)
  {
    return paramBuffer instanceof VideoFrame.TextureBuffer;
  }

  public static boolean isVp8HwSupported()
  {
    return (!hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp8")) && (findHwEncoder("video/x-vnd.on2.vp8", vp8HwList(), supportedColorList) != null);
  }

  public static boolean isVp8HwSupportedUsingTextures()
  {
    return (!hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp8")) && (findHwEncoder("video/x-vnd.on2.vp8", vp8HwList(), supportedSurfaceColorList) != null);
  }

  public static boolean isVp9HwSupported()
  {
    return (!hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp9")) && (findHwEncoder("video/x-vnd.on2.vp9", vp9HwList, supportedColorList) != null);
  }

  public static boolean isVp9HwSupportedUsingTextures()
  {
    return (!hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp9")) && (findHwEncoder("video/x-vnd.on2.vp9", vp9HwList, supportedSurfaceColorList) != null);
  }

  private static native long nativeCreateEncoder(VideoCodecInfo paramVideoCodecInfo, boolean paramBoolean);

  private static native void nativeFillInputBuffer(long paramLong, int paramInt1, ByteBuffer paramByteBuffer1, int paramInt2, ByteBuffer paramByteBuffer2, int paramInt3, ByteBuffer paramByteBuffer3, int paramInt4);

  public static void printStackTrace()
  {
    if ((runningInstance != null) && (runningInstance.mediaCodecThread != null))
    {
      StackTraceElement[] arrayOfStackTraceElement = runningInstance.mediaCodecThread.getStackTrace();
      if (arrayOfStackTraceElement.length > 0)
      {
        Logging.d("MediaCodecVideoEncoder", "MediaCodecVideoEncoder stacks trace:");
        int i = arrayOfStackTraceElement.length;
        for (int j = 0; j < i; j++)
          Logging.d("MediaCodecVideoEncoder", arrayOfStackTraceElement[j].toString());
      }
    }
  }

  private void reportEncodedFrame(int paramInt)
  {
    int i = 1;
    if ((this.targetFps == 0) || (this.bitrateAdjustmentType != BitrateAdjustmentType.DYNAMIC_ADJUSTMENT));
    do
    {
      return;
      double d1 = this.targetBitrateBps / (8.0D * this.targetFps);
      this.bitrateAccumulator += paramInt - d1;
      this.bitrateObservationTimeMs += 1000.0D / this.targetFps;
      double d2 = 3.0D * this.bitrateAccumulatorMax;
      this.bitrateAccumulator = Math.min(this.bitrateAccumulator, d2);
      this.bitrateAccumulator = Math.max(this.bitrateAccumulator, -d2);
    }
    while (this.bitrateObservationTimeMs <= 3000.0D);
    Logging.d("MediaCodecVideoEncoder", "Acc: " + (int)this.bitrateAccumulator + ". Max: " + (int)this.bitrateAccumulatorMax + ". ExpScale: " + this.bitrateAdjustmentScaleExp);
    if (this.bitrateAccumulator > this.bitrateAccumulatorMax)
    {
      int j = (int)(0.5D + this.bitrateAccumulator / this.bitrateAccumulatorMax);
      this.bitrateAdjustmentScaleExp -= j;
      this.bitrateAccumulator = this.bitrateAccumulatorMax;
    }
    while (true)
    {
      if (i != 0)
      {
        this.bitrateAdjustmentScaleExp = Math.min(this.bitrateAdjustmentScaleExp, 20);
        this.bitrateAdjustmentScaleExp = Math.max(this.bitrateAdjustmentScaleExp, -20);
        Logging.d("MediaCodecVideoEncoder", "Adjusting bitrate scale to " + this.bitrateAdjustmentScaleExp + ". Value: " + getBitrateScale(this.bitrateAdjustmentScaleExp));
        setRates(this.targetBitrateBps / 1000, this.targetFps);
      }
      this.bitrateObservationTimeMs = 0.0D;
      return;
      if (this.bitrateAccumulator < -this.bitrateAccumulatorMax)
      {
        this.bitrateAdjustmentScaleExp = ((int)(0.5D + -this.bitrateAccumulator / this.bitrateAccumulatorMax) + this.bitrateAdjustmentScaleExp);
        this.bitrateAccumulator = (-this.bitrateAccumulatorMax);
      }
      else
      {
        i = 0;
      }
    }
  }

  public static void setEglContext(EglBase.Context paramContext)
  {
    if (staticEglBase != null)
    {
      Logging.w("MediaCodecVideoEncoder", "Egl context already set.");
      staticEglBase.release();
    }
    staticEglBase = EglBase..CC.create$$STATIC$$(paramContext);
  }

  public static void setErrorCallback(MediaCodecVideoEncoderErrorCallback paramMediaCodecVideoEncoderErrorCallback)
  {
    Logging.d("MediaCodecVideoEncoder", "Set error callback");
    errorCallback = paramMediaCodecVideoEncoderErrorCallback;
  }

  @CalledByNativeUnchecked
  private boolean setRates(int paramInt1, int paramInt2)
  {
    checkOnMediaCodecThread();
    int i = paramInt1 * 1000;
    if (this.bitrateAdjustmentType == BitrateAdjustmentType.DYNAMIC_ADJUSTMENT)
    {
      this.bitrateAccumulatorMax = (i / 8.0D);
      if ((this.targetBitrateBps > 0) && (i < this.targetBitrateBps))
        this.bitrateAccumulator = (this.bitrateAccumulator * i / this.targetBitrateBps);
    }
    this.targetBitrateBps = i;
    this.targetFps = paramInt2;
    if ((this.bitrateAdjustmentType == BitrateAdjustmentType.FRAMERATE_ADJUSTMENT) && (this.targetFps > 0))
    {
      i = 30 * this.targetBitrateBps / this.targetFps;
      Logging.v("MediaCodecVideoEncoder", "setRates: " + paramInt1 + " -> " + i / 1000 + " kbps. Fps: " + this.targetFps);
    }
    try
    {
      while (true)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("video-bitrate", i);
        this.mediaCodec.setParameters(localBundle);
        return true;
        if (this.bitrateAdjustmentType == BitrateAdjustmentType.DYNAMIC_ADJUSTMENT)
        {
          Logging.v("MediaCodecVideoEncoder", "setRates: " + paramInt1 + " kbps. Fps: " + this.targetFps + ". ExpScale: " + this.bitrateAdjustmentScaleExp);
          if (this.bitrateAdjustmentScaleExp != 0)
            i = (int)(i * getBitrateScale(this.bitrateAdjustmentScaleExp));
        }
        else
        {
          Logging.v("MediaCodecVideoEncoder", "setRates: " + paramInt1 + " kbps. Fps: " + this.targetFps);
        }
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Logging.e("MediaCodecVideoEncoder", "setRates failed", localIllegalStateException);
    }
    return false;
  }

  @Nullable
  public static EncoderProperties vp8HwEncoderProperties()
  {
    if (hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp8"))
      return null;
    return findHwEncoder("video/x-vnd.on2.vp8", vp8HwList(), supportedColorList);
  }

  private static MediaCodecProperties[] vp8HwList()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(qcomVp8HwProperties);
    localArrayList.add(exynosVp8HwProperties);
    if (PeerConnectionFactory.fieldTrialsFindFullName("WebRTC-IntelVP8").equals("Enabled"))
      localArrayList.add(intelVp8HwProperties);
    return (MediaCodecProperties[])localArrayList.toArray(new MediaCodecProperties[localArrayList.size()]);
  }

  void checkKeyFrameRequired(boolean paramBoolean, long paramLong)
  {
    long l = (500L + paramLong) / 1000L;
    if (this.lastKeyFrameMs < 0L)
      this.lastKeyFrameMs = l;
    if ((!paramBoolean) && (this.forcedKeyFrameMs > 0L) && (l > this.lastKeyFrameMs + this.forcedKeyFrameMs));
    for (int i = 1; ; i = 0)
    {
      if ((paramBoolean) || (i != 0))
      {
        if (!paramBoolean)
          break label112;
        Logging.d("MediaCodecVideoEncoder", "Sync frame request");
      }
      while (true)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("request-sync", 0);
        this.mediaCodec.setParameters(localBundle);
        this.lastKeyFrameMs = l;
        return;
        label112: Logging.d("MediaCodecVideoEncoder", "Sync frame forced");
      }
    }
  }

  @CalledByNativeUnchecked
  int dequeueInputBuffer()
  {
    checkOnMediaCodecThread();
    try
    {
      int i = this.mediaCodec.dequeueInputBuffer(0L);
      return i;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Logging.e("MediaCodecVideoEncoder", "dequeueIntputBuffer failed", localIllegalStateException);
    }
    return -2;
  }

  @Nullable
  @CalledByNativeUnchecked
  OutputBufferInfo dequeueOutputBuffer()
  {
    boolean bool1 = true;
    checkOnMediaCodecThread();
    int i;
    boolean bool2;
    int k;
    try
    {
      MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
      i = this.mediaCodec.dequeueOutputBuffer(localBufferInfo, 0L);
      if (i >= 0)
      {
        if ((0x2 & localBufferInfo.flags) == 0)
          break label576;
        bool2 = bool1;
        if (bool2)
        {
          Logging.d("MediaCodecVideoEncoder", "Config frame generated. Offset: " + localBufferInfo.offset + ". Size: " + localBufferInfo.size);
          this.configData = ByteBuffer.allocateDirect(localBufferInfo.size);
          this.outputBuffers[i].position(localBufferInfo.offset);
          this.outputBuffers[i].limit(localBufferInfo.offset + localBufferInfo.size);
          this.configData.put(this.outputBuffers[i]);
          int j = 0;
          String str = "";
          while (true)
          {
            if (localBufferInfo.size >= 8)
              break label582;
            k = localBufferInfo.size;
            label172: if (j >= k)
              break;
            str = str + Integer.toHexString(0xFF & this.configData.get(j)) + " ";
            j++;
          }
          Logging.d("MediaCodecVideoEncoder", str);
          this.mediaCodec.releaseOutputBuffer(i, false);
          i = this.mediaCodec.dequeueOutputBuffer(localBufferInfo, 0L);
        }
      }
      if (i >= 0)
      {
        ByteBuffer localByteBuffer1 = this.outputBuffers[i].duplicate();
        localByteBuffer1.position(localBufferInfo.offset);
        localByteBuffer1.limit(localBufferInfo.offset + localBufferInfo.size);
        reportEncodedFrame(localBufferInfo.size);
        if ((0x1 & localBufferInfo.flags) == 0)
          break label589;
        label314: if (bool1)
          Logging.d("MediaCodecVideoEncoder", "Sync frame generated");
        if ((bool1) && (this.type == VideoCodecType.VIDEO_CODEC_H264))
        {
          Logging.d("MediaCodecVideoEncoder", "Appending config frame of size " + this.configData.capacity() + " to output buffer with offset " + localBufferInfo.offset + ", size " + localBufferInfo.size);
          ByteBuffer localByteBuffer2 = ByteBuffer.allocateDirect(this.configData.capacity() + localBufferInfo.size);
          this.configData.rewind();
          localByteBuffer2.put(this.configData);
          localByteBuffer2.put(localByteBuffer1);
          localByteBuffer2.position(0);
          return new OutputBufferInfo(i, localByteBuffer2, bool1, localBufferInfo.presentationTimeUs);
        }
        OutputBufferInfo localOutputBufferInfo = new OutputBufferInfo(i, localByteBuffer1.slice(), bool1, localBufferInfo.presentationTimeUs);
        return localOutputBufferInfo;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Logging.e("MediaCodecVideoEncoder", "dequeueOutputBuffer failed", localIllegalStateException);
      return new OutputBufferInfo(-1, null, false, -1L);
    }
    if (i == -3)
    {
      this.outputBuffers = this.mediaCodec.getOutputBuffers();
      return dequeueOutputBuffer();
    }
    if (i == -2)
      return dequeueOutputBuffer();
    label576: label582: label589: 
    while (i != -1)
    {
      throw new RuntimeException("dequeueOutputBuffer: " + i);
      bool2 = false;
      break;
      k = 8;
      break label172;
      bool1 = false;
      break label314;
    }
    return null;
  }

  @CalledByNativeUnchecked
  boolean encodeBuffer(boolean paramBoolean, int paramInt1, int paramInt2, long paramLong)
  {
    checkOnMediaCodecThread();
    try
    {
      checkKeyFrameRequired(paramBoolean, paramLong);
      this.mediaCodec.queueInputBuffer(paramInt1, 0, paramInt2, paramLong, 0);
      return true;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Logging.e("MediaCodecVideoEncoder", "encodeBuffer failed", localIllegalStateException);
    }
    return false;
  }

  @CalledByNativeUnchecked
  boolean encodeFrame(long paramLong1, boolean paramBoolean, VideoFrame paramVideoFrame, int paramInt, long paramLong2)
  {
    checkOnMediaCodecThread();
    VideoFrame.I420Buffer localI420Buffer;
    int i;
    ByteBuffer localByteBuffer1;
    ByteBuffer localByteBuffer2;
    ByteBuffer localByteBuffer3;
    int j;
    int k;
    int m;
    try
    {
      checkKeyFrameRequired(paramBoolean, paramLong2);
      VideoFrame.Buffer localBuffer = paramVideoFrame.getBuffer();
      if ((localBuffer instanceof VideoFrame.TextureBuffer))
      {
        VideoFrame.TextureBuffer localTextureBuffer = (VideoFrame.TextureBuffer)localBuffer;
        this.eglBase.makeCurrent();
        GLES20.glClear(16384);
        VideoFrameDrawer.drawTexture(this.drawer, localTextureBuffer, new Matrix(), this.width, this.height, 0, 0, this.width, this.height);
        this.eglBase.swapBuffers(TimeUnit.MICROSECONDS.toNanos(paramLong2));
        break label314;
      }
      localI420Buffer = localBuffer.toI420();
      i = (1 + this.height) / 2;
      localByteBuffer1 = localI420Buffer.getDataY();
      localByteBuffer2 = localI420Buffer.getDataU();
      localByteBuffer3 = localI420Buffer.getDataV();
      j = localI420Buffer.getStrideY();
      k = localI420Buffer.getStrideU();
      m = localI420Buffer.getStrideV();
      if (localByteBuffer1.capacity() < j * this.height)
        throw new RuntimeException("Y-plane buffer size too small.");
    }
    catch (RuntimeException localRuntimeException)
    {
      Logging.e("MediaCodecVideoEncoder", "encodeFrame failed", localRuntimeException);
      return false;
    }
    if (localByteBuffer2.capacity() < k * i)
      throw new RuntimeException("U-plane buffer size too small.");
    if (localByteBuffer3.capacity() < i * m)
      throw new RuntimeException("V-plane buffer size too small.");
    nativeFillInputBuffer(paramLong1, paramInt, localByteBuffer1, j, localByteBuffer2, k, localByteBuffer3, m);
    localI420Buffer.release();
    int n = 3 * (this.width * this.height) / 2;
    this.mediaCodec.queueInputBuffer(paramInt, 0, n, paramLong2, 0);
    label314: return true;
  }

  @CalledByNative
  int getColorFormat()
  {
    return this.colorFormat;
  }

  @CalledByNativeUnchecked
  ByteBuffer[] getInputBuffers()
  {
    ByteBuffer[] arrayOfByteBuffer = this.mediaCodec.getInputBuffers();
    Logging.d("MediaCodecVideoEncoder", "Input buffers: " + arrayOfByteBuffer.length);
    return arrayOfByteBuffer;
  }

  @CalledByNativeUnchecked
  boolean initEncode(VideoCodecType paramVideoCodecType, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    Logging.d("MediaCodecVideoEncoder", "Java initEncode: " + paramVideoCodecType + ". Profile: " + paramInt1 + " : " + paramInt2 + " x " + paramInt3 + ". @ " + paramInt4 + " kbps. Fps: " + paramInt5 + ". Encode from texture : " + paramBoolean);
    this.profile = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    if (this.mediaCodecThread != null)
      throw new RuntimeException("Forgot to release()?");
    int i = 0;
    Object localObject;
    String str;
    int k;
    if (paramVideoCodecType == VideoCodecType.VIDEO_CODEC_VP8)
    {
      MediaCodecProperties[] arrayOfMediaCodecProperties4 = vp8HwList();
      if (paramBoolean);
      for (int[] arrayOfInt4 = supportedSurfaceColorList; ; arrayOfInt4 = supportedColorList)
      {
        localObject = findHwEncoder("video/x-vnd.on2.vp8", arrayOfMediaCodecProperties4, arrayOfInt4);
        str = "video/x-vnd.on2.vp8";
        k = 100;
        if (localObject != null)
          break;
        throw new RuntimeException("Can not find HW encoder for " + paramVideoCodecType);
      }
    }
    if (paramVideoCodecType == VideoCodecType.VIDEO_CODEC_VP9)
    {
      MediaCodecProperties[] arrayOfMediaCodecProperties3 = vp9HwList;
      if (paramBoolean);
      for (int[] arrayOfInt3 = supportedSurfaceColorList; ; arrayOfInt3 = supportedColorList)
      {
        localObject = findHwEncoder("video/x-vnd.on2.vp9", arrayOfMediaCodecProperties3, arrayOfInt3);
        str = "video/x-vnd.on2.vp9";
        k = 100;
        i = 0;
        break;
      }
    }
    if (paramVideoCodecType == VideoCodecType.VIDEO_CODEC_H264)
    {
      MediaCodecProperties[] arrayOfMediaCodecProperties1 = h264HwList();
      int[] arrayOfInt1;
      label285: EncoderProperties localEncoderProperties;
      int[] arrayOfInt2;
      if (paramBoolean)
      {
        arrayOfInt1 = supportedSurfaceColorList;
        localEncoderProperties = findHwEncoder("video/avc", arrayOfMediaCodecProperties1, arrayOfInt1);
        if (paramInt1 != H264Profile.CONSTRAINED_HIGH.getValue())
          break label387;
        MediaCodecProperties[] arrayOfMediaCodecProperties2 = h264HighProfileHwList;
        if (!paramBoolean)
          break label371;
        arrayOfInt2 = supportedSurfaceColorList;
        label321: if (findHwEncoder("video/avc", arrayOfMediaCodecProperties2, arrayOfInt2) == null)
          break label379;
        Logging.d("MediaCodecVideoEncoder", "High profile H.264 encoder supported.");
      }
      label387: for (int j = 1; ; j = 0)
      {
        localObject = localEncoderProperties;
        str = "video/avc";
        k = 20;
        i = j;
        break;
        arrayOfInt1 = supportedColorList;
        break label285;
        label371: arrayOfInt2 = supportedColorList;
        break label321;
        label379: Logging.d("MediaCodecVideoEncoder", "High profile H.264 encoder requested, but not supported. Use baseline.");
      }
    }
    throw new RuntimeException("initEncode: Non-supported codec " + paramVideoCodecType);
    runningInstance = this;
    this.colorFormat = ((EncoderProperties)localObject).colorFormat;
    this.bitrateAdjustmentType = ((EncoderProperties)localObject).bitrateAdjustmentType;
    int m;
    if (this.bitrateAdjustmentType == BitrateAdjustmentType.FRAMERATE_ADJUSTMENT)
      m = 30;
    while (true)
    {
      this.forcedKeyFrameMs = 0L;
      this.lastKeyFrameMs = -1L;
      if ((paramVideoCodecType == VideoCodecType.VIDEO_CODEC_VP8) && (((EncoderProperties)localObject).codecName.startsWith(qcomVp8HwProperties.codecPrefix)))
      {
        if ((Build.VERSION.SDK_INT == 21) || (Build.VERSION.SDK_INT == 22))
          this.forcedKeyFrameMs = 15000L;
      }
      else
      {
        label516: Logging.d("MediaCodecVideoEncoder", "Color format: " + this.colorFormat + ". Bitrate adjustment: " + this.bitrateAdjustmentType + ". Key frame interval: " + this.forcedKeyFrameMs + " . Initial fps: " + m);
        this.targetBitrateBps = (paramInt4 * 1000);
        this.targetFps = m;
        this.bitrateAccumulatorMax = (this.targetBitrateBps / 8.0D);
        this.bitrateAccumulator = 0.0D;
        this.bitrateObservationTimeMs = 0.0D;
        this.bitrateAdjustmentScaleExp = 0;
        this.mediaCodecThread = Thread.currentThread();
      }
      try
      {
        MediaFormat localMediaFormat = MediaFormat.createVideoFormat(str, paramInt2, paramInt3);
        localMediaFormat.setInteger("bitrate", this.targetBitrateBps);
        localMediaFormat.setInteger("bitrate-mode", 2);
        localMediaFormat.setInteger("color-format", ((EncoderProperties)localObject).colorFormat);
        localMediaFormat.setInteger("frame-rate", this.targetFps);
        localMediaFormat.setInteger("i-frame-interval", k);
        if (i != 0)
        {
          localMediaFormat.setInteger("profile", 8);
          localMediaFormat.setInteger("level", 256);
        }
        Logging.d("MediaCodecVideoEncoder", "  Format: " + localMediaFormat);
        this.mediaCodec = createByCodecName(((EncoderProperties)localObject).codecName);
        this.type = paramVideoCodecType;
        if (this.mediaCodec == null)
        {
          Logging.e("MediaCodecVideoEncoder", "Can not create media encoder");
          release();
          return false;
          m = Math.min(paramInt5, 30);
          continue;
          if (Build.VERSION.SDK_INT == 23)
          {
            this.forcedKeyFrameMs = 20000L;
            break label516;
          }
          if (Build.VERSION.SDK_INT <= 23)
            break label516;
          this.forcedKeyFrameMs = 15000L;
          break label516;
        }
        else
        {
          this.mediaCodec.configure(localMediaFormat, null, null, 1);
          if (paramBoolean)
          {
            this.eglBase = new EglBase14((EglBase14.Context)getEglContext(), EglBase.CONFIG_RECORDABLE);
            this.inputSurface = this.mediaCodec.createInputSurface();
            this.eglBase.createSurface(this.inputSurface);
            this.drawer = new GlRectDrawer();
          }
          this.mediaCodec.start();
          this.outputBuffers = this.mediaCodec.getOutputBuffers();
          Logging.d("MediaCodecVideoEncoder", "Output buffers: " + this.outputBuffers.length);
          return true;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Logging.e("MediaCodecVideoEncoder", "initEncode failed", localIllegalStateException);
        release();
      }
    }
    return false;
  }

  @CalledByNativeUnchecked
  void release()
  {
    int i = 1;
    Logging.d("MediaCodecVideoEncoder", "Java releaseEncoder");
    checkOnMediaCodecThread();
    final Object local1CaughtException = new Object()
    {
      Exception e;
    };
    if (this.mediaCodec != null)
    {
      final CountDownLatch localCountDownLatch = new CountDownLatch(i);
      new Thread(new Runnable()
      {
        public void run()
        {
          Logging.d("MediaCodecVideoEncoder", "Java releaseEncoder on release thread");
          try
          {
            MediaCodecVideoEncoder.this.mediaCodec.stop();
          }
          catch (Exception localException1)
          {
            try
            {
              while (true)
              {
                MediaCodecVideoEncoder.this.mediaCodec.release();
                Logging.d("MediaCodecVideoEncoder", "Java releaseEncoder on release thread done");
                localCountDownLatch.countDown();
                return;
                localException1 = localException1;
                Logging.e("MediaCodecVideoEncoder", "Media encoder stop failed", localException1);
              }
            }
            catch (Exception localException2)
            {
              while (true)
              {
                Logging.e("MediaCodecVideoEncoder", "Media encoder release failed", localException2);
                local1CaughtException.e = localException2;
              }
            }
          }
        }
      }).start();
      if (!ThreadUtils.awaitUninterruptibly(localCountDownLatch, 5000L))
      {
        Logging.e("MediaCodecVideoEncoder", "Media encoder release timeout");
        this.mediaCodec = null;
      }
    }
    while (true)
    {
      this.mediaCodecThread = null;
      if (this.drawer != null)
      {
        this.drawer.release();
        this.drawer = null;
      }
      if (this.eglBase != null)
      {
        this.eglBase.release();
        this.eglBase = null;
      }
      if (this.inputSurface != null)
      {
        this.inputSurface.release();
        this.inputSurface = null;
      }
      runningInstance = null;
      if (i != 0)
      {
        codecErrors = 1 + codecErrors;
        if (errorCallback != null)
        {
          Logging.e("MediaCodecVideoEncoder", "Invoke codec error callback. Errors: " + codecErrors);
          errorCallback.onMediaCodecVideoEncoderCriticalError(codecErrors);
        }
        throw new RuntimeException("Media encoder release timeout.");
      }
      if (local1CaughtException.e != null)
      {
        RuntimeException localRuntimeException = new RuntimeException(local1CaughtException.e);
        localRuntimeException.setStackTrace(ThreadUtils.concatStackTraces(local1CaughtException.e.getStackTrace(), localRuntimeException.getStackTrace()));
        throw localRuntimeException;
      }
      Logging.d("MediaCodecVideoEncoder", "Java releaseEncoder done");
      return;
      i = 0;
      break;
      i = 0;
    }
  }

  @CalledByNativeUnchecked
  boolean releaseOutputBuffer(int paramInt)
  {
    checkOnMediaCodecThread();
    try
    {
      this.mediaCodec.releaseOutputBuffer(paramInt, false);
      return true;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Logging.e("MediaCodecVideoEncoder", "releaseOutputBuffer failed", localIllegalStateException);
    }
    return false;
  }

  public static enum BitrateAdjustmentType
  {
    static
    {
      FRAMERATE_ADJUSTMENT = new BitrateAdjustmentType("FRAMERATE_ADJUSTMENT", 1);
      DYNAMIC_ADJUSTMENT = new BitrateAdjustmentType("DYNAMIC_ADJUSTMENT", 2);
      BitrateAdjustmentType[] arrayOfBitrateAdjustmentType = new BitrateAdjustmentType[3];
      arrayOfBitrateAdjustmentType[0] = NO_ADJUSTMENT;
      arrayOfBitrateAdjustmentType[1] = FRAMERATE_ADJUSTMENT;
      arrayOfBitrateAdjustmentType[2] = DYNAMIC_ADJUSTMENT;
    }
  }

  public static class EncoderProperties
  {
    public final MediaCodecVideoEncoder.BitrateAdjustmentType bitrateAdjustmentType;
    public final String codecName;
    public final int colorFormat;

    public EncoderProperties(String paramString, int paramInt, MediaCodecVideoEncoder.BitrateAdjustmentType paramBitrateAdjustmentType)
    {
      this.codecName = paramString;
      this.colorFormat = paramInt;
      this.bitrateAdjustmentType = paramBitrateAdjustmentType;
    }
  }

  public static enum H264Profile
  {
    private final int value;

    static
    {
      BASELINE = new H264Profile("BASELINE", 1, 1);
      MAIN = new H264Profile("MAIN", 2, 2);
      CONSTRAINED_HIGH = new H264Profile("CONSTRAINED_HIGH", 3, 3);
      HIGH = new H264Profile("HIGH", 4, 4);
      H264Profile[] arrayOfH264Profile = new H264Profile[5];
      arrayOfH264Profile[0] = CONSTRAINED_BASELINE;
      arrayOfH264Profile[1] = BASELINE;
      arrayOfH264Profile[2] = MAIN;
      arrayOfH264Profile[3] = CONSTRAINED_HIGH;
      arrayOfH264Profile[4] = HIGH;
    }

    private H264Profile(int paramInt)
    {
      this.value = paramInt;
    }

    public int getValue()
    {
      return this.value;
    }
  }

  static class HwEncoderFactory
    implements VideoEncoderFactory
  {
    private final VideoCodecInfo[] supportedHardwareCodecs = getSupportedHardwareCodecs();

    private static VideoCodecInfo[] getSupportedHardwareCodecs()
    {
      ArrayList localArrayList = new ArrayList();
      if (MediaCodecVideoEncoder.isVp8HwSupported())
      {
        Logging.d("MediaCodecVideoEncoder", "VP8 HW Encoder supported.");
        localArrayList.add(new VideoCodecInfo("VP8", new HashMap()));
      }
      if (MediaCodecVideoEncoder.isVp9HwSupported())
      {
        Logging.d("MediaCodecVideoEncoder", "VP9 HW Encoder supported.");
        localArrayList.add(new VideoCodecInfo("VP9", new HashMap()));
      }
      if (MediaCodecVideoDecoder.isH264HighProfileHwSupported())
      {
        Logging.d("MediaCodecVideoEncoder", "H.264 High Profile HW Encoder supported.");
        localArrayList.add(H264Utils.DEFAULT_H264_HIGH_PROFILE_CODEC);
      }
      if (MediaCodecVideoEncoder.isH264HwSupported())
      {
        Logging.d("MediaCodecVideoEncoder", "H.264 HW Encoder supported.");
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

    @Nullable
    public VideoEncoder createEncoder(final VideoCodecInfo paramVideoCodecInfo)
    {
      if (!isCodecSupported(this.supportedHardwareCodecs, paramVideoCodecInfo))
      {
        Logging.d("MediaCodecVideoEncoder", "No HW video encoder for codec " + paramVideoCodecInfo.name);
        return null;
      }
      Logging.d("MediaCodecVideoEncoder", "Create HW video encoder for " + paramVideoCodecInfo.name);
      return new WrappedNativeVideoEncoder()
      {
        public long createNativeVideoEncoder()
        {
          return MediaCodecVideoEncoder.nativeCreateEncoder(paramVideoCodecInfo, MediaCodecVideoEncoder.staticEglBase instanceof EglBase14);
        }

        public boolean isHardwareEncoder()
        {
          return true;
        }
      };
    }

    public VideoCodecInfo[] getSupportedCodecs()
    {
      return this.supportedHardwareCodecs;
    }
  }

  private static class MediaCodecProperties
  {
    public final MediaCodecVideoEncoder.BitrateAdjustmentType bitrateAdjustmentType;
    public final String codecPrefix;
    public final int minSdk;

    MediaCodecProperties(String paramString, int paramInt, MediaCodecVideoEncoder.BitrateAdjustmentType paramBitrateAdjustmentType)
    {
      this.codecPrefix = paramString;
      this.minSdk = paramInt;
      this.bitrateAdjustmentType = paramBitrateAdjustmentType;
    }
  }

  public static abstract interface MediaCodecVideoEncoderErrorCallback
  {
    public abstract void onMediaCodecVideoEncoderCriticalError(int paramInt);
  }

  static class OutputBufferInfo
  {
    public final ByteBuffer buffer;
    public final int index;
    public final boolean isKeyFrame;
    public final long presentationTimestampUs;

    public OutputBufferInfo(int paramInt, ByteBuffer paramByteBuffer, boolean paramBoolean, long paramLong)
    {
      this.index = paramInt;
      this.buffer = paramByteBuffer;
      this.isKeyFrame = paramBoolean;
      this.presentationTimestampUs = paramLong;
    }

    @CalledByNative("OutputBufferInfo")
    ByteBuffer getBuffer()
    {
      return this.buffer;
    }

    @CalledByNative("OutputBufferInfo")
    int getIndex()
    {
      return this.index;
    }

    @CalledByNative("OutputBufferInfo")
    long getPresentationTimestampUs()
    {
      return this.presentationTimestampUs;
    }

    @CalledByNative("OutputBufferInfo")
    boolean isKeyFrame()
    {
      return this.isKeyFrame;
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
 * Qualified Name:     org.webrtc.MediaCodecVideoEncoder
 * JD-Core Version:    0.6.2
 */