package com.appboy.b;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public enum b
{
  private static final Map<String, b> f;

  static
  {
    b[] arrayOfb = new b[5];
    arrayOfb[0] = a;
    arrayOfb[1] = b;
    arrayOfb[2] = c;
    arrayOfb[3] = d;
    arrayOfb[4] = e;
    g = arrayOfb;
    f = new HashMap();
    Iterator localIterator = EnumSet.allOf(b.class).iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      f.put(localb.toString(), localb);
    }
  }

  public static b a(String paramString)
  {
    return (b)f.get(paramString.toUpperCase(Locale.US));
  }

  public static EnumSet<b> a()
  {
    return EnumSet.allOf(b.class);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.b.b
 * JD-Core Version:    0.6.2
 */