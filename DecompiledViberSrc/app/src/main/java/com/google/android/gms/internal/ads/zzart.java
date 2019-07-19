package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

public abstract class zzart extends zzfn
  implements zzars
{
  public zzart()
  {
    super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      zzb((ParcelFileDescriptor)zzfo.zza(paramParcel1, ParcelFileDescriptor.CREATOR));
    case 2:
    }
    while (true)
    {
      paramParcel2.writeNoException();
      return true;
      zza((zzayn)zzfo.zza(paramParcel1, zzayn.CREATOR));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzart
 * JD-Core Version:    0.6.2
 */