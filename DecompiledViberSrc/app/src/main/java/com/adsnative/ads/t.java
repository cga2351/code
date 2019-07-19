package com.adsnative.ads;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class t
{
  private u a;
  private HashMap<String, Object> b;

  public u a()
  {
    return this.a;
  }

  public void a(u paramu)
  {
    this.a = paramu;
  }

  public void a(JSONObject paramJSONObject)
    throws JSONException
  {
    this.b = new HashMap();
    this.b.put("playButtonUrl", paramJSONObject.optString("playButtonUrl"));
    this.b.put("closeButtonUrl", paramJSONObject.optString("closeButtonUrl"));
    this.b.put("expandButtonUrl", paramJSONObject.optString("expandButtonUrl"));
    this.b.put("percentVisible", Double.valueOf(paramJSONObject.optDouble("percentVisible")));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.ads.t
 * JD-Core Version:    0.6.2
 */