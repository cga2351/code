package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class GoogleSignInResult
  implements Result
{
  private Status mStatus;
  private GoogleSignInAccount zzaz;

  public GoogleSignInResult(GoogleSignInAccount paramGoogleSignInAccount, Status paramStatus)
  {
    this.zzaz = paramGoogleSignInAccount;
    this.mStatus = paramStatus;
  }

  public GoogleSignInAccount getSignInAccount()
  {
    return this.zzaz;
  }

  public Status getStatus()
  {
    return this.mStatus;
  }

  public boolean isSuccess()
  {
    return this.mStatus.isSuccess();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInResult
 * JD-Core Version:    0.6.2
 */