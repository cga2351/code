package com.appboy.e;

import a.a.au;
import com.appboy.b.a.f;
import org.json.JSONException;
import org.json.JSONObject;

public class j extends i
{
  public j()
  {
  }

  public j(JSONObject paramJSONObject, au paramau)
  {
    super(paramJSONObject, paramau);
  }

  public JSONObject E()
  {
    if (this.h != null)
      return this.h;
    try
    {
      JSONObject localJSONObject = super.E();
      localJSONObject.put("type", f.d.name());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.e.j
 * JD-Core Version:    0.6.2
 */