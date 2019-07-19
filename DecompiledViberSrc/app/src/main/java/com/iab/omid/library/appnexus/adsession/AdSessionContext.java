package com.iab.omid.library.appnexus.adsession;

import android.webkit.WebView;
import com.iab.omid.library.appnexus.d.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AdSessionContext
{
  private final Partner a;
  private final WebView b;
  private final List<VerificationScriptResource> c = new ArrayList();
  private final String d;
  private final String e;
  private final AdSessionContextType f;

  private AdSessionContext(Partner paramPartner, WebView paramWebView, String paramString1, List<VerificationScriptResource> paramList, String paramString2)
  {
    this.a = paramPartner;
    this.b = paramWebView;
    this.d = paramString1;
    if (paramList != null)
      this.c.addAll(paramList);
    for (this.f = AdSessionContextType.NATIVE; ; this.f = AdSessionContextType.HTML)
    {
      this.e = paramString2;
      return;
    }
  }

  public static AdSessionContext createHtmlAdSessionContext(Partner paramPartner, WebView paramWebView, String paramString)
  {
    e.a(paramPartner, "Partner is null");
    e.a(paramWebView, "WebView is null");
    if (paramString != null)
      e.a(paramString, 256, "CustomReferenceData is greater than 256 characters");
    return new AdSessionContext(paramPartner, paramWebView, null, null, paramString);
  }

  public static AdSessionContext createNativeAdSessionContext(Partner paramPartner, String paramString1, List<VerificationScriptResource> paramList, String paramString2)
  {
    e.a(paramPartner, "Partner is null");
    e.a(paramString1, "OMID JS script content is null");
    e.a(paramList, "VerificationScriptResources is null");
    if (paramString2 != null)
      e.a(paramString2, 256, "CustomReferenceData is greater than 256 characters");
    return new AdSessionContext(paramPartner, null, paramString1, paramList, paramString2);
  }

  public AdSessionContextType getAdSessionContextType()
  {
    return this.f;
  }

  public String getCustomReferenceData()
  {
    return this.e;
  }

  public String getOmidJsScriptContent()
  {
    return this.d;
  }

  public Partner getPartner()
  {
    return this.a;
  }

  public List<VerificationScriptResource> getVerificationScriptResources()
  {
    return Collections.unmodifiableList(this.c);
  }

  public WebView getWebView()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.adsession.AdSessionContext
 * JD-Core Version:    0.6.2
 */