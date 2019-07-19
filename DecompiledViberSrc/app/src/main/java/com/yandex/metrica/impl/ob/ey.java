package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

public class ey
{
  private final Context a;
  private final ew b;
  private final ex c;
  private final a d;
  private final et e;

  ey(Context paramContext, ew paramew, ex paramex, a parama, et paramet)
  {
    this.a = paramContext;
    this.b = paramew;
    this.c = paramex;
    this.d = parama;
    this.e = paramet;
  }

  public ey(Context paramContext, ScheduledExecutorService paramScheduledExecutorService, es parames)
  {
    this(paramContext, paramScheduledExecutorService, parames, new ex(paramContext));
  }

  private ey(Context paramContext, ScheduledExecutorService paramScheduledExecutorService, es parames, ex paramex)
  {
    this(paramContext, new ew(paramScheduledExecutorService, parames), paramex, new a(), new et(paramContext));
  }

  private void a(hk paramhk)
  {
    if (paramhk != null)
    {
      boolean bool1 = paramhk.k;
      boolean bool2 = paramhk.c;
      Long localLong = this.e.a(paramhk.d);
      if ((bool1) && (localLong != null) && (localLong.longValue() > 0L))
        this.b.a(localLong.longValue(), bool2);
    }
    else
    {
      return;
    }
    this.b.a();
  }

  private static void c(ez paramez)
  {
    if (paramez != null)
      paramez.a();
  }

  public void a()
  {
    a(this.d.a(this.a));
  }

  public void a(final ez paramez)
  {
    hk localhk = this.d.a(this.a);
    if (localhk != null)
    {
      long l = localhk.a;
      if (l > 0L)
      {
        this.c.a(this.a.getPackageName());
        this.b.a(l, new ew.a()
        {
          public void a()
          {
            ey.a(ey.this).a();
            ey.b(paramez);
          }
        });
      }
    }
    while (true)
    {
      a(localhk);
      return;
      c(paramez);
      continue;
      c(paramez);
    }
  }

  public static class a
  {
    public hk a(Context paramContext)
    {
      return ((mw)hd.a.a(mw.class).a(paramContext).a()).p;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ey
 * JD-Core Version:    0.6.2
 */