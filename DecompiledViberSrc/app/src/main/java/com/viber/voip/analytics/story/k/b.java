package com.viber.voip.analytics.story.k;

import com.viber.voip.model.e;
import com.viber.voip.util.da;

public class b extends a
{
  private String c = null;

  public b(String paramString1, String paramString2, String paramString3)
  {
    super(paramString2, paramString3);
    this.c = paramString1;
  }

  public String a()
  {
    if (da.a(this.a))
      return this.b;
    return this.b + "_" + this.a;
  }

  public void b()
  {
    e.a("analytics", a(), "");
  }

  public boolean d()
  {
    String str = e.c("analytics", a());
    return (!da.a(str)) && (this.c.equalsIgnoreCase(str));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.k.b
 * JD-Core Version:    0.6.2
 */