package android.support.constraint.a.a;

import android.support.constraint.a.e;
import android.support.constraint.a.f;
import android.support.constraint.a.h;

public class j extends l
{
  c a;
  float b;
  j c;
  float d;
  j e;
  float f;
  int g = 0;
  private j j;
  private float k;
  private k l = null;
  private int m = 1;
  private k n = null;
  private int o = 1;

  public j(c paramc)
  {
    this.a = paramc;
  }

  String a(int paramInt)
  {
    if (paramInt == 1)
      return "DIRECT";
    if (paramInt == 2)
      return "CENTER";
    if (paramInt == 3)
      return "MATCH";
    if (paramInt == 4)
      return "CHAIN";
    if (paramInt == 5)
      return "BARRIER";
    return "UNCONNECTED";
  }

  public void a()
  {
    int i = 0;
    if (this.i == 1);
    label10: 
    do
    {
      do
      {
        break label10;
        do
          return;
        while (this.g == 4);
        if (this.l == null)
          break;
      }
      while (this.l.i != 1);
      this.d = (this.m * this.l.a);
      if (this.n == null)
        break;
    }
    while (this.n.i != 1);
    this.k = (this.o * this.n.a);
    if ((this.g == 1) && ((this.c == null) || (this.c.i == 1)))
    {
      if (this.c == null)
        this.e = this;
      for (this.f = this.d; ; this.f = (this.c.f + this.d))
      {
        f();
        return;
        this.e = this.c.e;
      }
    }
    float f1;
    float f2;
    float f3;
    label359: int i1;
    int i2;
    float f4;
    if ((this.g == 2) && (this.c != null) && (this.c.i == 1) && (this.j != null) && (this.j.c != null) && (this.j.c.i == 1))
    {
      if (e.a() != null)
      {
        f localf2 = e.a();
        localf2.w = (1L + localf2.w);
      }
      this.e = this.c.e;
      this.j.e = this.j.c.e;
      if (this.k > 0.0F)
      {
        f1 = this.c.f - this.j.c.f;
        if ((this.a.b != c.c.b) && (this.a.b != c.c.d))
          break label510;
        f2 = f1 - this.a.a.o();
        f3 = this.a.a.O;
        i1 = this.a.e();
        i2 = this.j.a.e();
        if (this.a.g() != this.j.a.g())
          break label769;
        f4 = 0.5F;
      }
    }
    for (int i3 = 0; ; i3 = i2)
    {
      float f5 = f2 - i - i3;
      if (this.k > 0.0F)
        this.j.f = (this.j.c.f + i3 + f5 * f4);
      for (this.f = (this.c.f - i - f5 * (1.0F - f4)); ; this.j.f = (this.j.c.f - i3 - f5 * (1.0F - f4)))
      {
        f();
        this.j.f();
        return;
        f1 = this.j.c.f - this.c.f;
        break;
        label510: f2 = f1 - this.a.a.q();
        f3 = this.a.a.P;
        break label359;
        this.f = (this.c.f + i + f5 * f4);
      }
      if ((this.g == 3) && (this.c != null) && (this.c.i == 1) && (this.j != null) && (this.j.c != null) && (this.j.c.i == 1))
      {
        if (e.a() != null)
        {
          f localf1 = e.a();
          localf1.x = (1L + localf1.x);
        }
        this.e = this.c.e;
        this.j.e = this.j.c.e;
        this.f = (this.c.f + this.d);
        this.j.f = (this.j.c.f + this.j.d);
        f();
        this.j.f();
        return;
      }
      if (this.g != 5)
        break;
      this.a.a.c();
      return;
      label769: i = i1;
      f4 = f3;
    }
  }

  public void a(int paramInt1, j paramj, int paramInt2)
  {
    this.g = paramInt1;
    this.c = paramj;
    this.d = paramInt2;
    this.c.a(this);
  }

  public void a(j paramj, float paramFloat)
  {
    if ((this.i == 0) || ((this.e != paramj) && (this.f != paramFloat)))
    {
      this.e = paramj;
      this.f = paramFloat;
      if (this.i == 1)
        e();
      f();
    }
  }

  public void a(j paramj, int paramInt)
  {
    this.c = paramj;
    this.d = paramInt;
    this.c.a(this);
  }

  public void a(j paramj, int paramInt, k paramk)
  {
    this.c = paramj;
    this.c.a(this);
    this.l = paramk;
    this.m = paramInt;
    this.l.a(this);
  }

  void a(e parame)
  {
    h localh = this.a.b();
    if (this.e == null)
    {
      parame.a(localh, (int)this.f);
      return;
    }
    parame.c(localh, parame.a(this.e.a), (int)this.f, 6);
  }

  public void b()
  {
    super.b();
    this.c = null;
    this.d = 0.0F;
    this.l = null;
    this.m = 1;
    this.n = null;
    this.o = 1;
    this.e = null;
    this.f = 0.0F;
    this.b = 0.0F;
    this.j = null;
    this.k = 0.0F;
    this.g = 0;
  }

  public void b(int paramInt)
  {
    this.g = paramInt;
  }

  public void b(j paramj, float paramFloat)
  {
    this.j = paramj;
    this.k = paramFloat;
  }

  public void b(j paramj, int paramInt, k paramk)
  {
    this.j = paramj;
    this.n = paramk;
    this.o = paramInt;
  }

  public void c()
  {
    c localc = this.a.g();
    if (localc == null)
      return;
    if (localc.g() == this.a)
    {
      this.g = 4;
      localc.a().g = 4;
    }
    int i = this.a.e();
    if ((this.a.b == c.c.d) || (this.a.b == c.c.e))
      i = -i;
    a(localc.a(), i);
  }

  public float d()
  {
    return this.f;
  }

  public String toString()
  {
    if (this.i == 1)
    {
      if (this.e == this)
        return "[" + this.a + ", RESOLVED: " + this.f + "]  type: " + a(this.g);
      return "[" + this.a + ", RESOLVED: " + this.e + ":" + this.f + "] type: " + a(this.g);
    }
    return "{ " + this.a + " UNRESOLVED} type: " + a(this.g);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.a.a.j
 * JD-Core Version:    0.6.2
 */