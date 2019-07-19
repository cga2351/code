package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class zzk<TResult>
  implements zzq<TResult>
{
  private final Object mLock = new Object();
  private final Executor zzd;

  @GuardedBy("mLock")
  private OnFailureListener zzn;

  public zzk(Executor paramExecutor, OnFailureListener paramOnFailureListener)
  {
    this.zzd = paramExecutor;
    this.zzn = paramOnFailureListener;
  }

  public final void cancel()
  {
    synchronized (this.mLock)
    {
      this.zzn = null;
      return;
    }
  }

  public final void onComplete(Task<TResult> paramTask)
  {
    if ((!paramTask.isSuccessful()) && (!paramTask.isCanceled()))
      synchronized (this.mLock)
      {
        if (this.zzn == null)
          return;
        this.zzd.execute(new zzl(this, paramTask));
        return;
      }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.zzk
 * JD-Core Version:    0.6.2
 */