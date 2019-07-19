package com.viber.voip.ui.dialogs;

import com.viber.common.dialogs.l;
import com.viber.common.dialogs.l.a;
import com.viber.voip.R.string;

public class v
{
  public static l.a a(boolean paramBoolean)
  {
    l.a locala1 = l.n();
    int i;
    l.a locala2;
    if (paramBoolean)
    {
      i = R.string.dialog_2000a_enable_title;
      locala2 = (l.a)locala1.d(i);
      if (!paramBoolean)
        break label78;
    }
    label78: for (int j = R.string.dialog_2000a_enable_hint; ; j = R.string.dialog_2000a_disable_hint)
    {
      return (l.a)((l.a)((l.a)((l.a)locala2.f(j)).m(R.string.dialog_button_cancel).i(R.string.dialog_button_continue)).a(false)).a(DialogCode.D2000a);
      i = R.string.dialog_2000a_disable_title;
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.dialogs.v
 * JD-Core Version:    0.6.2
 */