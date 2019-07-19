package com.yandex.mobile.ads;

import java.util.Locale;

public final class AdRequestError
{
  private final int a;
  private final String b;

  public AdRequestError(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }

  public final int getCode()
  {
    return this.a;
  }

  public final String getDescription()
  {
    return this.b;
  }

  public final String toString()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.a);
    arrayOfObject[1] = this.b;
    return String.format(localLocale, "AdRequestError (code: %d, description: %s)", arrayOfObject);
  }

  public static final class Code
  {
    public static final int INTERNAL_ERROR = 1;
    public static final int INVALID_REQUEST = 2;
    public static final int NETWORK_ERROR = 3;
    public static final int NO_FILL = 4;
    public static final int SYSTEM_ERROR = 5;
    public static final int UNKNOWN_ERROR;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.AdRequestError
 * JD-Core Version:    0.6.2
 */