package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;

class c extends BaseUrlGenerator
{
  private Context a;
  private String b;
  private String c;
  private String d;
  private Boolean e;
  private boolean f;
  private boolean g;

  c(Context paramContext)
  {
    this.a = paramContext;
  }

  public String generateUrlString(String paramString)
  {
    ClientMetadata localClientMetadata = ClientMetadata.getInstance(this.a);
    a(paramString, "/m/open");
    m("6");
    n(localClientMetadata.getAppVersion());
    h();
    b("id", this.a.getPackageName());
    if (this.g)
      a("st", Boolean.valueOf(true));
    b("nv", "5.7.1");
    b("current_consent_status", this.b);
    b("consented_vendor_list_version", this.c);
    b("consented_privacy_policy_version", this.d);
    a("gdpr_applies", this.e);
    a("force_gdpr_applies", Boolean.valueOf(this.f));
    return g();
  }

  public c withConsentedPrivacyPolicyVersion(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public c withConsentedVendorListVersion(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public c withCurrentConsentStatus(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public c withForceGdprApplies(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }

  public c withGdprApplies(Boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }

  public c withSessionTracker(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.c
 * JD-Core Version:    0.6.2
 */