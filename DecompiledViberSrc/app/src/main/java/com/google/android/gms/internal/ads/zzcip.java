package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

final class zzcip
  implements zzbao<ParcelFileDescriptor>
{
  zzcip(zzcif paramzzcif, zzars paramzzars)
  {
  }

  public final void zzb(Throwable paramThrowable)
  {
    try
    {
      this.zzfxr.zza(zzayn.zza(paramThrowable, zzcgl.zze(paramThrowable)));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zza("Service can't call client", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcip
 * JD-Core Version:    0.6.2
 */