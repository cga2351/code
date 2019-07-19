package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

@Deprecated
public class jm extends jh
{
  static final jo d = new jo("PREF_KEY_DEVICE_ID_");
  static final jo e = new jo("PREF_KEY_UID_");
  static final jo f = new jo("STARTUP_CLIDS_MATCH_WITH_APP_CLIDS_");
  static final jo g = new jo("PREF_KEY_PINNING_UPDATE_URL");
  private static final jo h = new jo("PREF_KEY_HOST_URL_");
  private static final jo i = new jo("PREF_KEY_REPORT_URL_");
  private static final jo j = new jo("PREF_KEY_GET_AD_URL");
  private static final jo k = new jo("PREF_KEY_REPORT_AD_URL");
  private static final jo l = new jo("PREF_KEY_STARTUP_OBTAIN_TIME_");
  private static final jo m = new jo("PREF_KEY_STARTUP_ENCODED_CLIDS_");
  private static final jo n = new jo("PREF_KEY_DISTRIBUTION_REFERRER_");
  private static final jo o = new jo("PREF_KEY_EASY_COLLECTING_ENABLED_");
  private jo p = new jo(d.a());
  private jo q = new jo(e.a(), i());
  private jo r = new jo(h.a(), i());
  private jo s = new jo(i.a(), i());
  private jo t = new jo(j.a(), i());
  private jo u = new jo(k.a(), i());
  private jo v = new jo(l.a(), i());
  private jo w = new jo(m.a(), i());
  private jo x = new jo(n.a(), i());
  private jo y = new jo(o.a(), i());

  public jm(Context paramContext)
  {
    this(paramContext, null);
  }

  public jm(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }

  public static void a(Context paramContext)
  {
    jp.a(paramContext, "_startupserviceinfopreferences").edit().remove(d.a()).apply();
  }

  public long a(long paramLong)
  {
    return this.c.getLong(this.v.b(), paramLong);
  }

  public String a()
  {
    return this.c.getString(this.x.a(), null);
  }

  public String a(String paramString)
  {
    return this.c.getString(this.p.b(), paramString);
  }

  public String b(String paramString)
  {
    return this.c.getString(this.q.b(), paramString);
  }

  public void b()
  {
    h(this.p.b()).h(this.q.b()).h(this.r.b()).h(this.s.b()).h(this.t.b()).h(this.u.b()).h(this.v.b()).h(this.y.b()).h(this.w.b()).h(this.x.a()).h(f.a()).h(g.a()).j();
  }

  public String c(String paramString)
  {
    return this.c.getString(this.r.b(), paramString);
  }

  public String d(String paramString)
  {
    return this.c.getString(this.w.b(), paramString);
  }

  public String e(String paramString)
  {
    return this.c.getString(this.s.b(), paramString);
  }

  protected String f()
  {
    return "_startupserviceinfopreferences";
  }

  public String f(String paramString)
  {
    return this.c.getString(this.t.b(), paramString);
  }

  public String g(String paramString)
  {
    return this.c.getString(this.u.b(), paramString);
  }

  public jm i(String paramString)
  {
    return (jm)a(this.q.b(), paramString);
  }

  public jm j(String paramString)
  {
    return (jm)a(this.p.b(), paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.jm
 * JD-Core Version:    0.6.2
 */