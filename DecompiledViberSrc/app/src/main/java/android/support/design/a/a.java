package android.support.design.a;

import android.animation.TimeInterpolator;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public class a
{
  public static final TimeInterpolator a = new LinearInterpolator();
  public static final TimeInterpolator b = new FastOutSlowInInterpolator();
  public static final TimeInterpolator c = new FastOutLinearInInterpolator();
  public static final TimeInterpolator d = new LinearOutSlowInInterpolator();
  public static final TimeInterpolator e = new DecelerateInterpolator();

  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 + paramFloat3 * (paramFloat2 - paramFloat1);
  }

  public static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    return paramInt1 + Math.round(paramFloat * (paramInt2 - paramInt1));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.a.a
 * JD-Core Version:    0.6.2
 */