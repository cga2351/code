package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.CounterConfiguration.a;
import com.yandex.metrica.impl.b.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class aa
{
  private final ab a;
  private final jf b;
  private List<f> c;

  aa(ab paramab, jf paramjf)
  {
    this.a = paramab;
    this.b = paramjf;
    this.c = new LinkedList();
    this.c.add(new b(this.a, this.b));
    this.c.add(new d(this.a, this.b));
    this.c.add(new c(this.a, this.a.C()));
    this.c.add(new a(this.a));
    this.c.add(new e(this.a));
  }

  void a()
  {
    String str = this.a.b().a();
    if (!jf.a.values().contains(str))
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
        ((f)localIterator.next()).f();
    }
  }

  static class a extends aa.f
  {
    private final jj a;
    private final fw b;

    a(ab paramab)
    {
      super();
      this.a = new jj(paramab.c(), paramab.b().toString());
      this.b = paramab.D();
    }

    protected boolean a()
    {
      return this.a.e();
    }

    protected void b()
    {
      d();
      c();
      b.a locala = this.a.a();
      if (locala != null)
        this.b.a(locala);
      String str = this.a.a(null);
      if ((!TextUtils.isEmpty(str)) && (TextUtils.isEmpty(this.b.a(null))))
        this.b.b(str);
      CounterConfiguration.a locala1 = this.a.b();
      CounterConfiguration.a locala2 = this.b.c();
      if ((locala1 != CounterConfiguration.a.a) && (locala2 == CounterConfiguration.a.a))
        this.b.a(locala1);
      long l = this.a.c(-9223372036854775808L);
      if ((l != -9223372036854775808L) && (this.b.a(-9223372036854775808L) == -9223372036854775808L))
        this.b.c(l);
      this.b.i();
      this.a.g();
    }

    void c()
    {
      ej localej = new ej(this.b, "foreground");
      if (!localej.i())
      {
        long l1 = this.a.d(-1L);
        if (-1L != l1)
          localej.d(l1);
        boolean bool = this.a.a(true).booleanValue();
        if (bool)
          localej.a(bool);
        long l2 = this.a.a(-9223372036854775808L);
        if (l2 != -9223372036854775808L)
          localej.e(l2);
        long l3 = this.a.f(0L);
        if (l3 != 0L)
          localej.a(l3);
        long l4 = this.a.h(0L);
        if (l4 != 0L)
          localej.b(l4);
        localej.h();
      }
    }

    void d()
    {
      ej localej = new ej(this.b, "background");
      if (!localej.i())
      {
        long l1 = this.a.e(-1L);
        if (l1 != -1L)
          localej.d(l1);
        long l2 = this.a.b(-9223372036854775808L);
        if (l2 != -9223372036854775808L)
          localej.e(l2);
        long l3 = this.a.g(0L);
        if (l3 != 0L)
          localej.a(l3);
        long l4 = this.a.i(0L);
        if (l4 != 0L)
          localej.b(l4);
        localej.h();
      }
    }
  }

  static class b extends aa.g
  {
    b(ab paramab, jf paramjf)
    {
      super(paramjf);
    }

    protected boolean a()
    {
      return e() instanceof al;
    }

    protected void b()
    {
      c().a();
    }
  }

  static class c extends aa.f
  {
    private final jg a;
    private final fu b;

    c(ab paramab, jg paramjg)
    {
      super();
      this.a = paramjg;
      this.b = paramab.B();
    }

    protected boolean a()
    {
      return ("DONE".equals(this.a.c(null))) || ("DONE".equals(this.a.b(null)));
    }

    protected void b()
    {
      if ("DONE".equals(this.a.c(null)))
        this.b.b();
      String str = this.a.e(null);
      if (!TextUtils.isEmpty(str))
        this.b.c(str);
      if ("DONE".equals(this.a.b(null)))
        this.b.a();
      this.a.d();
      this.a.e();
      this.a.c();
    }
  }

  static class d extends aa.g
  {
    d(ab paramab, jf paramjf)
    {
      super(paramjf);
    }

    protected boolean a()
    {
      return e().B().a(null) == null;
    }

    protected void b()
    {
      jf localjf = c();
      if ((e() instanceof al))
      {
        localjf.c();
        return;
      }
      localjf.b();
    }
  }

  static class e extends aa.f
  {

    @Deprecated
    static final jo a = new jo("SESSION_SLEEP_START");

    @Deprecated
    static final jo b = new jo("SESSION_ID");

    @Deprecated
    static final jo c = new jo("SESSION_COUNTER_ID");

    @Deprecated
    static final jo d = new jo("SESSION_INIT_TIME");

    @Deprecated
    static final jo e = new jo("SESSION_IS_ALIVE_REPORT_NEEDED");

    @Deprecated
    static final jo f = new jo("BG_SESSION_ID");

    @Deprecated
    static final jo g = new jo("BG_SESSION_SLEEP_START");

    @Deprecated
    static final jo h = new jo("BG_SESSION_COUNTER_ID");

    @Deprecated
    static final jo i = new jo("BG_SESSION_INIT_TIME");

    @Deprecated
    static final jo j = new jo("BG_SESSION_IS_ALIVE_REPORT_NEEDED");
    private final fw k;

    e(ab paramab)
    {
      super();
      this.k = paramab.D();
    }

    protected boolean a()
    {
      return true;
    }

    protected void b()
    {
      d();
      c();
      this.k.p(a.b());
      this.k.p(b.b());
      this.k.p(c.b());
      this.k.p(d.b());
      this.k.p(e.b());
      this.k.p(f.b());
      this.k.p(g.b());
      this.k.p(h.b());
      this.k.p(i.b());
      this.k.p(j.b());
    }

    void c()
    {
      long l1 = this.k.b(a.b(), -2147483648L);
      if (l1 != -2147483648L)
      {
        ej localej = new ej(this.k, "foreground");
        if (!localej.i())
        {
          if (l1 != 0L)
            localej.b(l1);
          long l2 = this.k.b(b.b(), -1L);
          if (-1L != l2)
            localej.d(l2);
          boolean bool = this.k.b(e.b(), true);
          if (bool)
            localej.a(bool);
          long l3 = this.k.b(d.b(), -9223372036854775808L);
          if (l3 != -9223372036854775808L)
            localej.e(l3);
          long l4 = this.k.b(c.b(), 0L);
          if (l4 != 0L)
            localej.a(l4);
          localej.h();
        }
      }
    }

    void d()
    {
      long l1 = this.k.b(g.b(), -2147483648L);
      if (l1 != -2147483648L)
      {
        ej localej = new ej(this.k, "background");
        if (!localej.i())
        {
          if (l1 != 0L)
            localej.b(l1);
          long l2 = this.k.b(f.b(), -1L);
          if (l2 != -1L)
            localej.d(l2);
          boolean bool = this.k.b(j.b(), true);
          if (bool)
            localej.a(bool);
          long l3 = this.k.b(i.b(), -9223372036854775808L);
          if (l3 != -9223372036854775808L)
            localej.e(l3);
          long l4 = this.k.b(h.b(), 0L);
          if (l4 != 0L)
            localej.a(l4);
          localej.h();
        }
      }
    }
  }

  private static abstract class f
  {
    private final ab a;

    f(ab paramab)
    {
      this.a = paramab;
    }

    protected abstract boolean a();

    protected abstract void b();

    ab e()
    {
      return this.a;
    }

    void f()
    {
      if (a())
        b();
    }
  }

  private static abstract class g extends aa.f
  {
    private jf a;

    g(ab paramab, jf paramjf)
    {
      super();
      this.a = paramjf;
    }

    public jf c()
    {
      return this.a;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.aa
 * JD-Core Version:    0.6.2
 */