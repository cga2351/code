package com.viber.voip.ui.dialogs;

import com.viber.common.dialogs.e.a;
import com.viber.common.dialogs.h;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.k;
import com.viber.common.dialogs.k.a;
import com.viber.common.dialogs.l;
import com.viber.common.dialogs.l.a;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.util.ParcelableInt;
import java.util.ArrayList;

public class d
{
  public static h.a a()
  {
    return (h.a)((h.a)((h.a)h.j().a(DialogCode.D1032)).f(R.string.dialog_1032_body_up)).i(R.string.dialog_button_ok).a(false);
  }

  public static k.a a(e.b paramb, String paramString)
  {
    return (k.a)((k.a)((k.a)((k.a)((k.a)((k.a)((k.a)k.l().a(DialogCode.D1029a)).d(R.string.dialog_1029_title)).b(R.string.dialog_1029a_body, new Object[] { paramString })).i(R.string.dialog_button_delete_all)).k(R.string.dialog_button_delete_all_and_ban).m(R.string.dialog_button_cancel)).a(paramb)).a(false);
  }

  public static l.a a(String paramString)
  {
    return (l.a)((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D1030)).d(R.string.dialog_1030_title)).b(R.string.dialog_1030_body, new Object[] { paramString })).i(R.string.dialog_button_yes)).a(false);
  }

  public static l.a a(String paramString1, String paramString2)
  {
    return (l.a)((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D1040a)).d(R.string.dialog_1040a_title)).b(R.string.dialog_1040a_body, new Object[] { paramString1, paramString2 })).i(R.string.dialog_button_go_to_banned_users)).m(R.string.dialog_button_cancel).a(false);
  }

  public static h.a b()
  {
    return (h.a)((h.a)((h.a)h.j().a(DialogCode.D1032b)).f(R.string.dialog_1032b_body)).i(R.string.dialog_button_ok).a(false);
  }

  public static l.a b(String paramString)
  {
    return ((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D1037)).d(R.string.dialog_1037_title)).b(R.string.dialog_1037_body, new Object[] { paramString })).i(R.string.dialog_button_ban)).m(R.string.dialog_button_cancel);
  }

  public static h.a c()
  {
    return (h.a)((h.a)((h.a)h.j().a(DialogCode.D1032c)).f(R.string.dialog_1032c_body)).i(R.string.dialog_button_ok).a(false);
  }

  public static l.a c(String paramString)
  {
    return (l.a)((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D1040)).d(R.string.dialog_1040_title)).b(R.string.dialog_1040_body, new Object[] { paramString })).i(R.string.dialog_button_unban_user)).m(R.string.dialog_button_cancel).a(false);
  }

  public static h.a d()
  {
    return (h.a)((h.a)((h.a)h.j().a(DialogCode.D1032d)).f(R.string.dialog_1032d_body)).i(R.string.dialog_button_ok).a(false);
  }

  public static h.a e()
  {
    return (h.a)((h.a)((h.a)h.j().a(DialogCode.D1032e)).f(R.string.dialog_1032e_body)).i(R.string.dialog_button_ok).a(false);
  }

  public static h.a f()
  {
    return (h.a)((h.a)((h.a)h.j().a(DialogCode.D1032f)).f(R.string.dialog_1032f_body)).i(R.string.dialog_button_ok).a(false);
  }

  public static h.a g()
  {
    return (h.a)((h.a)((h.a)h.j().a(DialogCode.D1032g)).f(R.string.dialog_1032g_body)).i(R.string.dialog_button_ok).a(false);
  }

  public static h.a h()
  {
    return (h.a)((h.a)((h.a)h.j().a(DialogCode.D1032h)).f(R.string.dialog_1032h_body)).i(R.string.dialog_button_ok).a(false);
  }

  public static l.a i()
  {
    return ((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D1012c)).d(R.string.dialog_1012c_title)).f(R.string.dialog_1012c_body)).i(R.string.dialog_button_add)).m(R.string.dialog_button_cancel);
  }

  public static h.a j()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.D1033)).a(false)).f(R.string.dialog_1033_body)).i(R.string.dialog_button_okay);
  }

  public static l.a k()
  {
    return ((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D1012d)).d(R.string.dialog_1012d_title)).f(R.string.dialog_1012d_body)).i(R.string.dialog_button_add)).m(R.string.dialog_button_cancel);
  }

  public static l.a l()
  {
    return ((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D1036)).d(R.string.dialog_1036_title)).f(R.string.dialog_1036_body)).i(R.string.dialog_button_ok)).m(R.string.dialog_button_cancel);
  }

  public static h.a m()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.D1038)).d(R.string.dialog_1038_title)).f(R.string.dialog_1038_body)).i(R.string.dialog_button_close);
  }

  public static l.a n()
  {
    return ((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D1039)).d(R.string.dialog_1039_title)).f(R.string.dialog_1039_body)).i(R.string.dialog_button_okay)).m(R.string.dialog_button_cancel);
  }

  public static l.a o()
  {
    return (l.a)((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D1040b)).d(R.string.dialog_1040a_title)).f(R.string.dialog_1040b_body)).i(R.string.dialog_button_go_to_banned_users)).m(R.string.dialog_button_cancel).a(false);
  }

  public static l.a p()
  {
    return ((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D1041)).d(R.string.dialog_1041_title)).f(R.string.dialog_1041_body)).i(R.string.dialog_button_go_to_banned_users)).m(R.string.dialog_button_cancel);
  }

  public static h.a q()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.D1043)).d(R.string.dialog_1043_title)).f(R.string.dialog_1043_body)).i(R.string.dialog_button_close);
  }

  public static h.a r()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.D1044)).d(R.string.dialog_1043_title)).f(R.string.dialog_1044_body)).i(R.string.dialog_button_close);
  }

  public static h.a s()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.D1046)).d(R.string.dialog_1046_title)).f(R.string.dialog_1046_message)).i(R.string.dialog_button_ok);
  }

  public static h.a t()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.D3013)).d(R.string.dialog_3013_title)).f(R.string.dialog_3013_body)).i(R.string.dialog_button_close);
  }

  public static e.a u()
  {
    ArrayList localArrayList = new ArrayList();
    com.viber.voip.report.a.a.e[] arrayOfe = com.viber.voip.report.a.a.e.values();
    int i = arrayOfe.length;
    for (int j = 0; j < i; j++)
      localArrayList.add(new ParcelableInt(arrayOfe[j].ordinal()));
    return (e.a)((e.a)com.viber.common.dialogs.e.j().a(DialogCode.D_COMMUNITY_REPORT_REASONS)).i(R.layout.bottom_sheet_dialog_item_red).a(localArrayList).a(new ViberDialogHandlers.cf());
  }

  public static l.a v()
  {
    return (l.a)((l.a)((l.a)ad.d().a(DialogCode.DC47)).i(R.string.dialog_button_send)).a(new ViberDialogHandlers.ce());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.dialogs.d
 * JD-Core Version:    0.6.2
 */