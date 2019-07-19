package com.google.android.gms.tasks;

final class zza extends CancellationToken
{
  private final zzu<Void> zza = new zzu();

  public final void cancel()
  {
    this.zza.trySetResult(null);
  }

  public final boolean isCancellationRequested()
  {
    return this.zza.isComplete();
  }

  public final CancellationToken onCanceledRequested(OnTokenCanceledListener paramOnTokenCanceledListener)
  {
    this.zza.addOnSuccessListener(new zzb(this, paramOnTokenCanceledListener));
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.zza
 * JD-Core Version:    0.6.2
 */