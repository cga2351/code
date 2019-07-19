package com.google.android.gms.tasks;

final class zzj
  implements Runnable
{
  zzj(zzi paramzzi, Task paramTask)
  {
  }

  public final void run()
  {
    synchronized (zzi.zza(this.zzm))
    {
      if (zzi.zzb(this.zzm) != null)
        zzi.zzb(this.zzm).onComplete(this.zzg);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.zzj
 * JD-Core Version:    0.6.2
 */