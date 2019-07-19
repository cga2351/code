package com.viber.voip.messages.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.Space;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.viber.common.dialogs.k.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m.c;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.cdr.entity.ConversationsScreenScrollCdrController;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ads.b.c.b.a;
import com.viber.voip.ads.b.c.b.a.a;
import com.viber.voip.ads.b.c.b.f.c;
import com.viber.voip.analytics.story.StoryConstants.g.a;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.av.e;
import com.viber.voip.banner.notificationsoff.f.a;
import com.viber.voip.contacts.adapters.g.a;
import com.viber.voip.i.c.f;
import com.viber.voip.invitelinks.CommunityFollowerData;
import com.viber.voip.invitelinks.ad;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.r.a;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.a.h;
import com.viber.voip.messages.conversation.community.search.CommunitySearchResult;
import com.viber.voip.messages.conversation.community.search.Group;
import com.viber.voip.messages.conversation.n.a;
import com.viber.voip.messages.conversation.o;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.o.a;
import com.viber.voip.messages.ui.view.SearchLabelView;
import com.viber.voip.messages.ui.view.SearchNoResultsView;
import com.viber.voip.model.j;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.b.e.a;
import com.viber.voip.settings.d.r;
import com.viber.voip.shareviber.chatstrigger.ChatsTriggerPresenter;
import com.viber.voip.shareviber.chatstrigger.g;
import com.viber.voip.shareviber.chatstrigger.h.a;
import com.viber.voip.ui.ViberListView;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.ai;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.ak;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.al;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.am;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.as;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.au;
import com.viber.voip.ui.dialogs.k;
import com.viber.voip.ui.dialogs.l;
import com.viber.voip.ui.dialogs.p;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.ViberActionRunner.aa;
import com.viber.voip.util.ViberActionRunner.o;
import com.viber.voip.util.ae;
import com.viber.voip.util.cg;
import com.viber.voip.util.cv;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;
import com.viber.voip.util.dx;
import com.viber.voip.vln.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;

