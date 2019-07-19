package com.mopub.common.privacy;

import android.content.Context;
import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Preconditions;

public class ConsentDialogUrlGenerator extends BaseUrlGenerator
{
  private final Context a;
  private final String b;
  private final String c;
  private Boolean d;
  private boolean e;
  private String f;
  private String g;

  ConsentDialogUrlGenerator(Context paramContext, String paramString1, String paramString2)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramString1);
    Preconditions.checkNotNull(paramString2);
    this.a = paramContext.getApplicationContext();
    this.b = paramString1;
    this.c = paramString2;
  }

  protected ConsentDialogUrlGenerator a(Boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }

  protected ConsentDialogUrlGenerator a(String paramString)
  {
    this.f = paramString;
    return this;
  }

  protected ConsentDialogUrlGenerator a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }

  protected ConsentDialogUrlGenerator b(String paramString)
  {
    this.g = paramString;
    return this;
  }

  public String generateUrlString(String paramString)
  {
    a(paramString, "/m/gdpr_consent_dialog");
    b("id", this.b);
    b("current_consent_status", this.c);
    b("nv", "5.7.1");
    b("language", ClientMetadata.getCurrentLanguage(this.a));
    a("gdpr_applies", this.d);
    a("force_gdpr_applies", Boolean.valueOf(this.e));
    b("consented_vendor_list_version", this.f);
    b("consented_privacy_policy_version", this.g);
    b("bundle", ClientMetadata.getInstance(this.a).getAppPackageName());
    return g();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.privacy.ConsentDialogUrlGenerator
 * JD-Core Version:    0.6.2
 */