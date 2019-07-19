package com.viber.voip.calls.ui;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.Engine.InitializedListener;
import com.viber.jni.dialer.DialerController;
import com.viber.provider.d.a;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.b.a.h;
import com.viber.voip.analytics.story.b.a.h.a;
import com.viber.voip.analytics.story.b.a.h.a.a;
import com.viber.voip.au;
import com.viber.voip.contacts.ui.ContactDetailsFragment.c;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.messages.ui.view.SearchNoResultsView;
import com.viber.voip.model.AggregatedCall;
import com.viber.voip.model.j;
import com.viber.voip.permissions.e;
import com.viber.voip.permissions.m;
import com.viber.voip.permissions.n;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallInitiationId;
import com.viber.voip.phone.call.InCallState;
import com.viber.voip.settings.d.m;
import com.viber.voip.sound.ISoundService;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.ui.MenuSearchMediator;
import com.viber.voip.ui.ViberListView;
import com.viber.voip.ui.ab;
import com.viber.voip.ui.ac.a;
import com.viber.voip.ui.o.a;
import com.viber.voip.util.ViberActionRunner.o;
import com.viber.voip.util.ViberActionRunner.r;
import com.viber.voip.util.dj;
import com.viber.voip.widget.PhoneTypeField.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.webrtc.videoengine.EngineDelegate;
import org.webrtc.videoengine.EngineDelegate.VideoEngineEventSubscriber;

