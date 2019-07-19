package com.google.android.gms.internal.ads;

import java.lang.reflect.Constructor;

final class zzdnq
{
  private static final zzdno<?> zzhee = new zzdnp();
  private static final zzdno<?> zzhef = zzaxf();

  private static zzdno<?> zzaxf()
  {
    try
    {
      zzdno localzzdno = (zzdno)Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localzzdno;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  static zzdno<?> zzaxg()
  {
    return zzhee;
  }

  static zzdno<?> zzaxh()
  {
    if (zzhef == null)
      throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    return zzhef;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdnq
 * JD-Core Version:    0.6.2
 */