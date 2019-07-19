package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class zzm<TResult>
  implements zzq<TResult>
{
  private final Object mLock = new Object();
  private final Executor zzd;

  @GuardedBy("mLock")
  private OnSuccessListener<? super TResult> zzp;

  public zzm(Executor paramExecutor, OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    this.zzd = paramExecutor;
    this.zzp = paramOnSuccessListener;
  }

  public final void cancel()
  {
    synchronized (this.mLock)
    {
      this.zzp = null;
      return;
    }
  }

  public final void onComplete(Task<TResult> paramTask)
  {
    if (paramTask.isSuccessful())
      synchronized (this.mLock)
      {
        if (this.zzp == null)
          return;
        this.zzd.execute(new zzn(this, paramTask));
        return;
      }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.zzm
 * JD-Core Version:    0.6.2
 */