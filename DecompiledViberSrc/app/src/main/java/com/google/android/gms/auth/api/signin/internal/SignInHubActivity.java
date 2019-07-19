package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

@KeepName
public class SignInHubActivity extends FragmentActivity
{
  private static boolean zzbt = false;
  private boolean zzbu = false;
  private SignInConfiguration zzbv;
  private boolean zzbw;
  private int zzbx;
  private Intent zzby;

  private final void zzc(int paramInt)
  {
    Status localStatus = new Status(paramInt);
    Intent localIntent = new Intent();
    localIntent.putExtra("googleSignInStatus", localStatus);
    setResult(0, localIntent);
    finish();
    zzbt = false;
  }

  private final void zzn()
  {
    getSupportLoaderManager().initLoader(0, null, new zzc(null));
    zzbt = false;
  }

  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return true;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.zzbu)
      return;
    setResult(0);
    switch (paramInt1)
    {
    default:
      return;
    case 40962:
    }
    if (paramIntent != null)
    {
      SignInAccount localSignInAccount = (SignInAccount)paramIntent.getParcelableExtra("signInAccount");
      if ((localSignInAccount != null) && (localSignInAccount.getGoogleSignInAccount() != null))
      {
        GoogleSignInAccount localGoogleSignInAccount = localSignInAccount.getGoogleSignInAccount();
        zzp.zzd(this).zzc(this.zzbv.zzm(), localGoogleSignInAccount);
        paramIntent.removeExtra("signInAccount");
        paramIntent.putExtra("googleSignInAccount", localGoogleSignInAccount);
        this.zzbw = true;
        this.zzbx = paramInt2;
        this.zzby = paramIntent;
        zzn();
        return;
      }
      if (paramIntent.hasExtra("errorCode"))
      {
        int i = paramIntent.getIntExtra("errorCode", 8);
        if (i == 13)
          i = 12501;
        zzc(i);
        return;
      }
    }
    zzc(8);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Intent localIntent1 = getIntent();
    String str1 = localIntent1.getAction();
    if ("com.google.android.gms.auth.NO_IMPL".equals(str1))
      zzc(12500);
    do
    {
      return;
      if ((!str1.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) && (!str1.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")))
      {
        String str2 = String.valueOf(localIntent1.getAction());
        if (str2.length() != 0);
        for (String str3 = "Unknown action: ".concat(str2); ; str3 = new String("Unknown action: "))
        {
          Log.e("AuthSignInClient", str3);
          finish();
          return;
        }
      }
      this.zzbv = ((SignInConfiguration)localIntent1.getBundleExtra("config").getParcelable("config"));
      if (this.zzbv == null)
      {
        Log.e("AuthSignInClient", "Activity started with invalid configuration.");
        setResult(0);
        finish();
        return;
      }
      int i;
      if (paramBundle == null)
        i = 1;
      while (i != 0)
        if (zzbt)
        {
          setResult(0);
          zzc(12502);
          return;
          i = 0;
        }
        else
        {
          zzbt = true;
          Intent localIntent2 = new Intent(str1);
          if (str1.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN"))
            localIntent2.setPackage("com.google.android.gms");
          while (true)
          {
            localIntent2.putExtra("config", this.zzbv);
            try
            {
              startActivityForResult(localIntent2, 40962);
              return;
            }
            catch (ActivityNotFoundException localActivityNotFoundException)
            {
              this.zzbu = true;
              Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
              zzc(17);
              return;
            }
            localIntent2.setPackage(getPackageName());
          }
        }
      this.zzbw = paramBundle.getBoolean("signingInGoogleApiClients");
    }
    while (!this.zzbw);
    this.zzbx = paramBundle.getInt("signInResultCode");
    this.zzby = ((Intent)paramBundle.getParcelable("signInResultData"));
    zzn();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("signingInGoogleApiClients", this.zzbw);
    if (this.zzbw)
    {
      paramBundle.putInt("signInResultCode", this.zzbx);
      paramBundle.putParcelable("signInResultData", this.zzby);
    }
  }

  private final class zzc
    implements LoaderManager.LoaderCallbacks<Void>
  {
    private zzc()
    {
    }

    public final Loader<Void> onCreateLoader(int paramInt, Bundle paramBundle)
    {
      return new zze(SignInHubActivity.this, GoogleApiClient.getAllClients());
    }

    public final void onLoaderReset(Loader<Void> paramLoader)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.SignInHubActivity
 * JD-Core Version:    0.6.2
 */