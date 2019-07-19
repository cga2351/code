package com.viber.voip.ui.style;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.TypefaceSpan;
import com.viber.common.d.a;

public class b extends CharacterStyle
{
  private final CharacterStyle a;

  public b()
  {
    if (a.g())
    {
      this.a = new TypefaceSpan("sans-serif-medium");
      return;
    }
    this.a = null;
  }

  public void updateDrawState(TextPaint paramTextPaint)
  {
    if (this.a != null)
      this.a.updateDrawState(paramTextPaint);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.style.b
 * JD-Core Version:    0.6.2
 */