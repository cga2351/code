package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

public abstract class zzaie extends zzfn
  implements zzaid
{
  public zzaie()
  {
    super("com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheCallback");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      zza((ParcelFileDescriptor)zzfo.zza(paramParcel1, ParcelFileDescriptor.CREATOR));
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaie
 * JD-Core Version:    0.6.2
 */