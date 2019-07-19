package com.yandex.mobile.ads.impl;

import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class pw
{
  public static Long a(String paramString)
  {
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("hh:mm:ss");
      Long localLong = Long.valueOf(localSimpleDateFormat.parse(paramString).getTime() - localSimpleDateFormat.parse("00:00:00").getTime());
      return localLong;
    }
    catch (ParseException localParseException)
    {
    }
    return null;
  }

  public static void a(Object paramObject, String paramString)
  {
    if (paramObject == null)
      c(paramString);
  }

  public static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
      c(paramString2);
  }

  public static Integer b(String paramString)
  {
    try
    {
      Integer localInteger = Integer.valueOf(paramString);
      return localInteger;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return null;
  }

  private static void c(String paramString)
  {
    throw new IllegalArgumentException(paramString + " not set!");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.pw
 * JD-Core Version:    0.6.2
 */