package com.viber.voip.ui.doodle.extras;

import android.graphics.PointF;
import android.support.v4.util.CircularIntArray;

public class a
{
  private static double a(b paramb, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, double paramDouble)
  {
    if (paramDouble == 0.0D)
      return 0.0D;
    float f1 = paramb.getX(paramInt);
    float f2 = paramb.getY(paramInt);
    return Math.abs(paramFloat3 + (f1 * paramFloat2 - f2 * paramFloat1) - paramFloat4) / paramDouble;
  }

  public static <T extends b> T a(T paramT, b.a<T> parama, double paramDouble)
  {
    if (paramDouble < 0.0D)
      throw new IllegalArgumentException("Epsilon must be > 0");
    CircularIntArray localCircularIntArray = new CircularIntArray(paramT.getLength());
    localCircularIntArray.addLast(0);
    localCircularIntArray.addLast(-1 + paramT.getLength());
    boolean[] arrayOfBoolean = new boolean[paramT.getLength()];
    int i = paramT.getLength();
    int m;
    int n;
    double d2;
    int i1;
    int i2;
    label196: double d3;
    int i6;
    if (!localCircularIntArray.isEmpty())
    {
      m = localCircularIntArray.popLast();
      n = localCircularIntArray.popLast();
      float f1 = paramT.getX(m) - paramT.getX(n);
      float f2 = paramT.getY(m) - paramT.getY(n);
      float f3 = paramT.getX(m) * paramT.getY(n);
      float f4 = paramT.getY(m) * paramT.getX(n);
      double d1 = Math.sqrt(f2 * f2 + f1 * f1);
      d2 = 0.0D;
      i1 = n + 1;
      i2 = n;
      if (i1 <= m - 1)
      {
        if (arrayOfBoolean[i1] != 0)
          break label412;
        d3 = a(paramT, i1, f1, f2, f3, f4, d1);
        if (d3 <= d2)
          break label412;
        i6 = i1;
      }
    }
    while (true)
    {
      i1++;
      i2 = i6;
      d2 = d3;
      break label196;
      int i4;
      if (d2 >= paramDouble)
      {
        localCircularIntArray.addLast(n);
        localCircularIntArray.addLast(i2);
        localCircularIntArray.addLast(i2);
        localCircularIntArray.addLast(m);
        i4 = i;
      }
      while (true)
      {
        i = i4;
        break;
        int i3 = n + 1;
        int i5;
        for (i4 = i; i3 <= m - 1; i4 = i5)
        {
          arrayOfBoolean[i3] = true;
          i5 = i4 - 1;
          i3++;
        }
      }
      b localb = parama.a(i);
      int j = 0;
      int k = paramT.getLength();
      while (j < k)
      {
        if (arrayOfBoolean[j] == 0)
          localb.addPoint(paramT.getX(j), paramT.getY(j));
        j++;
      }
      return localb;
      label412: i6 = i2;
      d3 = d2;
    }
  }

  private static boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 <= paramFloat3;
  }

  public static boolean a(PointF paramPointF1, PointF paramPointF2, float paramFloat)
  {
    return a(paramPointF1.x - paramPointF2.x, paramPointF1.y - paramPointF2.y, paramFloat);
  }

  public static boolean a(PointF paramPointF, float[] paramArrayOfFloat)
  {
    int i = -2 + paramArrayOfFloat.length;
    int j = 0;
    boolean bool1 = false;
    if (j < paramArrayOfFloat.length)
    {
      float f1 = paramArrayOfFloat[j];
      float f2 = paramArrayOfFloat[(j + 1)];
      float f3 = paramArrayOfFloat[i];
      float f4 = paramArrayOfFloat[(i + 1)];
      int k;
      label54: int m;
      if (f2 > paramPointF.y)
      {
        k = 1;
        if (f4 <= paramPointF.y)
          break label139;
        m = 1;
        label67: if ((k != m) && (paramPointF.x < f1 + (f3 - f1) * (paramPointF.y - f2) / (f4 - f2)))
          if (bool1)
            break label145;
      }
      label139: label145: for (boolean bool2 = true; ; bool2 = false)
      {
        bool1 = bool2;
        int n = j + 2;
        int i1 = j;
        j = n;
        i = i1;
        break;
        k = 0;
        break label54;
        m = 0;
        break label67;
      }
    }
    return bool1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.extras.a
 * JD-Core Version:    0.6.2
 */