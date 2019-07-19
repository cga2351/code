package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

final class zzem
  implements Runnable
{
  zzem(zzeb paramzzeb, boolean paramBoolean1, boolean paramBoolean2, zzag paramzzag, zzk paramzzk, String paramString)
  {
  }

  public final void run()
  {
    zzaj localzzaj = zzeb.zzd(this.zzasl);
    if (localzzaj == null)
    {
      this.zzasl.zzgt().zzjg().zzby("Discarding data. Failed to send event to service");
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
      localObject = this.zzagi;
      break;
      try
      {
        if (!TextUtils.isEmpty(this.zzagj))
          break label125;
        localzzaj.zza(this.zzagi, this.zzaqn);
      }
      catch (RemoteException localRemoteException)
      {
        this.zzasl.zzgt().zzjg().zzg("Failed to send event to the service", localRemoteException);
      }
      continue;
      label125: localzzaj.zza(this.zzagi, this.zzagj, this.zzasl.zzgt().zzjq());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzem
 * JD-Core Version:    0.6.2
 */