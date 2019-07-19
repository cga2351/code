package com.google.android.gms.tasks;

final class zzl
  implements Runnable
{
  zzl(zzk paramzzk, Task paramTask)
  {
  }

  public final void run()
  {
    synchronized (zzk.zza(this.zzo))
    {
      if (zzk.zzb(this.zzo) != null)
        zzk.zzb(this.zzo).onFailure(this.zzg.getException());
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.zzl
 * JD-Core Version:    0.6.2
 */