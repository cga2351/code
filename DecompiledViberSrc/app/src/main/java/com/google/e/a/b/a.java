package com.google.e.a.b;

import com.google.e.c.b.c;
import com.google.e.c.b.e;
import com.google.e.c.i;
import com.google.e.j;
import com.google.e.p;

public final class a
{
  private static final int[] g = { 3808, 476, 2107, 1799 };
  private final com.google.e.c.b a;
  private boolean b;
  private int c;
  private int d;
  private int e;
  private int f;

  public a(com.google.e.c.b paramb)
  {
    this.a = paramb;
  }

  private static float a(p paramp1, p paramp2)
  {
    return com.google.e.c.a.a.a(paramp1.a(), paramp1.b(), paramp2.a(), paramp2.b());
  }

  private static int a(long paramLong, boolean paramBoolean)
    throws j
  {
    int i = 0;
    int j;
    if (paramBoolean)
      j = 7;
    int m;
    int[] arrayOfInt;
    for (int k = 2; ; k = 4)
    {
      m = j - k;
      arrayOfInt = new int[j];
      for (int n = j - 1; n >= 0; n--)
      {
        arrayOfInt[n] = (0xF & (int)paramLong);
        paramLong >>= 4;
      }
      j = 10;
    }
    try
    {
      new c(com.google.e.c.b.a.d).a(arrayOfInt, m);
      for (int i1 = 0; i1 < k; i1++)
        i = (i << 4) + arrayOfInt[i1];
    }
    catch (e locale)
    {
      throw j.a();
    }
    return i;
  }

  private int a(a parama1, a parama2)
  {
    float f1 = b(parama1, parama2);
    float f2 = (parama2.b() - parama1.b()) / f1;
    float f3 = (parama2.c() - parama1.c()) / f1;
    float f4 = parama1.b();
    float f5 = parama1.c();
    boolean bool1 = this.a.a(parama1.b(), parama1.c());
    int i = 0;
    float f6 = f4;
    float f7 = f5;
    for (int j = 0; j < f1; j++)
    {
      f6 += f2;
      f7 += f3;
      if (this.a.a(com.google.e.c.a.a.a(f6), com.google.e.c.a.a.a(f7)) != bool1)
        i++;
    }
    float f8 = i / f1;
    if ((f8 > 0.1F) && (f8 < 0.9F))
      return 0;
    if (f8 <= 0.1F);
    for (boolean bool2 = true; bool2 == bool1; bool2 = false)
      return 1;
    return -1;
  }

  private int a(p paramp1, p paramp2, int paramInt)
  {
    int i = 0;
    float f1 = a(paramp1, paramp2);
    float f2 = f1 / paramInt;
    float f3 = paramp1.a();
    float f4 = paramp1.b();
    float f5 = f2 * (paramp2.a() - paramp1.a()) / f1;
    float f6 = f2 * (paramp2.b() - paramp1.b()) / f1;
    for (int j = 0; j < paramInt; j++)
      if (this.a.a(com.google.e.c.a.a.a(f3 + f5 * j), com.google.e.c.a.a.a(f4 + f6 * j)))
        i |= 1 << -1 + (paramInt - j);
    return i;
  }

  private static int a(int[] paramArrayOfInt, int paramInt)
    throws j
  {
    int i = 0;
    int j = paramArrayOfInt.length;
    int k = 0;
    int m = 0;
    while (k < j)
    {
      int i1 = paramArrayOfInt[k];
      m = (i1 >> paramInt - 2 << 1) + (i1 & 0x1) + (m << 3);
      k++;
    }
    int n = ((m & 0x1) << 11) + (m >> 1);
    while (i < 4)
    {
      if (Integer.bitCount(n ^ g[i]) <= 2)
        return i;
      i++;
    }
    throw j.a();
  }

