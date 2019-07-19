package com.google.e.c.a;

import com.google.e.j;
import com.google.e.p;

public final class b
{
  private final com.google.e.c.b a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;

  public b(com.google.e.c.b paramb)
    throws j
  {
    this(paramb, 10, paramb.e() / 2, paramb.f() / 2);
  }

  public b(com.google.e.c.b paramb, int paramInt1, int paramInt2, int paramInt3)
    throws j
  {
    this.a = paramb;
    this.b = paramb.f();
    this.c = paramb.e();
    int i = paramInt1 / 2;
    this.d = (paramInt2 - i);
    this.e = (paramInt2 + i);
    this.g = (paramInt3 - i);
    this.f = (i + paramInt3);
    if ((this.g < 0) || (this.d < 0) || (this.f >= this.b) || (this.e >= this.c))
      throw j.a();
  }

  private p a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i = a.a(a.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4));
    float f1 = (paramFloat3 - paramFloat1) / i;
    float f2 = (paramFloat4 - paramFloat2) / i;
    for (int j = 0; j < i; j++)
    {
      int k = a.a(paramFloat1 + f1 * j);
      int m = a.a(paramFloat2 + f2 * j);
      if (this.a.a(k, m))
        return new p(k, m);
    }
    return null;
  }

  private boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramBoolean)
      while (paramInt1 <= paramInt2)
      {
        if (this.a.a(paramInt1, paramInt3))
          return true;
        paramInt1++;
      }
    do
    {
      paramInt1++;
      if (paramInt1 > paramInt2)
        break;
    }
    while (!this.a.a(paramInt3, paramInt1));
    return true;
    return false;
  }

  private p[] a(p paramp1, p paramp2, p paramp3, p paramp4)
  {
    float f1 = paramp1.a();
    float f2 = paramp1.b();
    float f3 = paramp2.a();
    float f4 = paramp2.b();
    float f5 = paramp3.a();
    float f6 = paramp3.b();
    float f7 = paramp4.a();
    float f8 = paramp4.b();
    if (f1 < this.c / 2.0F)
    {
      p[] arrayOfp2 = new p[4];
      arrayOfp2[0] = new p(f7 - 1.0F, f8 + 1.0F);
      arrayOfp2[1] = new p(f3 + 1.0F, f4 + 1.0F);
      arrayOfp2[2] = new p(f5 - 1.0F, f6 - 1.0F);
      arrayOfp2[3] = new p(f1 + 1.0F, f2 - 1.0F);
      return arrayOfp2;
    }
    p[] arrayOfp1 = new p[4];
    arrayOfp1[0] = new p(f7 + 1.0F, f8 + 1.0F);
    arrayOfp1[1] = new p(f3 + 1.0F, f4 - 1.0F);
    arrayOfp1[2] = new p(f5 - 1.0F, f6 + 1.0F);
    arrayOfp1[3] = new p(f1 - 1.0F, f2 - 1.0F);
    return arrayOfp1;
  }

  public p[] a()
    throws j
  {
    int i = 1;
    int j = this.d;
    int k = this.e;
    int m = this.g;
    int n = this.f;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    boolean bool1 = i;
    int i14;
    boolean bool4;
    boolean bool2;
    int i6;
    int i7;
    int i8;
    int i9;
    if (bool1)
    {
      boolean bool3 = i;
      i14 = i4;
      bool4 = false;
      while (((bool3) || (i14 == 0)) && (k < this.c))
      {
        bool3 = a(m, n, k, false);
        if (bool3)
        {
          k++;
          i14 = i;
          bool4 = i;
        }
        else if (i14 == 0)
        {
          k++;
        }
      }
      if (k >= this.c)
      {
        bool2 = i;
        i6 = k;
        i7 = n;
        i8 = j;
        i9 = m;
      }
    }
    while (true)
    {
      label140: int i10;
      int i11;
      p localp1;
      if ((!bool2) && (i5 != 0))
      {
        i10 = i6 - i8;
        i11 = i;
        localp1 = null;
        label163: if (i11 >= i10)
          break label734;
        localp1 = a(i8, i7 - i11, i8 + i11, i7);
        if (localp1 == null);
      }
      label734: for (p localp2 = localp1; ; localp2 = localp1)
      {
        if (localp2 == null)
        {
          throw j.a();
          int i15 = i3;
          boolean bool5 = bool4;
          int i16 = i;
          while (((i16 != 0) || (i15 == 0)) && (n < this.b))
          {
            boolean bool6 = a(j, k, n, i);
            if (bool6)
            {
              n++;
              i15 = i;
              bool5 = i;
            }
            else if (i15 == 0)
            {
              n++;
            }
          }
          if (n >= this.b)
          {
            bool2 = i;
            i6 = k;
            i7 = n;
            i8 = j;
            i9 = m;
            break label140;
          }
          int i17 = i2;
          boolean bool7 = bool5;
          int i18 = i;
          while (((i18 != 0) || (i17 == 0)) && (j >= 0))
          {
            boolean bool8 = a(m, n, j, false);
            if (bool8)
            {
              j--;
              i17 = i;
              bool7 = i;
            }
            else if (i17 == 0)
            {
              j--;
            }
          }
          if (j < 0)
          {
            bool2 = i;
            i6 = k;
            i7 = n;
            i8 = j;
            i9 = m;
            break label140;
          }
          boolean bool9 = bool7;
          int i19 = i1;
          int i20 = i;
          while (((i20 != 0) || (i19 == 0)) && (m >= 0))
          {
            boolean bool10 = a(j, k, m, i);
            if (bool10)
            {
              m--;
              i19 = i;
              bool9 = i;
            }
            else if (i19 == 0)
            {
              m--;
            }
          }
          if (m < 0)
          {
            bool2 = i;
            i6 = k;
            i7 = n;
            i8 = j;
            i9 = m;
            break label140;
          }
          if (bool9)
            i5 = i;
          i1 = i19;
          i2 = i17;
          i4 = i14;
          int i21 = i15;
          bool1 = bool9;
          i3 = i21;
          break;
          i11++;
          break label163;
        }
        int i12 = i;
        p localp3 = null;
        if (i12 < i10)
        {
          localp3 = a(i8, i9 + i12, i8 + i12, i9);
          if (localp3 == null);
        }
        for (p localp4 = localp3; ; localp4 = localp3)
        {
          if (localp4 == null)
          {
            throw j.a();
            i12++;
            break;
          }
          int i13 = i;
          p localp5 = null;
          if (i13 < i10)
          {
            localp5 = a(i6, i9 + i13, i6 - i13, i9);
            if (localp5 == null);
          }
          for (p localp6 = localp5; ; localp6 = localp5)
          {
            if (localp6 == null)
            {
              throw j.a();
              i13++;
              break;
            }
            p localp7 = null;
            while (true)
            {
              if (i < i10)
              {
                localp7 = a(i6, i7 - i, i6 - i, i7);
                if (localp7 == null);
              }
              else
              {
                if (localp7 != null)
                  break;
                throw j.a();
              }
              i++;
            }
            return a(localp7, localp2, localp6, localp4);
            throw j.a();
          }
        }
      }
      i6 = k;
      i7 = n;
      i8 = j;
      i9 = m;
      bool2 = false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.c.a.b
 * JD-Core Version:    0.6.2
 */