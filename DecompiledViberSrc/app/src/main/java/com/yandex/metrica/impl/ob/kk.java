package com.yandex.metrica.impl.ob;

import java.io.IOException;
import java.util.Arrays;

public abstract interface kk
{
  public static final class a extends e
  {
    private static volatile a[] k;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public String g;
    public boolean h;
    public int i;
    public int j;

    public a()
    {
      e();
    }

    public static a[] d()
    {
      if (k == null);
      synchronized (c.a)
      {
        if (k == null)
          k = new a[0];
        return k;
      }
    }

    public void a(b paramb)
      throws IOException
    {
      if (this.b != -1)
        paramb.b(1, this.b);
      if (this.c != 0)
        paramb.c(2, this.c);
      if (this.d != -1)
        paramb.b(3, this.d);
      if (this.e != -1)
        paramb.b(4, this.e);
      if (this.f != -1)
        paramb.b(5, this.f);
      if (!this.g.equals(""))
        paramb.a(6, this.g);
      if (this.h)
        paramb.a(7, this.h);
      if (this.i != 0)
        paramb.a(8, this.i);
      if (this.j != -1)
        paramb.b(9, this.j);
      super.a(paramb);
    }

    public a b(a parama)
      throws IOException
    {
      while (true)
      {
        int m = parama.a();
        switch (m)
        {
        default:
          if (g.a(parama, m))
            continue;
        case 0:
          return this;
        case 8:
          this.b = parama.k();
          break;
        case 16:
          this.c = parama.l();
          break;
        case 24:
          this.d = parama.k();
          break;
        case 32:
          this.e = parama.k();
          break;
        case 40:
          this.f = parama.k();
          break;
        case 50:
          this.g = parama.i();
          break;
        case 56:
          this.h = parama.h();
          break;
        case 64:
          int n = parama.g();
          switch (n)
          {
          default:
            break;
          case 0:
          case 1:
          case 2:
          case 3:
          case 4:
          }
          this.i = n;
          break;
        case 72:
        }
        this.j = parama.k();
      }
    }

    protected int c()
    {
      int m = super.c();
      if (this.b != -1)
        m += b.e(1, this.b);
      if (this.c != 0)
        m += b.f(2, this.c);
      if (this.d != -1)
        m += b.e(3, this.d);
      if (this.e != -1)
        m += b.e(4, this.e);
      if (this.f != -1)
        m += b.e(5, this.f);
      if (!this.g.equals(""))
        m += b.b(6, this.g);
      if (this.h)
        m += b.f(7);
      if (this.i != 0)
        m += b.d(8, this.i);
      if (this.j != -1)
        m += b.e(9, this.j);
      return m;
    }

    public a e()
    {
      this.b = -1;
      this.c = 0;
      this.d = -1;
      this.e = -1;
      this.f = -1;
      this.g = "";
      this.h = false;
      this.i = 0;
      this.j = -1;
      this.a = -1;
      return this;
    }
  }

  public static final class b extends e
  {
    public b[] b;
    public a[] c;

    public b()
    {
      d();
    }

    public void a(b paramb)
      throws IOException
    {
      if ((this.b != null) && (this.b.length > 0))
        for (int k = 0; k < this.b.length; k++)
        {
          b localb = this.b[k];
          if (localb != null)
            paramb.a(1, localb);
        }
      if (this.c != null)
      {
        int i = this.c.length;
        int j = 0;
        if (i > 0)
          while (j < this.c.length)
          {
            a locala = this.c[j];
            if (locala != null)
              paramb.a(2, locala);
            j++;
          }
      }
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
        case 10:
          int m = g.b(parama, 10);
          if (this.b == null);
          b[] arrayOfb;
          for (int n = 0; ; n = this.b.length)
          {
            arrayOfb = new b[m + n];
            if (n != 0)
              System.arraycopy(this.b, 0, arrayOfb, 0, n);
            while (n < -1 + arrayOfb.length)
            {
              arrayOfb[n] = new b();
              parama.a(arrayOfb[n]);
              parama.a();
              n++;
            }
          }
          arrayOfb[n] = new b();
          parama.a(arrayOfb[n]);
          this.b = arrayOfb;
          break;
        case 18:
        }
        int j = g.b(parama, 18);
        if (this.c == null);
        a[] arrayOfa;
        for (int k = 0; ; k = this.c.length)
        {
          arrayOfa = new a[j + k];
          if (k != 0)
            System.arraycopy(this.c, 0, arrayOfa, 0, k);
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
        this.c = arrayOfa;
      }
    }

    protected int c()
    {
      int i = super.c();
      if ((this.b != null) && (this.b.length > 0))
      {
        int m = i;
        for (int n = 0; n < this.b.length; n++)
        {
          b localb = this.b[n];
          if (localb != null)
            m += b.b(1, localb);
        }
        i = m;
      }
      if (this.c != null)
      {
        int j = this.c.length;
        int k = 0;
        if (j > 0)
          while (k < this.c.length)
          {
            a locala = this.c[k];
            if (locala != null)
              i += b.b(2, locala);
            k++;
          }
      }
      return i;
    }

