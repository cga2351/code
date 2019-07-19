package com.viber.backup.a;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.p;
import com.viber.voip.registration.ao;
import com.viber.voip.registration.s;
import com.viber.voip.settings.d.x;
import com.viber.voip.util.da;
import java.io.File;

public class e
{
  private static final Logger a = ViberEnv.getLogger();
  private final g b;
  private final a c;

  public e(g paramg, a parama)
  {
    this.b = paramg;
    this.c = parama;
  }

  private File f()
  {
    return new File(p.a());
  }

  private f g()
  {
    return new f(s.a(), d.x.c.d(), f());
  }

  public void a()
  {
    if ((!ao.f()) && (!f().exists()));
    for (int i = 1; ; i = 0)
    {
      if (i != 0)
        this.b.a();
      return;
    }
  }

  public void a(String paramString)
  {
    if (!ao.f())
    {
      f localf = g();
      if (localf.a())
        this.c.a(paramString, localf);
    }
  }

  public boolean a(boolean paramBoolean)
  {
    boolean bool1 = ao.f();
    boolean bool2 = false;
    if (bool1);
    do
    {
      f localf;
      boolean bool3;
      do
      {
        return bool2;
        localf = g();
        bool3 = da.a(localf.a);
        bool2 = false;
      }
      while (bool3);
      bool2 = this.c.a(localf, paramBoolean);
    }
    while (!bool2);
    s.d();
    s.a(s.d);
    return bool2;
  }

  public void b()
  {
    if (!ao.f())
    {
      this.b.b();
      this.c.a();
    }
  }

  public void c()
  {
    if (!ao.f())
    {
      f localf = g();
      if (localf.a())
        this.c.a(localf);
    }
  }

  public void d()
  {
    if (!ao.f())
    {
      f localf = g();
      if (localf.a())
        this.c.b(localf);
    }
  }

  public void e()
  {
    s.b();
    if (!ao.f())
    {
      f localf = g();
      if (localf.a())
        this.c.c(localf);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.backup.a.e
 * JD-Core Version:    0.6.2
 */