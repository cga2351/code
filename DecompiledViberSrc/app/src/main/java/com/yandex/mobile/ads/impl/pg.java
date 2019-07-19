package com.yandex.mobile.ads.impl;

import java.io.UnsupportedEncodingException;

public final class pg extends oi<String>
{
  private final ok.b<String> a;

  public pg(String paramString, ok.b<String> paramb, ok.a parama)
  {
    super(0, paramString, parama);
    this.a = paramb;
  }

  protected final ok<String> a(oh paramoh)
  {
    try
    {
      str = new String(paramoh.b, oz.a(paramoh.c));
      return ok.a(str, oz.a(paramoh));
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        String str = new String(paramoh.b);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.pg
 * JD-Core Version:    0.6.2
 */