package com.my.target;

import android.os.Build.VERSION;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class dw extends ds
{
  public dw(String paramString, String[] paramArrayOfString, int paramInt)
    throws JSONException
  {
    super("start");
    this.a.put("format", paramString);
    this.a.put("orientation", paramInt);
    this.a.put("rotation", false);
    JSONArray localJSONArray;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      if (Build.VERSION.SDK_INT < 19)
        break label101;
      localJSONArray = new JSONArray(paramArrayOfString);
    }
    while (true)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("excludeBanners", localJSONArray);
      this.a.put("filter", localJSONObject);
      return;
      label101: localJSONArray = new JSONArray();
      int j = paramArrayOfString.length;
      while (i < j)
      {
        localJSONArray.put(paramArrayOfString[i]);
        i++;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.dw
 * JD-Core Version:    0.6.2
 */