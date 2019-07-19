package com.yandex.metrica.impl;

import android.net.Uri.Builder;
import android.text.TextUtils;
import com.yandex.metrica.impl.ac.GoogleAdvertisingIdGetter.b;
import com.yandex.metrica.impl.ob.ls;
import com.yandex.metrica.impl.ob.lw;
import com.yandex.metrica.impl.ob.lx;
import com.yandex.metrica.impl.ob.mq;
import com.yandex.metrica.impl.ob.mx;
import com.yandex.metrica.impl.ob.ol;
import com.yandex.metrica.impl.ob.y;
import java.util.Map;

public class bs extends av
{
  private final mx a;
  private ls b;
  private boolean c = false;
  private mq l;
  private final lx m = new lw();

  public bs(mx parammx, ls paramls)
  {
    super(new bq(parammx, paramls));
    this.a = parammx;
    this.b = paramls;
    a(this.b.a());
  }

  private static void a(Uri.Builder paramBuilder, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
      paramBuilder.appendQueryParameter(paramString1, paramString2);
  }

  protected String E()
  {
    return "startup";
  }

  boolean F()
  {
    try
    {
      boolean bool = this.c;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String a()
  {
    return "Startup task for component: " + this.a.b().toString();
  }

  protected void a(Uri.Builder paramBuilder)
  {
    paramBuilder.path("analytics/startup");
    paramBuilder.appendQueryParameter("deviceid", this.b.q());
    a(paramBuilder, v.a().g());
    b(paramBuilder);
    paramBuilder.appendQueryParameter("app_platform", this.b.k());
    paramBuilder.appendQueryParameter("protocol_version", this.b.g());
    paramBuilder.appendQueryParameter("analytics_sdk_version_name", this.b.h());
    paramBuilder.appendQueryParameter("model", this.b.l());
    paramBuilder.appendQueryParameter("manufacturer", this.b.f());
    paramBuilder.appendQueryParameter("os_version", this.b.m());
    paramBuilder.appendQueryParameter("screen_width", String.valueOf(this.b.u()));
    paramBuilder.appendQueryParameter("screen_height", String.valueOf(this.b.v()));
    paramBuilder.appendQueryParameter("screen_dpi", String.valueOf(this.b.w()));
    paramBuilder.appendQueryParameter("scalefactor", String.valueOf(this.b.x()));
    paramBuilder.appendQueryParameter("locale", this.b.y());
    paramBuilder.appendQueryParameter("device_type", this.b.A());
    paramBuilder.appendQueryParameter("queries", "1");
    paramBuilder.appendQueryParameter("query_hosts", "2");
    paramBuilder.appendQueryParameter("features", bu.b(new String[] { "easy_collecting", "package_info", "socket", "permissions_collecting", "features_collecting", "foreground_location_collection", "background_location_collection", "foreground_lbs_collection", "background_lbs_collection", "telephony_restricted_to_location_tracking", "android_id", "google_aid", "wifi_around", "wifi_connected", "own_macs", "cells_around", "sim_info", "sim_imei", "access_point", "sdk_list" }));
    paramBuilder.appendQueryParameter("browsers", "1");
    paramBuilder.appendQueryParameter("socket", "1");
    paramBuilder.appendQueryParameter("app_id", this.b.c());
    paramBuilder.appendQueryParameter("foreground_location_collection", "1");
    paramBuilder.appendQueryParameter("app_debuggable", this.b.C());
    paramBuilder.appendQueryParameter("sdk_list", "1");
    paramBuilder.appendQueryParameter("background_location_collection", "1");
    if (this.b.b())
    {
      String str2 = this.b.J();
      if (!TextUtils.isEmpty(str2))
        paramBuilder.appendQueryParameter("country_init", str2);
    }
    while (true)
    {
      Map localMap = this.b.F();
      String str1 = this.b.G();
      if (!bw.a(localMap))
      {
        paramBuilder.appendQueryParameter("distribution_customization", "1");
        a(paramBuilder, "clids_set", ol.a(localMap));
        if (!TextUtils.isEmpty(str1))
          paramBuilder.appendQueryParameter("install_referrer", str1);
      }
      a(paramBuilder, "uuid", this.b.r());
      paramBuilder.appendQueryParameter("time", "1");
      paramBuilder.appendQueryParameter("requests", "1");
      paramBuilder.appendQueryParameter("stat_sending", "1");
      paramBuilder.appendQueryParameter("permissions", "1");
      return;
      paramBuilder.appendQueryParameter("detect_locale", "1");
    }
  }

  protected void a(Uri.Builder paramBuilder, bt parambt)
  {
    GoogleAdvertisingIdGetter.b localb = this.b.B();
    if (parambt.a())
    {
      paramBuilder.appendQueryParameter("adv_id", "");
      return;
    }
    if ((localb == null) || (TextUtils.isEmpty(localb.a)))
    {
      paramBuilder.appendQueryParameter("adv_id", "");
      return;
    }
    paramBuilder.appendQueryParameter("adv_id", localb.a);
  }

  protected void b(Uri.Builder paramBuilder)
  {
    GoogleAdvertisingIdGetter.b localb = this.b.B();
    if ((localb == null) || (TextUtils.isEmpty(localb.a)))
    {
      paramBuilder.appendQueryParameter("deviceid2", "");
      return;
    }
    paramBuilder.appendQueryParameter("deviceid2", bu.a(w.c(localb.a.getBytes())));
  }

  public void b(boolean paramBoolean)
  {
    try
    {
      this.c = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean b()
  {
    b(false);
    a("Accept-Encoding", new String[] { "encrypted" });
    return this.a.d();
  }

  public boolean c()
  {
    boolean bool;
    if (F())
      bool = true;
    do
    {
      return bool;
      if (200 != this.h)
        break;
      bool = super.c();
    }
    while (bool);
    this.l = mq.c;
    return bool;
    return false;
  }

  public lx d()
  {
    return this.m;
  }

  public void h()
  {
    if ((!A()) && (B()))
    {
      if (this.l == null)
        this.l = mq.a;
      this.a.a(this.l);
    }
  }

  public void i()
  {
    this.l = mq.b;
  }

  public void j()
  {
    super.j();
    this.l = mq.b;
  }

  public boolean q()
  {
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.bs
 * JD-Core Version:    0.6.2
 */