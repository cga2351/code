package com.viber.voip.messages.conversation.publicaccount;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.util.LongSparseArray;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.m.c;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.cdr.entity.PublicAccountImpression;
import com.viber.jni.cdr.entity.PublicAccountInteraction;
import com.viber.voip.ConversationListView;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.SpamController;
import com.viber.voip.messages.conversation.ui.a.v;
import com.viber.voip.messages.conversation.ui.aq;
import com.viber.voip.messages.conversation.ui.b.ac;
import com.viber.voip.messages.conversation.ui.b.aj;
import com.viber.voip.messages.conversation.ui.b.n;
import com.viber.voip.messages.conversation.ui.b.u;
import com.viber.voip.messages.conversation.ui.b.x;
import com.viber.voip.messages.conversation.ui.b.z;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView;
import com.viber.voip.messages.conversation.ui.bd;
import com.viber.voip.messages.conversation.ui.bm;
import com.viber.voip.messages.conversation.ui.bp;
import com.viber.voip.messages.conversation.ui.bt;
import com.viber.voip.messages.conversation.ui.presenter.GeneralConversationPresenter;
import com.viber.voip.messages.conversation.ui.presenter.GeneralPublicGroupConversationPresenter;
import com.viber.voip.messages.conversation.ui.presenter.MessagesActionsPresenter;
import com.viber.voip.messages.conversation.ui.presenter.PublicGroupMessagesActionsPresenter;
import com.viber.voip.messages.conversation.ui.presenter.banners.bottom.PublicGroupBottomBannerPresenter;
import com.viber.voip.messages.conversation.ui.presenter.banners.top.PublicGroupTopBannerPresenter;
import com.viber.voip.messages.conversation.ui.presenter.input.InputFieldPresenter.b;
import com.viber.voip.messages.conversation.ui.presenter.input.PublicGroupInputFieldPresenter;
import com.viber.voip.messages.ui.MessageComposerView;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.registration.af;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.r;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.r;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.util.cj;
import com.viber.voip.util.cq;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;

