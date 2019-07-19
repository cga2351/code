package com.mixpanel.android.b;

import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  public static String a(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    if ((paramJSONObject.has(paramString)) && (!paramJSONObject.isNull(paramString)))
      return paramJSONObject.getString(paramString);
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.b.e
 * JD-Core Version:    0.6.2
 */