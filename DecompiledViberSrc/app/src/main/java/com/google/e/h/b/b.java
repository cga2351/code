package com.google.e.h.b;

import com.google.e.j;
import com.google.e.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class b
{
  private final com.google.e.c.b a;
  private final List<a> b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private final float g;
  private final int[] h;
  private final q i;

  b(com.google.e.c.b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, q paramq)
  {
    this.a = paramb;
    this.b = new ArrayList(5);
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
    this.g = paramFloat;
    this.h = new int[3];
    this.i = paramq;
  }

  private float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    com.google.e.c.b localb = this.a;
    int j = localb.f();
    int[] arrayOfInt = this.h;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    for (int k = paramInt1; (k >= 0) && (localb.a(paramInt2, k)) && (arrayOfInt[1] <= paramInt3); k--)
      arrayOfInt[1] = (1 + arrayOfInt[1]);
    if ((k < 0) || (arrayOfInt[1] > paramInt3));
    int m;
    do
    {
      do
      {
        do
        {
          return (0.0F / 0.0F);
          while ((k >= 0) && (!localb.a(paramInt2, k)) && (arrayOfInt[0] <= paramInt3))
          {
            arrayOfInt[0] = (1 + arrayOfInt[0]);
            k--;
          }
        }
        while (arrayOfInt[0] > paramInt3);
        for (m = paramInt1 + 1; (m < j) && (localb.a(paramInt2, m)) && (arrayOfInt[1] <= paramInt3); m++)
          arrayOfInt[1] = (1 + arrayOfInt[1]);
      }
      while ((m == j) || (arrayOfInt[1] > paramInt3));
      while ((m < j) && (!localb.a(paramInt2, m)) && (arrayOfInt[2] <= paramInt3))
      {
        arrayOfInt[2] = (1 + arrayOfInt[2]);
        m++;
      }
    }
    while ((arrayOfInt[2] > paramInt3) || (5 * Math.abs(arrayOfInt[0] + arrayOfInt[1] + arrayOfInt[2] - paramInt4) >= paramInt4 * 2) || (!a(arrayOfInt)));
    return a(arrayOfInt, m);
  }

  private static float a(int[] paramArrayOfInt, int paramInt)
  {
    return paramInt - paramArrayOfInt[2] - paramArrayOfInt[1] / 2.0F;
  }

  private a a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int j = paramArrayOfInt[0] + paramArrayOfInt[1] + paramArrayOfInt[2];
    float f1 = a(paramArrayOfInt, paramInt2);
    float f2 = a(paramInt1, (int)f1, 2 * paramArrayOfInt[1], j);
    if (!Float.isNaN(f2))
    {
      float f3 = (paramArrayOfInt[0] + paramArrayOfInt[1] + paramArrayOfInt[2]) / 3.0F;
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        a locala2 = (a)localIterator.next();
        if (locala2.a(f3, f2, f1))
          return locala2.b(f2, f1, f3);
      }
      a locala1 = new a(f1, f2, f3);
      this.b.add(locala1);
      if (this.i != null)
        this.i.a(locala1);
    }
    return null;
  }

  private boolean a(int[] paramArrayOfInt)
  {
    float f1 = this.g;
    float f2 = f1 / 2.0F;
    for (int j = 0; j < 3; j++)
      if (Math.abs(f1 - paramArrayOfInt[j]) >= f2)
        return false;
    return true;
  }

  a a()
    throws j
  {
    int j = this.c;
    int k = this.f;
    int m = j + this.e;
    int n = this.d + k / 2;
    int[] arrayOfInt = new int[3];
    label296: for (int i1 = 0; i1 < k; i1++)
    {
      if ((i1 & 0x1) == 0);
      int i3;
      int i4;
      for (int i2 = (i1 + 1) / 2; ; i2 = -((i1 + 1) / 2))
      {
        i3 = n + i2;
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        arrayOfInt[2] = 0;
        for (i4 = j; (i4 < m) && (!this.a.a(i4, i3)); i4++);
      }
      int i5 = i4;
      int i6 = 0;
      a locala;
      while (true)
        if (i5 < m)
          if (this.a.a(i5, i3))
          {
            if (i6 == 1)
            {
              arrayOfInt[i6] = (1 + arrayOfInt[i6]);
              i5++;
              continue;
            }
            if (i6 == 2)
              if (a(arrayOfInt))
              {
                locala = a(arrayOfInt, i3, i5);
                if (locala == null)
                  break;
              }
          }
      do
      {
        return locala;
        arrayOfInt[0] = arrayOfInt[2];
        arrayOfInt[1] = 1;
        arrayOfInt[2] = 0;
        i6 = 1;
        break;
        i6++;
        arrayOfInt[i6] = (1 + arrayOfInt[i6]);
        break;
        if (i6 == 1)
          i6++;
        arrayOfInt[i6] = (1 + arrayOfInt[i6]);
        break;
        if (!a(arrayOfInt))
          break label296;
        locala = a(arrayOfInt, i3, m);
      }
      while (locala != null);
    }
    if (!this.b.isEmpty())
      return (a)this.b.get(0);
    throw j.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.h.b.b
 * JD-Core Version:    0.6.2
 */