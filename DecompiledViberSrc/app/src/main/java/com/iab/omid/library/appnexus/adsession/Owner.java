package com.iab.omid.library.appnexus.adsession;

public enum Owner
{
  private final String a;

  static
  {
    JAVASCRIPT = new Owner("JAVASCRIPT", 1, "javascript");
    NONE = new Owner("NONE", 2, "none");
    Owner[] arrayOfOwner = new Owner[3];
    arrayOfOwner[0] = NATIVE;
    arrayOfOwner[1] = JAVASCRIPT;
    arrayOfOwner[2] = NONE;
  }

  private Owner(String paramString)
  {
    this.a = paramString;
  }

  public String toString()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.adsession.Owner
 * JD-Core Version:    0.6.2
 */