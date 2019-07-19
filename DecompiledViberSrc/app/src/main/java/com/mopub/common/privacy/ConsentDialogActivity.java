package com.mopub.common.privacy;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Window;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.ConsentLogEvent;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.mobileads.MoPubErrorCode;

public class ConsentDialogActivity extends Activity
{
  a a;
  Handler b;
  ConsentStatus c;
  private Runnable d;

  static void a(Context paramContext, String paramString)
  {
    Preconditions.checkNotNull(paramContext);
    if (TextUtils.isEmpty(paramString))
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "ConsentDialogActivity htmlData can't be empty string." });
      MoPubLog.ConsentLogEvent localConsentLogEvent2 = MoPubLog.ConsentLogEvent.SHOW_FAILED;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Integer.valueOf(MoPubErrorCode.INTERNAL_ERROR.getIntCode());
      arrayOfObject2[1] = MoPubErrorCode.INTERNAL_ERROR;
      MoPubLog.log(localConsentLogEvent2, arrayOfObject2);
      return;
    }
    Intent localIntent = b(paramContext, paramString);
    try
    {
      Intents.startActivity(paramContext, localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "ConsentDialogActivity not found - did you declare it in AndroidManifest.xml?" });
      MoPubLog.ConsentLogEvent localConsentLogEvent1 = MoPubLog.ConsentLogEvent.SHOW_FAILED;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Integer.valueOf(MoPubErrorCode.INTERNAL_ERROR.getIntCode());
      arrayOfObject1[1] = MoPubErrorCode.INTERNAL_ERROR;
      MoPubLog.log(localConsentLogEvent1, arrayOfObject1);
      return;
    }
    catch (IntentNotResolvableException localIntentNotResolvableException)
    {
      label79: break label79;
    }
  }

  private void a(ConsentStatus paramConsentStatus)
  {
    Preconditions.checkNotNull(paramConsentStatus);
    this.c = paramConsentStatus;
  }

  static Intent b(Context paramContext, String paramString)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("html-page-content", paramString);
    return Intents.getStartActivityIntent(paramContext, ConsentDialogActivity.class, localBundle);
  }

  void a(boolean paramBoolean)
  {
    if (this.b != null)
      this.b.removeCallbacks(this.d);
    if (this.a != null)
      this.a.setCloseVisible(paramBoolean);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    String str = getIntent().getStringExtra("html-page-content");
    if (TextUtils.isEmpty(str))
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Web page for ConsentDialogActivity is empty" });
      MoPubLog.ConsentLogEvent localConsentLogEvent2 = MoPubLog.ConsentLogEvent.SHOW_FAILED;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Integer.valueOf(MoPubErrorCode.INTERNAL_ERROR.getIntCode());
      arrayOfObject2[1] = MoPubErrorCode.INTERNAL_ERROR;
      MoPubLog.log(localConsentLogEvent2, arrayOfObject2);
      finish();
      return;
    }
    requestWindowFeature(1);
    getWindow().addFlags(1024);
    try
    {
      this.a = new a(this);
      this.a.a(new a.a()
      {
        public void onCloseClick()
        {
          ConsentDialogActivity.this.finish();
        }

        public void onConsentClick(ConsentStatus paramAnonymousConsentStatus)
        {
          ConsentDialogActivity.a(ConsentDialogActivity.this, paramAnonymousConsentStatus);
          ConsentDialogActivity.this.a(false);
        }
      });
      this.d = new Runnable()
      {
        public void run()
        {
          ConsentDialogActivity.this.a(true);
        }
      };
      setContentView(this.a);
      this.a.a(str, new a.b()
      {
        public void onLoadProgress(int paramAnonymousInt)
        {
          if (paramAnonymousInt == a.a);
        }
      });
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM_WITH_THROWABLE, new Object[] { "Unable to create WebView", localRuntimeException });
      MoPubLog.ConsentLogEvent localConsentLogEvent1 = MoPubLog.ConsentLogEvent.SHOW_FAILED;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Integer.valueOf(MoPubErrorCode.INTERNAL_ERROR.getIntCode());
      arrayOfObject1[1] = MoPubErrorCode.INTERNAL_ERROR;
      MoPubLog.log(localConsentLogEvent1, arrayOfObject1);
      finish();
    }
  }

  protected void onDestroy()
  {
    PersonalInfoManager localPersonalInfoManager = MoPub.getPersonalInformationManager();
    if ((localPersonalInfoManager != null) && (this.c != null))
      localPersonalInfoManager.a(this.c);
    super.onDestroy();
  }

  protected void onResume()
  {
    super.onResume();
    MoPubLog.log(MoPubLog.ConsentLogEvent.SHOW_SUCCESS, new Object[0]);
  }

  protected void onStart()
  {
    super.onStart();
    this.b = new Handler();
    this.b.postDelayed(this.d, 10000L);
  }

  protected void onStop()
  {
    super.onStop();
    a(true);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.privacy.ConsentDialogActivity
 * JD-Core Version:    0.6.2
 */