package com.appboy.b;

import a.a.dr;
import com.appboy.f.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public enum c
{
  private static final String I;
  private static final Map<String, d> J;
  private String K;
  private String L;

  static
  {
    A = new c("TEXT_ANNOUNCEMENT_DESCRIPTION", 26, "description", "ds");
    B = new c("TEXT_ANNOUNCEMENT_URL", 27, "url", "u");
    C = new c("TEXT_ANNOUNCEMENT_DOMAIN", 28, "domain", "dm");
    D = new c("SHORT_NEWS_IMAGE", 29, "image", "i");
    E = new c("SHORT_NEWS_TITLE", 30, "title", "tt");
    F = new c("SHORT_NEWS_DESCRIPTION", 31, "description", "ds");
    G = new c("SHORT_NEWS_URL", 32, "url", "u");
    H = new c("SHORT_NEWS_DOMAIN", 33, "domain", "dm");
    c[] arrayOfc = new c[34];
    arrayOfc[0] = a;
    arrayOfc[1] = b;
    arrayOfc[2] = c;
    arrayOfc[3] = d;
    arrayOfc[4] = e;
    arrayOfc[5] = f;
    arrayOfc[6] = g;
    arrayOfc[7] = h;
    arrayOfc[8] = i;
    arrayOfc[9] = j;
    arrayOfc[10] = k;
    arrayOfc[11] = l;
    arrayOfc[12] = m;
    arrayOfc[13] = n;
    arrayOfc[14] = o;
    arrayOfc[15] = p;
    arrayOfc[16] = q;
    arrayOfc[17] = r;
    arrayOfc[18] = s;
    arrayOfc[19] = t;
    arrayOfc[20] = u;
    arrayOfc[21] = v;
    arrayOfc[22] = w;
    arrayOfc[23] = x;
    arrayOfc[24] = y;
    arrayOfc[25] = z;
    arrayOfc[26] = A;
    arrayOfc[27] = B;
    arrayOfc[28] = C;
    arrayOfc[29] = D;
    arrayOfc[30] = E;
    arrayOfc[31] = F;
    arrayOfc[32] = G;
    arrayOfc[33] = H;
    M = arrayOfc;
    I = com.appboy.f.c.a(c.class);
    J = new HashMap();
    J.put("banner_image", d.a);
    J.put("captioned_image", d.b);
    J.put("text_announcement", d.e);
    J.put("short_news", d.d);
    J.put("control", d.f);
  }

  private c(String paramString1, String paramString2)
  {
    this.K = paramString1;
    this.L = paramString2;
  }

  public String a()
  {
    return this.L;
  }

  public String b()
  {
    return this.K;
  }

  public static class a
  {
    private final boolean a;

    public a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }

    public d a(JSONObject paramJSONObject)
    {
      String str = paramJSONObject.optString(a(c.g), null);
      if ((!i.b(str)) && (this.a) && (str.equals("short_news")) && (i.b(dr.a(paramJSONObject, a(c.D)))))
      {
        com.appboy.f.c.a(c.c(), "Short News card doesn't contain image url, parsing type as Text Announcement");
        str = "text_announcement";
      }
      if (c.d().containsKey(str))
        return (d)c.d().get(str);
      return d.c;
    }

    public String a(c paramc)
    {
      if (this.a)
        return paramc.a();
      return paramc.b();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.b.c
 * JD-Core Version:    0.6.2
 */