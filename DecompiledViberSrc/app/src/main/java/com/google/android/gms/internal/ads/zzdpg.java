package com.google.android.gms.internal.ads;

import java.lang.reflect.Constructor;

final class zzdpg
{
  private static final zzdpe zzhjm = zzayy();
  private static final zzdpe zzhjn = new zzdpf();

  static zzdpe zzayw()
  {
    return zzhjm;
  }

  static zzdpe zzayx()
  {
    return zzhjn;
  }

  private static zzdpe zzayy()
  {
    try
    {
      zzdpe localzzdpe = (zzdpe)Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localzzdpe;
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdpg
 * JD-Core Version:    0.6.2
 */