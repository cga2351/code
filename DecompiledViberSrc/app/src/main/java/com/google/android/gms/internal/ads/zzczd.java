package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class zzczd<E, V>
  implements zzbbi<V>
{
  private final E zzgme;
  private final String zzgmf;
  private final zzbbi<V> zzgmg;

  public zzczd(E paramE, String paramString, zzbbi<V> paramzzbbi)
  {
    this.zzgme = paramE;
    this.zzgmf = paramString;
    this.zzgmg = paramzzbbi;
  }

  public final boolean cancel(boolean paramBoolean)
  {
    return this.zzgmg.cancel(paramBoolean);
  }

  public final V get()
    throws InterruptedException, ExecutionException
  {
    return this.zzgmg.get();
  }

  public final V get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return this.zzgmg.get(paramLong, paramTimeUnit);
  }

  public final boolean isCancelled()
  {
    return this.zzgmg.isCancelled();
  }

  public final boolean isDone()
  {
    return this.zzgmg.isDone();
  }

  public final String toString()
  {
    String str = this.zzgmf;
    int i = System.identityHashCode(this);
    return 12 + String.valueOf(str).length() + str + "@" + i;
  }

  public final void zza(Runnable paramRunnable, Executor paramExecutor)
  {
    this.zzgmg.zza(paramRunnable, paramExecutor);
  }

  public final E zzanb()
  {
    return this.zzgme;
  }

  public final String zzanc()
  {
    return this.zzgmf;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzczd
 * JD-Core Version:    0.6.2
 */