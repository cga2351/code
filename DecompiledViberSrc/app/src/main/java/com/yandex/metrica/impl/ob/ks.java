package com.yandex.metrica.impl.ob;

import java.io.IOException;

public abstract interface ks
{
  public static final class a extends e
  {
    public a[] b;
    public String c;
    public long d;
    public boolean e;
    public boolean f;

    public a()
    {
      d();
    }

    public void a(b paramb)
      throws IOException
    {
      if ((this.b != null) && (this.b.length > 0))
        for (int i = 0; i < this.b.length; i++)
        {
          a locala = this.b[i];
          if (locala != null)
            paramb.a(1, locala);
        }
      paramb.a(2, this.c);
      paramb.b(3, this.d);
      paramb.a(4, this.e);
      paramb.a(5, this.f);
      super.a(paramb);
    }

    public a b(a parama)
      throws IOException
    {
      while (true)
      {
        int i = parama.a();
        switch (i)
        {
        default:
          if (g.a(parama, i))
            continue;
        case 0:
          return this;
        case 10:
          int j = g.b(parama, 10);
          if (this.b == null);
          a[] arrayOfa;
          for (int k = 0; ; k = this.b.length)
          {
            arrayOfa = new a[j + k];
            if (k != 0)
              System.arraycopy(this.b, 0, arrayOfa, 0, k);
            while (k < -1 + arrayOfa.length)
            {
              arrayOfa[k] = new a();
              parama.a(arrayOfa[k]);
              parama.a();
              k++;
            }
          }
          arrayOfa[k] = new a();
          parama.a(arrayOfa[k]);
          this.b = arrayOfa;
          break;
        case 18:
          this.c = parama.i();
          break;
        case 24:
          this.d = parama.f();
          break;
        case 32:
          this.e = parama.h();
          break;
        case 40:
        }
        this.f = parama.h();
      }
    }

    protected int c()
    {
      int i = super.c();
      if ((this.b != null) && (this.b.length > 0))
        for (int j = 0; j < this.b.length; j++)
        {
          a locala = this.b[j];
          if (locala != null)
            i += b.b(1, locala);
        }
      return i + b.b(2, this.c) + b.d(3, this.d) + b.f(4) + b.f(5);
    }

    public a d()
    {
      this.b = a.d();
      this.c = "";
      this.d = 0L;
      this.e = false;
      this.f = false;
      this.a = -1;
      return this;
    }

    public static final class a extends e
    {
      private static volatile a[] d;
      public String b;
      public String[] c;

      public a()
      {
        e();
      }

      public static a[] d()
      {
        if (d == null);
        synchronized (c.a)
        {
          if (d == null)
            d = new a[0];
          return d;
        }
      }

      public void a(b paramb)
        throws IOException
      {
        paramb.a(1, this.b);
        if ((this.c != null) && (this.c.length > 0))
          for (int i = 0; i < this.c.length; i++)
          {
            String str = this.c[i];
            if (str != null)
              paramb.a(2, str);
          }
        super.a(paramb);
      }

      public a b(a parama)
        throws IOException
      {
        while (true)
        {
          int i = parama.a();
          switch (i)
          {
          default:
            if (g.a(parama, i))
              continue;
          case 0:
            return this;
          case 10:
            this.b = parama.i();
            break;
          case 18:
          }
          int j = g.b(parama, 18);
          if (this.c == null);
          String[] arrayOfString;
          for (int k = 0; ; k = this.c.length)
          {
            arrayOfString = new String[j + k];
            if (k != 0)
              System.arraycopy(this.c, 0, arrayOfString, 0, k);
            while (k < -1 + arrayOfString.length)
            {
              arrayOfString[k] = parama.i();
              parama.a();
              k++;
            }
          }
          arrayOfString[k] = parama.i();
          this.c = arrayOfString;
        }
      }

      protected int c()
      {
        int i = 0;
        int j = super.c() + b.b(1, this.b);
        if ((this.c != null) && (this.c.length > 0))
        {
          int k = 0;
          int m = 0;
          while (i < this.c.length)
          {
            String str = this.c[i];
            if (str != null)
            {
              m++;
              k += b.b(str);
            }
            i++;
          }
          return j + k + m * 1;
        }
        return j;
      }

      public a e()
      {
        this.b = "";
        this.c = g.b;
        this.a = -1;
        return this;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ks
 * JD-Core Version:    0.6.2
 */