package com.appboy.e;

import a.a.au;
import a.a.dr;
import android.graphics.Color;
import com.appboy.b.a.b;
import com.appboy.b.a.h;
import com.appboy.b.a.i;
import org.json.JSONException;
import org.json.JSONObject;

public class m extends f
{
  private h j = h.b;
  private int k = Color.parseColor("#9B9B9B");

  public m()
  {
    this.f = i.a;
  }

  public m(JSONObject paramJSONObject, au paramau)
  {
    this(paramJSONObject, paramau, (h)dr.a(paramJSONObject, "slide_from", h.class, h.b), paramJSONObject.optInt("close_btn_color"));
  }

  private m(JSONObject paramJSONObject, au paramau, h paramh, int paramInt)
  {
    super(paramJSONObject, paramau);
    this.j = paramh;
    if (this.j == null)
      this.j = h.b;
    this.k = paramInt;
    this.e = ((b)dr.a(paramJSONObject, "crop_type", b.class, b.a));
    this.f = ((i)dr.a(paramJSONObject, "text_align_message", i.class, i.a));
  }

  public h B()
  {
    return this.j;
  }

  public int C()
  {
    return this.k;
  }

  public JSONObject E()
  {
    if (this.h != null)
      return this.h;
    try
    {
      JSONObject localJSONObject = super.E();
      localJSONObject.putOpt("slide_from", this.j.toString());
      localJSONObject.put("close_btn_color", this.k);
      localJSONObject.put("type", com.appboy.b.a.f.a.name());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public void a(h paramh)
  {
    this.j = paramh;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.e.m
 * JD-Core Version:    0.6.2
 */