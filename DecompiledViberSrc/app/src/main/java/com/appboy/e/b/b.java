package com.appboy.e.b;

import com.appboy.e.e;
import com.appboy.f.c;
import com.appboy.f.i;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  implements e<JSONObject>
{
  private static final String a = c.a(b.class);
  private final String b;
  private final String c;
  private final String d;
  private final String e;

  public b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
  }

  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (!i.c(this.b))
        localJSONObject.put("source", this.b);
      if (!i.c(this.c))
        localJSONObject.put("campaign", this.c);
      if (!i.c(this.d))
        localJSONObject.put("adgroup", this.d);
      if (!i.c(this.e))
        localJSONObject.put("ad", this.e);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      c.d(a, "Caught exception creating AttributionData Json.", localJSONException);
    }
    return localJSONObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.e.b.b
 * JD-Core Version:    0.6.2
 */