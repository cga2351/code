package com.my.target;

import android.content.Context;
import android.text.TextUtils;
import com.my.target.b.c.a.e;
import com.my.target.b.c.a.g;
import com.my.target.b.c.a.h;
import com.my.target.b.c.a.i;
import com.my.target.common.a.b;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class cr
{
  private final f a;
  private final z b;
  private final Context c;
  private final ae d;

  private cr(f paramf, z paramz, Context paramContext)
  {
    this.a = paramf;
    this.b = paramz;
    this.c = paramContext;
    this.d = ae.a(paramf, paramz, paramContext);
  }

  public static cr a(f paramf, z paramz, Context paramContext)
  {
    return new cr(paramf, paramz, paramContext);
  }

  private void a(String paramString1, String paramString2, String paramString3)
  {
    y.a(paramString1).b(paramString2).a(this.b.c()).d(paramString3).c(this.a.f()).a(this.c);
  }

  private void a(JSONObject paramJSONObject, e parame)
  {
    this.d.a(paramJSONObject, parame);
    parame.c((float)paramJSONObject.optDouble("allowCloseDelay", parame.E()));
    String str = paramJSONObject.optString("close_icon_hd");
    if (!TextUtils.isEmpty(str))
      parame.c(b.a(str));
  }

  public final boolean a(JSONObject paramJSONObject, g paramg, String paramString)
  {
    String str1 = paramJSONObject.optString("source", null);
    if (str1 == null)
    {
      a("Required field", "Banner with type 'html' has no source field", paramg.k());
      return false;
    }
    String str2 = bk.a(str1);
    a(paramJSONObject, paramg);
    String str3;
    if (!TextUtils.isEmpty(paramString))
    {
      str3 = ae.a(paramString, str2);
      if (str3 != null)
        paramg.a("mraid");
    }
    while (true)
    {
      paramg.q(str3);
      return this.d.a(str3, paramJSONObject);
      str3 = str2;
    }
  }

  public final boolean a(JSONObject paramJSONObject, h paramh)
  {
    a(paramJSONObject, paramh);
    return cs.a(this.a, this.b, this.c).a(paramJSONObject, paramh);
  }

  public final boolean a(JSONObject paramJSONObject, i parami, String paramString)
  {
    a(paramJSONObject, parami);
    parami.d(ag.a(paramJSONObject, "footerColor", parami.L()));
    parami.e(ag.a(paramJSONObject, "ctaButtonColor", parami.M()));
    parami.f(ag.a(paramJSONObject, "ctaButtonTouchColor", parami.N()));
    parami.g(ag.a(paramJSONObject, "ctaButtonTextColor", parami.O()));
    parami.h(paramJSONObject.optInt("style", parami.Q()));
    parami.e(paramJSONObject.optBoolean("closeOnClick", parami.G()));
    String str1 = paramJSONObject.optString("play_icon_hd");
    if (!TextUtils.isEmpty(str1))
      parami.d(b.a(str1));
    String str2 = paramJSONObject.optString("store_icon_hd");
    if (!TextUtils.isEmpty(str2))
      parami.e(b.a(str2));
    JSONArray localJSONArray = paramJSONObject.optJSONArray("cards");
    if (localJSONArray != null)
    {
      int i = localJSONArray.length();
      int j = 0;
      if (j < i)
      {
        JSONObject localJSONObject3 = localJSONArray.optJSONObject(j);
        com.my.target.b.c.a.f localf;
        if (localJSONObject3 != null)
        {
          localf = com.my.target.b.c.a.f.a(parami);
          localf.a(parami.B());
          this.d.a(localJSONObject3, localf);
          if (!TextUtils.isEmpty(localf.q()))
            break label253;
          a("Required field", "no tracking link in interstitialAdCard", parami.k());
          localf = null;
        }
        while (true)
        {
          if (localf != null)
            parami.a(localf);
          j++;
          break;
          label253: if (localf.l() == null)
          {
            a("Required field", "no image in interstitialAdCard", parami.k());
            localf = null;
          }
          else
          {
            localf.j(localJSONObject3.optString("cardID", localf.k()));
          }
        }
      }
    }
    if (parami.P().isEmpty())
    {
      JSONObject localJSONObject1 = paramJSONObject.optJSONObject("video");
      if (localJSONObject1 != null)
      {
        k localk = k.D();
        localk.j(parami.k());
        if (af.a(this.a, this.b, this.c).a(localJSONObject1, localk))
        {
          parami.a(localk);
          if (localk.K())
          {
            parami.d(localk.P());
            parami.c(localk.O());
          }
        }
        JSONObject localJSONObject2 = paramJSONObject.optJSONObject("endcard");
        if (localJSONObject2 != null)
        {
          g localg = g.H();
          if (a(localJSONObject2, localg, paramString))
            parami.a(localg);
        }
      }
    }
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.cr
 * JD-Core Version:    0.6.2
 */