package com.crashlytics.android.a;

import c.a.a.a.a.c.a.a;
import java.util.Random;

class w
  implements a
{
  final a a;
  final Random b;
  final double c;

  public w(a parama, double paramDouble)
  {
    this(parama, paramDouble, new Random());
  }

  public w(a parama, double paramDouble, Random paramRandom)
  {
    if ((paramDouble < 0.0D) || (paramDouble > 1.0D))
      throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
    if (parama == null)
      throw new NullPointerException("backoff must not be null");
    if (paramRandom == null)
      throw new NullPointerException("random must not be null");
    this.a = parama;
    this.c = paramDouble;
    this.b = paramRandom;
  }

  double a()
  {
    double d1 = 1.0D - this.c;
    double d2 = 1.0D + this.c;
    return d1 + this.b.nextDouble() * (d2 - d1);
  }

  public long a(int paramInt)
  {
    return ()(a() * this.a.a(paramInt));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a.w
 * JD-Core Version:    0.6.2
 */