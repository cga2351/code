package com.viber.voip.api.scheme.action;

import android.net.Uri;
import com.viber.voip.util.bz;
import com.viber.voip.util.da;

public class m
{
  private final com.viber.voip.messages.controller.manager.c a;
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private final int g;
  private final int h;
  private final com.viber.voip.messages.extensions.c i;
  private final com.viber.voip.analytics.story.e.c j;

  public m(com.viber.voip.messages.controller.manager.c paramc, Uri paramUri, com.viber.voip.messages.extensions.c paramc1, com.viber.voip.analytics.story.e.c paramc2)
  {
    this.a = paramc;
    this.b = paramUri.getQueryParameter("action");
    this.c = paramUri.getQueryParameter("type");
    this.d = paramUri.getQueryParameter("url");
    this.e = paramUri.getQueryParameter("title");
    this.f = paramUri.getQueryParameter("thumbnail");
    this.g = bz.a(paramUri.getQueryParameter("width"));
    this.h = bz.a(paramUri.getQueryParameter("height"));
    this.i = paramc1;
    this.j = paramc2;
  }

  public static m a(com.viber.voip.messages.controller.manager.c paramc, Uri paramUri, com.viber.voip.messages.extensions.c paramc1, com.viber.voip.analytics.story.e.c paramc2)
  {
    return new m(paramc, paramUri, paramc1, paramc2);
  }

  private c b()
  {
    String str = c();
    if (da.a(str))
      return c.b;
    if (da.a(this.d))
      return c.a;
    return new t(this.a, str, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
  }

  private String c()
  {
    if ("link".equalsIgnoreCase(this.c))
      return "link";
    if ("gif".equalsIgnoreCase(this.c))
      return "gif";
    if ("video".equalsIgnoreCase(this.c))
      return "video";
    return null;
  }

  public c a()
  {
    if ("save".equalsIgnoreCase(this.b))
      return b();
    return c.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.action.m
 * JD-Core Version:    0.6.2
 */