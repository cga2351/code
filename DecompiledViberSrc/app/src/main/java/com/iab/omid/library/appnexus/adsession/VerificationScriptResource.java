package com.iab.omid.library.appnexus.adsession;

import com.iab.omid.library.appnexus.d.e;
import java.net.URL;

public final class VerificationScriptResource
{
  private final String a;
  private final URL b;
  private final String c;

  private VerificationScriptResource(String paramString1, URL paramURL, String paramString2)
  {
    this.a = paramString1;
    this.b = paramURL;
    this.c = paramString2;
  }

  public static VerificationScriptResource createVerificationScriptResourceWithParameters(String paramString1, URL paramURL, String paramString2)
  {
    e.a(paramString1, "VendorKey is null or empty");
    e.a(paramURL, "ResourceURL is null");
    e.a(paramString2, "VerificationParameters is null or empty");
    return new VerificationScriptResource(paramString1, paramURL, paramString2);
  }

  public static VerificationScriptResource createVerificationScriptResourceWithoutParameters(String paramString, URL paramURL)
  {
    e.a(paramString, "VendorKey is null or empty");
    e.a(paramURL, "ResourceURL is null");
    return new VerificationScriptResource(paramString, paramURL, null);
  }

  public static VerificationScriptResource createVerificationScriptResourceWithoutParameters(URL paramURL)
  {
    e.a(paramURL, "ResourceURL is null");
    return new VerificationScriptResource(null, paramURL, null);
  }

  public URL getResourceUrl()
  {
    return this.b;
  }

  public String getVendorKey()
  {
    return this.a;
  }

  public String getVerificationParameters()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.adsession.VerificationScriptResource
 * JD-Core Version:    0.6.2
 */