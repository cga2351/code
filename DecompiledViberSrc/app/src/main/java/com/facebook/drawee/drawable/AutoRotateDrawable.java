package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;

public class AutoRotateDrawable extends ForwardingDrawable
  implements CloneableDrawable, Runnable
{
  private static final int DEGREES_IN_FULL_ROTATION = 360;
  private static final int FRAME_INTERVAL_MS = 20;
  private boolean mClockwise;
  private int mInterval;
  private boolean mIsScheduled = false;

  @VisibleForTesting
  float mRotationAngle = 0.0F;

  public AutoRotateDrawable(Drawable paramDrawable, int paramInt)
  {
    this(paramDrawable, paramInt, true);
  }

  public AutoRotateDrawable(Drawable paramDrawable, int paramInt, boolean paramBoolean)
  {
    super((Drawable)Preconditions.checkNotNull(paramDrawable));
    this.mInterval = paramInt;
    this.mClockwise = paramBoolean;
  }

  private int getIncrement()
  {
    return (int)(360.0F * (20.0F / this.mInterval));
  }

  private void scheduleNextFrame()
  {
    if (!this.mIsScheduled)
    {
      this.mIsScheduled = true;
      scheduleSelf(this, 20L + SystemClock.uptimeMillis());
    }
  }

  public AutoRotateDrawable cloneDrawable()
  {
    return new AutoRotateDrawable(DrawableUtils.cloneDrawable(getDrawable()), this.mInterval, this.mClockwise);
  }

  public void draw(Canvas paramCanvas)
  {
    int i = paramCanvas.save();
    Rect localRect = getBounds();
    int j = localRect.right - localRect.left;
    int k = localRect.bottom - localRect.top;
    float f = this.mRotationAngle;
    if (!this.mClockwise)
      f = 360.0F - this.mRotationAngle;
    paramCanvas.rotate(f, localRect.left + j / 2, localRect.top + k / 2);
    super.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
    scheduleNextFrame();
  }

  public void reset()
  {
    this.mRotationAngle = 0.0F;
    this.mIsScheduled = false;
    unscheduleSelf(this);
    invalidateSelf();
  }

  public void run()
  {
    this.mIsScheduled = false;
    this.mRotationAngle += getIncrement();
    invalidateSelf();
  }

  public void setClockwise(boolean paramBoolean)
  {
    this.mClockwise = paramBoolean;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.drawable.AutoRotateDrawable
 * JD-Core Version:    0.6.2
 */