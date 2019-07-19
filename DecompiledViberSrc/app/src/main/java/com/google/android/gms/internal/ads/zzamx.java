package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzamx extends zzfn
  implements zzamw
{
  public zzamx()
  {
    super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
  }

  public static zzamw zzz(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    if ((localIInterface instanceof zzamw))
      return (zzamw)localIInterface;
    return new zzamy(paramIBinder);
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      onAdClicked();
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
    case 13:
    case 14:
    case 15:
    case 16:
    case 17:
    case 18:
    case 19:
    case 20:
    }
    while (true)
    {
      paramParcel2.writeNoException();
      return true;
      onAdClosed();
      continue;
      onAdFailedToLoad(paramParcel1.readInt());
      continue;
      onAdLeftApplication();
      continue;
      onAdOpened();
      continue;
      onAdLoaded();
      continue;
      IBinder localIBinder = paramParcel1.readStrongBinder();
      Object localObject;
      if (localIBinder == null)
        localObject = null;
      while (true)
      {
        zza((zzamz)localObject);
        break;
        IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
        if ((localIInterface instanceof zzamz))
          localObject = (zzamz)localIInterface;
        else
          localObject = new zzana(localIBinder);
      }
      onAdImpression();
      continue;
      onAppEvent(paramParcel1.readString(), paramParcel1.readString());
      continue;
      zza(zzafe.zzn(paramParcel1.readStrongBinder()), paramParcel1.readString());
      continue;
      onVideoEnd();
      continue;
      zzcz(paramParcel1.readString());
      continue;
      zzsm();
      continue;
      zzb((zzatp)zzfo.zza(paramParcel1, zzatp.CREATOR));
      continue;
      onVideoPause();
      continue;
      zza(zzats.zzaj(paramParcel1.readStrongBinder()));
      continue;
      zzcs(paramParcel1.readInt());
      continue;
      zzsn();
      continue;
      zzb((Bundle)zzfo.zza(paramParcel1, Bundle.CREATOR));
      continue;
      onVideoPlay();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzamx
 * JD-Core Version:    0.6.2
 */