package com.facebook.react.views.text;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

public class ShadowStyleSpan extends CharacterStyle
  implements ReactSpan
{
  private final int mColor;
  private final float mDx;
  private final float mDy;
  private final float mRadius;

  public ShadowStyleSpan(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    this.mDx = paramFloat1;
    this.mDy = paramFloat2;
    this.mRadius = paramFloat3;
    this.mColor = paramInt;
  }

  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setShadowLayer(this.mRadius, this.mDx, this.mDy, this.mColor);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.ShadowStyleSpan
 * JD-Core Version:    0.6.2
 */