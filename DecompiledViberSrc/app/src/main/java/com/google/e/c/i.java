package com.google.e.c;

import com.google.e.j;

public abstract class i
{
  private static i a = new f();

  public static i a()
  {
    return a;
  }

  protected static void a(b paramb, float[] paramArrayOfFloat)
    throws j
  {
    int i = paramb.e();
    int j = paramb.f();
    int k = 0;
    int m = 1;
    int i4;
    int i5;
    if ((k < paramArrayOfFloat.length) && (m != 0))
    {
      i4 = (int)paramArrayOfFloat[k];
      i5 = (int)paramArrayOfFloat[(k + 1)];
      if ((i4 < -1) || (i4 > i) || (i5 < -1) || (i5 > j))
        throw j.a();
      if (i4 == -1)
      {
        paramArrayOfFloat[k] = 0.0F;
        m = 1;
      }
    }
    while (true)
    {
      label86: if (i5 == -1)
      {
        paramArrayOfFloat[(k + 1)] = 0.0F;
        m = 1;
      }
      while (true)
      {
        k += 2;
        break;
        if (i4 != i)
          break label299;
        paramArrayOfFloat[k] = (i - 1);
        m = 1;
        break label86;
        if (i5 == j)
        {
          paramArrayOfFloat[(k + 1)] = (j - 1);
          m = 1;
        }
      }
      int n = -2 + paramArrayOfFloat.length;
      int i1 = 1;
      int i2;
      int i3;
      if ((n >= 0) && (i1 != 0))
      {
        i2 = (int)paramArrayOfFloat[n];
        i3 = (int)paramArrayOfFloat[(n + 1)];
        if ((i2 < -1) || (i2 > i) || (i3 < -1) || (i3 > j))
          throw j.a();
        if (i2 == -1)
        {
          paramArrayOfFloat[n] = 0.0F;
          i1 = 1;
        }
      }
      while (true)
      {
        label228: if (i3 == -1)
        {
          paramArrayOfFloat[(n + 1)] = 0.0F;
          i1 = 1;
        }
        while (true)
        {
          n -= 2;
          break;
          if (i2 != i)
            break label293;
          paramArrayOfFloat[n] = (i - 1);
          i1 = 1;
          break label228;
          if (i3 == j)
          {
            paramArrayOfFloat[(n + 1)] = (j - 1);
            i1 = 1;
          }
        }
        return;
        label293: i1 = 0;
      }
      label299: m = 0;
    }
  }

  public abstract b a(b paramb, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16)
    throws j;

  public abstract b a(b paramb, int paramInt1, int paramInt2, k paramk)
    throws j;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.c.i
 * JD-Core Version:    0.6.2
 */