package com.google.android.gms.internal.gcm;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zzd
  implements IInterface
{
  private final IBinder zzd;
  private final String zze;

  protected zzd(IBinder paramIBinder, String paramString)
  {
    this.zzd = paramIBinder;
    this.zze = paramString;
  }

  public IBinder asBinder()
  {
    return this.zzd;
  }

  protected final Parcel zzd()
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.writeInterfaceToken(this.zze);
    return localParcel;
  }

  protected final void zzd(int paramInt, Parcel paramParcel)
    throws RemoteException
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      this.zzd.transact(2, paramParcel, localParcel, 0);
      localParcel.readException();
      return;
    }
    finally
    {
      paramParcel.recycle();
      localParcel.recycle();
    }
  }

  protected final void zze(int paramInt, Parcel paramParcel)
    throws RemoteException
  {
    try
    {
      this.zzd.transact(1, paramParcel, null, 1);
      return;
    }
    finally
    {
      paramParcel.recycle();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gcm.zzd
 * JD-Core Version:    0.6.2
 */