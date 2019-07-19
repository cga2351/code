package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;

public final class ax
  implements av
{
  private final IBinder a;

  ax(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public final void a(Message paramMessage)
    throws RemoteException
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
    localParcel.writeInt(1);
    paramMessage.writeToParcel(localParcel, 0);
    try
    {
      this.a.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }

  public final IBinder asBinder()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.ax
 * JD-Core Version:    0.6.2
 */