package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

final class zzed
  implements Runnable
{
  zzed(zzeb paramzzeb, AtomicReference paramAtomicReference, zzk paramzzk, boolean paramBoolean)
  {
  }

  public final void run()
  {
    AtomicReference localAtomicReference = this.zzasm;
    try
    {
      zzaj localzzaj = zzeb.zzd(this.zzasl);
      if (localzzaj == null)
        this.zzasl.zzgt().zzjg().zzby("Failed to get user properties");
      try
      {
        return;
        this.zzasm.set(localzzaj.zza(this.zzaqn, this.zzaeg));
        zzeb.zze(this.zzasl);
        return;
      }
      finally
      {
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        this.zzasl.zzgt().zzjg().zzg("Failed to get user properties", localRemoteException);
        this.zzasm.notify();
      }
    }
    finally
    {
      this.zzasm.notify();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzed
 * JD-Core Version:    0.6.2
 */