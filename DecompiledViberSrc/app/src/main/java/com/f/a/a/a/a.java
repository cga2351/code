package com.f.a.a.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface a extends IInterface
{
  public abstract int a(int paramInt, String paramString, Bundle paramBundle)
    throws RemoteException;

  public abstract int a(int paramInt, String paramString1, String paramString2)
    throws RemoteException;

  public abstract int a(int paramInt, String paramString1, String paramString2, String paramString3)
    throws RemoteException;

  public abstract Bundle a(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException;

  public abstract Bundle a(int paramInt, String paramString1, String paramString2, Bundle paramBundle, String paramString3)
    throws RemoteException;

  public abstract Bundle a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
    throws RemoteException;

  public static abstract class a extends Binder
    implements a
  {
    public static a a(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.nokia.payment.iap.aidl.INokiaIAPService");
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
        paramParcel2.writeString("com.nokia.payment.iap.aidl.INokiaIAPService");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.nokia.payment.iap.aidl.INokiaIAPService");
        int i3 = a(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(i3);
        return true;
      case 2:
        paramParcel1.enforceInterface("com.nokia.payment.iap.aidl.INokiaIAPService");
        int i1 = paramParcel1.readInt();
        String str4 = paramParcel1.readString();
        String str5 = paramParcel1.readString();
        int i2 = paramParcel1.readInt();
        Bundle localBundle5 = null;
        if (i2 != 0)
          localBundle5 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        Bundle localBundle6 = a(i1, str4, str5, localBundle5);
        paramParcel2.writeNoException();
        if (localBundle6 != null)
        {
          paramParcel2.writeInt(1);
          localBundle6.writeToParcel(paramParcel2, 1);
        }
        while (true)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      case 3:
        paramParcel1.enforceInterface("com.nokia.payment.iap.aidl.INokiaIAPService");
        Bundle localBundle4 = a(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localBundle4 != null)
        {
          paramParcel2.writeInt(1);
          localBundle4.writeToParcel(paramParcel2, 1);
        }
        while (true)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      case 4:
        paramParcel1.enforceInterface("com.nokia.payment.iap.aidl.INokiaIAPService");
        int n = paramParcel1.readInt();
        String str2 = paramParcel1.readString();
        String str3 = paramParcel1.readString();
        Bundle localBundle2;
        if (paramParcel1.readInt() != 0)
        {
          localBundle2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          Bundle localBundle3 = a(n, str2, str3, localBundle2, paramParcel1.readString());
          paramParcel2.writeNoException();
          if (localBundle3 == null)
            break label374;
          paramParcel2.writeInt(1);
          localBundle3.writeToParcel(paramParcel2, 1);
        }
        while (true)
        {
          return true;
          localBundle2 = null;
          break;
          paramParcel2.writeInt(0);
        }
      case 5:
        label374: paramParcel1.enforceInterface("com.nokia.payment.iap.aidl.INokiaIAPService");
        int m = a(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(m);
        return true;
      case 6:
      }
      paramParcel1.enforceInterface("com.nokia.payment.iap.aidl.INokiaIAPService");
      int i = paramParcel1.readInt();
      String str1 = paramParcel1.readString();
      int j = paramParcel1.readInt();
      Bundle localBundle1 = null;
      if (j != 0)
        localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      int k = a(i, str1, localBundle1);
      paramParcel2.writeNoException();
      paramParcel2.writeInt(k);
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

      public int a(int paramInt, String paramString, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.nokia.payment.iap.aidl.INokiaIAPService");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.a.transact(6, localParcel1, localParcel2, 0);
            localParcel2.readException();
            int i = localParcel2.readInt();
            return i;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public int a(int paramInt, String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.nokia.payment.iap.aidl.INokiaIAPService");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          this.a.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public int a(int paramInt, String paramString1, String paramString2, String paramString3)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.nokia.payment.iap.aidl.INokiaIAPService");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          this.a.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public Bundle a(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.nokia.payment.iap.aidl.INokiaIAPService");
            localParcel1.writeInt(paramInt);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              this.a.transact(2, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return localBundle;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          Bundle localBundle = null;
        }
      }

      public Bundle a(int paramInt, String paramString1, String paramString2, Bundle paramBundle, String paramString3)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.nokia.payment.iap.aidl.INokiaIAPService");
            localParcel1.writeInt(paramInt);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              localParcel1.writeString(paramString3);
              this.a.transact(4, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return localBundle;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          Bundle localBundle = null;
        }
      }

      public Bundle a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.nokia.payment.iap.aidl.INokiaIAPService");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          localParcel1.writeString(paramString4);
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

      public IBinder asBinder()
      {
        return this.a;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.f.a.a.a.a
 * JD-Core Version:    0.6.2
 */