package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzats extends zzfn
  implements zzatr
{
  public zzats()
  {
    super("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
  }

  public static zzatr zzaj(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
    if ((localIInterface instanceof zzatr))
      return (zzatr)localIInterface;
    return new zzatt(paramIBinder);
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      String str = getType();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str);
    case 2:
    }
    while (true)
    {
      return true;
      int i = getAmount();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(i);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzats
 * JD-Core Version:    0.6.2
 */