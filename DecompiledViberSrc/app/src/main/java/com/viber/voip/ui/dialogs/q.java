package com.viber.voip.ui.dialogs;

import com.viber.common.dialogs.l;
import com.viber.common.dialogs.l.a;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;

public class q
{
  public static l.a a()
  {
    return ((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D_EXPLAIN_PERMISSION)).e(R.layout.dialog_permissions)).b(false)).c(R.id.button1, R.string.dialog_button_allow)).e(R.id.button2, R.string.dialog_button_not_now);
  }

  public static l.a b()
  {
    return ((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D_ASK_PERMISSION)).e(R.layout.dialog_permissions)).b(false)).c(R.id.button1, R.string.dialog_button_settings)).e(R.id.button2, R.string.dialog_button_not_now);
  }

  public static l.a c()
  {
    return ((l.a)((l.a)((l.a)((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D_DRAW_OVER_OTHER_APPS_MINIMIZED_CALL)).e(R.layout.dialog_permissions)).a(R.id.title, R.string.dialog_draw_over_other_apps_title)).b(R.id.message, R.string.dialog_draw_over_other_apps_message)).a(new ViberDialogHandlers.cg())).b(false)).c(R.id.button1, R.string.dialog_button_settings)).e(R.id.button2, R.string.dialog_button_not_now);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.dialogs.q
 * JD-Core Version:    0.6.2
 */