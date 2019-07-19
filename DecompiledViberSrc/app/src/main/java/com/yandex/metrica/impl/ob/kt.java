package com.yandex.metrica.impl.ob;

import java.io.IOException;

public abstract interface kt
{
  public static final class a extends e
  {
    public String A;
    public long B;
    public long C;
    public boolean D;
    public String b;
    public long c;
    public String[] d;
    public String e;
    public String f;
    public String[] g;
    public String[] h;
    public String[] i;
    public b j;
    public c k;
    public a l;
    public g m;
    public e[] n;
    public String o;
    public String p;
    public boolean q;
    public String r;
    public String s;
    public String[] t;
    public h u;
    public boolean v;
    public d[] w;
    public f x;
    public String y;
    public String z;

    public a()
    {
      d();
    }

    public void a(b paramb)
      throws IOException
    {
      if (!this.b.equals(""))
        paramb.a(1, this.b);
      paramb.b(3, this.c);
      if ((this.d != null) && (this.d.length > 0))
        for (int i8 = 0; i8 < this.d.length; i8++)
        {
          String str5 = this.d[i8];
          if (str5 != null)
            paramb.a(4, str5);
        }
      if (!this.e.equals(""))
        paramb.a(5, this.e);
      if (!this.f.equals(""))
        paramb.a(6, this.f);
      if ((this.g != null) && (this.g.length > 0))
        for (int i7 = 0; i7 < this.g.length; i7++)
        {
          String str4 = this.g[i7];
          if (str4 != null)
            paramb.a(7, str4);
        }
      if ((this.h != null) && (this.h.length > 0))
        for (int i6 = 0; i6 < this.h.length; i6++)
        {
          String str3 = this.h[i6];
          if (str3 != null)
            paramb.a(8, str3);
        }
      if ((this.i != null) && (this.i.length > 0))
        for (int i5 = 0; i5 < this.i.length; i5++)
        {
          String str2 = this.i[i5];
          if (str2 != null)
            paramb.a(9, str2);
        }
      if (this.j != null)
        paramb.a(10, this.j);
      if (this.k != null)
        paramb.a(11, this.k);
      if (this.l != null)
        paramb.a(12, this.l);
      if (this.m != null)
        paramb.a(13, this.m);
      if ((this.n != null) && (this.n.length > 0))
        for (int i4 = 0; i4 < this.n.length; i4++)
        {
          e locale = this.n[i4];
          if (locale != null)
            paramb.a(14, locale);
        }
      if (!this.o.equals(""))
        paramb.a(15, this.o);
      if (!this.p.equals(""))
        paramb.a(16, this.p);
      paramb.a(17, this.q);
      if (!this.r.equals(""))
        paramb.a(18, this.r);
      if (!this.s.equals(""))
        paramb.a(19, this.s);
      if ((this.t != null) && (this.t.length > 0))
        for (int i3 = 0; i3 < this.t.length; i3++)
        {
          String str1 = this.t[i3];
          if (str1 != null)
            paramb.a(20, str1);
        }
      if (this.u != null)
        paramb.a(21, this.u);
      if (this.v)
        paramb.a(22, this.v);
      if (this.w != null)
      {
        int i1 = this.w.length;
        int i2 = 0;
        if (i1 > 0)
          while (i2 < this.w.length)
          {
            d locald = this.w[i2];
            if (locald != null)
              paramb.a(23, locald);
            i2++;
          }
      }
      if (this.x != null)
        paramb.a(24, this.x);
      if (!this.y.equals(""))
        paramb.a(25, this.y);
      if (!this.z.equals(""))
        paramb.a(26, this.z);
      if (!this.A.equals(""))
        paramb.a(27, this.A);
      paramb.b(28, this.B);
      paramb.b(29, this.C);
      if (this.D)
        paramb.a(30, this.D);
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
        case 10:
          this.b = parama.i();
          break;
        case 24:
          this.c = parama.f();
          break;
        case 34:
          int i14 = g.b(parama, 34);
          if (this.d == null);
          String[] arrayOfString5;
          for (int i15 = 0; ; i15 = this.d.length)
          {
            arrayOfString5 = new String[i14 + i15];
            if (i15 != 0)
              System.arraycopy(this.d, 0, arrayOfString5, 0, i15);
            while (i15 < -1 + arrayOfString5.length)
            {
              arrayOfString5[i15] = parama.i();
              parama.a();
              i15++;
            }
          }
          arrayOfString5[i15] = parama.i();
          this.d = arrayOfString5;
          break;
        case 42:
          this.e = parama.i();
          break;
        case 50:
          this.f = parama.i();
          break;
        case 58:
          int i12 = g.b(parama, 58);
          if (this.g == null);
          String[] arrayOfString4;
          for (int i13 = 0; ; i13 = this.g.length)
          {
            arrayOfString4 = new String[i12 + i13];
            if (i13 != 0)
              System.arraycopy(this.g, 0, arrayOfString4, 0, i13);
            while (i13 < -1 + arrayOfString4.length)
            {
              arrayOfString4[i13] = parama.i();
              parama.a();
              i13++;
            }
          }
          arrayOfString4[i13] = parama.i();
          this.g = arrayOfString4;
          break;
        case 66:
          int i10 = g.b(parama, 66);
          if (this.h == null);
          String[] arrayOfString3;
          for (int i11 = 0; ; i11 = this.h.length)
          {
            arrayOfString3 = new String[i10 + i11];
            if (i11 != 0)
              System.arraycopy(this.h, 0, arrayOfString3, 0, i11);
            while (i11 < -1 + arrayOfString3.length)
            {
              arrayOfString3[i11] = parama.i();
              parama.a();
              i11++;
            }
          }
          arrayOfString3[i11] = parama.i();
          this.h = arrayOfString3;
          break;
        case 74:
          int i8 = g.b(parama, 74);
          if (this.i == null);
          String[] arrayOfString2;
          for (int i9 = 0; ; i9 = this.i.length)
          {
            arrayOfString2 = new String[i8 + i9];
            if (i9 != 0)
              System.arraycopy(this.i, 0, arrayOfString2, 0, i9);
            while (i9 < -1 + arrayOfString2.length)
            {
              arrayOfString2[i9] = parama.i();
              parama.a();
              i9++;
            }
          }
          arrayOfString2[i9] = parama.i();
          this.i = arrayOfString2;
          break;
        case 82:
          if (this.j == null)
            this.j = new b();
          parama.a(this.j);
          break;
        case 90:
          if (this.k == null)
            this.k = new c();
          parama.a(this.k);
          break;
        case 98:
          if (this.l == null)
            this.l = new a();
          parama.a(this.l);
          break;
        case 106:
          if (this.m == null)
            this.m = new g();
          parama.a(this.m);
          break;
        case 114:
          int i6 = g.b(parama, 114);
          if (this.n == null);
          e[] arrayOfe;
          for (int i7 = 0; ; i7 = this.n.length)
          {
            arrayOfe = new e[i6 + i7];
            if (i7 != 0)
              System.arraycopy(this.n, 0, arrayOfe, 0, i7);
            while (i7 < -1 + arrayOfe.length)
            {
              arrayOfe[i7] = new e();
              parama.a(arrayOfe[i7]);
              parama.a();
              i7++;
            }
          }
          arrayOfe[i7] = new e();
          parama.a(arrayOfe[i7]);
          this.n = arrayOfe;
          break;
        case 122:
          this.o = parama.i();
          break;
        case 130:
          this.p = parama.i();
          break;
        case 136:
          this.q = parama.h();
          break;
        case 146:
          this.r = parama.i();
          break;
        case 154:
          this.s = parama.i();
          break;
        case 162:
          int i4 = g.b(parama, 162);
          if (this.t == null);
          String[] arrayOfString1;
          for (int i5 = 0; ; i5 = this.t.length)
          {
            arrayOfString1 = new String[i4 + i5];
            if (i5 != 0)
              System.arraycopy(this.t, 0, arrayOfString1, 0, i5);
            while (i5 < -1 + arrayOfString1.length)
            {
              arrayOfString1[i5] = parama.i();
              parama.a();
              i5++;
            }
          }
          arrayOfString1[i5] = parama.i();
          this.t = arrayOfString1;
          break;
        case 170:
          if (this.u == null)
            this.u = new h();
          parama.a(this.u);
          break;
        case 176:
          this.v = parama.h();
          break;
        case 186:
          int i2 = g.b(parama, 186);
          if (this.w == null);
          d[] arrayOfd;
          for (int i3 = 0; ; i3 = this.w.length)
          {
            arrayOfd = new d[i2 + i3];
            if (i3 != 0)
              System.arraycopy(this.w, 0, arrayOfd, 0, i3);
            while (i3 < -1 + arrayOfd.length)
            {
              arrayOfd[i3] = new d();
              parama.a(arrayOfd[i3]);
              parama.a();
              i3++;
            }
          }
          arrayOfd[i3] = new d();
          parama.a(arrayOfd[i3]);
          this.w = arrayOfd;
          break;
        case 194:
          if (this.x == null)
            this.x = new f();
          parama.a(this.x);
          break;
        case 202:
          this.y = parama.i();
          break;
        case 210:
          this.z = parama.i();
          break;
        case 218:
          this.A = parama.i();
          break;
        case 224:
          this.B = parama.f();
          break;
        case 232:
          this.C = parama.f();
          break;
        case 240:
        }
        this.D = parama.h();
      }
    }

    protected int c()
    {
      int i1 = super.c();
      if (!this.b.equals(""))
        i1 += b.b(1, this.b);
      int i2 = i1 + b.d(3, this.c);
      int i23;
      int i24;
      if ((this.d != null) && (this.d.length > 0))
      {
        int i22 = 0;
        i23 = 0;
        i24 = 0;
        while (i22 < this.d.length)
        {
          String str5 = this.d[i22];
          if (str5 != null)
          {
            i24++;
            i23 += b.b(str5);
          }
          i22++;
        }
      }
      for (int i3 = i2 + i23 + i24 * 1; ; i3 = i2)
      {
        if (!this.e.equals(""))
          i3 += b.b(5, this.e);
        if (!this.f.equals(""))
          i3 += b.b(6, this.f);
        if ((this.g != null) && (this.g.length > 0))
        {
          int i19 = 0;
          int i20 = 0;
          int i21 = 0;
          while (i19 < this.g.length)
          {
            String str4 = this.g[i19];
            if (str4 != null)
            {
              i21++;
              i20 += b.b(str4);
            }
            i19++;
          }
          i3 = i3 + i20 + i21 * 1;
        }
        if ((this.h != null) && (this.h.length > 0))
        {
          int i16 = 0;
          int i17 = 0;
          int i18 = 0;
          while (i16 < this.h.length)
          {
            String str3 = this.h[i16];
            if (str3 != null)
            {
              i18++;
              i17 += b.b(str3);
            }
            i16++;
          }
          i3 = i3 + i17 + i18 * 1;
        }
        if ((this.i != null) && (this.i.length > 0))
        {
          int i13 = 0;
          int i14 = 0;
          int i15 = 0;
          while (i13 < this.i.length)
          {
            String str2 = this.i[i13];
            if (str2 != null)
            {
              i15++;
              i14 += b.b(str2);
            }
            i13++;
          }
          i3 = i3 + i14 + i15 * 1;
        }
        if (this.j != null)
          i3 += b.b(10, this.j);
        if (this.k != null)
          i3 += b.b(11, this.k);
        if (this.l != null)
          i3 += b.b(12, this.l);
        if (this.m != null)
          i3 += b.b(13, this.m);
        if ((this.n != null) && (this.n.length > 0))
        {
          int i11 = i3;
          for (int i12 = 0; i12 < this.n.length; i12++)
          {
            e locale = this.n[i12];
            if (locale != null)
              i11 += b.b(14, locale);
          }
          i3 = i11;
        }
        if (!this.o.equals(""))
          i3 += b.b(15, this.o);
        if (!this.p.equals(""))
          i3 += b.b(16, this.p);
        int i4 = i3 + b.f(17);
        if (!this.r.equals(""))
          i4 += b.b(18, this.r);
        if (!this.s.equals(""))
          i4 += b.b(19, this.s);
        if ((this.t != null) && (this.t.length > 0))
        {
          int i8 = 0;
          int i9 = 0;
          int i10 = 0;
          while (i8 < this.t.length)
          {
            String str1 = this.t[i8];
            if (str1 != null)
            {
              i10++;
              i9 += b.b(str1);
            }
            i8++;
          }
          i4 = i4 + i9 + i10 * 2;
        }
        if (this.u != null)
          i4 += b.b(21, this.u);
        if (this.v)
          i4 += b.f(22);
        if (this.w != null)
        {
          int i6 = this.w.length;
          int i7 = 0;
          if (i6 > 0)
            while (i7 < this.w.length)
            {
              d locald = this.w[i7];
              if (locald != null)
                i4 += b.b(23, locald);
              i7++;
            }
        }
        if (this.x != null)
          i4 += b.b(24, this.x);
        if (!this.y.equals(""))
          i4 += b.b(25, this.y);
        if (!this.z.equals(""))
          i4 += b.b(26, this.z);
        if (!this.A.equals(""))
          i4 += b.b(27, this.A);
        int i5 = i4 + b.d(28, this.B) + b.d(29, this.C);
        if (this.D)
          i5 += b.f(30);
        return i5;
      }
    }

    public a d()
    {
      this.b = "";
      this.c = 0L;
      this.d = g.b;
      this.e = "";
      this.f = "";
      this.g = g.b;
      this.h = g.b;
      this.i = g.b;
      this.j = null;
      this.k = null;
      this.l = null;
      this.m = null;
      this.n = e.d();
      this.o = "";
      this.p = "";
      this.q = false;
      this.r = "";
      this.s = "";
      this.t = g.b;
      this.u = null;
      this.v = false;
      this.w = d.d();
      this.x = null;
      this.y = "";
      this.z = "";
      this.A = "";
      this.B = 0L;
      this.C = 0L;
      this.D = false;
      this.a = -1;
      return this;
    }

    public static final class a extends e
    {
      public kt.a.c b;
      public long c;
      public long d;
      public boolean e;
      public a[] f;

      public a()
      {
        d();
      }

      public void a(b paramb)
        throws IOException
      {
        if (this.b != null)
          paramb.a(1, this.b);
        paramb.b(2, this.c);
        paramb.b(3, this.d);
        paramb.a(4, this.e);
        if ((this.f != null) && (this.f.length > 0))
          for (int i = 0; i < this.f.length; i++)
          {
            a locala = this.f[i];
            if (locala != null)
              paramb.a(5, locala);
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
            if (this.b == null)
              this.b = new kt.a.c();
            parama.a(this.b);
            break;
          case 16:
            this.c = parama.f();
            break;
          case 24:
            this.d = parama.f();
            break;
          case 32:
            this.e = parama.h();
            break;
          case 42:
          }
          int j = g.b(parama, 42);
          if (this.f == null);
          a[] arrayOfa;
          for (int k = 0; ; k = this.f.length)
          {
            arrayOfa = new a[j + k];
            if (k != 0)
              System.arraycopy(this.f, 0, arrayOfa, 0, k);
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
          this.f = arrayOfa;
        }
      }

      protected int c()
      {
        int i = super.c();
        if (this.b != null)
          i += b.b(1, this.b);
        int j = i + b.d(2, this.c) + b.d(3, this.d) + b.f(4);
        if ((this.f != null) && (this.f.length > 0))
          for (int k = 0; k < this.f.length; k++)
          {
            a locala = this.f[k];
            if (locala != null)
              j += b.b(5, locala);
          }
        return j;
      }

      public a d()
      {
        this.b = null;
        this.c = 60000L;
        this.d = 3600000L;
        this.e = false;
        this.f = a.d();
        this.a = -1;
        return this;
      }

      public static final class a extends e
      {
        private static volatile a[] d;
        public long b;
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
          paramb.b(1, this.b);
          paramb.b(2, this.c);
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
              this.b = parama.f();
              break;
            case 16:
            }
            this.c = parama.f();
          }
        }

        protected int c()
        {
          return super.c() + b.d(1, this.b) + b.d(2, this.c);
        }

        public a e()
        {
          this.b = 0L;
          this.c = 0L;
          this.a = -1;
          return this;
        }
      }
    }

    public static final class b extends e
    {
      public boolean b;
      public boolean c;
      public boolean d;
      public boolean e;
      public boolean f;
      public boolean g;
      public boolean h;
      public boolean i;
      public boolean j;
      public boolean k;
      public boolean l;
      public boolean m;
      public boolean n;
      public boolean o;

      public b()
      {
        d();
      }

      public void a(b paramb)
        throws IOException
      {
        paramb.a(1, this.b);
        paramb.a(2, this.c);
        paramb.a(3, this.d);
        paramb.a(4, this.e);
        paramb.a(5, this.g);
        paramb.a(6, this.h);
        paramb.a(8, this.i);
        paramb.a(9, this.j);
        paramb.a(10, this.k);
        paramb.a(11, this.l);
        paramb.a(12, this.m);
        paramb.a(13, this.n);
        paramb.a(14, this.o);
        paramb.a(15, this.f);
        super.a(paramb);
      }

      public b b(a parama)
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
            this.b = parama.h();
            break;
          case 16:
            this.c = parama.h();
            break;
          case 24:
            this.d = parama.h();
            break;
          case 32:
            this.e = parama.h();
            break;
          case 40:
            this.g = parama.h();
            break;
          case 48:
            this.h = parama.h();
            break;
          case 64:
            this.i = parama.h();
            break;
          case 72:
            this.j = parama.h();
            break;
          case 80:
            this.k = parama.h();
            break;
          case 88:
            this.l = parama.h();
            break;
          case 96:
            this.m = parama.h();
            break;
          case 104:
            this.n = parama.h();
            break;
          case 112:
            this.o = parama.h();
            break;
          case 120:
          }
          this.f = parama.h();
        }
      }

      protected int c()
      {
        return super.c() + b.f(1) + b.f(2) + b.f(3) + b.f(4) + b.f(5) + b.f(6) + b.f(8) + b.f(9) + b.f(10) + b.f(11) + b.f(12) + b.f(13) + b.f(14) + b.f(15);
      }

      public b d()
      {
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.a = -1;
        return this;
      }
    }

    public static final class c extends e
    {
      public long b;
      public float c;
      public int d;
      public int e;
      public long f;
      public int g;
      public boolean h;
      public boolean i;
      public long j;

      public c()
      {
        d();
      }

      public void a(b paramb)
        throws IOException
      {
        paramb.b(1, this.b);
        paramb.a(2, this.c);
        paramb.a(3, this.d);
        paramb.a(4, this.e);
        paramb.b(5, this.f);
        paramb.a(6, this.g);
        paramb.a(7, this.h);
        paramb.a(8, this.i);
        paramb.b(9, this.j);
        super.a(paramb);
      }

      public c b(a parama)
        throws IOException
      {
        while (true)
        {
          int k = parama.a();
          switch (k)
          {
          default:
            if (g.a(parama, k))
              continue;
          case 0:
            return this;
          case 8:
            this.b = parama.f();
            break;
          case 21:
            this.c = parama.d();
            break;
          case 24:
            this.d = parama.g();
            break;
          case 32:
            this.e = parama.g();
            break;
          case 40:
            this.f = parama.f();
            break;
          case 48:
            this.g = parama.g();
            break;
          case 56:
            this.h = parama.h();
            break;
          case 64:
            this.i = parama.h();
            break;
          case 72:
          }
          this.j = parama.f();
        }
      }

      protected int c()
      {
        return super.c() + b.d(1, this.b) + b.e(2) + b.d(3, this.d) + b.d(4, this.e) + b.d(5, this.f) + b.d(6, this.g) + b.f(7) + b.f(8) + b.d(9, this.j);
      }

      public c d()
      {
        this.b = 5000L;
        this.c = 10.0F;
        this.d = 20;
        this.e = 200;
        this.f = 60000L;
        this.g = 10000;
        this.h = false;
        this.i = false;
        this.j = 60000L;
        this.a = -1;
        return this;
      }
    }

    public static final class d extends e
    {
      private static volatile d[] d;
      public String b;
      public boolean c;

      public d()
      {
        e();
      }

      public static d[] d()
      {
        if (d == null);
        synchronized (c.a)
        {
          if (d == null)
            d = new d[0];
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
          }
          this.c = parama.h();
        }
      }

      protected int c()
      {
        return super.c() + b.b(1, this.b) + b.f(2);
      }

      public d e()
      {
        this.b = "";
        this.c = false;
        this.a = -1;
        return this;
      }
    }

    public static final class e extends e
    {
      private static volatile e[] h;
      public String b;
      public String c;
      public String d;
      public a[] e;
      public long f;
      public int[] g;

      public e()
      {
        e();
      }

      public static e[] d()
      {
        if (h == null);
        synchronized (c.a)
        {
          if (h == null)
            h = new e[0];
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
        paramb.b(5, this.f);
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
            this.f = parama.f();
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
        int k = j + b.d(5, this.f);
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

      public e e()
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

    public static final class f extends e
    {
      public long b;
      public long c;
      public long d;
      public long e;

      public f()
      {
        d();
      }

      public void a(b paramb)
        throws IOException
      {
        if (this.b != 432000000L)
          paramb.b(1, this.b);
        if (this.c != 86400000L)
          paramb.b(2, this.c);
        if (this.d != 10000L)
          paramb.b(3, this.d);
        if (this.e != 3600000L)
          paramb.b(4, this.e);
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
            this.b = parama.f();
            break;
          case 16:
            this.c = parama.f();
            break;
          case 24:
            this.d = parama.f();
            break;
          case 32:
          }
          this.e = parama.f();
        }
      }

      protected int c()
      {
        int i = super.c();
        if (this.b != 432000000L)
          i += b.d(1, this.b);
        if (this.c != 86400000L)
          i += b.d(2, this.c);
        if (this.d != 10000L)
          i += b.d(3, this.d);
        if (this.e != 3600000L)
          i += b.d(4, this.e);
        return i;
      }

      public f d()
      {
        this.b = 432000000L;
        this.c = 86400000L;
        this.d = 10000L;
        this.e = 3600000L;
        this.a = -1;
        return this;
      }
    }

    public static final class g extends e
    {
      public long b;
      public String c;
      public int[] d;

      public g()
      {
        d();
      }

      public void a(b paramb)
        throws IOException
      {
        paramb.b(1, this.b);
        paramb.a(2, this.c);
        if ((this.d != null) && (this.d.length > 0))
          for (int i = 0; i < this.d.length; i++)
            paramb.a(3, this.d[i]);
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
            this.b = parama.f();
            break;
          case 18:
            this.c = parama.i();
            break;
          case 24:
            int i1 = g.b(parama, 24);
            if (this.d == null);
            int[] arrayOfInt2;
            for (int i2 = 0; ; i2 = this.d.length)
            {
              arrayOfInt2 = new int[i1 + i2];
              if (i2 != 0)
                System.arraycopy(this.d, 0, arrayOfInt2, 0, i2);
              while (i2 < -1 + arrayOfInt2.length)
              {
                arrayOfInt2[i2] = parama.g();
                parama.a();
                i2++;
              }
            }
            arrayOfInt2[i2] = parama.g();
            this.d = arrayOfInt2;
            break;
          case 26:
          }
          int j = parama.c(parama.m());
          int k = parama.s();
          for (int m = 0; parama.q() > 0; m++)
            parama.g();
          parama.e(k);
          if (this.d == null);
          int[] arrayOfInt1;
          for (int n = 0; ; n = this.d.length)
          {
            arrayOfInt1 = new int[m + n];
            if (n != 0)
              System.arraycopy(this.d, 0, arrayOfInt1, 0, n);
            while (n < arrayOfInt1.length)
            {
              arrayOfInt1[n] = parama.g();
              n++;
            }
          }
          this.d = arrayOfInt1;
          parama.d(j);
        }
      }

      protected int c()
      {
        int i = 0;
        int j = super.c() + b.d(1, this.b) + b.b(2, this.c);
        if ((this.d != null) && (this.d.length > 0))
        {
          int k = 0;
          while (i < this.d.length)
          {
            k += b.g(this.d[i]);
            i++;
          }
          return j + k + 1 * this.d.length;
        }
        return j;
      }

      public g d()
      {
        this.b = 0L;
        this.c = "";
        this.d = g.a;
        this.a = -1;
        return this;
      }
    }

    public static final class h extends e
    {
      public long b;

      public h()
      {
        d();
      }

      public void a(b paramb)
        throws IOException
      {
        paramb.b(1, this.b);
        super.a(paramb);
      }

      public h b(a parama)
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
          }
          this.b = parama.f();
        }
      }

      protected int c()
      {
        return super.c() + b.d(1, this.b);
      }

      public h d()
      {
        this.b = 18000000L;
        this.a = -1;
        return this;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.kt
 * JD-Core Version:    0.6.2
 */