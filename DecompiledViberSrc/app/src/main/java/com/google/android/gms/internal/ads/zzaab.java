package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

public final class zzaab extends zzfm
  implements zzzz
{
  zzaab(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
  }

  public final String getVersionString()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(9, obtainAndWriteInterfaceToken());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }

  public final void setAppMuted(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.writeBoolean(localParcel, paramBoolean);
    zza(4, localParcel);
  }

  public final void setAppVolume(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeFloat(paramFloat);
    zza(2, localParcel);
  }

  public final void zza()
    throws RemoteException
  {
    zza(1, obtainAndWriteInterfaceToken());
  }

  public final void zza(zzais paramzzais)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzais);
    zza(12, localParcel);
  }

  public final void zza(zzamq paramzzamq)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzamq);
    zza(11, localParcel);
  }

  public final void zzb(String paramString, IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    zzfo.zza(localParcel, paramIObjectWrapper);
    zza(6, localParcel);
  }

  public final void zzbu(String paramString)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    zza(3, localParcel);
  }

  public final void zzbv(String paramString)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    zza(10, localParcel);
  }

  public final void zzc(IObjectWrapper paramIObjectWrapper, String paramString)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    localParcel.writeString(paramString);
    zza(5, localParcel);
  }

  public final float zzpq()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(7, obtainAndWriteInterfaceToken());
    float f = localParcel.readFloat();
    localParcel.recycle();
    return f;
  }

  public final boolean zzpr()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(8, obtainAndWriteInterfaceToken());
    boolean bool = zzfo.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final List<zzain> zzps()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(13, obtainAndWriteInterfaceToken());
    ArrayList localArrayList = localParcel.createTypedArrayList(zzain.CREATOR);
    localParcel.recycle();
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaab
 * JD-Core Version:    0.6.2
 */