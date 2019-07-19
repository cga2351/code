package com.viber.voip.ui.dialogs;

import android.content.res.Resources;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.k;
import com.viber.common.dialogs.k.a;
import com.viber.common.dialogs.l;
import com.viber.common.dialogs.l.a;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest;
import com.viber.voip.messages.conversation.ui.az.a;
import com.viber.voip.util.da;
import com.viber.voip.viberout.ui.TermsAndConditionsActivity.a;
import java.util.LinkedList;

public final class r
{
  public static a.a a(int paramInt, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, long paramLong3, String paramString4, TermsAndConditionsActivity.a parama, String paramString5)
  {
    return ((k.a)((k.a)a(paramInt, paramLong1, paramLong2, paramString1, paramString2, paramString3, paramLong3, paramString4, false, parama, paramString5, new ViberDialogHandlers.k()).d(R.string.dialog_1021_title)).f(R.string.dialog_1021b_message)).a(DialogCode.D1021b);
  }

  public static a.a a(String paramString, BotReplyRequest paramBotReplyRequest)
  {
    l.a locala = l.n();
    if (da.a(paramString))
      locala.f(R.string.dialog_2116_message_regular);
    while (true)
    {
      return ((l.a)((l.a)((l.a)locala.i(R.string.dialog_button_share_number)).m(R.string.dialog_button_cancel).a(new ViberDialogHandlers.w())).a(paramBotReplyRequest)).a(DialogCode.D2116);
      locala.b(R.string.dialog_2116_message, new Object[] { paramString });
    }
  }

