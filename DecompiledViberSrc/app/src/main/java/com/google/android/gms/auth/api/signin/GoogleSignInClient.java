package com.google.android.gms.auth.api.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.internal.zzh;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;

public class GoogleSignInClient extends GoogleApi<GoogleSignInOptions>
{
  private static final zzc zzar = new zzc(null);

  @VisibleForTesting
  private static int zzas = zzd.zzau;

  GoogleSignInClient(Activity paramActivity, GoogleSignInOptions paramGoogleSignInOptions)
  {
    super(paramActivity, Auth.GOOGLE_SIGN_IN_API, paramGoogleSignInOptions, new ApiExceptionMapper());
  }

  GoogleSignInClient(Context paramContext, GoogleSignInOptions paramGoogleSignInOptions)
  {
    super(paramContext, Auth.GOOGLE_SIGN_IN_API, paramGoogleSignInOptions, new ApiExceptionMapper());
  }

  private final int zze()
  {
    while (true)
    {
      try
      {
        Context localContext;
        GoogleApiAvailability localGoogleApiAvailability;
        int j;
        if (zzas == zzd.zzau)
        {
          localContext = getApplicationContext();
          localGoogleApiAvailability = GoogleApiAvailability.getInstance();
          j = localGoogleApiAvailability.isGooglePlayServicesAvailable(localContext, 12451000);
          if (j == 0)
            zzas = zzd.zzax;
        }
        else
        {
          int i = zzas;
          return i;
        }
        if ((localGoogleApiAvailability.getErrorResolutionIntent(localContext, j, null) == null) && (DynamiteModule.getLocalVersion(localContext, "com.google.android.gms.auth.api.fallback") != 0))
        {
          zzas = zzd.zzaw;
          continue;
        }
      }
      finally
      {
      }
      zzas = zzd.zzav;
    }
  }

  public Intent getSignInIntent()
  {
    Context localContext = getApplicationContext();
    switch (zzc.zzat[(-1 + zze())])
    {
    default:
      return zzh.zze(localContext, (GoogleSignInOptions)getApiOptions());
    case 1:
      return zzh.zzd(localContext, (GoogleSignInOptions)getApiOptions());
    case 2:
    }
    return zzh.zzc(localContext, (GoogleSignInOptions)getApiOptions());
  }

  public Task<Void> revokeAccess()
  {
    GoogleApiClient localGoogleApiClient = asGoogleApiClient();
    Context localContext = getApplicationContext();
    if (zze() == zzd.zzaw);
    for (boolean bool = true; ; bool = false)
      return PendingResultUtil.toVoidTask(zzh.zzd(localGoogleApiClient, localContext, bool));
  }

  public Task<Void> signOut()
  {
    GoogleApiClient localGoogleApiClient = asGoogleApiClient();
    Context localContext = getApplicationContext();
    if (zze() == zzd.zzaw);
    for (boolean bool = true; ; bool = false)
      return PendingResultUtil.toVoidTask(zzh.zzc(localGoogleApiClient, localContext, bool));
  }

  public Task<GoogleSignInAccount> silentSignIn()
  {
    GoogleApiClient localGoogleApiClient = asGoogleApiClient();
    Context localContext = getApplicationContext();
    GoogleSignInOptions localGoogleSignInOptions = (GoogleSignInOptions)getApiOptions();
    if (zze() == zzd.zzaw);
    for (boolean bool = true; ; bool = false)
      return PendingResultUtil.toTask(zzh.zzc(localGoogleApiClient, localContext, localGoogleSignInOptions, bool), zzar);
  }

  private static final class zzc
    implements PendingResultUtil.ResultConverter<GoogleSignInResult, GoogleSignInAccount>
  {
  }

  @VisibleForTesting
  static enum zzd
  {
    static
    {
      int[] arrayOfInt = new int[4];
      arrayOfInt[0] = zzau;
      arrayOfInt[1] = zzav;
      arrayOfInt[2] = zzaw;
      arrayOfInt[3] = zzax;
    }

    public static int[] values$50KLMJ33DTMIUPRFDTJMOP9FC5N68SJFD5I2UPRDECNM2TBKD0NM2S395TPMIPRED5N2UHRFDTJMOPAJD5JMSIBE8DM6IPBEEGI4IRBGDHIMQPBEEHGN8QBFDOTG____0()
    {
      return (int[])zzay.clone();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInClient
 * JD-Core Version:    0.6.2
 */