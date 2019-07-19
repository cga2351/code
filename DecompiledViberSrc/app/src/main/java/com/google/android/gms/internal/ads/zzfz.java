package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzfz extends zzfm
  implements zzfx
{
  zzfz(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.clearcut.IClearcut");
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, String paramString1, String paramString2)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    localParcel.writeString(paramString1);
    localParcel.writeString(null);
    zza(8, localParcel);
  }

  public final void zza(int[] paramArrayOfInt)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeIntArray(null);
    zza(4, localParcel);
  }

  public final void zzb(IObjectWrapper paramIObjectWrapper, String paramString)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    localParcel.writeString(paramString);
    zza(2, localParcel);
  }

  public final void zzc(byte[] paramArrayOfByte)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeByteArray(paramArrayOfByte);
    zza(5, localParcel);
  }

  public final void zzdj()
    throws RemoteException
  {
    zza(3, obtainAndWriteInterfaceToken());
  }

  public final void zzl(int paramInt)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeInt(paramInt);
    zza(6, localParcel);
  }

  public final void zzm(int paramInt)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeInt(paramInt);
    zza(7, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzfz
 * JD-Core Version:    0.6.2
 */