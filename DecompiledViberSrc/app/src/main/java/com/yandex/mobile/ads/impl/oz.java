package com.yandex.mobile.ads.impl;

import java.util.Date;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public final class oz
{
  private static long a(String paramString)
  {
    try
    {
      long l = DateUtils.parseDate(paramString).getTime();
      return l;
    }
    catch (DateParseException localDateParseException)
    {
    }
    return 0L;
  }

  public static ob.a a(oh paramoh)
  {
    long l1 = System.currentTimeMillis();
    Map localMap = paramoh.c;
    long l2 = 0L;
    long l3 = 0L;
    long l4 = 0L;
    String str1 = (String)localMap.get("Date");
    if (str1 != null)
      l2 = a(str1);
    String str2 = (String)localMap.get("Cache-Control");
    int k;
    int i;
    long l9;
    long l10;
    String str6;
    if (str2 != null)
    {
      String[] arrayOfString = str2.split(",");
      k = 0;
      i = 0;
      l9 = l4;
      l10 = l3;
      if (k < arrayOfString.length)
      {
        str6 = arrayOfString[k].trim();
        if ((str6.equals("no-cache")) || (str6.equals("no-store")))
          return null;
        if (!str6.startsWith("max-age="));
      }
    }
    while (true)
    {
      try
      {
        long l12 = Long.parseLong(str6.substring(8));
        l10 = l12;
        k++;
        break;
        if (str6.startsWith("stale-while-revalidate="));
        try
        {
          long l11 = Long.parseLong(str6.substring(23));
          l9 = l11;
          continue;
          if ((!str6.equals("must-revalidate")) && (!str6.equals("proxy-revalidate")))
            continue;
          i = 1;
          continue;
          l3 = l10;
          l4 = l9;
          j = 1;
          String str3 = (String)localMap.get("Expires");
          if (str3 == null)
            continue;
          l5 = a(str3);
          String str4 = (String)localMap.get("Last-Modified");
          if (str4 == null)
            continue;
          l6 = a(str4);
          String str5 = (String)localMap.get("ETag");
          if (j != 0)
          {
            l8 = l1 + 1000L * l3;
            if (i != 0)
            {
              l7 = l8;
              ob.a locala = new ob.a();
              locala.a = paramoh.b;
              locala.b = str5;
              locala.f = l8;
              locala.e = l7;
              locala.c = l2;
              locala.d = l6;
              locala.g = localMap;
              return locala;
            }
            l7 = l8 + 1000L * l4;
            continue;
          }
          if ((l2 <= 0L) || (l5 < l2))
            continue;
          l7 = l1 + (l5 - l2);
          l8 = l7;
          continue;
        }
        catch (Exception localException1)
        {
        }
        continue;
      }
      catch (Exception localException2)
      {
        continue;
        long l7 = 0L;
        long l8 = 0L;
        continue;
        long l6 = 0L;
        continue;
        long l5 = 0L;
        continue;
      }
      i = 0;
      int j = 0;
    }
  }

  public static String a(Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("Content-Type");
    if (str != null)
    {
      String[] arrayOfString1 = str.split(";");
      for (int i = 1; i < arrayOfString1.length; i++)
      {
        String[] arrayOfString2 = arrayOfString1[i].trim().split("=");
        if ((arrayOfString2.length == 2) && (arrayOfString2[0].equals("charset")))
          return arrayOfString2[1];
      }
    }
    return "ISO-8859-1";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.oz
 * JD-Core Version:    0.6.2
 */