package org.sqlite.os;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface ICancellationSignal extends IInterface
{
  public abstract void cancel()
    throws RemoteException;

  public static abstract class Stub extends Binder
    implements ICancellationSignal
  {
    private static final String DESCRIPTOR = "org.sqlite.os.ICancellationSignal";
    static final int TRANSACTION_cancel = 1;

    public Stub()
    {
      attachInterface(this, "org.sqlite.os.ICancellationSignal");
    }

    public static ICancellationSignal asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("org.sqlite.os.ICancellationSignal");
      if ((localIInterface != null) && ((localIInterface instanceof ICancellationSignal)))
        return (ICancellationSignal)localIInterface;
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
        paramParcel2.writeString("org.sqlite.os.ICancellationSignal");
        return true;
      case 1:
      }
      paramParcel1.enforceInterface("org.sqlite.os.ICancellationSignal");
      cancel();
      return true;
    }

    private static class Proxy
      implements ICancellationSignal
    {
      private IBinder mRemote;

      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }

      public IBinder asBinder()
      {
        return this.mRemote;
      }

      public void cancel()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("org.sqlite.os.ICancellationSignal");
          this.mRemote.transact(1, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public String getInterfaceDescriptor()
      {
        return "org.sqlite.os.ICancellationSignal";
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.os.ICancellationSignal
 * JD-Core Version:    0.6.2
 */