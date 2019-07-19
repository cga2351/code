package com.viber.voip;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface ai extends IInterface
{
  public abstract void a(int paramInt)
    throws RemoteException;

  public abstract void a(VideoConverterPreparedRequest paramVideoConverterPreparedRequest)
    throws RemoteException;

  public abstract void a(VideoConverterPreparedRequest paramVideoConverterPreparedRequest, int paramInt)
    throws RemoteException;

  public abstract void b(VideoConverterPreparedRequest paramVideoConverterPreparedRequest, int paramInt)
    throws RemoteException;

  public static abstract class a extends Binder
    implements ai
  {
    public static ai a(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.viber.voip.IVideoConverterStatusCallback");
      if ((localIInterface != null) && ((localIInterface instanceof ai)))
        return (ai)localIInterface;
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
        paramParcel2.writeString("com.viber.voip.IVideoConverterStatusCallback");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.viber.voip.IVideoConverterStatusCallback");
        int k = paramParcel1.readInt();
        VideoConverterPreparedRequest localVideoConverterPreparedRequest3 = null;
        if (k != 0)
          localVideoConverterPreparedRequest3 = (VideoConverterPreparedRequest)VideoConverterPreparedRequest.CREATOR.createFromParcel(paramParcel1);
        a(localVideoConverterPreparedRequest3, paramParcel1.readInt());
        return true;
      case 2:
        paramParcel1.enforceInterface("com.viber.voip.IVideoConverterStatusCallback");
        int j = paramParcel1.readInt();
        VideoConverterPreparedRequest localVideoConverterPreparedRequest2 = null;
        if (j != 0)
          localVideoConverterPreparedRequest2 = (VideoConverterPreparedRequest)VideoConverterPreparedRequest.CREATOR.createFromParcel(paramParcel1);
        a(localVideoConverterPreparedRequest2);
        return true;
      case 3:
        paramParcel1.enforceInterface("com.viber.voip.IVideoConverterStatusCallback");
        int i = paramParcel1.readInt();
        VideoConverterPreparedRequest localVideoConverterPreparedRequest1 = null;
        if (i != 0)
          localVideoConverterPreparedRequest1 = (VideoConverterPreparedRequest)VideoConverterPreparedRequest.CREATOR.createFromParcel(paramParcel1);
        b(localVideoConverterPreparedRequest1, paramParcel1.readInt());
        return true;
      case 4:
      }
      paramParcel1.enforceInterface("com.viber.voip.IVideoConverterStatusCallback");
      a(paramParcel1.readInt());
      return true;
    }

    private static class a
      implements ai
    {
      private IBinder a;

      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }

      public void a(int paramInt)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.viber.voip.IVideoConverterStatusCallback");
          localParcel.writeInt(paramInt);
          this.a.transact(4, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(VideoConverterPreparedRequest paramVideoConverterPreparedRequest)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.viber.voip.IVideoConverterStatusCallback");
          if (paramVideoConverterPreparedRequest != null)
          {
            localParcel.writeInt(1);
            paramVideoConverterPreparedRequest.writeToParcel(localParcel, 0);
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

      public void a(VideoConverterPreparedRequest paramVideoConverterPreparedRequest, int paramInt)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.viber.voip.IVideoConverterStatusCallback");
          if (paramVideoConverterPreparedRequest != null)
          {
            localParcel.writeInt(1);
            paramVideoConverterPreparedRequest.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            localParcel.writeInt(paramInt);
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

      public IBinder asBinder()
      {
        return this.a;
      }

      public void b(VideoConverterPreparedRequest paramVideoConverterPreparedRequest, int paramInt)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.viber.voip.IVideoConverterStatusCallback");
          if (paramVideoConverterPreparedRequest != null)
          {
            localParcel.writeInt(1);
            paramVideoConverterPreparedRequest.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            localParcel.writeInt(paramInt);
            this.a.transact(3, localParcel, null, 1);
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

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ai
 * JD-Core Version:    0.6.2
 */