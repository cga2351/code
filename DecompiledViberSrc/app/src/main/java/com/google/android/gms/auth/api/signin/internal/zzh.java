package com.google.android.gms.auth.api.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.OptionalPendingResultImpl;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class zzh
{
  private static Logger zzbd = new Logger("GoogleSignInCommon", new String[0]);

  public static GoogleSignInResult getSignInResultFromIntent(Intent paramIntent)
  {
    if ((paramIntent == null) || ((!paramIntent.hasExtra("googleSignInStatus")) && (!paramIntent.hasExtra("googleSignInAccount"))))
      return null;
    GoogleSignInAccount localGoogleSignInAccount = (GoogleSignInAccount)paramIntent.getParcelableExtra("googleSignInAccount");
    Status localStatus = (Status)paramIntent.getParcelableExtra("googleSignInStatus");
    if (localGoogleSignInAccount != null)
      localStatus = Status.RESULT_SUCCESS;
    return new GoogleSignInResult(localGoogleSignInAccount, localStatus);
  }

  public static Intent zzc(Context paramContext, GoogleSignInOptions paramGoogleSignInOptions)
  {
    zzbd.d("getSignInIntent()", new Object[0]);
    SignInConfiguration localSignInConfiguration = new SignInConfiguration(paramContext.getPackageName(), paramGoogleSignInOptions);
    Intent localIntent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.setClass(paramContext, SignInHubActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("config", localSignInConfiguration);
    localIntent.putExtra("config", localBundle);
    return localIntent;
  }

  public static OptionalPendingResult<GoogleSignInResult> zzc(GoogleApiClient paramGoogleApiClient, Context paramContext, GoogleSignInOptions paramGoogleSignInOptions, boolean paramBoolean)
  {
    zzbd.d("silentSignIn()", new Object[0]);
    zzbd.d("getEligibleSavedSignInResult()", new Object[0]);
    Preconditions.checkNotNull(paramGoogleSignInOptions);
    GoogleSignInOptions localGoogleSignInOptions = zzp.zzd(paramContext).zzi();
    Account localAccount1;
    Account localAccount2;
    boolean bool;
    GoogleSignInAccount localGoogleSignInAccount;
    if (localGoogleSignInOptions != null)
    {
      localAccount1 = localGoogleSignInOptions.getAccount();
      localAccount2 = paramGoogleSignInOptions.getAccount();
      if (localAccount1 == null)
        if (localAccount2 == null)
        {
          bool = true;
          if ((!bool) || (paramGoogleSignInOptions.isServerAuthCodeRequested()) || ((paramGoogleSignInOptions.isIdTokenRequested()) && ((!localGoogleSignInOptions.isIdTokenRequested()) || (!paramGoogleSignInOptions.getServerClientId().equals(localGoogleSignInOptions.getServerClientId())))) || (!new HashSet(localGoogleSignInOptions.getScopes()).containsAll(new HashSet(paramGoogleSignInOptions.getScopes()))))
            break label220;
          localGoogleSignInAccount = zzp.zzd(paramContext).zzh();
          if ((localGoogleSignInAccount == null) || (localGoogleSignInAccount.isExpired()))
            break label220;
        }
    }
    label220: for (GoogleSignInResult localGoogleSignInResult = new GoogleSignInResult(localGoogleSignInAccount, Status.RESULT_SUCCESS); ; localGoogleSignInResult = null)
    {
      if (localGoogleSignInResult == null)
        break label226;
      zzbd.d("Eligible saved sign in result found", new Object[0]);
      return PendingResults.immediatePendingResult(localGoogleSignInResult, paramGoogleApiClient);
      bool = false;
      break;
      bool = localAccount1.equals(localAccount2);
      break;
    }
    label226: if (paramBoolean)
      return PendingResults.immediatePendingResult(new GoogleSignInResult(null, new Status(4)), paramGoogleApiClient);
    zzbd.d("trySilentSignIn()", new Object[0]);
    return new OptionalPendingResultImpl(paramGoogleApiClient.enqueue(new zzi(paramGoogleApiClient, paramContext, paramGoogleSignInOptions)));
  }

  public static PendingResult<Status> zzc(GoogleApiClient paramGoogleApiClient, Context paramContext, boolean paramBoolean)
  {
    zzbd.d("Signing out", new Object[0]);
    zzc(paramContext);
    if (paramBoolean)
      return PendingResults.immediatePendingResult(Status.RESULT_SUCCESS, paramGoogleApiClient);
    return paramGoogleApiClient.execute(new zzk(paramGoogleApiClient));
  }

  private static void zzc(Context paramContext)
  {
    zzp.zzd(paramContext).clear();
    Iterator localIterator = GoogleApiClient.getAllClients().iterator();
    while (localIterator.hasNext())
      ((GoogleApiClient)localIterator.next()).maybeSignOut();
    GoogleApiManager.reportSignOut();
  }

  public static Intent zzd(Context paramContext, GoogleSignInOptions paramGoogleSignInOptions)
  {
    zzbd.d("getFallbackSignInIntent()", new Object[0]);
    Intent localIntent = zzc(paramContext, paramGoogleSignInOptions);
    localIntent.setAction("com.google.android.gms.auth.APPAUTH_SIGN_IN");
    return localIntent;
  }

  public static PendingResult<Status> zzd(GoogleApiClient paramGoogleApiClient, Context paramContext, boolean paramBoolean)
  {
    zzbd.d("Revoking access", new Object[0]);
    String str = Storage.getInstance(paramContext).getSavedRefreshToken();
    zzc(paramContext);
    if (paramBoolean)
      return zzd.zzc(str);
    return paramGoogleApiClient.execute(new zzm(paramGoogleApiClient));
  }

  public static Intent zze(Context paramContext, GoogleSignInOptions paramGoogleSignInOptions)
  {
    zzbd.d("getNoImplementationSignInIntent()", new Object[0]);
    Intent localIntent = zzc(paramContext, paramGoogleSignInOptions);
    localIntent.setAction("com.google.android.gms.auth.NO_IMPL");
    return localIntent;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzh
 * JD-Core Version:    0.6.2
 */