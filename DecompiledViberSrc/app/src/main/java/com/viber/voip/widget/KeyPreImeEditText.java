package com.viber.voip.widget;

import android.content.Context;
import android.os.Parcelable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import com.viber.voip.ui.ViberEditText;

public class KeyPreImeEditText extends ViberEditText
{
  private a a;

  public KeyPreImeEditText(Context paramContext)
  {
    super(paramContext);
  }

  public KeyPreImeEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public KeyPreImeEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.a != null) && (this.a.a(paramInt, paramKeyEvent)))
      return true;
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    super.onRestoreInstanceState(paramParcelable);
    if (getText() != null)
      setSelection(getText().length());
  }

  public void setKeyPreImeListener(a parama)
  {
    this.a = parama;
  }

  public static abstract interface a
  {
    public abstract boolean a(int paramInt, KeyEvent paramKeyEvent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.KeyPreImeEditText
 * JD-Core Version:    0.6.2
 */