package com.google.a.a.c.b;

import com.google.a.a.c.w;
import com.google.a.a.f.z;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class e extends w
{
  private static final String[] b = { "DELETE", "GET", "HEAD", "OPTIONS", "POST", "PUT", "TRACE" };
  private final a c;
  private final SSLSocketFactory d;
  private final HostnameVerifier e;

  static
  {
    Arrays.sort(b);
  }

  public e()
  {
    this((a)null, null, null);
  }

  e(a parama, SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier)
  {
    if (parama == null)
      parama = new b();
    this.c = parama;
    this.d = paramSSLSocketFactory;
    this.e = paramHostnameVerifier;
  }

  public boolean a(String paramString)
  {
    return Arrays.binarySearch(b, paramString) >= 0;
  }

  protected c b(String paramString1, String paramString2)
    throws IOException
  {
    z.a(a(paramString1), "HTTP method %s not supported", new Object[] { paramString1 });
    URL localURL = new URL(paramString2);
    HttpURLConnection localHttpURLConnection = this.c.a(localURL);
    localHttpURLConnection.setRequestMethod(paramString1);
    if ((localHttpURLConnection instanceof HttpsURLConnection))
    {
      HttpsURLConnection localHttpsURLConnection = (HttpsURLConnection)localHttpURLConnection;
      if (this.e != null)
        localHttpsURLConnection.setHostnameVerifier(this.e);
      if (this.d != null)
        localHttpsURLConnection.setSSLSocketFactory(this.d);
    }
    return new c(localHttpURLConnection);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.b.e
 * JD-Core Version:    0.6.2
 */