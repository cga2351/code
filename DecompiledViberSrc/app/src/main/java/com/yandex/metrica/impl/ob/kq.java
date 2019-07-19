package com.yandex.metrica.impl.ob;

import java.io.IOException;

public abstract interface kq
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
      private static volatile a[] d;
      public String b;
      public boolean c;

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
        paramb.a(2, this.c);
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
          case 16:
          }
          this.c = parama.h();
        }
      }

      protected int c()
      {
        return super.c() + b.b(1, this.b) + b.f(2);
      }

      public a e()
      {
        this.b = "";
        this.c = false;
        this.a = -1;
        return this;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.kq
 * JD-Core Version:    0.6.2
 */