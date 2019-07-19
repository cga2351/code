package com.my.target;

import android.content.Context;
import android.text.TextUtils;
import com.my.target.common.a.b;
import com.my.target.common.a.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class af
{
  private final f a;
  private final z b;
  private final Context c;
  private String d;
  private final ae e;

  private af(f paramf, z paramz, Context paramContext)
  {
    this.a = paramf;
    this.b = paramz;
    this.c = paramContext;
    this.e = ae.a(paramf, paramz, paramContext);
  }

  public static af a(f paramf, z paramz, Context paramContext)
  {
    return new af(paramf, paramz, paramContext);
  }

  private c a(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("src");
    int i = paramJSONObject.optInt("width");
    int j = paramJSONObject.optInt("height");
    if ((!TextUtils.isEmpty(str)) && (i > 0) && (j > 0))
    {
      c localc = c.a(str, i, j);
      localc.c(paramJSONObject.optInt("bitrate"));
      if ((localc.a().endsWith(".m3u8")) && (!bf.b()))
      {
        dp.a("HLS Video does not supported, add com.google.android.exoplayer:exoplayer-hls dependency to play HLS video ");
        return null;
      }
      return localc;
    }
    a("Bad value", "bad mediafile object, src = " + str + ", width = " + i + ", height = " + j);
    return null;
  }

  private void a(String paramString1, String paramString2)
  {
    y.a(paramString1).b(paramString2).a(this.b.c()).d(this.d).c(this.a.f()).a(this.c);
  }

  private void b(JSONObject paramJSONObject, k<c> paramk)
  {
    c(paramJSONObject, paramk);
    Boolean localBoolean1 = this.a.o();
    if (localBoolean1 != null)
      paramk.i(localBoolean1.booleanValue());
    Boolean localBoolean2 = this.a.p();
    if (localBoolean2 != null)
      paramk.k(localBoolean2.booleanValue());
    float f = this.a.n();
    if (f >= 0.0F)
      paramk.c(f);
  }

  private void c(JSONObject paramJSONObject, k<c> paramk)
  {
    double d1 = -1.0D;
    double d2 = this.a.k();
    if (d2 < 0.0D)
      d2 = paramJSONObject.optDouble("point");
    double d3;
    if (Double.isNaN(d2))
    {
      d2 = d1;
      d3 = this.a.l();
      if (d3 < 0.0D)
        d3 = paramJSONObject.optDouble("pointP");
      if (!Double.isNaN(d3))
        break label150;
      d3 = d1;
      label76: if ((d2 >= 0.0D) || (d3 >= 0.0D))
        break label191;
    }
    for (double d4 = 50.0D; ; d4 = d3)
    {
      paramk.d((float)d1);
      paramk.e((float)d4);
      return;
      if (d2 >= 0.0D)
        break;
      a("Bad value", "Wrong value " + d2 + " for point");
      break;
      label150: if (d3 >= 0.0D)
        break label76;
      a("Bad value", "Wrong value " + d3 + " for pointP");
      break label76;
      label191: d1 = d2;
    }
  }

  public boolean a(JSONObject paramJSONObject, k<c> paramk)
  {
    this.e.a(paramJSONObject, paramk);
    if ("statistics".equals(paramk.r()))
    {
      c(paramJSONObject, paramk);
      return true;
    }
    this.d = paramk.k();
    float f = paramk.A();
    if (f <= 0.0F)
    {
      a("Bad value", "wrong videoBanner duration " + f);
      return false;
    }
    paramk.q(paramJSONObject.optString("closeActionText", "Close"));
    paramk.r(paramJSONObject.optString("replayActionText", paramk.H()));
    paramk.s(paramJSONObject.optString("closeDelayActionText", paramk.T()));
    paramk.h(paramJSONObject.optBoolean("allowReplay", paramk.N()));
    paramk.d(paramJSONObject.optBoolean("automute", paramk.I()));
    paramk.j(paramJSONObject.optBoolean("allowBackButton", paramk.R()));
    paramk.i(paramJSONObject.optBoolean("allowClose", paramk.P()));
    paramk.c((float)paramJSONObject.optDouble("allowCloseDelay", 0.0D));
    paramk.g(paramJSONObject.optBoolean("showPlayerControls", paramk.J()));
    paramk.e(paramJSONObject.optBoolean("autoplay", paramk.K()));
    paramk.f(paramJSONObject.optBoolean("hasCtaButton", paramk.L()));
    paramk.k(paramJSONObject.optBoolean("hasPause", paramk.S()));
    String str = paramJSONObject.optString("previewLink");
    if (!TextUtils.isEmpty(str))
      paramk.c(b.a(str, paramJSONObject.optInt("previewWidth"), paramJSONObject.optInt("previewHeight")));
    JSONArray localJSONArray = paramJSONObject.optJSONArray("mediafiles");
    if ((localJSONArray == null) || (localJSONArray.length() == 0))
    {
      dp.a("mediafiles array is empty");
      a("Required field", "unable to find mediaFiles in MediaBanner");
      return false;
    }
    b(paramJSONObject, paramk);
    ArrayList localArrayList = new ArrayList();
    int i = localJSONArray.length();
    for (int j = 0; j < i; j++)
    {
      JSONObject localJSONObject = localJSONArray.optJSONObject(j);
      if (localJSONObject != null)
      {
        c localc2 = a(localJSONObject);
        if (localc2 != null)
          localArrayList.add(localc2);
      }
    }
    if (localArrayList.size() > 0)
    {
      c localc1 = c.a(localArrayList, this.b.h());
      if (localc1 != null)
      {
        paramk.a(localc1);
        return true;
      }
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.af
 * JD-Core Version:    0.6.2
 */