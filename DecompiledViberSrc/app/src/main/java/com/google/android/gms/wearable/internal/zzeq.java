package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.internal.wearable.zza;
import com.google.android.gms.internal.wearable.zzc;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;

public final class zzeq extends zza
  implements zzep
{
  zzeq(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.wearable.internal.IWearableService");
  }

  public final void zza(zzek paramzzek)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    transactAndReadExceptionReturnVoid(8, localParcel);
  }

  public final void zza(zzek paramzzek, int paramInt)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeInt(paramInt);
    transactAndReadExceptionReturnVoid(43, localParcel);
  }

  public final void zza(zzek paramzzek, Uri paramUri)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramUri);
    transactAndReadExceptionReturnVoid(7, localParcel);
  }

  public final void zza(zzek paramzzek, Uri paramUri, int paramInt)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramUri);
    localParcel.writeInt(paramInt);
    transactAndReadExceptionReturnVoid(40, localParcel);
  }

  public final void zza(zzek paramzzek, Asset paramAsset)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramAsset);
    transactAndReadExceptionReturnVoid(13, localParcel);
  }

  public final void zza(zzek paramzzek, PutDataRequest paramPutDataRequest)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramPutDataRequest);
    transactAndReadExceptionReturnVoid(6, localParcel);
  }

  public final void zza(zzek paramzzek, zzd paramzzd)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramzzd);
    transactAndReadExceptionReturnVoid(16, localParcel);
  }

  public final void zza(zzek paramzzek, zzei paramzzei, String paramString)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramzzei);
    localParcel.writeString(paramString);
    transactAndReadExceptionReturnVoid(34, localParcel);
  }

  public final void zza(zzek paramzzek, zzfw paramzzfw)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramzzfw);
    transactAndReadExceptionReturnVoid(17, localParcel);
  }

  public final void zza(zzek paramzzek, String paramString)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString);
    transactAndReadExceptionReturnVoid(46, localParcel);
  }

  public final void zza(zzek paramzzek, String paramString, int paramInt)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString);
    localParcel.writeInt(paramInt);
    transactAndReadExceptionReturnVoid(42, localParcel);
  }

  public final void zza(zzek paramzzek, String paramString, ParcelFileDescriptor paramParcelFileDescriptor)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString);
    zzc.zza(localParcel, paramParcelFileDescriptor);
    transactAndReadExceptionReturnVoid(38, localParcel);
  }

  public final void zza(zzek paramzzek, String paramString, ParcelFileDescriptor paramParcelFileDescriptor, long paramLong1, long paramLong2)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString);
    zzc.zza(localParcel, paramParcelFileDescriptor);
    localParcel.writeLong(paramLong1);
    localParcel.writeLong(paramLong2);
    transactAndReadExceptionReturnVoid(39, localParcel);
  }

  public final void zza(zzek paramzzek, String paramString1, String paramString2)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    transactAndReadExceptionReturnVoid(31, localParcel);
  }

  public final void zza(zzek paramzzek, String paramString1, String paramString2, byte[] paramArrayOfByte)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    localParcel.writeByteArray(paramArrayOfByte);
    transactAndReadExceptionReturnVoid(12, localParcel);
  }

  public final void zzb(zzek paramzzek)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    transactAndReadExceptionReturnVoid(14, localParcel);
  }

  public final void zzb(zzek paramzzek, Uri paramUri, int paramInt)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramUri);
    localParcel.writeInt(paramInt);
    transactAndReadExceptionReturnVoid(41, localParcel);
  }

  public final void zzb(zzek paramzzek, zzei paramzzei, String paramString)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramzzei);
    localParcel.writeString(paramString);
    transactAndReadExceptionReturnVoid(35, localParcel);
  }

  public final void zzb(zzek paramzzek, String paramString)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString);
    transactAndReadExceptionReturnVoid(47, localParcel);
  }

  public final void zzb(zzek paramzzek, String paramString, int paramInt)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString);
    localParcel.writeInt(paramInt);
    transactAndReadExceptionReturnVoid(33, localParcel);
  }

  public final void zzc(zzek paramzzek)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    transactAndReadExceptionReturnVoid(15, localParcel);
  }

  public final void zzc(zzek paramzzek, String paramString)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString);
    transactAndReadExceptionReturnVoid(32, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzeq
 * JD-Core Version:    0.6.2
 */