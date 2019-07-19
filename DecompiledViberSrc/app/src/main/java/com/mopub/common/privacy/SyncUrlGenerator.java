package com.mopub.common.privacy;

import android.content.Context;
import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Preconditions;

public class SyncUrlGenerator extends BaseUrlGenerator
{
  private final Context a;
  private String b;
  private String c;
  private String d;
  private String e;
  private final String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private Boolean l;
  private boolean m;
  private Boolean n;

  public SyncUrlGenerator(Context paramContext, String paramString)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramString);
    this.a = paramContext.getApplicationContext();
    this.f = paramString;
  }

  public String generateUrlString(String paramString)
  {
    a(paramString, "/m/gdpr_sync");
    b("id", this.b);
    b("nv", "5.7.1");
    b("last_changed_ms", this.d);
    b("last_consent_status", this.e);
    b("current_consent_status", this.f);
    b("consent_change_reason", this.g);
    b("consented_vendor_list_version", this.h);
    b("consented_privacy_policy_version", this.i);
    b("cached_vendor_list_iab_hash", this.j);
    b("extras", this.k);
    b("udid", this.c);
    a("gdpr_applies", this.l);
    a("force_gdpr_applies", Boolean.valueOf(this.m));
    a("forced_gdpr_applies_changed", this.n);
    b("bundle", ClientMetadata.getInstance(this.a).getAppPackageName());
    b("dnt", "mp_tmpl_do_not_track");
    return g();
  }

  public SyncUrlGenerator withAdUnitId(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public SyncUrlGenerator withCachedVendorListIabHash(String paramString)
  {
    this.j = paramString;
    return this;
  }

  public SyncUrlGenerator withConsentChangeReason(String paramString)
  {
    this.g = paramString;
    return this;
  }

  public SyncUrlGenerator withConsentedPrivacyPolicyVersion(String paramString)
  {
    this.i = paramString;
    return this;
  }

  public SyncUrlGenerator withConsentedVendorListVersion(String paramString)
  {
    this.h = paramString;
    return this;
  }

  public SyncUrlGenerator withExtras(String paramString)
  {
    this.k = paramString;
    return this;
  }

  public SyncUrlGenerator withForceGdprApplies(boolean paramBoolean)
  {
    this.m = paramBoolean;
    return this;
  }

  public SyncUrlGenerator withForceGdprAppliesChanged(Boolean paramBoolean)
  {
    this.n = paramBoolean;
    return this;
  }

  public SyncUrlGenerator withGdprApplies(Boolean paramBoolean)
  {
    this.l = paramBoolean;
    return this;
  }

  public SyncUrlGenerator withLastChangedMs(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public SyncUrlGenerator withLastConsentStatus(ConsentStatus paramConsentStatus)
  {
    if (paramConsentStatus == null);
    for (String str = null; ; str = paramConsentStatus.getValue())
    {
      this.e = str;
      return this;
    }
  }

  public SyncUrlGenerator withUdid(String paramString)
  {
    this.c = paramString;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.privacy.SyncUrlGenerator
 * JD-Core Version:    0.6.2
 */