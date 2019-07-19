package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzcqq
  implements zzbao<zzcrb>
{
  zzcqq(zzcqp paramzzcqp, zzavz paramzzavz)
  {
  }

  public final void zzb(Throwable paramThrowable)
  {
    try
    {
      this.zzgfr.onError("Internal error.");
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcqq
 * JD-Core Version:    0.6.2
 */