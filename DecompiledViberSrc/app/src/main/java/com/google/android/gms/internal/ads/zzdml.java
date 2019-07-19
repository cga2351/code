package com.google.android.gms.internal.ads;

final class zzdml
{
  private static final Class<?> zzhcj = zzgu("libcore.io.Memory");
  private static final boolean zzhck;

  static
  {
    if (zzgu("org.robolectric.Robolectric") != null);
    for (boolean bool = true; ; bool = false)
    {
      zzhck = bool;
      return;
    }
  }

  static boolean zzavl()
  {
    return (zzhcj != null) && (!zzhck);
  }

  static Class<?> zzavm()
  {
    return zzhcj;
  }

  private static <T> Class<T> zzgu(String paramString)
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
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdml
 * JD-Core Version:    0.6.2
 */