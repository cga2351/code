package com.google.a.a.c.a;

import com.google.a.a.c.aa;
import java.io.IOException;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.RequestLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

final class a extends com.google.a.a.c.z
{
  private final HttpClient a;
  private final HttpRequestBase b;

  a(HttpClient paramHttpClient, HttpRequestBase paramHttpRequestBase)
  {
    this.a = paramHttpClient;
    this.b = paramHttpRequestBase;
  }

  public aa a()
    throws IOException
  {
    if (e() != null)
    {
      boolean bool = this.b instanceof HttpEntityEnclosingRequest;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.b.getRequestLine().getMethod();
      com.google.a.a.f.z.a(bool, "Apache HTTP client does not support %s requests with content.", arrayOfObject);
      d locald = new d(b(), e());
      locald.setContentEncoding(c());
      locald.setContentType(d());
      ((HttpEntityEnclosingRequest)this.b).setEntity(locald);
    }
    return new b(this.b, this.a.execute(this.b));
  }

  public void a(int paramInt1, int paramInt2)
    throws IOException
  {
    HttpParams localHttpParams = this.b.getParams();
    ConnManagerParams.setTimeout(localHttpParams, paramInt1);
    HttpConnectionParams.setConnectionTimeout(localHttpParams, paramInt1);
    HttpConnectionParams.setSoTimeout(localHttpParams, paramInt2);
  }

  public void a(String paramString1, String paramString2)
  {
    this.b.addHeader(paramString1, paramString2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.a.a
 * JD-Core Version:    0.6.2
 */