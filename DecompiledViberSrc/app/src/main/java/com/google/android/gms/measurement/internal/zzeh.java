package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

final class zzeh
  implements Runnable
{
  zzeh(zzeb paramzzeb, zzk paramzzk)
  {
  }

  public final void run()
  {
    zzaj localzzaj = zzeb.zzd(this.zzasl);
    if (localzzaj == null)
    {
      this.zzasl.zzgt().zzjg().zzby("Discarding data. Failed to send app launch");
      return;
    }
    try
    {
      localzzaj.zza(this.zzaqn);
      this.zzasl.zza(localzzaj, null, this.zzaqn);
      zzeb.zze(this.zzasl);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      this.zzasl.zzgt().zzjg().zzg("Failed to send app launch to the service", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzeh
 * JD-Core Version:    0.6.2
 */