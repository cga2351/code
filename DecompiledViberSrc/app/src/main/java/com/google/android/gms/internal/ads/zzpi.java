package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
public final class zzpi
{
  private static final zzpd zzbho = zzpd.zzbc("OMX.google.raw.decoder");
  private static final Pattern zzbhp = Pattern.compile("^\\D?(\\d+)$");
  private static final HashMap<zza, List<zzpd>> zzbhq = new HashMap();
  private static final SparseIntArray zzbhr;
  private static final SparseIntArray zzbhs;
  private static final Map<String, Integer> zzbht;
  private static int zzbhu = -1;

  static
  {
    SparseIntArray localSparseIntArray1 = new SparseIntArray();
    zzbhr = localSparseIntArray1;
    localSparseIntArray1.put(66, 1);
    zzbhr.put(77, 2);
    zzbhr.put(88, 4);
    zzbhr.put(100, 8);
    SparseIntArray localSparseIntArray2 = new SparseIntArray();
    zzbhs = localSparseIntArray2;
    localSparseIntArray2.put(10, 1);
    zzbhs.put(11, 4);
    zzbhs.put(12, 8);
    zzbhs.put(13, 16);
    zzbhs.put(20, 32);
    zzbhs.put(21, 64);
    zzbhs.put(22, 128);
    zzbhs.put(30, 256);
    zzbhs.put(31, 512);
    zzbhs.put(32, 1024);
    zzbhs.put(40, 2048);
    zzbhs.put(41, 4096);
    zzbhs.put(42, 8192);
    zzbhs.put(50, 16384);
    zzbhs.put(51, 32768);
    zzbhs.put(52, 65536);
    HashMap localHashMap = new HashMap();
    zzbht = localHashMap;
    localHashMap.put("L30", Integer.valueOf(1));
    zzbht.put("L60", Integer.valueOf(4));
    zzbht.put("L63", Integer.valueOf(16));
    zzbht.put("L90", Integer.valueOf(64));
    zzbht.put("L93", Integer.valueOf(256));
    zzbht.put("L120", Integer.valueOf(1024));
    zzbht.put("L123", Integer.valueOf(4096));
    zzbht.put("L150", Integer.valueOf(16384));
    zzbht.put("L153", Integer.valueOf(65536));
    zzbht.put("L156", Integer.valueOf(262144));
    zzbht.put("L180", Integer.valueOf(1048576));
    zzbht.put("L183", Integer.valueOf(4194304));
    zzbht.put("L186", Integer.valueOf(16777216));
    zzbht.put("H30", Integer.valueOf(2));
    zzbht.put("H60", Integer.valueOf(8));
    zzbht.put("H63", Integer.valueOf(32));
    zzbht.put("H90", Integer.valueOf(128));
    zzbht.put("H93", Integer.valueOf(512));
    zzbht.put("H120", Integer.valueOf(2048));
    zzbht.put("H123", Integer.valueOf(8192));
    zzbht.put("H150", Integer.valueOf(32768));
    zzbht.put("H153", Integer.valueOf(131072));
    zzbht.put("H156", Integer.valueOf(524288));
    zzbht.put("H180", Integer.valueOf(2097152));
    zzbht.put("H183", Integer.valueOf(8388608));
    zzbht.put("H186", Integer.valueOf(33554432));
  }

