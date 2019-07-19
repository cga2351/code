package com.google.e.f;

import com.google.e.j;
import com.google.e.n;
import com.google.e.o;
import java.util.EnumMap;
import java.util.Map;

final class m
{
  private final int[] a = new int[4];
  private final StringBuilder b = new StringBuilder();

  private static Map<o, Object> a(String paramString)
  {
    if (paramString.length() != 2)
      return null;
    EnumMap localEnumMap = new EnumMap(o.class);
    localEnumMap.put(o.e, Integer.valueOf(paramString));
    return localEnumMap;
  }

  int a(com.google.e.c.a parama, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
    throws j
  {
    int[] arrayOfInt = this.a;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int i = parama.a();
    int j = paramArrayOfInt[1];
    int k = 0;
    int m = 0;
    while ((k < 2) && (j < i))
    {
      int n = p.a(parama, arrayOfInt, j, p.e);
      paramStringBuilder.append((char)(48 + n % 10));
      int i1 = arrayOfInt.length;
      int i2 = 0;
      while (i2 < i1)
      {
        int i3 = j + arrayOfInt[i2];
        i2++;
        j = i3;
      }
      if (n >= 10)
        m |= 1 << 1 - k;
      if (k != 1)
        j = parama.d(parama.c(j));
      k++;
    }
    if (paramStringBuilder.length() != 2)
      throw j.a();
    if (Integer.parseInt(paramStringBuilder.toString()) % 4 != m)
      throw j.a();
    return j;
  }

  n a(int paramInt, com.google.e.c.a parama, int[] paramArrayOfInt)
    throws j
  {
    StringBuilder localStringBuilder = this.b;
    localStringBuilder.setLength(0);
    int i = a(parama, paramArrayOfInt, localStringBuilder);
    String str = localStringBuilder.toString();
    Map localMap = a(str);
    com.google.e.p[] arrayOfp = new com.google.e.p[2];
    arrayOfp[0] = new com.google.e.p((paramArrayOfInt[0] + paramArrayOfInt[1]) / 2.0F, paramInt);
    arrayOfp[1] = new com.google.e.p(i, paramInt);
    n localn = new n(str, null, arrayOfp, com.google.e.a.q);
    if (localMap != null)
      localn.a(localMap);
    return localn;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.m
 * JD-Core Version:    0.6.2
 */