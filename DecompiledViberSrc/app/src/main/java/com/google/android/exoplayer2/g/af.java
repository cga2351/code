package com.google.android.exoplayer2.g;

import android.net.Uri;
import android.text.TextUtils;

public final class af
{
  public static Uri a(String paramString1, String paramString2)
  {
    return Uri.parse(b(paramString1, paramString2));
  }

  private static String a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= paramInt2)
      return paramStringBuilder.toString();
    if (paramStringBuilder.charAt(paramInt1) == '/')
      paramInt1++;
    int i = paramInt1;
    int j = paramInt1;
    int k = paramInt2;
    if (i <= k)
    {
      int m;
      label46: int n;
      if (i == k)
      {
        m = i;
        if ((i != j + 1) || (paramStringBuilder.charAt(j) != '.'))
          break label126;
        paramStringBuilder.delete(j, m);
        k -= m - j;
        n = j;
      }
      while (true)
      {
        int i1 = j;
        j = n;
        i = i1;
        break;
        if (paramStringBuilder.charAt(i) == '/')
        {
          m = i + 1;
          break label46;
        }
        i++;
        break;
        label126: if ((i == j + 2) && (paramStringBuilder.charAt(j) == '.') && (paramStringBuilder.charAt(j + 1) == '.'))
        {
          j = 1 + paramStringBuilder.lastIndexOf("/", j - 2);
          if (j > paramInt1);
          for (int i2 = j; ; i2 = paramInt1)
          {
            paramStringBuilder.delete(i2, m);
            k -= m - i2;
            n = j;
            break;
          }
        }
        j = i + 1;
        n = j;
      }
    }
    return paramStringBuilder.toString();
  }

  private static int[] a(String paramString)
  {
    int[] arrayOfInt = new int[4];
    if (TextUtils.isEmpty(paramString))
    {
      arrayOfInt[0] = -1;
      return arrayOfInt;
    }
    int i = paramString.length();
    int j = paramString.indexOf('#');
    if (j == -1);
    while (true)
    {
      int k = paramString.indexOf('?');
      if ((k == -1) || (k > i))
        k = i;
      int m = paramString.indexOf('/');
      if ((m == -1) || (m > k))
        m = k;
      int n = paramString.indexOf(':');
      if (n > m)
        n = -1;
      int i1;
      if ((n + 2 < k) && (paramString.charAt(n + 1) == '/') && (paramString.charAt(n + 2) == '/'))
      {
        i1 = 1;
        if (i1 == 0)
          break label199;
        i2 = paramString.indexOf('/', n + 3);
        if ((i2 != -1) && (i2 <= k));
      }
      label199: for (int i2 = k; ; i2 = n + 1)
      {
        arrayOfInt[0] = n;
        arrayOfInt[1] = i2;
        arrayOfInt[2] = k;
        arrayOfInt[3] = i;
        return arrayOfInt;
        i1 = 0;
        break;
      }
      i = j;
    }
  }

  public static String b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString1 == null)
      paramString1 = "";
    if (paramString2 == null)
      paramString2 = "";
    int[] arrayOfInt1 = a(paramString2);
    if (arrayOfInt1[0] != -1)
    {
      localStringBuilder.append(paramString2);
      a(localStringBuilder, arrayOfInt1[1], arrayOfInt1[2]);
      return localStringBuilder.toString();
    }
    int[] arrayOfInt2 = a(paramString1);
    if (arrayOfInt1[3] == 0)
      return paramString2;
    if (arrayOfInt1[2] == 0)
      return paramString2;
    if (arrayOfInt1[1] != 0)
    {
      int k = 1 + arrayOfInt2[0];
      localStringBuilder.append(paramString1, 0, k).append(paramString2);
      return a(localStringBuilder, k + arrayOfInt1[1], k + arrayOfInt1[2]);
    }
    if (paramString2.charAt(arrayOfInt1[1]) == '/')
    {
      localStringBuilder.append(paramString1, 0, arrayOfInt2[1]).append(paramString2);
      return a(localStringBuilder, arrayOfInt2[1], arrayOfInt2[1] + arrayOfInt1[2]);
    }
    if ((2 + arrayOfInt2[0] < arrayOfInt2[1]) && (arrayOfInt2[1] == arrayOfInt2[2]))
    {
      localStringBuilder.append(paramString1, 0, arrayOfInt2[1]).append('/').append(paramString2);
      return a(localStringBuilder, arrayOfInt2[1], 1 + (arrayOfInt2[1] + arrayOfInt1[2]));
    }
    int i = paramString1.lastIndexOf('/', -1 + arrayOfInt2[2]);
    if (i == -1);
    for (int j = arrayOfInt2[1]; ; j = i + 1)
    {
      localStringBuilder.append(paramString1, 0, j).append(paramString2);
      return a(localStringBuilder, arrayOfInt2[1], j + arrayOfInt1[2]);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.af
 * JD-Core Version:    0.6.2
 */