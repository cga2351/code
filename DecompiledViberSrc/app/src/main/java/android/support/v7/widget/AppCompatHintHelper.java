package android.support.v7.widget;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

class AppCompatHintHelper
{
  static InputConnection onCreateInputConnection(InputConnection paramInputConnection, EditorInfo paramEditorInfo, View paramView)
  {
    if ((paramInputConnection != null) && (paramEditorInfo.hintText == null));
    for (ViewParent localViewParent = paramView.getParent(); ; localViewParent = localViewParent.getParent())
      if ((localViewParent instanceof View))
      {
        if ((localViewParent instanceof WithHint))
          paramEditorInfo.hintText = ((WithHint)localViewParent).getHint();
      }
      else
        return paramInputConnection;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.AppCompatHintHelper
 * JD-Core Version:    0.6.2
 */