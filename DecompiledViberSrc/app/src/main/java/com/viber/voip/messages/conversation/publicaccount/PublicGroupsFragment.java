package com.viber.voip.messages.conversation.publicaccount;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import com.viber.common.a.e;
import com.viber.common.dialogs.h.a;
import com.viber.jni.Engine;
import com.viber.provider.d.a;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.j;
import com.viber.voip.i.c.l;
import com.viber.voip.messages.adapters.w;
import com.viber.voip.messages.controller.ai.n;
import com.viber.voip.messages.controller.publicaccount.ae;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.k;
import com.viber.voip.messages.orm.entity.json.action.Action;
import com.viber.voip.messages.orm.entity.json.action.FollowPublicGroupAction;
import com.viber.voip.messages.orm.entity.json.action.OpenUrlAction;
import com.viber.voip.messages.ui.ConversationActivity;
import com.viber.voip.messages.ui.MessagesFragmentModeManager;
import com.viber.voip.messages.ui.MessagesFragmentModeManager.MessagesFragmentModeManagerData;
import com.viber.voip.messages.ui.MessagesFragmentModeManager.a;
import com.viber.voip.messages.ui.MessagesFragmentModeManager.b;
import com.viber.voip.messages.ui.MessagesFragmentModeManager.d;
import com.viber.voip.messages.ui.PublicGroupsFragmentModeManager;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.ui.ViberListView;
import com.viber.voip.ui.i;
import com.viber.voip.ui.i.a;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.util.cj;
import com.viber.voip.util.cl;
import com.viber.voip.util.dj;
import com.viber.voip.widget.PublicAccountAdView;
import com.viber.voip.widget.PublicAccountAdView.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Inject;

