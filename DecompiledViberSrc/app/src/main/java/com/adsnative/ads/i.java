package com.adsnative.ads;

import android.content.Context;
import com.adsnative.b.a;
import com.adsnative.b.a.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class i
{
  private int a = 300000;
  private a b;
  private a.b c;
  private final m d;
  private final String e;
  private final Context f;
  private final q.a g;
  private int h;
  private boolean i;
  private Double j;
  private q.b k;

  public i(String paramString, Context paramContext, q.a parama)
  {
    this.e = paramString;
    this.f = paramContext;
    this.g = parama;
    this.d = null;
    this.j = null;
  }

  private void a(String paramString)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      if (this.d != null)
      {
        JSONObject localJSONObject3 = localJSONObject1.optJSONObject("adPositions");
        if (localJSONObject3 == null)
          break label114;
        a(localJSONObject3);
      }
      while (true)
      {
        if (localJSONObject1.has("biddingInterval"))
          this.j = Double.valueOf(localJSONObject1.optDouble("biddingInterval"));
        String str = localJSONObject1.optString("layout");
        if ((str != null) && (str.length() > 0))
          this.g.a(str);
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("video");
        if (localJSONObject2 == null)
          break;
        this.g.a(localJSONObject2);
        return;
        label114: com.adsnative.c.i.b("Couldn't find ad postions - placement may not be active");
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }

  private void a(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONArray localJSONArray = paramJSONObject.getJSONArray("fixed");
    int m = paramJSONObject.getJSONObject("repeating").getInt("interval");
    s.a locala = s.a();
    if (localJSONArray != null)
      for (int n = 0; n < localJSONArray.length(); n++)
        locala.a(((JSONObject)localJSONArray.get(n)).getInt("position"));
    locala.b(m);
    if (this.d != null)
    {
      this.d.a(s.a(locala));
      return;
    }
    com.adsnative.c.i.e("Attempted setPositionsExplicit when mServerPositioningSource is null");
  }

  private void c()
  {
    int m = (int)(1000.0D * Math.pow(2.0D, 1 + this.h));
    if (m >= this.a)
      return;
    this.h = (1 + this.h);
    if (this.b != null)
    {
      this.b.a(m);
      return;
    }
    com.adsnative.c.i.e("Attempted makeRequestWithDelay when mAdConfigsRequest is null");
  }

  public void a()
  {
    this.c = new a.b()
    {
      public void a(f paramAnonymousf)
      {
        i.b(i.this);
      }

      public void a(String paramAnonymousString)
      {
        i.a(i.this, paramAnonymousString);
        i.a(i.this, true);
        if (i.a(i.this) != null)
          i.a(i.this).a();
      }
    };
    this.b = new a(this.e, this.f, this.c);
    this.b.a();
  }

  public Double b()
  {
    return this.j;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.ads.i
 * JD-Core Version:    0.6.2
 */