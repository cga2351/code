package com.google.android.gms.tasks;

public class TaskCompletionSource<TResult>
{
  private final zzu<TResult> zza = new zzu();

  public TaskCompletionSource()
  {
  }

  public TaskCompletionSource(CancellationToken paramCancellationToken)
  {
    paramCancellationToken.onCanceledRequested(new zzs(this));
  }

  public Task<TResult> getTask()
  {
    return this.zza;
  }

  public void setException(Exception paramException)
  {
    this.zza.setException(paramException);
  }

  public void setResult(TResult paramTResult)
  {
    this.zza.setResult(paramTResult);
  }

  public boolean trySetException(Exception paramException)
  {
    return this.zza.trySetException(paramException);
  }

  public boolean trySetResult(TResult paramTResult)
  {
    return this.zza.trySetResult(paramTResult);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.TaskCompletionSource
 * JD-Core Version:    0.6.2
 */