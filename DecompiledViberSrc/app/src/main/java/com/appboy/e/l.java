package com.appboy.e;

import a.a.au;
import a.a.dr;
import com.appboy.b.a.b;
import com.appboy.b.a.d;
import com.appboy.b.a.f;
import org.json.JSONException;
import org.json.JSONObject;

public class l extends k
{
  public l()
  {
  }

  public l(JSONObject paramJSONObject, au paramau)
  {
    super(paramJSONObject, paramau);
    if (this.j.equals(d.a))
    {
      this.e = ((b)dr.a(paramJSONObject, "crop_type", b.class, b.b));
      return;
    }
    this.e = ((b)dr.a(paramJSONObject, "crop_type", b.class, b.a));
  }

  public JSONObject E()
  {
    if (this.h != null)
      return this.h;
    try
    {
      JSONObject localJSONObject = super.E();
      localJSONObject.put("type", f.b.name());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.e.l
 * JD-Core Version:    0.6.2
 */