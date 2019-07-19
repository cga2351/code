package com.yandex.metrica.impl.ob;

import android.util.Base64;
import com.yandex.metrica.CounterConfiguration.a;

public class fy extends fx
{
  static final jo a = new jo("LOCATION_TRACKING_ENABLED");
  static final jo b = new jo("COLLECT_INSTALLED_APPS");
  static final jo c = new jo("REFERRER");
  static final jo d = new jo("REFERRER_FROM_PLAY_SERVICES");
  static final jo e = new jo("REFERRER_HANDLED");
  static final jo f = new jo("REFERRER_HOLDER_STATE");
  static final jo g = new jo("PREF_KEY_OFFSET");
  static final jo h = new jo("UNCHECKED_TIME");
  static final jo i = new jo("L_REQ_NUM");
  static final jo j = new jo("L_ID");
  static final jo k = new jo("LBS_ID");
  static final jo l = new jo("STATISTICS_RESTRICTED_IN_MAIN");
  private static final jo m = new jo("LAST_MIGRATION_VERSION");

  static
  {
    new jo("SDKFCE");
    new jo("FST");
    new jo("LSST");
    new jo("FSDKFCO");
    new jo("SRSDKFC");
    new jo("LSDKFCAT");
  }

  public fy(fk paramfk)
  {
    super(paramfk);
  }

  private static lj b(String paramString)
  {
    if (paramString == null)
      return null;
    try
    {
      lj locallj = lj.a(Base64.encode(paramString.getBytes(), 0));
      return locallj;
    }
    catch (d locald)
    {
    }
    return null;
  }

  public int a(int paramInt)
  {
    return b(m.b(), paramInt);
  }

  public CounterConfiguration.a a()
  {
    return CounterConfiguration.a.a(Long.valueOf(b(b.b(), CounterConfiguration.a.a.d)).intValue());
  }

  public fy a(long paramLong)
  {
    return (fy)a(g.b(), paramLong);
  }

  public fy a(CounterConfiguration.a parama)
  {
    return (fy)a(b.b(), parama.d);
  }

  public fy a(lj paramlj)
  {
    String str1 = d.b();
    if (paramlj == null);
    for (String str2 = null; ; str2 = new String(Base64.encode(paramlj.a(), 0)))
      return (fy)b(str1, str2);
  }

  public fy a(String paramString)
  {
    return (fy)b(c.b(), paramString);
  }

  public void a(boolean paramBoolean)
  {
    a(a.b(), paramBoolean).i();
  }

  public long b(long paramLong)
  {
    return b(i.b(), paramLong);
  }

  public fy b(int paramInt)
  {
    return (fy)a(m.b(), paramInt);
  }

  public String b()
  {
    return c(c.b(), null);
  }

  public boolean b(boolean paramBoolean)
  {
    return b(h.b(), paramBoolean);
  }

  public long c(int paramInt)
  {
    return b(g.b(), paramInt);
  }

  public fy c(long paramLong)
  {
    return (fy)a(i.b(), paramLong);
  }

  public fy c(boolean paramBoolean)
  {
    return (fy)a(h.b(), paramBoolean);
  }

  public lj c()
  {
    return b(c(d.b(), null));
  }

  public int d(int paramInt)
  {
    return b(f.b(), paramInt);
  }

  public long d(long paramLong)
  {
    return b(j.b(), paramLong);
  }

  public fy d(boolean paramBoolean)
  {
    return (fy)a(l.b(), paramBoolean);
  }

  public boolean d()
  {
    return b(e.b(), false);
  }

  public fy e()
  {
    return (fy)a(e.b(), true);
  }

  public fy e(int paramInt)
  {
    return (fy)a(f.b(), paramInt);
  }

  public fy e(long paramLong)
  {
    return (fy)a(j.b(), paramLong);
  }

  public long f(long paramLong)
  {
    return b(k.b(), paramLong);
  }

  public fy f()
  {
    return (fy)p(c.b()).p(d.b());
  }

  public fy g(long paramLong)
  {
    return (fy)a(k.b(), paramLong);
  }

  public boolean g()
  {
    return b(a.b(), false);
  }

  public Boolean j()
  {
    if (r(l.b()))
      return Boolean.valueOf(b(l.b(), true));
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.fy
 * JD-Core Version:    0.6.2
 */