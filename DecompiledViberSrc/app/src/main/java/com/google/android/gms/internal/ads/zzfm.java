package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zzfm
  implements IInterface
{
  private final IBinder zzaad;
  private final String zzaae;

  protected zzfm(IBinder paramIBinder, String paramString)
  {
    this.zzaad = paramIBinder;
    this.zzaae = paramString;
  }

  public IBinder asBinder()
  {
    return this.zzaad;
  }

  protected final Parcel obtainAndWriteInterfaceToken()
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.writeInterfaceToken(this.zzaae);
    return localParcel;
  }

  protected final Parcel transactAndReadException(int paramInt, Parcel paramParcel)
    throws RemoteException
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      this.zzaad.transact(paramInt, paramParcel, localParcel, 0);
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

  protected final void zza(int paramInt, Parcel paramParcel)
    throws RemoteException
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      this.zzaad.transact(paramInt, paramParcel, localParcel, 0);
      localParcel.readException();
      return;
    }
    finally
    {
      paramParcel.recycle();
      localParcel.recycle();
    }
  }

  protected final void zzb(int paramInt, Parcel paramParcel)
    throws RemoteException
  {
    try
    {
      this.zzaad.transact(2, paramParcel, null, 1);
      return;
    }
    finally
    {
      paramParcel.recycle();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzfm
 * JD-Core Version:    0.6.2
 */