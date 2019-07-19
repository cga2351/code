package com.viber.voip.messages.conversation.ui.presenter.banners.top;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.i.c.d;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.d;
import com.viber.voip.messages.controller.bv.e;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.ac;
import com.viber.voip.messages.conversation.adapter.d.ad;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.q;
import com.viber.voip.messages.conversation.s;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.conversation.ui.SpamController;
import com.viber.voip.messages.conversation.ui.SpamController.b;
import com.viber.voip.messages.conversation.ui.b.ag;
import com.viber.voip.messages.conversation.ui.b.ah;
import com.viber.voip.messages.conversation.ui.b.aj;
import com.viber.voip.messages.conversation.ui.b.ak;
import com.viber.voip.messages.conversation.ui.b.al;
import com.viber.voip.messages.conversation.ui.b.e;
import com.viber.voip.messages.conversation.ui.b.i;
import com.viber.voip.messages.conversation.ui.b.l;
import com.viber.voip.messages.conversation.ui.b.n;
import com.viber.voip.messages.conversation.ui.b.o;
import com.viber.voip.messages.conversation.ui.b.p;
import com.viber.voip.messages.conversation.ui.b.u;
import com.viber.voip.messages.conversation.ui.b.v;
import com.viber.voip.messages.conversation.ui.b.w;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView.a;
import com.viber.voip.messages.conversation.ui.banner.g.a;
import com.viber.voip.messages.conversation.ui.banner.s.a;
import com.viber.voip.messages.conversation.ui.banner.w.a;
import com.viber.voip.messages.conversation.ui.j;
import com.viber.voip.messages.conversation.ui.presenter.banners.BannerPresenter;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository.ConferenceAvailabilityListener;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository.ConferenceAvailabilityListener..CC;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallModel;
import com.viber.voip.settings.d.ba;
import com.viber.voip.ui.t.b.a;
import com.viber.voip.ui.t.c;
import com.viber.voip.util.cj;
import com.viber.voip.util.cj.a;
import dagger.a;
import java.util.Map;

