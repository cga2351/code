package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

final class zzen
  implements Runnable
{
  zzen(zzeb paramzzeb, boolean paramBoolean1, boolean paramBoolean2, zzo paramzzo1, zzk paramzzk, zzo paramzzo2)
  {
  }

  public final void run()
  {
    zzaj localzzaj = zzeb.zzd(this.zzasl);
    if (localzzaj == null)
    {
      this.zzasl.zzgt().zzjg().zzby("Discarding data. Failed to send conditional user property to service");
      return;
    }
    Object localObject;
    if (this.zzasn)
    {
      zzeb localzzeb = this.zzasl;
      if (this.zzaso)
      {
        localObject = null;
        localzzeb.zza(localzzaj, (AbstractSafeParcelable)localObject, this.zzaqn);
      }
    }
    while (true)
    {
      zzeb.zze(this.zzasl);
      return;
      localObject = this.zzasp;
      break;
      try
      {
        if (!TextUtils.isEmpty(this.zzasq.packageName))
          break label128;
        localzzaj.zza(this.zzasp, this.zzaqn);
      }
      catch (RemoteException localRemoteException)
      {
        this.zzasl.zzgt().zzjg().zzg("Failed to send conditional user property to the service", localRemoteException);
      }
      continue;
      label128: localzzaj.zzb(this.zzasp);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzen
 * JD-Core Version:    0.6.2
 */