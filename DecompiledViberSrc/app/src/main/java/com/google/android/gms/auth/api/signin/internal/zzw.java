package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;

public final class zzw extends zzr
{
  private final Context mContext;

  public zzw(Context paramContext)
  {
    this.mContext = paramContext;
  }

  private final void zzl()
  {
    if (!GooglePlayServicesUtil.isGooglePlayServicesUid(this.mContext, Binder.getCallingUid()))
    {
      int i = Binder.getCallingUid();
      throw new SecurityException(52 + "Calling UID " + i + " is not Google Play services.");
    }
  }

  public final void zzj()
  {
    zzl();
    Storage localStorage = Storage.getInstance(this.mContext);
    GoogleSignInAccount localGoogleSignInAccount = localStorage.getSavedDefaultGoogleSignInAccount();
    GoogleSignInOptions localGoogleSignInOptions = GoogleSignInOptions.DEFAULT_SIGN_IN;
    if (localGoogleSignInAccount != null)
      localGoogleSignInOptions = localStorage.getSavedDefaultGoogleSignInOptions();
    GoogleApiClient localGoogleApiClient = new GoogleApiClient.Builder(this.mContext).addApi(Auth.GOOGLE_SIGN_IN_API, localGoogleSignInOptions).build();
    try
    {
      if (localGoogleApiClient.blockingConnect().isSuccess())
      {
        if (localGoogleSignInAccount == null)
          break label85;
        Auth.GoogleSignInApi.revokeAccess(localGoogleApiClient);
      }
      while (true)
      {
        return;
        label85: localGoogleApiClient.clearDefaultAccountAndReconnect();
      }
    }
    finally
    {
      localGoogleApiClient.disconnect();
    }
  }

  public final void zzk()
  {
    zzl();
    zzp.zzd(this.mContext).clear();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzw
 * JD-Core Version:    0.6.2
 */