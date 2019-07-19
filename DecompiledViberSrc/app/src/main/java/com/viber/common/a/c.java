package com.viber.common.a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
{
  private static final String a = c.class.getSimpleName();
  private static final Pattern b = Pattern.compile("(?<!\\\\)\\?");

  static String a(String paramString, Object[] paramArrayOfObject)
  {
    if (paramString != null)
    {
      if (paramArrayOfObject == null);
      for (int i = 1; i == 0; i = paramArrayOfObject.length)
        return paramString;
      return String.format(b.matcher(paramString).replaceAll("%s").replace("\\?", "?"), paramArrayOfObject);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.a.c
 * JD-Core Version:    0.6.2
 */