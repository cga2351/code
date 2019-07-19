package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public abstract class zzamu extends zzfn
  implements zzamt
{
  public zzamu()
  {
    super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    IBinder localIBinder6;
    Object localObject6;
    switch (paramInt1)
    {
    case 29:
    default:
      return false;
    case 1:
      IObjectWrapper localIObjectWrapper7 = IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder());
      zzyb localzzyb2 = (zzyb)zzfo.zza(paramParcel1, zzyb.CREATOR);
      zzxx localzzxx6 = (zzxx)zzfo.zza(paramParcel1, zzxx.CREATOR);
      String str9 = paramParcel1.readString();
      localIBinder6 = paramParcel1.readStrongBinder();
      if (localIBinder6 == null)
      {
        localObject6 = null;
        zza(localIObjectWrapper7, localzzyb2, localzzxx6, str9, (zzamw)localObject6);
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
    case 12:
    case 13:
    case 14:
    case 15:
    case 16:
    case 17:
    case 18:
    case 19:
    case 20:
    case 21:
    case 22:
    case 23:
    case 24:
    case 25:
    case 26:
    case 27:
    case 28:
    case 30:
    case 31:
    }
    while (true)
    {
      return true;
      IInterface localIInterface6 = localIBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
      if ((localIInterface6 instanceof zzamw))
      {
        localObject6 = (zzamw)localIInterface6;
        break;
      }
      localObject6 = new zzamy(localIBinder6);
      break;
      IObjectWrapper localIObjectWrapper6 = zzse();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localIObjectWrapper6);
      continue;
      IObjectWrapper localIObjectWrapper5 = IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder());
      zzxx localzzxx5 = (zzxx)zzfo.zza(paramParcel1, zzxx.CREATOR);
      String str8 = paramParcel1.readString();
      IBinder localIBinder5 = paramParcel1.readStrongBinder();
      Object localObject5 = null;
      if (localIBinder5 == null);
      while (true)
      {
        zza(localIObjectWrapper5, localzzxx5, str8, (zzamw)localObject5);
        paramParcel2.writeNoException();
        break;
        IInterface localIInterface5 = localIBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        if ((localIInterface5 instanceof zzamw))
          localObject5 = (zzamw)localIInterface5;
        else
          localObject5 = new zzamy(localIBinder5);
      }
      showInterstitial();
      paramParcel2.writeNoException();
      continue;
      destroy();
      paramParcel2.writeNoException();
      continue;
      IObjectWrapper localIObjectWrapper4 = IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder());
      zzyb localzzyb1 = (zzyb)zzfo.zza(paramParcel1, zzyb.CREATOR);
      zzxx localzzxx4 = (zzxx)zzfo.zza(paramParcel1, zzxx.CREATOR);
      String str6 = paramParcel1.readString();
      String str7 = paramParcel1.readString();
      IBinder localIBinder4 = paramParcel1.readStrongBinder();
      Object localObject4 = null;
      if (localIBinder4 == null);
      while (true)
      {
        zza(localIObjectWrapper4, localzzyb1, localzzxx4, str6, str7, (zzamw)localObject4);
        paramParcel2.writeNoException();
        break;
        IInterface localIInterface4 = localIBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        if ((localIInterface4 instanceof zzamw))
          localObject4 = (zzamw)localIInterface4;
        else
          localObject4 = new zzamy(localIBinder4);
      }
      IObjectWrapper localIObjectWrapper3 = IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder());
      zzxx localzzxx3 = (zzxx)zzfo.zza(paramParcel1, zzxx.CREATOR);
      String str4 = paramParcel1.readString();
      String str5 = paramParcel1.readString();
      IBinder localIBinder3 = paramParcel1.readStrongBinder();
      Object localObject3;
      if (localIBinder3 == null)
        localObject3 = null;
      while (true)
      {
        zza(localIObjectWrapper3, localzzxx3, str4, str5, (zzamw)localObject3);
        paramParcel2.writeNoException();
        break;
        IInterface localIInterface3 = localIBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        if ((localIInterface3 instanceof zzamw))
          localObject3 = (zzamw)localIInterface3;
        else
          localObject3 = new zzamy(localIBinder3);
      }
      pause();
      paramParcel2.writeNoException();
      continue;
      resume();
      paramParcel2.writeNoException();
      continue;
      zza(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), (zzxx)zzfo.zza(paramParcel1, zzxx.CREATOR), paramParcel1.readString(), zzatm.zzai(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      continue;
      zza((zzxx)zzfo.zza(paramParcel1, zzxx.CREATOR), paramParcel1.readString());
      paramParcel2.writeNoException();
      continue;
      showVideo();
      paramParcel2.writeNoException();
      continue;
      boolean bool2 = isInitialized();
      paramParcel2.writeNoException();
      zzfo.writeBoolean(paramParcel2, bool2);
      continue;
      IObjectWrapper localIObjectWrapper2 = IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder());
      zzxx localzzxx2 = (zzxx)zzfo.zza(paramParcel1, zzxx.CREATOR);
      String str2 = paramParcel1.readString();
      String str3 = paramParcel1.readString();
      IBinder localIBinder2 = paramParcel1.readStrongBinder();
      Object localObject2;
      if (localIBinder2 == null)
        localObject2 = null;
      while (true)
      {
        zza(localIObjectWrapper2, localzzxx2, str2, str3, (zzamw)localObject2, (zzadx)zzfo.zza(paramParcel1, zzadx.CREATOR), paramParcel1.createStringArrayList());
        paramParcel2.writeNoException();
        break;
        IInterface localIInterface2 = localIBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        if ((localIInterface2 instanceof zzamw))
          localObject2 = (zzamw)localIInterface2;
        else
          localObject2 = new zzamy(localIBinder2);
      }
      zzanb localzzanb = zzsf();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzanb);
      continue;
      zzane localzzane = zzsg();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzane);
      continue;
      Bundle localBundle3 = zzsh();
      paramParcel2.writeNoException();
      zzfo.zzb(paramParcel2, localBundle3);
      continue;
      Bundle localBundle2 = getInterstitialAdapterInfo();
      paramParcel2.writeNoException();
      zzfo.zzb(paramParcel2, localBundle2);
      continue;
      Bundle localBundle1 = zzsi();
      paramParcel2.writeNoException();
      zzfo.zzb(paramParcel2, localBundle1);
      continue;
      zza((zzxx)zzfo.zza(paramParcel1, zzxx.CREATOR), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      continue;
      zzr(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      boolean bool1 = zzsj();
      paramParcel2.writeNoException();
      zzfo.writeBoolean(paramParcel2, bool1);
      continue;
      zza(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), zzatm.zzai(paramParcel1.readStrongBinder()), paramParcel1.createStringArrayList());
      paramParcel2.writeNoException();
      continue;
      zzafd localzzafd = zzsk();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzafd);
      continue;
      setImmersiveMode(zzfo.zza(paramParcel1));
      paramParcel2.writeNoException();
      continue;
      zzaap localzzaap = getVideoController();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzaap);
      continue;
      zzanh localzzanh = zzsl();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzanh);
      continue;
      IObjectWrapper localIObjectWrapper1 = IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder());
      zzxx localzzxx1 = (zzxx)zzfo.zza(paramParcel1, zzxx.CREATOR);
      String str1 = paramParcel1.readString();
      IBinder localIBinder1 = paramParcel1.readStrongBinder();
      Object localObject1 = null;
      if (localIBinder1 == null);
      while (true)
      {
        zzb(localIObjectWrapper1, localzzxx1, str1, (zzamw)localObject1);
        paramParcel2.writeNoException();
        break;
        IInterface localIInterface1 = localIBinder1.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        if ((localIInterface1 instanceof zzamw))
          localObject1 = (zzamw)localIInterface1;
        else
          localObject1 = new zzamy(localIBinder1);
      }
      zzs(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      zza(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), zzaiq.zzv(paramParcel1.readStrongBinder()), paramParcel1.createTypedArrayList(zzaix.CREATOR));
      paramParcel2.writeNoException();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzamu
 * JD-Core Version:    0.6.2
 */