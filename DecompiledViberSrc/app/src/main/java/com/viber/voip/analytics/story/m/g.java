package com.viber.voip.analytics.story.m;

import com.viber.voip.util.da;

public class g
  implements e
{
  private final com.viber.voip.analytics.g a;

  public g(com.viber.voip.analytics.g paramg)
  {
    this.a = paramg;
  }

  public void a()
  {
    this.a.a(b.a());
  }

  public void a(double paramDouble)
  {
    this.a.a(b.a(paramDouble));
  }

  public void a(String paramString)
  {
    com.viber.voip.analytics.g localg = this.a;
    if (da.a(paramString))
      paramString = "Value Changed Unavailable";
    localg.a(b.b(paramString, "Value Changed Unavailable"));
  }

  public void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.a.a(b.a(paramString1, paramString2, paramInt));
    this.a.a(a.a(paramString3, paramString2));
  }

  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.a.a(b.a(paramString1, paramString2));
    this.a.a(a.a(paramString3));
  }

  public void b()
  {
    this.a.a(b.b());
  }

  public void b(String paramString)
  {
    this.a.a(b.a(paramString));
  }

  public void b(String paramString1, String paramString2, String paramString3)
  {
    this.a.a(b.a(paramString1, paramString2, paramString3));
  }

  public void c()
  {
    this.a.a(b.c());
  }

  public void c(String paramString)
  {
    this.a.a(b.b(paramString));
  }

  public void d(String paramString)
  {
    this.a.a(b.c(paramString));
  }

  public void e(String paramString)
  {
    this.a.a(b.d(paramString));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.m.g
 * JD-Core Version:    0.6.2
 */