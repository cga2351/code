package com.google.e.d.b;

import com.google.e.c.g;
import com.google.e.c.i;
import com.google.e.j;
import com.google.e.p;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private final com.google.e.c.b a;
  private final com.google.e.c.a.b b;

  public a(com.google.e.c.b paramb)
    throws j
  {
    this.a = paramb;
    this.b = new com.google.e.c.a.b(paramb);
  }

  private static int a(p paramp1, p paramp2)
  {
    return com.google.e.c.a.a.a(p.a(paramp1, paramp2));
  }

  private static com.google.e.c.b a(com.google.e.c.b paramb, p paramp1, p paramp2, p paramp3, p paramp4, int paramInt1, int paramInt2)
    throws j
  {
    return i.a().a(paramb, paramInt1, paramInt2, 0.5F, 0.5F, paramInt1 - 0.5F, 0.5F, paramInt1 - 0.5F, paramInt2 - 0.5F, 0.5F, paramInt2 - 0.5F, paramp1.a(), paramp1.b(), paramp4.a(), paramp4.b(), paramp3.a(), paramp3.b(), paramp2.a(), paramp2.b());
  }

  private p a(p paramp1, p paramp2, p paramp3, p paramp4, int paramInt)
  {
    float f1 = a(paramp1, paramp2) / paramInt;
    int i = a(paramp3, paramp4);
    float f2 = (paramp4.a() - paramp3.a()) / i;
    float f3 = (paramp4.b() - paramp3.b()) / i;
    Object localObject = new p(paramp4.a() + f2 * f1, paramp4.b() + f1 * f3);
    float f4 = a(paramp1, paramp3) / paramInt;
    int j = a(paramp2, paramp4);
    float f5 = (paramp4.a() - paramp2.a()) / j;
    float f6 = (paramp4.b() - paramp2.b()) / j;
    p localp = new p(paramp4.a() + f5 * f4, paramp4.b() + f4 * f6);
    if (!a((p)localObject))
      if (a(localp))
        localObject = localp;
    while ((!a(localp)) || (Math.abs(b(paramp3, (p)localObject).c() - b(paramp2, (p)localObject).c()) <= Math.abs(b(paramp3, localp).c() - b(paramp2, localp).c())))
    {
      return localObject;
      return null;
    }
    return localp;
  }

  private p a(p paramp1, p paramp2, p paramp3, p paramp4, int paramInt1, int paramInt2)
  {
    float f1 = a(paramp1, paramp2) / paramInt1;
    int i = a(paramp3, paramp4);
    float f2 = (paramp4.a() - paramp3.a()) / i;
    float f3 = (paramp4.b() - paramp3.b()) / i;
    p localp1 = new p(paramp4.a() + f2 * f1, paramp4.b() + f1 * f3);
    float f4 = a(paramp1, paramp3) / paramInt2;
    int j = a(paramp2, paramp4);
    float f5 = (paramp4.a() - paramp2.a()) / j;
    float f6 = (paramp4.b() - paramp2.b()) / j;
    p localp2 = new p(paramp4.a() + f5 * f4, paramp4.b() + f4 * f6);
    if (!a(localp1))
      if (!a(localp2));
    do
    {
      return localp2;
      return null;
      if (!a(localp2))
        return localp1;
    }
    while (Math.abs(paramInt1 - b(paramp3, localp1).c()) + Math.abs(paramInt2 - b(paramp2, localp1).c()) > Math.abs(paramInt1 - b(paramp3, localp2).c()) + Math.abs(paramInt2 - b(paramp2, localp2).c()));
    return localp1;
  }

  private static void a(Map<p, Integer> paramMap, p paramp)
  {
    Integer localInteger = (Integer)paramMap.get(paramp);
    if (localInteger == null);
    for (int i = 1; ; i = 1 + localInteger.intValue())
    {
      paramMap.put(paramp, Integer.valueOf(i));
      return;
    }
  }

  private boolean a(p paramp)
  {
    return (paramp.a() >= 0.0F) && (paramp.a() < this.a.e()) && (paramp.b() > 0.0F) && (paramp.b() < this.a.f());
  }

  private a b(p paramp1, p paramp2)
  {
    int i = (int)paramp1.a();
    int j = (int)paramp1.b();
    int k = (int)paramp2.a();
    int m = (int)paramp2.b();
    int n;
    if (Math.abs(m - j) > Math.abs(k - i))
    {
      n = 1;
      if (n == 0)
        break label314;
    }
    while (true)
    {
      int i3 = Math.abs(m - j);
      int i4 = Math.abs(k - i);
      int i5 = -i3 / 2;
      int i6;
      label88: int i7;
      label98: int i8;
      int i9;
      label115: int i10;
      label124: int i11;
      int i12;
      label142: int i14;
      label164: int i15;
      label173: int i16;
      if (i < k)
      {
        i6 = 1;
        if (j >= m)
          break label246;
        i7 = 1;
        i8 = 0;
        com.google.e.c.b localb1 = this.a;
        if (n == 0)
          break label252;
        i9 = i;
        if (n == 0)
          break label259;
        i10 = j;
        boolean bool1 = localb1.a(i9, i10);
        i11 = i;
        i12 = i5;
        if (j == m)
          break label307;
        com.google.e.c.b localb2 = this.a;
        if (n == 0)
          break label265;
        i14 = i11;
        if (n == 0)
          break label272;
        i15 = j;
        boolean bool2 = localb2.a(i14, i15);
        if (bool2 != bool1)
        {
          i8++;
          bool1 = bool2;
        }
        i16 = i12 + i4;
        if (i16 <= 0)
          break label293;
        if (i11 != k)
          break label279;
      }
      label259: label265: label272: label279: label293: label307: for (int i13 = i8; ; i13 = i8)
      {
        return new a(paramp1, paramp2, i13, null);
        n = 0;
        break;
        i6 = -1;
        break label88;
        label246: i7 = -1;
        break label98;
        label252: i9 = j;
        break label115;
        i10 = i;
        break label124;
        i14 = j;
        break label164;
        i15 = i11;
        break label173;
        i11 += i6;
        i16 -= i3;
        j += i7;
        i12 = i16;
        break label142;
      }
      label314: int i1 = m;
      m = k;
      k = i1;
      int i2 = j;
      j = i;
      i = i2;
    }
  }

  public g a()
    throws j
  {
    p[] arrayOfp1 = this.b.a();
    p localp1 = arrayOfp1[0];
    p localp2 = arrayOfp1[1];
    p localp3 = arrayOfp1[2];
    p localp4 = arrayOfp1[3];
    ArrayList localArrayList = new ArrayList(4);
    localArrayList.add(b(localp1, localp2));
    localArrayList.add(b(localp1, localp3));
    localArrayList.add(b(localp2, localp4));
    localArrayList.add(b(localp3, localp4));
    Collections.sort(localArrayList, new b(null));
    a locala1 = (a)localArrayList.get(0);
    a locala2 = (a)localArrayList.get(1);
    HashMap localHashMap = new HashMap();
    a(localHashMap, locala1.a());
    a(localHashMap, locala1.b());
    a(localHashMap, locala2.a());
    a(localHashMap, locala2.b());
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Iterator localIterator = localHashMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject4 = (p)localEntry.getKey();
      Object localObject5;
      Object localObject6;
      if (((Integer)localEntry.getValue()).intValue() == 2)
      {
        localObject5 = localObject4;
        localObject4 = localObject3;
        localObject6 = localObject1;
      }
      while (true)
      {
        localObject2 = localObject5;
        localObject1 = localObject6;
        localObject3 = localObject4;
        break;
        if (localObject1 == null)
        {
          localObject5 = localObject2;
          Object localObject7 = localObject3;
          localObject6 = localObject4;
          localObject4 = localObject7;
        }
        else
        {
          localObject5 = localObject2;
          localObject6 = localObject1;
        }
      }
    }
    if ((localObject1 == null) || (localObject2 == null) || (localObject3 == null))
      throw j.a();
    p[] arrayOfp2 = { localObject1, localObject2, localObject3 };
    p.a(arrayOfp2);
    p localp5 = arrayOfp2[0];
    p localp6 = arrayOfp2[1];
    p localp7 = arrayOfp2[2];
    p localp8;
    int k;
    int m;
    p localp9;
    int n;
    int i1;
    if (!localHashMap.containsKey(localp1))
    {
      localp8 = localp1;
      int i = b(localp7, localp8).c();
      int j = b(localp5, localp8).c();
      if ((i & 0x1) == 1)
        i++;
      k = i + 2;
      if ((j & 0x1) == 1)
        j++;
      m = j + 2;
      if ((k * 4 < m * 7) && (m * 4 < k * 7))
        break label654;
      localp9 = a(localp6, localp5, localp7, localp8, k, m);
      if (localp9 == null)
        localp9 = localp8;
      n = b(localp7, localp9).c();
      i1 = b(localp5, localp9).c();
      if ((n & 0x1) == 1)
        n++;
      if ((i1 & 0x1) == 1)
        i1++;
    }
    label654: int i2;
    for (com.google.e.c.b localb = a(this.a, localp7, localp6, localp5, localp9, n, i1); ; localb = a(this.a, localp7, localp6, localp5, localp9, i2, i2))
    {
      return new g(localb, new p[] { localp7, localp6, localp5, localp9 });
      if (!localHashMap.containsKey(localp2))
      {
        localp8 = localp2;
        break;
      }
      if (!localHashMap.containsKey(localp3))
      {
        localp8 = localp3;
        break;
      }
      localp8 = localp4;
      break;
      localp9 = a(localp6, localp5, localp7, localp8, Math.min(m, k));
      if (localp9 == null)
        localp9 = localp8;
      i2 = 1 + Math.max(b(localp7, localp9).c(), b(localp5, localp9).c());
      if ((i2 & 0x1) == 1)
        i2++;
    }
  }

  private static final class a
  {
    private final p a;
    private final p b;
    private final int c;

    private a(p paramp1, p paramp2, int paramInt)
    {
      this.a = paramp1;
      this.b = paramp2;
      this.c = paramInt;
    }

    p a()
    {
      return this.a;
    }

    p b()
    {
      return this.b;
    }

    public int c()
    {
      return this.c;
    }

    public String toString()
    {
      return this.a + "/" + this.b + '/' + this.c;
    }
  }

  private static final class b
    implements Serializable, Comparator<a.a>
  {
    public int a(a.a parama1, a.a parama2)
    {
      return parama1.c() - parama2.c();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.d.b.a
 * JD-Core Version:    0.6.2
 */