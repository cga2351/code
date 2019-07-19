package com.yandex.metrica.impl;

import android.os.Build;
import android.os.Build.VERSION;

public class bn
{
  public static String a()
  {
    String str = "3.4.0";
    if (str.length() - str.indexOf('.') < 3)
      str = str + "0";
    return str;
  }

  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramString).append("/").append(a()).append(".13097 (");
    if (Build.MODEL.startsWith(Build.MANUFACTURER));
    for (String str = bu.b(Build.MODEL); ; str = bu.b(Build.MANUFACTURER) + " " + Build.MODEL)
      return str + "; Android " + Build.VERSION.RELEASE + ")";
  }

  public static String b()
  {
    return a.a;
  }

  public static boolean b(String paramString)
  {
    try
    {
      Class localClass = Class.forName(paramString);
      boolean bool = false;
      if (localClass != null)
        bool = true;
      return bool;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    return false;
  }

  static class a
  {
    static final String a = new a().a();

    String a()
    {
      String str = "native";
      if (a("com.unity3d.player.UnityPlayer"))
        str = "unity";
      do
      {
        return str;
        if (a("mono.MonoPackageManager"))
          return "xamarin";
        if (a("org.apache.cordova.CordovaPlugin"))
          return "cordova";
      }
      while (!a("com.facebook.react.ReactRootView"));
      return "react";
    }

    boolean a(String paramString)
    {
      return bn.b(paramString);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.bn
 * JD-Core Version:    0.6.2
 */