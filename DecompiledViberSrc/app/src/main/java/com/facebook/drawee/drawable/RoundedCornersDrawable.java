package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.util.Arrays;
import javax.annotation.Nullable;

public class RoundedCornersDrawable extends ForwardingDrawable
  implements Rounded
{
  private int mBorderColor = 0;
  private final Path mBorderPath = new Path();

  @VisibleForTesting
  final float[] mBorderRadii = new float[8];
  private float mBorderWidth = 0.0F;
  private final RectF mBounds = new RectF();

  @Nullable
  private RectF mInsideBorderBounds;

  @Nullable
  private Matrix mInsideBorderTransform;
  private boolean mIsCircle = false;
  private int mOverlayColor = 0;
  private float mPadding = 0.0F;

  @VisibleForTesting
  final Paint mPaint = new Paint(1);
  private final Path mPath = new Path();
  private final float[] mRadii = new float[8];
  private boolean mScaleDownInsideBorders = false;
  private final RectF mTempRectangle = new RectF();

  @VisibleForTesting
  Type mType = Type.OVERLAY_COLOR;

  public RoundedCornersDrawable(Drawable paramDrawable)
  {
    super((Drawable)Preconditions.checkNotNull(paramDrawable));
  }

  private void updatePath()
  {
    this.mPath.reset();
    this.mBorderPath.reset();
    this.mTempRectangle.set(getBounds());
    this.mTempRectangle.inset(this.mPadding, this.mPadding);
    this.mPath.addRect(this.mTempRectangle, Path.Direction.CW);
    if (this.mIsCircle)
    {
      this.mPath.addCircle(this.mTempRectangle.centerX(), this.mTempRectangle.centerY(), Math.min(this.mTempRectangle.width(), this.mTempRectangle.height()) / 2.0F, Path.Direction.CW);
      this.mTempRectangle.inset(-this.mPadding, -this.mPadding);
      this.mTempRectangle.inset(this.mBorderWidth / 2.0F, this.mBorderWidth / 2.0F);
      if (!this.mIsCircle)
        break label235;
      float f = Math.min(this.mTempRectangle.width(), this.mTempRectangle.height()) / 2.0F;
      this.mBorderPath.addCircle(this.mTempRectangle.centerX(), this.mTempRectangle.centerY(), f, Path.Direction.CW);
    }
    while (true)
    {
      this.mTempRectangle.inset(-this.mBorderWidth / 2.0F, -this.mBorderWidth / 2.0F);
      return;
      this.mPath.addRoundRect(this.mTempRectangle, this.mRadii, Path.Direction.CW);
      break;
      label235: for (int i = 0; i < this.mBorderRadii.length; i++)
        this.mBorderRadii[i] = (this.mRadii[i] + this.mPadding - this.mBorderWidth / 2.0F);
      this.mBorderPath.addRoundRect(this.mTempRectangle, this.mBorderRadii, Path.Direction.CW);
    }
  }

  public void draw(Canvas paramCanvas)
  {
    this.mBounds.set(getBounds());
    switch (1.$SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type[this.mType.ordinal()])
    {
    default:
    case 1:
      while (true)
      {
        if (this.mBorderColor != 0)
        {
          this.mPaint.setStyle(Paint.Style.STROKE);
          this.mPaint.setColor(this.mBorderColor);
          this.mPaint.setStrokeWidth(this.mBorderWidth);
          this.mPath.setFillType(Path.FillType.EVEN_ODD);
          paramCanvas.drawPath(this.mBorderPath, this.mPaint);
        }
        return;
        int j = paramCanvas.save();
        this.mPath.setFillType(Path.FillType.EVEN_ODD);
        paramCanvas.clipPath(this.mPath);
        super.draw(paramCanvas);
        paramCanvas.restoreToCount(j);
      }
    case 2:
    }
    if (this.mScaleDownInsideBorders)
      if (this.mInsideBorderBounds == null)
      {
        this.mInsideBorderBounds = new RectF(this.mBounds);
        this.mInsideBorderTransform = new Matrix();
        label185: this.mInsideBorderBounds.inset(this.mBorderWidth, this.mBorderWidth);
        this.mInsideBorderTransform.setRectToRect(this.mBounds, this.mInsideBorderBounds, Matrix.ScaleToFit.FILL);
        int i = paramCanvas.save();
        paramCanvas.clipRect(this.mBounds);
        paramCanvas.concat(this.mInsideBorderTransform);
        super.draw(paramCanvas);
        paramCanvas.restoreToCount(i);
      }
    while (true)
    {
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPaint.setColor(this.mOverlayColor);
      this.mPaint.setStrokeWidth(0.0F);
      this.mPath.setFillType(Path.FillType.EVEN_ODD);
      paramCanvas.drawPath(this.mPath, this.mPaint);
      if (!this.mIsCircle)
        break;
      float f1 = (this.mBounds.width() - this.mBounds.height() + this.mBorderWidth) / 2.0F;
      float f2 = (this.mBounds.height() - this.mBounds.width() + this.mBorderWidth) / 2.0F;
      if (f1 > 0.0F)
      {
        paramCanvas.drawRect(this.mBounds.left, this.mBounds.top, f1 + this.mBounds.left, this.mBounds.bottom, this.mPaint);
        paramCanvas.drawRect(this.mBounds.right - f1, this.mBounds.top, this.mBounds.right, this.mBounds.bottom, this.mPaint);
      }
      if (f2 <= 0.0F)
        break;
      paramCanvas.drawRect(this.mBounds.left, this.mBounds.top, this.mBounds.right, f2 + this.mBounds.top, this.mPaint);
      paramCanvas.drawRect(this.mBounds.left, this.mBounds.bottom - f2, this.mBounds.right, this.mBounds.bottom, this.mPaint);
      break;
      this.mInsideBorderBounds.set(this.mBounds);
      break label185;
      super.draw(paramCanvas);
    }
  }

  public int getBorderColor()
  {
    return this.mBorderColor;
  }

  public float getBorderWidth()
  {
    return this.mBorderWidth;
  }

  public int getOverlayColor()
  {
    return this.mOverlayColor;
  }

  public float getPadding()
  {
    return this.mPadding;
  }

  public float[] getRadii()
  {
    return this.mRadii;
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
    super.onBoundsChange(paramRect);
    updatePath();
  }

  public void setBorder(int paramInt, float paramFloat)
  {
    this.mBorderColor = paramInt;
    this.mBorderWidth = paramFloat;
    updatePath();
    invalidateSelf();
  }

  public void setCircle(boolean paramBoolean)
  {
    this.mIsCircle = paramBoolean;
    updatePath();
    invalidateSelf();
  }

  public void setOverlayColor(int paramInt)
  {
    this.mOverlayColor = paramInt;
    invalidateSelf();
  }

  public void setPadding(float paramFloat)
  {
    this.mPadding = paramFloat;
    updatePath();
    invalidateSelf();
  }

  public void setRadii(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
    {
      Arrays.fill(this.mRadii, 0.0F);
      updatePath();
      invalidateSelf();
      return;
    }
    if (paramArrayOfFloat.length == 8);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "radii should have exactly 8 values");
      System.arraycopy(paramArrayOfFloat, 0, this.mRadii, 0, 8);
      break;
    }
  }

  public void setRadius(float paramFloat)
  {
    Arrays.fill(this.mRadii, paramFloat);
    updatePath();
    invalidateSelf();
  }

  public void setScaleDownInsideBorders(boolean paramBoolean)
  {
    this.mScaleDownInsideBorders = paramBoolean;
    updatePath();
    invalidateSelf();
  }

  public void setType(Type paramType)
  {
    this.mType = paramType;
    invalidateSelf();
  }

  public static enum Type
  {
    static
    {
      CLIPPING = new Type("CLIPPING", 1);
      Type[] arrayOfType = new Type[2];
      arrayOfType[0] = OVERLAY_COLOR;
      arrayOfType[1] = CLIPPING;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.drawable.RoundedCornersDrawable
 * JD-Core Version:    0.6.2
 */