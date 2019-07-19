package com.iab.omid.library.appnexus.adsession;

public enum AdSessionContextType
{
  private final String a;

  static
  {
    AdSessionContextType[] arrayOfAdSessionContextType = new AdSessionContextType[2];
    arrayOfAdSessionContextType[0] = HTML;
    arrayOfAdSessionContextType[1] = NATIVE;
  }

  private AdSessionContextType(String paramString)
  {
    this.a = paramString;
  }

  public String toString()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.adsession.AdSessionContextType
 * JD-Core Version:    0.6.2
 */