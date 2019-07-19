package com.google.android.gms.tasks;

final class zzn
  implements Runnable
{
  zzn(zzm paramzzm, Task paramTask)
  {
  }

  public final void run()
  {
    synchronized (zzm.zza(this.zzq))
    {
      if (zzm.zzb(this.zzq) != null)
        zzm.zzb(this.zzq).onSuccess(this.zzg.getResult());
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.zzn
 * JD-Core Version:    0.6.2
 */