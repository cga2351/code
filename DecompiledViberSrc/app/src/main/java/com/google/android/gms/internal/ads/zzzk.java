package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public final class zzzk extends zzfm
  implements zzzi
{
  zzzk(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.client.IAdManager");
  }

  public final void destroy()
    throws RemoteException
  {
    zza(2, obtainAndWriteInterfaceToken());
  }

  public final Bundle getAdMetadata()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(37, obtainAndWriteInterfaceToken());
    Bundle localBundle = (Bundle)zzfo.zza(localParcel, Bundle.CREATOR);
    localParcel.recycle();
    return localBundle;
  }

  public final String getAdUnitId()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(31, obtainAndWriteInterfaceToken());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }

  public final String getMediationAdapterClassName()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(18, obtainAndWriteInterfaceToken());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }

  public final zzaap getVideoController()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(26, obtainAndWriteInterfaceToken());
    IBinder localIBinder = localParcel.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
      if ((localIInterface instanceof zzaap))
        localObject = (zzaap)localIInterface;
      else
        localObject = new zzaar(localIBinder);
    }
  }

  public final boolean isLoading()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(23, obtainAndWriteInterfaceToken());
    boolean bool = zzfo.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean isReady()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(3, obtainAndWriteInterfaceToken());
    boolean bool = zzfo.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final void pause()
    throws RemoteException
  {
    zza(5, obtainAndWriteInterfaceToken());
  }

  public final void resume()
    throws RemoteException
  {
    zza(6, obtainAndWriteInterfaceToken());
  }

  public final void setImmersiveMode(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.writeBoolean(localParcel, paramBoolean);
    zza(34, localParcel);
  }

  public final void setManualImpressionsEnabled(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.writeBoolean(localParcel, paramBoolean);
    zza(22, localParcel);
  }

  public final void setUserId(String paramString)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    zza(25, localParcel);
  }

  public final void showInterstitial()
    throws RemoteException
  {
    zza(9, obtainAndWriteInterfaceToken());
  }

  public final void stopLoading()
    throws RemoteException
  {
    zza(10, obtainAndWriteInterfaceToken());
  }

  public final void zza(zzaav paramzzaav)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzaav);
    zza(30, localParcel);
  }

  public final void zza(zzacc paramzzacc)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzacc);
    zza(29, localParcel);
  }

  public final void zza(zzadn paramzzadn)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzadn);
    zza(19, localParcel);
  }

  public final void zza(zzaqo paramzzaqo)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzaqo);
    zza(14, localParcel);
  }

  public final void zza(zzaqu paramzzaqu, String paramString)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzaqu);
    localParcel.writeString(paramString);
    zza(15, localParcel);
  }

  public final void zza(zzatc paramzzatc)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzatc);
    zza(24, localParcel);
  }

  public final void zza(zzyb paramzzyb)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzyb);
    zza(13, localParcel);
  }

  public final void zza(zzyu paramzzyu)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzyu);
    zza(20, localParcel);
  }

  public final void zza(zzzn paramzzzn)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzzn);
    zza(36, localParcel);
  }

  public final void zza(zzzq paramzzzq)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzzq);
    zza(8, localParcel);
  }

  public final void zzb(zzyx paramzzyx)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzyx);
    zza(7, localParcel);
  }

  public final void zzb(zzzw paramzzzw)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzzw);
    zza(21, localParcel);
  }

  public final boolean zzb(zzxx paramzzxx)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramzzxx);
    Parcel localParcel2 = transactAndReadException(4, localParcel1);
    boolean bool = zzfo.zza(localParcel2);
    localParcel2.recycle();
    return bool;
  }

  public final void zzbt(String paramString)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    zza(38, localParcel);
  }

  public final String zzpj()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(35, obtainAndWriteInterfaceToken());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }

  public final IObjectWrapper zzpl()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(1, obtainAndWriteInterfaceToken());
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
    localParcel.recycle();
    return localIObjectWrapper;
  }

  public final void zzpm()
    throws RemoteException
  {
    zza(11, obtainAndWriteInterfaceToken());
  }

  public final zzyb zzpn()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(12, obtainAndWriteInterfaceToken());
    zzyb localzzyb = (zzyb)zzfo.zza(localParcel, zzyb.CREATOR);
    localParcel.recycle();
    return localzzyb;
  }

  public final zzzq zzpo()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(32, obtainAndWriteInterfaceToken());
    IBinder localIBinder = localParcel.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
      if ((localIInterface instanceof zzzq))
        localObject = (zzzq)localIInterface;
      else
        localObject = new zzzs(localIBinder);
    }
  }

  public final zzyx zzpp()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(33, obtainAndWriteInterfaceToken());
    IBinder localIBinder = localParcel.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
      if ((localIInterface instanceof zzyx))
        localObject = (zzyx)localIInterface;
      else
        localObject = new zzyz(localIBinder);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzzk
 * JD-Core Version:    0.6.2
 */