package com.google.e.g.a;

import com.google.e.p;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class j
{
  private static final com.google.e.g.a.a.a a = new com.google.e.g.a.a.a();

  private static int a(int paramInt)
  {
    return 2 << paramInt;
  }

  private static int a(f paramf, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean);
    d locald1;
    for (int i = 1; ; i = -1)
    {
      boolean bool = a(paramf, paramInt1 - i);
      locald1 = null;
      if (bool)
        locald1 = paramf.a(paramInt1 - i).c(paramInt2);
      if (locald1 == null)
        break label66;
      if (!paramBoolean)
        break;
      return locald1.e();
    }
    return locald1.d();
    label66: d locald2 = paramf.a(paramInt1).a(paramInt2);
    if (locald2 != null)
    {
      if (paramBoolean)
        return locald2.d();
      return locald2.e();
    }
    if (a(paramf, paramInt1 - i))
      locald2 = paramf.a(paramInt1 - i).a(paramInt2);
    if (locald2 != null)
    {
      if (paramBoolean)
        return locald2.e();
      return locald2.d();
    }
    for (int j = 0; a(paramf, paramInt1 - i); j++)
    {
      paramInt1 -= i;
      for (d locald3 : paramf.a(paramInt1).b())
        if (locald3 != null)
        {
          if (paramBoolean);
          for (int n = locald3.e(); ; n = locald3.d())
            return n + i * j * (locald3.e() - locald3.d());
        }
    }
    if (paramBoolean)
      return paramf.e().a();
    return paramf.e().b();
  }

  private static int a(int[] paramArrayOfInt)
  {
    int i = -1;
    int j = paramArrayOfInt.length;
    for (int k = 0; k < j; k++)
      i = Math.max(i, paramArrayOfInt[k]);
    return i;
  }

  private static int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
    throws com.google.e.d
  {
    if (((paramArrayOfInt2 != null) && (paramArrayOfInt2.length > 3 + paramInt / 2)) || (paramInt < 0) || (paramInt > 512))
      throw com.google.e.d.a();
    return a.a(paramArrayOfInt1, paramInt, paramArrayOfInt2);
  }

  private static com.google.e.c.e a(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[][] paramArrayOfInt)
    throws com.google.e.g, com.google.e.d
  {
    int[] arrayOfInt = new int[paramArrayOfInt3.length];
    int i = 100;
    int j = i - 1;
    if (i > 0)
    {
      for (int k = 0; k < arrayOfInt.length; k++)
        paramArrayOfInt1[paramArrayOfInt3[k]] = paramArrayOfInt[k][arrayOfInt[k]];
      int m;
      try
      {
        com.google.e.c.e locale = a(paramArrayOfInt1, paramInt, paramArrayOfInt2);
        return locale;
      }
      catch (com.google.e.d locald)
      {
        if (arrayOfInt.length == 0)
          throw com.google.e.d.a();
        m = 0;
      }
      while (true)
      {
        if (m < arrayOfInt.length)
        {
          if (arrayOfInt[m] < -1 + paramArrayOfInt[m].length)
            arrayOfInt[m] = (1 + arrayOfInt[m]);
        }
        else
        {
          i = j;
          break;
        }
        arrayOfInt[m] = 0;
        if (m == -1 + arrayOfInt.length)
          throw com.google.e.d.a();
        m++;
      }
    }
    throw com.google.e.d.a();
  }

  public static com.google.e.c.e a(com.google.e.c.b paramb, p paramp1, p paramp2, p paramp3, p paramp4, int paramInt1, int paramInt2)
    throws com.google.e.j, com.google.e.g, com.google.e.d
  {
    c localc1 = new c(paramb, paramp1, paramp2, paramp3, paramp4);
    Object localObject1 = null;
    int i = 0;
    Object localObject2 = localc1;
    Object localObject3 = null;
    Object localObject4 = null;
    if (i < 2)
      if (paramp1 == null)
        break label502;
    label229: label502: for (Object localObject6 = a(paramb, (c)localObject2, paramp1, true, paramInt1, paramInt2); ; localObject6 = localObject4)
    {
      if (paramp3 != null);
      for (Object localObject7 = a(paramb, (c)localObject2, paramp3, false, paramInt1, paramInt2); ; localObject7 = localObject1)
      {
        f localf = a((h)localObject6, (h)localObject7);
        if (localf == null)
          throw com.google.e.j.a();
        if ((i == 0) && (localf.e() != null) && ((localf.e().c() < ((c)localObject2).c()) || (localf.e().d() > ((c)localObject2).d())))
        {
          c localc2 = localf.e();
          i++;
          localObject1 = localObject7;
          localObject3 = localf;
          localObject2 = localc2;
          localObject4 = localObject6;
          break;
        }
        localf.a((c)localObject2);
        localObject1 = localObject7;
        localObject3 = localf;
        localObject4 = localObject6;
        int j = 1 + localObject3.b();
        localObject3.a(0, localObject4);
        localObject3.a(j, localObject1);
        boolean bool1;
        int k;
        int m;
        int n;
        if (localObject4 != null)
        {
          bool1 = true;
          k = 1;
          m = paramInt2;
          n = paramInt1;
          if (k > j)
            break label482;
          if (!bool1)
            break label267;
        }
        for (int i1 = k; ; i1 = j - k)
        {
          if (localObject3.a(i1) == null)
            break label277;
          k++;
          break label229;
          bool1 = false;
          break;
        }
        boolean bool2;
        Object localObject5;
        int i2;
        int i3;
        int i4;
        int i5;
        if ((i1 == 0) || (i1 == j))
          if (i1 == 0)
          {
            bool2 = true;
            localObject5 = new h((c)localObject2, bool2);
            localObject3.a(i1, (g)localObject5);
            i2 = ((c)localObject2).c();
            i3 = -1;
            if (i2 <= ((c)localObject2).d())
            {
              i4 = a(localObject3, i1, i2, bool1);
              if ((i4 >= 0) && (i4 <= ((c)localObject2).b()))
                break label411;
              if (i3 != -1)
                break label407;
              i5 = i3;
            }
          }
        while (true)
        {
          i2++;
          i3 = i5;
          break label329;
          break;
          bool2 = false;
          break label297;
          localObject5 = new g((c)localObject2);
          break label310;
          i4 = i3;
          d locald = a(paramb, ((c)localObject2).a(), ((c)localObject2).b(), bool1, i4, i2, n, m);
          if (locald != null)
          {
            ((g)localObject5).a(i2, locald);
            n = Math.min(n, locald.c());
            m = Math.max(m, locald.c());
            i5 = i4;
            continue;
            return a(localObject3);
          }
          else
          {
            i5 = i3;
          }
        }
      }
    }
  }

  private static com.google.e.c.e a(f paramf)
    throws com.google.e.g, com.google.e.d, com.google.e.j
  {
    int i = 0;
    b[][] arrayOfb = b(paramf);
    a(paramf, arrayOfb);
    ArrayList localArrayList1 = new ArrayList();
    int[] arrayOfInt1 = new int[paramf.c() * paramf.b()];
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    for (int j = 0; j < paramf.c(); j++)
    {
      int k = 0;
      if (k < paramf.b())
      {
        int[] arrayOfInt2 = arrayOfb[j][(k + 1)].a();
        int m = k + j * paramf.b();
        if (arrayOfInt2.length == 0)
          localArrayList1.add(Integer.valueOf(m));
        while (true)
        {
          k++;
          break;
          if (arrayOfInt2.length == 1)
          {
            arrayOfInt1[m] = arrayOfInt2[0];
          }
          else
          {
            localArrayList3.add(Integer.valueOf(m));
            localArrayList2.add(arrayOfInt2);
          }
        }
      }
    }
    int[][] arrayOfInt = new int[localArrayList2.size()][];
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = ((int[])localArrayList2.get(i));
      i++;
    }
    return a(paramf.d(), arrayOfInt1, com.google.e.g.a.a(localArrayList1), com.google.e.g.a.a(localArrayList3), arrayOfInt);
  }

  private static com.google.e.c.e a(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
    throws com.google.e.g, com.google.e.d
  {
    if (paramArrayOfInt1.length == 0)
      throw com.google.e.g.a();
    int i = 1 << paramInt + 1;
    int j = a(paramArrayOfInt1, paramArrayOfInt2, i);
    a(paramArrayOfInt1, i);
    com.google.e.c.e locale = e.a(paramArrayOfInt1, String.valueOf(paramInt));
    locale.a(Integer.valueOf(j));
    locale.b(Integer.valueOf(paramArrayOfInt2.length));
    return locale;
  }

  private static c a(h paramh)
    throws com.google.e.j, com.google.e.g
  {
    if (paramh == null);
    int[] arrayOfInt;
    do
    {
      return null;
      arrayOfInt = paramh.d();
    }
    while (arrayOfInt == null);
    int i = a(arrayOfInt);
    int j = arrayOfInt.length;
    int k = 0;
    int m = 0;
    d[] arrayOfd;
    int n;
    while (true)
    {
      if (k < j)
      {
        int i8 = arrayOfInt[k];
        m += i - i8;
        if (i8 <= 0);
      }
      else
      {
        arrayOfd = paramh.b();
        n = m;
        for (int i1 = 0; (n > 0) && (arrayOfd[i1] == null); i1++)
          n--;
      }
      k++;
    }
    int i2 = -1 + arrayOfInt.length;
    int i3 = 0;
    int i6;
    for (int i4 = i2; ; i4--)
      if (i4 >= 0)
      {
        i3 += i - arrayOfInt[i4];
        if (arrayOfInt[i4] <= 0);
      }
      else
      {
        int i5 = -1 + arrayOfd.length;
        i6 = i3;
        for (int i7 = i5; (i6 > 0) && (arrayOfd[i7] == null); i7--)
          i6--;
      }
    return paramh.a().a(n, i6, paramh.f());
  }

  private static d a(com.google.e.c.b paramb, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i = b(paramb, paramInt1, paramInt2, paramBoolean, paramInt3, paramInt4);
    int[] arrayOfInt = a(paramb, paramInt1, paramInt2, paramBoolean, i, paramInt4);
    if (arrayOfInt == null)
      return null;
    int j = com.google.e.g.a.a(arrayOfInt);
    int m;
    if (paramBoolean)
    {
      int i3 = i + j;
      m = i;
      i = i3;
    }
    while (!a(j, paramInt5, paramInt6))
    {
      return null;
      for (int k = 0; k < arrayOfInt.length / 2; k++)
      {
        int i2 = arrayOfInt[k];
        arrayOfInt[k] = arrayOfInt[(-1 + arrayOfInt.length - k)];
        arrayOfInt[(-1 + arrayOfInt.length - k)] = i2;
      }
      m = i - j;
    }
    int n = i.a(arrayOfInt);
    int i1 = com.google.e.g.a.a(n);
    if (i1 == -1)
      return null;
    return new d(m, i, c(n), i1);
  }

  private static f a(h paramh1, h paramh2)
    throws com.google.e.j, com.google.e.g
  {
    if ((paramh1 == null) && (paramh2 == null));
    a locala;
    do
    {
      return null;
      locala = b(paramh1, paramh2);
    }
    while (locala == null);
    return new f(locala, c.a(a(paramh1), a(paramh2)));
  }

  private static h a(com.google.e.c.b paramb, c paramc, p paramp, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    h localh = new h(paramc, paramBoolean);
    for (int i = 0; i < 2; i++)
    {
      int j;
      int m;
      label42: d locald;
      if (i == 0)
      {
        j = 1;
        k = (int)paramp.a();
        m = (int)paramp.b();
        if ((m > paramc.d()) || (m < paramc.c()))
          continue;
        locald = a(paramb, 0, paramb.e(), paramBoolean, k, m, paramInt1, paramInt2);
        if (locald != null)
        {
          localh.a(m, locald);
          if (!paramBoolean)
            break label121;
        }
      }
      label121: for (int k = locald.d(); ; k = locald.e())
      {
        m += j;
        break label42;
        j = -1;
        break;
      }
    }
    return localh;
  }

  private static void a(f paramf, b[][] paramArrayOfb)
    throws com.google.e.j
  {
    int[] arrayOfInt = paramArrayOfb[0][1].a();
    int i = paramf.b() * paramf.c() - a(paramf.d());
    if (arrayOfInt.length == 0)
    {
      if ((i < 1) || (i > 928))
        throw com.google.e.j.a();
      paramArrayOfb[0][1].a(i);
    }
    while (arrayOfInt[0] == i)
      return;
    paramArrayOfb[0][1].a(i);
  }

  private static void a(int[] paramArrayOfInt, int paramInt)
    throws com.google.e.g
  {
    if (paramArrayOfInt.length < 4)
      throw com.google.e.g.a();
    int i = paramArrayOfInt[0];
    if (i > paramArrayOfInt.length)
      throw com.google.e.g.a();
    if (i == 0)
    {
      if (paramInt < paramArrayOfInt.length)
        paramArrayOfInt[0] = (paramArrayOfInt.length - paramInt);
    }
    else
      return;
    throw com.google.e.g.a();
  }

  private static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt2 - 2 <= paramInt1) && (paramInt1 <= paramInt3 + 2);
  }

  private static boolean a(f paramf, int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 1 + paramf.b());
  }

  private static int[] a(com.google.e.c.b paramb, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    int[] arrayOfInt = new int[8];
    int i;
    boolean bool;
    int j;
    if (paramBoolean)
    {
      i = 1;
      bool = paramBoolean;
      j = 0;
    }
    while (true)
    {
      if (((!paramBoolean) || (paramInt3 >= paramInt2)) && ((paramBoolean) || (paramInt3 < paramInt1) || (j >= arrayOfInt.length)))
        break label108;
      if (paramb.a(paramInt3, paramInt4) == bool)
      {
        arrayOfInt[j] = (1 + arrayOfInt[j]);
        paramInt3 += i;
        continue;
        i = -1;
        break;
      }
      j++;
      if (!bool)
        bool = true;
      else
        bool = false;
    }
    label108: if ((j == arrayOfInt.length) || (((paramBoolean) && (paramInt3 == paramInt2)) || ((!paramBoolean) && (paramInt3 == paramInt1) && (j == -1 + arrayOfInt.length))))
      return arrayOfInt;
    return null;
  }

  private static int b(com.google.e.c.b paramb, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    int i;
    int j;
    int k;
    int m;
    int n;
    if (paramBoolean)
    {
      i = -1;
      j = 0;
      k = i;
      m = paramInt3;
      if (j < 2)
        n = m;
    }
    else
    {
      while (true)
      {
        if (((!paramBoolean) || (n < paramInt1)) && ((paramBoolean) || (n >= paramInt2) || (paramBoolean != paramb.a(n, paramInt4))))
          break label91;
        if (Math.abs(paramInt3 - n) > 2)
        {
          return paramInt3;
          i = 1;
          break;
        }
        n += k;
      }
      label91: k = -k;
      if (!paramBoolean);
      for (boolean bool = true; ; bool = false)
      {
        j++;
        paramBoolean = bool;
        m = n;
        break;
      }
    }
    return m;
  }

  private static int b(int[] paramArrayOfInt)
  {
    return (9 + (paramArrayOfInt[0] - paramArrayOfInt[2] + paramArrayOfInt[4] - paramArrayOfInt[6])) % 9;
  }

  private static a b(h paramh1, h paramh2)
  {
    a locala1;
    if (paramh1 != null)
    {
      locala1 = paramh1.e();
      if (locala1 != null);
    }
    else if (paramh2 != null);
    a locala2;
    do
    {
      return null;
      return paramh2.e();
      if (paramh2 != null)
      {
        locala2 = paramh2.e();
        if (locala2 != null);
      }
      else
      {
        return locala1;
      }
    }
    while ((locala1.a() != locala2.a()) && (locala1.b() != locala2.b()) && (locala1.c() != locala2.c()));
    return locala1;
  }

  private static int[] b(int paramInt)
  {
    int[] arrayOfInt = new int[8];
    int i = 0;
    int j = -1 + arrayOfInt.length;
    while (true)
    {
      if ((paramInt & 0x1) != i)
      {
        i = paramInt & 0x1;
        j--;
        if (j < 0)
          return arrayOfInt;
      }
      arrayOfInt[j] = (1 + arrayOfInt[j]);
      paramInt >>= 1;
    }
  }

  private static b[][] b(f paramf)
    throws com.google.e.g
  {
    b[][] arrayOfb = (b[][])Array.newInstance(b.class, new int[] { paramf.c(), 2 + paramf.b() });
    for (int i = 0; i < arrayOfb.length; i++)
      for (int i3 = 0; i3 < arrayOfb[i].length; i3++)
        arrayOfb[i][i3] = new b();
    g[] arrayOfg = paramf.a();
    int j = arrayOfg.length;
    int k = 0;
    int m = 0;
    while (k < j)
    {
      g localg = arrayOfg[k];
      if (localg != null)
        for (d locald : localg.b())
          if (locald != null)
          {
            int i2 = locald.h();
            if (i2 >= 0)
            {
              if (i2 >= arrayOfb.length)
                throw com.google.e.g.a();
              arrayOfb[i2][m].a(locald.g());
            }
          }
      m++;
      k++;
    }
    return arrayOfb;
  }

  private static int c(int paramInt)
  {
    return b(b(paramInt));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.g.a.j
 * JD-Core Version:    0.6.2
 */