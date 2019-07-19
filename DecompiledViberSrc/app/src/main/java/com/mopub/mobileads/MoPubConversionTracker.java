package com.mopub.mobileads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.mopub.common.Constants;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.SharedPreferencesHelper;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.privacy.ConsentData;
import com.mopub.common.privacy.ConsentStatus;
import com.mopub.common.privacy.PersonalInfoManager;
import com.mopub.network.TrackingRequest;
import com.mopub.network.TrackingRequest.Listener;
import com.mopub.volley.VolleyError;

public class MoPubConversionTracker
{
  private final Context a;
  private final String b;
  private final String c;
  private SharedPreferences d;

  public MoPubConversionTracker(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    this.a = paramContext.getApplicationContext();
    String str = this.a.getPackageName();
    this.b = (str + " wantToTrack");
    this.c = (str + " tracked");
    this.d = SharedPreferencesHelper.getSharedPreferences(this.a);
  }

  private boolean a()
  {
    return this.d.getBoolean(this.c, false);
  }

  public void reportAppOpen()
  {
    reportAppOpen(false);
  }

  public void reportAppOpen(boolean paramBoolean)
  {
    PersonalInfoManager localPersonalInfoManager = MoPub.getPersonalInformationManager();
    if (localPersonalInfoManager == null)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Cannot report app open until initialization is done" });
      return;
    }
    if ((!paramBoolean) && (a()))
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Conversion already tracked" });
      return;
    }
    if ((!paramBoolean) && (!MoPub.canCollectPersonalInformation()))
    {
      this.d.edit().putBoolean(this.b, true).apply();
      return;
    }
    ConsentData localConsentData = localPersonalInfoManager.getConsentData();
    TrackingRequest.makeTrackingHttpRequest(new c(this.a).withGdprApplies(localPersonalInfoManager.gdprApplies()).withForceGdprApplies(localConsentData.isForceGdprApplies()).withCurrentConsentStatus(localPersonalInfoManager.getPersonalInfoConsentStatus().getValue()).withConsentedPrivacyPolicyVersion(localConsentData.getConsentedPrivacyPolicyVersion()).withConsentedVendorListVersion(localConsentData.getConsentedVendorListVersion()).withSessionTracker(paramBoolean).generateUrlString(Constants.HOST), this.a, new TrackingRequest.Listener()
    {
      public void onErrorResponse(VolleyError paramAnonymousVolleyError)
      {
      }

      public void onResponse(String paramAnonymousString)
      {
        MoPubConversionTracker.c(MoPubConversionTracker.this).edit().putBoolean(MoPubConversionTracker.b(MoPubConversionTracker.this), true).putBoolean(MoPubConversionTracker.a(MoPubConversionTracker.this), false).apply();
      }
    });
  }

  public boolean shouldTrack()
  {
    PersonalInfoManager localPersonalInfoManager = MoPub.getPersonalInformationManager();
    if (localPersonalInfoManager == null);
    while ((!localPersonalInfoManager.canCollectPersonalInformation()) || (!this.d.getBoolean(this.b, false)))
      return false;
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.MoPubConversionTracker
 * JD-Core Version:    0.6.2
 */