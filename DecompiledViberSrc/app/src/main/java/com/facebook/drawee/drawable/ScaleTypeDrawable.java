package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;

public class ScaleTypeDrawable extends ForwardingDrawable
{

  @VisibleForTesting
  Matrix mDrawMatrix;

  @VisibleForTesting
  PointF mFocusPoint = null;

  @VisibleForTesting
  ScalingUtils.ScaleType mScaleType;

  @VisibleForTesting
  Object mScaleTypeState;
  private Matrix mTempMatrix = new Matrix();

  @VisibleForTesting
  int mUnderlyingHeight = 0;

  @VisibleForTesting
  int mUnderlyingWidth = 0;

  public ScaleTypeDrawable(Drawable paramDrawable, ScalingUtils.ScaleType paramScaleType)
  {
    super((Drawable)Preconditions.checkNotNull(paramDrawable));
    this.mScaleType = paramScaleType;
  }

  private void configureBoundsIfUnderlyingChanged()
  {
    int i;
    if ((this.mScaleType instanceof ScalingUtils.StatefulScaleType))
    {
      Object localObject = ((ScalingUtils.StatefulScaleType)this.mScaleType).getState();
      if ((localObject == null) || (!localObject.equals(this.mScaleTypeState)))
      {
        i = 1;
        this.mScaleTypeState = localObject;
      }
    }
    while (true)
    {
      int j;
      if (this.mUnderlyingWidth == getCurrent().getIntrinsicWidth())
      {
        int k = this.mUnderlyingHeight;
        int m = getCurrent().getIntrinsicHeight();
        j = 0;
        if (k == m);
      }
      else
      {
        j = 1;
      }
      if ((j != 0) || (i != 0))
        configureBounds();
      return;
      i = 0;
      break;
      i = 0;
    }
  }

  @VisibleForTesting
  void configureBounds()
  {
    float f1 = 0.5F;
    Drawable localDrawable = getCurrent();
    Rect localRect = getBounds();
    int i = localRect.width();
    int j = localRect.height();
    int k = localDrawable.getIntrinsicWidth();
    this.mUnderlyingWidth = k;
    int m = localDrawable.getIntrinsicHeight();
    this.mUnderlyingHeight = m;
    if ((k <= 0) || (m <= 0))
    {
      localDrawable.setBounds(localRect);
      this.mDrawMatrix = null;
      return;
    }
    if ((k == i) && (m == j))
    {
      localDrawable.setBounds(localRect);
      this.mDrawMatrix = null;
      return;
    }
    if (this.mScaleType == ScalingUtils.ScaleType.FIT_XY)
    {
      localDrawable.setBounds(localRect);
      this.mDrawMatrix = null;
      return;
    }
    localDrawable.setBounds(0, 0, k, m);
    ScalingUtils.ScaleType localScaleType = this.mScaleType;
    Matrix localMatrix = this.mTempMatrix;
    if (this.mFocusPoint != null);
    for (float f2 = this.mFocusPoint.x; ; f2 = f1)
    {
      if (this.mFocusPoint != null)
        f1 = this.mFocusPoint.y;
      localScaleType.getTransform(localMatrix, localRect, k, m, f2, f1);
      this.mDrawMatrix = this.mTempMatrix;
      return;
    }
  }

  public void draw(Canvas paramCanvas)
  {
    configureBoundsIfUnderlyingChanged();
    if (this.mDrawMatrix != null)
    {
      int i = paramCanvas.save();
      paramCanvas.clipRect(getBounds());
      paramCanvas.concat(this.mDrawMatrix);
      super.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      return;
    }
    super.draw(paramCanvas);
  }

  public PointF getFocusPoint()
  {
    return this.mFocusPoint;
  }

  public ScalingUtils.ScaleType getScaleType()
  {
    return this.mScaleType;
  }

  public void getTransform(Matrix paramMatrix)
  {
    getParentTransform(paramMatrix);
    configureBoundsIfUnderlyingChanged();
    if (this.mDrawMatrix != null)
      paramMatrix.preConcat(this.mDrawMatrix);
  }

  protected void onBoundsChange(Rect paramRect)
  {
    configureBounds();
  }

  public Drawable setCurrent(Drawable paramDrawable)
  {
    Drawable localDrawable = super.setCurrent(paramDrawable);
    configureBounds();
    return localDrawable;
  }

  public void setFocusPoint(PointF paramPointF)
  {
    if (Objects.equal(this.mFocusPoint, paramPointF))
      return;
    if (this.mFocusPoint == null)
      this.mFocusPoint = new PointF();
    this.mFocusPoint.set(paramPointF);
    configureBounds();
    invalidateSelf();
  }

  public void setScaleType(ScalingUtils.ScaleType paramScaleType)
  {
    if (Objects.equal(this.mScaleType, paramScaleType))
      return;
    this.mScaleType = paramScaleType;
    this.mScaleTypeState = null;
    configureBounds();
    invalidateSelf();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.drawable.ScaleTypeDrawable
 * JD-Core Version:    0.6.2
 */