package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;

public final class Tasks
{
  public static <TResult> TResult await(Task<TResult> paramTask)
    throws ExecutionException, InterruptedException
  {
    Preconditions.checkNotMainThread();
    Preconditions.checkNotNull(paramTask, "Task must not be null");
    if (paramTask.isComplete())
      return zzb(paramTask);
    zza localzza = new zza(null);
    zza(paramTask, localzza);
    localzza.await();
    return zzb(paramTask);
  }

  public static <TResult> TResult await(Task<TResult> paramTask, long paramLong, TimeUnit paramTimeUnit)
    throws ExecutionException, InterruptedException, TimeoutException
  {
    Preconditions.checkNotMainThread();
    Preconditions.checkNotNull(paramTask, "Task must not be null");
    Preconditions.checkNotNull(paramTimeUnit, "TimeUnit must not be null");
    if (paramTask.isComplete())
      return zzb(paramTask);
    zza localzza = new zza(null);
    zza(paramTask, localzza);
    if (!localzza.await(paramLong, paramTimeUnit))
      throw new TimeoutException("Timed out waiting for Task");
    return zzb(paramTask);
  }

  public static <TResult> Task<TResult> call(Callable<TResult> paramCallable)
  {
    return call(TaskExecutors.MAIN_THREAD, paramCallable);
  }

  public static <TResult> Task<TResult> call(Executor paramExecutor, Callable<TResult> paramCallable)
  {
    Preconditions.checkNotNull(paramExecutor, "Executor must not be null");
    Preconditions.checkNotNull(paramCallable, "Callback must not be null");
    zzu localzzu = new zzu();
    paramExecutor.execute(new zzv(localzzu, paramCallable));
    return localzzu;
  }

  public static <TResult> Task<TResult> forCanceled()
  {
    zzu localzzu = new zzu();
    localzzu.zza();
    return localzzu;
  }

  public static <TResult> Task<TResult> forException(Exception paramException)
  {
    zzu localzzu = new zzu();
    localzzu.setException(paramException);
    return localzzu;
  }

  public static <TResult> Task<TResult> forResult(TResult paramTResult)
  {
    zzu localzzu = new zzu();
    localzzu.setResult(paramTResult);
    return localzzu;
  }

  public static Task<Void> whenAll(Collection<? extends Task<?>> paramCollection)
  {
    if (paramCollection.isEmpty())
      return forResult(null);
    Iterator localIterator1 = paramCollection.iterator();
    while (localIterator1.hasNext())
      if ((Task)localIterator1.next() == null)
        throw new NullPointerException("null tasks are not accepted");
    zzu localzzu = new zzu();
    zzc localzzc = new zzc(paramCollection.size(), localzzu);
    Iterator localIterator2 = paramCollection.iterator();
    while (localIterator2.hasNext())
      zza((Task)localIterator2.next(), localzzc);
    return localzzu;
  }

  public static Task<Void> whenAll(Task<?>[] paramArrayOfTask)
  {
    if (paramArrayOfTask.length == 0)
      return forResult(null);
    return whenAll(Arrays.asList(paramArrayOfTask));
  }

  public static Task<List<Task<?>>> whenAllComplete(Collection<? extends Task<?>> paramCollection)
  {
    return whenAll(paramCollection).continueWithTask(new zzx(paramCollection));
  }

  public static Task<List<Task<?>>> whenAllComplete(Task<?>[] paramArrayOfTask)
  {
    return whenAllComplete(Arrays.asList(paramArrayOfTask));
  }

  public static <TResult> Task<List<TResult>> whenAllSuccess(Collection<? extends Task<?>> paramCollection)
  {
    return whenAll(paramCollection).continueWith(new zzw(paramCollection));
  }

  public static <TResult> Task<List<TResult>> whenAllSuccess(Task<?>[] paramArrayOfTask)
  {
    return whenAllSuccess(Arrays.asList(paramArrayOfTask));
  }

  private static void zza(Task<?> paramTask, zzb paramzzb)
  {
    paramTask.addOnSuccessListener(TaskExecutors.zzw, paramzzb);
    paramTask.addOnFailureListener(TaskExecutors.zzw, paramzzb);
    paramTask.addOnCanceledListener(TaskExecutors.zzw, paramzzb);
  }

  private static <TResult> TResult zzb(Task<TResult> paramTask)
    throws ExecutionException
  {
    if (paramTask.isSuccessful())
      return paramTask.getResult();
    if (paramTask.isCanceled())
      throw new CancellationException("Task is already canceled");
    throw new ExecutionException(paramTask.getException());
  }

  private static final class zza
    implements Tasks.zzb
  {
    private final CountDownLatch zzaf = new CountDownLatch(1);

    public final void await()
      throws InterruptedException
    {
      this.zzaf.await();
    }

    public final boolean await(long paramLong, TimeUnit paramTimeUnit)
      throws InterruptedException
    {
      return this.zzaf.await(paramLong, paramTimeUnit);
    }

    public final void onCanceled()
    {
      this.zzaf.countDown();
    }

    public final void onFailure(Exception paramException)
    {
      this.zzaf.countDown();
    }

    public final void onSuccess(Object paramObject)
    {
      this.zzaf.countDown();
    }
  }

  static abstract interface zzb extends OnCanceledListener, OnFailureListener, OnSuccessListener<Object>
  {
  }

  private static final class zzc
    implements Tasks.zzb
  {
    private final Object mLock = new Object();
    private final zzu<Void> zza;

    @GuardedBy("mLock")
    private Exception zzab;
    private final int zzag;

    @GuardedBy("mLock")
    private int zzah;

    @GuardedBy("mLock")
    private int zzai;

    @GuardedBy("mLock")
    private int zzaj;

    @GuardedBy("mLock")
    private boolean zzak;

    public zzc(int paramInt, zzu<Void> paramzzu)
    {
      this.zzag = paramInt;
      this.zza = paramzzu;
    }

    @GuardedBy("mLock")
    private final void zzf()
    {
      if (this.zzah + this.zzai + this.zzaj == this.zzag)
      {
        if (this.zzab != null)
        {
          zzu localzzu = this.zza;
          int i = this.zzai;
          int j = this.zzag;
          localzzu.setException(new ExecutionException(54 + i + " out of " + j + " underlying tasks failed", this.zzab));
        }
      }
      else
        return;
      if (this.zzak)
      {
        this.zza.zza();
        return;
      }
      this.zza.setResult(null);
    }

    public final void onCanceled()
    {
      synchronized (this.mLock)
      {
        this.zzaj = (1 + this.zzaj);
        this.zzak = true;
        zzf();
        return;
      }
    }

    public final void onFailure(Exception paramException)
    {
      synchronized (this.mLock)
      {
        this.zzai = (1 + this.zzai);
        this.zzab = paramException;
        zzf();
        return;
      }
    }

    public final void onSuccess(Object paramObject)
    {
      synchronized (this.mLock)
      {
        this.zzah = (1 + this.zzah);
        zzf();
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.Tasks
 * JD-Core Version:    0.6.2
 */