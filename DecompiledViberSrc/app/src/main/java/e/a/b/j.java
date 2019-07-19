package e.a.b;

import java.io.IOException;

class j
{
  public static final d a = new d(null);
  public static final e b = new e(null);
  public static final c c = new c(null);
  public static final b d = new b(null);
  public static final a e = new a(null);

  public static boolean a(char paramChar)
  {
    return (paramChar == '\r') || (paramChar == '\n') || (paramChar == '\t') || (paramChar == ' ');
  }

  public static boolean a(String paramString)
  {
    if (paramString.length() < 3);
    int i;
    do
    {
      return false;
      i = paramString.charAt(0);
      if (i == 110)
        return paramString.equals("null");
      if (i == 116)
        return paramString.equals("true");
      if (i == 102)
        return paramString.equals("false");
    }
    while (i != 78);
    return paramString.equals("NaN");
  }

  public static boolean b(char paramChar)
  {
    return (paramChar == '\b') || (paramChar == '\f') || (paramChar == '\n');
  }

  public static boolean c(char paramChar)
  {
    return (paramChar == '}') || (paramChar == ']') || (paramChar == ',') || (paramChar == ':');
  }

  public static boolean d(char paramChar)
  {
    return (paramChar == '{') || (paramChar == '[') || (paramChar == ',') || (paramChar == '}') || (paramChar == ']') || (paramChar == ':') || (paramChar == '\'') || (paramChar == '"');
  }

  public static boolean e(char paramChar)
  {
    return ((paramChar >= 0) && (paramChar <= '\037')) || ((paramChar >= '') && (paramChar <= '')) || ((paramChar >= ' ') && (paramChar <= '⃿'));
  }

  private static class a
    implements j.g
  {
    public void a(String paramString, Appendable paramAppendable)
    {
      int i;
      int j;
      int k;
      try
      {
        i = paramString.length();
        j = 0;
        break label305;
        k = paramString.charAt(j);
        switch (k)
        {
        case 34:
          label96: paramAppendable.append("\\u");
          paramAppendable.append("0123456789ABCDEF".charAt(0xF & k >> 12));
          paramAppendable.append("0123456789ABCDEF".charAt(0xF & k >> 8));
          paramAppendable.append("0123456789ABCDEF".charAt(0xF & k >> 4));
          paramAppendable.append("0123456789ABCDEF".charAt(0xF & k >> 0));
          break label359;
          paramAppendable.append("\\\"");
        case 92:
        case 8:
        case 12:
        case 10:
        case 13:
        case 9:
        case 47:
        }
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException("Impossible Error");
      }
      paramAppendable.append("\\\\");
      break label359;
      paramAppendable.append("\\b");
      break label359;
      paramAppendable.append("\\f");
      break label359;
      paramAppendable.append("\\n");
      break label359;
      paramAppendable.append("\\r");
      break label359;
      paramAppendable.append("\\t");
      break label359;
      paramAppendable.append("\\/");
      break label359;
      label293: paramAppendable.append(k);
      label305: 
      while (j >= i)
      {
        return;
        if (((k >= 0) && (k <= 31)) || ((k >= 127) && (k <= 159)))
          break label96;
        if ((k < 8192) || (k > 8447))
          break label293;
        break label96;
        label359: j++;
      }
    }
  }

  private static class b
    implements j.g
  {
    public void a(String paramString, Appendable paramAppendable)
    {
      int i;
      int j;
      int k;
      try
      {
        i = paramString.length();
        j = 0;
        break label285;
        k = paramString.charAt(j);
        switch (k)
        {
        case 34:
          label88: paramAppendable.append("\\u");
          paramAppendable.append("0123456789ABCDEF".charAt(0xF & k >> 12));
          paramAppendable.append("0123456789ABCDEF".charAt(0xF & k >> 8));
          paramAppendable.append("0123456789ABCDEF".charAt(0xF & k >> 4));
          paramAppendable.append("0123456789ABCDEF".charAt(0xF & k >> 0));
          break label339;
          paramAppendable.append("\\\"");
        case 92:
        case 8:
        case 12:
        case 10:
        case 13:
        case 9:
        }
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException("Impossible Exeption");
      }
      paramAppendable.append("\\\\");
      break label339;
      paramAppendable.append("\\b");
      break label339;
      paramAppendable.append("\\f");
      break label339;
      paramAppendable.append("\\n");
      break label339;
      paramAppendable.append("\\r");
      break label339;
      paramAppendable.append("\\t");
      break label339;
      label273: paramAppendable.append(k);
      label285: 
      while (j >= i)
      {
        return;
        if (((k >= 0) && (k <= 31)) || ((k >= 127) && (k <= 159)))
          break label88;
        if ((k < 8192) || (k > 8447))
          break label273;
        break label88;
        label339: j++;
      }
    }
  }

  private static class c
    implements j.f
  {
    public boolean a(String paramString)
    {
      if (paramString == null)
        break label291;
      label4: int i;
      int m;
      do
      {
        do
        {
          int k;
          do
          {
            return false;
            i = paramString.length();
            if (i == 0)
              return true;
            if (paramString.trim() != paramString)
              return true;
            char c1 = paramString.charAt(0);
            if ((j.d(c1)) || (j.e(c1)))
              return true;
            for (int j = 1; ; j++)
            {
              if (j >= i)
              {
                if (!j.a(paramString))
                  break;
                return true;
              }
              char c2 = paramString.charAt(j);
              if ((j.c(c2)) || (j.e(c2)))
                return true;
            }
            k = paramString.charAt(0);
          }
          while (((k < 48) || (k > 57)) && (k != 45));
          for (m = 1; ; m++)
          {
            if (m >= i);
            do
            {
              if (m != i)
                break;
              return true;
              k = paramString.charAt(m);
            }
            while ((k < 48) || (k > 57));
          }
          if (k == 46)
            m++;
          while (true)
          {
            if (m >= i);
            do
            {
              if (m != i)
                break;
              return true;
              k = paramString.charAt(m);
            }
            while ((k < 48) || (k > 57));
            m++;
          }
          if ((k != 69) && (k != 101))
            break;
          m++;
        }
        while (m == i);
        int n = paramString.charAt(m);
        if ((n == 43) || (n == 45))
        {
          m++;
          paramString.charAt(m);
        }
      }
      while (m == i);
      while (true)
      {
        if (m >= i)
        {
          label291: if (m != i)
            break label4;
          return true;
        }
        int i1 = paramString.charAt(m);
        if ((i1 < 48) || (i1 > 57))
          break;
        m++;
      }
    }
  }

  private static class d
    implements j.f
  {
    public boolean a(String paramString)
    {
      if (paramString == null)
        return false;
      int i = paramString.length();
      if (i == 0)
        return true;
      if (paramString.trim() != paramString)
        return true;
      int j = paramString.charAt(0);
      if (((j >= 48) && (j <= 57)) || (j == 45))
        return true;
      for (int k = 0; ; k++)
      {
        if (k >= i)
        {
          if (!j.a(paramString))
            break;
          return true;
        }
        char c = paramString.charAt(k);
        if (j.a(c))
          return true;
        if (j.d(c))
          return true;
        if (j.b(c))
          return true;
        if (j.e(c))
          return true;
      }
    }
  }

  private static class e
    implements j.f
  {
    public boolean a(String paramString)
    {
      return true;
    }
  }

  public static abstract interface f
  {
    public abstract boolean a(String paramString);
  }

  public static abstract interface g
  {
    public abstract void a(String paramString, Appendable paramAppendable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     e.a.b.j
 * JD-Core Version:    0.6.2
 */