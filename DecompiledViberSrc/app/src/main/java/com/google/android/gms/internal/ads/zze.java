package com.google.android.gms.internal.ads;

import java.util.concurrent.BlockingQueue;

final class zze
  implements Runnable
{
  zze(zzd paramzzd, zzr paramzzr)
  {
  }

  public final void run()
  {
    try
    {
      zzd.zza(this.zzo).put(this.zzn);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zze
 * JD-Core Version:    0.6.2
 */