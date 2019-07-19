package com.yandex.metrica.impl.ob;

import java.io.IOException;
import java.util.Arrays;

public final class kn extends e
{
  public int b;
  public double c;
  public byte[] d;
  public byte[] e;
  public byte[] f;
  public a g;

  public kn()
  {
    d();
  }

  public void a(b paramb)
    throws IOException
  {
    if (this.b != 1)
      paramb.b(1, this.b);
    paramb.a(2, this.c);
    paramb.a(3, this.d);
    if (!Arrays.equals(this.e, g.c))
      paramb.a(4, this.e);
    if (!Arrays.equals(this.f, g.c))
      paramb.a(5, this.f);
    if (this.g != null)
      paramb.a(6, this.g);
    super.a(paramb);
  }

  public kn b(a parama)
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
      case 17:
        this.c = parama.c();
        break;
      case 26:
        this.d = parama.j();
        break;
      case 34:
        this.e = parama.j();
        break;
      case 42:
        this.f = parama.j();
        break;
      case 50:
      }
      if (this.g == null)
        this.g = new a();
      parama.a(this.g);
    }
  }

  protected int c()
  {
    int i = super.c();
    if (this.b != 1)
      i += b.e(1, this.b);
    int j = i + b.d(2) + b.b(3, this.d);
    if (!Arrays.equals(this.e, g.c))
      j += b.b(4, this.e);
    if (!Arrays.equals(this.f, g.c))
      j += b.b(5, this.f);
    if (this.g != null)
      j += b.b(6, this.g);
    return j;
  }

  public kn d()
  {
    this.b = 1;
    this.c = 0.0D;
    this.d = g.c;
    this.e = g.c;
    this.f = g.c;
    this.g = null;
    this.a = -1;
    return this;
  }

  public static final class a extends e
  {
    public byte[] b;
    public byte[] c;

    public a()
    {
      d();
    }

    public void a(b paramb)
      throws IOException
    {
      if (!Arrays.equals(this.b, g.c))
        paramb.a(1, this.b);
      if (!Arrays.equals(this.c, g.c))
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
          this.b = parama.j();
          break;
        case 18:
        }
        this.c = parama.j();
      }
    }

    protected int c()
    {
      int i = super.c();
      if (!Arrays.equals(this.b, g.c))
        i += b.b(1, this.b);
      if (!Arrays.equals(this.c, g.c))
        i += b.b(2, this.c);
      return i;
    }

    public a d()
    {
      this.b = g.c;
      this.c = g.c;
      this.a = -1;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.kn
 * JD-Core Version:    0.6.2
 */