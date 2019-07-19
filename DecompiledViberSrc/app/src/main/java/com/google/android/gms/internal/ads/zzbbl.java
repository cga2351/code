package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import javax.annotation.Nullable;

@zzare
final class zzbbl<V> extends FutureTask<V>
  implements zzbbi<V>
{
  private final zzbbj zzeaa = new zzbbj();

  zzbbl(Runnable paramRunnable, @Nullable V paramV)
  {
    super(paramRunnable, paramV);
  }

  zzbbl(Callable<V> paramCallable)
  {
    super(paramCallable);
  }

  protected final void done()
  {
    this.zzeaa.zzxd();
  }

  public final void zza(Runnable paramRunnable, Executor paramExecutor)
  {
    this.zzeaa.zza(paramRunnable, paramExecutor);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbbl
 * JD-Core Version:    0.6.2
 */