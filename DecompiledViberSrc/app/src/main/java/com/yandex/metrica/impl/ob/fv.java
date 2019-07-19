package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import java.util.List;

public class fv extends fx
{
  static final jo a = new jo("UUID");
  static final jo b = new jo("DEVICE_ID_POSSIBLE");
  static final jo c = new jo("DEVICE_ID");
  static final jo d = new jo("DEVICE_ID_HASH");
  static final jo e = new jo("AD_URL_GET");
  static final jo f = new jo("AD_URL_REPORT");
  static final jo g = new jo("CUSTOM_HOSTS");
  static final jo h = new jo("SERVER_TIME_OFFSET");
  static final jo i = new jo("STARTUP_REQUEST_TIME");
  static final jo j = new jo("CLIDS");
  static final jo k = new jo("REFERRER");
  static final jo l = new jo("DEFERRED_DEEP_LINK_WAS_CHECKED");
  static final jo m = new jo("REFERRER_FROM_PLAY_SERVICES_WAS_CHECKED");
  static final jo n = new jo("API_LEVEL");

  public fv(fk paramfk)
  {
    super(paramfk);
  }

  public long a(long paramLong)
  {
    return b(h.a(), paramLong);
  }

  public fv a(List<String> paramList)
  {
    String str = nz.a(paramList);
    return (fv)b(g.b(), str);
  }

  public String a()
  {
    return c(b.b(), "");
  }

  public String a(String paramString)
  {
    return c(a.b(), paramString);
  }

  public long b(long paramLong)
  {
    return b(i.b(), paramLong);
  }

  public String b(String paramString)
  {
    return c(c.b(), paramString);
  }

  public List<String> b()
  {
    String str = c(g.b(), null);
    if (TextUtils.isEmpty(str))
      return null;
    return nz.b(str);
  }

  public long c(long paramLong)
  {
    return b(n.b(), paramLong);
  }

  public String c()
  {
    return c(k.b(), null);
  }

  public String c(String paramString)
  {
    return c(d.b(), paramString);
  }

  public fv d(long paramLong)
  {
    return (fv)a(h.b(), paramLong);
  }

  public String d(String paramString)
  {
    return c(e.b(), paramString);
  }

  public boolean d()
  {
    return b(l.b(), false);
  }

  public fv e(long paramLong)
  {
    return (fv)a(i.b(), paramLong);
  }

  public String e(String paramString)
  {
    return c(f.b(), paramString);
  }

  public boolean e()
  {
    return b(l.b(), false);
  }

  public fv f()
  {
    return (fv)a(l.b(), true);
  }

  public fv f(long paramLong)
  {
    return (fv)a(n.b(), paramLong);
  }

  public String f(String paramString)
  {
    return c(j.b(), paramString);
  }

  public fv g()
  {
    return (fv)a(m.b(), true);
  }

  public fv g(String paramString)
  {
    return (fv)b(a.b(), paramString);
  }

  public fv h(String paramString)
  {
    return (fv)b(c.b(), paramString);
  }

  public fv i(String paramString)
  {
    return (fv)b(d.b(), paramString);
  }

  public fv j(String paramString)
  {
    return (fv)b(e.b(), paramString);
  }

  public fv k(String paramString)
  {
    return (fv)b(f.b(), paramString);
  }

  public fv l(String paramString)
  {
    return (fv)b(j.b(), paramString);
  }

  public fv m(String paramString)
  {
    return (fv)b(b.b(), paramString);
  }

  public fv n(String paramString)
  {
    return (fv)b(k.b(), paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.fv
 * JD-Core Version:    0.6.2
 */