package com.viber.voip.ui.dialogs;

import android.content.Context;
import android.content.res.Resources;
import com.viber.common.dialogs.a;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.f;
import com.viber.common.dialogs.f.a;
import com.viber.common.dialogs.h;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.j;
import com.viber.common.dialogs.j.a;
import com.viber.common.dialogs.k;
import com.viber.common.dialogs.k.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.y;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.R.style;
import com.viber.voip.ViberApplication;

public class t
{
  public static f.a a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2)
  {
    return ((f.a)f.j().a(DialogCode.D_SELECT_DATE)).i(paramInt1).j(paramInt2).k(paramInt3).a(paramLong1).b(paramLong2);
  }

  public static h.a a(String paramString)
  {
    return (h.a)((h.a)((h.a)h.j().a(R.string.dialog_422b_title, new Object[] { paramString })).f(R.string.dialog_422b_message)).a(DialogCode.D422b);
  }

  public static j.a a(int paramInt, int[] paramArrayOfInt)
  {
    return (j.a)((j.a)((j.a)((j.a)((j.a)j.m().a(DialogCode.D_SELECT_AUTO_BACKUP_PERIOD)).d(R.string.backup_autobackup_promo_screen_title)).a(paramArrayOfInt)).i(paramInt).b(true)).c();
  }

  public static l.a a()
  {
    return (l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().f(R.string.dialog_400_message)).i(R.string.dialog_button_continue)).m(R.string.dialog_button_cancel).a(DialogCode.D400);
  }

  public static l.a a(String paramString1, String paramString2)
  {
    return (l.a)((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().c(paramString1)).a(paramString2)).a(false)).a(DialogCode.D424);
  }

  public static l.a a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    Context localContext = y.a();
    int i = localContext.getResources().getDimensionPixelSize(R.dimen.restore_confirmation_dialog_message_part_delimiter_height);
    return (l.a)((l.a)((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().d(R.string.dialog_435_title)).a(com.viber.voip.backup.l.a(localContext, localContext.getString(R.string.dialog_435_message_part1), localContext.getString(R.string.dialog_435_message_part2), paramLong1, paramLong2, i))).i(R.string.dialog_button_restore_now)).m(R.string.dialog_button_cancel).a(new ViberDialogHandlers.bb(paramString1, paramString2))).a(DialogCode.D435);
  }

  public static l.a b()
  {
    return (l.a)((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().d(R.string.dialog_401_title)).f(R.string.dialog_401_message)).i(R.string.dialog_button_clear)).m(R.string.dialog_button_cancel).a(DialogCode.D401);
  }

  public static l.a b(String paramString)
  {
    Context localContext = y.a();
    return (l.a)((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().d(R.string.dialog_435d_title)).a(localContext.getString(R.string.dialog_435d_message, new Object[] { paramString }))).i(R.string.dialog_button_ok)).m(R.string.dialog_button_try_another_account).a(DialogCode.D435d);
  }

  public static l.a c()
  {
    return (l.a)((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().b(false)).f(R.string.dialog_402_message)).i(R.string.dialog_button_deactivate)).m(R.string.dialog_button_cancel).a(DialogCode.D402);
  }

  public static l.a c(String paramString)
  {
    return ((l.a)((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().a(DialogCode.D402i)).d(R.string.change_phone_number)).b(R.string.dialog_402i_message, new Object[] { paramString })).i(R.string.dialog_button_continue)).m(R.string.dialog_button_cancel);
  }

  public static l.a d()
  {
    return ((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().a(DialogCode.D402f)).f(R.string.dialog_402f_message)).i(R.string.dialog_button_deactivate)).m(R.string.dialog_button_cancel);
  }

  public static h.a e()
  {
    return (h.a)((h.a)((h.a)h.j().d(R.string.dialog_406b_title)).f(R.string.dialog_406b_message)).a(DialogCode.D406b);
  }

  public static h.a f()
  {
    return (h.a)((h.a)h.j().f(R.string.dialog_410_message)).a(DialogCode.D410);
  }

  public static l.a g()
  {
    return (l.a)((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().d(R.string.dialog_411_title)).f(R.string.dialog_411_message)).i(R.string.dialog_button_turn_on)).a(DialogCode.D411);
  }

  public static l.a h()
  {
    return (l.a)((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().d(R.string.dialog_411b_title)).f(R.string.dialog_411b_message)).i(R.string.dialog_button_turn_off)).a(DialogCode.D411b);
  }

  public static h.a i()
  {
    return (h.a)((h.a)((h.a)h.j().d(R.string.dialog_420_title)).f(R.string.dialog_420_message)).a(DialogCode.D420);
  }

  public static h.a j()
  {
    return (h.a)((h.a)((h.a)h.j().d(R.string.dialog_437_title)).f(R.string.dialog_437_message)).i(R.string.dialog_button_ok).a(DialogCode.D437);
  }

  public static h.a k()
  {
    return (h.a)((h.a)((h.a)h.j().d(R.string.dialog_438_title)).f(R.string.dialog_438_message)).i(R.string.dialog_button_ok).a(DialogCode.D438);
  }

  public static k.a l()
  {
    k.a locala = (k.a)((k.a)((k.a)((k.a)((k.a)((k.a)k.l().e(R.layout.hidden_chat_pin_layout)).b(R.id.btn_fake_confirm, "")).d(R.id.btn_fake_close, "")).c(R.id.btn_fake_neutral, "").k().h(R.style.HiddenChatPinDialogBase_HiddenChatPinDialog)).c(-1001)).a(DialogCode.D_PIN);
    if (!ViberApplication.isTablet(ViberApplication.getApplication()))
      locala.a(-1);
    return locala;
  }

  public static h.a m()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.D402h)).d(R.string.dialog_402h_title)).f(R.string.dialog_402h_message)).i(R.string.ok_btn_text);
  }

  public static l.a n()
  {
    return ((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().a(DialogCode.D3009)).f(R.string.dialog_3009_message)).i(R.string.dialog_button_continue)).m(R.string.dialog_button_cancel);
  }

  public static l.a o()
  {
    return (l.a)((l.a)((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().d(R.string.dialog_442a_title)).f(R.string.dialog_442a_body)).i(R.string.dialog_button_agree)).m(R.string.dialog_button_cancel).b(false)).a(DialogCode.D442a);
  }

  public static l.a p()
  {
    return (l.a)((l.a)((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().d(R.string.dialog_442b_title)).f(R.string.dialog_442a_body)).i(R.string.dialog_button_agree)).m(R.string.dialog_button_cancel).b(false)).a(DialogCode.D442b);
  }

  public static h.a q()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.D463)).d(R.string.dialog_103_title)).f(R.string.dialog_463_body)).i(R.string.dialog_button_try_again);
  }

  public static l.a r()
  {
    return (l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().a(DialogCode.D464)).f(R.string.dialog_464_message)).m(R.string.dialog_button_cancel).i(R.string.dialog_button_clear);
  }

  public static a.a s()
  {
    return a.b().a(DialogCode.D464_PROGRESS).c().e(R.layout.layout_dialog_clear_media_progress);
  }

  public static l.a t()
  {
    return (l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().a(DialogCode.D465)).f(R.string.dialog_465_message)).m(R.string.dialog_button_cancel).i(R.string.dialog_button_try_again);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.dialogs.t
 * JD-Core Version:    0.6.2
 */