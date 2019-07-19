package com.yandex.metrica.impl.ob;

import com.yandex.metrica.CounterConfiguration.a;
import com.yandex.metrica.impl.b.a;

public class fw extends fx
{
  private static final jo a = new jo("COLLECT_INSTALLED_APPS");
  private static final jo b = new jo("IDENTITY_SEND_TIME");
  private static final jo c = new jo("PERMISSIONS_CHECK_TIME");
  private static final jo d = new jo("USER_INFO");
  private static final jo e = new jo("PROFILE_ID");
  private static final jo f = new jo("APP_ENVIRONMENT");
  private static final jo g = new jo("APP_ENVIRONMENT_REVISION");
  private static final jo h = new jo("LAST_MIGRATION_VERSION");
  private static final jo i = new jo("LAST_APP_VERSION_WITH_FEATURES");
  private static final jo j = new jo("APPLICATION_FEATURES");
  private static final jo k = new jo("CURRENT_SESSION_ID");
  private static final jo l = new jo("ATTRIBUTION_ID");
  private static final jo m = new jo("LAST_STAT_SENDING_DISABLED_REPORTING_TIMESTAMP");

  public fw(fk paramfk)
  {
    super(paramfk);
  }

  public int a(int paramInt)
  {
    return b(i.b(), paramInt);
  }

  public long a(long paramLong)
  {
    return b(b.b(), paramLong);
  }

  public b.a a()
  {
    try
    {
      b.a locala = new b.a(c(f.b(), "{}"), b(g.b(), 0L));
      return locala;
    }
    finally
    {
    }
  }

  public fw a(CounterConfiguration.a parama)
  {
    return (fw)a(a.b(), parama.d);
  }

  public fw a(b.a parama)
  {
    try
    {
      b(f.b(), parama.a);
      a(g.b(), parama.b);
      return this;
    }
    finally
    {
    }
  }

  public fw a(String paramString1, String paramString2)
  {
    return (fw)b(new jo("SESSION_", paramString1).b(), paramString2);
  }

  public String a(String paramString)
  {
    return c(d.b(), paramString);
  }

  public long b(long paramLong)
  {
    return b(c.b(), paramLong);
  }

  public fw b(int paramInt)
  {
    return (fw)a(i.b(), paramInt);
  }

  public fw b(String paramString)
  {
    return (fw)b(d.b(), paramString);
  }

  public String b()
  {
    return c(j.b(), "");
  }

  public CounterConfiguration.a c()
  {
    return CounterConfiguration.a.a(Long.valueOf(b(a.b(), CounterConfiguration.a.a.d)).intValue());
  }

  public fw c(int paramInt)
  {
    return (fw)a(l.b(), paramInt);
  }

  public fw c(long paramLong)
  {
    return (fw)a(b.b(), paramLong);
  }

  public fw c(String paramString)
  {
    return (fw)b(j.b(), paramString);
  }

  public int d(int paramInt)
  {
    return b(l.b(), paramInt);
  }

  public long d()
  {
    return b(h.b(), 0L);
  }

  public fw d(long paramLong)
  {
    return (fw)a(c.b(), paramLong);
  }

  public String d(String paramString)
  {
    return c(new jo("SESSION_", paramString).b(), "");
  }

  public fw e(long paramLong)
  {
    return (fw)a(h.b(), paramLong);
  }

  public fw e(String paramString)
  {
    return (fw)b(e.b(), paramString);
  }

  public String e()
  {
    return q(e.b());
  }

  public long f(long paramLong)
  {
    return b(k.b(), paramLong);
  }

  public fw g(long paramLong)
  {
    return (fw)a(k.b(), paramLong);
  }

  public long h(long paramLong)
  {
    return b(m.b(), paramLong);
  }

  public fw i(long paramLong)
  {
    return (fw)a(m.b(), paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.fw
 * JD-Core Version:    0.6.2
 */