package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzdq;

final class zzeg
  implements Runnable
{
  zzeg(zzeb paramzzeb, zzk paramzzk, zzdq paramzzdq)
  {
  }

  public final void run()
  {
    String str = null;
    try
    {
      zzaj localzzaj = zzeb.zzd(this.zzasl);
      str = null;
      if (localzzaj == null)
      {
        this.zzasl.zzgt().zzjg().zzby("Failed to get app instance id");
        this.zzasl.zzgr().zzb(this.zzagg, null);
        return;
      }
      str = localzzaj.zzc(this.zzaqn);
      if (str != null)
      {
        this.zzasl.zzgj().zzcp(str);
        this.zzasl.zzgu().zzanj.zzcd(str);
      }
      zzeb.zze(this.zzasl);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      this.zzasl.zzgt().zzjg().zzg("Failed to get app instance id", localRemoteException);
      return;
    }
    finally
    {
      this.zzasl.zzgr().zzb(this.zzagg, str);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzeg
 * JD-Core Version:    0.6.2
 */