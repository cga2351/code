package com.viber.voip.messages.conversation.ui.view.b;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.viber.common.b.b;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.k.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.z;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.voip.ConversationListView;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.msginfo.CommunityScreenshot;
import com.viber.voip.flatbuffers.model.msginfo.GroupReferralInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.market.StickerMarketActivity;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest;
import com.viber.voip.messages.controller.publicaccount.ae;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.d.ac;
import com.viber.voip.messages.conversation.adapter.d.e;
import com.viber.voip.messages.conversation.adapter.d.x;
import com.viber.voip.messages.conversation.publicaccount.g;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.f;
import com.viber.voip.messages.conversation.ui.f.b;
import com.viber.voip.messages.conversation.ui.presenter.MessagesActionsPresenter;
import com.viber.voip.messages.conversation.ui.view.j;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import com.viber.voip.messages.orm.entity.json.action.MessageOpenUrlAction;
import com.viber.voip.messages.shopchat.OpenShopChatPanelData;
import com.viber.voip.messages.ui.MessageComposerView;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout;
import com.viber.voip.messages.ui.media.LocationMessageActivityV2;
import com.viber.voip.model.entity.MessageCallEntity;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.settings.d.r;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.a.b.a;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.ah;
import com.viber.voip.ui.dialogs.e.b;
import com.viber.voip.ui.dialogs.k;
import com.viber.voip.ui.dialogs.r;
import com.viber.voip.ui.dialogs.u;
import com.viber.voip.ui.style.InternalURLSpan;
import com.viber.voip.ui.style.InternalURLSpan.a;
import com.viber.voip.ui.style.UserMentionSpan;
import com.viber.voip.ui.style.UserMentionSpan.a;
import com.viber.voip.user.PublicGroupParticipantDetailsActivity;
import com.viber.voip.util.ParcelableUtils;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.ViberActionRunner.ae;
import com.viber.voip.util.ViberActionRunner.ai;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.util.ViberActionRunner.be;
import com.viber.voip.util.ViberActionRunner.bm;
import com.viber.voip.util.ViberActionRunner.bn;
import com.viber.voip.util.ViberActionRunner.bt;
import com.viber.voip.util.ViberActionRunner.o;
import com.viber.voip.util.ViberActionRunner.r;
import com.viber.voip.util.ViberActionRunner.t;
import com.viber.voip.util.da;
import java.util.List;

