package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzzv extends zzfm
  implements zzzt
{
  zzzv(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.client.IClientApi");
  }

  public final zzaeq zza(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramIObjectWrapper1);
    zzfo.zza(localParcel1, paramIObjectWrapper2);
    zzfo.zza(localParcel1, paramIObjectWrapper3);
    Parcel localParcel2 = transactAndReadException(11, localParcel1);
    zzaeq localzzaeq = zzaer.zzm(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localzzaeq;
  }

  public final zzasx zza(IObjectWrapper paramIObjectWrapper, zzamq paramzzamq, int paramInt)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramIObjectWrapper);
    zzfo.zza(localParcel1, paramzzamq);
    localParcel1.writeInt(paramInt);
    Parcel localParcel2 = transactAndReadException(6, localParcel1);
    zzasx localzzasx = zzasy.zzag(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localzzasx;
  }

  public final zzzd zza(IObjectWrapper paramIObjectWrapper, String paramString, zzamq paramzzamq, int paramInt)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramIObjectWrapper);
    localParcel1.writeString(paramString);
    zzfo.zza(localParcel1, paramzzamq);
    localParcel1.writeInt(paramInt);
    Parcel localParcel2 = transactAndReadException(3, localParcel1);
    IBinder localIBinder = localParcel2.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel2.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
      if ((localIInterface instanceof zzzd))
        localObject = (zzzd)localIInterface;
      else
        localObject = new zzzf(localIBinder);
    }
  }

  public final zzzi zza(IObjectWrapper paramIObjectWrapper, zzyb paramzzyb, String paramString, int paramInt)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramIObjectWrapper);
    zzfo.zza(localParcel1, paramzzyb);
    localParcel1.writeString(paramString);
    localParcel1.writeInt(paramInt);
    Parcel localParcel2 = transactAndReadException(10, localParcel1);
    IBinder localIBinder = localParcel2.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel2.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
      if ((localIInterface instanceof zzzi))
        localObject = (zzzi)localIInterface;
      else
        localObject = new zzzk(localIBinder);
    }
  }

  public final zzzi zza(IObjectWrapper paramIObjectWrapper, zzyb paramzzyb, String paramString, zzamq paramzzamq, int paramInt)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramIObjectWrapper);
    zzfo.zza(localParcel1, paramzzyb);
    localParcel1.writeString(paramString);
    zzfo.zza(localParcel1, paramzzamq);
    localParcel1.writeInt(paramInt);
    Parcel localParcel2 = transactAndReadException(1, localParcel1);
    IBinder localIBinder = localParcel2.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel2.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
      if ((localIInterface instanceof zzzi))
        localObject = (zzzi)localIInterface;
      else
        localObject = new zzzk(localIBinder);
    }
  }

  public final zzzz zza(IObjectWrapper paramIObjectWrapper, int paramInt)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramIObjectWrapper);
    localParcel1.writeInt(paramInt);
    Parcel localParcel2 = transactAndReadException(9, localParcel1);
    IBinder localIBinder = localParcel2.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel2.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
      if ((localIInterface instanceof zzzz))
        localObject = (zzzz)localIInterface;
      else
        localObject = new zzaab(localIBinder);
    }
  }

  public final zzatu zzb(IObjectWrapper paramIObjectWrapper, String paramString, zzamq paramzzamq, int paramInt)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramIObjectWrapper);
    localParcel1.writeString(paramString);
    zzfo.zza(localParcel1, paramzzamq);
    localParcel1.writeInt(paramInt);
    Parcel localParcel2 = transactAndReadException(12, localParcel1);
    zzatu localzzatu = zzatv.zzak(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localzzatu;
  }

  public final zzzi zzb(IObjectWrapper paramIObjectWrapper, zzyb paramzzyb, String paramString, zzamq paramzzamq, int paramInt)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramIObjectWrapper);
    zzfo.zza(localParcel1, paramzzyb);
    localParcel1.writeString(paramString);
    zzfo.zza(localParcel1, paramzzamq);
    localParcel1.writeInt(paramInt);
    Parcel localParcel2 = transactAndReadException(2, localParcel1);
    IBinder localIBinder = localParcel2.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel2.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
      if ((localIInterface instanceof zzzi))
        localObject = (zzzi)localIInterface;
      else
        localObject = new zzzk(localIBinder);
    }
  }

  public final zzael zzc(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramIObjectWrapper1);
    zzfo.zza(localParcel1, paramIObjectWrapper2);
    Parcel localParcel2 = transactAndReadException(5, localParcel1);
    zzael localzzael = zzaem.zzl(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localzzael;
  }

  public final zzaqh zzf(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramIObjectWrapper);
    Parcel localParcel2 = transactAndReadException(8, localParcel1);
    zzaqh localzzaqh = zzaqi.zzac(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localzzaqh;
  }

  public final zzzz zzg(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramIObjectWrapper);
    Parcel localParcel2 = transactAndReadException(4, localParcel1);
    IBinder localIBinder = localParcel2.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel2.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
      if ((localIInterface instanceof zzzz))
        localObject = (zzzz)localIInterface;
      else
        localObject = new zzaab(localIBinder);
    }
  }

  public final zzaqr zzh(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramIObjectWrapper);
    Parcel localParcel2 = transactAndReadException(7, localParcel1);
    zzaqr localzzaqr = zzaqs.zzae(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localzzaqr;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzzv
 * JD-Core Version:    0.6.2
 */