package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.List;

public final class zzamv extends zzfm
  implements zzamt
{
  zzamv(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
  }

  public final void destroy()
    throws RemoteException
  {
    zza(5, obtainAndWriteInterfaceToken());
  }

  public final Bundle getInterstitialAdapterInfo()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(18, obtainAndWriteInterfaceToken());
    Bundle localBundle = (Bundle)zzfo.zza(localParcel, Bundle.CREATOR);
    localParcel.recycle();
    return localBundle;
  }

  public final zzaap getVideoController()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(26, obtainAndWriteInterfaceToken());
    zzaap localzzaap = zzaaq.zzh(localParcel.readStrongBinder());
    localParcel.recycle();
    return localzzaap;
  }

  public final boolean isInitialized()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(13, obtainAndWriteInterfaceToken());
    boolean bool = zzfo.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final void pause()
    throws RemoteException
  {
    zza(8, obtainAndWriteInterfaceToken());
  }

  public final void resume()
    throws RemoteException
  {
    zza(9, obtainAndWriteInterfaceToken());
  }

  public final void setImmersiveMode(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.writeBoolean(localParcel, paramBoolean);
    zza(25, localParcel);
  }

  public final void showInterstitial()
    throws RemoteException
  {
    zza(4, obtainAndWriteInterfaceToken());
  }

  public final void showVideo()
    throws RemoteException
  {
    zza(12, obtainAndWriteInterfaceToken());
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzaip paramzzaip, List<zzaix> paramList)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zzfo.zza(localParcel, paramzzaip);
    localParcel.writeTypedList(paramList);
    zza(31, localParcel);
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzatl paramzzatl, List<String> paramList)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zzfo.zza(localParcel, paramzzatl);
    localParcel.writeStringList(paramList);
    zza(23, localParcel);
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzxx paramzzxx, String paramString, zzamw paramzzamw)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zzfo.zza(localParcel, paramzzxx);
    localParcel.writeString(paramString);
    zzfo.zza(localParcel, paramzzamw);
    zza(3, localParcel);
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzxx paramzzxx, String paramString1, zzatl paramzzatl, String paramString2)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zzfo.zza(localParcel, paramzzxx);
    localParcel.writeString(paramString1);
    zzfo.zza(localParcel, paramzzatl);
    localParcel.writeString(paramString2);
    zza(10, localParcel);
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzxx paramzzxx, String paramString1, String paramString2, zzamw paramzzamw)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zzfo.zza(localParcel, paramzzxx);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzfo.zza(localParcel, paramzzamw);
    zza(7, localParcel);
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzxx paramzzxx, String paramString1, String paramString2, zzamw paramzzamw, zzadx paramzzadx, List<String> paramList)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zzfo.zza(localParcel, paramzzxx);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzfo.zza(localParcel, paramzzamw);
    zzfo.zza(localParcel, paramzzadx);
    localParcel.writeStringList(paramList);
    zza(14, localParcel);
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzyb paramzzyb, zzxx paramzzxx, String paramString, zzamw paramzzamw)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zzfo.zza(localParcel, paramzzyb);
    zzfo.zza(localParcel, paramzzxx);
    localParcel.writeString(paramString);
    zzfo.zza(localParcel, paramzzamw);
    zza(1, localParcel);
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzyb paramzzyb, zzxx paramzzxx, String paramString1, String paramString2, zzamw paramzzamw)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zzfo.zza(localParcel, paramzzyb);
    zzfo.zza(localParcel, paramzzxx);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzfo.zza(localParcel, paramzzamw);
    zza(6, localParcel);
  }

  public final void zza(zzxx paramzzxx, String paramString)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzxx);
    localParcel.writeString(paramString);
    zza(11, localParcel);
  }

  public final void zza(zzxx paramzzxx, String paramString1, String paramString2)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzxx);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zza(20, localParcel);
  }

  public final void zzb(IObjectWrapper paramIObjectWrapper, zzxx paramzzxx, String paramString, zzamw paramzzamw)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zzfo.zza(localParcel, paramzzxx);
    localParcel.writeString(paramString);
    zzfo.zza(localParcel, paramzzamw);
    zza(28, localParcel);
  }

  public final void zzr(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zza(21, localParcel);
  }

  public final void zzs(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zza(30, localParcel);
  }

  public final IObjectWrapper zzse()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(2, obtainAndWriteInterfaceToken());
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
    localParcel.recycle();
    return localIObjectWrapper;
  }

  public final zzanb zzsf()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(15, obtainAndWriteInterfaceToken());
    IBinder localIBinder = localParcel.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
      if ((localIInterface instanceof zzanb))
        localObject = (zzanb)localIInterface;
      else
        localObject = new zzand(localIBinder);
    }
  }

  public final zzane zzsg()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(16, obtainAndWriteInterfaceToken());
    IBinder localIBinder = localParcel.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
      if ((localIInterface instanceof zzane))
        localObject = (zzane)localIInterface;
      else
        localObject = new zzang(localIBinder);
    }
  }

  public final Bundle zzsh()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(17, obtainAndWriteInterfaceToken());
    Bundle localBundle = (Bundle)zzfo.zza(localParcel, Bundle.CREATOR);
    localParcel.recycle();
    return localBundle;
  }

  public final Bundle zzsi()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(19, obtainAndWriteInterfaceToken());
    Bundle localBundle = (Bundle)zzfo.zza(localParcel, Bundle.CREATOR);
    localParcel.recycle();
    return localBundle;
  }

  public final boolean zzsj()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(22, obtainAndWriteInterfaceToken());
    boolean bool = zzfo.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final zzafd zzsk()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(24, obtainAndWriteInterfaceToken());
    zzafd localzzafd = zzafe.zzn(localParcel.readStrongBinder());
    localParcel.recycle();
    return localzzafd;
  }

  public final zzanh zzsl()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(27, obtainAndWriteInterfaceToken());
    IBinder localIBinder = localParcel.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
      if ((localIInterface instanceof zzanh))
        localObject = (zzanh)localIInterface;
      else
        localObject = new zzanj(localIBinder);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzamv
 * JD-Core Version:    0.6.2
 */