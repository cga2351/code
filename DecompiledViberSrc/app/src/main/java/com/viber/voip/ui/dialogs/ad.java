package com.viber.voip.ui.dialogs;

import android.content.res.Resources;
import com.viber.common.dialogs.a;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.g;
import com.viber.common.dialogs.g.a;
import com.viber.common.dialogs.h;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.j.a;
import com.viber.common.dialogs.l;
import com.viber.common.dialogs.l.a;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.R.style;
import com.viber.voip.ViberApplication;
import com.viber.voip.contacts.ui.s.a;
import com.viber.voip.messages.conversation.ui.az.a;
import com.viber.voip.messages.ui.MessageComposerView;
import com.viber.voip.registration.ao;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserDataEditHelper.Listener;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.by;
import com.viber.voip.util.cj;
import java.util.LinkedList;

public class ad
{
  public static a.a<?> a(int paramInt)
  {
    return a.b().a(DialogCode.D_PROGRESS).b(false).b(R.id.message, paramInt).e(R.layout.progress_dialog_material);
  }

  public static g.a a(boolean paramBoolean)
  {
    if (!paramBoolean);
    for (int i = 1; ; i = 0)
    {
      int[] arrayOfInt = new int[3 - i];
      arrayOfInt[0] = R.string.dialog_c19_list_item_0;
      arrayOfInt[1] = R.string.dialog_c19_list_item_1;
      if (paramBoolean)
        arrayOfInt[2] = R.string.dialog_c19_list_item_2;
      return (g.a)g.j().a(arrayOfInt).a(DialogCode.DC19);
    }
  }

  public static h.a a()
  {
    if (by.b(ViberApplication.getApplication()))
      return f.a();
    if (cj.d(ViberApplication.getApplication()).booleanValue())
      return f.b();
    return f.c();
  }

  public static h.a a(CharSequence paramCharSequence)
  {
    return (h.a)((h.a)((h.a)h.j().a(DialogCode.DC35)).c("Info")).a(paramCharSequence);
  }

  public static h.a a(String paramString)
  {
    return (h.a)((h.a)((h.a)h.j().d(R.string.dialog_c12_title)).a(paramString)).a(DialogCode.DC12);
  }

  public static l.a a(az.a parama, LinkedList<Long> paramLinkedList)
  {
    ViberDialogHandlers.by localby = new ViberDialogHandlers.by();
    localby.a = parama;
    localby.b = paramLinkedList;
    return (l.a)((l.a)((l.a)((l.a)((l.a)l.n().f(R.string.dialog_c29_message)).a(localby)).a(false)).i(R.string.dialog_button_ok)).a(DialogCode.DC29);
  }

  public static l.a a(com.viber.voip.messages.conversation.ui.j paramj, long paramLong)
  {
    ViberDialogHandlers.bs localbs = new ViberDialogHandlers.bs();
    localbs.a = paramLong;
    localbs.b = paramj;
    return (l.a)((l.a)((l.a)((l.a)((l.a)l.n().f(R.string.dialog_c13_message)).a(localbs)).a(false)).i(R.string.dialog_button_yes)).a(DialogCode.DC13);
  }

  public static l.a a(com.viber.voip.messages.conversation.ui.j paramj, long paramLong, boolean paramBoolean)
  {
    ViberDialogHandlers.bx localbx = new ViberDialogHandlers.bx();
    localbx.a = paramLong;
    localbx.b = paramj;
    localbx.c = paramBoolean;
    return (l.a)((l.a)((l.a)((l.a)((l.a)l.n().f(R.string.dialog_c28_message)).a(localbx)).a(false)).i(R.string.dialog_button_yes)).a(DialogCode.DC28);
  }

  public static l.a a(MessageComposerView paramMessageComposerView)
  {
    return (l.a)((l.a)((l.a)((l.a)((l.a)d().a(DialogCode.DC26)).c("Enter sticker id")).i(R.string.dialog_button_ok)).a(false)).a(new ViberDialogHandlers.bv(null, paramMessageComposerView));
  }

  public static l.a a(e.b paramb, String paramString)
  {
    return (l.a)((l.a)((l.a)((l.a)((l.a)((l.a)l.n().d(R.string.dialog_1029_title)).a(paramString)).a(paramb)).a(false)).i(R.string.dialog_button_delete)).a(DialogCode.D1029);
  }

  public static l.a a(UserDataEditHelper.Listener paramListener, boolean paramBoolean)
  {
    String str = UserManager.from(ViberApplication.getApplication()).getUserData().getViberName();
    return (l.a)((l.a)((l.a)((l.a)d().a(DialogCode.DC27)).d(R.string.dialog_429_title)).a(false)).a(new ViberDialogHandlers.bw(str, paramListener, paramBoolean));
  }

  public static l.a a(String paramString1, String paramString2, String paramString3, s.a parama)
  {
    return (l.a)((l.a)((l.a)((l.a)l.n().a(DialogCode.DC44)).f(R.string.dialog_c44_message)).i(R.string.dialog_button_ok)).m(R.string.dialog_button_suggest_update).a(new ViberDialogHandlers.cb(paramString1, paramString2, paramString3, parama));
  }

  public static a.a<?> b()
  {
    return a(R.string.progress_dialog_loading);
  }

  public static l.a b(String paramString)
  {
    Resources localResources = ViberApplication.getLocalizedResources();
    return (l.a)((l.a)((l.a)((l.a)((l.a)((l.a)((l.a)l.n().a(localResources.getString(R.string.dialog_c16_title, new Object[] { paramString }))).a(localResources.getString(R.string.dialog_c16_message, new Object[] { paramString }))).e(true)).a(paramString)).i(R.string.dialog_button_invite)).e("Invite")).a(DialogCode.DC16);
  }

