package com.mopub.common;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.mopub.common.privacy.ConsentData;
import com.mopub.common.privacy.ConsentStatus;
import com.mopub.common.privacy.PersonalInfoManager;
import com.mopub.common.util.DateAndTime;
import com.mopub.network.RequestRateTracker;
import com.mopub.network.RequestRateTracker.TimeRecord;

public abstract class AdUrlGenerator extends BaseUrlGenerator
{
  protected Context a;
  protected String b;
  protected String c;
  protected String d;
  protected Location e;
  private final PersonalInfoManager f;
  private final ConsentData g;

  public AdUrlGenerator(Context paramContext)
  {
    this.a = paramContext;
    this.f = MoPub.getPersonalInformationManager();
    if (this.f == null)
    {
      this.g = null;
      return;
    }
    this.g = this.f.getConsentData();
  }

  private void a(String paramString, ClientMetadata.MoPubNetworkType paramMoPubNetworkType)
  {
    b(paramString, paramMoPubNetworkType.toString());
  }

  private static int b(Location paramLocation)
  {
    Preconditions.checkNotNull(paramLocation);
    long l = paramLocation.getTime();
    return (int)(System.currentTimeMillis() - l);
  }

  private void i()
  {
    RequestRateTracker.TimeRecord localTimeRecord = RequestRateTracker.getInstance().getRecordForAdUnit(this.b);
    if ((localTimeRecord == null) || (localTimeRecord.mBlockIntervalMs < 1))
      return;
    b("backoff_ms", String.valueOf(localTimeRecord.mBlockIntervalMs));
    b("backoff_reason", localTimeRecord.mReason);
  }

  private int o(String paramString)
  {
    return Math.min(3, paramString.length());
  }

  protected void a()
  {
    b("abt", MoPub.a(this.a));
  }

  protected void a(float paramFloat)
  {
    b("sc", "" + paramFloat);
  }

  protected void a(Location paramLocation)
  {
    if (!MoPub.canCollectPersonalInformation());
    Location localLocation;
    do
    {
      do
      {
        return;
        localLocation = LocationService.getLastKnownLocation(this.a, MoPub.getLocationPrecision(), MoPub.getLocationAwareness());
        if ((localLocation != null) && ((paramLocation == null) || (localLocation.getTime() >= paramLocation.getTime())))
          paramLocation = localLocation;
      }
      while (paramLocation == null);
      b("ll", paramLocation.getLatitude() + "," + paramLocation.getLongitude());
      b("lla", String.valueOf((int)paramLocation.getAccuracy()));
      b("llf", String.valueOf(b(paramLocation)));
    }
    while (paramLocation != localLocation);
    b("llsdk", "1");
  }

  protected void a(ClientMetadata.MoPubNetworkType paramMoPubNetworkType)
  {
    a("ct", paramMoPubNetworkType);
  }

  protected void a(ClientMetadata paramClientMetadata)
  {
    a(this.b);
    b(paramClientMetadata.getSdkVersion());
    String[] arrayOfString = new String[3];
    arrayOfString[0] = paramClientMetadata.getDeviceManufacturer();
    arrayOfString[1] = paramClientMetadata.getDeviceModel();
    arrayOfString[2] = paramClientMetadata.getDeviceProduct();
    a(arrayOfString);
    k(paramClientMetadata.getAppPackageName());
    c(this.c);
    if (MoPub.canCollectPersonalInformation())
    {
      d(this.d);
      a(this.e);
    }
    e(DateAndTime.getTimeZoneOffsetString());
    f(paramClientMetadata.getOrientationString());
    a(paramClientMetadata.getDeviceDimensions());
    a(paramClientMetadata.getDensity());
    String str = paramClientMetadata.getNetworkOperatorForUrl();
    g(str);
    h(str);
    i(paramClientMetadata.getIsoCountryCode());
    j(paramClientMetadata.getNetworkOperatorName());
    a(paramClientMetadata.getActiveNetworkType());
    n(paramClientMetadata.getAppVersion());
    a();
    h();
    b();
    c();
    d();
    e();
    f();
    i();
  }

  protected void a(String paramString)
  {
    b("id", paramString);
  }

  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
      b("mr", "1");
  }

  protected void b()
  {
    if (this.f != null)
      a("gdpr_applies", this.f.gdprApplies());
  }

  protected void b(String paramString)
  {
    b("nv", paramString);
  }

  protected void c()
  {
    if (this.g != null)
      a("force_gdpr_applies", Boolean.valueOf(this.g.isForceGdprApplies()));
  }

  protected void c(String paramString)
  {
    b("q", paramString);
  }

  protected void d()
  {
    if (this.f != null)
      b("current_consent_status", this.f.getPersonalInfoConsentStatus().getValue());
  }

  protected void d(String paramString)
  {
    if (!MoPub.canCollectPersonalInformation())
      return;
    b("user_data_q", paramString);
  }

  protected void e()
  {
    if (this.g != null)
      b("consented_privacy_policy_version", this.g.getConsentedPrivacyPolicyVersion());
  }

  protected void e(String paramString)
  {
    b("z", paramString);
  }

  protected void f()
  {
    if (this.g != null)
      b("consented_vendor_list_version", this.g.getConsentedVendorListVersion());
  }

  protected void f(String paramString)
  {
    b("o", paramString);
  }

  protected void g(String paramString)
  {
    if (paramString == null);
    for (String str = ""; ; str = paramString.substring(0, o(paramString)))
    {
      b("mcc", str);
      return;
    }
  }

  protected void h(String paramString)
  {
    if (paramString == null);
    for (String str = ""; ; str = paramString.substring(o(paramString)))
    {
      b("mnc", str);
      return;
    }
  }

  protected void i(String paramString)
  {
    b("iso", paramString);
  }

  protected void j(String paramString)
  {
    b("cn", paramString);
  }

  protected void k(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      b("bundle", paramString);
  }

  protected void l(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    b("vv", paramString);
  }

  public AdUrlGenerator withAdUnitId(String paramString)
  {
    this.b = paramString;
    return this;
  }

  @Deprecated
  public AdUrlGenerator withFacebookSupported(boolean paramBoolean)
  {
    return this;
  }

  public AdUrlGenerator withKeywords(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public AdUrlGenerator withLocation(Location paramLocation)
  {
    this.e = paramLocation;
    return this;
  }

  public AdUrlGenerator withUserDataKeywords(String paramString)
  {
    this.d = paramString;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.AdUrlGenerator
 * JD-Core Version:    0.6.2
 */