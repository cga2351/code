package com.google.android.gms.tasks;

final class zzd
  implements Runnable
{
  zzd(zzc paramzzc, Task paramTask)
  {
  }

  public final void run()
  {
    if (this.zzg.isCanceled())
    {
      zzc.zza(this.zzh).zza();
      return;
    }
    try
    {
      Object localObject = zzc.zzb(this.zzh).then(this.zzg);
      zzc.zza(this.zzh).setResult(localObject);
      return;
    }
    catch (RuntimeExecutionException localRuntimeExecutionException)
    {
      if ((localRuntimeExecutionException.getCause() instanceof Exception))
      {
        zzc.zza(this.zzh).setException((Exception)localRuntimeExecutionException.getCause());
        return;
      }
      zzc.zza(this.zzh).setException(localRuntimeExecutionException);
      return;
    }
    catch (Exception localException)
    {
      zzc.zza(this.zzh).setException(localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.zzd
 * JD-Core Version:    0.6.2
 */