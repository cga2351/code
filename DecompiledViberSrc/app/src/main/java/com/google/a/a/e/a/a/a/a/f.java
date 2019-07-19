package com.google.a.a.e.a.a.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class f
{
  private final b a;
  private final boolean b;
  private final b c;
  private final int d;

  private f(b paramb)
  {
    this(paramb, false, b.m, 2147483647);
  }

  private f(b paramb, boolean paramBoolean, b paramb1, int paramInt)
  {
    this.c = paramb;
    this.b = paramBoolean;
    this.a = paramb1;
    this.d = paramInt;
  }

  public static f a(char paramChar)
  {
    return a(b.a(paramChar));
  }

  public static f a(b paramb)
  {
    e.a(paramb);
    return new f(new b()
    {
      public f.a a(f paramAnonymousf, CharSequence paramAnonymousCharSequence)
      {
        return new f.a(paramAnonymousf, paramAnonymousCharSequence)
        {
          int a(int paramAnonymous2Int)
          {
            return f.1.this.a.a(this.b, paramAnonymous2Int);
          }

          int b(int paramAnonymous2Int)
          {
            return paramAnonymous2Int + 1;
          }
        };
      }
    });
  }

  private Iterator<String> b(CharSequence paramCharSequence)
  {
    return this.c.b(this, paramCharSequence);
  }

  public List<String> a(CharSequence paramCharSequence)
  {
    e.a(paramCharSequence);
    Iterator localIterator = b(paramCharSequence);
    ArrayList localArrayList = new ArrayList();
    while (localIterator.hasNext())
      localArrayList.add(localIterator.next());
    return Collections.unmodifiableList(localArrayList);
  }

  private static abstract class a extends a<String>
  {
    final CharSequence b;
    final b c;
    final boolean d;
    int e = 0;
    int f;

    protected a(f paramf, CharSequence paramCharSequence)
    {
      this.c = f.a(paramf);
      this.d = f.b(paramf);
      this.f = f.c(paramf);
      this.b = paramCharSequence;
    }

    abstract int a(int paramInt);

    abstract int b(int paramInt);

    protected String c()
    {
      int i = this.e;
      int j;
      if (this.e != -1)
      {
        j = a(this.e);
        if (j == -1)
          j = this.b.length();
        for (this.e = -1; ; this.e = b(j))
        {
          if (this.e != i)
            break label284;
          this.e = (1 + this.e);
          if (this.e < this.b.length())
            break;
          this.e = -1;
          break;
        }
      }
      while (true)
      {
        int k;
        if ((k < j) && (this.c.b(this.b.charAt(k))))
        {
          k++;
        }
        else
        {
          while (true)
          {
            int m;
            if ((m > k) && (this.c.b(this.b.charAt(m - 1))))
            {
              m--;
            }
            else
            {
              if ((this.d) && (k == m))
              {
                i = this.e;
                break;
              }
              if (this.f == 1)
              {
                m = this.b.length();
                this.e = -1;
                while ((m > k) && (this.c.b(this.b.charAt(m - 1))))
                  m--;
              }
              this.f = (-1 + this.f);
              return this.b.subSequence(k, m).toString();
              return (String)b();
              m = j;
            }
          }
          label284: k = i;
        }
      }
    }
  }

  private static abstract interface b
  {
    public abstract Iterator<String> b(f paramf, CharSequence paramCharSequence);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.e.a.a.a.a.f
 * JD-Core Version:    0.6.2
 */