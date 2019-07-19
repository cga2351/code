package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzage extends zzfm
  implements zzagc
{
  zzage(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
  }

  public final void onUnconfirmedClickCancelled()
    throws RemoteException
  {
    zza(2, obtainAndWriteInterfaceToken());
  }

  public final void onUnconfirmedClickReceived(String paramString)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    zza(1, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzage
 * JD-Core Version:    0.6.2
 */