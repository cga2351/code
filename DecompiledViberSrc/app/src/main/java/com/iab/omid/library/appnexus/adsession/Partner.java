package com.iab.omid.library.appnexus.adsession;

import com.iab.omid.library.appnexus.d.e;

public class Partner
{
  private final String a;
  private final String b;

  private Partner(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }

  public static Partner createPartner(String paramString1, String paramString2)
  {
    e.a(paramString1, "Name is null or empty");
    e.a(paramString2, "Version is null or empty");
    return new Partner(paramString1, paramString2);
  }

  public String getName()
  {
    return this.a;
  }

  public String getVersion()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.adsession.Partner
 * JD-Core Version:    0.6.2
 */