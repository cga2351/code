package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

final class zzakr
  implements Runnable
{
  zzakr(zzaki paramzzaki, zzalb paramzzalb, zzajx paramzzajx)
  {
  }

  public final void run()
  {
    synchronized (zzaki.zza(this.zzdcp))
    {
      if ((this.zzdcn.getStatus() == -1) || (this.zzdcn.getStatus() == 1))
        return;
      this.zzdcn.reject();
      Executor localExecutor = zzbbn.zzeag;
      zzajx localzzajx = this.zzdco;
      localzzajx.getClass();
      localExecutor.execute(zzaks.zzb(localzzajx));
      zzaxa.zzds("Could not receive loaded message in a timely manner. Rejecting.");
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzakr
 * JD-Core Version:    0.6.2
 */