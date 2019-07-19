package com.viber.voip.analytics.f;

import c.a.a.a.c;
import com.crashlytics.android.a.b;
import com.crashlytics.android.a.m;
import com.viber.voip.p;

public class a
{
  public static void a(m paramm)
  {
    paramm.a("viber_ver", p.f());
    if (c.i());
    try
    {
      b.c().a(paramm);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void a(String paramString, Exception paramException)
  {
    m localm = new m("OkHttpException");
    localm.a("where", paramString);
    localm.a("class", paramException.getClass().getName());
    localm.a("message", paramException.getMessage());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.f.a
 * JD-Core Version:    0.6.2
 */