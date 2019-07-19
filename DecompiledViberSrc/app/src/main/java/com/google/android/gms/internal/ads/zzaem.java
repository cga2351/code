package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public abstract class zzaem extends zzfn
  implements zzael
{
  public zzaem()
  {
    super("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
  }

  public static zzael zzl(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    if ((localIInterface instanceof zzael))
      return (zzael)localIInterface;
    return new zzaen(paramIBinder);
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      zzc(paramParcel1.readString(), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    }
    while (true)
    {
      return true;
      IObjectWrapper localIObjectWrapper = zzcf(paramParcel1.readString());
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localIObjectWrapper);
      continue;
      zze(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      destroy();
      paramParcel2.writeNoException();
      continue;
      zzc(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      paramParcel2.writeNoException();
      continue;
      zzi(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaem
 * JD-Core Version:    0.6.2
 */