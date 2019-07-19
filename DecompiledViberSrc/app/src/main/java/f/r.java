package f;

import java.util.Arrays;

final class r extends f
{
  final transient byte[][] f;
  final transient int[] g;

  r(c paramc, int paramInt)
  {
    super(null);
    v.a(paramc.b, 0L, paramInt);
    p localp1 = paramc.a;
    int j = 0;
    int k = 0;
    while (k < paramInt)
    {
      if (localp1.c == localp1.b)
        throw new AssertionError("s.limit == s.pos");
      k += localp1.c - localp1.b;
      j++;
      localp1 = localp1.f;
    }
    this.f = new byte[j][];
    this.g = new int[j * 2];
    p localp2 = paramc.a;
    int m = 0;
    while (i < paramInt)
    {
      this.f[m] = localp2.a;
      int n = i + (localp2.c - localp2.b);
      if (n > paramInt)
        n = paramInt;
      this.g[m] = n;
      this.g[(m + this.f.length)] = localp2.b;
      localp2.d = true;
      m++;
      localp2 = localp2.f;
      i = n;
    }
  }

  private int b(int paramInt)
  {
    int i = Arrays.binarySearch(this.g, 0, this.f.length, paramInt + 1);
    if (i >= 0)
      return i;
    return i ^ 0xFFFFFFFF;
  }

  private f j()
  {
    return new f(i());
  }

  public byte a(int paramInt)
  {
    v.a(this.g[(-1 + this.f.length)], paramInt, 1L);
    int i = b(paramInt);
    if (i == 0);
    for (int j = 0; ; j = this.g[(i - 1)])
    {
      int k = this.g[(i + this.f.length)];
      return this.f[i][(k + (paramInt - j))];
    }
  }

  public f a(int paramInt1, int paramInt2)
  {
    return j().a(paramInt1, paramInt2);
  }

  public String a()
  {
    return j().a();
  }

  void a(c paramc)
  {
    int i = this.f.length;
    int j = 0;
    int k = 0;
    if (j < i)
    {
      int m = this.g[(i + j)];
      int n = this.g[j];
      p localp = new p(this.f[j], m, m + n - k, true, false);
      if (paramc.a == null)
      {
        localp.g = localp;
        localp.f = localp;
        paramc.a = localp;
      }
      while (true)
      {
        j++;
        k = n;
        break;
        paramc.a.g.a(localp);
      }
    }
    paramc.b += k;
  }

  public boolean a(int paramInt1, f paramf, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt1 > h() - paramInt3))
      return false;
    int i = b(paramInt1);
    label24: if (paramInt3 > 0)
    {
      if (i == 0);
      for (int j = 0; ; j = this.g[(i - 1)])
      {
        int k = Math.min(paramInt3, j + (this.g[i] - j) - paramInt1);
        int m = this.g[(i + this.f.length)] + (paramInt1 - j);
        if (!paramf.a(paramInt2, this.f[i], m, k))
          break;
        paramInt1 += k;
        paramInt2 += k;
        paramInt3 -= k;
        i++;
        break label24;
      }
    }
    return true;
  }

  public boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt1 > h() - paramInt3) || (paramInt2 < 0) || (paramInt2 > paramArrayOfByte.length - paramInt3))
      return false;
    int i = b(paramInt1);
    label37: if (paramInt3 > 0)
    {
      if (i == 0);
      for (int j = 0; ; j = this.g[(i - 1)])
      {
        int k = Math.min(paramInt3, j + (this.g[i] - j) - paramInt1);
        int m = this.g[(i + this.f.length)] + (paramInt1 - j);
        if (!v.a(this.f[i], m, paramArrayOfByte, paramInt2, k))
          break;
        paramInt1 += k;
        paramInt2 += k;
        paramInt3 -= k;
        i++;
        break label37;
      }
    }
    return true;
  }

  public String b()
  {
    return j().b();
  }

  public f c()
  {
    return j().c();
  }

  public f d()
  {
    return j().d();
  }

  public f e()
  {
    return j().e();
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this)
      return true;
    if (((paramObject instanceof f)) && (((f)paramObject).h() == h()) && (a(0, (f)paramObject, 0, h())));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public String f()
  {
    return j().f();
  }

  public f g()
  {
    return j().g();
  }

  public int h()
  {
    return this.g[(-1 + this.f.length)];
  }

  public int hashCode()
  {
    int i = this.d;
    if (i != 0)
      return i;
    int j = 1;
    int k = this.f.length;
    int m = 0;
    int n = 0;
    while (m < k)
    {
      byte[] arrayOfByte = this.f[m];
      int i1 = this.g[(k + m)];
      int i2 = this.g[m];
      int i3 = i1 + (i2 - n);
      int i4 = j;
      for (int i5 = i1; i5 < i3; i5++)
        i4 = i4 * 31 + arrayOfByte[i5];
      m++;
      n = i2;
      j = i4;
    }
    this.d = j;
    return j;
  }

  public byte[] i()
  {
    int i = 0;
    byte[] arrayOfByte = new byte[this.g[(-1 + this.f.length)]];
    int j = this.f.length;
    int n;
    for (int k = 0; i < j; k = n)
    {
      int m = this.g[(j + i)];
      n = this.g[i];
      System.arraycopy(this.f[i], m, arrayOfByte, k, n - k);
      i++;
    }
    return arrayOfByte;
  }

  public String toString()
  {
    return j().toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     f.r
 * JD-Core Version:    0.6.2
 */