package com.viber.voip.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.TextView.BufferType;

public class ViberCheckBox extends CheckBox
{
  private float a = -2.147484E+009F;
  private int b = -2147483648;
  private float c = -2.147484E+009F;
  private int d = -2147483648;
  private int e = -2147483648;
  private CharSequence f;
  private TextView.BufferType g;

  public ViberCheckBox(Context paramContext)
  {
    super(paramContext);
  }

  public ViberCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ViberCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void setButtonDrawable(int paramInt)
  {
    if (paramInt != this.e)
    {
      this.e = paramInt;
      super.setButtonDrawable(paramInt);
    }
  }

  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if ((paramCharSequence != this.f) || (paramBufferType != this.g))
    {
      this.f = paramCharSequence;
      this.g = paramBufferType;
    }
    try
    {
      super.setText(paramCharSequence, paramBufferType);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      setText(paramCharSequence.toString());
    }
  }

  public void setTextColor(int paramInt)
  {
    if (this.d != paramInt)
    {
      this.d = paramInt;
      super.setTextColor(paramInt);
    }
  }

  public void setTextSize(float paramFloat)
  {
    if (paramFloat != this.a)
    {
      this.a = paramFloat;
      super.setTextSize(paramFloat);
    }
  }

  public void setTextSize(int paramInt, float paramFloat)
  {
    if ((paramFloat != this.c) || (paramInt != this.b))
    {
      this.c = paramFloat;
      this.b = paramInt;
      super.setTextSize(paramInt, paramFloat);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.ViberCheckBox
 * JD-Core Version:    0.6.2
 */