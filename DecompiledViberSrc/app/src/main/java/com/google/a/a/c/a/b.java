package com.google.a.a.c.a;

import com.google.a.a.c.aa;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpRequestBase;

final class b extends aa
{
  private final HttpRequestBase a;
  private final HttpResponse b;
  private final Header[] c;

  b(HttpRequestBase paramHttpRequestBase, HttpResponse paramHttpResponse)
  {
    this.a = paramHttpRequestBase;
    this.b = paramHttpResponse;
    this.c = paramHttpResponse.getAllHeaders();
  }

  public InputStream a()
    throws IOException
  {
    HttpEntity localHttpEntity = this.b.getEntity();
    if (localHttpEntity == null)
      return null;
    return localHttpEntity.getContent();
  }

  public String a(int paramInt)
  {
    return this.c[paramInt].getName();
  }

  public String b()
  {
    HttpEntity localHttpEntity = this.b.getEntity();
    if (localHttpEntity != null)
    {
      Header localHeader = localHttpEntity.getContentEncoding();
      if (localHeader != null)
        return localHeader.getValue();
    }
    return null;
  }

  public String b(int paramInt)
  {
    return this.c[paramInt].getValue();
  }

  public String c()
  {
    HttpEntity localHttpEntity = this.b.getEntity();
    if (localHttpEntity != null)
    {
      Header localHeader = localHttpEntity.getContentType();
      if (localHeader != null)
        return localHeader.getValue();
    }
    return null;
  }

  public String d()
  {
    StatusLine localStatusLine = this.b.getStatusLine();
    if (localStatusLine == null)
      return null;
    return localStatusLine.toString();
  }

  public int e()
  {
    StatusLine localStatusLine = this.b.getStatusLine();
    if (localStatusLine == null)
      return 0;
    return localStatusLine.getStatusCode();
  }

  public String f()
  {
    StatusLine localStatusLine = this.b.getStatusLine();
    if (localStatusLine == null)
      return null;
    return localStatusLine.getReasonPhrase();
  }

  public int g()
  {
    return this.c.length;
  }

  public void h()
  {
    this.a.abort();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.a.b
 * JD-Core Version:    0.6.2
 */