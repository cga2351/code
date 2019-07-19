package com.amazon.device.iap.internal.util;

import java.util.Collection;

public class d
{
  public static void a(Object paramObject, String paramString)
  {
    if (paramObject == null)
      throw new IllegalArgumentException(paramString + " must not be null");
  }

  public static void a(String paramString1, String paramString2)
  {
    if (a(paramString1))
      throw new IllegalArgumentException(paramString2 + " must not be null or empty");
  }

  public static void a(Collection<? extends Object> paramCollection, String paramString)
  {
    if (paramCollection.isEmpty())
      throw new IllegalArgumentException(paramString + " must not be empty");
  }

  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.util.d
 * JD-Core Version:    0.6.2
 */