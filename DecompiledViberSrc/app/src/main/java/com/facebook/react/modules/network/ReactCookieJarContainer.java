package com.facebook.react.modules.network;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;

public class ReactCookieJarContainer
  implements CookieJarContainer
{

  @Nullable
  private CookieJar cookieJar = null;

  public List<Cookie> loadForRequest(HttpUrl paramHttpUrl)
  {
    if (this.cookieJar != null)
    {
      List localList = this.cookieJar.loadForRequest(paramHttpUrl);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Cookie localCookie = (Cookie)localIterator.next();
        try
        {
          new Headers.Builder().add(localCookie.name(), localCookie.value());
          localArrayList.add(localCookie);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
        }
      }
      return localArrayList;
    }
    return Collections.emptyList();
  }

  public void removeCookieJar()
  {
    this.cookieJar = null;
  }

  public void saveFromResponse(HttpUrl paramHttpUrl, List<Cookie> paramList)
  {
    if (this.cookieJar != null)
      this.cookieJar.saveFromResponse(paramHttpUrl, paramList);
  }

  public void setCookieJar(CookieJar paramCookieJar)
  {
    this.cookieJar = paramCookieJar;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.network.ReactCookieJarContainer
 * JD-Core Version:    0.6.2
 */