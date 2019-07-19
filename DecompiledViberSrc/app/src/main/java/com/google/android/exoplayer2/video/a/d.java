package com.google.android.exoplayer2.video.a;

import com.google.android.exoplayer2.g.a;

public final class d
{
  public final a a;
  public final a b;
  public final int c;
  public final boolean d;

  public d(a parama, int paramInt)
  {
    this(parama, parama, paramInt);
  }

  public d(a parama1, a parama2, int paramInt)
  {
    this.a = parama1;
    this.b = parama2;
    this.c = paramInt;
    if (parama1 == parama2);
    for (boolean bool = true; ; bool = false)
    {
      this.d = bool;
      return;
    }
  }

  public static d a(float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, float paramFloat3, int paramInt3)
  {
    boolean bool1;
    boolean bool2;
    label22: boolean bool3;
    label35: boolean bool4;
    label56: boolean bool5;
    label79: float f1;
    float f2;
    float f3;
    float f4;
    float[] arrayOfFloat1;
    float[] arrayOfFloat2;
    int j;
    int k;
    if (paramFloat1 > 0.0F)
    {
      bool1 = true;
      a.a(bool1);
      if (paramInt1 < 1)
        break label431;
      bool2 = true;
      a.a(bool2);
      if (paramInt2 < 1)
        break label437;
      bool3 = true;
      a.a(bool3);
      if ((paramFloat2 <= 0.0F) || (paramFloat2 > 180.0F))
        break label443;
      bool4 = true;
      a.a(bool4);
      if ((paramFloat3 <= 0.0F) || (paramFloat3 > 360.0F))
        break label449;
      bool5 = true;
      a.a(bool5);
      f1 = (float)Math.toRadians(paramFloat2);
      f2 = (float)Math.toRadians(paramFloat3);
      f3 = f1 / paramInt1;
      f4 = f2 / paramInt2;
      int i = paramInt1 * (2 + 2 * (paramInt2 + 1));
      arrayOfFloat1 = new float[i * 3];
      arrayOfFloat2 = new float[i * 2];
      j = 0;
      k = 0;
    }
    label207: label476: for (int m = 0; ; m++)
    {
      if (m >= paramInt1)
        break label482;
      float f5 = f3 * m - f1 / 2.0F;
      float f6 = f3 * (m + 1) - f1 / 2.0F;
      int n = 0;
      while (true)
      {
        if (n >= paramInt2 + 1)
          break label476;
        int i1 = k;
        int i2 = j;
        int i3 = 0;
        if (i3 < 2)
        {
          if (i3 == 0);
          for (float f7 = f5; ; f7 = f6)
          {
            float f8 = 3.141593F + f4 * n - f2 / 2.0F;
            int i4 = i2 + 1;
            arrayOfFloat1[i2] = (-(float)(paramFloat1 * Math.sin(f8) * Math.cos(f7)));
            int i5 = i4 + 1;
            arrayOfFloat1[i4] = ((float)(paramFloat1 * Math.sin(f7)));
            i2 = i5 + 1;
            arrayOfFloat1[i5] = ((float)(paramFloat1 * Math.cos(f8) * Math.cos(f7)));
            int i6 = i1 + 1;
            arrayOfFloat2[i1] = (f4 * n / f2);
            int i7 = i6 + 1;
            arrayOfFloat2[i6] = (f3 * (m + i3) / f1);
            if (((n == 0) && (i3 == 0)) || ((n == paramInt2) && (i3 == 1)))
            {
              System.arraycopy(arrayOfFloat1, i2 - 3, arrayOfFloat1, i2, 3);
              i2 += 3;
              System.arraycopy(arrayOfFloat2, i7 - 2, arrayOfFloat2, i7, 2);
              i7 += 2;
            }
            i3++;
            i1 = i7;
            break label207;
            bool1 = false;
            break;
            bool2 = false;
            break label22;
            bool3 = false;
            break label35;
            bool4 = false;
            break label56;
            bool5 = false;
            break label79;
          }
        }
        n++;
        j = i2;
        k = i1;
      }
    }
    label431: label437: label443: label449: label482: return new d(new a(new b[] { new b(0, arrayOfFloat1, arrayOfFloat2, 1) }), paramInt3);
  }

  public static d a(int paramInt)
  {
    return a(50.0F, 36, 72, 180.0F, 360.0F, paramInt);
  }

  public static final class a
  {
    private final d.b[] a;

    public a(d.b[] paramArrayOfb)
    {
      this.a = paramArrayOfb;
    }

    public int a()
    {
      return this.a.length;
    }

    public d.b a(int paramInt)
    {
      return this.a[paramInt];
    }
  }

  public static final class b
  {
    public final int a;
    public final int b;
    public final float[] c;
    public final float[] d;

    public b(int paramInt1, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt2)
    {
      this.a = paramInt1;
      if (2L * paramArrayOfFloat1.length == 3L * paramArrayOfFloat2.length);
      for (boolean bool = true; ; bool = false)
      {
        a.a(bool);
        this.c = paramArrayOfFloat1;
        this.d = paramArrayOfFloat2;
        this.b = paramInt2;
        return;
      }
    }

    public int a()
    {
      return this.c.length / 3;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.video.a.d
 * JD-Core Version:    0.6.2
 */