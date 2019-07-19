package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzq;
import com.google.android.gms.internal.measurement.zzs;
import java.util.ArrayList;
import java.util.List;

public final class zzal extends zzq
  implements zzaj
{
  zzal(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
  }

  public final List<zzfu> zza(zzk paramzzk, boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel1, paramzzk);
    zzs.writeBoolean(localParcel1, paramBoolean);
    Parcel localParcel2 = transactAndReadException(7, localParcel1);
    ArrayList localArrayList = localParcel2.createTypedArrayList(zzfu.CREATOR);
    localParcel2.recycle();
    return localArrayList;
  }

  public final List<zzo> zza(String paramString1, String paramString2, zzk paramzzk)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    localParcel1.writeString(paramString1);
    localParcel1.writeString(paramString2);
    zzs.zza(localParcel1, paramzzk);
    Parcel localParcel2 = transactAndReadException(16, localParcel1);
    ArrayList localArrayList = localParcel2.createTypedArrayList(zzo.CREATOR);
    localParcel2.recycle();
    return localArrayList;
  }

  public final List<zzfu> zza(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    localParcel1.writeString(paramString1);
    localParcel1.writeString(paramString2);
    localParcel1.writeString(paramString3);
    zzs.writeBoolean(localParcel1, paramBoolean);
    Parcel localParcel2 = transactAndReadException(15, localParcel1);
    ArrayList localArrayList = localParcel2.createTypedArrayList(zzfu.CREATOR);
    localParcel2.recycle();
    return localArrayList;
  }

  public final List<zzfu> zza(String paramString1, String paramString2, boolean paramBoolean, zzk paramzzk)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    localParcel1.writeString(paramString1);
    localParcel1.writeString(paramString2);
    zzs.writeBoolean(localParcel1, paramBoolean);
    zzs.zza(localParcel1, paramzzk);
    Parcel localParcel2 = transactAndReadException(14, localParcel1);
    ArrayList localArrayList = localParcel2.createTypedArrayList(zzfu.CREATOR);
    localParcel2.recycle();
    return localArrayList;
  }

  public final void zza(long paramLong, String paramString1, String paramString2, String paramString3)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeLong(paramLong);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    localParcel.writeString(paramString3);
    zza(10, localParcel);
  }

  public final void zza(zzag paramzzag, zzk paramzzk)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramzzag);
    zzs.zza(localParcel, paramzzk);
    zza(1, localParcel);
  }

  public final void zza(zzag paramzzag, String paramString1, String paramString2)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramzzag);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zza(5, localParcel);
  }

  public final void zza(zzfu paramzzfu, zzk paramzzk)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramzzfu);
    zzs.zza(localParcel, paramzzk);
    zza(2, localParcel);
  }

  public final void zza(zzk paramzzk)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramzzk);
    zza(4, localParcel);
  }

  public final void zza(zzo paramzzo, zzk paramzzk)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramzzo);
    zzs.zza(localParcel, paramzzk);
    zza(12, localParcel);
  }

  public final byte[] zza(zzag paramzzag, String paramString)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel1, paramzzag);
    localParcel1.writeString(paramString);
    Parcel localParcel2 = transactAndReadException(9, localParcel1);
    byte[] arrayOfByte = localParcel2.createByteArray();
    localParcel2.recycle();
    return arrayOfByte;
  }

  public final void zzb(zzk paramzzk)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramzzk);
    zza(6, localParcel);
  }

  public final void zzb(zzo paramzzo)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramzzo);
    zza(13, localParcel);
  }

  public final String zzc(zzk paramzzk)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel1, paramzzk);
    Parcel localParcel2 = transactAndReadException(11, localParcel1);
    String str = localParcel2.readString();
    localParcel2.recycle();
    return str;
  }

  public final void zzd(zzk paramzzk)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramzzk);
    zza(18, localParcel);
  }

  public final List<zzo> zze(String paramString1, String paramString2, String paramString3)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    localParcel1.writeString(paramString1);
    localParcel1.writeString(paramString2);
    localParcel1.writeString(paramString3);
    Parcel localParcel2 = transactAndReadException(17, localParcel1);
    ArrayList localArrayList = localParcel2.createTypedArrayList(zzo.CREATOR);
    localParcel2.recycle();
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzal
 * JD-Core Version:    0.6.2
 */