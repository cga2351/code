package com.viber.voip;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface ah extends IInterface
{
  public abstract void a(VideoConverterPreparedRequest paramVideoConverterPreparedRequest)
    throws RemoteException;

  public abstract void a(VideoConverterPreparedRequest paramVideoConverterPreparedRequest, int paramInt)
    throws RemoteException;

  public abstract void a(VideoConverterPreparedRequest paramVideoConverterPreparedRequest, VideoConverterReply paramVideoConverterReply)
    throws RemoteException;

  public abstract void a(VideoConverterPreparedRequest paramVideoConverterPreparedRequest, String paramString)
    throws RemoteException;

  public static abstract class a extends Binder
    implements ah
  {
    public a()
    {
      attachInterface(this, "com.viber.voip.IVideoConverterProgressCallback");
    }

    public static ah a(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.viber.voip.IVideoConverterProgressCallback");
      if ((localIInterface != null) && ((localIInterface instanceof ah)))
        return (ah)localIInterface;
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
        paramParcel2.writeString("com.viber.voip.IVideoConverterProgressCallback");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.viber.voip.IVideoConverterProgressCallback");
        if (paramParcel1.readInt() != 0);
        for (VideoConverterPreparedRequest localVideoConverterPreparedRequest4 = (VideoConverterPreparedRequest)VideoConverterPreparedRequest.CREATOR.createFromParcel(paramParcel1); ; localVideoConverterPreparedRequest4 = null)
        {
          a(localVideoConverterPreparedRequest4);
          return true;
        }
      case 2:
        paramParcel1.enforceInterface("com.viber.voip.IVideoConverterProgressCallback");
        if (paramParcel1.readInt() != 0);
        for (VideoConverterPreparedRequest localVideoConverterPreparedRequest3 = (VideoConverterPreparedRequest)VideoConverterPreparedRequest.CREATOR.createFromParcel(paramParcel1); ; localVideoConverterPreparedRequest3 = null)
        {
          a(localVideoConverterPreparedRequest3, paramParcel1.readInt());
          return true;
        }
      case 3:
        paramParcel1.enforceInterface("com.viber.voip.IVideoConverterProgressCallback");
        VideoConverterPreparedRequest localVideoConverterPreparedRequest2;
        if (paramParcel1.readInt() != 0)
        {
          localVideoConverterPreparedRequest2 = (VideoConverterPreparedRequest)VideoConverterPreparedRequest.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label220;
        }
        label220: for (VideoConverterReply localVideoConverterReply = (VideoConverterReply)VideoConverterReply.CREATOR.createFromParcel(paramParcel1); ; localVideoConverterReply = null)
        {
          a(localVideoConverterPreparedRequest2, localVideoConverterReply);
          return true;
          localVideoConverterPreparedRequest2 = null;
          break;
        }
      case 4:
      }
      paramParcel1.enforceInterface("com.viber.voip.IVideoConverterProgressCallback");
      if (paramParcel1.readInt() != 0);
      for (VideoConverterPreparedRequest localVideoConverterPreparedRequest1 = (VideoConverterPreparedRequest)VideoConverterPreparedRequest.CREATOR.createFromParcel(paramParcel1); ; localVideoConverterPreparedRequest1 = null)
      {
        a(localVideoConverterPreparedRequest1, paramParcel1.readString());
        return true;
      }
    }

    private static class a
      implements ah
    {
      private IBinder a;

      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }

      public void a(VideoConverterPreparedRequest paramVideoConverterPreparedRequest)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.viber.voip.IVideoConverterProgressCallback");
          if (paramVideoConverterPreparedRequest != null)
          {
            localParcel.writeInt(1);
            paramVideoConverterPreparedRequest.writeToParcel(localParcel, 0);
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

      public void a(VideoConverterPreparedRequest paramVideoConverterPreparedRequest, int paramInt)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.viber.voip.IVideoConverterProgressCallback");
          if (paramVideoConverterPreparedRequest != null)
          {
            localParcel.writeInt(1);
            paramVideoConverterPreparedRequest.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            localParcel.writeInt(paramInt);
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

      public void a(VideoConverterPreparedRequest paramVideoConverterPreparedRequest, VideoConverterReply paramVideoConverterReply)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.viber.voip.IVideoConverterProgressCallback");
            if (paramVideoConverterPreparedRequest != null)
            {
              localParcel.writeInt(1);
              paramVideoConverterPreparedRequest.writeToParcel(localParcel, 0);
              if (paramVideoConverterReply != null)
              {
                localParcel.writeInt(1);
                paramVideoConverterReply.writeToParcel(localParcel, 0);
                this.a.transact(3, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel.recycle();
          }
          localParcel.writeInt(0);
        }
      }

      public void a(VideoConverterPreparedRequest paramVideoConverterPreparedRequest, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.viber.voip.IVideoConverterProgressCallback");
          if (paramVideoConverterPreparedRequest != null)
          {
            localParcel.writeInt(1);
            paramVideoConverterPreparedRequest.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            localParcel.writeString(paramString);
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

      public IBinder asBinder()
      {
        return this.a;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ah
 * JD-Core Version:    0.6.2
 */