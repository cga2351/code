package com.viber.voip.messages.extensions.d;

import com.viber.voip.messages.extensions.d.a.b;
import com.viber.voip.util.i.e;
import java.util.HashMap;
import java.util.Map;

public class a
{
  private final e a;
  private final Map<String, b> b;
  private final a c;

  public a(e parame, boolean paramBoolean)
  {
    this.a = parame;
    this.b = new HashMap();
    if (paramBoolean)
    {
      this.c = new b(null);
      return;
    }
    this.c = new c(null);
  }

  public b a(String paramString, int paramInt)
  {
    String str = this.c.a(paramString.toLowerCase(), paramInt);
    if (str != null)
    {
      b localb = (b)this.b.get(str);
      if ((!localb.a()) || (localb.a(this.a.a())))
        return localb;
    }
    return null;
  }

  public void a()
  {
    this.b.clear();
    this.c.a();
  }

  public void a(b paramb)
  {
    this.b.put(paramb.a, paramb);
    this.c.a(paramb.a);
  }

  private static abstract class a
  {
    protected final a a = new a();

    protected static boolean a(char paramChar)
    {
      return (Character.isWhitespace(paramChar)) || (b(paramChar));
    }

    private static boolean b(char paramChar)
    {
      return (paramChar == '!') || (paramChar == '?') || (paramChar == '.') || (paramChar == ',') || (paramChar == ';') || (paramChar == ':') || (paramChar == '(') || (paramChar == ')') || (paramChar == '[') || (paramChar == ']') || (paramChar == '"') || (paramChar == '*');
    }

    abstract String a(String paramString, int paramInt);

    void a()
    {
      this.a.a.clear();
      this.a.b = false;
    }

    abstract void a(String paramString);

    protected static class a
    {
      Map<Character, a> a = new HashMap(1);
      boolean b;
    }
  }

  private static class b extends a.a
  {
    private b()
    {
      super();
    }

    String a(String paramString, int paramInt)
    {
      int i = paramString.length();
      int j = i - 1;
      int k = 0;
      int m;
      a.a.a locala2;
      int n;
      label35: int i1;
      int i2;
      if (j >= 0)
      {
        a.a.a locala1 = this.a;
        m = 1;
        locala2 = locala1;
        n = j;
        if (n < 0)
          break label219;
        char c = paramString.charAt(n);
        locala2 = (a.a.a)locala2.a.get(Character.valueOf(c));
        if (locala2 == null)
        {
          if (j == n)
            break label219;
          i1 = n + 1;
          i2 = k;
        }
      }
      while (true)
      {
        int i3 = i1 - 1;
        k = i2;
        j = i3;
        break;
        if ((m != 0) && (n != i - 1) && (!a(paramString.charAt(n + 1))))
        {
          i1 = j;
          i2 = k;
        }
        else if ((locala2.b) && ((n - 1 < 0) || (a(paramString.charAt(n - 1)))))
        {
          int i4 = k + 1;
          if (k == paramInt)
            return paramString.substring(n, j + 1);
          i2 = i4;
          i1 = n;
        }
        else
        {
          n--;
          m = 0;
          break label35;
          return null;
          label219: i1 = j;
          i2 = k;
        }
      }
    }

    void a(String paramString)
    {
      a.a.a locala1 = this.a;
      int i = -1 + paramString.length();
      Object localObject = locala1;
      int j = i;
      while (j >= 0)
      {
        char c = paramString.charAt(j);
        a.a.a locala2 = (a.a.a)((a.a.a)localObject).a.get(Character.valueOf(c));
        if (locala2 == null)
        {
          locala2 = new a.a.a();
          ((a.a.a)localObject).a.put(Character.valueOf(c), locala2);
        }
        j--;
        localObject = locala2;
      }
      ((a.a.a)localObject).b = true;
    }
  }

  private static class c extends a.a
  {
    private c()
    {
      super();
    }

    String a(String paramString, int paramInt)
    {
      int i = paramString.length();
      int j = 0;
      int k = 0;
      int m;
      a.a.a locala2;
      int n;
      label34: int i1;
      int i2;
      if (j < i)
      {
        a.a.a locala1 = this.a;
        m = 1;
        locala2 = locala1;
        n = j;
        if (n >= i)
          break label217;
        char c = paramString.charAt(n);
        locala2 = (a.a.a)locala2.a.get(Character.valueOf(c));
        if (locala2 == null)
        {
          if (j == n)
            break label217;
          i1 = n - 1;
          i2 = k;
        }
      }
      while (true)
      {
        int i3 = i1 + 1;
        k = i2;
        j = i3;
        break;
        if ((m != 0) && (n != 0) && (!a(paramString.charAt(n - 1))))
        {
          i1 = j;
          i2 = k;
        }
        else if ((locala2.b) && ((n + 1 == i) || (a(paramString.charAt(n + 1)))))
        {
          int i4 = k + 1;
          if (k == paramInt)
            return paramString.substring(j, n + 1);
          i2 = i4;
          i1 = n;
        }
        else
        {
          n++;
          m = 0;
          break label34;
          return null;
          label217: i1 = j;
          i2 = k;
        }
      }
    }

    void a(String paramString)
    {
      a.a.a locala1 = this.a;
      int i = paramString.length();
      Object localObject = locala1;
      int j = 0;
      while (j < i)
      {
        char c = paramString.charAt(j);
        a.a.a locala2 = (a.a.a)((a.a.a)localObject).a.get(Character.valueOf(c));
        if (locala2 == null)
        {
          locala2 = new a.a.a();
          ((a.a.a)localObject).a.put(Character.valueOf(c), locala2);
        }
        j++;
        localObject = locala2;
      }
      ((a.a.a)localObject).b = true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.d.a
 * JD-Core Version:    0.6.2
 */