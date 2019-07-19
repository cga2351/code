package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.util.HashMap;

@TargetApi(16)
public final class zzgx
{
  private static final HashMap<zza, Pair<String, MediaCodecInfo.CodecCapabilities>> zzaeq = new HashMap();

  private static Pair<String, MediaCodecInfo.CodecCapabilities> zza(zza paramzza, zzha paramzzha)
    throws zzgz
  {
    while (true)
    {
      String str1;
      int j;
      String str2;
      int k;
      MediaCodecInfo.CodecCapabilities localCodecCapabilities;
      boolean bool2;
      try
      {
        str1 = paramzza.mimeType;
        int i = paramzzha.getCodecCount();
        boolean bool1 = paramzzha.zzeh();
        j = 0;
        if (j >= i)
          break label332;
        MediaCodecInfo localMediaCodecInfo = paramzzha.getCodecInfoAt(j);
        str2 = localMediaCodecInfo.getName();
        if ((localMediaCodecInfo.isEncoder()) || (!str2.startsWith("OMX.")) || ((!bool1) && (str2.endsWith(".secure"))))
          break label326;
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        k = 0;
        if (k >= arrayOfString.length)
          break label326;
        String str3 = arrayOfString[k];
        if (!str3.equalsIgnoreCase(str1))
          break label320;
        localCodecCapabilities = localMediaCodecInfo.getCapabilitiesForType(str3);
        bool2 = paramzzha.zza(paramzza.mimeType, localCodecCapabilities);
        if (!bool1)
        {
          HashMap localHashMap1 = zzaeq;
          if (!paramzza.zzaer)
            break label334;
          localzza1 = new zza(str1, false);
          localHashMap1.put(localzza1, Pair.create(str2, localCodecCapabilities));
          if (bool2)
          {
            HashMap localHashMap2 = zzaeq;
            if (paramzza.zzaer)
            {
              localzza2 = paramzza;
              localHashMap2.put(localzza2, Pair.create(String.valueOf(str2).concat(".secure"), localCodecCapabilities));
            }
          }
          else
          {
            if (!zzaeq.containsKey(paramzza))
              break label320;
            return (Pair)zzaeq.get(paramzza);
          }
          zza localzza2 = new zza(str1, true);
          continue;
        }
      }
      catch (Exception localException)
      {
        throw new zzgz(localException, null);
      }
      HashMap localHashMap3 = zzaeq;
      if (paramzza.zzaer == bool2);
      for (zza localzza3 = paramzza; ; localzza3 = new zza(str1, bool2))
      {
        localHashMap3.put(localzza3, Pair.create(str2, localCodecCapabilities));
        break;
      }
      label320: k++;
      continue;
      label326: j++;
      continue;
      label332: return null;
      label334: zza localzza1 = paramzza;
    }
  }

  public static zzgc zzc(String paramString, boolean paramBoolean)
    throws zzgz
  {
    Pair localPair = zzd(paramString, paramBoolean);
    if (localPair == null)
      return null;
    String str = (String)localPair.first;
    MediaCodecInfo.CodecCapabilities localCodecCapabilities = (MediaCodecInfo.CodecCapabilities)localPair.second;
    if (zzkq.SDK_INT >= 19);
    for (boolean bool = localCodecCapabilities.isFeatureSupported("adaptive-playback"); ; bool = false)
      return new zzgc(str, bool);
  }

  private static Pair<String, MediaCodecInfo.CodecCapabilities> zzd(String paramString, boolean paramBoolean)
    throws zzgz
  {
    while (true)
    {
      Pair localPair;
      try
      {
        zza localzza = new zza(paramString, paramBoolean);
        if (zzaeq.containsKey(localzza))
        {
          localObject3 = (Pair)zzaeq.get(localzza);
          return localObject3;
        }
        if (zzkq.SDK_INT >= 21)
        {
          localObject2 = new zzhc(paramBoolean);
          localObject3 = zza(localzza, (zzha)localObject2);
          if ((!paramBoolean) || (localObject3 != null) || (zzkq.SDK_INT < 21))
            continue;
          localPair = zza(localzza, new zzhb(null));
          if (localPair == null)
            break label189;
          String str = (String)localPair.first;
          Log.w("MediaCodecUtil", 63 + String.valueOf(paramString).length() + String.valueOf(str).length() + "MediaCodecList API didn't list secure decoder for: " + paramString + ". Assuming: " + str);
          break label189;
        }
        Object localObject2 = new zzhb(null);
        continue;
      }
      finally
      {
      }
      label189: Object localObject3 = localPair;
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
 * Qualified Name:     com.google.android.gms.internal.ads.zzgx
 * JD-Core Version:    0.6.2
 */