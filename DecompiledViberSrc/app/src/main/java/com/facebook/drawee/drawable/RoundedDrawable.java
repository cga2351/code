package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.util.Arrays;

public abstract class RoundedDrawable extends Drawable
  implements Rounded, TransformAwareDrawable
{

  @VisibleForTesting
  final RectF mBitmapBounds = new RectF();
  protected int mBorderColor = 0;
  protected final Path mBorderPath = new Path();

  @VisibleForTesting
  final float[] mBorderRadii = new float[8];
  protected float mBorderWidth = 0.0F;

  @VisibleForTesting
  final Matrix mBoundsTransform = new Matrix();
  private final float[] mCornerRadii = new float[8];
  private final Drawable mDelegate;

  @VisibleForTesting
  final RectF mDrawableBounds = new RectF();

  @VisibleForTesting
  RectF mInsideBorderBounds;

  @VisibleForTesting
  float[] mInsideBorderRadii;

  @VisibleForTesting
  Matrix mInsideBorderTransform;

  @VisibleForTesting
  final Matrix mInverseParentTransform = new Matrix();
  protected boolean mIsCircle = false;
  private boolean mIsPathDirty = true;
  protected boolean mIsShaderTransformDirty = true;
  private float mPadding = 0.0F;

  @VisibleForTesting
  final Matrix mParentTransform = new Matrix();
  protected final Path mPath = new Path();

  @VisibleForTesting
  final Matrix mPrevBoundsTransform = new Matrix();

  @VisibleForTesting
  Matrix mPrevInsideBorderTransform;

  @VisibleForTesting
  final Matrix mPrevParentTransform = new Matrix();

  @VisibleForTesting
  final RectF mPrevRootBounds = new RectF();
  protected boolean mRadiiNonZero = false;

  @VisibleForTesting
  final RectF mRootBounds = new RectF();
  private boolean mScaleDownInsideBorders = false;

  @VisibleForTesting
  final Matrix mTransform = new Matrix();
  private TransformCallback mTransformCallback;

  RoundedDrawable(Drawable paramDrawable)
  {
    this.mDelegate = paramDrawable;
  }

  public void clearColorFilter()
  {
    this.mDelegate.clearColorFilter();
  }

  public void draw(Canvas paramCanvas)
  {
    this.mDelegate.draw(paramCanvas);
  }

  public int getAlpha()
  {
    return this.mDelegate.getAlpha();
  }

  public int getBorderColor()
  {
    return this.mBorderColor;
  }

  public float getBorderWidth()
  {
    return this.mBorderWidth;
  }

  public ColorFilter getColorFilter()
  {
    return this.mDelegate.getColorFilter();
  }

  public int getIntrinsicHeight()
  {
    return this.mDelegate.getIntrinsicHeight();
  }

  public int getIntrinsicWidth()
  {
    return this.mDelegate.getIntrinsicWidth();
  }

  public int getOpacity()
  {
    return this.mDelegate.getOpacity();
  }

  public float getPadding()
  {
    return this.mPadding;
  }

  public float[] getRadii()
  {
    return this.mCornerRadii;
  }

  public boolean getScaleDownInsideBorders()
  {
    return this.mScaleDownInsideBorders;
  }

  public boolean isCircle()
  {
    return this.mIsCircle;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    this.mDelegate.setBounds(paramRect);
  }

  public void setAlpha(int paramInt)
  {
    this.mDelegate.setAlpha(paramInt);
  }

  public void setBorder(int paramInt, float paramFloat)
  {
    if ((this.mBorderColor != paramInt) || (this.mBorderWidth != paramFloat))
    {
      this.mBorderColor = paramInt;
      this.mBorderWidth = paramFloat;
      this.mIsPathDirty = true;
      invalidateSelf();
    }
  }

  public void setCircle(boolean paramBoolean)
  {
    this.mIsCircle = paramBoolean;
    this.mIsPathDirty = true;
    invalidateSelf();
  }

  public void setColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    this.mDelegate.setColorFilter(paramInt, paramMode);
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mDelegate.setColorFilter(paramColorFilter);
  }

  public void setPadding(float paramFloat)
  {
    if (this.mPadding != paramFloat)
    {
      this.mPadding = paramFloat;
      this.mIsPathDirty = true;
      invalidateSelf();
    }
  }

  public void setRadii(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
    {
      Arrays.fill(this.mCornerRadii, 0.0F);
      this.mRadiiNonZero = false;
      this.mIsPathDirty = true;
      invalidateSelf();
      return;
    }
    boolean bool1;
    label36: int i;
    label61: boolean bool2;
    if (paramArrayOfFloat.length == 8)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1, "radii should have exactly 8 values");
      System.arraycopy(paramArrayOfFloat, 0, this.mCornerRadii, 0, 8);
      this.mRadiiNonZero = false;
      i = 0;
      if (i < 8)
      {
        bool2 = this.mRadiiNonZero;
        if (paramArrayOfFloat[i] <= 0.0F)
          break label104;
      }
    }
    label104: for (boolean bool3 = true; ; bool3 = false)
    {
      this.mRadiiNonZero = (bool3 | bool2);
      i++;
      break label61;
      break;
      bool1 = false;
      break label36;
    }
  }

  public void setRadius(float paramFloat)
  {
    if (paramFloat >= 0.0F);
    for (boolean bool1 = true; ; bool1 = false)
    {
      Preconditions.checkState(bool1);
      Arrays.fill(this.mCornerRadii, paramFloat);
      boolean bool2 = paramFloat < 0.0F;
      boolean bool3 = false;
      if (bool2)
        bool3 = true;
      this.mRadiiNonZero = bool3;
      this.mIsPathDirty = true;
      invalidateSelf();
      return;
    }
  }

  public void setScaleDownInsideBorders(boolean paramBoolean)
  {
    if (this.mScaleDownInsideBorders != paramBoolean)
    {
      this.mScaleDownInsideBorders = paramBoolean;
      this.mIsPathDirty = true;
      invalidateSelf();
    }
  }

  public void setTransformCallback(TransformCallback paramTransformCallback)
  {
    this.mTransformCallback = paramTransformCallback;
  }

  @VisibleForTesting
  boolean shouldRound()
  {
    return (this.mIsCircle) || (this.mRadiiNonZero) || (this.mBorderWidth > 0.0F);
  }

  protected void updatePath()
  {
    float f2;
    label132: float f3;
    if (this.mIsPathDirty)
    {
      this.mBorderPath.reset();
      this.mRootBounds.inset(this.mBorderWidth / 2.0F, this.mBorderWidth / 2.0F);
      if (!this.mIsCircle)
        break label227;
      float f4 = Math.min(this.mRootBounds.width(), this.mRootBounds.height()) / 2.0F;
      this.mBorderPath.addCircle(this.mRootBounds.centerX(), this.mRootBounds.centerY(), f4, Path.Direction.CW);
      this.mRootBounds.inset(-this.mBorderWidth / 2.0F, -this.mBorderWidth / 2.0F);
      this.mPath.reset();
      float f1 = this.mPadding;
      if (!this.mScaleDownInsideBorders)
        break label289;
      f2 = this.mBorderWidth;
      f3 = f1 + f2;
      this.mRootBounds.inset(f3, f3);
      if (!this.mIsCircle)
        break label294;
      this.mPath.addCircle(this.mRootBounds.centerX(), this.mRootBounds.centerY(), Math.min(this.mRootBounds.width(), this.mRootBounds.height()) / 2.0F, Path.Direction.CW);
    }
    while (true)
    {
      this.mRootBounds.inset(-f3, -f3);
      this.mPath.setFillType(Path.FillType.WINDING);
      this.mIsPathDirty = false;
      return;
      label227: for (int i = 0; i < this.mBorderRadii.length; i++)
        this.mBorderRadii[i] = (this.mCornerRadii[i] + this.mPadding - this.mBorderWidth / 2.0F);
      this.mBorderPath.addRoundRect(this.mRootBounds, this.mBorderRadii, Path.Direction.CW);
      break;
      label289: f2 = 0.0F;
      break label132;
      label294: if (this.mScaleDownInsideBorders)
      {
        if (this.mInsideBorderRadii == null)
          this.mInsideBorderRadii = new float[8];
        for (int j = 0; j < this.mBorderRadii.length; j++)
          this.mInsideBorderRadii[j] = (this.mCornerRadii[j] - this.mBorderWidth);
        this.mPath.addRoundRect(this.mRootBounds, this.mInsideBorderRadii, Path.Direction.CW);
      }
      else
      {
        this.mPath.addRoundRect(this.mRootBounds, this.mCornerRadii, Path.Direction.CW);
      }
    }
  }

  protected void updateTransform()
  {
    if (this.mTransformCallback != null)
    {
      this.mTransformCallback.getTransform(this.mParentTransform);
      this.mTransformCallback.getRootBounds(this.mRootBounds);
      this.mBitmapBounds.set(0.0F, 0.0F, getIntrinsicWidth(), getIntrinsicHeight());
      this.mDrawableBounds.set(this.mDelegate.getBounds());
      this.mBoundsTransform.setRectToRect(this.mBitmapBounds, this.mDrawableBounds, Matrix.ScaleToFit.FILL);
      if (!this.mScaleDownInsideBorders)
        break label391;
      if (this.mInsideBorderBounds != null)
        break label377;
      this.mInsideBorderBounds = new RectF(this.mRootBounds);
      label114: this.mInsideBorderBounds.inset(this.mBorderWidth, this.mBorderWidth);
      if (this.mInsideBorderTransform == null)
        this.mInsideBorderTransform = new Matrix();
      this.mInsideBorderTransform.setRectToRect(this.mRootBounds, this.mInsideBorderBounds, Matrix.ScaleToFit.FILL);
      label166: if ((!this.mParentTransform.equals(this.mPrevParentTransform)) || (!this.mBoundsTransform.equals(this.mPrevBoundsTransform)) || ((this.mInsideBorderTransform != null) && (!this.mInsideBorderTransform.equals(this.mPrevInsideBorderTransform))))
      {
        this.mIsShaderTransformDirty = true;
        this.mParentTransform.invert(this.mInverseParentTransform);
        this.mTransform.set(this.mParentTransform);
        if (this.mScaleDownInsideBorders)
          this.mTransform.postConcat(this.mInsideBorderTransform);
        this.mTransform.preConcat(this.mBoundsTransform);
        this.mPrevParentTransform.set(this.mParentTransform);
        this.mPrevBoundsTransform.set(this.mBoundsTransform);
        if (!this.mScaleDownInsideBorders)
          break label422;
        if (this.mPrevInsideBorderTransform != null)
          break label408;
        this.mPrevInsideBorderTransform = new Matrix(this.mInsideBorderTransform);
      }
    }
    while (true)
    {
      if (!this.mRootBounds.equals(this.mPrevRootBounds))
      {
        this.mIsPathDirty = true;
        this.mPrevRootBounds.set(this.mRootBounds);
      }
      return;
      this.mParentTransform.reset();
      this.mRootBounds.set(getBounds());
      break;
      label377: this.mInsideBorderBounds.set(this.mRootBounds);
      break label114;
      label391: if (this.mInsideBorderTransform == null)
        break label166;
      this.mInsideBorderTransform.reset();
      break label166;
      label408: this.mPrevInsideBorderTransform.set(this.mInsideBorderTransform);
      continue;
      label422: if (this.mPrevInsideBorderTransform != null)
        this.mPrevInsideBorderTransform.reset();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.drawable.RoundedDrawable
 * JD-Core Version:    0.6.2
 */