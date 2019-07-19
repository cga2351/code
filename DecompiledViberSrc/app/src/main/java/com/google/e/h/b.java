package com.google.e.h;

import com.google.e.a;
import com.google.e.h.c.c;
import com.google.e.r;
import java.util.Map;

public final class b
{
  private static com.google.e.c.b a(com.google.e.h.c.f paramf, int paramInt1, int paramInt2, int paramInt3)
  {
    com.google.e.h.c.b localb = paramf.a();
    if (localb == null)
      throw new IllegalStateException();
    int i = localb.b();
    int j = localb.a();
    int k = i + paramInt3 * 2;
    int m = j + paramInt3 * 2;
    int n = Math.max(paramInt1, k);
    int i1 = Math.max(paramInt2, m);
    int i2 = Math.min(n / k, i1 / m);
    int i3 = (n - i * i2) / 2;
    int i4 = (i1 - j * i2) / 2;
    com.google.e.c.b localb1 = new com.google.e.c.b(n, i1);
    int i5 = i4;
    int i9;
    for (int i6 = 0; i6 < j; i6 = i9)
    {
      int i7 = 0;
      int i8 = i3;
      while (i7 < i)
      {
        if (localb.a(i7, i6) == 1)
          localb1.a(i8, i5, i2, i2);
        i7++;
        i8 += i2;
      }
      i9 = i6 + 1;
      i5 += i2;
    }
    return localb1;
  }

  public com.google.e.c.b a(String paramString, a parama, int paramInt1, int paramInt2)
    throws r
  {
    return a(paramString, parama, paramInt1, paramInt2, null);
  }

  public com.google.e.c.b a(String paramString, a parama, int paramInt1, int paramInt2, Map<com.google.e.f, ?> paramMap)
    throws r
  {
    if (paramString.isEmpty())
      throw new IllegalArgumentException("Found empty contents");
    if (parama != a.l)
      throw new IllegalArgumentException("Can only encode QR_CODE, but got " + parama);
    if ((paramInt1 < 0) || (paramInt2 < 0))
      throw new IllegalArgumentException("Requested dimensions are too small: " + paramInt1 + 'x' + paramInt2);
    Object localObject = com.google.e.h.a.f.a;
    Integer localInteger;
    if (paramMap != null)
    {
      com.google.e.h.a.f localf = (com.google.e.h.a.f)paramMap.get(com.google.e.f.a);
      if (localf != null)
        localObject = localf;
      localInteger = (Integer)paramMap.get(com.google.e.f.f);
      if (localInteger == null);
    }
    for (int i = localInteger.intValue(); ; i = 4)
      return a(c.a(paramString, (com.google.e.h.a.f)localObject, paramMap), paramInt1, paramInt2, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.h.b
 * JD-Core Version:    0.6.2
 */