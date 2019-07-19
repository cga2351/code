package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzaiq extends zzfn
  implements zzaip
{
  public zzaiq()
  {
    super("com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
  }

  public static zzaip zzv(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
    if ((localIInterface instanceof zzaip))
      return (zzaip)localIInterface;
    return new zzair(paramIBinder);
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 2:
      onInitializationSucceeded();
    case 3:
    }
    while (true)
    {
      paramParcel2.writeNoException();
      return true;
      onInitializationFailed(paramParcel1.readString());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaiq
 * JD-Core Version:    0.6.2
 */