    public b d()
    {
      this.b = b.d();
      this.c = a.d();
      this.a = -1;
      return this;
    }

    public static final class a extends e
    {
      private static volatile a[] f;
      public long b;
      public long c;
      public kk.a[] d;
      public kk.d[] e;

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
        if ((this.d != null) && (this.d.length > 0))
          for (int k = 0; k < this.d.length; k++)
          {
            kk.a locala = this.d[k];
            if (locala != null)
              paramb.a(3, locala);
          }
        if (this.e != null)
        {
          int i = this.e.length;
          int j = 0;
          if (i > 0)
            while (j < this.e.length)
            {
              kk.d locald = this.e[j];
              if (locald != null)
                paramb.a(4, locald);
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
          case 8:
            this.b = parama.e();
            break;
          case 16:
            this.c = parama.e();
            break;
          case 26:
            int m = g.b(parama, 26);
            if (this.d == null);
            kk.a[] arrayOfa;
            for (int n = 0; ; n = this.d.length)
            {
              arrayOfa = new kk.a[m + n];
              if (n != 0)
                System.arraycopy(this.d, 0, arrayOfa, 0, n);
              while (n < -1 + arrayOfa.length)
              {
                arrayOfa[n] = new kk.a();
                parama.a(arrayOfa[n]);
                parama.a();
                n++;
              }
            }
            arrayOfa[n] = new kk.a();
            parama.a(arrayOfa[n]);
            this.d = arrayOfa;
            break;
          case 34:
          }
          int j = g.b(parama, 34);
          if (this.e == null);
          kk.d[] arrayOfd;
          for (int k = 0; ; k = this.e.length)
          {
            arrayOfd = new kk.d[j + k];
            if (k != 0)
              System.arraycopy(this.e, 0, arrayOfd, 0, k);
            while (k < -1 + arrayOfd.length)
            {
              arrayOfd[k] = new kk.d();
              parama.a(arrayOfd[k]);
              parama.a();
              k++;
            }
          }
          arrayOfd[k] = new kk.d();
          parama.a(arrayOfd[k]);
          this.e = arrayOfd;
        }
      }

      protected int c()
      {
        int i = super.c() + b.c(1, this.b) + b.c(2, this.c);
        if ((this.d != null) && (this.d.length > 0))
        {
          int m = i;
          for (int n = 0; n < this.d.length; n++)
          {
            kk.a locala = this.d[n];
            if (locala != null)
              m += b.b(3, locala);
          }
          i = m;
        }
        if (this.e != null)
        {
          int j = this.e.length;
          int k = 0;
          if (j > 0)
            while (k < this.e.length)
            {
              kk.d locald = this.e[k];
              if (locald != null)
                i += b.b(4, locald);
              k++;
            }
        }
        return i;
      }

