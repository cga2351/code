package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;

public final class zzzp extends zzfm
  implements zzzn
{
  zzzp(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.client.IAdMetadataListener");
  }

  public final void onAdMetadataChanged()
    throws RemoteException
  {
    zza(1, obtainAndWriteInterfaceToken());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzzp
 * JD-Core Version:    0.6.2
 */