package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzo<TResult, TContinuationResult>
  implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, zzq<TResult>
{
  private final Executor zzd;
  private final zzu<TContinuationResult> zzf;
  private final SuccessContinuation<TResult, TContinuationResult> zzr;

  public zzo(Executor paramExecutor, SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation, zzu<TContinuationResult> paramzzu)
  {
    this.zzd = paramExecutor;
    this.zzr = paramSuccessContinuation;
    this.zzf = paramzzu;
  }

  public final void cancel()
  {
    throw new UnsupportedOperationException();
  }

  public final void onCanceled()
  {
    this.zzf.zza();
  }

  public final void onComplete(Task<TResult> paramTask)
  {
    this.zzd.execute(new zzp(this, paramTask));
  }

  public final void onFailure(Exception paramException)
  {
    this.zzf.setException(paramException);
  }

  public final void onSuccess(TContinuationResult paramTContinuationResult)
  {
    this.zzf.setResult(paramTContinuationResult);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.zzo
 * JD-Core Version:    0.6.2
 */