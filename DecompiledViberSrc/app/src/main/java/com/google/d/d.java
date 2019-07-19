package com.google.d;

import java.lang.reflect.Field;
import java.util.Locale;

public enum d
  implements e
{
  static
  {
    d[] arrayOfd = new d[5];
    arrayOfd[0] = a;
    arrayOfd[1] = b;
    arrayOfd[2] = c;
    arrayOfd[3] = d;
    arrayOfd[4] = e;
  }

  private static String a(char paramChar, String paramString, int paramInt)
  {
    if (paramInt < paramString.length())
      return paramChar + paramString.substring(paramInt);
    return String.valueOf(paramChar);
  }

  static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    char c1 = paramString.charAt(0);
    if ((i >= -1 + paramString.length()) || (Character.isLetter(c1)))
    {
      if (i != paramString.length())
        break label66;
      paramString = localStringBuilder.toString();
    }
    label66: 
    while (Character.isUpperCase(c1))
    {
      return paramString;
      localStringBuilder.append(c1);
      i++;
      c1 = paramString.charAt(i);
      break;
    }
    return a(Character.toUpperCase(c1), paramString, i + 1);
  }

  static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramString1.length(); i++)
    {
      char c1 = paramString1.charAt(i);
      if ((Character.isUpperCase(c1)) && (localStringBuilder.length() != 0))
        localStringBuilder.append(paramString2);
      localStringBuilder.append(c1);
    }
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.d
 * JD-Core Version:    0.6.2
 */