package com.viber.voip.analytics.story.k;

import com.viber.voip.model.e;

public class c extends a
{
  private final int c;

  public c(String paramString1, String paramString2, int paramInt)
  {
    super(paramString1, paramString2);
    this.c = paramInt;
  }

  public void b()
  {
    e.a("analytics", a(), this.c);
  }

  public boolean d()
  {
    Integer localInteger = e.a("analytics", a());
    return (localInteger == null) || (localInteger.intValue() != this.c);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.k.c
 * JD-Core Version:    0.6.2
 */