package com.facebook.react.uimanager;

import android.util.DisplayMetrics;
import android.util.TypedValue;

public class PixelUtil
{
  public static float getDisplayMetricDensity()
  {
    return DisplayMetricsHolder.getScreenDisplayMetrics().density;
  }

  public static float toDIPFromPixel(float paramFloat)
  {
    return paramFloat / DisplayMetricsHolder.getWindowDisplayMetrics().density;
  }

  public static float toPixelFromDIP(double paramDouble)
  {
    return toPixelFromDIP((float)paramDouble);
  }

  public static float toPixelFromDIP(float paramFloat)
  {
    return TypedValue.applyDimension(1, paramFloat, DisplayMetricsHolder.getWindowDisplayMetrics());
  }

  public static float toPixelFromSP(double paramDouble)
  {
    return toPixelFromSP((float)paramDouble);
  }

  public static float toPixelFromSP(float paramFloat)
  {
    return toPixelFromSP(paramFloat, (0.0F / 0.0F));
  }

  public static float toPixelFromSP(float paramFloat1, float paramFloat2)
  {
    DisplayMetrics localDisplayMetrics = DisplayMetricsHolder.getWindowDisplayMetrics();
    float f1 = localDisplayMetrics.scaledDensity;
    float f2 = f1 / localDisplayMetrics.density;
    if ((paramFloat2 >= 1.0F) && (paramFloat2 < f2))
      f1 = paramFloat2 * localDisplayMetrics.density;
    return f1 * paramFloat1;
  }

  public static float toSPFromPixel(float paramFloat)
  {
    return paramFloat / DisplayMetricsHolder.getScreenDisplayMetrics().scaledDensity;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.PixelUtil
 * JD-Core Version:    0.6.2
 */