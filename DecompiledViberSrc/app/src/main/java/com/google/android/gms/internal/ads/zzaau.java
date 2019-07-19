package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzaau extends zzfm
  implements zzaas
{
  zzaau(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
  }

  public final void onVideoEnd()
    throws RemoteException
  {
    zza(4, obtainAndWriteInterfaceToken());
  }

  public final void onVideoMute(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.writeBoolean(localParcel, paramBoolean);
    zza(5, localParcel);
  }

  public final void onVideoPause()
    throws RemoteException
  {
    zza(3, obtainAndWriteInterfaceToken());
  }

  public final void onVideoPlay()
    throws RemoteException
  {
    zza(2, obtainAndWriteInterfaceToken());
  }

  public final void onVideoStart()
    throws RemoteException
  {
    zza(1, obtainAndWriteInterfaceToken());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaau
 * JD-Core Version:    0.6.2
 */