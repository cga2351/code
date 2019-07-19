package com.viber.voip.analytics.story.k;

import com.viber.voip.model.e;

public class d extends a
{
  private final String c;

  public d(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2);
    this.c = paramString3;
  }

  public void b()
  {
    e.a("analytics", a(), this.c);
  }

  public boolean d()
  {
    String str = e.c("analytics", a());
    return (str == null) || (!str.equals(this.c));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.k.d
 * JD-Core Version:    0.6.2
 */