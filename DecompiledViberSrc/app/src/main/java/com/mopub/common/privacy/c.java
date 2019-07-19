package com.mopub.common.privacy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Preconditions;
import com.mopub.common.SharedPreferencesHelper;
import com.mopub.common.VisibleForTesting;
import java.util.Locale;

class c
  implements ConsentData
{
  private final Context a;
  private String b;
  private ConsentStatus c;
  private ConsentStatus d;
  private String e;
  private boolean f;
  private String g;
  private String h;
  private ConsentStatus i;
  private boolean j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s;
  private String t;
  private boolean u;
  private Boolean v;

  c(Context paramContext, String paramString)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramString);
    this.a = paramContext.getApplicationContext();
    this.c = ConsentStatus.UNKNOWN;
    m();
    this.b = paramString;
  }

  private static String a(Context paramContext, String paramString)
  {
    Preconditions.checkNotNull(paramContext);
    for (String str : Locale.getISOLanguages())
      if ((str != null) && (str.equals(paramString)))
        return paramString;
    return ClientMetadata.getCurrentLanguage(paramContext);
  }

  @VisibleForTesting
  static String a(String paramString1, Context paramContext, String paramString2)
  {
    Preconditions.checkNotNull(paramContext);
    if (TextUtils.isEmpty(paramString1))
      return "";
    return paramString1.replaceAll("%%LANGUAGE%%", a(paramContext, paramString2));
  }

  private void m()
  {
    SharedPreferences localSharedPreferences = SharedPreferencesHelper.getSharedPreferences(this.a, "com.mopub.privacy");
    this.b = localSharedPreferences.getString("info/adunit", "");
    this.c = ConsentStatus.fromString(localSharedPreferences.getString("info/consent_status", ConsentStatus.UNKNOWN.name()));
    String str1 = localSharedPreferences.getString("info/last_successfully_synced_consent_status", null);
    String str2;
    if (TextUtils.isEmpty(str1))
    {
      this.d = null;
      this.j = localSharedPreferences.getBoolean("info/is_whitelisted", false);
      this.k = localSharedPreferences.getString("info/current_vendor_list_version", null);
      this.l = localSharedPreferences.getString("info/current_vendor_list_link", null);
      this.m = localSharedPreferences.getString("info/current_privacy_policy_version", null);
      this.n = localSharedPreferences.getString("info/current_privacy_policy_link", null);
      this.o = localSharedPreferences.getString("info/current_vendor_list_iab_format", null);
      this.p = localSharedPreferences.getString("info/current_vendor_list_iab_hash", null);
      this.q = localSharedPreferences.getString("info/consented_vendor_list_version", null);
      this.r = localSharedPreferences.getString("info/consented_privacy_policy_version", null);
      this.s = localSharedPreferences.getString("info/consented_vendor_list_iab_format", null);
      this.t = localSharedPreferences.getString("info/extras", null);
      this.e = localSharedPreferences.getString("info/consent_change_reason", null);
      this.u = localSharedPreferences.getBoolean("info/reacquire_consent", false);
      str2 = localSharedPreferences.getString("info/gdpr_applies", null);
      if (!TextUtils.isEmpty(str2))
        break label333;
    }
    String str3;
    label333: for (this.v = null; ; this.v = Boolean.valueOf(Boolean.parseBoolean(str2)))
    {
      this.f = localSharedPreferences.getBoolean("info/force_gdpr_applies", false);
      this.g = localSharedPreferences.getString("info/udid", null);
      this.h = localSharedPreferences.getString("info/last_changed_ms", null);
      str3 = localSharedPreferences.getString("info/consent_status_before_dnt", null);
      if (!TextUtils.isEmpty(str3))
        break label347;
      this.i = null;
      return;
      this.d = ConsentStatus.fromString(str1);
      break;
    }
    label347: this.i = ConsentStatus.fromString(str3);
  }

  void a()
  {
    SharedPreferences.Editor localEditor = SharedPreferencesHelper.getSharedPreferences(this.a, "com.mopub.privacy").edit();
    localEditor.putString("info/adunit", this.b);
    localEditor.putString("info/consent_status", this.c.name());
    String str1;
    String str2;
    label244: String str3;
    if (this.d == null)
    {
      str1 = null;
      localEditor.putString("info/last_successfully_synced_consent_status", str1);
      localEditor.putBoolean("info/is_whitelisted", this.j);
      localEditor.putString("info/current_vendor_list_version", this.k);
      localEditor.putString("info/current_vendor_list_link", this.l);
      localEditor.putString("info/current_privacy_policy_version", this.m);
      localEditor.putString("info/current_privacy_policy_link", this.n);
      localEditor.putString("info/current_vendor_list_iab_format", this.o);
      localEditor.putString("info/current_vendor_list_iab_hash", this.p);
      localEditor.putString("info/consented_vendor_list_version", this.q);
      localEditor.putString("info/consented_privacy_policy_version", this.r);
      localEditor.putString("info/consented_vendor_list_iab_format", this.s);
      localEditor.putString("info/extras", this.t);
      localEditor.putString("info/consent_change_reason", this.e);
      localEditor.putBoolean("info/reacquire_consent", this.u);
      if (this.v != null)
        break label338;
      str2 = null;
      localEditor.putString("info/gdpr_applies", str2);
      localEditor.putBoolean("info/force_gdpr_applies", this.f);
      localEditor.putString("info/udid", this.g);
      localEditor.putString("info/last_changed_ms", this.h);
      ConsentStatus localConsentStatus = this.i;
      str3 = null;
      if (localConsentStatus != null)
        break label350;
    }
    while (true)
    {
      localEditor.putString("info/consent_status_before_dnt", str3);
      localEditor.apply();
      return;
      str1 = this.d.name();
      break;
      label338: str2 = this.v.toString();
      break label244;
      label350: str3 = this.i.name();
    }
  }

  void a(ConsentStatus paramConsentStatus)
  {
    this.c = paramConsentStatus;
  }

  void a(Boolean paramBoolean)
  {
    this.v = paramBoolean;
  }

  void a(String paramString)
  {
    this.k = paramString;
  }

  void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }

  String b()
  {
    return this.b;
  }

  void b(ConsentStatus paramConsentStatus)
  {
    this.d = paramConsentStatus;
  }

  void b(String paramString)
  {
    this.l = paramString;
  }

  void b(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }

  ConsentStatus c()
  {
    return this.c;
  }

  void c(ConsentStatus paramConsentStatus)
  {
    this.i = paramConsentStatus;
  }

  void c(String paramString)
  {
    this.m = paramString;
  }

  void c(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  ConsentStatus d()
  {
    return this.d;
  }

  void d(String paramString)
  {
    this.n = paramString;
  }

  void e(String paramString)
  {
    this.o = paramString;
  }

  boolean e()
  {
    return this.j;
  }

  String f()
  {
    return this.p;
  }

  void f(String paramString)
  {
    this.p = paramString;
  }

  String g()
  {
    return this.e;
  }

  void g(String paramString)
  {
    this.q = paramString;
  }

  public String getConsentedPrivacyPolicyVersion()
  {
    return this.r;
  }

  public String getConsentedVendorListIabFormat()
  {
    return this.s;
  }

  public String getConsentedVendorListVersion()
  {
    return this.q;
  }

  public String getCurrentPrivacyPolicyLink()
  {
    return getCurrentPrivacyPolicyLink(null);
  }

  public String getCurrentPrivacyPolicyLink(String paramString)
  {
    return a(this.n, this.a, paramString);
  }

  public String getCurrentPrivacyPolicyVersion()
  {
    return this.m;
  }

  public String getCurrentVendorListIabFormat()
  {
    return this.o;
  }

  public String getCurrentVendorListLink()
  {
    return getCurrentVendorListLink(null);
  }

  public String getCurrentVendorListLink(String paramString)
  {
    return a(this.l, this.a, paramString);
  }

  public String getCurrentVendorListVersion()
  {
    return this.k;
  }

  public String getExtras()
  {
    return this.t;
  }

  void h(String paramString)
  {
    this.r = paramString;
  }

  boolean h()
  {
    return this.u;
  }

  Boolean i()
  {
    return this.v;
  }

  void i(String paramString)
  {
    this.s = paramString;
  }

  public boolean isForceGdprApplies()
  {
    return this.f;
  }

  String j()
  {
    return this.g;
  }

  void j(String paramString)
  {
    this.e = paramString;
  }

  String k()
  {
    return this.h;
  }

  void k(String paramString)
  {
    this.g = paramString;
  }

  ConsentStatus l()
  {
    return this.i;
  }

  void l(String paramString)
  {
    this.h = paramString;
  }

  public void setExtras(String paramString)
  {
    this.t = paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.privacy.c
 * JD-Core Version:    0.6.2
 */