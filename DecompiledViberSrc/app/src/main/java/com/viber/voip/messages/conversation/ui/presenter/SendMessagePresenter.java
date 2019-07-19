package com.viber.voip.messages.conversation.ui.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.block.g.a;
import com.viber.voip.flatbuffers.b.a;
import com.viber.voip.flatbuffers.b.e;
import com.viber.voip.flatbuffers.model.msginfo.Edit;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.util.UnsignedLong;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.a.b.a;
import com.viber.voip.messages.controller.manager.k;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.conversation.ui.b.g;
import com.viber.voip.messages.conversation.ui.b.z;
import com.viber.voip.messages.conversation.ui.view.b.ae;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import com.viber.voip.messages.extras.wink.WinkDescription;
import com.viber.voip.messages.l;
import com.viber.voip.messages.shopchat.OpenShopChatPanelData;
import com.viber.voip.messages.ui.MessageComposerView.k;
import com.viber.voip.messages.ui.d.c;
import com.viber.voip.messages.ui.d.d;
import com.viber.voip.messages.ui.d.e;
import com.viber.voip.messages.ui.d.f;
import com.viber.voip.messages.ui.d.g;
import com.viber.voip.messages.ui.d.i;
import com.viber.voip.messages.ui.d.k;
import com.viber.voip.messages.ui.d.l;
import com.viber.voip.messages.ui.d.m;
import com.viber.voip.messages.ui.d.n;
import com.viber.voip.messages.ui.d.o;
import com.viber.voip.messages.ui.d.p;
import com.viber.voip.messages.ui.media.SendMediaDataContainer;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.registration.af;
import com.viber.voip.ui.t.b.a;
import com.viber.voip.ui.t.c;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.at;
import com.viber.voip.util.bz;
import com.viber.voip.util.cd;
import com.viber.voip.util.e.j;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;

