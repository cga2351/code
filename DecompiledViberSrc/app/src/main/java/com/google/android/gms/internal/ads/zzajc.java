package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public abstract class zzajc extends zzfn
  implements zzajb
{
  public zzajc()
  {
    super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 3:
      zzaap localzzaap = getVideoController();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzaap);
    case 4:
      while (true)
      {
        return true;
        destroy();
        paramParcel2.writeNoException();
      }
    case 5:
    }
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder());
    IBinder localIBinder = paramParcel1.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      zza(localIObjectWrapper, (zzajd)localObject);
      paramParcel2.writeNoException();
      break;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
      if ((localIInterface instanceof zzajd))
        localObject = (zzajd)localIInterface;
      else
        localObject = new zzaje(localIBinder);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzajc
 * JD-Core Version:    0.6.2
 */