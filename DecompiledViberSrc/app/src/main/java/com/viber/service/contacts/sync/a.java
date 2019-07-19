package com.viber.service.contacts.sync;

import android.content.Context;
import android.os.Handler;
import com.viber.common.b.b;
import com.viber.common.b.d;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.contacts.c.d.n;
import com.viber.voip.contacts.c.d.n.a;
import com.viber.voip.settings.d.p;
import com.viber.voip.util.ViberActionRunner.p;

public final class a
  implements n.a
{
  private static final Logger a = ViberEnv.getLogger();
  private static long b = 10000L;
  private static long c = 120000L;
  private static long d = 10000L;
  private static long e = 20000L;
  private Context f = ViberApplication.getApplication();
  private Handler g = av.a(av.e.c);
  private n h;
  private boolean i;
  private boolean j;
  private boolean k;
  private Runnable l = new Runnable()
  {
    public void run()
    {
      boolean bool1 = d.p.f.d();
      boolean bool2 = d.p.e.d();
      a.a(a.this, true);
      if (1 > d.p.k.d())
      {
        d.p.k.a(1);
        a.this.c();
      }
      do
      {
        return;
        if (a.a(a.this))
          a.this.c();
        if (bool2)
        {
          a.b(a.this);
          return;
        }
      }
      while ((!a.c(a.this)) && (!bool1));
      a.this.b();
    }
  };

  public static a a()
  {
    return a.a();
  }

  private void e()
  {
    try
    {
      if (this.i)
        ViberActionRunner.p.b(b);
      for (this.k = false; ; this.k = true)
        return;
    }
    finally
    {
    }
  }

  public void a(n paramn)
  {
    try
    {
      this.h = paramn;
      this.h.a(this);
      c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(boolean paramBoolean)
  {
    try
    {
      d.p.g.a(paramBoolean);
      c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void b()
  {
    try
    {
      d.p.f.a(true);
      if (this.i)
        ViberActionRunner.p.b(c);
      for (this.k = false; ; this.k = true)
        return;
    }
    finally
    {
    }
  }

  public void c()
  {
    try
    {
      if (this.i)
        ViberActionRunner.p.a(d);
      for (this.j = false; ; this.j = true)
        return;
    }
    finally
    {
    }
  }

  public void d()
  {
    try
    {
      ViberActionRunner.p.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onSyncStateChanged(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 4)
    {
      this.g.removeCallbacks(this.l);
      this.g.postDelayed(this.l, e);
      this.h.b(this);
    }
  }

  private static final class a
  {
    private static final a a = new a(null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.service.contacts.sync.a
 * JD-Core Version:    0.6.2
 */