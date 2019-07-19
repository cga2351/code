package com.c.a.a.a;

import com.c.a.a.b.d;
import com.c.a.a.b.h;
import com.c.a.a.f;
import com.c.a.a.j;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class b extends c
{
  static final BigInteger s = BigInteger.valueOf(-2147483648L);
  static final BigInteger t = BigInteger.valueOf(2147483647L);
  static final BigInteger u = BigInteger.valueOf(-9223372036854775808L);
  static final BigInteger v = BigInteger.valueOf(9223372036854775807L);
  static final BigDecimal w = new BigDecimal(u);
  static final BigDecimal x = new BigDecimal(v);
  static final BigDecimal y = new BigDecimal(s);
  static final BigDecimal z = new BigDecimal(t);
  protected int A = 0;
  protected int B;
  protected long C;
  protected double D;
  protected BigInteger E;
  protected BigDecimal F;
  protected boolean G;
  protected int H;
  protected int I;
  protected int J;
  protected final d b;
  protected boolean c;
  protected int d = 0;
  protected int e = 0;
  protected long f = 0L;
  protected int g = 1;
  protected int h = 0;
  protected long i = 0L;
  protected int j = 1;
  protected int k = 0;
  protected com.c.a.a.c.c l;
  protected j m;
  protected final com.c.a.a.e.e n;
  protected char[] o = null;
  protected boolean p = false;
  protected com.c.a.a.e.b q = null;
  protected byte[] r;

  protected b(d paramd, int paramInt)
  {
    this.a = paramInt;
    this.b = paramd;
    this.n = paramd.d();
    this.l = com.c.a.a.c.c.g();
  }

  private void a(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
    throws IOException, f
  {
    String str = this.n.f();
    try
    {
      if (h.a(paramArrayOfChar, paramInt2, paramInt3, this.G))
      {
        this.C = Long.parseLong(str);
        this.A = 2;
        return;
      }
      this.E = new BigInteger(str);
      this.A = 4;
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      a("Malformed numeric value '" + str + "'", localNumberFormatException);
    }
  }

  private void d(int paramInt)
    throws IOException, f
  {
    if (paramInt == 16);
    try
    {
      this.F = this.n.h();
      this.A = 16;
      return;
      this.D = this.n.i();
      this.A = 8;
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      a("Malformed numeric value '" + this.n.f() + "'", localNumberFormatException);
    }
  }

  protected void A()
    throws IOException, f
  {
    d("Numeric value (" + f() + ") out of range of long (" + -9223372036854775808L + " - " + 9223372036854775807L + ")");
  }

  protected char B()
    throws IOException, f
  {
    throw new UnsupportedOperationException();
  }

  protected final j a(String paramString, double paramDouble)
  {
    this.n.a(paramString);
    this.D = paramDouble;
    this.A = 8;
    return j.j;
  }

  protected final j a(boolean paramBoolean, int paramInt)
  {
    this.G = paramBoolean;
    this.H = paramInt;
    this.I = 0;
    this.J = 0;
    this.A = 0;
    return j.i;
  }

  protected final j a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 < 1) && (paramInt3 < 1))
      return a(paramBoolean, paramInt1);
    return b(paramBoolean, paramInt1, paramInt2, paramInt3);
  }

  protected void a(int paramInt)
    throws IOException, f
  {
    if (this.K == j.i)
    {
      char[] arrayOfChar = this.n.e();
      int i1 = this.n.d();
      int i2 = this.H;
      if (this.G)
        i1++;
      if (i2 <= 9)
      {
        int i3 = h.a(arrayOfChar, i1, i2);
        if (this.G)
          i3 = -i3;
        this.B = i3;
        this.A = 1;
        return;
      }
      if (i2 <= 18)
      {
        long l1 = h.b(arrayOfChar, i1, i2);
        if (this.G)
          l1 = -l1;
        if (i2 == 10)
          if (this.G)
          {
            if (l1 >= -2147483648L)
            {
              this.B = ((int)l1);
              this.A = 1;
            }
          }
          else if (l1 <= 2147483647L)
          {
            this.B = ((int)l1);
            this.A = 1;
            return;
          }
        this.C = l1;
        this.A = 2;
        return;
      }
      a(paramInt, arrayOfChar, i1, i2);
      return;
    }
    if (this.K == j.j)
    {
      d(paramInt);
      return;
    }
    d("Current token (" + this.K + ") not numeric, can not use numeric value accessors");
  }

  protected void a(int paramInt, char paramChar)
    throws f
  {
    String str = "" + this.l.a(this.b.a());
    d("Unexpected close marker '" + (char)paramInt + "': expected '" + paramChar + "' (for " + this.l.d() + " starting at " + str + ")");
  }

  protected void a(int paramInt, String paramString)
    throws f
  {
    String str = "Unexpected character (" + c(paramInt) + ") in numeric value";
    if (paramString != null)
      str = str + ": " + paramString;
    d(str);
  }

  protected final j b(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.G = paramBoolean;
    this.H = paramInt1;
    this.I = paramInt2;
    this.J = paramInt3;
    this.A = 0;
    return j.j;
  }

  protected void b(String paramString)
    throws f
  {
    d("Invalid numeric value: " + paramString);
  }

  public void close()
    throws IOException
  {
    if (!this.c)
      this.c = true;
    try
    {
      r();
      return;
    }
    finally
    {
      s();
    }
  }

  public String d()
    throws IOException, f
  {
    if ((this.K == j.b) || (this.K == j.d))
      return this.l.i().h();
    return this.l.h();
  }

  public com.c.a.a.e e()
  {
    int i1 = 1 + (this.d - this.h);
    return new com.c.a.a.e(this.b.a(), this.f + this.d - 1L, this.g, i1);
  }

  public int i()
    throws IOException, f
  {
    if ((0x1 & this.A) == 0)
    {
      if (this.A == 0)
        a(1);
      if ((0x1 & this.A) == 0)
        u();
    }
    return this.B;
  }

  public long j()
    throws IOException, f
  {
    if ((0x2 & this.A) == 0)
    {
      if (this.A == 0)
        a(2);
      if ((0x2 & this.A) == 0)
        v();
    }
    return this.C;
  }

  public BigInteger k()
    throws IOException, f
  {
    if ((0x4 & this.A) == 0)
    {
      if (this.A == 0)
        a(4);
      if ((0x4 & this.A) == 0)
        w();
    }
    return this.E;
  }

  public float l()
    throws IOException, f
  {
    return (float)m();
  }

  public double m()
    throws IOException, f
  {
    if ((0x8 & this.A) == 0)
    {
      if (this.A == 0)
        a(8);
      if ((0x8 & this.A) == 0)
        x();
    }
    return this.D;
  }

  public BigDecimal n()
    throws IOException, f
  {
    if ((0x10 & this.A) == 0)
    {
      if (this.A == 0)
        a(16);
      if ((0x10 & this.A) == 0)
        y();
    }
    return this.F;
  }

  protected final void o()
    throws IOException
  {
    if (!p())
      C();
  }

  protected abstract boolean p()
    throws IOException;

  protected abstract void q()
    throws IOException, f;

  protected abstract void r()
    throws IOException;

  protected void s()
    throws IOException
  {
    this.n.a();
    char[] arrayOfChar = this.o;
    if (arrayOfChar != null)
    {
      this.o = null;
      this.b.c(arrayOfChar);
    }
  }

  protected void t()
    throws f
  {
    if (!this.l.b())
      c(": expected close marker for " + this.l.d() + " (from " + this.l.a(this.b.a()) + ")");
  }

  protected void u()
    throws IOException, f
  {
    if ((0x2 & this.A) != 0)
    {
      int i1 = (int)this.C;
      if (i1 != this.C)
        d("Numeric value (" + f() + ") out of range of int");
      this.B = i1;
    }
    while (true)
    {
      this.A = (0x1 | this.A);
      return;
      if ((0x4 & this.A) != 0)
      {
        if ((s.compareTo(this.E) > 0) || (t.compareTo(this.E) < 0))
          z();
        this.B = this.E.intValue();
      }
      else if ((0x8 & this.A) != 0)
      {
        if ((this.D < -2147483648.0D) || (this.D > 2147483647.0D))
          z();
        this.B = ((int)this.D);
      }
      else if ((0x10 & this.A) != 0)
      {
        if ((y.compareTo(this.F) > 0) || (z.compareTo(this.F) < 0))
          z();
        this.B = this.F.intValue();
      }
      else
      {
        E();
      }
    }
  }

  protected void v()
    throws IOException, f
  {
    if ((0x1 & this.A) != 0)
      this.C = this.B;
    while (true)
    {
      this.A = (0x2 | this.A);
      return;
      if ((0x4 & this.A) != 0)
      {
        if ((u.compareTo(this.E) > 0) || (v.compareTo(this.E) < 0))
          A();
        this.C = this.E.longValue();
      }
      else if ((0x8 & this.A) != 0)
      {
        if ((this.D < -9.223372036854776E+018D) || (this.D > 9.223372036854776E+018D))
          A();
        this.C = (()this.D);
      }
      else if ((0x10 & this.A) != 0)
      {
        if ((w.compareTo(this.F) > 0) || (x.compareTo(this.F) < 0))
          A();
        this.C = this.F.longValue();
      }
      else
      {
        E();
      }
    }
  }

  protected void w()
    throws IOException, f
  {
    if ((0x10 & this.A) != 0)
      this.E = this.F.toBigInteger();
    while (true)
    {
      this.A = (0x4 | this.A);
      return;
      if ((0x2 & this.A) != 0)
        this.E = BigInteger.valueOf(this.C);
      else if ((0x1 & this.A) != 0)
        this.E = BigInteger.valueOf(this.B);
      else if ((0x8 & this.A) != 0)
        this.E = BigDecimal.valueOf(this.D).toBigInteger();
      else
        E();
    }
  }

  protected void x()
    throws IOException, f
  {
    if ((0x10 & this.A) != 0)
      this.D = this.F.doubleValue();
    while (true)
    {
      this.A = (0x8 | this.A);
      return;
      if ((0x4 & this.A) != 0)
        this.D = this.E.doubleValue();
      else if ((0x2 & this.A) != 0)
        this.D = this.C;
      else if ((0x1 & this.A) != 0)
        this.D = this.B;
      else
        E();
    }
  }

  protected void y()
    throws IOException, f
  {
    if ((0x8 & this.A) != 0)
      this.F = new BigDecimal(f());
    while (true)
    {
      this.A = (0x10 | this.A);
      return;
      if ((0x4 & this.A) != 0)
        this.F = new BigDecimal(this.E);
      else if ((0x2 & this.A) != 0)
        this.F = BigDecimal.valueOf(this.C);
      else if ((0x1 & this.A) != 0)
        this.F = BigDecimal.valueOf(this.B);
      else
        E();
    }
  }

  protected void z()
    throws IOException, f
  {
    d("Numeric value (" + f() + ") out of range of int (" + -2147483648 + " - " + 2147483647 + ")");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.a.b
 * JD-Core Version:    0.6.2
 */