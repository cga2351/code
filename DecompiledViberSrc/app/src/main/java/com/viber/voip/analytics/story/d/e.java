package com.viber.voip.analytics.story.d;

import com.viber.voip.analytics.g;

public class e
  implements c
{
  private final g a;

  public e(g paramg)
  {
    this.a = paramg;
  }

  public void a()
  {
    this.a.a(b.c());
  }

  public void a(double paramDouble, String paramString)
  {
    this.a.a(b.b(paramString));
    this.a.a(a.a(paramDouble, true));
  }

  public void a(String paramString)
  {
    this.a.a(b.a(paramString));
  }

  public void a(String paramString1, String paramString2)
  {
    this.a.a(b.a(paramString1, paramString2));
  }

  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.a.a(b.b(paramString1, paramString2));
    this.a.a(a.c(paramString3));
  }

  public void b(double paramDouble, String paramString)
  {
    this.a.a(b.c(paramString));
    this.a.a(a.a(paramDouble, false));
  }

  public void b(String paramString)
  {
    this.a.a(b.a());
    this.a.a(a.a(paramString));
  }

  public void c(String paramString)
  {
    this.a.a(b.b());
    this.a.a(a.b(paramString));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.d.e
 * JD-Core Version:    0.6.2
 */