  public static a.a<?> c()
  {
    return a.b().a(DialogCode.D_PROGRESS_OVERLAY).e(R.layout.progress_overlay);
  }

  static l.a<?> d()
  {
    return ((l.a)((l.a)l.n().e(R.layout.dialog_content_edit_text)).i(R.string.dialog_button_save)).m(R.string.dialog_button_cancel);
  }

  public static h.a e()
  {
    return (h.a)((h.a)((h.a)h.j().a(DialogCode.DC18)).d(R.string.dialog_c18_title)).f(R.string.dialog_c18_message);
  }

  public static h.a f()
  {
    h.a locala = (h.a)((h.a)h.j().a(DialogCode.DC21)).d(R.string.dialog_c21_title);
    if (ao.f());
    for (int i = R.string.dialog_c21_message_secondary; ; i = R.string.dialog_c21_message)
      return ((h.a)locala.f(i)).i(R.string.dialog_button_ok);
  }

  public static l.a g()
  {
    return ((l.a)((l.a)((l.a)l.n().a(DialogCode.DC22)).f(R.string.dialog_c22_message)).i(R.string.dialog_button_remove_photo)).m(R.string.dialog_button_cancel);
  }

  public static h.a h()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.DC23)).d(R.string.dialog_c23_title)).f(R.string.dialog_c23_message)).i(R.string.dialog_button_ok);
  }

  public static l.a i()
  {
    return (l.a)((l.a)((l.a)((l.a)d().a(DialogCode.DC25)).c("Enter package id")).i(R.string.dialog_button_ok)).a(new ViberDialogHandlers.bu());
  }

  public static l.a j()
  {
    return (l.a)((l.a)((l.a)((l.a)d().a(DialogCode.DC30)).c("Enter app id")).i(R.string.dialog_button_ok)).a(new ViberDialogHandlers.bz());
  }

  public static l.a k()
  {
    return (l.a)((l.a)((l.a)((l.a)d().a(DialogCode.DC31)).c("Enter splash content URL")).i(R.string.dialog_button_ok)).a(new ViberDialogHandlers.ca("http://"));
  }

  public static j.a<?> l()
  {
    return (j.a)((j.a)com.viber.common.dialogs.j.m().a(DialogCode.DC36)).d(R.string.create_public_account_select_category_hint);
  }

  public static j.a<?> m()
  {
    return (j.a)((j.a)com.viber.common.dialogs.j.m().a(DialogCode.DC37)).d(R.string.create_public_account_select_subcategory_hint);
  }

  public static h.a n()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.DC39)).d(R.string.dialog_c39_title)).f(R.string.dialog_c39_message)).i(R.string.dialog_button_view);
  }

  public static h.a o()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.DC40)).a(false)).f(R.string.dialog_c40_message)).i(R.string.dialog_button_ok);
  }

  public static h.a p()
  {
    return ((h.a)((h.a)((h.a)h.j().a(false)).a(DialogCode.DC41)).f(R.string.dialog_c41_message)).i(R.string.dialog_button_ok);
  }

  public static h.a q()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.DC42)).a(false)).f(R.string.dialog_c42_message)).i(R.string.dialog_button_ok);
  }

  public static h.a r()
  {
    return ((h.a)((h.a)((h.a)h.j().a(DialogCode.DC43)).a(false)).f(R.string.dialog_c43_message)).i(R.string.dialog_button_ok);
  }

  public static l.a s()
  {
    return (l.a)((l.a)((l.a)((l.a)((l.a)d().a(DialogCode.DC45)).c("Enter max number of recipients")).a("Min value is 2")).i(R.string.dialog_button_ok)).a(new ViberDialogHandlers.cc());
  }

  public static h.a t()
  {
    return ((h.a)((h.a)((h.a)((h.a)((h.a)h.j().a(DialogCode.DC46)).c("Restart")).a("You are about to restart Viber to apply changes")).a(new ViberDialogHandlers.cd())).b(false)).i(R.string.dialog_button_ok);
  }

  public static l.a u()
  {
    return (l.a)((l.a)((l.a)((l.a)((l.a)((l.a)((l.a)((l.a)l.n().e(R.layout.sync_history_to_desktop_approve)).h(R.style.Theme_Viber_FullWidthDialog_SyncHistory)).a(R.id.title_text, R.string.dialog_approve_sync_history_desktop_title)).b(R.id.body_text, R.string.dialog_approve_sync_history_desktop_message)).c(R.id.sync_button, R.string.dialog_button_sync)).d(R.id.dismiss_button, null).a(new ViberDialogHandlers.a())).b(false)).a(DialogCode.D_APPROVE_SYNC_HISTORY_TO_DESKTOP);
  }

  public static h.a v()
  {
    return (h.a)((h.a)((h.a)((h.a)((h.a)((h.a)h.j().e(R.layout.syncing_history_to_desktop)).h(R.style.Theme_Viber_FullWidthDialog_SyncHistory)).a(R.id.title_text, R.string.dialog_syncing_history_desktop_title)).b(R.id.body_text, R.string.dialog_syncing_history_desktop_message)).c(R.id.sync_button, R.string.dialog_button_got_it).a(new ViberDialogHandlers.ct())).a(DialogCode.D_SYNCING_HISTORY_TO_DESKTOP);
  }

  public static a.a w()
  {
    return a.b().e(R.layout.dialog_cpn_verify_account).h(R.style.Theme_Viber_FullWidthDialog).a(R.id.title_text, R.string.verify_your_account).b(R.id.body_text, R.string.select_account).a(DialogCode.D_CPN_VERIFY_ACCOUNT);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.dialogs.ad
 * JD-Core Version:    0.6.2
 */