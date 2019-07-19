package com.iab.omid.library.appnexus;

import com.iab.omid.library.appnexus.d.e;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class b
{
  private static final Pattern a = Pattern.compile("<(head)( [^>]*)?>", 2);
  private static final Pattern b = Pattern.compile("<(head)( [^>]*)?/>", 2);
  private static final Pattern c = Pattern.compile("<(body)( [^>]*?)?>", 2);
  private static final Pattern d = Pattern.compile("<(body)( [^>]*?)?/>", 2);
  private static final Pattern e = Pattern.compile("<(html)( [^>]*?)?>", 2);
  private static final Pattern f = Pattern.compile("<(html)( [^>]*?)?/>", 2);
  private static final Pattern g = Pattern.compile("<!DOCTYPE [^>]*>", 2);

  static String a(String paramString1, String paramString2)
  {
    return b(paramString2, "<script type=\"text/javascript\">" + paramString1 + "</script>");
  }

  private static boolean a(int paramInt, int[][] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      int i = paramArrayOfInt.length;
      for (int j = 0; j < i; j++)
      {
        int[] arrayOfInt = paramArrayOfInt[j];
        if ((paramInt >= arrayOfInt[0]) && (paramInt <= arrayOfInt[1]))
          return true;
      }
    }
    return false;
  }

  private static boolean a(String paramString1, StringBuilder paramStringBuilder, Pattern paramPattern, String paramString2, int[][] paramArrayOfInt)
  {
    Matcher localMatcher = paramPattern.matcher(paramString1);
    int i = 0;
    int j;
    do
    {
      boolean bool1 = localMatcher.find(i);
      bool2 = false;
      if (!bool1)
        break;
      j = localMatcher.start();
      i = localMatcher.end();
    }
    while (a(j, paramArrayOfInt));
    paramStringBuilder.append(paramString1.substring(0, localMatcher.end()));
    paramStringBuilder.append(paramString2);
    paramStringBuilder.append(paramString1.substring(localMatcher.end()));
    boolean bool2 = true;
    return bool2;
  }

  private static int[][] a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramString.length();
    int j = 0;
    while (j < i)
    {
      int k = paramString.indexOf("<!--", j);
      if (k >= 0)
      {
        int m = paramString.indexOf("-->", k);
        if (m >= 0)
        {
          localArrayList.add(new int[] { k, m });
          j = m + "-->".length();
        }
        else
        {
          localArrayList.add(new int[] { k, i });
        }
      }
      else
      {
        j = i;
      }
    }
    int[] arrayOfInt = { 0, 2 };
    return (int[][])localArrayList.toArray((int[][])Array.newInstance(Integer.TYPE, arrayOfInt));
  }

  static String b(String paramString1, String paramString2)
  {
    e.a(paramString1, "HTML is null or empty");
    int[][] arrayOfInt = a(paramString1);
    StringBuilder localStringBuilder = new StringBuilder(16 + (paramString1.length() + paramString2.length()));
    if (b(paramString1, localStringBuilder, b, paramString2, arrayOfInt))
      return localStringBuilder.toString();
    if (a(paramString1, localStringBuilder, a, paramString2, arrayOfInt))
      return localStringBuilder.toString();
    if (b(paramString1, localStringBuilder, d, paramString2, arrayOfInt))
      return localStringBuilder.toString();
    if (a(paramString1, localStringBuilder, c, paramString2, arrayOfInt))
      return localStringBuilder.toString();
    if (b(paramString1, localStringBuilder, f, paramString2, arrayOfInt))
      return localStringBuilder.toString();
    if (a(paramString1, localStringBuilder, e, paramString2, arrayOfInt))
      return localStringBuilder.toString();
    if (a(paramString1, localStringBuilder, g, paramString2, arrayOfInt))
      return localStringBuilder.toString();
    return paramString2 + paramString1;
  }

  private static boolean b(String paramString1, StringBuilder paramStringBuilder, Pattern paramPattern, String paramString2, int[][] paramArrayOfInt)
  {
    Matcher localMatcher = paramPattern.matcher(paramString1);
    int i = 0;
    int j;
    do
    {
      boolean bool1 = localMatcher.find(i);
      bool2 = false;
      if (!bool1)
        break;
      j = localMatcher.start();
      i = localMatcher.end();
    }
    while (a(j, paramArrayOfInt));
    paramStringBuilder.append(paramString1.substring(0, -2 + localMatcher.end()));
    paramStringBuilder.append(">");
    paramStringBuilder.append(paramString2);
    paramStringBuilder.append("</");
    paramStringBuilder.append(localMatcher.group(1));
    paramStringBuilder.append(">");
    paramStringBuilder.append(paramString1.substring(localMatcher.end()));
    boolean bool2 = true;
    return bool2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.b
 * JD-Core Version:    0.6.2
 */