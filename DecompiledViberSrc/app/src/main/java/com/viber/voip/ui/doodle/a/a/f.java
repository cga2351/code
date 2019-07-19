package com.viber.voip.ui.doodle.a.a;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

public class f extends GestureDetector
  implements b
{
  public f(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    super(paramContext, paramOnGestureListener);
  }

  public boolean a()
  {
    return false;
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    return onTouchEvent(paramMotionEvent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.a.a.f
 * JD-Core Version:    0.6.2
 */