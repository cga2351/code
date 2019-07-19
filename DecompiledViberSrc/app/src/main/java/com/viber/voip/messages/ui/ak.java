package com.viber.voip.messages.ui;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.widget.EditText;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class ak
  implements TextWatcher
{
  private static final Logger a = ViberEnv.getLogger();
  private aj.a b;
  private String c;
  private aj d;
  private EditText e;

  public ak(aj paramaj, EditText paramEditText)
  {
    this.d = paramaj;
    this.e = paramEditText;
  }

  public void afterTextChanged(Editable paramEditable)
  {
    int i = Selection.getSelectionStart(this.e.getText());
    String str = paramEditable.toString();
    int j = this.c.length() - str.length();
    if ((this.b != null) && (j > 0) && (j < this.b.c().length()))
    {
      int k = this.b.c().length() - j;
      if (i >= k)
        paramEditable.delete(i - k, i);
    }
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    this.c = this.e.getText().toString();
    this.b = null;
    Editable localEditable = this.e.getText();
    int j = Selection.getSelectionStart(localEditable);
    String str;
    int k;
    aj.a[] arrayOfa;
    int m;
    if ((j == Selection.getSelectionEnd(localEditable)) && (j > 0))
    {
      str = this.c.substring(0, j);
      k = str.length();
      arrayOfa = this.d.f();
      m = arrayOfa.length;
    }
    while (true)
    {
      if (i < m)
      {
        aj.a locala = arrayOfa[i];
        if (!str.endsWith(locala.c()))
          break label151;
        if (((ImageSpan[])localEditable.getSpans(k - locala.c().length(), k - 1, ImageSpan.class)).length > 0)
          this.b = locala;
      }
      return;
      label151: i++;
    }
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.ak
 * JD-Core Version:    0.6.2
 */