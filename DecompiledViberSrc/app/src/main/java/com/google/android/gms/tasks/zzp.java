package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;

final class zzp
  implements Runnable
{
  zzp(zzo paramzzo, Task paramTask)
  {
  }

  public final void run()
  {
    Task localTask;
    try
    {
      localTask = zzo.zza(this.zzs).then(this.zzg.getResult());
      if (localTask == null)
      {
        this.zzs.onFailure(new NullPointerException("Continuation returned null"));
        return;
      }
    }
    catch (RuntimeExecutionException localRuntimeExecutionException)
    {
      if ((localRuntimeExecutionException.getCause() instanceof Exception))
      {
        this.zzs.onFailure((Exception)localRuntimeExecutionException.getCause());
        return;
      }
      this.zzs.onFailure(localRuntimeExecutionException);
      return;
    }
    catch (CancellationException localCancellationException)
    {
      this.zzs.onCanceled();
      return;
    }
    catch (Exception localException)
    {
      this.zzs.onFailure(localException);
      return;
    }
    localTask.addOnSuccessListener(TaskExecutors.zzw, this.zzs);
    localTask.addOnFailureListener(TaskExecutors.zzw, this.zzs);
    localTask.addOnCanceledListener(TaskExecutors.zzw, this.zzs);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.zzp
 * JD-Core Version:    0.6.2
 */