package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

final class zzef
  implements Runnable
{
  zzef(zzeb paramzzeb, AtomicReference paramAtomicReference, zzk paramzzk)
  {
  }

  public final void run()
  {
    AtomicReference localAtomicReference = this.zzasm;
    try
    {
      zzaj localzzaj = zzeb.zzd(this.zzasl);
      if (localzzaj == null)
        this.zzasl.zzgt().zzjg().zzby("Failed to get app instance id");
      try
      {
        return;
        this.zzasm.set(localzzaj.zzc(this.zzaqn));
        String str = (String)this.zzasm.get();
        if (str != null)
        {
          this.zzasl.zzgj().zzcp(str);
          this.zzasl.zzgu().zzanj.zzcd(str);
        }
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
        this.zzasl.zzgt().zzjg().zzg("Failed to get app instance id", localRemoteException);
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
 * Qualified Name:     com.google.android.gms.measurement.internal.zzef
 * JD-Core Version:    0.6.2
 */