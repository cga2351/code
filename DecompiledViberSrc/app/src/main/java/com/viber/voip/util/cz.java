package com.viber.voip.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import java.lang.ref.WeakReference;

public class cz
  implements TextWatcher, View.OnKeyListener
{
  private String a = "";
  private int b = 0;
  private int c;
  private WeakReference<EditText> d = null;

  public cz(EditText paramEditText, int paramInt)
  {
    this.d = new WeakReference(paramEditText);
    this.c = paramInt;
  }

  public void afterTextChanged(Editable paramEditable)
  {
    EditText localEditText;
    if (this.d == null)
    {
      localEditText = null;
      if (localEditText != null)
        break label28;
    }
    label28: 
    while ((localEditText.getLineCount() <= this.c) || (this.a.length() >= paramEditable.length()))
    {
      return;
      localEditText = (EditText)this.d.get();
      break;
    }
    int i = this.b;
    localEditText.setText(this.a);
    localEditText.setSelection(Math.min(i, this.a.length()));
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramCharSequence.toString();
    this.b = paramInt1;
  }

  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    return (paramInt == 66) && (paramKeyEvent.getAction() == 0) && (((EditText)paramView).getLineCount() >= this.c);
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.cz
 * JD-Core Version:    0.6.2
 */