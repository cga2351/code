package com.my.target;

import org.json.JSONException;
import org.json.JSONObject;

public class dv extends ds
{
  public dv(JSONObject paramJSONObject)
    throws JSONException
  {
    super("init");
    this.a.put("bannersJSON", paramJSONObject);
    this.a.put("version", 20);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.dv
 * JD-Core Version:    0.6.2
 */