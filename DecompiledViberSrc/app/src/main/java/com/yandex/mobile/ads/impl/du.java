package com.yandex.mobile.ads.impl;

import java.util.Map;

public final class du
{
  private final ds a;
  private final he b;

  public du(ds paramds)
  {
    this.a = paramds;
    this.b = new he();
  }

  public final void a(final Map<String, String> paramMap)
  {
    this.b.a(new Runnable()
    {
      public final void run()
      {
        du.a(du.this).setVisibility(0);
        du.a(du.this, paramMap);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.du
 * JD-Core Version:    0.6.2
 */