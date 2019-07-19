package com.viber.voip.messages.conversation.community;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.jni.Engine;
import com.viber.jni.cdr.entity.PublicAccountInteraction;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.ConversationListView;
import com.viber.voip.ViberApplication;
import com.viber.voip.analytics.g;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.contacts.ui.list.w;
import com.viber.voip.contacts.ui.list.y;
import com.viber.voip.i.c.f;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationFragment;
import com.viber.voip.messages.conversation.ui.ConversationFragment.a;
import com.viber.voip.messages.conversation.ui.SpamController;
import com.viber.voip.messages.conversation.ui.a.v;
import com.viber.voip.messages.conversation.ui.aq;
import com.viber.voip.messages.conversation.ui.b.aj;
import com.viber.voip.messages.conversation.ui.b.n;
import com.viber.voip.messages.conversation.ui.b.z;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView;
import com.viber.voip.messages.conversation.ui.bm;
import com.viber.voip.messages.conversation.ui.bp;
import com.viber.voip.messages.conversation.ui.j;
import com.viber.voip.messages.conversation.ui.presenter.CommunityMessagesActionsPresenter;
import com.viber.voip.messages.conversation.ui.presenter.DeleteConversationRelatedActionsPresenter;
import com.viber.voip.messages.conversation.ui.presenter.GeneralConversationPresenter;
import com.viber.voip.messages.conversation.ui.presenter.GeneralPublicGroupConversationPresenter;
import com.viber.voip.messages.conversation.ui.presenter.MessagesActionsPresenter;
import com.viber.voip.messages.conversation.ui.presenter.SearchMessagesOptionMenuPresenter;
import com.viber.voip.messages.conversation.ui.presenter.banners.top.CommunityTopBannerPresenter;
import com.viber.voip.messages.conversation.ui.view.e;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.registration.af;
import com.viber.voip.registration.ao;
import com.viber.voip.registration.changephonenumber.d.a;
import com.viber.voip.report.community.CommunityReportPresenter;
import com.viber.voip.settings.d.r;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.cj;
import com.viber.voip.util.cn;
import com.viber.voip.util.cq;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;

