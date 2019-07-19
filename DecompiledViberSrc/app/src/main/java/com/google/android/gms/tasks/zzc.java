package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzc<TResult, TContinuationResult>
  implements zzq<TResult>
{
  private final Executor zzd;
  private final Continuation<TResult, TContinuationResult> zze;
  private final zzu<TContinuationResult> zzf;

  public zzc(Executor paramExecutor, Continuation<TResult, TContinuationResult> paramContinuation, zzu<TContinuationResult> paramzzu)
  {
    this.zzd = paramExecutor;
    this.zze = paramContinuation;
    this.zzf = paramzzu;
  }

  public final void cancel()
  {
    throw new UnsupportedOperationException();
  }

  public final void onComplete(Task<TResult> paramTask)
  {
    this.zzd.execute(new zzd(this, paramTask));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.zzc
 * JD-Core Version:    0.6.2
 */