package com.facebook.react.views.text;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.style.ReplacementSpan;
import android.widget.TextView;
import javax.annotation.Nullable;

public abstract class TextInlineImageSpan extends ReplacementSpan
  implements ReactSpan
{
  public static void possiblyUpdateInlineImageSpans(Spannable paramSpannable, TextView paramTextView)
  {
    int i = 0;
    TextInlineImageSpan[] arrayOfTextInlineImageSpan = (TextInlineImageSpan[])paramSpannable.getSpans(0, paramSpannable.length(), TextInlineImageSpan.class);
    int j = arrayOfTextInlineImageSpan.length;
    while (i < j)
    {
      TextInlineImageSpan localTextInlineImageSpan = arrayOfTextInlineImageSpan[i];
      localTextInlineImageSpan.onAttachedToWindow();
      localTextInlineImageSpan.setTextView(paramTextView);
      i++;
    }
  }

  @Nullable
  public abstract Drawable getDrawable();

  public abstract int getHeight();

  public abstract int getWidth();

  public abstract void onAttachedToWindow();

  public abstract void onDetachedFromWindow();

  public abstract void onFinishTemporaryDetach();

  public abstract void onStartTemporaryDetach();

  public abstract void setTextView(TextView paramTextView);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.TextInlineImageSpan
 * JD-Core Version:    0.6.2
 */