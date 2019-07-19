package com.yandex.metrica.impl.ob;

import java.util.HashMap;
import java.util.Map;

public class og
{
  private static Map<String, of> a = new HashMap();

  public static of a()
  {
    return of.g();
  }

  public static of a(String paramString)
  {
    if (!a.containsKey(paramString))
      a.put(paramString, new of(paramString));
    return (of)a.get(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.og
 * JD-Core Version:    0.6.2
 */