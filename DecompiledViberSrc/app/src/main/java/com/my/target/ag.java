package com.my.target;

import android.graphics.Color;
import android.text.TextUtils;
import org.json.JSONObject;

public class ag
{
  public static int a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    String str = paramJSONObject.optString(paramString);
    if (TextUtils.isEmpty(str))
      return paramInt;
    try
    {
      int i = Color.parseColor(str);
      return i;
    }
    catch (Exception localException)
    {
      dp.b("error parsing color " + str);
    }
    return paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.ag
 * JD-Core Version:    0.6.2
 */