package com.facebook.react.views.scroll;

import android.os.SystemClock;

public class OnScrollDispatchHelper
{
  private static final int MIN_EVENT_SEPARATION_MS = 10;
  private long mLastScrollEventTimeMs = -11L;
  private int mPrevX = -2147483648;
  private int mPrevY = -2147483648;
  private float mXFlingVelocity = 0.0F;
  private float mYFlingVelocity = 0.0F;

  public float getXFlingVelocity()
  {
    return this.mXFlingVelocity;
  }

  public float getYFlingVelocity()
  {
    return this.mYFlingVelocity;
  }

  public boolean onScrollChanged(int paramInt1, int paramInt2)
  {
    long l = SystemClock.uptimeMillis();
    if ((l - this.mLastScrollEventTimeMs > 10L) || (this.mPrevX != paramInt1) || (this.mPrevY != paramInt2));
    for (boolean bool = true; ; bool = false)
    {
      if (l - this.mLastScrollEventTimeMs != 0L)
      {
        this.mXFlingVelocity = ((paramInt1 - this.mPrevX) / (float)(l - this.mLastScrollEventTimeMs));
        this.mYFlingVelocity = ((paramInt2 - this.mPrevY) / (float)(l - this.mLastScrollEventTimeMs));
      }
      this.mLastScrollEventTimeMs = l;
      this.mPrevX = paramInt1;
      this.mPrevY = paramInt2;
      return bool;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.scroll.OnScrollDispatchHelper
 * JD-Core Version:    0.6.2
 */