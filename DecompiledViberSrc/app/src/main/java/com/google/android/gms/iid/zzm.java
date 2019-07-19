package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.gcm.zzd;
import com.google.android.gms.internal.gcm.zze;

public final class zzm extends zzd
  implements zzl
{
  zzm(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.iid.IMessengerCompat");
  }

  public final void send(Message paramMessage)
    throws RemoteException
  {
    Parcel localParcel = zzd();
    zze.zzd(localParcel, paramMessage);
    zze(1, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.iid.zzm
 * JD-Core Version:    0.6.2
 */