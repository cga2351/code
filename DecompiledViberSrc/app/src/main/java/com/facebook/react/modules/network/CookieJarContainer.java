package com.facebook.react.modules.network;

import okhttp3.CookieJar;

public abstract interface CookieJarContainer extends CookieJar
{
  public abstract void removeCookieJar();

  public abstract void setCookieJar(CookieJar paramCookieJar);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.network.CookieJarContainer
 * JD-Core Version:    0.6.2
 */