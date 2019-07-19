package com.my.target;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class ds
  implements du
{
  JSONObject a = new JSONObject();
  private final String b;
  private final JSONObject c = new JSONObject();

  public ds(String paramString)
    throws JSONException
  {
    this.b = paramString;
    this.c.put("method", paramString);
    this.c.put("data", this.a);
  }

  public JSONObject a()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.ds
 * JD-Core Version:    0.6.2
 */