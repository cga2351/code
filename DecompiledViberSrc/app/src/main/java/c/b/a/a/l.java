package c.b.a.a;

import java.io.Serializable;

public final class l
{
  public static class a
    implements Serializable
  {
    private boolean a;
    private int b = 0;
    private boolean c;
    private long d = 0L;
    private boolean e;
    private String f = "";
    private boolean g;
    private boolean h = false;
    private boolean i;
    private int j = 1;
    private boolean k;
    private String l = "";
    private boolean m;
    private a n = a.e;
    private boolean o;
    private String p = "";

    public int a()
    {
      return this.b;
    }

    public a a(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }

    public a a(long paramLong)
    {
      this.c = true;
      this.d = paramLong;
      return this;
    }

    public a a(a parama)
    {
      if (parama == null)
        throw new NullPointerException();
      this.m = true;
      this.n = parama;
      return this;
    }

    public a a(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException();
      this.e = true;
      this.f = paramString;
      return this;
    }

    public a a(boolean paramBoolean)
    {
      this.g = true;
      this.h = paramBoolean;
      return this;
    }

    public boolean a(a parama)
    {
      boolean bool = true;
      if (parama == null)
        bool = false;
      while ((this == parama) || ((this.b == parama.b) && (this.d == parama.d) && (this.f.equals(parama.f)) && (this.h == parama.h) && (this.j == parama.j) && (this.l.equals(parama.l)) && (this.n == parama.n) && (this.p.equals(parama.p)) && (n() == parama.n())))
        return bool;
      return false;
    }

    public long b()
    {
      return this.d;
    }

    public a b(int paramInt)
    {
      this.i = true;
      this.j = paramInt;
      return this;
    }

    public a b(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException();
      this.k = true;
      this.l = paramString;
      return this;
    }

    public a c(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException();
      this.o = true;
      this.p = paramString;
      return this;
    }

    public boolean c()
    {
      return this.e;
    }

    public String d()
    {
      return this.f;
    }

    public boolean e()
    {
      return this.g;
    }

    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof a)) && (a((a)paramObject));
    }

    public boolean f()
    {
      return this.h;
    }

    public boolean g()
    {
      return this.i;
    }

    public int h()
    {
      return this.j;
    }

    public int hashCode()
    {
      int i1 = 1231;
      int i2 = 53 * (53 * (53 * (2173 + a()) + Long.valueOf(b()).hashCode()) + d().hashCode());
      int i3;
      int i4;
      if (f())
      {
        i3 = i1;
        i4 = 53 * (53 * (53 * (53 * (53 * (i3 + i2) + h()) + j().hashCode()) + l().hashCode()) + o().hashCode());
        if (!n())
          break label118;
      }
      while (true)
      {
        return i4 + i1;
        i3 = 1237;
        break;
        label118: i1 = 1237;
      }
    }

    public boolean i()
    {
      return this.k;
    }

    public String j()
    {
      return this.l;
    }

    public boolean k()
    {
      return this.m;
    }

    public a l()
    {
      return this.n;
    }

    public a m()
    {
      this.m = false;
      this.n = a.e;
      return this;
    }

    public boolean n()
    {
      return this.o;
    }

    public String o()
    {
      return this.p;
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Country Code: ").append(this.b);
      localStringBuilder.append(" National Number: ").append(this.d);
      if ((e()) && (f()))
        localStringBuilder.append(" Leading Zero(s): true");
      if (g())
        localStringBuilder.append(" Number of leading zeros: ").append(this.j);
      if (c())
        localStringBuilder.append(" Extension: ").append(this.f);
      if (k())
        localStringBuilder.append(" Country Code Source: ").append(this.n);
      if (n())
        localStringBuilder.append(" Preferred Domestic Carrier Code: ").append(this.p);
      return localStringBuilder.toString();
    }

    public static enum a
    {
      static
      {
        a[] arrayOfa = new a[5];
        arrayOfa[0] = a;
        arrayOfa[1] = b;
        arrayOfa[2] = c;
        arrayOfa[3] = d;
        arrayOfa[4] = e;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.b.a.a.l
 * JD-Core Version:    0.6.2
 */