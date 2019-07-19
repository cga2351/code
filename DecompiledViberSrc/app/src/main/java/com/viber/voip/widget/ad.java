package com.viber.voip.widget;

import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class ad
  implements TextView.OnEditorActionListener
{
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool1 = false;
    if (paramInt == 5)
    {
      View localView = paramTextView.focusSearch(130);
      bool1 = false;
      if (localView != null)
      {
        boolean bool2 = localView.requestFocus(130);
        bool1 = false;
        if (bool2)
        {
          if ((localView instanceof EditText))
          {
            EditText localEditText = (EditText)localView;
            Editable localEditable = localEditText.getText();
            int i = 0;
            if (localEditable != null)
              i = localEditable.length();
            localEditText.setSelection(i);
          }
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.ad
 * JD-Core Version:    0.6.2
 */