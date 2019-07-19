package com.viber.voip.stickers.entity;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.market.g;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private static final Logger b = ViberEnv.getLogger();
  public String[] a;
  private String c;
  private String d;
  private a e;
  private long f;

  public static c a(g paramg)
  {
    c localc = new c();
    localc.b(paramg.c);
    localc.c(paramg.d);
    localc.a(paramg.f);
    if (paramg.e.equalsIgnoreCase(g.a));
    for (a locala = a.b; ; locala = a.a)
    {
      localc.a(locala);
      return localc;
    }
  }

  public static c a(String paramString)
  {
    return d(paramString);
  }

  private static c d(String paramString)
  {
    int i = 0;
    c localc = new c();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localc.a(localJSONObject.optLong("weight"));
      localc.b(localJSONObject.optString("name"));
      localc.c(localJSONObject.optString("price"));
      if (localJSONObject.has("offerType"))
        if (!"free".equals(localJSONObject.getString("offerType")))
          break label106;
      JSONArray localJSONArray;
      label106: for (a locala = a.a; ; locala = a.b)
      {
        localc.a(locala);
        localJSONArray = localJSONObject.optJSONArray("formats");
        if (localJSONArray != null)
          break;
        localc.a(new String[0]);
        return localc;
      }
      String[] arrayOfString = new String[localJSONArray.length()];
      while (i < localJSONArray.length())
      {
        arrayOfString[i] = localJSONArray.getString(i);
        i++;
      }
      localc.a(arrayOfString);
      return localc;
    }
    catch (JSONException localJSONException)
    {
    }
    return localc;
  }

  public String a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.putOpt("weight", Long.valueOf(e()));
      localJSONObject.putOpt("name", b());
      localJSONObject.putOpt("price", c());
      if (d() != null)
        localJSONObject.put("offerType", d().name());
      if ((f() != null) && (f().length > 0))
        localJSONObject.put("formats", new JSONArray(Arrays.asList(f())));
      String str = localJSONObject.toString();
      return str;
    }
    catch (JSONException localJSONException)
    {
    }
    return "{}";
  }

  public void a(long paramLong)
  {
    this.f = paramLong;
  }

  public void a(a parama)
  {
    this.e = parama;
  }

  public void a(String[] paramArrayOfString)
  {
    this.a = paramArrayOfString;
  }

  public String b()
  {
    return this.c;
  }

  public void b(String paramString)
  {
    this.c = paramString;
  }

  public String c()
  {
    return this.d;
  }

  public void c(String paramString)
  {
    this.d = paramString;
  }

  public a d()
  {
    return this.e;
  }

  public long e()
  {
    return this.f;
  }

  public String[] f()
  {
    return this.a;
  }

  public String toString()
  {
    return "StickerPackageInfo{mName='" + this.c + '\'' + ", mPrice='" + this.d + '\'' + ", mOfferType=" + this.e + ", mWeight=" + this.f + ", formats=" + Arrays.toString(this.a) + '}';
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.entity.c
 * JD-Core Version:    0.6.2
 */