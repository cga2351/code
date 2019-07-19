package com.viber.voip.ui.style;

import android.os.Parcel;
import android.text.TextPaint;
import android.text.style.URLSpan;

public class ColoredURLSpan extends URLSpan
{
  private final boolean mIsUnderline;
  private final int mUrlColor;

  public ColoredURLSpan(Parcel paramParcel)
  {
    super(paramParcel);
    this.mUrlColor = paramParcel.readInt();
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mIsUnderline = bool;
      return;
    }
  }

  public ColoredURLSpan(String paramString, int paramInt)
  {
    this(paramString, paramInt, true);
  }

  public ColoredURLSpan(String paramString, int paramInt, boolean paramBoolean)
  {
    super(paramString);
    this.mUrlColor = paramInt;
    this.mIsUnderline = paramBoolean;
  }

  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.mUrlColor);
    paramTextPaint.setUnderlineText(this.mIsUnderline);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mUrlColor);
    if (this.mIsUnderline);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.style.ColoredURLSpan
 * JD-Core Version:    0.6.2
 */