public class RecentCallsFragment extends com.viber.voip.ui.o
  implements AbsListView.OnScrollListener, AdapterView.OnItemLongClickListener, Engine.InitializedListener, d.a, RecentCallsFragmentModeManager.a, m.a, ContactDetailsFragment.c, ac.a, PhoneTypeField.a
{
  private static final Logger h = ViberEnv.getLogger();
  private static a x = new a()
  {
    public void a(int paramAnonymousInt, Fragment paramAnonymousFragment)
    {
    }

    public void h(Intent paramAnonymousIntent)
    {
    }
  };
  private boolean A;
  private boolean B;
  protected com.b.a.a.a a;
  protected com.viber.voip.calls.c b;
  protected MenuSearchMediator c;
  Map<com.viber.provider.d, Boolean> d = new HashMap();

  @Inject
  dagger.a<com.viber.voip.analytics.story.b.c> e;

  @Inject
  dagger.a<h> f;
  b g;
  private o i;
  private View j;
  private boolean k;
  private ab l;
  private dagger.a<ISoundService> m;
  private IRingtonePlayer n;
  private boolean o;
  private RecentCallsFragmentModeManager p;
  private RecentCallsFragmentModeManager.RecentCallsFragmentModeManagerData q = null;
  private View r;
  private SearchNoResultsView s;
  private MenuItem t;
  private boolean u = false;
  private com.viber.common.permission.c v;
  private final com.viber.common.permission.b w;
  private a y;
  private EngineDelegate.VideoEngineEventSubscriber z;

  public RecentCallsFragment()
  {
    super(1);
    Pair[] arrayOfPair = new Pair[3];
    arrayOfPair[0] = m.a(54);
    arrayOfPair[1] = m.a(34);
    arrayOfPair[2] = m.a(43);
    this.w = new e(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
        case 54:
        case 34:
        case 43:
        }
        do
        {
          do
          {
            do
              return;
            while (!(paramAnonymousObject instanceof RecentCallsFragment.MemberActionInfo));
            RecentCallsFragment.this.a((RecentCallsFragment.MemberActionInfo)paramAnonymousObject, false, false);
            return;
          }
          while (!(paramAnonymousObject instanceof RecentCallsFragment.MemberActionInfo));
          RecentCallsFragment.this.a((RecentCallsFragment.MemberActionInfo)paramAnonymousObject, false, true);
          return;
        }
        while (!(paramAnonymousObject instanceof RecentCallsFragment.MemberActionInfo));
        RecentCallsFragment.this.a((RecentCallsFragment.MemberActionInfo)paramAnonymousObject, true, false);
      }
    };
    this.y = x;
    this.z = new EngineDelegate.VideoEngineEventSubscriber()
    {
      public void onAvailableFeatures(boolean paramAnonymousBoolean1, final boolean paramAnonymousBoolean2, boolean paramAnonymousBoolean3, boolean paramAnonymousBoolean4)
      {
        RecentCallsFragment.a(RecentCallsFragment.this, new Runnable()
        {
          public void run()
          {
            if (RecentCallsFragment.a(RecentCallsFragment.this) != null)
            {
              RecentCallsFragment.a(RecentCallsFragment.this).a(paramAnonymousBoolean2);
              RecentCallsFragment.a(RecentCallsFragment.this).notifyDataSetChanged();
            }
          }
        });
      }

      public void onFailure(int paramAnonymousInt)
      {
      }

      public void onStartRecvVideo(int paramAnonymousInt)
      {
      }

      public void onStartSendVideo()
      {
      }

      public void onStopRecvVideo(int paramAnonymousInt)
      {
      }

      public void onStopSendVideo()
      {
      }
    };
    this.A = false;
    this.B = true;
    this.g = b.a;
  }

  private Intent a(AggregatedCall paramAggregatedCall)
  {
    com.viber.voip.model.a locala = paramAggregatedCall.getContact();
    if ((paramAggregatedCall.isTypeViberGroup()) && (paramAggregatedCall.hasConferenceInfo()))
      return ViberActionRunner.r.a(requireActivity(), paramAggregatedCall.getAggregatedHash(), paramAggregatedCall.getConferenceInfo(), "Recents - Details Screen");
    if (locala != null)
    {
      j localj = locala.n();
      String str1;
      String str2;
      long l1;
      String str3;
      String str4;
      String str5;
      Uri localUri;
      if (localj != null)
      {
        str1 = localj.c();
        str2 = null;
        if (localj != null)
          str2 = localj.a();
        l1 = locala.getId();
        str3 = locala.q();
        str4 = paramAggregatedCall.getCanonizedNumber();
        str5 = locala.k();
        localUri = locala.o();
        if ((!paramAggregatedCall.isViberCall()) || (!locala.p()))
          break label178;
      }
      label178: for (boolean bool = true; ; bool = false)
      {
        return ViberActionRunner.o.a(l1, str3, str4, str1, str5, localUri, bool, paramAggregatedCall.getAggregatedHash(), str2);
        str1 = null;
        break;
      }
    }
    if (!paramAggregatedCall.isPrivateNumber())
      return ViberActionRunner.o.a(paramAggregatedCall.getCanonizedNumber(), paramAggregatedCall.isViberCall(), paramAggregatedCall.getAggregatedHash());
    return ViberActionRunner.o.a(paramAggregatedCall.getCanonizedNumber(), paramAggregatedCall.isViberCall(), paramAggregatedCall.getAggregatedHash());
  }

  private void a(View paramView)
  {
    if ((this.mIsTablet) || (!(getActivity() instanceof AppCompatActivity)));
    android.support.v7.app.a locala;
    do
    {
      Toolbar localToolbar;
      do
      {
        return;
        localToolbar = (Toolbar)paramView.findViewById(R.id.toolbar);
      }
      while (localToolbar == null);
      AppCompatActivity localAppCompatActivity = (AppCompatActivity)getActivity();
      localAppCompatActivity.setSupportActionBar(localToolbar);
      locala = localAppCompatActivity.getSupportActionBar();
    }
    while (locala == null);
    locala.b(true);
  }

  private void a(b paramb, int paramInt)
  {
    this.a.b(this.s, false);
    switch (5.a[paramb.ordinal()])
    {
    default:
    case 2:
    }
    do
      return;
    while (paramInt != 0);
    b(this.P);
  }

  private void a(ConferenceInfo paramConferenceInfo, boolean paramBoolean)
  {
    FragmentActivity localFragmentActivity = requireActivity();
    if (paramBoolean);
    for (String str = "Search Results"; ; str = "Recents - Details Screen")
    {
      startActivity(ViberActionRunner.r.a(localFragmentActivity, paramConferenceInfo, str));
      return;
    }
  }

  private void a(String paramString, boolean paramBoolean)
  {
    n();
    MemberActionInfo localMemberActionInfo = new MemberActionInfo(paramString, paramBoolean);
    if (this.v.a(n.g))
    {
      a(localMemberActionInfo, false, true);
      return;
    }
    this.v.a(this, 34, n.g, localMemberActionInfo);
  }

  private void b(String paramString)
  {
    this.s.setQueryText(paramString);
    this.a.b(this.s, true);
  }

  private void b(String paramString, boolean paramBoolean)
  {
    n();
    MemberActionInfo localMemberActionInfo = new MemberActionInfo(paramString, paramBoolean);
    if (this.v.a(n.h))
    {
      a(localMemberActionInfo, false, false);
      return;
    }
    this.v.a(this, 54, n.h, localMemberActionInfo);
  }

  private ab c(View paramView)
  {
    if (this.l == null)
    {
      this.l = new ab();
      b(paramView);
      this.l.a(paramView, null);
    }
    return this.l;
  }

  private void c(String paramString, boolean paramBoolean)
  {
    n();
    MemberActionInfo localMemberActionInfo = new MemberActionInfo(paramString, paramBoolean);
    if (this.v.a(n.h))
    {
      a(localMemberActionInfo, true, false);
      return;
    }
    this.v.a(this, 43, n.h, localMemberActionInfo);
  }

  private void l()
  {
    this.p.a(u());
    ((TextView)this.j.findViewById(R.id.label)).setText(getString(R.string.search_call_header));
    this.a.a(this.j);
    b();
    f();
    this.a.a(this.s);
    this.a.b(this.s, false);
    b(this.b);
    a(this.g);
    this.a.notifyDataSetChanged();
    setListAdapter(this.a);
    this.u = true;
    m();
  }

  private void m()
  {
    if ((!this.u) || (this.t == null));
    SearchView localSearchView;
    do
    {
      return;
      this.c.a(this.t, this.O, this.P);
      localSearchView = (SearchView)MenuItemCompat.getActionView(this.t);
    }
    while (localSearchView == null);
    Application localApplication = ViberApplication.getApplication();
    localSearchView.setQueryHint(localApplication.getString(R.string.menu_search));
    localSearchView.setMaxWidth(localApplication.getResources().getDimensionPixelOffset(R.dimen.search_view_max_width));
  }

  private void n()
  {
    if ((this.o) && (this.n != null))
      this.n.vibrate(35);
  }

  private boolean p()
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      com.viber.provider.d locald = (com.viber.provider.d)localIterator.next();
      if ((!locald.b()) && (!((Boolean)this.d.get(locald)).booleanValue()))
        return false;
    }
    return true;
  }

  protected int a(b paramb)
  {
    if ((this.p != null) && (!this.p.c()))
      D();
    if (this.i == null)
      return 0;
    this.a.a(this.i, false);
    this.a.b(this.j, false);
    int i1;
    switch (5.a[paramb.ordinal()])
    {
    default:
      i1 = 0;
      if (this.k)
      {
        this.k = false;
        ListView localListView = getListView();
        if (localListView != null)
          localListView.setAdapter(this.a);
      }
      break;
    case 1:
    case 2:
    }
    while (true)
    {
      return i1;
      this.a.a(this.i, true);
      i1 = 0 + this.i.getCount();
      break;
      this.a.a(this.i, true);
      i1 = 0 + this.i.getCount();
      if (this.i.getCount() <= 0)
        break;
      this.a.b(this.j, true);
      break;
      this.a.notifyDataSetChanged();
    }
  }

  protected void a(int paramInt)
  {
    if ((this.c == null) || (TextUtils.isEmpty(this.c.a())))
      this.y.a(paramInt, this);
  }

  protected void a(com.viber.provider.d paramd)
  {
    this.d.put(paramd, Boolean.valueOf(false));
  }

  protected void a(com.viber.provider.d paramd, boolean paramBoolean)
  {
    this.d.put(paramd, Boolean.valueOf(paramBoolean));
  }

  void a(MemberActionInfo paramMemberActionInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1 = paramMemberActionInfo.number;
    if (TextUtils.isEmpty(str1))
      return;
    CallInitiationId.noteNextCallInitiationAttemptId();
    h localh = (h)this.f.get();
    h.a.a locala1 = h.a.i().a(new String[] { str1 });
    String str2;
    h.a.a locala2;
    if (paramMemberActionInfo.isFromSearchResults)
    {
      str2 = "Search Results";
      locala2 = locala1.a(str2).a(paramBoolean1, paramBoolean2).b(paramBoolean1);
      if (paramBoolean1)
        break label131;
    }
    label131: for (boolean bool = true; ; bool = false)
    {
      localh.b(locala2.a(bool).a());
      if (!paramBoolean1)
        break label137;
      ViberApplication.getInstance().getEngine(true).getDialerController().handleDialViberOut(str1);
      return;
      str2 = "Recents - Details Screen";
      break;
    }
    label137: ViberApplication.getInstance().getEngine(true).getDialerController().handleDial(str1, paramBoolean2);
  }

  public void a(ConferenceInfo paramConferenceInfo)
  {
    boolean bool = this.c.e();
    this.c.f();
    a(paramConferenceInfo, bool);
  }

  public void a(String paramString)
  {
  }

  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    boolean bool = this.c.e();
    this.c.f();
    if (((paramBoolean1) || ((paramBoolean3) && (!paramBoolean4))) && (!paramBoolean2))
    {
      c(paramString, bool);
      return;
    }
    if (paramBoolean2)
    {
      a(paramString, bool);
      return;
    }
    b(paramString, bool);
  }

  public void a(List<Integer> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ((com.viber.voip.analytics.story.b.c)this.e.get()).a(paramList.size());
      ArrayList localArrayList = new ArrayList(paramList.size());
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        int i1 = ((Integer)localIterator.next()).intValue();
        localArrayList.add(this.b.e(i1));
      }
      ViberApplication.getInstance().getRecentCallsManager().a(localArrayList, new q(this));
      return;
    }
    this.p.e();
  }

  public void a(boolean paramBoolean)
  {
    this.i.notifyDataSetChanged();
    if ((paramBoolean) && (this.mIsTablet) && (getListAdapter().getCount() > 0))
    {
      Intent localIntent = a((AggregatedCall)getListAdapter().getItem(0));
      this.y.h(localIntent);
      d(0);
      getListView().setItemChecked(0, true);
    }
  }

  protected boolean a()
  {
    return (this.c != null) && (this.c.e());
  }

  protected void b()
  {
    this.i.a(this);
    this.a.a(this.i);
  }

  protected void b(com.viber.provider.d paramd)
  {
    if (paramd == null)
      return;
    c(paramd);
  }

  protected void c(com.viber.provider.d paramd)
  {
    if (paramd == null);
    while (!paramd.b())
      return;
    paramd.c();
  }

  public boolean c()
  {
    return (this.b != null) && (this.b.d());
  }

  public void d()
  {
  }

  protected void e()
  {
    View localView = getView();
    if (localView == null);
    do
    {
      do
      {
        return;
        if (!this.A)
          break;
      }
      while ((!this.B) && (this.l == null));
      c(localView).b(false);
      c(localView).a(this.B);
      return;
    }
    while (!this.S);
    c(localView).b(true);
  }

  protected void f()
  {
    ((ViberListView)getListView()).a(this);
    getListView().setOnItemLongClickListener(this);
    getListView().setFastScrollEnabled(false);
    ListView localListView = getListView();
    if (this.mIsTablet);
    for (int i1 = 1; ; i1 = 0)
    {
      localListView.setChoiceMode(i1);
      if (this.mIsTablet)
        dj.a(getListView(), 1);
      if (com.viber.common.d.a.g())
        getListView().setNestedScrollingEnabled(true);
      return;
    }
  }

  protected void h()
  {
  }

  public Intent i()
  {
    if (!c());
    while ((this.i == null) || (this.i.getCount() <= 0))
      return null;
    return a((AggregatedCall)this.i.a(0));
  }

  public void initialized(Engine paramEngine)
  {
    this.n = ViberApplication.getInstance().getRingtonePlayer();
    CallInfo localCallInfo = ViberApplication.getInstance().getEngine(false).getCurrentCall();
    if (localCallInfo != null)
      ((ISoundService)this.m.get()).setSpeakerphoneOn(localCallInfo.getInCallState().isSpeakerEnabled());
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if ((this.mIsTablet) && (getTag() != null))
      getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
    if (!(getActivity() instanceof a))
    {
      Fragment localFragment = getParentFragment();
      if (!(localFragment instanceof a))
        throw new ClassCastException("RecentCallsFragment.Callbacks is not implemented!");
      this.y = ((a)localFragment);
      return;
    }
    this.y = ((a)paramContext);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.m = new com.viber.voip.g.b.b()
    {
      protected ISoundService a()
      {
        return ViberApplication.getInstance().getSoundService();
      }
    };
    if (paramBundle != null)
    {
      this.g = b.values()[paramBundle.getInt("extra_search_state", b.a.ordinal())];
      this.q = ((RecentCallsFragmentModeManager.RecentCallsFragmentModeManagerData)paramBundle.getParcelable("mode_manager"));
    }
    this.v = com.viber.common.permission.c.a(getActivity());
    this.c = new MenuSearchMediator(this);
    setHasOptionsMenu(true);
    this.n = null;
    this.b = new com.viber.voip.calls.c(getActivity(), getLoaderManager(), this.P, this);
    this.p = new RecentCallsFragmentModeManager(this, this, this.b, this.q, this.mIsTablet);
    a(this.b);
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    if (!g())
      return;
    paramMenuInflater.inflate(R.menu.menu_recent_calls, paramMenu);
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    this.t = paramMenu.findItem(R.id.menu_search);
    m();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.r = paramLayoutInflater.inflate(R.layout.fragment_recent_calls, paramViewGroup, false);
    this.a = new com.b.a.a.a();
    ListView localListView = (ListView)this.r.findViewById(16908298);
    this.i = new ad(getContext(), this.b, null, this.p, this.c, true);
    this.s = ((SearchNoResultsView)paramLayoutInflater.inflate(R.layout.search_no_results_item, localListView, false));
    this.j = paramLayoutInflater.inflate(R.layout.search_item_header, localListView, false);
    a(this.r);
    this.b.p();
    this.b.i();
    return this.r;
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.i = null;
    this.p = null;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    this.b.q();
    if (b.a == this.g)
      this.b.j();
    if (this.i != null)
      this.i.a(null);
    ((ViewGroup)this.r).removeAllViews();
    this.r = null;
  }

  public void onDetach()
  {
    super.onDetach();
    this.b = null;
    this.y = x;
  }

  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    u localu = (u)paramView.getTag();
    boolean bool;
    if (localu == null)
      bool = false;
    do
    {
      return bool;
      if (localu.e() == null)
        return false;
      if (this.c.e())
        return false;
      bool = this.p.b(paramInt, (AggregatedCall)localu.e());
    }
    while (!bool);
    getListView().setItemChecked(paramInt, true);
    return bool;
  }

  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    d(paramInt);
    Object localObject = getListAdapter().getItem(paramInt);
    if (localObject == null);
    label52: label197: label203: 
    do
    {
      return;
      if (!this.p.c())
      {
        Intent localIntent;
        if ((localObject instanceof AggregatedCall))
          localIntent = a((AggregatedCall)localObject);
        com.viber.voip.model.a locala;
        j localj;
        String str1;
        while (true)
          if (localIntent != null)
          {
            if (isVisible())
              this.y.h(localIntent);
            if (getListView().getCheckedItemPosition() != -1)
              break;
            getListView().setItemChecked(paramInt, true);
            return;
            boolean bool = localObject instanceof com.viber.voip.model.a;
            localIntent = null;
            if (bool)
            {
              locala = (com.viber.voip.model.a)localObject;
              localj = locala.n();
              if (localj == null)
                break label197;
              str1 = localj.c();
              if (localj == null)
                break label203;
            }
          }
        for (String str2 = localj.a(); ; str2 = null)
        {
          localIntent = ViberActionRunner.o.a(false, locala.getId(), locala.k(), locala.q(), locala.o(), null, str1, str2);
          break label52;
          break;
          str1 = null;
          break label141;
        }
      }
      if ((localObject instanceof AggregatedCall))
      {
        AggregatedCall localAggregatedCall = (AggregatedCall)localObject;
        this.p.a(paramInt, localAggregatedCall);
        return;
      }
    }
    while (!(localObject instanceof com.viber.voip.model.a));
    label141: this.p.a(paramInt, null);
  }

  public void onLoadFinished(com.viber.provider.d paramd, boolean paramBoolean)
  {
    boolean bool = true;
    a(paramd, bool);
    this.A = p();
    if (this.A)
    {
      int i1 = a(this.g);
      a(this.g, i1);
      if ((i1 > 0) || (this.g != b.a))
        break label68;
    }
    while (true)
    {
      this.B = bool;
      e();
      return;
      label68: bool = false;
    }
  }

  public void onLoaderReset(com.viber.provider.d paramd)
  {
  }

  public void onPause()
  {
    super.onPause();
    ViberApplication.getInstance().getEngine(false).removeInitializedListener(this);
    EngineDelegate.removeEventSubscriber(this.z);
  }

  public void onPrepareOptionsMenu(Menu paramMenu)
  {
    if ((getActivity() != null) && (g()) && (isDetached()));
  }

  public boolean onQueryTextChange(String paramString)
  {
    this.k = true;
    if (TextUtils.isEmpty(paramString))
      this.g = b.a;
    while (true)
    {
      this.P = paramString;
      b(this.b);
      if (this.b != null)
      {
        this.b.f(paramString);
        a(this.b, false);
      }
      return true;
      if (this.g == b.a)
        this.g = b.b;
    }
  }

  public boolean onQueryTextSubmit(String paramString)
  {
    return false;
  }

  public void onResume()
  {
    super.onResume();
    ViberApplication.getInstance().getEngine(false).addInitializedListener(this);
    getActivity().getIntent().getData();
    this.o = d.m.d.d();
    EngineDelegate.addEventSubscriber(this.z);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("extra_search_state", this.g.ordinal());
    if ((g()) && (this.p != null))
      paramBundle.putParcelable("mode_manager", this.p.a());
    super.onSaveInstanceState(paramBundle);
  }

  public boolean onSearchViewShow(boolean paramBoolean)
  {
    this.O = paramBoolean;
    if (!paramBoolean)
    {
      this.g = b.a;
      this.a.b(this.s, false);
      this.a.b(this.j, false);
    }
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof au))
      ((au)localFragmentActivity).a(paramBoolean);
    return true;
  }

  public void onStart()
  {
    super.onStart();
    this.v.a(this.w);
  }

  public void onStop()
  {
    this.v.b(this.w);
    super.onStop();
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    l();
  }

  public void q()
  {
    if (this.c.e())
      this.c.f();
  }

  public void w_()
  {
  }

  static class MemberActionInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<MemberActionInfo> CREATOR = new Parcelable.Creator()
    {
      public RecentCallsFragment.MemberActionInfo a(Parcel paramAnonymousParcel)
      {
        return new RecentCallsFragment.MemberActionInfo(paramAnonymousParcel);
      }

      public RecentCallsFragment.MemberActionInfo[] a(int paramAnonymousInt)
      {
        return new RecentCallsFragment.MemberActionInfo[paramAnonymousInt];
      }
    };
    public final boolean isFromSearchResults;
    public final String number;

    protected MemberActionInfo(Parcel paramParcel)
    {
      if (paramParcel.readByte() != 0);
      for (boolean bool = true; ; bool = false)
      {
        this.isFromSearchResults = bool;
        this.number = paramParcel.readString();
        return;
      }
    }

    MemberActionInfo(String paramString, boolean paramBoolean)
    {
      this.number = paramString;
      this.isFromSearchResults = paramBoolean;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      if (this.isFromSearchResults);
      for (byte b = 1; ; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.number);
        return;
      }
    }
  }

  public static abstract interface a extends o.a
  {
    public abstract void h(Intent paramIntent);
  }

  static enum b
  {
    static
    {
      b[] arrayOfb = new b[2];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.RecentCallsFragment
 * JD-Core Version:    0.6.2
 */