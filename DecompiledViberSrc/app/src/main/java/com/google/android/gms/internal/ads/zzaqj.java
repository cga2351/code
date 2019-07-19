package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzaqj extends zzfm
  implements zzaqh
{
  zzaqj(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
  }

  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeInt(paramInt1);
    localParcel.writeInt(paramInt2);
    zzfo.zza(localParcel, paramIntent);
    zza(12, localParcel);
  }

  public final void onBackPressed()
    throws RemoteException
  {
    zza(10, obtainAndWriteInterfaceToken());
  }

  public final void onCreate(Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramBundle);
    zza(1, localParcel);
  }

  public final void onDestroy()
    throws RemoteException
  {
    zza(8, obtainAndWriteInterfaceToken());
  }

  public final void onPause()
    throws RemoteException
  {
    zza(5, obtainAndWriteInterfaceToken());
  }

  public final void onRestart()
    throws RemoteException
  {
    zza(2, obtainAndWriteInterfaceToken());
  }

  public final void onResume()
    throws RemoteException
  {
    zza(4, obtainAndWriteInterfaceToken());
  }

  public final void onSaveInstanceState(Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramBundle);
    Parcel localParcel2 = transactAndReadException(6, localParcel1);
    if (localParcel2.readInt() != 0)
      paramBundle.readFromParcel(localParcel2);
    localParcel2.recycle();
  }

  public final void onStart()
    throws RemoteException
  {
    zza(3, obtainAndWriteInterfaceToken());
  }

  public final void onStop()
    throws RemoteException
  {
    zza(7, obtainAndWriteInterfaceToken());
  }

  public final void zzac(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zza(13, localParcel);
  }

  public final void zzdd()
    throws RemoteException
  {
    zza(9, obtainAndWriteInterfaceToken());
  }

  public final boolean zztg()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(11, obtainAndWriteInterfaceToken());
    boolean bool = zzfo.zza(localParcel);
    localParcel.recycle();
    return bool;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaqj
 * JD-Core Version:    0.6.2
 */