package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzzb extends zzfn
  implements zzza
{
  public zzzb()
  {
    super("com.google.android.gms.ads.internal.client.IAdLoader");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      zza((zzxx)zzfo.zza(paramParcel1, zzxx.CREATOR));
      paramParcel2.writeNoException();
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      return true;
      String str2 = getMediationAdapterClassName();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str2);
      continue;
      boolean bool = isLoading();
      paramParcel2.writeNoException();
      zzfo.writeBoolean(paramParcel2, bool);
      continue;
      String str1 = zzpj();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str1);
      continue;
      zza((zzxx)zzfo.zza(paramParcel1, zzxx.CREATOR), paramParcel1.readInt());
      paramParcel2.writeNoException();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzzb
 * JD-Core Version:    0.6.2
 */