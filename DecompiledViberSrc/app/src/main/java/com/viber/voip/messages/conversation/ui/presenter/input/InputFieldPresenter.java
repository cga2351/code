package com.viber.voip.messages.conversation.ui.presenter.input;

import android.os.Handler;
import android.view.View;
import com.viber.dexshared.Logger;
import com.viber.jni.im2.CGroupUserIsTypingMsg;
import com.viber.jni.im2.CUserIsTypingMsg;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.f.d;
import com.viber.voip.flatbuffers.model.quote.QuotedMessageData;
import com.viber.voip.i.c.d;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.MessageEditText.a;
import com.viber.voip.messages.a.i.a;
import com.viber.voip.messages.a.i.b;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ac;
import com.viber.voip.messages.conversation.adapter.d.ad;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationData;
import com.viber.voip.messages.conversation.q;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.conversation.ui.b.ab;
import com.viber.voip.messages.conversation.ui.b.g;
import com.viber.voip.messages.conversation.ui.b.l;
import com.viber.voip.messages.conversation.ui.b.n;
import com.viber.voip.messages.conversation.ui.b.o;
import com.viber.voip.messages.conversation.ui.b.p;
import com.viber.voip.messages.conversation.ui.b.t;
import com.viber.voip.messages.conversation.ui.b.u;
import com.viber.voip.messages.conversation.ui.b.v;
import com.viber.voip.messages.conversation.ui.b.w;
import com.viber.voip.messages.conversation.ui.b.z;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.messages.shopchat.OpenShopChatPanelData;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout.c;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.ui.t.b.a;
import com.viber.voip.ui.t.c;
import com.viber.voip.util.ae;
import com.viber.voip.util.da;
import org.greenrobot.eventbus.EventBus;

