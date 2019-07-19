package com.google.a.a.c.b;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class b
  implements a
{
  private final Proxy a;

  public b()
  {
    this(null);
  }

  public b(Proxy paramProxy)
  {
    this.a = paramProxy;
  }

  public HttpURLConnection a(URL paramURL)
    throws IOException
  {
    if (this.a == null);
    for (URLConnection localURLConnection = paramURL.openConnection(); ; localURLConnection = paramURL.openConnection(this.a))
      return (HttpURLConnection)localURLConnection;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.b.b
 * JD-Core Version:    0.6.2
 */