package com.viber.voip.ui.dialogs;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import com.viber.common.dialogs.h;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.k;
import com.viber.common.dialogs.k.a;
import com.viber.common.dialogs.l;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m.a;
import com.viber.common.dialogs.y;
import com.viber.voip.R.plurals;
import com.viber.voip.R.string;

public class b
{
  public static h.a a()
  {
    return ((h.a)((h.a)h.j().a(DialogCode.D302)).f(R.string.dialog_302_message)).i(R.string.dialog_button_ok);
  }

  public static h.a a(String paramString)
  {
    ViberDialogHandlers.an localan = new ViberDialogHandlers.an();
    localan.a = paramString;
    return (h.a)((h.a)((h.a)h.j().a(DialogCode.D346e)).f(R.string.dialog_346e_message)).i(R.string.dialog_button_ok).a(localan);
  }

  public static h.a a(String paramString1, String paramString2)
  {
    return ((l.a)((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D1502)).d(R.string.dialog_1502_title)).b(R.string.dialog_1502_message, new Object[] { paramString1, paramString2 })).a(new ViberDialogHandlers.q())).i(R.string.dialog_button_ok)).m(R.string.dialog_button_learn_more);
  }

  public static k.a a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    return (k.a)((k.a)((k.a)((k.a)((k.a)((k.a)k.l().a(DialogCode.D1503)).d(R.string.dialog_1503_title)).b(R.string.dialog_1503_message, new Object[] { paramString1, paramString2 })).a(new ViberDialogHandlers.r(paramInt, paramArrayOfByte))).i(R.string.dialog_button_trust_contact)).k(R.string.dialog_button_learn_more).m(R.string.cancel_btn_text);
  }

  public static l.a a(int paramInt, CharSequence paramCharSequence)
  {
    l.a locala = (l.a)((l.a)l.n().a(DialogCode.D1101)).d(R.string.dialog_1101_title);
    Resources localResources = y.a().getResources();
    int i = R.plurals.dialog_1101_body;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Html.escapeHtml(paramCharSequence);
    return ((l.a)((l.a)locala.a(Html.fromHtml(localResources.getQuantityString(i, paramInt, arrayOfObject)))).i(R.string.dialog_button_send_update_link)).m(R.string.dialog_button_cancel);
  }

  public static l.a a(CharSequence paramCharSequence)
  {
    l.a locala = (l.a)((l.a)l.n().a(DialogCode.D1105)).d(R.string.dialog_1105_title);
    Context localContext = y.a();
    int i = R.string.dialog_1105_body;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Html.escapeHtml(paramCharSequence);
    return ((l.a)((l.a)locala.a(Html.fromHtml(localContext.getString(i, arrayOfObject)))).i(R.string.dialog_button_continue)).m(R.string.dialog_button_cancel);
  }

  public static l.a a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (Object localObject = new ViberDialogHandlers.ad(); ; localObject = new ViberDialogHandlers.ae())
      return (l.a)((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D316c)).d(R.string.dialog_316c_title)).f(R.string.dialog_316c_message)).i(R.string.dialog_button_ok)).m(R.string.dialog_button_learn_more).a((m.a)localObject);
  }

  public static h.a b(String paramString)
  {
    return (h.a)((h.a)((h.a)h.j().a(DialogCode.D1506a)).d(R.string.dialog_1506_title)).b(R.string.dialog_1506a_message, new Object[] { paramString });
  }

  public static k.a b(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    return (k.a)((k.a)((k.a)((k.a)((k.a)((k.a)k.l().a(DialogCode.D1504)).d(R.string.dialog_1504_title)).b(R.string.dialog_1504_message, new Object[] { paramString1, paramString2 })).a(new ViberDialogHandlers.r(paramInt, paramArrayOfByte))).i(R.string.retrust_contact)).k(R.string.dialog_button_learn_more).m(R.string.cancel_btn_text);
  }

  public static l.a b()
  {
    return ((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D303)).d(R.string.dialog_303_title)).f(R.string.dialog_303_message)).i(R.string.dialog_button_continue)).m(R.string.dialog_button_cancel);
  }

  public static l.a b(int paramInt, CharSequence paramCharSequence)
  {
    l.a locala = (l.a)((l.a)l.n().a(DialogCode.D1102)).d(R.string.dialog_1102_title);
    Resources localResources = y.a().getResources();
    int i = R.plurals.dialog_1102_body;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Html.escapeHtml(paramCharSequence);
    return ((l.a)((l.a)locala.a(Html.fromHtml(localResources.getQuantityString(i, paramInt, arrayOfObject)))).i(R.string.dialog_button_start_call)).m(R.string.dialog_button_cancel);
  }

  public static l.a c()
  {
    return (l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D310)).f(R.string.dialog_310_message)).b(false)).i(R.string.dialog_button_continue);
  }

  public static l.a d()
  {
    return ((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D326)).d(R.string.dialog_326_title)).f(R.string.dialog_326_message)).i(R.string.dialog_button_try_it)).m(R.string.dialog_button_no_thanks);
  }

  public static h.a e()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.D344)).d(R.string.dialog_344_title)).f(R.string.dialog_344_message)).i(R.string.dialog_button_ok);
  }

  public static h.a f()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.D344a)).d(R.string.dialog_344a_title)).f(R.string.dialog_344a_message)).i(R.string.dialog_button_ok);
  }

  public static h.a g()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.D345)).d(R.string.dialog_345_title)).f(R.string.dialog_345_message)).i(R.string.dialog_button_ok);
  }

  public static h.a h()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.D346d)).d(R.string.dialog_346d_title)).f(R.string.dialog_346d_message)).i(R.string.dialog_button_ok);
  }

  public static l.a i()
  {
    return (l.a)((l.a)((l.a)l.n().a(DialogCode.D335c)).f(R.string.dialog_335c_message)).i(R.string.dialog_button_continue);
  }

  public static l.a j()
  {
    return ((l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.D1103)).d(R.string.dialog_1103_title)).f(R.string.dialog_1103_body)).i(R.string.dialog_button_send_update_link)).m(R.string.dialog_button_cancel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.dialogs.b
 * JD-Core Version:    0.6.2
 */