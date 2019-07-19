package com.google.android.gms.tasks;

final class zzh
  implements Runnable
{
  zzh(zzg paramzzg)
  {
  }

  public final void run()
  {
    synchronized (zzg.zza(this.zzk))
    {
      if (zzg.zzb(this.zzk) != null)
        zzg.zzb(this.zzk).onCanceled();
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.zzh
 * JD-Core Version:    0.6.2
 */