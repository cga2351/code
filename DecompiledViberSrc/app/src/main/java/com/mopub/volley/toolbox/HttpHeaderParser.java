package com.mopub.volley.toolbox;

import com.mopub.volley.Cache.Entry;
import com.mopub.volley.Header;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.VolleyLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;

public class HttpHeaderParser
{
  static String a(long paramLong)
  {
    return a().format(new Date(paramLong));
  }

  private static SimpleDateFormat a()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    return localSimpleDateFormat;
  }

  static List<Header> a(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localArrayList.add(new Header((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    return localArrayList;
  }

  static Map<String, String> a(List<Header> paramList)
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Header localHeader = (Header)localIterator.next();
      localTreeMap.put(localHeader.getName(), localHeader.getValue());
    }
    return localTreeMap;
  }

  public static Cache.Entry parseCacheHeaders(NetworkResponse paramNetworkResponse)
  {
    long l1 = System.currentTimeMillis();
    Map localMap = paramNetworkResponse.headers;
    long l2 = 0L;
    long l3 = 0L;
    long l4 = 0L;
    String str1 = (String)localMap.get("Date");
    if (str1 != null)
      l2 = parseDateAsEpoch(str1);
    String str2 = (String)localMap.get("Cache-Control");
    int k;
    int i;
    long l9;
    long l10;
    String str6;
    if (str2 != null)
    {
      String[] arrayOfString = str2.split(",", 0);
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
          l5 = parseDateAsEpoch(str3);
          String str4 = (String)localMap.get("Last-Modified");
          if (str4 == null)
            continue;
          l6 = parseDateAsEpoch(str4);
          String str5 = (String)localMap.get("ETag");
          if (j != 0)
          {
            l8 = l1 + 1000L * l3;
            if (i != 0)
            {
              l7 = l8;
              Cache.Entry localEntry = new Cache.Entry();
              localEntry.data = paramNetworkResponse.data;
              localEntry.etag = str5;
              localEntry.softTtl = l8;
              localEntry.ttl = l7;
              localEntry.serverDate = l2;
              localEntry.lastModified = l6;
              localEntry.responseHeaders = localMap;
              localEntry.allResponseHeaders = paramNetworkResponse.allHeaders;
              return localEntry;
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

  public static String parseCharset(Map<String, String> paramMap)
  {
    return parseCharset(paramMap, "ISO-8859-1");
  }

  public static String parseCharset(Map<String, String> paramMap, String paramString)
  {
    String str = (String)paramMap.get("Content-Type");
    String[] arrayOfString1;
    if (str != null)
      arrayOfString1 = str.split(";", 0);
    for (int i = 1; ; i++)
      if (i < arrayOfString1.length)
      {
        String[] arrayOfString2 = arrayOfString1[i].trim().split("=", 0);
        if ((arrayOfString2.length == 2) && (arrayOfString2[0].equals("charset")))
          paramString = arrayOfString2[1];
      }
      else
      {
        return paramString;
      }
  }

  public static long parseDateAsEpoch(String paramString)
  {
    try
    {
      long l = a().parse(paramString).getTime();
      return l;
    }
    catch (ParseException localParseException)
    {
      VolleyLog.e(localParseException, "Unable to parse dateStr: %s, falling back to 0", new Object[] { paramString });
    }
    return 0L;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.toolbox.HttpHeaderParser
 * JD-Core Version:    0.6.2
 */