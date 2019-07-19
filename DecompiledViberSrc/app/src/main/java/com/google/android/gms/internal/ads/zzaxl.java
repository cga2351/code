package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzaxl
  implements Runnable
{
  zzaxl(zzaxj paramzzaxj, Context paramContext)
  {
  }

  public final void run()
  {
    synchronized (zzaxj.zza(this.zzdwb))
    {
      zzaxj.zza(this.zzdwb, zzaxj.zzam(this.val$context));
      zzaxj.zza(this.zzdwb).notifyAll();
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaxl
 * JD-Core Version:    0.6.2
 */