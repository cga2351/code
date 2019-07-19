package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.gcm.zzd;

public final class zzh extends zzd
  implements zzg
{
  zzh(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.gcm.INetworkTaskCallback");
  }

  public final void zzf(int paramInt)
    throws RemoteException
  {
    Parcel localParcel = zzd();
    localParcel.writeInt(paramInt);
    zzd(2, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.gcm.zzh
 * JD-Core Version:    0.6.2
 */