public class SendMessagePresenter extends BaseMvpPresenter<com.viber.voip.messages.conversation.ui.view.o, SendMessagePresenterState>
  implements com.viber.voip.messages.conversation.ui.b.aa, g, com.viber.voip.messages.conversation.ui.b.v, MessageComposerView.k, d.c, d.d, d.e, d.f, d.g, d.i, d.k, d.l, d.m, d.n, d.o, d.p
{
  private static final Logger a = ViberEnv.getLogger();
  private final com.viber.voip.messages.conversation.ui.b.f b;
  private final com.viber.voip.messages.conversation.ui.b.u c;
  private final com.viber.voip.messages.conversation.ui.b.ai d;
  private final z e;
  private final com.viber.voip.messages.controller.ai f;
  private Uri g;
  private ConversationItemLoaderEntity h;
  private ConversationData i;
  private com.viber.common.b.b j;
  private com.viber.voip.messages.controller.publicaccount.d k;
  private Context l;
  private final com.viber.voip.banner.i m;
  private final com.viber.common.permission.c n;
  private final com.viber.voip.messages.extensions.c o;
  private com.viber.voip.messages.conversation.aa p;
  private MessageEntity q;
  private Handler r;
  private k s;
  private com.viber.voip.messages.extensions.i t;
  private final EventBus u;
  private final com.viber.common.b.b v;
  private final com.viber.common.b.b w;
  private final com.viber.voip.i.f x;

  public SendMessagePresenter(com.viber.voip.messages.conversation.ui.b.f paramf, com.viber.voip.messages.conversation.ui.b.u paramu, com.viber.voip.messages.conversation.ui.b.ai paramai, z paramz, com.viber.voip.messages.controller.ai paramai1, com.viber.common.b.b paramb1, com.viber.voip.messages.controller.publicaccount.d paramd, Context paramContext, com.viber.voip.banner.i parami, com.viber.common.permission.c paramc, com.viber.voip.messages.extensions.c paramc1, com.viber.voip.messages.extensions.i parami1, EventBus paramEventBus, Handler paramHandler, k paramk, com.viber.common.b.b paramb2, com.viber.common.b.b paramb3, com.viber.voip.i.f paramf1)
  {
    this.b = paramf;
    this.c = paramu;
    this.d = paramai;
    this.e = paramz;
    this.f = paramai1;
    this.j = paramb1;
    this.k = paramd;
    this.l = paramContext;
    this.m = parami;
    this.n = paramc;
    this.o = paramc1;
    this.t = parami1;
    this.u = paramEventBus;
    this.r = paramHandler;
    this.s = paramk;
    this.v = paramb2;
    this.w = paramb3;
    this.x = paramf1;
  }

  private void a(g.a parama)
  {
    if (this.h == null);
    do
    {
      return;
      if (!this.h.isGroupBehavior())
      {
        ((com.viber.voip.messages.conversation.ui.view.o)this.mView).a(Member.from(this.h), parama);
        return;
      }
    }
    while (parama == null);
    parama.a(Collections.emptySet());
  }

  private void b(MessageEntity paramMessageEntity)
  {
    com.viber.voip.model.entity.h localh = com.viber.voip.messages.controller.manager.ab.b().f(paramMessageEntity.getConversationId());
    long l1 = paramMessageEntity.getDuration();
    if (localh != null)
      ViberApplication.getInstance().getEngine(false).getCdrController().handleReportVoiceMessage((int)TimeUnit.MILLISECONDS.toSeconds(l1), 1, 2);
  }

  private boolean w()
  {
    return (this.h != null) && (this.x.e()) && (!this.h.isCommunityBlocked()) && (cd.g(this.h.getGroupRole(), this.h.getConversationType()));
  }

  public void G_()
  {
    com.viber.voip.messages.conversation.ui.b.w.a(this);
  }

  public void H_()
  {
    a(new s(this));
  }

  public void a()
  {
    if (this.j.d())
      this.j.a(false);
    for (boolean bool = true; ; bool = false)
    {
      ((com.viber.voip.messages.conversation.ui.view.o)this.mView).d(bool);
      this.d.a();
      return;
    }
  }

  public void a(long paramLong, String paramString1, String paramString2)
  {
    if ((0L == paramLong) || (paramString1 == null) || (paramString2 == null))
      return;
    this.f.a(paramLong, Uri.fromFile(new File(paramString1, paramString2)));
  }

  public void a(Intent paramIntent)
  {
    if (this.b.h() == null)
      this.b.a(this.i);
    ((com.viber.voip.messages.conversation.ui.view.o)this.mView).a(paramIntent, this.g, this.b.h(), true, null);
    this.g = null;
  }

  public void a(BotReplyRequest paramBotReplyRequest, double paramDouble1, double paramDouble2, String paramString)
  {
    this.k.a(paramBotReplyRequest, paramDouble1, paramDouble2, paramString);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    if ((this.h != null) && (this.h.getId() != paramConversationItemLoaderEntity.getId()))
      this.u.post(new b.a());
    this.h = paramConversationItemLoaderEntity;
  }

  public void a(com.viber.voip.messages.conversation.aa paramaa)
  {
    com.viber.voip.messages.conversation.adapter.f.a(this, paramaa);
  }

  public void a(ConversationData paramConversationData)
  {
    com.viber.voip.messages.conversation.ui.b.w.a(this, paramConversationData);
  }

  protected void a(SendMessagePresenterState paramSendMessagePresenterState)
  {
    super.onViewAttached(paramSendMessagePresenterState);
    if (paramSendMessagePresenterState != null)
      this.i = paramSendMessagePresenterState.getData();
    this.b.a(this);
    this.c.a(this);
    this.e.a(this);
  }

  public void a(ae paramae)
  {
    String str1 = paramae.a();
    String str2 = paramae.b();
    String str3 = paramae.c();
    if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)));
    Uri localUri;
    label162: label168: 
    do
    {
      return;
      int i1 = bz.a(str1);
      SendMediaDataContainer localSendMediaDataContainer = new SendMediaDataContainer();
      localSendMediaDataContainer.winkDescription = WinkDescription.from(i1, str3);
      if (localSendMediaDataContainer.winkDescription != null)
      {
        localUri = at.f(this.l, Uri.parse(str2));
        localSendMediaDataContainer.fileUri = localUri;
        if (!"image".startsWith(str3))
          break label162;
      }
      for (int i2 = 1; ; i2 = 3)
      {
        localSendMediaDataContainer.type = i2;
        if (localSendMediaDataContainer.winkDescription == null)
          break label168;
        ((com.viber.voip.messages.conversation.ui.view.o)this.mView).a(Collections.singletonList(localSendMediaDataContainer), null);
        return;
        String str4 = at.g(Uri.parse(str2));
        localUri = j.a(this.l, Uri.parse(str2), str4);
        break;
      }
      if ((l.e(localSendMediaDataContainer.type)) && (this.h != null))
      {
        ((com.viber.voip.messages.conversation.ui.view.o)this.mView).a(localUri, null, this.b.b().canSendTimeBomb(), 9);
        return;
      }
    }
    while (this.h == null);
    ((com.viber.voip.messages.conversation.ui.view.o)this.mView).a(localUri, null, this.b.b().canSendTimeBomb(), 10);
  }

  public void a(OpenShopChatPanelData paramOpenShopChatPanelData)
  {
    com.viber.voip.messages.conversation.ui.b.ab.a(this, paramOpenShopChatPanelData);
  }

  public void a(MessageEntity paramMessageEntity)
  {
    this.q = paramMessageEntity;
    this.s.a(paramMessageEntity.getMediaUri());
  }

  public void a(t.c paramc, t.b.a parama)
  {
    com.viber.voip.messages.conversation.ui.b.w.a(this, paramc, parama);
  }

  public void a(t.c paramc, t.b.a parama, long paramLong)
  {
    com.viber.voip.messages.conversation.ui.b.w.a(this, paramc, parama, paramLong);
  }

  public void a(CharSequence paramCharSequence)
  {
    com.viber.voip.messages.conversation.ui.b.ab.a(this, paramCharSequence);
  }

  public void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    com.viber.voip.messages.conversation.ui.b.w.a(this, paramCharSequence, paramBoolean);
  }

  public void a(String paramString)
  {
    com.viber.voip.messages.conversation.ui.b.w.a(this, paramString);
  }

  public void a(String paramString1, String paramString2)
  {
    if ((this.p != null) && (this.h.getId() == this.p.b()))
      if (!TextUtils.isEmpty(paramString2))
        break label143;
    label143: for (MsgInfo localMsgInfo = new MsgInfo(); ; localMsgInfo = (MsgInfo)e.a().a().a(paramString2))
    {
      localMsgInfo.setEdit(new Edit(new UnsignedLong(this.p.y())));
      MessageEntity localMessageEntity = new com.viber.voip.messages.controller.c.b(this.h).a(0, paramString1, 0, e.a().b().a(localMsgInfo), 0);
      if (this.p.az())
        localMessageEntity.setExtraStatus(12);
      this.f.a(localMessageEntity, com.viber.voip.analytics.story.n.a(null, "Keyboard"));
      this.c.a(true);
      return;
    }
  }

  public void a(ArrayList<GalleryItem> paramArrayList)
  {
    a(new o(this, paramArrayList));
  }

  public void a(boolean paramBoolean)
  {
    com.viber.voip.messages.conversation.ui.b.w.a(this, paramBoolean);
  }

  public void a(boolean paramBoolean, String paramString1, ChatExtensionLoaderEntity paramChatExtensionLoaderEntity, String paramString2)
  {
    a(new v(this, paramBoolean, paramString1, paramChatExtensionLoaderEntity, paramString2));
  }

  public void a(MessageEntity[] paramArrayOfMessageEntity, Bundle paramBundle)
  {
    this.b.a(paramArrayOfMessageEntity, paramBundle);
    this.m.b();
    ((com.viber.voip.messages.conversation.ui.view.o)this.mView).a();
  }

  public boolean a(Intent paramIntent, long paramLong, int paramInt)
  {
    return (this.b.b() == null) || (this.c.a(paramIntent, this.h.getId(), paramLong, paramInt));
  }

  public Bundle b(String paramString)
  {
    if (paramString == null)
      return null;
    return this.d.a(paramString);
  }

  public void b()
  {
    ((com.viber.voip.messages.conversation.ui.view.o)this.mView).e();
  }

  public void b(long paramLong)
  {
    com.viber.voip.messages.conversation.ui.b.h.b(this, paramLong);
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this, paramConversationItemLoaderEntity, paramBoolean);
  }

  public void b(com.viber.voip.messages.conversation.aa paramaa)
  {
    this.p = paramaa;
  }

  public void b(boolean paramBoolean)
  {
    com.viber.voip.messages.conversation.ui.b.ab.a(this, paramBoolean);
  }

  public void b_(long paramLong)
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this, paramLong);
  }

  public void c()
  {
    com.viber.voip.messages.conversation.ui.b.ab.a(this);
  }

  public void c(boolean paramBoolean)
  {
    com.viber.voip.messages.conversation.ui.b.ab.b(this, paramBoolean);
  }

  public void d()
  {
    if (this.h.isConversation1on1());
    for (String str = this.h.getParticipantMemberId(); ; str = "")
    {
      OpenShopChatPanelData localOpenShopChatPanelData = new OpenShopChatPanelData(str, this.h.getGroupId(), "");
      this.e.a(localOpenShopChatPanelData);
      return;
    }
  }

  public void d(boolean paramBoolean)
  {
    if (!paramBoolean);
    do
    {
      return;
      this.d.a(this.g);
    }
    while (!this.n.a(new String[] { "android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE" }));
    m();
  }

  @SuppressLint({"MissingPermission"})
  public void e()
  {
    a(new q(this));
  }

  public void e(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.g = null;
  }

  public void f()
  {
    a(new r(this));
  }

  public void g()
  {
    a(new u(this));
  }

  public void h()
  {
    UserManager localUserManager = UserManager.from(ViberApplication.getApplication());
    ((com.viber.voip.messages.conversation.ui.view.o)this.mView).a(this.h.getId(), this.h.getGroupId(), localUserManager.getRegistrationValues().l(), this.h.getConversationType(), this.h.getNativeChatType());
  }

  public void i()
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this);
  }

  public void j()
  {
    a(new t(this));
  }

  public void k()
  {
    if ((com.viber.voip.util.upload.o.b(true)) && (com.viber.voip.util.upload.o.a(true)))
      ((com.viber.voip.messages.conversation.ui.view.o)this.mView).a(this.b.h());
  }

  public void l()
  {
    a(new p(this));
  }

  @SuppressLint({"MissingPermission"})
  public void m()
  {
    a(new w(this));
  }

  public void n()
  {
    com.viber.voip.messages.conversation.ui.b.ab.b(this);
  }

  protected SendMessagePresenterState o()
  {
    return new SendMessagePresenterState(this.i, this.g);
  }

  public void onDestroy(android.arch.lifecycle.h paramh)
  {
    super.onDestroy(paramh);
    this.b.b(this);
    this.c.b(this);
    this.e.b(this);
  }

  public int p()
  {
    com.viber.voip.messages.conversation.s locals = this.b.a();
    if (locals != null)
      return locals.m();
    return 0;
  }

  public void q()
  {
    if ((this.h == null) || (this.q == null))
      return;
    if (this.h.getId() == this.q.getConversationId())
    {
      this.f.a(this.q, null);
      this.s.a(null);
      this.r.post(new n(this));
    }
    this.c.a(true);
  }

  public void r()
  {
    this.s.a(null);
  }

  public void s()
  {
    ((com.viber.voip.messages.conversation.ui.view.o)this.mView).d();
  }

  public void t()
  {
    this.c.a(true);
    if ((this.w.d()) && (!this.v.d()) && (this.h != null) && (this.h.isCommunityType()) && (w()))
    {
      this.v.a(true);
      ((com.viber.voip.messages.conversation.ui.view.o)this.mView).f();
    }
  }

  public void u()
  {
    this.d.a(this.g);
    this.g = null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.SendMessagePresenter
 * JD-Core Version:    0.6.2
 */