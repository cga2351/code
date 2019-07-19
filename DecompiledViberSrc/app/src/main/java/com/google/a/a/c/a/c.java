package com.google.a.a.c.a;

import com.google.a.a.c.w;
import java.net.ProxySelector;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.ProxySelectorRoutePlanner;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public final class c extends w
{
  private final HttpClient b;

  public c()
  {
    this(c());
  }

  public c(HttpClient paramHttpClient)
  {
    this.b = paramHttpClient;
    HttpParams localHttpParams = paramHttpClient.getParams();
    HttpProtocolParams.setVersion(localHttpParams, HttpVersion.HTTP_1_1);
    localHttpParams.setBooleanParameter("http.protocol.handle-redirects", false);
  }

  static DefaultHttpClient a(SSLSocketFactory paramSSLSocketFactory, HttpParams paramHttpParams, ProxySelector paramProxySelector)
  {
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    localSchemeRegistry.register(new Scheme("https", paramSSLSocketFactory, 443));
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(paramHttpParams, localSchemeRegistry), paramHttpParams);
    localDefaultHttpClient.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
    if (paramProxySelector != null)
      localDefaultHttpClient.setRoutePlanner(new ProxySelectorRoutePlanner(localSchemeRegistry, paramProxySelector));
    return localDefaultHttpClient;
  }

  public static DefaultHttpClient c()
  {
    return a(SSLSocketFactory.getSocketFactory(), d(), ProxySelector.getDefault());
  }

  static HttpParams d()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, false);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 200);
    ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(20));
    return localBasicHttpParams;
  }

  public boolean a(String paramString)
  {
    return true;
  }

  protected a b(String paramString1, String paramString2)
  {
    Object localObject;
    if (paramString1.equals("DELETE"))
      localObject = new HttpDelete(paramString2);
    while (true)
    {
      return new a(this.b, (HttpRequestBase)localObject);
      if (paramString1.equals("GET"))
        localObject = new HttpGet(paramString2);
      else if (paramString1.equals("HEAD"))
        localObject = new HttpHead(paramString2);
      else if (paramString1.equals("POST"))
        localObject = new HttpPost(paramString2);
      else if (paramString1.equals("PUT"))
        localObject = new HttpPut(paramString2);
      else if (paramString1.equals("TRACE"))
        localObject = new HttpTrace(paramString2);
      else if (paramString1.equals("OPTIONS"))
        localObject = new HttpOptions(paramString2);
      else
        localObject = new e(paramString1, paramString2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.a.c
 * JD-Core Version:    0.6.2
 */