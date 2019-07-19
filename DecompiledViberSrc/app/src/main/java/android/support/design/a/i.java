package android.support.design.a;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class i
{
  private long a = 0L;
  private long b = 300L;
  private TimeInterpolator c = null;
  private int d = 0;
  private int e = 1;

  public i(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
  }

  public i(long paramLong1, long paramLong2, TimeInterpolator paramTimeInterpolator)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramTimeInterpolator;
  }

  static i a(ValueAnimator paramValueAnimator)
  {
    i locali = new i(paramValueAnimator.getStartDelay(), paramValueAnimator.getDuration(), b(paramValueAnimator));
    locali.d = paramValueAnimator.getRepeatCount();
    locali.e = paramValueAnimator.getRepeatMode();
    return locali;
  }

  private static TimeInterpolator b(ValueAnimator paramValueAnimator)
  {
    TimeInterpolator localTimeInterpolator = paramValueAnimator.getInterpolator();
    if (((localTimeInterpolator instanceof AccelerateDecelerateInterpolator)) || (localTimeInterpolator == null))
      localTimeInterpolator = a.b;
    do
    {
      return localTimeInterpolator;
      if ((localTimeInterpolator instanceof AccelerateInterpolator))
        return a.c;
    }
    while (!(localTimeInterpolator instanceof DecelerateInterpolator));
    return a.d;
  }

  public long a()
  {
    return this.a;
  }

  public void a(Animator paramAnimator)
  {
    paramAnimator.setStartDelay(a());
    paramAnimator.setDuration(b());
    paramAnimator.setInterpolator(c());
    if ((paramAnimator instanceof ValueAnimator))
    {
      ((ValueAnimator)paramAnimator).setRepeatCount(d());
      ((ValueAnimator)paramAnimator).setRepeatMode(e());
    }
  }

  public long b()
  {
    return this.b;
  }

  public TimeInterpolator c()
  {
    if (this.c != null)
      return this.c;
    return a.b;
  }

  public int d()
  {
    return this.d;
  }

  public int e()
  {
    return this.e;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    i locali;
    int k;
    int m;
    do
    {
      int i;
      int j;
      do
      {
        boolean bool3;
        do
        {
          boolean bool2;
          do
          {
            Class localClass1;
            Class localClass2;
            do
            {
              do
              {
                return bool1;
                bool1 = false;
              }
              while (paramObject == null);
              localClass1 = getClass();
              localClass2 = paramObject.getClass();
              bool1 = false;
            }
            while (localClass1 != localClass2);
            locali = (i)paramObject;
            bool2 = a() < locali.a();
            bool1 = false;
          }
          while (bool2);
          bool3 = b() < locali.b();
          bool1 = false;
        }
        while (bool3);
        i = d();
        j = locali.d();
        bool1 = false;
      }
      while (i != j);
      k = e();
      m = locali.e();
      bool1 = false;
    }
    while (k != m);
    return c().getClass().equals(locali.c().getClass());
  }

  public int hashCode()
  {
    return 31 * (31 * (31 * (31 * (int)(a() ^ a() >>> 32) + (int)(b() ^ b() >>> 32)) + c().getClass().hashCode()) + d()) + e();
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\n');
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append('{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" delay: ");
    localStringBuilder.append(a());
    localStringBuilder.append(" duration: ");
    localStringBuilder.append(b());
    localStringBuilder.append(" interpolator: ");
    localStringBuilder.append(c().getClass());
    localStringBuilder.append(" repeatCount: ");
    localStringBuilder.append(d());
    localStringBuilder.append(" repeatMode: ");
    localStringBuilder.append(e());
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.a.i
 * JD-Core Version:    0.6.2
 */