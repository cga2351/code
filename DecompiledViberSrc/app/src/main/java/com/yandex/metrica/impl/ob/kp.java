package com.yandex.metrica.impl.ob;

import java.io.IOException;

public abstract interface kp
{
  public static final class a extends e
  {
    public boolean b;
    public int c;
    public int d;
    public int[] e;

    public a()
    {
      d();
    }

    public void a(b paramb)
      throws IOException
    {
      paramb.a(1, this.b);
      paramb.b(2, this.c);
      paramb.b(3, this.d);
      if ((this.e != null) && (this.e.length > 0))
        for (int i = 0; i < this.e.length; i++)
          paramb.a(4, this.e[i]);
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
          this.b = parama.h();
          break;
        case 16:
          this.c = parama.k();
          break;
        case 24:
          this.d = parama.k();
          break;
        case 32:
          int i1 = g.b(parama, 32);
          if (this.e == null);
          int[] arrayOfInt2;
          for (int i2 = 0; ; i2 = this.e.length)
          {
            arrayOfInt2 = new int[i1 + i2];
            if (i2 != 0)
              System.arraycopy(this.e, 0, arrayOfInt2, 0, i2);
            while (i2 < -1 + arrayOfInt2.length)
            {
              arrayOfInt2[i2] = parama.g();
              parama.a();
              i2++;
            }
          }
          arrayOfInt2[i2] = parama.g();
          this.e = arrayOfInt2;
          break;
        case 34:
        }
        int j = parama.c(parama.m());
        int k = parama.s();
        for (int m = 0; parama.q() > 0; m++)
          parama.g();
        parama.e(k);
        if (this.e == null);
        int[] arrayOfInt1;
        for (int n = 0; ; n = this.e.length)
        {
          arrayOfInt1 = new int[m + n];
          if (n != 0)
            System.arraycopy(this.e, 0, arrayOfInt1, 0, n);
          while (n < arrayOfInt1.length)
          {
            arrayOfInt1[n] = parama.g();
            n++;
          }
        }
        this.e = arrayOfInt1;
        parama.d(j);
      }
    }

    protected int c()
    {
      int i = 0;
      int j = super.c() + b.f(1) + b.e(2, this.c) + b.e(3, this.d);
      if ((this.e != null) && (this.e.length > 0))
      {
        int k = 0;
        while (i < this.e.length)
        {
          k += b.g(this.e[i]);
          i++;
        }
        return j + k + 1 * this.e.length;
      }
      return j;
    }

    public a d()
    {
      this.b = false;
      this.c = 0;
      this.d = 0;
      this.e = g.a;
      this.a = -1;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.kp
 * JD-Core Version:    0.6.2
 */