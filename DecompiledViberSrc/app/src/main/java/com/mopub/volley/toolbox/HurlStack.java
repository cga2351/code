package com.mopub.volley.toolbox;

import com.mopub.volley.AuthFailureError;
import com.mopub.volley.Header;
import com.mopub.volley.Request;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class HurlStack extends BaseHttpStack
{
  private final UrlRewriter a;
  private final SSLSocketFactory b;

  public HurlStack()
  {
    this(null);
  }

  public HurlStack(UrlRewriter paramUrlRewriter)
  {
    this(paramUrlRewriter, null);
  }

  public HurlStack(UrlRewriter paramUrlRewriter, SSLSocketFactory paramSSLSocketFactory)
  {
    this.a = paramUrlRewriter;
    this.b = paramSSLSocketFactory;
  }

  private HttpURLConnection a(URL paramURL, Request<?> paramRequest)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = a(paramURL);
    int i = paramRequest.getTimeoutMs();
    localHttpURLConnection.setConnectTimeout(i);
    localHttpURLConnection.setReadTimeout(i);
    localHttpURLConnection.setUseCaches(false);
    localHttpURLConnection.setDoInput(true);
    if (("https".equals(paramURL.getProtocol())) && (this.b != null))
      ((HttpsURLConnection)localHttpURLConnection).setSSLSocketFactory(this.b);
    return localHttpURLConnection;
  }

  static List<Header> a(Map<String, List<String>> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    Iterator localIterator1 = paramMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      if (localEntry.getKey() != null)
      {
        Iterator localIterator2 = ((List)localEntry.getValue()).iterator();
        while (localIterator2.hasNext())
        {
          String str = (String)localIterator2.next();
          localArrayList.add(new Header((String)localEntry.getKey(), str));
        }
      }
    }
    return localArrayList;
  }

  static void a(HttpURLConnection paramHttpURLConnection, Request<?> paramRequest)
    throws IOException, AuthFailureError
  {
    switch (paramRequest.getMethod())
    {
    default:
      throw new IllegalStateException("Unknown method type.");
    case -1:
      byte[] arrayOfByte = paramRequest.getPostBody();
      if (arrayOfByte != null)
      {
        paramHttpURLConnection.setRequestMethod("POST");
        a(paramHttpURLConnection, paramRequest, arrayOfByte);
      }
      return;
    case 0:
      paramHttpURLConnection.setRequestMethod("GET");
      return;
    case 3:
      paramHttpURLConnection.setRequestMethod("DELETE");
      return;
    case 1:
      paramHttpURLConnection.setRequestMethod("POST");
      b(paramHttpURLConnection, paramRequest);
      return;
    case 2:
      paramHttpURLConnection.setRequestMethod("PUT");
      b(paramHttpURLConnection, paramRequest);
      return;
    case 4:
      paramHttpURLConnection.setRequestMethod("HEAD");
      return;
    case 5:
      paramHttpURLConnection.setRequestMethod("OPTIONS");
      return;
    case 6:
      paramHttpURLConnection.setRequestMethod("TRACE");
      return;
    case 7:
    }
    paramHttpURLConnection.setRequestMethod("PATCH");
    b(paramHttpURLConnection, paramRequest);
  }

  private static void a(HttpURLConnection paramHttpURLConnection, Request<?> paramRequest, byte[] paramArrayOfByte)
    throws IOException
  {
    paramHttpURLConnection.setDoOutput(true);
    if (!paramHttpURLConnection.getRequestProperties().containsKey("Content-Type"))
      paramHttpURLConnection.setRequestProperty("Content-Type", paramRequest.getBodyContentType());
    DataOutputStream localDataOutputStream = new DataOutputStream(paramHttpURLConnection.getOutputStream());
    localDataOutputStream.write(paramArrayOfByte);
    localDataOutputStream.close();
  }

  private static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 != 4) && ((100 > paramInt2) || (paramInt2 >= 200)) && (paramInt2 != 204) && (paramInt2 != 304);
  }

  private static InputStream b(HttpURLConnection paramHttpURLConnection)
  {
    try
    {
      InputStream localInputStream = paramHttpURLConnection.getInputStream();
      return localInputStream;
    }
    catch (IOException localIOException)
    {
    }
    return paramHttpURLConnection.getErrorStream();
  }

  private static void b(HttpURLConnection paramHttpURLConnection, Request<?> paramRequest)
    throws IOException, AuthFailureError
  {
    byte[] arrayOfByte = paramRequest.getBody();
    if (arrayOfByte != null)
      a(paramHttpURLConnection, paramRequest, arrayOfByte);
  }

  protected HttpURLConnection a(URL paramURL)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
    localHttpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
    return localHttpURLConnection;
  }

  public HttpResponse executeRequest(Request<?> paramRequest, Map<String, String> paramMap)
    throws IOException, AuthFailureError
  {
    String str1 = paramRequest.getUrl();
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramMap);
    localHashMap.putAll(paramRequest.getHeaders());
    String str2;
    if (this.a != null)
    {
      str2 = this.a.rewriteUrl(str1);
      if (str2 == null)
        throw new IOException("URL blocked by rewriter: " + str1);
    }
    else
    {
      str2 = str1;
    }
    HttpURLConnection localHttpURLConnection = a(new URL(str2), paramRequest);
    int i;
    try
    {
      Iterator localIterator = localHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str3 = (String)localIterator.next();
        localHttpURLConnection.setRequestProperty(str3, (String)localHashMap.get(str3));
      }
    }
    finally
    {
      i = 0;
    }
    while (true)
    {
      if (i == 0)
        localHttpURLConnection.disconnect();
      throw localObject1;
      a(localHttpURLConnection, paramRequest);
      int j = localHttpURLConnection.getResponseCode();
      if (j == -1)
        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
      if (!a(paramRequest.getMethod(), j))
      {
        HttpResponse localHttpResponse1 = new HttpResponse(j, a(localHttpURLConnection.getHeaderFields()));
        localHttpURLConnection.disconnect();
        return localHttpResponse1;
      }
      i = 1;
      try
      {
        HttpResponse localHttpResponse2 = new HttpResponse(j, a(localHttpURLConnection.getHeaderFields()), localHttpURLConnection.getContentLength(), new a(localHttpURLConnection));
        return localHttpResponse2;
      }
      finally
      {
      }
    }
  }

  public static abstract interface UrlRewriter
  {
    public abstract String rewriteUrl(String paramString);
  }

  static class a extends FilterInputStream
  {
    private final HttpURLConnection a;

    a(HttpURLConnection paramHttpURLConnection)
    {
      super();
      this.a = paramHttpURLConnection;
    }

    public void close()
      throws IOException
    {
      super.close();
      this.a.disconnect();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.toolbox.HurlStack
 * JD-Core Version:    0.6.2
 */