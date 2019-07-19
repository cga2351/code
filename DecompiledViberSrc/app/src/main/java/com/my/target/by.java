package com.my.target;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class by<T extends l>
{
  static boolean a(String paramString)
  {
    String str = paramString.trim();
    return (str.startsWith("<VAST")) || (str.startsWith("<?xml"));
  }

  private boolean a(JSONObject paramJSONObject)
  {
    try
    {
      String str1 = paramJSONObject.getString("version");
      dp.a("json version: " + str1);
      int i = str1.indexOf(".");
      boolean bool = false;
      String str2;
      if (i > 0)
        str2 = str1.substring(0, i);
      try
      {
        int j = Integer.parseInt(str2, 10);
        bool = false;
        if (j == 2)
          bool = true;
        return bool;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return false;
      }
    }
    catch (JSONException localJSONException)
    {
    }
    return false;
  }

  public abstract T a(String paramString, f paramf, T paramT, z paramz, Context paramContext);

  protected JSONObject a(String paramString, Context paramContext)
  {
    if (paramString != null)
      paramString = paramString.trim();
    if ((paramString != null) && (!"".equals(paramString)))
      dp.a("Converting to JSON...");
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      dp.a("done");
      if (a(localJSONObject))
        return localJSONObject;
      dp.a("invalid json version");
      while (true)
      {
        label56: return null;
        dp.a("parsing ad response: empty data");
      }
    }
    catch (Exception localException)
    {
      break label56;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.by
 * JD-Core Version:    0.6.2
 */