  private a a()
  {
    try
    {
      p[] arrayOfp2 = new com.google.e.c.a.b(this.a).a();
      localp1 = arrayOfp2[0];
      localp2 = arrayOfp2[1];
      localp3 = arrayOfp2[2];
      localp4 = arrayOfp2[3];
      k = com.google.e.c.a.a.a((localp1.a() + localp4.a() + localp2.a() + localp3.a()) / 4.0F);
      m = com.google.e.c.a.a.a((localp1.b() + localp4.b() + localp2.b() + localp3.b()) / 4.0F);
    }
    catch (j localj1)
    {
      try
      {
        p[] arrayOfp1 = new com.google.e.c.a.b(this.a, 15, k, m).a();
        localp5 = arrayOfp1[0];
        localp6 = arrayOfp1[1];
        localp7 = arrayOfp1[2];
        localp8 = arrayOfp1[3];
        return new a(com.google.e.c.a.a.a((localp5.a() + localp8.a() + localp6.a() + localp7.a()) / 4.0F), com.google.e.c.a.a.a((localp5.b() + localp8.b() + localp6.b() + localp7.b()) / 4.0F));
        localj1 = localj1;
        int i = this.a.e() / 2;
        int j = this.a.f() / 2;
        p localp1 = a(new a(i + 7, j - 7), false, 1, -1).a();
        p localp2 = a(new a(i + 7, j + 7), false, 1, 1).a();
        p localp3 = a(new a(i - 7, j + 7), false, -1, 1).a();
        p localp4 = a(new a(i - 7, j - 7), false, -1, -1).a();
      }
      catch (j localj2)
      {
        while (true)
        {
          int k;
          int m;
          p localp5 = a(new a(k + 7, m - 7), false, 1, -1).a();
          p localp6 = a(new a(k + 7, m + 7), false, 1, 1).a();
          p localp7 = a(new a(k - 7, m + 7), false, -1, 1).a();
          p localp8 = a(new a(k - 7, m - 7), false, -1, -1).a();
        }
      }
    }
  }

  private a a(a parama, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + parama.b();
    int j = paramInt2 + parama.c();
    while ((a(i, j)) && (this.a.a(i, j) == paramBoolean))
    {
      i += paramInt1;
      j += paramInt2;
    }
    int k = i - paramInt1;
    int m = j - paramInt2;
    int n = k;
    while ((a(n, m)) && (this.a.a(n, m) == paramBoolean))
      n += paramInt1;
    int i1 = n - paramInt1;
    int i2 = m;
    while ((a(i1, i2)) && (this.a.a(i1, i2) == paramBoolean))
      i2 += paramInt2;
    return new a(i1, i2 - paramInt2);
  }

  private com.google.e.c.b a(com.google.e.c.b paramb, p paramp1, p paramp2, p paramp3, p paramp4)
    throws j
  {
    i locali = i.a();
    int i = b();
    float f1 = i / 2.0F - this.e;
    float f2 = i / 2.0F + this.e;
    return locali.a(paramb, i, i, f1, f1, f2, f1, f2, f2, f1, f2, paramp1.a(), paramp1.b(), paramp2.a(), paramp2.b(), paramp3.a(), paramp3.b(), paramp4.a(), paramp4.b());
  }

  private void a(p[] paramArrayOfp)
    throws j
  {
    if ((!a(paramArrayOfp[0])) || (!a(paramArrayOfp[1])) || (!a(paramArrayOfp[2])) || (!a(paramArrayOfp[3])))
      throw j.a();
    int i = 2 * this.e;
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = a(paramArrayOfp[0], paramArrayOfp[1], i);
    arrayOfInt[1] = a(paramArrayOfp[1], paramArrayOfp[2], i);
    arrayOfInt[2] = a(paramArrayOfp[2], paramArrayOfp[3], i);
    arrayOfInt[3] = a(paramArrayOfp[3], paramArrayOfp[0], i);
    this.f = a(arrayOfInt, i);
    long l = 0L;
    int j = 0;
    if (j < 4)
    {
      int m = arrayOfInt[((j + this.f) % 4)];
      if (this.b);
      for (l = (l << 7) + (0x7F & m >> 1); ; l = (l << 10) + ((0x3E0 & m >> 2) + (0x1F & m >> 1)))
      {
        j++;
        break;
      }
    }
    int k = a(l, this.b);
    if (this.b)
    {
      this.c = (1 + (k >> 6));
      this.d = (1 + (k & 0x3F));
      return;
    }
    this.c = (1 + (k >> 11));
    this.d = (1 + (k & 0x7FF));
  }

