package com.google.a.a.c.a;

import com.google.a.a.f.z;
import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

final class e extends HttpEntityEnclosingRequestBase
{
  private final String a;

  public e(String paramString1, String paramString2)
  {
    this.a = ((String)z.a(paramString1));
    setURI(URI.create(paramString2));
  }

  public String getMethod()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.a.e
 * JD-Core Version:    0.6.2
 */