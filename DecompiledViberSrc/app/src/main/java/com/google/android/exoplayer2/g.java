package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g.b;
import com.google.android.exoplayer2.g.n;
import com.google.android.exoplayer2.g.z;

final class g
  implements n
{
  private final z a;
  private final a b;
  private ad c;
  private n d;

  public g(a parama, b paramb)
  {
    this.b = parama;
    this.a = new z(paramb);
  }

  private void f()
  {
    long l = this.d.d();
    this.a.a(l);
    y localy = this.d.e();
    if (!localy.equals(this.a.e()))
    {
      this.a.a(localy);
      this.b.a(localy);
    }
  }

  private boolean g()
  {
    return (this.c != null) && (!this.c.v()) && ((this.c.u()) || (!this.c.g()));
  }

  public y a(y paramy)
  {
    if (this.d != null)
      paramy = this.d.a(paramy);
    this.a.a(paramy);
    this.b.a(paramy);
    return paramy;
  }

  public void a()
  {
    this.a.a();
  }

  public void a(long paramLong)
  {
    this.a.a(paramLong);
  }

  public void a(ad paramad)
    throws i
  {
    n localn = paramad.c();
    if ((localn != null) && (localn != this.d))
    {
      if (this.d != null)
        throw i.a(new IllegalStateException("Multiple renderer media clocks enabled."));
      this.d = localn;
      this.c = paramad;
      this.d.a(this.a.e());
      f();
    }
  }

  public void b()
  {
    this.a.b();
  }

  public void b(ad paramad)
  {
    if (paramad == this.c)
    {
      this.d = null;
      this.c = null;
    }
  }

  public long c()
  {
    if (g())
    {
      f();
      return this.d.d();
    }
    return this.a.d();
  }

  public long d()
  {
    if (g())
      return this.d.d();
    return this.a.d();
  }

  public y e()
  {
    if (this.d != null)
      return this.d.e();
    return this.a.e();
  }

  public static abstract interface a
  {
    public abstract void a(y paramy);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g
 * JD-Core Version:    0.6.2
 */