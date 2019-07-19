package com.my.target;

import android.content.Context;
import android.text.TextUtils;
import com.my.target.common.a.b;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class ae
{
  private final Context a;
  private final f b;
  private final z c;
  private final ah d;
  private String e;

  private ae(f paramf, z paramz, Context paramContext)
  {
    this.b = paramf;
    this.c = paramz;
    this.a = paramContext;
    this.d = ah.a(paramf, paramz, paramContext);
  }

  public static ae a(f paramf, z paramz, Context paramContext)
  {
    return new ae(paramf, paramz, paramContext);
  }

  public static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)));
    StringBuilder localStringBuilder;
    Matcher localMatcher;
    do
    {
      do
      {
        return null;
        localStringBuilder = new StringBuilder(paramString2);
      }
      while (localStringBuilder.length() <= 0);
      localMatcher = Pattern.compile("<script\\s+[^>]*\\bsrc\\s*=\\s*(\\\\?[\\\"\\'])mraid\\.js\\1[^>]*>\\s*<\\/script>\\n*", 2).matcher(paramString2);
    }
    while (!localMatcher.find());
    int i = localMatcher.start();
    localStringBuilder.delete(i, localMatcher.end());
    localStringBuilder.insert(i, "<script src=\"" + paramString1 + "\"></script>");
    return localStringBuilder.toString();
  }

  private void b(String paramString1, String paramString2)
  {
    y.a(paramString1).b(paramString2).a(this.c.c()).d(this.e).c(this.b.f()).a(this.a);
  }

  public void a(JSONObject paramJSONObject, i parami)
  {
    this.e = paramJSONObject.optString("id");
    if (TextUtils.isEmpty(this.e))
      this.e = paramJSONObject.optString("bannerID", parami.k());
    parami.j(this.e);
    String str1 = paramJSONObject.optString("type");
    if (!TextUtils.isEmpty(str1))
      parami.a(str1);
    parami.c(paramJSONObject.optInt("width", parami.u()));
    parami.a(paramJSONObject.optInt("height", parami.i()));
    String str2 = paramJSONObject.optString("ageRestrictions");
    if (!TextUtils.isEmpty(str2))
      parami.b(str2);
    String str3 = paramJSONObject.optString("deeplink");
    if (!TextUtils.isEmpty(str3))
      parami.f(str3);
    String str4 = paramJSONObject.optString("trackingLink");
    if (!TextUtils.isEmpty(str4))
      parami.n(str4);
    String str5 = paramJSONObject.optString("bundle_id");
    if (!TextUtils.isEmpty(str5))
      parami.c(str5);
    String str6 = paramJSONObject.optString("urlscheme");
    if (!TextUtils.isEmpty(str6))
      parami.o(str6);
    parami.b(paramJSONObject.optBoolean("openInBrowser", parami.w()));
    parami.c(paramJSONObject.optBoolean("usePlayStoreAction", parami.x()));
    parami.a(paramJSONObject.optBoolean("directLink", parami.v()));
    String str7 = paramJSONObject.optString("navigationType");
    float f;
    label485: int n;
    if (!TextUtils.isEmpty(str7))
    {
      if ("deeplink".equals(str7))
        parami.k("store");
    }
    else
    {
      String str8 = paramJSONObject.optString("title");
      if (!TextUtils.isEmpty(str8))
        parami.m(str8);
      String str9 = paramJSONObject.optString("description");
      if (!TextUtils.isEmpty(str9))
        parami.g(str9);
      String str10 = paramJSONObject.optString("disclaimer");
      if (!TextUtils.isEmpty(str10))
        parami.h(str10);
      parami.b(paramJSONObject.optInt("votes", parami.t()));
      String str11 = paramJSONObject.optString("category");
      if (!TextUtils.isEmpty(str11))
        parami.d(str11);
      String str12 = paramJSONObject.optString("subcategory");
      if (!TextUtils.isEmpty(str12))
        parami.l(str12);
      String str13 = paramJSONObject.optString("domain");
      if (!TextUtils.isEmpty(str13))
        parami.i(str13);
      parami.b((float)paramJSONObject.optDouble("duration", parami.A()));
      if (paramJSONObject.has("rating"))
      {
        f = (float)paramJSONObject.optDouble("rating", -1.0D);
        if ((f > 5.0D) || (f < 0.0D))
          break label756;
        parami.a(f);
      }
      parami.e(paramJSONObject.optString("ctaText", parami.d()));
      String str14 = paramJSONObject.optString("iconLink");
      int i = paramJSONObject.optInt("iconWidth");
      int j = paramJSONObject.optInt("iconHeight");
      if (!TextUtils.isEmpty(str14))
        parami.a(b.a(str14, i, j));
      String str15 = paramJSONObject.optString("imageLink");
      int k = paramJSONObject.optInt("imageWidth");
      int m = paramJSONObject.optInt("imageHeight");
      if (!TextUtils.isEmpty(str15))
        parami.b(b.a(str15, k, m));
      if (!paramJSONObject.has("clickArea"))
        break label799;
      n = paramJSONObject.optInt("clickArea");
      if (n > 0)
        break label787;
      b("Bad value", "Bad ClickArea mask " + n);
    }
    while (true)
    {
      parami.p(paramJSONObject.optString("advertisingLabel", ""));
      JSONObject localJSONObject = paramJSONObject.optJSONObject("adChoices");
      if (localJSONObject != null)
      {
        String str16 = localJSONObject.optString("iconLink");
        String str17 = localJSONObject.optString("clickLink");
        if ((!TextUtils.isEmpty(str16)) && (!TextUtils.isEmpty(str17)))
          parami.a(e.a(b.a(str16), str17));
      }
      this.d.a(parami.y(), paramJSONObject, this.e, parami.A());
      return;
      parami.k(str7);
      break;
      label756: b("Bad value", "unable to parse rating " + f);
      break label485;
      label787: parami.a(g.a(n));
      continue;
      label799: if (paramJSONObject.has("extendedClickArea"))
        if (paramJSONObject.optBoolean("extendedClickArea", true))
          parami.a(g.a);
        else
          parami.a(g.b);
    }
  }

  public boolean a(String paramString, JSONObject paramJSONObject)
  {
    paramJSONObject.remove("source");
    try
    {
      paramJSONObject.put("source", paramString);
      return true;
    }
    catch (JSONException localJSONException)
    {
      b("Json error", "Unable to re-encode source of html banner");
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.ae
 * JD-Core Version:    0.6.2
 */