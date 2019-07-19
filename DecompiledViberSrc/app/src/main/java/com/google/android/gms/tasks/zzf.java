package com.google.android.gms.tasks;

final class zzf
  implements Runnable
{
  zzf(zze paramzze, Task paramTask)
  {
  }

  public final void run()
  {
    Task localTask;
    try
    {
      localTask = (Task)zze.zza(this.zzi).then(this.zzg);
      if (localTask == null)
      {
        this.zzi.onFailure(new NullPointerException("Continuation returned null"));
        return;
      }
    }
    catch (RuntimeExecutionException localRuntimeExecutionException)
    {
      if ((localRuntimeExecutionException.getCause() instanceof Exception))
      {
        zze.zzb(this.zzi).setException((Exception)localRuntimeExecutionException.getCause());
        return;
      }
      zze.zzb(this.zzi).setException(localRuntimeExecutionException);
      return;
    }
    catch (Exception localException)
    {
      zze.zzb(this.zzi).setException(localException);
      return;
    }
    localTask.addOnSuccessListener(TaskExecutors.zzw, this.zzi);
    localTask.addOnFailureListener(TaskExecutors.zzw, this.zzi);
    localTask.addOnCanceledListener(TaskExecutors.zzw, this.zzi);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.zzf
 * JD-Core Version:    0.6.2
 */