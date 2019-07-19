package com.facebook.react.fabric.mounting;

import android.view.View.MeasureSpec;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.yoga.YogaMeasureMode;

public class LayoutMetricsConversions
{
  public static final int REACT_CONSTRAINT_UNDEFINED = -2147483648;

  public static float getMaxSize(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    int j = View.MeasureSpec.getSize(paramInt);
    if (i == 0)
      return -2.147484E+009F;
    return j;
  }

  public static float getMinSize(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    int j = View.MeasureSpec.getSize(paramInt);
    if (i == 1073741824)
      return j;
    return 0.0F;
  }

  public static YogaMeasureMode getYogaMeasureMode(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 == paramFloat2)
      return YogaMeasureMode.EXACTLY;
    if (paramFloat2 == -2.147484E+009F)
      return YogaMeasureMode.UNDEFINED;
    return YogaMeasureMode.AT_MOST;
  }

  public static float getYogaSize(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 == paramFloat2)
      return PixelUtil.toPixelFromDIP(paramFloat2);
    if (paramFloat2 == -2.147484E+009F)
      return 0.0F;
    return PixelUtil.toPixelFromDIP(paramFloat2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.fabric.mounting.LayoutMetricsConversions
 * JD-Core Version:    0.6.2
 */