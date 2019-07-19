package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public abstract interface GoogleSignInApi
{
  public static final String EXTRA_SIGN_IN_ACCOUNT = "signInAccount";

  public abstract Intent getSignInIntent(GoogleApiClient paramGoogleApiClient);

  public abstract GoogleSignInResult getSignInResultFromIntent(Intent paramIntent);

  public abstract PendingResult<Status> revokeAccess(GoogleApiClient paramGoogleApiClient);

  public abstract PendingResult<Status> signOut(GoogleApiClient paramGoogleApiClient);

  public abstract OptionalPendingResult<GoogleSignInResult> silentSignIn(GoogleApiClient paramGoogleApiClient);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInApi
 * JD-Core Version:    0.6.2
 */