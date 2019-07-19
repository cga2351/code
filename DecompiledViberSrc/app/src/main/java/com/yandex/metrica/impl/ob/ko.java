package com.yandex.metrica.impl.ob;

import java.io.IOException;
import java.util.Arrays;

public abstract interface ko
{
  public static final class a extends e
  {
    public a[] b;

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
        }
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
      return i;
    }

    public a d()
    {
      this.b = a.d();
      this.a = -1;
      return this;
    }

    public static final class a extends e
    {
      private static volatile a[] f;
      public byte[] b;
      public int c;
      public ko.a.b d;
      public ko.a.c e;

      public a()
      {
        e();
      }

      public static a[] d()
      {
        if (f == null);
        synchronized (c.a)
        {
          if (f == null)
            f = new a[0];
          return f;
        }
      }

      public void a(b paramb)
        throws IOException
      {
        paramb.a(1, this.b);
        paramb.a(2, this.c);
        if (this.d != null)
          paramb.a(3, this.d);
        if (this.e != null)
          paramb.a(4, this.e);
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
            this.b = parama.j();
            break;
          case 16:
            int j = parama.g();
            switch (j)
            {
            default:
              break;
            case 0:
            case 1:
            case 2:
            case 3:
            }
            this.c = j;
            break;
          case 26:
            if (this.d == null)
              this.d = new ko.a.b();
            parama.a(this.d);
            break;
          case 34:
          }
          if (this.e == null)
            this.e = new ko.a.c();
          parama.a(this.e);
        }
      }

      protected int c()
      {
        int i = super.c() + b.b(1, this.b) + b.d(2, this.c);
        if (this.d != null)
          i += b.b(3, this.d);
        if (this.e != null)
          i += b.b(4, this.e);
        return i;
      }

      public a e()
      {
        this.b = g.c;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.a = -1;
        return this;
      }
    }

    public static final class b extends e
    {
      public boolean b;
      public boolean c;

      public b()
      {
        d();
      }

      public void a(b paramb)
        throws IOException
      {
        if (this.b)
          paramb.a(1, this.b);
        if (this.c)
          paramb.a(2, this.c);
        super.a(paramb);
      }

      public b b(a parama)
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
          case 8:
            this.b = parama.h();
            break;
          case 16:
          }
          this.c = parama.h();
        }
      }

      protected int c()
      {
        int i = super.c();
        if (this.b)
          i += b.f(1);
        if (this.c)
          i += b.f(2);
        return i;
      }

      public b d()
      {
        this.b = false;
        this.c = false;
        this.a = -1;
        return this;
      }
    }

    public static final class c extends e
    {
      public byte[] b;
      public double c;
      public double d;
      public boolean e;

      public c()
      {
        d();
      }

      public void a(b paramb)
        throws IOException
      {
        if (!Arrays.equals(this.b, g.c))
          paramb.a(1, this.b);
        if (Double.doubleToLongBits(this.c) != Double.doubleToLongBits(0.0D))
          paramb.a(2, this.c);
        if (Double.doubleToLongBits(this.d) != Double.doubleToLongBits(0.0D))
          paramb.a(3, this.d);
        if (this.e)
          paramb.a(4, this.e);
        super.a(paramb);
      }

      public c b(a parama)
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
            this.b = parama.j();
            break;
          case 17:
            this.c = parama.c();
            break;
          case 25:
            this.d = parama.c();
            break;
          case 32:
          }
          this.e = parama.h();
        }
      }

      protected int c()
      {
        int i = super.c();
        if (!Arrays.equals(this.b, g.c))
          i += b.b(1, this.b);
        if (Double.doubleToLongBits(this.c) != Double.doubleToLongBits(0.0D))
          i += b.d(2);
        if (Double.doubleToLongBits(this.d) != Double.doubleToLongBits(0.0D))
          i += b.d(3);
        if (this.e)
          i += b.f(4);
        return i;
      }

      public c d()
      {
        this.b = g.c;
        this.c = 0.0D;
        this.d = 0.0D;
        this.e = false;
        this.a = -1;
        return this;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ko
 * JD-Core Version:    0.6.2
 */