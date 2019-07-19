package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;

public abstract interface IGmsServiceBroker extends IInterface
{
  @KeepForSdk
  public abstract void getService(IGmsCallbacks paramIGmsCallbacks, GetServiceRequest paramGetServiceRequest)
    throws RemoteException;

  public static abstract class Stub extends Binder
    implements IGmsServiceBroker
  {
    public Stub()
    {
      attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
    }

    @KeepForSdk
    public IBinder asBinder()
    {
      return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      if (paramInt1 > 16777215)
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      IBinder localIBinder = paramParcel1.readStrongBinder();
      Object localObject;
      if (localIBinder == null)
      {
        localObject = null;
        if (paramInt1 != 46)
          break label120;
        if (paramParcel1.readInt() == 0)
          break label536;
      }
      label536: for (GetServiceRequest localGetServiceRequest = (GetServiceRequest)GetServiceRequest.CREATOR.createFromParcel(paramParcel1); ; localGetServiceRequest = null)
      {
        getService((IGmsCallbacks)localObject, localGetServiceRequest);
        paramParcel2.writeNoException();
        return true;
        IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
        if ((localIInterface instanceof IGmsCallbacks))
        {
          localObject = (IGmsCallbacks)localIInterface;
          break;
        }
        localObject = new zzl(localIBinder);
        break;
        label120: if (paramInt1 == 47)
        {
          if (paramParcel1.readInt() != 0)
            zzr.CREATOR.createFromParcel(paramParcel1);
          throw new UnsupportedOperationException();
        }
        paramParcel1.readInt();
        if (paramInt1 != 4)
          paramParcel1.readString();
        switch (paramInt1)
        {
        case 3:
        case 4:
        case 21:
        case 22:
        case 24:
        case 26:
        case 28:
        case 29:
        case 31:
        case 32:
        case 33:
        case 35:
        case 36:
        case 39:
        case 40:
        case 42:
        default:
        case 19:
        case 1:
        case 9:
        case 20:
        case 30:
        case 10:
        case 34:
        case 2:
        case 5:
        case 6:
        case 7:
        case 8:
        case 11:
        case 12:
        case 13:
        case 14:
        case 15:
        case 16:
        case 17:
        case 18:
        case 23:
        case 25:
        case 27:
        case 37:
        case 38:
        case 41:
        case 43:
        }
        while (true)
        {
          throw new UnsupportedOperationException();
          paramParcel1.readStrongBinder();
          if (paramParcel1.readInt() != 0)
          {
            Bundle.CREATOR.createFromParcel(paramParcel1);
            continue;
            paramParcel1.readString();
            paramParcel1.createStringArray();
            paramParcel1.readString();
            if (paramParcel1.readInt() != 0)
            {
              Bundle.CREATOR.createFromParcel(paramParcel1);
              continue;
              paramParcel1.readString();
              paramParcel1.createStringArray();
              paramParcel1.readString();
              paramParcel1.readStrongBinder();
              paramParcel1.readString();
              if (paramParcel1.readInt() != 0)
              {
                Bundle.CREATOR.createFromParcel(paramParcel1);
                continue;
                paramParcel1.createStringArray();
                paramParcel1.readString();
                if (paramParcel1.readInt() != 0)
                {
                  Bundle.CREATOR.createFromParcel(paramParcel1);
                  continue;
                  paramParcel1.readString();
                  paramParcel1.createStringArray();
                  continue;
                  paramParcel1.readString();
                  continue;
                  if (paramParcel1.readInt() != 0)
                    Bundle.CREATOR.createFromParcel(paramParcel1);
                }
              }
            }
          }
        }
      }
    }

    private static final class zza
      implements IGmsServiceBroker
    {
      private final IBinder zza;

      zza(IBinder paramIBinder)
      {
        this.zza = paramIBinder;
      }

      public final IBinder asBinder()
      {
        return this.zza;
      }

      public final void getService(IGmsCallbacks paramIGmsCallbacks, GetServiceRequest paramGetServiceRequest)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
          IBinder localIBinder;
          if (paramIGmsCallbacks != null)
          {
            localIBinder = paramIGmsCallbacks.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            if (paramGetServiceRequest == null)
              break label85;
            localParcel1.writeInt(1);
            paramGetServiceRequest.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.zza.transact(46, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            localIBinder = null;
            break;
            label85: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.IGmsServiceBroker
 * JD-Core Version:    0.6.2
 */