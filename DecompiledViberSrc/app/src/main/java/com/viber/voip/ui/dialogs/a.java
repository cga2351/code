package com.viber.voip.ui.dialogs;

import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.k;
import com.viber.common.dialogs.k.a;
import com.viber.common.dialogs.l;
import com.viber.common.dialogs.l.a;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;

public class a
{
  public static h.a a()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.D103)).d(R.string.dialog_103_title)).f(R.string.dialog_103_message)).i(R.string.dialog_button_try_again);
  }

  public static h.a a(String paramString)
  {
    return ((h.a)((h.a)h.j().a(DialogCode.D103a)).b(R.string.dialog_103a_message, new Object[] { paramString })).i(R.string.dialog_button_edit);
  }

  public static l.a a(String paramString1, String paramString2)
  {
    return ((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D136)).d(R.string.dialog_135_136_title)).b(R.string.dialog_136_message, new Object[] { paramString1, paramString2 })).i(R.string.dialog_button_copy)).m(R.string.dialog_button_cancel);
  }

  public static h.a b()
  {
    return (h.a)((h.a)((h.a)h.j().a(DialogCode.D103d)).d(R.string.dialog_103d_title)).f(R.string.dialog_103d_message);
  }

  public static h.a b(String paramString)
  {
    return ((h.a)((h.a)h.j().a(DialogCode.D103b)).b(R.string.dialog_103b_message, new Object[] { paramString })).i(R.string.dialog_button_edit);
  }

  public static h.a c()
  {
    return ((h.a)((h.a)((h.a)((h.a)h.j().a(DialogCode.D104a)).d(R.string.dialog_104_title)).f(R.string.dialog_104a_message)).i(R.string.dialog_button_try_again).e(true)).e("Try Again");
  }

  public static l.a c(String paramString)
  {
    return (l.a)((l.a)((l.a)((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D105)).e(R.layout.dialog_105)).a(R.id.number, paramString)).c(R.id.yes_btn, R.string.dialog_button_yes)).e(R.id.edit_btn, R.string.dialog_button_edit).e(true)).e("Yes")).i("Edit").a(new ViberDialogHandlers.m());
  }

  public static h.a d()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.D104c)).d(R.string.dialog_104_title)).f(R.string.dialog_104c_message)).i(R.string.dialog_button_try_again);
  }

  public static l.a d(String paramString)
  {
    return (l.a)c(paramString).a(DialogCode.D105e).e(R.layout.dialog_105e).a(R.id.number, paramString);
  }

  public static l.a e()
  {
    return ((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D108)).d(R.string.dialog_108_title)).f(R.string.dialog_108_message)).i(R.string.dialog_button_try_again)).m(R.string.dialog_button_close);
  }

  public static l.a e(String paramString)
  {
    return ((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D135)).d(R.string.dialog_135_136_title)).b(R.string.dialog_135_message, new Object[] { paramString })).i(R.string.dialog_button_copy)).m(R.string.dialog_button_cancel);
  }

  public static h.a f()
  {
    return ((h.a)((h.a)h.j().a(DialogCode.D109e)).f(R.string.dialog_109e_message)).i(R.string.dialog_button_ok);
  }

  public static k.a g()
  {
    return (k.a)((k.a)((k.a)((k.a)((k.a)k.l().a(DialogCode.D113)).d(R.string.dialog_113_title)).f(R.string.dialog_113_message)).i(R.string.dialog_button_done)).k(R.string.dialog_113_neutral_button_text).m(R.string.dialog_button_close);
  }

  public static l.a h()
  {
    return ((l.a)((l.a)((l.a)l.n().a(DialogCode.D128)).f(R.string.dialog_128_message)).i(R.string.dialog_button_ok)).m(R.string.dialog_button_cancel);
  }

  public static h.a i()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.D130c)).d(R.string.dialog_130c_title)).f(R.string.dialog_130c_message)).i(R.string.dialog_button_close);
  }

  public static h.a j()
  {
    return (h.a)((h.a)((h.a)h.j().a(DialogCode.D132)).d(R.string.dialog_132_title)).f(R.string.dialog_132_message);
  }

  public static l.a k()
  {
    return ((l.a)((l.a)((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D137)).d(R.string.dialog_137_title)).e(R.layout.dialog_approve_action)).b(R.id.message, R.string.dialog_137_message)).a(new ViberDialogHandlers.n())).i(R.string.dialog_button_approve)).m(R.string.dialog_button_cancel);
  }

  public static l.a l()
  {
    return ((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D138b)).f(R.string.dialog_138b_message)).a(new ViberDialogHandlers.o())).i(R.string.dialog_button_settings)).m(R.string.dialog_button_cancel);
  }

  public static l.a m()
  {
    return ((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D140a)).d(R.string.dialog_140a_title)).f(R.string.dialog_140a_message)).i(R.string.dialog_button_contact_support)).m(R.string.dialog_button_close);
  }

  public static a.a n()
  {
    return com.viber.common.dialogs.a.b().a(DialogCode.D_PROGRESS_OVERLAY).e(R.layout.change_phone_number_progress).b(false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.dialogs.a
 * JD-Core Version:    0.6.2
 */