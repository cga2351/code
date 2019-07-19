package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public abstract class zzatm extends zzfn
  implements zzatl
{
  public zzatm()
  {
    super("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
  }

  public static zzatl zzai(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    if ((localIInterface instanceof zzatl))
      return (zzatl)localIInterface;
    return new zzatn(paramIBinder);
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      zzae(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
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
      paramParcel2.writeNoException();
      return true;
      zzd(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      continue;
      zzaf(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      continue;
      zzag(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      continue;
      zzah(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      continue;
      zzai(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      continue;
      zza(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), (zzatp)zzfo.zza(paramParcel1, zzatp.CREATOR));
      continue;
      zzaj(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      continue;
      zze(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      continue;
      zzak(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      continue;
      zzal(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      continue;
      zzb((Bundle)zzfo.zza(paramParcel1, Bundle.CREATOR));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzatm
 * JD-Core Version:    0.6.2
 */