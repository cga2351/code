package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public abstract interface zzbbm extends ExecutorService
{
  public abstract <T> zzbbi<T> zza(Callable<T> paramCallable);

  public abstract zzbbi<?> zze(Runnable paramRunnable);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbbm
 * JD-Core Version:    0.6.2
 */