  public static h.a a(CharSequence paramCharSequence)
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.D404)).d(R.string.dialog_404_title)).a(ViberApplication.getLocalizedResources().getString(R.string.dialog_404_message, new Object[] { paramCharSequence }))).i(R.string.dialog_button_close);
  }

  private static k.a<?> a(int paramInt, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, long paramLong3, String paramString4, boolean paramBoolean, TermsAndConditionsActivity.a parama, String paramString5, ViberDialogHandlers.k paramk)
  {
    paramk.a = paramInt;
    paramk.b = paramLong1;
    paramk.c = paramLong2;
    paramk.d = paramString2;
    paramk.e = paramString3;
    paramk.f = paramLong3;
    paramk.g = paramString4;
    paramk.i = parama;
    paramk.j = paramString5;
    paramk.h = paramBoolean;
    paramk.k = paramString1;
    k.a locala = (k.a)((k.a)k.l().a(paramk)).e(true);
    if ((parama == TermsAndConditionsActivity.a.c) || (parama == TermsAndConditionsActivity.a.d) || (parama == TermsAndConditionsActivity.a.g));
    for (int i = R.string.dialog_button_accept_and_follow; ; i = R.string.dialog_button_accept)
      return ((k.a)((k.a)((k.a)((k.a)locala.i(i)).m(R.string.dialog_button_cancel)).k(R.string.dialog_button_view_terms_of_use).e("Accept")).i("Dismiss")).g("View");
  }

  public static l.a a()
  {
    return (l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D1002a)).d(R.string.dialog_1002a_title)).f(R.string.dialog_1002a_message)).i(R.string.dialog_button_decline);
  }

  public static l.a a(az.a parama, LinkedList<Long> paramLinkedList)
  {
    ViberDialogHandlers.br localbr = new ViberDialogHandlers.br();
    localbr.a = parama;
    localbr.b = paramLinkedList;
    return (l.a)((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D1028)).a(false)).f(R.string.dialog_1028_message)).a(localbr)).i(R.string.dialog_button_yes);
  }

  public static a.a b(int paramInt, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, long paramLong3, String paramString4, TermsAndConditionsActivity.a parama, String paramString5)
  {
    return ((k.a)((k.a)a(paramInt, paramLong1, paramLong2, paramString1, paramString2, paramString3, paramLong3, paramString4, true, parama, paramString5, new ViberDialogHandlers.k()).d(R.string.dialog_1022a_title)).f(R.string.dialog_1022a_message)).a(DialogCode.D1022a);
  }

  public static h.a b()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.D1003b)).d(R.string.dialog_1003_title)).f(R.string.dialog_1003b_message)).i(R.string.dialog_button_ok);
  }

  public static h.a c()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.D1004)).d(R.string.dialog_1004_title)).a(false)).i(R.string.dialog_button_ok);
  }

  public static l.a d()
  {
    return ((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D1005)).d(R.string.dialog_1005_title)).f(R.string.dialog_1005_message)).i(R.string.dialog_button_ok)).m(R.string.dialog_button_cancel);
  }

  public static l.a e()
  {
    return ((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D1005a)).d(R.string.dialog_1005a_title)).f(R.string.dialog_1005a_message)).i(R.string.dialog_button_ok)).m(R.string.dialog_button_cancel);
  }

  public static l.a f()
  {
    return (l.a)((l.a)((l.a)((l.a)l.n().d(R.string.dialog_1009_title)).f(R.string.dialog_1009_body)).i(R.string.dialog_button_leave)).a(DialogCode.D1009);
  }

  public static l.a g()
  {
    return (l.a)((l.a)((l.a)((l.a)l.n().d(R.string.dialog_1012_title)).f(R.string.dialog_1012a_message)).i(R.string.dialog_button_add)).m(R.string.dialog_button_cancel).a(DialogCode.D1012a);
  }

  public static l.a h()
  {
    return (l.a)((l.a)((l.a)((l.a)l.n().d(R.string.dialog_1019_title)).f(R.string.dialog_1019_message)).i(R.string.dialog_button_ok)).m(R.string.dialog_button_cancel).a(DialogCode.D1019);
  }

  public static h.a i()
  {
    return (h.a)((h.a)h.j().a(DialogCode.D1025a)).f(R.string.dialog_1025a_message);
  }

  public static h.a j()
  {
    return (h.a)((h.a)((h.a)h.j().a(DialogCode.D1026)).d(R.string.dialog_1026_title)).f(R.string.dialog_1026_message);
  }

  public static h.a k()
  {
    return (h.a)((h.a)h.j().a(DialogCode.D1027)).f(R.string.dialog_1027_message);
  }

  public static l.a l()
  {
    return (l.a)((l.a)((l.a)l.n().a(DialogCode.D1028)).f(R.string.dialog_1028_message)).i(R.string.dialog_button_yes);
  }

  public static a.a m()
  {
    return ((k.a)((k.a)((k.a)((k.a)((k.a)k.l().e(false)).i(R.string.dialog_button_accept)).m(R.string.dialog_button_cancel)).k(R.string.dialog_button_view_terms_of_use).d(R.string.dialog_2104_title)).f(R.string.dialog_2104_message)).a(DialogCode.D2104);
  }

  public static a.a n()
  {
    return ((h.a)((h.a)h.j().d(R.string.dialog_2100_title)).f(R.string.dialog_2100_message)).a(DialogCode.D2100);
  }

  public static a.a o()
  {
    return ((h.a)((h.a)h.j().d(R.string.dialog_2101_title)).f(R.string.dialog_2101_message)).a(DialogCode.D2101);
  }

  public static a.a p()
  {
    return ((l.a)((l.a)((l.a)l.n().i(R.string.dialog_button_unpublish)).d(R.string.dialog_2105_title)).f(R.string.dialog_2105_body)).a(DialogCode.D2105);
  }

  public static a.a q()
  {
    return ((h.a)((h.a)h.j().d(R.string.dialog_2107_title)).f(R.string.dialog_2107_body)).i(R.string.ok_btn_text).a(DialogCode.D2107);
  }

  public static a.a r()
  {
    return ((l.a)((l.a)l.n().d(R.string.dialog_2108_title)).f(R.string.dialog_2108_body)).a(DialogCode.D2108);
  }

  public static a.a s()
  {
    return ((l.a)((l.a)((l.a)l.n().d(R.string.dialog_2109_title)).f(R.string.dialog_2109_message)).i(R.string.dialog_button_discard)).a(DialogCode.D2109);
  }

  public static a.a t()
  {
    return ((l.a)((l.a)((l.a)l.n().d(R.string.dialog_2010_title)).f(R.string.dialog_2010_body)).i(R.string.ok_btn_text)).m(R.string.dialog_button_unsubscribe).a(DialogCode.D2010);
  }

  public static a.a u()
  {
    return ((h.a)h.j().d(R.string.dialog_2011_title)).i(R.string.ok_btn_text).a(DialogCode.D2011);
  }

  public static a.a v()
  {
    return ((l.a)((l.a)((l.a)l.n().d(R.string.dialog_2106_title)).f(R.string.dialog_2106_body)).i(R.string.dialog_button_disconnect)).m(R.string.dialog_button_cancel).a(DialogCode.D2106);
  }

  public static a.a w()
  {
    return ((k.a)((k.a)((k.a)((k.a)k.l().d(R.string.dialog_2010a_title)).f(R.string.dialog_2010a_body)).i(R.string.dialog_button_continue)).k(R.string.dialog_button_cancel).m(R.string.dialog_2010a_button_delete)).a(DialogCode.D2010a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.dialogs.r
 * JD-Core Version:    0.6.2
 */