public abstract class InputFieldPresenter<VIEW extends com.viber.voip.messages.conversation.ui.view.i> extends BaseMvpPresenter<VIEW, InputFieldState>
  implements ad, com.viber.voip.messages.conversation.ui.b.aa, g, l, o, v, ExpandablePanelLayout.c
{
  private static final Logger r = ViberEnv.getLogger();
  private final com.viber.voip.messages.extensions.c A;
  private boolean B;
  private boolean C;
  private boolean D;
  private InputFieldState E;
  private int F = -1;
  private String G;
  private final Runnable H = new a(this, null);
  protected final com.viber.voip.messages.conversation.ui.b.a a;
  protected final com.viber.voip.messages.conversation.ui.b.f b;
  protected final n c;
  protected final com.viber.voip.messages.conversation.ui.b.i d;
  protected final z e;
  protected final u f;
  protected final t g;
  protected final com.viber.voip.messages.c.a.a h;
  protected final com.viber.voip.messages.b.a.c i;
  protected final com.viber.voip.flatbuffers.b.a<QuotedMessageData> j;
  protected final com.viber.voip.flatbuffers.b.b<QuotedMessageData> k;
  protected final com.viber.voip.bot.b l;
  protected final Im2Exchanger m;
  protected final Handler n;
  protected final boolean o;
  protected ConversationItemLoaderEntity p;
  protected int q;
  private final Handler s;
  private final EventBus t;
  private final c u;
  private final com.viber.voip.messages.d.b v;
  private final ai w;
  private final d x;
  private long y;
  private boolean z;

  public InputFieldPresenter(z paramz, com.viber.voip.messages.conversation.ui.b.a parama, com.viber.voip.messages.conversation.ui.b.f paramf, n paramn, com.viber.voip.messages.conversation.ui.b.i parami, t paramt, u paramu, com.viber.voip.messages.c.a.a parama1, com.viber.voip.messages.b.a.c paramc, com.viber.voip.flatbuffers.b.a<QuotedMessageData> parama2, com.viber.voip.flatbuffers.b.b<QuotedMessageData> paramb, com.viber.voip.bot.b paramb1, Im2Exchanger paramIm2Exchanger, Handler paramHandler1, Handler paramHandler2, EventBus paramEventBus, com.viber.voip.messages.extensions.c paramc1, com.viber.voip.messages.d.b paramb2, ai paramai, boolean paramBoolean1, boolean paramBoolean2, d paramd)
  {
    this.a = parama;
    this.b = paramf;
    this.c = paramn;
    this.d = parami;
    this.e = paramz;
    this.g = paramt;
    this.f = paramu;
    this.h = parama1;
    this.i = paramc;
    this.j = parama2;
    this.k = paramb;
    this.l = paramb1;
    this.m = paramIm2Exchanger;
    this.n = paramHandler1;
    this.s = paramHandler2;
    this.t = paramEventBus;
    this.A = paramc1;
    this.o = paramBoolean1;
    this.B = paramBoolean2;
    this.u = new c(this, 1);
    this.v = paramb2;
    this.w = paramai;
    this.x = paramd;
  }

  private void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if ((!paramConversationItemLoaderEntity.canSendMessages(this.q)) && (!paramConversationItemLoaderEntity.isSystemReplyableChat()))
      return;
    if ((!paramConversationItemLoaderEntity.isHiddenConversation()) || (this.C))
    {
      String str1 = paramConversationItemLoaderEntity.getMessageDraft();
      String str2 = this.e.f();
      String str3 = paramConversationItemLoaderEntity.getReplyBannerDraft();
      if ((paramConversationItemLoaderEntity.isNewUserJoinedConversation()) && ((da.a(str1)) || (str2.equals(str1))))
      {
        this.e.c(str2);
        this.e.a(1, false);
        ((com.viber.voip.messages.conversation.ui.view.i)this.mView).a(false, true);
        ((com.viber.voip.messages.conversation.ui.view.i)this.mView).c();
        return;
      }
      if (da.a(paramConversationItemLoaderEntity.getMessageDraftSpans()))
        this.e.c(str1);
      while (true)
      {
        if (this.e.j())
        {
          c(true, true);
          this.e.t();
        }
        QuotedMessageData localQuotedMessageData = (QuotedMessageData)this.j.a(str3);
        if (localQuotedMessageData.getToken() <= 0L)
          break;
        ((com.viber.voip.messages.conversation.ui.view.i)this.mView).a(localQuotedMessageData);
        return;
        this.e.a(str1, paramConversationItemLoaderEntity.getMessageDraftSpans());
      }
      ((com.viber.voip.messages.conversation.ui.view.i)this.mView).c();
      return;
    }
    this.e.c("");
    ((com.viber.voip.messages.conversation.ui.view.i)this.mView).c();
  }

  private void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if ((this.e.o()) && (!com.viber.voip.messages.d.a.c(paramConversationItemLoaderEntity)))
    {
      ((com.viber.voip.messages.conversation.ui.view.i)this.mView).a();
      if (this.e.p() != 2)
        this.e.g(true);
      ((com.viber.voip.messages.conversation.ui.view.i)this.mView).a(false);
    }
    if ((this.e.m()) && (!com.viber.voip.messages.d.a.a(paramConversationItemLoaderEntity, this.A)))
    {
      ((com.viber.voip.messages.conversation.ui.view.i)this.mView).b();
      this.e.t();
      c(false);
    }
    if ((this.F == R.id.options_menu_open_share_and_shop) && (!com.viber.voip.messages.d.a.d(paramConversationItemLoaderEntity)))
      ((com.viber.voip.messages.conversation.ui.view.i)this.mView).b();
  }

  private void b(CharSequence paramCharSequence)
  {
    ((com.viber.voip.messages.conversation.ui.view.i)this.mView).a(paramCharSequence);
  }

  private void c(int paramInt)
  {
    boolean bool = true;
    if (this.e.m())
      return;
    if (this.D)
    {
      com.viber.voip.messages.conversation.ui.view.i locali2 = (com.viber.voip.messages.conversation.ui.view.i)this.mView;
      if (!this.e.c());
      while (true)
      {
        locali2.g(bool);
        return;
        bool = false;
      }
    }
    if (this.e.n())
    {
      com.viber.voip.messages.conversation.ui.view.i locali1 = (com.viber.voip.messages.conversation.ui.view.i)this.mView;
      if ((!this.e.d()) && (!this.e.e().toString().equals(this.G)));
      while (true)
      {
        locali1.g(bool);
        return;
        bool = false;
      }
    }
    if ((this.e.c()) && (!this.h.a()) && ((o()) || (e()) || (this.e.v())))
    {
      this.n.postDelayed(new a(this, paramInt), 500L);
      return;
    }
    ((com.viber.voip.messages.conversation.ui.view.i)this.mView).h();
  }

  private void c(CharSequence paramCharSequence)
  {
    this.e.b(paramCharSequence);
    ((com.viber.voip.messages.conversation.ui.view.i)this.mView).a(paramCharSequence, this.e.v());
  }

  private void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.e.a(paramBoolean1, paramBoolean2))
      ((com.viber.voip.messages.conversation.ui.view.i)this.mView).a(false);
  }

  private void g(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.e.r())
        this.e.b(1, true);
      return;
    }
    this.e.b(1, false);
  }

  private boolean o()
  {
    return (!this.D) && (com.viber.voip.messages.d.a.b(this.p));
  }

  private String p()
  {
    return this.k.a(this.h.e());
  }

  private void q()
  {
    if ((this.p == null) || (this.p.isBroadcastListType()));
    do
    {
      return;
      if ((!this.p.isGroupBehavior()) && (!this.e.a(new Member(this.p.getParticipantMemberId()))))
      {
        this.m.handleCUserIsTypingMsg(new CUserIsTypingMsg(this.p.getParticipantMemberId(), this.z, this.p.getNativeChatType()));
        return;
      }
    }
    while (this.p.getGroupId() == 0L);
    this.m.handleCGroupUserIsTypingMsg(new CGroupUserIsTypingMsg(this.p.getGroupId(), this.z));
  }

  private void r()
  {
    ((com.viber.voip.messages.conversation.ui.view.i)this.mView).b();
    c(false, true);
    c(false);
    ((com.viber.voip.messages.conversation.ui.view.i)this.mView).e();
    k();
  }

  private boolean s()
  {
    if (this.e.n())
    {
      this.e.f(false);
      if ((this.B) && (!this.o))
        ((com.viber.voip.messages.conversation.ui.view.i)this.mView).c(true);
      this.G = null;
      ((com.viber.voip.messages.conversation.ui.view.i)this.mView).f(false);
      ((com.viber.voip.messages.conversation.ui.view.i)this.mView).a("", false);
      k();
      return true;
    }
    return false;
  }

  private void t()
  {
    ((com.viber.voip.messages.conversation.ui.view.i)this.mView).f();
  }

  public void G_()
  {
    g();
  }

  public void a(int paramInt)
  {
    com.viber.voip.messages.ui.expanel.c.a(this, paramInt);
  }

  public void a(int paramInt1, int paramInt2, View paramView)
  {
    ((com.viber.voip.messages.conversation.ui.view.i)this.mView).a(paramInt1, paramInt2, paramView);
    if (paramInt1 == 3)
    {
      this.F = paramInt2;
      s();
      return;
    }
    this.F = -1;
  }

  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    com.viber.voip.messages.conversation.ui.b.m.a(this, paramLong1, paramInt, paramLong2);
  }

  protected void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt, boolean paramBoolean)
  {
    boolean bool1;
    if ((paramConversationItemLoaderEntity.canSendMessages(paramInt)) && (!this.e.i()) && (!this.d.a()))
    {
      bool1 = true;
      if (!this.o)
        break label166;
    }
    label166: for (boolean bool2 = bool1 & paramBoolean; ; bool2 = bool1)
    {
      this.D = paramConversationItemLoaderEntity.isSystemReplyableChat();
      boolean bool3;
      if (!this.D)
      {
        bool3 = false;
        if (!bool2);
      }
      else
      {
        bool3 = true;
      }
      ((com.viber.voip.messages.conversation.ui.view.i)this.mView).d(this.D);
      ((com.viber.voip.messages.conversation.ui.view.i)this.mView).e(bool3);
      if ((!bool3) && (!this.d.a()))
        ((com.viber.voip.messages.conversation.ui.view.i)this.mView).c(true);
      if (((this.D) || (!bool2)) && (!paramConversationItemLoaderEntity.hasBusinessInboxOverlay()))
        ((com.viber.voip.messages.conversation.ui.view.i)this.mView).b();
      return;
      bool1 = false;
      break;
    }
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    if (paramConversationItemLoaderEntity != null)
    {
      if ((this.p == null) || (this.p.getId() != paramConversationItemLoaderEntity.getId()))
      {
        s();
        ((com.viber.voip.messages.conversation.ui.view.i)this.mView).f();
        this.e.l();
      }
      if (((this.p == null) || (!this.p.isEngagementConversation())) && (paramConversationItemLoaderEntity.isEngagementConversation()));
      for (int i1 = 1; ; i1 = 0)
      {
        this.p = paramConversationItemLoaderEntity;
        b(paramConversationItemLoaderEntity);
        if ((!this.e.i()) && (!this.d.a()))
          a(this.p, this.q, this.e.g());
        if ((paramBoolean) || (i1 != 0))
          a(paramConversationItemLoaderEntity);
        if (paramBoolean)
          ((com.viber.voip.messages.conversation.ui.view.i)this.mView).g();
        h();
        if ((c.d.a.e()) && (this.p.hasBusinessInboxOverlay()) && (this.p.isSystemReplyableChat()))
          ((com.viber.voip.messages.conversation.ui.view.i)this.mView).k();
        return;
      }
    }
    this.p = null;
  }

  public void a(com.viber.voip.messages.conversation.aa paramaa)
  {
    com.viber.voip.messages.conversation.adapter.f.a(this, paramaa);
  }

  public void a(com.viber.voip.messages.conversation.aa paramaa, int paramInt)
  {
    com.viber.voip.model.entity.m localm = this.v.b(paramaa.u());
    if (localm == null)
      return;
    String str1 = localm.a();
    if (paramaa.aV());
    for (String str2 = localm.b(); ; str2 = localm.d())
    {
      QuotedMessageData localQuotedMessageData = com.viber.voip.messages.m.a(null, paramaa, this.p.getGroupRole(), str1, str2, paramInt);
      ((com.viber.voip.messages.conversation.ui.view.i)this.mView).a(localQuotedMessageData);
      if (this.e.n())
        s();
      ((com.viber.voip.messages.conversation.ui.view.i)this.mView).k();
      return;
    }
  }

  public void a(ac paramac, boolean paramBoolean)
  {
    this.q = paramac.getCount();
    a(this.p, this.q, this.e.g());
  }

  public void a(q paramq, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.C = paramBoolean2;
    if ((this.p != null) && (this.p.isHiddenConversation()))
    {
      if (paramBoolean1)
      {
        this.y = System.currentTimeMillis();
        a(this.p);
      }
      if (!this.e.i())
        a(this.p, this.q, this.e.g());
    }
  }

  public void a(ConversationData paramConversationData)
  {
    if ((paramConversationData.systemConversation) || ((paramConversationData instanceof PublicGroupConversationData)) || (paramConversationData.conversationType == 3) || ((paramConversationData.isBroadcastListType()) && (paramConversationData.broadcastListParticipantsCount == 1)))
      ((com.viber.voip.messages.conversation.ui.view.i)this.mView).e(false);
  }

  protected void a(InputFieldState paramInputFieldState)
  {
    super.onViewAttached(paramInputFieldState);
    this.E = paramInputFieldState;
    this.b.a(this);
    this.a.a(this);
    this.e.a(this);
    this.c.a(this);
    this.d.a(this);
    this.f.a(this);
    k();
    if (!this.t.isRegistered(this.u))
      this.t.register(this.u);
  }

  public void a(OpenShopChatPanelData paramOpenShopChatPanelData)
  {
    ((com.viber.voip.messages.conversation.ui.view.i)this.mView).a(paramOpenShopChatPanelData);
  }

  public void a(MessageEntity paramMessageEntity, int paramInt, String paramString)
  {
    com.viber.voip.messages.conversation.ui.b.m.a(this, paramMessageEntity, paramInt, paramString);
  }

  public void a(t.c paramc, t.b.a parama)
  {
    w.a(this, paramc, parama);
  }

  public void a(t.c paramc, t.b.a parama, long paramLong)
  {
    w.a(this, paramc, parama, paramLong);
  }

  public void a(CharSequence paramCharSequence)
  {
    c(paramCharSequence);
  }

  public void a(CharSequence paramCharSequence, int paramInt)
  {
    this.e.b(paramCharSequence);
    c(paramInt);
  }

  public void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    w.a(this, paramCharSequence, paramBoolean);
  }

  public void a(String paramString)
  {
    w.a(this, paramString);
  }

  public void a(boolean paramBoolean)
  {
    w.a(this, paramBoolean);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      r();
      ((com.viber.voip.messages.conversation.ui.view.i)this.mView).e(false);
      return;
    }
    a(this.p, this.q, this.e.g());
  }

  public boolean a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramInt == 1))
    {
      r();
      ((com.viber.voip.messages.conversation.ui.view.i)this.mView).a();
      return true;
    }
    c(true, true);
    if (paramBoolean2)
    {
      ((com.viber.voip.messages.conversation.ui.view.i)this.mView).d();
      return true;
    }
    return false;
  }

  protected InputFieldState b()
  {
    return new InputFieldState(this.e.m(), this.e.s());
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
    c(false);
    c(true, false);
    this.e.f(true);
    this.G = paramaa.h();
    if (paramaa.az())
    {
      this.G = paramaa.i();
      if ((!paramaa.aY()) || (da.a(paramaa.N())) || ("no_sp".equals(paramaa.N())))
        break label187;
      this.e.a(this.G, paramaa.N());
    }
    while (true)
    {
      ((com.viber.voip.messages.conversation.ui.view.i)this.mView).f(true);
      k();
      ((com.viber.voip.messages.conversation.ui.view.i)this.mView).c();
      this.n.postDelayed(new c(this), 100L);
      boolean bool = com.viber.voip.messages.m.a(paramaa.A(), paramaa.d(), this.p);
      this.x.a(paramaa, ae.b(), bool);
      return;
      if (!paramaa.aL())
        break;
      this.G = paramaa.L().getPushText();
      break;
      label187: ((com.viber.voip.messages.conversation.ui.view.i)this.mView).a(this.G);
    }
  }

  public void b(com.viber.voip.model.h paramh)
  {
    p.a(this, paramh);
  }

  public void b(boolean paramBoolean)
  {
    b(false, true);
    this.n.post(new b(this, paramBoolean));
  }

  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = System.currentTimeMillis();
    if (((paramBoolean2) && (this.z != paramBoolean1)) || (l1 - this.y > 4000L))
    {
      this.z = paramBoolean1;
      this.y = l1;
      this.s.post(this.H);
    }
  }

  public void b_(long paramLong)
  {
    if ((this.p != null) && (paramLong != this.p.getId()))
      g();
  }

  public void c()
  {
    ((com.viber.voip.messages.conversation.ui.view.i)this.mView).f();
  }

  public void c(boolean paramBoolean)
  {
    if (this.e.m() == paramBoolean)
      return;
    this.e.e(paramBoolean);
    if (paramBoolean)
      this.i.b();
    while (true)
    {
      k();
      g(paramBoolean);
      ((com.viber.voip.messages.conversation.ui.view.i)this.mView).b(paramBoolean);
      return;
      this.i.c();
    }
  }

  public void d()
  {
    this.g.a(this.o);
  }

  public void d(boolean paramBoolean)
  {
    this.B = paramBoolean;
    k();
  }

  public void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((com.viber.voip.messages.conversation.ui.view.i)this.mView).c(true);
      ((com.viber.voip.messages.conversation.ui.view.i)this.mView).e(false);
      return;
    }
    a(this.p, this.q, this.e.g());
  }

  public boolean e()
  {
    return (!this.D) && (this.p != null) && (com.viber.voip.messages.d.a.a(this.p.isOneToOneWithPublicAccount()));
  }

  public void f()
  {
    ((com.viber.voip.messages.conversation.ui.view.i)this.mView).c(true);
    ((com.viber.voip.messages.conversation.ui.view.i)this.mView).e(false);
  }

  public void g()
  {
    if ((this.p != null) && (!this.e.n()) && (this.p.canWrite()))
    {
      this.w.a(this.p.getId(), this.p.getConversationType(), this.e.h(), p(), this.l.b());
      this.l.c();
    }
  }

  public void h()
  {
    if (this.E == null)
      return;
    this.e.a(this.E.getInputState());
    if (this.e.m())
      g(true);
    while (true)
    {
      this.E = null;
      return;
      if (this.E.isChatExEnabled())
        c(true);
    }
  }

  public void i()
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this);
  }

  public void j()
  {
    com.viber.voip.messages.conversation.ui.b.m.a(this);
  }

  public void k()
  {
    if (this.e.m())
    {
      ((com.viber.voip.messages.conversation.ui.view.i)this.mView).a(MessageEditText.a.d, this.B);
      return;
    }
    if (this.e.n())
    {
      ((com.viber.voip.messages.conversation.ui.view.i)this.mView).a(MessageEditText.a.c, this.B);
      return;
    }
    if (this.e.q())
    {
      ((com.viber.voip.messages.conversation.ui.view.i)this.mView).a(MessageEditText.a.b, this.B);
      return;
    }
    ((com.viber.voip.messages.conversation.ui.view.i)this.mView).a(MessageEditText.a.a, this.B);
  }

  public void l()
  {
    if (s())
      this.x.f("Cancel");
  }

  public void n()
  {
    ab.b(this);
  }

  public void onDestroy(android.arch.lifecycle.h paramh)
  {
    super.onDestroy(paramh);
    this.s.removeCallbacks(this.H);
    this.b.b(this);
    this.a.b(this);
    this.e.b(this);
    this.c.b(this);
    this.d.b(this);
    this.f.b(this);
    this.t.unregister(this.u);
  }

  public void onPause(android.arch.lifecycle.h paramh)
  {
    super.onPause(paramh);
    g();
  }

  private static class a extends com.viber.voip.d.b<InputFieldPresenter>
  {
    private a(InputFieldPresenter paramInputFieldPresenter)
    {
      super();
    }

    public void a(InputFieldPresenter paramInputFieldPresenter)
    {
      if (paramInputFieldPresenter != null)
        InputFieldPresenter.a(paramInputFieldPresenter);
    }
  }

  public static class b
    implements com.viber.voip.messages.ui.input.a
  {
    private InputFieldPresenter a;

    public CharSequence a()
    {
      if (this.a == null)
        return "";
      return this.a.e.e();
    }

    public void a(InputFieldPresenter paramInputFieldPresenter)
    {
      this.a = paramInputFieldPresenter;
    }

    public void a(CharSequence paramCharSequence)
    {
      if (this.a != null)
        InputFieldPresenter.a(this.a, paramCharSequence);
    }

    public void b(CharSequence paramCharSequence)
    {
      if (this.a != null)
        InputFieldPresenter.b(this.a, paramCharSequence);
    }
  }

  private static final class c extends i.a<InputFieldPresenter<? extends com.viber.voip.messages.conversation.ui.view.i>>
  {
    c(InputFieldPresenter<? extends com.viber.voip.messages.conversation.ui.view.i> paramInputFieldPresenter, int paramInt)
    {
      super(paramInt);
    }

    protected void a(InputFieldPresenter<? extends com.viber.voip.messages.conversation.ui.view.i> paramInputFieldPresenter, i.b paramb)
    {
      InputFieldPresenter.b(paramInputFieldPresenter);
      ((com.viber.voip.messages.conversation.ui.view.i)InputFieldPresenter.c(paramInputFieldPresenter)).c(true);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.input.InputFieldPresenter
 * JD-Core Version:    0.6.2
 */