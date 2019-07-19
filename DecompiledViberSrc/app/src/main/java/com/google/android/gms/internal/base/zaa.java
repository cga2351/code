package com.google.android.gms.internal.base;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zaa
  implements IInterface
{
  private final IBinder zaa;
  private final String zab;

  protected zaa(IBinder paramIBinder, String paramString)
  {
    this.zaa = paramIBinder;
    this.zab = paramString;
  }

  public IBinder asBinder()
  {
    return this.zaa;
  }

  protected final Parcel zaa()
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.writeInterfaceToken(this.zab);
    return localParcel;
  }

  protected final Parcel zaa(int paramInt, Parcel paramParcel)
    throws RemoteException
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      this.zaa.transact(paramInt, paramParcel, localParcel, 0);
      localParcel.readException();
      return localParcel;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    finally
    {
      paramParcel.recycle();
    }
  }

  protected final void zab(int paramInt, Parcel paramParcel)
    throws RemoteException
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      this.zaa.transact(paramInt, paramParcel, localParcel, 0);
      localParcel.readException();
      return;
    }
    finally
    {
      paramParcel.recycle();
      localParcel.recycle();
    }
  }

  protected final void zac(int paramInt, Parcel paramParcel)
    throws RemoteException
  {
    try
    {
      this.zaa.transact(1, paramParcel, null, 1);
      return;
    }
    finally
    {
      paramParcel.recycle();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.base.zaa
 * JD-Core Version:    0.6.2
 */