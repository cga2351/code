package com.google.android.gms.internal.measurement;

import java.lang.reflect.Constructor;

final class zzvs
{
  private static final zzvq zzcao = zzxl();
  private static final zzvq zzcap = new zzvr();

  static zzvq zzxj()
  {
    return zzcao;
  }

  static zzvq zzxk()
  {
    return zzcap;
  }

  private static zzvq zzxl()
  {
    try
    {
      zzvq localzzvq = (zzvq)Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localzzvq;
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzvs
 * JD-Core Version:    0.6.2
 */