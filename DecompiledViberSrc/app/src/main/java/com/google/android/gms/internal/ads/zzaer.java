package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public abstract class zzaer extends zzfn
  implements zzaeq
{
  public zzaer()
  {
    super("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
  }

  public static zzaeq zzm(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    if ((localIInterface instanceof zzaeq))
      return (zzaeq)localIInterface;
    return new zzaes(paramIBinder);
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      zze(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
    case 2:
    case 3:
    }
    while (true)
    {
      paramParcel2.writeNoException();
      return true;
      unregisterNativeAd();
      continue;
      zzi(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaer
 * JD-Core Version:    0.6.2
 */