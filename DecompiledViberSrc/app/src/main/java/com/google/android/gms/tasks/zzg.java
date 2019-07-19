package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class zzg<TResult>
  implements zzq<TResult>
{
  private final Object mLock = new Object();
  private final Executor zzd;

  @GuardedBy("mLock")
  private OnCanceledListener zzj;

  public zzg(Executor paramExecutor, OnCanceledListener paramOnCanceledListener)
  {
    this.zzd = paramExecutor;
    this.zzj = paramOnCanceledListener;
  }

  public final void cancel()
  {
    synchronized (this.mLock)
    {
      this.zzj = null;
      return;
    }
  }

  public final void onComplete(Task paramTask)
  {
    if (paramTask.isCanceled())
      synchronized (this.mLock)
      {
        if (this.zzj == null)
          return;
        this.zzd.execute(new zzh(this));
        return;
      }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.zzg
 * JD-Core Version:    0.6.2
 */