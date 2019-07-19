package com.yandex.mobile.ads.impl;

import android.text.TextUtils;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class bi
{
  public static String a(Map<String, String> paramMap, oa paramoa)
  {
    return (String)paramMap.get(paramoa.a());
  }

  public static <T> List<T> a(Map<String, String> paramMap, oa paramoa, a<T> parama)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = a(paramMap, paramoa);
    String[] arrayOfString;
    int i;
    int j;
    if (!TextUtils.isEmpty(str1))
    {
      arrayOfString = (String[])fl.a(str1.split(","));
      i = arrayOfString.length;
      j = 0;
    }
    while (true)
    {
      String str2;
      if (j < i)
        str2 = arrayOfString[j];
      try
      {
        String str3 = URLDecoder.decode(str2.trim(), "UTF-8");
        if (parama.a(str3) != null)
          localArrayList.add(parama.a(str3));
        label98: j++;
        continue;
        return localArrayList;
      }
      catch (Exception localException)
      {
        break label98;
      }
    }
  }

  public static boolean b(Map<String, String> paramMap, oa paramoa)
  {
    String str = a(paramMap, paramoa);
    if (str == null)
      return false;
    return Boolean.parseBoolean(str);
  }

  public static int c(Map<String, String> paramMap, oa paramoa)
  {
    return cw.b(a(paramMap, paramoa));
  }

  public static String d(Map<String, String> paramMap, oa paramoa)
  {
    List localList = e(paramMap, paramoa);
    if (localList.isEmpty())
      return null;
    return (String)localList.get(0);
  }

  public static List<String> e(Map<String, String> paramMap, oa paramoa)
  {
    return a(paramMap, paramoa, new a()
    {
    });
  }

  public static abstract interface a<T>
  {
    public abstract T a(String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.bi
 * JD-Core Version:    0.6.2
 */