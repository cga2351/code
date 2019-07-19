package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

final class zzep
  implements Runnable
{
  zzep(zzeb paramzzeb, AtomicReference paramAtomicReference, String paramString1, String paramString2, String paramString3, boolean paramBoolean, zzk paramzzk)
  {
  }

  public final void run()
  {
    AtomicReference localAtomicReference = this.zzasm;
    try
    {
      zzaj localzzaj = zzeb.zzd(this.zzasl);
      if (localzzaj == null)
      {
        this.zzasl.zzgt().zzjg().zzd("Failed to get user properties", zzas.zzbw(this.zzagj), this.zzads, this.zzadz);
        this.zzasm.set(Collections.emptyList());
      }
      while (true)
      {
        try
        {
          return;
          if (TextUtils.isEmpty(this.zzagj))
          {
            this.zzasm.set(localzzaj.zza(this.zzads, this.zzadz, this.zzaeg, this.zzaqn));
            zzeb.zze(this.zzasl);
            return;
          }
        }
        finally
        {
        }
        this.zzasm.set(localzzaj.zza(this.zzagj, this.zzads, this.zzadz, this.zzaeg));
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        this.zzasl.zzgt().zzjg().zzd("Failed to get user properties", zzas.zzbw(this.zzagj), this.zzads, localRemoteException);
        this.zzasm.set(Collections.emptyList());
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
 * Qualified Name:     com.google.android.gms.measurement.internal.zzep
 * JD-Core Version:    0.6.2
 */