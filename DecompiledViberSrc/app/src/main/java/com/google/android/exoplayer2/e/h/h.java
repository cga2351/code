package com.google.android.exoplayer2.e.h;

import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.w;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h
{
  private static final Pattern a = Pattern.compile("^NOTE(( |\t).*)?$");

  public static long a(String paramString)
    throws NumberFormatException
  {
    int i = 0;
    long l1 = 0L;
    String[] arrayOfString1 = ag.b(paramString, "\\.");
    String[] arrayOfString2 = ag.a(arrayOfString1[0], ":");
    int j = arrayOfString2.length;
    while (i < j)
    {
      String str = arrayOfString2[i];
      l1 = l1 * 60L + Long.parseLong(str);
      i++;
    }
    long l2 = l1 * 1000L;
    if (arrayOfString1.length == 2)
      l2 += Long.parseLong(arrayOfString1[1]);
    return l2 * 1000L;
  }

  public static void a(r paramr)
    throws w
  {
    int i = paramr.d();
    if (!b(paramr))
    {
      paramr.c(i);
      throw new w("Expected WEBVTT. Got " + paramr.B());
    }
  }

  public static float b(String paramString)
    throws NumberFormatException
  {
    if (!paramString.endsWith("%"))
      throw new NumberFormatException("Percentages must end with %");
    return Float.parseFloat(paramString.substring(0, -1 + paramString.length())) / 100.0F;
  }

  public static boolean b(r paramr)
  {
    String str = paramr.B();
    return (str != null) && (str.startsWith("WEBVTT"));
  }

  public static Matcher c(r paramr)
  {
    Matcher localMatcher;
    do
    {
      String str1 = paramr.B();
      if (str1 == null)
        break;
      if (a.matcher(str1).matches())
        while (true)
        {
          String str2 = paramr.B();
          if ((str2 == null) || (str2.isEmpty()))
            break;
        }
      localMatcher = f.a.matcher(str1);
    }
    while (!localMatcher.matches());
    return localMatcher;
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.h.h
 * JD-Core Version:    0.6.2
 */