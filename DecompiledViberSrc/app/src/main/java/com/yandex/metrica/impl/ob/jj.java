package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.yandex.metrica.CounterConfiguration.a;
import com.yandex.metrica.impl.b.a;

@Deprecated
public class jj extends jh
{

  @Deprecated
  public static final jo d = new jo("APP_ENVIRONMENT");

  @Deprecated
  public static final jo e = new jo("APP_ENVIRONMENT_REVISION");
  private static final jo f = new jo("SESSION_SLEEP_START_");
  private static final jo g = new jo("SESSION_ID_");
  private static final jo h = new jo("SESSION_COUNTER_ID_");
  private static final jo i = new jo("SESSION_INIT_TIME_");
  private static final jo j = new jo("SESSION_ALIVE_TIME_");
  private static final jo k = new jo("SESSION_IS_ALIVE_REPORT_NEEDED_");
  private static final jo l = new jo("BG_SESSION_ID_");
  private static final jo m = new jo("BG_SESSION_SLEEP_START_");
  private static final jo n = new jo("BG_SESSION_COUNTER_ID_");
  private static final jo o = new jo("BG_SESSION_INIT_TIME_");
  private static final jo p = new jo("COLLECT_INSTALLED_APPS_");
  private static final jo q = new jo("IDENTITY_SEND_TIME_");
  private static final jo r = new jo("USER_INFO_");
  private static final jo s = new jo("REFERRER_");
  private static final jo t = new jo("APP_ENVIRONMENT_");
  private static final jo u = new jo("APP_ENVIRONMENT_REVISION_");
  private jo A = new jo(k.a(), i());
  private jo B = new jo(l.a(), i());
  private jo C = new jo(m.a(), i());
  private jo D = new jo(n.a(), i());
  private jo E = new jo(o.a(), i());
  private jo F = new jo(q.a(), i());
  private jo G = new jo(p.a(), i());
  private jo H = new jo(r.a(), i());
  private jo I = new jo(s.a(), i());
  private jo J = new jo(t.a(), i());
  private jo K = new jo(u.a(), i());
  private jo v = new jo(f.a(), i());
  private jo w = new jo(g.a(), i());
  private jo x = new jo(h.a(), i());
  private jo y = new jo(i.a(), i());
  private jo z = new jo(j.a(), i());

  public jj(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    SharedPreferences localSharedPreferences = this.c;
    String str = this.G.b();
    if ((localSharedPreferences != null) && (localSharedPreferences.contains(str)));
    try
    {
      localSharedPreferences.getBoolean(str, false);
      localSharedPreferences.edit().remove(str).putInt(str, CounterConfiguration.a.a.d).apply();
      label412: jp.a(this.c, this.z.b(), -1);
      jp.a(this.c, this.v.b(), 0);
      jp.a(this.c, this.x.b(), 0);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      break label412;
    }
  }

  private long a(String paramString, long paramLong)
  {
    return this.c.getLong(paramString, paramLong);
  }

  public long a(long paramLong)
  {
    return a(this.y.b(), paramLong);
  }

  public b.a a()
  {
    try
    {
      if ((this.c.contains(this.J.b())) && (this.c.contains(this.K.b())))
      {
        b.a locala = new b.a(this.c.getString(this.J.b(), "{}"), this.c.getLong(this.K.b(), 0L));
        return locala;
      }
      return null;
    }
    finally
    {
    }
  }

  public jj a(b.a parama)
  {
    try
    {
      a(this.J.b(), parama.a);
      a(this.K.b(), Long.valueOf(parama.b));
      return this;
    }
    finally
    {
    }
  }

  public Boolean a(boolean paramBoolean)
  {
    return Boolean.valueOf(this.c.getBoolean(this.A.b(), paramBoolean));
  }

  public String a(String paramString)
  {
    return this.c.getString(this.H.b(), paramString);
  }

  public long b(long paramLong)
  {
    return a(this.E.b(), paramLong);
  }

  public CounterConfiguration.a b()
  {
    return CounterConfiguration.a.a(this.c.getInt(this.G.b(), CounterConfiguration.a.a.d));
  }

  public String b(String paramString)
  {
    return this.c.getString(this.I.b(), paramString);
  }

  public long c(long paramLong)
  {
    return a(this.F.b(), paramLong);
  }

  public jj c()
  {
    return (jj)h(this.I.b());
  }

  public long d(long paramLong)
  {
    return a(this.w.b(), paramLong);
  }

  public jj d()
  {
    return (jj)h(this.G.b());
  }

  public long e(long paramLong)
  {
    return a(this.B.b(), paramLong);
  }

  public boolean e()
  {
    return (this.c.contains(this.y.b())) || (this.c.contains(this.z.b())) || (this.c.contains(this.A.b())) || (this.c.contains(this.v.b())) || (this.c.contains(this.w.b())) || (this.c.contains(this.x.b())) || (this.c.contains(this.E.b())) || (this.c.contains(this.C.b())) || (this.c.contains(this.B.b())) || (this.c.contains(this.D.b())) || (this.c.contains(this.J.b())) || (this.c.contains(this.G.b())) || (this.c.contains(this.H.b())) || (this.c.contains(this.I.b())) || (this.c.contains(this.F.b()));
  }

  public long f(long paramLong)
  {
    return a(this.x.b(), paramLong);
  }

  protected String f()
  {
    return "_boundentrypreferences";
  }

  public long g(long paramLong)
  {
    return a(this.D.b(), paramLong);
  }

  public void g()
  {
    this.c.edit().remove(this.E.b()).remove(this.D.b()).remove(this.B.b()).remove(this.C.b()).remove(this.y.b()).remove(this.x.b()).remove(this.w.b()).remove(this.v.b()).remove(this.A.b()).remove(this.z.b()).remove(this.H.b()).remove(this.G.b()).remove(this.J.b()).remove(this.K.b()).remove(this.I.b()).remove(this.F.b()).apply();
  }

  public long h(long paramLong)
  {
    return a(this.v.b(), paramLong);
  }

  public long i(long paramLong)
  {
    return a(this.C.b(), paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.jj
 * JD-Core Version:    0.6.2
 */