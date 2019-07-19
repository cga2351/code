package com.google.android.exoplayer2.d;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
public final class d
{
  private static final Pattern a = Pattern.compile("^\\D?(\\d+)$");
  private static final f b = new f(null);
  private static final HashMap<a, List<a>> c = new HashMap();
  private static final SparseIntArray d;
  private static final SparseIntArray e;
  private static final Map<String, Integer> f;
  private static final SparseIntArray g;
  private static int h = -1;

  static
  {
    d = new SparseIntArray();
    d.put(66, 1);
    d.put(77, 2);
    d.put(88, 4);
    d.put(100, 8);
    d.put(110, 16);
    d.put(122, 32);
    d.put(244, 64);
    e = new SparseIntArray();
    e.put(10, 1);
    e.put(11, 4);
    e.put(12, 8);
    e.put(13, 16);
    e.put(20, 32);
    e.put(21, 64);
    e.put(22, 128);
    e.put(30, 256);
    e.put(31, 512);
    e.put(32, 1024);
    e.put(40, 2048);
    e.put(41, 4096);
    e.put(42, 8192);
    e.put(50, 16384);
    e.put(51, 32768);
    e.put(52, 65536);
    f = new HashMap();
    f.put("L30", Integer.valueOf(1));
    f.put("L60", Integer.valueOf(4));
    f.put("L63", Integer.valueOf(16));
    f.put("L90", Integer.valueOf(64));
    f.put("L93", Integer.valueOf(256));
    f.put("L120", Integer.valueOf(1024));
    f.put("L123", Integer.valueOf(4096));
    f.put("L150", Integer.valueOf(16384));
    f.put("L153", Integer.valueOf(65536));
    f.put("L156", Integer.valueOf(262144));
    f.put("L180", Integer.valueOf(1048576));
    f.put("L183", Integer.valueOf(4194304));
    f.put("L186", Integer.valueOf(16777216));
    f.put("H30", Integer.valueOf(2));
    f.put("H60", Integer.valueOf(8));
    f.put("H63", Integer.valueOf(32));
    f.put("H90", Integer.valueOf(128));
    f.put("H93", Integer.valueOf(512));
    f.put("H120", Integer.valueOf(2048));
    f.put("H123", Integer.valueOf(8192));
    f.put("H150", Integer.valueOf(32768));
    f.put("H153", Integer.valueOf(131072));
    f.put("H156", Integer.valueOf(524288));
    f.put("H180", Integer.valueOf(2097152));
    f.put("H183", Integer.valueOf(8388608));
    f.put("H186", Integer.valueOf(33554432));
    g = new SparseIntArray();
    g.put(1, 1);
    g.put(2, 2);
    g.put(3, 3);
    g.put(4, 4);
    g.put(5, 5);
    g.put(6, 6);
    g.put(17, 17);
    g.put(20, 20);
    g.put(23, 23);
    g.put(29, 29);
    g.put(39, 39);
    g.put(42, 42);
  }

  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return -1;
    case 1:
    case 2:
      return 25344;
    case 8:
    case 16:
    case 32:
      return 101376;
    case 64:
      return 202752;
    case 128:
    case 256:
      return 414720;
    case 512:
      return 921600;
    case 1024:
      return 1310720;
    case 2048:
    case 4096:
      return 2097152;
    case 8192:
      return 2228224;
    case 16384:
      return 5652480;
    case 32768:
    case 65536:
    }
    return 9437184;
  }

  public static Pair<Integer, Integer> a(String paramString)
  {
    if (paramString == null)
      return null;
    String[] arrayOfString = paramString.split("\\.");
    String str = arrayOfString[0];
    label72: int i;
    switch (str.hashCode())
    {
    default:
      i = -1;
    case 3199032:
    case 3214780:
    case 3006243:
    case 3006244:
    case 3356560:
    }
    while (true)
      switch (i)
      {
      default:
        return null;
      case 0:
      case 1:
        return a(paramString, arrayOfString);
        if (!str.equals("hev1"))
          break label72;
        i = 0;
        continue;
        if (!str.equals("hvc1"))
          break label72;
        i = 1;
        continue;
        if (!str.equals("avc1"))
          break label72;
        i = 2;
        continue;
        if (!str.equals("avc2"))
          break label72;
        i = 3;
        continue;
        if (!str.equals("mp4a"))
          break label72;
        i = 4;
      case 2:
      case 3:
      case 4:
      }
    return b(paramString, arrayOfString);
    return c(paramString, arrayOfString);
  }

  private static Pair<Integer, Integer> a(String paramString, String[] paramArrayOfString)
  {
    if (paramArrayOfString.length < 4)
    {
      l.c("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + paramString);
      return null;
    }
    Matcher localMatcher = a.matcher(paramArrayOfString[1]);
    if (!localMatcher.matches())
    {
      l.c("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + paramString);
      return null;
    }
    String str = localMatcher.group(1);
    if ("1".equals(str));
    Integer localInteger;
    for (int i = 1; ; i = 2)
    {
      localInteger = (Integer)f.get(paramArrayOfString[3]);
      if (localInteger != null)
        break label185;
      l.c("MediaCodecUtil", "Unknown HEVC level string: " + localMatcher.group(1));
      return null;
      if (!"2".equals(str))
        break;
    }
    l.c("MediaCodecUtil", "Unknown HEVC profile string: " + str);
    return null;
    label185: return new Pair(Integer.valueOf(i), localInteger);
  }

  public static a a()
    throws d.b
  {
    a locala = a("audio/raw", false);
    if (locala == null)
      return null;
    return a.a(locala.a);
  }

  public static a a(String paramString, boolean paramBoolean)
    throws d.b
  {
    List localList = b(paramString, paramBoolean);
    if (localList.isEmpty())
      return null;
    return (a)localList.get(0);
  }

  private static ArrayList<a> a(a parama, c paramc, String paramString)
    throws d.b
  {
    while (true)
    {
      int j;
      String str2;
      int m;
      String str3;
      try
      {
        ArrayList localArrayList = new ArrayList();
        String str1 = parama.a;
        int i = paramc.a();
        boolean bool1 = paramc.b();
        j = 0;
        MediaCodecInfo localMediaCodecInfo;
        if (j < i)
        {
          localMediaCodecInfo = paramc.a(j);
          str2 = localMediaCodecInfo.getName();
          if (!a(localMediaCodecInfo, str2, bool1, paramString))
            break label346;
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int k = arrayOfString.length;
          m = 0;
          if (m >= k)
            break label346;
          str3 = arrayOfString[m];
          boolean bool2 = str3.equalsIgnoreCase(str1);
          if (!bool2)
            break label352;
        }
        try
        {
          MediaCodecInfo.CodecCapabilities localCodecCapabilities = localMediaCodecInfo.getCapabilitiesForType(str3);
          boolean bool3 = paramc.a(str1, localCodecCapabilities);
          boolean bool4 = b(str2);
          if (((bool1) && (parama.b == bool3)) || ((!bool1) && (!parama.b)))
          {
            localArrayList.add(a.a(str2, str1, localCodecCapabilities, bool4, false));
            break label352;
          }
          if ((bool1) || (!bool3))
            break label352;
          localArrayList.add(a.a(str2 + ".secure", str1, localCodecCapabilities, bool4, true));
          return localArrayList;
        }
        catch (Exception localException2)
        {
          if (ag.a > 23)
            break label300;
        }
        if (!localArrayList.isEmpty())
          l.d("MediaCodecUtil", "Skipping codec " + str2 + " (failed to query capabilities)");
      }
      catch (Exception localException1)
      {
        throw new b(localException1, null);
      }
      label300: l.d("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str3 + ")");
      throw localException2;
      label346: j++;
      continue;
      label352: m++;
    }
  }

  private static void a(String paramString, List<a> paramList)
  {
    if ("audio/raw".equals(paramString))
      Collections.sort(paramList, b);
  }

  private static boolean a(MediaCodecInfo paramMediaCodecInfo, String paramString1, boolean paramBoolean, String paramString2)
  {
    if ((paramMediaCodecInfo.isEncoder()) || ((!paramBoolean) && (paramString1.endsWith(".secure"))));
    while (((ag.a < 21) && (("CIPAACDecoder".equals(paramString1)) || ("CIPMP3Decoder".equals(paramString1)) || ("CIPVorbisDecoder".equals(paramString1)) || ("CIPAMRNBDecoder".equals(paramString1)) || ("AACDecoder".equals(paramString1)) || ("MP3Decoder".equals(paramString1)))) || ((ag.a < 18) && ("OMX.SEC.MP3.Decoder".equals(paramString1))) || (("OMX.SEC.mp3.dec".equals(paramString1)) && ((ag.d.startsWith("GT-I9152")) || (ag.d.startsWith("GT-I9515")) || (ag.d.startsWith("GT-P5220")) || (ag.d.startsWith("GT-S7580")) || (ag.d.startsWith("SM-G350")) || (ag.d.startsWith("SM-G386")) || (ag.d.startsWith("SM-T231")) || (ag.d.startsWith("SM-T530")) || (ag.d.startsWith("SCH-I535")) || (ag.d.startsWith("SPH-L710")))) || (("OMX.brcm.audio.mp3.decoder".equals(paramString1)) && ((ag.d.startsWith("GT-I9152")) || (ag.d.startsWith("GT-S7580")) || (ag.d.startsWith("SM-G350")))) || ((ag.a < 18) && ("OMX.MTK.AUDIO.DECODER.AAC".equals(paramString1)) && (("a70".equals(ag.b)) || (("Xiaomi".equals(ag.c)) && (ag.b.startsWith("HM"))))) || ((ag.a == 16) && ("OMX.qcom.audio.decoder.mp3".equals(paramString1)) && (("dlxu".equals(ag.b)) || ("protou".equals(ag.b)) || ("ville".equals(ag.b)) || ("villeplus".equals(ag.b)) || ("villec2".equals(ag.b)) || (ag.b.startsWith("gee")) || ("C6602".equals(ag.b)) || ("C6603".equals(ag.b)) || ("C6606".equals(ag.b)) || ("C6616".equals(ag.b)) || ("L36h".equals(ag.b)) || ("SO-02E".equals(ag.b)))) || ((ag.a == 16) && ("OMX.qcom.audio.decoder.aac".equals(paramString1)) && (("C1504".equals(ag.b)) || ("C1505".equals(ag.b)) || ("C1604".equals(ag.b)) || ("C1605".equals(ag.b)))) || ((ag.a < 24) && (("OMX.SEC.aac.dec".equals(paramString1)) || ("OMX.Exynos.AAC.Decoder".equals(paramString1))) && ("samsung".equals(ag.c)) && ((ag.b.startsWith("zeroflte")) || (ag.b.startsWith("zerolte")) || (ag.b.startsWith("zenlte")) || ("SC-05G".equals(ag.b)) || ("marinelteatt".equals(ag.b)) || ("404SC".equals(ag.b)) || ("SC-04G".equals(ag.b)) || ("SCV31".equals(ag.b)))) || ((ag.a <= 19) && ("OMX.SEC.vp8.dec".equals(paramString1)) && ("samsung".equals(ag.c)) && ((ag.b.startsWith("d2")) || (ag.b.startsWith("serrano")) || (ag.b.startsWith("jflte")) || (ag.b.startsWith("santos")) || (ag.b.startsWith("t0")))) || ((ag.a <= 19) && (ag.b.startsWith("jflte")) && ("OMX.qcom.video.decoder.vp8".equals(paramString1))) || (("audio/eac3-joc".equals(paramString2)) && ("OMX.MTK.AUDIO.DECODER.DSPAC3".equals(paramString1))))
      return false;
    return true;
  }

  public static int b()
    throws d.b
  {
    int i;
    int k;
    if (h == -1)
    {
      a locala = a("video/avc", false);
      i = 0;
      if (locala != null)
      {
        MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = locala.a();
        int j = arrayOfCodecProfileLevel.length;
        k = 0;
        while (i < j)
        {
          k = Math.max(a(arrayOfCodecProfileLevel[i].level), k);
          i++;
        }
        if (ag.a < 21)
          break label88;
      }
    }
    label88: for (int m = 345600; ; m = 172800)
    {
      i = Math.max(k, m);
      h = i;
      return h;
    }
  }

  private static Pair<Integer, Integer> b(String paramString, String[] paramArrayOfString)
  {
    if (paramArrayOfString.length < 2)
    {
      l.c("MediaCodecUtil", "Ignoring malformed AVC codec string: " + paramString);
      return null;
    }
    Integer localInteger2;
    int i;
    try
    {
      Integer localInteger1;
      Integer localInteger3;
      if (paramArrayOfString[1].length() == 6)
      {
        localInteger1 = Integer.valueOf(Integer.parseInt(paramArrayOfString[1].substring(0, 2), 16));
        localInteger3 = Integer.valueOf(Integer.parseInt(paramArrayOfString[1].substring(4), 16));
      }
      for (localInteger2 = localInteger3; ; localInteger2 = Integer.valueOf(Integer.parseInt(paramArrayOfString[2])))
      {
        i = d.get(localInteger1.intValue(), -1);
        if (i != -1)
          break label213;
        l.c("MediaCodecUtil", "Unknown AVC profile: " + localInteger1);
        return null;
        if (paramArrayOfString.length < 3)
          break;
        localInteger1 = Integer.valueOf(Integer.parseInt(paramArrayOfString[1]));
      }
      l.c("MediaCodecUtil", "Ignoring malformed AVC codec string: " + paramString);
      return null;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      l.c("MediaCodecUtil", "Ignoring malformed AVC codec string: " + paramString);
      return null;
    }
    label213: int j = e.get(localInteger2.intValue(), -1);
    if (j == -1)
    {
      l.c("MediaCodecUtil", "Unknown AVC level: " + localInteger2);
      return null;
    }
    return new Pair(Integer.valueOf(i), Integer.valueOf(j));
  }

  public static List<a> b(String paramString, boolean paramBoolean)
    throws d.b
  {
    while (true)
    {
      d locald;
      ArrayList localArrayList;
      try
      {
        a locala = new a(paramString, paramBoolean);
        List localList = (List)c.get(locala);
        if (localList != null)
          return localList;
        if (ag.a >= 21)
        {
          localObject2 = new e(paramBoolean);
          localObject3 = a(locala, (c)localObject2, paramString);
          if ((paramBoolean) && (((ArrayList)localObject3).isEmpty()) && (21 <= ag.a) && (ag.a <= 23))
          {
            locald = new d(null);
            localArrayList = a(locala, locald, paramString);
            if (localArrayList.isEmpty())
              break label248;
            l.c("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + paramString + ". Assuming: " + ((a)localArrayList.get(0)).a);
            break label248;
          }
          if ("audio/eac3-joc".equals(paramString))
            ((ArrayList)localObject3).addAll(a(new a("audio/eac3", locala.b), (c)localObject2, paramString));
          a(paramString, (List)localObject3);
          localList = Collections.unmodifiableList((List)localObject3);
          c.put(locala, localList);
          continue;
        }
      }
      finally
      {
      }
      Object localObject2 = new d(null);
      continue;
      label248: Object localObject3 = localArrayList;
      localObject2 = locald;
    }
  }

  private static boolean b(String paramString)
  {
    return (ag.a <= 22) && (("ODROID-XU3".equals(ag.d)) || ("Nexus 10".equals(ag.d))) && (("OMX.Exynos.AVC.Decoder".equals(paramString)) || ("OMX.Exynos.AVC.Decoder.secure".equals(paramString)));
  }

  private static Pair<Integer, Integer> c(String paramString, String[] paramArrayOfString)
  {
    if (paramArrayOfString.length != 3)
      l.c("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + paramString);
    while (true)
    {
      return null;
      try
      {
        if ("audio/mp4a-latm".equals(o.a(Integer.parseInt(paramArrayOfString[1], 16))))
        {
          int i = Integer.parseInt(paramArrayOfString[2]);
          int j = g.get(i, -1);
          if (j != -1)
          {
            Pair localPair = new Pair(Integer.valueOf(j), Integer.valueOf(0));
            return localPair;
          }
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        l.c("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + paramString);
      }
    }
    return null;
  }

  private static final class a
  {
    public final String a;
    public final boolean b;

    public a(String paramString, boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramBoolean;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      a locala;
      do
      {
        return true;
        if ((paramObject == null) || (paramObject.getClass() != a.class))
          return false;
        locala = (a)paramObject;
      }
      while ((TextUtils.equals(this.a, locala.a)) && (this.b == locala.b));
      return false;
    }

    public int hashCode()
    {
      int i;
      int j;
      if (this.a == null)
      {
        i = 0;
        j = 31 * (i + 31);
        if (!this.b)
          break label43;
      }
      label43: for (int k = 1231; ; k = 1237)
      {
        return k + j;
        i = this.a.hashCode();
        break;
      }
    }
  }

  public static class b extends Exception
  {
    private b(Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }

  private static abstract interface c
  {
    public abstract int a();

    public abstract MediaCodecInfo a(int paramInt);

    public abstract boolean a(String paramString, MediaCodecInfo.CodecCapabilities paramCodecCapabilities);

    public abstract boolean b();
  }

  private static final class d
    implements d.c
  {
    public int a()
    {
      return MediaCodecList.getCodecCount();
    }

    public MediaCodecInfo a(int paramInt)
    {
      return MediaCodecList.getCodecInfoAt(paramInt);
    }

    public boolean a(String paramString, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
    {
      return "video/avc".equals(paramString);
    }

    public boolean b()
    {
      return false;
    }
  }

  @TargetApi(21)
  private static final class e
    implements d.c
  {
    private final int a;
    private MediaCodecInfo[] b;

    public e(boolean paramBoolean)
    {
      if (paramBoolean);
      for (int i = 1; ; i = 0)
      {
        this.a = i;
        return;
      }
    }

    private void c()
    {
      if (this.b == null)
        this.b = new MediaCodecList(this.a).getCodecInfos();
    }

    public int a()
    {
      c();
      return this.b.length;
    }

    public MediaCodecInfo a(int paramInt)
    {
      c();
      return this.b[paramInt];
    }

    public boolean a(String paramString, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
    {
      return paramCodecCapabilities.isFeatureSupported("secure-playback");
    }

    public boolean b()
    {
      return true;
    }
  }

  private static final class f
    implements Comparator<a>
  {
    private static int a(a parama)
    {
      String str = parama.a;
      if ((str.startsWith("OMX.google")) || (str.startsWith("c2.android")))
        return -1;
      if ((ag.a < 26) && (str.equals("OMX.MTK.AUDIO.DECODER.RAW")))
        return 1;
      return 0;
    }

    public int a(a parama1, a parama2)
    {
      return a(parama1) - a(parama2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.d.d
 * JD-Core Version:    0.6.2
 */