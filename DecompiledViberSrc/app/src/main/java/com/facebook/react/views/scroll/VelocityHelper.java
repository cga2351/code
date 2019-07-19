package com.facebook.react.views.scroll;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import javax.annotation.Nullable;

public class VelocityHelper
{

  @Nullable
  private VelocityTracker mVelocityTracker;
  private float mXVelocity;
  private float mYVelocity;

  public void calculateVelocity(MotionEvent paramMotionEvent)
  {
    int i = 0xFF & paramMotionEvent.getAction();
    if (this.mVelocityTracker == null)
      this.mVelocityTracker = VelocityTracker.obtain();
    this.mVelocityTracker.addMovement(paramMotionEvent);
    switch (i)
    {
    case 2:
    default:
    case 1:
    case 3:
    }
    do
    {
      return;
      this.mVelocityTracker.computeCurrentVelocity(1);
      this.mXVelocity = this.mVelocityTracker.getXVelocity();
      this.mYVelocity = this.mVelocityTracker.getYVelocity();
    }
    while (this.mVelocityTracker == null);
    this.mVelocityTracker.recycle();
    this.mVelocityTracker = null;
  }

  public float getXVelocity()
  {
    return this.mXVelocity;
  }

  public float getYVelocity()
  {
    return this.mYVelocity;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.scroll.VelocityHelper
 * JD-Core Version:    0.6.2
 */