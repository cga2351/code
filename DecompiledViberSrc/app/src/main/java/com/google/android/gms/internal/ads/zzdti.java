package com.google.android.gms.internal.ads;

public final class zzdti<T>
  implements zzdtd<T>, zzdth<T>
{
  private static final zzdti<Object> zzhuj = new zzdti(null);
  private final T zzdyb;

  private zzdti(T paramT)
  {
    this.zzdyb = paramT;
  }

  public static <T> zzdth<T> zzar(T paramT)
  {
    return new zzdti(zzdtn.zza(paramT, "instance cannot be null"));
  }

  public final T get()
  {
    return this.zzdyb;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdti
 * JD-Core Version:    0.6.2
 */