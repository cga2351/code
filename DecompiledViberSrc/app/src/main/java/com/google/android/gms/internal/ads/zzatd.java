package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzatd extends zzfn
  implements zzatc
{
  public zzatd()
  {
    super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
  }

  public static zzatc zzah(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    if ((localIInterface instanceof zzatc))
      return (zzatc)localIInterface;
    return new zzate(paramIBinder);
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      onRewardedVideoAdLoaded();
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    }
    while (true)
    {
      paramParcel2.writeNoException();
      return true;
      onRewardedVideoAdOpened();
      continue;
      onRewardedVideoStarted();
      continue;
      onRewardedVideoAdClosed();
      continue;
      IBinder localIBinder = paramParcel1.readStrongBinder();
      Object localObject;
      if (localIBinder == null)
        localObject = null;
      while (true)
      {
        zza((zzass)localObject);
        break;
        IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardItem");
        if ((localIInterface instanceof zzass))
          localObject = (zzass)localIInterface;
        else
          localObject = new zzasu(localIBinder);
      }
      onRewardedVideoAdLeftApplication();
      continue;
      onRewardedVideoAdFailedToLoad(paramParcel1.readInt());
      continue;
      onRewardedVideoCompleted();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzatd
 * JD-Core Version:    0.6.2
 */