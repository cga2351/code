package com.facebook.react.uimanager.layoutanimation;

import android.view.animation.Interpolator;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;

class SimpleSpringInterpolator
  implements Interpolator
{
  private static final float FACTOR = 0.5F;
  public static final String PARAM_SPRING_DAMPING = "springDamping";
  private final float mSpringDamping;

  public SimpleSpringInterpolator()
  {
    this.mSpringDamping = 0.5F;
  }

  public SimpleSpringInterpolator(float paramFloat)
  {
    this.mSpringDamping = paramFloat;
  }

  public static float getSpringDamping(ReadableMap paramReadableMap)
  {
    if (paramReadableMap.getType("springDamping").equals(ReadableType.Number))
      return (float)paramReadableMap.getDouble("springDamping");
    return 0.5F;
  }

  public float getInterpolation(float paramFloat)
  {
    return (float)(1.0D + Math.pow(2.0D, -10.0F * paramFloat) * Math.sin(2.0D * (3.141592653589793D * (paramFloat - this.mSpringDamping / 4.0F)) / this.mSpringDamping));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.layoutanimation.SimpleSpringInterpolator
 * JD-Core Version:    0.6.2
 */