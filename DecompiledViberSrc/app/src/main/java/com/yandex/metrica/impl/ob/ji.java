package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

@Deprecated
public class ji extends jh
{
  private static final jo d = new jo("UUID");
  private static final jo e = new jo("DEVICEID");
  private static final jo f = new jo("DEVICEID_2");
  private static final jo g = new jo("DEVICEID_3");
  private static final jo h = new jo("AD_URL_GET");
  private static final jo i = new jo("AD_URL_REPORT");
  private static final jo j = new jo("HOST_URL");
  private static final jo k = new jo("SERVER_TIME_OFFSET");
  private static final jo l = new jo("STARTUP_REQUEST_TIME");
  private static final jo m = new jo("CLIDS");
  private jo n = new jo(d.a());
  private jo o = new jo(e.a());
  private jo p = new jo(f.a());
  private jo q = new jo(g.a());
  private jo r = new jo(h.a());
  private jo s = new jo(i.a());
  private jo t = new jo(j.a());
  private jo u = new jo(k.a());
  private jo v = new jo(l.a());
  private jo w = new jo(m.a());

  public ji(Context paramContext)
  {
    super(paramContext, null);
  }

  public long a(long paramLong)
  {
    return this.c.getLong(this.u.a(), paramLong);
  }

  public String a()
  {
    return this.c.getString(this.p.b(), this.c.getString(this.o.b(), ""));
  }

  public String a(String paramString)
  {
    return this.c.getString(this.n.b(), paramString);
  }

  public long b(long paramLong)
  {
    return this.c.getLong(this.v.b(), paramLong);
  }

  public ji b()
  {
    return (ji)h();
  }

  public String b(String paramString)
  {
    return this.c.getString(this.q.b(), paramString);
  }

  public String c(String paramString)
  {
    return this.c.getString(this.r.b(), paramString);
  }

  public Map<String, ?> c()
  {
    return this.c.getAll();
  }

  public String d(String paramString)
  {
    return this.c.getString(this.s.b(), paramString);
  }

  public String e(String paramString)
  {
    return this.c.getString(this.w.b(), paramString);
  }

  protected String f()
  {
    return "_startupinfopreferences";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ji
 * JD-Core Version:    0.6.2
 */