package org.onepf.oms;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface IOpenAppstore extends IInterface
{
  public abstract boolean areOutsideLinksAllowed()
    throws RemoteException;

  public abstract String getAppstoreName()
    throws RemoteException;

  public abstract Intent getBillingServiceIntent()
    throws RemoteException;

  public abstract int getPackageVersion(String paramString)
    throws RemoteException;

  public abstract Intent getProductPageIntent(String paramString)
    throws RemoteException;

  public abstract Intent getRateItPageIntent(String paramString)
    throws RemoteException;

  public abstract Intent getSameDeveloperPageIntent(String paramString)
    throws RemoteException;

  public abstract boolean isBillingAvailable(String paramString)
    throws RemoteException;

  public abstract boolean isPackageInstaller(String paramString)
    throws RemoteException;

  public static abstract class Stub extends Binder
    implements IOpenAppstore
  {
    private static final String DESCRIPTOR = "org.onepf.oms.IOpenAppstore";
    static final int TRANSACTION_areOutsideLinksAllowed = 9;
    static final int TRANSACTION_getAppstoreName = 1;
    static final int TRANSACTION_getBillingServiceIntent = 5;
    static final int TRANSACTION_getPackageVersion = 4;
    static final int TRANSACTION_getProductPageIntent = 6;
    static final int TRANSACTION_getRateItPageIntent = 7;
    static final int TRANSACTION_getSameDeveloperPageIntent = 8;
    static final int TRANSACTION_isBillingAvailable = 3;
    static final int TRANSACTION_isPackageInstaller = 2;

    public Stub()
    {
      attachInterface(this, "org.onepf.oms.IOpenAppstore");
    }

    public static IOpenAppstore asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("org.onepf.oms.IOpenAppstore");
      if ((localIInterface != null) && ((localIInterface instanceof IOpenAppstore)))
        return (IOpenAppstore)localIInterface;
      return new Proxy(paramIBinder);
    }

    public IBinder asBinder()
    {
      return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("org.onepf.oms.IOpenAppstore");
        return true;
      case 1:
        paramParcel1.enforceInterface("org.onepf.oms.IOpenAppstore");
        String str = getAppstoreName();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str);
        return true;
      case 2:
        paramParcel1.enforceInterface("org.onepf.oms.IOpenAppstore");
        boolean bool3 = isPackageInstaller(paramParcel1.readString());
        paramParcel2.writeNoException();
        int m = 0;
        if (bool3)
          m = 1;
        paramParcel2.writeInt(m);
        return true;
      case 3:
        paramParcel1.enforceInterface("org.onepf.oms.IOpenAppstore");
        boolean bool2 = isBillingAvailable(paramParcel1.readString());
        paramParcel2.writeNoException();
        int k = 0;
        if (bool2)
          k = 1;
        paramParcel2.writeInt(k);
        return true;
      case 4:
        paramParcel1.enforceInterface("org.onepf.oms.IOpenAppstore");
        int j = getPackageVersion(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(j);
        return true;
      case 5:
        paramParcel1.enforceInterface("org.onepf.oms.IOpenAppstore");
        Intent localIntent4 = getBillingServiceIntent();
        paramParcel2.writeNoException();
        if (localIntent4 != null)
        {
          paramParcel2.writeInt(1);
          localIntent4.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 6:
        paramParcel1.enforceInterface("org.onepf.oms.IOpenAppstore");
        Intent localIntent3 = getProductPageIntent(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localIntent3 != null)
        {
          paramParcel2.writeInt(1);
          localIntent3.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 7:
        paramParcel1.enforceInterface("org.onepf.oms.IOpenAppstore");
        Intent localIntent2 = getRateItPageIntent(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localIntent2 != null)
        {
          paramParcel2.writeInt(1);
          localIntent2.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 8:
        paramParcel1.enforceInterface("org.onepf.oms.IOpenAppstore");
        Intent localIntent1 = getSameDeveloperPageIntent(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localIntent1 != null)
        {
          paramParcel2.writeInt(1);
          localIntent1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 9:
      }
      paramParcel1.enforceInterface("org.onepf.oms.IOpenAppstore");
      boolean bool1 = areOutsideLinksAllowed();
      paramParcel2.writeNoException();
      int i = 0;
      if (bool1)
        i = 1;
      paramParcel2.writeInt(i);
      return true;
    }

    private static class Proxy
      implements IOpenAppstore
    {
      private IBinder mRemote;

      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }

      public boolean areOutsideLinksAllowed()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("org.onepf.oms.IOpenAppstore");
          this.mRemote.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0)
            bool = true;
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public IBinder asBinder()
      {
        return this.mRemote;
      }

      public String getAppstoreName()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("org.onepf.oms.IOpenAppstore");
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public Intent getBillingServiceIntent()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("org.onepf.oms.IOpenAppstore");
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
            return localIntent;
          }
          Intent localIntent = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public String getInterfaceDescriptor()
      {
        return "org.onepf.oms.IOpenAppstore";
      }

      public int getPackageVersion(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("org.onepf.oms.IOpenAppstore");
          localParcel1.writeString(paramString);
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
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

      public Intent getProductPageIntent(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("org.onepf.oms.IOpenAppstore");
          localParcel1.writeString(paramString);
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
            return localIntent;
          }
          Intent localIntent = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public Intent getRateItPageIntent(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("org.onepf.oms.IOpenAppstore");
          localParcel1.writeString(paramString);
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
            return localIntent;
          }
          Intent localIntent = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public Intent getSameDeveloperPageIntent(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("org.onepf.oms.IOpenAppstore");
          localParcel1.writeString(paramString);
          this.mRemote.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
            return localIntent;
          }
          Intent localIntent = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public boolean isBillingAvailable(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("org.onepf.oms.IOpenAppstore");
          localParcel1.writeString(paramString);
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0)
            bool = true;
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public boolean isPackageInstaller(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("org.onepf.oms.IOpenAppstore");
          localParcel1.writeString(paramString);
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0)
            bool = true;
          return bool;
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

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.IOpenAppstore
 * JD-Core Version:    0.6.2
 */