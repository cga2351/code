package com.viber.voip.messages;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.Editable;
import android.widget.EditText;
import com.viber.voip.ui.style.UserMentionSpan;
import com.viber.voip.util.da;
import com.viber.voip.util.n;

public class g
  implements a
{
  private boolean a(EditText paramEditText, boolean paramBoolean)
  {
    int i = 0;
    int j = paramEditText.getText().length();
    int i5;
    int k;
    if (paramEditText.isFocused())
    {
      int i3 = paramEditText.getSelectionStart();
      int i4 = paramEditText.getSelectionEnd();
      i5 = Math.max(0, Math.min(i3, i4));
      k = Math.max(0, Math.max(i3, i4));
    }
    for (int m = i5; ; m = 0)
    {
      Editable localEditable1 = paramEditText.getText();
      Editable localEditable2 = (Editable)localEditable1.subSequence(m, k);
      UserMentionSpan[] arrayOfUserMentionSpan = (UserMentionSpan[])localEditable2.getSpans(0, localEditable2.length(), UserMentionSpan.class);
      if (n.a(arrayOfUserMentionSpan))
        return false;
      int n = arrayOfUserMentionSpan.length;
      while (i < n)
      {
        UserMentionSpan localUserMentionSpan = arrayOfUserMentionSpan[i];
        int i1 = localEditable2.getSpanStart(localUserMentionSpan);
        if ((com.viber.common.d.a.c()) && (i1 + 1 < localEditable2.length()) && (da.a(localEditable2.charAt(i1 + 1))))
          localEditable2.delete(i1 + 1, i1 + 2);
        int i2 = localEditable2.getSpanEnd(localUserMentionSpan);
        if (da.a(localEditable2.charAt(i2 - 1)))
          localEditable2.delete(i2 - 1, i2);
        i++;
      }
      String str = localEditable2.toString();
      ClipData localClipData = ClipData.newPlainText(str, str);
      ClipboardManager localClipboardManager = (ClipboardManager)paramEditText.getContext().getSystemService("clipboard");
      if (localClipboardManager != null)
        localClipboardManager.setPrimaryClip(localClipData);
      if (paramBoolean)
        paramEditText.setText(localEditable1.delete(m, k));
      return true;
      k = j;
    }
  }

  public boolean a(EditText paramEditText)
  {
    return a(paramEditText, false);
  }

  public boolean b(EditText paramEditText)
  {
    return a(paramEditText, true);
  }

  public boolean c(EditText paramEditText)
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.g
 * JD-Core Version:    0.6.2
 */