package com.google.android.gms.internal.auth-api;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

final class zzk extends zzg
{
  zzk(zzj paramzzj)
  {
  }

  public final void zzc(Status paramStatus)
  {
    this.zzan.setResult(zzh.zzd(paramStatus));
  }

  public final void zzc(Status paramStatus, Credential paramCredential)
  {
    this.zzan.setResult(new zzh(paramStatus, paramCredential));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth-api.zzk
 * JD-Core Version:    0.6.2
 */