public class CommunityConversationFragment extends PublicGroupConversationFragment
  implements w
{

  @Inject
  ai a;

  @Inject
  af b;
  private CommunityConversationMvpPresenter bj;
  private com.viber.voip.contacts.ui.list.t bk;
  private com.viber.voip.contacts.ui.list.x bl;
  private DeleteConversationRelatedActionsPresenter bm;
  private final com.viber.common.permission.b bn;

  @Inject
  cj c;

  @Inject
  com.viber.voip.analytics.story.b.c d;

  @Inject
  com.viber.voip.app.b e;

  @Inject
  com.viber.voip.messages.conversation.community.b.a f;

  @Inject
  com.viber.voip.report.a.a.a g;

  @Inject
  com.viber.voip.report.community.a h;

  @Inject
  com.viber.voip.messages.conversation.ui.b.q i;

  @Inject
  com.viber.voip.invitelinks.d j;

  @Inject
  dagger.a<com.viber.voip.messages.k> k;

  @Inject
  dagger.a<GroupController> l;

  @Inject
  dagger.a<bv> m;

  @Inject
  dagger.a<com.viber.voip.analytics.story.b.a.h> n;

  @Inject
  com.viber.voip.contacts.c.d.m o;

  @Inject
  Im2Exchanger p;

  public CommunityConversationFragment()
  {
    FragmentActivity localFragmentActivity = getActivity();
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(62);
    this.bn = new com.viber.voip.permissions.f(localFragmentActivity, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 62:
        }
        CommunityConversationFragment.a(CommunityConversationFragment.this).g();
      }
    };
  }

  public void E_()
  {
    this.bl.E_();
  }

  public void F_()
  {
    this.bl.F_();
  }

  public void X_()
  {
    this.bl.X_();
  }

  public PublicAccountInteraction a(aa paramaa, String paramString)
  {
    return null;
  }

  protected com.viber.voip.messages.conversation.s a(Context paramContext, LoaderManager paramLoaderManager, dagger.a<com.viber.voip.messages.k> parama, EventBus paramEventBus, Bundle paramBundle)
  {
    return new com.viber.voip.messages.conversation.s(paramContext, paramLoaderManager, parama, this.aZ, this.ba, this.bb, this.bc, paramEventBus, 5, paramBundle);
  }

  protected MessagesActionsPresenter a(SpamController paramSpamController, com.viber.voip.messages.conversation.ui.b.f paramf, com.viber.voip.messages.conversation.ui.b.ac paramac, com.viber.voip.messages.conversation.ui.b.i parami, ai paramai, com.viber.common.permission.c paramc, j paramj, Engine paramEngine, af paramaf, Handler paramHandler1, Handler paramHandler2, Handler paramHandler3, g paramg, IRingtonePlayer paramIRingtonePlayer, com.viber.voip.messages.controller.publicaccount.d paramd, com.viber.voip.messages.conversation.ui.b.a parama, com.viber.voip.messages.d.b paramb, o paramo, Handler paramHandler4, bm parambm, com.viber.voip.messages.conversation.ui.b.x paramx, aj paramaj, com.viber.voip.stickers.b paramb1, com.viber.voip.stickers.i parami1, com.viber.voip.stickers.a.a parama1, n paramn, com.viber.voip.messages.conversation.ui.b.u paramu, ActivationController paramActivationController, z paramz, com.viber.voip.messages.extensions.c paramc1, dagger.a<com.viber.voip.invitelinks.q> parama2)
  {
    return new CommunityMessagesActionsPresenter(paramSpamController, paramf, paramac, parami, paramai, paramc, paramj, paramEngine, paramaf, paramHandler1, paramHandler3, paramHandler2, paramg, paramIRingtonePlayer, paramd, parama, this.x, paramb, this.mIsTablet, paramo, paramHandler4, parambm, paramx, paramaj, paramb1, parami1, parama1, paramn, paramu, paramActivationController, paramz, d.r.D, paramc1, parama2);
  }

  protected com.viber.voip.messages.conversation.ui.view.a.c.f a(View paramView, ConversationAlertView paramConversationAlertView, SwipeRefreshLayout paramSwipeRefreshLayout, Bundle paramBundle)
  {
    Application localApplication = ViberApplication.getApplication();
    CommunityTopBannerPresenter localCommunityTopBannerPresenter = new CommunityTopBannerPresenter(this.aZ, this.ba, this.bb, this.aX, this.bc, this.az, this.at, o.a(), this.aE, cj.a(localApplication), this.S, com.viber.voip.contacts.c.c.a.b.a(), com.viber.voip.block.b.a(), ((com.viber.voip.messages.k)aj().get()).c(), this.aR, this.aq, this.H, this.d, this.be, this.bf, this.aP, this.bg, this.ae, this.aS, UserManager.from(getContext()), this.Z);
    this.bh.a(localCommunityTopBannerPresenter);
    com.viber.voip.messages.conversation.ui.view.a.c.b localb = new com.viber.voip.messages.conversation.ui.view.a.c.b(localCommunityTopBannerPresenter, getActivity(), this, paramView, this.mIsTablet, ao.f(), this.aw, paramConversationAlertView, paramSwipeRefreshLayout, this.at, com.viber.voip.messages.conversation.publicaccount.k.a(), new bp(ag(), this.an, getLayoutInflater()), this.av, this.G, this.I, this.J, this.N, this.aE);
    addMvpView(localb, localCommunityTopBannerPresenter, paramBundle);
    this.aH = localCommunityTopBannerPresenter;
    return localb;
  }

  public void a()
  {
    this.bl.a();
  }

  protected void a(View paramView, Bundle paramBundle)
  {
    SearchMessagesOptionMenuPresenter localSearchMessagesOptionMenuPresenter = new SearchMessagesOptionMenuPresenter(this.aX, this.bb, this.aZ, this.k, this.I, this.al, this.mIsTablet);
    com.viber.voip.messages.conversation.ui.view.b.t localt = new com.viber.voip.messages.conversation.ui.view.b.t(localSearchMessagesOptionMenuPresenter, getActivity(), this, paramView, this, this.mIsTablet);
    this.bh.a(localt);
    addMvpView(localt, localSearchMessagesOptionMenuPresenter, paramBundle);
  }

  public void a(com.viber.voip.contacts.ui.list.s params)
  {
    this.bl.a(params);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.bl.a(paramConversationItemLoaderEntity);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, com.viber.voip.model.h paramh)
  {
    this.bl.a(paramConversationItemLoaderEntity, paramh);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    if (paramConversationItemLoaderEntity == null)
    {
      b(ah().r());
      return;
    }
    this.bk.a(paramConversationItemLoaderEntity);
    super.a(paramConversationItemLoaderEntity, paramBoolean);
    if (!paramBoolean)
    {
      TextView localTextView = this.aD.o();
      this.as.b(localTextView);
    }
    this.bm.a(paramConversationItemLoaderEntity);
  }

  public void a(com.viber.voip.messages.conversation.ac paramac, boolean paramBoolean)
  {
  }

  public void a(com.viber.voip.model.h paramh)
  {
    this.bl.a(paramh);
  }

  public void a(com.viber.voip.model.h paramh, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.bl.a(paramh, paramBoolean1, paramBoolean2);
  }

  public void a(com.viber.voip.model.h paramh, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.bl.a(paramh, paramBoolean1, paramBoolean2, paramBoolean3);
  }

  public void a(String paramString, Uri paramUri, boolean paramBoolean)
  {
    this.bl.a(paramString, paramUri, paramBoolean);
  }

  public void a(boolean paramBoolean)
  {
    this.bl.a(paramBoolean);
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.bl.b(paramConversationItemLoaderEntity);
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, com.viber.voip.model.h paramh)
  {
    this.bl.b(paramConversationItemLoaderEntity, paramh);
  }

  public void c()
  {
    this.bl.c();
  }

  public void c(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.bl.c(paramConversationItemLoaderEntity);
  }

  public void c(ConversationItemLoaderEntity paramConversationItemLoaderEntity, com.viber.voip.model.h paramh)
  {
    this.bl.c(paramConversationItemLoaderEntity, paramh);
  }

  protected void createViewPresenters(View paramView, Bundle paramBundle)
  {
    super.createViewPresenters(paramView, paramBundle);
    com.viber.voip.invitelinks.f localf = new com.viber.voip.invitelinks.f(this.j, this.c);
    d.a locala = ViberApplication.getInstance().getChangePhoneNumberController().b();
    bm localbm = new bm(requireActivity(), locala, this.o);
    cn localcn = new cn(getResources());
    this.bk = new com.viber.voip.contacts.ui.list.u(this.p, this, this.l, this.ae, this.b, this.bf, this.m, localcn, this.T, this.aE, this.ba, this.I, this.n, this.ah, c.f.d, "Chat", this.e.a(getContext()));
    this.bl = new y(this, this.mIsTablet, this.bk, this.aa, localbm, 5);
    this.bj = new CommunityConversationMvpPresenter(localf, new com.viber.voip.invitelinks.linkscreen.f(requireActivity(), this.G, "Add Participants Screen"), this.f, this.aZ, this.bb, this.h);
    com.viber.voip.messages.conversation.community.c.a locala1 = new com.viber.voip.messages.conversation.community.c.a(this.bj, getActivity(), this, paramView, this.aE, this.aw, this.mIsTablet, this.bl, this, this);
    this.am.a(locala1);
    addMvpView(locala1, this.bj, paramBundle);
    this.bm = new DeleteConversationRelatedActionsPresenter(this.i, this.a, this.I);
    addMvpView(new com.viber.voip.messages.conversation.community.c.d(this.bm, getActivity(), this, paramView, this.mIsTablet), this.bm, paramBundle);
    CommunityReportPresenter localCommunityReportPresenter = new CommunityReportPresenter(this.g, this.h, this.i);
    addMvpView(new com.viber.voip.messages.conversation.community.c.c(localCommunityReportPresenter, requireActivity(), this, paramView, this.mIsTablet), localCommunityReportPresenter, paramBundle);
  }

  public void d()
  {
    this.bl.d();
  }

  public void d_(String paramString)
  {
    this.bl.d_(paramString);
  }

  public void e()
  {
    this.bl.e();
  }

  public void f()
  {
    this.bl.f();
  }

  public void g()
  {
    this.bl.g();
  }

  public void h()
  {
    this.bl.h();
  }

  public void k()
  {
    this.bl.k();
  }

  public void l()
  {
  }

  protected void m()
  {
  }

  protected a.a n()
  {
    return com.viber.voip.ui.dialogs.d.i();
  }

  protected DialogCode o()
  {
    return DialogCode.D1012c;
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    if (this.bl.a(paramMenuItem))
      return true;
    return super.onContextItemSelected(paramMenuItem);
  }

  public void onContextMenuClosed(Menu paramMenu)
  {
    super.onContextMenuClosed(paramMenu);
    if (this.bl != null)
      this.bl.a(paramMenu);
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if (paramView == getView())
    {
      this.bl.a(paramContextMenu);
      this.bk.d();
      return;
    }
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    ((e)getCompositeView()).a(paramMenu, paramMenuInflater);
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    this.bk.c();
    this.bk = null;
    this.bl.l();
    this.bl = null;
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if (this.bl.a(paramm, paramInt))
      return;
    super.onDialogAction(paramm, paramInt);
  }

  public void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    super.onFragmentVisibilityChanged(paramBoolean);
    if (this.bk != null)
      this.bk.a(paramBoolean);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    ((e)getCompositeView()).b(paramMenuItem);
    return false;
  }

  public void onStart()
  {
    super.onStart();
    this.aa.a(this.bn);
    this.bk.a();
  }

  public void onStop()
  {
    super.onStop();
    this.aa.b(this.bn);
    this.bk.b();
  }

  protected GeneralConversationPresenter p()
  {
    if (this.aM == null)
      this.aM = new GeneralPublicGroupConversationPresenter(this.aN, this.aZ, this.aX, this.aY, this.bb, cj.a(getContext()), ViberApplication.getInstance().getMediaMountManager(), this.bc, this.ba, ((com.viber.voip.messages.k)aj().get()).d(), this.Z, this.w, this.mIsTablet, com.viber.voip.h.a.b(), this.aQ, this.aS, this.a, this.e, av.a(av.e.g), this.aE, new cq(requireContext()), this.I, ((com.viber.voip.messages.k)this.k.get()).h(), this.ae);
    return this.aM;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.community.CommunityConversationFragment
 * JD-Core Version:    0.6.2
 */