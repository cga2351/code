package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzaro extends zzfn
  implements zzarn
{
  public zzaro()
  {
    super("com.google.android.gms.ads.internal.request.IAdRequestService");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    case 3:
    default:
      return false;
    case 1:
      zzarj localzzarj = zza((zzarh)zzfo.zza(paramParcel1, zzarh.CREATOR));
      paramParcel2.writeNoException();
      zzfo.zzb(paramParcel2, localzzarj);
      return true;
    case 2:
      zzarh localzzarh = (zzarh)zzfo.zza(paramParcel1, zzarh.CREATOR);
      IBinder localIBinder3 = paramParcel1.readStrongBinder();
      Object localObject3 = null;
      if (localIBinder3 == null);
      while (true)
      {
        zza(localzzarh, (zzarq)localObject3);
        paramParcel2.writeNoException();
        break;
        IInterface localIInterface3 = localIBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
        if ((localIInterface3 instanceof zzarq))
          localObject3 = (zzarq)localIInterface3;
        else
          localObject3 = new zzarr(localIBinder3);
      }
    case 4:
      zzary localzzary2 = (zzary)zzfo.zza(paramParcel1, zzary.CREATOR);
      IBinder localIBinder2 = paramParcel1.readStrongBinder();
      Object localObject2 = null;
      if (localIBinder2 == null);
      while (true)
      {
        zza(localzzary2, (zzars)localObject2);
        paramParcel2.writeNoException();
        break;
        IInterface localIInterface2 = localIBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
        if ((localIInterface2 instanceof zzars))
          localObject2 = (zzars)localIInterface2;
        else
          localObject2 = new zzaru(localIBinder2);
      }
    case 5:
    }
    zzary localzzary1 = (zzary)zzfo.zza(paramParcel1, zzary.CREATOR);
    IBinder localIBinder1 = paramParcel1.readStrongBinder();
    Object localObject1 = null;
    if (localIBinder1 == null);
    while (true)
    {
      zzb(localzzary1, (zzars)localObject1);
      paramParcel2.writeNoException();
      break;
      IInterface localIInterface1 = localIBinder1.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
      if ((localIInterface1 instanceof zzars))
        localObject1 = (zzars)localIInterface1;
      else
        localObject1 = new zzaru(localIBinder1);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaro
 * JD-Core Version:    0.6.2
 */