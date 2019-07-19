package com.iab.omid.library.appnexus.adsession;

public enum ErrorType
{
  private final String a;

  static
  {
    ErrorType[] arrayOfErrorType = new ErrorType[2];
    arrayOfErrorType[0] = GENERIC;
    arrayOfErrorType[1] = VIDEO;
  }

  private ErrorType(String paramString)
  {
    this.a = paramString;
  }

  public String toString()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.adsession.ErrorType
 * JD-Core Version:    0.6.2
 */