package com.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;

public class LoginActivity extends ViberFragmentActivity
{
  private static final String EXTRA_REQUEST = "request";
  private static final Logger L = ViberEnv.getLogger();
  private static final String NULL_CALLING_PKG_ERROR_MSG = "Cannot call LoginActivity with a null calling package. This can occur if the launchMode of the caller is singleInstance.";
  public static final String RESULT_KEY = "com.facebook.LoginActivity:Result";
  private static final String SAVED_AUTH_CLIENT = "authorizationClient";
  private static final String SAVED_CALLING_PKG_KEY = "callingPackage";
  private AuthorizationClient authorizationClient;
  private String callingPackage;
  private AuthorizationClient.AuthorizationRequest request;

  private void onAuthClientCompleted(AuthorizationClient.Result paramResult)
  {
    this.request = null;
    if (paramResult.code == AuthorizationClient.Result.Code.CANCEL);
    for (int i = 0; ; i = -1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("com.facebook.LoginActivity:Result", paramResult);
      Intent localIntent = new Intent();
      localIntent.putExtras(localBundle);
      setResult(i, localIntent);
      finish();
      return;
    }
  }

  public static Bundle populateIntentExtras(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("request", paramAuthorizationRequest);
    return localBundle;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AuthorizationClient localAuthorizationClient = this.authorizationClient;
    if (paramIntent != null);
    for (Bundle localBundle = paramIntent.getExtras(); ; localBundle = null)
    {
      localAuthorizationClient.onActivityResult(paramInt1, paramInt2, localBundle);
      return;
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.com_facebook_login_activity_layout);
    if (paramBundle != null)
    {
      this.callingPackage = paramBundle.getString("callingPackage");
      this.authorizationClient = ((AuthorizationClient)paramBundle.getParcelable("authorizationClient"));
    }
    while (true)
    {
      this.authorizationClient.setContext(this);
      this.authorizationClient.setOnCompletedListener(new AuthorizationClient.OnCompletedListener()
      {
        public void onCompleted(AuthorizationClient.Result paramAnonymousResult)
        {
          LoginActivity.this.onAuthClientCompleted(paramAnonymousResult);
        }
      });
      this.authorizationClient.setBackgroundProcessingListener(new AuthorizationClient.BackgroundProcessingListener()
      {
        public void onBackgroundProcessingStarted()
        {
          LoginActivity.this.findViewById(R.id.com_facebook_login_activity_progress_bar).setVisibility(0);
        }

        public void onBackgroundProcessingStopped()
        {
          LoginActivity.this.findViewById(R.id.com_facebook_login_activity_progress_bar).setVisibility(8);
        }
      });
      return;
      this.callingPackage = getCallingPackage();
      this.authorizationClient = new AuthorizationClient();
      this.request = ((AuthorizationClient.AuthorizationRequest)getIntent().getExtras().getParcelable("request"));
    }
  }

  public void onPause()
  {
    super.onPause();
    this.authorizationClient.cancelCurrentHandler();
    findViewById(R.id.com_facebook_login_activity_progress_bar).setVisibility(8);
  }

  public void onResume()
  {
    super.onResume();
    if (this.callingPackage == null)
    {
      L.e("?", new Object[] { "Cannot call LoginActivity with a null calling package. This can occur if the launchMode of the caller is singleInstance." });
      finish();
      return;
    }
    this.authorizationClient.startOrContinueAuth(this.request);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("callingPackage", this.callingPackage);
    paramBundle.putParcelable("authorizationClient", this.authorizationClient);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.LoginActivity
 * JD-Core Version:    0.6.2
 */