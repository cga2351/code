package org.webrtc.videoengine;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import android.util.Range;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.u;
import com.viber.voip.util.u.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class ViEOMXHelper
{
  public static final boolean ALLOW_WHITELISTED_MODELS_ONLY = false;
  public static final String[] EXTERNAL_QUIRK_LISTS_LOCATIONS;
  public static final boolean FORCE_DETAILED_CHECKS = false;
  private static final Logger L = ViberEnv.getLogger("ViEOMXHelper");
  private static final String OPENH264_SONAME = "libopenh264-1.0.0-android19.so";
  private static final String OPENH264_SONAME_LOCATION;
  public static final boolean REJECT_BLACKLISTED_MODELS = true;
  private static final String TAG = "ViEOMXHelper";
  public static final int VP8ProfileMain = 1;
  private static AtomicInteger _h264_available;
  private static int _h264_minimal_api_level = 18;
  private static AtomicInteger _vp8_available;
  static Map<String, OMXQuirks> blacklistedModels;
  static Set<MediaCodecInfo> cachedCodecInfo;
  public static final Map<String, OMXNode> h264_codecs;
  private static final Map<String, OpenH264DownloadDescriptor> openh264DownloadPaths;
  public static final Set<Integer> vp8_colorspaces;
  static Map<String, OMXQuirks> whitelistedModels;

  static
  {
    _h264_available = new AtomicInteger(-1);
    _vp8_available = new AtomicInteger(-1);
    blacklistedModels = new HashMap();
    EXTERNAL_QUIRK_LISTS_LOCATIONS = new String[] { "/sdcard/viber/h264_quirks.json" };
    whitelistedModels = new HashMap();
    h264_codecs = new HashMap();
    vp8_colorspaces = new TreeSet();
    cachedCodecInfo = null;
    OPENH264_SONAME_LOCATION = "/data/data/" + ViberApplication.class.getPackage().getName() + "/lib/";
    openh264DownloadPaths = new HashMap();
    openh264DownloadPaths.put("armeabi-v7a", new OpenH264DownloadDescriptor("http://ciscobinary.openh264.org/download/libopenh264-1.0.0-android19.so.bz2", "3bac885bba6b97afcbac5ed383bec918"));
    openh264DownloadPaths.put("armeabi-v7a-hard", new OpenH264DownloadDescriptor("http://ciscobinary.openh264.org/download/libopenh264-1.0.0-android19.so.bz2", "3bac885bba6b97afcbac5ed383bec918"));
  }

  public ViEOMXHelper()
  {
    whitelistedModels.put("manta", new OMXQuirks(19));
    whitelistedModels.put("nakasi", new OMXQuirks(19, 19));
    whitelistedModels.put("jflte", new OMXQuirks(19));
    whitelistedModels.put("t03gxx", new OMXQuirks(19, 19, "OMX.SEC.AVC.Encoder", "OMX.SEC.AVC.Decoder"));
    whitelistedModels.put("lt26i_1257-7450", new OMXQuirks(21, 2141391875, "OMX.qcom.video.encoder.avc", "OMX.qcom.video.decoder.avc"));
    whitelistedModels.put("m0xx", new OMXQuirks(19, 19, "OMX.SEC.AVC.Encoder", "OMX.SEC.AVC.Encoder"));
    whitelistedModels.put("hammerhead", new OMXQuirks(21, 19, "OMX.qcom.video.encoder.avc", "OMX.qcom.video.decoder.avc"));
    whitelistedModels.put("kltexx", new OMXQuirks(2141391876, 21, "OMX.qcom.video.encoder.avc", "OMX.qcom.video.decoder.avc"));
    whitelistedModels.put("6045y", new OMXQuirks(-1, 2141391876));
    whitelistedModels.put("sisleyr", new OMXQuirks(-1, 2141391876));
    loadExternalQuirkLists(EXTERNAL_QUIRK_LISTS_LOCATIONS);
  }

  public static final String colorFormat(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
      return "COLOR_FormatMonochrome";
    case 2:
      return "COLOR_Format8bitRGB332";
    case 3:
      return "COLOR_Format12bitRGB444";
    case 4:
      return "COLOR_Format16bitARGB4444";
    case 5:
      return "COLOR_Format16bitARGB1555";
    case 6:
      return "COLOR_Format16bitRGB565";
    case 7:
      return "COLOR_Format16bitBGR565";
    case 8:
      return "COLOR_Format18bitRGB666";
    case 9:
      return "COLOR_Format18bitARGB1665";
    case 10:
      return "COLOR_Format19bitARGB1666";
    case 11:
      return "COLOR_Format24bitRGB888";
    case 12:
      return "COLOR_Format24bitBGR888";
    case 13:
      return "COLOR_Format24bitARGB1887";
    case 14:
      return "COLOR_Format25bitARGB1888";
    case 15:
      return "COLOR_Format32bitBGRA8888";
    case 16:
      return "COLOR_Format32bitARGB8888";
    case 17:
      return "COLOR_FormatYUV411Planar";
    case 18:
      return "COLOR_FormatYUV411PackedPlanar";
    case 19:
      return "COLOR_FormatYUV420Planar";
    case 20:
      return "COLOR_FormatYUV420PackedPlanar";
    case 21:
      return "COLOR_FormatYUV420SemiPlanar";
    case 22:
      return "COLOR_FormatYUV422Planar";
    case 23:
      return "COLOR_FormatYUV422PackedPlanar";
    case 24:
      return "COLOR_FormatYUV422SemiPlanar";
    case 25:
      return "COLOR_FormatYCbYCr";
    case 26:
      return "COLOR_FormatYCrYCb";
    case 27:
      return "COLOR_FormatCbYCrY";
    case 28:
      return "COLOR_FormatCrYCbY";
    case 29:
      return "COLOR_FormatYUV444Interleaved";
    case 30:
      return "COLOR_FormatRawBayer8bit";
    case 31:
      return "COLOR_FormatRawBayer10bit";
    case 32:
      return "COLOR_FormatRawBayer8bitcompressed";
    case 33:
      return "COLOR_FormatL2";
    case 34:
      return "COLOR_FormatL4";
    case 35:
      return "COLOR_FormatL8";
    case 36:
      return "COLOR_FormatL16";
    case 37:
      return "COLOR_FormatL24";
    case 38:
      return "COLOR_FormatL32";
    case 39:
      return "COLOR_FormatYUV420PackedSemiPlanar";
    case 40:
      return "COLOR_FormatYUV422PackedSemiPlanar";
    case 41:
      return "COLOR_Format18BitBGR666";
    case 42:
      return "COLOR_Format24BitARGB6666";
    case 43:
      return "COLOR_Format24BitABGR6666";
    case 2130706688:
      return "COLOR_TI_FormatYUV420PackedSemiPlanar";
    case 2130708361:
      return "COLOR_FormatSurface";
    case 2141391872:
    }
    return "COLOR_QCOM_FormatYUV420SemiPlanar";
  }

  @TargetApi(21)
  private static boolean fillExtendedCodecMetadata(OMXNode paramOMXNode, MediaCodecInfo.CodecCapabilities paramCodecCapabilities, MediaCodecInfo paramMediaCodecInfo)
  {
    MediaCodecInfo.VideoCapabilities localVideoCapabilities = paramCodecCapabilities.getVideoCapabilities();
    if (localVideoCapabilities == null)
      return false;
    Range localRange1 = localVideoCapabilities.getBitrateRange();
    if (localRange1 != null)
    {
      OMXNode.access$302(paramOMXNode, ((Integer)localRange1.getLower()).intValue());
      OMXNode.access$402(paramOMXNode, ((Integer)localRange1.getUpper()).intValue());
    }
    Range localRange2 = localVideoCapabilities.getSupportedFrameRates();
    if (localRange2 != null)
    {
      OMXNode.access$502(paramOMXNode, ((Integer)localRange2.getLower()).intValue());
      OMXNode.access$602(paramOMXNode, ((Integer)localRange2.getUpper()).intValue());
    }
    OMXNode.access$102(paramOMXNode, localVideoCapabilities.getWidthAlignment());
    OMXNode.access$202(paramOMXNode, localVideoCapabilities.getHeightAlignment());
    if (paramOMXNode.isEncoder)
    {
      MediaCodecInfo.EncoderCapabilities localEncoderCapabilities = paramCodecCapabilities.getEncoderCapabilities();
      if (localEncoderCapabilities != null)
      {
        Range localRange3 = localEncoderCapabilities.getComplexityRange();
        if (localRange3 != null)
        {
          OMXNode.access$1002(paramOMXNode, ((Integer)localRange3.getLower()).intValue());
          OMXNode.access$1102(paramOMXNode, ((Integer)localRange3.getUpper()).intValue());
        }
        OMXNode.access$702(paramOMXNode, localEncoderCapabilities.isBitrateModeSupported(2));
        OMXNode.access$802(paramOMXNode, localEncoderCapabilities.isBitrateModeSupported(1));
        OMXNode.access$902(paramOMXNode, localEncoderCapabilities.isBitrateModeSupported(0));
      }
    }
    MediaFormat localMediaFormat = paramCodecCapabilities.getDefaultFormat();
    if (localMediaFormat != null)
    {
      if (localMediaFormat.containsKey("bitrate-mode"))
        paramOMXNode.default_bitrate_mode = localMediaFormat.getInteger("bitrate-mode");
      if (localMediaFormat.containsKey("color-format"))
        paramOMXNode.default_color_format = localMediaFormat.getInteger("color-format");
      if (localMediaFormat.containsKey("complexity"))
        paramOMXNode.default_complexity = localMediaFormat.getInteger("complexity");
      if (localMediaFormat.containsKey("frame-rate"))
        paramOMXNode.default_framerate = localMediaFormat.getInteger("frame-rate");
      if (localMediaFormat.containsKey("width"))
        paramOMXNode.default_width = localMediaFormat.getInteger("width");
      if (localMediaFormat.containsKey("height"))
        paramOMXNode.default_height = localMediaFormat.getInteger("height");
      if (localMediaFormat.containsKey("i-frame-interval"))
        paramOMXNode.default_i_frame_interval = localMediaFormat.getInteger("i-frame-interval");
      if (localMediaFormat.containsKey("profile"))
        paramOMXNode.default_profile = localMediaFormat.getInteger("profile");
    }
    OMXNode.access$1202(paramOMXNode, localVideoCapabilities);
    return true;
  }

  public static final String getAVCLevel(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
      return "AVCLevel1";
    case 2:
      return "AVCLevel1b";
    case 4:
      return "AVCLevel11";
    case 8:
      return "AVCLevel12";
    case 16:
      return "AVCLevel13";
    case 32:
      return "AVCLevel2";
    case 64:
      return "AVCLevel21";
    case 128:
      return "AVCLevel22";
    case 256:
      return "AVCLevel3";
    case 512:
      return "AVCLeve31";
    case 1024:
      return "AVCLeve32";
    case 2048:
      return "AVCLevel4";
    case 4096:
      return "AVCLevel41";
    case 8192:
      return "AVCLevel42";
    case 16384:
      return "AVCLevel5";
    case 32768:
    }
    return "AVCLevel51";
  }

  public static final String getAVCProfile(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
      return "AVCProfileBaseline";
    case 2:
      return "AVCProfileMain";
    case 4:
      return "AVCProfileExtended";
    case 8:
      return "AVCProfileHigh";
    case 16:
      return "AVCProfileHigh10";
    case 32:
      return "AVCProfileHigh422";
    case 64:
    }
    return "AVCProfileHigh444";
  }

  public static String[] getDecoderNames(String paramString)
  {
    List localList = u.a(Arrays.asList(getDecoders(paramString)), new u.b()
    {
      public String transform(ViEOMXHelper.OMXNode paramAnonymousOMXNode)
      {
        return paramAnonymousOMXNode.name;
      }
    });
    return (String[])localList.toArray(new String[localList.size()]);
  }

  public static OMXNode[] getDecoders(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = h264_codecs.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((!((OMXNode)localEntry.getValue()).isEncoder) && (paramString.equals(((OMXNode)localEntry.getValue()).mimetype)))
        localArrayList.add(localEntry.getValue());
    }
    return (OMXNode[])localArrayList.toArray(new OMXNode[localArrayList.size()]);
  }

  public static String[] getEncoderNames(String paramString)
  {
    List localList = u.a(Arrays.asList(getEncoders(paramString)), new u.b()
    {
      public String transform(ViEOMXHelper.OMXNode paramAnonymousOMXNode)
      {
        return paramAnonymousOMXNode.name;
      }
    });
    return (String[])localList.toArray(new String[localList.size()]);
  }

  public static OMXNode[] getEncoders(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = h264_codecs.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((OMXNode)localEntry.getValue()).isEncoder) && (paramString.equals(((OMXNode)localEntry.getValue()).mimetype)))
        localArrayList.add(localEntry.getValue());
    }
    return (OMXNode[])localArrayList.toArray(new OMXNode[localArrayList.size()]);
  }

  public static OMXNode getNode(String paramString)
  {
    return (OMXNode)h264_codecs.get(paramString);
  }

  public static OpenH264DownloadDescriptor getOpenH264DownloadUrl()
  {
    return (OpenH264DownloadDescriptor)openh264DownloadPaths.get(Build.CPU_ABI);
  }

  @ViENative
  private static final String getOpenH264Path()
  {
    return OPENH264_SONAME_LOCATION + "libopenh264-1.0.0-android19.so";
  }

  public static final OMXQuirks getQuirks()
  {
    return (OMXQuirks)whitelistedModels.get(Build.PRODUCT.toLowerCase());
  }

  public static final String getVP8Level(int paramInt)
  {
    switch (paramInt)
    {
    case 3:
    case 5:
    case 6:
    case 7:
    default:
      return null;
    case 1:
      return "VP8Level_Version0";
    case 2:
      return "VP8Level_Version1";
    case 4:
      return "VP8Level_Version2";
    case 8:
    }
    return "VP8Level_Version3";
  }

  public static final String getVP8Profile(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
    }
    return "VP8ProfileMain";
  }

  public static int[] h264Colorspaces(String paramString)
  {
    OMXNode localOMXNode = (OMXNode)h264_codecs.get(paramString);
    if (localOMXNode == null)
      return null;
    return localOMXNode.supportedColorspaces();
  }

  public static final int h264MinimalApiLevel()
  {
    return _h264_minimal_api_level;
  }

  @TargetApi(18)
  private static boolean isCodecPresent(String paramString, Map<String, OMXNode> paramMap)
  {
    if (Build.VERSION.SDK_INT >= 18)
      return isCodecPresent(paramString, paramMap, LookupMode.ENCODER_AND_DECODER);
    return false;
  }

  // ERROR //
  @TargetApi(18)
  private static boolean isCodecPresent(String paramString, Map<String, OMXNode> paramMap, LookupMode paramLookupMode)
  {
    // Byte code:
    //   0: getstatic 86	org/webrtc/videoengine/ViEOMXHelper:cachedCodecInfo	Ljava/util/Set;
    //   3: ifnonnull +54 -> 57
    //   6: ldc 2
    //   8: monitorenter
    //   9: new 628	java/util/HashSet
    //   12: dup
    //   13: invokespecial 629	java/util/HashSet:<init>	()V
    //   16: putstatic 86	org/webrtc/videoengine/ViEOMXHelper:cachedCodecInfo	Ljava/util/Set;
    //   19: invokestatic 634	android/media/MediaCodecList:getCodecCount	()I
    //   22: istore 60
    //   24: iconst_0
    //   25: istore 61
    //   27: iload 61
    //   29: iload 60
    //   31: if_icmpge +23 -> 54
    //   34: getstatic 86	org/webrtc/videoengine/ViEOMXHelper:cachedCodecInfo	Ljava/util/Set;
    //   37: iload 61
    //   39: invokestatic 638	android/media/MediaCodecList:getCodecInfoAt	(I)Landroid/media/MediaCodecInfo;
    //   42: invokeinterface 639 2 0
    //   47: pop
    //   48: iinc 61 1
    //   51: goto -24 -> 27
    //   54: ldc 2
    //   56: monitorexit
    //   57: getstatic 86	org/webrtc/videoengine/ViEOMXHelper:cachedCodecInfo	Ljava/util/Set;
    //   60: invokeinterface 526 1 0
    //   65: astore_3
    //   66: iconst_0
    //   67: istore 4
    //   69: iconst_0
    //   70: istore 5
    //   72: aload_3
    //   73: invokeinterface 532 1 0
    //   78: ifeq +1913 -> 1991
    //   81: aload_3
    //   82: invokeinterface 536 1 0
    //   87: checkcast 641	android/media/MediaCodecInfo
    //   90: astore 6
    //   92: aload 6
    //   94: invokevirtual 645	android/media/MediaCodecInfo:getSupportedTypes	()[Ljava/lang/String;
    //   97: astore 7
    //   99: aload 7
    //   101: arraylength
    //   102: istore 8
    //   104: iconst_0
    //   105: istore 9
    //   107: ldc_w 647
    //   110: astore 10
    //   112: iload 9
    //   114: iload 8
    //   116: if_icmpge +1697 -> 1813
    //   119: aload 7
    //   121: iload 9
    //   123: aaload
    //   124: astore 16
    //   126: aload_0
    //   127: aload 16
    //   129: invokevirtual 650	java/lang/String:compareToIgnoreCase	(Ljava/lang/String;)I
    //   132: ifeq +19 -> 151
    //   135: aload_0
    //   136: aload 6
    //   138: invokevirtual 651	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   141: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   144: istore 58
    //   146: iload 58
    //   148: ifeq +173 -> 321
    //   151: iconst_1
    //   152: istore 22
    //   154: iload 4
    //   156: iload 22
    //   158: ior
    //   159: istore 23
    //   161: getstatic 619	org/webrtc/videoengine/ViEOMXHelper$LookupMode:ENCODER_AND_DECODER	Lorg/webrtc/videoengine/ViEOMXHelper$LookupMode;
    //   164: aload_2
    //   165: if_acmpeq +1889 -> 2054
    //   168: aload 6
    //   170: invokevirtual 653	android/media/MediaCodecInfo:isEncoder	()Z
    //   173: ifeq +10 -> 183
    //   176: getstatic 656	org/webrtc/videoengine/ViEOMXHelper$LookupMode:ENCODER	Lorg/webrtc/videoengine/ViEOMXHelper$LookupMode;
    //   179: aload_2
    //   180: if_acmpeq +1874 -> 2054
    //   183: aload 6
    //   185: invokevirtual 653	android/media/MediaCodecInfo:isEncoder	()Z
    //   188: ifne +139 -> 327
    //   191: getstatic 659	org/webrtc/videoengine/ViEOMXHelper$LookupMode:DECODER	Lorg/webrtc/videoengine/ViEOMXHelper$LookupMode;
    //   194: aload_2
    //   195: if_acmpne +132 -> 327
    //   198: goto +1856 -> 2054
    //   201: iload 22
    //   203: iload 25
    //   205: iand
    //   206: istore 22
    //   208: iload 22
    //   210: ifeq +1823 -> 2033
    //   213: aload 6
    //   215: aload 16
    //   217: invokevirtual 663	android/media/MediaCodecInfo:getCapabilitiesForType	(Ljava/lang/String;)Landroid/media/MediaCodecInfo$CodecCapabilities;
    //   220: astore 26
    //   222: new 88	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   229: aload 10
    //   231: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: ldc_w 665
    //   237: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload 16
    //   242: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc_w 667
    //   248: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: astore 27
    //   256: aload 27
    //   258: astore 20
    //   260: new 81	java/util/TreeSet
    //   263: dup
    //   264: invokespecial 82	java/util/TreeSet:<init>	()V
    //   267: astore 28
    //   269: aload 26
    //   271: getfield 671	android/media/MediaCodecInfo$CodecCapabilities:colorFormats	[I
    //   274: astore 30
    //   276: aload 30
    //   278: arraylength
    //   279: istore 31
    //   281: iconst_0
    //   282: istore 32
    //   284: iload 32
    //   286: iload 31
    //   288: if_icmpge +45 -> 333
    //   291: aload 28
    //   293: aload 30
    //   295: iload 32
    //   297: iaload
    //   298: invokestatic 675	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   301: invokeinterface 678 2 0
    //   306: pop
    //   307: iinc 32 1
    //   310: goto -26 -> 284
    //   313: astore 59
    //   315: ldc 2
    //   317: monitorexit
    //   318: aload 59
    //   320: athrow
    //   321: iconst_0
    //   322: istore 22
    //   324: goto -170 -> 154
    //   327: iconst_0
    //   328: istore 25
    //   330: goto -129 -> 201
    //   333: aload 28
    //   335: invokeinterface 679 1 0
    //   340: astore 34
    //   342: aload 34
    //   344: invokeinterface 532 1 0
    //   349: ifeq +199 -> 548
    //   352: aload 34
    //   354: invokeinterface 536 1 0
    //   359: checkcast 307	java/lang/Integer
    //   362: invokevirtual 311	java/lang/Integer:intValue	()I
    //   365: istore 54
    //   367: iload 54
    //   369: invokestatic 681	org/webrtc/videoengine/ViEOMXHelper:colorFormat	(I)Ljava/lang/String;
    //   372: astore 55
    //   374: aload 55
    //   376: ifnonnull +8 -> 384
    //   379: ldc_w 683
    //   382: astore 55
    //   384: new 88	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   391: aload 20
    //   393: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: iload 54
    //   398: invokevirtual 686	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   401: ldc_w 688
    //   404: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload 55
    //   409: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: ldc_w 690
    //   415: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: astore 20
    //   423: aload_1
    //   424: aload 6
    //   426: invokevirtual 651	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   429: invokeinterface 570 2 0
    //   434: checkcast 313	org/webrtc/videoengine/ViEOMXHelper$OMXNode
    //   437: astore 56
    //   439: aload 56
    //   441: ifnonnull +24 -> 465
    //   444: new 313	org/webrtc/videoengine/ViEOMXHelper$OMXNode
    //   447: dup
    //   448: aload 16
    //   450: aload 6
    //   452: invokevirtual 651	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   455: aload 6
    //   457: invokevirtual 653	android/media/MediaCodecInfo:isEncoder	()Z
    //   460: invokespecial 693	org/webrtc/videoengine/ViEOMXHelper$OMXNode:<init>	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   463: astore 56
    //   465: aload 56
    //   467: iload 54
    //   469: invokevirtual 696	org/webrtc/videoengine/ViEOMXHelper$OMXNode:addSupportedColorspace	(I)V
    //   472: aload_1
    //   473: aload 6
    //   475: invokevirtual 651	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   478: aload 56
    //   480: invokeinterface 135 3 0
    //   485: pop
    //   486: goto -144 -> 342
    //   489: astore 29
    //   491: iload 22
    //   493: istore 5
    //   495: iload 23
    //   497: istore 19
    //   499: iconst_1
    //   500: new 88	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   507: ldc_w 698
    //   510: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: aload 16
    //   515: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: ldc_w 700
    //   521: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: invokestatic 704	org/webrtc/videoengine/ViEOMXHelper:log	(ZLjava/lang/String;)V
    //   530: iinc 9 1
    //   533: aload 20
    //   535: astore 21
    //   537: iload 19
    //   539: istore 4
    //   541: aload 21
    //   543: astore 10
    //   545: goto -433 -> 112
    //   548: new 88	java/lang/StringBuilder
    //   551: dup
    //   552: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   555: aload 20
    //   557: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: ldc_w 706
    //   563: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: astore 20
    //   571: ldc_w 708
    //   574: aload 16
    //   576: invokevirtual 711	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   579: ifeq +1078 -> 1657
    //   582: new 88	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   589: aload 20
    //   591: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: ldc_w 713
    //   597: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: astore 20
    //   605: aload_1
    //   606: aload 6
    //   608: invokevirtual 651	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   611: invokeinterface 570 2 0
    //   616: checkcast 313	org/webrtc/videoengine/ViEOMXHelper$OMXNode
    //   619: astore 45
    //   621: aload 45
    //   623: ifnonnull +1424 -> 2047
    //   626: new 313	org/webrtc/videoengine/ViEOMXHelper$OMXNode
    //   629: dup
    //   630: aload 16
    //   632: aload 6
    //   634: invokevirtual 651	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   637: aload 6
    //   639: invokevirtual 653	android/media/MediaCodecInfo:isEncoder	()Z
    //   642: invokespecial 693	org/webrtc/videoengine/ViEOMXHelper$OMXNode:<init>	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   645: astore 46
    //   647: aload 26
    //   649: getfield 717	android/media/MediaCodecInfo$CodecCapabilities:profileLevels	[Landroid/media/MediaCodecInfo$CodecProfileLevel;
    //   652: astore 47
    //   654: aload 47
    //   656: arraylength
    //   657: istore 48
    //   659: iconst_0
    //   660: istore 49
    //   662: iload 49
    //   664: iload 48
    //   666: if_icmpge +141 -> 807
    //   669: aload 47
    //   671: iload 49
    //   673: aaload
    //   674: astore 50
    //   676: new 88	java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   683: aload 20
    //   685: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: ldc_w 719
    //   691: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: aload 50
    //   696: getfield 723	android/media/MediaCodecInfo$CodecProfileLevel:profile	I
    //   699: invokestatic 725	org/webrtc/videoengine/ViEOMXHelper:getAVCProfile	(I)Ljava/lang/String;
    //   702: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: ldc_w 727
    //   708: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: aload 50
    //   713: getfield 730	android/media/MediaCodecInfo$CodecProfileLevel:level	I
    //   716: invokestatic 732	org/webrtc/videoengine/ViEOMXHelper:getAVCLevel	(I)Ljava/lang/String;
    //   719: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: ldc_w 734
    //   725: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   731: astore 20
    //   733: aload 46
    //   735: getfield 737	org/webrtc/videoengine/ViEOMXHelper$OMXNode:h264_baseline_supported	Z
    //   738: istore 51
    //   740: aload 50
    //   742: getfield 723	android/media/MediaCodecInfo$CodecProfileLevel:profile	I
    //   745: iconst_1
    //   746: if_icmpne +1320 -> 2066
    //   749: aload 50
    //   751: getfield 730	android/media/MediaCodecInfo$CodecProfileLevel:level	I
    //   754: sipush 512
    //   757: if_icmplt +1309 -> 2066
    //   760: iconst_1
    //   761: istore 52
    //   763: aload 46
    //   765: iload 52
    //   767: iload 51
    //   769: ior
    //   770: putfield 737	org/webrtc/videoengine/ViEOMXHelper$OMXNode:h264_baseline_supported	Z
    //   773: aload 46
    //   775: getfield 737	org/webrtc/videoengine/ViEOMXHelper$OMXNode:h264_baseline_supported	Z
    //   778: ifeq +1282 -> 2060
    //   781: aload 46
    //   783: getfield 740	org/webrtc/videoengine/ViEOMXHelper$OMXNode:h264_baseline_avclevel	I
    //   786: aload 50
    //   788: getfield 730	android/media/MediaCodecInfo$CodecProfileLevel:level	I
    //   791: if_icmpge +1269 -> 2060
    //   794: aload 46
    //   796: aload 50
    //   798: getfield 730	android/media/MediaCodecInfo$CodecProfileLevel:level	I
    //   801: putfield 740	org/webrtc/videoengine/ViEOMXHelper$OMXNode:h264_baseline_avclevel	I
    //   804: goto +1256 -> 2060
    //   807: new 88	java/lang/StringBuilder
    //   810: dup
    //   811: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   814: aload 20
    //   816: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: ldc_w 706
    //   822: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   828: astore 20
    //   830: aload_1
    //   831: aload 6
    //   833: invokevirtual 651	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   836: aload 46
    //   838: invokeinterface 135 3 0
    //   843: pop
    //   844: aload_1
    //   845: aload 6
    //   847: invokevirtual 651	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   850: invokeinterface 570 2 0
    //   855: checkcast 313	org/webrtc/videoengine/ViEOMXHelper$OMXNode
    //   858: astore 40
    //   860: getstatic 613	android/os/Build$VERSION:SDK_INT	I
    //   863: istore 41
    //   865: iload 41
    //   867: bipush 21
    //   869: if_icmplt +777 -> 1646
    //   872: aload 40
    //   874: ifnull +772 -> 1646
    //   877: aload 40
    //   879: aload 26
    //   881: aload 6
    //   883: invokestatic 742	org/webrtc/videoengine/ViEOMXHelper:fillExtendedCodecMetadata	(Lorg/webrtc/videoengine/ViEOMXHelper$OMXNode;Landroid/media/MediaCodecInfo$CodecCapabilities;Landroid/media/MediaCodecInfo;)Z
    //   886: ifeq +1154 -> 2040
    //   889: new 88	java/lang/StringBuilder
    //   892: dup
    //   893: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   896: aload 20
    //   898: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: ldc_w 744
    //   904: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   910: astore 20
    //   912: new 88	java/lang/StringBuilder
    //   915: dup
    //   916: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   919: aload 20
    //   921: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: ldc_w 746
    //   927: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: aload 40
    //   932: invokestatic 750	org/webrtc/videoengine/ViEOMXHelper$OMXNode:access$100	(Lorg/webrtc/videoengine/ViEOMXHelper$OMXNode;)I
    //   935: invokevirtual 686	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   938: ldc_w 752
    //   941: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   947: astore 20
    //   949: new 88	java/lang/StringBuilder
    //   952: dup
    //   953: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   956: aload 20
    //   958: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: ldc_w 754
    //   964: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: aload 40
    //   969: invokestatic 757	org/webrtc/videoengine/ViEOMXHelper$OMXNode:access$200	(Lorg/webrtc/videoengine/ViEOMXHelper$OMXNode;)I
    //   972: invokevirtual 686	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   975: ldc_w 752
    //   978: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   984: astore 20
    //   986: new 88	java/lang/StringBuilder
    //   989: dup
    //   990: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   993: aload 20
    //   995: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: ldc_w 759
    //   1001: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: aload 40
    //   1006: invokestatic 762	org/webrtc/videoengine/ViEOMXHelper$OMXNode:access$300	(Lorg/webrtc/videoengine/ViEOMXHelper$OMXNode;)I
    //   1009: invokevirtual 686	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1012: ldc_w 752
    //   1015: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1021: astore 20
    //   1023: new 88	java/lang/StringBuilder
    //   1026: dup
    //   1027: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1030: aload 20
    //   1032: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: ldc_w 764
    //   1038: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: aload 40
    //   1043: invokestatic 767	org/webrtc/videoengine/ViEOMXHelper$OMXNode:access$400	(Lorg/webrtc/videoengine/ViEOMXHelper$OMXNode;)I
    //   1046: invokevirtual 686	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1049: ldc_w 752
    //   1052: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1058: astore 20
    //   1060: new 88	java/lang/StringBuilder
    //   1063: dup
    //   1064: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1067: aload 20
    //   1069: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: ldc_w 769
    //   1075: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1078: aload 40
    //   1080: invokestatic 772	org/webrtc/videoengine/ViEOMXHelper$OMXNode:access$500	(Lorg/webrtc/videoengine/ViEOMXHelper$OMXNode;)I
    //   1083: invokevirtual 686	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1086: ldc_w 752
    //   1089: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1092: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1095: astore 20
    //   1097: new 88	java/lang/StringBuilder
    //   1100: dup
    //   1101: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1104: aload 20
    //   1106: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1109: ldc_w 774
    //   1112: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1115: aload 40
    //   1117: invokestatic 777	org/webrtc/videoengine/ViEOMXHelper$OMXNode:access$600	(Lorg/webrtc/videoengine/ViEOMXHelper$OMXNode;)I
    //   1120: invokevirtual 686	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1123: ldc_w 752
    //   1126: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1132: astore 20
    //   1134: new 88	java/lang/StringBuilder
    //   1137: dup
    //   1138: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1141: aload 20
    //   1143: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: ldc_w 779
    //   1149: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1152: aload 40
    //   1154: invokestatic 783	org/webrtc/videoengine/ViEOMXHelper$OMXNode:access$700	(Lorg/webrtc/videoengine/ViEOMXHelper$OMXNode;)Z
    //   1157: invokevirtual 786	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1160: ldc_w 752
    //   1163: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1166: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1169: astore 20
    //   1171: new 88	java/lang/StringBuilder
    //   1174: dup
    //   1175: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1178: aload 20
    //   1180: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: ldc_w 788
    //   1186: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1189: aload 40
    //   1191: invokestatic 791	org/webrtc/videoengine/ViEOMXHelper$OMXNode:access$800	(Lorg/webrtc/videoengine/ViEOMXHelper$OMXNode;)Z
    //   1194: invokevirtual 786	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1197: ldc_w 752
    //   1200: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1206: astore 20
    //   1208: new 88	java/lang/StringBuilder
    //   1211: dup
    //   1212: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1215: aload 20
    //   1217: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1220: ldc_w 793
    //   1223: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: aload 40
    //   1228: invokestatic 796	org/webrtc/videoengine/ViEOMXHelper$OMXNode:access$900	(Lorg/webrtc/videoengine/ViEOMXHelper$OMXNode;)Z
    //   1231: invokevirtual 786	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1234: ldc_w 752
    //   1237: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1243: astore 20
    //   1245: new 88	java/lang/StringBuilder
    //   1248: dup
    //   1249: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1252: aload 20
    //   1254: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: ldc_w 798
    //   1260: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1263: aload 40
    //   1265: invokestatic 801	org/webrtc/videoengine/ViEOMXHelper$OMXNode:access$1000	(Lorg/webrtc/videoengine/ViEOMXHelper$OMXNode;)I
    //   1268: invokevirtual 686	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1271: ldc_w 752
    //   1274: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1280: astore 20
    //   1282: new 88	java/lang/StringBuilder
    //   1285: dup
    //   1286: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1289: aload 20
    //   1291: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1294: ldc_w 803
    //   1297: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1300: aload 40
    //   1302: invokestatic 806	org/webrtc/videoengine/ViEOMXHelper$OMXNode:access$1100	(Lorg/webrtc/videoengine/ViEOMXHelper$OMXNode;)I
    //   1305: invokevirtual 686	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1308: ldc_w 752
    //   1311: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1314: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1317: astore 20
    //   1319: new 88	java/lang/StringBuilder
    //   1322: dup
    //   1323: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1326: aload 20
    //   1328: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: ldc_w 808
    //   1334: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1337: aload 40
    //   1339: getfield 395	org/webrtc/videoengine/ViEOMXHelper$OMXNode:default_bitrate_mode	I
    //   1342: invokevirtual 686	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1345: ldc_w 752
    //   1348: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1351: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1354: astore 20
    //   1356: new 88	java/lang/StringBuilder
    //   1359: dup
    //   1360: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1363: aload 20
    //   1365: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: ldc_w 810
    //   1371: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1374: aload 40
    //   1376: getfield 400	org/webrtc/videoengine/ViEOMXHelper$OMXNode:default_color_format	I
    //   1379: invokevirtual 686	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1382: ldc_w 752
    //   1385: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1388: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1391: astore 20
    //   1393: new 88	java/lang/StringBuilder
    //   1396: dup
    //   1397: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1400: aload 20
    //   1402: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1405: ldc_w 812
    //   1408: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1411: aload 40
    //   1413: getfield 405	org/webrtc/videoengine/ViEOMXHelper$OMXNode:default_complexity	I
    //   1416: invokevirtual 686	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1419: ldc_w 752
    //   1422: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1428: astore 20
    //   1430: new 88	java/lang/StringBuilder
    //   1433: dup
    //   1434: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1437: aload 20
    //   1439: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1442: ldc_w 814
    //   1445: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1448: aload 40
    //   1450: getfield 410	org/webrtc/videoengine/ViEOMXHelper$OMXNode:default_framerate	I
    //   1453: invokevirtual 686	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1456: ldc_w 752
    //   1459: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1462: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1465: astore 20
    //   1467: new 88	java/lang/StringBuilder
    //   1470: dup
    //   1471: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1474: aload 20
    //   1476: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1479: ldc_w 816
    //   1482: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1485: aload 40
    //   1487: getfield 415	org/webrtc/videoengine/ViEOMXHelper$OMXNode:default_width	I
    //   1490: invokevirtual 686	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1493: ldc_w 752
    //   1496: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1499: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1502: astore 20
    //   1504: new 88	java/lang/StringBuilder
    //   1507: dup
    //   1508: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1511: aload 20
    //   1513: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1516: ldc_w 818
    //   1519: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1522: aload 40
    //   1524: getfield 420	org/webrtc/videoengine/ViEOMXHelper$OMXNode:default_height	I
    //   1527: invokevirtual 686	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1530: ldc_w 752
    //   1533: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1536: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1539: astore 20
    //   1541: new 88	java/lang/StringBuilder
    //   1544: dup
    //   1545: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1548: aload 20
    //   1550: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1553: ldc_w 820
    //   1556: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1559: aload 40
    //   1561: getfield 425	org/webrtc/videoengine/ViEOMXHelper$OMXNode:default_i_frame_interval	I
    //   1564: invokevirtual 686	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1567: ldc_w 752
    //   1570: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1573: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1576: astore 20
    //   1578: new 88	java/lang/StringBuilder
    //   1581: dup
    //   1582: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1585: aload 20
    //   1587: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1590: ldc_w 822
    //   1593: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1596: aload 40
    //   1598: getfield 430	org/webrtc/videoengine/ViEOMXHelper$OMXNode:default_profile	I
    //   1601: invokevirtual 686	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1604: ldc_w 752
    //   1607: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1610: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1613: astore 20
    //   1615: new 88	java/lang/StringBuilder
    //   1618: dup
    //   1619: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1622: aload 20
    //   1624: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1627: ldc_w 706
    //   1630: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1633: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1636: astore 44
    //   1638: aload 44
    //   1640: astore 43
    //   1642: aload 43
    //   1644: astore 20
    //   1646: iload 22
    //   1648: istore 5
    //   1650: iload 23
    //   1652: istore 19
    //   1654: goto -1124 -> 530
    //   1657: ldc_w 708
    //   1660: aload 16
    //   1662: invokevirtual 711	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1665: ifeq -821 -> 844
    //   1668: new 88	java/lang/StringBuilder
    //   1671: dup
    //   1672: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1675: aload 20
    //   1677: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1680: ldc_w 824
    //   1683: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1686: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1689: astore 20
    //   1691: aload 26
    //   1693: getfield 717	android/media/MediaCodecInfo$CodecCapabilities:profileLevels	[Landroid/media/MediaCodecInfo$CodecProfileLevel;
    //   1696: astore 35
    //   1698: aload 35
    //   1700: arraylength
    //   1701: istore 36
    //   1703: iconst_0
    //   1704: istore 37
    //   1706: iload 37
    //   1708: iload 36
    //   1710: if_icmpge +73 -> 1783
    //   1713: aload 35
    //   1715: iload 37
    //   1717: aaload
    //   1718: astore 38
    //   1720: new 88	java/lang/StringBuilder
    //   1723: dup
    //   1724: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1727: aload 20
    //   1729: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1732: ldc_w 719
    //   1735: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1738: aload 38
    //   1740: getfield 723	android/media/MediaCodecInfo$CodecProfileLevel:profile	I
    //   1743: invokestatic 826	org/webrtc/videoengine/ViEOMXHelper:getVP8Profile	(I)Ljava/lang/String;
    //   1746: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1749: ldc_w 727
    //   1752: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1755: aload 38
    //   1757: getfield 730	android/media/MediaCodecInfo$CodecProfileLevel:level	I
    //   1760: invokestatic 828	org/webrtc/videoengine/ViEOMXHelper:getVP8Level	(I)Ljava/lang/String;
    //   1763: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1766: ldc_w 734
    //   1769: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1772: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1775: astore 20
    //   1777: iinc 37 1
    //   1780: goto -74 -> 1706
    //   1783: new 88	java/lang/StringBuilder
    //   1786: dup
    //   1787: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1790: aload 20
    //   1792: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1795: ldc_w 706
    //   1798: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1801: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1804: astore 39
    //   1806: aload 39
    //   1808: astore 20
    //   1810: goto -966 -> 844
    //   1813: new 88	java/lang/StringBuilder
    //   1816: dup
    //   1817: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1820: aload 10
    //   1822: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1825: ldc_w 830
    //   1828: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1831: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1834: astore 11
    //   1836: new 88	java/lang/StringBuilder
    //   1839: dup
    //   1840: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1843: ldc_w 832
    //   1846: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1849: astore 12
    //   1851: iload 5
    //   1853: ifeq +122 -> 1975
    //   1856: ldc_w 834
    //   1859: astore 13
    //   1861: aload 12
    //   1863: aload 13
    //   1865: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1868: ldc_w 836
    //   1871: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1874: astore 14
    //   1876: aload 6
    //   1878: invokevirtual 653	android/media/MediaCodecInfo:isEncoder	()Z
    //   1881: ifeq +102 -> 1983
    //   1884: ldc_w 838
    //   1887: astore 15
    //   1889: iconst_1
    //   1890: aload 14
    //   1892: aload 15
    //   1894: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1897: ldc_w 667
    //   1900: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1903: iconst_0
    //   1904: invokevirtual 686	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1907: ldc_w 706
    //   1910: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1913: aload 6
    //   1915: invokevirtual 651	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   1918: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1921: ldc_w 840
    //   1924: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1927: aload 7
    //   1929: invokestatic 843	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   1932: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1935: ldc_w 845
    //   1938: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1941: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1944: invokestatic 704	org/webrtc/videoengine/ViEOMXHelper:log	(ZLjava/lang/String;)V
    //   1947: iconst_1
    //   1948: new 88	java/lang/StringBuilder
    //   1951: dup
    //   1952: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1955: ldc_w 847
    //   1958: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1961: aload 11
    //   1963: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1966: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1969: invokestatic 704	org/webrtc/videoengine/ViEOMXHelper:log	(ZLjava/lang/String;)V
    //   1972: goto -1900 -> 72
    //   1975: ldc_w 849
    //   1978: astore 13
    //   1980: goto -119 -> 1861
    //   1983: ldc_w 851
    //   1986: astore 15
    //   1988: goto -99 -> 1889
    //   1991: iload 4
    //   1993: ireturn
    //   1994: astore 17
    //   1996: aload 10
    //   1998: astore 18
    //   2000: iload 4
    //   2002: istore 19
    //   2004: aload 18
    //   2006: astore 20
    //   2008: goto -1509 -> 499
    //   2011: astore 24
    //   2013: aload 10
    //   2015: astore 20
    //   2017: iload 22
    //   2019: istore 5
    //   2021: iload 23
    //   2023: istore 19
    //   2025: goto -1526 -> 499
    //   2028: astore 42
    //   2030: goto -384 -> 1646
    //   2033: aload 10
    //   2035: astore 20
    //   2037: goto -391 -> 1646
    //   2040: aload 20
    //   2042: astore 43
    //   2044: goto -402 -> 1642
    //   2047: aload 45
    //   2049: astore 46
    //   2051: goto -1404 -> 647
    //   2054: iconst_1
    //   2055: istore 25
    //   2057: goto -1856 -> 201
    //   2060: iinc 49 1
    //   2063: goto -1401 -> 662
    //   2066: iconst_0
    //   2067: istore 52
    //   2069: goto -1306 -> 763
    //
    // Exception table:
    //   from	to	target	type
    //   9	24	313	finally
    //   34	48	313	finally
    //   54	57	313	finally
    //   315	318	313	finally
    //   260	281	489	java/lang/Exception
    //   291	307	489	java/lang/Exception
    //   333	342	489	java/lang/Exception
    //   342	374	489	java/lang/Exception
    //   384	439	489	java/lang/Exception
    //   444	465	489	java/lang/Exception
    //   465	486	489	java/lang/Exception
    //   548	621	489	java/lang/Exception
    //   626	647	489	java/lang/Exception
    //   647	659	489	java/lang/Exception
    //   669	760	489	java/lang/Exception
    //   763	804	489	java/lang/Exception
    //   807	844	489	java/lang/Exception
    //   844	865	489	java/lang/Exception
    //   877	1638	489	java/lang/Exception
    //   1657	1703	489	java/lang/Exception
    //   1713	1777	489	java/lang/Exception
    //   1783	1806	489	java/lang/Exception
    //   126	146	1994	java/lang/Exception
    //   161	183	2011	java/lang/Exception
    //   183	198	2011	java/lang/Exception
    //   213	256	2011	java/lang/Exception
    //   877	1638	2028	java/lang/Throwable
  }

  // ERROR //
  public static boolean isH264Available()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: iconst_m1
    //   3: getstatic 61	org/webrtc/videoengine/ViEOMXHelper:_h264_available	Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual 854	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   9: if_icmpeq +26 -> 35
    //   12: getstatic 61	org/webrtc/videoengine/ViEOMXHelper:_h264_available	Ljava/util/concurrent/atomic/AtomicInteger;
    //   15: invokevirtual 854	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   18: ifeq +11 -> 29
    //   21: iload_0
    //   22: istore 25
    //   24: iload 25
    //   26: istore_0
    //   27: iload_0
    //   28: ireturn
    //   29: iconst_0
    //   30: istore 25
    //   32: goto -8 -> 24
    //   35: getstatic 584	android/os/Build:PRODUCT	Ljava/lang/String;
    //   38: invokevirtual 587	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   41: astore_1
    //   42: getstatic 69	org/webrtc/videoengine/ViEOMXHelper:blacklistedModels	Ljava/util/Map;
    //   45: aload_1
    //   46: invokeinterface 856 2 0
    //   51: istore 6
    //   53: iconst_0
    //   54: iload 6
    //   56: ior
    //   57: istore_3
    //   58: iload_3
    //   59: ifeq +22 -> 81
    //   62: getstatic 61	org/webrtc/videoengine/ViEOMXHelper:_h264_available	Ljava/util/concurrent/atomic/AtomicInteger;
    //   65: astore 24
    //   67: iload_3
    //   68: ifeq +5 -> 73
    //   71: iconst_0
    //   72: istore_0
    //   73: aload 24
    //   75: iload_0
    //   76: invokevirtual 859	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   79: iconst_0
    //   80: ireturn
    //   81: getstatic 77	org/webrtc/videoengine/ViEOMXHelper:whitelistedModels	Ljava/util/Map;
    //   84: aload_1
    //   85: invokeinterface 856 2 0
    //   90: ifeq +343 -> 433
    //   93: getstatic 77	org/webrtc/videoengine/ViEOMXHelper:whitelistedModels	Ljava/util/Map;
    //   96: aload_1
    //   97: invokeinterface 570 2 0
    //   102: checkcast 142	org/webrtc/videoengine/ViEOMXHelper$OMXQuirks
    //   105: astore 11
    //   107: getstatic 79	org/webrtc/videoengine/ViEOMXHelper:h264_codecs	Ljava/util/Map;
    //   110: aload 11
    //   112: getfield 862	org/webrtc/videoengine/ViEOMXHelper$OMXQuirks:forcedEncoderType	Ljava/lang/String;
    //   115: invokeinterface 570 2 0
    //   120: checkcast 313	org/webrtc/videoengine/ViEOMXHelper$OMXNode
    //   123: astore 12
    //   125: aload 12
    //   127: ifnonnull +21 -> 148
    //   130: getstatic 79	org/webrtc/videoengine/ViEOMXHelper:h264_codecs	Ljava/util/Map;
    //   133: aload 11
    //   135: getfield 865	org/webrtc/videoengine/ViEOMXHelper$OMXQuirks:forcedDecoderType	Ljava/lang/String;
    //   138: invokeinterface 570 2 0
    //   143: checkcast 313	org/webrtc/videoengine/ViEOMXHelper$OMXNode
    //   146: astore 12
    //   148: aload 12
    //   150: ifnull +44 -> 194
    //   153: aload 12
    //   155: getfield 347	org/webrtc/videoengine/ViEOMXHelper$OMXNode:isEncoder	Z
    //   158: ifeq +26 -> 184
    //   161: aload 11
    //   163: getfield 867	org/webrtc/videoengine/ViEOMXHelper$OMXQuirks:encoder	I
    //   166: istore 13
    //   168: aload 12
    //   170: iload 13
    //   172: invokevirtual 696	org/webrtc/videoengine/ViEOMXHelper$OMXNode:addSupportedColorspace	(I)V
    //   175: getstatic 61	org/webrtc/videoengine/ViEOMXHelper:_h264_available	Ljava/util/concurrent/atomic/AtomicInteger;
    //   178: iload_0
    //   179: invokevirtual 859	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   182: iload_0
    //   183: ireturn
    //   184: aload 11
    //   186: getfield 869	org/webrtc/videoengine/ViEOMXHelper$OMXQuirks:decoder	I
    //   189: istore 13
    //   191: goto -23 -> 168
    //   194: aload 11
    //   196: getfield 862	org/webrtc/videoengine/ViEOMXHelper$OMXQuirks:forcedEncoderType	Ljava/lang/String;
    //   199: ifnull +178 -> 377
    //   202: getstatic 79	org/webrtc/videoengine/ViEOMXHelper:h264_codecs	Ljava/util/Map;
    //   205: astore 20
    //   207: aload 11
    //   209: getfield 862	org/webrtc/videoengine/ViEOMXHelper$OMXQuirks:forcedEncoderType	Ljava/lang/String;
    //   212: astore 21
    //   214: new 313	org/webrtc/videoengine/ViEOMXHelper$OMXNode
    //   217: dup
    //   218: ldc_w 708
    //   221: aload 11
    //   223: getfield 862	org/webrtc/videoengine/ViEOMXHelper$OMXQuirks:forcedEncoderType	Ljava/lang/String;
    //   226: iconst_1
    //   227: invokespecial 693	org/webrtc/videoengine/ViEOMXHelper$OMXNode:<init>	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   230: astore 22
    //   232: aload 20
    //   234: aload 21
    //   236: aload 22
    //   238: invokeinterface 135 3 0
    //   243: pop
    //   244: iconst_m1
    //   245: aload 11
    //   247: getfield 867	org/webrtc/videoengine/ViEOMXHelper$OMXQuirks:encoder	I
    //   250: if_icmpeq +107 -> 357
    //   253: aload 22
    //   255: aload 11
    //   257: getfield 867	org/webrtc/videoengine/ViEOMXHelper$OMXQuirks:encoder	I
    //   260: invokevirtual 696	org/webrtc/videoengine/ViEOMXHelper$OMXNode:addSupportedColorspace	(I)V
    //   263: aload 11
    //   265: getfield 865	org/webrtc/videoengine/ViEOMXHelper$OMXQuirks:forcedDecoderType	Ljava/lang/String;
    //   268: ifnull +147 -> 415
    //   271: getstatic 79	org/webrtc/videoengine/ViEOMXHelper:h264_codecs	Ljava/util/Map;
    //   274: astore 15
    //   276: aload 11
    //   278: getfield 865	org/webrtc/videoengine/ViEOMXHelper$OMXQuirks:forcedDecoderType	Ljava/lang/String;
    //   281: astore 16
    //   283: new 313	org/webrtc/videoengine/ViEOMXHelper$OMXNode
    //   286: dup
    //   287: ldc_w 708
    //   290: aload 11
    //   292: getfield 865	org/webrtc/videoengine/ViEOMXHelper$OMXQuirks:forcedDecoderType	Ljava/lang/String;
    //   295: iconst_0
    //   296: invokespecial 693	org/webrtc/videoengine/ViEOMXHelper$OMXNode:<init>	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   299: astore 17
    //   301: aload 15
    //   303: aload 16
    //   305: aload 17
    //   307: invokeinterface 135 3 0
    //   312: pop
    //   313: iconst_m1
    //   314: aload 11
    //   316: getfield 869	org/webrtc/videoengine/ViEOMXHelper$OMXQuirks:decoder	I
    //   319: if_icmpeq +76 -> 395
    //   322: aload 17
    //   324: aload 11
    //   326: getfield 869	org/webrtc/videoengine/ViEOMXHelper$OMXQuirks:decoder	I
    //   329: invokevirtual 696	org/webrtc/videoengine/ViEOMXHelper$OMXNode:addSupportedColorspace	(I)V
    //   332: goto -157 -> 175
    //   335: astore_2
    //   336: getstatic 61	org/webrtc/videoengine/ViEOMXHelper:_h264_available	Ljava/util/concurrent/atomic/AtomicInteger;
    //   339: astore 4
    //   341: iconst_0
    //   342: istore 5
    //   344: iload_3
    //   345: ifeq +142 -> 487
    //   348: aload 4
    //   350: iload 5
    //   352: invokevirtual 859	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   355: aload_2
    //   356: athrow
    //   357: iload_3
    //   358: aload 11
    //   360: getfield 862	org/webrtc/videoengine/ViEOMXHelper$OMXQuirks:forcedEncoderType	Ljava/lang/String;
    //   363: getstatic 79	org/webrtc/videoengine/ViEOMXHelper:h264_codecs	Ljava/util/Map;
    //   366: getstatic 656	org/webrtc/videoengine/ViEOMXHelper$LookupMode:ENCODER	Lorg/webrtc/videoengine/ViEOMXHelper$LookupMode;
    //   369: invokestatic 622	org/webrtc/videoengine/ViEOMXHelper:isCodecPresent	(Ljava/lang/String;Ljava/util/Map;Lorg/webrtc/videoengine/ViEOMXHelper$LookupMode;)Z
    //   372: iand
    //   373: istore_3
    //   374: goto -111 -> 263
    //   377: iload_3
    //   378: ldc_w 708
    //   381: getstatic 79	org/webrtc/videoengine/ViEOMXHelper:h264_codecs	Ljava/util/Map;
    //   384: getstatic 656	org/webrtc/videoengine/ViEOMXHelper$LookupMode:ENCODER	Lorg/webrtc/videoengine/ViEOMXHelper$LookupMode;
    //   387: invokestatic 622	org/webrtc/videoengine/ViEOMXHelper:isCodecPresent	(Ljava/lang/String;Ljava/util/Map;Lorg/webrtc/videoengine/ViEOMXHelper$LookupMode;)Z
    //   390: iand
    //   391: istore_3
    //   392: goto -129 -> 263
    //   395: iload_3
    //   396: aload 11
    //   398: getfield 865	org/webrtc/videoengine/ViEOMXHelper$OMXQuirks:forcedDecoderType	Ljava/lang/String;
    //   401: getstatic 79	org/webrtc/videoengine/ViEOMXHelper:h264_codecs	Ljava/util/Map;
    //   404: getstatic 659	org/webrtc/videoengine/ViEOMXHelper$LookupMode:DECODER	Lorg/webrtc/videoengine/ViEOMXHelper$LookupMode;
    //   407: invokestatic 622	org/webrtc/videoengine/ViEOMXHelper:isCodecPresent	(Ljava/lang/String;Ljava/util/Map;Lorg/webrtc/videoengine/ViEOMXHelper$LookupMode;)Z
    //   410: iand
    //   411: pop
    //   412: goto -237 -> 175
    //   415: iload_3
    //   416: ldc_w 708
    //   419: getstatic 79	org/webrtc/videoengine/ViEOMXHelper:h264_codecs	Ljava/util/Map;
    //   422: getstatic 659	org/webrtc/videoengine/ViEOMXHelper$LookupMode:DECODER	Lorg/webrtc/videoengine/ViEOMXHelper$LookupMode;
    //   425: invokestatic 622	org/webrtc/videoengine/ViEOMXHelper:isCodecPresent	(Ljava/lang/String;Ljava/util/Map;Lorg/webrtc/videoengine/ViEOMXHelper$LookupMode;)Z
    //   428: iand
    //   429: pop
    //   430: goto -255 -> 175
    //   433: iload_3
    //   434: ifne +65 -> 499
    //   437: ldc_w 708
    //   440: getstatic 79	org/webrtc/videoengine/ViEOMXHelper:h264_codecs	Ljava/util/Map;
    //   443: invokestatic 871	org/webrtc/videoengine/ViEOMXHelper:isCodecPresent	(Ljava/lang/String;Ljava/util/Map;)Z
    //   446: istore 7
    //   448: iload 7
    //   450: iload_3
    //   451: iand
    //   452: istore 8
    //   454: getstatic 61	org/webrtc/videoengine/ViEOMXHelper:_h264_available	Ljava/util/concurrent/atomic/AtomicInteger;
    //   457: astore 9
    //   459: iload 8
    //   461: ifeq +20 -> 481
    //   464: iconst_0
    //   465: istore 10
    //   467: aload 9
    //   469: iload 10
    //   471: invokevirtual 859	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   474: iload 8
    //   476: ifeq -449 -> 27
    //   479: iconst_0
    //   480: ireturn
    //   481: iload_0
    //   482: istore 10
    //   484: goto -17 -> 467
    //   487: iload_0
    //   488: istore 5
    //   490: goto -142 -> 348
    //   493: astore_2
    //   494: iconst_0
    //   495: istore_3
    //   496: goto -160 -> 336
    //   499: iload_3
    //   500: istore 8
    //   502: goto -48 -> 454
    //
    // Exception table:
    //   from	to	target	type
    //   81	125	335	finally
    //   130	148	335	finally
    //   153	168	335	finally
    //   168	175	335	finally
    //   184	191	335	finally
    //   194	263	335	finally
    //   263	332	335	finally
    //   357	374	335	finally
    //   377	392	335	finally
    //   395	412	335	finally
    //   415	430	335	finally
    //   437	448	335	finally
    //   42	53	493	finally
  }

  // ERROR //
  public static boolean isVP8Available()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: iconst_m1
    //   3: getstatic 63	org/webrtc/videoengine/ViEOMXHelper:_vp8_available	Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual 854	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   9: if_icmpeq +26 -> 35
    //   12: getstatic 63	org/webrtc/videoengine/ViEOMXHelper:_vp8_available	Ljava/util/concurrent/atomic/AtomicInteger;
    //   15: invokevirtual 854	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   18: ifeq +11 -> 29
    //   21: iload_0
    //   22: istore 11
    //   24: iload 11
    //   26: istore_0
    //   27: iload_0
    //   28: ireturn
    //   29: iconst_0
    //   30: istore 11
    //   32: goto -8 -> 24
    //   35: getstatic 584	android/os/Build:PRODUCT	Ljava/lang/String;
    //   38: invokevirtual 587	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   41: astore_1
    //   42: getstatic 69	org/webrtc/videoengine/ViEOMXHelper:blacklistedModels	Ljava/util/Map;
    //   45: aload_1
    //   46: invokeinterface 856 2 0
    //   51: istore 6
    //   53: iload 6
    //   55: iconst_0
    //   56: ior
    //   57: istore_3
    //   58: iload_3
    //   59: ifeq +22 -> 81
    //   62: getstatic 63	org/webrtc/videoengine/ViEOMXHelper:_vp8_available	Ljava/util/concurrent/atomic/AtomicInteger;
    //   65: astore 10
    //   67: iload_3
    //   68: ifeq +5 -> 73
    //   71: iconst_0
    //   72: istore_0
    //   73: aload 10
    //   75: iload_0
    //   76: invokevirtual 859	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   79: iconst_0
    //   80: ireturn
    //   81: getstatic 77	org/webrtc/videoengine/ViEOMXHelper:whitelistedModels	Ljava/util/Map;
    //   84: aload_1
    //   85: invokeinterface 856 2 0
    //   90: ifeq +39 -> 129
    //   93: getstatic 84	org/webrtc/videoengine/ViEOMXHelper:vp8_colorspaces	Ljava/util/Set;
    //   96: getstatic 77	org/webrtc/videoengine/ViEOMXHelper:whitelistedModels	Ljava/util/Map;
    //   99: aload_1
    //   100: invokeinterface 570 2 0
    //   105: checkcast 142	org/webrtc/videoengine/ViEOMXHelper$OMXQuirks
    //   108: getfield 867	org/webrtc/videoengine/ViEOMXHelper$OMXQuirks:encoder	I
    //   111: invokestatic 675	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   114: invokeinterface 639 2 0
    //   119: pop
    //   120: getstatic 63	org/webrtc/videoengine/ViEOMXHelper:_vp8_available	Ljava/util/concurrent/atomic/AtomicInteger;
    //   123: iload_0
    //   124: invokevirtual 859	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   127: iload_0
    //   128: ireturn
    //   129: iload_3
    //   130: ifne +3 -> 133
    //   133: getstatic 63	org/webrtc/videoengine/ViEOMXHelper:_vp8_available	Ljava/util/concurrent/atomic/AtomicInteger;
    //   136: astore 7
    //   138: iload_3
    //   139: ifeq +19 -> 158
    //   142: iconst_0
    //   143: istore 8
    //   145: aload 7
    //   147: iload 8
    //   149: invokevirtual 859	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   152: iload_3
    //   153: ifeq -126 -> 27
    //   156: iconst_0
    //   157: ireturn
    //   158: iload_0
    //   159: istore 8
    //   161: goto -16 -> 145
    //   164: astore_2
    //   165: iconst_0
    //   166: istore_3
    //   167: getstatic 63	org/webrtc/videoengine/ViEOMXHelper:_vp8_available	Ljava/util/concurrent/atomic/AtomicInteger;
    //   170: astore 4
    //   172: iconst_0
    //   173: istore 5
    //   175: iload_3
    //   176: ifeq +12 -> 188
    //   179: aload 4
    //   181: iload 5
    //   183: invokevirtual 859	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   186: aload_2
    //   187: athrow
    //   188: iload_0
    //   189: istore 5
    //   191: goto -12 -> 179
    //   194: astore_2
    //   195: goto -28 -> 167
    //
    // Exception table:
    //   from	to	target	type
    //   42	53	164	finally
    //   81	120	194	finally
  }

  // ERROR //
  public static final void loadExternalQuirkLists(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: arraylength
    //   7: istore_1
    //   8: iconst_0
    //   9: istore_2
    //   10: iload_2
    //   11: iload_1
    //   12: if_icmpge -8 -> 4
    //   15: new 874	java/io/File
    //   18: dup
    //   19: aload_0
    //   20: iload_2
    //   21: aaload
    //   22: invokespecial 877	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore_3
    //   26: aload_3
    //   27: invokevirtual 880	java/io/File:exists	()Z
    //   30: ifne +9 -> 39
    //   33: iinc 2 1
    //   36: goto -26 -> 10
    //   39: new 882	android/util/JsonReader
    //   42: dup
    //   43: new 884	java/io/InputStreamReader
    //   46: dup
    //   47: new 886	java/io/FileInputStream
    //   50: dup
    //   51: aload_3
    //   52: invokespecial 889	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: invokespecial 892	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   58: invokespecial 895	android/util/JsonReader:<init>	(Ljava/io/Reader;)V
    //   61: astore 4
    //   63: aload 4
    //   65: iconst_1
    //   66: invokevirtual 899	android/util/JsonReader:setLenient	(Z)V
    //   69: aload 4
    //   71: invokevirtual 902	android/util/JsonReader:beginObject	()V
    //   74: aload 4
    //   76: invokevirtual 903	android/util/JsonReader:hasNext	()Z
    //   79: ifeq +15 -> 94
    //   82: aload 4
    //   84: invokevirtual 906	android/util/JsonReader:nextName	()Ljava/lang/String;
    //   87: astore 6
    //   89: aload 6
    //   91: ifnonnull +11 -> 102
    //   94: aload 4
    //   96: invokevirtual 909	android/util/JsonReader:endObject	()V
    //   99: goto -66 -> 33
    //   102: aload 6
    //   104: invokevirtual 587	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   107: astore 7
    //   109: ldc_w 911
    //   112: aload 7
    //   114: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   117: ifne +14 -> 131
    //   120: ldc_w 913
    //   123: aload 7
    //   125: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   128: ifeq +95 -> 223
    //   131: ldc_w 913
    //   134: aload 7
    //   136: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   139: ifeq +60 -> 199
    //   142: getstatic 69	org/webrtc/videoengine/ViEOMXHelper:blacklistedModels	Ljava/util/Map;
    //   145: astore 8
    //   147: ldc_w 913
    //   150: aload 7
    //   152: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   155: ifeq +52 -> 207
    //   158: getstatic 77	org/webrtc/videoengine/ViEOMXHelper:whitelistedModels	Ljava/util/Map;
    //   161: astore 9
    //   163: aload 4
    //   165: invokevirtual 916	android/util/JsonReader:beginArray	()V
    //   168: aload 4
    //   170: invokevirtual 903	android/util/JsonReader:hasNext	()Z
    //   173: istore 10
    //   175: iload 10
    //   177: ifeq +38 -> 215
    //   180: aload 4
    //   182: aload 8
    //   184: aload 9
    //   186: invokestatic 920	org/webrtc/videoengine/ViEOMXHelper$OMXQuirks:fromJSON	(Landroid/util/JsonReader;Ljava/util/Map;Ljava/util/Map;)Z
    //   189: istore 12
    //   191: iload 12
    //   193: ifeq -25 -> 168
    //   196: goto -28 -> 168
    //   199: getstatic 77	org/webrtc/videoengine/ViEOMXHelper:whitelistedModels	Ljava/util/Map;
    //   202: astore 8
    //   204: goto -57 -> 147
    //   207: getstatic 69	org/webrtc/videoengine/ViEOMXHelper:blacklistedModels	Ljava/util/Map;
    //   210: astore 9
    //   212: goto -49 -> 163
    //   215: aload 4
    //   217: invokevirtual 923	android/util/JsonReader:endArray	()V
    //   220: goto -146 -> 74
    //   223: ldc_w 925
    //   226: aload 7
    //   228: invokevirtual 929	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   231: ifeq +83 -> 314
    //   234: ldc_w 931
    //   237: aload 4
    //   239: invokevirtual 935	android/util/JsonReader:peek	()Landroid/util/JsonToken;
    //   242: invokevirtual 938	android/util/JsonToken:toString	()Ljava/lang/String;
    //   245: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   248: ifeq +55 -> 303
    //   251: aload 4
    //   253: invokevirtual 941	android/util/JsonReader:nextString	()Ljava/lang/String;
    //   256: astore 13
    //   258: bipush 10
    //   260: istore 14
    //   262: aload 13
    //   264: ldc_w 943
    //   267: invokevirtual 946	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   270: ifeq +20 -> 290
    //   273: aload 13
    //   275: ldc_w 943
    //   278: ldc_w 832
    //   281: invokevirtual 950	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   284: astore 13
    //   286: bipush 16
    //   288: istore 14
    //   290: aload 13
    //   292: iload 14
    //   294: invokestatic 954	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   297: putstatic 53	org/webrtc/videoengine/ViEOMXHelper:_h264_minimal_api_level	I
    //   300: goto -226 -> 74
    //   303: aload 4
    //   305: invokevirtual 957	android/util/JsonReader:nextInt	()I
    //   308: putstatic 53	org/webrtc/videoengine/ViEOMXHelper:_h264_minimal_api_level	I
    //   311: goto -237 -> 74
    //   314: aload 4
    //   316: invokevirtual 960	android/util/JsonReader:skipValue	()V
    //   319: goto -245 -> 74
    //   322: astore 5
    //   324: goto -291 -> 33
    //   327: astore 11
    //   329: goto -114 -> 215
    //
    // Exception table:
    //   from	to	target	type
    //   39	74	322	java/lang/Exception
    //   74	89	322	java/lang/Exception
    //   94	99	322	java/lang/Exception
    //   102	131	322	java/lang/Exception
    //   131	147	322	java/lang/Exception
    //   147	163	322	java/lang/Exception
    //   163	168	322	java/lang/Exception
    //   168	175	322	java/lang/Exception
    //   199	204	322	java/lang/Exception
    //   207	212	322	java/lang/Exception
    //   215	220	322	java/lang/Exception
    //   223	258	322	java/lang/Exception
    //   262	286	322	java/lang/Exception
    //   290	300	322	java/lang/Exception
    //   303	311	322	java/lang/Exception
    //   314	319	322	java/lang/Exception
    //   180	191	327	java/lang/Exception
  }

  private static void log(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
      Log.d("ViEOMXHelper", paramString);
  }

  public static native void notifyQuirksListChanged();

  private static int readIntFromJson(JsonReader paramJsonReader)
    throws IOException
  {
    if ("STRING".equals(paramJsonReader.peek().toString()))
    {
      String str = paramJsonReader.nextString();
      int i = 10;
      if (str.startsWith("0x"))
      {
        str = str.replaceFirst("0x", "");
        i = 16;
      }
      return Integer.parseInt(str, i);
    }
    return paramJsonReader.nextInt();
  }

  public static int[] vp8Colorspaces()
  {
    int[] arrayOfInt = new int[vp8_colorspaces.size()];
    Iterator localIterator = vp8_colorspaces.iterator();
    int k;
    for (int i = 0; localIterator.hasNext(); i = k)
    {
      int j = ((Integer)localIterator.next()).intValue();
      k = i + 1;
      arrayOfInt[i] = j;
    }
    return arrayOfInt;
  }

  public final class CustomColorFormats
  {
    public static final int COLOR_FormatNV12_as_NV21 = -1919698361;
    public static final int COLOR_FormatVendorExtension = 2141391875;

    public CustomColorFormats()
    {
    }
  }

  static enum LookupMode
  {
    static
    {
      ENCODER = new LookupMode("ENCODER", 1);
      DECODER = new LookupMode("DECODER", 2);
      LookupMode[] arrayOfLookupMode = new LookupMode[3];
      arrayOfLookupMode[0] = ENCODER_AND_DECODER;
      arrayOfLookupMode[1] = ENCODER;
      arrayOfLookupMode[2] = DECODER;
    }
  }

  public static class MimeTypes
  {
    public static final String H264_MIME = "video/avc";
    public static final String VP8_MIME = "video/x-vnd.on2.vp8";
    public static final String VP9_MIME = "video/x-vnd.on2.vp9";
  }

  static class OMXNode
  {

    @ViENative
    private boolean cbr_supported = false;

    @ViENative
    private final SortedSet<Integer> colorspaces = new TreeSet();

    @ViENative
    private boolean cq_supported = false;
    public int default_bitrate_mode = 2;
    public int default_color_format = 19;
    public int default_complexity = 0;
    public int default_framerate = this.max_framerate;
    public int default_height = 0;
    public int default_i_frame_interval = 30;
    public int default_profile = 1;
    public int default_width = 0;
    public int h264_baseline_avclevel = 0;
    public boolean h264_baseline_supported = false;
    public boolean h264_complexity_supported = false;

    @ViENative
    private int height_alignment = 0;

    @ViENative
    public final boolean isEncoder;

    @ViENative
    private int max_bitrate = 2147483647;

    @ViENative
    private int max_complexity = 0;

    @ViENative
    private int max_framerate = 30;

    @ViENative
    public final String mimetype;

    @ViENative
    private int min_bitrate = 0;

    @ViENative
    private int min_complexity = 0;

    @ViENative
    private int min_framerate = 0;

    @ViENative
    public final String name;

    @ViENative
    private boolean vbr_supported = false;
    private Object videoCapabilities = null;

    @ViENative
    private int width_alignment = 0;

    public OMXNode(String paramString1, String paramString2, boolean paramBoolean)
    {
      this.mimetype = paramString1;
      this.name = paramString2;
      this.isEncoder = paramBoolean;
    }

    @TargetApi(21)
    private boolean checkSizeSupported21(int paramInt1, int paramInt2)
    {
      return ((MediaCodecInfo.VideoCapabilities)this.videoCapabilities).isSizeSupported(paramInt1, paramInt2);
    }

    public void addSupportedColorspace(int paramInt)
    {
      if (this.colorspaces.add(Integer.valueOf(paramInt)))
        this.default_color_format = ((Integer)this.colorspaces.first()).intValue();
    }

    public boolean equals(Object paramObject)
    {
      return (paramObject != null) && ((paramObject instanceof OMXNode)) && (paramObject.hashCode() == hashCode());
    }

    public int hashCode()
    {
      return this.name.hashCode();
    }

    public boolean isSizeSupported(int paramInt1, int paramInt2)
    {
      if ((this.videoCapabilities == null) && (Build.VERSION.SDK_INT < 21))
        return true;
      if (this.videoCapabilities == null)
        return false;
      return checkSizeSupported21(paramInt1, paramInt2);
    }

    public int[] supportedColorspaces()
    {
      int[] arrayOfInt = new int[this.colorspaces.size()];
      Iterator localIterator = this.colorspaces.iterator();
      int k;
      for (int i = 0; localIterator.hasNext(); i = k)
      {
        int j = ((Integer)localIterator.next()).intValue();
        k = i + 1;
        arrayOfInt[i] = j;
      }
      return arrayOfInt;
    }

    public String toString()
    {
      return this.name;
    }
  }

  static class OMXQuirks
  {

    @ViENative
    final int decoder;

    @ViENative
    private int decoderInputTimeout = -2;

    @ViENative
    private int decoderOutputTimeout = -2;

    @ViENative
    final boolean direct_input;

    @ViENative
    final int encoder;

    @ViENative
    private int encoderBitRate = -1;

    @ViENative
    private int encoderFrameRate = -1;

    @ViENative
    private int encoderInputTimeout = -2;

    @ViENative
    private int encoderOutputTimeout = -2;

    @ViENative
    final String forcedDecoderType;

    @ViENative
    final String forcedEncoderType;

    @ViENative
    final int forcedOrientation = -1;

    public OMXQuirks(int paramInt)
    {
      this.decoder = paramInt;
      this.encoder = paramInt;
      this.forcedEncoderType = null;
      this.forcedDecoderType = null;
      if (2130708361 == this.encoder);
      for (boolean bool = true; ; bool = false)
      {
        this.direct_input = bool;
        return;
      }
    }

    public OMXQuirks(int paramInt1, int paramInt2)
    {
      this.encoder = paramInt1;
      this.decoder = paramInt2;
      this.forcedEncoderType = null;
      this.forcedDecoderType = null;
      if (2130708361 == paramInt1);
      for (boolean bool = true; ; bool = false)
      {
        this.direct_input = bool;
        return;
      }
    }

    public OMXQuirks(int paramInt1, int paramInt2, String paramString)
    {
      this.encoder = paramInt1;
      this.decoder = paramInt2;
      this.forcedEncoderType = paramString;
      this.forcedDecoderType = null;
      if (2130708361 == paramInt1);
      for (boolean bool = true; ; bool = false)
      {
        this.direct_input = bool;
        return;
      }
    }

    public OMXQuirks(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      this.encoder = paramInt1;
      this.decoder = paramInt2;
      this.forcedEncoderType = paramString1;
      this.forcedDecoderType = paramString2;
      if (2130708361 == paramInt1);
      for (boolean bool = true; ; bool = false)
      {
        this.direct_input = bool;
        return;
      }
    }

    public OMXQuirks(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
    {
      this.encoder = paramInt1;
      this.decoder = paramInt2;
      this.forcedEncoderType = paramString1;
      this.forcedDecoderType = paramString2;
      this.direct_input = paramBoolean;
    }

    public OMXQuirks(int paramInt, String paramString)
    {
      this.decoder = paramInt;
      this.encoder = paramInt;
      this.forcedEncoderType = paramString;
      this.forcedDecoderType = null;
      if (2130708361 == this.encoder);
      for (boolean bool = true; ; bool = false)
      {
        this.direct_input = bool;
        return;
      }
    }

    public static boolean fromJSON(JsonReader paramJsonReader, Map<String, OMXQuirks> paramMap1, Map<String, OMXQuirks> paramMap2)
      throws Exception
    {
      Object localObject1 = null;
      int i = -1;
      int j = -1;
      int k = 0;
      boolean bool1 = false;
      Object localObject2 = null;
      Object localObject3 = null;
      int m = -2;
      int n = -2;
      int i1 = -2;
      int i2 = -2;
      int i3 = -1;
      int i4 = -1;
      paramJsonReader.beginObject();
      while (true)
      {
        Object localObject4;
        int i7;
        int i8;
        Object localObject5;
        int i6;
        int i10;
        int i11;
        Object localObject6;
        int i12;
        int i13;
        int i14;
        boolean bool2;
        int i15;
        if (paramJsonReader.hasNext())
        {
          String str1 = paramJsonReader.nextName();
          if (str1 != null)
          {
            String str2 = str1.toLowerCase();
            try
            {
              if ("product".equals(str2))
              {
                String str5 = paramJsonReader.nextString();
                int i35 = i4;
                localObject4 = localObject3;
                i7 = n;
                i8 = j;
                localObject5 = str5;
                i6 = i35;
                int i36 = m;
                i10 = i;
                i11 = i3;
                localObject6 = localObject2;
                i12 = i1;
                i13 = k;
                i14 = i2;
                bool2 = bool1;
                i15 = i36;
              }
              else if ("encoder_colorspace".equals(str2))
              {
                int i33 = ViEOMXHelper.readIntFromJson(paramJsonReader);
                i6 = i4;
                localObject4 = localObject3;
                i7 = n;
                i8 = j;
                localObject5 = localObject1;
                int i34 = m;
                i10 = i33;
                i11 = i3;
                localObject6 = localObject2;
                i12 = i1;
                i13 = k;
                i14 = i2;
                bool2 = bool1;
                i15 = i34;
              }
              else if ("decoder_colorspace".equals(str2))
              {
                int i30 = ViEOMXHelper.readIntFromJson(paramJsonReader);
                localObject5 = localObject1;
                int i31 = i3;
                localObject6 = localObject2;
                i12 = i1;
                i13 = k;
                i14 = i2;
                bool2 = bool1;
                i15 = m;
                i10 = i;
                i11 = i31;
                int i32 = n;
                i8 = i30;
                i6 = i4;
                localObject4 = localObject3;
                i7 = i32;
              }
              else if ("direct_rendering".equals(str2))
              {
                boolean bool4 = paramJsonReader.nextBoolean();
                i14 = i2;
                bool2 = bool1;
                i15 = m;
                i10 = i;
                i11 = i3;
                localObject6 = localObject2;
                i12 = i1;
                i13 = bool4;
                i6 = i4;
                localObject4 = localObject3;
                i7 = n;
                i8 = j;
                localObject5 = localObject1;
              }
              else if ("direct_input".equals(str2))
              {
                boolean bool3 = paramJsonReader.nextBoolean();
                i6 = i4;
                localObject4 = localObject3;
                i7 = n;
                i8 = j;
                localObject5 = localObject1;
                int i29 = m;
                i10 = i;
                i11 = i3;
                localObject6 = localObject2;
                i12 = i1;
                i13 = k;
                i14 = i2;
                bool2 = bool3;
                i15 = i29;
              }
              else if ("encoder_id".equals(str2))
              {
                String str4 = paramJsonReader.nextString();
                i6 = i4;
                localObject4 = localObject3;
                i7 = n;
                i8 = j;
                localObject5 = localObject1;
                int i28 = m;
                i10 = i;
                i11 = i3;
                localObject6 = str4;
                i12 = i1;
                i13 = k;
                i14 = i2;
                bool2 = bool1;
                i15 = i28;
              }
              else if ("decoder_id".equals(str2))
              {
                String str3 = paramJsonReader.nextString();
                i6 = i4;
                localObject4 = str3;
                i7 = n;
                i8 = j;
                localObject5 = localObject1;
                int i27 = m;
                i10 = i;
                i11 = i3;
                localObject6 = localObject2;
                i12 = i1;
                i13 = k;
                i14 = i2;
                bool2 = bool1;
                i15 = i27;
              }
              else if ("encoder_input_timeout".equals(str2))
              {
                int i26 = ViEOMXHelper.readIntFromJson(paramJsonReader);
                i10 = i;
                i11 = i3;
                localObject6 = localObject2;
                i12 = i1;
                i13 = k;
                i14 = i2;
                bool2 = bool1;
                i15 = i26;
                i6 = i4;
                localObject4 = localObject3;
                i7 = n;
                i8 = j;
                localObject5 = localObject1;
              }
              else if ("encoder_output_timeout".equals(str2))
              {
                int i23 = ViEOMXHelper.readIntFromJson(paramJsonReader);
                i8 = j;
                localObject5 = localObject1;
                int i24 = i2;
                bool2 = bool1;
                i15 = m;
                i10 = i;
                i11 = i3;
                localObject6 = localObject2;
                i12 = i1;
                i13 = k;
                i14 = i24;
                int i25 = i4;
                localObject4 = localObject3;
                i7 = i23;
                i6 = i25;
              }
              else if ("decoder_input_timeout".equals(str2))
              {
                int i22 = ViEOMXHelper.readIntFromJson(paramJsonReader);
                i13 = k;
                i14 = i2;
                bool2 = bool1;
                i15 = m;
                i10 = i;
                i11 = i3;
                localObject6 = localObject2;
                i12 = i22;
                i6 = i4;
                localObject4 = localObject3;
                i7 = n;
                i8 = j;
                localObject5 = localObject1;
              }
              else if ("decoder_output_timeout".equals(str2))
              {
                int i21 = ViEOMXHelper.readIntFromJson(paramJsonReader);
                bool2 = bool1;
                i15 = m;
                i10 = i;
                i11 = i3;
                localObject6 = localObject2;
                i12 = i1;
                i13 = k;
                i14 = i21;
                i6 = i4;
                localObject4 = localObject3;
                i7 = n;
                i8 = j;
                localObject5 = localObject1;
              }
              else if ("encoder_framerate".equals(str2))
              {
                int i20 = ViEOMXHelper.readIntFromJson(paramJsonReader);
                localObject6 = localObject2;
                i12 = i1;
                i13 = k;
                i14 = i2;
                bool2 = bool1;
                i15 = m;
                i10 = i;
                i11 = i20;
                i6 = i4;
                localObject4 = localObject3;
                i7 = n;
                i8 = j;
                localObject5 = localObject1;
              }
              else if ("encoder_bitrate".equals(str2))
              {
                int i18 = ViEOMXHelper.readIntFromJson(paramJsonReader);
                i6 = i18;
                localObject4 = localObject3;
                i7 = n;
                i8 = j;
                localObject5 = localObject1;
                int i19 = m;
                i10 = i;
                i11 = i3;
                localObject6 = localObject2;
                i12 = i1;
                i13 = k;
                i14 = i2;
                bool2 = bool1;
                i15 = i19;
              }
            }
            catch (Exception localException)
            {
              i6 = i4;
              localObject4 = localObject3;
              i7 = n;
              i8 = j;
              localObject5 = localObject1;
              int i9 = m;
              i10 = i;
              i11 = i3;
              localObject6 = localObject2;
              i12 = i1;
              i13 = k;
              i14 = i2;
              bool2 = bool1;
              i15 = i9;
            }
          }
        }
        else
        {
          paramJsonReader.endObject();
          if (localObject1 != null)
            if (k == 0)
              break label1186;
          label1186: for (int i5 = 2141391875; ; i5 = j)
          {
            OMXQuirks localOMXQuirks = new OMXQuirks(i, i5, (String)localObject2, (String)localObject3, bool1);
            localOMXQuirks.encoderInputTimeout = m;
            localOMXQuirks.encoderOutputTimeout = n;
            localOMXQuirks.decoderInputTimeout = i1;
            localOMXQuirks.decoderOutputTimeout = i2;
            localOMXQuirks.encoderFrameRate = i3;
            localOMXQuirks.encoderBitRate = i4;
            paramMap1.put(localObject1, localOMXQuirks);
            paramMap2.remove(localObject1);
            return true;
            return false;
          }
          i6 = i4;
          localObject4 = localObject3;
          i7 = n;
          i8 = j;
          localObject5 = localObject1;
          int i17 = m;
          i10 = i;
          i11 = i3;
          localObject6 = localObject2;
          i12 = i1;
          i13 = k;
          i14 = i2;
          bool2 = bool1;
          i15 = i17;
          localObject1 = localObject5;
          j = i8;
          n = i7;
          localObject3 = localObject4;
          i4 = i6;
          int i16 = i15;
          bool1 = bool2;
          i2 = i14;
          k = i13;
          i1 = i12;
          localObject2 = localObject6;
          i3 = i11;
          i = i10;
          m = i16;
        }
      }
    }
  }

  public static class OpenH264DownloadDescriptor
  {
    public final String downloadUri;
    public final String md5;

    OpenH264DownloadDescriptor(String paramString1, String paramString2)
    {
      this.downloadUri = paramString1;
      this.md5 = paramString2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.videoengine.ViEOMXHelper
 * JD-Core Version:    0.6.2
 */