      public a e()
      {
        this.b = 0L;
        this.c = 0L;
        this.d = kk.a.d();
        this.e = kk.d.d();
        this.a = -1;
        return this;
      }
    }

    public static final class b extends e
    {
      private static volatile b[] m;
      public long b;
      public long c;
      public long d;
      public double e;
      public double f;
      public int g;
      public int h;
      public int i;
      public int j;
      public int k;
      public int l;

      public b()
      {
        e();
      }

      public static b[] d()
      {
        if (m == null);
        synchronized (c.a)
        {
          if (m == null)
            m = new b[0];
          return m;
        }
      }

      public void a(b paramb)
        throws IOException
      {
        paramb.a(1, this.b);
        paramb.a(2, this.c);
        if (this.d != 0L)
          paramb.a(3, this.d);
        paramb.a(4, this.e);
        paramb.a(5, this.f);
        if (this.g != 0)
          paramb.b(6, this.g);
        if (this.h != 0)
          paramb.b(7, this.h);
        if (this.i != 0)
          paramb.b(8, this.i);
        if (this.j != 0)
          paramb.a(9, this.j);
        if (this.k != 0)
          paramb.a(10, this.k);
        if (this.l != 0)
          paramb.a(11, this.l);
        super.a(paramb);
      }

      public b b(a parama)
        throws IOException
      {
        while (true)
        {
          int n = parama.a();
          switch (n)
          {
          default:
            if (g.a(parama, n))
              continue;
          case 0:
            return this;
          case 8:
            this.b = parama.e();
            break;
          case 16:
            this.c = parama.e();
            break;
          case 24:
            this.d = parama.e();
            break;
          case 33:
            this.e = parama.c();
            break;
          case 41:
            this.f = parama.c();
            break;
          case 48:
            this.g = parama.k();
            break;
          case 56:
            this.h = parama.k();
            break;
          case 64:
            this.i = parama.k();
            break;
          case 72:
            this.j = parama.g();
            break;
          case 80:
            int i2 = parama.g();
            switch (i2)
            {
            default:
              break;
            case 0:
            case 1:
            case 2:
            }
            this.k = i2;
            break;
          case 88:
          }
          int i1 = parama.g();
          switch (i1)
          {
          default:
            break;
          case 0:
          case 1:
          }
          this.l = i1;
        }
      }

      protected int c()
      {
        int n = super.c() + b.c(1, this.b) + b.c(2, this.c);
        if (this.d != 0L)
          n += b.c(3, this.d);
        int i1 = n + b.d(4) + b.d(5);
        if (this.g != 0)
          i1 += b.e(6, this.g);
        if (this.h != 0)
          i1 += b.e(7, this.h);
        if (this.i != 0)
          i1 += b.e(8, this.i);
        if (this.j != 0)
          i1 += b.d(9, this.j);
        if (this.k != 0)
          i1 += b.d(10, this.k);
        if (this.l != 0)
          i1 += b.d(11, this.l);
        return i1;
      }

      public b e()
      {
        this.b = 0L;
        this.c = 0L;
        this.d = 0L;
        this.e = 0.0D;
        this.f = 0.0D;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.a = -1;
        return this;
      }
    }
  }

  public static final class c extends e
  {
    public e[] b;
    public d c;
    public a[] d;
    public c[] e;
    public String[] f;
    public f[] g;

    public c()
    {
      d();
    }

    public void a(b paramb)
      throws IOException
    {
      if ((this.b != null) && (this.b.length > 0))
        for (int i1 = 0; i1 < this.b.length; i1++)
        {
          e locale = this.b[i1];
          if (locale != null)
            paramb.a(3, locale);
        }
      if (this.c != null)
        paramb.a(4, this.c);
      if ((this.d != null) && (this.d.length > 0))
        for (int n = 0; n < this.d.length; n++)
        {
          a locala = this.d[n];
          if (locala != null)
            paramb.a(7, locala);
        }
      if ((this.e != null) && (this.e.length > 0))
        for (int m = 0; m < this.e.length; m++)
        {
          c localc = this.e[m];
          if (localc != null)
            paramb.a(8, localc);
        }
      if ((this.f != null) && (this.f.length > 0))
        for (int k = 0; k < this.f.length; k++)
        {
          String str = this.f[k];
          if (str != null)
            paramb.a(9, str);
        }
      if (this.g != null)
      {
        int i = this.g.length;
        int j = 0;
        if (i > 0)
          while (j < this.g.length)
          {
            f localf = this.g[j];
            if (localf != null)
              paramb.a(10, localf);
            j++;
          }
      }
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
        case 26:
          int i5 = g.b(parama, 26);
          if (this.b == null);
          e[] arrayOfe;
          for (int i6 = 0; ; i6 = this.b.length)
          {
            arrayOfe = new e[i5 + i6];
            if (i6 != 0)
              System.arraycopy(this.b, 0, arrayOfe, 0, i6);
            while (i6 < -1 + arrayOfe.length)
            {
              arrayOfe[i6] = new e();
              parama.a(arrayOfe[i6]);
              parama.a();
              i6++;
            }
          }
          arrayOfe[i6] = new e();
          parama.a(arrayOfe[i6]);
          this.b = arrayOfe;
          break;
        case 34:
          if (this.c == null)
            this.c = new d();
          parama.a(this.c);
          break;
        case 58:
          int i3 = g.b(parama, 58);
          if (this.d == null);
          a[] arrayOfa;
          for (int i4 = 0; ; i4 = this.d.length)
          {
            arrayOfa = new a[i3 + i4];
            if (i4 != 0)
              System.arraycopy(this.d, 0, arrayOfa, 0, i4);
            while (i4 < -1 + arrayOfa.length)
            {
              arrayOfa[i4] = new a();
              parama.a(arrayOfa[i4]);
              parama.a();
              i4++;
            }
          }
          arrayOfa[i4] = new a();
          parama.a(arrayOfa[i4]);
          this.d = arrayOfa;
          break;
        case 66:
          int i1 = g.b(parama, 66);
          if (this.e == null);
          c[] arrayOfc;
          for (int i2 = 0; ; i2 = this.e.length)
          {
            arrayOfc = new c[i1 + i2];
            if (i2 != 0)
              System.arraycopy(this.e, 0, arrayOfc, 0, i2);
            while (i2 < -1 + arrayOfc.length)
            {
              arrayOfc[i2] = new c();
              parama.a(arrayOfc[i2]);
              parama.a();
              i2++;
            }
          }
          arrayOfc[i2] = new c();
          parama.a(arrayOfc[i2]);
          this.e = arrayOfc;
          break;
        case 74:
          int m = g.b(parama, 74);
          if (this.f == null);
          String[] arrayOfString;
          for (int n = 0; ; n = this.f.length)
          {
            arrayOfString = new String[m + n];
            if (n != 0)
              System.arraycopy(this.f, 0, arrayOfString, 0, n);
            while (n < -1 + arrayOfString.length)
            {
              arrayOfString[n] = parama.i();
              parama.a();
              n++;
            }
          }
          arrayOfString[n] = parama.i();
          this.f = arrayOfString;
          break;
        case 82:
        }
        int j = g.b(parama, 82);
        if (this.g == null);
        f[] arrayOff;
        for (int k = 0; ; k = this.g.length)
        {
          arrayOff = new f[j + k];
          if (k != 0)
            System.arraycopy(this.g, 0, arrayOff, 0, k);
          while (k < -1 + arrayOff.length)
          {
            arrayOff[k] = new f();
            parama.a(arrayOff[k]);
            parama.a();
            k++;
          }
        }
        arrayOff[k] = new f();
        parama.a(arrayOff[k]);
        this.g = arrayOff;
      }
    }

    protected int c()
    {
      int i = super.c();
      if ((this.b != null) && (this.b.length > 0))
      {
        int i6 = i;
        for (int i7 = 0; i7 < this.b.length; i7++)
        {
          e locale = this.b[i7];
          if (locale != null)
            i6 += b.b(3, locale);
        }
        i = i6;
      }
      if (this.c != null)
        i += b.b(4, this.c);
      if ((this.d != null) && (this.d.length > 0))
      {
        int i4 = i;
        for (int i5 = 0; i5 < this.d.length; i5++)
        {
          a locala = this.d[i5];
          if (locala != null)
            i4 += b.b(7, locala);
        }
        i = i4;
      }
      if ((this.e != null) && (this.e.length > 0))
      {
        int i2 = i;
        for (int i3 = 0; i3 < this.e.length; i3++)
        {
          c localc = this.e[i3];
          if (localc != null)
            i2 += b.b(8, localc);
        }
        i = i2;
      }
      if ((this.f != null) && (this.f.length > 0))
      {
        int m = 0;
        int n = 0;
        int i1 = 0;
        while (m < this.f.length)
        {
          String str = this.f[m];
          if (str != null)
          {
            i1++;
            n += b.b(str);
          }
          m++;
        }
        i = i + n + i1 * 1;
      }
      if (this.g != null)
      {
        int j = this.g.length;
        int k = 0;
        if (j > 0)
          while (k < this.g.length)
          {
            f localf = this.g[k];
            if (localf != null)
              i += b.b(10, localf);
            k++;
          }
      }
      return i;
    }

    public c d()
    {
      this.b = e.d();
      this.c = null;
      this.d = a.d();
      this.e = c.d();
      this.f = g.b;
      this.g = f.d();
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

    public static final class b extends e
    {
      public double b;
      public double c;
      public long d;
      public int e;
      public int f;
      public int g;
      public int h;
      public int i;

      public b()
      {
        d();
      }

      public void a(b paramb)
        throws IOException
      {
        paramb.a(1, this.b);
        paramb.a(2, this.c);
        if (this.d != 0L)
          paramb.a(3, this.d);
        if (this.e != 0)
          paramb.b(4, this.e);
        if (this.f != 0)
          paramb.b(5, this.f);
        if (this.g != 0)
          paramb.b(6, this.g);
        if (this.h != 0)
          paramb.a(7, this.h);
        if (this.i != 0)
          paramb.a(8, this.i);
        super.a(paramb);
      }

      public b b(a parama)
        throws IOException
      {
        while (true)
        {
          int j = parama.a();
          switch (j)
          {
          default:
            if (g.a(parama, j))
              continue;
          case 0:
            return this;
          case 9:
            this.b = parama.c();
            break;
          case 17:
            this.c = parama.c();
            break;
          case 24:
            this.d = parama.e();
            break;
          case 32:
            this.e = parama.k();
            break;
          case 40:
            this.f = parama.k();
            break;
          case 48:
            this.g = parama.k();
            break;
          case 56:
            this.h = parama.g();
            break;
          case 64:
          }
          int k = parama.g();
          switch (k)
          {
          default:
            break;
          case 0:
          case 1:
          case 2:
          }
          this.i = k;
        }
      }

      protected int c()
      {
        int j = super.c() + b.d(1) + b.d(2);
        if (this.d != 0L)
          j += b.c(3, this.d);
        if (this.e != 0)
          j += b.e(4, this.e);
        if (this.f != 0)
          j += b.e(5, this.f);
        if (this.g != 0)
          j += b.e(6, this.g);
        if (this.h != 0)
          j += b.d(7, this.h);
        if (this.i != 0)
          j += b.d(8, this.i);
        return j;
      }

      public b d()
      {
        this.b = 0.0D;
        this.c = 0.0D;
        this.d = 0L;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.a = -1;
        return this;
      }
    }

    public static final class c extends e
    {
      private static volatile c[] d;
      public String b;
      public String c;

      public c()
      {
        e();
      }

      public static c[] d()
      {
        if (d == null);
        synchronized (c.a)
        {
          if (d == null)
            d = new c[0];
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

      public c e()
      {
        this.b = "";
        this.c = "";
        this.a = -1;
        return this;
      }
    }

    public static final class d extends e
    {
      public String b;
      public String c;
      public String d;
      public int e;
      public String f;
      public String g;
      public boolean h;
      public int i;
      public String j;
      public String k;
      public String l;
      public int m;
      public a[] n;
      public String o;

      public d()
      {
        d();
      }

      public void a(b paramb)
        throws IOException
      {
        if (!this.b.equals(""))
          paramb.a(1, this.b);
        if (!this.c.equals(""))
          paramb.a(2, this.c);
        if (!this.d.equals(""))
          paramb.a(4, this.d);
        if (this.e != 0)
          paramb.b(5, this.e);
        if (!this.f.equals(""))
          paramb.a(10, this.f);
        if (!this.g.equals(""))
          paramb.a(15, this.g);
        if (this.h)
          paramb.a(17, this.h);
        if (this.i != 0)
          paramb.b(18, this.i);
        if (!this.j.equals(""))
          paramb.a(19, this.j);
        if (!this.k.equals(""))
          paramb.a(20, this.k);
        if (!this.l.equals(""))
          paramb.a(21, this.l);
        if (this.m != 0)
          paramb.b(22, this.m);
        if ((this.n != null) && (this.n.length > 0))
          for (int i1 = 0; i1 < this.n.length; i1++)
          {
            a locala = this.n[i1];
            if (locala != null)
              paramb.a(23, locala);
          }
        if (!this.o.equals(""))
          paramb.a(24, this.o);
        super.a(paramb);
      }

      public d b(a parama)
        throws IOException
      {
        while (true)
        {
          int i1 = parama.a();
          switch (i1)
          {
          default:
            if (g.a(parama, i1))
              continue;
          case 0:
            return this;
          case 10:
            this.b = parama.i();
            break;
          case 18:
            this.c = parama.i();
            break;
          case 34:
            this.d = parama.i();
            break;
          case 40:
            this.e = parama.k();
            break;
          case 82:
            this.f = parama.i();
            break;
          case 122:
            this.g = parama.i();
            break;
          case 136:
            this.h = parama.h();
            break;
          case 144:
            this.i = parama.k();
            break;
          case 154:
            this.j = parama.i();
            break;
          case 162:
            this.k = parama.i();
            break;
          case 170:
            this.l = parama.i();
            break;
          case 176:
            this.m = parama.k();
            break;
          case 186:
            int i2 = g.b(parama, 186);
            if (this.n == null);
            a[] arrayOfa;
            for (int i3 = 0; ; i3 = this.n.length)
            {
              arrayOfa = new a[i2 + i3];
              if (i3 != 0)
                System.arraycopy(this.n, 0, arrayOfa, 0, i3);
              while (i3 < -1 + arrayOfa.length)
              {
                arrayOfa[i3] = new a();
                parama.a(arrayOfa[i3]);
                parama.a();
                i3++;
              }
            }
            arrayOfa[i3] = new a();
            parama.a(arrayOfa[i3]);
            this.n = arrayOfa;
            break;
          case 194:
          }
          this.o = parama.i();
        }
      }

      protected int c()
      {
        int i1 = super.c();
        if (!this.b.equals(""))
          i1 += b.b(1, this.b);
        if (!this.c.equals(""))
          i1 += b.b(2, this.c);
        if (!this.d.equals(""))
          i1 += b.b(4, this.d);
        if (this.e != 0)
          i1 += b.e(5, this.e);
        if (!this.f.equals(""))
          i1 += b.b(10, this.f);
        if (!this.g.equals(""))
          i1 += b.b(15, this.g);
        if (this.h)
          i1 += b.f(17);
        if (this.i != 0)
          i1 += b.e(18, this.i);
        if (!this.j.equals(""))
          i1 += b.b(19, this.j);
        if (!this.k.equals(""))
          i1 += b.b(20, this.k);
        if (!this.l.equals(""))
          i1 += b.b(21, this.l);
        if (this.m != 0)
          i1 += b.e(22, this.m);
        if ((this.n != null) && (this.n.length > 0))
        {
          int i2 = i1;
          for (int i3 = 0; i3 < this.n.length; i3++)
          {
            a locala = this.n[i3];
            if (locala != null)
              i2 += b.b(23, locala);
          }
          i1 = i2;
        }
        if (!this.o.equals(""))
          i1 += b.b(24, this.o);
        return i1;
      }

      public d d()
      {
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = 0;
        this.f = "";
        this.g = "";
        this.h = false;
        this.i = 0;
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = 0;
        this.n = a.d();
        this.o = "";
        this.a = -1;
        return this;
      }

      public static final class a extends e
      {
        private static volatile a[] d;
        public String b;
        public long c;

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
            this.c = parama.e();
          }
        }

        protected int c()
        {
          return super.c() + b.b(1, this.b) + b.c(2, this.c);
        }

        public a e()
        {
          this.b = "";
          this.c = 0L;
          this.a = -1;
          return this;
        }
      }
    }

    public static final class e extends e
    {
      private static volatile e[] e;
      public long b;
      public b c;
      public a[] d;

      public e()
      {
        e();
      }

      public static e[] d()
      {
        if (e == null);
        synchronized (c.a)
        {
          if (e == null)
            e = new e[0];
          return e;
        }
      }

      public void a(b paramb)
        throws IOException
      {
        paramb.a(1, this.b);
        if (this.c != null)
          paramb.a(2, this.c);
        if ((this.d != null) && (this.d.length > 0))
          for (int i = 0; i < this.d.length; i++)
          {
            a locala = this.d[i];
            if (locala != null)
              paramb.a(3, locala);
          }
        super.a(paramb);
      }

      public e b(a parama)
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
            this.b = parama.e();
            break;
          case 18:
            if (this.c == null)
              this.c = new b();
            parama.a(this.c);
            break;
          case 26:
          }
          int j = g.b(parama, 26);
          if (this.d == null);
          a[] arrayOfa;
          for (int k = 0; ; k = this.d.length)
          {
            arrayOfa = new a[j + k];
            if (k != 0)
              System.arraycopy(this.d, 0, arrayOfa, 0, k);
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
          this.d = arrayOfa;
        }
      }

      protected int c()
      {
        int i = super.c() + b.c(1, this.b);
        if (this.c != null)
          i += b.b(2, this.c);
        if ((this.d != null) && (this.d.length > 0))
        {
          int j = i;
          for (int k = 0; k < this.d.length; k++)
          {
            a locala = this.d[k];
            if (locala != null)
              j += b.b(3, locala);
          }
          i = j;
        }
        return i;
      }

      public e e()
      {
        this.b = 0L;
        this.c = null;
        this.d = a.d();
        this.a = -1;
        return this;
      }

      public static final class a extends e
      {
        private static volatile a[] p;
        public long b;
        public long c;
        public int d;
        public String e;
        public byte[] f;
        public kk.c.b g;
        public b h;
        public String i;
        public a j;
        public int k;
        public int l;
        public int m;
        public byte[] n;
        public int o;

        public a()
        {
          e();
        }

        public static a[] d()
        {
          if (p == null);
          synchronized (c.a)
          {
            if (p == null)
              p = new a[0];
            return p;
          }
        }

        public void a(b paramb)
          throws IOException
        {
          paramb.a(1, this.b);
          paramb.a(2, this.c);
          paramb.b(3, this.d);
          if (!this.e.equals(""))
            paramb.a(4, this.e);
          if (!Arrays.equals(this.f, g.c))
            paramb.a(5, this.f);
          if (this.g != null)
            paramb.a(6, this.g);
          if (this.h != null)
            paramb.a(7, this.h);
          if (!this.i.equals(""))
            paramb.a(8, this.i);
          if (this.j != null)
            paramb.a(9, this.j);
          if (this.k != 0)
            paramb.b(10, this.k);
          if (this.l != 0)
            paramb.a(12, this.l);
          if (this.m != -1)
            paramb.a(13, this.m);
          if (!Arrays.equals(this.n, g.c))
            paramb.a(14, this.n);
          if (this.o != -1)
            paramb.a(15, this.o);
          super.a(paramb);
        }

        public a b(a parama)
          throws IOException
        {
          while (true)
          {
            int i1 = parama.a();
            switch (i1)
            {
            default:
              if (g.a(parama, i1))
                continue;
            case 0:
              return this;
            case 8:
              this.b = parama.e();
              break;
            case 16:
              this.c = parama.e();
              break;
            case 24:
              this.d = parama.k();
              break;
            case 34:
              this.e = parama.i();
              break;
            case 42:
              this.f = parama.j();
              break;
            case 50:
              if (this.g == null)
                this.g = new kk.c.b();
              parama.a(this.g);
              break;
            case 58:
              if (this.h == null)
                this.h = new b();
              parama.a(this.h);
              break;
            case 66:
              this.i = parama.i();
              break;
            case 74:
              if (this.j == null)
                this.j = new a();
              parama.a(this.j);
              break;
            case 80:
              this.k = parama.k();
              break;
            case 96:
              int i4 = parama.g();
              switch (i4)
              {
              default:
                break;
              case 0:
              case 1:
              }
              this.l = i4;
              break;
            case 104:
              int i3 = parama.g();
              switch (i3)
              {
              default:
                break;
              case -1:
              case 0:
              case 1:
              }
              this.m = i3;
              break;
            case 114:
              this.n = parama.j();
              break;
            case 120:
            }
            int i2 = parama.g();
            switch (i2)
            {
            default:
              break;
            case -1:
            case 0:
            case 1:
            }
            this.o = i2;
          }
        }

        protected int c()
        {
          int i1 = super.c() + b.c(1, this.b) + b.c(2, this.c) + b.e(3, this.d);
          if (!this.e.equals(""))
            i1 += b.b(4, this.e);
          if (!Arrays.equals(this.f, g.c))
            i1 += b.b(5, this.f);
          if (this.g != null)
            i1 += b.b(6, this.g);
          if (this.h != null)
            i1 += b.b(7, this.h);
          if (!this.i.equals(""))
            i1 += b.b(8, this.i);
          if (this.j != null)
            i1 += b.b(9, this.j);
          if (this.k != 0)
            i1 += b.e(10, this.k);
          if (this.l != 0)
            i1 += b.d(12, this.l);
          if (this.m != -1)
            i1 += b.d(13, this.m);
          if (!Arrays.equals(this.n, g.c))
            i1 += b.b(14, this.n);
          if (this.o != -1)
            i1 += b.d(15, this.o);
          return i1;
        }

        public a e()
        {
          this.b = 0L;
          this.c = 0L;
          this.d = 0;
          this.e = "";
          this.f = g.c;
          this.g = null;
          this.h = null;
          this.i = "";
          this.j = null;
          this.k = 0;
          this.l = 0;
          this.m = -1;
          this.n = g.c;
          this.o = -1;
          this.a = -1;
          return this;
        }

        public static final class a extends e
        {
          public String b;
          public String c;
          public String d;

          public a()
          {
            d();
          }

          public void a(b paramb)
            throws IOException
          {
            paramb.a(1, this.b);
            if (!this.c.equals(""))
              paramb.a(2, this.c);
            if (!this.d.equals(""))
              paramb.a(3, this.d);
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
              }
              this.d = parama.i();
            }
          }

          protected int c()
          {
            int i = super.c() + b.b(1, this.b);
            if (!this.c.equals(""))
              i += b.b(2, this.c);
            if (!this.d.equals(""))
              i += b.b(3, this.d);
            return i;
          }

          public a d()
          {
            this.b = "";
            this.c = "";
            this.d = "";
            this.a = -1;
            return this;
          }
        }

        public static final class b extends e
        {
          public kk.a[] b;
          public kk.d[] c;
          public int d;
          public String e;
          public a f;

          public b()
          {
            d();
          }

          public void a(b paramb)
            throws IOException
          {
            if ((this.b != null) && (this.b.length > 0))
              for (int k = 0; k < this.b.length; k++)
              {
                kk.a locala = this.b[k];
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
                  kk.d locald = this.c[j];
                  if (locald != null)
                    paramb.a(2, locald);
                  j++;
                }
            }
            if (this.d != 2)
              paramb.a(3, this.d);
            if (!this.e.equals(""))
              paramb.a(4, this.e);
            if (this.f != null)
              paramb.a(5, this.f);
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
              case 10:
                int n = g.b(parama, 10);
                if (this.b == null);
                kk.a[] arrayOfa;
                for (int i1 = 0; ; i1 = this.b.length)
                {
                  arrayOfa = new kk.a[n + i1];
                  if (i1 != 0)
                    System.arraycopy(this.b, 0, arrayOfa, 0, i1);
                  while (i1 < -1 + arrayOfa.length)
                  {
                    arrayOfa[i1] = new kk.a();
                    parama.a(arrayOfa[i1]);
                    parama.a();
                    i1++;
                  }
                }
                arrayOfa[i1] = new kk.a();
                parama.a(arrayOfa[i1]);
                this.b = arrayOfa;
                break;
              case 18:
                int k = g.b(parama, 18);
                if (this.c == null);
                kk.d[] arrayOfd;
                for (int m = 0; ; m = this.c.length)
                {
                  arrayOfd = new kk.d[k + m];
                  if (m != 0)
                    System.arraycopy(this.c, 0, arrayOfd, 0, m);
                  while (m < -1 + arrayOfd.length)
                  {
                    arrayOfd[m] = new kk.d();
                    parama.a(arrayOfd[m]);
                    parama.a();
                    m++;
                  }
                }
                arrayOfd[m] = new kk.d();
                parama.a(arrayOfd[m]);
                this.c = arrayOfd;
                break;
              case 24:
                int j = parama.g();
                switch (j)
                {
                default:
                  break;
                case 0:
                case 1:
                case 2:
                }
                this.d = j;
                break;
              case 34:
                this.e = parama.i();
                break;
              case 42:
              }
              if (this.f == null)
                this.f = new a();
              parama.a(this.f);
            }
          }

          protected int c()
          {
            int i = super.c();
            if ((this.b != null) && (this.b.length > 0))
            {
              int m = i;
              for (int n = 0; n < this.b.length; n++)
              {
                kk.a locala = this.b[n];
                if (locala != null)
                  m += b.b(1, locala);
              }
              i = m;
            }
            if (this.c != null)
            {
              int j = this.c.length;
              int k = 0;
              if (j > 0)
                while (k < this.c.length)
                {
                  kk.d locald = this.c[k];
                  if (locald != null)
                    i += b.b(2, locald);
                  k++;
                }
            }
            if (this.d != 2)
              i += b.d(3, this.d);
            if (!this.e.equals(""))
              i += b.b(4, this.e);
            if (this.f != null)
              i += b.b(5, this.f);
            return i;
          }

          public b d()
          {
            this.b = kk.a.d();
            this.c = kk.d.d();
            this.d = 2;
            this.e = "";
            this.f = null;
            this.a = -1;
            return this;
          }

          public static final class a extends e
          {
            public String b;
            public int c;

            public a()
            {
              d();
            }

            public void a(b paramb)
              throws IOException
            {
              paramb.a(1, this.b);
              if (this.c != 0)
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
                int j = parama.g();
                switch (j)
                {
                default:
                  break;
                case 0:
                case 1:
                case 2:
                }
                this.c = j;
              }
            }

            protected int c()
            {
              int i = super.c() + b.b(1, this.b);
              if (this.c != 0)
                i += b.d(2, this.c);
              return i;
            }

            public a d()
            {
              this.b = "";
              this.c = 0;
              this.a = -1;
              return this;
            }
          }
        }
      }

      public static final class b extends e
      {
        public kk.c.g b;
        public String c;
        public int d;

        public b()
        {
          d();
        }

        public void a(b paramb)
          throws IOException
        {
          if (this.b != null)
            paramb.a(1, this.b);
          paramb.a(2, this.c);
          if (this.d != 0)
            paramb.a(5, this.d);
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
            case 10:
              if (this.b == null)
                this.b = new kk.c.g();
              parama.a(this.b);
              break;
            case 18:
              this.c = parama.i();
              break;
            case 40:
            }
            int j = parama.g();
            switch (j)
            {
            default:
              break;
            case 0:
            case 1:
            case 2:
            }
            this.d = j;
          }
        }

        protected int c()
        {
          int i = super.c();
          if (this.b != null)
            i += b.b(1, this.b);
          int j = i + b.b(2, this.c);
          if (this.d != 0)
            j += b.d(5, this.d);
          return j;
        }

        public b d()
        {
          this.b = null;
          this.c = "";
          this.d = 0;
          this.a = -1;
          return this;
        }
      }
    }

    public static final class f extends e
    {
      private static volatile f[] g;
      public int b;
      public int c;
      public String d;
      public boolean e;
      public String f;

      public f()
      {
        e();
      }

      public static f[] d()
      {
        if (g == null);
        synchronized (c.a)
        {
          if (g == null)
            g = new f[0];
          return g;
        }
      }

      public void a(b paramb)
        throws IOException
      {
        if (this.b != 0)
          paramb.b(1, this.b);
        if (this.c != 0)
          paramb.b(2, this.c);
        if (!this.d.equals(""))
          paramb.a(3, this.d);
        if (this.e)
          paramb.a(4, this.e);
        if (!this.f.equals(""))
          paramb.a(5, this.f);
        super.a(paramb);
      }

      public f b(a parama)
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
            this.b = parama.k();
            break;
          case 16:
            this.c = parama.k();
            break;
          case 26:
            this.d = parama.i();
            break;
          case 32:
            this.e = parama.h();
            break;
          case 42:
          }
          this.f = parama.i();
        }
      }

      protected int c()
      {
        int i = super.c();
        if (this.b != 0)
          i += b.e(1, this.b);
        if (this.c != 0)
          i += b.e(2, this.c);
        if (!this.d.equals(""))
          i += b.b(3, this.d);
        if (this.e)
          i += b.f(4);
        if (!this.f.equals(""))
          i += b.b(5, this.f);
        return i;
      }

      public f e()
      {
        this.b = 0;
        this.c = 0;
        this.d = "";
        this.e = false;
        this.f = "";
        this.a = -1;
        return this;
      }
    }

    public static final class g extends e
    {
      public long b;
      public int c;
      public long d;
      public boolean e;

      public g()
      {
        d();
      }

      public void a(b paramb)
        throws IOException
      {
        paramb.a(1, this.b);
        paramb.c(2, this.c);
        if (this.d != 0L)
          paramb.b(3, this.d);
        if (this.e)
          paramb.a(4, this.e);
        super.a(paramb);
      }

      public g b(a parama)
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
            this.b = parama.e();
            break;
          case 16:
            this.c = parama.l();
            break;
          case 24:
            this.d = parama.f();
            break;
          case 32:
          }
          this.e = parama.h();
        }
      }

      protected int c()
      {
        int i = super.c() + b.c(1, this.b) + b.f(2, this.c);
        if (this.d != 0L)
          i += b.d(3, this.d);
        if (this.e)
          i += b.f(4);
        return i;
      }

      public g d()
      {
        this.b = 0L;
        this.c = 0;
        this.d = 0L;
        this.e = false;
        this.a = -1;
        return this;
      }
    }
  }

  public static final class d extends e
  {
    private static volatile d[] f;
    public String b;
    public int c;
    public String d;
    public boolean e;

    public d()
    {
      e();
    }

    public static d[] d()
    {
      if (f == null);
      synchronized (c.a)
      {
        if (f == null)
          f = new d[0];
        return f;
      }
    }

    public void a(b paramb)
      throws IOException
    {
      paramb.a(1, this.b);
      if (this.c != 0)
        paramb.c(2, this.c);
      if (!this.d.equals(""))
        paramb.a(3, this.d);
      if (this.e)
        paramb.a(4, this.e);
      super.a(paramb);
    }

    public d b(a parama)
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
          this.c = parama.l();
          break;
        case 26:
          this.d = parama.i();
          break;
        case 32:
        }
        this.e = parama.h();
      }
    }

    protected int c()
    {
      int i = super.c() + b.b(1, this.b);
      if (this.c != 0)
        i += b.f(2, this.c);
      if (!this.d.equals(""))
        i += b.b(3, this.d);
      if (this.e)
        i += b.f(4);
      return i;
    }

    public d e()
    {
      this.b = "";
      this.c = 0;
      this.d = "";
      this.e = false;
      this.a = -1;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.kk
 * JD-Core Version:    0.6.2
 */