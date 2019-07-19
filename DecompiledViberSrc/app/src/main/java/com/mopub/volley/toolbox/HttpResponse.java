package com.mopub.volley.toolbox;

import com.mopub.volley.Header;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class HttpResponse
{
  private final int a;
  private final List<Header> b;
  private final int c;
  private final InputStream d;

  public HttpResponse(int paramInt, List<Header> paramList)
  {
    this(paramInt, paramList, -1, null);
  }

  public HttpResponse(int paramInt1, List<Header> paramList, int paramInt2, InputStream paramInputStream)
  {
    this.a = paramInt1;
    this.b = paramList;
    this.c = paramInt2;
    this.d = paramInputStream;
  }

  public final InputStream getContent()
  {
    return this.d;
  }

  public final int getContentLength()
  {
    return this.c;
  }

  public final List<Header> getHeaders()
  {
    return Collections.unmodifiableList(this.b);
  }

  public final int getStatusCode()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.toolbox.HttpResponse
 * JD-Core Version:    0.6.2
 */