package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.ArrayList;
import java.util.List;

public final class zzagh extends zzfm
  implements zzagf
{
  zzagh(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
  }

  public final void cancelUnconfirmedClick()
    throws RemoteException
  {
    zza(22, obtainAndWriteInterfaceToken());
  }

  public final void destroy()
    throws RemoteException
  {
    zza(13, obtainAndWriteInterfaceToken());
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
    Parcel localParcel = transactAndReadException(20, obtainAndWriteInterfaceToken());
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

  public final String getMediationAdapterClassName()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(12, obtainAndWriteInterfaceToken());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }

  public final List getMuteThisAdReasons()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(23, obtainAndWriteInterfaceToken());
    ArrayList localArrayList = zzfo.zzb(localParcel);
    localParcel.recycle();
    return localArrayList;
  }

  public final String getPrice()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(10, obtainAndWriteInterfaceToken());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }

  public final double getStarRating()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(8, obtainAndWriteInterfaceToken());
    double d = localParcel.readDouble();
    localParcel.recycle();
    return d;
  }

  public final String getStore()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(9, obtainAndWriteInterfaceToken());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }

  public final zzaap getVideoController()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(11, obtainAndWriteInterfaceToken());
    zzaap localzzaap = zzaaq.zzh(localParcel.readStrongBinder());
    localParcel.recycle();
    return localzzaap;
  }

  public final boolean isCustomMuteThisAdEnabled()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(24, obtainAndWriteInterfaceToken());
    boolean bool = zzfo.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final void performClick(Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramBundle);
    zza(15, localParcel);
  }

  public final void recordCustomClickGesture()
    throws RemoteException
  {
    zza(28, obtainAndWriteInterfaceToken());
  }

  public final boolean recordImpression(Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramBundle);
    Parcel localParcel2 = transactAndReadException(16, localParcel1);
    boolean bool = zzfo.zza(localParcel2);
    localParcel2.recycle();
    return bool;
  }

  public final void reportTouchEvent(Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramBundle);
    zza(17, localParcel);
  }

  public final void zza(zzaae paramzzaae)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzaae);
    zza(26, localParcel);
  }

  public final void zza(zzaai paramzzaai)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzaai);
    zza(25, localParcel);
  }

  public final void zza(zzagc paramzzagc)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzagc);
    zza(21, localParcel);
  }

  public final IObjectWrapper zzrh()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(18, obtainAndWriteInterfaceToken());
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
    localParcel.recycle();
    return localIObjectWrapper;
  }

  public final zzaeh zzri()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(5, obtainAndWriteInterfaceToken());
    IBinder localIBinder = localParcel.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
      if ((localIInterface instanceof zzaeh))
        localObject = (zzaeh)localIInterface;
      else
        localObject = new zzaej(localIBinder);
    }
  }

  public final zzadz zzrj()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(14, obtainAndWriteInterfaceToken());
    IBinder localIBinder = localParcel.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
      if ((localIInterface instanceof zzadz))
        localObject = (zzadz)localIInterface;
      else
        localObject = new zzaeb(localIBinder);
    }
  }

  public final IObjectWrapper zzrk()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(19, obtainAndWriteInterfaceToken());
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
    localParcel.recycle();
    return localIObjectWrapper;
  }

  public final void zzro()
    throws RemoteException
  {
    zza(27, obtainAndWriteInterfaceToken());
  }

  public final zzaed zzrp()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(29, obtainAndWriteInterfaceToken());
    IBinder localIBinder = localParcel.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
      if ((localIInterface instanceof zzaed))
        localObject = (zzaed)localIInterface;
      else
        localObject = new zzaef(localIBinder);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzagh
 * JD-Core Version:    0.6.2
 */