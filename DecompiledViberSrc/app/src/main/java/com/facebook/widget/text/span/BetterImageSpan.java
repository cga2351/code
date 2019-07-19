package com.facebook.widget.text.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class BetterImageSpan extends ReplacementSpan
{
  public static final int ALIGN_BASELINE = 1;
  public static final int ALIGN_BOTTOM = 0;
  public static final int ALIGN_CENTER = 2;
  private final int mAlignment;
  private Rect mBounds;
  private final Drawable mDrawable;
  private final Paint.FontMetricsInt mFontMetricsInt = new Paint.FontMetricsInt();
  private int mHeight;
  private int mWidth;

  public BetterImageSpan(Drawable paramDrawable)
  {
    this(paramDrawable, 1);
  }

  public BetterImageSpan(Drawable paramDrawable, int paramInt)
  {
    this.mDrawable = paramDrawable;
    this.mAlignment = paramInt;
    updateBounds();
  }

  private int getOffsetAboveBaseline(Paint.FontMetricsInt paramFontMetricsInt)
  {
    switch (this.mAlignment)
    {
    case 1:
    default:
      return -this.mHeight;
    case 0:
      return paramFontMetricsInt.descent - this.mHeight;
    case 2:
    }
    return (paramFontMetricsInt.descent - paramFontMetricsInt.ascent - this.mHeight) / 2 + paramFontMetricsInt.ascent;
  }

  public static final int normalizeAlignment(int paramInt)
  {
    switch (paramInt)
    {
    case 1:
    default:
      return 1;
    case 0:
      return 0;
    case 2:
    }
    return 2;
  }

  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramPaint.getFontMetricsInt(this.mFontMetricsInt);
    int i = paramInt4 + getOffsetAboveBaseline(this.mFontMetricsInt);
    paramCanvas.translate(paramFloat, i);
    this.mDrawable.draw(paramCanvas);
    paramCanvas.translate(-paramFloat, -i);
  }

  public Drawable getDrawable()
  {
    return this.mDrawable;
  }

  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    updateBounds();
    if (paramFontMetricsInt == null)
      return this.mWidth;
    int i = getOffsetAboveBaseline(paramFontMetricsInt);
    int j = i + this.mHeight;
    if (i < paramFontMetricsInt.ascent)
      paramFontMetricsInt.ascent = i;
    if (i < paramFontMetricsInt.top)
      paramFontMetricsInt.top = i;
    if (j > paramFontMetricsInt.descent)
      paramFontMetricsInt.descent = j;
    if (j > paramFontMetricsInt.bottom)
      paramFontMetricsInt.bottom = j;
    return this.mWidth;
  }

  public void updateBounds()
  {
    this.mBounds = this.mDrawable.getBounds();
    this.mWidth = this.mBounds.width();
    this.mHeight = this.mBounds.height();
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface BetterImageSpanAlignment
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.widget.text.span.BetterImageSpan
 * JD-Core Version:    0.6.2
 */