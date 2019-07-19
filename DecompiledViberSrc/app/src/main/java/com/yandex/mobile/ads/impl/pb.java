package com.yandex.mobile.ads.impl;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public final class pb
  implements pa
{
  private final a a = null;
  private final SSLSocketFactory b;

  public pb()
  {
    this((byte)0);
  }

  private pb(byte paramByte)
  {
    this(null);
  }

  public pb(SSLSocketFactory paramSSLSocketFactory)
  {
    this.b = paramSSLSocketFactory;
  }

  private static HttpEntity a(HttpURLConnection paramHttpURLConnection)
  {
    BasicHttpEntity localBasicHttpEntity = new BasicHttpEntity();
    try
    {
      InputStream localInputStream2 = paramHttpURLConnection.getInputStream();
      localInputStream1 = localInputStream2;
      localBasicHttpEntity.setContent(localInputStream1);
      localBasicHttpEntity.setContentLength(paramHttpURLConnection.getContentLength());
      localBasicHttpEntity.setContentEncoding(paramHttpURLConnection.getContentEncoding());
      localBasicHttpEntity.setContentType(paramHttpURLConnection.getContentType());
      return localBasicHttpEntity;
    }
    catch (IOException localIOException)
    {
      while (true)
        InputStream localInputStream1 = paramHttpURLConnection.getErrorStream();
    }
  }

  private static void a(HttpURLConnection paramHttpURLConnection, oi<?> paramoi)
    throws IOException, oo
  {
    byte[] arrayOfByte = paramoi.c();
    if (arrayOfByte != null)
    {
      paramHttpURLConnection.setDoOutput(true);
      paramHttpURLConnection.addRequestProperty("Content-Type", oi.k());
      DataOutputStream localDataOutputStream = new DataOutputStream(paramHttpURLConnection.getOutputStream());
      localDataOutputStream.write(arrayOfByte);
      localDataOutputStream.close();
    }
  }

  public final HttpResponse a(oi<?> paramoi, Map<String, String> paramMap)
    throws IOException, oo
  {
    String str1 = paramoi.b();
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramoi.a());
    localHashMap.putAll(paramMap);
    String str2;
    if (this.a != null)
    {
      str2 = this.a.a();
      if (str2 == null)
        throw new IOException("URL blocked by rewriter: ".concat(String.valueOf(str1)));
    }
    else
    {
      str2 = str1;
    }
    URL localURL = new URL(str2);
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)localURL.openConnection();
    localHttpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
    int i = paramoi.p();
    localHttpURLConnection.setConnectTimeout(i);
    localHttpURLConnection.setReadTimeout(i);
    localHttpURLConnection.setUseCaches(false);
    localHttpURLConnection.setDoInput(true);
    if (("https".equals(localURL.getProtocol())) && (this.b != null))
      ((HttpsURLConnection)localHttpURLConnection).setSSLSocketFactory(this.b);
    Iterator localIterator1 = localHashMap.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str3 = (String)localIterator1.next();
      localHttpURLConnection.addRequestProperty(str3, (String)localHashMap.get(str3));
    }
    switch (paramoi.d())
    {
    default:
      throw new IllegalStateException("Unknown method type.");
    case 0:
      localHttpURLConnection.setRequestMethod("GET");
    case -1:
    case 3:
    case 1:
    case 2:
    case 4:
    case 5:
    case 6:
    case 7:
    }
    ProtocolVersion localProtocolVersion;
    while (true)
    {
      localProtocolVersion = new ProtocolVersion("HTTP", 1, 1);
      if (localHttpURLConnection.getResponseCode() != -1)
        break;
      throw new IOException("Could not retrieve response code from HttpUrlConnection.");
      localHttpURLConnection.setRequestMethod("DELETE");
      continue;
      localHttpURLConnection.setRequestMethod("POST");
      a(localHttpURLConnection, paramoi);
      continue;
      localHttpURLConnection.setRequestMethod("PUT");
      a(localHttpURLConnection, paramoi);
      continue;
      localHttpURLConnection.setRequestMethod("HEAD");
      continue;
      localHttpURLConnection.setRequestMethod("OPTIONS");
      continue;
      localHttpURLConnection.setRequestMethod("TRACE");
      continue;
      localHttpURLConnection.setRequestMethod("PATCH");
      a(localHttpURLConnection, paramoi);
    }
    BasicStatusLine localBasicStatusLine = new BasicStatusLine(localProtocolVersion, localHttpURLConnection.getResponseCode(), localHttpURLConnection.getResponseMessage());
    BasicHttpResponse localBasicHttpResponse = new BasicHttpResponse(localBasicStatusLine);
    int j = paramoi.d();
    int k = localBasicStatusLine.getStatusCode();
    if ((j != 4) && ((100 > k) || (k >= 200)) && (k != 204) && (k != 304));
    for (int m = 1; ; m = 0)
    {
      if (m != 0)
        localBasicHttpResponse.setEntity(a(localHttpURLConnection));
      Iterator localIterator2 = localHttpURLConnection.getHeaderFields().entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator2.next();
        if (localEntry.getKey() != null)
          localBasicHttpResponse.addHeader(new BasicHeader((String)localEntry.getKey(), (String)((List)localEntry.getValue()).get(0)));
      }
    }
    return localBasicHttpResponse;
  }

  public static abstract interface a
  {
    public abstract String a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.pb
 * JD-Core Version:    0.6.2
 */