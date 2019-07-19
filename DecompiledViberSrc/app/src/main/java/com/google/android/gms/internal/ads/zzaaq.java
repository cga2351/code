package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzaaq extends zzfn
  implements zzaap
{
  public zzaaq()
  {
    super("com.google.android.gms.ads.internal.client.IVideoController");
  }

  public static zzaap zzh(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
    if ((localIInterface instanceof zzaap))
      return (zzaap)localIInterface;
    return new zzaar(paramIBinder);
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      play();
      paramParcel2.writeNoException();
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    case 11:
    case 12:
    }
    while (true)
    {
      return true;
      pause();
      paramParcel2.writeNoException();
      continue;
      mute(zzfo.zza(paramParcel1));
      paramParcel2.writeNoException();
      continue;
      boolean bool3 = isMuted();
      paramParcel2.writeNoException();
      zzfo.writeBoolean(paramParcel2, bool3);
      continue;
      int i = getPlaybackState();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(i);
      continue;
      float f3 = zzpv();
      paramParcel2.writeNoException();
      paramParcel2.writeFloat(f3);
      continue;
      float f2 = zzpw();
      paramParcel2.writeNoException();
      paramParcel2.writeFloat(f2);
      continue;
      IBinder localIBinder = paramParcel1.readStrongBinder();
      Object localObject;
      if (localIBinder == null)
        localObject = null;
      while (true)
      {
        zza((zzaas)localObject);
        paramParcel2.writeNoException();
        break;
        IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
        if ((localIInterface instanceof zzaas))
          localObject = (zzaas)localIInterface;
        else
          localObject = new zzaau(localIBinder);
      }
      float f1 = getAspectRatio();
      paramParcel2.writeNoException();
      paramParcel2.writeFloat(f1);
      continue;
      boolean bool2 = isCustomControlsEnabled();
      paramParcel2.writeNoException();
      zzfo.writeBoolean(paramParcel2, bool2);
      continue;
      zzaas localzzaas = zzpx();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzaas);
      continue;
      boolean bool1 = isClickToExpandEnabled();
      paramParcel2.writeNoException();
      zzfo.writeBoolean(paramParcel2, bool1);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaaq
 * JD-Core Version:    0.6.2
 */