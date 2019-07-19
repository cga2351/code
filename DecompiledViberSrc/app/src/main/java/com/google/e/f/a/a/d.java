package com.google.e.f.a.a;

import com.google.e.e;
import com.google.e.f.a.f;
import com.google.e.g;
import com.google.e.n;
import com.google.e.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class d extends com.google.e.f.a.a
{
  private static final int[] a = { 7, 5, 4, 3, 1 };
  private static final int[] b = { 4, 20, 52, 104, 204 };
  private static final int[] c = { 0, 348, 1388, 2948, 3988 };
  private static final int[][] d = { { 1, 8, 4, 1 }, { 3, 6, 4, 1 }, { 3, 4, 6, 1 }, { 3, 2, 8, 1 }, { 2, 6, 5, 1 }, { 2, 2, 9, 1 } };
  private static final int[][] e = { { 1, 3, 9, 27, 81, 32, 96, 77 }, { 20, 60, 180, 118, 143, 7, 21, 63 }, { 189, 145, 13, 39, 117, 140, 209, 205 }, { 193, 157, 49, 147, 19, 57, 171, 91 }, { 62, 186, 136, 197, 169, 85, 44, 132 }, { 185, 133, 188, 142, 4, 12, 36, 108 }, { 113, 128, 173, 97, 80, 29, 87, 50 }, { 150, 28, 84, 41, 123, 158, 52, 156 }, { 46, 138, 203, 187, 139, 206, 196, 166 }, { 76, 17, 51, 153, 37, 111, 122, 155 }, { 43, 129, 176, 106, 107, 110, 119, 146 }, { 16, 48, 144, 10, 30, 90, 59, 177 }, { 109, 116, 137, 200, 178, 112, 125, 164 }, { 70, 210, 208, 202, 184, 130, 179, 115 }, { 134, 191, 151, 31, 93, 68, 204, 190 }, { 148, 22, 66, 198, 172, 94, 71, 2 }, { 6, 18, 54, 162, 64, 192, 154, 40 }, { 120, 149, 25, 75, 14, 42, 126, 167 }, { 79, 26, 78, 23, 69, 207, 199, 175 }, { 103, 98, 83, 38, 114, 131, 182, 124 }, { 161, 61, 183, 127, 170, 88, 53, 159 }, { 55, 165, 73, 8, 24, 72, 5, 15 }, { 45, 135, 194, 160, 58, 174, 100, 89 } };
  private static final int[][] f = { { 0, 0 }, { 0, 1, 1 }, { 0, 2, 1, 3 }, { 0, 4, 1, 3, 2 }, { 0, 4, 1, 3, 3, 5 }, { 0, 4, 1, 3, 4, 5, 5 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 4, 4 }, { 0, 0, 1, 1, 2, 2, 3, 4, 5, 5 }, { 0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5 } };
  private final List<b> g = new ArrayList(11);
  private final List<c> h = new ArrayList();
  private final int[] i = new int[2];
  private boolean j;

  private static int a(com.google.e.c.a parama, int paramInt)
  {
    if (parama.a(paramInt))
      return parama.c(parama.d(paramInt));
    return parama.d(parama.c(paramInt));
  }

  private com.google.e.f.a.c a(com.google.e.c.a parama, int paramInt, boolean paramBoolean)
  {
    int k;
    int n;
    int m;
    if (paramBoolean)
    {
      for (int i2 = -1 + this.i[0]; (i2 >= 0) && (!parama.a(i2)); i2--);
      k = i2 + 1;
      n = this.i[0] - k;
      m = this.i[1];
    }
    while (true)
    {
      int[] arrayOfInt = b();
      System.arraycopy(arrayOfInt, 0, arrayOfInt, 1, -1 + arrayOfInt.length);
      arrayOfInt[0] = n;
      try
      {
        int i1 = a(arrayOfInt, d);
        return new com.google.e.f.a.c(i1, new int[] { k, m }, k, m, paramInt);
        k = this.i[0];
        m = parama.d(1 + this.i[1]);
        n = m - this.i[1];
      }
      catch (com.google.e.j localj)
      {
      }
    }
    return null;
  }

  static n a(List<b> paramList)
    throws com.google.e.j, g
  {
    String str = com.google.e.f.a.a.a.j.a(a.a(paramList)).a();
    p[] arrayOfp1 = ((b)paramList.get(0)).c().c();
    p[] arrayOfp2 = ((b)paramList.get(-1 + paramList.size())).c().c();
    p[] arrayOfp3 = new p[4];
    arrayOfp3[0] = arrayOfp1[0];
    arrayOfp3[1] = arrayOfp1[1];
    arrayOfp3[2] = arrayOfp2[0];
    arrayOfp3[3] = arrayOfp2[1];
    return new n(str, null, arrayOfp3, com.google.e.a.n);
  }

  private List<b> a(List<c> paramList, int paramInt)
    throws com.google.e.j
  {
    c localc;
    if (paramInt < this.h.size())
    {
      localc = (c)this.h.get(paramInt);
      this.g.clear();
      int k = paramList.size();
      for (int m = 0; m < k; m++)
        this.g.addAll(((c)paramList.get(m)).a());
      this.g.addAll(localc.a());
      if (b(this.g));
    }
    while (true)
    {
      paramInt++;
      break;
      if (h())
        return this.g;
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(paramList);
      localArrayList.add(localc);
      int n = paramInt + 1;
      try
      {
        List localList = a(localArrayList, n);
        return localList;
        throw com.google.e.j.a();
      }
      catch (com.google.e.j localj)
      {
      }
    }
  }

  private List<b> a(boolean paramBoolean)
  {
    Object localObject = null;
    if (this.h.size() > 25)
      this.h.clear();
    while (true)
    {
      return localObject;
      this.g.clear();
      if (paramBoolean)
        Collections.reverse(this.h);
      try
      {
        List localList = a(new ArrayList(), 0);
        localObject = localList;
        if (!paramBoolean)
          continue;
        Collections.reverse(this.h);
        return localObject;
      }
      catch (com.google.e.j localj)
      {
        while (true)
          localObject = null;
      }
    }
  }

  private void a(int paramInt)
    throws com.google.e.j
  {
    int k = 1;
    int m = a(f());
    int n = a(g());
    int i1 = m + n - paramInt;
    int i2;
    int i3;
    label47: int i4;
    int i5;
    if ((m & 0x1) == k)
    {
      i2 = k;
      if ((n & 0x1) != 0)
        break label98;
      i3 = k;
      if (m <= 13)
        break label104;
      i4 = k;
      i5 = 0;
    }
    while (true)
    {
      label59: int i7;
      int i6;
      if (n > 13)
      {
        i7 = 0;
        i6 = k;
      }
      while (true)
      {
        label98: label104: int i9;
        int i8;
        if (i1 == k)
          if (i2 != 0)
          {
            if (i3 != 0)
            {
              throw com.google.e.j.a();
              i2 = 0;
              break;
              i3 = 0;
              break label47;
              if (m >= 4)
                break label403;
              i5 = k;
              i4 = 0;
              break label59;
              if (n >= 4)
                break label394;
              i7 = k;
              i6 = 0;
              continue;
            }
            i9 = i5;
            int i12 = k;
            k = i7;
            i8 = i12;
          }
        while (true)
          if (i9 != 0)
          {
            if (i8 != 0)
            {
              throw com.google.e.j.a();
              if (i3 == 0)
                throw com.google.e.j.a();
              i6 = k;
              k = i7;
              i8 = i4;
              i9 = i5;
              continue;
              if (i1 == -1)
              {
                if (i2 != 0)
                {
                  if (i3 != 0)
                    throw com.google.e.j.a();
                  int i11 = i7;
                  i8 = i4;
                  i9 = k;
                  k = i11;
                }
                else
                {
                  if (i3 == 0)
                    throw com.google.e.j.a();
                  i8 = i4;
                  i9 = i5;
                }
              }
              else if (i1 == 0)
              {
                if (i2 != 0)
                {
                  if (i3 == 0)
                    throw com.google.e.j.a();
                  if (m < n)
                  {
                    i6 = k;
                    int i10 = i7;
                    i8 = i4;
                    i9 = k;
                    k = i10;
                  }
                  else
                  {
                    i8 = k;
                    i9 = i5;
                  }
                }
                else if (i3 != 0)
                {
                  throw com.google.e.j.a();
                }
              }
              else
                throw com.google.e.j.a();
            }
            else
            {
              a(f(), d());
            }
          }
          else
          {
            if (i8 != 0)
              b(f(), d());
            if (k != 0)
            {
              if (i6 != 0)
                throw com.google.e.j.a();
              a(g(), d());
            }
            if (i6 != 0)
              b(g(), e());
            return;
            k = i7;
            i8 = i4;
            i9 = i5;
          }
        label394: i6 = 0;
        i7 = 0;
      }
      label403: i4 = 0;
      i5 = 0;
    }
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    int k = 0;
    int m = 0;
    int n = this.h.size();
    boolean bool1 = false;
    c localc;
    if (m < n)
    {
      localc = (c)this.h.get(m);
      if (localc.b() > paramInt)
        bool1 = localc.a(this.g);
    }
    else
    {
      if ((!bool1) && (k == 0))
        break label92;
    }
    label92: 
    while (a(this.g, this.h))
    {
      return;
      boolean bool2 = localc.a(this.g);
      m++;
      k = bool2;
      break;
    }
    this.h.add(m, new c(this.g, paramInt, paramBoolean));
    a(this.g, this.h);
  }

  private static void a(List<b> paramList, List<c> paramList1)
  {
    Iterator localIterator1 = paramList1.iterator();
    label143: label149: 
    while (true)
    {
      label55: int m;
      if (localIterator1.hasNext())
      {
        c localc = (c)localIterator1.next();
        if (localc.a().size() != paramList.size())
        {
          Iterator localIterator2 = localc.a().iterator();
          if (localIterator2.hasNext())
          {
            b localb = (b)localIterator2.next();
            Iterator localIterator3 = paramList.iterator();
            while (localIterator3.hasNext())
              if (localb.equals((b)localIterator3.next()))
              {
                m = 1;
                label116: if (m != 0)
                  break label143;
              }
          }
        }
      }
      else
      {
        for (int k = 0; ; k = 1)
        {
          if (k == 0)
            break label149;
          localIterator1.remove();
          break;
          return;
          m = 0;
          break label116;
          break label55;
        }
      }
    }
  }

  private static boolean a(com.google.e.f.a.c paramc, boolean paramBoolean1, boolean paramBoolean2)
  {
    return (paramc.a() != 0) || (!paramBoolean1) || (!paramBoolean2);
  }

  private static boolean a(Iterable<b> paramIterable, Iterable<c> paramIterable1)
  {
    Iterator localIterator1 = paramIterable1.iterator();
    label98: label119: label121: label125: 
    while (true)
    {
      int m;
      if (localIterator1.hasNext())
      {
        c localc = (c)localIterator1.next();
        Iterator localIterator2 = paramIterable.iterator();
        if (!localIterator2.hasNext())
          break label121;
        b localb = (b)localIterator2.next();
        Iterator localIterator3 = localc.a().iterator();
        while (localIterator3.hasNext())
          if (localb.equals((b)localIterator3.next()))
          {
            m = 1;
            if (m != 0)
              break label119;
          }
      }
      for (int k = 0; ; k = 1)
      {
        if (k == 0)
          break label125;
        return true;
        return false;
        m = 0;
        break label98;
        break;
      }
    }
  }

  private void b(com.google.e.c.a parama, List<b> paramList, int paramInt)
    throws com.google.e.j
  {
    int[] arrayOfInt = b();
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int k = parama.a();
    int m;
    label50: label65: int n;
    int i1;
    label71: label90: int i2;
    int i4;
    int i5;
    int i6;
    if (paramInt >= 0)
    {
      if (paramList.size() % 2 == 0)
        break label194;
      m = 1;
      if (this.j)
      {
        if (m != 0)
          break label200;
        m = 1;
      }
      n = 0;
      i1 = paramInt;
      if (i1 < k)
      {
        if (parama.a(i1))
          break label206;
        n = 1;
        if (n != 0)
          break label212;
      }
      i2 = i1;
      int i3 = i1;
      i4 = 0;
      i5 = n;
      i6 = i3;
      label114: if (i2 >= k)
        break label341;
      if ((i5 ^ parama.a(i2)) == 0)
        break label218;
      arrayOfInt[i4] = (1 + arrayOfInt[i4]);
    }
    while (true)
    {
      i2++;
      break label114;
      if (paramList.isEmpty())
      {
        paramInt = 0;
        break;
      }
      paramInt = ((b)paramList.get(-1 + paramList.size())).c().b()[1];
      break;
      label194: m = 0;
      break label50;
      label200: m = 0;
      break label65;
      label206: n = 0;
      break label90;
      label212: i1++;
      break label71;
      label218: if (i4 == 3)
      {
        if (m != 0)
          c(arrayOfInt);
        if (b(arrayOfInt))
        {
          this.i[0] = i6;
          this.i[1] = i2;
          return;
        }
        if (m != 0)
          c(arrayOfInt);
        i6 += arrayOfInt[0] + arrayOfInt[1];
        arrayOfInt[0] = arrayOfInt[2];
        arrayOfInt[1] = arrayOfInt[3];
        arrayOfInt[2] = 0;
        arrayOfInt[3] = 0;
        i4--;
      }
      while (true)
      {
        arrayOfInt[i4] = 1;
        if (i5 != 0)
          break label335;
        i5 = 1;
        break;
        i4++;
      }
      label335: i5 = 0;
    }
    label341: throw com.google.e.j.a();
  }

  private static boolean b(List<b> paramList)
  {
    int[][] arrayOfInt = f;
    int k = arrayOfInt.length;
    int m = 0;
    boolean bool = false;
    int[] arrayOfInt1;
    if (m < k)
    {
      arrayOfInt1 = arrayOfInt[m];
      if (paramList.size() <= arrayOfInt1.length);
    }
    label103: 
    while (true)
    {
      m++;
      break;
      int n = 0;
      if (n < paramList.size())
        if (((b)paramList.get(n)).c().a() == arrayOfInt1[n]);
      for (int i1 = 0; ; i1 = 1)
      {
        if (i1 == 0)
          break label103;
        bool = true;
        return bool;
        n++;
        break;
      }
    }
  }

  private static void c(int[] paramArrayOfInt)
  {
    int k = paramArrayOfInt.length;
    for (int m = 0; m < k / 2; m++)
    {
      int n = paramArrayOfInt[m];
      paramArrayOfInt[m] = paramArrayOfInt[(-1 + (k - m))];
      paramArrayOfInt[(-1 + (k - m))] = n;
    }
  }

  private boolean h()
  {
    int k = 1;
    b localb1 = (b)this.g.get(0);
    com.google.e.f.a.b localb2 = localb1.a();
    com.google.e.f.a.b localb3 = localb1.b();
    if (localb3 == null)
      return false;
    int m = localb3.b();
    int n = 2;
    int i1 = m;
    for (int i2 = k; i2 < this.g.size(); i2++)
    {
      b localb4 = (b)this.g.get(i2);
      i1 += localb4.a().b();
      n++;
      com.google.e.f.a.b localb5 = localb4.b();
      if (localb5 != null)
      {
        i1 += localb5.b();
        n++;
      }
    }
    if (i1 % 211 + 211 * (n - 4) == localb2.a());
    while (true)
    {
      return k;
      k = 0;
    }
  }

  b a(com.google.e.c.a parama, List<b> paramList, int paramInt)
    throws com.google.e.j
  {
    boolean bool1;
    boolean bool3;
    if (paramList.size() % 2 == 0)
    {
      bool1 = true;
      if (!this.j)
        break label184;
      if (bool1)
        break label133;
      bool3 = true;
    }
    label29: label184: for (boolean bool2 = bool3; ; bool2 = bool1)
    {
      int k = -1;
      int m = 1;
      com.google.e.f.a.c localc;
      com.google.e.f.a.b localb1;
      while (true)
      {
        b(parama, paramList, k);
        localc = a(parama, paramInt, bool2);
        if (localc == null)
          k = a(parama, this.i[0]);
        while (true)
        {
          if (m != 0)
            break label143;
          localb1 = a(parama, localc, bool2, true);
          if ((paramList.isEmpty()) || (!((b)paramList.get(-1 + paramList.size())).d()))
            break label145;
          throw com.google.e.j.a();
          bool1 = false;
          break;
          bool3 = false;
          break label29;
          m = 0;
        }
      }
      try
      {
        com.google.e.f.a.b localb3 = a(parama, localc, bool2, false);
        localb2 = localb3;
        return new b(localb1, localb2, localc, true);
      }
      catch (com.google.e.j localj)
      {
        while (true)
          com.google.e.f.a.b localb2 = null;
      }
    }
  }

  com.google.e.f.a.b a(com.google.e.c.a parama, com.google.e.f.a.c paramc, boolean paramBoolean1, boolean paramBoolean2)
    throws com.google.e.j
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
    if (paramBoolean2)
      b(parama, paramc.b()[0], arrayOfInt1);
    float f1;
    while (true)
    {
      f1 = a(arrayOfInt1) / 17;
      float f2 = (paramc.b()[1] - paramc.b()[0]) / 15.0F;
      if (Math.abs(f1 - f2) / f2 <= 0.3F)
        break;
      throw com.google.e.j.a();
      a(parama, paramc.b()[1], arrayOfInt1);
      int k = 0;
      for (int m = -1 + arrayOfInt1.length; k < m; m--)
      {
        int n = arrayOfInt1[k];
        arrayOfInt1[k] = arrayOfInt1[m];
        arrayOfInt1[m] = n;
        k++;
      }
    }
    int[] arrayOfInt2 = f();
    int[] arrayOfInt3 = g();
    float[] arrayOfFloat1 = d();
    float[] arrayOfFloat2 = e();
    int i1 = 0;
    if (i1 < arrayOfInt1.length)
    {
      float f3 = 1.0F * arrayOfInt1[i1] / f1;
      int i22 = (int)(0.5F + f3);
      label260: int i23;
      if (i22 < 1)
      {
        if (f3 < 0.3F)
          throw com.google.e.j.a();
        i22 = 1;
        i23 = i1 / 2;
        if ((i1 & 0x1) != 0)
          break label324;
        arrayOfInt2[i23] = i22;
        arrayOfFloat1[i23] = (f3 - i22);
      }
      while (true)
      {
        i1++;
        break;
        if (i22 <= 8)
          break label260;
        if (f3 > 8.7F)
          throw com.google.e.j.a();
        i22 = 8;
        break label260;
        label324: arrayOfInt3[i23] = i22;
        arrayOfFloat2[i23] = (f3 - i22);
      }
    }
    a(17);
    int i2 = 4 * paramc.a();
    int i3;
    int i4;
    if (paramBoolean1)
    {
      i3 = 0;
      i4 = i2 + i3;
      if (!paramBoolean2)
        break label470;
    }
    int i6;
    int i8;
    int i10;
    label470: for (int i5 = 0; ; i5 = 1)
    {
      i6 = -1 + (i5 + i4);
      int i7 = -1 + arrayOfInt2.length;
      i8 = 0;
      int i9 = i7;
      i10 = 0;
      while (i9 >= 0)
      {
        if (a(paramc, paramBoolean1, paramBoolean2))
          i10 += e[i6][(i9 * 2)] * arrayOfInt2[i9];
        int i21 = i8 + arrayOfInt2[i9];
        i9--;
        i8 = i21;
      }
      i3 = 2;
      break;
    }
    int i11 = -1 + arrayOfInt3.length;
    int i12 = 0;
    for (int i13 = i11; i13 >= 0; i13--)
      if (a(paramc, paramBoolean1, paramBoolean2))
        i12 += e[i6][(1 + i13 * 2)] * arrayOfInt3[i13];
    int i14 = i10 + i12;
    if (((i8 & 0x1) != 0) || (i8 > 13) || (i8 < 4))
      throw com.google.e.j.a();
    int i15 = (13 - i8) / 2;
    int i16 = a[i15];
    int i17 = 9 - i16;
    int i18 = f.a(arrayOfInt2, i16, true);
    int i19 = f.a(arrayOfInt3, i17, false);
    int i20 = b[i15];
    return new com.google.e.f.a.b(c[i15] + (i19 + i18 * i20), i14);
  }

  public n a(int paramInt, com.google.e.c.a parama, Map<e, ?> paramMap)
    throws com.google.e.j, g
  {
    this.g.clear();
    this.j = false;
    try
    {
      n localn = a(a(paramInt, parama));
      return localn;
    }
    catch (com.google.e.j localj)
    {
      this.g.clear();
      this.j = true;
    }
    return a(a(paramInt, parama));
  }

  List<b> a(int paramInt, com.google.e.c.a parama)
    throws com.google.e.j
  {
    try
    {
      while (true)
      {
        b localb = a(parama, this.g, paramInt);
        this.g.add(localb);
      }
    }
    catch (com.google.e.j localj)
    {
      if (this.g.isEmpty())
        throw localj;
      if (!h())
        break label58;
    }
    List localList = this.g;
    return localList;
    label58: if (!this.h.isEmpty());
    for (int k = 1; ; k = 0)
    {
      a(paramInt, false);
      if (k != 0)
      {
        localList = a(false);
        if (localList != null)
          break;
        localList = a(true);
        if (localList != null)
          break;
      }
      throw com.google.e.j.a();
    }
  }

  public void a()
  {
    this.g.clear();
    this.h.clear();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.a.a.d
 * JD-Core Version:    0.6.2
 */