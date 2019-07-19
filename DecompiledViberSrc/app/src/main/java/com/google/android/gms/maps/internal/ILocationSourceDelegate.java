package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;

public abstract interface ILocationSourceDelegate extends IInterface
{
  public abstract void activate(zzah paramzzah)
    throws RemoteException;

  public abstract void deactivate()
    throws RemoteException;

  public static abstract class zza extends zzb
    implements ILocationSourceDelegate
  {
    public zza()
    {
      super();
    }

    protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      IBinder localIBinder;
      Object localObject;
      switch (paramInt1)
      {
      default:
        return false;
      case 1:
        localIBinder = paramParcel1.readStrongBinder();
        if (localIBinder == null)
        {
          localObject = null;
          activate((zzah)localObject);
        }
        break;
      case 2:
      }
      while (true)
      {
        paramParcel2.writeNoException();
        return true;
        IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
        if ((localIInterface instanceof zzah))
        {
          localObject = (zzah)localIInterface;
          break;
        }
        localObject = new zzai(localIBinder);
        break;
        deactivate();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.ILocationSourceDelegate
 * JD-Core Version:    0.6.2
 */