package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.ArrayList;
import java.util.List;

public final class zzaff extends zzfm
  implements zzafd
{
  zzaff(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
  }

  public final void destroy()
    throws RemoteException
  {
    zza(8, obtainAndWriteInterfaceToken());
  }

  public final List<String> getAvailableAssetNames()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(3, obtainAndWriteInterfaceToken());
    ArrayList localArrayList = localParcel.createStringArrayList();
    localParcel.recycle();
    return localArrayList;
  }

  public final String getCustomTemplateId()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(4, obtainAndWriteInterfaceToken());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }

  public final zzaap getVideoController()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(7, obtainAndWriteInterfaceToken());
    zzaap localzzaap = zzaaq.zzh(localParcel.readStrongBinder());
    localParcel.recycle();
    return localzzaap;
  }

  public final void performClick(String paramString)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    zza(5, localParcel);
  }

  public final void recordImpression()
    throws RemoteException
  {
    zza(6, obtainAndWriteInterfaceToken());
  }

  public final String zzcj(String paramString)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    localParcel1.writeString(paramString);
    Parcel localParcel2 = transactAndReadException(1, localParcel1);
    String str = localParcel2.readString();
    localParcel2.recycle();
    return str;
  }

  public final zzaeh zzck(String paramString)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    localParcel1.writeString(paramString);
    Parcel localParcel2 = transactAndReadException(2, localParcel1);
    IBinder localIBinder = localParcel2.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel2.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
      if ((localIInterface instanceof zzaeh))
        localObject = (zzaeh)localIInterface;
      else
        localObject = new zzaej(localIBinder);
    }
  }

  public final boolean zzp(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramIObjectWrapper);
    Parcel localParcel2 = transactAndReadException(10, localParcel1);
    boolean bool = zzfo.zza(localParcel2);
    localParcel2.recycle();
    return bool;
  }

  public final IObjectWrapper zzrh()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(11, obtainAndWriteInterfaceToken());
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
    localParcel.recycle();
    return localIObjectWrapper;
  }

  public final IObjectWrapper zzrm()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(9, obtainAndWriteInterfaceToken());
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
    localParcel.recycle();
    return localIObjectWrapper;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaff
 * JD-Core Version:    0.6.2
 */