  private static Pair<Integer, Integer> zza(String paramString, String[] paramArrayOfString)
  {
    if (paramArrayOfString.length < 2)
    {
      String str7 = String.valueOf(paramString);
      if (str7.length() != 0);
      for (String str8 = "Ignoring malformed AVC codec string: ".concat(str7); ; str8 = new String("Ignoring malformed AVC codec string: "))
      {
        Log.w("MediaCodecUtil", str8);
        return null;
      }
    }
    try
    {
      Integer localInteger1;
      Integer localInteger5;
      if (paramArrayOfString[1].length() == 6)
      {
        localInteger1 = Integer.valueOf(Integer.parseInt(paramArrayOfString[1].substring(0, 2), 16));
        localInteger5 = Integer.valueOf(Integer.parseInt(paramArrayOfString[1].substring(4), 16));
      }
      for (localInteger2 = localInteger5; ; localInteger2 = Integer.valueOf(Integer.parseInt(paramArrayOfString[2])))
      {
        localInteger3 = Integer.valueOf(zzbhr.get(localInteger1.intValue()));
        if (localInteger3 != null)
          break label293;
        String str6 = String.valueOf(localInteger1);
        Log.w("MediaCodecUtil", 21 + String.valueOf(str6).length() + "Unknown AVC profile: " + str6);
        return null;
        if (paramArrayOfString.length < 3)
          break;
        localInteger1 = Integer.valueOf(Integer.parseInt(paramArrayOfString[1]));
      }
      String str3 = String.valueOf(paramString);
      if (str3.length() != 0);
      for (String str4 = "Ignoring malformed AVC codec string: ".concat(str3); ; str4 = new String("Ignoring malformed AVC codec string: "))
      {
        Log.w("MediaCodecUtil", str4);
        return null;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Integer localInteger2;
      Integer localInteger3;
      String str1 = String.valueOf(paramString);
      if (str1.length() != 0);
      for (String str2 = "Ignoring malformed AVC codec string: ".concat(str1); ; str2 = new String("Ignoring malformed AVC codec string: "))
      {
        Log.w("MediaCodecUtil", str2);
        return null;
      }
      label293: Integer localInteger4 = Integer.valueOf(zzbhs.get(localInteger2.intValue()));
      if (localInteger4 == null)
      {
        String str5 = String.valueOf(localInteger2);
        Log.w("MediaCodecUtil", 19 + String.valueOf(str5).length() + "Unknown AVC level: " + str5);
        return null;
      }
      return new Pair(localInteger3, localInteger4);
    }
  }

  private static List<zzpd> zza(zza paramzza, zzpl paramzzpl)
    throws zzpk
  {
    while (true)
    {
      int j;
      String str2;
      String str3;
      try
      {
        ArrayList localArrayList = new ArrayList();
        String str1 = paramzza.mimeType;
        int i = paramzzpl.getCodecCount();
        boolean bool1 = paramzzpl.zzeh();
        j = 0;
        MediaCodecInfo localMediaCodecInfo;
        int n;
        if (j < i)
        {
          localMediaCodecInfo = paramzzpl.getCodecInfoAt(j);
          str2 = localMediaCodecInfo.getName();
          if (localMediaCodecInfo.isEncoder())
            break label971;
          if ((!bool1) && (str2.endsWith(".secure")))
          {
            break label971;
            if (k == 0)
              break label965;
            String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
            int m = arrayOfString.length;
            n = 0;
            if (n >= m)
              break label965;
            str3 = arrayOfString[n];
            boolean bool2 = str3.equalsIgnoreCase(str1);
            if (!bool2);
          }
        }
        try
        {
          MediaCodecInfo.CodecCapabilities localCodecCapabilities = localMediaCodecInfo.getCapabilitiesForType(str3);
          boolean bool3 = paramzzpl.zza(str1, localCodecCapabilities);
          if ((zzsy.SDK_INT <= 22) && ((zzsy.MODEL.equals("ODROID-XU3")) || (zzsy.MODEL.equals("Nexus 10"))))
          {
            if ("OMX.Exynos.AVC.Decoder".equals(str2))
              break label977;
            if ("OMX.Exynos.AVC.Decoder.secure".equals(str2))
            {
              break label977;
              if (((!bool1) || (paramzza.zzaer != bool3)) && ((bool1) || (paramzza.zzaer)))
                continue;
              localArrayList.add(zzpd.zza(str2, str1, localCodecCapabilities, bool4, false));
              n++;
              continue;
              if ((zzsy.SDK_INT < 21) && (("CIPAACDecoder".equals(str2)) || ("CIPMP3Decoder".equals(str2)) || ("CIPVorbisDecoder".equals(str2)) || ("CIPAMRNBDecoder".equals(str2)) || ("AACDecoder".equals(str2)) || ("MP3Decoder".equals(str2))))
                break label983;
              if ((zzsy.SDK_INT < 18) && ("OMX.SEC.MP3.Decoder".equals(str2)))
              {
                k = 0;
                continue;
              }
              if ((zzsy.SDK_INT < 18) && ("OMX.MTK.AUDIO.DECODER.AAC".equals(str2)) && ("a70".equals(zzsy.DEVICE)))
              {
                k = 0;
                continue;
              }
              if ((zzsy.SDK_INT == 16) && ("OMX.qcom.audio.decoder.mp3".equals(str2)) && (("dlxu".equals(zzsy.DEVICE)) || ("protou".equals(zzsy.DEVICE)) || ("ville".equals(zzsy.DEVICE)) || ("villeplus".equals(zzsy.DEVICE)) || ("villec2".equals(zzsy.DEVICE)) || (zzsy.DEVICE.startsWith("gee")) || ("C6602".equals(zzsy.DEVICE)) || ("C6603".equals(zzsy.DEVICE)) || ("C6606".equals(zzsy.DEVICE)) || ("C6616".equals(zzsy.DEVICE)) || ("L36h".equals(zzsy.DEVICE)) || ("SO-02E".equals(zzsy.DEVICE))))
                break label989;
              if ((zzsy.SDK_INT == 16) && ("OMX.qcom.audio.decoder.aac".equals(str2)) && (("C1504".equals(zzsy.DEVICE)) || ("C1505".equals(zzsy.DEVICE)) || ("C1604".equals(zzsy.DEVICE)) || ("C1605".equals(zzsy.DEVICE))))
                break label995;
              if ((zzsy.SDK_INT <= 19) && ("OMX.SEC.vp8.dec".equals(str2)) && ("samsung".equals(zzsy.MANUFACTURER)) && ((zzsy.DEVICE.startsWith("d2")) || (zzsy.DEVICE.startsWith("serrano")) || (zzsy.DEVICE.startsWith("jflte")) || (zzsy.DEVICE.startsWith("santos")) || (zzsy.DEVICE.startsWith("t0"))))
                break label1001;
              if ((zzsy.SDK_INT <= 19) && (zzsy.DEVICE.startsWith("jflte")))
              {
                boolean bool5 = "OMX.qcom.video.decoder.vp8".equals(str2);
                if (bool5)
                {
                  k = 0;
                  continue;
                }
              }
              k = 1;
              continue;
            }
          }
          bool4 = false;
          continue;
          if ((bool1) || (!bool3))
            continue;
          localArrayList.add(zzpd.zza(String.valueOf(str2).concat(".secure"), str1, localCodecCapabilities, bool4, true));
          return localArrayList;
        }
        catch (Exception localException2)
        {
          if (zzsy.SDK_INT > 23)
            break label898;
        }
        if (!localArrayList.isEmpty())
        {
          Log.e("MediaCodecUtil", 46 + String.valueOf(str2).length() + "Skipping codec " + str2 + " (failed to query capabilities)");
          continue;
        }
      }
      catch (Exception localException1)
      {
        throw new zzpk(localException1, null);
      }
      label898: Log.e("MediaCodecUtil", 25 + String.valueOf(str2).length() + String.valueOf(str3).length() + "Failed to query codec " + str2 + " (" + str3 + ")");
      throw localException2;
      label965: j++;
      continue;
      label971: int k = 0;
      continue;
      label977: boolean bool4 = true;
      continue;
      label983: k = 0;
      continue;
      label989: k = 0;
      continue;
      label995: k = 0;
      continue;
      label1001: k = 0;
    }
  }

  public static Pair<Integer, Integer> zzbe(String paramString)
  {
    if (paramString == null)
      return null;
    String[] arrayOfString = paramString.split("\\.");
    String str1 = arrayOfString[0];
    label64: int i;
    switch (str1.hashCode())
    {
    default:
      i = -1;
    case 3199032:
    case 3214780:
    case 3006243:
    case 3006244:
    }
    while (true)
      switch (i)
      {
      default:
        return null;
        if (!str1.equals("hev1"))
          break label64;
        i = 0;
        continue;
        if (!str1.equals("hvc1"))
          break label64;
        i = 1;
        continue;
        if (!str1.equals("avc1"))
          break label64;
        i = 2;
        continue;
        if (!str1.equals("avc2"))
          break label64;
        i = 3;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    if (arrayOfString.length < 4)
    {
      String str9 = String.valueOf(paramString);
      if (str9.length() != 0);
      for (String str10 = "Ignoring malformed HEVC codec string: ".concat(str9); ; str10 = new String("Ignoring malformed HEVC codec string: "))
      {
        Log.w("MediaCodecUtil", str10);
        return null;
      }
    }
    Matcher localMatcher = zzbhp.matcher(arrayOfString[1]);
    if (!localMatcher.matches())
    {
      String str7 = String.valueOf(paramString);
      if (str7.length() != 0);
      for (String str8 = "Ignoring malformed HEVC codec string: ".concat(str7); ; str8 = new String("Ignoring malformed HEVC codec string: "))
      {
        Log.w("MediaCodecUtil", str8);
        return null;
      }
    }
    String str2 = localMatcher.group(1);
    int j;
    Integer localInteger;
    String str5;
    if ("1".equals(str2))
    {
      j = 1;
      localInteger = (Integer)zzbht.get(arrayOfString[3]);
      if (localInteger != null)
        break label445;
      str5 = String.valueOf(localMatcher.group(1));
      if (str5.length() == 0)
        break label430;
    }
    label430: for (String str6 = "Unknown HEVC level string: ".concat(str5); ; str6 = new String("Unknown HEVC level string: "))
    {
      Log.w("MediaCodecUtil", str6);
      return null;
      if ("2".equals(str2))
      {
        j = 2;
        break;
      }
      String str3 = String.valueOf(str2);
      if (str3.length() != 0);
      for (String str4 = "Unknown HEVC profile string: ".concat(str3); ; str4 = new String("Unknown HEVC profile string: "))
      {
        Log.w("MediaCodecUtil", str4);
        return null;
      }
    }
    label445: return new Pair(Integer.valueOf(j), localInteger);
    return zza(paramString, arrayOfString);
  }

  public static zzpd zze(String paramString, boolean paramBoolean)
    throws zzpk
  {
    List localList = zzf(paramString, paramBoolean);
    if (localList.isEmpty())
      return null;
    return (zzpd)localList.get(0);
  }

  private static List<zzpd> zzf(String paramString, boolean paramBoolean)
    throws zzpk
  {
    while (true)
    {
      List localList2;
      try
      {
        zza localzza = new zza(paramString, paramBoolean);
        List localList1 = (List)zzbhq.get(localzza);
        if (localList1 != null)
          return localList1;
        if (zzsy.SDK_INT >= 21)
        {
          localObject2 = new zzpn(paramBoolean);
          localObject3 = zza(localzza, (zzpl)localObject2);
          if ((paramBoolean) && (((List)localObject3).isEmpty()) && (21 <= zzsy.SDK_INT) && (zzsy.SDK_INT <= 23))
          {
            localList2 = zza(localzza, new zzpm(null));
            if (localList2.isEmpty())
              break label230;
            String str = ((zzpd)localList2.get(0)).name;
            Log.w("MediaCodecUtil", 63 + String.valueOf(paramString).length() + String.valueOf(str).length() + "MediaCodecList API didn't list secure decoder for: " + paramString + ". Assuming: " + str);
            break label230;
          }
          localList1 = Collections.unmodifiableList((List)localObject3);
          zzbhq.put(localzza, localList1);
          continue;
        }
      }
      finally
      {
      }
      Object localObject2 = new zzpm(null);
      continue;
      label230: Object localObject3 = localList2;
    }
  }

  public static zzpd zziv()
  {
    return zzbho;
  }

  public static int zziw()
    throws zzpk
  {
    int i;
    int m;
    if (zzbhu == -1)
    {
      zzpd localzzpd = zze("video/avc", false);
      i = 0;
      if (localzzpd != null)
      {
        MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = localzzpd.zziq();
        int j = arrayOfCodecProfileLevel.length;
        int k = 0;
        m = 0;
        if (k < j)
        {
          int i1;
          switch (arrayOfCodecProfileLevel[k].level)
          {
          default:
            i1 = -1;
          case 1:
          case 2:
          case 8:
          case 16:
          case 32:
          case 64:
          case 128:
          case 256:
          case 512:
          case 1024:
          case 2048:
          case 4096:
          case 8192:
          case 16384:
          case 32768:
          case 65536:
          }
          while (true)
          {
            m = Math.max(i1, m);
            k++;
            break;
            i1 = 25344;
            continue;
            i1 = 25344;
            continue;
            i1 = 101376;
            continue;
            i1 = 101376;
            continue;
            i1 = 101376;
            continue;
            i1 = 202752;
            continue;
            i1 = 414720;
            continue;
            i1 = 414720;
            continue;
            i1 = 921600;
            continue;
            i1 = 1310720;
            continue;
            i1 = 2097152;
            continue;
            i1 = 2097152;
            continue;
            i1 = 2228224;
            continue;
            i1 = 5652480;
            continue;
            i1 = 9437184;
            continue;
            i1 = 9437184;
          }
        }
        if (zzsy.SDK_INT < 21)
          break label361;
      }
    }
    label361: for (int n = 345600; ; n = 172800)
    {
      i = Math.max(m, n);
      zzbhu = i;
      return zzbhu;
    }
  }

  static final class zza
  {
    public final String mimeType;
    public final boolean zzaer;

    public zza(String paramString, boolean paramBoolean)
    {
      this.mimeType = paramString;
      this.zzaer = paramBoolean;
    }

    public final boolean equals(Object paramObject)
    {
      if (this == paramObject);
      zza localzza;
      do
      {
        return true;
        if ((paramObject == null) || (paramObject.getClass() != zza.class))
          return false;
        localzza = (zza)paramObject;
      }
      while ((TextUtils.equals(this.mimeType, localzza.mimeType)) && (this.zzaer == localzza.zzaer));
      return false;
    }

    public final int hashCode()
    {
      int i;
      int j;
      if (this.mimeType == null)
      {
        i = 0;
        j = 31 * (i + 31);
        if (!this.zzaer)
          break label43;
      }
      label43: for (int k = 1231; ; k = 1237)
      {
        return k + j;
        i = this.mimeType.hashCode();
        break;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzpi
 * JD-Core Version:    0.6.2
 */