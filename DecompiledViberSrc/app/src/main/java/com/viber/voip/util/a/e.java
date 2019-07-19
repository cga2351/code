package com.viber.voip.util.a;

public class e
{
  protected static String[] a = { "a", "a", "i", "i", "u", "u", "e", "e", "o", "o", "ka", "ga", "ki", "gi", "ku", "gu", "ke", "ge", "ko", "go", "sa", "za", "shi", "ji", "su", "zu", "se", "ze", "so", "zo", "ta", "da", "chi", "ji", "tsu", "tsu", "zu", "te", "de", "to", "do", "na", "ni", "nu", "ne", "no", "ha", "ba", "pa", "hi", "bi", "pi", "fu", "bu", "pu", "he", "be", "pe", "ho", "bo", "po", "ma", "mi", "mu", "me", "mo", "a", "ya", "u", "yu", "o", "yo", "ra", "ri", "ru", "re", "ro", "wa", "wa", "wi", "we", "o", "n", "v", "ka", "ke" };
  protected static String[] b = { "", "", "", "", "", "", "", "", "", "", "", "", "ky", "gy", "", "", "", "", "", "", "", "", "sh", "j", "", "", "", "", "", "", "", "", "ch", "ji", "", "", "", "", "", "", "", "", "ny", "", "", "", "", "", "", "hy", "by", "py", "", "", "", "", "", "", "", "", "", "", "my", "", "", "", "a", "ya", "u", "yu", "o", "yo", "", "ry", "", "", "", "", "", "", "", "", "", "", "", "" };

  public static int a(String paramString)
  {
    int i = 0;
    int j = paramString.length();
    int k = 0;
    int m = -1;
    int n = -1;
    while (true)
    {
      char c;
      if (i < j)
      {
        c = paramString.charAt(i);
        if (!Character.isLetterOrDigit(c))
          n = -1;
      }
      else
      {
        return n;
      }
      int i1 = c.a(c);
      if (((k != 0) && (i1 != m)) || (i1 == -1) || (i1 == 3))
        return -1;
      if ((m != -1) && (m != i1))
      {
        k = 1;
        n = i;
      }
      i++;
      m = i1;
    }
  }

  public static boolean b(String paramString)
  {
    return (d(paramString)) || (e(paramString));
  }

  public static int c(String paramString)
  {
    if (d(paramString))
      return 1;
    if (e(paramString))
      return 2;
    if (i(paramString))
      return 3;
    return 0;
  }

  public static boolean d(String paramString)
  {
    int i = paramString.length();
    for (int j = 0; j < i; j++)
    {
      int k = paramString.charAt(j);
      if ((12353 > k) || (k > 12446))
        return false;
    }
    return true;
  }

  public static boolean e(String paramString)
  {
    return (f(paramString)) || (g(paramString));
  }

  public static boolean f(String paramString)
  {
    int i = paramString.length();
    for (int j = 0; j < i; j++)
    {
      int k = paramString.charAt(j);
      if ((65382 > k) || (k > 65437))
        return false;
    }
    return true;
  }

  public static boolean g(String paramString)
  {
    int i = paramString.length();
    for (int j = 0; j < i; j++)
    {
      int k = paramString.charAt(j);
      if ((12449 > k) || (k > 12542))
        return false;
    }
    return true;
  }

  public static boolean h(String paramString)
  {
    int i = paramString.length();
    int j = 0;
    int k;
    if (j < i)
    {
      k = paramString.charAt(j);
      if ((19968 > k) || (k > 40869))
        break label66;
    }
    label66: for (int m = 1; ; m = 0)
    {
      if ((12293 <= k) && (k <= 12295))
        m = 1;
      if (m == 0)
        return false;
      j++;
      break;
      return true;
    }
  }

  public static boolean i(String paramString)
  {
    int i = paramString.length();
    int j = 0;
    int k;
    int m;
    if (j < i)
    {
      k = paramString.charAt(j);
      if ((65 <= k) && (k <= 144))
        m = 1;
    }
    while (true)
      if (m == 0)
      {
        return false;
        if ((97 <= k) && (k <= 122))
          m = 1;
        else if ((33 <= k) && (k <= 58))
          m = 1;
        else if ((65 <= k) && (k <= 90))
          m = 1;
      }
      else
      {
        j++;
        break;
        return true;
        m = 0;
      }
  }

  public static String j(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramString.length();
    for (int j = 0; j < i; j++)
      localStringBuffer.append(c.h(paramString.charAt(j)));
    return localStringBuffer.toString();
  }

  public static String k(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramString.length();
    for (int j = 0; j < i; j++)
      localStringBuffer.append(c.i(paramString.charAt(j)));
    return localStringBuffer.toString();
  }

  public static String l(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramString.length();
    int j = 0;
    if (j < i - 1)
    {
      char c2 = paramString.charAt(j);
      char c3 = paramString.charAt(j + 1);
      boolean bool2 = c.b(c2);
      int m = c.i(c2);
      int n = c.i(c3);
      String str2;
      if ((n == 12423) || (n == 12421) || (n == 12419))
        str2 = b[(m - 12353)];
      while (true)
      {
        if (!bool2)
          str2 = str2.toUpperCase();
        localStringBuffer.append(str2);
        j++;
        break;
        try
        {
          str2 = a[(m - 12353)];
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          str2 = "";
        }
      }
    }
    char c1 = paramString.charAt(i - 1);
    boolean bool1 = c.b(c1);
    int k = c.i(c1);
    String str1 = a[(k - 12353)];
    if (!bool1)
      str1 = str1.toUpperCase();
    localStringBuffer.append(str1);
    return localStringBuffer.toString();
  }

  public static boolean m(String paramString)
  {
    if (paramString == null);
    while (true)
    {
      return false;
      int i = paramString.length();
      for (int j = 0; j < i; j++)
        if (c.j(paramString.charAt(j)))
          return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.a.e
 * JD-Core Version:    0.6.2
 */