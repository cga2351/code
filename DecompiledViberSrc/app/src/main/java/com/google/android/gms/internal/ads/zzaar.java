package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzaar extends zzfm
  implements zzaap
{
  zzaar(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.client.IVideoController");
  }

  public final float getAspectRatio()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(9, obtainAndWriteInterfaceToken());
    float f = localParcel.readFloat();
    localParcel.recycle();
    return f;
  }

  public final int getPlaybackState()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(5, obtainAndWriteInterfaceToken());
    int i = localParcel.readInt();
    localParcel.recycle();
    return i;
  }

  public final boolean isClickToExpandEnabled()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(12, obtainAndWriteInterfaceToken());
    boolean bool = zzfo.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean isCustomControlsEnabled()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(10, obtainAndWriteInterfaceToken());
    boolean bool = zzfo.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean isMuted()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(4, obtainAndWriteInterfaceToken());
    boolean bool = zzfo.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final void mute(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.writeBoolean(localParcel, paramBoolean);
    zza(3, localParcel);
  }

  public final void pause()
    throws RemoteException
  {
    zza(2, obtainAndWriteInterfaceToken());
  }

  public final void play()
    throws RemoteException
  {
    zza(1, obtainAndWriteInterfaceToken());
  }

  public final void zza(zzaas paramzzaas)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzaas);
    zza(8, localParcel);
  }

  public final float zzpv()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(6, obtainAndWriteInterfaceToken());
    float f = localParcel.readFloat();
    localParcel.recycle();
    return f;
  }

  public final float zzpw()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(7, obtainAndWriteInterfaceToken());
    float f = localParcel.readFloat();
    localParcel.recycle();
    return f;
  }

  public final zzaas zzpx()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(11, obtainAndWriteInterfaceToken());
    IBinder localIBinder = localParcel.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
      if ((localIInterface instanceof zzaas))
        localObject = (zzaas)localIInterface;
      else
        localObject = new zzaau(localIBinder);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaar
 * JD-Core Version:    0.6.2
 */