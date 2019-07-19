package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;

public class OrientedDrawable extends ForwardingDrawable
{
  private int mExifOrientation;
  private int mRotationAngle;

  @VisibleForTesting
  final Matrix mRotationMatrix;
  private final Matrix mTempMatrix = new Matrix();
  private final RectF mTempRectF = new RectF();

  public OrientedDrawable(Drawable paramDrawable, int paramInt)
  {
    this(paramDrawable, paramInt, 0);
  }

  public OrientedDrawable(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    super(paramDrawable);
    boolean bool2;
    if (paramInt1 % 90 == 0)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2);
      if ((paramInt2 < 0) || (paramInt2 > 8))
        break label89;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1);
      this.mRotationMatrix = new Matrix();
      this.mRotationAngle = paramInt1;
      this.mExifOrientation = paramInt2;
      return;
      bool2 = false;
      break;
      label89: bool1 = false;
    }
  }

  public void draw(Canvas paramCanvas)
  {
    if ((this.mRotationAngle <= 0) && ((this.mExifOrientation == 0) || (this.mExifOrientation == 1)))
    {
      super.draw(paramCanvas);
      return;
    }
    int i = paramCanvas.save();
    paramCanvas.concat(this.mRotationMatrix);
    super.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }

  public int getIntrinsicHeight()
  {
    if ((this.mExifOrientation == 5) || (this.mExifOrientation == 7) || (this.mRotationAngle % 180 != 0))
      return super.getIntrinsicWidth();
    return super.getIntrinsicHeight();
  }

  public int getIntrinsicWidth()
  {
    if ((this.mExifOrientation == 5) || (this.mExifOrientation == 7) || (this.mRotationAngle % 180 != 0))
      return super.getIntrinsicHeight();
    return super.getIntrinsicWidth();
  }

  public void getTransform(Matrix paramMatrix)
  {
    getParentTransform(paramMatrix);
    if (!this.mRotationMatrix.isIdentity())
      paramMatrix.preConcat(this.mRotationMatrix);
  }

  protected void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = getCurrent();
    if ((this.mRotationAngle > 0) || ((this.mExifOrientation != 0) && (this.mExifOrientation != 1)))
    {
      switch (this.mExifOrientation)
      {
      case 3:
      case 6:
      default:
        this.mRotationMatrix.setRotate(this.mRotationAngle, paramRect.centerX(), paramRect.centerY());
      case 2:
      case 4:
      case 5:
      case 7:
      }
      while (true)
      {
        this.mTempMatrix.reset();
        this.mRotationMatrix.invert(this.mTempMatrix);
        this.mTempRectF.set(paramRect);
        this.mTempMatrix.mapRect(this.mTempRectF);
        localDrawable.setBounds((int)this.mTempRectF.left, (int)this.mTempRectF.top, (int)this.mTempRectF.right, (int)this.mTempRectF.bottom);
        return;
        this.mRotationMatrix.setScale(-1.0F, 1.0F);
        continue;
        this.mRotationMatrix.setScale(1.0F, -1.0F);
        continue;
        this.mRotationMatrix.setRotate(270.0F, paramRect.centerX(), paramRect.centerY());
        this.mRotationMatrix.postScale(1.0F, -1.0F);
        continue;
        this.mRotationMatrix.setRotate(270.0F, paramRect.centerX(), paramRect.centerY());
        this.mRotationMatrix.postScale(-1.0F, 1.0F);
      }
    }
    localDrawable.setBounds(paramRect);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.drawable.OrientedDrawable
 * JD-Core Version:    0.6.2
 */