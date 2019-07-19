package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

class f
{
  static <T> ObjectAnimator a(T paramT, Property<T, PointF> paramProperty, Path paramPath)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return ObjectAnimator.ofObject(paramT, paramProperty, null, paramPath);
    return ObjectAnimator.ofFloat(paramT, new h(paramProperty, paramPath), new float[] { 0.0F, 1.0F });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.transition.f
 * JD-Core Version:    0.6.2
 */