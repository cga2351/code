package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth.zzs;

final class zzk extends zzs
{
  zzk(AccountTransferClient.zzc paramzzc)
  {
  }

  public final void onFailure(Status paramStatus)
  {
    this.zzay.zza(paramStatus);
  }

  public final void zzd()
  {
    this.zzay.setResult(null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.zzk
 * JD-Core Version:    0.6.2
 */