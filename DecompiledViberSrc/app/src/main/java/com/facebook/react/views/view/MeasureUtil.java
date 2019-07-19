package com.facebook.react.views.view;

import android.view.View.MeasureSpec;
import com.facebook.yoga.YogaMeasureMode;

public class MeasureUtil
{
  public static int getMeasureSpec(float paramFloat, YogaMeasureMode paramYogaMeasureMode)
  {
    if (paramYogaMeasureMode == YogaMeasureMode.EXACTLY)
      return View.MeasureSpec.makeMeasureSpec((int)paramFloat, 1073741824);
    if (paramYogaMeasureMode == YogaMeasureMode.AT_MOST)
      return View.MeasureSpec.makeMeasureSpec((int)paramFloat, -2147483648);
    return View.MeasureSpec.makeMeasureSpec(0, 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.view.MeasureUtil
 * JD-Core Version:    0.6.2
 */