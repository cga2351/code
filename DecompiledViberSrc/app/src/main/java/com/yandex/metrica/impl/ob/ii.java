package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.yandex.metrica.impl.a;
import com.yandex.metrica.impl.a.a;
import com.yandex.metrica.impl.au;
import com.yandex.metrica.impl.v;

class ii
{
  private final Context a;
  private mw b;
  private hp c;
  private final au d;
  private final fm e;
  private final fl f;
  private final on g;
  private final id h;
  private final a i;
  private final a.a j;
  private final im k;
  private final Looper l;
  private boolean m = false;

  ii(Context paramContext, mw parammw, hp paramhp, au paramau, fm paramfm, fl paramfl, Looper paramLooper, on paramon, id paramid, a parama, im paramim)
  {
    this.a = paramContext;
    this.c = paramhp;
    this.b = parammw;
    this.d = paramau;
    this.e = paramfm;
    this.f = paramfl;
    this.l = paramLooper;
    this.g = paramon;
    this.h = paramid;
    this.i = parama;
    this.j = new a.a()
    {
      public void a()
      {
        ii.a(ii.this, true);
        ii.a(ii.this);
      }
    };
    this.k = paramim;
  }

  public ii(Context paramContext, mw parammw, hp paramhp, fm paramfm, fl paramfl, Looper paramLooper)
  {
    this(paramContext, parammw, paramhp, new au(), paramfm, paramfl, paramLooper, new om(), new id(), v.a().h(), new im(paramContext));
  }

  private boolean a(fd paramfd)
  {
    return (this.c != null) && ((b(paramfd)) || (c(paramfd)));
  }

  private static boolean a(fd paramfd, long paramLong)
  {
    return paramfd.a() >= paramLong;
  }

  private void b()
  {
    hz localhz;
    lx locallx;
    boolean bool;
    if (this.c != null)
    {
      localhz = this.h.a(this.a, this.b, this.c);
      locallx = localhz.d();
      bool = true;
    }
    while (true)
    {
      if (this.k.a())
      {
        bool = localhz.b();
        if (bool)
        {
          if (localhz.e().b())
            while ((!Thread.currentThread().isInterrupted()) && (bool))
            {
              this.d.a(localhz);
              if ((!localhz.c()) && (localhz.w()))
                bool = true;
              else
                bool = false;
            }
        }
        else
          localhz.H();
      }
      while ((!bool) || (!locallx.b()))
      {
        return;
        locallx.c();
      }
    }
  }

  private boolean b(fd paramfd)
  {
    return (this.c != null) && (a(paramfd, this.c.g));
  }

  private boolean b(fd paramfd, long paramLong)
  {
    return this.g.a() - paramfd.b() > paramLong;
  }

  private boolean c(fd paramfd)
  {
    return (this.c != null) && (b(paramfd, this.c.i));
  }

  public void a()
  {
    boolean bool1 = a(this.e);
    boolean bool2 = a(this.f);
    if ((bool1) || (bool2));
    for (int n = 1; ; n = 0)
    {
      if (n != 0)
      {
        if (this.m)
          break;
        this.i.a(a.a, new Handler(this.l), this.j);
      }
      return;
    }
    b();
  }

  public void a(mw parammw, hp paramhp)
  {
    this.b = parammw;
    this.c = paramhp;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ii
 * JD-Core Version:    0.6.2
 */