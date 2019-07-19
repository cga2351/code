package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;

public final class zzaag extends zzfm
  implements zzaae
{
  zzaag(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.client.IMuteThisAdListener");
  }

  public final void onAdMuted()
    throws RemoteException
  {
    zza(1, obtainAndWriteInterfaceToken());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaag
 * JD-Core Version:    0.6.2
 */