package com.viber.voip.messages.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.util.LongSparseArray;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.provider.d.a;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.aa;
import com.viber.voip.ab;
import com.viber.voip.analytics.story.b.a.h.a.a;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.block.g.a;
import com.viber.voip.contacts.ui.ContactsComposeCombinedActivity;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.a.d.c;
import com.viber.voip.messages.a.d.e;
import com.viber.voip.messages.adapters.u;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.ai;
import com.viber.voip.messages.conversation.n;
import com.viber.voip.messages.conversation.n.a;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.conversation.ui.ck;
import com.viber.voip.messages.m;
import com.viber.voip.messages.ui.forward.ForwardActivity;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.ui.ViberListView;
import com.viber.voip.ui.ac;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.i;
import com.viber.voip.ui.o.a;
import com.viber.voip.ui.x;
import com.viber.voip.ui.x.a;
import com.viber.voip.ui.x.b;
import com.viber.voip.util.ViberActionRunner.bc;
import com.viber.voip.util.ViberActionRunner.d;
import com.viber.voip.util.ViberActionRunner.k;
import com.viber.voip.util.ViberActionRunner.r;
import com.viber.voip.util.ViberActionRunner.s;
import com.viber.voip.util.cj;
import com.viber.voip.util.dj;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@SuppressLint({"ValidFragment"})
public class bk extends h
  implements View.OnClickListener, AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, d.a, com.viber.voip.messages.adapters.c.b, MessagesFragmentModeManager.c, com.viber.voip.messages.ui.forward.e, x.a, x.b
{
  private static a I = new a()
  {
    public void a(int paramAnonymousInt, Fragment paramAnonymousFragment)
    {
    }

    public void a_(Intent paramAnonymousIntent)
    {
    }
  };
  private static com.viber.voip.messages.ui.forward.f J = new com.viber.voip.messages.ui.forward.f()
  {
    public void a()
    {
    }

    public void a(String paramAnonymousString)
    {
    }
  };
  protected static final Logger a = ViberEnv.getLogger();

  @Inject
  dagger.a<com.viber.voip.analytics.story.b.a.h> A;

  @Inject
  com.viber.voip.messages.adapters.a.e B;

  @Inject
  dagger.a<com.viber.voip.messages.controller.cl> C;
  protected com.viber.voip.messages.ui.forward.f D = J;
  protected a E = I;
  private String F;
  private boolean G;
  private final EventBus H = com.viber.voip.h.a.b();
  protected n b;
  protected com.viber.voip.messages.conversation.j c;
  protected u d;
  protected dagger.a<com.viber.voip.contacts.c.d.g> e;
  protected x m;
  protected ViberListView n;
  protected i o;
  protected boolean p;
  protected boolean q;

  @Inject
  protected dagger.a<CallHandler> r;

  @Inject
  protected dagger.a<ConferenceCallsRepository> s;

  @Inject
  dagger.a<cj> t;

  @Inject
  dagger.a<Engine> u;

  @Inject
  dagger.a<com.viber.voip.notif.g> v;

  @Inject
  ICdrController w;

  @Inject
  com.viber.voip.analytics.story.b.c x;

  @Inject
  com.viber.voip.analytics.story.a.a y;

  @Inject
  dagger.a<com.viber.voip.analytics.g> z;

  public bk()
  {
    super(0);
  }

  private void A()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null)
      return;
    this.o = new i(localFragmentActivity.getWindow().getDecorView(), R.id.fab_compose, new bl(this));
  }

  private void B()
  {
    startActivity(new Intent(getActivity(), ContactsComposeCombinedActivity.class));
  }

  private void C()
  {
    a(isVisible(), a());
  }

  private void E()
  {
    this.d.a();
    Iterator localIterator = ((com.viber.voip.messages.controller.cl)this.C.get()).b().entrySet().iterator();
    while (localIterator.hasNext())
    {
      com.viber.voip.messages.conversation.ui.cl localcl = (com.viber.voip.messages.conversation.ui.cl)((Map.Entry)localIterator.next()).getValue();
      this.d.a(localcl.a().a(), localcl.b(), localcl.a(), true);
    }
    LongSparseArray localLongSparseArray = ((com.viber.voip.messages.controller.cl)this.C.get()).a();
    int i = localLongSparseArray.size();
    for (int j = 0; j < i; j++)
    {
      long l = localLongSparseArray.keyAt(j);
      Map localMap = (Map)localLongSparseArray.valueAt(j);
      this.d.a(l, localMap.values());
    }
    this.d.notifyDataSetChanged();
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    i locali;
    if (this.o != null)
    {
      locali = this.o;
      if ((!paramBoolean1) || (paramBoolean2) || (this.G))
        break label37;
    }
    label37: for (boolean bool = true; ; bool = false)
    {
      locali.a(bool);
      return;
    }
  }

  private boolean a(Intent paramIntent, boolean paramBoolean)
  {
    if ((this.f) && (this.E != null))
    {
      paramIntent.putExtra("clicked", true);
      if (paramBoolean)
        paramIntent.putExtra("extra_forward_compose", true);
      this.E.a_(paramIntent);
      return true;
    }
    return false;
  }

  private void b(Bundle paramBundle, String paramString)
  {
    this.b = a(paramBundle, paramString);
    this.c = new com.viber.voip.messages.conversation.j(getActivity(), getLoaderManager(), this.e, this);
  }

  private int c(int paramInt)
  {
    int i = this.b.getCount();
    if ((!this.p) || ((i == 0) && (!this.q) && (paramInt != 2)));
    for (int j = 1; j != 0; j = 0)
      return 0;
    if (a(i, paramInt))
      return 1;
    if ((this.c != null) && (this.c.getCount() > 0))
      return 2;
    return 3;
  }

  private void z()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.f = localBundle.getBoolean("open_for_forward");
      this.g = localBundle.getBoolean("forward_formatted_message_extra");
    }
  }

  protected Intent a(int paramInt, ConversationLoaderEntity paramConversationLoaderEntity)
  {
    switch (paramInt)
    {
    default:
      return m.a(new ConversationData(paramConversationLoaderEntity, "", false), false);
    case 1:
      String str = w().t();
      if ((this.f) || (!this.b.A()))
        return m.a(new ConversationData(paramConversationLoaderEntity, "", true), true);
      return m.a(new ConversationData(paramConversationLoaderEntity, str, true), false).putExtra("extra_search_message", true);
    case 2:
      this.w.handleReportScreenDisplay(4, 1);
      this.y.c("Chat List");
      return ViberActionRunner.k.a(getActivity());
    case 3:
    }
    return ViberActionRunner.bc.a(getActivity(), paramConversationLoaderEntity.getToNumber());
  }

  protected u a(Context paramContext, com.viber.provider.c<ConversationLoaderEntity> paramc, MessagesFragmentModeManager paramMessagesFragmentModeManager, boolean paramBoolean1, boolean paramBoolean2, LayoutInflater paramLayoutInflater, com.viber.voip.messages.adapters.a.e parame)
  {
    return new u(paramContext, paramc, paramMessagesFragmentModeManager, null, paramBoolean1, paramBoolean2, getLayoutInflater(), parame);
  }

  protected n a(Bundle paramBundle, String paramString)
  {
    FragmentActivity localFragmentActivity = getActivity();
    LoaderManager localLoaderManager = getLoaderManager();
    dagger.a locala = this.j;
    boolean bool;
    if (!this.f)
    {
      bool = true;
      if (!this.g)
        break label69;
    }
    label69: for (n.a locala1 = n.a.b; ; locala1 = n.a.a)
    {
      return new ai(localFragmentActivity, localLoaderManager, locala, true, bool, locala1, paramBundle, paramString, this, com.viber.voip.h.a.b());
      bool = false;
      break;
    }
  }

  protected String a(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    if (this.f);
    for (int i = R.string.search_recent_conversations; ; i = R.string.menu_search)
      return localResources.getString(i);
  }

  protected void a(int paramInt)
  {
    this.E.a(paramInt, this);
  }

  public void a(long paramLong1, ConferenceInfo paramConferenceInfo, long paramLong2)
  {
    if (((cj)this.t.get()).a() == -1)
    {
      ad.a().b(this);
      return;
    }
    if (((Engine)this.u.get()).getServiceState() != ServiceStateDelegate.ServiceState.SERVICE_CONNECTED)
    {
      com.viber.voip.ui.dialogs.f.d().b(this);
      return;
    }
    ((CallHandler)this.r.get()).handleJoinOngoingAudioConference(paramLong1, paramConferenceInfo, paramLong2);
    ((com.viber.voip.notif.g)this.v.get()).b().a(paramLong1, paramLong2);
    this.x.c("Chat List");
  }

  protected void a(View paramView)
  {
    com.viber.voip.e.a.e.b().a("UI", "EmptyView init");
    b(paramView);
    this.m.a(paramView, this, this, this);
    this.m.a(this);
    com.viber.voip.e.a.e.b().b("UI", "EmptyView init");
  }

  public void a(View paramView, int paramInt)
  {
    com.viber.voip.model.c localc = this.c.e(paramInt);
    if ((localc != null) && (localc.n() != null))
    {
      com.viber.voip.model.j localj = localc.n();
      Intent localIntent = m.a(localj.a(), localj.c(), localc.k(), false, false, false, false);
      if (!a(localIntent, false))
        getActivity().startActivity(localIntent);
    }
  }

  public void a(final ListView paramListView, final View paramView, final int paramInt, long paramLong, final boolean paramBoolean)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (paramInt != u()))
      dj.d(localFragmentActivity);
    if (!w().l())
    {
      if (!this.f)
        break label159;
      com.viber.voip.ui.g.d locald = a(paramView.getTag());
      if (locald == null)
        return;
      com.viber.voip.messages.adapters.a.a locala = (com.viber.voip.messages.adapters.a.a)locald.d();
      if (locala.a().isGroupBehavior())
        break label147;
      ConversationLoaderEntity localConversationLoaderEntity = locala.a();
      com.viber.voip.block.g.a(getActivity(), new Member(localConversationLoaderEntity.getParticipantMemberId(), localConversationLoaderEntity.getNumber(), null, localConversationLoaderEntity.getParticipantName(), null), new g.a()
      {
        public void a()
        {
          com.viber.voip.block.h.a(this);
        }

        public void a(Set<Member> paramAnonymousSet)
        {
          bk.this.a(paramListView, paramView, paramInt, paramBoolean);
        }
      });
    }
    while (true)
    {
      super.onListItemClick(paramListView, paramView, paramInt, paramLong);
      return;
      label147: a(paramListView, paramView, paramInt, paramBoolean);
      continue;
      label159: a(paramListView, paramView, paramInt, paramBoolean);
    }
  }

  public void a(com.viber.voip.messages.adapters.a.a parama, boolean paramBoolean)
  {
    ConversationLoaderEntity localConversationLoaderEntity = parama.a();
    Intent localIntent;
    if ((w().k()) && (!TextUtils.isEmpty(w().t())))
    {
      localIntent = a(1, localConversationLoaderEntity);
      w().s();
    }
    while (true)
    {
      localIntent.putExtra("clicked", paramBoolean);
      localIntent.setExtrasClassLoader(getActivity().getClassLoader());
      this.i = parama.i();
      this.d.a(this.i);
      if (this.E != null)
        this.E.a_(localIntent);
      return;
      if (localConversationLoaderEntity.isInBusinessInbox())
        localIntent = a(2, localConversationLoaderEntity);
      else if (localConversationLoaderEntity.isVlnConversation())
        localIntent = a(3, localConversationLoaderEntity);
      else
        localIntent = a(0, localConversationLoaderEntity);
    }
  }

  public void a(ConversationLoaderEntity paramConversationLoaderEntity)
  {
    if ((paramConversationLoaderEntity.isGroupCallType()) && (paramConversationLoaderEntity.hasConferenceInfo()));
    for (int i = 1; i != 0; i = 0)
    {
      ConferenceInfo localConferenceInfo = paramConversationLoaderEntity.getConferenceInfo();
      startActivity(ViberActionRunner.r.a(requireActivity(), localConferenceInfo, paramConversationLoaderEntity.getId(), "Chat List"));
      return;
    }
    Member localMember = Member.from(paramConversationLoaderEntity);
    boolean bool = paramConversationLoaderEntity.isMissedVideoCall();
    ((CallHandler)this.r.get()).handleDialViber(localMember, bool);
    com.viber.voip.analytics.story.b.a.h localh = (com.viber.voip.analytics.story.b.a.h)this.A.get();
    h.a.a locala1 = com.viber.voip.analytics.story.b.a.h.a.i();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramConversationLoaderEntity.getNumber();
    h.a.a locala2 = locala1.a(arrayOfString);
    if (bool);
    for (String str = "Free Video"; ; str = "Free Audio 1-On-1 Call")
    {
      localh.a(locala2.b(str).a("Chat List").a(true).a());
      return;
    }
  }

  public void a(String paramString)
  {
    this.D.a(paramString);
    if (this.b != null)
    {
      this.p = false;
      this.b.f(paramString);
    }
  }

  public void a(boolean paramBoolean)
  {
    a(isVisible(), paramBoolean);
  }

  protected boolean a(int paramInt1, int paramInt2)
  {
    return paramInt1 > 0;
  }

  protected x b()
  {
    return new x();
  }

  public void b(long paramLong)
  {
    if (this.d != null)
      this.d.a(paramLong);
  }

  public void b(Context paramContext)
  {
    Intent localIntent = ViberActionRunner.d.a(paramContext.getString(R.string.select_contacts));
    localIntent.addFlags(268435456);
    if (!a(localIntent, true))
      B();
  }

  public boolean c()
  {
    return (this.b != null) && (this.b.d());
  }

  protected boolean d()
  {
    return true;
  }

  protected void e()
  {
    if ((!this.Q) || (w() == null));
    int i;
    View localView;
    int j;
    do
    {
      return;
      i = w().j();
      localView = getView();
      j = c(i);
    }
    while ((localView == null) || ((j == 0) && (!this.S)) || ((j == 1) && (this.m == null)));
    if (this.m == null)
    {
      this.m = b();
      a(localView);
    }
    this.m.a(j, i, getActivity() instanceof ForwardActivity, this.c);
  }

  protected void e(boolean paramBoolean)
  {
    if ((this.d.getCount() == 0) && (this.mIsTablet) && (!this.f))
      this.i = 0L;
    if (this.i > 0L)
    {
      long l = this.i;
      if (!this.f);
      for (boolean bool = true; ; bool = false)
      {
        a(l, bool, true);
        return;
      }
    }
    D();
  }

  protected void f()
  {
    if (!this.b.d())
    {
      this.b.i();
      this.b.p();
    }
  }

  public void f(boolean paramBoolean)
  {
    this.G = paramBoolean;
    C();
  }

  public ListAdapter getListAdapter()
  {
    return this.d;
  }

  public ListView getListView()
  {
    return this.n;
  }

  protected void h()
  {
    i();
    f();
  }

  protected void i()
  {
    if ((this.c != null) && (!this.c.d()))
    {
      this.c.i();
      this.c.p();
    }
  }

  protected ListAdapter j()
  {
    return this.d;
  }

  protected void k()
  {
    this.d.notifyDataSetChanged();
  }

  public boolean l()
  {
    if ((w() != null) && (w().k()))
    {
      w().b(true);
      return true;
    }
    return false;
  }

  public void m()
  {
    if (this.d != null)
      this.d.notifyDataSetChanged();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (r())
      dj.a(getListView(), 1);
    this.n.setAdapter(j());
    if (aa.a(this))
      A();
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
    FragmentActivity localFragmentActivity = getActivity();
    Fragment localFragment;
    if (!(localFragmentActivity instanceof a))
    {
      localFragment = getParentFragment();
      if (!(localFragment instanceof a))
        throw new ClassCastException("MessagesFragment.Callbacks is not implemented!");
    }
    for (this.E = ((a)localFragment); ; this.E = ((a)localFragmentActivity))
    {
      if ((localFragmentActivity instanceof com.viber.voip.messages.ui.forward.f))
        this.D = ((com.viber.voip.messages.ui.forward.f)localFragmentActivity);
      return;
    }
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.compose_btn)
      b(getActivity());
    while (i != R.id.say_hi_to_friends_link)
      return;
    ViberActionRunner.s.a(getActivity());
  }

  public void onCreate(Bundle paramBundle)
  {
    z();
    super.onCreate(paramBundle);
    setHasOptionsMenu(d());
    this.e = ViberApplication.getInstance().getLazyContactManager();
    this.B.a(this);
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((!g()) || (localFragmentActivity == null));
    do
    {
      return;
      paramMenuInflater.inflate(R.menu.menu_messages, paramMenu);
      if (this.f)
        paramMenu.findItem(R.id.menu_search).setVisible(true);
      super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    }
    while ((!this.f) || (w() == null));
    if ((!TextUtils.isEmpty(this.F)) || (this.h))
      w().a(this.F);
    w().y();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.fragment_messages, paramViewGroup, false);
    this.m = null;
    this.n = ((ViberListView)localView.findViewById(16908298));
    this.n.setOnTouchListener(this);
    this.n.setOnItemLongClickListener(this);
    this.n.setOnItemClickListener(this);
    this.n.a(this);
    this.n.setScrollingCacheEnabled(false);
    this.n.setOnCreateContextMenuListener(this);
    if (com.viber.common.d.a.g())
      this.n.setNestedScrollingEnabled(true);
    String str;
    if (paramBundle != null)
    {
      this.f = paramBundle.getBoolean("open_for_forward", this.f);
      this.g = paramBundle.getBoolean("forward_formatted_message_extra", this.g);
      MessagesFragmentModeManager.MessagesFragmentModeManagerData localMessagesFragmentModeManagerData = (MessagesFragmentModeManager.MessagesFragmentModeManagerData)paramBundle.getParcelable("mode_manager");
      if (localMessagesFragmentModeManagerData != null)
        str = localMessagesFragmentModeManagerData.getSavedQuery();
    }
    while (true)
    {
      b(paramBundle, str);
      this.d = a(getActivity(), this.b, w(), this.f, this.mIsTablet, getLayoutInflater(), this.B);
      this.n.a(this.d);
      return localView;
      str = null;
      continue;
      str = null;
    }
  }

  public void onDestroyView()
  {
    this.b.q();
    this.b.j();
    if (this.c != null)
      this.c.q();
    super.onDestroyView();
  }

  public void onDetach()
  {
    if (w() != null)
    {
      this.D.a(w().t());
      if (w().x() != null)
        w().x().c(true);
    }
    super.onDetach();
  }

  public void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    super.onFragmentVisibilityChanged(paramBoolean);
    a(paramBoolean, a());
    FragmentActivity localFragmentActivity = getActivity();
    if ((paramBoolean) && ((localFragmentActivity instanceof ab)))
      ((ab)localFragmentActivity).h();
    if (this.d != null)
      this.d.a(paramBoolean);
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onGroupUserIsTyping(d.c paramc)
  {
    this.d.a(paramc.a, paramc.b);
    this.d.notifyDataSetChanged();
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    onListItemClick((ListView)paramAdapterView, paramView, paramInt, paramLong);
  }

  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }

  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    a(paramListView, paramView, paramInt, paramLong, true);
  }

  public void onLoadFinished(com.viber.provider.d paramd, boolean paramBoolean)
  {
    if ((this.d == null) && (getActivity() != null) && (!getActivity().isFinishing()))
      return;
    if ((paramd instanceof n))
    {
      k();
      this.p = true;
      MessagesFragmentModeManager localMessagesFragmentModeManager = w();
      boolean bool = false;
      if (localMessagesFragmentModeManager != null)
      {
        w().p();
        if ((!this.f) && (!w().l()))
          e(paramBoolean);
        bool = w().k();
      }
      if (!bool)
        this.H.postSticky(new com.viber.voip.ui.e.b(this.b.getCount()));
    }
    while (true)
    {
      e();
      return;
      if ((paramd instanceof com.viber.voip.messages.conversation.j))
        this.q = true;
    }
  }

  public void onLoaderReset(com.viber.provider.d paramd)
  {
  }

  public void onPause()
  {
    super.onPause();
    this.H.unregister(this);
  }

  public void onResume()
  {
    super.onResume();
    E();
    if (!this.H.isRegistered(this))
      this.H.register(this);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (g())
    {
      this.b.a(paramBundle);
      paramBundle.putBoolean("open_for_forward", this.f);
      paramBundle.putBoolean("forward_formatted_message_extra", this.g);
    }
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onUserIsTyping(d.e parame)
  {
    this.d.a(parame.a.a(), parame.b, parame.a, parame.c);
    this.d.notifyDataSetChanged();
  }

  public boolean p()
  {
    return (this.d != null) && (this.d.getCount() > 0);
  }

  public void q()
  {
    if (this.f)
      av.a(av.e.a).post(new Runnable()
      {
        public void run()
        {
          if ((!bk.a(bk.this)) && (TextUtils.isEmpty(dj.a((AppCompatActivity)bk.this.getActivity()))))
            dj.a((AppCompatActivity)bk.this.getActivity(), "");
        }
      });
  }

  public boolean r()
  {
    FragmentActivity localFragmentActivity = getActivity();
    return (localFragmentActivity == null) || ((localFragmentActivity instanceof ConversationActivity));
  }

  public Map<Long, MessagesFragmentModeManager.b> s()
  {
    return this.b.B();
  }

  public void setSearchQuery(String paramString)
  {
    this.F = paramString;
  }

  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (this.b != null)
    {
      if (!paramBoolean)
        break label42;
      this.b.c();
    }
    while (true)
    {
      if (this.c != null)
      {
        if (!paramBoolean)
          break;
        this.c.c();
      }
      return;
      label42: this.b.y_();
    }
    this.c.y_();
  }

  public static abstract interface a extends o.a
  {
    public abstract void a_(Intent paramIntent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.bk
 * JD-Core Version:    0.6.2
 */