package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzdq;

final class zzej
  implements Runnable
{
  zzej(zzeb paramzzeb, zzag paramzzag, String paramString, zzdq paramzzdq)
  {
  }

  public final void run()
  {
    byte[] arrayOfByte = null;
    try
    {
      zzaj localzzaj = zzeb.zzd(this.zzasl);
      arrayOfByte = null;
      if (localzzaj == null)
      {
        this.zzasl.zzgt().zzjg().zzby("Discarding data. Failed to send event to service to bundle");
        this.zzasl.zzgr().zza(this.zzagg, null);
        return;
      }
      arrayOfByte = localzzaj.zza(this.zzagi, this.zzagj);
      zzeb.zze(this.zzasl);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      this.zzasl.zzgt().zzjg().zzg("Failed to send event to the service to bundle", localRemoteException);
      return;
    }
    finally
    {
      this.zzasl.zzgr().zza(this.zzagg, arrayOfByte);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzej
 * JD-Core Version:    0.6.2
 */