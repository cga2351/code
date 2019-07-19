package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.design.R.color;
import android.support.v4.content.ContextCompat;
import android.support.v7.b.a.c;

public class ShadowDrawableWrapper extends c
{
  static final double COS_45 = 0.0D;
  static final float SHADOW_BOTTOM_SCALE = 1.0F;
  static final float SHADOW_HORIZ_SCALE = 0.5F;
  static final float SHADOW_MULTIPLIER = 1.5F;
  static final float SHADOW_TOP_SCALE = 0.25F;
  private boolean addPaddingForCorners = true;
  final RectF contentBounds;
  float cornerRadius;
  final Paint cornerShadowPaint;
  Path cornerShadowPath;
  private boolean dirty = true;
  final Paint edgeShadowPaint;
  float maxShadowSize;
  private boolean printedShadowClipWarning = false;
  float rawMaxShadowSize;
  float rawShadowSize;
  private float rotation;
  private final int shadowEndColor;
  private final int shadowMiddleColor;
  float shadowSize;
  private final int shadowStartColor;

  public ShadowDrawableWrapper(Context paramContext, Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramDrawable);
    this.shadowStartColor = ContextCompat.getColor(paramContext, R.color.design_fab_shadow_start_color);
    this.shadowMiddleColor = ContextCompat.getColor(paramContext, R.color.design_fab_shadow_mid_color);
    this.shadowEndColor = ContextCompat.getColor(paramContext, R.color.design_fab_shadow_end_color);
    this.cornerShadowPaint = new Paint(5);
    this.cornerShadowPaint.setStyle(Paint.Style.FILL);
    this.cornerRadius = Math.round(paramFloat1);
    this.contentBounds = new RectF();
    this.edgeShadowPaint = new Paint(this.cornerShadowPaint);
    this.edgeShadowPaint.setAntiAlias(false);
    setShadowSize(paramFloat2, paramFloat3);
  }

  private void buildComponents(Rect paramRect)
  {
    float f = 1.5F * this.rawMaxShadowSize;
    this.contentBounds.set(paramRect.left + this.rawMaxShadowSize, f + paramRect.top, paramRect.right - this.rawMaxShadowSize, paramRect.bottom - f);
    getWrappedDrawable().setBounds((int)this.contentBounds.left, (int)this.contentBounds.top, (int)this.contentBounds.right, (int)this.contentBounds.bottom);
    buildShadowCorners();
  }

  private void buildShadowCorners()
  {
    RectF localRectF1 = new RectF(-this.cornerRadius, -this.cornerRadius, this.cornerRadius, this.cornerRadius);
    RectF localRectF2 = new RectF(localRectF1);
    localRectF2.inset(-this.shadowSize, -this.shadowSize);
    if (this.cornerShadowPath == null)
      this.cornerShadowPath = new Path();
    while (true)
    {
      this.cornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
      this.cornerShadowPath.moveTo(-this.cornerRadius, 0.0F);
      this.cornerShadowPath.rLineTo(-this.shadowSize, 0.0F);
      this.cornerShadowPath.arcTo(localRectF2, 180.0F, 90.0F, false);
      this.cornerShadowPath.arcTo(localRectF1, 270.0F, -90.0F, false);
      this.cornerShadowPath.close();
      float f1 = -localRectF2.top;
      if (f1 > 0.0F)
      {
        float f4 = this.cornerRadius / f1;
        float f5 = f4 + (1.0F - f4) / 2.0F;
        Paint localPaint2 = this.cornerShadowPaint;
        int[] arrayOfInt2 = new int[4];
        arrayOfInt2[0] = 0;
        arrayOfInt2[1] = this.shadowStartColor;
        arrayOfInt2[2] = this.shadowMiddleColor;
        arrayOfInt2[3] = this.shadowEndColor;
        localPaint2.setShader(new RadialGradient(0.0F, 0.0F, f1, arrayOfInt2, new float[] { 0.0F, f4, f5, 1.0F }, Shader.TileMode.CLAMP));
      }
      Paint localPaint1 = this.edgeShadowPaint;
      float f2 = localRectF1.top;
      float f3 = localRectF2.top;
      int[] arrayOfInt1 = new int[3];
      arrayOfInt1[0] = this.shadowStartColor;
      arrayOfInt1[1] = this.shadowMiddleColor;
      arrayOfInt1[2] = this.shadowEndColor;
      localPaint1.setShader(new LinearGradient(0.0F, f2, 0.0F, f3, arrayOfInt1, new float[] { 0.0F, 0.5F, 1.0F }, Shader.TileMode.CLAMP));
      this.edgeShadowPaint.setAntiAlias(false);
      return;
      this.cornerShadowPath.reset();
    }
  }

  public static float calculateHorizontalPadding(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean)
      paramFloat1 = (float)(paramFloat1 + (1.0D - COS_45) * paramFloat2);
    return paramFloat1;
  }

  public static float calculateVerticalPadding(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean)
      return (float)(1.5F * paramFloat1 + (1.0D - COS_45) * paramFloat2);
    return 1.5F * paramFloat1;
  }

  private void drawShadow(Canvas paramCanvas)
  {
    int i = paramCanvas.save();
    paramCanvas.rotate(this.rotation, this.contentBounds.centerX(), this.contentBounds.centerY());
    float f1 = -this.cornerRadius - this.shadowSize;
    float f2 = this.cornerRadius;
    int j;
    if (this.contentBounds.width() - 2.0F * f2 > 0.0F)
    {
      j = 1;
      if (this.contentBounds.height() - 2.0F * f2 <= 0.0F)
        break label578;
    }
    label578: for (int k = 1; ; k = 0)
    {
      float f3 = this.rawShadowSize - 0.25F * this.rawShadowSize;
      float f4 = this.rawShadowSize - 0.5F * this.rawShadowSize;
      float f5 = this.rawShadowSize - 1.0F * this.rawShadowSize;
      float f6 = f2 / (f4 + f2);
      float f7 = f2 / (f3 + f2);
      float f8 = f2 / (f2 + f5);
      int m = paramCanvas.save();
      paramCanvas.translate(f2 + this.contentBounds.left, f2 + this.contentBounds.top);
      paramCanvas.scale(f6, f7);
      paramCanvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
      if (j != 0)
      {
        paramCanvas.scale(1.0F / f6, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.contentBounds.width() - 2.0F * f2, -this.cornerRadius, this.edgeShadowPaint);
      }
      paramCanvas.restoreToCount(m);
      int n = paramCanvas.save();
      paramCanvas.translate(this.contentBounds.right - f2, this.contentBounds.bottom - f2);
      paramCanvas.scale(f6, f8);
      paramCanvas.rotate(180.0F);
      paramCanvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
      if (j != 0)
      {
        paramCanvas.scale(1.0F / f6, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.contentBounds.width() - 2.0F * f2, -this.cornerRadius + this.shadowSize, this.edgeShadowPaint);
      }
      paramCanvas.restoreToCount(n);
      int i1 = paramCanvas.save();
      paramCanvas.translate(f2 + this.contentBounds.left, this.contentBounds.bottom - f2);
      paramCanvas.scale(f6, f8);
      paramCanvas.rotate(270.0F);
      paramCanvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
      if (k != 0)
      {
        paramCanvas.scale(1.0F / f8, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.contentBounds.height() - 2.0F * f2, -this.cornerRadius, this.edgeShadowPaint);
      }
      paramCanvas.restoreToCount(i1);
      int i2 = paramCanvas.save();
      paramCanvas.translate(this.contentBounds.right - f2, f2 + this.contentBounds.top);
      paramCanvas.scale(f6, f7);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
      if (k != 0)
      {
        paramCanvas.scale(1.0F / f7, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.contentBounds.height() - 2.0F * f2, -this.cornerRadius, this.edgeShadowPaint);
      }
      paramCanvas.restoreToCount(i2);
      paramCanvas.restoreToCount(i);
      return;
      j = 0;
      break;
    }
  }

  private static int toEven(float paramFloat)
  {
    int i = Math.round(paramFloat);
    if (i % 2 == 1)
      i--;
    return i;
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.dirty)
    {
      buildComponents(getBounds());
      this.dirty = false;
    }
    drawShadow(paramCanvas);
    super.draw(paramCanvas);
  }

  public float getCornerRadius()
  {
    return this.cornerRadius;
  }

  public float getMaxShadowSize()
  {
    return this.rawMaxShadowSize;
  }

  public float getMinHeight()
  {
    return 2.0F * Math.max(this.rawMaxShadowSize, this.cornerRadius + 1.5F * this.rawMaxShadowSize / 2.0F) + 2.0F * (1.5F * this.rawMaxShadowSize);
  }

  public float getMinWidth()
  {
    return 2.0F * Math.max(this.rawMaxShadowSize, this.cornerRadius + this.rawMaxShadowSize / 2.0F) + 2.0F * this.rawMaxShadowSize;
  }

  public int getOpacity()
  {
    return -3;
  }

  public boolean getPadding(Rect paramRect)
  {
    int i = (int)Math.ceil(calculateVerticalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
    int j = (int)Math.ceil(calculateHorizontalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
    paramRect.set(j, i, j, i);
    return true;
  }

  public float getShadowSize()
  {
    return this.rawShadowSize;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    this.dirty = true;
  }

  public void setAddPaddingForCorners(boolean paramBoolean)
  {
    this.addPaddingForCorners = paramBoolean;
    invalidateSelf();
  }

  public void setAlpha(int paramInt)
  {
    super.setAlpha(paramInt);
    this.cornerShadowPaint.setAlpha(paramInt);
    this.edgeShadowPaint.setAlpha(paramInt);
  }

  public void setCornerRadius(float paramFloat)
  {
    float f = Math.round(paramFloat);
    if (this.cornerRadius == f)
      return;
    this.cornerRadius = f;
    this.dirty = true;
    invalidateSelf();
  }

  public void setMaxShadowSize(float paramFloat)
  {
    setShadowSize(this.rawShadowSize, paramFloat);
  }

  public final void setRotation(float paramFloat)
  {
    if (this.rotation != paramFloat)
    {
      this.rotation = paramFloat;
      invalidateSelf();
    }
  }

  public void setShadowSize(float paramFloat)
  {
    setShadowSize(paramFloat, this.rawMaxShadowSize);
  }

  public void setShadowSize(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 < 0.0F) || (paramFloat2 < 0.0F))
      throw new IllegalArgumentException("invalid shadow size");
    float f1 = toEven(paramFloat1);
    float f2 = toEven(paramFloat2);
    if (f1 > f2)
    {
      if (!this.printedShadowClipWarning)
        this.printedShadowClipWarning = true;
      f1 = f2;
    }
    if ((this.rawShadowSize == f1) && (this.rawMaxShadowSize == f2))
      return;
    this.rawShadowSize = f1;
    this.rawMaxShadowSize = f2;
    this.shadowSize = Math.round(f1 * 1.5F);
    this.maxShadowSize = f2;
    this.dirty = true;
    invalidateSelf();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.ShadowDrawableWrapper
 * JD-Core Version:    0.6.2
 */