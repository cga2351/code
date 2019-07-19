package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzamr extends zzfn
  implements zzamq
{
  public zzamr()
  {
    super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
  }

  public static zzamq zzy(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    if ((localIInterface instanceof zzamq))
      return (zzamq)localIInterface;
    return new zzams(paramIBinder);
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      zzamt localzzamt = zzcu(paramParcel1.readString());
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzamt);
    case 2:
    case 3:
    }
    while (true)
    {
      return true;
      boolean bool = zzcv(paramParcel1.readString());
      paramParcel2.writeNoException();
      zzfo.writeBoolean(paramParcel2, bool);
      continue;
      zzaow localzzaow = zzcy(paramParcel1.readString());
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzaow);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzamr
 * JD-Core Version:    0.6.2
 */