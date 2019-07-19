package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public abstract class zzaox extends zzfn
  implements zzaow
{
  public zzaox()
  {
    super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
  }

  public static zzaow zzab(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    if ((localIInterface instanceof zzaow))
      return (zzaow)localIInterface;
    return new zzaoy(paramIBinder);
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    IBinder localIBinder5;
    Object localObject5;
    switch (paramInt1)
    {
    case 4:
    case 6:
    case 7:
    case 8:
    case 9:
    case 12:
    default:
      return false;
    case 1:
      IObjectWrapper localIObjectWrapper5 = IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder());
      String str9 = paramParcel1.readString();
      Bundle localBundle1 = (Bundle)zzfo.zza(paramParcel1, Bundle.CREATOR);
      Bundle localBundle2 = (Bundle)zzfo.zza(paramParcel1, Bundle.CREATOR);
      zzyb localzzyb = (zzyb)zzfo.zza(paramParcel1, zzyb.CREATOR);
      localIBinder5 = paramParcel1.readStrongBinder();
      localObject5 = null;
      if (localIBinder5 == null)
      {
        zza(localIObjectWrapper5, str9, localBundle1, localBundle2, localzzyb, (zzaoz)localObject5);
        paramParcel2.writeNoException();
      }
    case 2:
    case 3:
    case 5:
    case 10:
    case 11:
    case 13:
    case 14:
    case 15:
    case 16:
    case 17:
      while (true)
      {
        return true;
        IInterface localIInterface5 = localIBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
        if ((localIInterface5 instanceof zzaoz))
        {
          localObject5 = (zzaoz)localIInterface5;
          break;
        }
        localObject5 = new zzapb(localIBinder5);
        break;
        zzapk localzzapk2 = zzsx();
        paramParcel2.writeNoException();
        zzfo.zzb(paramParcel2, localzzapk2);
        continue;
        zzapk localzzapk1 = zzsy();
        paramParcel2.writeNoException();
        zzfo.zzb(paramParcel2, localzzapk1);
        continue;
        zzaap localzzaap = getVideoController();
        paramParcel2.writeNoException();
        zzfo.zza(paramParcel2, localzzaap);
        continue;
        zzx(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        continue;
        zza(paramParcel1.createStringArray(), (Bundle[])paramParcel1.createTypedArray(Bundle.CREATOR));
        paramParcel2.writeNoException();
        continue;
        String str7 = paramParcel1.readString();
        String str8 = paramParcel1.readString();
        zzxx localzzxx4 = (zzxx)zzfo.zza(paramParcel1, zzxx.CREATOR);
        IObjectWrapper localIObjectWrapper4 = IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder());
        IBinder localIBinder4 = paramParcel1.readStrongBinder();
        Object localObject4;
        if (localIBinder4 == null)
          localObject4 = null;
        while (true)
        {
          zza(str7, str8, localzzxx4, localIObjectWrapper4, (zzaok)localObject4, zzamx.zzz(paramParcel1.readStrongBinder()), (zzyb)zzfo.zza(paramParcel1, zzyb.CREATOR));
          paramParcel2.writeNoException();
          break;
          IInterface localIInterface4 = localIBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
          if ((localIInterface4 instanceof zzaok))
            localObject4 = (zzaok)localIInterface4;
          else
            localObject4 = new zzaom(localIBinder4);
        }
        String str5 = paramParcel1.readString();
        String str6 = paramParcel1.readString();
        zzxx localzzxx3 = (zzxx)zzfo.zza(paramParcel1, zzxx.CREATOR);
        IObjectWrapper localIObjectWrapper3 = IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder());
        IBinder localIBinder3 = paramParcel1.readStrongBinder();
        Object localObject3;
        if (localIBinder3 == null)
          localObject3 = null;
        while (true)
        {
          zza(str5, str6, localzzxx3, localIObjectWrapper3, (zzaon)localObject3, zzamx.zzz(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          break;
          IInterface localIInterface3 = localIBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
          if ((localIInterface3 instanceof zzaon))
            localObject3 = (zzaon)localIInterface3;
          else
            localObject3 = new zzaop(localIBinder3);
        }
        boolean bool2 = zzy(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        zzfo.writeBoolean(paramParcel2, bool2);
        continue;
        String str3 = paramParcel1.readString();
        String str4 = paramParcel1.readString();
        zzxx localzzxx2 = (zzxx)zzfo.zza(paramParcel1, zzxx.CREATOR);
        IObjectWrapper localIObjectWrapper2 = IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder());
        IBinder localIBinder2 = paramParcel1.readStrongBinder();
        Object localObject2;
        if (localIBinder2 == null)
          localObject2 = null;
        while (true)
        {
          zza(str3, str4, localzzxx2, localIObjectWrapper2, (zzaot)localObject2, zzamx.zzz(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          break;
          IInterface localIInterface2 = localIBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
          if ((localIInterface2 instanceof zzaot))
            localObject2 = (zzaot)localIInterface2;
          else
            localObject2 = new zzaov(localIBinder2);
        }
        boolean bool1 = zzz(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        zzfo.writeBoolean(paramParcel2, bool1);
      }
    case 18:
    }
    String str1 = paramParcel1.readString();
    String str2 = paramParcel1.readString();
    zzxx localzzxx1 = (zzxx)zzfo.zza(paramParcel1, zzxx.CREATOR);
    IObjectWrapper localIObjectWrapper1 = IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder());
    IBinder localIBinder1 = paramParcel1.readStrongBinder();
    Object localObject1;
    if (localIBinder1 == null)
      localObject1 = null;
    while (true)
    {
      zza(str1, str2, localzzxx1, localIObjectWrapper1, (zzaoq)localObject1, zzamx.zzz(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      break;
      IInterface localIInterface1 = localIBinder1.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
      if ((localIInterface1 instanceof zzaoq))
        localObject1 = (zzaoq)localIInterface1;
      else
        localObject1 = new zzaos(localIBinder1);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaox
 * JD-Core Version:    0.6.2
 */