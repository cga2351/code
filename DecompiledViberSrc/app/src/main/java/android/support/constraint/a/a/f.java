package android.support.constraint.a.a;

import android.support.constraint.a.h;
import java.util.ArrayList;

public class f extends d
{
  protected float ab = -1.0F;
  protected int ac = -1;
  protected int ad = -1;
  private c ae = this.r;
  private int af = 0;
  private boolean ag = false;
  private int ah = 0;
  private i ai = new i();
  private int aj = 8;

  public f()
  {
    this.z.clear();
    this.z.add(this.ae);
    int j = this.y.length;
    while (i < j)
    {
      this.y[i] = this.ae;
      i++;
    }
  }

  public ArrayList<c> E()
  {
    return this.z;
  }

  public int K()
  {
    return this.af;
  }

  public c a(c.c paramc)
  {
    switch (1.a[paramc.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
      do
      {
        do
          throw new AssertionError(paramc.name());
        while (this.af != 1);
        return this.ae;
      }
      while (this.af != 0);
      return this.ae;
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    }
    return null;
  }

  public void a(int paramInt)
  {
    if (this.af == paramInt)
      return;
    this.af = paramInt;
    this.z.clear();
    if (this.af == 1);
    for (this.ae = this.q; ; this.ae = this.r)
    {
      this.z.add(this.ae);
      int i = this.y.length;
      for (int j = 0; j < i; j++)
        this.y[j] = this.ae;
      break;
    }
  }

  public void a(android.support.constraint.a.e parame)
  {
    int i = 1;
    e locale = (e)j();
    if (locale == null)
      return;
    c localc1 = locale.a(c.c.b);
    c localc2 = locale.a(c.c.d);
    int j;
    label58: c localc5;
    c localc3;
    if (this.B != null)
      if (this.B.A[0] == d.a.b)
      {
        j = i;
        if (this.af != 0)
          break label305;
        localc5 = locale.a(c.c.c);
        localc3 = locale.a(c.c.e);
        if (this.B == null)
          break label182;
        if (this.B.A[i] != d.a.b)
          break label177;
      }
    label105: for (c localc4 = localc5; ; localc4 = localc1)
    {
      if (this.ac != -1)
      {
        h localh3 = parame.a(this.ae);
        parame.c(localh3, parame.a(localc4), this.ac, 6);
        if (i == 0)
          break;
        parame.a(parame.a(localc3), localh3, 0, 5);
        return;
        j = 0;
        break label58;
        j = 0;
        break label58;
        i = 0;
        break label105;
        i = 0;
        break label105;
      }
      if (this.ad != -1)
      {
        h localh1 = parame.a(this.ae);
        h localh2 = parame.a(localc3);
        parame.c(localh1, localh2, -this.ad, 6);
        if (i == 0)
          break;
        parame.a(localh1, parame.a(localc4), 0, 5);
        parame.a(localh2, localh1, 0, 5);
        return;
      }
      if (this.ab == -1.0F)
        break;
      parame.a(android.support.constraint.a.e.a(parame, parame.a(this.ae), parame.a(localc4), parame.a(localc3), this.ab, this.ag));
      return;
      i = j;
      localc3 = localc2;
    }
  }

  public boolean a()
  {
    return true;
  }

  public void b(int paramInt)
  {
    d locald = j();
    if (locald == null);
    do
    {
      do
      {
        return;
        if (K() != 1)
          break;
        this.r.a().a(1, locald.r.a(), 0);
        this.t.a().a(1, locald.r.a(), 0);
        if (this.ac != -1)
        {
          this.q.a().a(1, locald.q.a(), this.ac);
          this.s.a().a(1, locald.q.a(), this.ac);
          return;
        }
        if (this.ad != -1)
        {
          this.q.a().a(1, locald.s.a(), -this.ad);
          this.s.a().a(1, locald.s.a(), -this.ad);
          return;
        }
      }
      while ((this.ab == -1.0F) || (locald.I() != d.a.a));
      int j = (int)(locald.C * this.ab);
      this.q.a().a(1, locald.q.a(), j);
      this.s.a().a(1, locald.q.a(), j);
      return;
      this.q.a().a(1, locald.q.a(), 0);
      this.s.a().a(1, locald.q.a(), 0);
      if (this.ac != -1)
      {
        this.r.a().a(1, locald.r.a(), this.ac);
        this.t.a().a(1, locald.r.a(), this.ac);
        return;
      }
      if (this.ad != -1)
      {
        this.r.a().a(1, locald.t.a(), -this.ad);
        this.t.a().a(1, locald.t.a(), -this.ad);
        return;
      }
    }
    while ((this.ab == -1.0F) || (locald.J() != d.a.a));
    int i = (int)(locald.D * this.ab);
    this.r.a().a(1, locald.r.a(), i);
    this.t.a().a(1, locald.r.a(), i);
  }

  public void b(android.support.constraint.a.e parame)
  {
    if (j() == null)
      return;
    int i = parame.b(this.ae);
    if (this.af == 1)
    {
      f(i);
      g(0);
      i(j().q());
      h(0);
      return;
    }
    f(0);
    g(i);
    h(j().o());
    i(0);
  }

  public void e(float paramFloat)
  {
    if (paramFloat > -1.0F)
    {
      this.ab = paramFloat;
      this.ac = -1;
      this.ad = -1;
    }
  }

  public void q(int paramInt)
  {
    if (paramInt > -1)
    {
      this.ab = -1.0F;
      this.ac = paramInt;
      this.ad = -1;
    }
  }

  public void r(int paramInt)
  {
    if (paramInt > -1)
    {
      this.ab = -1.0F;
      this.ac = -1;
      this.ad = paramInt;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.a.a.f
 * JD-Core Version:    0.6.2
 */