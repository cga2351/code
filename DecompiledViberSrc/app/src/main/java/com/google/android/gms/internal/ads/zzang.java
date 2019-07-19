package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.ArrayList;
import java.util.List;

public final class zzang extends zzfm
  implements zzane
{
  zzang(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
  }

  public final String getAdvertiser()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(7, obtainAndWriteInterfaceToken());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }

  public final String getBody()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(4, obtainAndWriteInterfaceToken());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }

  public final String getCallToAction()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(6, obtainAndWriteInterfaceToken());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }

  public final Bundle getExtras()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(13, obtainAndWriteInterfaceToken());
    Bundle localBundle = (Bundle)zzfo.zza(localParcel, Bundle.CREATOR);
    localParcel.recycle();
    return localBundle;
  }

  public final String getHeadline()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(2, obtainAndWriteInterfaceToken());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }

  public final List getImages()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(3, obtainAndWriteInterfaceToken());
    ArrayList localArrayList = zzfo.zzb(localParcel);
    localParcel.recycle();
    return localArrayList;
  }

  public final boolean getOverrideClickHandling()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(12, obtainAndWriteInterfaceToken());
    boolean bool = zzfo.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean getOverrideImpressionRecording()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(11, obtainAndWriteInterfaceToken());
    boolean bool = zzfo.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final zzaap getVideoController()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(16, obtainAndWriteInterfaceToken());
    zzaap localzzaap = zzaaq.zzh(localParcel.readStrongBinder());
    localParcel.recycle();
    return localzzaap;
  }

  public final void recordImpression()
    throws RemoteException
  {
    zza(8, obtainAndWriteInterfaceToken());
  }

  public final void zzc(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper1);
    zzfo.zza(localParcel, paramIObjectWrapper2);
    zzfo.zza(localParcel, paramIObjectWrapper3);
    zza(22, localParcel);
  }

  public final zzadz zzrj()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(19, obtainAndWriteInterfaceToken());
    zzadz localzzadz = zzaea.zzj(localParcel.readStrongBinder());
    localParcel.recycle();
    return localzzadz;
  }

  public final IObjectWrapper zzrk()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(21, obtainAndWriteInterfaceToken());
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
    localParcel.recycle();
    return localIObjectWrapper;
  }

  public final zzaeh zzrl()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(5, obtainAndWriteInterfaceToken());
    zzaeh localzzaeh = zzaei.zzk(localParcel.readStrongBinder());
    localParcel.recycle();
    return localzzaeh;
  }

  public final IObjectWrapper zzso()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(15, obtainAndWriteInterfaceToken());
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
    localParcel.recycle();
    return localIObjectWrapper;
  }

  public final IObjectWrapper zzsp()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(20, obtainAndWriteInterfaceToken());
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
    localParcel.recycle();
    return localIObjectWrapper;
  }

  public final void zzt(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zza(9, localParcel);
  }

  public final void zzu(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zza(10, localParcel);
  }

  public final void zzv(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zza(14, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzang
 * JD-Core Version:    0.6.2
 */