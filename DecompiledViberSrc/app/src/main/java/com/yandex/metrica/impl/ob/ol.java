package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.impl.bw;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ol
{
  public static String a(Map<String, String> paramMap)
  {
    String str = "";
    if (!bw.a(paramMap))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (!TextUtils.isEmpty((CharSequence)localEntry.getKey()))
          localStringBuilder.append((String)localEntry.getKey()).append(":").append((String)localEntry.getValue()).append(",");
      }
      localStringBuilder.setLength(-1 + localStringBuilder.length());
      str = localStringBuilder.toString();
    }
    return str;
  }

  public static Map<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramString))
      for (String str1 : paramString.split(","))
      {
        int k = str1.indexOf(":");
        if (k != -1)
        {
          String str2 = str1.substring(0, k);
          if (!TextUtils.isEmpty(str2))
            localHashMap.put(str2, str1.substring(k + 1));
        }
      }
    return localHashMap;
  }

  public static boolean b(Map<String, String> paramMap)
  {
    if (paramMap.isEmpty())
      return false;
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      try
      {
        Integer.parseInt((String)localEntry.getValue());
      }
      catch (Exception localException)
      {
        return false;
      }
    }
    return true;
  }

  public static Map<String, String> c(Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      label168: label170: label174: 
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str1 = (String)localEntry.getKey();
        int i;
        if ((!TextUtils.isEmpty(str1)) && (!str1.contains(":")) && (!str1.contains(",")) && (!str1.contains("&")))
        {
          i = 1;
          label95: if (i == 0)
            break label168;
          String str2 = (String)localEntry.getValue();
          if ((TextUtils.isEmpty(str2)) || (oe.a(str2, -1L) == -1L))
            break label170;
        }
        for (int j = 1; ; j = 0)
        {
          if (j == 0)
            break label174;
          localHashMap.put(localEntry.getKey(), localEntry.getValue());
          break;
          i = 0;
          break label95;
          break;
        }
      }
    }
    return localHashMap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ol
 * JD-Core Version:    0.6.2
 */