package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzdq;

final class zzeq
  implements Runnable
{
  zzeq(zzeb paramzzeb, String paramString1, String paramString2, boolean paramBoolean, zzk paramzzk, zzdq paramzzdq)
  {
  }

  public final void run()
  {
    Bundle localBundle = new Bundle();
    try
    {
      zzaj localzzaj = zzeb.zzd(this.zzasl);
      if (localzzaj == null)
      {
        this.zzasl.zzgt().zzjg().zze("Failed to get user properties", this.zzads, this.zzadz);
        return;
      }
      localBundle = zzfx.zzd(localzzaj.zza(this.zzads, this.zzadz, this.zzaeg, this.zzaqn));
      zzeb.zze(this.zzasl);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      this.zzasl.zzgt().zzjg().zze("Failed to get user properties", this.zzads, localRemoteException);
      return;
    }
    finally
    {
      this.zzasl.zzgr().zza(this.zzagg, localBundle);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzeq
 * JD-Core Version:    0.6.2
 */