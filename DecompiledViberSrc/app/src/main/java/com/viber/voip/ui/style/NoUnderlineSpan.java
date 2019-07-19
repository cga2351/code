package com.viber.voip.ui.style;

import android.os.Parcel;
import android.text.TextPaint;
import android.text.style.UnderlineSpan;

public class NoUnderlineSpan extends UnderlineSpan
{
  public NoUnderlineSpan()
  {
  }

  public NoUnderlineSpan(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.style.NoUnderlineSpan
 * JD-Core Version:    0.6.2
 */