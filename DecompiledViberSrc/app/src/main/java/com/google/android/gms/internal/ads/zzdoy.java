package com.google.android.gms.internal.ads;

import java.lang.reflect.Method;

final class zzdoy
  implements zzdqb
{
  private static final zzdpi zzhjg = new zzdoz();
  private final zzdpi zzhjf;

  public zzdoy()
  {
    this(new zzdpa(arrayOfzzdpi));
  }

  private zzdoy(zzdpi paramzzdpi)
  {
    this.zzhjf = ((zzdpi)zzdoc.zza(paramzzdpi, "messageInfoFactory"));
  }

  private static boolean zza(zzdph paramzzdph)
  {
    return paramzzdph.zzayz() == zzdoa.zze.zzhhs;
  }

  private static zzdpi zzays()
  {
    try
    {
      zzdpi localzzdpi = (zzdpi)Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
      return localzzdpi;
    }
    catch (Exception localException)
    {
    }
    return zzhjg;
  }

  public final <T> zzdqa<T> zzf(Class<T> paramClass)
  {
    zzdqc.zzh(paramClass);
    zzdph localzzdph = this.zzhjf.zzd(paramClass);
    if (localzzdph.zzaza())
    {
      if (zzdoa.class.isAssignableFrom(paramClass))
        return zzdpp.zza(zzdqc.zzazm(), zzdnq.zzaxg(), localzzdph.zzazb());
      return zzdpp.zza(zzdqc.zzazk(), zzdnq.zzaxh(), localzzdph.zzazb());
    }
    if (zzdoa.class.isAssignableFrom(paramClass))
    {
      if (zza(localzzdph))
        return zzdpn.zza(paramClass, localzzdph, zzdpt.zzaze(), zzdot.zzayr(), zzdqc.zzazm(), zzdnq.zzaxg(), zzdpg.zzayx());
      return zzdpn.zza(paramClass, localzzdph, zzdpt.zzaze(), zzdot.zzayr(), zzdqc.zzazm(), null, zzdpg.zzayx());
    }
    if (zza(localzzdph))
      return zzdpn.zza(paramClass, localzzdph, zzdpt.zzazd(), zzdot.zzayq(), zzdqc.zzazk(), zzdnq.zzaxh(), zzdpg.zzayw());
    return zzdpn.zza(paramClass, localzzdph, zzdpt.zzazd(), zzdot.zzayq(), zzdqc.zzazl(), null, zzdpg.zzayw());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdoy
 * JD-Core Version:    0.6.2
 */