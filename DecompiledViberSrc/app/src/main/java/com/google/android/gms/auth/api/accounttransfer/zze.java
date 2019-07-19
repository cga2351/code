package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzad;
import com.google.android.gms.internal.auth.zzz;

final class zze extends AccountTransferClient.zzb<byte[]>
{
  zze(AccountTransferClient paramAccountTransferClient, zzad paramzzad)
  {
    super(null);
  }

  protected final void zza(zzz paramzzz)
    throws RemoteException
  {
    paramzzz.zza(new zzf(this, this), this.zzap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.zze
 * JD-Core Version:    0.6.2
 */