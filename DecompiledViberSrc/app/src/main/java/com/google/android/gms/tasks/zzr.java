package com.google.android.gms.tasks;

import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

final class zzr<TResult>
{
  private final Object mLock = new Object();

  @GuardedBy("mLock")
  private Queue<zzq<TResult>> zzt;

  @GuardedBy("mLock")
  private boolean zzu;

  public final void zza(Task<TResult> paramTask)
  {
    while (true)
    {
      zzq localzzq;
      synchronized (this.mLock)
      {
        if ((this.zzt == null) || (this.zzu))
          return;
        this.zzu = true;
        synchronized (this.mLock)
        {
          localzzq = (zzq)this.zzt.poll();
          if (localzzq == null)
          {
            this.zzu = false;
            return;
          }
        }
      }
      localzzq.onComplete(paramTask);
    }
  }

  public final void zza(zzq<TResult> paramzzq)
  {
    synchronized (this.mLock)
    {
      if (this.zzt == null)
        this.zzt = new ArrayDeque();
      this.zzt.add(paramzzq);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.zzr
 * JD-Core Version:    0.6.2
 */