package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzcfj
  implements zzczy
{
  private final Clock zzbsb;
  private final Map<zzczr, Long> zzfuq;
  private final zzcfh zzfur;
  private final Map<zzczr, zzcfk> zzfus;

  public zzcfj(zzcfh paramzzcfh, Set<zzcfk> paramSet, Clock paramClock)
  {
    this.zzfur = paramzzcfh;
    this.zzfuq = new HashMap();
    this.zzfus = new HashMap();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      zzcfk localzzcfk = (zzcfk)localIterator.next();
      this.zzfus.put(zzcfk.zza(localzzcfk), localzzcfk);
    }
    this.zzbsb = paramClock;
  }

  private final void zza(zzczr paramzzczr, boolean paramBoolean)
  {
    zzczr localzzczr = zzcfk.zzb((zzcfk)this.zzfus.get(paramzzczr));
    String str1;
    Map localMap;
    String str3;
    label113: String str4;
    String str5;
    if (paramBoolean)
    {
      str1 = "s.";
      if (this.zzfuq.containsKey(localzzczr))
      {
        long l = this.zzbsb.elapsedRealtime() - ((Long)this.zzfuq.get(localzzczr)).longValue();
        localMap = this.zzfur.zzqy();
        String str2 = String.valueOf(zzcfk.zzc((zzcfk)this.zzfus.get(paramzzczr)));
        if (str2.length() == 0)
          break label167;
        str3 = "label.".concat(str2);
        str4 = String.valueOf(str1);
        str5 = String.valueOf(Long.toString(l));
        if (str5.length() == 0)
          break label181;
      }
    }
    label167: label181: for (String str6 = str4.concat(str5); ; str6 = new String(str4))
    {
      localMap.put(str3, str6);
      return;
      str1 = "f.";
      break;
      str3 = new String("label.");
      break label113;
    }
  }

  public final void zza(zzczr paramzzczr, String paramString)
  {
  }

  public final void zza(zzczr paramzzczr, String paramString, Throwable paramThrowable)
  {
    Map localMap;
    String str2;
    String str3;
    if (this.zzfuq.containsKey(paramzzczr))
    {
      long l = this.zzbsb.elapsedRealtime() - ((Long)this.zzfuq.get(paramzzczr)).longValue();
      localMap = this.zzfur.zzqy();
      String str1 = String.valueOf(paramString);
      if (str1.length() == 0)
        break label132;
      str2 = "task.".concat(str1);
      str3 = String.valueOf(Long.toString(l));
      if (str3.length() == 0)
        break label146;
    }
    label132: label146: for (String str4 = "f.".concat(str3); ; str4 = new String("f."))
    {
      localMap.put(str2, str4);
      if (this.zzfus.containsKey(paramzzczr))
        zza(paramzzczr, false);
      return;
      str2 = new String("task.");
      break;
    }
  }

  public final void zzb(zzczr paramzzczr, String paramString)
  {
    this.zzfuq.put(paramzzczr, Long.valueOf(this.zzbsb.elapsedRealtime()));
  }

  public final void zzc(zzczr paramzzczr, String paramString)
  {
    Map localMap;
    String str2;
    String str3;
    if (this.zzfuq.containsKey(paramzzczr))
    {
      long l = this.zzbsb.elapsedRealtime() - ((Long)this.zzfuq.get(paramzzczr)).longValue();
      localMap = this.zzfur.zzqy();
      String str1 = String.valueOf(paramString);
      if (str1.length() == 0)
        break label130;
      str2 = "task.".concat(str1);
      str3 = String.valueOf(Long.toString(l));
      if (str3.length() == 0)
        break label144;
    }
    label130: label144: for (String str4 = "s.".concat(str3); ; str4 = new String("s."))
    {
      localMap.put(str2, str4);
      if (this.zzfus.containsKey(paramzzczr))
        zza(paramzzczr, true);
      return;
      str2 = new String("task.");
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcfj
 * JD-Core Version:    0.6.2
 */