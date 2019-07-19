package com.viber.voip.messages.conversation.ui.view.a.c;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.viber.common.b.d;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.voip.ConversationListView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.analytics.story.o;
import com.viber.voip.banner.notificationsoff.f.b;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.d.ae;
import com.viber.voip.messages.conversation.af;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView.a;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView.b;
import com.viber.voip.messages.conversation.ui.banner.g.a;
import com.viber.voip.messages.conversation.ui.banner.m;
import com.viber.voip.messages.conversation.ui.banner.r;
import com.viber.voip.messages.conversation.ui.banner.s.a;
import com.viber.voip.messages.conversation.ui.banner.w.a;
import com.viber.voip.messages.conversation.ui.bc;
import com.viber.voip.messages.conversation.ui.bf;
import com.viber.voip.messages.conversation.ui.bl;
import com.viber.voip.messages.conversation.ui.bn;
import com.viber.voip.messages.conversation.ui.bp;
import com.viber.voip.messages.conversation.ui.cj;
import com.viber.voip.messages.conversation.ui.j;
import com.viber.voip.messages.conversation.ui.presenter.banners.top.TopBannerPresenter;
import com.viber.voip.messages.ui.MessageComposerView;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallModel;
import com.viber.voip.phone.viber.conference.ui.banner.OngoingConferenceBannerWrapper;
import com.viber.voip.phone.viber.conference.ui.banner.OngoingConferenceBannerWrapper.Listener;
import com.viber.voip.settings.d.ba;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.l;
import com.viber.voip.util.cd;
import com.viber.voip.util.dg;
import com.viber.voip.util.e.e;
import java.util.Collections;

