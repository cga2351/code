package com.viber.voip.analytics.story.k;

import com.viber.voip.model.e;

public class f extends a
{
  private String c = null;

  public f(String paramString1, String paramString2, String paramString3)
  {
    super(paramString2, paramString3);
    this.c = paramString1;
  }

  public void b()
  {
    e.a("analytics", a(), this.c);
  }

  public boolean d()
  {
    String str = e.c("analytics", a());
    return (str == null) || (!this.c.equalsIgnoreCase(str));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.k.f
 * JD-Core Version:    0.6.2
 */