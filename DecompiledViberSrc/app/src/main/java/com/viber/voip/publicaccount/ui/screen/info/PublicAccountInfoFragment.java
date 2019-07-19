package com.viber.voip.publicaccount.ui.screen.info;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;
import com.viber.common.dialogs.l.a;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.R.attr;
import com.viber.voip.R.color;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.R.style;
import com.viber.voip.ViberApplication;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.api.scheme.i;
import com.viber.voip.av.e;
import com.viber.voip.contacts.ui.list.as;
import com.viber.voip.i.c.l;
import com.viber.voip.market.MarketPublicGroupInfo;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.r;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.controller.publicaccount.ae;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.y;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationData;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.ConversationBannerView;
import com.viber.voip.messages.conversation.ui.bq;
import com.viber.voip.messages.conversation.ui.presenter.DeleteConversationRelatedActionsPresenter;
import com.viber.voip.messages.k;
import com.viber.voip.messages.ui.ConversationGalleryActivity;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.entity.PublicAccount.ExtraInfo.JokerButton.Action;
import com.viber.voip.publicaccount.ui.holders.f.a;
import com.viber.voip.registration.af;
import com.viber.voip.ui.ao;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.r;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.ViberActionRunner.ag;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.util.ViberActionRunner.ay;
import com.viber.voip.util.ViberActionRunner.be;
import com.viber.voip.util.ViberActionRunner.bm;
import com.viber.voip.util.cd;
import com.viber.voip.util.da;
import com.viber.voip.util.dc;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;
import com.viber.voip.util.dw;
import com.viber.voip.util.e.h.a;
import com.viber.voip.util.v;
import com.viber.voip.widget.ObservableCollapsingToolbarLayout;
import com.viber.voip.widget.ObservableCollapsingToolbarLayout.c;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class PublicAccountInfoFragment extends a
  implements Toolbar.OnMenuItemClickListener, View.OnClickListener, bv.r
{
  protected com.viber.voip.widget.toolbar.e Q;
  public ConversationBannerView R;
  private Toolbar S;
  private View T;
  private View U;
  private View V;
  private View W;
  private AppBarLayout X;
  private com.viber.voip.widget.e Y;
  private ImageView Z;
  private View aa;
  private View ab;
  private com.viber.voip.util.e.e ac;
  private com.viber.voip.util.e.f ad;
  private bv ae;
  private Handler af;
  private String ag;
  private boolean ah = true;
  private int ai;
  private int aj;
  private int ak;
  private int al;
  private int am;
  private int an;
  private int ao;
  private ao ap;
  private boolean aq;
  private boolean ar;
  private bq as;
  private boolean at;
  private long au;
  private com.viber.voip.publicaccount.ui.holders.recentmedia.b av;
  private com.viber.voip.messages.conversation.publicaccount.e aw;
  private com.viber.common.permission.b ax;

  public PublicAccountInfoFragment()
  {
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(130);
    this.ax = new com.viber.voip.permissions.e(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
        case 130:
        }
        do
          return;
        while (!(paramAnonymousObject instanceof Bundle));
        Bundle localBundle = (Bundle)paramAnonymousObject;
        ViberActionRunner.bm.a(PublicAccountInfoFragment.this.getActivity(), localBundle.getBoolean("is_wink"), localBundle.getLong("message_id"), PublicAccountInfoFragment.this.I);
      }
    };
  }

  private void Q()
  {
    if (this.I == null)
    {
      dj.b(this.T, false);
      return;
    }
    if ((com.viber.voip.publicaccount.d.e.c()) && (this.I.shouldShowNotPublishedPublicAccountBanner()));
    for (boolean bool = true; ; bool = false)
    {
      dj.b(this.T, bool);
      if ((bool) && (this.at))
        this.as.a(this.J);
      this.at = false;
      return;
    }
  }

  private void R()
  {
    if ((this.J == null) || (this.I == null))
    {
      dj.b(this.U, false);
      return;
    }
    boolean bool1 = com.viber.voip.publicaccount.d.d.f.a(this.I.getGroupRole(), this.J.getPublicGroupType());
    View localView = this.U;
    boolean bool2 = false;
    if (bool1)
    {
      boolean bool3 = V();
      bool2 = false;
      if (!bool3)
        bool2 = true;
    }
    dj.b(localView, bool2);
  }

  private void S()
  {
    if ((this.J == null) || (this.I == null));
    while ((this.J.hasPublicChat()) || (!this.I.isPendingRole()) || (this.R == null))
      return;
    this.R.a(this.I, this, true);
  }

  private void T()
  {
    if (this.I == null)
      return;
    this.ac.a(this.I.getIconUri(), this.Z, this.ad, new h.a()
    {
      public void onLoadComplete(Uri paramAnonymousUri, Bitmap paramAnonymousBitmap, boolean paramAnonymousBoolean)
      {
        PublicAccountInfoFragment.a(PublicAccountInfoFragment.this, paramAnonymousBoolean);
        if ((!paramAnonymousBoolean) && (PublicAccountInfoFragment.j(PublicAccountInfoFragment.this) != null) && (PublicAccountInfoFragment.k(PublicAccountInfoFragment.this) != null))
        {
          PublicAccountInfoFragment.j(PublicAccountInfoFragment.this).setVisibility(0);
          PublicAccountInfoFragment.k(PublicAccountInfoFragment.this).setVisibility(0);
        }
      }
    });
  }

  private void U()
  {
    if (this.I == null)
      return;
    this.Q.a(this.I.getGroupName());
    this.Q.a(this.J.isVerified());
    this.Q.c();
    this.Q.b(a(this.I.getGroupRole(), this.I.getConversationType(), this.I.getCategoryName(), this.I.getSubcategoryName()).toString());
  }

  private boolean V()
  {
    int i = this.I.getGroupRole();
    if (cd.b(i));
    int j;
    do
    {
      return true;
      if (!cd.f(i))
        break;
      j = this.I.getConversationType();
    }
    while ((!this.I.isDisabledConversation()) && (j == 2));
    return false;
    return false;
  }

  private void W()
  {
    ViberActionRunner.aq.a(getActivity(), null, c.l.a.e(), 0);
  }

  private void X()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((this.J != null) && (localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
      ViberActionRunner.c(localFragmentActivity, this.J.getGroupID(), this.J.getGroupUri());
  }

  private void Y()
  {
    if (this.J != null)
      dw.a(getActivity(), this.J.getGroupUri(), this.J.getName(), this.J.getGroupID());
  }

  private void Z()
  {
    String str = ViberApplication.getInstance().getUserManager().getRegistrationValues().l();
    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(ap.c().al).buildUpon().appendQueryParameter("type", "PA").appendQueryParameter("chaturi", this.J.getGroupUri()).appendQueryParameter("memid", str).appendQueryParameter("appid", Integer.toString(902)).build()));
  }

  private void a(float paramFloat)
  {
    if (!this.aq);
    FragmentActivity localFragmentActivity;
    do
    {
      return;
      localFragmentActivity = getActivity();
    }
    while (((localFragmentActivity != null) && (a(paramFloat, localFragmentActivity.getWindow()))) || (!com.viber.common.d.a.j()) || (localFragmentActivity == null));
    if ((paramFloat >= 0.5D) && (dc.b()));
    for (boolean bool = true; ; bool = false)
    {
      dj.b(localFragmentActivity, bool);
      return;
    }
  }

  @TargetApi(21)
  private boolean a(float paramFloat, Window paramWindow)
  {
    boolean bool1 = com.viber.common.d.a.i();
    boolean bool2 = false;
    if (bool1)
    {
      if (paramFloat < 0.5D)
        break label34;
      paramWindow.setStatusBarColor(this.ao);
    }
    while (true)
    {
      bool2 = true;
      return bool2;
      label34: paramWindow.setStatusBarColor(0);
    }
  }

  private void aa()
  {
    b();
  }

  private void ab()
  {
    ac();
  }

  private void ac()
  {
    String str;
    if (this.I != null)
    {
      str = this.I.getPublicAccountId();
      if (this.I.hasPublicAccountSubscription())
        break label42;
    }
    label42: for (boolean bool = true; ; bool = false)
    {
      if (a(str, bool))
        this.ag = str;
      return;
    }
  }

  private void ad()
  {
    String str = ap.c().am;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Locale.getDefault().getLanguage();
    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(String.format(str, arrayOfObject))));
  }

  private void ae()
  {
    if (this.au > 0L)
      d(this.au);
    MessageEntity localMessageEntity;
    do
    {
      do
        while (true)
        {
          return;
          List localList = ab.b().l();
          if (localList.isEmpty())
            break;
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
            d(((MessageEntity)localIterator.next()).getMessageToken());
        }
      while (this.I == null);
      localMessageEntity = ab.b().v(this.I.getGroupId());
    }
    while ((localMessageEntity == null) || (localMessageEntity.isRead()));
    d(localMessageEntity.getMessageToken());
  }

  private void b(String paramString, int paramInt)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null);
    while (!paramString.equals(this.ag))
      return;
    if (paramInt != 0)
      Toast.makeText(localFragmentActivity.getApplicationContext(), R.string.public_group_info_unable_to_update_subscription_status, 1).show();
    this.ag = null;
  }

  private void l(boolean paramBoolean)
  {
    if (this.I == null);
    int i;
    do
    {
      return;
      boolean bool1 = this.I.isWebhookExist();
      i = 0;
      if (bool1)
      {
        boolean bool2 = ViberApplication.getInstance().getEngine(false).getPhoneController().isConnected();
        i = 0;
        if (bool2)
        {
          i = 0;
          if (!paramBoolean)
          {
            boolean bool3 = this.I.hasPublicAccountSubscription();
            i = 0;
            if (bool3)
            {
              i = 1;
              r.t().a(this).b(this);
            }
          }
        }
      }
    }
    while (i != 0);
    m(paramBoolean);
  }

  private void m(boolean paramBoolean)
  {
    if (this.I == null)
      return;
    PublicGroupConversationData localPublicGroupConversationData = new PublicGroupConversationData(this.I.getGroupId(), this.I.getPublicAccountGroupUri());
    new com.viber.voip.market.b.a().a(new MarketPublicGroupInfo(localPublicGroupConversationData), this.I.isAgeRestricted(), paramBoolean, ae.b);
  }

  public com.viber.voip.messages.conversation.adapter.n N()
  {
    return new y(getActivity(), this.I, false);
  }

  protected void P()
  {
    if (!this.N.j())
      a(this.S.getMenu());
    while (getActivity() == null)
      return;
    getActivity().invalidateOptionsMenu();
  }

  protected a.b a(Context paramContext, int paramInt, com.viber.voip.ui.a.a parama)
  {
    return new a(this, (AppCompatActivity)requireActivity(), paramInt, parama, this.d, this.o, this.av, getLayoutInflater());
  }

  protected CharSequence a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((com.viber.voip.publicaccount.d.d.g.a(paramInt1, paramInt2)) && (!da.a(paramString1)))
    {
      localStringBuilder.append(paramString1);
      if ((com.viber.voip.publicaccount.d.d.h.a(paramInt1, paramInt2)) && (!da.a(paramString2)))
        localStringBuilder.append(", ").append(paramString2);
      return localStringBuilder;
    }
    if ((!da.a(paramString2)) && (com.viber.voip.publicaccount.d.d.h.a(paramInt1, paramInt2)));
    while (true)
    {
      localStringBuilder.append(paramString2);
      return localStringBuilder;
      paramString2 = getResources().getString(R.string.public_account_info_uncategorized);
    }
  }

  protected void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    this.ar = true;
  }

  public void a(long paramLong)
  {
  }

  public void a(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    super.c(paramLong1);
    this.at = paramBoolean;
    this.au = paramLong2;
  }

  public void a(Menu paramMenu)
  {
    boolean bool1 = true;
    if ((this.J == null) || (paramMenu == null))
      return;
    int i = this.J.getGroupRole();
    int j = this.J.getPublicGroupType();
    boolean bool2 = com.viber.voip.publicaccount.d.d.f.a(i, j);
    boolean bool3;
    int m;
    label126: int k;
    label156: boolean bool4;
    label176: MenuItem localMenuItem3;
    if ((com.viber.voip.publicaccount.d.d.n.a(i, j)) && (this.J.isWebhookExists()))
    {
      bool3 = bool1;
      MenuItem localMenuItem1 = paramMenu.findItem(R.id.menu_toggle_follow);
      MenuItem localMenuItem2 = paramMenu.findItem(R.id.menu_toggle_receive_sessages);
      localMenuItem1.setVisible(bool2);
      localMenuItem2.setVisible(bool3);
      if (bool2)
      {
        if (!V())
          break label271;
        m = R.string.public_account_info_menu_unfollow;
        localMenuItem1.setTitle(m);
      }
      if (bool3)
      {
        if (!this.J.hasSubscription())
          break label279;
        k = R.string.public_account_info_menu_stop_messages;
        localMenuItem2.setTitle(k);
        if (this.ag != null)
          break label287;
        bool4 = bool1;
        localMenuItem2.setEnabled(bool4);
      }
      paramMenu.findItem(R.id.menu_about).setVisible(com.viber.voip.publicaccount.d.d.s.a(i, j));
      paramMenu.findItem(R.id.menu_leave).setVisible(com.viber.voip.publicaccount.d.d.C.a(i, j));
      localMenuItem3 = paramMenu.findItem(R.id.menu_invite_and_share_container);
      if (this.J.isNotShareable())
        break label293;
    }
    while (true)
    {
      localMenuItem3.setVisible(bool1);
      return;
      bool3 = false;
      break;
      label271: m = R.string.public_account_info_menu_follow;
      break label126;
      label279: k = R.string.public_account_info_menu_receive_messages;
      break label156;
      label287: bool4 = false;
      break label176;
      label293: bool1 = false;
    }
  }

  protected void a(View paramView)
  {
    this.S = ((Toolbar)paramView.findViewById(R.id.toolbar));
    this.X = ((AppBarLayout)paramView.findViewById(R.id.app_bar));
    this.X.addOnOffsetChangedListener(this.Q);
    this.ap = new ao(this.S);
    if (!this.N.j())
    {
      this.S.inflateMenu(R.menu.menu_pa_info);
      this.S.setOnMenuItemClickListener(this);
      this.S.setNavigationOnClickListener(new g(this));
      a(this.S.getMenu());
    }
    android.support.v7.app.a locala;
    do
    {
      FragmentActivity localFragmentActivity;
      do
      {
        return;
        localFragmentActivity = getActivity();
      }
      while (!(localFragmentActivity instanceof AppCompatActivity));
      ((AppCompatActivity)localFragmentActivity).setSupportActionBar(this.S);
      locala = ((AppCompatActivity)localFragmentActivity).getSupportActionBar();
    }
    while (locala == null);
    locala.b(true);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    super.a(paramConversationItemLoaderEntity, paramBoolean);
    if ((this.ag != null) && (!this.ag.equals(paramConversationItemLoaderEntity.getPublicAccountId())))
      this.ag = null;
    if ((paramConversationItemLoaderEntity != null) && (this.av.I() != paramConversationItemLoaderEntity.getId()))
    {
      this.av.a(paramConversationItemLoaderEntity.getId());
      this.av.i();
    }
    T();
    U();
    Q();
    R();
    P();
    S();
  }

  public void a(String paramString)
  {
  }

  public void a(final String paramString, final int paramInt)
  {
    this.af.post(new Runnable()
    {
      public void run()
      {
        PublicAccountInfoFragment.a(PublicAccountInfoFragment.this, paramString, paramInt);
      }
    });
  }

  protected void b(View paramView)
  {
    this.Q = new com.viber.voip.widget.toolbar.b(paramView);
    if (this.Q.b() != null)
      this.Q.b().setOnClickListener(this);
  }

  protected void c(View paramView)
  {
    this.T = paramView.findViewById(R.id.publish_public_account_banner_container);
    this.V = paramView.findViewById(R.id.publish_public_account_btn);
    this.V.setOnClickListener(this);
  }

  void d(long paramLong)
  {
    if ((this.I != null) && (new bs(ViberApplication.getApplication()).a(this.I.getId(), this.I.getConversationType(), paramLong, this.I.getLastServerMsgId(), this.I.getGroupId())))
    {
      com.viber.voip.notif.g.a(getActivity()).a(this.I.getId());
      o.a().a(Collections.singleton(Long.valueOf(this.I.getId())), this.I.getConversationType(), false, false);
    }
  }

  public void k(boolean paramBoolean)
  {
    this.aq = paramBoolean;
  }

  protected boolean m()
  {
    return as.a(this.I);
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.I != null) && (this.aw.a(paramInt1, paramInt2, this.I.getGroupId())))
      return;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onClick(View paramView)
  {
    if ((R.id.publish_public_account_btn == paramView.getId()) && (this.I != null))
      this.as.a(this.J);
    do
    {
      return;
      if (R.id.follow_btn == paramView.getId())
      {
        l(true);
        return;
      }
      if (R.id.accept == paramView.getId())
      {
        this.aw.a(this);
        return;
      }
    }
    while (R.id.decline != paramView.getId());
    r.a().a(this).b(this);
  }

  public void onCreate(Bundle paramBundle)
  {
    dagger.a locala = ViberApplication.getInstance().getLazyMessagesManager();
    this.av = new com.viber.voip.publicaccount.ui.holders.recentmedia.b(getContext(), getLoaderManager(), locala, this, com.viber.voip.h.a.b());
    super.onCreate(paramBundle);
    setHasOptionsMenu(this.N.j());
    FragmentActivity localFragmentActivity = requireActivity();
    this.ac = com.viber.voip.util.e.e.a(localFragmentActivity);
    this.ad = com.viber.voip.util.e.f.a();
    this.af = com.viber.voip.av.a(av.e.a);
    this.ae = o.a();
    this.ae.a(this);
    this.ai = ContextCompat.getColor(localFragmentActivity, R.color.negative);
    this.aj = ContextCompat.getColor(localFragmentActivity, R.color.main_light);
    this.ak = dc.d(localFragmentActivity, R.attr.toolbarTitleInverseColor);
    this.al = dc.d(localFragmentActivity, R.attr.toolbarTitleColor);
    this.am = dc.d(localFragmentActivity, R.attr.toolbarSubtitleInverseColor);
    this.an = dc.d(localFragmentActivity, R.attr.toolbarSubtitleCollapsedColor);
    if (com.viber.common.d.a.i());
    for (int i = dc.a(localFragmentActivity, R.attr.statusBarDefaultLollipopColor, ContextCompat.getColor(localFragmentActivity, R.color.status_bar_grey)); ; i = dc.a(localFragmentActivity, R.attr.colorPrimaryDark, ContextCompat.getColor(localFragmentActivity, R.color.light_theme_main_dark)))
    {
      this.ao = i;
      return;
    }
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(R.menu.menu_pa_info, paramMenu);
    a(paramMenu);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    com.viber.voip.ui.j.av localav = (com.viber.voip.ui.j.av)ViberApplication.getInstance().getThemeController().get();
    LayoutInflater localLayoutInflater = paramLayoutInflater.cloneInContext(new android.support.v7.view.d(paramLayoutInflater.getContext(), localav.a(R.style.Theme_Viber_Details)));
    if (this.N.j())
      return localLayoutInflater.inflate(R.layout.fragment_public_account_info, paramViewGroup, false);
    return localLayoutInflater.inflate(R.layout.fragment_public_account_info_drawer, paramViewGroup, false);
  }

  public void onDestroy()
  {
    this.ae.b(this);
    super.onDestroy();
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if ((this.I != null) && (this.aw.a(getActivity(), paramm, paramInt, this.I.getId(), this.I.getConversationType())))
      return;
    if (paramm.a(DialogCode.D2010))
      switch (paramInt)
      {
      default:
      case -2:
      }
    while (true)
    {
      m(false);
      super.onDialogAction(paramm, paramInt);
      return;
      if ((this.I != null) && (this.I.isWebhookExist()) && (this.I.hasPublicAccountSubscription()) && (ViberApplication.getInstance().getEngine(false).getPhoneController().isConnected()))
        ac();
    }
  }

  public void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    super.onFragmentVisibilityChanged(paramBoolean);
    k(paramBoolean);
    if ((!paramBoolean) && (this.X != null))
    {
      this.X.setExpanded(true, true);
      this.Q.c();
      this.L.scrollToPosition(0);
    }
  }

  public void onLoadFinished(com.viber.provider.d paramd, boolean paramBoolean)
  {
    if (this.av == paramd)
      this.K.b(paramd.getCount());
    do
    {
      return;
      super.onLoadFinished(paramd, paramBoolean);
      if ((paramBoolean) && (this.I != null) && (as.a(this.I)))
        ViberApplication.getInstance().getMessagesManager().h().a(this.I.getPublicAccountId());
    }
    while ((!paramBoolean) || (this.I == null) || ((this.I.hasPublicAccountPublicChat()) && (this.au <= 0L)));
    com.viber.voip.av.a(av.e.f).post(new Runnable()
    {
      public void run()
      {
        PublicAccountInfoFragment.l(PublicAccountInfoFragment.this);
      }
    });
  }

  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i == 16908332)
    {
      this.N.i();
      return true;
    }
    if (i == R.id.menu_invite_friends)
    {
      X();
      return true;
    }
    if (i == R.id.menu_share)
    {
      Y();
      return true;
    }
    if (i == R.id.menu_report)
    {
      Z();
      return true;
    }
    if (i == R.id.menu_toggle_follow)
    {
      if (!V());
      for (boolean bool = true; ; bool = false)
      {
        l(bool);
        return true;
      }
    }
    if (i == R.id.menu_leave)
    {
      aa();
      return true;
    }
    if (i == R.id.menu_toggle_receive_sessages)
    {
      ab();
      return true;
    }
    if (i == R.id.menu_about)
    {
      ad();
      return true;
    }
    if (i == R.id.menu_discover)
    {
      W();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return onMenuItemClick(paramMenuItem);
  }

  public void onStart()
  {
    super.onStart();
    this.d.a(this.ax);
    this.av.p();
  }

  public void onStop()
  {
    super.onStop();
    this.d.b(this.ax);
    this.av.q();
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    DefaultItemAnimator localDefaultItemAnimator = new DefaultItemAnimator();
    localDefaultItemAnimator.setSupportsChangeAnimations(false);
    this.L.setItemAnimator(localDefaultItemAnimator);
    this.Z = ((ImageView)paramView.findViewById(R.id.icon));
    this.R = ((ConversationBannerView)paramView.findViewById(R.id.remote_banner_container_wrapper_bottom));
    this.aa = paramView.findViewById(R.id.gradient_top);
    this.ab = paramView.findViewById(R.id.gradient_bottom);
    this.W = paramView.findViewById(R.id.overlay);
    b(paramView);
    a(paramView);
    FragmentActivity localFragmentActivity = getActivity();
    this.Y = new com.viber.voip.widget.e(dc.g(paramView.getContext(), R.attr.toolbarBackground), this.W, this.aa, this.ab, this.S)
    {
      public boolean adjustGradient()
      {
        return !PublicAccountInfoFragment.b(PublicAccountInfoFragment.this);
      }

      public void onScroll(float paramAnonymousFloat, ObservableCollapsingToolbarLayout.c paramAnonymousc)
      {
        super.onScroll(paramAnonymousFloat, paramAnonymousc);
        PublicAccountInfoFragment.a(PublicAccountInfoFragment.this, paramAnonymousFloat);
        PublicAccountInfoFragment.e(PublicAccountInfoFragment.this).a(v.a(paramAnonymousFloat, PublicAccountInfoFragment.c(PublicAccountInfoFragment.this), PublicAccountInfoFragment.d(PublicAccountInfoFragment.this)));
        PublicAccountInfoFragment.this.Q.a(v.a(paramAnonymousFloat, PublicAccountInfoFragment.f(PublicAccountInfoFragment.this), PublicAccountInfoFragment.g(PublicAccountInfoFragment.this)));
        PublicAccountInfoFragment.this.Q.b(v.a(paramAnonymousFloat, PublicAccountInfoFragment.h(PublicAccountInfoFragment.this), PublicAccountInfoFragment.i(PublicAccountInfoFragment.this)));
      }
    };
    ObservableCollapsingToolbarLayout localObservableCollapsingToolbarLayout = (ObservableCollapsingToolbarLayout)paramView.findViewById(R.id.collapsing_toolbar);
    if (localObservableCollapsingToolbarLayout != null)
      localObservableCollapsingToolbarLayout.setOnScrollListener(this.Y);
    c(paramView);
    this.U = paramView.findViewById(R.id.follow_banner_container);
    paramView.findViewById(R.id.follow_btn).setOnClickListener(this);
    this.as = new bq(o.a(), ViberApplication.getInstance().getMessagesManager().d(), ViberApplication.getInstance().getEngine(true).getPhoneController(), localFragmentActivity.getWindow().getDecorView());
    this.aw = new com.viber.voip.messages.conversation.publicaccount.e(this.R);
  }

  public void u()
  {
    if (this.J.hasPublicChat())
    {
      super.u();
      return;
    }
    a(2, "Participants List");
  }

  protected static class a extends a.b
    implements com.viber.voip.publicaccount.ui.holders.a.a, com.viber.voip.publicaccount.ui.holders.about.a.a, f.a, com.viber.voip.publicaccount.ui.holders.infobuttons.c.a, com.viber.voip.publicaccount.ui.holders.jokerbuttons.a.a, com.viber.voip.publicaccount.ui.holders.recentmedia.c.a, com.viber.voip.publicaccount.ui.holders.storage.a.a
  {
    protected a.a f;
    private AppCompatActivity g;
    private final com.viber.voip.util.e.g h;
    private k i;
    private ICdrController j;
    private com.viber.common.permission.c k;
    private Fragment l;
    private com.viber.voip.publicaccount.ui.holders.recentmedia.b m;

    public a(Fragment paramFragment, AppCompatActivity paramAppCompatActivity, int paramInt, com.viber.voip.ui.a.a parama, com.viber.common.permission.c paramc, com.viber.voip.util.e.g paramg, com.viber.voip.publicaccount.ui.holders.recentmedia.b paramb, LayoutInflater paramLayoutInflater)
    {
      super(paramInt, parama, paramLayoutInflater);
      this.g = paramAppCompatActivity;
      this.h = paramg;
      this.i = ViberApplication.getInstance().getMessagesManager();
      this.j = ViberApplication.getInstance().getEngine(false).getCdrController();
      this.f = ((a.a)paramAppCompatActivity);
      this.l = paramFragment;
      this.k = paramc;
      this.m = paramb;
    }

    private void o()
    {
      this.f.a(this.e);
    }

    protected a.c a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, com.viber.voip.publicaccount.ui.holders.c[] paramArrayOfc)
    {
      return new a.c(paramLayoutInflater.inflate(R.layout.layout_pa_info_header, paramViewGroup, false), paramArrayOfc);
    }

    public void a()
    {
      o();
    }

    public void a(aa paramaa)
    {
      if (this.k.a(com.viber.voip.permissions.n.m))
      {
        ViberActionRunner.bm.a(this.g, paramaa.aD(), paramaa.a(), this.e);
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("is_wink", paramaa.aD());
      localBundle.putLong("message_id", paramaa.a());
      this.k.a(this.g, 130, com.viber.voip.permissions.n.m, localBundle);
    }

    public void a(String paramString, PublicAccount.ExtraInfo.JokerButton.Action paramAction)
    {
      int n = ViberActionRunner.ag.a(this.g, paramAction);
      if ((paramAction != null) && (!da.a(paramAction.getUrl())));
      for (String str = paramAction.getUrl(); ; str = null)
      {
        this.j.handleReportPATappingOnWebSite(this.e.getPublicAccountId(), this.e.getCategoryId(), this.e.getSubcategoryId(), this.e.getCountryCode(), this.e.getLocation(), new SecureRandom().nextLong(), str, n);
        return;
      }
    }

    public void a(boolean paramBoolean)
    {
      if (!this.e.isMuteConversation())
        this.i.d().a(this.e.getId(), this.e.getConversationType(), paramBoolean);
    }

    protected a.c b(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, com.viber.voip.publicaccount.ui.holders.c[] paramArrayOfc)
    {
      return new a.c(paramLayoutInflater.inflate(R.layout.layout_pa_info_footer, paramViewGroup, false), paramArrayOfc);
    }

    public void b()
    {
      ViberActionRunner.a(this.g, this.e.getId(), this.e.getLocationLat(), this.e.getLocationLng(), System.currentTimeMillis(), this.e.getGroupName(), this.e.getAddressString(), false, true, true, this.e.isSecret());
    }

    public void b(boolean paramBoolean)
    {
      if ((this.l instanceof PublicAccountInfoFragment))
        PublicAccountInfoFragment.a((PublicAccountInfoFragment)this.l).b(paramBoolean);
    }

    public void c()
    {
      if (this.e != null)
      {
        String str = ViberActionRunner.be.a(this.e.getWebsite(), "http://");
        ViberActionRunner.be.a(this.g, str, true);
        this.j.handleReportPATappingOnWebSite(this.e.getPublicAccountId(), this.e.getCategoryId(), this.e.getSubcategoryId(), this.e.getCountryCode(), this.e.getLocation(), new SecureRandom().nextLong(), str, -1);
      }
    }

    public void d()
    {
      this.g.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(i.a(this.e.getPublicAccountId()))));
    }

    public void e()
    {
      ViberActionRunner.aq.a(this.g, this.e.getPublicAccountId());
    }

    public void f()
    {
      o();
    }

    public void g()
    {
      ViberActionRunner.aq.a(this.l, this.e.getId());
    }

    public void h()
    {
      o();
    }

    public void i()
    {
      AppCompatActivity localAppCompatActivity = this.g;
      long l1 = this.e.getId();
      int n = this.e.getConversationType();
      if (!this.e.isNotShareable());
      for (boolean bool = true; ; bool = false)
      {
        localAppCompatActivity.startActivity(ConversationGalleryActivity.a(l1, n, bool, false, dg.b(this.e), this.e.getGroupRole()));
        return;
      }
    }

    public void j()
    {
      ViberActionRunner.ay.a(this.g, this.e.getId(), 5);
    }

    protected com.viber.voip.publicaccount.ui.holders.c[] l()
    {
      Context localContext = this.g.getApplicationContext();
      com.viber.voip.publicaccount.ui.holders.c[] arrayOfc = new com.viber.voip.publicaccount.ui.holders.c[8];
      arrayOfc[0] = new com.viber.voip.publicaccount.ui.holders.infobuttons.c(this);
      arrayOfc[1] = new com.viber.voip.publicaccount.ui.holders.numbers.a();
      arrayOfc[2] = new com.viber.voip.publicaccount.ui.holders.recentmedia.c(this.g, this.m, this.h, this, this.l.getLayoutInflater());
      arrayOfc[3] = new com.viber.voip.publicaccount.ui.holders.jokerbuttons.a(this);
      arrayOfc[4] = new com.viber.voip.publicaccount.ui.holders.a(localContext, this);
      arrayOfc[5] = new com.viber.voip.publicaccount.ui.holders.uri.a();
      arrayOfc[6] = new com.viber.voip.publicaccount.ui.holders.about.a(localContext.getResources(), this);
      arrayOfc[7] = new com.viber.voip.publicaccount.ui.holders.storage.a(this);
      return arrayOfc;
    }

    protected com.viber.voip.publicaccount.ui.holders.c[] m()
    {
      com.viber.voip.publicaccount.ui.holders.c[] arrayOfc = new com.viber.voip.publicaccount.ui.holders.c[2];
      arrayOfc[0] = new com.viber.voip.publicaccount.ui.holders.separator.a();
      arrayOfc[1] = new com.viber.voip.publicaccount.ui.holders.f(this);
      return arrayOfc;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.screen.info.PublicAccountInfoFragment
 * JD-Core Version:    0.6.2
 */