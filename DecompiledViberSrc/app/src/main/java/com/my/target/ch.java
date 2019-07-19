package com.my.target;

import android.content.Context;
import android.text.TextUtils;
import com.my.target.b.c.a.c;
import com.my.target.b.c.a.d;
import com.my.target.common.a.b;
import org.json.JSONObject;

public final class ch
{
  private final f a;
  private final z b;
  private final Context c;
  private final ae d;

  private ch(f paramf, z paramz, Context paramContext)
  {
    this.a = paramf;
    this.b = paramz;
    this.c = paramContext;
    this.d = ae.a(paramf, paramz, paramContext);
  }

  public static ch a(f paramf, z paramz, Context paramContext)
  {
    return new ch(paramf, paramz, paramContext);
  }

  public final boolean a(JSONObject paramJSONObject, c paramc, String paramString)
  {
    this.d.a(paramJSONObject, paramc);
    int n;
    label38: String str1;
    int m;
    label147: int i;
    if (paramJSONObject.has("timeout"))
    {
      n = paramJSONObject.optInt("timeout");
      if (n >= 5)
        paramc.d(n);
    }
    else
    {
      str1 = paramc.r();
      paramc.E().b(this.b.b());
      JSONObject localJSONObject = paramJSONObject.optJSONObject("view");
      if (localJSONObject != null)
      {
        d locald = paramc.E();
        locald.a(localJSONObject.optString("type", locald.a()));
        locald.a(ag.a(localJSONObject, "backgroundColor", locald.h()));
        locald.b(ag.a(localJSONObject, "backgroundTouchColor", locald.i()));
        if (!this.b.b().equals("standard_300x250"))
          break label603;
        m = -16777216;
        locald.c(ag.a(localJSONObject, "titleColor", m));
        locald.d(ag.a(localJSONObject, "ageRestrictionsBackgroundColor", locald.k()));
        locald.e(ag.a(localJSONObject, "ageRestrictionsTextColor", locald.l()));
        locald.f(ag.a(localJSONObject, "ageRestrictionsBorderColor", locald.m()));
        locald.g(ag.a(localJSONObject, "descriptionColor", locald.n()));
        locald.h(ag.a(localJSONObject, "domainColor", locald.o()));
        locald.i(ag.a(localJSONObject, "votesColor", locald.p()));
        locald.j(ag.a(localJSONObject, "disclaimerColor", locald.q()));
        locald.k(ag.a(localJSONObject, "ctaButtonColor", locald.r()));
        locald.l(ag.a(localJSONObject, "ctaButtonTouchColor", locald.s()));
        locald.m(ag.a(localJSONObject, "ctaButtonTextColor", locald.t()));
        locald.a(localJSONObject.optBoolean("titleBold", locald.b()));
        locald.b(localJSONObject.optBoolean("descriptionBold", locald.c()));
        locald.c(localJSONObject.optBoolean("domainBold", locald.d()));
        locald.d(localJSONObject.optBoolean("votesBold", locald.e()));
        locald.e(localJSONObject.optBoolean("disclaimerBold", locald.f()));
        locald.f(localJSONObject.optBoolean("ctaButtonTextBold", locald.g()));
      }
      i = -1;
      switch (str1.hashCode())
      {
      default:
      case -877706672:
      case 3213227:
      case -1396342996:
      }
    }
    while (true)
      switch (i)
      {
      default:
        dp.a("Unknown banner type: '" + str1 + "'");
        return false;
        String str6 = "Wrong banner timeout: " + n;
        String str7 = paramc.k();
        y.a("Required field").b(str6).a(this.b.c()).d(str7).c(this.a.f()).a(this.c);
        break label38;
        label603: m = -16755546;
        break label147;
        if (str1.equals("teaser"))
        {
          i = 0;
          continue;
          if (str1.equals("html"))
          {
            i = 1;
            continue;
            if (str1.equals("banner"))
              i = 2;
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      }
    paramc.a(paramc.l());
    paramc.b(null);
    String str5 = paramJSONObject.optString("mainImageLink", "");
    int j = paramJSONObject.optInt("mainImageWidth", 0);
    int k = paramJSONObject.optInt("mainImageHeight", 0);
    if (!TextUtils.isEmpty(str5))
      paramc.b(b.a(str5, j, k));
    return true;
    String str2 = paramJSONObject.optString("source", null);
    if (str2 == null)
    {
      y.a("Required field").b("Banner with type 'html' has no source field").d(paramc.k()).c(this.a.f()).a(this.b.c()).a(this.c);
      return false;
    }
    String str3 = bk.a(str2);
    String str4;
    if (!TextUtils.isEmpty(paramString))
    {
      paramc.r(paramString);
      str4 = ae.a(paramString, str3);
      if (str4 != null)
      {
        paramc.q(str4);
        paramc.a("mraid");
      }
    }
    while (!this.d.a(str4, paramJSONObject))
    {
      return false;
      if (paramc.l() != null)
        break;
      y.a("Required field").b("Banner with type 'banner' has no image").d(paramc.k()).c(this.a.f()).a(this.b.c()).a(this.c);
      return false;
      str4 = str3;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.ch
 * JD-Core Version:    0.6.2
 */