public class bn extends bk
  implements m.c, f.c, h.a, d.a
{

  @Inject
  dagger.a<com.viber.voip.messages.controller.a.a> F;

  @Inject
  dagger.a<com.viber.voip.messages.controller.r> G;

  @Inject
  com.viber.voip.vln.d H;

  @Inject
  dagger.a<h> I;

  @Inject
  dagger.a<com.viber.voip.analytics.story.e.c> J;

  @Inject
  ConversationsScreenScrollCdrController K;

  @Inject
  @Named("com.viber.voip.ChatListAdsController")
  com.viber.voip.ads.b.c.b.f L;

  @Inject
  com.viber.voip.ads.b.c.a.b M;
  private com.viber.voip.contacts.d T;
  private bi U;
  private bh V;
  private com.b.a.a.a W;
  private SearchLabelView X;
  private SearchNoResultsView Y;
  private View Z;
  private View aa;
  private TextView ab;
  private View ac;
  private View ad;
  private final e ae = new e(null);
  private final b af = new b();
  private final f ag = new f(null);
  private final d ah = new d();
  private j ai = this.ae;
  private boolean aj;
  private Drawable ak;
  private Handler al;
  private boolean am;
  private com.viber.voip.ui.f.b an;
  private ChatsTriggerPresenter ao;
  private boolean ap;
  private q aq;
  private int ar = -1;
  private final com.viber.voip.ads.b.c.a<com.viber.voip.ads.b.c.c.c> as = new com.viber.voip.ads.b.c.a()
  {
    public void a()
    {
      if ((bn.a(bn.this) != null) && (bn.this.n != null))
        bn.a(bn.this).a(null);
    }

    public void a(com.viber.voip.ads.b.c.c.c paramAnonymousc)
    {
      if ((bn.a(bn.this) != null) && (bn.this.n != null))
        bn.a(bn.this).a(paramAnonymousc);
      if ((bn.this.L != null) && (bn.this.n != null))
        bn.this.L.l();
    }
  };
  private Runnable at = new bo(this);

  private void C()
  {
    if (this.aj)
    {
      this.aj = false;
      this.n.setAdapter(j());
    }
    ListAdapter localListAdapter;
    do
    {
      return;
      localListAdapter = j();
      if (this.n.getAdapter() != localListAdapter)
      {
        this.n.setAdapter(localListAdapter);
        return;
      }
    }
    while (!(localListAdapter instanceof BaseAdapter));
    ((BaseAdapter)localListAdapter).notifyDataSetChanged();
  }

  private void E()
  {
    boolean bool = true;
    this.aj = bool;
    j localj = this.ai;
    int i;
    if (this.ae != this.ai)
    {
      i = bool;
      if (TextUtils.isEmpty(this.P))
        break label113;
      label35: if ((!c.f.c.e()) || (this.P == null) || (!this.P.startsWith("@")))
        break label118;
      this.ai = this.ah;
    }
    while (true)
    {
      if (localj != this.ai)
        localj.c();
      this.ai.b();
      this.ai.a(this.P);
      return;
      i = 0;
      break;
      label113: bool = false;
      break label35;
      label118: if (((this.ai == this.ah) || (i == 0)) && (bool))
        this.ai = this.af;
      else if ((i != 0) && (!bool))
        this.ai = this.ae;
    }
  }

  private void F()
  {
    p.c().a(new ViberDialogHandlers.as("Swipe on Business Inbox")).a(getActivity());
  }

  private void G()
  {
    MessagesFragmentModeManager localMessagesFragmentModeManager = w();
    if (localMessagesFragmentModeManager != null)
      localMessagesFragmentModeManager.A();
  }

  private boolean H()
  {
    return (this.L != null) && (this.ar != -1) && (c()) && (!a()) && (this.L.e()) && (!this.L.d());
  }

  private void a(Activity paramActivity)
  {
    if (H())
    {
      b.a locala = new b.a.a(paramActivity).a(false).a();
      this.L.a(locala, this.as);
    }
  }

  private void a(ContextMenu paramContextMenu, ConversationLoaderEntity paramConversationLoaderEntity)
  {
    String str = dg.b(paramConversationLoaderEntity);
    View localView = LayoutInflater.from(getActivity()).inflate(R.layout.context_menu_header, null);
    TextView localTextView = (TextView)localView.findViewById(R.id.text);
    if (paramConversationLoaderEntity.isInBusinessInbox())
      str = getString(R.string.business_inbox);
    while (true)
    {
      localTextView.setText(str);
      paramContextMenu.setHeaderView(localView);
      return;
      if (paramConversationLoaderEntity.isVlnConversation())
        str = cg.a(getActivity(), paramConversationLoaderEntity.getToNumber());
    }
  }

  private void a(Menu paramMenu, ConversationLoaderEntity paramConversationLoaderEntity)
  {
    int i = 1;
    boolean bool1 = paramConversationLoaderEntity.isSnoozedConversation();
    boolean bool2 = paramConversationLoaderEntity.isSystemConversation();
    int j;
    int k;
    if ((paramConversationLoaderEntity.isSecret()) || (paramConversationLoaderEntity.isHiddenConversation()))
    {
      j = i;
      if ((!paramConversationLoaderEntity.isConversation1on1()) && (!com.viber.voip.messages.m.f(paramConversationLoaderEntity.getConversationType())) && (!paramConversationLoaderEntity.isPublicAccount()) && ((!paramConversationLoaderEntity.isCommunityType()) || (paramConversationLoaderEntity.isDisabledConversation())))
        break label135;
      k = i;
      label72: if ((!bool1) && (k != 0) && (j == 0) && (!bool2))
      {
        if ((!paramConversationLoaderEntity.isMarkedAsUnreadConversation()) && (paramConversationLoaderEntity.getUnreadEventsCount() <= 0))
          break label141;
        label106: if (i == 0)
          break label146;
      }
    }
    label135: label141: label146: for (int m = R.string.mark_as_read; ; m = R.string.mark_as_unread)
    {
      paramMenu.add(0, m, 0, m);
      return;
      j = 0;
      break;
      k = 0;
      break label72;
      i = 0;
      break label106;
    }
  }

  private void a(Menu paramMenu, ConversationLoaderEntity paramConversationLoaderEntity, com.viber.voip.messages.controller.a.a parama)
  {
    if ((parama.b()) && (paramConversationLoaderEntity.isSystemConversation()) && (!com.viber.voip.messages.controller.a.d.a(paramConversationLoaderEntity.getAppId())) && (!paramConversationLoaderEntity.isInBusinessInbox()) && (!paramConversationLoaderEntity.isVlnConversation()))
      paramMenu.add(0, R.id.menu_move_to_business_inbox, 0, getString(R.string.menu_move_to_business_inbox));
  }

  private void a(com.viber.voip.model.c paramc)
  {
    Intent localIntent;
    if ((paramc instanceof bi.a))
      localIntent = com.viber.voip.messages.m.a(new ConversationData(((bi.a)paramc).a(), "", true), true);
    while (true)
    {
      if (localIntent != null)
      {
        localIntent.putExtra("clicked", true);
        startActivity(localIntent);
      }
      return;
      if ((paramc.p()) && (paramc.n() != null))
      {
        j localj = paramc.n();
        localIntent = null;
        if (localj != null)
          localIntent = com.viber.voip.messages.m.a(localj.a(), localj.c(), "", false, false, false, true);
      }
      else
      {
        localIntent = ViberActionRunner.o.a(false, paramc.getId(), paramc.k(), "", paramc.o(), null, null, null);
      }
    }
  }

  private void b(Menu paramMenu, ConversationLoaderEntity paramConversationLoaderEntity)
  {
    if ((!ao.f()) && (!paramConversationLoaderEntity.isSystemConversation()) && (!paramConversationLoaderEntity.isPublicAccount()) && (!paramConversationLoaderEntity.isBroadcastListType()) && (!paramConversationLoaderEntity.isCommunityType()) && (!paramConversationLoaderEntity.isVlnConversation()) && (!paramConversationLoaderEntity.isSnoozedConversation()))
      if (!paramConversationLoaderEntity.isHiddenConversation())
        break label71;
    label71: for (int i = R.string.menu_unhide_chat; ; i = R.string.menu_hide_chat)
    {
      paramMenu.add(0, i, 0, i);
      return;
    }
  }

  private void b(String paramString)
  {
    p.d().a(new ViberDialogHandlers.au(paramString)).a(getActivity());
  }

  private boolean b(ConversationLoaderEntity paramConversationLoaderEntity)
  {
    return !((ConferenceCallsRepository)this.s.get()).isConversationConferenceTalkingTo(paramConversationLoaderEntity.getId());
  }

  private void c(Menu paramMenu, ConversationLoaderEntity paramConversationLoaderEntity)
  {
    int i;
    if ((paramConversationLoaderEntity.isCommunityType()) && (!paramConversationLoaderEntity.isSnoozedConversation()) && (!paramConversationLoaderEntity.isNotJoinedCommunity()))
    {
      i = R.id.menu_mute_chat;
      if (!paramConversationLoaderEntity.isMuteConversation())
        break label54;
    }
    label54: for (String str = getString(R.string.unmute_chat); ; str = getString(R.string.chat_info_mute_title))
    {
      paramMenu.add(0, i, 0, str);
      return;
    }
  }

  private void c(final ConversationLoaderEntity paramConversationLoaderEntity)
  {
    if (paramConversationLoaderEntity.isPublicAccount())
    {
      com.viber.voip.ui.dialogs.r.w().a(paramConversationLoaderEntity).a(this).b(this);
      return;
    }
    if ((!paramConversationLoaderEntity.isGroupBehavior()) || (paramConversationLoaderEntity.isDisabledConversation()))
    {
      a(e(paramConversationLoaderEntity));
      return;
    }
    if (paramConversationLoaderEntity.isBroadcastListType())
    {
      ViberDialogHandlers.al localal = new ViberDialogHandlers.al();
      localal.a = this;
      localal.b = e(paramConversationLoaderEntity);
      l.b(dg.c(paramConversationLoaderEntity.getGroupName())).a(localal).a(getActivity());
      return;
    }
    if (paramConversationLoaderEntity.isSnoozedConversation())
    {
      ViberDialogHandlers.ak localak = new ViberDialogHandlers.ak();
      localak.a = this;
      localak.b = e(paramConversationLoaderEntity);
      k.j().a(localak).a(getActivity());
      return;
    }
    if (paramConversationLoaderEntity.isMuteConversation())
    {
      ViberDialogHandlers.am localam = new ViberDialogHandlers.am(StoryConstants.g.a.a(paramConversationLoaderEntity), com.viber.voip.analytics.story.n.a(paramConversationLoaderEntity));
      localam.a = new MessagesFragmentModeManager.c()
      {
        public void a(long paramAnonymousLong, int paramAnonymousInt)
        {
          bn.this.a(paramAnonymousLong, paramAnonymousInt);
        }

        public void a(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          bn.this.a(paramAnonymousLong, paramAnonymousInt, paramAnonymousBoolean);
          com.viber.voip.analytics.story.e.c localc = (com.viber.voip.analytics.story.e.c)bn.this.J.get();
          String str = ae.b();
          ConversationLoaderEntity localConversationLoaderEntity = paramConversationLoaderEntity;
          if (!paramAnonymousBoolean);
          for (boolean bool = true; ; bool = false)
          {
            localc.a(str, localConversationLoaderEntity, "Leave and Delete Dialog", bool);
            return;
          }
        }

        public void a(String paramAnonymousString)
        {
          bn.this.a(paramAnonymousString);
        }

        public void a(Map<Long, MessagesFragmentModeManager.b> paramAnonymousMap)
        {
          bn.this.a(paramAnonymousMap);
        }

        public void b(int paramAnonymousInt)
        {
          bn.this.b(paramAnonymousInt);
        }

        public void b(Map<Long, MessagesFragmentModeManager.b> paramAnonymousMap)
        {
          bn.this.b(paramAnonymousMap);
        }

        public void m()
        {
          bn.this.m();
        }
      };
      localam.c = paramConversationLoaderEntity.getConversationType();
      localam.b = paramConversationLoaderEntity.getId();
      k.l().a(localam).a(getActivity());
      return;
    }
    ViberDialogHandlers.ai localai = new ViberDialogHandlers.ai();
    localai.a = new MessagesFragmentModeManager.c()
    {
      public void a(long paramAnonymousLong, int paramAnonymousInt)
      {
        bm.a(this, paramAnonymousLong, paramAnonymousInt);
      }

      public void a(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        bm.a(this, paramAnonymousLong, paramAnonymousInt, paramAnonymousBoolean);
      }

      public void a(String paramAnonymousString)
      {
        bn.this.a(paramAnonymousString);
      }

      public void a(Map<Long, MessagesFragmentModeManager.b> paramAnonymousMap)
      {
        bn.this.a(paramAnonymousMap);
      }

      public void b(int paramAnonymousInt)
      {
        bn.this.b(paramAnonymousInt);
      }

      public void b(Map<Long, MessagesFragmentModeManager.b> paramAnonymousMap)
      {
        bn.this.b(paramAnonymousMap);
        ((com.viber.voip.analytics.story.e.c)bn.this.J.get()).a(ae.b(), paramConversationLoaderEntity, true);
      }

      public void m()
      {
        bn.this.m();
      }
    };
    localai.b = e(paramConversationLoaderEntity);
    k.h().a(localai).a(getActivity());
  }

  private void d(Menu paramMenu, ConversationLoaderEntity paramConversationLoaderEntity)
  {
    int i;
    if ((!paramConversationLoaderEntity.isNonreplyableConversation()) && (!paramConversationLoaderEntity.isSystemConversation()) && (!paramConversationLoaderEntity.isSnoozedConversation()) && (!paramConversationLoaderEntity.isNotJoinedCommunity()))
    {
      i = R.id.menu_pin_chat;
      if (!paramConversationLoaderEntity.isFavouriteConversation())
        break label57;
    }
    label57: for (int j = R.string.menu_unpin_this_chat; ; j = R.string.menu_pin_chat_to_top)
    {
      paramMenu.add(0, i, 0, j);
      return;
    }
  }

  private void d(ConversationLoaderEntity paramConversationLoaderEntity)
  {
    boolean bool1 = paramConversationLoaderEntity.isSnoozedConversation();
    a(paramConversationLoaderEntity.getId(), paramConversationLoaderEntity.getConversationType(), bool1);
    com.viber.voip.analytics.story.e.c localc = (com.viber.voip.analytics.story.e.c)this.J.get();
    String str = ae.b();
    if (!bool1);
    for (boolean bool2 = true; ; bool2 = false)
    {
      localc.a(str, paramConversationLoaderEntity, "Chat List", bool2);
      return;
    }
  }

  private Map<Long, MessagesFragmentModeManager.b> e(ConversationLoaderEntity paramConversationLoaderEntity)
  {
    HashMap localHashMap = new HashMap();
    MessagesFragmentModeManager.b localb = new MessagesFragmentModeManager.b(paramConversationLoaderEntity.isGroupBehavior(), paramConversationLoaderEntity.isMuteConversation(), false, paramConversationLoaderEntity.getConversationType(), paramConversationLoaderEntity.getGroupRole(), paramConversationLoaderEntity.getFlags(), paramConversationLoaderEntity.getAppId(), paramConversationLoaderEntity.getWatchersCount());
    localHashMap.put(Long.valueOf(paramConversationLoaderEntity.getId()), localb);
    return localHashMap;
  }

  private void e(Menu paramMenu, ConversationLoaderEntity paramConversationLoaderEntity)
  {
    if (paramConversationLoaderEntity.isDisabledConversation());
    do
    {
      return;
      if (paramConversationLoaderEntity.isCommunityType())
      {
        int i = R.id.menu_snooze_chat;
        if (paramConversationLoaderEntity.isSnoozedConversation());
        for (int j = R.string.unsnooze_community; ; j = R.string.snooze_community_pref_title)
        {
          paramMenu.add(0, i, 0, j);
          return;
        }
      }
    }
    while ((!paramConversationLoaderEntity.isSnoozedConversation()) || (!paramConversationLoaderEntity.isGroupType()));
    paramMenu.add(0, R.id.menu_snooze_chat, 0, R.string.unsnooze_community);
  }

  private void f(Menu paramMenu, ConversationLoaderEntity paramConversationLoaderEntity)
  {
    if ((paramConversationLoaderEntity.isCommunityType()) && (!paramConversationLoaderEntity.isDisabledConversation()) && (!paramConversationLoaderEntity.isSnoozedConversation()));
    do
    {
      return;
      if (paramConversationLoaderEntity.isInBusinessInbox())
      {
        paramMenu.add(0, R.id.menu_clear_business_inbox, 0, getString(R.string.menu_clear_business_inbox));
        return;
      }
      if (paramConversationLoaderEntity.isVlnConversation())
      {
        paramMenu.add(0, R.id.menu_clear_vln_inbox, 0, getString(R.string.menu_clear_vln_inbox));
        return;
      }
    }
    while (!b(paramConversationLoaderEntity));
    paramMenu.add(0, R.id.menu_delete_chat, 0, R.string.menu_delete_chat);
  }

  private void g(boolean paramBoolean)
  {
    if (this.n == null);
    do
    {
      return;
      if ((paramBoolean) && (this.n.getDivider() == null))
      {
        this.n.setDivider(this.ak);
        this.n.setDividerHeight(getResources().getDimensionPixelSize(R.dimen.formatted_separator_divider_height));
        return;
      }
    }
    while ((paramBoolean) || (this.n.getDivider() == null));
    this.n.setDivider(null);
  }

  protected boolean B_()
  {
    return true;
  }

  public void N_()
  {
    if (this.aq != null)
      this.aq.a(false);
  }

  protected com.viber.voip.messages.adapters.u a(Context paramContext, com.viber.provider.c<ConversationLoaderEntity> paramc, MessagesFragmentModeManager paramMessagesFragmentModeManager, boolean paramBoolean1, boolean paramBoolean2, LayoutInflater paramLayoutInflater, com.viber.voip.messages.adapters.a.e parame)
  {
    return new g(paramContext, paramc, paramMessagesFragmentModeManager, paramBoolean1, paramBoolean2, this.s, paramLayoutInflater, parame);
  }

  protected com.viber.voip.messages.conversation.n a(Bundle paramBundle, String paramString)
  {
    Bundle localBundle = getArguments();
    int i;
    int j;
    if ((localBundle != null) && (localBundle.getBoolean("show_public_accounts_only")))
    {
      i = 1;
      if ((localBundle == null) || (!localBundle.getBoolean("hide_public_accounts")))
        break label122;
      j = 1;
      label39: if (i == 0)
        break label128;
    }
    label128: for (n.a locala = n.a.h; ; locala = n.a.a)
    {
      o localo = new o(getActivity(), getLoaderManager(), this.j, true, true, locala, paramBundle, paramString, this, com.viber.voip.h.a.b(), (h)this.I.get(), this.s);
      localo.h(true);
      if (j != 0)
        localo.i(false);
      return localo;
      i = 0;
      break;
      label122: j = 0;
      break label39;
    }
  }

  public void a(com.getkeepsafe.taptargetview.b paramb)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      com.getkeepsafe.taptargetview.c.a(localFragmentActivity, paramb);
      this.H.a();
    }
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.am))
    {
      this.am = false;
      G();
    }
    super.a(paramConversationItemLoaderEntity, paramBoolean);
  }

  public void a(String paramString)
  {
    this.P = paramString;
    this.al.removeCallbacks(this.at);
    this.al.postDelayed(this.at, 200L);
  }

  protected void a(boolean paramBoolean, int paramInt)
  {
    super.a(paramBoolean, paramInt);
    if ((this.o != null) && (this.o.b() != null))
      this.an.a(paramBoolean, paramInt);
  }

  protected boolean a(int paramInt1, int paramInt2)
  {
    return (super.a(paramInt1, paramInt2)) || (paramInt2 == 2);
  }

  public void b(int paramInt)
  {
    boolean bool = true;
    ChatsTriggerPresenter localChatsTriggerPresenter;
    if (2 == paramInt)
    {
      this.O = bool;
      this.R.h();
      localChatsTriggerPresenter = this.ao;
      if (2 != paramInt)
        break label65;
    }
    while (true)
    {
      localChatsTriggerPresenter.b(bool);
      super.b(paramInt);
      return;
      if (this.ai == this.ae)
        break;
      this.P = null;
      E();
      break;
      label65: bool = false;
    }
  }

  protected void e(boolean paramBoolean)
  {
    if ((this.mIsTablet) && (!TextUtils.isEmpty(this.P)))
    {
      if (paramBoolean)
      {
        if (this.i <= 0L)
          break label70;
        Intent localIntent = com.viber.voip.messages.m.a(this.i, 1, false, false, false, true);
        localIntent.putExtra("clicked", false);
        if (this.E != null)
          this.E.a_(localIntent);
      }
      return;
      label70: G();
      super.e(true);
      return;
    }
    super.e(paramBoolean);
  }

  protected void h()
  {
    super.h();
    this.T.i();
    this.T.p();
    this.T.y_();
  }

  protected ListAdapter j()
  {
    com.b.a.a.a locala = this.W;
    Context localContext = getContext();
    if ((this.L != null) && (this.L.e()) && (localContext != null))
    {
      if (this.aq == null)
      {
        com.viber.voip.ads.b.c.a.c localc = new com.viber.voip.ads.b.c.a.c(localContext, null, this.L, this.n, this.W, null);
        this.aq = new q(localContext, locala, this.d, this.d.d(), localc, com.viber.voip.ads.b.b.b.c.i, this.M, R.layout.view_chat_list_ad_cell);
        this.aq.a(this.L.j());
      }
      return this.aq;
    }
    return locala;
  }

  protected void k()
  {
    if (this.ai == this.ae)
      C();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof ViberFragmentActivity))
      ((ViberFragmentActivity)localFragmentActivity).setupAndShowPinDialog(this);
    if ((this.o != null) && (this.o.b() != null))
      this.an.a(this.o.b());
    if (this.L != null)
    {
      this.L.b(this.n, this.W);
      this.L.a(this);
    }
  }

  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.search_in)
    {
      j localj = this.ai;
      if (this.af == this.ai);
      for (Object localObject = this.ag; ; localObject = this.af)
      {
        this.ai = ((j)localObject);
        this.P = w().t();
        this.W.a(this.d, false);
        if ((localj != null) && (localj != this.ai))
          localj.c();
        E();
        return;
      }
    }
    super.onClick(paramView);
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    if (!super.onContextItemSelected(paramMenuItem))
      return false;
    com.viber.voip.ui.g.d locald = a(((AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo()).targetView.getTag());
    if (locald == null)
      return super.onContextItemSelected(paramMenuItem);
    com.viber.voip.messages.adapters.a.a locala = (com.viber.voip.messages.adapters.a.a)locald.d();
    if (locala == null)
      return super.onContextItemSelected(paramMenuItem);
    ConversationLoaderEntity localConversationLoaderEntity = locala.a();
    int i = paramMenuItem.getItemId();
    boolean bool2;
    if (i == R.id.menu_mute_chat)
    {
      ai localai = (ai)this.k.get();
      Set localSet = Collections.singleton(Long.valueOf(localConversationLoaderEntity.getId()));
      if (!localConversationLoaderEntity.isMuteConversation())
      {
        bool2 = true;
        localai.a(localSet, bool2, localConversationLoaderEntity.getConversationType());
        com.viber.voip.analytics.story.e.c localc = (com.viber.voip.analytics.story.e.c)this.J.get();
        String str2 = ae.b();
        boolean bool3 = localConversationLoaderEntity.isMuteConversation();
        boolean bool4 = false;
        if (!bool3)
          bool4 = true;
        localc.a(str2, localConversationLoaderEntity, bool4);
      }
    }
    label363: boolean bool1;
    label382: 
    do
    {
      while (true)
      {
        return true;
        bool2 = false;
        break;
        if (i == R.id.menu_debug_options)
        {
          w().a(Collections.singleton(Long.valueOf(localConversationLoaderEntity.getId())));
        }
        else if (i == R.id.menu_snooze_chat)
        {
          d(localConversationLoaderEntity);
        }
        else if (i == R.id.menu_delete_chat)
        {
          ((com.viber.voip.analytics.story.e.c)this.J.get()).a(localConversationLoaderEntity);
          c(localConversationLoaderEntity);
        }
        else if (i == R.id.menu_clear_business_inbox)
        {
          F();
        }
        else if (i == R.id.menu_clear_vln_inbox)
        {
          b(localConversationLoaderEntity.getGroupingKey());
        }
        else
        {
          if (i != R.id.menu_move_to_business_inbox)
            break label363;
          this.y.e("To Business Inbox");
          ((ai)this.k.get()).a(localConversationLoaderEntity.getId(), localConversationLoaderEntity.getConversationType());
        }
      }
      if (i != R.id.menu_pin_chat)
        break label527;
      if (localConversationLoaderEntity.isFavouriteConversation())
        break label515;
      bool1 = true;
      ((ai)this.k.get()).a(localConversationLoaderEntity.getId(), bool1, localConversationLoaderEntity.getConversationType());
    }
    while (localConversationLoaderEntity.isBroadcastListType());
    int j;
    label427: String str1;
    if (bool1)
    {
      j = 0;
      str1 = "" + localConversationLoaderEntity.getId();
      if (!localConversationLoaderEntity.isGroupBehavior())
        break label705;
      str1 = "" + localConversationLoaderEntity.getGroupId();
    }
    label515: label527: label705: for (int k = 1; ; k = 0)
    {
      ViberApplication.getInstance().getEngine(false).getCdrController().handleReportPinToTop(j, k, str1);
      break;
      bool1 = false;
      break label382;
      j = 1;
      break label427;
      if ((i == R.string.menu_hide_chat) || (i == R.string.menu_unhide_chat))
      {
        Bundle localBundle = new Bundle();
        localBundle.putLong("conversation_id", localConversationLoaderEntity.getId());
        localBundle.putBoolean("conversation_hidden", localConversationLoaderEntity.isHiddenConversation());
        ViberActionRunner.aa.a(this, getChildFragmentManager(), o.a.h, localBundle);
        break;
      }
      if (i == R.string.mark_as_unread)
      {
        ((ai)this.k.get()).a(localConversationLoaderEntity.getId(), localConversationLoaderEntity.getConversationType(), true);
        break;
      }
      if (i == R.string.mark_as_read)
      {
        if (localConversationLoaderEntity.isMarkedAsUnreadConversation())
          ((ai)this.k.get()).a(localConversationLoaderEntity.getId(), localConversationLoaderEntity.getConversationType(), false);
        ((ai)this.k.get()).a(localConversationLoaderEntity);
        break;
      }
      return super.onContextItemSelected(paramMenuItem);
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.al = av.e.a.a();
    this.T = new com.viber.voip.contacts.d(getActivity(), getLoaderManager(), this.e, paramBundle, this.P, this);
    this.ao = new ChatsTriggerPresenter(new com.viber.voip.shareviber.chatstrigger.b(com.viber.common.permission.c.a(getActivity()), av.e.f.a(), av.e.a.a(), new com.viber.voip.g.b.b()
    {
      protected ab a()
      {
        return ab.b();
      }
    }
    , ViberApplication.getInstance().getLazyContactsQueryHelper(), d.r.F, e.a.n.d(), this.mIsTablet), new g(getContext()), ViberApplication.getInstance().getLazyContactsQueryHelper(), av.e.a.a());
    this.ap = c.f.e.e();
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    com.viber.voip.ui.g.d locald = a(((AdapterView.AdapterContextMenuInfo)paramContextMenuInfo).targetView.getTag());
    if (locald == null)
      return;
    ConversationLoaderEntity localConversationLoaderEntity = ((com.viber.voip.messages.adapters.a.a)locald.d()).a();
    if (localConversationLoaderEntity == null)
    {
      super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
      return;
    }
    a(paramContextMenu, localConversationLoaderEntity);
    a(paramContextMenu, localConversationLoaderEntity);
    d(paramContextMenu, localConversationLoaderEntity);
    c(paramContextMenu, localConversationLoaderEntity);
    e(paramContextMenu, localConversationLoaderEntity);
    b(paramContextMenu, localConversationLoaderEntity);
    f(paramContextMenu, localConversationLoaderEntity);
    a(paramContextMenu, localConversationLoaderEntity, (com.viber.voip.messages.controller.a.a)this.F.get());
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.ak = this.n.getDivider();
    com.viber.voip.e.a.e.b().a("APP START", "MessagesPublicAccountSearchAdapter");
    com.viber.voip.e.a.e.b().b("APP START", "MessagesPublicAccountSearchAdapter");
    this.V = new bh(getContext(), com.viber.voip.util.e.e.a(getContext()), paramLayoutInflater);
    this.U = new bi(getActivity(), this.mIsTablet, this.T.w(), this.T.u(), paramLayoutInflater);
    this.Y = ((SearchNoResultsView)paramLayoutInflater.inflate(R.layout.search_no_results_item, this.n, false));
    this.Z = paramLayoutInflater.inflate(R.layout.search_item_header, this.n, false);
    this.aa = this.Z.findViewById(R.id.top_divider);
    dj.b(this.aa, false);
    this.ab = ((TextView)this.Z.findViewById(R.id.label));
    this.X = ((SearchLabelView)paramLayoutInflater.inflate(R.layout.search_label_item, this.n, false));
    this.X.setShowBottomLine(true);
    this.ac = paramLayoutInflater.inflate(R.layout.load_more_participants_progress_layout, this.n, false);
    this.W = new com.b.a.a.a()
    {
      public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
      {
        View localView = super.getView(paramAnonymousInt, paramAnonymousView, paramAnonymousViewGroup);
        if (localView == null)
          localView = new View(bn.this.getActivity());
        return localView;
      }
    };
    this.W.a(this.X);
    this.W.a(this.Y);
    this.W.a(this.U);
    this.W.a(this.d);
    this.W.a(this.Z);
    this.W.b(this.Z, false);
    this.W.a(this.V);
    this.W.a(this.V, false);
    this.ad = new Space(getContext());
    this.ad.setLayoutParams(new AbsListView.LayoutParams(0, 0));
    this.W.a(this.ad);
    this.W.b(this.ad, false);
    this.W.a(this.ac);
    this.W.b(this.ac, false);
    Parcelable localParcelable1;
    int i;
    Parcelable localParcelable2;
    if (!this.mIsTablet)
    {
      com.viber.voip.shareviber.chatstrigger.i locali = new com.viber.voip.shareviber.chatstrigger.i(getContext(), this.W, getLayoutInflater());
      locali.c();
      locali.a(this);
      if (paramBundle == null)
      {
        localParcelable1 = null;
        this.ao.a(locali, localParcelable1);
      }
    }
    else
    {
      this.an = new com.viber.voip.ui.f.b(localView.getContext(), this.W, getResources().getDimensionPixelSize(R.dimen.messages_list_empty_view_under_fab_height));
      this.an.a();
      if (paramBundle != null)
      {
        i = paramBundle.getInt("search_state_id_extra", this.ae.a());
        localParcelable2 = paramBundle.getParcelable("search_state_parcelable_extra");
        if (i != this.af.a())
          break label665;
        this.ai = this.af;
      }
    }
    while (true)
    {
      if (localParcelable2 != null)
        this.ai.a(this.P, localParcelable2);
      this.X.setText(paramBundle.getString("search_in_text_extra"));
      this.U.a(((o)this.b).H());
      this.ai.b();
      FragmentActivity localFragmentActivity = getActivity();
      boolean bool = localFragmentActivity instanceof a;
      AppBarLayout localAppBarLayout = null;
      if (bool)
        localAppBarLayout = ((a)localFragmentActivity).b();
      this.K.attachViews(getListView(), localAppBarLayout);
      return localView;
      localParcelable1 = paramBundle.getParcelable("share_viber_chats_trigger");
      break;
      label665: if (i == this.ag.a())
        this.ai = this.ag;
      else if (i == this.ah.a())
        this.ai = this.ah;
    }
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.T.d())
      this.T.q();
    this.ao.a();
    this.an.b();
    this.H.b();
    this.K.detachViews();
    if (this.L != null)
    {
      this.L.m();
      this.L.b(this);
    }
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    boolean bool1 = true;
    boolean bool3;
    if (paramm.a(DialogCode.D_PIN))
      if ((-1 == paramInt) || (-3 == paramInt))
      {
        Bundle localBundle = ((Bundle)paramm.d()).getBundle("bundle_data");
        if (localBundle != null)
        {
          Long localLong = Long.valueOf(localBundle.getLong("conversation_id"));
          boolean bool2 = localBundle.getBoolean("conversation_hidden");
          if (localLong.longValue() != 0L)
          {
            ai localai = (ai)this.k.get();
            long l = localLong.longValue();
            if (bool2)
              break label138;
            bool3 = bool1;
            if ((localLong.longValue() != this.i) || (!this.mIsTablet))
              break label144;
            label125: localai.a(l, bool3, bool1);
          }
        }
      }
    label138: label144: ConversationLoaderEntity localConversationLoaderEntity;
    do
    {
      do
      {
        return;
        bool3 = false;
        break;
        bool1 = false;
        break label125;
      }
      while (!paramm.a(DialogCode.D2010a));
      localConversationLoaderEntity = (ConversationLoaderEntity)paramm.d();
    }
    while (localConversationLoaderEntity == null);
    switch (paramInt)
    {
    default:
      return;
    case -2:
      ((com.viber.voip.messages.controller.publicaccount.d)this.l.get()).a(localConversationLoaderEntity.getId(), false);
    case -1:
    }
    a(e(localConversationLoaderEntity));
  }

  public void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    super.onFragmentVisibilityChanged(paramBoolean);
    FragmentActivity localFragmentActivity = getActivity();
    if ((paramBoolean) && (localFragmentActivity != null))
      a(localFragmentActivity);
  }

  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return (!(paramView.getTag() instanceof g.a)) && (super.onItemLongClick(paramAdapterView, paramView, paramInt, paramLong));
  }

  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    this.ai.a(paramInt, localObject);
    if ((localObject instanceof g.a))
    {
      if (((this.mIsTablet) && (dj.c(getActivity()))) || (this.U.c()));
      for (boolean bool = true; ; bool = false)
      {
        this.am = bool;
        if (this.am)
        {
          MessagesFragmentModeManager localMessagesFragmentModeManager = w();
          if (localMessagesFragmentModeManager != null)
            localMessagesFragmentModeManager.z();
        }
        a(((g.a)paramView.getTag()).p);
        return;
      }
    }
    super.onListItemClick(paramListView, paramView, paramInt, paramLong);
  }

  public void onLoadFinished(com.viber.provider.d paramd, boolean paramBoolean)
  {
    if ((this.d == null) || (w() == null));
    final int i;
    do
    {
      do
      {
        return;
        super.onLoadFinished(paramd, paramBoolean);
        this.ai.a(paramd instanceof com.viber.voip.contacts.a);
      }
      while (paramd != this.b);
      this.R.i();
      this.H.a(this.n, this.d, this);
      if ((this.mIsTablet) && (paramd.getCount() == 0) && (this.N > 0))
        this.al.post(new bp(this));
      this.K.update(this.n.getFirstVisiblePosition(), paramd.getCount());
      i = this.d.getCount();
    }
    while ((this.aq == null) || (this.ar != -1) || (!com.viber.voip.util.u.a(this.b.E())));
    this.n.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        int i = bn.this.n.getChildCount();
        bn.this.n.removeOnLayoutChangeListener(this);
        if (i <= i);
        FragmentActivity localFragmentActivity;
        do
        {
          return;
          bn.a(bn.this, i + 1);
          bn.a(bn.this).a(bn.b(bn.this));
          localFragmentActivity = bn.this.getActivity();
        }
        while (localFragmentActivity == null);
        bn.a(bn.this, localFragmentActivity);
      }
    });
  }

  public void onLoaderReset(com.viber.provider.d paramd)
  {
    super.onLoaderReset(paramd);
    if ((paramd instanceof com.viber.voip.contacts.a))
      this.d.notifyDataSetChanged();
  }

  public void onPause()
  {
    super.onPause();
    if (this.L != null)
      this.L.k();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.am)
    {
      MessagesFragmentModeManager localMessagesFragmentModeManager = w();
      if (localMessagesFragmentModeManager != null)
        localMessagesFragmentModeManager.a(0);
    }
    if (this.T != null)
      this.T.a(paramBundle);
    paramBundle.putInt("search_state_id_extra", this.ai.a());
    if (this.ai.i() != null)
      paramBundle.putParcelable("search_state_parcelable_extra", this.ai.i());
    paramBundle.putString("search_in_text_extra", this.X.getText().toString());
    paramBundle.putParcelable("share_viber_chats_trigger", this.ao.c());
    super.onSaveInstanceState(paramBundle);
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (!a())
      this.K.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (!a())
      this.K.onScrollStateChanged(paramAbsListView, paramInt);
  }

  public void onStart()
  {
    if (this.b.b())
      this.b.c();
    super.onStart();
    this.ao.d();
  }

  public void onStop()
  {
    if (!TextUtils.isEmpty(w().t()))
      this.b.y_();
    if ((!this.mIsTablet) && (this.am))
    {
      this.am = false;
      G();
    }
    super.onStop();
  }

  protected f.a y()
  {
    return new f.a()
    {
      public boolean a()
      {
        return !bn.this.a();
      }

      public boolean b()
      {
        return cv.a().d() != 0;
      }
    };
  }

  public void z()
  {
    this.ao.b();
  }

  public static abstract interface a
  {
    public abstract AppBarLayout b();
  }

  private class b
    implements bn.c, bn.j
  {
    private final bn.h b = new bn.h()
    {
      public CommunitySearchResult a()
      {
        return br.a(this);
      }

      public void a(LongSparseSet paramAnonymousLongSparseSet)
      {
        br.a(this, paramAnonymousLongSparseSet);
      }

      public void a(Object paramAnonymousObject)
      {
        br.a(this, paramAnonymousObject);
      }

      public void a(String paramAnonymousString)
      {
        br.a(this, paramAnonymousString);
      }

      public void a(String paramAnonymousString, Parcelable paramAnonymousParcelable)
      {
        br.a(this, paramAnonymousString, paramAnonymousParcelable);
      }

      public void b()
      {
        br.b(this);
      }

      public void c()
      {
        br.c(this);
      }
    };
    private bn.h c = this.b;

    b()
    {
    }

    private int j()
    {
      ArrayList localArrayList = ((o)bn.this.b).H();
      if (localArrayList == null)
        return 0;
      return localArrayList.size();
    }

    public int a()
    {
      return 1;
    }

    public void a(int paramInt, Object paramObject)
    {
      if ((paramObject instanceof bh.a))
        this.c.a(paramObject);
    }

    public void a(String paramString)
    {
      if (bn.this.isAdded())
      {
        bn.d(bn.this).setText(bn.this.getString(R.string.search_in_messages_label, new Object[] { paramString }));
        bn.this.b.d(true);
        bn.this.b.c(true);
        bn.this.b.a(true);
        bn.this.b.b(true);
        bn.this.b.e(false);
        bn.b(bn.this, paramString);
        this.c.a(paramString);
      }
    }

    public void a(String paramString, Parcelable paramParcelable)
    {
      this.c.a(paramString, paramParcelable);
    }

    public void a(boolean paramBoolean)
    {
      o localo = (o)bn.this.b;
      int i = j();
      if (paramBoolean)
        if ((i == 0) && (bn.j(bn.this).getCount() == 0))
        {
          bn.e(bn.this).a(bn.c(bn.this), false);
          bn.this.d.a(com.viber.voip.messages.adapters.a.c.a.a.b);
          bn.c(bn.this).a(com.viber.voip.messages.adapters.a.c.a.a.b);
          bn.e(bn.this).a(bn.this.d, true);
          bn.c(bn.this).a(localo.H());
          bn.e(bn.this).b(bn.d(bn.this), true);
          bn.m(bn.this);
          bn.a(bn.this, false);
        }
      MessagesFragmentModeManager localMessagesFragmentModeManager;
      do
      {
        return;
        bn.e(bn.this).a(bn.c(bn.this), true);
        break;
        localMessagesFragmentModeManager = bn.this.w();
      }
      while (localMessagesFragmentModeManager == null);
      bn.j(bn.this).f(localo.J());
      bn.j(bn.this).c();
      bn.j(bn.this).a(localMessagesFragmentModeManager.t(), null);
      this.c.a(localo.I());
    }

    public String b(String paramString)
    {
      return bq.a(this, paramString);
    }

    public void b()
    {
      bn.e(bn.this).b(bn.f(bn.this), false);
      bn.i(bn.this).setText(R.string.search_more_communities_title);
      dj.b(bn.k(bn.this), true);
      bn.j(bn.this).y_();
      bn.d(bn.this).setOnClickListener(bn.this);
      if (bn.l(bn.this))
        if (this.c != this.b);
      for (this.c = new bn.i(bn.this, this); ; this.c = this.b)
      {
        this.c.b();
        return;
      }
    }

    public void c()
    {
      this.c.c();
    }

    public void d()
    {
      bn.e(bn.this).b(bn.d(bn.this), true);
    }

    public int e()
    {
      return 4;
    }

    public void f()
    {
      bq.a(this);
    }

    public void g()
    {
      bq.b(this);
    }

    public void h()
    {
      bq.c(this);
    }

    public Parcelable i()
    {
      return bs.b(this);
    }
  }

  private static abstract interface c
  {
    public abstract String b(String paramString);

    public abstract void d();

    public abstract int e();

    public abstract void f();

    public abstract void g();

    public abstract void h();
  }

  private class d
    implements bn.c, bn.j
  {
    private final bn.h b = new bn.i(bn.this, this);
    private View c;

    d()
    {
    }

    private View j()
    {
      if (this.c == null)
      {
        View localView = bn.this.getView();
        if (localView != null)
          this.c = ((ViewStub)localView.findViewById(R.id.no_con_stub)).inflate();
      }
      return this.c;
    }

    public int a()
    {
      return 3;
    }

    public void a(int paramInt, Object paramObject)
    {
      this.b.a(paramObject);
    }

    public void a(String paramString)
    {
      this.b.a(paramString);
    }

    public void a(String paramString, Parcelable paramParcelable)
    {
      this.b.a(paramString, paramParcelable);
    }

    public void a(boolean paramBoolean)
    {
    }

    public String b(String paramString)
    {
      return paramString.replaceFirst("@", "");
    }

    public void b()
    {
      bn.this.d.a(com.viber.voip.messages.adapters.a.c.a.a.a);
      bn.c(bn.this).a(com.viber.voip.messages.adapters.a.c.a.a.a);
      bn.this.b.d(false);
      bn.this.b.c(false);
      bn.this.b.a(false);
      bn.this.b.b(false);
      bn.this.b.e(false);
      bn.e(bn.this).b(bn.f(bn.this), false);
      bn.e(bn.this).a(bn.this.d, false);
      bn.e(bn.this).a(bn.c(bn.this), false);
      bn.e(bn.this).b(bn.p(bn.this), true);
      bn.this.b.y_();
      bn.j(bn.this).y_();
      bn.a(bn.this, false);
      bn.d(bn.this).setText(bn.this.getString(R.string.type_a_community_name));
      bn.d(bn.this).setOnClickListener(null);
      dj.b(bn.k(bn.this), false);
      bn.i(bn.this).setText(R.string.communities);
      if (this.b.a() == null)
        bn.e(bn.this).b(bn.d(bn.this), true);
      this.b.b();
    }

    public void c()
    {
      this.b.c();
      dj.c(this.c, 8);
      bn.e(bn.this).b(bn.p(bn.this), false);
    }

    public void d()
    {
      bn.e(bn.this).b(bn.d(bn.this), false);
    }

    public int e()
    {
      return 2;
    }

    public void f()
    {
      dj.c(this.c, 8);
    }

    public void g()
    {
      dj.c(j(), 0);
      bn.e(bn.this).b(bn.d(bn.this), false);
    }

    public void h()
    {
      dj.c(this.c, 8);
      bn.e(bn.this).b(bn.d(bn.this), true);
    }

    public Parcelable i()
    {
      return bs.b(this);
    }
  }

  private class e
    implements bn.j
  {
    private e()
    {
    }

    public int a()
    {
      return 0;
    }

    public void a(int paramInt, Object paramObject)
    {
    }

    public void a(String paramString)
    {
      bn.j(bn.this).y_();
      bn.a(bn.this, "");
    }

    public void a(String paramString, Parcelable paramParcelable)
    {
      bs.a(this, paramString, paramParcelable);
    }

    public void a(boolean paramBoolean)
    {
    }

    public void b()
    {
      bn.this.d.a(com.viber.voip.messages.adapters.a.c.a.a.a);
      bn.c(bn.this).a(com.viber.voip.messages.adapters.a.c.a.a.a);
      bn.this.b.d(false);
      bn.this.b.c(false);
      bn.this.b.a(false);
      bn.this.b.b(false);
      bn.this.b.e(false);
      bn.e(bn.this).b(bn.d(bn.this), false);
      bn.e(bn.this).b(bn.f(bn.this), false);
      bn.e(bn.this).a(bn.c(bn.this), false);
      bn.e(bn.this).a(bn.this.d, true);
      bn.a(bn.this, true);
      bn.this.b.c();
      bn.d(bn.this).setOnClickListener(null);
      bn.e(bn.this).a(bn.g(bn.this), false);
      bn.e(bn.this).b(bn.h(bn.this), false);
      bn.i(bn.this).setText("");
    }

    public void c()
    {
      bs.a(this);
    }

    public Parcelable i()
    {
      return bs.b(this);
    }
  }

  private class f
    implements bn.j
  {
    private f()
    {
    }

    public int a()
    {
      return 2;
    }

    public void a(int paramInt, Object paramObject)
    {
    }

    public void a(String paramString)
    {
      bn.d(bn.this).setText(bn.this.getString(R.string.search_in_chats_label, new Object[] { paramString }));
      bn.j(bn.this).y_();
      bn.this.b.d(false);
      bn.this.b.a(false);
      bn.this.b.b(false);
      bn.this.b.c(false);
      bn.this.b.e(true);
      bn.c(bn.this, paramString);
    }

    public void a(String paramString, Parcelable paramParcelable)
    {
      bs.a(this, paramString, paramParcelable);
    }

    public void a(boolean paramBoolean)
    {
      if (!paramBoolean)
      {
        bn.e(bn.this).a(bn.c(bn.this), false);
        bn.this.d.a(com.viber.voip.messages.adapters.a.c.a.a.c);
        bn.c(bn.this).a(com.viber.voip.messages.adapters.a.c.a.a.c);
        bn.e(bn.this).a(bn.this.d, true);
        bn.m(bn.this);
        bn.a(bn.this, false);
      }
    }

    public void b()
    {
      bn.e(bn.this).b(bn.d(bn.this), true);
      bn.e(bn.this).b(bn.f(bn.this), false);
      bn.j(bn.this).y_();
      bn.d(bn.this).setOnClickListener(bn.this);
    }

    public void c()
    {
      bs.a(this);
    }

    public Parcelable i()
    {
      return bs.b(this);
    }
  }

  private static class g extends com.viber.voip.messages.adapters.u
  {
    public g(Context paramContext, com.viber.provider.c<ConversationLoaderEntity> paramc, MessagesFragmentModeManager paramMessagesFragmentModeManager, boolean paramBoolean1, boolean paramBoolean2, dagger.a<ConferenceCallsRepository> parama, LayoutInflater paramLayoutInflater, com.viber.voip.messages.adapters.a.e parame)
    {
      super(paramc, paramMessagesFragmentModeManager, parama, paramBoolean1, paramBoolean2, paramLayoutInflater, parame);
    }

    protected boolean b()
    {
      return true;
    }
  }

  private static abstract interface h
  {
    public abstract CommunitySearchResult a();

    public abstract void a(LongSparseSet paramLongSparseSet);

    public abstract void a(Object paramObject);

    public abstract void a(String paramString);

    public abstract void a(String paramString, Parcelable paramParcelable);

    public abstract void b();

    public abstract void c();
  }

  private class i
    implements AbsListView.OnScrollListener, r.a, bn.h
  {
    private final bn.c b;
    private com.viber.voip.messages.controller.r c;
    private CommunitySearchResult d;
    private LongSparseSet e;
    private String f;

    i(bn.c arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    private void a(CommunitySearchResult paramCommunitySearchResult)
    {
      int i = 0;
      if ((this.d == null) || (this.d.getGroups() == null))
        return;
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(this.d.getGroups().size() + paramCommunitySearchResult.getGroups().size());
      int j = this.d.getGroups().size();
      for (int k = 0; k < j; k++)
      {
        Group localGroup2 = (Group)this.d.getGroups().get(k);
        localLinkedHashMap.put(localGroup2.getId(), localGroup2);
      }
      int m = paramCommunitySearchResult.getGroups().size();
      while (i < m)
      {
        Group localGroup1 = (Group)paramCommunitySearchResult.getGroups().get(i);
        localLinkedHashMap.put(localGroup1.getId(), localGroup1);
        i++;
      }
      this.d.getGroups().clear();
      this.d.getGroups().addAll(localLinkedHashMap.values());
    }

    private void a(List<Group> paramList, String paramString)
    {
      if ((!com.viber.voip.util.u.a(this.e)) && (!com.viber.voip.util.u.a(paramList)))
      {
        ArrayList localArrayList = new ArrayList(paramList.size());
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          Group localGroup = (Group)localIterator.next();
          try
          {
            long l = Long.parseLong(localGroup.getId());
            if (!this.e.contains(l))
              localArrayList.add(localGroup);
          }
          catch (NumberFormatException localNumberFormatException)
          {
          }
        }
        paramList = localArrayList;
      }
      if (com.viber.voip.util.u.a(paramList))
      {
        f();
        return;
      }
      bn.e(bn.this).b(bn.h(bn.this), true);
      bn.g(bn.this).a(paramString, paramList);
      this.b.d();
    }

    private boolean d()
    {
      if (this.d == null)
        return true;
      if (this.d.getGroups() != null);
      for (int i = this.d.getGroups().size(); ; i = 0)
      {
        int j = this.d.getTotalHits();
        boolean bool = false;
        if (j > i)
          bool = true;
        return bool;
      }
    }

    private void e()
    {
      this.d = null;
      bn.g(bn.this).a();
      bn.e(bn.this).b(bn.n(bn.this), false);
      bn.e(bn.this).b(bn.h(bn.this), false);
      this.b.g();
    }

    private void f()
    {
      this.d = null;
      bn.g(bn.this).a();
      bn.e(bn.this).b(bn.n(bn.this), false);
      bn.e(bn.this).b(bn.h(bn.this), false);
      this.b.h();
    }

    private com.viber.voip.messages.controller.r g()
    {
      if (this.c == null)
        this.c = ((com.viber.voip.messages.controller.r)bn.this.G.get());
      return this.c;
    }

    public CommunitySearchResult a()
    {
      return this.d;
    }

    public void a(LongSparseSet paramLongSparseSet)
    {
      if (!com.viber.voip.util.u.a(this.e, paramLongSparseSet))
      {
        this.e = paramLongSparseSet;
        if ((this.d != null) && (this.f != null))
          a(this.d.getGroups(), this.b.b(this.f));
      }
    }

    public void a(Object paramObject)
    {
      if (!(paramObject instanceof bh.a));
      final Group localGroup;
      do
      {
        return;
        localGroup = ((bh.a)paramObject).a();
      }
      while (localGroup == null);
      try
      {
        long l = Long.parseLong(localGroup.getId());
        new ad(bn.this.requireContext(), ab.b(), av.e.d.a(), l, 0)
        {
          protected void e()
          {
            CommunityFollowerData localCommunityFollowerData = new CommunityFollowerData(localGroup, this.b.getName(), dx.g(this.b.getIcn()), this.b.getTagln(), 0L, UserManager.from(bn.this.getContext()).getUserData().getViberName(), this.b.getFl(), 2, 0);
            ((com.viber.voip.analytics.story.e.c)bn.this.J.get()).a(localGroup, "Search");
            l.a(localCommunityFollowerData, dj.e(bn.this.requireActivity())).b(bn.this);
          }
        }
        .h();
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    }

    public void a(String paramString)
    {
      int i = 20;
      int j;
      if (!paramString.equals(this.f))
      {
        j = 1;
        String str = this.f;
        this.f = paramString;
        if ((str != null) || (this.d == null))
          break label45;
      }
      label45: 
      while ((j == 0) && (!d()))
      {
        return;
        j = 0;
        break;
      }
      int k;
      if ((j != 0) || (this.d == null))
        k = 1;
      while (true)
      {
        g().a(this.b.b(paramString), k, i, this.b.e(), this);
        return;
        k = 1 + this.d.getGroups().size();
        i = Math.min(this.d.getTotalHits() - this.d.getGroups().size(), i);
      }
    }

    public void a(String paramString, Parcelable paramParcelable)
    {
      a(paramString, (CommunitySearchResult)paramParcelable, true);
    }

    public void a(String paramString, CommunitySearchResult paramCommunitySearchResult, boolean paramBoolean)
    {
      if ((paramBoolean) || (this.d == null) || (this.d.getGroups() == null))
        this.d = paramCommunitySearchResult;
      while (true)
      {
        this.b.f();
        bn.e(bn.this).b(bn.n(bn.this), d());
        a(this.d.getGroups(), paramString);
        return;
        if (paramCommunitySearchResult.getGroups() != null)
          a(paramCommunitySearchResult);
      }
    }

    public void a(String paramString, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        f();
        return;
      }
      e();
    }

    public void b()
    {
      bn.e(bn.this).a(bn.g(bn.this), true);
      bn.this.n.a(this);
    }

    public void c()
    {
      this.d = null;
      bn.g(bn.this).a();
      this.e = null;
      g().a();
      bn.e(bn.this).b(bn.n(bn.this), false);
      bn.e(bn.this).a(bn.g(bn.this), false);
      bn.e(bn.this).b(bn.h(bn.this), false);
      bn.this.n.b(this);
    }

    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      if ((paramInt1 + paramInt2 == paramInt3) && (this.d != null) && (d()))
        a(bn.o(bn.this));
    }

    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
    }
  }

  private static abstract interface j
  {
    public abstract int a();

    public abstract void a(int paramInt, Object paramObject);

    public abstract void a(String paramString);

    public abstract void a(String paramString, Parcelable paramParcelable);

    public abstract void a(boolean paramBoolean);

    public abstract void b();

    public abstract void c();

    public abstract Parcelable i();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.bn
 * JD-Core Version:    0.6.2
 */