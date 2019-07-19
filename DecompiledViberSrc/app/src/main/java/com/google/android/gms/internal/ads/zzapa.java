package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzapa extends zzfn
  implements zzaoz
{
  public zzapa()
  {
    super("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      zzdc(paramParcel1.readString());
    case 2:
    }
    while (true)
    {
      paramParcel2.writeNoException();
      return true;
      onFailure(paramParcel1.readString());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzapa
 * JD-Core Version:    0.6.2
 */