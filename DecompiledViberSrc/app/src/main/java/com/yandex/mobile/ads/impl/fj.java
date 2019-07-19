package com.yandex.mobile.ads.impl;

import android.os.Build;
import android.os.Build.VERSION;

final class fj
{
  static String a()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("com.yandex.mobile.metrica.ads.sdk/");
    StringBuilder localStringBuilder2 = new StringBuilder("2.81");
    if (localStringBuilder2.length() - localStringBuilder2.indexOf(".") < 3)
      localStringBuilder2.append("0");
    return localStringBuilder2.toString() + ".17";
  }

  static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder("(");
    if (Build.MODEL.startsWith(Build.MANUFACTURER));
    for (String str = fo.a(Build.MODEL); ; str = fo.a(Build.MANUFACTURER) + " " + Build.MODEL)
      return str + "; Android " + Build.VERSION.RELEASE + ")";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.fj
 * JD-Core Version:    0.6.2
 */