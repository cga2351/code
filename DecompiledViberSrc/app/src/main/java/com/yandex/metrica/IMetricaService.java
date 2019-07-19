package com.yandex.metrica;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface IMetricaService extends IInterface
{
  public abstract void reportData(Bundle paramBundle)
    throws RemoteException;

  public abstract void reportEvent(String paramString1, int paramInt, String paramString2, Bundle paramBundle)
    throws RemoteException;

  public static abstract class Stub extends Binder
    implements IMetricaService
  {
    public Stub()
    {
      attachInterface(this, "com.yandex.metrica.IMetricaService");
    }

    public static IMetricaService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.yandex.metrica.IMetricaService");
      if ((localIInterface != null) && ((localIInterface instanceof IMetricaService)))
        return (IMetricaService)localIInterface;
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
        paramParcel2.writeString("com.yandex.metrica.IMetricaService");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.yandex.metrica.IMetricaService");
        String str1 = paramParcel1.readString();
        int j = paramParcel1.readInt();
        String str2 = paramParcel1.readString();
        int k = paramParcel1.readInt();
        Bundle localBundle2 = null;
        if (k != 0)
          localBundle2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        reportEvent(str1, j, str2, localBundle2);
        return true;
      case 2:
      }
      paramParcel1.enforceInterface("com.yandex.metrica.IMetricaService");
      int i = paramParcel1.readInt();
      Bundle localBundle1 = null;
      if (i != 0)
        localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      reportData(localBundle1);
      return true;
    }

    private static class Proxy
      implements IMetricaService
    {
      private IBinder a;

      Proxy(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }

      public IBinder asBinder()
      {
        return this.a;
      }

      public void reportData(Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.yandex.metrica.IMetricaService");
          if (paramBundle != null)
          {
            localParcel.writeInt(1);
            paramBundle.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            this.a.transact(2, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void reportEvent(String paramString1, int paramInt, String paramString2, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.yandex.metrica.IMetricaService");
          localParcel.writeString(paramString1);
          localParcel.writeInt(paramInt);
          localParcel.writeString(paramString2);
          if (paramBundle != null)
          {
            localParcel.writeInt(1);
            paramBundle.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            this.a.transact(1, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.IMetricaService
 * JD-Core Version:    0.6.2
 */