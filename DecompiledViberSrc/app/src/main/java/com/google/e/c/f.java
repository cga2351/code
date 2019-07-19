package com.google.e.c;

import com.google.e.j;

public final class f extends i
{
  public b a(b paramb, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16)
    throws j
  {
    return a(paramb, paramInt1, paramInt2, k.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15, paramFloat16));
  }

  public b a(b paramb, int paramInt1, int paramInt2, k paramk)
    throws j
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
      throw j.a();
    b localb = new b(paramInt1, paramInt2);
    float[] arrayOfFloat = new float[paramInt1 * 2];
    for (int i = 0; i < paramInt2; i++)
    {
      int j = arrayOfFloat.length;
      float f = 0.5F + i;
      for (int k = 0; k < j; k += 2)
      {
        arrayOfFloat[k] = (0.5F + k / 2);
        arrayOfFloat[(k + 1)] = f;
      }
      paramk.a(arrayOfFloat);
      a(paramb, arrayOfFloat);
      int m = 0;
      while (m < j)
        try
        {
          if (paramb.a((int)arrayOfFloat[m], (int)arrayOfFloat[(m + 1)]))
            localb.b(m / 2, i);
          m += 2;
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          throw j.a();
        }
    }
    return localb;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.c.f
 * JD-Core Version:    0.6.2
 */