public class g<P extends TopBannerPresenter> extends com.viber.voip.messages.conversation.ui.view.b.a<P>
  implements f.b, ae, ConversationAlertView.b, f, OngoingConferenceBannerWrapper.Listener
{
  protected final ConversationAlertView a;
  protected final com.viber.voip.messages.conversation.adapter.k b;
  private final SwipeRefreshLayout g;
  private final cj h;
  private com.viber.voip.messages.conversation.ui.banner.b i;
  private final m j;
  private final com.viber.voip.messages.conversation.ui.banner.c k;
  private final com.viber.voip.messages.conversation.ui.banner.h l;
  private final bc m;
  private final bl n;
  private final com.viber.voip.messages.conversation.ui.b o;
  private final bn p;
  private bf q;
  private final OngoingConferenceBannerWrapper r;
  private final MessageComposerView s;
  private final bp t;

  public g(P paramP, Activity paramActivity, ConversationFragment paramConversationFragment, View paramView, boolean paramBoolean, ConversationAlertView paramConversationAlertView, com.viber.voip.messages.conversation.adapter.k paramk, SwipeRefreshLayout paramSwipeRefreshLayout, j paramj, MessageComposerView paramMessageComposerView, bp parambp, com.viber.voip.analytics.g paramg, com.viber.voip.analytics.story.e.c paramc, com.viber.voip.analytics.story.a.a parama, com.viber.voip.messages.d.b paramb)
  {
    super(paramP, paramActivity, paramConversationFragment, paramView, paramBoolean);
    this.a = paramConversationAlertView;
    this.b = paramk;
    this.g = paramSwipeRefreshLayout;
    this.h = new cj((LinearLayout)paramView.findViewById(R.id.top_banner_container), this.d.getLayoutInflater());
    this.s = paramMessageComposerView;
    this.j = new m(this.d);
    this.k = new com.viber.voip.messages.conversation.ui.banner.c(paramActivity, paramb);
    this.l = new com.viber.voip.messages.conversation.ui.banner.h(this.d, this);
    this.m = new bc(this.d, this.a, paramc);
    this.n = new bl(this.d, this.a, ViberApplication.getInstance().getMessagesManager().c(), paramj, paramb, paramg.c().a());
    this.o = new com.viber.voip.messages.conversation.ui.b(this.d, this.a, parama);
    this.p = new bn(this.d, this.a, e.a(this.d.getActivity()), (w.a)this.mPresenter, paramb);
    this.r = new OngoingConferenceBannerWrapper(this.a, this, paramConversationFragment.getLayoutInflater());
    this.a.setNoParticipantsBannerListener((s.a)this.mPresenter);
    this.a.setBlockListener((g.a)this.mPresenter);
    this.a.setSizeChangeListener(this);
    this.t = parambp;
  }

  public void J_()
  {
    Bundle localBundle = new Bundle();
    this.a.a(ConversationAlertView.a.q, localBundle, false);
  }

  public void K_()
  {
    this.e.setStickyHeaderStickyPosition(this.a.getBannersHeight());
  }

  public View a(int paramInt)
  {
    return this.h.a(paramInt);
  }

  public void a(int paramInt, aa paramaa)
  {
    if ((paramInt == R.id.menu_reply) && (d.ba.a.d() == 1) && (((TopBannerPresenter)this.mPresenter).p()))
      J_();
  }

  public void a(Pin paramPin)
  {
    this.p.a(paramPin);
  }

  public void a(Pin paramPin, j paramj)
  {
    l.b(paramj, paramPin).b(this.d);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, af paramaf, boolean paramBoolean)
  {
    this.p.a(paramConversationItemLoaderEntity, paramaf, paramBoolean);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, OngoingConferenceCallModel paramOngoingConferenceCallModel)
  {
    this.r.bind(paramConversationItemLoaderEntity, paramOngoingConferenceCallModel);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, Runnable paramRunnable)
  {
    com.viber.voip.block.g.a(this.d.getActivity(), Collections.singleton(Member.from(paramConversationItemLoaderEntity)), dg.a(paramConversationItemLoaderEntity), paramConversationItemLoaderEntity.isSecret(), paramRunnable);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString)
  {
    this.d.a(paramConversationItemLoaderEntity, paramString);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2;
    com.viber.voip.messages.conversation.ui.banner.c localc;
    if (paramConversationItemLoaderEntity != null)
    {
      m localm = this.j;
      if (paramBoolean)
        break label65;
      bool2 = bool1;
      localm.a(paramConversationItemLoaderEntity, bool2, this.b);
      localc = this.k;
      if (paramBoolean)
        break label71;
    }
    while (true)
    {
      localc.a(paramConversationItemLoaderEntity, bool1, this.b);
      this.l.a(paramConversationItemLoaderEntity, this.b);
      return;
      label65: bool2 = false;
      break;
      label71: bool1 = false;
    }
  }

  public void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    ((TopBannerPresenter)this.mPresenter).a(paramPublicGroupConversationItemLoaderEntity);
  }

  public void a(String paramString)
  {
    if (this.c != null)
      this.c.runOnUiThread(new h(this, paramString));
  }

  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (this.i == null)
        this.i = new r(this.h.a(R.layout.alertbaner_connection_layout));
      this.h.b(this.i.layout);
    }
    while (this.i == null)
      return;
    this.h.c(this.i.layout);
  }

  public boolean a(View paramView)
  {
    return this.h.a(paramView);
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    FragmentActivity localFragmentActivity = this.d.getActivity();
    if ((paramConversationItemLoaderEntity != null) && (localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
    {
      this.t.a(paramConversationItemLoaderEntity, this.b);
      if (paramBoolean)
        this.e.e();
    }
  }

  public boolean b(View paramView)
  {
    return this.h.c(paramView);
  }

  public boolean b(ConversationAlertView.a parama)
  {
    return this.a.a(parama);
  }

  public void c(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
  }

  public void d(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
  }

  public void d_(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.g.getLayoutParams();
    if (paramBoolean);
    for (int i1 = R.id.edit_options; ; i1 = R.id.message_composer)
    {
      localLayoutParams.addRule(2, i1);
      return;
    }
  }

  public void e()
  {
    this.a.a(ConversationAlertView.a.a, false);
  }

  public void e(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.m.a(paramConversationItemLoaderEntity, this.b, this.g, this.e);
  }

  public void f()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("alert_text_extra", this.d.getString(R.string.no_participants_broadcast_list_alert_msg));
    this.a.a(ConversationAlertView.a.a, localBundle, false);
  }

  public void f(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.n.a(paramConversationItemLoaderEntity);
  }

  public void g()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("alert_text_extra", this.d.getString(R.string.no_participants_alert_msg));
    this.a.a(ConversationAlertView.a.a, localBundle, false);
  }

  public void g(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.o.a(paramConversationItemLoaderEntity);
  }

  public void h(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.p.a(paramConversationItemLoaderEntity, false);
  }

  public void i()
  {
    this.a.a(ConversationAlertView.a.q, true);
  }

  public void i(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("display_name", dg.a(paramConversationItemLoaderEntity));
    this.a.a(ConversationAlertView.a.k, localBundle, false);
  }

  public void j()
  {
    this.n.a();
  }

  public void j(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if ((r()) && (!cd.c(paramConversationItemLoaderEntity.getNumber())))
    {
      if (this.q == null)
        this.q = new bf(this.d);
      this.q.a(paramConversationItemLoaderEntity);
    }
  }

  public void k()
  {
    this.o.c();
  }

  public void l()
  {
    this.r.hide();
  }

  public void m()
  {
    this.p.a();
  }

  public void n()
  {
    this.a.a(ConversationAlertView.a.k, false);
  }

  public void o()
  {
    ad.a().b(this.d);
  }

  public void onConferenceBannerVisibilityChanged(boolean paramBoolean)
  {
    ((TopBannerPresenter)this.mPresenter).d(paramBoolean);
  }

  public void onJoinConference(long paramLong1, ConferenceInfo paramConferenceInfo, long paramLong2)
  {
    ((TopBannerPresenter)this.mPresenter).a(paramLong1, paramConferenceInfo, paramLong2);
  }

  public void p()
  {
    com.viber.voip.ui.dialogs.f.d().b(this.d);
  }

  public void q()
  {
    com.viber.voip.ui.dialogs.f.a().d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.a.c.g
 * JD-Core Version:    0.6.2
 */