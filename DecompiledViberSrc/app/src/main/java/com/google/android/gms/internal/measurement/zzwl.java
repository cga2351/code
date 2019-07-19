package com.google.android.gms.internal.measurement;

import java.io.IOException;

abstract interface zzwl<T>
{
  public abstract boolean equals(T paramT1, T paramT2);

  public abstract int hashCode(T paramT);

  public abstract T newInstance();

  public abstract void zza(T paramT, zzwk paramzzwk, zzub paramzzub)
    throws IOException;

  public abstract void zza(T paramT, zzxy paramzzxy)
    throws IOException;

  public abstract int zzai(T paramT);

  public abstract boolean zzaj(T paramT);

  public abstract void zzd(T paramT1, T paramT2);

  public abstract void zzy(T paramT);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzwl
 * JD-Core Version:    0.6.2
 */