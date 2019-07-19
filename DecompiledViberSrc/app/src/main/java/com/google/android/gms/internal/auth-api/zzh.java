package com.google.android.gms.internal.auth-api;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.Status;

public final class zzh
  implements CredentialRequestResult
{
  private final Status mStatus;
  private final Credential zzal;

  public zzh(Status paramStatus, Credential paramCredential)
  {
    this.mStatus = paramStatus;
    this.zzal = paramCredential;
  }

  public static zzh zzd(Status paramStatus)
  {
    return new zzh(paramStatus, null);
  }

  public final Credential getCredential()
  {
    return this.zzal;
  }

  public final Status getStatus()
  {
    return this.mStatus;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth-api.zzh
 * JD-Core Version:    0.6.2
 */