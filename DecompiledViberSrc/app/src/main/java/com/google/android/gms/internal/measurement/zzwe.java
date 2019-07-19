package com.google.android.gms.internal.measurement;

import java.lang.reflect.Constructor;

final class zzwe
{
  private static final zzwc zzcbj = zzxs();
  private static final zzwc zzcbk = new zzwd();

  static zzwc zzxq()
  {
    return zzcbj;
  }

  static zzwc zzxr()
  {
    return zzcbk;
  }

  private static zzwc zzxs()
  {
    try
    {
      zzwc localzzwc = (zzwc)Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localzzwc;
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzwe
 * JD-Core Version:    0.6.2
 */