package com.appboy.e;

import a.a.au;
import a.a.bp;
import a.a.fb;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class i extends f
  implements c
{
  private String j;
  private String k;
  private boolean l = false;
  private String m = null;

  protected i()
  {
    this.g = true;
  }

  public i(JSONObject paramJSONObject, au paramau)
  {
    super(paramJSONObject, paramau);
    if (!com.appboy.f.i.c(paramJSONObject.optString("zipped_assets_url")))
      this.j = paramJSONObject.optString("zipped_assets_url");
    this.g = paramJSONObject.optBoolean("use_webview", true);
  }

  public String B()
  {
    return this.k;
  }

  public String C()
  {
    return this.j;
  }

  public JSONObject E()
  {
    if (this.h != null)
      return this.h;
    try
    {
      JSONObject localJSONObject = super.E();
      localJSONObject.putOpt("zipped_assets_url", this.j);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public void a(String paramString)
  {
    f(paramString);
  }

  public boolean b(String paramString)
  {
    if ((com.appboy.f.i.b(this.b)) && (com.appboy.f.i.b(this.c)) && (com.appboy.f.i.b(this.d)))
    {
      com.appboy.f.c.b(a, "Campaign, card, and trigger Ids not found. Not logging html in-app message click.");
      return false;
    }
    if (com.appboy.f.i.c(paramString))
    {
      com.appboy.f.c.c(a, "Button Id was null or blank for this html in-app message. Ignoring.");
      return false;
    }
    if (this.l)
    {
      com.appboy.f.c.c(a, "Button click already logged for this html in-app message. Ignoring.");
      return false;
    }
    if (this.i == null)
    {
      com.appboy.f.c.e(a, "Cannot log an html in-app message button click because the AppboyManager is null.");
      return false;
    }
    try
    {
      bp localbp = bp.a(this.b, this.c, this.d, paramString);
      this.i.a(localbp);
      this.m = paramString;
      this.l = true;
      return true;
    }
    catch (JSONException localJSONException)
    {
      this.i.a(localJSONException);
    }
    return false;
  }

  public void f(String paramString)
  {
    this.k = paramString;
  }

  public String s()
  {
    return C();
  }

  public void z()
  {
    super.z();
    if ((this.l) && (!com.appboy.f.i.c(this.d)) && (!com.appboy.f.i.c(this.m)))
      this.i.a(new fb(this.d, this.m));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.e.i
 * JD-Core Version:    0.6.2
 */