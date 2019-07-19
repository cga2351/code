package com.google.android.exoplayer2.e.h;

import android.text.TextUtils;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.r;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class a
{
  private static final Pattern a = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
  private final r b = new r();
  private final StringBuilder c = new StringBuilder();

  private static char a(r paramr, int paramInt)
  {
    return (char)paramr.a[paramInt];
  }

  static String a(r paramr, StringBuilder paramStringBuilder)
  {
    b(paramr);
    String str;
    if (paramr.b() == 0)
      str = null;
    do
    {
      return str;
      str = d(paramr, paramStringBuilder);
    }
    while (!"".equals(str));
    return "" + (char)paramr.h();
  }

  private void a(d paramd, String paramString)
  {
    if ("".equals(paramString));
    while (true)
    {
      return;
      int i = paramString.indexOf('[');
      if (i != -1)
      {
        Matcher localMatcher = a.matcher(paramString.substring(i));
        if (localMatcher.matches())
          paramd.c(localMatcher.group(1));
        paramString = paramString.substring(0, i);
      }
      String[] arrayOfString = ag.a(paramString, "\\.");
      String str = arrayOfString[0];
      int j = str.indexOf('#');
      if (j != -1)
      {
        paramd.b(str.substring(0, j));
        paramd.a(str.substring(j + 1));
      }
      while (arrayOfString.length > 1)
      {
        paramd.a((String[])Arrays.copyOfRange(arrayOfString, 1, arrayOfString.length));
        return;
        paramd.b(str);
      }
    }
  }

  private static void a(r paramr, d paramd, StringBuilder paramStringBuilder)
  {
    b(paramr);
    String str1 = d(paramr, paramStringBuilder);
    if ("".equals(str1));
    label19: String str2;
    label121: 
    do
    {
      do
      {
        do
        {
          do
          {
            break label19;
            break label19;
            break label19;
            do
              return;
            while (!":".equals(a(paramr, paramStringBuilder)));
            b(paramr);
            str2 = c(paramr, paramStringBuilder);
          }
          while ((str2 == null) || ("".equals(str2)));
          int i = paramr.d();
          String str3 = a(paramr, paramStringBuilder);
          if (";".equals(str3));
          while (true)
          {
            if (!"color".equals(str1))
              break label121;
            paramd.a(com.google.android.exoplayer2.g.d.b(str2));
            return;
            if (!"}".equals(str3))
              break;
            paramr.c(i);
          }
          if ("background-color".equals(str1))
          {
            paramd.b(com.google.android.exoplayer2.g.d.b(str2));
            return;
          }
          if (!"text-decoration".equals(str1))
            break;
        }
        while (!"underline".equals(str2));
        paramd.a(true);
        return;
        if ("font-family".equals(str1))
        {
          paramd.d(str2);
          return;
        }
        if (!"font-weight".equals(str1))
          break;
      }
      while (!"bold".equals(str2));
      paramd.b(true);
      return;
    }
    while ((!"font-style".equals(str1)) || (!"italic".equals(str2)));
    paramd.c(true);
  }

  private static String b(r paramr, StringBuilder paramStringBuilder)
  {
    b(paramr);
    if (paramr.b() < 5);
    int i;
    String str1;
    do
    {
      do
        return null;
      while (!"::cue".equals(paramr.e(5)));
      i = paramr.d();
      str1 = a(paramr, paramStringBuilder);
    }
    while (str1 == null);
    if ("{".equals(str1))
    {
      paramr.c(i);
      return "";
    }
    if ("(".equals(str1));
    for (String str2 = d(paramr); ; str2 = null)
    {
      String str3 = a(paramr, paramStringBuilder);
      if ((!")".equals(str3)) || (str3 == null))
        break;
      return str2;
    }
  }

  static void b(r paramr)
  {
    int i = 1;
    while ((paramr.b() > 0) && (i != 0))
      if ((e(paramr)) || (f(paramr)))
        i = 1;
      else
        i = 0;
  }

  private static String c(r paramr, StringBuilder paramStringBuilder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i == 0)
    {
      int j = paramr.d();
      String str = a(paramr, paramStringBuilder);
      if (str == null)
        return null;
      if (("}".equals(str)) || (";".equals(str)))
      {
        paramr.c(j);
        i = 1;
      }
      else
      {
        localStringBuilder.append(str);
      }
    }
    return localStringBuilder.toString();
  }

  static void c(r paramr)
  {
    while (!TextUtils.isEmpty(paramr.B()));
  }

  private static String d(r paramr)
  {
    int i = paramr.d();
    int j = paramr.c();
    int k = i;
    int m = 0;
    if ((k < j) && (m == 0))
    {
      byte[] arrayOfByte = paramr.a;
      int n = k + 1;
      if ((char)arrayOfByte[k] == ')');
      for (m = 1; ; m = 0)
      {
        k = n;
        break;
      }
    }
    return paramr.e(k - 1 - paramr.d()).trim();
  }

  private static String d(r paramr, StringBuilder paramStringBuilder)
  {
    int i = 0;
    paramStringBuilder.setLength(0);
    int j = paramr.d();
    int k = paramr.c();
    while ((j < k) && (i == 0))
    {
      char c1 = (char)paramr.a[j];
      if (((c1 >= 'A') && (c1 <= 'Z')) || ((c1 >= 'a') && (c1 <= 'z')) || ((c1 >= '0') && (c1 <= '9')) || (c1 == '#') || (c1 == '-') || (c1 == '.') || (c1 == '_'))
      {
        j++;
        paramStringBuilder.append(c1);
      }
      else
      {
        i = 1;
      }
    }
    paramr.d(j - paramr.d());
    return paramStringBuilder.toString();
  }

  private static boolean e(r paramr)
  {
    switch (a(paramr, paramr.d()))
    {
    default:
      return false;
    case '\t':
    case '\n':
    case '\f':
    case '\r':
    case ' ':
    }
    paramr.d(1);
    return true;
  }

  private static boolean f(r paramr)
  {
    int i = paramr.d();
    int j = paramr.c();
    byte[] arrayOfByte = paramr.a;
    if (i + 2 <= j)
    {
      int k = i + 1;
      if (arrayOfByte[i] == 47)
      {
        int m = k + 1;
        if (arrayOfByte[k] == 42)
        {
          int i1;
          for (int n = m; n + 1 < j; n = i1)
          {
            i1 = n + 1;
            if (((char)arrayOfByte[n] == '*') && ((char)arrayOfByte[i1] == '/'))
            {
              j = i1 + 1;
              i1 = j;
            }
          }
          paramr.d(j - paramr.d());
          return true;
        }
      }
    }
    return false;
  }

  public d a(r paramr)
  {
    this.c.setLength(0);
    int i = paramr.d();
    c(paramr);
    this.b.a(paramr.a, paramr.d());
    this.b.c(i);
    String str1 = b(this.b, this.c);
    d locald;
    if ((str1 == null) || (!"{".equals(a(this.b, this.c))))
      locald = null;
    String str2;
    label182: 
    do
    {
      return locald;
      locald = new d();
      a(locald, str1);
      int j = 0;
      str2 = null;
      while (j == 0)
      {
        int k = this.b.d();
        str2 = a(this.b, this.c);
        if ((str2 == null) || ("}".equals(str2)));
        for (j = 1; ; j = 0)
        {
          if (j != 0)
            break label182;
          this.b.c(k);
          a(this.b, locald, this.c);
          break;
        }
      }
    }
    while ("}".equals(str2));
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.h.a
 * JD-Core Version:    0.6.2
 */