package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzzj extends zzfn
  implements zzzi
{
  public zzzj()
  {
    super("com.google.android.gms.ads.internal.client.IAdManager");
  }

  public static zzzi zzb(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
    if ((localIInterface instanceof zzzi))
      return (zzzi)localIInterface;
    return new zzzk(paramIBinder);
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    case 16:
    case 17:
    case 27:
    case 28:
    default:
      return false;
    case 1:
      IObjectWrapper localIObjectWrapper = zzpl();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localIObjectWrapper);
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
    case 18:
    case 19:
    case 20:
    case 21:
    case 22:
    case 23:
    case 24:
    case 25:
    case 26:
    case 29:
    case 30:
    case 31:
    case 32:
    case 33:
    case 34:
    case 35:
    case 36:
    case 37:
    case 38:
    }
    while (true)
    {
      return true;
      destroy();
      paramParcel2.writeNoException();
      continue;
      boolean bool3 = isReady();
      paramParcel2.writeNoException();
      zzfo.writeBoolean(paramParcel2, bool3);
      continue;
      boolean bool2 = zzb((zzxx)zzfo.zza(paramParcel1, zzxx.CREATOR));
      paramParcel2.writeNoException();
      zzfo.writeBoolean(paramParcel2, bool2);
      continue;
      pause();
      paramParcel2.writeNoException();
      continue;
      resume();
      paramParcel2.writeNoException();
      continue;
      IBinder localIBinder5 = paramParcel1.readStrongBinder();
      Object localObject5 = null;
      if (localIBinder5 == null);
      while (true)
      {
        zzb((zzyx)localObject5);
        paramParcel2.writeNoException();
        break;
        IInterface localIInterface5 = localIBinder5.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
        if ((localIInterface5 instanceof zzyx))
          localObject5 = (zzyx)localIInterface5;
        else
          localObject5 = new zzyz(localIBinder5);
      }
      IBinder localIBinder4 = paramParcel1.readStrongBinder();
      Object localObject4 = null;
      if (localIBinder4 == null);
      while (true)
      {
        zza((zzzq)localObject4);
        paramParcel2.writeNoException();
        break;
        IInterface localIInterface4 = localIBinder4.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
        if ((localIInterface4 instanceof zzzq))
          localObject4 = (zzzq)localIInterface4;
        else
          localObject4 = new zzzs(localIBinder4);
      }
      showInterstitial();
      paramParcel2.writeNoException();
      continue;
      stopLoading();
      paramParcel2.writeNoException();
      continue;
      zzpm();
      paramParcel2.writeNoException();
      continue;
      zzyb localzzyb = zzpn();
      paramParcel2.writeNoException();
      zzfo.zzb(paramParcel2, localzzyb);
      continue;
      zza((zzyb)zzfo.zza(paramParcel1, zzyb.CREATOR));
      paramParcel2.writeNoException();
      continue;
      zza(zzaqp.zzad(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      zza(zzaqv.zzaf(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      continue;
      String str3 = getMediationAdapterClassName();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str3);
      continue;
      zza(zzado.zzi(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      IBinder localIBinder3 = paramParcel1.readStrongBinder();
      Object localObject3 = null;
      if (localIBinder3 == null);
      while (true)
      {
        zza((zzyu)localObject3);
        paramParcel2.writeNoException();
        break;
        IInterface localIInterface3 = localIBinder3.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
        if ((localIInterface3 instanceof zzyu))
          localObject3 = (zzyu)localIInterface3;
        else
          localObject3 = new zzyw(localIBinder3);
      }
      IBinder localIBinder2 = paramParcel1.readStrongBinder();
      Object localObject2 = null;
      if (localIBinder2 == null);
      while (true)
      {
        zzb((zzzw)localObject2);
        paramParcel2.writeNoException();
        break;
        IInterface localIInterface2 = localIBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
        if ((localIInterface2 instanceof zzzw))
          localObject2 = (zzzw)localIInterface2;
        else
          localObject2 = new zzzy(localIBinder2);
      }
      setManualImpressionsEnabled(zzfo.zza(paramParcel1));
      paramParcel2.writeNoException();
      continue;
      boolean bool1 = isLoading();
      paramParcel2.writeNoException();
      zzfo.writeBoolean(paramParcel2, bool1);
      continue;
      zza(zzatd.zzah(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      setUserId(paramParcel1.readString());
      paramParcel2.writeNoException();
      continue;
      zzaap localzzaap = getVideoController();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzaap);
      continue;
      zza((zzacc)zzfo.zza(paramParcel1, zzacc.CREATOR));
      paramParcel2.writeNoException();
      continue;
      zza((zzaav)zzfo.zza(paramParcel1, zzaav.CREATOR));
      paramParcel2.writeNoException();
      continue;
      String str2 = getAdUnitId();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str2);
      continue;
      zzzq localzzzq = zzpo();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzzq);
      continue;
      zzyx localzzyx = zzpp();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzyx);
      continue;
      setImmersiveMode(zzfo.zza(paramParcel1));
      paramParcel2.writeNoException();
      continue;
      String str1 = zzpj();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str1);
      continue;
      IBinder localIBinder1 = paramParcel1.readStrongBinder();
      Object localObject1 = null;
      if (localIBinder1 == null);
      while (true)
      {
        zza((zzzn)localObject1);
        paramParcel2.writeNoException();
        break;
        IInterface localIInterface1 = localIBinder1.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
        if ((localIInterface1 instanceof zzzn))
          localObject1 = (zzzn)localIInterface1;
        else
          localObject1 = new zzzp(localIBinder1);
      }
      Bundle localBundle = getAdMetadata();
      paramParcel2.writeNoException();
      zzfo.zzb(paramParcel2, localBundle);
      continue;
      zzbt(paramParcel1.readString());
      paramParcel2.writeNoException();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzzj
 * JD-Core Version:    0.6.2
 */