package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public abstract class zzatv extends zzfn
  implements zzatu
{
  public zzatv()
  {
    super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
  }

  public static zzatu zzak(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    if ((localIInterface instanceof zzatu))
      return (zzatu)localIInterface;
    return new zzatw(paramIBinder);
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    IBinder localIBinder3;
    Object localObject3;
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      zzxx localzzxx = (zzxx)zzfo.zza(paramParcel1, zzxx.CREATOR);
      localIBinder3 = paramParcel1.readStrongBinder();
      localObject3 = null;
      if (localIBinder3 == null)
      {
        zza(localzzxx, (zzauc)localObject3);
        paramParcel2.writeNoException();
      }
      break;
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
    }
    while (true)
    {
      return true;
      IInterface localIInterface3 = localIBinder3.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
      if ((localIInterface3 instanceof zzauc))
      {
        localObject3 = (zzauc)localIInterface3;
        break;
      }
      localObject3 = new zzaue(localIBinder3);
      break;
      IBinder localIBinder2 = paramParcel1.readStrongBinder();
      Object localObject2 = null;
      if (localIBinder2 == null);
      while (true)
      {
        zza((zzatx)localObject2);
        paramParcel2.writeNoException();
        break;
        IInterface localIInterface2 = localIBinder2.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
        if ((localIInterface2 instanceof zzatx))
          localObject2 = (zzatx)localIInterface2;
        else
          localObject2 = new zzatz(localIBinder2);
      }
      boolean bool = isLoaded();
      paramParcel2.writeNoException();
      zzfo.writeBoolean(paramParcel2, bool);
      continue;
      String str = getMediationAdapterClassName();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str);
      continue;
      zzj(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      IBinder localIBinder1 = paramParcel1.readStrongBinder();
      Object localObject1 = null;
      if (localIBinder1 == null);
      while (true)
      {
        zza((zzauf)localObject1);
        paramParcel2.writeNoException();
        break;
        IInterface localIInterface1 = localIBinder1.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
        if ((localIInterface1 instanceof zzauf))
          localObject1 = (zzauf)localIInterface1;
        else
          localObject1 = new zzaug(localIBinder1);
      }
      zza((zzaun)zzfo.zza(paramParcel1, zzaun.CREATOR));
      paramParcel2.writeNoException();
      continue;
      zza(zzaan.zzg(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      Bundle localBundle = getAdMetadata();
      paramParcel2.writeNoException();
      zzfo.zzb(paramParcel2, localBundle);
      continue;
      zza(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), zzfo.zza(paramParcel1));
      paramParcel2.writeNoException();
      continue;
      zzatr localzzatr = zzqh();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzatr);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzatv
 * JD-Core Version:    0.6.2
 */