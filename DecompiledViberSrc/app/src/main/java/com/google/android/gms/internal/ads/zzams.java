package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzams extends zzfm
  implements zzamq
{
  zzams(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
  }

  public final zzamt zzcu(String paramString)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    localParcel1.writeString(paramString);
    Parcel localParcel2 = transactAndReadException(1, localParcel1);
    IBinder localIBinder = localParcel2.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel2.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      if ((localIInterface instanceof zzamt))
        localObject = (zzamt)localIInterface;
      else
        localObject = new zzamv(localIBinder);
    }
  }

  public final boolean zzcv(String paramString)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    localParcel1.writeString(paramString);
    Parcel localParcel2 = transactAndReadException(2, localParcel1);
    boolean bool = zzfo.zza(localParcel2);
    localParcel2.recycle();
    return bool;
  }

  public final zzaow zzcy(String paramString)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    localParcel1.writeString(paramString);
    Parcel localParcel2 = transactAndReadException(3, localParcel1);
    zzaow localzzaow = zzaox.zzab(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localzzaow;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzams
 * JD-Core Version:    0.6.2
 */