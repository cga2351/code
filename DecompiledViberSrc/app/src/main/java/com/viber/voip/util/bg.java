package com.viber.voip.util;

import android.net.Uri;
import android.net.Uri.Builder;
import com.viber.voip.ViberApplication;
import f.c;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bg
{
  private static final Pattern a = Pattern.compile("^bytes ([0-9]+)-(([0-9]+)/([0-9]+))?");

  public static b a(String paramString)
  {
    int i = -1;
    Matcher localMatcher = a.matcher(paramString);
    int j;
    int k;
    if (localMatcher.matches())
    {
      j = Integer.parseInt(localMatcher.group(1));
      if ((localMatcher.group(3) == null) || (localMatcher.group(3).length() == 0))
        break label78;
      k = Integer.parseInt(localMatcher.group(3));
      i = Integer.parseInt(localMatcher.group(4));
    }
    while (true)
    {
      return new b(j, k, i);
      return null;
      label78: k = i;
    }
  }

  public static String a()
  {
    String str1 = dz.a(ViberApplication.getApplication());
    if (da.a(str1))
    {
      str1 = System.getProperty("http.agent");
      if (da.a(str1))
        str1 = dz.a();
    }
    try
    {
      String str2 = c(str1);
      return str2;
    }
    catch (Exception localException)
    {
    }
    return str1;
  }

  public static String b(String paramString)
  {
    if ((paramString != null) && (!da.a(paramString)) && (da.a(Uri.parse(paramString).getScheme())))
      paramString = new Uri.Builder().scheme("http").encodedPath("//" + paramString).build().toString();
    return paramString;
  }

  private static String c(String paramString)
  {
    int i = paramString.length();
    int j = 0;
    while (j < i)
    {
      int k = paramString.codePointAt(j);
      if ((k > 31) && (k < 127))
      {
        j += Character.charCount(k);
      }
      else
      {
        c localc = new c();
        localc.a(paramString, 0, j);
        int m = j;
        if (m < i)
        {
          int n = paramString.codePointAt(m);
          if ((n > 31) && (n < 127));
          for (int i1 = n; ; i1 = 63)
          {
            localc.a(i1);
            m += Character.charCount(n);
            break;
          }
        }
        paramString = localc.r();
      }
    }
    return paramString;
  }

  public static final class a
  {
    public static boolean a(String paramString)
    {
      return (paramString != null) && (paramString.startsWith("image/"));
    }

    public static boolean b(String paramString)
    {
      return (paramString != null) && (paramString.startsWith("audio/"));
    }

    public static boolean c(String paramString)
    {
      return (paramString != null) && (paramString.startsWith("video/"));
    }

    public static boolean d(String paramString)
    {
      return (paramString != null) && (paramString.equals("image/gif"));
    }
  }

  public static class b
  {
    private final int a;
    private final int b;
    private final int c;

    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
    }

    public int a()
    {
      return this.a;
    }

    public int b()
    {
      return this.c;
    }

    public String toString()
    {
      return "Range[" + this.a + "-" + this.b + "/" + this.c + "]";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.bg
 * JD-Core Version:    0.6.2
 */