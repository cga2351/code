package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.graphics.ColorUtils;

public class CircularBorderDrawable extends Drawable
{
  private static final float DRAW_STROKE_WIDTH_MULTIPLE = 1.3333F;
  private ColorStateList borderTint;
  float borderWidth;
  private int bottomInnerStrokeColor;
  private int bottomOuterStrokeColor;
  private int currentBorderTintColor;
  private boolean invalidateShader = true;
  final Paint paint = new Paint(1);
  final Rect rect = new Rect();
  final RectF rectF = new RectF();
  private float rotation;
  final CircularBorderState state = new CircularBorderState(null);
  private int topInnerStrokeColor;
  private int topOuterStrokeColor;

  public CircularBorderDrawable()
  {
    this.paint.setStyle(Paint.Style.STROKE);
  }

  private Shader createGradientShader()
  {
    Rect localRect = this.rect;
    copyBounds(localRect);
    float f = this.borderWidth / localRect.height();
    int[] arrayOfInt = new int[6];
    arrayOfInt[0] = ColorUtils.compositeColors(this.topOuterStrokeColor, this.currentBorderTintColor);
    arrayOfInt[1] = ColorUtils.compositeColors(this.topInnerStrokeColor, this.currentBorderTintColor);
    arrayOfInt[2] = ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.topInnerStrokeColor, 0), this.currentBorderTintColor);
    arrayOfInt[3] = ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.bottomInnerStrokeColor, 0), this.currentBorderTintColor);
    arrayOfInt[4] = ColorUtils.compositeColors(this.bottomInnerStrokeColor, this.currentBorderTintColor);
    arrayOfInt[5] = ColorUtils.compositeColors(this.bottomOuterStrokeColor, this.currentBorderTintColor);
    float[] arrayOfFloat = new float[6];
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = f;
    arrayOfFloat[2] = 0.5F;
    arrayOfFloat[3] = 0.5F;
    arrayOfFloat[4] = (1.0F - f);
    arrayOfFloat[5] = 1.0F;
    return new LinearGradient(0.0F, localRect.top, 0.0F, localRect.bottom, arrayOfInt, arrayOfFloat, Shader.TileMode.CLAMP);
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.invalidateShader)
    {
      this.paint.setShader(createGradientShader());
      this.invalidateShader = false;
    }
    float f = this.paint.getStrokeWidth() / 2.0F;
    RectF localRectF = this.rectF;
    copyBounds(this.rect);
    localRectF.set(this.rect);
    localRectF.left = (f + localRectF.left);
    localRectF.top = (f + localRectF.top);
    localRectF.right -= f;
    localRectF.bottom -= f;
    paramCanvas.save();
    paramCanvas.rotate(this.rotation, localRectF.centerX(), localRectF.centerY());
    paramCanvas.drawOval(localRectF, this.paint);
    paramCanvas.restore();
  }

  public Drawable.ConstantState getConstantState()
  {
    return this.state;
  }

  public int getOpacity()
  {
    if (this.borderWidth > 0.0F)
      return -3;
    return -2;
  }

  public boolean getPadding(Rect paramRect)
  {
    int i = Math.round(this.borderWidth);
    paramRect.set(i, i, i, i);
    return true;
  }

  public boolean isStateful()
  {
    return ((this.borderTint != null) && (this.borderTint.isStateful())) || (super.isStateful());
  }

  protected void onBoundsChange(Rect paramRect)
  {
    this.invalidateShader = true;
  }

  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.borderTint != null)
    {
      int i = this.borderTint.getColorForState(paramArrayOfInt, this.currentBorderTintColor);
      if (i != this.currentBorderTintColor)
      {
        this.invalidateShader = true;
        this.currentBorderTintColor = i;
      }
    }
    if (this.invalidateShader)
      invalidateSelf();
    return this.invalidateShader;
  }

  public void setAlpha(int paramInt)
  {
    this.paint.setAlpha(paramInt);
    invalidateSelf();
  }

  public void setBorderTint(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
      this.currentBorderTintColor = paramColorStateList.getColorForState(getState(), this.currentBorderTintColor);
    this.borderTint = paramColorStateList;
    this.invalidateShader = true;
    invalidateSelf();
  }

  public void setBorderWidth(float paramFloat)
  {
    if (this.borderWidth != paramFloat)
    {
      this.borderWidth = paramFloat;
      this.paint.setStrokeWidth(1.3333F * paramFloat);
      this.invalidateShader = true;
      invalidateSelf();
    }
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.paint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }

  public void setGradientColors(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.topOuterStrokeColor = paramInt1;
    this.topInnerStrokeColor = paramInt2;
    this.bottomOuterStrokeColor = paramInt3;
    this.bottomInnerStrokeColor = paramInt4;
  }

  public final void setRotation(float paramFloat)
  {
    if (paramFloat != this.rotation)
    {
      this.rotation = paramFloat;
      invalidateSelf();
    }
  }

  private class CircularBorderState extends Drawable.ConstantState
  {
    private CircularBorderState()
    {
    }

    public int getChangingConfigurations()
    {
      return 0;
    }

    public Drawable newDrawable()
    {
      return CircularBorderDrawable.this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.CircularBorderDrawable
 * JD-Core Version:    0.6.2
 */