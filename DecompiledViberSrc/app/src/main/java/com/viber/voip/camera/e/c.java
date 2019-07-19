package com.viber.voip.camera.e;

import android.graphics.Point;

public final class c
{
  public static double a(double paramDouble1, double paramDouble2)
  {
    return paramDouble1 * paramDouble2;
  }

  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    double d = Math.min((paramDouble3 + 0.0D) / paramDouble1, (0.0D + paramDouble4) / paramDouble2);
    return paramDouble1 * d * (d * paramDouble2);
  }

  public static double a(Point paramPoint)
  {
    return a(paramPoint.x, paramPoint.y);
  }

  public static Point a(Point paramPoint1, Point paramPoint2)
  {
    if ((paramPoint1.x > paramPoint2.x) || (paramPoint1.y > paramPoint2.y))
      paramPoint1 = paramPoint2;
    return paramPoint1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camera.e.c
 * JD-Core Version:    0.6.2
 */