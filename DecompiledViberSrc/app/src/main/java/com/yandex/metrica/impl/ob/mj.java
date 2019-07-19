package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class mj
{
  private final JSONObject a = new JSONObject();

  private void a(String paramString1, String paramString2)
  {
    int i;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
      i = 1;
    while (true)
    {
      if (i == 0);
      try
      {
        this.a.put(paramString1, paramString2);
        return;
        i = 0;
      }
      catch (JSONException localJSONException)
      {
      }
    }
  }

  public String a()
    throws JSONException
  {
    return this.a.toString();
  }

  public void a(String paramString)
  {
    a("uuid", paramString);
  }

  public void b(String paramString)
  {
    a("device_id", paramString);
  }

  public void c(String paramString)
  {
    a("google_aid", paramString);
  }

  public void d(String paramString)
  {
    a("android_id", paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.mj
 * JD-Core Version:    0.6.2
 */