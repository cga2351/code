package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzaoy extends zzfm
  implements zzaow
{
  zzaoy(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
  }

  public final zzaap getVideoController()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(5, obtainAndWriteInterfaceToken());
    zzaap localzzaap = zzaaq.zzh(localParcel.readStrongBinder());
    localParcel.recycle();
    return localzzaap;
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, String paramString, Bundle paramBundle1, Bundle paramBundle2, zzyb paramzzyb, zzaoz paramzzaoz)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    localParcel.writeString(paramString);
    zzfo.zza(localParcel, paramBundle1);
    zzfo.zza(localParcel, paramBundle2);
    zzfo.zza(localParcel, paramzzyb);
    zzfo.zza(localParcel, paramzzaoz);
    zza(1, localParcel);
  }

  public final void zza(String paramString1, String paramString2, zzxx paramzzxx, IObjectWrapper paramIObjectWrapper, zzaok paramzzaok, zzamw paramzzamw, zzyb paramzzyb)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzfo.zza(localParcel, paramzzxx);
    zzfo.zza(localParcel, paramIObjectWrapper);
    zzfo.zza(localParcel, paramzzaok);
    zzfo.zza(localParcel, paramzzamw);
    zzfo.zza(localParcel, paramzzyb);
    zza(13, localParcel);
  }

  public final void zza(String paramString1, String paramString2, zzxx paramzzxx, IObjectWrapper paramIObjectWrapper, zzaon paramzzaon, zzamw paramzzamw)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzfo.zza(localParcel, paramzzxx);
    zzfo.zza(localParcel, paramIObjectWrapper);
    zzfo.zza(localParcel, paramzzaon);
    zzfo.zza(localParcel, paramzzamw);
    zza(14, localParcel);
  }

  public final void zza(String paramString1, String paramString2, zzxx paramzzxx, IObjectWrapper paramIObjectWrapper, zzaoq paramzzaoq, zzamw paramzzamw)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzfo.zza(localParcel, paramzzxx);
    zzfo.zza(localParcel, paramIObjectWrapper);
    zzfo.zza(localParcel, paramzzaoq);
    zzfo.zza(localParcel, paramzzamw);
    zza(18, localParcel);
  }

  public final void zza(String paramString1, String paramString2, zzxx paramzzxx, IObjectWrapper paramIObjectWrapper, zzaot paramzzaot, zzamw paramzzamw)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzfo.zza(localParcel, paramzzxx);
    zzfo.zza(localParcel, paramIObjectWrapper);
    zzfo.zza(localParcel, paramzzaot);
    zzfo.zza(localParcel, paramzzamw);
    zza(16, localParcel);
  }

  public final void zza(String[] paramArrayOfString, Bundle[] paramArrayOfBundle)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeStringArray(paramArrayOfString);
    localParcel.writeTypedArray(paramArrayOfBundle, 0);
    zza(11, localParcel);
  }

  public final zzapk zzsx()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(2, obtainAndWriteInterfaceToken());
    zzapk localzzapk = (zzapk)zzfo.zza(localParcel, zzapk.CREATOR);
    localParcel.recycle();
    return localzzapk;
  }

  public final zzapk zzsy()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(3, obtainAndWriteInterfaceToken());
    zzapk localzzapk = (zzapk)zzfo.zza(localParcel, zzapk.CREATOR);
    localParcel.recycle();
    return localzzapk;
  }

  public final void zzx(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zza(10, localParcel);
  }

  public final boolean zzy(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramIObjectWrapper);
    Parcel localParcel2 = transactAndReadException(15, localParcel1);
    boolean bool = zzfo.zza(localParcel2);
    localParcel2.recycle();
    return bool;
  }

  public final boolean zzz(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramIObjectWrapper);
    Parcel localParcel2 = transactAndReadException(17, localParcel1);
    boolean bool = zzfo.zza(localParcel2);
    localParcel2.recycle();
    return bool;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaoy
 * JD-Core Version:    0.6.2
 */