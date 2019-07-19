package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

public final class ap
{
  private boolean a;
  private final cj b;
  private final List<String> c;

  public ap(Context paramContext, List<String> paramList)
  {
    this.b = new cj(paramContext);
    this.c = paramList;
  }

  public final void a()
  {
    if ((!this.a) && (this.c != null))
    {
      this.a = true;
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.b.a(str);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ap
 * JD-Core Version:    0.6.2
 */