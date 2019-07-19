package com.my.target;

import android.content.Context;
import com.my.target.common.b;
import com.my.target.common.c;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class do
{
  public static do b()
  {
    return new a();
  }

  public abstract f b(z paramz, Context paramContext);

  public static class a extends do
  {
    private static String a = "https://ad.mail.ru/mobile/";

    private String c(z paramz, Context paramContext)
    {
      Map localMap = a(paramz, paramContext);
      StringBuilder localStringBuilder = new StringBuilder(a + paramz.c() + "/");
      Iterator localIterator = localMap.entrySet().iterator();
      int i = 1;
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Object localObject = (String)localEntry.getValue();
        String str1;
        if (localObject != null)
          str1 = (String)localEntry.getKey();
        while (true)
        {
          try
          {
            String str2 = URLEncoder.encode((String)localObject, "UTF-8");
            localObject = str2;
            if (i != 0)
            {
              localStringBuilder.append("?").append(str1).append("=").append((String)localObject);
              j = 0;
              i = j;
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            dp.a(localUnsupportedEncodingException.getMessage());
            continue;
            localStringBuilder.append("&").append(str1).append("=").append((String)localObject);
          }
          int j = i;
        }
      }
      return localStringBuilder.toString();
    }

    protected Map<String, String> a(z paramz, Context paramContext)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("formats", paramz.b());
      localHashMap.put("adman_ver", "5.3.11");
      if (c.b())
        if (!c.a())
          break label155;
      label155: for (String str2 = "1"; ; str2 = "0")
      {
        localHashMap.put("user_consent", str2);
        if (c.c())
          localHashMap.put("user_age_restricted", "1");
        if (paramz.e())
          localHashMap.put("preloadvideo", "1");
        int i = paramz.j();
        if (i > 0)
          localHashMap.put("count", Integer.toString(i));
        String str1 = paramz.k();
        if (str1 != null)
          localHashMap.put("bid_id", str1);
        if ((!c.b()) || (c.a()))
          break;
        return localHashMap;
      }
      paramz.a().a(localHashMap);
      try
      {
        am.c().d().a(paramz.f());
        am.c().d().b(paramz.g());
        am.c().a(paramContext);
        am.c().a(localHashMap);
        return localHashMap;
      }
      catch (Throwable localThrowable)
      {
        while (true)
          dp.a("Error collecting data: " + localThrowable);
      }
    }

    public f b(z paramz, Context paramContext)
    {
      return f.a(c(paramz, paramContext));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.do
 * JD-Core Version:    0.6.2
 */