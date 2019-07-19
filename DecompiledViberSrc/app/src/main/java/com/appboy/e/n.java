package com.appboy.e;

import a.a.dr;
import android.graphics.Color;
import android.net.Uri;
import com.appboy.b.a.a;
import com.appboy.f.c;
import com.appboy.f.i;
import org.json.JSONException;
import org.json.JSONObject;

public class n
  implements e<JSONObject>
{
  private static final String a = c.a(n.class);
  private JSONObject b;
  private int c = -1;
  private a d = a.c;
  private Uri e;
  private String f;
  private boolean g;
  private boolean h = false;
  private int i = Color.parseColor("#1B78CF");
  private int j = -1;
  private int k = this.i;

  public n()
  {
  }

  public n(JSONObject paramJSONObject)
  {
    this(paramJSONObject, paramJSONObject.optInt("id", -1), (a)dr.a(paramJSONObject, "click_action", a.class, a.a), paramJSONObject.optString("uri"), paramJSONObject.optString("text"), paramJSONObject.optInt("bg_color"), paramJSONObject.optInt("text_color"), paramJSONObject.optBoolean("use_webview", false), paramJSONObject.optInt("border_color"));
  }

  private n(JSONObject paramJSONObject, int paramInt1, a parama, String paramString1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    this.b = paramJSONObject;
    this.c = paramInt1;
    this.d = parama;
    if ((this.d == a.b) && (!i.c(paramString1)))
      this.e = Uri.parse(paramString1);
    this.f = paramString2;
    this.i = paramInt2;
    this.j = paramInt3;
    this.g = paramBoolean;
    this.k = paramInt4;
  }

  public int a()
  {
    return this.c;
  }

  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }

  public a b()
  {
    return this.d;
  }

  public Uri c()
  {
    return this.e;
  }

  public String d()
  {
    return this.f;
  }

  public int e()
  {
    return this.i;
  }

  public int f()
  {
    return this.j;
  }

  public int g()
  {
    return this.k;
  }

  public boolean i()
  {
    return this.g;
  }

  public JSONObject j()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", this.c);
      localJSONObject.put("click_action", this.d.toString());
      if (this.e != null)
        localJSONObject.put("uri", this.e.toString());
      localJSONObject.putOpt("text", this.f);
      localJSONObject.put("bg_color", this.i);
      localJSONObject.put("text_color", this.j);
      localJSONObject.put("use_webview", this.g);
      localJSONObject.put("border_color", this.k);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.e.n
 * JD-Core Version:    0.6.2
 */