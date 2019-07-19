package okhttp3;

import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import okhttp3.internal.URLFilter;
import okhttp3.internal.huc.OkHttpURLConnection;
import okhttp3.internal.huc.OkHttpsURLConnection;

public final class OkUrlFactory
  implements Cloneable, URLStreamHandlerFactory
{
  private OkHttpClient client;
  private URLFilter urlFilter;

  public OkUrlFactory(OkHttpClient paramOkHttpClient)
  {
    this.client = paramOkHttpClient;
  }

  public OkHttpClient client()
  {
    return this.client;
  }

  public OkUrlFactory clone()
  {
    return new OkUrlFactory(this.client);
  }

  public URLStreamHandler createURLStreamHandler(final String paramString)
  {
    if ((!paramString.equals("http")) && (!paramString.equals("https")))
      return null;
    return new URLStreamHandler()
    {
      protected int getDefaultPort()
      {
        if (paramString.equals("http"))
          return 80;
        if (paramString.equals("https"))
          return 443;
        throw new AssertionError();
      }

      protected URLConnection openConnection(URL paramAnonymousURL)
      {
        return OkUrlFactory.this.open(paramAnonymousURL);
      }

      protected URLConnection openConnection(URL paramAnonymousURL, Proxy paramAnonymousProxy)
      {
        return OkUrlFactory.this.open(paramAnonymousURL, paramAnonymousProxy);
      }
    };
  }

  public HttpURLConnection open(URL paramURL)
  {
    return open(paramURL, this.client.proxy());
  }

  HttpURLConnection open(URL paramURL, Proxy paramProxy)
  {
    String str = paramURL.getProtocol();
    OkHttpClient localOkHttpClient = this.client.newBuilder().proxy(paramProxy).build();
    if (str.equals("http"))
      return new OkHttpURLConnection(paramURL, localOkHttpClient, this.urlFilter);
    if (str.equals("https"))
      return new OkHttpsURLConnection(paramURL, localOkHttpClient, this.urlFilter);
    throw new IllegalArgumentException("Unexpected protocol: " + str);
  }

  public OkUrlFactory setClient(OkHttpClient paramOkHttpClient)
  {
    this.client = paramOkHttpClient;
    return this;
  }

  void setUrlFilter(URLFilter paramURLFilter)
  {
    this.urlFilter = paramURLFilter;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.OkUrlFactory
 * JD-Core Version:    0.6.2
 */