package com.google.a.a.f;

import java.io.IOException;

public class l
  implements c
{
  long c;
  private int d;
  private final int e;
  private final double f;
  private final double g;
  private final int h;
  private final int i;
  private final v j;

  public l()
  {
    this(new a());
  }

  protected l(a parama)
  {
    this.e = parama.a;
    this.f = parama.b;
    this.g = parama.c;
    this.h = parama.d;
    this.i = parama.e;
    this.j = parama.f;
    boolean bool2;
    boolean bool3;
    label88: boolean bool4;
    label105: boolean bool5;
    if (this.e > 0)
    {
      bool2 = bool1;
      z.a(bool2);
      if ((0.0D > this.f) || (this.f >= 1.0D))
        break label150;
      bool3 = bool1;
      z.a(bool3);
      if (this.g < 1.0D)
        break label156;
      bool4 = bool1;
      z.a(bool4);
      if (this.h < this.e)
        break label162;
      bool5 = bool1;
      label124: z.a(bool5);
      if (this.i <= 0)
        break label168;
    }
    while (true)
    {
      z.a(bool1);
      a();
      return;
      bool2 = false;
      break;
      label150: bool3 = false;
      break label88;
      label156: bool4 = false;
      break label105;
      label162: bool5 = false;
      break label124;
      label168: bool1 = false;
    }
  }

  static int a(double paramDouble1, double paramDouble2, int paramInt)
  {
    double d1 = paramDouble1 * paramInt;
    double d2 = paramInt - d1;
    return (int)(d2 + paramDouble2 * (1.0D + (d1 + paramInt - d2)));
  }

  private void d()
  {
    if (this.d >= this.h / this.g)
    {
      this.d = this.h;
      return;
    }
    this.d = ((int)(this.d * this.g));
  }

  public final void a()
  {
    this.d = this.e;
    this.c = this.j.a();
  }

  public long b()
    throws IOException
  {
    if (c() > this.i)
      return -1L;
    int k = a(this.f, Math.random(), this.d);
    d();
    return k;
  }

  public final long c()
  {
    return (this.j.a() - this.c) / 1000000L;
  }

  public static class a
  {
    int a = 500;
    double b = 0.5D;
    double c = 1.5D;
    int d = 60000;
    int e = 900000;
    v f = v.a;

    public a a(int paramInt)
    {
      this.e = paramInt;
      return this;
    }

    public l a()
    {
      return new l(this);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.f.l
 * JD-Core Version:    0.6.2
 */