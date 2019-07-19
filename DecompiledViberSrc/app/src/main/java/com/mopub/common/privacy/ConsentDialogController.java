package com.mopub.common.privacy;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.ConsentLogEvent;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.MoPubRequestQueue;
import com.mopub.network.Networking;
import com.mopub.volley.VolleyError;

public class ConsentDialogController
  implements ConsentDialogRequest.Listener
{
  volatile boolean a;
  volatile boolean b;
  private final Context c;
  private String d;
  private ConsentDialogListener e;
  private final Handler f;

  ConsentDialogController(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    this.c = paramContext.getApplicationContext();
    this.f = new Handler();
  }

  private void c()
  {
    this.b = false;
    this.a = false;
    this.e = null;
    this.d = null;
  }

  void a(final ConsentDialogListener paramConsentDialogListener, Boolean paramBoolean, c paramc)
  {
    while (true)
    {
      try
      {
        Preconditions.checkNotNull(paramc);
        if (this.a)
        {
          if (paramConsentDialogListener != null)
            this.f.post(new Runnable()
            {
              public void run()
              {
                MoPubLog.log(MoPubLog.ConsentLogEvent.LOAD_SUCCESS, new Object[0]);
                paramConsentDialogListener.onConsentDialogLoaded();
              }
            });
          return;
        }
        if (this.b)
        {
          MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Already making a consent dialog load request." });
          continue;
        }
      }
      finally
      {
      }
      this.e = paramConsentDialogListener;
      this.b = true;
      ConsentDialogRequest localConsentDialogRequest = new ConsentDialogRequest(this.c, new ConsentDialogUrlGenerator(this.c, paramc.b(), paramc.c().getValue()).a(paramBoolean).b(paramc.getConsentedPrivacyPolicyVersion()).a(paramc.getConsentedVendorListVersion()).a(paramc.isForceGdprApplies()).generateUrlString(Constants.HOST), this);
      Networking.getRequestQueue(this.c).add(localConsentDialogRequest);
    }
  }

  boolean a()
  {
    MoPubLog.log(MoPubLog.ConsentLogEvent.SHOW_ATTEMPTED, new Object[0]);
    if ((!this.a) || (TextUtils.isEmpty(this.d)))
    {
      MoPubLog.ConsentLogEvent localConsentLogEvent = MoPubLog.ConsentLogEvent.SHOW_FAILED;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(MoPubErrorCode.INTERNAL_ERROR.getIntCode());
      arrayOfObject[1] = MoPubErrorCode.INTERNAL_ERROR;
      MoPubLog.log(localConsentLogEvent, arrayOfObject);
      return false;
    }
    this.a = false;
    ConsentDialogActivity.a(this.c, this.d);
    c();
    return true;
  }

  boolean b()
  {
    return this.a;
  }

  public void onErrorResponse(VolleyError paramVolleyError)
  {
    ConsentDialogListener localConsentDialogListener = this.e;
    c();
    if (localConsentDialogListener == null)
      return;
    if ((paramVolleyError instanceof MoPubNetworkError));
    switch (2.a[((MoPubNetworkError)paramVolleyError).getReason().ordinal()])
    {
    default:
      MoPubLog.ConsentLogEvent localConsentLogEvent2 = MoPubLog.ConsentLogEvent.LOAD_FAILED;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Integer.valueOf(MoPubErrorCode.UNSPECIFIED.getIntCode());
      arrayOfObject2[1] = MoPubErrorCode.UNSPECIFIED;
      MoPubLog.log(localConsentLogEvent2, arrayOfObject2);
      localConsentDialogListener.onConsentDialogLoadFailed(MoPubErrorCode.UNSPECIFIED);
      return;
    case 1:
    }
    MoPubLog.ConsentLogEvent localConsentLogEvent1 = MoPubLog.ConsentLogEvent.LOAD_FAILED;
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Integer.valueOf(MoPubErrorCode.INTERNAL_ERROR.getIntCode());
    arrayOfObject1[1] = MoPubErrorCode.INTERNAL_ERROR;
    MoPubLog.log(localConsentLogEvent1, arrayOfObject1);
    localConsentDialogListener.onConsentDialogLoadFailed(MoPubErrorCode.INTERNAL_ERROR);
  }

  public void onSuccess(b paramb)
  {
    this.b = false;
    this.d = paramb.getHtml();
    if (TextUtils.isEmpty(this.d))
    {
      this.a = false;
      if (this.e != null)
      {
        MoPubLog.ConsentLogEvent localConsentLogEvent = MoPubLog.ConsentLogEvent.LOAD_FAILED;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(MoPubErrorCode.INTERNAL_ERROR.getIntCode());
        arrayOfObject[1] = MoPubErrorCode.INTERNAL_ERROR;
        MoPubLog.log(localConsentLogEvent, arrayOfObject);
        this.e.onConsentDialogLoadFailed(MoPubErrorCode.INTERNAL_ERROR);
      }
    }
    do
    {
      return;
      MoPubLog.log(MoPubLog.ConsentLogEvent.LOAD_SUCCESS, new Object[0]);
      this.a = true;
    }
    while (this.e == null);
    this.e.onConsentDialogLoaded();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.privacy.ConsentDialogController
 * JD-Core Version:    0.6.2
 */