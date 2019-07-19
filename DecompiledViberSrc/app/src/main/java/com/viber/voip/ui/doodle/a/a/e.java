package com.viber.voip.ui.doodle.a.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

public class e extends ScaleGestureDetector
  implements b
{
  public e(Context paramContext, ScaleGestureDetector.OnScaleGestureListener paramOnScaleGestureListener)
  {
    super(paramContext, paramOnScaleGestureListener);
  }

  public boolean a()
  {
    return isInProgress();
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    return onTouchEvent(paramMotionEvent);
  }

  public float getScaleFactor()
  {
    float f = super.getScaleFactor();
    if (f <= 0.0F)
      return 1.0F;
    return Math.min(1.5F, f);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.a.a.e
 * JD-Core Version:    0.6.2
 */