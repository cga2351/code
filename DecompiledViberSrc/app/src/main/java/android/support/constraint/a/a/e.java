package android.support.constraint.a.a;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class e extends n
{
  protected android.support.constraint.a.e ab = new android.support.constraint.a.e();
  int ac;
  int ad;
  int ae;
  int af;
  int ag = 0;
  int ah = 0;
  d[] ai = new d[4];
  d[] aj = new d[4];
  int ak = 0;
  private boolean am = false;
  private m an;
  private int ao = 3;
  private boolean ap = false;
  private boolean aq = false;

  private void W()
  {
    this.ag = 0;
    this.ah = 0;
  }

  private void e(d paramd)
  {
    for (int i = 0; i < this.ag; i++)
      if (this.aj[i] == paramd)
        return;
    if (1 + this.ag >= this.aj.length)
      this.aj = ((d[])Arrays.copyOf(this.aj, 2 * this.aj.length));
    this.aj[this.ag] = paramd;
    this.ag = (1 + this.ag);
  }

  private void f(d paramd)
  {
    for (int i = 0; i < this.ah; i++)
      if (this.ai[i] == paramd)
        return;
    if (1 + this.ah >= this.ai.length)
      this.ai = ((d[])Arrays.copyOf(this.ai, 2 * this.ai.length));
    this.ai[this.ah] = paramd;
    this.ah = (1 + this.ah);
  }

  public int K()
  {
    return this.ao;
  }

  public boolean L()
  {
    return this.ap;
  }

  public boolean M()
  {
    return this.aq;
  }

  public boolean N()
  {
    return this.am;
  }

  public void O()
  {
    int i = this.G;
    int j = this.H;
    int k = Math.max(0, o());
    int m = Math.max(0, q());
    this.ap = false;
    this.aq = false;
    if (this.B != null)
    {
      if (this.an == null)
        this.an = new m(this);
      this.an.a(this);
      f(this.ac);
      g(this.ad);
      H();
      a(this.ab.g());
      if (this.ao == 0)
        break label227;
      if (!q(8))
        R();
      S();
    }
    int n;
    d.a locala1;
    d.a locala2;
    int i1;
    label227: for (this.ab.c = true; ; this.ab.c = false)
    {
      n = 0;
      locala1 = this.A[1];
      locala2 = this.A[0];
      W();
      i1 = this.al.size();
      for (int i2 = 0; i2 < i1; i2++)
      {
        d locald3 = (d)this.al.get(i2);
        if ((locald3 instanceof n))
          ((n)locald3).O();
      }
      this.G = 0;
      this.H = 0;
      break;
    }
    boolean bool1 = true;
    int i3 = 0;
    int i6;
    int i8;
    if (bool1)
    {
      i6 = i3 + 1;
      int i14;
      int i15;
      try
      {
        this.ab.b();
        bool1 = c(this.ab);
        if (bool1)
          this.ab.f();
        if (bool1)
        {
          a(this.ab, h.a);
          if ((i6 >= 8) || (h.a[2] == 0))
            break label977;
          i11 = 0;
          i12 = 0;
          for (int i13 = 0; i13 < i1; i13++)
          {
            d locald2 = (d)this.al.get(i13);
            i11 = Math.max(i11, locald2.G + locald2.o());
            i12 = Math.max(i12, locald2.H + locald2.q());
          }
        }
      }
      catch (Exception localException)
      {
        int i11;
        int i12;
        while (true)
        {
          localException.printStackTrace();
          System.out.println("EXCEPTION : " + localException);
        }
        b(this.ab);
        for (int i7 = 0; i7 < i1; i7++)
        {
          d locald1 = (d)this.al.get(i7);
          if ((locald1.A[0] == d.a.c) && (locald1.o() < locald1.p()))
          {
            h.a[2] = true;
            break;
          }
          if ((locald1.A[1] == d.a.c) && (locald1.q() < locald1.r()))
          {
            h.a[2] = true;
            break;
          }
        }
        i14 = Math.max(this.L, i11);
        i15 = Math.max(this.M, i12);
        if (locala2 != d.a.b)
          break label967;
      }
      if (o() >= i14)
        break label967;
      h(i14);
      this.A[0] = d.a.b;
      i8 = 1;
      bool2 = true;
      label591: if ((locala1 == d.a.b) && (q() < i15))
      {
        i(i15);
        this.A[1] = d.a.b;
        i8 = 1;
      }
    }
    for (boolean bool2 = true; ; bool2 = false)
    {
      int i9 = Math.max(this.L, o());
      if (i9 > o())
      {
        h(i9);
        this.A[0] = d.a.a;
        i8 = 1;
        bool2 = true;
      }
      int i10 = Math.max(this.M, q());
      if (i10 > q())
      {
        i(i10);
        this.A[1] = d.a.a;
        i8 = 1;
        bool2 = true;
      }
      if (i8 == 0)
      {
        if ((this.A[0] == d.a.b) && (k > 0) && (o() > k))
        {
          this.ap = true;
          i8 = 1;
          this.A[0] = d.a.a;
          h(k);
          bool2 = true;
        }
        if ((this.A[1] == d.a.b) && (m > 0) && (q() > m))
        {
          this.aq = true;
          i8 = 1;
          this.A[1] = d.a.a;
          i(m);
          bool2 = true;
        }
      }
      n = i8;
      bool1 = bool2;
      i3 = i6;
      break;
      if (this.B != null)
      {
        int i4 = Math.max(this.L, o());
        int i5 = Math.max(this.M, q());
        this.an.b(this);
        h(i4 + this.ac + this.ae);
        i(i5 + this.ad + this.af);
      }
      while (true)
      {
        if (n != 0)
        {
          this.A[0] = locala2;
          this.A[1] = locala1;
        }
        a(this.ab.g());
        if (this == U())
          F();
        return;
        this.G = i;
        this.H = j;
      }
      label967: i8 = n;
      bool2 = false;
      break label591;
      label977: i8 = n;
    }
  }

  public void P()
  {
    R();
    b(this.ao);
  }

  public void Q()
  {
    j localj1 = a(c.c.b).a();
    j localj2 = a(c.c.c).a();
    localj1.a(null, 0.0F);
    localj2.a(null, 0.0F);
  }

  public void R()
  {
    int i = this.al.size();
    b();
    for (int j = 0; j < i; j++)
      ((d)this.al.get(j)).b();
  }

  public void S()
  {
    if (!q(8))
      b(this.ao);
    Q();
  }

  public boolean T()
  {
    return false;
  }

  public void a(int paramInt)
  {
    this.ao = paramInt;
  }

  void a(d paramd, int paramInt)
  {
    if (paramInt == 0)
    {
      while ((paramd.q.c != null) && (paramd.q.c.a.s.c != null) && (paramd.q.c.a.s.c == paramd.q) && (paramd.q.c.a != paramd))
        paramd = paramd.q.c.a;
      e(paramd);
    }
    while (paramInt != 1)
      return;
    while ((paramd.r.c != null) && (paramd.r.c.a.t.c != null) && (paramd.r.c.a.t.c == paramd.r) && (paramd.r.c.a != paramd))
      paramd = paramd.r.c.a;
    f(paramd);
  }

  public void a(android.support.constraint.a.e parame, boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean[2] = false;
    b(parame);
    int i = this.al.size();
    for (int j = 0; j < i; j++)
    {
      d locald = (d)this.al.get(j);
      locald.b(parame);
      if ((locald.A[0] == d.a.c) && (locald.o() < locald.p()))
        paramArrayOfBoolean[2] = true;
      if ((locald.A[1] == d.a.c) && (locald.q() < locald.r()))
        paramArrayOfBoolean[2] = true;
    }
  }

  public void a(boolean paramBoolean)
  {
    this.am = paramBoolean;
  }

  public void b(int paramInt)
  {
    super.b(paramInt);
    int i = this.al.size();
    for (int j = 0; j < i; j++)
      ((d)this.al.get(j)).b(paramInt);
  }

  public boolean c(android.support.constraint.a.e parame)
  {
    a(parame);
    int i = this.al.size();
    int j = 0;
    if (j < i)
    {
      d locald = (d)this.al.get(j);
      if ((locald instanceof e))
      {
        d.a locala1 = locald.A[0];
        d.a locala2 = locald.A[1];
        if (locala1 == d.a.b)
          locald.a(d.a.a);
        if (locala2 == d.a.b)
          locald.b(d.a.a);
        locald.a(parame);
        if (locala1 == d.a.b)
          locald.a(locala1);
        if (locala2 == d.a.b)
          locald.b(locala2);
      }
      while (true)
      {
        j++;
        break;
        h.a(this, parame, locald);
        locald.a(parame);
      }
    }
    if (this.ag > 0)
      b.a(this, parame, 0);
    if (this.ah > 0)
      b.a(this, parame, 1);
    return true;
  }

  public void e(int paramInt1, int paramInt2)
  {
    if ((this.A[0] != d.a.b) && (this.c != null))
      this.c.a(paramInt1);
    if ((this.A[1] != d.a.b) && (this.d != null))
      this.d.a(paramInt2);
  }

  public void f()
  {
    this.ab.b();
    this.ac = 0;
    this.ae = 0;
    this.ad = 0;
    this.af = 0;
    super.f();
  }

  public boolean q(int paramInt)
  {
    return (paramInt & this.ao) == paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.a.a.e
 * JD-Core Version:    0.6.2
 */