package com.google.android.gms.internal.ads;

import java.lang.reflect.Constructor;

final class zzdpt
{
  private static final zzdpr zzhkh = zzazf();
  private static final zzdpr zzhki = new zzdps();

  static zzdpr zzazd()
  {
    return zzhkh;
  }

  static zzdpr zzaze()
  {
    return zzhki;
  }

  private static zzdpr zzazf()
  {
    try
    {
      zzdpr localzzdpr = (zzdpr)Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localzzdpr;
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdpt
 * JD-Core Version:    0.6.2
 */