public class p extends a<MessagesActionsPresenter>
  implements ac, e, x, f.b, j
{
  private static final Logger a = ViberEnv.getLogger();
  private com.viber.voip.messages.conversation.adapter.d b;
  private ExpandablePanelLayout g;
  private MessageComposerView h;

  public p(MessagesActionsPresenter paramMessagesActionsPresenter, Activity paramActivity, ConversationFragment paramConversationFragment, View paramView, com.viber.voip.messages.conversation.adapter.d paramd, boolean paramBoolean, MessageComposerView paramMessageComposerView)
  {
    super(paramMessagesActionsPresenter, paramActivity, paramConversationFragment, paramView, paramBoolean);
    this.b = paramd;
    this.g = ((ExpandablePanelLayout)this.mRootView.findViewById(R.id.conversation_menu));
    this.h = paramMessageComposerView;
  }

  private void a(Bundle paramBundle)
  {
    String str = paramBundle.getString("pa_id");
    BotReplyConfig localBotReplyConfig = (BotReplyConfig)paramBundle.getParcelable("bot_config");
    ReplyButton localReplyButton = (ReplyButton)paramBundle.getParcelable("reply_btn");
    boolean bool = paramBundle.getBoolean("open_keyboard");
    int i = paramBundle.getInt("bot_reply_source");
    ((MessagesActionsPresenter)this.mPresenter).a(str, localBotReplyConfig, localReplyButton, bool, i);
  }

  private void a(BotReplyRequest paramBotReplyRequest)
  {
    if (!ViberActionRunner.ai.a(this.d, paramBotReplyRequest))
    {
      Location localLocation = ViberApplication.getInstance().getLocationManager().b(2);
      if (localLocation != null)
      {
        Intent localIntent = LocationMessageActivityV2.a(localLocation);
        localIntent.putExtra("extra_bot_reply_pending_request", paramBotReplyRequest);
        onActivityResult(105, -1, localIntent);
      }
    }
  }

  public void a()
  {
    com.viber.voip.ui.dialogs.d.r().b(this.d);
  }

  public void a(int paramInt)
  {
    com.viber.voip.ui.dialogs.p.c(paramInt).d();
  }

  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    StickerMarketActivity.b(paramInt1, paramInt2, paramString1, paramString2);
  }

  public void a(int paramInt, aa paramaa)
  {
    if (paramInt == R.id.menu_save_to_folder)
      ((MessagesActionsPresenter)this.mPresenter).f(paramaa);
    do
    {
      return;
      if (paramInt == R.id.menu_save_to_gallery)
      {
        ((MessagesActionsPresenter)this.mPresenter).e(paramaa);
        return;
      }
      if (paramInt == R.id.menu_message_forward)
      {
        ((MessagesActionsPresenter)this.mPresenter).h(paramaa);
        return;
      }
    }
    while (paramInt != R.id.menu_message_view);
    ((MessagesActionsPresenter)this.mPresenter).g(paramaa);
  }

  public void a(long paramLong)
  {
    ((MessagesActionsPresenter)this.mPresenter).c(paramLong);
  }

  public void a(Uri paramUri)
  {
    this.g.setTag(paramUri);
    this.d.registerForContextMenu(this.g);
    this.c.openContextMenu(this.g);
    this.d.unregisterForContextMenu(this.g);
  }

  public void a(View paramView, aa paramaa)
  {
    ((MessagesActionsPresenter)this.mPresenter).a(paramView, paramaa);
  }

  public void a(c paramc, int paramInt, String[] paramArrayOfString)
  {
    paramc.a(this.d, paramInt, paramArrayOfString);
  }

  public void a(c paramc, int paramInt, String[] paramArrayOfString, long paramLong, String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("message_id", paramLong);
    localBundle.putString("download_id", paramString);
    localBundle.putBoolean("is_wink", paramBoolean);
    paramc.a(this.d, paramInt, paramArrayOfString, localBundle);
  }

  public void a(c paramc, int paramInt, String[] paramArrayOfString, Object paramObject)
  {
    paramc.a(this.d, paramInt, paramArrayOfString, paramObject);
  }

  public void a(ConferenceInfo paramConferenceInfo, long paramLong, boolean paramBoolean)
  {
    FragmentActivity localFragmentActivity = this.d.requireActivity();
    if (paramBoolean);
    for (String str = "In-Chat Call Log"; ; str = "Group")
    {
      Intent localIntent = ViberActionRunner.r.a(localFragmentActivity, paramConferenceInfo, paramLong, str);
      this.d.startActivity(localIntent);
      return;
    }
  }

  public void a(GroupReferralInfo paramGroupReferralInfo)
  {
    ((MessagesActionsPresenter)this.mPresenter).a(paramGroupReferralInfo, 2000L);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, long paramLong, int paramInt)
  {
    ViberActionRunner.o.a(this.d.getContext(), paramConversationItemLoaderEntity.getConversationType(), paramConversationItemLoaderEntity.getGroupRole(), paramLong, paramInt);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean, long paramLong)
  {
    if (!this.c.isFinishing())
      ViberActionRunner.bm.a(this.c, paramBoolean, paramLong, paramConversationItemLoaderEntity);
  }

  public void a(aa paramaa)
  {
    ((MessagesActionsPresenter)this.mPresenter).k(paramaa);
  }

  public void a(aa paramaa, int paramInt1, int paramInt2, ReplyButton paramReplyButton, String paramString)
  {
    ((MessagesActionsPresenter)this.mPresenter).a(paramaa, paramInt1, paramInt2, paramReplyButton, paramString);
  }

  public void a(aa paramaa, MessageOpenUrlAction paramMessageOpenUrlAction)
  {
    ((MessagesActionsPresenter)this.mPresenter).a(paramaa, paramMessageOpenUrlAction);
  }

  public void a(aa paramaa, String paramString)
  {
    if ((this.d instanceof g))
      ((g)this.d).b(paramaa, paramString);
  }

  public void a(aa paramaa, List<MessageCallEntity> paramList, boolean paramBoolean)
  {
    if (this.d.getFragmentManager() != null)
    {
      f localf = f.a(paramaa, paramList, paramBoolean);
      localf.a(this);
      localf.setTargetFragment(this.d, 0);
      localf.show(this.d.getFragmentManager(), a.a());
    }
  }

  public void a(aa paramaa, boolean paramBoolean)
  {
    ((MessagesActionsPresenter)this.mPresenter).a(paramaa, paramBoolean);
  }

  public void a(MessageOpenUrlAction paramMessageOpenUrlAction)
  {
    u.a(paramMessageOpenUrlAction).d();
  }

  public void a(OpenShopChatPanelData paramOpenShopChatPanelData)
  {
    this.h.a(paramOpenShopChatPanelData);
  }

  public void a(MessageCallEntity paramMessageCallEntity, ConferenceInfo paramConferenceInfo, boolean paramBoolean)
  {
    ((MessagesActionsPresenter)this.mPresenter).a(paramMessageCallEntity, paramConferenceInfo, paramBoolean);
  }

  public void a(com.viber.voip.model.entity.h paramh)
  {
    Intent localIntent = com.viber.voip.messages.m.a(paramh.getId(), paramh.j(), paramh.R(), paramh.aj(), paramh.ao(), false);
    ViberActionRunner.b(this.c, localIntent);
  }

  public void a(com.viber.voip.model.entity.h paramh, long paramLong1, long paramLong2)
  {
    Intent localIntent = com.viber.voip.messages.m.a(paramh.getId(), paramLong1, paramLong2, 2000L, paramh.k(), "", "", paramh.j(), "", "", paramh.o(), -1, false, false, paramh.R(), paramh.aj(), paramh.ao()).putExtra("extra_search_message", true);
    ViberActionRunner.b(this.c, localIntent);
  }

  public void a(e.b paramb)
  {
    l.a locala = com.viber.voip.ui.dialogs.o.j();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramb.j;
    arrayOfObject[1] = Long.valueOf(50L);
    locala.b(-1, arrayOfObject).a(this.d).a(paramb).b(this.d);
  }

  public void a(String paramString)
  {
    com.viber.voip.ui.dialogs.o.k().b(-1, new Object[] { paramString }).a(this.d).b(this.d);
  }

  public void a(String paramString, Uri paramUri)
  {
    this.d.startActivity(PublicGroupParticipantDetailsActivity.buildIntentForSingleShowing(this.d.getActivity(), paramUri, paramString, false));
  }

  public void a(String paramString, GroupReferralInfo paramGroupReferralInfo)
  {
    ViberActionRunner.be.a(this.c, paramString, paramGroupReferralInfo);
  }

  public void a(String paramString, BotReplyConfig paramBotReplyConfig, ReplyButton paramReplyButton, boolean paramBoolean, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("pa_id", paramString);
    localBundle.putParcelable("bot_config", paramBotReplyConfig);
    localBundle.putParcelable("reply_btn", paramReplyButton);
    localBundle.putBoolean("open_keyboard", paramBoolean);
    localBundle.putInt("bot_reply_source", paramInt);
    r.m().a(this.d).a(localBundle).b(this.d);
  }

  public void a(String paramString1, BotReplyConfig paramBotReplyConfig, BotReplyRequest paramBotReplyRequest, ChatExtensionLoaderEntity paramChatExtensionLoaderEntity, ReplyButton paramReplyButton, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    switch (1.a[paramReplyButton.getActionType().ordinal()])
    {
    default:
      ((MessagesActionsPresenter)this.mPresenter).a(paramBotReplyRequest, paramString2, paramString3);
      return;
    case 1:
      a(paramBotReplyRequest);
      return;
    case 2:
      if (paramChatExtensionLoaderEntity != null);
      for (String str = paramChatExtensionLoaderEntity.getName(); ; str = null)
      {
        r.a(str, paramBotReplyRequest).b(this.d);
        return;
      }
    case 3:
      ViberActionRunner.ai.a(this.c, paramReplyButton.getMap());
      return;
    case 4:
    }
    ((MessagesActionsPresenter)this.mPresenter).a(paramBotReplyRequest);
  }

  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramString1 != null);
    for (Uri localUri = Uri.parse(paramString1); ; localUri = null)
    {
      ViberActionRunner.t.a(this.d.getActivity(), localUri, paramString2, paramBoolean);
      return;
    }
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ad.b().b(true).a(false).a(this.d).b(this.d);
      return;
    }
    z.b(this.d, DialogCode.D_PROGRESS);
  }

  public void a(boolean paramBoolean, long paramLong, aa paramaa)
  {
    ((MessagesActionsPresenter)this.mPresenter).a(paramBoolean, paramLong, paramaa);
  }

  public void a(boolean paramBoolean1, Member paramMember, MessageOpenUrlAction paramMessageOpenUrlAction, boolean paramBoolean2)
  {
    boolean bool1 = this.f;
    if (!paramBoolean2);
    for (boolean bool2 = true; ; bool2 = false)
    {
      u.a(bool1, paramMember, paramMessageOpenUrlAction, bool2).d();
      return;
    }
  }

  public void a(boolean paramBoolean, MessageOpenUrlAction paramMessageOpenUrlAction)
  {
    FragmentActivity localFragmentActivity = this.d.getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
      ViberActionRunner.ae.a(localFragmentActivity, paramBoolean, paramMessageOpenUrlAction);
  }

  public void a_(long paramLong1, int paramInt, long paramLong2)
  {
    ((MessagesActionsPresenter)this.mPresenter).a(paramLong1, paramInt, paramLong2);
  }

  public void b()
  {
    ah.b().a(this.c);
  }

  public void b(int paramInt)
  {
    com.viber.voip.ui.dialogs.p.b(paramInt).d();
  }

  public void b(long paramLong)
  {
    ad.n().a(Long.valueOf(paramLong)).a(this.d).b(this.d);
  }

  public void b(aa paramaa)
  {
    ((MessagesActionsPresenter)this.mPresenter).l(paramaa);
  }

  public void b(aa paramaa, boolean paramBoolean)
  {
    Activity localActivity = this.c;
    if (!paramaa.aS());
    for (boolean bool = true; ; bool = false)
    {
      ViberActionRunner.a(localActivity, paramaa, paramBoolean, bool);
      return;
    }
  }

  public void b(e.b paramb)
  {
    com.viber.voip.ui.dialogs.o.l().a(paramb).a(this.d).b(this.d);
  }

  public void b(String paramString)
  {
    ViberActionRunner.be.a(this.c, paramString, true);
  }

  public void c()
  {
    ViberActionRunner.bt.d(this.c);
  }

  public void c(int paramInt)
  {
    com.viber.voip.ui.dialogs.p.a(paramInt).d();
  }

  public void c(long paramLong)
  {
    ViberActionRunner.bn.a(this.c, this.d.ac(), paramLong);
  }

  public void c(aa paramaa)
  {
    ((MessagesActionsPresenter)this.mPresenter).m(paramaa);
  }

  public void c(aa paramaa, boolean paramBoolean)
  {
    ((MessagesActionsPresenter)this.mPresenter).b(paramaa, paramBoolean);
  }

  public void d()
  {
    com.viber.voip.ui.dialogs.i.a().a(new b.a("File manager")).b(this.d);
  }

  public void d(aa paramaa)
  {
    ((MessagesActionsPresenter)this.mPresenter).b(paramaa);
  }

  public void e()
  {
    this.e.a(false);
  }

  public void e(aa paramaa)
  {
    ((MessagesActionsPresenter)this.mPresenter).h(paramaa);
  }

  public void f()
  {
    this.b.notifyDataSetChanged();
  }

  public void f(aa paramaa)
  {
  }

  public void g()
  {
    h.a locala = k.n();
    int i = R.string.dialog_339_message_with_reason;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.d.getResources().getString(R.string.dialog_339_reason_download_file_message);
    locala.b(i, arrayOfObject).d();
  }

  public void g(aa paramaa)
  {
  }

  public void h()
  {
    Activity localActivity;
    if (this.c != null)
    {
      localActivity = this.c;
      if (!ViberApplication.isTablet(this.c))
        break label39;
    }
    label39: for (String str = "com.viber.voip.action.MORE_DIALOG"; ; str = "com.viber.voip.action.MORE")
    {
      localActivity.startActivity(new Intent(str));
      return;
    }
  }

  public void h(aa paramaa)
  {
    ((MessagesActionsPresenter)this.mPresenter).i(paramaa);
  }

  public void i(aa paramaa)
  {
    ((MessagesActionsPresenter)this.mPresenter).n(paramaa);
  }

  public boolean i()
  {
    return this.d.B();
  }

  public void j()
  {
    com.viber.voip.ui.dialogs.h.a().b(this.d);
  }

  public void j(aa paramaa)
  {
  }

  public void k(aa paramaa)
  {
    ((MessagesActionsPresenter)this.mPresenter).o(paramaa);
  }

  public void l(aa paramaa)
  {
    ((MessagesActionsPresenter)this.mPresenter).p(paramaa);
  }

  public void m(aa paramaa)
  {
    ViberActionRunner.be.a(this.c, paramaa.bx().getCommunityScreenshot().getCommunityShareLink());
  }

  public void n(aa paramaa)
  {
    if ((com.viber.voip.util.upload.o.b(true)) && (com.viber.voip.util.upload.o.a(true)))
    {
      ((MessagesActionsPresenter)this.mPresenter).d(paramaa);
      return;
    }
    k.g().d();
  }

  public void o(aa paramaa)
  {
    ViberActionRunner.a(this.d, paramaa.a(), paramaa.h(), paramaa.ag());
  }

  public void onDestroy()
  {
    super.onDestroy();
    InternalURLSpan.removeClickListener((InternalURLSpan.a)this.mPresenter);
    UserMentionSpan.removeClickListener((UserMentionSpan.a)this.mPresenter);
  }

  public boolean onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D377incoming)) && (-1 == paramInt))
      ((MessagesActionsPresenter)this.mPresenter).b((e.b)paramm.d());
    do
    {
      Bundle localBundle1;
      do
      {
        return true;
        if ((paramm.a(DialogCode.D1031)) && (-1 == paramInt))
        {
          ((MessagesActionsPresenter)this.mPresenter).a((e.b)paramm.d());
          return true;
        }
        if ((paramm.a(DialogCode.DC39)) && (-1 == paramInt))
        {
          d.r.k.a(false);
          ((MessagesActionsPresenter)this.mPresenter).a(true, ((Long)paramm.d()).longValue());
          return true;
        }
        if (!paramm.a(DialogCode.D2104))
          break;
        localBundle1 = (Bundle)paramm.d();
        Parcelable localParcelable = localBundle1.getParcelable("pending_messages");
        if (localParcelable != null)
        {
          Bundle localBundle2 = (Bundle)localBundle1.getParcelable("options");
          ae localae = (ae)localBundle1.getSerializable("follow_source");
          MessageEntity[] arrayOfMessageEntity = (MessageEntity[])ParcelableUtils.a(localParcelable);
          switch (paramInt)
          {
          case -2:
          default:
            return true;
          case -3:
            ViberActionRunner.aq.a(paramm.getActivity(), (Parcelable)paramm.d(), localae, 1000);
            return true;
          case -1:
          }
          this.d.b(arrayOfMessageEntity, localBundle2);
          return true;
        }
      }
      while (da.a(localBundle1.getString("pa_id")));
      switch (paramInt)
      {
      case -2:
      default:
        return true;
      case -3:
        ViberActionRunner.aq.a(paramm.getActivity(), localBundle1, null, 1001);
        return true;
      case -1:
      }
      a(localBundle1);
      return true;
    }
    while ((!paramm.a(DialogCode.D_PROGRESS)) || (-1000 != paramInt));
    ((MessagesActionsPresenter)this.mPresenter).c();
    return true;
  }

  public void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      InternalURLSpan.addClickListener((InternalURLSpan.a)this.mPresenter);
      UserMentionSpan.addClickListener((UserMentionSpan.a)this.mPresenter);
      return;
    }
    InternalURLSpan.removeClickListener((InternalURLSpan.a)this.mPresenter);
    UserMentionSpan.removeClickListener((UserMentionSpan.a)this.mPresenter);
  }

  public void onPause()
  {
    if (this.f)
      InternalURLSpan.removeClickListener((InternalURLSpan.a)this.mPresenter);
  }

  public void onResume()
  {
    if (this.f)
      InternalURLSpan.addClickListener((InternalURLSpan.a)this.mPresenter);
  }

  public void p(aa paramaa)
  {
    ((MessagesActionsPresenter)this.mPresenter).c(paramaa);
  }

  public void q(aa paramaa)
  {
    boolean bool = this.b.b().A();
    ((MessagesActionsPresenter)this.mPresenter).a(paramaa, bool);
  }

  public void r(aa paramaa)
  {
    String str = this.b.b().a(paramaa.h());
    ((MessagesActionsPresenter)this.mPresenter).a(paramaa, str);
  }

  public void s(aa paramaa)
  {
    ((MessagesActionsPresenter)this.mPresenter).j(paramaa);
  }

  public void t(aa paramaa)
  {
    ((MessagesActionsPresenter)this.mPresenter).q(paramaa);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.b.p
 * JD-Core Version:    0.6.2
 */