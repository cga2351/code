package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzast extends zzfn
  implements zzass
{
  public zzast()
  {
    super("com.google.android.gms.ads.internal.reward.client.IRewardItem");
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
 * Qualified Name:     com.google.android.gms.internal.ads.zzast
 * JD-Core Version:    0.6.2
 */