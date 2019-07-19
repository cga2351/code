package com.viber.voip.ui.dialogs;

import android.content.Context;
import com.viber.common.dialogs.h;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.y;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.invitelinks.CommunityFollowerData;
import com.viber.voip.messages.conversation.ui.j;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.util.da;

public class l
{
  public static h.a a()
  {
    return ((h.a)((h.a)h.j().a(DialogCode.D500)).f(R.string.dialog_500_message)).i(R.string.dialog_button_ok);
  }

  public static l.a a(long paramLong, String paramString)
  {
    return (l.a)((l.a)((l.a)ad.d().a(DialogCode.D509)).c(paramString)).a(new ViberDialogHandlers.be(paramLong, paramString));
  }

  public static l.a a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, PublicAccount paramPublicAccount)
  {
    return (l.a)((l.a)((l.a)((l.a)ad.d().a(DialogCode.D509)).c(paramString)).a(new ViberDialogHandlers.bd(paramString, paramLong, paramBoolean1, paramBoolean2))).a(paramPublicAccount);
  }

  public static l.a a(CommunityFollowerData paramCommunityFollowerData, int paramInt)
  {
    Context localContext = y.a();
    if (da.a(paramCommunityFollowerData.userName));
    int i;
    Object[] arrayOfObject;
    for (StringBuilder localStringBuilder = new StringBuilder(localContext.getString(R.string.dialog_follow_community_welcome_without_name)); ; localStringBuilder = new StringBuilder(localContext.getString(i, arrayOfObject)))
    {
      if (!da.a(paramCommunityFollowerData.tagLine))
        localStringBuilder.append("\n\n").append(paramCommunityFollowerData.tagLine);
      l.a locala = (l.a)((l.a)((l.a)((l.a)((l.a)((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().a(DialogCode.D_FOLLOW_COMMUNITY_WELCOME)).e(R.layout.dialog_follow_community_welcome)).a(R.id.group_name, paramCommunityFollowerData.groupName)).a(R.id.description, localStringBuilder)).c(R.id.btn_follow, R.string.dialog_button_follow)).e(R.id.btn_cancel, R.string.dialog_button_cancel).a(paramCommunityFollowerData)).h()).a(new ViberDialogHandlers.ch());
      if (!ViberApplication.isTablet(localContext))
        locala.a(paramInt);
      return locala;
      i = R.string.dialog_follow_community_welcome_with_name;
      arrayOfObject = new Object[1];
      arrayOfObject[0] = paramCommunityFollowerData.userName;
    }
  }

  public static l.a a(j paramj, Pin paramPin)
  {
    ViberDialogHandlers.cr localcr = new ViberDialogHandlers.cr();
    localcr.a = paramj;
    localcr.b = paramPin;
    return (l.a)((l.a)((l.a)((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().d(R.string.dialog_530_title)).f(R.string.dialog_530_message)).a(localcr)).a(false)).i(R.string.pin)).a(DialogCode.D530);
  }

  public static l.a a(String paramString)
  {
    ViberDialogHandlers.bc localbc = new ViberDialogHandlers.bc();
    localbc.a = paramString;
    return ((l.a)((l.a)((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().a(DialogCode.D507c)).d(R.string.dialog_507c_title)).f(R.string.dialog_507c_message)).a(localbc)).i(R.string.dialog_button_invite)).m(R.string.dialog_button_cancel);
  }

  public static l.a a(String paramString, PublicAccount paramPublicAccount)
  {
    return (l.a)((l.a)((l.a)((l.a)ad.d().a(DialogCode.D2002a)).d(R.string.dialog_2002a_title)).a(new ViberDialogHandlers.t(paramString))).a(paramPublicAccount);
  }

  public static h.a b()
  {
    return (h.a)((h.a)((h.a)h.j().d(R.string.dialog_507_title)).f(R.string.dialog_507_message)).a(DialogCode.D507);
  }

  public static l.a b(j paramj, Pin paramPin)
  {
    ViberDialogHandlers.cr localcr = new ViberDialogHandlers.cr();
    localcr.a = paramj;
    localcr.b = paramPin;
    return (l.a)((l.a)((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().d(R.string.dialog_531_title)).f(R.string.dialog_531_message)).a(localcr)).a(false)).a(DialogCode.D531);
  }

  public static l.a b(String paramString)
  {
    return (l.a)((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().a(DialogCode.D343e)).b(R.string.dialog_343e_message, new Object[] { paramString })).i(R.string.dialog_button_ok)).m(R.string.dialog_button_cancel).a(false);
  }

  public static h.a c()
  {
    return ((h.a)((h.a)((h.a)((h.a)h.j().a(DialogCode.D513)).d(R.string.dialog_513_title)).f(R.string.dialog_513_message)).a(false)).i(R.string.dialog_button_ok);
  }

  public static h.a d()
  {
    return (h.a)((h.a)h.j().f(R.string.dialog_514_message)).a(DialogCode.D514);
  }

  public static l.a e()
  {
    return (l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().d(R.string.dialog_521_title)).f(R.string.dialog_521_message)).a(DialogCode.D521);
  }

  public static l.a f()
  {
    return (l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().d(R.string.dialog_521a_title)).f(R.string.dialog_521_message)).a(DialogCode.D521);
  }

  public static h.a g()
  {
    return ((h.a)((h.a)h.j().a(DialogCode.D522)).f(R.string.dialog_522_message)).i(R.string.dialog_button_ok);
  }

  public static h.a h()
  {
    return (h.a)((h.a)((h.a)h.j().a(DialogCode.D280)).d(R.string.dialog_280_title)).f(R.string.dialog_280_body);
  }

  public static h.a i()
  {
    return (h.a)((h.a)((h.a)h.j().a(DialogCode.D280a)).d(R.string.dialog_280a_title)).f(R.string.dialog_280a_body);
  }

  public static l.a j()
  {
    return ((l.a)((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().a(DialogCode.D280c)).d(R.string.dialog_280c_title)).f(R.string.dialog_280c_body)).i(R.string.dialog_button_ok)).m(R.string.dialog_button_cancel);
  }

  public static h.a k()
  {
    return (h.a)((h.a)((h.a)h.j().a(DialogCode.D280e)).d(R.string.dialog_280e_title)).f(R.string.dialog_280e_message);
  }

  public static l.a l()
  {
    return ((l.a)((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().a(DialogCode.D280f)).d(R.string.dialog_280f_title)).f(R.string.dialog_280f_message)).i(R.string.dialog_button_ok)).m(R.string.dialog_button_cancel);
  }

  public static l.a m()
  {
    return ((l.a)((l.a)((l.a)com.viber.common.dialogs.l.n().a(DialogCode.D1034)).f(R.string.dialog_1034_message)).i(R.string.dialog_button_ok)).m(R.string.dialog_button_cancel);
  }

  public static h.a n()
  {
    return (h.a)((h.a)((h.a)h.j().d(R.string.dialog_532_title)).f(R.string.dialog_532_message)).a(DialogCode.D532);
  }

  public static h.a o()
  {
    return ((h.a)((h.a)h.j().a(DialogCode.D500)).f(R.string.dialog_500b_message)).i(R.string.dialog_button_ok);
  }

  public static h.a p()
  {
    return ((h.a)((h.a)h.j().a(DialogCode.D1035)).f(R.string.dialog_1035_title)).i(R.string.dialog_button_okay);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.dialogs.l
 * JD-Core Version:    0.6.2
 */