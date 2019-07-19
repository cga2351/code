package com.yandex.metrica.impl;

import android.content.ContentValues;
import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.hw;
import com.yandex.metrica.impl.ob.lr;
import com.yandex.metrica.impl.ob.nf;
import com.yandex.metrica.impl.ob.ng;
import com.yandex.metrica.impl.ob.nh;
import com.yandex.metrica.impl.ob.np;
import com.yandex.metrica.impl.ob.nr;
import com.yandex.metrica.impl.ob.ns;
import com.yandex.metrica.impl.ob.nz;
import com.yandex.metrica.impl.ob.oy;
import com.yandex.metrica.impl.ob.pb;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l
{
  private Context a;
  private ContentValues b;
  private lr c;

  public l(Context paramContext)
  {
    this.a = paramContext;
  }

  public l a(ContentValues paramContentValues)
  {
    this.b = paramContentValues;
    return this;
  }

  public l a(lr paramlr)
  {
    this.c = paramlr;
    return this;
  }

  public void a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("dId", this.c.q()).putOpt("uId", this.c.r()).putOpt("appVer", this.c.p()).putOpt("appBuild", this.c.o()).putOpt("analyticsSdkVersionName", this.c.h()).putOpt("kitBuildNumber", this.c.i()).putOpt("kitBuildType", this.c.j()).putOpt("osVer", this.c.m()).putOpt("osApiLev", Integer.valueOf(this.c.n())).putOpt("lang", this.c.y()).putOpt("root", this.c.s()).putOpt("app_debuggable", this.c.C()).putOpt("app_framework", this.c.t()).putOpt("attribution_id", Integer.valueOf(this.c.R()));
      this.b.put("report_request_parameters", localJSONObject.toString());
      return;
    }
    catch (Exception localException)
    {
      while (true)
        localJSONObject = new JSONObject();
    }
  }

  void a(bx parambx)
  {
    String str = parambx.b(this.a);
    int i;
    if (!TextUtils.isEmpty(str))
      i = parambx.c(this.a);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ssid", str);
      localJSONObject.put("state", i);
      this.b.put("wifi_access_point", localJSONObject.toString());
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void a(oy paramoy, b.a parama)
  {
    i locali = paramoy.a;
    this.b.put("name", locali.b());
    this.b.put("value", locali.c());
    this.b.put("type", Integer.valueOf(locali.e()));
    this.b.put("custom_type", Integer.valueOf(locali.f()));
    this.b.put("error_environment", locali.k());
    this.b.put("user_info", locali.m());
    this.b.put("truncated", Integer.valueOf(locali.q()));
    this.b.put("connection_type", Integer.valueOf(aw.e(this.a)));
    this.b.put("profile_id", locali.t());
    this.b.put("encrypting_mode", Integer.valueOf(paramoy.b.a()));
    this.b.put("first_occurrence_status", Integer.valueOf(paramoy.a.u().d));
    this.b.put("app_environment", parama.a);
    this.b.put("app_environment_revision", Long.valueOf(parama.b));
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("enabled", this.c.J());
      Location localLocation = b();
      Float localFloat1;
      Float localFloat2;
      label333: Float localFloat3;
      label362: bx localbx;
      label442: JSONArray localJSONArray1;
      if (localLocation != null)
      {
        localJSONObject.put("lat", localLocation.getLatitude());
        localJSONObject.put("lon", localLocation.getLongitude());
        localJSONObject.putOpt("timestamp", Long.valueOf(localLocation.getTime()));
        if (localLocation.hasAccuracy())
        {
          localFloat1 = Float.valueOf(localLocation.getAccuracy());
          localJSONObject.putOpt("precision", localFloat1);
          if (!localLocation.hasBearing())
            break label540;
          localFloat2 = Float.valueOf(localLocation.getBearing());
          localJSONObject.putOpt("direction", localFloat2);
          if (!localLocation.hasSpeed())
            break label546;
          localFloat3 = Float.valueOf(localLocation.getSpeed());
          localJSONObject.putOpt("speed", localFloat3);
          boolean bool = localLocation.hasAltitude();
          Double localDouble = null;
          if (bool)
            localDouble = Double.valueOf(localLocation.getAltitude());
          localJSONObject.putOpt("altitude", localDouble);
          localJSONObject.putOpt("provider", bu.c(localLocation.getProvider(), null));
        }
      }
      else
      {
        this.b.put("location_info", localJSONObject.toString());
        np localnp = np.a(this.a);
        localnp.a(new ns()
        {
          public void a(nr paramAnonymousnr)
          {
            ng localng = paramAnonymousnr.b();
            if (localng != null)
              l.a(l.this).put("cellular_connection_type", localng.g());
          }
        });
        localnp.a(new nh()
        {
          public void a(ng[] paramAnonymousArrayOfng)
          {
            l.a(l.this).put("cell_info", nz.a(paramAnonymousArrayOfng).toString());
          }
        });
        localbx = bx.a(this.a);
        localJSONArray1 = locali.i();
        JSONArray localJSONArray2 = localbx.a();
        if (localJSONArray2.length() <= localJSONArray1.length())
          break label552;
        this.b.put("wifi_network_info", localJSONArray2.toString());
      }
      while (true)
      {
        a(localbx);
        return;
        localFloat1 = null;
        break;
        label540: localFloat2 = null;
        break label333;
        label546: localFloat3 = null;
        break label362;
        label552: this.b.put("wifi_network_info", localJSONArray1.toString());
      }
    }
    catch (Exception localException)
    {
      break label442;
    }
  }

  Location b()
  {
    boolean bool = this.c.J();
    Location localLocation = null;
    if (bool)
    {
      localLocation = this.c.K();
      if (localLocation == null)
      {
        localLocation = hw.a(this.a).a();
        if (localLocation == null)
          localLocation = hw.a(this.a).b();
      }
    }
    return localLocation;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.l
 * JD-Core Version:    0.6.2
 */