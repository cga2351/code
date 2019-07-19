package com.viber.voip.ui;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.viber.common.d.a;

public class ScalableTextView extends TextView
{
  private String a;
  private int b;
  private int c;
  private boolean d;
  private boolean e;

  public ScalableTextView(Context paramContext)
  {
    super(paramContext);
  }

  public ScalableTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ScalableTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private float a(String paramString)
  {
    TextPaint localTextPaint = getPaint();
    if (localTextPaint != null)
      return localTextPaint.measureText(paramString) * getScaleX();
    return 0.0F;
  }

  private String a(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.a = paramString;
      setMinWidth(Math.min((int)a(paramString), this.b));
    }
    this.e = false;
    return paramString;
  }

  private void b()
  {
    int i = (int)a(this.a);
    boolean bool;
    if ((i > this.b) && (this.b != 0))
    {
      bool = true;
      this.d = bool;
      if (!this.d)
        break label84;
      c();
      label43: if (!a.a())
        break label116;
    }
    label84: label116: for (int j = getMinWidth(); ; j = i)
    {
      int k = Math.min(i, this.b);
      if (j != k)
        setMinWidth(k);
      return;
      bool = false;
      break;
      String str = getText().toString();
      if (this.a.equals(str))
        break label43;
      setText(this.a);
      break label43;
    }
  }

  private void c()
  {
    String str = this.a;
    this.e = true;
    setText(TextUtils.ellipsize(str, getPaint(), this.b / getScaleX(), TextUtils.TruncateAt.END));
  }

  private void setLastReturnMinWidth(int paramInt)
  {
    if (Math.abs(paramInt - this.c) > 3)
      this.c = paramInt;
  }

  public void a()
  {
    this.d = false;
    setText(this.a);
  }

  public int getMaxWidth()
  {
    return this.b;
  }

  public float getScaledWidthDelta()
  {
    String str;
    int i;
    if (!this.d)
    {
      str = getText().toString();
      i = (int)a(this.a);
      if (!this.a.equals(str))
        break label60;
    }
    label60: for (int j = i; ; j = (int)a(str))
    {
      setLastReturnMinWidth(Math.min(i, this.b) - j);
      return this.c;
    }
  }

  public void setMaxWidth(int paramInt)
  {
    super.setMaxWidth(paramInt);
    this.b = paramInt;
    b();
    if (this.d)
      setLastReturnMinWidth(0);
  }

  public void setScaleX(float paramFloat)
  {
    super.setScaleX(paramFloat);
    b();
  }

  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if (paramCharSequence == null)
      paramCharSequence = "";
    super.setText(a(paramCharSequence.toString(), this.e), paramBufferType);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.ScalableTextView
 * JD-Core Version:    0.6.2
 */