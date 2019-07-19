package com.sec.android.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface a extends IInterface
{
  public abstract Bundle a(int paramInt)
    throws RemoteException;

  public abstract Bundle a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3)
    throws RemoteException;

  public abstract Bundle a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
    throws RemoteException;

  public abstract boolean a(b paramb)
    throws RemoteException;

  public abstract boolean a(b paramb, Bundle paramBundle)
    throws RemoteException;

  public static abstract class a extends Binder
    implements a
  {
    public static a a(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.sec.android.iap.IAPConnector");
      if ((localIInterface != null) && ((localIInterface instanceof a)))
        return (a)localIInterface;
      return new a(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.sec.android.iap.IAPConnector");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.sec.android.iap.IAPConnector");
        b localb = b.a.a(paramParcel1.readStrongBinder());
        Bundle localBundle4;
        if (paramParcel1.readInt() != 0)
        {
          localBundle4 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          boolean bool2 = a(localb, localBundle4);
          paramParcel2.writeNoException();
          if (!bool2)
            break label150;
        }
        for (int j = 1; ; j = 0)
        {
          paramParcel2.writeInt(j);
          return true;
          localBundle4 = null;
          break;
        }
      case 2:
        paramParcel1.enforceInterface("com.sec.android.iap.IAPConnector");
        boolean bool1 = a(b.a.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        int i = 0;
        if (bool1)
          i = 1;
        paramParcel2.writeInt(i);
        return true;
      case 3:
        paramParcel1.enforceInterface("com.sec.android.iap.IAPConnector");
        Bundle localBundle3 = a(paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (localBundle3 != null)
        {
          paramParcel2.writeInt(1);
          localBundle3.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 4:
        label150: paramParcel1.enforceInterface("com.sec.android.iap.IAPConnector");
        Bundle localBundle2 = a(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localBundle2 != null)
        {
          paramParcel2.writeInt(1);
          localBundle2.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 5:
      }
      paramParcel1.enforceInterface("com.sec.android.iap.IAPConnector");
      Bundle localBundle1 = a(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      if (localBundle1 != null)
      {
        paramParcel2.writeInt(1);
        localBundle1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    }

    private static class a
      implements a
    {
      private IBinder a;

      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }

      public Bundle a(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.sec.android.iap.IAPConnector");
          localParcel1.writeInt(paramInt);
          this.a.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return localBundle;
          }
          Bundle localBundle = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public Bundle a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.sec.android.iap.IAPConnector");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeInt(paramInt3);
          localParcel1.writeString(paramString3);
          this.a.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return localBundle;
          }
          Bundle localBundle = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public Bundle a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.sec.android.iap.IAPConnector");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeString(paramString3);
          localParcel1.writeString(paramString4);
          this.a.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return localBundle;
          }
          Bundle localBundle = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public boolean a(b paramb)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.sec.android.iap.IAPConnector");
          if (paramb != null);
          for (IBinder localIBinder = paramb.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.a.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
            int i = localParcel2.readInt();
            boolean bool = false;
            if (i != 0)
              bool = true;
            return bool;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public boolean a(b paramb, Bundle paramBundle)
        throws RemoteException
      {
        boolean bool = true;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.sec.android.iap.IAPConnector");
            IBinder localIBinder;
            if (paramb != null)
            {
              localIBinder = paramb.asBinder();
              localParcel1.writeStrongBinder(localIBinder);
              if (paramBundle != null)
              {
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                this.a.transact(1, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                if (i == 0)
                  break label130;
                return bool;
              }
            }
            else
            {
              localIBinder = null;
              continue;
            }
            localParcel1.writeInt(0);
            continue;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          label130: bool = false;
        }
      }

      public IBinder asBinder()
      {
        return this.a;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.sec.android.a.a
 * JD-Core Version:    0.6.2
 */