package com.c.a.a.e;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class d extends LinkedHashMap<String, String>
{
  public static final d a = new d();

  private d()
  {
    super(100, 0.8F, true);
  }

  public String a(String paramString)
  {
    try
    {
      String str = (String)get(paramString);
      if (str == null)
      {
        str = paramString.intern();
        put(str, str);
      }
      return str;
    }
    finally
    {
    }
  }

  protected boolean removeEldestEntry(Map.Entry<String, String> paramEntry)
  {
    return size() > 100;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.e.d
 * JD-Core Version:    0.6.2
 */