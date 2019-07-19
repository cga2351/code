package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzv;
import com.google.android.gms.internal.auth.zzz;

final class zzg extends AccountTransferClient.zzb<DeviceMetaData>
{
  zzg(AccountTransferClient paramAccountTransferClient, zzv paramzzv)
  {
    super(null);
  }

  protected final void zza(zzz paramzzz)
    throws RemoteException
  {
    paramzzz.zza(new zzh(this, this), this.zzar);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.zzg
 * JD-Core Version:    0.6.2
 */