package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public final class zzaej extends zzfm
  implements zzaeh
{
  zzaej(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
  }

  public final int getHeight()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(5, obtainAndWriteInterfaceToken());
    int i = localParcel.readInt();
    localParcel.recycle();
    return i;
  }

  public final double getScale()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(3, obtainAndWriteInterfaceToken());
    double d = localParcel.readDouble();
    localParcel.recycle();
    return d;
  }

  public final Uri getUri()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(2, obtainAndWriteInterfaceToken());
    Uri localUri = (Uri)zzfo.zza(localParcel, Uri.CREATOR);
    localParcel.recycle();
    return localUri;
  }

  public final int getWidth()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(4, obtainAndWriteInterfaceToken());
    int i = localParcel.readInt();
    localParcel.recycle();
    return i;
  }

  public final IObjectWrapper zzrf()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(1, obtainAndWriteInterfaceToken());
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
    localParcel.recycle();
    return localIObjectWrapper;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaej
 * JD-Core Version:    0.6.2
 */