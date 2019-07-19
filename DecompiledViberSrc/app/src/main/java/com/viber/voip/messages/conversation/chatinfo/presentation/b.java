package com.viber.voip.messages.conversation.chatinfo.presentation;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m.c;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.OnlineContactInfo;
import com.viber.jni.PeerTrustState.PeerTrustEnum;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.secure.TrustPeerDelegate.MessagesDelegate;
import com.viber.jni.secure.TrustPeerMessagesListener;
import com.viber.voip.R.id;
import com.viber.voip.R.integer;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.o;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.block.g.a;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.contacts.ui.list.as;
import com.viber.voip.contacts.ui.list.s;
import com.viber.voip.contacts.ui.list.t;
import com.viber.voip.contacts.ui.list.u;
import com.viber.voip.contacts.ui.list.y;
import com.viber.voip.i.c.f;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.d;
import com.viber.voip.messages.controller.bv.t;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ac;
import com.viber.voip.messages.conversation.ui.b.q;
import com.viber.voip.messages.conversation.ui.bm;
import com.viber.voip.messages.conversation.ui.presenter.DeleteConversationRelatedActionsPresenter;
import com.viber.voip.permissions.n;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.registration.af;
import com.viber.voip.registration.ao;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.aa;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.r;
import com.viber.voip.user.OnlineUserActivityHelper;
import com.viber.voip.util.ViberActionRunner.af;
import com.viber.voip.util.ViberActionRunner.bt;
import com.viber.voip.util.ViberActionRunner.d;
import com.viber.voip.util.ViberActionRunner.e;
import com.viber.voip.util.cd;
import com.viber.voip.util.cj;
import com.viber.voip.util.cn;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;

