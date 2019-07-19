package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.AdRequestError;

public abstract class t
{
  public static final AdRequestError a = a(1, "Received unsupported ad type");
  public static final AdRequestError b = a(5, "android.webkit.WebView database is inoperable");
  public static final AdRequestError c = a(1, "Ad was loaded successfully, but there is not enough space to display it");
  public static final AdRequestError d = a(1, "Internal state wasn't completely configured");
  public static final AdRequestError e = a(1, "Incorrect data in server response");
  public static final AdRequestError f = a(1, "Invalid server response code");
  public static final AdRequestError g = a(1, "Ad request failed with unexpected exception");
  public static final AdRequestError h = a(1, "Service temporarily unavailable");
  public static final AdRequestError i = a(1, "Banner rendering failed with timeout");
  public static final AdRequestError j = a(4, "Ad request completed successfully, but there are no ads available");
  public static final AdRequestError k = a(3, "No connection. Please check your internet connection");
  public static final AdRequestError l = a(3, "Ad request failed with network error");
  public static final AdRequestError m = a(2, "Provided block ID doesn't exist");
  public static final AdRequestError n = a(2, "Ad request configured incorrectly");
  public static final AdRequestError o = a(2, "Invalid Block ID");
  public static final AdRequestError p = a(2, "Invalid ad size");
  public static final AdRequestError q = new AdRequestError(2, String.format("Incorrect AppMetrica Version. Minimum supported AppMetrica SDK Version is %s. Please, check your AppMetrica version.", new Object[] { "2.40" }));
  public static final AdRequestError r = a(2, String.format("Incorrect AppMetrica Integration. Minimum supported AppMetrica SDK Version is %s. Please, check your AppMetrica integration.", new Object[] { "2.40" }));
  public static final AdRequestError s = a(0, "Unknown error");

  public static AdRequestError a(int paramInt, String paramString)
  {
    return new AdRequestError(paramInt, paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.t
 * JD-Core Version:    0.6.2
 */