  private boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 >= 0) && (paramInt1 < this.a.e()) && (paramInt2 > 0) && (paramInt2 < this.a.f());
  }

  private boolean a(a parama1, a parama2, a parama3, a parama4)
  {
    a locala1 = new a(parama1.b() - 3, 3 + parama1.c());
    a locala2 = new a(parama2.b() - 3, parama2.c() - 3);
    a locala3 = new a(3 + parama3.b(), parama3.c() - 3);
    a locala4 = new a(3 + parama4.b(), 3 + parama4.c());
    int i = a(locala4, locala1);
    if (i == 0);
    while ((a(locala1, locala2) != i) || (a(locala2, locala3) != i) || (a(locala3, locala4) != i))
      return false;
    return true;
  }

  private boolean a(p paramp)
  {
    return a(com.google.e.c.a.a.a(paramp.a()), com.google.e.c.a.a.a(paramp.b()));
  }

  private p[] a(a parama)
    throws j
  {
    boolean bool1 = true;
    this.e = 1;
    Object localObject1 = parama;
    Object localObject2 = parama;
    Object localObject3 = parama;
    a locala1;
    a locala2;
    a locala3;
    a locala4;
    if (this.e < 9)
    {
      locala1 = a((a)localObject3, bool1, 1, -1);
      locala2 = a((a)localObject2, bool1, 1, 1);
      locala3 = a((a)localObject1, bool1, -1, 1);
      locala4 = a(parama, bool1, -1, -1);
      if (this.e > 2)
      {
        float f1 = b(locala4, locala1) * this.e / (b(parama, (a)localObject3) * (2 + this.e));
        if ((f1 >= 0.75D) && (f1 <= 1.25D) && (a(locala1, locala2, locala3, locala4)));
      }
    }
    else
    {
      if ((this.e == 5) || (this.e == 7))
        break label198;
      throw j.a();
    }
    if (!bool1);
    for (bool1 = true; ; bool1 = false)
    {
      this.e = (1 + this.e);
      parama = locala4;
      localObject1 = locala3;
      localObject2 = locala2;
      localObject3 = locala1;
      break;
    }
    label198: if (this.e == 5);
    for (boolean bool2 = true; ; bool2 = false)
    {
      this.b = bool2;
      return a(new p[] { new p(0.5F + ((a)localObject3).b(), ((a)localObject3).c() - 0.5F), new p(0.5F + ((a)localObject2).b(), 0.5F + ((a)localObject2).c()), new p(((a)localObject1).b() - 0.5F, 0.5F + ((a)localObject1).c()), new p(parama.b() - 0.5F, parama.c() - 0.5F) }, -3 + 2 * this.e, 2 * this.e);
    }
  }

  private static p[] a(p[] paramArrayOfp, float paramFloat1, float paramFloat2)
  {
    float f1 = paramFloat2 / (2.0F * paramFloat1);
    float f2 = paramArrayOfp[0].a() - paramArrayOfp[2].a();
    float f3 = paramArrayOfp[0].b() - paramArrayOfp[2].b();
    float f4 = (paramArrayOfp[0].a() + paramArrayOfp[2].a()) / 2.0F;
    float f5 = (paramArrayOfp[0].b() + paramArrayOfp[2].b()) / 2.0F;
    p localp1 = new p(f4 + f1 * f2, f5 + f1 * f3);
    p localp2 = new p(f4 - f2 * f1, f5 - f3 * f1);
    float f6 = paramArrayOfp[1].a() - paramArrayOfp[3].a();
    float f7 = paramArrayOfp[1].b() - paramArrayOfp[3].b();
    float f8 = (paramArrayOfp[1].a() + paramArrayOfp[3].a()) / 2.0F;
    float f9 = (paramArrayOfp[1].b() + paramArrayOfp[3].b()) / 2.0F;
    return new p[] { localp1, new p(f8 + f1 * f6, f9 + f1 * f7), localp2, new p(f8 - f6 * f1, f9 - f1 * f7) };
  }

  private static float b(a parama1, a parama2)
  {
    return com.google.e.c.a.a.a(parama1.b(), parama1.c(), parama2.b(), parama2.c());
  }

  private int b()
  {
    if (this.b)
      return 11 + 4 * this.c;
    if (this.c <= 4)
      return 15 + 4 * this.c;
    return 15 + (4 * this.c + 2 * (1 + (-4 + this.c) / 8));
  }

  private p[] b(p[] paramArrayOfp)
  {
    return a(paramArrayOfp, 2 * this.e, b());
  }

  public com.google.e.a.a a(boolean paramBoolean)
    throws j
  {
    p[] arrayOfp = a(a());
    if (paramBoolean)
    {
      p localp = arrayOfp[0];
      arrayOfp[0] = arrayOfp[2];
      arrayOfp[2] = localp;
    }
    a(arrayOfp);
    return new com.google.e.a.a(a(this.a, arrayOfp[(this.f % 4)], arrayOfp[((1 + this.f) % 4)], arrayOfp[((2 + this.f) % 4)], arrayOfp[((3 + this.f) % 4)]), b(arrayOfp), this.b, this.d, this.c);
  }

  static final class a
  {
    private final int a;
    private final int b;

    a(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }

    p a()
    {
      return new p(b(), c());
    }

    int b()
    {
      return this.a;
    }

    int c()
    {
      return this.b;
    }

    public String toString()
    {
      return "<" + this.a + ' ' + this.b + '>';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.a.b.a
 * JD-Core Version:    0.6.2
 */