package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.RemoteException;

final class zzei
  implements Runnable
{
  zzei(zzeb paramzzeb, zzdx paramzzdx)
  {
  }

  public final void run()
  {
    zzaj localzzaj = zzeb.zzd(this.zzasl);
    if (localzzaj == null)
    {
      this.zzasl.zzgt().zzjg().zzby("Failed to send current screen to service");
      return;
    }
    while (true)
    {
      try
      {
        if (this.zzasd == null)
        {
          localzzaj.zza(0L, null, null, this.zzasl.getContext().getPackageName());
          zzeb.zze(this.zzasl);
          return;
        }
      }
      catch (RemoteException localRemoteException)
      {
        this.zzasl.zzgt().zzjg().zzg("Failed to send current screen to the service", localRemoteException);
        return;
      }
      localzzaj.zza(this.zzasd.zzarr, this.zzasd.zzuw, this.zzasd.zzarq, this.zzasl.getContext().getPackageName());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzei
 * JD-Core Version:    0.6.2
 */