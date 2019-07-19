package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzaty extends zzfn
  implements zzatx
{
  public zzaty()
  {
    super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      onRewardedAdOpened();
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      paramParcel2.writeNoException();
      return true;
      onRewardedAdClosed();
      continue;
      IBinder localIBinder = paramParcel1.readStrongBinder();
      Object localObject;
      if (localIBinder == null)
        localObject = null;
      while (true)
      {
        zza((zzatr)localObject);
        break;
        IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
        if ((localIInterface instanceof zzatr))
          localObject = (zzatr)localIInterface;
        else
          localObject = new zzatt(localIBinder);
      }
      onRewardedAdFailedToShow(paramParcel1.readInt());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaty
 * JD-Core Version:    0.6.2
 */