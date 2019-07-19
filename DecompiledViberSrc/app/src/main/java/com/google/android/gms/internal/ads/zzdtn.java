package com.google.android.gms.internal.ads;

public final class zzdtn
{
  public static <T> T checkNotNull(T paramT)
  {
    if (paramT == null)
      throw new NullPointerException();
    return paramT;
  }

  public static <T> T zza(T paramT, String paramString)
  {
    if (paramT == null)
      throw new NullPointerException(paramString);
    return paramT;
  }

  public static <T> void zza(T paramT, Class<T> paramClass)
  {
    if (paramT == null)
      throw new IllegalStateException(String.valueOf(paramClass.getCanonicalName()).concat(" must be set"));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdtn
 * JD-Core Version:    0.6.2
 */