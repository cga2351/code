package com.yandex.metrica.impl.ob;

public class oe
{
  public static long a(String paramString, long paramLong)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return paramLong;
  }

  public static Long a(String paramString)
  {
    try
    {
      Long localLong = Long.valueOf(Long.parseLong(paramString));
      return localLong;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return null;
  }

  public static Float b(String paramString)
  {
    try
    {
      Float localFloat = Float.valueOf(Float.parseFloat(paramString));
      return localFloat;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return null;
  }

  public static Integer c(String paramString)
  {
    try
    {
      Integer localInteger = Integer.valueOf(Integer.parseInt(paramString));
      return localInteger;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.oe
 * JD-Core Version:    0.6.2
 */