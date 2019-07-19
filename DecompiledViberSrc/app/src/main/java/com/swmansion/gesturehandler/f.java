package com.swmansion.gesturehandler;

import android.view.MotionEvent;

public class f
{
  public static float a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = 0;
    float f1 = paramMotionEvent.getRawX() - paramMotionEvent.getX();
    int j;
    if (paramMotionEvent.getActionMasked() == 6)
      j = paramMotionEvent.getActionIndex();
    while (paramBoolean)
    {
      float f2 = 0.0F;
      int m = paramMotionEvent.getPointerCount();
      int n = 0;
      while (true)
        if (n < m)
        {
          if (n != j)
          {
            f2 += f1 + paramMotionEvent.getX(n);
            i++;
          }
          n++;
          continue;
          j = -1;
          break;
        }
      return f2 / i;
    }
    int k = -1 + paramMotionEvent.getPointerCount();
    if (k == j)
      k--;
    return f1 + paramMotionEvent.getX(k);
  }

  public static float b(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = 0;
    float f1 = paramMotionEvent.getRawY() - paramMotionEvent.getY();
    int j;
    if (paramMotionEvent.getActionMasked() == 6)
      j = paramMotionEvent.getActionIndex();
    while (paramBoolean)
    {
      float f2 = 0.0F;
      int m = paramMotionEvent.getPointerCount();
      int n = 0;
      while (true)
        if (n < m)
        {
          if (n != j)
          {
            f2 += f1 + paramMotionEvent.getY(n);
            i++;
          }
          n++;
          continue;
          j = -1;
          break;
        }
      return f2 / i;
    }
    int k = -1 + paramMotionEvent.getPointerCount();
    if (k == j)
      k--;
    return f1 + paramMotionEvent.getY(k);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.swmansion.gesturehandler.f
 * JD-Core Version:    0.6.2
 */