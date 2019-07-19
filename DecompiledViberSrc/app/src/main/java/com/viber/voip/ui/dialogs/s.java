package com.viber.voip.ui.dialogs;

import com.viber.common.dialogs.h;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.k;
import com.viber.common.dialogs.k.a;
import com.viber.common.dialogs.l;
import com.viber.common.dialogs.l.a;
import com.viber.voip.R.string;

public class s
{
  public static k.a a(String paramString)
  {
    return (k.a)((k.a)((k.a)((k.a)((k.a)k.l().d(R.string.dialog_1500_title)).b(R.string.dialog_1500b_message, new Object[] { paramString })).i(R.string.dialog_button_viber_call)).k(R.string.cancel_btn_text).m(R.string.dialog_button_learn_more)).a(DialogCode.D1500);
  }

  public static l.a a()
  {
    return ((l.a)((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D1501)).d(R.string.dialog_1502_title)).f(R.string.dialog_1501_message)).a(new ViberDialogHandlers.q())).i(R.string.dialog_button_ok)).m(R.string.dialog_button_learn_more);
  }

  public static h.a b()
  {
    return (h.a)((h.a)((h.a)h.j().a(DialogCode.D1506)).d(R.string.dialog_1506_title)).f(R.string.dialog_1506_message);
  }

  public static k.a b(String paramString)
  {
    return (k.a)((k.a)((k.a)((k.a)((k.a)k.l().a(DialogCode.D1500c)).d(R.string.dialog_1500_title)).b(R.string.dialog_1500c_message, new Object[] { paramString })).i(R.string.dialog_button_viber_call)).k(R.string.cancel_btn_text).m(R.string.dialog_button_learn_more);
  }

  public static l.a c(String paramString)
  {
    return (l.a)((l.a)((l.a)l.n().a(DialogCode.D1505)).d(R.string.dialog_1505_title)).b(R.string.dialog_1505_message, new Object[] { paramString });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.dialogs.s
 * JD-Core Version:    0.6.2
 */