package com.my.target.c.a;

import android.text.TextUtils;

public class b
{
  private final String a;
  private final String b;
  private final String c;
  private final com.my.target.common.a.b d;

  private b(com.my.target.b.c.a.b paramb)
  {
    if (!TextUtils.isEmpty(paramb.p()))
    {
      this.a = paramb.p();
      if (TextUtils.isEmpty(paramb.f()))
        break label75;
      this.b = paramb.f();
      label40: if (TextUtils.isEmpty(paramb.d()))
        break label83;
    }
    label75: label83: for (this.c = paramb.d(); ; this.c = null)
    {
      this.d = paramb.l();
      return;
      this.a = null;
      break;
      this.b = null;
      break label40;
    }
  }

  static b a(com.my.target.b.c.a.b paramb)
  {
    return new b(paramb);
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public com.my.target.common.a.b d()
  {
    return this.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.c.a.b
 * JD-Core Version:    0.6.2
 */