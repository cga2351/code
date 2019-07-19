package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class zzu<TResult> extends Task<TResult>
{
  private final Object mLock = new Object();

  @GuardedBy("mLock")
  private TResult zzaa;

  @GuardedBy("mLock")
  private Exception zzab;
  private final zzr<TResult> zzx = new zzr();

  @GuardedBy("mLock")
  private boolean zzy;
  private volatile boolean zzz;

  @GuardedBy("mLock")
  private final void zzb()
  {
    Preconditions.checkState(this.zzy, "Task is not yet complete");
  }

  @GuardedBy("mLock")
  private final void zzc()
  {
    if (!this.zzy);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "Task is already complete");
      return;
    }
  }

  @GuardedBy("mLock")
  private final void zzd()
  {
    if (this.zzz)
      throw new CancellationException("Task is already canceled.");
  }

  private final void zze()
  {
    synchronized (this.mLock)
    {
      if (!this.zzy)
        return;
      this.zzx.zza(this);
      return;
    }
  }

  public final Task<TResult> addOnCanceledListener(Activity paramActivity, OnCanceledListener paramOnCanceledListener)
  {
    zzg localzzg = new zzg(TaskExecutors.MAIN_THREAD, paramOnCanceledListener);
    this.zzx.zza(localzzg);
    zza.zza(paramActivity).zzb(localzzg);
    zze();
    return this;
  }

  public final Task<TResult> addOnCanceledListener(OnCanceledListener paramOnCanceledListener)
  {
    return addOnCanceledListener(TaskExecutors.MAIN_THREAD, paramOnCanceledListener);
  }

  public final Task<TResult> addOnCanceledListener(Executor paramExecutor, OnCanceledListener paramOnCanceledListener)
  {
    this.zzx.zza(new zzg(paramExecutor, paramOnCanceledListener));
    zze();
    return this;
  }

  public final Task<TResult> addOnCompleteListener(Activity paramActivity, OnCompleteListener<TResult> paramOnCompleteListener)
  {
    zzi localzzi = new zzi(TaskExecutors.MAIN_THREAD, paramOnCompleteListener);
    this.zzx.zza(localzzi);
    zza.zza(paramActivity).zzb(localzzi);
    zze();
    return this;
  }

  public final Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> paramOnCompleteListener)
  {
    return addOnCompleteListener(TaskExecutors.MAIN_THREAD, paramOnCompleteListener);
  }

  public final Task<TResult> addOnCompleteListener(Executor paramExecutor, OnCompleteListener<TResult> paramOnCompleteListener)
  {
    this.zzx.zza(new zzi(paramExecutor, paramOnCompleteListener));
    zze();
    return this;
  }

  public final Task<TResult> addOnFailureListener(Activity paramActivity, OnFailureListener paramOnFailureListener)
  {
    zzk localzzk = new zzk(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
    this.zzx.zza(localzzk);
    zza.zza(paramActivity).zzb(localzzk);
    zze();
    return this;
  }

  public final Task<TResult> addOnFailureListener(OnFailureListener paramOnFailureListener)
  {
    return addOnFailureListener(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
  }

  public final Task<TResult> addOnFailureListener(Executor paramExecutor, OnFailureListener paramOnFailureListener)
  {
    this.zzx.zza(new zzk(paramExecutor, paramOnFailureListener));
    zze();
    return this;
  }

  public final Task<TResult> addOnSuccessListener(Activity paramActivity, OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    zzm localzzm = new zzm(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
    this.zzx.zza(localzzm);
    zza.zza(paramActivity).zzb(localzzm);
    zze();
    return this;
  }

  public final Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    return addOnSuccessListener(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
  }

  public final Task<TResult> addOnSuccessListener(Executor paramExecutor, OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    this.zzx.zza(new zzm(paramExecutor, paramOnSuccessListener));
    zze();
    return this;
  }

  public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> paramContinuation)
  {
    return continueWith(TaskExecutors.MAIN_THREAD, paramContinuation);
  }

  public final <TContinuationResult> Task<TContinuationResult> continueWith(Executor paramExecutor, Continuation<TResult, TContinuationResult> paramContinuation)
  {
    zzu localzzu = new zzu();
    this.zzx.zza(new zzc(paramExecutor, paramContinuation, localzzu));
    zze();
    return localzzu;
  }

  public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> paramContinuation)
  {
    return continueWithTask(TaskExecutors.MAIN_THREAD, paramContinuation);
  }

  public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor paramExecutor, Continuation<TResult, Task<TContinuationResult>> paramContinuation)
  {
    zzu localzzu = new zzu();
    this.zzx.zza(new zze(paramExecutor, paramContinuation, localzzu));
    zze();
    return localzzu;
  }

  public final Exception getException()
  {
    synchronized (this.mLock)
    {
      Exception localException = this.zzab;
      return localException;
    }
  }

  public final TResult getResult()
  {
    synchronized (this.mLock)
    {
      zzb();
      zzd();
      if (this.zzab != null)
        throw new RuntimeExecutionException(this.zzab);
    }
    Object localObject3 = this.zzaa;
    return localObject3;
  }

  public final <X extends Throwable> TResult getResult(Class<X> paramClass)
    throws Throwable
  {
    synchronized (this.mLock)
    {
      zzb();
      zzd();
      if (paramClass.isInstance(this.zzab))
        throw ((Throwable)paramClass.cast(this.zzab));
    }
    if (this.zzab != null)
      throw new RuntimeExecutionException(this.zzab);
    Object localObject3 = this.zzaa;
    return localObject3;
  }

  public final boolean isCanceled()
  {
    return this.zzz;
  }

  public final boolean isComplete()
  {
    synchronized (this.mLock)
    {
      boolean bool = this.zzy;
      return bool;
    }
  }

  public final boolean isSuccessful()
  {
    while (true)
    {
      synchronized (this.mLock)
      {
        if ((this.zzy) && (!this.zzz) && (this.zzab == null))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation)
  {
    return onSuccessTask(TaskExecutors.MAIN_THREAD, paramSuccessContinuation);
  }

  public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor paramExecutor, SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation)
  {
    zzu localzzu = new zzu();
    this.zzx.zza(new zzo(paramExecutor, paramSuccessContinuation, localzzu));
    zze();
    return localzzu;
  }

  public final void setException(Exception paramException)
  {
    Preconditions.checkNotNull(paramException, "Exception must not be null");
    synchronized (this.mLock)
    {
      zzc();
      this.zzy = true;
      this.zzab = paramException;
      this.zzx.zza(this);
      return;
    }
  }

  public final void setResult(TResult paramTResult)
  {
    synchronized (this.mLock)
    {
      zzc();
      this.zzy = true;
      this.zzaa = paramTResult;
      this.zzx.zza(this);
      return;
    }
  }

  public final boolean trySetException(Exception paramException)
  {
    Preconditions.checkNotNull(paramException, "Exception must not be null");
    synchronized (this.mLock)
    {
      if (this.zzy)
        return false;
      this.zzy = true;
      this.zzab = paramException;
      this.zzx.zza(this);
      return true;
    }
  }

  public final boolean trySetResult(TResult paramTResult)
  {
    synchronized (this.mLock)
    {
      if (this.zzy)
        return false;
      this.zzy = true;
      this.zzaa = paramTResult;
      this.zzx.zza(this);
      return true;
    }
  }

  public final boolean zza()
  {
    synchronized (this.mLock)
    {
      if (this.zzy)
        return false;
      this.zzy = true;
      this.zzz = true;
      this.zzx.zza(this);
      return true;
    }
  }

  private static class zza extends LifecycleCallback
  {
    private final List<WeakReference<zzq<?>>> zzac = new ArrayList();

    private zza(LifecycleFragment paramLifecycleFragment)
    {
      super();
      this.mLifecycleFragment.addCallback("TaskOnStopCallback", this);
    }

    public static zza zza(Activity paramActivity)
    {
      LifecycleFragment localLifecycleFragment = getFragment(paramActivity);
      zza localzza = (zza)localLifecycleFragment.getCallbackOrNull("TaskOnStopCallback", zza.class);
      if (localzza == null)
        localzza = new zza(localLifecycleFragment);
      return localzza;
    }

    public void onStop()
    {
      synchronized (this.zzac)
      {
        Iterator localIterator = this.zzac.iterator();
        while (localIterator.hasNext())
        {
          zzq localzzq = (zzq)((WeakReference)localIterator.next()).get();
          if (localzzq != null)
            localzzq.cancel();
        }
      }
      this.zzac.clear();
    }

    public final <T> void zzb(zzq<T> paramzzq)
    {
      synchronized (this.zzac)
      {
        this.zzac.add(new WeakReference(paramzzq));
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.zzu
 * JD-Core Version:    0.6.2
 */