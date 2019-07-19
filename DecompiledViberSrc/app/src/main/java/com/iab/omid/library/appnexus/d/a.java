package com.iab.omid.library.appnexus.d;

import android.os.Build;
import android.os.Build.VERSION;
import org.json.JSONObject;

public final class a
{
  public static String a()
  {
    return Build.MANUFACTURER + "; " + Build.MODEL;
  }

  public static String b()
  {
    return Integer.toString(Build.VERSION.SDK_INT);
  }

  public static String c()
  {
    return "Android";
  }

  public static JSONObject d()
  {
    JSONObject localJSONObject = new JSONObject();
    b.a(localJSONObject, "deviceType", a());
    b.a(localJSONObject, "osVersion", b());
    b.a(localJSONObject, "os", c());
    return localJSONObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.d.a
 * JD-Core Version:    0.6.2
 */