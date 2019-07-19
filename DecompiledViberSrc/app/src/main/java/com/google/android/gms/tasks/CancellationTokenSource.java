package com.google.android.gms.tasks;

public class CancellationTokenSource
{
  private final zza zzc = new zza();

  public void cancel()
  {
    this.zzc.cancel();
  }

  public CancellationToken getToken()
  {
    return this.zzc;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.CancellationTokenSource
 * JD-Core Version:    0.6.2
 */