package com.viber.voip.ui.dialogs;

import android.content.Context;
import com.viber.common.dialogs.h;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.k;
import com.viber.common.dialogs.k.a;
import com.viber.common.dialogs.l;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.y;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.orm.entity.json.action.OpenUrlAction;

public class u
{
  public static k.a a(boolean paramBoolean1, Member paramMember, OpenUrlAction paramOpenUrlAction, boolean paramBoolean2)
  {
    k.a locala1 = (k.a)((k.a)k.l().a(DialogCode.D1400b)).e(R.layout.dialog_1400b);
    int i = R.id.btn_save_contact_and_open_link;
    String str;
    k.a locala2;
    if (paramBoolean2)
    {
      str = y.a().getString(R.string.dialog_button_save_sender_and_open);
      locala2 = (k.a)((k.a)locala1.b(i, str)).d(R.id.btn_open_link, R.string.dialog_button_open_link).e(R.id.btn_block_and_report, R.string.spam_banner_report_btn);
      if (paramBoolean1)
        break label118;
    }
    label118: for (boolean bool = true; ; bool = false)
    {
      return (k.a)((k.a)locala2.a(new ViberDialogHandlers.D1400b(bool, paramBoolean1, paramMember))).a(paramOpenUrlAction);
      str = null;
      break;
    }
  }

  public static l.a a()
  {
    return (l.a)((l.a)((l.a)((l.a)((l.a)l.n().d(R.string.dialog_424b_title)).f(R.string.dialog_424b_body)).a(DialogCode.D424b)).i(R.string.dialog_button_yes)).m(R.string.dialog_button_no).a(false);
  }

  public static l.a a(OpenUrlAction paramOpenUrlAction)
  {
    return (l.a)((l.a)((l.a)((l.a)((l.a)l.n().d(R.string.dialog_1400_title)).f(R.string.dialog_1400_message)).a(DialogCode.D1400)).a(new ViberDialogHandlers.p())).a(paramOpenUrlAction);
  }

  public static l.a b()
  {
    return (l.a)((l.a)((l.a)((l.a)((l.a)l.n().d(R.string.dialog_3901_title)).f(R.string.dialog_3901_body)).a(DialogCode.D3901)).i(R.string.dialog_button_block_msg)).m(R.string.dialog_button_accept_msg).a(false);
  }

  public static h.a c()
  {
    return (h.a)((h.a)((h.a)((h.a)h.j().d(R.string.dialog_3902_title)).f(R.string.dialog_3902_body)).a(DialogCode.D3902)).a(false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.dialogs.u
 * JD-Core Version:    0.6.2
 */