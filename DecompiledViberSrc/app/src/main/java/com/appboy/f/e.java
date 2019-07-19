package com.appboy.f;

import java.util.Set;

public class e
{
  private static final String a = c.a(e.class);

  public static boolean a(String paramString)
  {
    if (paramString == null)
    {
      c.d(a, "Custom attribute value cannot be null.");
      return false;
    }
    return true;
  }

  public static boolean a(String paramString, Set<String> paramSet)
  {
    if (paramString == null)
    {
      c.d(a, "Custom attribute key cannot be null.");
      return false;
    }
    if (paramSet.contains(paramString))
    {
      c.d(a, "Custom attribute key cannot be blacklisted attribute: " + paramString + ".");
      return false;
    }
    return true;
  }

  public static String[] a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
      for (int i = 0; i < paramArrayOfString.length; i++)
        paramArrayOfString[i] = j.c(paramArrayOfString[i]);
    return paramArrayOfString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.f.e
 * JD-Core Version:    0.6.2
 */