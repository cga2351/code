package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public final class zzdai extends zzfm
  implements zzdag
{
  zzdai(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.omid.IOmid");
  }

  public final String getVersion()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(6, obtainAndWriteInterfaceToken());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }

  public final IObjectWrapper zza(String paramString1, IObjectWrapper paramIObjectWrapper, String paramString2, String paramString3, String paramString4, String paramString5)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    localParcel1.writeString(paramString1);
    zzfo.zza(localParcel1, paramIObjectWrapper);
    localParcel1.writeString(paramString2);
    localParcel1.writeString(paramString3);
    localParcel1.writeString(paramString4);
    localParcel1.writeString(paramString5);
    Parcel localParcel2 = transactAndReadException(9, localParcel1);
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localIObjectWrapper;
  }

  public final void zzaa(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zza(4, localParcel);
  }

  public final void zzab(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zza(7, localParcel);
  }

  public final boolean zzap(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramIObjectWrapper);
    Parcel localParcel2 = transactAndReadException(2, localParcel1);
    boolean bool = zzfo.zza(localParcel2);
    localParcel2.recycle();
    return bool;
  }

  public final void zzd(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper1);
    zzfo.zza(localParcel, paramIObjectWrapper2);
    zza(5, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdai
 * JD-Core Version:    0.6.2
 */