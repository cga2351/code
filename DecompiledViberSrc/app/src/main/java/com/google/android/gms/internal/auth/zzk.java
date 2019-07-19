package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.common.api.Status;

final class zzk extends zzn
{
  zzk(zzj paramzzj)
  {
  }

  public final void zzc(Account paramAccount)
  {
    zzj localzzj = this.zzaf;
    if (paramAccount != null);
    for (Status localStatus = Status.RESULT_SUCCESS; ; localStatus = zzh.zzc())
    {
      localzzj.setResult(new zzo(localStatus, paramAccount));
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzk
 * JD-Core Version:    0.6.2
 */