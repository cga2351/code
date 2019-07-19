package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzagd extends zzfn
  implements zzagc
{
  public zzagd()
  {
    super("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      onUnconfirmedClickReceived(paramParcel1.readString());
    case 2:
    }
    while (true)
    {
      paramParcel2.writeNoException();
      return true;
      onUnconfirmedClickCancelled();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzagd
 * JD-Core Version:    0.6.2
 */