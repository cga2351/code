package com.yandex.metrica.impl.ob;

import java.io.IOException;

public abstract interface kr
{
  public static final class a extends e
  {
    public a[] b;
    public String[] c;

    public a()
    {
      d();
    }

    public void a(b paramb)
      throws IOException
    {
      if ((this.b != null) && (this.b.length > 0))
        for (int k = 0; k < this.b.length; k++)
        {
          a locala = this.b[k];
          if (locala != null)
            paramb.a(1, locala);
        }
      if (this.c != null)
      {
        int i = this.c.length;
        int j = 0;
        if (i > 0)
          while (j < this.c.length)
          {
            String str = this.c[j];
            if (str != null)
              paramb.a(2, str);
            j++;
          }
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
          int m = g.b(parama, 10);
          if (this.b == null);
          a[] arrayOfa;
          for (int n = 0; ; n = this.b.length)
          {
            arrayOfa = new a[m + n];
            if (n != 0)
              System.arraycopy(this.b, 0, arrayOfa, 0, n);
            while (n < -1 + arrayOfa.length)
            {
              arrayOfa[n] = new a();
              parama.a(arrayOfa[n]);
              parama.a();
              n++;
            }
          }
          arrayOfa[n] = new a();
          parama.a(arrayOfa[n]);
          this.b = arrayOfa;
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
      int j = super.c();
      if ((this.b != null) && (this.b.length > 0))
      {
        int n = j;
        for (int i1 = 0; i1 < this.b.length; i1++)
        {
          a locala = this.b[i1];
          if (locala != null)
            n += b.b(1, locala);
        }
        j = n;
      }
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
        j = j + k + m * 1;
      }
      return j;
    }

    public a d()
    {
      this.b = a.d();
      this.c = g.b;
      this.a = -1;
      return this;
    }

    public static final class a extends e
    {
      private static volatile a[] h;
      public String b;
      public String c;
      public String d;
      public a[] e;
      public long f;
      public int[] g;

      public a()
      {
        e();
      }

      public static a[] d()
      {
        if (h == null);
        synchronized (c.a)
        {
          if (h == null)
            h = new a[0];
          return h;
        }
      }

      public void a(b paramb)
        throws IOException
      {
        paramb.a(1, this.b);
        paramb.a(2, this.c);
        paramb.a(3, this.d);
        if ((this.e != null) && (this.e.length > 0))
          for (int k = 0; k < this.e.length; k++)
          {
            a locala = this.e[k];
            if (locala != null)
              paramb.a(4, locala);
          }
        paramb.a(5, this.f);
        if (this.g != null)
        {
          int i = this.g.length;
          int j = 0;
          if (i > 0)
            while (j < this.g.length)
            {
              paramb.a(6, this.g[j]);
              j++;
            }
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
            this.c = parama.i();
            break;
          case 26:
            this.d = parama.i();
            break;
          case 34:
            int i9 = g.b(parama, 34);
            if (this.e == null);
            a[] arrayOfa;
            for (int i10 = 0; ; i10 = this.e.length)
            {
              arrayOfa = new a[i9 + i10];
              if (i10 != 0)
                System.arraycopy(this.e, 0, arrayOfa, 0, i10);
              while (i10 < -1 + arrayOfa.length)
              {
                arrayOfa[i10] = new a();
                parama.a(arrayOfa[i10]);
                parama.a();
                i10++;
              }
            }
            arrayOfa[i10] = new a();
            parama.a(arrayOfa[i10]);
            this.e = arrayOfa;
            break;
          case 40:
            this.f = parama.e();
            break;
          case 48:
            int i3 = g.b(parama, 48);
            int[] arrayOfInt2 = new int[i3];
            int i4 = 0;
            int i5 = 0;
            if (i4 < i3)
            {
              if (i4 != 0)
                parama.a();
              int i7 = parama.g();
              int i8;
              switch (i7)
              {
              default:
                i8 = i5;
              case 1:
              case 2:
              }
              while (true)
              {
                i4++;
                i5 = i8;
                break;
                i8 = i5 + 1;
                arrayOfInt2[i5] = i7;
              }
            }
            if (i5 == 0)
              continue;
            if (this.g == null);
            for (int i6 = 0; ; i6 = this.g.length)
            {
              if ((i6 != 0) || (i5 != i3))
                break label404;
              this.g = arrayOfInt2;
              break;
            }
            label404: int[] arrayOfInt3 = new int[i6 + i5];
            if (i6 != 0)
              System.arraycopy(this.g, 0, arrayOfInt3, 0, i6);
            System.arraycopy(arrayOfInt2, 0, arrayOfInt3, i6, i5);
            this.g = arrayOfInt3;
            break;
          case 50:
          }
          int j = parama.c(parama.m());
          int k = parama.s();
          int m = 0;
          while (parama.q() > 0)
            switch (parama.g())
            {
            default:
              break;
            case 1:
            case 2:
              m++;
            }
          if (m != 0)
          {
            parama.e(k);
            if (this.g == null);
            int[] arrayOfInt1;
            for (int n = 0; ; n = this.g.length)
            {
              arrayOfInt1 = new int[m + n];
              if (n != 0)
                System.arraycopy(this.g, 0, arrayOfInt1, 0, n);
              while (parama.q() > 0)
              {
                int i1 = parama.g();
                switch (i1)
                {
                default:
                  break;
                case 1:
                case 2:
                  int i2 = n + 1;
                  arrayOfInt1[n] = i1;
                  n = i2;
                }
              }
            }
            this.g = arrayOfInt1;
          }
          parama.d(j);
        }
      }

      protected int c()
      {
        int i = 0;
        int j = super.c() + b.b(1, this.b) + b.b(2, this.c) + b.b(3, this.d);
        if ((this.e != null) && (this.e.length > 0))
        {
          int n = j;
          for (int i1 = 0; i1 < this.e.length; i1++)
          {
            a locala = this.e[i1];
            if (locala != null)
              n += b.b(4, locala);
          }
          j = n;
        }
        int k = j + b.c(5, this.f);
        if ((this.g != null) && (this.g.length > 0))
        {
          int m = 0;
          while (i < this.g.length)
          {
            m += b.g(this.g[i]);
            i++;
          }
          return m + k + 1 * this.g.length;
        }
        return k;
      }

      public a e()
      {
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = a.d();
        this.f = 0L;
        this.g = g.a;
        this.a = -1;
        return this;
      }

      public static final class a extends e
      {
        private static volatile a[] d;
        public String b;
        public String c;

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
            case 18:
            }
            this.c = parama.i();
          }
        }

        protected int c()
        {
          return super.c() + b.b(1, this.b) + b.b(2, this.c);
        }

        public a e()
        {
          this.b = "";
          this.c = "";
          this.a = -1;
          return this;
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.kr
 * JD-Core Version:    0.6.2
 */