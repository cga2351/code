package com.google.android.gms.internal.ads;

public final class zzy<T>
{
  public final T result;
  public final zzc zzbh;
  public final zzaf zzbi;
  public boolean zzbj = false;

  private zzy(zzaf paramzzaf)
  {
    this.result = null;
    this.zzbh = null;
    this.zzbi = paramzzaf;
  }

  private zzy(T paramT, zzc paramzzc)
  {
    this.result = paramT;
    this.zzbh = paramzzc;
    this.zzbi = null;
  }

  public static <T> zzy<T> zza(T paramT, zzc paramzzc)
  {
    return new zzy(paramT, paramzzc);
  }

  public static <T> zzy<T> zzc(zzaf paramzzaf)
  {
    return new zzy(paramzzaf);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzy
 * JD-Core Version:    0.6.2
 */