package com.viber.voip.ui.dialogs;

import com.viber.common.dialogs.h;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.k;
import com.viber.common.dialogs.k.a;
import com.viber.common.dialogs.l.a;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;

public class p
{
  public static h.a a(int paramInt)
  {
    return ((h.a)((h.a)h.j().a(DialogCode.D307)).f(d(paramInt))).i(R.string.dialog_button_ok);
  }

  public static k.a a(long paramLong)
  {
    return ((k.a)((k.a)((k.a)((k.a)((k.a)((k.a)k.l().a(DialogCode.D3911)).d(R.string.dialog_3911_title)).f(R.string.dialog_3911_message)).a(Long.valueOf(paramLong))).i(R.string.dialog_button_continue)).m(R.string.dialog_button_continue_and_do_not_show)).k(R.string.dialog_button_cancel);
  }

  public static l.a a()
  {
    return (l.a)((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().a(DialogCode.D398)).f(true)).e(R.layout.dialog_why_im_seeing_spam)).e(R.id.unsubscribe_btn, R.string.dialog_button_unsubscribe).c(R.id.close_btn, R.string.dialog_button_close);
  }

  public static h.a b()
  {
    return (h.a)((h.a)((h.a)h.j().a(DialogCode.D533)).d(R.string.dialog_533_title)).f(R.string.dialog_533_body);
  }

  public static h.a b(int paramInt)
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.D307b)).d(R.string.dialog_307b_title)).f(e(paramInt))).i(R.string.dialog_button_ok);
  }

  public static h.a c(int paramInt)
  {
    return ((h.a)((h.a)h.j().a(DialogCode.D307d)).f(f(paramInt))).i(R.string.dialog_button_ok);
  }

  public static l.a c()
  {
    return (l.a)((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().a(DialogCode.D3903)).d(R.string.dialog_3903_title)).f(R.string.dialog_3903_message)).m(R.string.dialog_button_no).i(R.string.dialog_button_yes);
  }

  private static int d(int paramInt)
  {
    int i = R.string.dialog_307_message_message;
    if (com.viber.voip.messages.l.e(paramInt))
      i = R.string.dialog_307_message_video;
    do
    {
      return i;
      if (com.viber.voip.messages.l.f(paramInt))
        return R.string.dialog_307_message_photo;
      if ((2 == paramInt) || (1009 == paramInt))
        return R.string.dialog_307_message_ptt;
      if (10 == paramInt)
        return R.string.dialog_307_message_file;
    }
    while (1005 != paramInt);
    return R.string.dialog_307_message_gif;
  }

  public static l.a d()
  {
    return (l.a)((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().a(DialogCode.D3912)).d(R.string.dialog_3912_title)).f(R.string.dialog_3912_message)).m(R.string.dialog_button_cancel).i(R.string.dialog_button_delete);
  }

  private static int e(int paramInt)
  {
    int i = R.string.dialog_307b_message_message;
    if (com.viber.voip.messages.l.e(paramInt))
      i = R.string.dialog_307b_message_video;
    do
    {
      return i;
      if (com.viber.voip.messages.l.f(paramInt))
        return R.string.dialog_307b_message_photo;
      if ((2 == paramInt) || (1009 == paramInt))
        return R.string.dialog_307b_message_ptt;
      if (10 == paramInt)
        return R.string.dialog_307b_message_file;
    }
    while (1005 != paramInt);
    return R.string.dialog_307b_message_gif;
  }

  public static l.a e()
  {
    return (l.a)((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().a(DialogCode.D3905)).d(R.string.dialog_3905_title)).f(R.string.dialog_3905_body)).m(R.string.dialog_3905_button_keep).i(R.string.dialog_button_delete);
  }

  private static int f(int paramInt)
  {
    int i = R.string.dialog_307d_message_message;
    if (com.viber.voip.messages.l.e(paramInt))
      i = R.string.dialog_307d_message_video;
    do
    {
      return i;
      if (com.viber.voip.messages.l.f(paramInt))
        return R.string.dialog_307d_message_photo;
      if ((2 == paramInt) || (1009 == paramInt))
        return R.string.dialog_307d_message_ptt;
      if (10 == paramInt)
        return R.string.dialog_307d_message_file;
    }
    while (1005 != paramInt);
    return R.string.dialog_307d_message_gif;
  }

  public static l.a f()
  {
    return (l.a)((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().a(DialogCode.D3913)).d(R.string.dialog_3913_title)).f(R.string.dialog_3913_message)).m(R.string.dialog_button_cancel).i(R.string.dialog_button_delete);
  }

  public static l.a g()
  {
    return (l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().a(DialogCode.D3914)).d(R.string.dialog_3914_title)).m(R.string.dialog_button_cancel).i(R.string.dialog_button_delete);
  }

  public static h.a h()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.D3911a)).d(R.string.dialog_3911_title)).f(R.string.dialog_3911a_message)).i(R.string.dialog_button_ok);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.dialogs.p
 * JD-Core Version:    0.6.2
 */