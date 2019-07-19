package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

public abstract class zzze extends zzfn
  implements zzzd
{
  public zzze()
  {
    super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    case 11:
    case 12:
    default:
      return false;
    case 1:
      zzza localzzza = zzpk();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzza);
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    case 13:
    case 14:
    }
    while (true)
    {
      return true;
      IBinder localIBinder2 = paramParcel1.readStrongBinder();
      Object localObject2 = null;
      if (localIBinder2 == null);
      while (true)
      {
        zza((zzyx)localObject2);
        paramParcel2.writeNoException();
        break;
        IInterface localIInterface2 = localIBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
        if ((localIInterface2 instanceof zzyx))
          localObject2 = (zzyx)localIInterface2;
        else
          localObject2 = new zzyz(localIBinder2);
      }
      zza(zzafi.zzo(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      zza(zzafl.zzp(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      zza(paramParcel1.readString(), zzafr.zzr(paramParcel1.readStrongBinder()), zzafo.zzq(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      zza((zzadx)zzfo.zza(paramParcel1, zzadx.CREATOR));
      paramParcel2.writeNoException();
      continue;
      IBinder localIBinder1 = paramParcel1.readStrongBinder();
      Object localObject1 = null;
      if (localIBinder1 == null);
      while (true)
      {
        zza((zzzw)localObject1);
        paramParcel2.writeNoException();
        break;
        IInterface localIInterface1 = localIBinder1.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
        if ((localIInterface1 instanceof zzzw))
          localObject1 = (zzzw)localIInterface1;
        else
          localObject1 = new zzzy(localIBinder1);
      }
      zza(zzafu.zzs(paramParcel1.readStrongBinder()), (zzyb)zzfo.zza(paramParcel1, zzyb.CREATOR));
      paramParcel2.writeNoException();
      continue;
      zza((PublisherAdViewOptions)zzfo.zza(paramParcel1, PublisherAdViewOptions.CREATOR));
      paramParcel2.writeNoException();
      continue;
      zza(zzafx.zzt(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      zza((zzaiz)zzfo.zza(paramParcel1, zzaiz.CREATOR));
      paramParcel2.writeNoException();
      continue;
      zza(zzajg.zzx(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzze
 * JD-Core Version:    0.6.2
 */