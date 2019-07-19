package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzaaj extends zzfn
  implements zzaai
{
  public zzaaj()
  {
    super("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
  }

  public static zzaai zzf(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    if ((localIInterface instanceof zzaai))
      return (zzaai)localIInterface;
    return new zzaak(paramIBinder);
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      String str2 = getDescription();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str2);
    case 2:
    }
    while (true)
    {
      return true;
      String str1 = zzpt();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str1);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaaj
 * JD-Core Version:    0.6.2
 */