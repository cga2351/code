package com.facebook.react.views.text;

import android.graphics.Paint.FontMetricsInt;
import android.text.style.LineHeightSpan;

public class CustomLineHeightSpan
  implements LineHeightSpan, ReactSpan
{
  private final int mHeight;

  CustomLineHeightSpan(float paramFloat)
  {
    this.mHeight = ((int)Math.ceil(paramFloat));
  }

  public void chooseHeight(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint.FontMetricsInt paramFontMetricsInt)
  {
    if (paramFontMetricsInt.descent > this.mHeight)
    {
      int k = Math.min(this.mHeight, paramFontMetricsInt.descent);
      paramFontMetricsInt.descent = k;
      paramFontMetricsInt.bottom = k;
      paramFontMetricsInt.ascent = 0;
      paramFontMetricsInt.top = 0;
      return;
    }
    if (-paramFontMetricsInt.ascent + paramFontMetricsInt.descent > this.mHeight)
    {
      paramFontMetricsInt.bottom = paramFontMetricsInt.descent;
      int j = -this.mHeight + paramFontMetricsInt.descent;
      paramFontMetricsInt.ascent = j;
      paramFontMetricsInt.top = j;
      return;
    }
    if (-paramFontMetricsInt.ascent + paramFontMetricsInt.bottom > this.mHeight)
    {
      paramFontMetricsInt.top = paramFontMetricsInt.ascent;
      paramFontMetricsInt.bottom = (paramFontMetricsInt.ascent + this.mHeight);
      return;
    }
    if (-paramFontMetricsInt.top + paramFontMetricsInt.bottom > this.mHeight)
    {
      paramFontMetricsInt.top = (paramFontMetricsInt.bottom - this.mHeight);
      return;
    }
    int i = this.mHeight - (-paramFontMetricsInt.top + paramFontMetricsInt.bottom);
    paramFontMetricsInt.top = ((int)(paramFontMetricsInt.top - Math.ceil(i / 2.0F)));
    paramFontMetricsInt.bottom = ((int)(paramFontMetricsInt.bottom + Math.floor(i / 2.0F)));
    paramFontMetricsInt.ascent = paramFontMetricsInt.top;
    paramFontMetricsInt.descent = paramFontMetricsInt.bottom;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.CustomLineHeightSpan
 * JD-Core Version:    0.6.2
 */