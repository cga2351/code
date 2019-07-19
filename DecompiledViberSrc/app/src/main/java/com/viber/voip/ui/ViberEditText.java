package com.viber.voip.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.viber.common.d.a;
import com.viber.common.d.c;

public class ViberEditText extends AppCompatEditText
{
  private a a;

  public ViberEditText(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public ViberEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  public ViberEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }

  private void a()
  {
    if ((a.k()) && (c.a()))
      setGravity(21);
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.a != null)
      this.a.a();
  }

  public Editable getText()
  {
    try
    {
      Editable localEditable = super.getText();
      return localEditable;
    }
    catch (ClassCastException localClassCastException)
    {
      setText("", TextView.BufferType.EDITABLE);
    }
    return super.getText();
  }

  public void setInputType(int paramInt)
  {
    Typeface localTypeface = getTypeface();
    super.setInputType(paramInt);
    if (localTypeface != null)
      setTypeface(localTypeface);
  }

  public void setOnStateChangeListener(a parama)
  {
    this.a = parama;
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.ViberEditText
 * JD-Core Version:    0.6.2
 */