package com.google.android.gms.measurement.internal;

import android.content.Context;

final class zzbn
  implements Runnable
{
  zzbn(zzbm paramzzbm, zzbw paramzzbw, zzas paramzzas)
  {
  }

  public final void run()
  {
    if (this.zzaoh.zzkk() == null)
    {
      this.zzaoi.zzjg().zzby("Install Referrer Reporter is null");
      return;
    }
    zzbj localzzbj = this.zzaoh.zzkk();
    localzzbj.zzada.zzgg();
    localzzbj.zzce(localzzbj.zzada.getContext().getPackageName());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzbn
 * JD-Core Version:    0.6.2
 */