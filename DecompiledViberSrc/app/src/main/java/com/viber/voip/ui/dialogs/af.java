package com.viber.voip.ui.dialogs;

import android.content.res.Resources;
import com.viber.common.dialogs.h;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l;
import com.viber.common.dialogs.l.a;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.billing.PurchaseSupportActivity.a;
import com.viber.voip.util.da;

public class af
{
  public static h.a a()
  {
    return (h.a)((h.a)((h.a)((h.a)((h.a)h.j().e(true)).a(PurchaseSupportActivity.a.b)).d(R.string.dialog_614_title)).f(R.string.dialog_614_message)).a(DialogCode.D614);
  }

  public static h.a a(String paramString)
  {
    return (h.a)((h.a)((h.a)((h.a)((h.a)h.j().e(true)).a(PurchaseSupportActivity.a.b)).a(h().getString(R.string.dialog_615_message) + "\n(" + paramString + ")")).a(DialogCode.D615)).a(new ViberDialogHandlers.bh());
  }

  public static h.a a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1;
    if ((paramString != null) && (!paramBoolean2))
    {
      str1 = h().getString(R.string.dialog_604_message, new Object[] { paramString });
      if (!paramBoolean2)
        break label105;
    }
    label105: for (String str2 = ""; ; str2 = h().getString(R.string.dialog_604_title))
    {
      return (h.a)((h.a)((h.a)((h.a)((h.a)((h.a)h.j().e(true)).c(str2)).a(str1)).c(-1001)).a(DialogCode.D604)).a(new ViberDialogHandlers.bf(paramBoolean1));
      str1 = h().getString(R.string.purchase_completed);
      break;
    }
  }

  public static h.a a(boolean paramBoolean)
  {
    return (h.a)((h.a)((h.a)((h.a)((h.a)((h.a)h.j().e(true)).d(R.string.dialog_605_title)).f(R.string.dialog_605_message)).c(-1001)).a(DialogCode.D605)).a(new ViberDialogHandlers.bg(paramBoolean));
  }

  public static l.a a(String paramString1, String paramString2)
  {
    if (!da.a(paramString2));
    for (String str = h().getString(R.string.dialog_602_message, new Object[] { paramString1, paramString2 }); ; str = h().getString(R.string.dialog_602_message_no_rate, new Object[] { paramString1 }))
      return (l.a)((l.a)((l.a)((l.a)((l.a)((l.a)l.n().e(true)).d(R.string.dialog_602_title)).a(str)).i(R.string.dialog_button_call)).m(R.string.dialog_button_no_thanks).e("Call")).i("No Thanks").a(DialogCode.D602);
  }

  public static h.a b()
  {
    return (h.a)((h.a)((h.a)((h.a)((h.a)((h.a)h.j().e(true)).a(PurchaseSupportActivity.a.b)).d(R.string.dialog_618a_title)).f(R.string.dialog_618a_message)).a(DialogCode.D618a)).a(new ViberDialogHandlers.bi());
  }

  public static h.a b(String paramString)
  {
    ViberDialogHandlers.bj localbj = new ViberDialogHandlers.bj();
    localbj.a = paramString;
    return (h.a)((h.a)((h.a)((h.a)h.j().e(R.layout.dialog_content_inapp_error)).a(PurchaseSupportActivity.a.b)).a(DialogCode.D620)).a(localbj);
  }

  public static h.a b(boolean paramBoolean)
  {
    h.a locala = h.j();
    if (paramBoolean);
    for (int i = R.string.dialog_3010_message_plural; ; i = R.string.dialog_3010_message_singular)
      return (h.a)((h.a)locala.f(i)).a(DialogCode.D3010);
  }

  public static h.a c()
  {
    return (h.a)((h.a)((h.a)((h.a)((h.a)h.j().e(true)).a(PurchaseSupportActivity.a.b)).d(R.string.dialog_619_title)).f(R.string.dialog_619_message)).a(DialogCode.D619);
  }

  public static h.a d()
  {
    return (h.a)((h.a)((h.a)h.j().d(R.string.dialog_3002_title)).f(R.string.dialog_3002_message)).a(DialogCode.D3002);
  }

  public static h.a e()
  {
    return (h.a)((h.a)((h.a)h.j().d(R.string.dialog_622dev_title)).f(R.string.dialog_622dev_message)).a(DialogCode.D3003);
  }

  public static h.a f()
  {
    return (h.a)((h.a)((h.a)((h.a)h.j().b(false)).d(R.string.dialog_3011_title)).f(R.string.dialog_3011_message)).a(DialogCode.D3011);
  }

  public static l.a g()
  {
    return (l.a)((l.a)((l.a)((l.a)((l.a)l.n().a(new ViberDialogHandlers.bk())).d(R.string.dialog_624_title)).f(R.string.dialog_624_message)).i(R.string.dialog_button_ok)).m(R.string.dialog_button_learn_more).a(DialogCode.D624);
  }

  private static Resources h()
  {
    return ViberApplication.getLocalizedResources();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.dialogs.af
 * JD-Core Version:    0.6.2
 */