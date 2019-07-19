package com.yandex.metrica.impl.ob;

import java.io.IOException;

public final class kl extends e
{
  public byte[] b;
  public long c;
  public long d;

  public kl()
  {
    d();
  }

  public void a(b paramb)
    throws IOException
  {
    paramb.a(1, this.b);
    if (this.c != 0L)
      paramb.a(2, this.c);
    if (this.d != 0L)
      paramb.a(3, this.d);
    super.a(paramb);
  }

  public kl b(a parama)
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
      case 16:
        this.c = parama.e();
        break;
      case 24:
      }
      this.d = parama.e();
    }
  }

  protected int c()
  {
    int i = super.c() + b.b(1, this.b);
    if (this.c != 0L)
      i += b.c(2, this.c);
    if (this.d != 0L)
      i += b.c(3, this.d);
    return i;
  }

  public kl d()
  {
    this.b = g.c;
    this.c = 0L;
    this.d = 0L;
    this.a = -1;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.kl
 * JD-Core Version:    0.6.2
 */