public class PublicGroupConversationFragment extends ConversationFragment
  implements m.c, f, g
{
  private Boolean a;
  private int b;
  private boolean c = false;
  private j d;
  private long e = 0L;
  private c f;
  private final Runnable g = new l(this);
  private Runnable h = new a(this, null);

  @Inject
  ai q;

  @Inject
  com.viber.voip.analytics.story.b.c r;
  protected com.viber.voip.messages.conversation.k s;
  public int t = 3;
  protected long u;
  protected boolean v = false;
  protected com.viber.voip.messages.conversation.ui.view.m w;
  protected ICdrController x;

  private void a()
  {
    if ((this.a == null) || (!this.a.booleanValue()))
    {
      this.a = Boolean.valueOf(true);
      View localView1 = View.inflate(getActivity(), R.layout.msg_conversation_new_viber_splash, null);
      View localView2 = localView1.findViewById(R.id.touchable_place);
      Resources localResources = getResources();
      localView2.getLayoutParams().height = (localResources.getDimensionPixelSize(R.dimen.msg_edit_text_height_one_line) + localResources.getDimensionPixelSize(R.dimen.composer_btn_height) + localResources.getDimensionPixelSize(R.dimen.composer_btn_margin_bottom));
      ((ViewGroup)getView().findViewById(R.id.conversation_top)).addView(localView1, new ViewGroup.LayoutParams(-1, -1));
      localView1.setOnTouchListener(new View.OnTouchListener()
      {
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          if (paramAnonymousMotionEvent.getAction() == 0)
            PublicGroupConversationFragment.a(PublicGroupConversationFragment.this);
          return false;
        }
      });
    }
  }

  private void a(boolean paramBoolean)
  {
    if (this.az == null);
    com.viber.voip.messages.conversation.q localq;
    do
    {
      return;
      localq = this.az.g();
    }
    while ((localq.getCount() == 0) || (this.au == null) || (!this.au.b().d()));
    int i = localq.x();
    int j = localq.w();
    GroupController localGroupController = ((com.viber.voip.messages.k)aj().get()).d();
    long l = this.u;
    if (i > 1)
      if (j <= 1)
        break label109;
    while (true)
    {
      localGroupController.a(l, i, j, paramBoolean);
      return;
      i = 1;
      break;
      label109: j = 1;
    }
  }

  private void b()
  {
    if ((this.a == null) || (this.a.booleanValue()))
    {
      this.a = Boolean.valueOf(false);
      View localView = getView().findViewById(R.id.vibe_splash);
      if (localView != null)
        ((ViewGroup)getView().findViewById(R.id.conversation_top)).removeView(localView);
    }
  }

  private void c()
  {
    this.aE.removeCallbacks(this.h);
    this.aE.postDelayed(this.h, 60000L);
  }

  private void c(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      long l = paramBundle.getLong("cdr_session_token", 0L);
      if (l != 0L)
        this.e = l;
    }
    if ((this.e == 0L) && (this.e == 0L))
      this.e = new SecureRandom().nextLong();
  }

  public PublicAccountInteraction a(aa paramaa, String paramString)
  {
    PublicGroupConversationItemLoaderEntity localPublicGroupConversationItemLoaderEntity = r();
    if (localPublicGroupConversationItemLoaderEntity == null);
    while (paramaa == null)
      return null;
    return PublicAccountInteraction.create(this.e, paramString, localPublicGroupConversationItemLoaderEntity, paramaa);
  }

  protected com.viber.voip.messages.conversation.s a(Context paramContext, LoaderManager paramLoaderManager, dagger.a<com.viber.voip.messages.k> parama, EventBus paramEventBus, Bundle paramBundle)
  {
    return new com.viber.voip.messages.conversation.s(paramContext, paramLoaderManager, parama, this.aZ, this.ba, this.bb, this.bc, paramEventBus, 2, paramBundle);
  }

  protected MessagesActionsPresenter a(SpamController paramSpamController, com.viber.voip.messages.conversation.ui.b.f paramf, ac paramac, com.viber.voip.messages.conversation.ui.b.i parami, ai paramai, com.viber.common.permission.c paramc, com.viber.voip.messages.conversation.ui.j paramj, Engine paramEngine, af paramaf, Handler paramHandler1, Handler paramHandler2, Handler paramHandler3, com.viber.voip.analytics.g paramg, IRingtonePlayer paramIRingtonePlayer, com.viber.voip.messages.controller.publicaccount.d paramd, com.viber.voip.messages.conversation.ui.b.a parama, com.viber.voip.messages.d.b paramb, o paramo, Handler paramHandler4, bm parambm, x paramx, aj paramaj, com.viber.voip.stickers.b paramb1, com.viber.voip.stickers.i parami1, com.viber.voip.stickers.a.a parama1, n paramn, u paramu, ActivationController paramActivationController, z paramz, com.viber.voip.messages.extensions.c paramc1, dagger.a<com.viber.voip.invitelinks.q> parama2)
  {
    return new PublicGroupMessagesActionsPresenter(paramSpamController, paramf, paramac, parami, paramai, paramc, paramj, paramEngine, paramaf, paramHandler1, paramHandler3, paramHandler2, paramg, paramIRingtonePlayer, paramd, parama, this.x, paramb, this.mIsTablet, paramo, paramHandler4, parambm, paramx, paramaj, paramb1, parami1, parama1, paramn, paramu, paramActivationController, paramz, d.r.D, paramc1, parama2);
  }

  protected com.viber.voip.messages.conversation.ui.spam.a a(Bundle paramBundle)
  {
    return new com.viber.voip.messages.conversation.ui.spam.b();
  }

  protected com.viber.voip.messages.conversation.ui.view.a.a.b a(View paramView, bd parambd, Bundle paramBundle)
  {
    PublicGroupBottomBannerPresenter localPublicGroupBottomBannerPresenter = new PublicGroupBottomBannerPresenter(this.aZ, com.viber.voip.contacts.c.c.a.b.a(), com.viber.voip.block.b.a().b(), this.aE, aj());
    com.viber.voip.messages.conversation.ui.view.a.a.d locald = new com.viber.voip.messages.conversation.ui.view.a.a.d(localPublicGroupBottomBannerPresenter, getActivity(), this, paramView, this.mIsTablet, this.ao, parambd);
    addMvpView(locald, localPublicGroupBottomBannerPresenter, paramBundle);
    return locald;
  }

  protected com.viber.voip.messages.conversation.ui.view.a.c.f a(View paramView, ConversationAlertView paramConversationAlertView, SwipeRefreshLayout paramSwipeRefreshLayout, Bundle paramBundle)
  {
    Application localApplication = ViberApplication.getApplication();
    PublicGroupTopBannerPresenter localPublicGroupTopBannerPresenter = new PublicGroupTopBannerPresenter(this.aZ, this.ba, this.bb, this.aX, this.bc, this.az, this.at, o.a(), this.aE, cj.a(localApplication), this.S, com.viber.voip.contacts.c.c.a.b.a(), com.viber.voip.block.b.a(), this.H, this.r, this.aR, this.aq, this.be, this.bf, this.aP, this.q, this.bg, this.Z);
    com.viber.voip.messages.conversation.ui.view.a.c.e locale = new com.viber.voip.messages.conversation.ui.view.a.c.e(localPublicGroupTopBannerPresenter, getActivity(), this, paramView, this.mIsTablet, this.aw, paramConversationAlertView, paramSwipeRefreshLayout, this.at, k.a(), new bp(ag(), this.an, getLayoutInflater()), this.av, this.G, this.I, this.J, this.N);
    addMvpView(locale, localPublicGroupTopBannerPresenter, paramBundle);
    this.aH = localPublicGroupTopBannerPresenter;
    return locale;
  }

  protected void a(View paramView, Bundle paramBundle)
  {
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    if ((paramConversationItemLoaderEntity == null) || (isDetached()) || (!isAdded()))
      return;
    super.a(paramConversationItemLoaderEntity, paramBoolean);
    PublicGroupConversationItemLoaderEntity localPublicGroupConversationItemLoaderEntity = (PublicGroupConversationItemLoaderEntity)paramConversationItemLoaderEntity;
    this.t = localPublicGroupConversationItemLoaderEntity.getGroupRole();
    this.u = localPublicGroupConversationItemLoaderEntity.getGroupId();
    if (paramBoolean)
      a(localPublicGroupConversationItemLoaderEntity);
    if (this.f != null)
      this.f.a(localPublicGroupConversationItemLoaderEntity);
    a(this.s);
    l();
  }

  protected void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    int i = 1;
    if ((paramPublicGroupConversationItemLoaderEntity.getGroupRole() == 2) && (paramPublicGroupConversationItemLoaderEntity.isPublicGroupType()) && (paramPublicGroupConversationItemLoaderEntity.getRevision() <= i) && (paramPublicGroupConversationItemLoaderEntity.getGroupEnterCount() == 0));
    while (true)
    {
      this.c = i;
      return;
      i = 0;
    }
  }

  protected void a(com.viber.voip.messages.conversation.q paramq)
  {
    int i = 1;
    int j;
    if ((r() != null) && (this.v))
    {
      if (paramq.getCount() != 0)
        break label45;
      j = i;
      if ((j == 0) || (!this.c))
        break label50;
    }
    while (true)
    {
      if (i == 0)
        break label55;
      a();
      return;
      label45: j = 0;
      break;
      label50: i = 0;
    }
    label55: b();
  }

  public void a(com.viber.voip.messages.conversation.q paramq, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    super.a(paramq, paramBoolean1, paramInt, paramBoolean2);
    int i = paramq.getCount();
    if (paramBoolean1)
      a(true);
    while (true)
    {
      this.b = i;
      this.v = true;
      a(paramq);
      return;
      if (i - this.b > 1)
        a(false);
    }
  }

  protected void a(ConversationData paramConversationData)
  {
    super.a(paramConversationData);
    this.v = false;
    this.c = false;
  }

  public void a(List<Long> paramList, boolean paramBoolean)
  {
    if (paramList.size() > 0)
    {
      if (!ao.f())
        com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.g.a(Boolean.TRUE));
      ((com.viber.voip.messages.k)aj().get()).c().a(((Long)paramList.get(0)).longValue(), this.bi);
    }
  }

  public void a(MessageEntity[] paramArrayOfMessageEntity, Bundle paramBundle)
  {
    this.b += paramArrayOfMessageEntity.length;
    super.a(paramArrayOfMessageEntity, paramBundle);
  }

  protected com.viber.voip.messages.conversation.ui.view.i b(View paramView, Bundle paramBundle)
  {
    PublicGroupInputFieldPresenter localPublicGroupInputFieldPresenter = new PublicGroupInputFieldPresenter(this.aS, this.aN, this.aZ, this.ba, this.bb, this.aY, this.aX, this.av.getReplyBannerViewController(), this.av.getMentionsViewController(), com.viber.voip.flatbuffers.b.e.b().a(), com.viber.voip.flatbuffers.b.e.b().b(), com.viber.voip.bot.b.a(), ViberApplication.getInstance().getEngine(false).getExchanger(), av.e.a.a(), av.e.f.a(), com.viber.voip.h.a.b(), this.ab, this.N, this.q, this.mIsTablet, dj.c(getContext()), this.L);
    this.bh.a(localPublicGroupInputFieldPresenter);
    this.aT.a(localPublicGroupInputFieldPresenter);
    com.viber.voip.messages.conversation.ui.view.b.s locals = new com.viber.voip.messages.conversation.ui.view.b.s(localPublicGroupInputFieldPresenter, getActivity(), this, paramView, this.mIsTablet, this.av, this.aA, o(), n());
    addMvpView(locals, localPublicGroupInputFieldPresenter, paramBundle);
    return locals;
  }

  public void b(aa paramaa, String paramString)
  {
    PublicAccountInteraction localPublicAccountInteraction = a(paramaa, paramString);
    if (localPublicAccountInteraction != null)
      this.x.handleReportPAInteractions(localPublicAccountInteraction.publicAccountId, localPublicAccountInteraction.publicAccountCategory, localPublicAccountInteraction.publicAccountSubcategory, localPublicAccountInteraction.publicAccountCountryCode, localPublicAccountInteraction.publicAccountLocationInfo, localPublicAccountInteraction.publicChatSessionToken, localPublicAccountInteraction.messageMediaType, localPublicAccountInteraction.messageUrl, null, localPublicAccountInteraction.isGifMessage, localPublicAccountInteraction.messageStickerNumber, localPublicAccountInteraction.messageToken, localPublicAccountInteraction.messageSequence, localPublicAccountInteraction.publicAccountUserRole);
  }

  public void f(aa paramaa)
  {
    super.f(paramaa);
    b(paramaa, null);
  }

  public void g(aa paramaa)
  {
    if (cj.a(true))
    {
      com.viber.voip.messages.conversation.adapter.a.a locala = this.au.b(-1 + this.au.getCount());
      this.s.a(r().getGroupId(), com.viber.voip.messages.conversation.publicaccount.a.a.b(com.viber.voip.messages.m.a(paramaa), locala.c().F()), this.g);
      return;
    }
    this.aX.a(false);
  }

  protected void initModelComponent(View paramView, Bundle paramBundle)
  {
    super.initModelComponent(paramView, paramBundle);
    m();
  }

  public void l()
  {
    boolean bool1 = true;
    PublicGroupConversationItemLoaderEntity localPublicGroupConversationItemLoaderEntity = r();
    boolean bool2;
    boolean bool4;
    label47: label54: boolean bool3;
    if (localPublicGroupConversationItemLoaderEntity != null)
    {
      boolean bool5 = localPublicGroupConversationItemLoaderEntity.isWebhookExist();
      if ((localPublicGroupConversationItemLoaderEntity.getGroupRole() == 2) && (!localPublicGroupConversationItemLoaderEntity.isPendingRole()))
      {
        bool2 = bool1;
        if (da.a(localPublicGroupConversationItemLoaderEntity.getCrm()))
          break label77;
        bool4 = bool1;
        if (localPublicGroupConversationItemLoaderEntity.isNotShareable())
          break label83;
        bool3 = bool5;
      }
    }
    while (true)
    {
      t().a(bool3, bool2, bool4, bool1);
      return;
      bool2 = false;
      break;
      label77: bool4 = false;
      break label47;
      label83: bool1 = false;
      break label54;
      bool2 = false;
      bool1 = false;
      bool3 = false;
      bool4 = false;
    }
  }

  protected void m()
  {
    this.f = new c(this.e, this.aw);
    this.as.e.a(this.f);
  }

  protected a.a n()
  {
    return r.g();
  }

  protected DialogCode o()
  {
    return DialogCode.D1012a;
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((this.a != null) && (this.a.booleanValue()))
    {
      b();
      a();
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.x = ViberApplication.getInstance().getEngine(false).getCdrController();
    c(paramBundle);
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if (!((com.viber.voip.messages.conversation.ui.view.a.a.d)this.aK).onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo))
      super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(R.menu.menu_public_conversation, paramMenu);
    t().a(paramMenu);
    l();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.w = new com.viber.voip.messages.conversation.ui.view.m(this.am, new bt());
    return localView;
  }

  public void onDetach()
  {
    super.onDetach();
    if (this.f != null)
    {
      ArrayList localArrayList = this.f.b();
      if (!localArrayList.isEmpty())
        av.e.f.a().post(new d(this.x, localArrayList));
      this.f.c();
    }
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    super.onOptionsItemSelected(paramMenuItem);
    int i = paramMenuItem.getItemId();
    if (i == R.id.menu_sync_info)
    {
      ViberApplication.getInstance().getMessagesManager().d().a((int)(System.currentTimeMillis() / 100L), this.u, null, 0, 2, this.t);
      return true;
    }
    if (i == R.id.menu_conversation_info)
    {
      a(r(), "Chat Menu");
      return true;
    }
    if (i == R.id.menu_open_1on1_chat)
    {
      u();
      return true;
    }
    if (i == R.id.menu_setup_inbox)
    {
      v();
      return true;
    }
    if (i == R.id.menu_pa_invite_to_follow)
    {
      w();
      return true;
    }
    return t().a(paramMenuItem);
  }

  public void onPause()
  {
    super.onPause();
    this.aE.removeCallbacks(this.h);
    if (this.f != null)
      this.f.a();
  }

  public void onRemoteBannerVisibilityChange(boolean paramBoolean, com.viber.voip.banner.d.c paramc, com.viber.voip.banner.view.b paramb)
  {
    super.onRemoteBannerVisibilityChange(paramBoolean, paramc, paramb);
    ((com.viber.voip.messages.conversation.ui.view.a.a.d)this.aK).onRemoteBannerVisibilityChange(paramBoolean, paramc, paramb);
  }

  public void onResume()
  {
    super.onResume();
    c();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putLong("cdr_session_token", this.e);
  }

  protected GeneralConversationPresenter p()
  {
    if (this.aM == null)
      this.aM = new GeneralPublicGroupConversationPresenter(this.aN, this.aZ, this.aX, this.aY, this.bb, cj.a(getContext()), ViberApplication.getInstance().getMediaMountManager(), this.bc, this.ba, ((com.viber.voip.messages.k)aj().get()).d(), this.Z, this.w, this.mIsTablet, com.viber.voip.h.a.b(), this.aQ, this.aS, this.q, this.R, av.a(av.e.g), this.aE, new cq(getContext()), this.I, ((com.viber.voip.messages.k)this.W.get()).h(), this.ae);
    return this.aM;
  }

  public void q()
  {
    super.q();
    this.s = ((com.viber.voip.messages.conversation.k)this.az.g());
  }

  public PublicGroupConversationItemLoaderEntity r()
  {
    if (this.az == null)
      return null;
    return (PublicGroupConversationItemLoaderEntity)this.az.j();
  }

  protected boolean s()
  {
    PublicGroupConversationItemLoaderEntity localPublicGroupConversationItemLoaderEntity = r();
    return (localPublicGroupConversationItemLoaderEntity != null) && (localPublicGroupConversationItemLoaderEntity.isPendingRole());
  }

  protected j t()
  {
    if (this.d == null)
      this.d = new j();
    return this.d;
  }

  protected void u()
  {
    PublicGroupConversationItemLoaderEntity localPublicGroupConversationItemLoaderEntity = r();
    if (localPublicGroupConversationItemLoaderEntity != null)
    {
      this.I.a(localPublicGroupConversationItemLoaderEntity.getPublicAccountId(), "Chat Menu", 2);
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse(com.viber.voip.api.scheme.i.a(localPublicGroupConversationItemLoaderEntity.getPublicAccountId()))));
    }
  }

  protected void v()
  {
    PublicGroupConversationItemLoaderEntity localPublicGroupConversationItemLoaderEntity = r();
    if (localPublicGroupConversationItemLoaderEntity != null)
      ViberActionRunner.aq.a(getActivity(), localPublicGroupConversationItemLoaderEntity.getPublicAccountId());
  }

  protected void w()
  {
    PublicGroupConversationItemLoaderEntity localPublicGroupConversationItemLoaderEntity = r();
    FragmentActivity localFragmentActivity = getActivity();
    if ((localPublicGroupConversationItemLoaderEntity != null) && (localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
      ViberActionRunner.a(localFragmentActivity, localPublicGroupConversationItemLoaderEntity.getGroupId(), localPublicGroupConversationItemLoaderEntity.getPublicAccountGroupUri());
  }

  public boolean x()
  {
    return this.mRemoteBannerDisplayController.a(com.viber.voip.banner.d.c.b);
  }

  private static class a extends com.viber.voip.d.b<PublicGroupConversationFragment>
  {
    private a(PublicGroupConversationFragment paramPublicGroupConversationFragment)
    {
      super();
    }

    public void a(PublicGroupConversationFragment paramPublicGroupConversationFragment)
    {
      PublicGroupConversationFragment.a(paramPublicGroupConversationFragment, false);
      PublicGroupConversationFragment.b(paramPublicGroupConversationFragment);
    }
  }

  private static final class b
    implements Comparable<b>
  {
    public final PublicAccountImpression a;
    private boolean b;
    private long c;

    public b(long paramLong, PublicAccountImpression paramPublicAccountImpression)
    {
      this.c = paramLong;
      this.a = paramPublicAccountImpression;
    }

    private static int a(long paramLong1, long paramLong2)
    {
      if (paramLong1 < paramLong2)
        return -1;
      if (paramLong1 == paramLong2)
        return 0;
      return 1;
    }

    public int a(b paramb)
    {
      int i = a(this.c, paramb.c);
      if (i != 0)
        return i;
      return a(this.a.messageSequence, paramb.a.messageSequence);
    }

    public boolean a()
    {
      return this.b;
    }

    public boolean a(long paramLong)
    {
      if ((this.c != 0L) && (paramLong - this.c > 1000L));
      for (boolean bool = true; ; bool = false)
      {
        this.b = bool;
        return bool;
      }
    }

    public void b(long paramLong)
    {
      this.c = paramLong;
      this.b = false;
    }

    public boolean b()
    {
      return this.c != 0L;
    }

    public void c()
    {
      this.b = false;
      this.c = 0L;
    }
  }

  private static class c
    implements AbsListView.OnScrollListener
  {
    private Rect a;
    private final long b;
    private PublicGroupConversationItemLoaderEntity c;
    private final com.viber.voip.messages.conversation.adapter.k d;
    private final LongSparseArray<PublicGroupConversationFragment.b> e = new LongSparseArray();

    public c(long paramLong, com.viber.voip.messages.conversation.adapter.k paramk)
    {
      this.b = paramLong;
      this.d = paramk;
    }

    private void a(long paramLong, aa paramaa)
    {
      long l = paramaa.a();
      PublicGroupConversationFragment.b localb = (PublicGroupConversationFragment.b)this.e.get(l);
      if ((localb != null) && (localb.b()) && (!localb.a(paramLong)))
        localb.c();
    }

    private void a(long paramLong, PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity, aa paramaa)
    {
      long l = paramaa.a();
      PublicGroupConversationFragment.b localb1 = (PublicGroupConversationFragment.b)this.e.get(l);
      if (localb1 == null)
      {
        PublicGroupConversationFragment.b localb2 = new PublicGroupConversationFragment.b(paramLong, PublicAccountImpression.create(this.b, paramPublicGroupConversationItemLoaderEntity, paramaa));
        this.e.put(l, localb2);
      }
      do
      {
        return;
        if (!localb1.b())
        {
          localb1.b(paramLong);
          return;
        }
      }
      while (localb1.a());
      localb1.a(paramLong);
    }

    private boolean a(aa paramaa)
    {
      return (paramaa != null) && ((paramaa.aY()) || (paramaa.aX()) || (paramaa.aH()) || (paramaa.ax()) || (paramaa.aL()) || (paramaa.aM()) || (paramaa.aF()) || (paramaa.aG()) || (paramaa.aD()));
    }

    private long d()
    {
      return SystemClock.elapsedRealtime();
    }

    public void a()
    {
      long l = d();
      for (int i = -1 + this.e.size(); i >= 0; i--)
      {
        PublicGroupConversationFragment.b localb = (PublicGroupConversationFragment.b)this.e.valueAt(i);
        if ((localb != null) && (!localb.a(l)))
          this.e.removeAt(i);
      }
    }

    public void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
    {
      this.c = paramPublicGroupConversationItemLoaderEntity;
    }

    public ArrayList<PublicGroupConversationFragment.b> b()
    {
      int i = this.e.size();
      ArrayList localArrayList = new ArrayList(i);
      for (int j = 0; j < i; j++)
      {
        PublicGroupConversationFragment.b localb = (PublicGroupConversationFragment.b)this.e.valueAt(j);
        if ((localb != null) && (localb.a()))
          localArrayList.add(this.e.valueAt(j));
      }
      return localArrayList;
    }

    public void c()
    {
      this.e.clear();
    }

    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      PublicGroupConversationItemLoaderEntity localPublicGroupConversationItemLoaderEntity = this.c;
      if (localPublicGroupConversationItemLoaderEntity == null)
        return;
      if (this.a == null)
      {
        this.a = new Rect();
        paramAbsListView.getDrawingRect(this.a);
      }
      long l = d();
      int i = paramAbsListView.getChildCount();
      int j = 0;
      label53: aa localaa;
      if (j < i)
      {
        View localView = paramAbsListView.getChildAt(j);
        if (localView != null)
        {
          Object localObject = this.d.getItem(paramInt1 + j);
          if ((localObject instanceof com.viber.voip.messages.conversation.adapter.a.a))
          {
            localaa = ((com.viber.voip.messages.conversation.adapter.a.a)localObject).c();
            if (a(localaa))
            {
              float f = localView.getY();
              if ((f < this.a.top) || (f + localView.getHeight() > this.a.bottom))
                break label173;
              a(l, localPublicGroupConversationItemLoaderEntity, localaa);
            }
          }
        }
      }
      while (true)
      {
        j++;
        break label53;
        break;
        label173: a(l, localaa);
      }
    }

    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
    }
  }

  private static class d
    implements Runnable
  {
    private final ICdrController a;
    private final ArrayList<PublicGroupConversationFragment.b> b;

    public d(ICdrController paramICdrController, ArrayList<PublicGroupConversationFragment.b> paramArrayList)
    {
      this.a = paramICdrController;
      this.b = paramArrayList;
    }

    public void run()
    {
      Collections.sort(this.b);
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        PublicAccountImpression localPublicAccountImpression = ((PublicGroupConversationFragment.b)localIterator.next()).a;
        this.a.handleReportPAImpressions(localPublicAccountImpression.publicAccountId, localPublicAccountImpression.publicAccountCountryCode, localPublicAccountImpression.publicChatSessionToken, localPublicAccountImpression.messageMediaType, localPublicAccountImpression.messageUrl, localPublicAccountImpression.isGifMessage, localPublicAccountImpression.messageStickerNumber, localPublicAccountImpression.messageToken, localPublicAccountImpression.messageSequence, localPublicAccountImpression.publicAccountUserRole);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationFragment
 * JD-Core Version:    0.6.2
 */