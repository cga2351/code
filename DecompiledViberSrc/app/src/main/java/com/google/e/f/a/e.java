package com.google.e.f.a;

import com.google.e.j;
import com.google.e.n;
import com.google.e.p;
import com.google.e.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class e extends a
{
  private static final int[] a = { 1, 10, 34, 70, 126 };
  private static final int[] b = { 4, 20, 48, 81 };
  private static final int[] c = { 0, 161, 961, 2015, 2715 };
  private static final int[] d = { 0, 336, 1036, 1516 };
  private static final int[] e = { 8, 6, 4, 3, 1 };
  private static final int[] f = { 2, 4, 6, 8 };
  private static final int[][] g = { { 3, 8, 2, 1 }, { 3, 5, 5, 1 }, { 3, 3, 7, 1 }, { 3, 1, 9, 1 }, { 2, 7, 4, 1 }, { 2, 5, 6, 1 }, { 2, 3, 8, 1 }, { 1, 5, 7, 1 }, { 1, 3, 9, 1 } };
  private final List<d> h = new ArrayList();
  private final List<d> i = new ArrayList();

  private b a(com.google.e.c.a parama, c paramc, boolean paramBoolean)
    throws j
  {
    int[] arrayOfInt1 = c();
    arrayOfInt1[0] = 0;
    arrayOfInt1[1] = 0;
    arrayOfInt1[2] = 0;
    arrayOfInt1[3] = 0;
    arrayOfInt1[4] = 0;
    arrayOfInt1[5] = 0;
    arrayOfInt1[6] = 0;
    arrayOfInt1[7] = 0;
    int n;
    label72: int[] arrayOfInt2;
    int[] arrayOfInt3;
    float[] arrayOfFloat2;
    int i1;
    label111: float f2;
    int i23;
    label147: int i24;
    if (paramBoolean)
    {
      b(parama, paramc.b()[0], arrayOfInt1);
      if (!paramBoolean)
        break label248;
      n = 16;
      float f1 = a(arrayOfInt1) / n;
      arrayOfInt2 = f();
      arrayOfInt3 = g();
      float[] arrayOfFloat1 = d();
      arrayOfFloat2 = e();
      i1 = 0;
      if (i1 >= arrayOfInt1.length)
        break label290;
      f2 = arrayOfInt1[i1] / f1;
      i23 = (int)(0.5F + f2);
      if (i23 >= 1)
        break label255;
      i23 = 1;
      i24 = i1 / 2;
      if ((i1 & 0x1) != 0)
        break label269;
      arrayOfInt2[i24] = i23;
      arrayOfFloat1[i24] = (f2 - i23);
    }
    while (true)
    {
      i1++;
      break label111;
      a(parama, 1 + paramc.b()[1], arrayOfInt1);
      int j = 0;
      for (int k = -1 + arrayOfInt1.length; j < k; k--)
      {
        int m = arrayOfInt1[j];
        arrayOfInt1[j] = arrayOfInt1[k];
        arrayOfInt1[k] = m;
        j++;
      }
      break;
      label248: n = 15;
      break label72;
      label255: if (i23 <= 8)
        break label147;
      i23 = 8;
      break label147;
      label269: arrayOfInt3[i24] = i23;
      arrayOfFloat2[i24] = (f2 - i23);
    }
    label290: a(paramBoolean, n);
    int i2 = -1 + arrayOfInt2.length;
    int i3 = 0;
    int i22;
    for (int i4 = 0; i2 >= 0; i4 = i22)
    {
      int i21 = i3 * 9 + arrayOfInt2[i2];
      i22 = i4 + arrayOfInt2[i2];
      i2--;
      i3 = i21;
    }
    int i5 = 0;
    int i6 = 0;
    for (int i7 = -1 + arrayOfInt3.length; i7 >= 0; i7--)
    {
      i5 = i5 * 9 + arrayOfInt3[i7];
      i6 += arrayOfInt3[i7];
    }
    int i8 = i3 + i5 * 3;
    if (paramBoolean)
    {
      if (((i4 & 0x1) != 0) || (i4 > 12) || (i4 < 4))
        throw j.a();
      int i15 = (12 - i4) / 2;
      int i16 = e[i15];
      int i17 = 9 - i16;
      int i18 = f.a(arrayOfInt2, i16, false);
      int i19 = f.a(arrayOfInt3, i17, true);
      int i20 = a[i15];
      return new b(c[i15] + (i19 + i18 * i20), i8);
    }
    if (((i6 & 0x1) != 0) || (i6 > 10) || (i6 < 4))
      throw j.a();
    int i9 = (10 - i6) / 2;
    int i10 = f[i9];
    int i11 = 9 - i10;
    int i12 = f.a(arrayOfInt2, i10, true);
    int i13 = f.a(arrayOfInt3, i11, false);
    int i14 = b[i9];
    return new b(d[i9] + (i12 + i13 * i14), i8);
  }

  private c a(com.google.e.c.a parama, int paramInt, boolean paramBoolean, int[] paramArrayOfInt)
    throws j
  {
    boolean bool = parama.a(paramArrayOfInt[0]);
    for (int j = -1 + paramArrayOfInt[0]; (j >= 0) && ((bool ^ parama.a(j))); j--);
    int k = j + 1;
    int m = paramArrayOfInt[0] - k;
    int[] arrayOfInt1 = b();
    System.arraycopy(arrayOfInt1, 0, arrayOfInt1, 1, -1 + arrayOfInt1.length);
    arrayOfInt1[0] = m;
    int n = a(arrayOfInt1, g);
    int i1 = paramArrayOfInt[1];
    int i2;
    if (paramBoolean)
    {
      i2 = -1 + parama.a() - k;
      i1 = -1 + parama.a() - i1;
    }
    while (true)
    {
      int[] arrayOfInt2 = new int[2];
      arrayOfInt2[0] = k;
      arrayOfInt2[1] = paramArrayOfInt[1];
      return new c(n, arrayOfInt2, i2, i1, paramInt);
      i2 = k;
    }
  }

  private d a(com.google.e.c.a parama, boolean paramBoolean, int paramInt, Map<com.google.e.e, ?> paramMap)
  {
    try
    {
      int[] arrayOfInt = a(parama, 0, paramBoolean);
      c localc = a(parama, paramInt, paramBoolean, arrayOfInt);
      if (paramMap == null);
      q localq;
      for (Object localObject = null; ; localObject = localq)
      {
        if (localObject != null)
        {
          float f1 = (arrayOfInt[0] + arrayOfInt[1]) / 2.0F;
          if (paramBoolean)
            f1 = -1 + parama.a() - f1;
          localObject.a(new p(f1, paramInt));
        }
        b localb1 = a(parama, localc, true);
        b localb2 = a(parama, localc, false);
        return new d(1597 * localb1.a() + localb2.a(), localb1.b() + 4 * localb2.b(), localc);
        localq = (q)paramMap.get(com.google.e.e.j);
      }
    }
    catch (j localj)
    {
    }
    return null;
  }

  private static n a(d paramd1, d paramd2)
  {
    String str1 = String.valueOf(4537077L * paramd1.a() + paramd2.a());
    StringBuilder localStringBuilder = new StringBuilder(14);
    for (int j = 13 - str1.length(); j > 0; j--)
      localStringBuilder.append('0');
    localStringBuilder.append(str1);
    int k = 0;
    int m = 0;
    while (k < 13)
    {
      int i1 = '￐' + localStringBuilder.charAt(k);
      if ((k & 0x1) == 0)
        i1 *= 3;
      m += i1;
      k++;
    }
    int n = 10 - m % 10;
    if (n == 10)
      n = 0;
    localStringBuilder.append(n);
    p[] arrayOfp1 = paramd1.c().c();
    p[] arrayOfp2 = paramd2.c().c();
    String str2 = String.valueOf(localStringBuilder.toString());
    p[] arrayOfp3 = new p[4];
    arrayOfp3[0] = arrayOfp1[0];
    arrayOfp3[1] = arrayOfp1[1];
    arrayOfp3[2] = arrayOfp2[0];
    arrayOfp3[3] = arrayOfp2[1];
    return new n(str2, null, arrayOfp3, com.google.e.a.m);
  }

  private static void a(Collection<d> paramCollection, d paramd)
  {
    if (paramd == null);
    while (true)
    {
      return;
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if (locald.a() == paramd.a())
          locald.e();
      }
      for (int j = 1; j == 0; j = 0)
      {
        paramCollection.add(paramd);
        return;
      }
    }
  }

  private void a(boolean paramBoolean, int paramInt)
    throws j
  {
    int j = 1;
    int k = a(f());
    int m = a(g());
    int n = k + m - paramInt;
    int i1 = k & 0x1;
    int i2;
    int i3;
    label52: int i4;
    label63: int i5;
    int i6;
    if (paramBoolean)
    {
      i2 = j;
      if (i1 != i2)
        break label119;
      i3 = j;
      if ((m & 0x1) != j)
        break label125;
      i4 = j;
      if (!paramBoolean)
        break label161;
      if (k <= 12)
        break label131;
      i5 = j;
      i6 = 0;
    }
    while (true)
    {
      label80: int i8;
      int i7;
      if (m > 12)
      {
        i8 = 0;
        i7 = j;
      }
      while (true)
        if (n == j)
          if (i3 != 0)
            if (i4 != 0)
            {
              throw j.a();
              i2 = 0;
              break;
              label119: i3 = 0;
              break label52;
              label125: i4 = 0;
              break label63;
              label131: if (k >= 4)
                break label500;
              i6 = j;
              i5 = 0;
              break label80;
              if (m >= 4)
                break label482;
              i8 = j;
              i7 = 0;
              continue;
              label161: if (k > 11)
              {
                i5 = j;
                i6 = 0;
              }
            }
      while (true)
      {
        if (m > 10)
        {
          i7 = j;
          i8 = 0;
          break;
          if (k >= 5)
            break label491;
          i6 = j;
          i5 = 0;
          continue;
        }
        if (m < 4)
        {
          i8 = j;
          i7 = 0;
          break;
          int i10 = i6;
          int i13 = j;
          j = i8;
          int i9 = i13;
          while (true)
            if (i10 != 0)
            {
              if (i9 != 0)
              {
                throw j.a();
                if (i4 == 0)
                  throw j.a();
                i7 = j;
                j = i8;
                i9 = i5;
                i10 = i6;
                continue;
                if (n == -1)
                {
                  if (i3 != 0)
                  {
                    if (i4 != 0)
                      throw j.a();
                    int i12 = i8;
                    i9 = i5;
                    i10 = j;
                    j = i12;
                  }
                  else
                  {
                    if (i4 == 0)
                      throw j.a();
                    i9 = i5;
                    i10 = i6;
                  }
                }
                else if (n == 0)
                {
                  if (i3 != 0)
                  {
                    if (i4 == 0)
                      throw j.a();
                    if (k < m)
                    {
                      i7 = j;
                      int i11 = i8;
                      i9 = i5;
                      i10 = j;
                      j = i11;
                    }
                    else
                    {
                      i9 = j;
                      i10 = i6;
                    }
                  }
                  else if (i4 != 0)
                  {
                    throw j.a();
                  }
                }
                else
                  throw j.a();
              }
              else
              {
                a(f(), d());
              }
            }
            else
            {
              if (i9 != 0)
                b(f(), d());
              if (j != 0)
              {
                if (i7 != 0)
                  throw j.a();
                a(g(), d());
              }
              if (i7 != 0)
                b(g(), e());
              return;
              j = i8;
              i9 = i5;
              i10 = i6;
            }
        }
        label482: i7 = 0;
        i8 = 0;
        break;
        label491: i5 = 0;
        i6 = 0;
      }
      label500: i5 = 0;
      i6 = 0;
    }
  }

  private int[] a(com.google.e.c.a parama, int paramInt, boolean paramBoolean)
    throws j
  {
    int[] arrayOfInt = b();
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int j = parama.a();
    boolean bool1 = false;
    int k = paramInt;
    label57: int m;
    boolean bool2;
    int n;
    int i1;
    if (k < j)
    {
      if (!parama.a(k))
      {
        bool1 = true;
        if (paramBoolean != bool1)
          break label121;
      }
    }
    else
    {
      m = k;
      bool2 = bool1;
      n = k;
      i1 = 0;
      label78: if (m >= j)
        break label227;
      if (!(bool2 ^ parama.a(m)))
        break label127;
      arrayOfInt[i1] = (1 + arrayOfInt[i1]);
    }
    while (true)
    {
      m++;
      break label78;
      bool1 = false;
      break label57;
      label121: k++;
      break;
      label127: if (i1 == 3)
      {
        if (b(arrayOfInt))
          return new int[] { n, m };
        n += arrayOfInt[0] + arrayOfInt[1];
        arrayOfInt[0] = arrayOfInt[2];
        arrayOfInt[1] = arrayOfInt[3];
        arrayOfInt[2] = 0;
        arrayOfInt[3] = 0;
        i1--;
      }
      while (true)
      {
        arrayOfInt[i1] = 1;
        if (bool2)
          break label221;
        bool2 = true;
        break;
        i1++;
      }
      label221: bool2 = false;
    }
    label227: throw j.a();
  }

  private static boolean b(d paramd1, d paramd2)
  {
    int j = (paramd1.b() + 16 * paramd2.b()) % 79;
    int k = 9 * paramd1.c().a() + paramd2.c().a();
    if (k > 72)
      k--;
    if (k > 8)
      k--;
    return j == k;
  }

  public n a(int paramInt, com.google.e.c.a parama, Map<com.google.e.e, ?> paramMap)
    throws j
  {
    d locald1 = a(parama, false, paramInt, paramMap);
    a(this.h, locald1);
    parama.e();
    d locald2 = a(parama, true, paramInt, paramMap);
    a(this.i, locald2);
    parama.e();
    int j = this.h.size();
    for (int k = 0; k < j; k++)
    {
      d locald3 = (d)this.h.get(k);
      if (locald3.d() > 1)
      {
        int m = this.i.size();
        for (int n = 0; n < m; n++)
        {
          d locald4 = (d)this.i.get(n);
          if ((locald4.d() > 1) && (b(locald3, locald4)))
            return a(locald3, locald4);
        }
      }
    }
    throw j.a();
  }

  public void a()
  {
    this.h.clear();
    this.i.clear();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.a.e
 * JD-Core Version:    0.6.2
 */