public class PublicGroupsFragment extends com.viber.voip.messages.ui.h
  implements View.OnClickListener, d.a, MessagesFragmentModeManager.a
{
  private static final e m = ViberEnv.getLogger();
  private static a w = (a)cl.b(a.class);
  protected a a = w;
  protected ViberListView b;
  protected View c;
  protected RelativeLayout.LayoutParams d;

  @Inject
  dagger.a<com.viber.voip.analytics.story.g.a> e;
  private o n;
  private View o;
  private w p;
  private b q;
  private i r;
  private ArrayList<PublicAccount> s;
  private j t;
  private Engine u;
  private boolean v;
  private View.OnClickListener x = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      ViberActionRunner.aq.a(PublicGroupsFragment.this.getContext(), (PublicAccount)paramAnonymousView.getTag());
    }
  };
  private PublicAccountAdView.a y = new PublicAccountAdView.a()
  {
    private void a(com.viber.voip.ads.d.n paramAnonymousn)
    {
      PublicGroupsFragment.c(PublicGroupsFragment.this).b(paramAnonymousn, PublicGroupsFragment.this.i());
      new OpenUrlAction(paramAnonymousn.e()).execute(PublicGroupsFragment.this.getActivity(), null);
    }

    public void a(com.viber.voip.ads.d.n paramAnonymousn, PublicAccountAdView paramAnonymousPublicAccountAdView)
    {
      if (!PublicGroupsFragment.this.w().l())
        PublicGroupsFragment.b(PublicGroupsFragment.this, paramAnonymousPublicAccountAdView);
    }

    public void a(com.viber.voip.ads.d.n paramAnonymousn, PublicAccountAdView paramAnonymousPublicAccountAdView, String paramAnonymousString)
    {
      if (PublicGroupsFragment.this.w().l())
        PublicGroupsFragment.a(PublicGroupsFragment.this, paramAnonymousPublicAccountAdView);
      do
      {
        do
        {
          return;
          if (!(paramAnonymousn instanceof com.viber.voip.ads.d.o))
            break;
          if ("button".equals(paramAnonymousString))
          {
            Object localObject;
            if (paramAnonymousn.t())
            {
              if (!cj.b(PublicGroupsFragment.this.getActivity()))
              {
                com.viber.voip.ui.dialogs.f.b().d();
                return;
              }
              localObject = new FollowPublicGroupAction(paramAnonymousn.u(), ae.f, false);
            }
            while (true)
            {
              ((Action)localObject).execute(PublicGroupsFragment.this.getActivity(), null);
              return;
              localObject = new OpenUrlAction(paramAnonymousn.m());
              PublicGroupsFragment.c(PublicGroupsFragment.this).b(paramAnonymousn, PublicGroupsFragment.this.i());
            }
          }
          if ("sponsored".equals(paramAnonymousString))
          {
            if (paramAnonymousn.A())
            {
              PublicGroupsFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousn.y())));
              return;
            }
            a(paramAnonymousn);
            return;
          }
        }
        while ("menu icon".equals(paramAnonymousString));
        a(paramAnonymousn);
        return;
      }
      while ("menu icon".equals(paramAnonymousString));
      a(paramAnonymousn);
    }

    public void b(com.viber.voip.ads.d.n paramAnonymousn, PublicAccountAdView paramAnonymousPublicAccountAdView)
    {
      PublicGroupsFragment.c(PublicGroupsFragment.this).a(paramAnonymousn, PublicGroupsFragment.this.i());
      PublicGroupsFragment.b(PublicGroupsFragment.this).l();
    }

    public void c(com.viber.voip.ads.d.n paramAnonymousn, PublicAccountAdView paramAnonymousPublicAccountAdView)
    {
      PublicGroupsFragment.c(PublicGroupsFragment.this).c();
      PublicGroupsFragment.b(PublicGroupsFragment.this).l();
    }

    public void d(com.viber.voip.ads.d.n paramAnonymousn, PublicAccountAdView paramAnonymousPublicAccountAdView)
    {
    }
  };

  public PublicGroupsFragment()
  {
    super(-1);
  }

  private void a(PublicAccountAdView paramPublicAccountAdView)
  {
    View localView = (View)paramPublicAccountAdView.getParent();
    ListView localListView = getListView();
    int i = localListView.getPositionForView(localView);
    localListView.performItemClick(localView, i, localListView.getItemIdAtPosition(i));
  }

  private void b(PublicAccountAdView paramPublicAccountAdView)
  {
    View localView = (View)paramPublicAccountAdView.getParent();
    ListView localListView = getListView();
    int i = localListView.getPositionForView(localView);
    onItemLongClick(localListView, localView, i, localListView.getItemIdAtPosition(i));
  }

  private com.viber.voip.publicaccount.a.a z()
  {
    return ViberApplication.getInstance().getMessagesManager().r();
  }

  protected MessagesFragmentModeManager a(MessagesFragmentModeManager.MessagesFragmentModeManagerData paramMessagesFragmentModeManagerData, MessagesFragmentModeManager.d paramd)
  {
    return new PublicGroupsFragmentModeManager(this, this, paramMessagesFragmentModeManagerData, paramd, this.mIsTablet);
  }

  public void a(long paramLong)
  {
    c(paramLong);
    this.n.l();
  }

  public void a(ListView paramListView, View paramView, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (!w().l())
    {
      com.viber.voip.ui.g.d locald = a(paramView.getTag());
      if ((locald != null) && (((com.viber.voip.messages.adapters.a.a)locald.d()).i() > 0L))
        a(paramListView, paramView, paramInt, paramBoolean);
    }
    super.onListItemClick(paramListView, paramView, paramInt, paramLong);
  }

  public void a(com.viber.voip.messages.adapters.a.a parama, boolean paramBoolean)
  {
    com.viber.voip.messages.adapters.h localh = (com.viber.voip.messages.adapters.h)parama;
    ConversationLoaderEntity localConversationLoaderEntity = localh.a();
    PublicGroupConversationData localPublicGroupConversationData = new PublicGroupConversationData(parama.i(), localh.p(), localConversationLoaderEntity.getGroupName(), null, localh.q(), 0, localh.n(), localConversationLoaderEntity.getUnreadMessagesCount(), localConversationLoaderEntity.getLastPinMessageRawMsgInfo());
    Intent localIntent = ViberActionRunner.aq.a(getContext(), false, parama.a().hasPublicChat(), localPublicGroupConversationData);
    this.i = parama.i();
    this.p.a(this.i);
    if (this.a != null)
      this.a.b_(localIntent);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    super.a(paramConversationItemLoaderEntity, paramBoolean);
    this.v = false;
  }

  public void a(String paramString)
  {
  }

  protected void a(ArrayList<PublicAccount> paramArrayList)
  {
    if ((paramArrayList.size() == 0) && (!cj.b(getActivity())))
    {
      this.q.b();
      return;
    }
    this.q.a(paramArrayList);
  }

  public void a(Map<Long, MessagesFragmentModeManager.b> paramMap)
  {
    super.a(paramMap);
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
      if (-10L == ((Long)((Map.Entry)localIterator.next()).getKey()).longValue())
      {
        com.viber.voip.publicaccount.a.a locala = z();
        locala.a(locala.d(), i());
        this.n.l();
      }
  }

  public void a(boolean paramBoolean)
  {
  }

  protected o b()
  {
    return new o(getActivity(), getLoaderManager(), this.j, this.mIsTablet, this, com.viber.voip.h.a.b());
  }

  public void b(long paramLong)
  {
    if (this.p != null)
      this.p.a(paramLong);
  }

  public boolean c()
  {
    return (this.n != null) && (this.n.d());
  }

  protected int d()
  {
    return 1;
  }

  protected void e()
  {
  }

  protected void f()
  {
    z().a(new com.viber.voip.ads.n()
    {
      public void a()
      {
        PublicGroupsFragment.b(PublicGroupsFragment.this).l();
      }

      public void a(com.viber.voip.ads.d.n paramAnonymousn)
      {
        PublicGroupsFragment.b(PublicGroupsFragment.this).l();
      }
    });
  }

  public ListAdapter getListAdapter()
  {
    return this.p;
  }

  protected void h()
  {
    if (!this.mIsTablet)
    {
      b(getView());
      this.q.a(getView(), this, this.x);
      this.q.a();
    }
    if (this.s != null)
      a(this.s);
    k();
    f();
  }

  public int i()
  {
    return -1 + this.n.getCount();
  }

  protected boolean j()
  {
    return c.l.a.e();
  }

  protected void k()
  {
    this.n.p();
    this.n.i();
  }

  public void l()
  {
    this.v = true;
  }

  public void m()
  {
  }

  public void n()
  {
    ((com.viber.voip.messages.controller.publicaccount.d)this.l.get()).a(new ai.n()
    {
      public void a(String paramAnonymousString, List<PublicAccount> paramAnonymousList)
      {
        PublicGroupsFragment.a(PublicGroupsFragment.this, new ArrayList(paramAnonymousList));
        PublicGroupsFragment.a(PublicGroupsFragment.this, new Runnable()
        {
          public void run()
          {
            PublicGroupsFragment.this.a(PublicGroupsFragment.a(PublicGroupsFragment.this));
          }
        });
      }
    });
  }

  protected void o()
  {
    if (cj.b(getActivity()))
    {
      n();
      return;
    }
    this.q.b();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    if (this.mIsTablet)
    {
      getView().findViewById(R.id.emptyProgress).setVisibility(8);
      getView().findViewById(16908292).setVisibility(8);
    }
    while (true)
    {
      this.n = b();
      this.p = new w(getActivity(), w(), this.n, this.y, getLayoutInflater());
      getListView().setAdapter(this.p);
      this.t = new j(z(), this.b, this.p);
      if (paramBundle != null)
        this.s = paramBundle.getParcelableArrayList("suggestion_list");
      super.onActivityCreated(paramBundle);
      return;
      this.q = new p();
    }
  }

  public void onAttach(Activity paramActivity)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramActivity);
    if (!(paramActivity instanceof a))
      throw new ClassCastException("Activity must implement fragment's callbacks.");
    this.a = ((a)paramActivity);
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.emptyButton)
      if (this.q.c())
        o();
    do
    {
      return;
      ViberActionRunner.aq.a(getContext());
      return;
      if (i == R.id.empty_button)
      {
        o();
        return;
      }
    }
    while (i != R.id.emptyDescription);
    if ((this.q != null) && (this.q.c()))
    {
      o();
      return;
    }
    ViberActionRunner.aq.a(getContext());
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
    this.u = ViberApplication.getInstance().getEngine(false);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.fragment_groups, paramViewGroup, false);
    this.b = ((ViberListView)localView.findViewById(16908298));
    this.b.a(this);
    this.d = ((RelativeLayout.LayoutParams)this.b.getLayoutParams());
    this.c = localView.findViewById(R.id.fab_container);
    if (j())
    {
      this.r = new i(localView, R.id.fab_create, new i.a()
      {
        public void a()
        {
          ViberActionRunner.aq.a(PublicGroupsFragment.this.getActivity());
        }
      });
      this.r.a(true);
    }
    return localView;
  }

  public void onDestroyView()
  {
    this.n.q();
    super.onDestroyView();
    if (this.t != null)
    {
      this.t.b();
      this.t = null;
    }
  }

  public void onDetach()
  {
    super.onDetach();
    this.a = w;
  }

  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    a(paramListView, paramView, paramInt, paramLong, true);
  }

  public void onLoadFinished(com.viber.provider.d paramd, boolean paramBoolean)
  {
    boolean bool1;
    boolean bool2;
    if (paramd == this.n)
    {
      if (paramd.getCount() != 0)
        break label308;
      bool1 = true;
      if ((!bool1) && (this.q != null))
        this.q.a(bool1);
      this.p.notifyDataSetChanged();
      if (paramBoolean)
      {
        com.viber.voip.analytics.story.g.a locala = (com.viber.voip.analytics.story.g.a)this.e.get();
        if ((bool1) || (-10L != paramd.a(0)))
          break label313;
        bool2 = true;
        label82: locala.a(bool2);
      }
      if (this.mIsTablet)
      {
        if (this.o == null)
        {
          b(getView());
          this.o = getView().findViewById(R.id.empty_root);
        }
        if (!bool1)
          break label319;
        this.i = 0L;
        if (isVisible())
        {
          dj.a((AppCompatActivity)getActivity(), getString(R.string.vibes));
          dj.b((AppCompatActivity)getActivity(), null);
        }
        this.b.setVisibility(8);
        this.o.setVisibility(0);
      }
      label189: this.a.a(d(), this.p.getCount());
      if (this.i <= 0L)
        break label339;
      a(this.i, true, false);
    }
    while (true)
    {
      if ((bool1) && (this.q != null) && (this.q.d() == null))
      {
        if (this.q != null)
          this.q.a(bool1);
        o();
      }
      if (w() != null)
      {
        w().p();
        if ((!w().l()) && (!this.v))
          D();
      }
      return;
      label308: bool1 = false;
      break;
      label313: bool2 = false;
      break label82;
      label319: this.o.setVisibility(8);
      this.b.setVisibility(0);
      break label189;
      label339: if ((this.p.getCount() > 0) && (this.mIsTablet) && (getListView() != null) && (w() != null) && (!this.v))
      {
        long l = getListView().getItemIdAtPosition(0);
        if (l > 0L)
          a(l, true, true);
      }
    }
  }

  public void onLoaderReset(com.viber.provider.d paramd)
  {
  }

  public void onPause()
  {
    super.onPause();
    if (this.t != null)
      this.t.a();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if ((this.s != null) && (this.n.getCount() == 0))
      paramBundle.putParcelableArrayList("suggestion_list", this.s);
  }

  public void onStart()
  {
    super.onStart();
    if (this.n != null)
      this.n.c();
  }

  public void onStop()
  {
    super.onStop();
    if (this.n != null)
      this.n.y_();
  }

  public boolean p()
  {
    return (this.n != null) && (this.n.getCount() > 0);
  }

  public void q()
  {
  }

  public boolean r()
  {
    FragmentActivity localFragmentActivity = getActivity();
    return (localFragmentActivity != null) && ((localFragmentActivity instanceof ConversationActivity));
  }

  public Map<Long, MessagesFragmentModeManager.b> s()
  {
    return this.n.B();
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2);

    public abstract void b_(Intent paramIntent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.publicaccount.PublicGroupsFragment
 * JD-Core Version:    0.6.2
 */