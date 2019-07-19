package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzaud extends zzfn
  implements zzauc
{
  public zzaud()
  {
    super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      onRewardedAdLoaded();
    case 2:
    }
    while (true)
    {
      paramParcel2.writeNoException();
      return true;
      onRewardedAdFailedToLoad(paramParcel1.readInt());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaud
 * JD-Core Version:    0.6.2
 */