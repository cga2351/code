package com.appboy.e;

import a.a.au;
import a.a.bp;
import a.a.dr;
import a.a.fb;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import com.appboy.b.a.a;
import com.appboy.b.a.e;
import com.appboy.b.a.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class f
  implements b
{
  protected static final String a = com.appboy.f.c.a(f.class);
  private boolean A = false;
  private boolean B = false;
  private boolean C = false;
  private boolean D = false;
  private String E;
  private long F = -1L;
  String b;
  String c;
  String d;
  protected com.appboy.b.a.b e = com.appboy.b.a.b.a;
  protected com.appboy.b.a.i f = com.appboy.b.a.i.b;
  protected boolean g = false;
  protected JSONObject h;
  protected au i;
  private String j;
  private Map<String, String> k;
  private boolean l = true;
  private boolean m = true;
  private a n = a.c;
  private Uri o;
  private com.appboy.b.a.c p = com.appboy.b.a.c.a;
  private int q = 5000;
  private String r;
  private String s;
  private g t = g.c;
  private Bitmap u;
  private boolean v = false;
  private int w = -1;
  private int x = Color.parseColor("#555555");
  private int y = -1;
  private int z = Color.parseColor("#ff0073d5");

  protected f()
  {
  }

  private f(String paramString1, Map<String, String> paramMap, boolean paramBoolean1, boolean paramBoolean2, a parama, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4, com.appboy.b.a.c paramc, int paramInt5, String paramString5, String paramString6, String paramString7, boolean paramBoolean3, boolean paramBoolean4, g paramg, boolean paramBoolean5, boolean paramBoolean6, JSONObject paramJSONObject, au paramau)
  {
    this.j = paramString1;
    this.k = paramMap;
    this.l = paramBoolean1;
    this.m = paramBoolean2;
    this.n = parama;
    if ((this.n == a.b) && (!com.appboy.f.i.c(paramString2)))
      this.o = Uri.parse(paramString2);
    if (paramc == com.appboy.b.a.c.b);
    for (this.p = com.appboy.b.a.c.c; ; this.p = paramc)
    {
      a(paramInt5);
      this.w = paramInt1;
      this.y = paramInt2;
      this.z = paramInt3;
      this.x = paramInt4;
      this.r = paramString3;
      this.s = paramString4;
      this.t = paramg;
      this.b = paramString5;
      this.c = paramString6;
      this.d = paramString7;
      this.A = paramBoolean3;
      this.B = paramBoolean4;
      this.g = paramBoolean5;
      this.D = paramBoolean6;
      this.h = paramJSONObject;
      this.i = paramau;
      return;
    }
  }

  public f(JSONObject paramJSONObject, au paramau)
  {
    this(paramJSONObject.optString("message"), dr.a(paramJSONObject.optJSONObject("extras"), new HashMap()), paramJSONObject.optBoolean("animate_in", true), paramJSONObject.optBoolean("animate_out", true), (a)dr.a(paramJSONObject, "click_action", a.class, a.c), paramJSONObject.optString("uri"), paramJSONObject.optInt("bg_color"), paramJSONObject.optInt("icon_color"), paramJSONObject.optInt("icon_bg_color"), paramJSONObject.optInt("text_color"), paramJSONObject.optString("icon"), paramJSONObject.optString("image_url"), (com.appboy.b.a.c)dr.a(paramJSONObject, "message_close", com.appboy.b.a.c.class, com.appboy.b.a.c.a), paramJSONObject.optInt("duration"), paramJSONObject.optString("campaign_id"), paramJSONObject.optString("card_id"), paramJSONObject.optString("trigger_id"), false, false, (g)dr.a(paramJSONObject, "orientation", g.class, g.c), paramJSONObject.optBoolean("use_webview", false), paramJSONObject.optBoolean("is_control"), paramJSONObject, paramau);
  }

  public boolean A()
  {
    return this.D;
  }

  public com.appboy.b.a.i D()
  {
    return this.f;
  }

  public JSONObject E()
  {
    if (this.h != null)
      return this.h;
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.putOpt("message", this.j);
      localJSONObject1.put("duration", this.q);
      localJSONObject1.putOpt("campaign_id", this.b);
      localJSONObject1.putOpt("card_id", this.c);
      localJSONObject1.putOpt("trigger_id", this.d);
      localJSONObject1.putOpt("click_action", this.n.toString());
      localJSONObject1.putOpt("message_close", this.p.toString());
      if (this.o != null)
        localJSONObject1.put("uri", this.o.toString());
      localJSONObject1.put("use_webview", this.g);
      localJSONObject1.put("animate_in", this.l);
      localJSONObject1.put("animate_out", this.m);
      localJSONObject1.put("bg_color", this.w);
      localJSONObject1.put("text_color", this.x);
      localJSONObject1.put("icon_color", this.y);
      localJSONObject1.put("icon_bg_color", this.z);
      localJSONObject1.putOpt("icon", this.r);
      localJSONObject1.putOpt("image_url", this.s);
      localJSONObject1.putOpt("crop_type", this.e.toString());
      localJSONObject1.putOpt("orientation", this.t.toString());
      localJSONObject1.putOpt("text_align_message", this.f.toString());
      localJSONObject1.putOpt("is_control", Boolean.valueOf(this.D));
      if (this.k != null)
      {
        JSONObject localJSONObject2 = new JSONObject();
        Iterator localIterator = this.k.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localJSONObject2.put(str, this.k.get(str));
        }
        localJSONObject1.put("extras", localJSONObject2);
      }
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public String a()
  {
    return this.j;
  }

  public void a(int paramInt)
  {
    if (paramInt < 999)
    {
      this.q = 5000;
      com.appboy.f.c.d(a, "Requested in-app message duration " + paramInt + " is lower than the minimum of " + 999 + ". Defaulting to " + this.q + " milliseconds.");
      return;
    }
    this.q = paramInt;
    com.appboy.f.c.b(a, "Set in-app message duration to " + this.q + " milliseconds.");
  }

  public void a(long paramLong)
  {
    this.F = paramLong;
  }

  public void a(Bitmap paramBitmap)
  {
    this.u = paramBitmap;
  }

  public void a(com.appboy.b.a.c paramc)
  {
    this.p = paramc;
  }

  public void a(String paramString)
  {
    e(paramString);
  }

  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }

  public boolean a(a parama)
  {
    if (parama != a.b)
    {
      this.n = parama;
      this.o = null;
      return true;
    }
    com.appboy.f.c.e(a, "A non-null URI is required in order to set the message ClickAction to URI.");
    return false;
  }

  public boolean a(a parama, Uri paramUri)
  {
    if ((paramUri == null) && (parama == a.b))
    {
      com.appboy.f.c.e(a, "A non-null URI is required in order to set the message ClickAction to URI.");
      return false;
    }
    if ((paramUri != null) && (parama == a.b))
    {
      this.n = parama;
      this.o = paramUri;
      return true;
    }
    return a(parama);
  }

  public boolean a(e parame)
  {
    if ((com.appboy.f.i.c(this.b)) && (com.appboy.f.i.c(this.c)) && (com.appboy.f.i.c(this.d)))
    {
      com.appboy.f.c.b(a, "Campaign, card, and trigger Ids not found. Not logging in-app message display failure.");
      return false;
    }
    if (this.C)
    {
      com.appboy.f.c.c(a, "Display failure already logged for this in-app message. Ignoring.");
      return false;
    }
    if (this.B)
    {
      com.appboy.f.c.c(a, "Click already logged for this in-app message. Ignoring.");
      return false;
    }
    if (this.A)
    {
      com.appboy.f.c.c(a, "Impression already logged for this in-app message. Ignoring.");
      return false;
    }
    if (this.i == null)
    {
      com.appboy.f.c.e(a, "Cannot log an in-app message display failure because the AppboyManager is null.");
      return false;
    }
    try
    {
      bp localbp = bp.a(this.b, this.c, this.d, parame);
      this.i.a(localbp);
      this.C = true;
      return true;
    }
    catch (JSONException localJSONException)
    {
      this.i.a(localJSONException);
    }
    return false;
  }

  public Map<String, String> b()
  {
    return this.k;
  }

  public void b(int paramInt)
  {
    this.y = paramInt;
  }

  public void b(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }

  public int c()
  {
    return this.q;
  }

  public void c(String paramString)
  {
    this.j = paramString;
  }

  public void c(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }

  public int d()
  {
    return this.w;
  }

  public void d(String paramString)
  {
    this.r = paramString;
  }

  public int e()
  {
    return this.y;
  }

  public void e(String paramString)
  {
    this.E = paramString;
  }

  public int f()
  {
    return this.z;
  }

  public int g()
  {
    return this.x;
  }

  public String i()
  {
    return this.r;
  }

  public String j()
  {
    return this.s;
  }

  public String k()
  {
    return this.E;
  }

  public boolean l()
  {
    return this.l;
  }

  public boolean m()
  {
    return this.m;
  }

  public a n()
  {
    return this.n;
  }

  public Uri o()
  {
    return this.o;
  }

  public Bitmap p()
  {
    return this.u;
  }

  public com.appboy.b.a.c q()
  {
    return this.p;
  }

  public boolean r()
  {
    return this.v;
  }

  public String s()
  {
    return j();
  }

  public g t()
  {
    return this.t;
  }

  public com.appboy.b.a.b u()
  {
    return this.e;
  }

  public long v()
  {
    return this.F;
  }

  public boolean w()
  {
    return this.g;
  }

  public boolean x()
  {
    if ((com.appboy.f.i.b(this.b)) && (com.appboy.f.i.b(this.c)) && (com.appboy.f.i.b(this.d)))
    {
      com.appboy.f.c.b(a, "Campaign, card, and trigger Ids not found. Not logging in-app message impression.");
      return false;
    }
    if (this.A)
    {
      com.appboy.f.c.c(a, "Impression already logged for this in-app message. Ignoring.");
      return false;
    }
    if (this.C)
    {
      com.appboy.f.c.c(a, "Display failure already logged for this in-app message. Ignoring.");
      return false;
    }
    if (this.i == null)
    {
      com.appboy.f.c.e(a, "Cannot log an in-app message impression because the AppboyManager is null.");
      return false;
    }
    try
    {
      bp localbp = bp.b(this.b, this.c, this.d);
      this.i.a(localbp);
      this.A = true;
      return true;
    }
    catch (JSONException localJSONException)
    {
      this.i.a(localJSONException);
    }
    return false;
  }

  public boolean y()
  {
    if ((com.appboy.f.i.c(this.b)) && (com.appboy.f.i.c(this.c)) && (com.appboy.f.i.c(this.d)))
    {
      com.appboy.f.c.b(a, "Campaign, card, and trigger Ids not found. Not logging in-app message click.");
      return false;
    }
    if (this.B)
    {
      com.appboy.f.c.c(a, "Click already logged for this in-app message. Ignoring.");
      return false;
    }
    if (this.C)
    {
      com.appboy.f.c.c(a, "Display failure already logged for this in-app message. Ignoring.");
      return false;
    }
    if (this.i == null)
    {
      com.appboy.f.c.e(a, "Cannot log an in-app message click because the AppboyManager is null.");
      return false;
    }
    try
    {
      bp localbp = bp.c(this.b, this.c, this.d);
      this.i.a(localbp);
      this.B = true;
      return true;
    }
    catch (JSONException localJSONException)
    {
      this.i.a(localJSONException);
    }
    return false;
  }

  public void z()
  {
    if ((this.B) && (!com.appboy.f.i.b(this.d)))
      this.i.a(new fb(this.d));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.e.f
 * JD-Core Version:    0.6.2
 */