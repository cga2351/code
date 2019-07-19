package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public abstract class zzasy extends zzfn
  implements zzasx
{
  public zzasy()
  {
    super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
  }

  public static zzasx zzag(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    if ((localIInterface instanceof zzasx))
      return (zzasx)localIInterface;
    return new zzasz(paramIBinder);
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    case 4:
    case 20:
    case 21:
    case 22:
    case 23:
    case 24:
    case 25:
    case 26:
    case 27:
    case 28:
    case 29:
    case 30:
    case 31:
    case 32:
    case 33:
    default:
      return false;
    case 1:
      zza((zzati)zzfo.zza(paramParcel1, zzati.CREATOR));
      paramParcel2.writeNoException();
    case 2:
    case 3:
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
    case 34:
    }
    while (true)
    {
      return true;
      show();
      paramParcel2.writeNoException();
      continue;
      IBinder localIBinder2 = paramParcel1.readStrongBinder();
      Object localObject2 = null;
      if (localIBinder2 == null);
      while (true)
      {
        zza((zzatc)localObject2);
        paramParcel2.writeNoException();
        break;
        IInterface localIInterface2 = localIBinder2.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
        if ((localIInterface2 instanceof zzatc))
          localObject2 = (zzatc)localIInterface2;
        else
          localObject2 = new zzate(localIBinder2);
      }
      boolean bool = isLoaded();
      paramParcel2.writeNoException();
      zzfo.writeBoolean(paramParcel2, bool);
      continue;
      pause();
      paramParcel2.writeNoException();
      continue;
      resume();
      paramParcel2.writeNoException();
      continue;
      destroy();
      paramParcel2.writeNoException();
      continue;
      zzl(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      zzm(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      zzn(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      String str = getMediationAdapterClassName();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str);
      continue;
      setUserId(paramParcel1.readString());
      paramParcel2.writeNoException();
      continue;
      zza(zzzo.zzc(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      Bundle localBundle = getAdMetadata();
      paramParcel2.writeNoException();
      zzfo.zzb(paramParcel2, localBundle);
      continue;
      IBinder localIBinder1 = paramParcel1.readStrongBinder();
      Object localObject1 = null;
      if (localIBinder1 == null);
      while (true)
      {
        zza((zzasv)localObject1);
        paramParcel2.writeNoException();
        break;
        IInterface localIInterface1 = localIBinder1.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
        if ((localIInterface1 instanceof zzasv))
          localObject1 = (zzasv)localIInterface1;
        else
          localObject1 = new zzasw(localIBinder1);
      }
      setAppPackageName(paramParcel1.readString());
      paramParcel2.writeNoException();
      continue;
      zzk(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      setCustomData(paramParcel1.readString());
      paramParcel2.writeNoException();
      continue;
      setImmersiveMode(zzfo.zza(paramParcel1));
      paramParcel2.writeNoException();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzasy
 * JD-Core Version:    0.6.2
 */