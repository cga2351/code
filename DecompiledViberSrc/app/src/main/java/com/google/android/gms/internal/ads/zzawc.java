package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public abstract class zzawc extends zzfn
  implements zzawb
{
  public zzawc()
  {
    super("com.google.android.gms.ads.internal.signals.ISignalGenerator");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder());
      zzawd localzzawd = (zzawd)zzfo.zza(paramParcel1, zzawd.CREATOR);
      IBinder localIBinder = paramParcel1.readStrongBinder();
      Object localObject;
      if (localIBinder == null)
        localObject = null;
      while (true)
      {
        zza(localIObjectWrapper, localzzawd, (zzavz)localObject);
        paramParcel2.writeNoException();
        return true;
        IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalCallback");
        if ((localIInterface instanceof zzavz))
          localObject = (zzavz)localIInterface;
        else
          localObject = new zzawa(localIBinder);
      }
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzawc
 * JD-Core Version:    0.6.2
 */