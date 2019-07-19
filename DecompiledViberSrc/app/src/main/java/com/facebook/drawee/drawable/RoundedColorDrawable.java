package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.util.Arrays;
import javax.annotation.Nullable;

public class RoundedColorDrawable extends Drawable
  implements Rounded
{
  private int mAlpha = 255;
  private int mBorderColor = 0;

  @VisibleForTesting
  final Path mBorderPath = new Path();

  @VisibleForTesting
  final float[] mBorderRadii = new float[8];
  private float mBorderWidth = 0.0F;
  private int mColor = 0;

  @Nullable
  @VisibleForTesting
  float[] mInsideBorderRadii;
  private boolean mIsCircle = false;
  private float mPadding = 0.0F;

  @VisibleForTesting
  final Paint mPaint = new Paint(1);

  @VisibleForTesting
  final Path mPath = new Path();
  private final float[] mRadii = new float[8];
  private boolean mScaleDownInsideBorders = false;
  private final RectF mTempRect = new RectF();

  public RoundedColorDrawable(float paramFloat, int paramInt)
  {
    this(paramInt);
    setRadius(paramFloat);
  }

  public RoundedColorDrawable(int paramInt)
  {
    setColor(paramInt);
  }

  public RoundedColorDrawable(float[] paramArrayOfFloat, int paramInt)
  {
    this(paramInt);
    setRadii(paramArrayOfFloat);
  }

  @TargetApi(11)
  public static RoundedColorDrawable fromColorDrawable(ColorDrawable paramColorDrawable)
  {
    return new RoundedColorDrawable(paramColorDrawable.getColor());
  }

  private void updatePath()
  {
    this.mPath.reset();
    this.mBorderPath.reset();
    this.mTempRect.set(getBounds());
    this.mTempRect.inset(this.mBorderWidth / 2.0F, this.mBorderWidth / 2.0F);
    float f2;
    label136: float f3;
    if (this.mIsCircle)
    {
      float f5 = Math.min(this.mTempRect.width(), this.mTempRect.height()) / 2.0F;
      this.mBorderPath.addCircle(this.mTempRect.centerX(), this.mTempRect.centerY(), f5, Path.Direction.CW);
      this.mTempRect.inset(-this.mBorderWidth / 2.0F, -this.mBorderWidth / 2.0F);
      float f1 = this.mPadding;
      if (!this.mScaleDownInsideBorders)
        break label282;
      f2 = this.mBorderWidth;
      f3 = f2 + f1;
      this.mTempRect.inset(f3, f3);
      if (!this.mIsCircle)
        break label287;
      float f4 = Math.min(this.mTempRect.width(), this.mTempRect.height()) / 2.0F;
      this.mPath.addCircle(this.mTempRect.centerX(), this.mTempRect.centerY(), f4, Path.Direction.CW);
    }
    while (true)
    {
      this.mTempRect.inset(-f3, -f3);
      return;
      for (int i = 0; i < this.mBorderRadii.length; i++)
        this.mBorderRadii[i] = (this.mRadii[i] + this.mPadding - this.mBorderWidth / 2.0F);
      this.mBorderPath.addRoundRect(this.mTempRect, this.mBorderRadii, Path.Direction.CW);
      break;
      label282: f2 = 0.0F;
      break label136;
      label287: if (this.mScaleDownInsideBorders)
      {
        float[] arrayOfFloat = this.mInsideBorderRadii;
        int j = 0;
        if (arrayOfFloat == null)
          this.mInsideBorderRadii = new float[8];
        while (j < this.mInsideBorderRadii.length)
        {
          this.mInsideBorderRadii[j] = (this.mRadii[j] - this.mBorderWidth);
          j++;
        }
        this.mPath.addRoundRect(this.mTempRect, this.mInsideBorderRadii, Path.Direction.CW);
      }
      else
      {
        this.mPath.addRoundRect(this.mTempRect, this.mRadii, Path.Direction.CW);
      }
    }
  }

  public void draw(Canvas paramCanvas)
  {
    this.mPaint.setColor(DrawableUtils.multiplyColorAlpha(this.mColor, this.mAlpha));
    this.mPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawPath(this.mPath, this.mPaint);
    if (this.mBorderWidth != 0.0F)
    {
      this.mPaint.setColor(DrawableUtils.multiplyColorAlpha(this.mBorderColor, this.mAlpha));
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setStrokeWidth(this.mBorderWidth);
      paramCanvas.drawPath(this.mBorderPath, this.mPaint);
    }
  }

  public int getAlpha()
  {
    return this.mAlpha;
  }

  public int getBorderColor()
  {
    return this.mBorderColor;
  }

  public float getBorderWidth()
  {
    return this.mBorderWidth;
  }

  public int getColor()
  {
    return this.mColor;
  }

  public int getOpacity()
  {
    return DrawableUtils.getOpacityFromColor(DrawableUtils.multiplyColorAlpha(this.mColor, this.mAlpha));
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

  public void setAlpha(int paramInt)
  {
    if (paramInt != this.mAlpha)
    {
      this.mAlpha = paramInt;
      invalidateSelf();
    }
  }

  public void setBorder(int paramInt, float paramFloat)
  {
    if (this.mBorderColor != paramInt)
    {
      this.mBorderColor = paramInt;
      invalidateSelf();
    }
    if (this.mBorderWidth != paramFloat)
    {
      this.mBorderWidth = paramFloat;
      updatePath();
      invalidateSelf();
    }
  }

  public void setCircle(boolean paramBoolean)
  {
    this.mIsCircle = paramBoolean;
    updatePath();
    invalidateSelf();
  }

  public void setColor(int paramInt)
  {
    if (this.mColor != paramInt)
    {
      this.mColor = paramInt;
      invalidateSelf();
    }
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
  }

  public void setPadding(float paramFloat)
  {
    if (this.mPadding != paramFloat)
    {
      this.mPadding = paramFloat;
      updatePath();
      invalidateSelf();
    }
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
    if (paramFloat >= 0.0F);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "radius should be non negative");
      Arrays.fill(this.mRadii, paramFloat);
      updatePath();
      invalidateSelf();
      return;
    }
  }

  public void setScaleDownInsideBorders(boolean paramBoolean)
  {
    if (this.mScaleDownInsideBorders != paramBoolean)
    {
      this.mScaleDownInsideBorders = paramBoolean;
      updatePath();
      invalidateSelf();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.drawable.RoundedColorDrawable
 * JD-Core Version:    0.6.2
 */