package com.google.e.h.b;

import com.google.e.c.i;
import com.google.e.c.k;
import com.google.e.p;
import com.google.e.q;
import java.util.Map;

public class c
{
  private final com.google.e.c.b a;
  private q b;

  public c(com.google.e.c.b paramb)
  {
    this.a = paramb;
  }

  private float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    float f1 = b(paramInt1, paramInt2, paramInt3, paramInt4);
    int j = paramInt1 - (paramInt3 - paramInt1);
    float f2;
    int k;
    if (j < 0)
    {
      f2 = paramInt1 / (paramInt1 - j);
      k = 0;
    }
    while (true)
    {
      int m = (int)(paramInt2 - f2 * (paramInt4 - paramInt2));
      float f3;
      if (m < 0)
        f3 = paramInt2 / (paramInt2 - m);
      while (true)
      {
        return f1 + b(paramInt1, paramInt2, (int)(paramInt1 + f3 * (k - paramInt1)), i) - 1.0F;
        if (j < this.a.e())
          break label204;
        float f4 = (-1 + this.a.e() - paramInt1) / (j - paramInt1);
        int n = -1 + this.a.e();
        f2 = f4;
        k = n;
        break;
        if (m >= this.a.f())
        {
          f3 = (-1 + this.a.f() - paramInt2) / (m - paramInt2);
          i = -1 + this.a.f();
        }
        else
        {
          i = m;
          f3 = 1.0F;
        }
      }
      label204: k = j;
      f2 = 1.0F;
    }
  }

  private float a(p paramp1, p paramp2)
  {
    float f1 = a((int)paramp1.a(), (int)paramp1.b(), (int)paramp2.a(), (int)paramp2.b());
    float f2 = a((int)paramp2.a(), (int)paramp2.b(), (int)paramp1.a(), (int)paramp1.b());
    if (Float.isNaN(f1))
      return f2 / 7.0F;
    if (Float.isNaN(f2))
      return f1 / 7.0F;
    return (f1 + f2) / 14.0F;
  }

  private static int a(p paramp1, p paramp2, p paramp3, float paramFloat)
    throws com.google.e.j
  {
    int i = 7 + (com.google.e.c.a.a.a(p.a(paramp1, paramp2) / paramFloat) + com.google.e.c.a.a.a(p.a(paramp1, paramp3) / paramFloat)) / 2;
    switch (i & 0x3)
    {
    case 1:
    default:
      return i;
    case 0:
      return i + 1;
    case 2:
      return i - 1;
    case 3:
    }
    throw com.google.e.j.a();
  }

  private static com.google.e.c.b a(com.google.e.c.b paramb, k paramk, int paramInt)
    throws com.google.e.j
  {
    return i.a().a(paramb, paramInt, paramInt, paramk);
  }

  private static k a(p paramp1, p paramp2, p paramp3, p paramp4, int paramInt)
  {
    float f1 = paramInt - 3.5F;
    float f2;
    float f3;
    float f4;
    if (paramp4 != null)
    {
      f2 = paramp4.a();
      f3 = paramp4.b();
      f4 = f1 - 3.0F;
    }
    for (float f5 = f4; ; f5 = f1)
    {
      return k.a(3.5F, 3.5F, f1, 3.5F, f5, f4, 3.5F, f1, paramp1.a(), paramp1.b(), paramp2.a(), paramp2.b(), f2, f3, paramp3.a(), paramp3.b());
      f2 = paramp2.a() - paramp1.a() + paramp3.a();
      f3 = paramp2.b() - paramp1.b() + paramp3.b();
      f4 = f1;
    }
  }

  private float b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i;
    if (Math.abs(paramInt4 - paramInt2) > Math.abs(paramInt3 - paramInt1))
    {
      i = 1;
      if (i == 0)
        break label299;
    }
    while (true)
    {
      int m = Math.abs(paramInt4 - paramInt2);
      int n = Math.abs(paramInt3 - paramInt1);
      int i1 = -m / 2;
      int i2;
      label57: int i3;
      label65: int i4;
      int i6;
      int i7;
      int i8;
      int i10;
      label101: int i11;
      label110: int i12;
      if (paramInt2 < paramInt4)
      {
        i2 = 1;
        if (paramInt1 >= paramInt3)
          break label163;
        i3 = 1;
        i4 = 0;
        int i5 = paramInt4 + i2;
        i6 = paramInt2;
        i7 = i1;
        i8 = paramInt1;
        if (i6 == i5)
          break label292;
        if (i == 0)
          break label169;
        i10 = i8;
        if (i == 0)
          break label176;
        i11 = i6;
        if (i4 != 1)
          break label183;
        i12 = 1;
      }
      label163: label169: label176: label183: int i13;
      label195: int i14;
      while (true)
        if (i12 == this.a.a(i10, i11))
        {
          if (i4 == 2)
          {
            return com.google.e.c.a.a.a(i6, i8, paramInt2, paramInt1);
            i = 0;
            break;
            i2 = -1;
            break label57;
            i3 = -1;
            break label65;
            i10 = i6;
            break label101;
            i11 = i8;
            break label110;
            i12 = 0;
            continue;
          }
          i13 = i4 + 1;
          i14 = i7 + n;
          if (i14 > 0)
            if (i8 != paramInt3);
        }
      label292: for (int i9 = i13; ; i9 = i4)
      {
        int i15;
        if (i9 == 2)
        {
          return com.google.e.c.a.a.a(paramInt4 + i2, paramInt3, paramInt2, paramInt1);
          i15 = i8 + i3;
        }
        for (int i16 = i14 - m; ; i16 = i14)
        {
          i6 += i2;
          i4 = i13;
          i7 = i16;
          i8 = i15;
          break;
          return (0.0F / 0.0F);
          i15 = i8;
        }
        i13 = i4;
        break label195;
      }
      label299: int j = paramInt4;
      paramInt4 = paramInt3;
      paramInt3 = j;
      int k = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = k;
    }
  }

  protected final float a(p paramp1, p paramp2, p paramp3)
  {
    return (a(paramp1, paramp2) + a(paramp1, paramp3)) / 2.0F;
  }

  protected final com.google.e.c.g a(f paramf)
    throws com.google.e.j, com.google.e.g
  {
    d locald1 = paramf.b();
    d locald2 = paramf.c();
    d locald3 = paramf.a();
    float f1 = a(locald1, locald2, locald3);
    if (f1 < 1.0F)
      throw com.google.e.j.a();
    int i = a(locald1, locald2, locald3, f1);
    com.google.e.h.a.j localj = com.google.e.h.a.j.a(i);
    int j = -7 + localj.d();
    int k = localj.b().length;
    Object localObject = null;
    int m;
    int n;
    int i1;
    float f5;
    if (k > 0)
    {
      float f2 = locald2.a() - locald1.a() + locald3.a();
      float f3 = locald2.b() - locald1.b() + locald3.b();
      float f4 = 1.0F - 3.0F / j;
      m = (int)(locald1.a() + f4 * (f2 - locald1.a()));
      n = (int)(locald1.b() + f4 * (f3 - locald1.b()));
      i1 = 4;
      localObject = null;
      if (i1 <= 16)
        f5 = i1;
    }
    while (true)
    {
      try
      {
        a locala = a(f1, m, n, f5);
        localObject = locala;
        k localk = a(locald1, locald2, locald3, localObject, i);
        com.google.e.c.b localb = a(this.a, localk, i);
        if (localObject != null)
          break label270;
        arrayOfp = new p[] { locald3, locald1, locald2 };
        return new com.google.e.c.g(localb, arrayOfp);
      }
      catch (com.google.e.j localj1)
      {
        i1 <<= 1;
      }
      break;
      label270: p[] arrayOfp = { locald3, locald1, locald2, localObject };
    }
  }

  public final com.google.e.c.g a(Map<com.google.e.e, ?> paramMap)
    throws com.google.e.j, com.google.e.g
  {
    if (paramMap == null);
    for (q localq = null; ; localq = (q)paramMap.get(com.google.e.e.j))
    {
      this.b = localq;
      return a(new e(this.a, this.b).a(paramMap));
    }
  }

  protected final a a(float paramFloat1, int paramInt1, int paramInt2, float paramFloat2)
    throws com.google.e.j
  {
    int i = (int)(paramFloat2 * paramFloat1);
    int j = Math.max(0, paramInt1 - i);
    int k = Math.min(-1 + this.a.e(), paramInt1 + i);
    if (k - j < paramFloat1 * 3.0F)
      throw com.google.e.j.a();
    int m = Math.max(0, paramInt2 - i);
    int n = Math.min(-1 + this.a.f(), i + paramInt2);
    if (n - m < paramFloat1 * 3.0F)
      throw com.google.e.j.a();
    return new b(this.a, j, m, k - j, n - m, paramFloat1, this.b).a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.h.b.c
 * JD-Core Version:    0.6.2
 */