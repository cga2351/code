package okhttp3;

import java.util.Collections;
import java.util.List;

public abstract interface CookieJar
{
  public static final CookieJar NO_COOKIES = new CookieJar()
  {
    public List<Cookie> loadForRequest(HttpUrl paramAnonymousHttpUrl)
    {
      return Collections.emptyList();
    }

    public void saveFromResponse(HttpUrl paramAnonymousHttpUrl, List<Cookie> paramAnonymousList)
    {
    }
  };

  public abstract List<Cookie> loadForRequest(HttpUrl paramHttpUrl);

  public abstract void saveFromResponse(HttpUrl paramHttpUrl, List<Cookie> paramList);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.CookieJar
 * JD-Core Version:    0.6.2
 */