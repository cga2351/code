package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class fz extends fx
{
  static final jo a = new jo("PREF_KEY_UID_");
  static final jo b;
  private static final jo c = new jo("PREF_KEY_HOST_URL_");
  private static final jo d = new jo("PREF_KEY_HOST_URLS_FROM_STARTUP");
  private static final jo e = new jo("PREF_KEY_HOST_URLS_FROM_CLIENT");

  @Deprecated
  private static final jo f = new jo("PREF_KEY_REPORT_URL_");
  private static final jo g = new jo("PREF_KEY_REPORT_URLS_");

  @Deprecated
  private static final jo h = new jo("PREF_L_URL");
  private static final jo i = new jo("PREF_L_URLS");
  private static final jo j = new jo("PREF_KEY_GET_AD_URL");
  private static final jo k = new jo("PREF_KEY_REPORT_AD_URL");
  private static final jo l = new jo("PREF_KEY_STARTUP_OBTAIN_TIME_");
  private static final jo m = new jo("PREF_KEY_STARTUP_ENCODED_CLIDS_");
  private static final jo n = new jo("PREF_KEY_DISTRIBUTION_REFERRER_");
  private static final jo o;
  private static final jo p = new jo("PREF_KEY_EASY_COLLECTING_ENABLED_");
  private static final jo q = new jo("PREF_KEY_COLLECTING_PACKAGE_INFO_ENABLED_");
  private static final jo r = new jo("PREF_KEY_PERMISSIONS_COLLECTING_ENABLED_");
  private static final jo s = new jo("PREF_KEY_FEATURES_COLLECTING_ENABLED_");
  private static final jo t = new jo("SOCKET_CONFIG_");
  private static final jo u = new jo("LAST_STARTUP_REQUEST_CLIDS");
  private static final jo v = new jo("FLCC");
  private static final jo w = new jo("BKCC");
  private jo A = o(d.a());
  private jo B = o(e.a());

  @Deprecated
  private jo C = o(f.a());
  private jo D = o(g.a());

  @Deprecated
  private jo E = o(h.a());
  private jo F = o(i.a());
  private jo G = o(j.a());
  private jo H = o(k.a());
  private jo I = o(l.a());
  private jo J = o(m.a());
  private jo K = o(n.a());
  private jo L = o(o.a());
  private jo M = o(p.a());
  private jo N = o(q.a());
  private jo O = o(r.a());
  private jo P = o(s.a());
  private jo Q = o(t.a());
  private jo R = o(u.a());
  private jo S = o(v.a());
  private jo T = o(w.a());
  private jo x = new jo(b.a());
  private jo y = o(a.a());
  private jo z = o(c.a());

  static
  {
    b = new jo("PREF_KEY_DEVICE_ID_");
    o = new jo("STARTUP_CLIDS_MATCH_WITH_APP_CLIDS_");
    new jo("PREF_KEY_PINNING_UPDATE_URL");
  }

  public fz(fk paramfk, String paramString)
  {
    super(paramfk, paramString);
  }

  static kt.a.c a(JSONObject paramJSONObject)
  {
    kt.a.c localc = new kt.a.c();
    localc.b = oq.a(nz.a(paramJSONObject, "uti"), localc.b);
    localc.c = oq.a(nz.d(paramJSONObject, "udi"), localc.c);
    localc.d = oq.a(nz.b(paramJSONObject, "rcff"), localc.d);
    localc.e = oq.a(nz.b(paramJSONObject, "mbs"), localc.e);
    localc.f = oq.a(nz.a(paramJSONObject, "maff"), localc.f);
    localc.g = oq.a(nz.b(paramJSONObject, "mrsl"), localc.g);
    localc.h = oq.a(nz.c(paramJSONObject, "ce"), localc.h);
    return localc;
  }

  private static hp k(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject = null;
    if (!bool);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      hp localhp = new gp().a(a(localJSONObject));
      localObject = localhp;
      return localObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  private static hk l(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject = null;
    if (!bool);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      kt.a.a locala = new kt.a.a();
      locala.b = a(localJSONObject);
      locala.c = oq.a(nz.a(localJSONObject, "cd"), locala.c);
      locala.d = oq.a(nz.a(localJSONObject, "ci"), locala.d);
      hk localhk = new gl().a(locala);
      localObject = localhk;
      return localObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public fz a(long paramLong)
  {
    return (fz)a(this.I.b(), paramLong);
  }

  public fz a(String paramString)
  {
    return (fz)b(this.y.b(), paramString);
  }

  public fz a(List<String> paramList)
  {
    return (fz)b(this.D.b(), nz.a(paramList));
  }

  public fz a(boolean paramBoolean)
  {
    return (fz)a(this.L.b(), paramBoolean);
  }

  @Deprecated
  public mw a()
  {
    return new mw.a(new ml.a().a(b(this.M.b(), ml.b.a)).b(b(this.N.b(), ml.b.b)).c(b(this.O.b(), ml.b.c)).d(b(this.P.b(), ml.b.d)).a()).a(q(this.y.b())).c(nz.b(q(this.A.b()))).d(nz.b(q(this.B.b()))).g(q(this.J.b())).a(nz.b(q(this.D.b()))).b(nz.b(q(this.F.b()))).d(q(this.G.b())).e(q(this.H.b())).i(c(this.K.b(), null)).a(k(q(this.S.b()))).a(l(q(this.T.b()))).a(mn.a(q(this.Q.b()))).h(q(this.R.b())).b(b(this.L.b(), true)).a(b(this.I.b(), -1L)).a();
  }

  @Deprecated
  public fz b(String paramString)
  {
    return (fz)b(this.x.b(), paramString);
  }

  public fz b(List<String> paramList)
  {
    return (fz)b(this.F.b(), nz.a(paramList));
  }

  @Deprecated
  public fz c(String paramString)
  {
    return (fz)b(this.C.b(), paramString);
  }

  public fz d(String paramString)
  {
    return (fz)b(this.H.b(), paramString);
  }

  public fz e(String paramString)
  {
    return (fz)b(this.G.b(), paramString);
  }

  public fz f(String paramString)
  {
    return (fz)b(this.z.b(), paramString);
  }

  public fz g(String paramString)
  {
    return (fz)b(this.J.b(), paramString);
  }

  public fz h(String paramString)
  {
    return (fz)b(this.K.b(), paramString);
  }

  @Deprecated
  public String i(String paramString)
  {
    return c(this.C.b(), paramString);
  }

  @Deprecated
  public String j(String paramString)
  {
    return c(this.E.b(), paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.fz
 * JD-Core Version:    0.6.2
 */