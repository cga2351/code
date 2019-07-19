package com.google.android.gms.internal.measurement;

import java.lang.reflect.Constructor;

final class zzue
{
  private static final zzuc<?> zzbvh = new zzud();
  private static final zzuc<?> zzbvi = zzvt();

  private static zzuc<?> zzvt()
  {
    try
    {
      zzuc localzzuc = (zzuc)Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localzzuc;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  static zzuc<?> zzvu()
  {
    return zzbvh;
  }

  static zzuc<?> zzvv()
  {
    if (zzbvi == null)
      throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    return zzbvi;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzue
 * JD-Core Version:    0.6.2
 */