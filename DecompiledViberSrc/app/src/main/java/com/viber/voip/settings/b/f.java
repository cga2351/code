package com.viber.voip.settings.b;

import com.viber.common.b.g;
import com.viber.voip.ViberApplication;
import com.viber.voip.bk;

public class f extends a
{
  private String b;

  public f(String paramString1, String paramString2)
  {
    super(paramString1);
    this.b = paramString2;
  }

  public void a(String paramString)
  {
    ViberApplication.preferences(bk.b()).b(this.a, paramString);
  }

  public String d()
  {
    return ViberApplication.preferences(bk.b()).a(this.a, this.b);
  }

  public void e()
  {
    ViberApplication.preferences(bk.b()).b(this.a, this.b);
  }

  public String f()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.b.f
 * JD-Core Version:    0.6.2
 */