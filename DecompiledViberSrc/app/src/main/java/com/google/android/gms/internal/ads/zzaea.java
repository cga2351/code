package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public abstract class zzaea extends zzfn
  implements zzadz
{
  public zzaea()
  {
    super("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
  }

  public static zzadz zzj(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    if ((localIInterface instanceof zzadz))
      return (zzadz)localIInterface;
    return new zzaeb(paramIBinder);
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 2:
      String str = getText();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str);
    case 3:
    }
    while (true)
    {
      return true;
      List localList = zzra();
      paramParcel2.writeNoException();
      paramParcel2.writeList(localList);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaea
 * JD-Core Version:    0.6.2
 */