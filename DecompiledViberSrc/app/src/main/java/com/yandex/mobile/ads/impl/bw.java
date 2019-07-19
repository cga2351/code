package com.yandex.mobile.ads.impl;

import android.net.Uri;
import android.text.TextUtils;

public final class bw
{
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString));
    try
    {
      int i = Uri.encode(paramString).length();
      if (i <= 1024)
        return paramString;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(1024);
      arrayOfObject[1] = Integer.valueOf(i);
      fq.b("Exceeded the length of the parameter! The maximum size of the parameter is %s bytes. Current size is %s bytes", arrayOfObject);
      label51: return null;
    }
    catch (Exception localException)
    {
      break label51;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.bw
 * JD-Core Version:    0.6.2
 */