public abstract class TopBannerPresenter<VIEW extends com.viber.voip.messages.conversation.ui.view.a.c.f> extends BannerPresenter<VIEW, TopBannerState>
  implements ad, SpamController.b, ag, ak, com.viber.voip.messages.conversation.ui.b.g, l, o, v, g.a, s.a, w.a, ConferenceCallsRepository.ConferenceAvailabilityListener
{
  protected static final Logger c = ViberEnv.getLogger();
  protected long d;
  protected final ai e;
  private final n f;
  private final i g;
  private final u h;
  private final com.viber.voip.messages.conversation.ui.b.af i;
  private final s j;
  private j k;
  private cj l;
  private aj m;
  private SpamController n;
  private com.viber.voip.analytics.story.d.c o;
  private com.viber.voip.analytics.story.b.c p;
  private Engine q;
  private final e r;
  private CallHandler s;
  private final a<ConferenceCallsRepository> t;
  private final a<com.viber.voip.notif.g> u;
  private final bv v;
  private final bv.e w = new bv.d()
  {
    public void onConversationClosed(boolean paramAnonymousBoolean, long paramAnonymousLong)
    {
      TopBannerPresenter.a(TopBannerPresenter.this);
    }
  };
  private final cj.a x = new cj.a()
  {
    public void connectivityChanged(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      TopBannerPresenter localTopBannerPresenter = TopBannerPresenter.this;
      if (-1 != paramAnonymousInt2);
      for (boolean bool = true; ; bool = false)
      {
        localTopBannerPresenter.b(bool);
        return;
      }
    }
  };

  public TopBannerPresenter(com.viber.voip.messages.conversation.ui.b.f paramf, n paramn, i parami, u paramu, com.viber.voip.messages.conversation.ui.b.af paramaf, s params, j paramj, Handler paramHandler, cj paramcj, Engine paramEngine, com.viber.voip.contacts.c.c.a.b paramb, com.viber.voip.block.b paramb1, com.viber.voip.analytics.story.d.c paramc, com.viber.voip.analytics.story.b.c paramc1, aj paramaj, SpamController paramSpamController, a<ConferenceCallsRepository> parama, CallHandler paramCallHandler, e parame, ai paramai, a<com.viber.voip.notif.g> parama1, bv parambv)
  {
    super(paramf, paramHandler, paramb, paramb1.b());
    this.f = paramn;
    this.g = parami;
    this.h = paramu;
    this.i = paramaf;
    this.j = params;
    this.k = paramj;
    this.l = paramcj;
    this.m = paramaj;
    this.n = paramSpamController;
    this.q = paramEngine;
    this.t = parama;
    this.r = parame;
    this.s = paramCallHandler;
    this.e = paramai;
    this.u = parama1;
    this.o = paramc;
    this.p = paramc1;
    this.v = parambv;
  }

  private void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if (paramConversationItemLoaderEntity == null)
      return;
    OngoingConferenceCallModel localOngoingConferenceCallModel = ((ConferenceCallsRepository)this.t.get()).getConversationConferenceAvailableToJoin(paramConversationItemLoaderEntity.getId());
    ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).a(this.b, localOngoingConferenceCallModel);
  }

  private void a(com.viber.voip.messages.conversation.af paramaf, boolean paramBoolean)
  {
    ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).a(this.b, paramaf, paramBoolean);
  }

  private void a(Map<Long, OngoingConferenceCallModel> paramMap)
  {
    if ((this.b != null) && (paramMap.containsKey(Long.valueOf(this.b.getId()))))
      a(this.b);
  }

  private void e(boolean paramBoolean)
  {
    ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).a(this.b, paramBoolean);
  }

  private void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (com.viber.voip.messages.m.c(this.b.getConversationType()))
      {
        ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).f();
        return;
      }
      ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).g();
      return;
    }
    ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).e();
  }

  private void m()
  {
    if (d.ba.a.d() == 2)
      d.ba.a.a(3);
  }

  public void G_()
  {
    w.a(this);
  }

  protected void I_()
  {
  }

  public void J()
  {
    ah.a(this);
  }

  public void K()
  {
    ah.b(this);
  }

  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    if (c.d.a.e())
      ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).a(paramString);
  }

  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    com.viber.voip.messages.conversation.ui.b.m.a(this, paramLong1, paramInt, paramLong2);
  }

  public void a(long paramLong1, long paramLong2)
  {
    this.e.a(paramLong1, paramLong2);
  }

  public void a(long paramLong1, ConferenceInfo paramConferenceInfo, long paramLong2)
  {
    if (this.b == null)
      return;
    if (this.l.a() == -1)
    {
      ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).o();
      return;
    }
    if (this.q.getServiceState() != ServiceStateDelegate.ServiceState.SERVICE_CONNECTED)
    {
      ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).p();
      return;
    }
    this.s.handleJoinOngoingAudioConference(paramLong1, paramConferenceInfo, paramLong2);
    ((com.viber.voip.notif.g)this.u.get()).b().a(paramLong1, paramLong2);
    com.viber.voip.analytics.story.b.c localc = this.p;
    if (this.b.isConversation1on1());
    for (String str = "1-on-1 Chat"; ; str = "Group Chat")
    {
      localc.c(str);
      return;
    }
  }

  public void a(Pin paramPin)
  {
    if (this.b == null)
      return;
    ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).a(paramPin, this.k);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    super.a(paramConversationItemLoaderEntity, paramBoolean);
    if (!paramBoolean)
      e(this.j.o());
    this.d = paramConversationItemLoaderEntity.getId();
    ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).c(paramConversationItemLoaderEntity);
  }

  public void a(aa paramaa)
  {
    com.viber.voip.messages.conversation.adapter.f.a(this, paramaa);
  }

  public void a(aa paramaa, int paramInt)
  {
    ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).i();
  }

  public void a(ac paramac, boolean paramBoolean)
  {
    int i1 = 1;
    if (this.b == null)
      return;
    if ((paramac.getCount() == i1) && ((this.b.isGroupType()) || (this.b.isBroadcastListType())) && (!this.b.isDisabledConversation()));
    while (true)
    {
      f(i1);
      return;
      int i2 = 0;
    }
  }

  public void a(com.viber.voip.messages.conversation.adapter.a.b.f paramf, boolean paramBoolean)
  {
    int i1 = paramf.getCount();
    com.viber.voip.messages.conversation.af localaf = null;
    if (i1 > 0)
      localaf = paramf.e(0);
    a(localaf, false);
  }

  public void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
  }

  public void a(q paramq, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    e(paramq.B());
  }

  public void a(ConversationData paramConversationData)
  {
    if ((paramConversationData.conversationId != this.d) && (this.d > -1L))
    {
      ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).j();
      ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).k();
      ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).m();
      ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).l();
    }
    ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).a(paramConversationData.getLastMessagePin());
  }

  protected void a(TopBannerState paramTopBannerState)
  {
    super.onViewAttached(paramTopBannerState);
    if (paramTopBannerState != null)
      this.d = paramTopBannerState.getConversationId();
    this.l.a(this.x);
    this.i.a(this);
    this.g.a(this);
    this.f.a(this);
    this.m.a(this);
    this.h.a(this);
    this.n.a(this);
    this.v.a(this.w);
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
    if (this.l.a() == -1)
    {
      if ((paramBoolean) && (this.l.c()))
      {
        ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).q();
        return;
      }
      ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).a(false);
      return;
    }
    ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).a(true);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    com.viber.voip.messages.conversation.ui.b.m.a(this, paramBoolean1, paramBoolean2);
  }

  public void a_(long paramLong1, int paramInt, long paramLong2)
  {
    this.g.a(paramLong1, paramInt, paramLong2);
  }

  public void b()
  {
    k();
  }

  public void b(com.viber.voip.model.h paramh)
  {
    p.a(this, paramh);
  }

  protected void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).b(ConversationAlertView.a.j)) && (this.j.i() != null))
      a(this.j.i().e(0), true);
    if (paramBoolean)
      c(true);
  }

  public void c()
  {
    k();
  }

  public void c(boolean paramBoolean)
  {
    ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).a(paramBoolean);
  }

  public void d()
  {
  }

  public void d(boolean paramBoolean)
  {
    this.r.a(paramBoolean);
  }

  public void e()
  {
    ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).a(this.b, new d(this));
    this.o.b(1.0D, "Block Banner");
  }

  public void f()
  {
    ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).a(this.b, null);
  }

  public void g()
  {
    al.a(this);
  }

  public void j()
  {
    com.viber.voip.messages.conversation.ui.b.m.a(this);
  }

  protected void k()
  {
    a(this.b);
    if (this.b.isConversation1on1())
      ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).e();
    ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).e(this.b);
    ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).f(this.b);
    ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).g(this.b);
    if ((this.b.isCommunityType()) && (this.j.i() != null));
    for (com.viber.voip.messages.conversation.af localaf = this.j.i().e(0); ; localaf = null)
    {
      int i1;
      if (localaf != null)
      {
        ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).a(this.b, localaf, false);
        com.viber.voip.model.entity.m localm = SpamController.a(this.b.isGroupBehavior(), this.b.getCreatorParticipantInfoId(), this.b.getParticipantMemberId());
        if ((localm == null) || (!com.viber.voip.block.g.a(new Member(localm.a()), this.b.isVlnConversation())))
          break label337;
        i1 = 1;
        label187: boolean bool = ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).b(ConversationAlertView.a.c);
        if ((i1 == 0) || (!this.b.isConversation1on1()) || (bool))
          break label342;
        ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).i(this.b);
        label239: if ((d.ba.a.d() != 2) || (!p()))
          break label357;
        ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).J_();
      }
      while (true)
      {
        ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).j(this.b);
        ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).b(this.b, false);
        ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).d(this.b);
        return;
        ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).h(this.b);
        break;
        label337: i1 = 0;
        break label187;
        label342: ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).n();
        break label239;
        label357: ((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).i();
      }
    }
  }

  protected TopBannerState o()
  {
    return new TopBannerState(this.d);
  }

  public void onConferenceMissedInProgress(OngoingConferenceCallModel paramOngoingConferenceCallModel, String paramString1, String paramString2)
  {
    ConferenceCallsRepository.ConferenceAvailabilityListener..CC.onConferenceMissedInProgress(this, paramOngoingConferenceCallModel, paramString1, paramString2);
  }

  public void onConferencesAvailable(Map<Long, OngoingConferenceCallModel> paramMap)
  {
    a(paramMap);
  }

  public void onConferencesUnavailable(Map<Long, OngoingConferenceCallModel> paramMap)
  {
    a(paramMap);
  }

  public void onDestroy(android.arch.lifecycle.h paramh)
  {
    super.onDestroy(paramh);
    this.f.b(this);
    this.g.b(this);
    this.i.b(this);
    this.m.b(this);
    this.h.b(this);
    this.l.b(this.x);
    this.n.b(this);
    this.v.b(this.w);
  }

  public void onStart(android.arch.lifecycle.h paramh)
  {
    super.onStart(paramh);
    ((ConferenceCallsRepository)this.t.get()).registerConferenceAvailabilityListener(this);
    if (this.k.f())
    {
      if ((((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).b(ConversationAlertView.a.j)) && (this.j.i() != null))
        a(this.j.i().e(0), false);
      if (((com.viber.voip.messages.conversation.ui.view.a.c.f)this.mView).b(ConversationAlertView.a.n))
        a(this.b);
    }
  }

  public void onStop(android.arch.lifecycle.h paramh)
  {
    super.onStop(paramh);
    ((ConferenceCallsRepository)this.t.get()).unregisterConferenceAvailabilityListener(this);
    m();
  }

  public boolean p()
  {
    return (this.b != null) && (this.b.isSupportedReply());
  }

  protected final int q()
  {
    return this.j.g().w();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.banners.top.TopBannerPresenter
 * JD-Core Version:    0.6.2
 */