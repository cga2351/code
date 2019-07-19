package com.google.android.gms.internal.measurement;

final class zztb
{
  private static final Class<?> zzbto = zzfz("libcore.io.Memory");
  private static final boolean zzbtp;

  static
  {
    if (zzfz("org.robolectric.Robolectric") != null);
    for (boolean bool = true; ; bool = false)
    {
      zzbtp = bool;
      return;
    }
  }

  private static <T> Class<T> zzfz(String paramString)
  {
    try
    {
      Class localClass = Class.forName(paramString);
      return localClass;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  static boolean zzub()
  {
    return (zzbto != null) && (!zzbtp);
  }

  static Class<?> zzuc()
  {
    return zzbto;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zztb
 * JD-Core Version:    0.6.2
 */