package com.yandex.metrica.impl.ob;

import android.net.Uri;
import android.text.TextUtils;
import com.yandex.metrica.impl.i;
import org.json.JSONObject;

public class cg extends ci
{
  public cg(ab paramab)
  {
    super(paramab);
  }

  private static boolean a(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (!bool1);
    try
    {
      String str1 = Uri.parse(paramString).getQueryParameter("referrer");
      boolean bool3 = TextUtils.isEmpty(str1);
      bool2 = false;
      String[] arrayOfString;
      int i;
      if (!bool3)
      {
        arrayOfString = str1.split("&");
        i = arrayOfString.length;
      }
      for (int j = 0; ; j++)
      {
        bool2 = false;
        if (j < i)
        {
          String str2 = arrayOfString[j];
          int k = str2.indexOf("=");
          if ((k >= 0) && ("reattribution".equals(Uri.decode(str2.substring(0, k)))))
          {
            boolean bool4 = "1".equals(Uri.decode(str2.substring(k + 1)));
            if (bool4)
              bool2 = true;
          }
        }
        else
        {
          return bool2;
        }
      }
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public boolean a(i parami)
  {
    String str = parami.c();
    if (!TextUtils.isEmpty(str));
    try
    {
      JSONObject localJSONObject = new JSONObject(str);
      if (("open".equals(localJSONObject.optString("type"))) && (a(localJSONObject.optString("link"))))
      {
        a().t();
        a().I().a();
      }
      label64: return false;
    }
    catch (Exception localException)
    {
      break label64;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.cg
 * JD-Core Version:    0.6.2
 */