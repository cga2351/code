package android.support.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

class i
{
  static PropertyValuesHolder a(Property<?, PointF> paramProperty, Path paramPath)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return PropertyValuesHolder.ofObject(paramProperty, null, paramPath);
    return PropertyValuesHolder.ofFloat(new h(paramProperty, paramPath), new float[] { 0.0F, 1.0F });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.transition.i
 * JD-Core Version:    0.6.2
 */