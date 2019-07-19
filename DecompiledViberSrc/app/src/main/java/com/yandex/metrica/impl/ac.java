package com.yandex.metrica.impl;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.yandex.metrica.impl.ob.h;
import com.yandex.metrica.impl.ob.k;
import com.yandex.metrica.impl.ob.l;
import com.yandex.metrica.impl.ob.l.a;
import com.yandex.metrica.impl.ob.p;

public final class ac
{
  private static volatile ac a;
  private static final Object b = new Object();
  private String c;

  private ac(Context paramContext)
  {
    this.c = aw.a(paramContext.getResources().getConfiguration().locale);
    h.a().a(this, p.class, l.a(new k()
    {
      public void a(p paramAnonymousp)
      {
        ac.a(ac.this, paramAnonymousp.a);
      }
    }).a());
  }

  public static ac a(Context paramContext)
  {
    if (a == null);
    synchronized (b)
    {
      if (a == null)
        a = new ac(paramContext.getApplicationContext());
      return a;
    }
  }

  public String a()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ac
 * JD-Core Version:    0.6.2
 */