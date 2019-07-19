package com.yandex.metrica.impl;

import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class p
  implements ar
{
  private final a a;

  public p()
  {
    this(new a());
  }

  p(a parama)
  {
    this.a = parama;
  }

  public boolean a(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    boolean bool = false;
    if (200 == paramInt)
    {
      p.a.a locala = this.a.a(paramArrayOfByte);
      bool = false;
      if (locala != null)
        bool = "accepted".equals(locala.a);
    }
    return bool;
  }

  static class a
  {
    public a a(byte[] paramArrayOfByte)
    {
      try
      {
        if (!bw.a(paramArrayOfByte))
        {
          a locala = new a(new JSONObject(new String(paramArrayOfByte, "UTF-8")).optString("status"));
          return locala;
        }
      }
      catch (Exception localException)
      {
      }
      return null;
    }

    static class a
    {
      final String a;

      public a(String paramString)
      {
        this.a = paramString;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.p
 * JD-Core Version:    0.6.2
 */