package com.viber.voip.messages.conversation.ui.presenter;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.TextMetaInfo;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.flatbuffers.model.msginfo.GroupReferralInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountMsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.b;
import com.viber.voip.invitelinks.q;
import com.viber.voip.invitelinks.q.a;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.ai.f;
import com.viber.voip.messages.controller.bv.m;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest;
import com.viber.voip.messages.controller.publicaccount.d;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.conversation.ui.SpamController;
import com.viber.voip.messages.conversation.ui.b.ad;
import com.viber.voip.messages.conversation.ui.b.aj;
import com.viber.voip.messages.conversation.ui.b.p;
import com.viber.voip.messages.conversation.ui.b.u;
import com.viber.voip.messages.conversation.ui.b.v;
import com.viber.voip.messages.conversation.ui.b.w;
import com.viber.voip.messages.conversation.ui.b.x;
import com.viber.voip.messages.conversation.ui.b.z;
import com.viber.voip.messages.conversation.ui.bm;
import com.viber.voip.messages.conversation.ui.br;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import com.viber.voip.messages.orm.entity.json.action.MessageOpenUrlAction;
import com.viber.voip.messages.shopchat.OpenShopChatPanelData;
import com.viber.voip.model.entity.MessageCallEntity;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.publicaccount.d.e;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.r;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.sound.tones.SampleTone;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.entity.Sticker.a;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.e.b;
import com.viber.voip.ui.style.InternalURLSpan.a;
import com.viber.voip.ui.style.UserMentionSpan.a;
import com.viber.voip.ui.t.b.a;
import com.viber.voip.ui.t.c;
import com.viber.voip.util.at;
import com.viber.voip.util.at.a;
import com.viber.voip.util.cd;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import com.viber.voip.util.dl;
import com.viber.voip.util.dr;
import com.viber.voip.util.upload.s;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MessagesActionsPresenter<VIEW extends com.viber.voip.messages.conversation.ui.view.j> extends BaseMvpPresenter<VIEW, MessagesActionsPresenterState>
  implements q.a, bv.m, ad, com.viber.voip.messages.conversation.ui.b.g, com.viber.voip.messages.conversation.ui.b.o, v, InternalURLSpan.a, UserMentionSpan.a
{
  protected static final Logger a = ViberEnv.getLogger();
  private final z A;
  private final com.viber.common.b.b B;
  private final com.viber.voip.messages.extensions.c C;
  private final dagger.a<q> D;
  private final com.viber.voip.analytics.story.e.c E;
  private aa F;
  private com.viber.voip.messages.controller.manager.o G;
  private Handler H;
  private ActivationController I;
  private int J;
  private boolean K;
  private boolean L;
  protected com.viber.voip.messages.conversation.ui.b.f b;
  protected com.viber.voip.messages.conversation.ui.b.i c;
  protected com.viber.voip.messages.conversation.ui.b.ac d;
  protected com.viber.voip.analytics.g e;
  protected final com.viber.voip.messages.conversation.ui.b.n f;
  private SpamController g;
  private ai h;
  private com.viber.common.permission.c i;
  private com.viber.voip.messages.conversation.ui.j j;
  private Engine k;
  private af l;
  private Handler m;
  private Handler n;
  private Handler o;
  private IRingtonePlayer p;
  private d q;
  private com.viber.voip.messages.conversation.ui.b.a r;
  private com.viber.voip.messages.d.b s;
  private final bm t;
  private final x u;
  private final aj v;
  private final com.viber.voip.stickers.b w;
  private final com.viber.voip.stickers.i x;
  private final com.viber.voip.stickers.a.a y;
  private final u z;

  public MessagesActionsPresenter(SpamController paramSpamController, com.viber.voip.messages.conversation.ui.b.f paramf, com.viber.voip.messages.conversation.ui.b.ac paramac, com.viber.voip.messages.conversation.ui.b.i parami, ai paramai, com.viber.common.permission.c paramc, com.viber.voip.messages.conversation.ui.j paramj, Engine paramEngine, af paramaf, Handler paramHandler1, Handler paramHandler2, Handler paramHandler3, com.viber.voip.analytics.g paramg, IRingtonePlayer paramIRingtonePlayer, d paramd, com.viber.voip.messages.conversation.ui.b.a parama, com.viber.voip.messages.d.b paramb, boolean paramBoolean, com.viber.voip.messages.controller.manager.o paramo, Handler paramHandler4, bm parambm, x paramx, aj paramaj, com.viber.voip.stickers.b paramb1, com.viber.voip.stickers.i parami1, com.viber.voip.stickers.a.a parama1, com.viber.voip.messages.conversation.ui.b.n paramn, u paramu, ActivationController paramActivationController, z paramz, com.viber.common.b.b paramb2, com.viber.voip.messages.extensions.c paramc1, dagger.a<q> parama2)
  {
    this.g = paramSpamController;
    this.b = paramf;
    this.c = parami;
    this.d = paramac;
    this.h = paramai;
    this.i = paramc;
    this.j = paramj;
    this.k = paramEngine;
    this.l = paramaf;
    this.m = paramHandler1;
    this.n = paramHandler2;
    this.o = paramHandler3;
    this.e = paramg;
    this.p = paramIRingtonePlayer;
    this.q = paramd;
    this.r = parama;
    this.s = paramb;
    this.K = paramBoolean;
    this.G = paramo;
    this.H = paramHandler4;
    this.t = parambm;
    this.u = paramx;
    this.v = paramaj;
    this.w = paramb1;
    this.x = parami1;
    this.y = parama1;
    this.f = paramn;
    this.z = paramu;
    this.I = paramActivationController;
    this.A = paramz;
    this.B = paramb2;
    this.C = paramc1;
    this.D = parama2;
    this.E = paramg.c().g();
  }

  private Uri a(Uri paramUri)
  {
    Uri.Builder localBuilder = paramUri.buildUpon().clearQuery();
    Iterator localIterator = paramUri.getQueryParameterNames().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!"adjust".equalsIgnoreCase(str))
      {
        List localList = paramUri.getQueryParameters(str);
        int i1 = localList.size();
        for (int i2 = 0; i2 < i1; i2++)
          localBuilder.appendQueryParameter(str, (String)localList.get(i2));
      }
    }
    return localBuilder.build();
  }

  private BotReplyRequest a(String paramString, BotReplyConfig paramBotReplyConfig, ReplyButton paramReplyButton, int paramInt)
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.b();
    return new BotReplyRequest(paramString, paramBotReplyConfig, paramReplyButton, localConversationItemLoaderEntity.getGroupId(), localConversationItemLoaderEntity.getId(), localConversationItemLoaderEntity.getConversationType(), localConversationItemLoaderEntity.isOneToOneWithPublicAccount(), localConversationItemLoaderEntity.isSystemConversation(), e(), localConversationItemLoaderEntity.getParticipantMemberId(), localConversationItemLoaderEntity.isHiddenConversation(), paramInt);
  }

  private MessageOpenUrlAction a(MessageOpenUrlAction paramMessageOpenUrlAction, aa paramaa)
  {
    MessageOpenUrlAction localMessageOpenUrlAction = MessageOpenUrlAction.from(paramMessageOpenUrlAction);
    if ((!this.B.d()) || (paramaa.ag()));
    for (boolean bool = true; ; bool = false)
    {
      localMessageOpenUrlAction.setIsExternal(bool);
      localMessageOpenUrlAction.setIsSecret(paramaa.ag());
      localMessageOpenUrlAction.setConversationId(paramaa.b());
      localMessageOpenUrlAction.setConversationType(paramaa.A());
      return localMessageOpenUrlAction;
    }
  }

  private void a(long paramLong, aa paramaa)
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.b();
    if (localConversationItemLoaderEntity == null);
    com.viber.voip.model.entity.m localm2;
    do
    {
      boolean bool1;
      do
      {
        return;
        if (paramaa != null)
        {
          boolean bool2 = paramaa.ak();
          bool1 = false;
          if (!bool2);
        }
        else
        {
          com.viber.voip.model.entity.m localm1 = this.s.b(paramLong);
          bool1 = this.t.a(localm1, localConversationItemLoaderEntity);
        }
      }
      while (bool1);
      if (!localConversationItemLoaderEntity.isAnonymous())
        break;
      localm2 = com.viber.voip.messages.d.c.c().b(paramLong);
    }
    while ((localm2 == null) || (paramaa == null));
    com.viber.voip.model.h localh = com.viber.voip.model.entity.m.a(paramaa.bG(), paramaa.bH(), localm2);
    String str = localh.a(localConversationItemLoaderEntity.getGroupRole(), localConversationItemLoaderEntity.getConversationType());
    ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(str, localh.j());
    return;
    if (paramaa != null);
    for (int i1 = paramaa.bG(); ; i1 = 3)
    {
      ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(localConversationItemLoaderEntity, paramLong, i1);
      v(paramaa);
      return;
    }
  }

  private void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, aa paramaa, int paramInt1, int paramInt2, ReplyButton paramReplyButton)
  {
    if ((paramConversationItemLoaderEntity != null) && (paramaa != null) && (paramReplyButton != null))
      this.o.post(new br(paramConversationItemLoaderEntity, paramaa, paramInt1, paramInt2, paramReplyButton));
  }

  private void a(aa paramaa, MessageCallEntity paramMessageCallEntity, boolean paramBoolean)
  {
    if ((paramMessageCallEntity.isTypeViberGroup()) && (paramaa.bK()) && (paramaa.bL()))
    {
      if (!paramMessageCallEntity.isAnswerredOnAnotherDevice())
        ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(paramaa.bM(), paramaa.b(), true);
      return;
    }
    a(paramMessageCallEntity.isTypeViberGeneralVideo(), paramMessageCallEntity.isTypeViberOut(), paramMessageCallEntity.isTypeVln(), paramBoolean, true);
  }

  private void a(aa paramaa, List<MessageCallEntity> paramList, boolean paramBoolean)
  {
    if (paramList.size() == 1)
      a(paramaa, (MessageCallEntity)paramList.get(0), paramBoolean);
    while (paramList.size() <= 1)
      return;
    ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(paramaa, paramList, paramBoolean);
  }

  private void a(e.b paramb, int paramInt)
  {
    if (this.i.a(com.viber.voip.permissions.n.m))
    {
      this.h.a(paramb.a, paramb.b);
      return;
    }
    ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(this.i, paramInt, com.viber.voip.permissions.n.m, paramb.a, paramb.b, false);
  }

  private boolean a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    boolean bool1;
    if (paramConversationItemLoaderEntity != null)
    {
      boolean bool2 = paramConversationItemLoaderEntity.canSendMessages(0);
      bool1 = false;
      if (bool2);
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }

  private boolean a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString, BotReplyConfig paramBotReplyConfig, ReplyButton paramReplyButton, boolean paramBoolean, int paramInt)
  {
    if ((paramConversationItemLoaderEntity == null) || (!paramConversationItemLoaderEntity.isOneToOneWithPublicAccount()));
    while ((!paramConversationItemLoaderEntity.isAgeRestrictedPublicAccount()) || (paramConversationItemLoaderEntity.hasOutgoingMessages()) || (paramConversationItemLoaderEntity.hasPublicAccountSubscription()))
      return false;
    ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(paramString, paramBotReplyConfig, paramReplyButton, paramBoolean, paramInt);
    return true;
  }

  private boolean a(e.b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((10 == paramb.c) || (1005 == paramb.c))
    {
      if ((paramBoolean1) && (paramb.d) && (!paramb.e) && (!paramb.h) && (paramb.f <= 0L) && (!paramb.g))
      {
        ((com.viber.voip.messages.conversation.ui.view.j)this.mView).b(paramb);
        return false;
      }
      if ((paramBoolean2) && (paramb.i >= 52428800L))
      {
        ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(paramb);
        return false;
      }
    }
    return true;
  }

  private boolean e()
  {
    return a(this.b.b());
  }

  private void f()
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.b();
    if ((localConversationItemLoaderEntity != null) && (com.viber.voip.messages.d.a.a(localConversationItemLoaderEntity.isPublicGroupBehavior(), localConversationItemLoaderEntity.isOneToOneWithPublicAccount(), this.K)))
      this.H.post(new a(localConversationItemLoaderEntity.getId()));
  }

  private void s(aa paramaa)
  {
    this.m.post(new i(this, paramaa));
  }

  private boolean t(aa paramaa)
  {
    return (paramaa.ap()) && (paramaa.f() == -1) && ((0x10 & paramaa.E()) == 0);
  }

  private void u(aa paramaa)
  {
    if (s.a(paramaa.C()))
      s.a(paramaa, false);
    while (!cj.a(true))
      return;
    a(new e.b(paramaa), 111);
  }

  private void v(aa paramaa)
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.b();
    if (localConversationItemLoaderEntity != null)
      this.E.a(localConversationItemLoaderEntity, paramaa);
  }

  public void G_()
  {
    w.a(this);
  }

  public void a()
  {
    ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(true);
  }

  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    this.c.a(paramLong1, paramInt, paramLong2);
  }

  public void a(long paramLong, Uri paramUri)
  {
    this.h.b(paramLong, paramUri);
  }

  public void a(View paramView, aa paramaa)
  {
    if ((paramaa.O()) || (paramaa.S()) || (paramaa.aa()))
      return;
    if (paramaa.ao())
    {
      if ((paramaa.V()) && (paramaa.U()))
      {
        this.u.a(paramView);
        return;
      }
      if (da.a(paramaa.getNumber(), this.l.h()))
      {
        ((com.viber.voip.messages.conversation.ui.view.j)this.mView).h();
        return;
      }
      a(paramaa.u(), paramaa);
      return;
    }
    ((com.viber.voip.messages.conversation.ui.view.j)this.mView).h();
  }

  public void a(TextMetaInfo paramTextMetaInfo)
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.b();
    if (localConversationItemLoaderEntity != null);
    for (com.viber.voip.model.entity.m localm = this.s.c(paramTextMetaInfo.getMemberId(), cd.j(localConversationItemLoaderEntity.getConversationType())); ; localm = null)
    {
      if (localm != null)
      {
        if (!localm.isOwner())
          break;
        this.j.k();
      }
      return;
    }
    this.j.a(localm.getId());
  }

  public void a(ConferenceInfo paramConferenceInfo, boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.J == 2))
      a(false, false, false, false, false);
    ConversationItemLoaderEntity localConversationItemLoaderEntity;
    do
    {
      return;
      localConversationItemLoaderEntity = this.b.b();
    }
    while (localConversationItemLoaderEntity == null);
    ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(paramConferenceInfo, localConversationItemLoaderEntity.getId(), paramBoolean);
  }

  public void a(GroupReferralInfo paramGroupReferralInfo, long paramLong)
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.b();
    if ((localConversationItemLoaderEntity != null) && (localConversationItemLoaderEntity.getGroupId() == paramGroupReferralInfo.getGroupId()))
    {
      a(paramGroupReferralInfo.getMessageToken(), paramGroupReferralInfo.getMessageId(), paramLong);
      return;
    }
    ((q)this.D.get()).a(paramGroupReferralInfo, this);
  }

  public void a(BotReplyRequest paramBotReplyRequest)
  {
    this.q.a(paramBotReplyRequest);
  }

  public void a(BotReplyRequest paramBotReplyRequest, String paramString1, String paramString2)
  {
    this.m.post(new h(this, paramBotReplyRequest));
    MsgInfo localMsgInfo = new MsgInfo();
    localMsgInfo.setTitle(paramString1);
    PublicAccountInfo localPublicAccountInfo = new PublicAccountInfo();
    localPublicAccountInfo.setPaName(paramString2);
    localMsgInfo.getPublicAccountMsgInfo().setPublicAccountInfo(localPublicAccountInfo);
    this.q.a(paramBotReplyRequest, localMsgInfo);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    if ((paramConversationItemLoaderEntity != null) && (paramBoolean))
    {
      this.L = false;
      f();
    }
  }

  public void a(aa paramaa)
  {
    com.viber.voip.messages.conversation.adapter.f.a(this, paramaa);
  }

  public void a(aa paramaa, int paramInt1, int paramInt2, ReplyButton paramReplyButton, String paramString)
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.b();
    if (localConversationItemLoaderEntity == null);
    ReplyButton.a locala;
    do
    {
      do
        return;
      while (SpamController.a(localConversationItemLoaderEntity));
      locala = paramReplyButton.getActionType();
    }
    while ((localConversationItemLoaderEntity.isPublicGroupBehavior()) && (locala != ReplyButton.a.OPEN_URL) && (locala != ReplyButton.a.OPEN_MAP));
    if ((locala != ReplyButton.a.OPEN_URL) && (paramReplyButton.getReplyType() == ReplyButton.b.QUERY));
    for (boolean bool = true; ; bool = false)
    {
      a(localConversationItemLoaderEntity, paramaa, paramInt1, paramInt2, paramReplyButton);
      BotReplyConfig localBotReplyConfig = paramaa.bx().getPublicAccountMsgInfo().getRichMedia();
      String str = paramaa.bx().getPublicAccountInfoName();
      if (a(localConversationItemLoaderEntity, paramString, localBotReplyConfig, paramReplyButton, bool, 2))
        break;
      a(paramString, localBotReplyConfig, paramReplyButton, bool, str, 2);
      return;
    }
  }

  public void a(aa paramaa, MessageOpenUrlAction paramMessageOpenUrlAction)
  {
    s(paramaa);
    DialogCode localDialogCode = this.g.a(paramaa);
    if (localDialogCode != DialogCode.UNKNOWN)
    {
      switch (3.a[localDialogCode.ordinal()])
      {
      default:
      case 1:
      case 2:
      }
      ConversationItemLoaderEntity localConversationItemLoaderEntity;
      do
      {
        return;
        ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(paramMessageOpenUrlAction);
        return;
        localConversationItemLoaderEntity = this.b.b();
      }
      while (localConversationItemLoaderEntity == null);
      paramMessageOpenUrlAction.setConversationId(localConversationItemLoaderEntity.getId());
      paramMessageOpenUrlAction.setConversationType(localConversationItemLoaderEntity.getConversationType());
      ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(this.K, Member.from(localConversationItemLoaderEntity), paramMessageOpenUrlAction, localConversationItemLoaderEntity.isAnonymous());
      return;
    }
    MessageOpenUrlAction localMessageOpenUrlAction = a(paramMessageOpenUrlAction, paramaa);
    ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(paramaa.X(), localMessageOpenUrlAction);
  }

  public void a(aa paramaa, String paramString)
  {
    if (paramaa.q() == 1008);
    do
    {
      return;
      if (paramaa.d().equals(this.l.l()))
      {
        ((com.viber.voip.messages.conversation.ui.view.j)this.mView).c();
        return;
      }
    }
    while (("many_add".equals(paramString)) || ("many_add_members".equals(paramString)));
    this.j.a(paramaa);
  }

  public void a(aa paramaa, boolean paramBoolean)
  {
    com.viber.voip.messages.conversation.ui.view.j localj = (com.viber.voip.messages.conversation.ui.view.j)this.mView;
    if ((!paramaa.ag()) && (paramBoolean));
    for (boolean bool = true; ; bool = false)
    {
      localj.b(paramaa, bool);
      v(paramaa);
      return;
    }
  }

  public void a(com.viber.voip.messages.conversation.ac paramac, boolean paramBoolean)
  {
    this.J = paramac.getCount();
  }

  public void a(ConversationData paramConversationData)
  {
    if (paramConversationData.isBroadcastListType())
      this.J = paramConversationData.broadcastListParticipantsCount;
  }

  protected void a(MessagesActionsPresenterState paramMessagesActionsPresenterState)
  {
    super.onViewAttached(paramMessagesActionsPresenterState);
    this.b.a(this);
    this.d.a(this);
    this.z.a(this);
    this.f.a(this);
  }

  public void a(MessageCallEntity paramMessageCallEntity, ConferenceInfo paramConferenceInfo, boolean paramBoolean)
  {
    if ((paramConferenceInfo != null) && (paramMessageCallEntity.isTypeViberGroup()))
    {
      if (!paramMessageCallEntity.isAnswerredOnAnotherDevice())
        a(paramConferenceInfo, true);
      return;
    }
    a(paramMessageCallEntity.isTypeViberGeneralVideo(), paramMessageCallEntity.isTypeViberOut(), paramMessageCallEntity.isTypeVln(), paramBoolean, true);
  }

  public void a(MessageEntity paramMessageEntity, int paramInt)
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.b();
    long l1 = paramMessageEntity.getConversationId();
    long l2;
    if (localConversationItemLoaderEntity != null)
    {
      l2 = localConversationItemLoaderEntity.getId();
      if (l1 == l2)
        break label41;
    }
    label41: 
    do
    {
      do
      {
        return;
        l2 = -1L;
        break;
        if ((paramInt == 0) && (paramMessageEntity.isWinkVideo()) && (paramMessageEntity.isIncoming()))
        {
          a(true, paramMessageEntity.getId());
          return;
        }
      }
      while ((paramInt == 2) && (!cj.c(ViberApplication.getApplication())));
      if ((paramInt == 2) && (paramMessageEntity.isFromPublicAccount()))
      {
        ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(paramMessageEntity.getMimeType());
        return;
      }
      if ((paramInt == 2) && (paramMessageEntity.isVideoPttBehavior()) && (paramMessageEntity.isIncoming()))
      {
        ((com.viber.voip.messages.conversation.ui.view.j)this.mView).b(paramMessageEntity.getMimeType());
        return;
      }
      if ((paramInt == 3) && (paramMessageEntity.isFile()))
      {
        ((com.viber.voip.messages.conversation.ui.view.j)this.mView).c(paramMessageEntity.getMimeType());
        return;
      }
    }
    while ((paramInt != 2) || (!paramMessageEntity.isFile()));
    ((com.viber.voip.messages.conversation.ui.view.j)this.mView).g();
  }

  public void a(com.viber.voip.model.entity.h paramh)
  {
    ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(paramh);
  }

  public void a(com.viber.voip.model.entity.h paramh, long paramLong1, long paramLong2)
  {
    ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(paramh, paramLong1, paramLong2);
  }

  public void a(e.b paramb)
  {
    if (a(paramb, false, true))
    {
      a(paramb, 117);
      ((com.viber.voip.messages.conversation.ui.view.j)this.mView).f();
    }
  }

  public void a(t.c paramc, t.b.a parama)
  {
    w.a(this, paramc, parama);
  }

  public void a(t.c paramc, t.b.a parama, long paramLong)
  {
    w.a(this, paramc, parama, paramLong);
  }

  public void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    w.a(this, paramCharSequence, paramBoolean);
  }

  public void a(String paramString)
  {
    w.a(this, paramString);
  }

  public void a(String paramString, GroupReferralInfo paramGroupReferralInfo)
  {
    if (!da.a(paramString))
      ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(paramString, paramGroupReferralInfo);
  }

  public void a(String paramString, BotReplyConfig paramBotReplyConfig, ReplyButton paramReplyButton)
  {
    if ((!cj.a(true)) || (a(this.b.b(), paramString, paramBotReplyConfig, paramReplyButton, false, 1)))
      return;
    a(paramString, paramBotReplyConfig, paramReplyButton, false, null, 1);
    ((com.viber.voip.messages.conversation.ui.view.j)this.mView).e();
  }

  public void a(String paramString, BotReplyConfig paramBotReplyConfig, ReplyButton paramReplyButton, boolean paramBoolean, int paramInt)
  {
    a(paramString, paramBotReplyConfig, paramReplyButton, paramBoolean, null, paramInt);
  }

  public void a(String paramString1, BotReplyConfig paramBotReplyConfig, ReplyButton paramReplyButton, boolean paramBoolean, String paramString2, int paramInt)
  {
    if (this.b.b() != null)
    {
      ChatExtensionLoaderEntity localChatExtensionLoaderEntity = this.C.a(paramString1);
      ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(paramString1, paramBotReplyConfig, a(paramString1, paramBotReplyConfig, paramReplyButton, paramInt), localChatExtensionLoaderEntity, paramReplyButton, this.b.b().getGroupName(), paramString2, paramBoolean, paramInt);
    }
    if ((paramBoolean) && (!da.a(paramString1)))
      this.r.a(paramString1, 7, "Rich message");
  }

  public void a(String paramString, aa paramaa)
  {
    Uri localUri1 = Uri.parse(paramString);
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.b();
    int i1;
    Uri localUri3;
    if ((localConversationItemLoaderEntity == null) || (com.viber.voip.analytics.a.j.a(localConversationItemLoaderEntity)))
    {
      i1 = 1;
      if ((i1 != 0) || (!localUri1.isHierarchical()) || (TextUtils.isEmpty(localUri1.getQueryParameter("adjust"))) || (!dl.a(paramString)))
        break label245;
      localUri3 = a(localUri1);
      paramString = localUri3.toString();
    }
    label231: label245: for (Uri localUri2 = localUri3; ; localUri2 = localUri1)
    {
      if (paramString.startsWith("tel:"))
        ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(localUri2);
      do
      {
        return;
        i1 = 0;
        break;
        if (paramString.startsWith("mailto:"))
        {
          ((com.viber.voip.messages.conversation.ui.view.j)this.mView).b(paramString);
          return;
        }
        if ((localConversationItemLoaderEntity != null) && (localConversationItemLoaderEntity.isPublicGroupType()))
        {
          if (paramaa != null)
          {
            ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(paramaa, paramString);
            a(paramaa, new MessageOpenUrlAction(paramString));
            v(paramaa);
            return;
          }
          ((com.viber.voip.messages.conversation.ui.view.j)this.mView).b(paramString);
          return;
        }
        if (paramaa == null)
          break label231;
        a(paramaa, new MessageOpenUrlAction(paramString));
      }
      while (localConversationItemLoaderEntity == null);
      this.E.a(localConversationItemLoaderEntity);
      return;
      ((com.viber.voip.messages.conversation.ui.view.j)this.mView).b(paramString);
      return;
    }
  }

  public void a(boolean paramBoolean)
  {
    w.a(this, paramBoolean);
  }

  public void a(boolean paramBoolean, long paramLong)
  {
    if (this.i.a(com.viber.voip.permissions.n.m))
    {
      this.L = paramBoolean;
      if ((paramBoolean) && (d.r.k.d()))
        ((com.viber.voip.messages.conversation.ui.view.j)this.mView).b(paramLong);
      while (this.b.b() == null)
        return;
      ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(this.b.b(), paramBoolean, paramLong);
      return;
    }
    ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(this.i, 109, com.viber.voip.permissions.n.m, paramLong, "", paramBoolean);
  }

  public void a(boolean paramBoolean, long paramLong, aa paramaa)
  {
    this.h.e(paramLong);
    if ((paramBoolean) && (paramaa != null))
      v(paramaa);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    boolean bool = true;
    if (paramBoolean1)
    {
      if (this.i.a(com.viber.voip.permissions.n.g))
      {
        this.j.a(bool, false, paramBoolean5);
        return;
      }
      ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(this.i, 29, com.viber.voip.permissions.n.g, Boolean.valueOf(paramBoolean5));
      return;
    }
    if ((paramBoolean2) || ((paramBoolean3) && (!paramBoolean4)));
    while (this.i.a(com.viber.voip.permissions.n.h))
    {
      this.j.a(false, bool, paramBoolean5);
      return;
      bool = false;
    }
    if (bool);
    for (int i1 = 40; ; i1 = 50)
    {
      ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(this.i, i1, com.viber.voip.permissions.n.h, Boolean.valueOf(paramBoolean5));
      return;
    }
  }

  public void b()
  {
    ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(false);
  }

  public void b(long paramLong)
  {
    com.viber.voip.messages.conversation.ui.b.h.b(this, paramLong);
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this, paramConversationItemLoaderEntity, paramBoolean);
  }

  public void b(aa paramaa)
  {
    if (this.b.b() == null);
    e.b localb;
    do
    {
      do
      {
        return;
        if (t(paramaa))
        {
          FileInfo localFileInfo = paramaa.bz();
          long l1 = localFileInfo.getFileSize();
          String str = localFileInfo.getFileName();
          if (at.b(l1) == at.a.d)
          {
            ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(str);
            return;
          }
          this.h.b(paramaa.a());
          return;
        }
        if ((paramaa.o() != null) || (paramaa.C() == null))
          break;
        if (s.a(paramaa.C()))
        {
          s.a(paramaa, false);
          return;
        }
      }
      while (!cj.a(true));
      localb = new e.b(paramaa);
    }
    while (!a(localb, true, true));
    a(localb, 117);
    return;
    if ((paramaa.ap()) && (!paramaa.aq()))
    {
      this.h.c(paramaa.a());
      return;
    }
    if (this.i.a(com.viber.voip.permissions.n.m))
    {
      c_(paramaa.o());
      v(paramaa);
      return;
    }
    ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(this.i, 118, com.viber.voip.permissions.n.m, paramaa.o());
    v(paramaa);
  }

  public void b(aa paramaa, boolean paramBoolean)
  {
    if (paramBoolean)
      v(paramaa);
  }

  public void b(com.viber.voip.model.h paramh)
  {
    p.a(this, paramh);
  }

  public void b(e.b paramb)
  {
    this.h.c(paramb.a, 14);
    a(paramb, 117);
    ((com.viber.voip.messages.conversation.ui.view.j)this.mView).f();
  }

  public void b(boolean paramBoolean)
  {
    this.L = paramBoolean;
  }

  public void b_(long paramLong)
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this, paramLong);
  }

  public void b_(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.F != null))
      this.j.b(this.F);
    this.F = null;
  }

  public void c()
  {
    ((q)this.D.get()).a();
  }

  public void c(long paramLong)
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.b();
    if ((localConversationItemLoaderEntity != null) && (localConversationItemLoaderEntity.isGroupType()))
      ((com.viber.voip.messages.conversation.ui.view.j)this.mView).c(paramLong);
  }

  public void c(aa paramaa)
  {
    if (t(paramaa))
    {
      this.h.b(paramaa.a());
      return;
    }
    if ((paramaa.ap()) && (!paramaa.aq()))
    {
      this.h.c(paramaa.a());
      return;
    }
    if (paramaa.bE())
    {
      u(paramaa);
      return;
    }
    a(paramaa.aD(), paramaa.a());
    v(paramaa);
  }

  public void c_(String paramString)
  {
    this.m.post(new j(this, paramString));
  }

  public void d(aa paramaa)
  {
    File localFile = this.d.a(paramaa);
    if (localFile != null)
      a(paramaa.a(), Uri.fromFile(localFile));
  }

  public void e(aa paramaa)
  {
    ((com.viber.voip.messages.conversation.ui.view.j)this.mView).n(paramaa);
  }

  public void f(aa paramaa)
  {
    ((com.viber.voip.messages.conversation.ui.view.j)this.mView).o(paramaa);
  }

  public void g(aa paramaa)
  {
    if (paramaa.az())
      c(paramaa);
    do
    {
      return;
      if (paramaa.aA())
      {
        j(paramaa);
        return;
      }
    }
    while (!paramaa.ay());
    if (!this.b.b().isNotShareablePublicAccount());
    for (boolean bool = true; ; bool = false)
    {
      a(paramaa, bool);
      return;
    }
  }

  public void h(aa paramaa)
  {
    if (this.i.a(com.viber.voip.permissions.n.m))
    {
      this.j.b(paramaa);
      return;
    }
    this.F = paramaa;
    ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(this.i, 140, com.viber.voip.permissions.n.m);
  }

  public void i()
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this);
  }

  public void i(aa paramaa)
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.b();
    if (localConversationItemLoaderEntity != null)
      if (!localConversationItemLoaderEntity.isDisabledConversation());
    do
    {
      do
      {
        return;
        if (localConversationItemLoaderEntity.isCommunityBlocked())
        {
          ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a();
          return;
        }
      }
      while (!paramaa.ac());
      this.h.e(paramaa.y());
    }
    while (paramaa.ab());
    this.p.playSample(SampleTone.LIKE);
  }

  public void j(aa paramaa)
  {
    if ((paramaa.aC()) && (this.k.getCurrentCall() != null))
    {
      ((com.viber.voip.messages.conversation.ui.view.j)this.mView).b();
      return;
    }
    if (t(paramaa))
    {
      this.h.b(paramaa.a());
      return;
    }
    if ((paramaa.o() == null) && (paramaa.C() != null))
    {
      u(paramaa);
      return;
    }
    if ((paramaa.ap()) && (!paramaa.aq()))
    {
      this.h.c(paramaa.a());
      return;
    }
    a(paramaa.aD(), paramaa.a());
    v(paramaa);
  }

  public void k(aa paramaa)
  {
    v(paramaa);
  }

  public void l(final aa paramaa)
  {
    this.h.a(paramaa.a(), new ai.f()
    {
      public void a(List<MessageCallEntity> paramAnonymousList)
      {
        ConversationItemLoaderEntity localConversationItemLoaderEntity = MessagesActionsPresenter.this.b.b();
        if (paramAnonymousList != null)
        {
          if ((localConversationItemLoaderEntity != null) && (localConversationItemLoaderEntity.isVlnConversation()))
            dr.a(localConversationItemLoaderEntity.getNumber(), new l(this, paramaa, paramAnonymousList));
        }
        else
          return;
        MessagesActionsPresenter.a(MessagesActionsPresenter.this, paramaa, paramAnonymousList, true);
      }
    });
  }

  public void m(final aa paramaa)
  {
    this.h.a(paramaa.a(), new ai.f()
    {
      public void a(List<MessageCallEntity> paramAnonymousList)
      {
        ConversationItemLoaderEntity localConversationItemLoaderEntity = MessagesActionsPresenter.this.b.b();
        MessageCallEntity localMessageCallEntity;
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          localMessageCallEntity = (MessageCallEntity)paramAnonymousList.get(0);
          if ((localConversationItemLoaderEntity != null) && (localConversationItemLoaderEntity.isVlnConversation()))
            dr.a(localConversationItemLoaderEntity.getNumber(), new m(this, paramaa, localMessageCallEntity));
        }
        else
        {
          return;
        }
        MessagesActionsPresenter.a(MessagesActionsPresenter.this, paramaa, localMessageCallEntity, true);
      }
    });
  }

  public void n(aa paramaa)
  {
    this.h.b(paramaa.a());
    this.v.a();
  }

  public void o(aa paramaa)
  {
    int i1 = 1;
    Sticker localSticker = paramaa.bn();
    if (localSticker == null)
      return;
    com.viber.voip.stickers.b localb = this.w;
    com.viber.voip.messages.d.l locall = new com.viber.voip.messages.d.l(paramaa);
    if (((localSticker.isAnimated()) || (localSticker.hasSound())) && (!localb.a(locall)) && (paramaa.aq()))
    {
      localb.c(locall);
      v(paramaa);
    }
    label145: label299: label304: 
    while (true)
    {
      if ((this.y.c(paramaa)) && (paramaa.ai()));
      this.I.getCountryCode();
      return;
      int i2 = com.viber.voip.stickers.c.g.f(localSticker.id);
      com.viber.voip.stickers.entity.a locala = this.x.g(i2);
      int i3;
      boolean bool;
      int i5;
      if ((localSticker.isOwned()) && (locala != null) && (locala.c()))
      {
        i3 = i1;
        if (i3 == 0)
          break label260;
        ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.b();
        i4 = 0;
        if (localConversationItemLoaderEntity != null)
        {
          bool = localConversationItemLoaderEntity.canSendMessages(this.J);
          if (!(localConversationItemLoaderEntity instanceof PublicGroupConversationItemLoaderEntity))
            break label299;
          if (((PublicGroupConversationItemLoaderEntity)localConversationItemLoaderEntity).isPendingRole())
            break label254;
          i5 = i1;
          label200: i1 = i5;
        }
      }
      for (int i4 = bool; ; i4 = bool)
      {
        if ((((com.viber.voip.messages.conversation.ui.view.j)this.mView).i()) || (i4 == 0) || (i1 == 0))
          break label304;
        localb.d();
        this.r.b(i2);
        break;
        i3 = 0;
        break label145;
        label254: i5 = 0;
        break label200;
        if (localSticker.type != Sticker.a.c)
          break;
        ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(com.viber.voip.stickers.c.g.f(localSticker.id), 3, "Chat", "Product Page");
        break;
      }
    }
  }

  public void onDestroy(android.arch.lifecycle.h paramh)
  {
    super.onDestroy(paramh);
    this.b.b(this);
    this.d.b(this);
    this.z.b(this);
    this.f.b(this);
  }

  public void onPause(android.arch.lifecycle.h paramh)
  {
    super.onPause(paramh);
    if (!this.L)
      f();
    this.G.b(this);
  }

  public void onResume(android.arch.lifecycle.h paramh)
  {
    super.onResume(paramh);
    this.L = false;
    this.G.a(this);
  }

  public void onStart(android.arch.lifecycle.h paramh)
  {
    super.onStart(paramh);
  }

  public void onStop(android.arch.lifecycle.h paramh)
  {
    super.onStop(paramh);
  }

  public void p(aa paramaa)
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.b();
    if (a(localConversationItemLoaderEntity));
    while (SpamController.a(localConversationItemLoaderEntity))
      return;
    String str1 = paramaa.bv();
    if (e.b(str1))
    {
      if (!com.viber.voip.messages.d.a.d(localConversationItemLoaderEntity))
      {
        ((com.viber.voip.messages.conversation.ui.view.j)this.mView).j();
        return;
      }
      if (localConversationItemLoaderEntity.isConversation1on1());
      for (String str2 = localConversationItemLoaderEntity.getParticipantMemberId(); ; str2 = "")
      {
        OpenShopChatPanelData localOpenShopChatPanelData = new OpenShopChatPanelData(str2, localConversationItemLoaderEntity.getGroupId(), "");
        ((com.viber.voip.messages.conversation.ui.view.j)this.mView).a(localOpenShopChatPanelData);
        return;
      }
    }
    if ((com.viber.voip.messages.d.a.a(localConversationItemLoaderEntity, this.C)) && (this.C.c(str1)))
    {
      this.q.d(str1);
      this.r.a(str1, 7, "Rich message");
      return;
    }
    ((com.viber.voip.messages.conversation.ui.view.j)this.mView).j();
  }

  public void q(aa paramaa)
  {
    v(paramaa);
  }

  private final class a
    implements Runnable
  {
    private final long b;

    public a(long arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    public void run()
    {
      MessagesActionsPresenter.this.d.a(this.b);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.MessagesActionsPresenter
 * JD-Core Version:    0.6.2
 */