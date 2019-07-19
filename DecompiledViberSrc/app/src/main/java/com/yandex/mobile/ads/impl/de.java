package com.yandex.mobile.ads.impl;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import java.net.IDN;

public final class de
{
  public static String a(String paramString)
  {
    try
    {
      Uri localUri = Uri.parse(paramString);
      String str1 = localUri.getHost();
      if (!TextUtils.isEmpty(str1))
      {
        String str2 = IDN.toASCII(str1);
        if (!str1.equals(str2))
        {
          Uri.Builder localBuilder = localUri.buildUpon();
          StringBuilder localStringBuilder = new StringBuilder();
          String str3 = localUri.getUserInfo();
          if (!TextUtils.isEmpty(str3))
          {
            localStringBuilder.append(str3);
            localStringBuilder.append("@");
          }
          localStringBuilder.append(str2);
          int i = localUri.getPort();
          if (i != -1)
          {
            localStringBuilder.append(":");
            localStringBuilder.append(i);
          }
          localBuilder.authority(localStringBuilder.toString());
          String str4 = localBuilder.build().toString();
          paramString = str4;
        }
      }
      return paramString;
    }
    catch (Exception localException)
    {
      new Object[] { paramString };
    }
    return paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.de
 * JD-Core Version:    0.6.2
 */