public abstract class b extends com.viber.voip.mvp.core.g<com.viber.voip.mvp.core.d>
  implements m.c, TrustPeerDelegate.MessagesDelegate, com.viber.provider.d.a, com.viber.voip.contacts.ui.list.w, ae, com.viber.voip.messages.conversation.chatinfo.presentation.b.j
{
  private static final Logger H = ViberEnv.getLogger();
  protected DeleteConversationRelatedActionsPresenter A;
  protected ProgressBar B;
  protected boolean C;
  protected boolean D;
  protected int E = 3;
  protected int F = 1;
  protected ConversationItemLoaderEntity G;
  private LocationManager I;
  private com.viber.voip.contacts.ui.list.x J;
  private boolean K;
  private boolean L;
  private boolean M;
  private Intent N;
  private final com.viber.common.permission.b O;
  private bv.d P;
  private bv.t Q;

  @Inject
  com.viber.voip.app.b a;

  @Inject
  protected com.viber.voip.messages.k b;

  @Inject
  protected com.viber.voip.analytics.g c;

  @Inject
  protected com.viber.common.permission.c d;

  @Inject
  dagger.a<bv> e;

  @Inject
  Engine f;

  @Inject
  EventBus g;

  @Inject
  Handler h;

  @Inject
  protected com.viber.voip.contacts.c.d.m i;

  @Inject
  protected dagger.a<ConferenceCallsRepository> j;

  @Inject
  dagger.a<com.viber.voip.analytics.story.b.a.h> k;

  @Inject
  com.viber.voip.messages.conversation.chatinfo.b.a l;

  @Inject
  protected com.viber.voip.analytics.story.e.c m;

  @Inject
  protected com.viber.voip.util.e.e n;

  @Inject
  protected com.viber.voip.util.e.g o;

  @Inject
  protected dagger.a<GroupController> p;

  @Inject
  protected dagger.a<com.viber.voip.messages.controller.a> q;

  @Inject
  af r;

  @Inject
  PhoneController s;

  @Inject
  CallHandler t;

  @Inject
  OnlineUserActivityHelper u;

  @Inject
  protected q v;
  protected com.viber.voip.messages.conversation.chatinfo.e.e w;
  protected ac x;
  protected w y;
  protected t z;

  public b()
  {
    Pair[] arrayOfPair = new Pair[2];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(66);
    arrayOfPair[1] = com.viber.voip.permissions.m.a(62);
    this.O = new com.viber.voip.permissions.e(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 62:
          b.this.z.g();
          return;
        case 66:
        }
        b.a(b.this);
      }
    };
    this.P = new bv.d()
    {
      public void onChange(Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        if ((paramAnonymousBoolean1) && (paramAnonymousSet != null) && (paramAnonymousSet.contains(Long.valueOf(b.this.x.s()))))
          b.a(b.this, new h(this));
      }
    };
    this.Q = new bv.t()
    {
      public void onGroupIconChanged(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2)
      {
        b.this.a(false);
        b.d(b.this, new k(this, paramAnonymousInt2));
      }

      public void onGroupInfoUpdateStarted(int paramAnonymousInt)
      {
        b.this.a(true);
      }

      public void onGroupRenamed(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2)
      {
        b.this.a(false);
        b.b(b.this, new i(this, paramAnonymousInt2));
      }

      public void onGroupUnknownChanged(long paramAnonymousLong, int paramAnonymousInt)
      {
        b.this.a(false);
        b.c(b.this, new j(this, paramAnonymousInt));
      }

      public void onPublicGroupInfoChanged(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        b.this.a(false);
        b.e(b.this, new l(this, paramAnonymousInt3, paramAnonymousInt2));
      }
    };
  }

  private void N()
  {
    if ((this.M) && (this.I != null) && (!this.I.isProviderEnabled("network")))
      this.M = false;
    c(this.M);
  }

  private void O()
  {
    if (this.N == null)
      return;
    a(this.N);
    this.N = null;
  }

  private void P()
  {
    if (this.d.a(n.l))
    {
      Q();
      return;
    }
    this.d.a(this, 66, n.l);
  }

  private void Q()
  {
    if ((this.I != null) && (this.I.isProviderEnabled("network")))
    {
      c(true);
      return;
    }
    com.viber.voip.ui.dialogs.m.a().a(new ViberDialogHandlers.aa()).b(this);
  }

  private void a(Intent paramIntent)
  {
    long l1 = paramIntent.getLongExtra("group_id", 0L);
    ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("selected_admins");
    if (localArrayList != null)
    {
      String[] arrayOfString = new String[localArrayList.size()];
      int i1 = localArrayList.size();
      for (int i2 = 0; i2 < i1; i2++)
        arrayOfString[i2] = ((ParticipantSelector.Participant)localArrayList.get(i2)).getMemberId();
      if (this.y != null)
        this.y.a(l1, arrayOfString);
    }
  }

  private void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, g.a parama)
  {
    if (getActivity() != null)
    {
      if (!paramConversationItemLoaderEntity.isGroupBehavior())
        com.viber.voip.block.g.a(getActivity(), Member.from(paramConversationItemLoaderEntity), parama);
    }
    else
      return;
    parama.a(null);
  }

  private void k(boolean paramBoolean)
  {
    this.C = paramBoolean;
    this.y.b(paramBoolean);
  }

  private void l(boolean paramBoolean)
  {
    this.D = paramBoolean;
    this.y.c(paramBoolean);
  }

  public void A()
  {
    ViberActionRunner.af.a(getActivity(), this.G, "Chat Info", this.G.isCommunityType());
  }

  public void B()
  {
    ad.a().b(this);
  }

  public void C()
  {
    com.viber.voip.ui.dialogs.l.g().b(this);
  }

  public void D()
  {
    com.viber.voip.ui.dialogs.k.n().b(this);
  }

  public void E()
  {
    com.viber.voip.ui.dialogs.l.p().b(this);
  }

  public void E_()
  {
    this.J.E_();
  }

  public void F_()
  {
    this.J.F_();
  }

  public void H()
  {
    com.viber.voip.messages.conversation.chatinfo.presentation.b.k.a(this);
  }

  public void I()
  {
    com.viber.voip.messages.conversation.chatinfo.presentation.b.k.b(this);
  }

  public void J()
  {
    com.viber.voip.messages.conversation.chatinfo.presentation.b.k.c(this);
  }

  public void K()
  {
    com.viber.voip.messages.conversation.chatinfo.presentation.b.k.d(this);
  }

  public void L()
  {
    com.viber.voip.messages.conversation.chatinfo.presentation.b.k.e(this);
  }

  public void M()
  {
    com.viber.voip.messages.conversation.chatinfo.presentation.b.k.f(this);
  }

  public void X_()
  {
    this.J.X_();
  }

  public void a()
  {
    this.J.a();
  }

  public void a(int paramInt)
  {
    com.viber.voip.messages.conversation.chatinfo.presentation.b.k.a(this, paramInt);
  }

  public void a(int paramInt, String paramString)
  {
    if (!m())
      return;
    this.y.a(paramInt, paramString);
  }

  protected void a(Uri paramUri)
  {
  }

  public void a(s params)
  {
    this.J.a(params);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.J.a(paramConversationItemLoaderEntity);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt)
  {
    ViberActionRunner.d.a(this, paramConversationItemLoaderEntity, paramInt);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt1, int paramInt2)
  {
    ViberActionRunner.d.a(this, paramConversationItemLoaderEntity, paramInt1, paramInt2);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt1, int paramInt2, String paramString)
  {
    if (!ViberActionRunner.d.a(this, paramConversationItemLoaderEntity.getConversationType(), paramInt1))
      return;
    a(paramConversationItemLoaderEntity, new f(this, paramConversationItemLoaderEntity, paramInt1, paramInt2, paramString));
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt, String paramString)
  {
    a(paramConversationItemLoaderEntity, new g(this, paramConversationItemLoaderEntity, paramInt, paramString));
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, com.viber.voip.model.h paramh)
  {
    this.J.a(paramConversationItemLoaderEntity, paramh);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    this.y.a(paramConversationItemLoaderEntity, paramBoolean);
    this.z.a(paramConversationItemLoaderEntity);
    this.A.a(paramConversationItemLoaderEntity);
    int i1 = this.E;
    this.G = paramConversationItemLoaderEntity;
    this.E = paramConversationItemLoaderEntity.getGroupRole();
    this.F = paramConversationItemLoaderEntity.getConversationType();
    this.M = paramConversationItemLoaderEntity.isShareLocation();
    if (i1 != this.E);
    for (boolean bool = true; ; bool = false)
    {
      b(bool);
      N();
      return;
    }
  }

  protected void a(ac paramac, boolean paramBoolean)
  {
    if (this.G != null)
      d(this.G);
  }

  public void a(com.viber.voip.messages.conversation.ae paramae)
  {
    this.z.a(paramae);
  }

  public void a(com.viber.voip.messages.conversation.chatinfo.c.a<com.viber.voip.messages.conversation.chatinfo.d.d> parama)
  {
  }

  public void a(com.viber.voip.model.h paramh)
  {
    this.J.a(paramh);
  }

  public void a(com.viber.voip.model.h paramh, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.J.a(paramh, paramBoolean1, paramBoolean2);
  }

  public void a(com.viber.voip.model.h paramh, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.J.a(paramh, paramBoolean1, paramBoolean2, paramBoolean3);
  }

  public void a(String paramString, Uri paramUri, boolean paramBoolean)
  {
    this.J.a(paramString, paramUri, paramBoolean);
  }

  public void a(Map<String, OnlineContactInfo> paramMap)
  {
    if (getActivity() != null)
      o().a(paramMap);
  }

  public final void a(boolean paramBoolean)
  {
    runOnUiThread(new e(this, paramBoolean));
  }

  protected final boolean a(String paramString, boolean paramBoolean)
  {
    if (this.f.getPhoneController().isConnected())
    {
      this.b.h().a(paramString, paramBoolean);
      return true;
    }
    com.viber.voip.ui.dialogs.f.d().d();
    return false;
  }

  public void b(long paramLong)
  {
    com.viber.voip.messages.conversation.chatinfo.presentation.b.k.a(this, paramLong);
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.J.b(paramConversationItemLoaderEntity);
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, com.viber.voip.model.h paramh)
  {
    this.J.b(paramConversationItemLoaderEntity, paramh);
  }

  public void b(String paramString)
  {
    com.viber.voip.messages.conversation.chatinfo.presentation.b.k.a(this, paramString);
  }

  public void b(Map<String, PeerTrustState.PeerTrustEnum> paramMap)
  {
    if (getActivity() != null)
      o().b(paramMap);
  }

  protected void b(boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2;
    if ((!this.x.a(this.G.getId())) || (paramBoolean))
    {
      bool2 = bool1;
      if (bool2)
      {
        this.K = bool1;
        this.L = bool1;
        k(false);
        l(false);
        t();
        if (this.G.isCommunityType())
          break label115;
        ac localac = this.x;
        if (3 != this.E)
          break label110;
        label77: localac.a(bool1);
      }
    }
    while (true)
    {
      this.x.b(this.G.getId());
      this.x.i();
      return;
      bool2 = false;
      break;
      label110: bool1 = false;
      break label77;
      label115: this.x.r();
    }
  }

  public void c()
  {
    this.J.c();
  }

  public void c(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.J.c(paramConversationItemLoaderEntity);
  }

  public void c(ConversationItemLoaderEntity paramConversationItemLoaderEntity, com.viber.voip.model.h paramh)
  {
    this.J.c(paramConversationItemLoaderEntity, paramh);
  }

  public void c(String paramString)
  {
    com.viber.voip.messages.conversation.chatinfo.presentation.b.k.b(this, paramString);
  }

  protected void c(boolean paramBoolean)
  {
    if (this.M != paramBoolean)
    {
      this.M = paramBoolean;
      if (this.G != null)
        this.b.c().b(this.G.getId(), this.M);
    }
  }

  protected void createViewPresenters(View paramView, Bundle paramBundle)
  {
    this.A = new DeleteConversationRelatedActionsPresenter(this.v, this.b.c(), this.m);
    addMvpView(new com.viber.voip.messages.conversation.ui.view.b.i(this.A, this, paramView), this.A, paramBundle);
  }

  public void d()
  {
    this.J.d();
  }

  protected void d(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.y.a(paramConversationItemLoaderEntity, false);
  }

  public void d(boolean paramBoolean)
  {
    this.J.a(paramBoolean);
  }

  public void d_(String paramString)
  {
    this.J.d_(paramString);
  }

  public void e()
  {
    this.J.e();
  }

  public void e(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    ViberActionRunner.e.a(this, 10, paramConversationItemLoaderEntity.getId(), paramConversationItemLoaderEntity.getGroupId(), paramConversationItemLoaderEntity.isSecret(), paramConversationItemLoaderEntity.getConversationType());
  }

  public void f()
  {
    this.J.f();
  }

  public void f(boolean paramBoolean)
  {
    com.viber.voip.messages.conversation.chatinfo.presentation.b.k.a(this, paramBoolean);
  }

  public void g()
  {
    this.J.g();
  }

  public void g(boolean paramBoolean)
  {
    com.viber.voip.messages.conversation.chatinfo.presentation.b.k.b(this, paramBoolean);
  }

  public void h()
  {
    this.J.h();
  }

  public void h(boolean paramBoolean)
  {
    com.viber.voip.messages.conversation.chatinfo.presentation.b.k.c(this, paramBoolean);
  }

  public void i(boolean paramBoolean)
  {
    com.viber.voip.messages.conversation.chatinfo.presentation.b.k.d(this, paramBoolean);
  }

  protected void initModelComponent(View paramView, Bundle paramBundle)
  {
  }

  public void j(boolean paramBoolean)
  {
    com.viber.voip.messages.conversation.chatinfo.presentation.b.k.e(this, paramBoolean);
  }

  public void k()
  {
    this.J.k();
  }

  protected boolean l()
  {
    return (this.G != null) && (cd.d(this.G.getGroupRole(), this.G.getConversationType()));
  }

  protected boolean m()
  {
    return as.c(this.G);
  }

  protected boolean n()
  {
    return as.d(this.G);
  }

  protected abstract com.viber.voip.messages.conversation.chatinfo.presentation.a.b o();

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    ((bv)this.e.get()).a(this.Q);
    ((bv)this.e.get()).a(this.P);
    this.x.p();
    this.f.getDelegatesManager().getTrustPeerMessagesListener().registerDelegate(this, this.h);
    O();
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10) && (paramInt2 == -1) && (paramIntent != null))
    {
      if (this.y == null)
        this.N = paramIntent;
    }
    else
      return;
    a(paramIntent);
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
    this.I = ((LocationManager)paramContext.getSystemService("location"));
    Engine localEngine = this.f;
    com.viber.voip.messages.conversation.chatinfo.e.d locald = new com.viber.voip.messages.conversation.chatinfo.e.d.a().a(3).b(1).a(getString(R.string.conversation_you)).b(getString(R.string.conversation_info_your_list_item)).a();
    this.w = new com.viber.voip.messages.conversation.chatinfo.e.e(new com.viber.voip.messages.conversation.chatinfo.e.c(paramContext), new com.viber.voip.messages.conversation.chatinfo.e.a(paramContext, this.n, this.o, com.viber.voip.util.links.f.b()), locald);
    com.viber.voip.invitelinks.f localf = new com.viber.voip.invitelinks.f(this.b.u(), cj.a(paramContext));
    com.viber.voip.publicaccount.ui.holders.recentmedia.b localb = new com.viber.voip.publicaccount.ui.holders.recentmedia.b(paramContext, getLoaderManager(), new c(this), this, this.g);
    this.x = new ac(paramContext, true, true, getLoaderManager(), new d(this), this, this.g);
    com.viber.voip.messages.conversation.i locali = new com.viber.voip.messages.conversation.i(paramContext, getLoaderManager(), this.e);
    com.viber.voip.messages.conversation.b localb1 = new com.viber.voip.messages.conversation.b(paramContext, getLoaderManager(), this.e);
    this.y = new x(this, this.b, this.u, localf, new com.viber.voip.invitelinks.linkscreen.f((Activity)paramContext, this.c, "Chat Info"), localEngine, this.h, av.a(av.e.f), this.l, localb, this.w, this.c.c().g(), getResources(), localb, p(), this.x, locali, localb1, this.mIsTablet, ao.f());
    this.z = new u(localEngine.getExchanger(), this, this.p, this.q, this.r, this.t, this.e, new cn(getResources()), this.s, this.h, null, this.m, this.k, com.viber.voip.h.a.b(), c.f.d, "Participants List", this.a.a(getContext()));
    bm localbm = new bm(paramContext, ViberApplication.getInstance().getChangePhoneNumberController().b(), this.i);
    this.J = new y(this, this.mIsTablet, this.z, this.d, localbm, this.F);
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    if (this.J.a(paramMenuItem))
      return true;
    return super.onContextItemSelected(paramMenuItem);
  }

  public void onContextMenuClosed(Menu paramMenu)
  {
    super.onContextMenuClosed(paramMenu);
    this.J.a(paramMenu);
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    this.J.a(paramContextMenu);
    this.z.d();
  }

  public void onDestroyView()
  {
    this.y.j();
    this.y = null;
    this.z.c();
    this.z = null;
    this.J.l();
    this.J = null;
    ((bv)this.e.get()).b(this.Q);
    ((bv)this.e.get()).b(this.P);
    this.x.q();
    this.f.getDelegatesManager().getTrustPeerMessagesListener().removeDelegate(this);
    super.onDestroyView();
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if (!this.J.a(paramm, paramInt))
    {
      if (!paramm.a(DialogCode.D1012a))
        break label39;
      if (paramInt == -1)
        this.y.i();
    }
    return;
    label39: super.onDialogAction(paramm, paramInt);
  }

  @SuppressLint({"MissingSuperCall"})
  public void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    this.z.a(paramBoolean);
    if (paramBoolean)
    {
      if ((this.E != 3) && (this.K))
      {
        this.K = false;
        this.y.g();
      }
      if (this.L)
      {
        this.L = false;
        this.y.h();
      }
    }
  }

  public void onLoadFinished(com.viber.provider.d paramd, boolean paramBoolean)
  {
    if ((paramd != this.x) || (!isAdded()));
    do
    {
      return;
      a(this.x, paramBoolean);
    }
    while (!this.mIsTablet);
    this.y.g();
    this.y.h();
  }

  public void onLoaderReset(com.viber.provider.d paramd)
  {
  }

  public void onStart()
  {
    super.onStart();
    this.d.a(this.O);
    this.z.a();
  }

  public void onStop()
  {
    super.onStop();
    this.d.b(this.O);
    this.z.b();
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.B = ((ProgressBar)paramView.findViewById(R.id.progress_bar));
  }

  protected int p()
  {
    return getResources().getInteger(R.integer.group_displayed_participants_limit);
  }

  public com.viber.common.permission.c q()
  {
    return this.d;
  }

  public Fragment r()
  {
    return this;
  }

  public ConversationItemLoaderEntity s()
  {
    return this.G;
  }

  protected abstract void t();

  public void u()
  {
    if (!l())
      return;
    this.y.e();
  }

  public void v()
  {
    l(true);
    a(this.x, false);
  }

  public void w()
  {
    k(true);
    a(this.x, false);
  }

  public void x()
  {
    if (this.G != null)
    {
      if (!this.M)
        P();
    }
    else
      return;
    c(false);
  }

  public void y()
  {
    if (getActivity() != null)
      ViberActionRunner.bt.d(getActivity());
  }

  public void z()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
      r.j().a(localFragmentActivity);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.b
 * JD-Core Version:    0.6.2
 */