package com.viber.voip;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface ag extends IInterface
{
  public abstract VideoConverterPreparedRequest a(VideoConverterRequest paramVideoConverterRequest)
    throws RemoteException;

  public abstract ag a()
    throws RemoteException;

  public abstract String a(String paramString)
    throws RemoteException;

  public abstract void a(VideoConverterPreparedRequest paramVideoConverterPreparedRequest)
    throws RemoteException;

  public abstract void a(VideoConverterPreparedRequest paramVideoConverterPreparedRequest, ah paramah)
    throws RemoteException;

  public abstract void a(ai paramai)
    throws RemoteException;

  public abstract void b(ai paramai)
    throws RemoteException;

  public static abstract class a extends Binder
    implements ag
  {
    public a()
    {
      attachInterface(this, "com.viber.voip.IVideoConverter");
    }

    public static ag a(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.viber.voip.IVideoConverter");
      if ((localIInterface != null) && ((localIInterface instanceof ag)))
        return (ag)localIInterface;
      return new a(paramIBinder);
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
        paramParcel2.writeString("com.viber.voip.IVideoConverter");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.viber.voip.IVideoConverter");
        a(ai.a.a(paramParcel1.readStrongBinder()));
        return true;
      case 2:
        paramParcel1.enforceInterface("com.viber.voip.IVideoConverter");
        b(ai.a.a(paramParcel1.readStrongBinder()));
        return true;
      case 3:
        paramParcel1.enforceInterface("com.viber.voip.IVideoConverter");
        int k = paramParcel1.readInt();
        VideoConverterRequest localVideoConverterRequest = null;
        if (k != 0)
          localVideoConverterRequest = (VideoConverterRequest)VideoConverterRequest.CREATOR.createFromParcel(paramParcel1);
        VideoConverterPreparedRequest localVideoConverterPreparedRequest3 = a(localVideoConverterRequest);
        paramParcel2.writeNoException();
        if (localVideoConverterPreparedRequest3 != null)
        {
          paramParcel2.writeInt(1);
          localVideoConverterPreparedRequest3.writeToParcel(paramParcel2, 1);
        }
        while (true)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      case 4:
        paramParcel1.enforceInterface("com.viber.voip.IVideoConverter");
        int j = paramParcel1.readInt();
        VideoConverterPreparedRequest localVideoConverterPreparedRequest2 = null;
        if (j != 0)
          localVideoConverterPreparedRequest2 = (VideoConverterPreparedRequest)VideoConverterPreparedRequest.CREATOR.createFromParcel(paramParcel1);
        a(localVideoConverterPreparedRequest2, ah.a.a(paramParcel1.readStrongBinder()));
        return true;
      case 5:
        paramParcel1.enforceInterface("com.viber.voip.IVideoConverter");
        int i = paramParcel1.readInt();
        VideoConverterPreparedRequest localVideoConverterPreparedRequest1 = null;
        if (i != 0)
          localVideoConverterPreparedRequest1 = (VideoConverterPreparedRequest)VideoConverterPreparedRequest.CREATOR.createFromParcel(paramParcel1);
        a(localVideoConverterPreparedRequest1);
        return true;
      case 6:
        paramParcel1.enforceInterface("com.viber.voip.IVideoConverter");
        String str = a(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(str);
        return true;
      case 7:
      }
      paramParcel1.enforceInterface("com.viber.voip.IVideoConverter");
      ag localag = a();
      paramParcel2.writeNoException();
      IBinder localIBinder = null;
      if (localag != null)
        localIBinder = localag.asBinder();
      paramParcel2.writeStrongBinder(localIBinder);
      return true;
    }

    private static class a
      implements ag
    {
      private IBinder a;

      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }

      public VideoConverterPreparedRequest a(VideoConverterRequest paramVideoConverterRequest)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.viber.voip.IVideoConverter");
            if (paramVideoConverterRequest != null)
            {
              localParcel1.writeInt(1);
              paramVideoConverterRequest.writeToParcel(localParcel1, 0);
              this.a.transact(3, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                localVideoConverterPreparedRequest = (VideoConverterPreparedRequest)VideoConverterPreparedRequest.CREATOR.createFromParcel(localParcel2);
                return localVideoConverterPreparedRequest;
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
          VideoConverterPreparedRequest localVideoConverterPreparedRequest = null;
        }
      }

      public ag a()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.viber.voip.IVideoConverter");
          this.a.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          ag localag = ag.a.a(localParcel2.readStrongBinder());
          return localag;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public String a(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.viber.voip.IVideoConverter");
          localParcel1.writeString(paramString);
          this.a.transact(6, localParcel1, localParcel2, 0);
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

      public void a(VideoConverterPreparedRequest paramVideoConverterPreparedRequest)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.viber.voip.IVideoConverter");
          if (paramVideoConverterPreparedRequest != null)
          {
            localParcel.writeInt(1);
            paramVideoConverterPreparedRequest.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            this.a.transact(5, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(VideoConverterPreparedRequest paramVideoConverterPreparedRequest, ah paramah)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.viber.voip.IVideoConverter");
          if (paramVideoConverterPreparedRequest != null)
          {
            localParcel.writeInt(1);
            paramVideoConverterPreparedRequest.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            IBinder localIBinder = null;
            if (paramah != null)
              localIBinder = paramah.asBinder();
            localParcel.writeStrongBinder(localIBinder);
            this.a.transact(4, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(ai paramai)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.viber.voip.IVideoConverter");
          IBinder localIBinder = null;
          if (paramai != null)
            localIBinder = paramai.asBinder();
          localParcel.writeStrongBinder(localIBinder);
          this.a.transact(1, localParcel, null, 1);
          return;
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

      public void b(ai paramai)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.viber.voip.IVideoConverter");
          IBinder localIBinder = null;
          if (paramai != null)
            localIBinder = paramai.asBinder();
          localParcel.writeStrongBinder(localIBinder);
          this.a.transact(2, localParcel, null, 1);
          return;
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
 * Qualified Name:     com.viber.voip.ag
 * JD-Core Version:    0.6.2
 */