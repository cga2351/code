package com.facebook.react.views.text;

import android.annotation.TargetApi;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

@TargetApi(21)
public class CustomLetterSpacingSpan extends MetricAffectingSpan
  implements ReactSpan
{
  private final float mLetterSpacing;

  public CustomLetterSpacingSpan(float paramFloat)
  {
    this.mLetterSpacing = paramFloat;
  }

  private void apply(TextPaint paramTextPaint)
  {
    if (!Float.isNaN(this.mLetterSpacing))
      paramTextPaint.setLetterSpacing(this.mLetterSpacing);
  }

  public void updateDrawState(TextPaint paramTextPaint)
  {
    apply(paramTextPaint);
  }

  public void updateMeasureState(TextPaint paramTextPaint)
  {
    apply(paramTextPaint);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.CustomLetterSpacingSpan
 * JD-Core Version:    0.6.2
 */