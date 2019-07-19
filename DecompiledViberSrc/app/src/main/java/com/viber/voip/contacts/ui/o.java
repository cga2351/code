package com.viber.voip.contacts.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ListView;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.block.g;
import com.viber.voip.block.g.a;
import com.viber.voip.block.h;
import com.viber.voip.contacts.adapters.i;
import com.viber.voip.contacts.b.b;
import com.viber.voip.h.a;
import com.viber.voip.i.c.f;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.GroupController.GroupMember;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.conversation.community.CreateCommunityActivity;
import com.viber.voip.messages.conversation.ui.CommunityIntroActivity;
import com.viber.voip.messages.k;
import com.viber.voip.messages.ui.forward.e;
import com.viber.voip.messages.ui.media.ComposeDataContainer;
import com.viber.voip.model.entity.v;
import com.viber.voip.model.j;
import com.viber.voip.permissions.n;
import com.viber.voip.registration.af;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.o;
import com.viber.voip.ui.ContactsListView;
import com.viber.voip.ui.MenuSearchMediator;
import com.viber.voip.ui.at;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.ck;
import com.viber.voip.ui.dialogs.r;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.co;
import com.viber.voip.util.dc;
import com.viber.voip.util.df;
import com.viber.voip.util.dj;
import com.viber.voip.util.dr;
import com.viber.voip.util.x;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;

public class o extends ContactsFragment
  implements ParticipantSelector.e, e
{
  private static final Logger B = ViberEnv.getLogger();
  private static com.viber.voip.messages.ui.forward.f T = new com.viber.voip.messages.ui.forward.f()
  {
    public void a()
    {
    }

    public void a(String paramAnonymousString)
    {
    }
  };
  private af C;
  private TextView D;
  private View E;
  private View F;
  private View G;
  private boolean H;
  private Boolean I;
  private boolean J;
  private boolean K;
  private boolean L;
  private boolean M;
  protected ParticipantSelector a;
  protected boolean b;

  @Inject
  com.viber.voip.analytics.story.e.c c;
  protected com.viber.voip.messages.ui.forward.f d = T;

  private void E()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      if (!d.o.a.d())
        localFragmentActivity.startActivityForResult(new Intent(getActivity(), CommunityIntroActivity.class), 20);
    }
    else
      return;
    if (TextUtils.isEmpty(UserManager.from(localFragmentActivity).getUserData().getViberName()))
    {
      com.viber.voip.ui.dialogs.d.k().a(new ViberDialogHandlers.ck()).d();
      return;
    }
    Intent localIntent = new Intent(getActivity(), CreateCommunityActivity.class);
    localIntent.putExtra("members_extra", new GroupController.GroupMember[0]);
    localFragmentActivity.startActivityForResult(localIntent, 1021);
  }

  private void a(View paramView)
  {
    View localView1 = paramView.findViewById(R.id.compose_header);
    TextView localTextView2;
    TextView localTextView3;
    if ((localView1 != null) && ((localView1 instanceof ViewStub)))
    {
      View localView2 = ((ViewStub)localView1).inflate();
      TextView localTextView1 = (TextView)localView2.findViewById(R.id.new_group);
      localTextView2 = (TextView)localView2.findViewById(R.id.new_broadcast_list);
      localTextView3 = (TextView)localView2.findViewById(R.id.new_community);
      localTextView1.setOnClickListener(this);
      localTextView2.setOnClickListener(this);
      localTextView3.setOnClickListener(this);
      int i = dc.d(getActivity(), R.attr.listItemIconTint);
      Drawable localDrawable1 = df.a(ContextCompat.getDrawable(getActivity(), R.drawable.ic_new_group), i, false);
      Drawable localDrawable2 = df.a(ContextCompat.getDrawable(getActivity(), R.drawable.ic_new_broadcast_list), i, false);
      Drawable localDrawable3 = df.a(ContextCompat.getDrawable(getActivity(), R.drawable.ic_new_community), i, false);
      co.a(localTextView1, localDrawable1);
      co.a(localTextView2, localDrawable2);
      co.a(localTextView3, localDrawable3);
      if (ao.f())
        break label196;
    }
    label196: for (boolean bool = true; ; bool = false)
    {
      dj.b(localTextView2, bool);
      dj.b(localTextView3, c.f.a.e());
      return;
    }
  }

  private void a(String paramString)
  {
    String str = dr.a(paramString);
    if ((TextUtils.isEmpty(str)) || (this.K))
    {
      this.E.setVisibility(8);
      if (this.G != null)
        this.G.setVisibility(0);
    }
    do
    {
      return;
      this.E.setVisibility(0);
      this.D.setText(str);
    }
    while (this.G == null);
    this.G.setVisibility(8);
  }

  private void a(Set<ParticipantSelector.Participant> paramSet, ParticipantSelector.d paramd)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
      x.a(localFragmentActivity, paramSet, paramd);
  }

  private void b(boolean paramBoolean, int paramInt)
  {
    ((ContactsComposeCombinedActivity)getActivity()).a(paramBoolean, paramInt);
  }

  private void d(final com.viber.voip.model.c paramc)
  {
    if (paramc == null)
      return;
    this.i.i();
    final Set localSet = e(paramc);
    a(localSet, new ParticipantSelector.d()
    {
      public void a(ParticipantSelector.Participant paramAnonymousParticipant)
      {
      }

      public void a(boolean paramAnonymousBoolean, ParticipantSelector.Participant paramAnonymousParticipant)
      {
        String str = paramAnonymousParticipant.getMemberId();
        if ((o.a(o.this).l().equals(str)) && (!o.b(o.this)))
          o.this.a.n();
        do
        {
          return;
          if ((o.c(o.this)) || (TextUtils.isEmpty(str)))
            break;
        }
        while (!g.a(o.this.getActivity(), Member.from(paramAnonymousParticipant), this.a));
        o.this.a.d(paramAnonymousParticipant);
        return;
        o.this.a(paramc, paramAnonymousParticipant);
      }
    });
  }

  private void d(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 0; (i == 0) && (this.j == null); i = 3)
      return;
    r().a(i, true);
  }

  private Set<ParticipantSelector.Participant> e(com.viber.voip.model.c paramc)
  {
    HashSet localHashSet1 = new HashSet();
    Collection localCollection = paramc.s();
    HashSet localHashSet2 = new HashSet(localCollection.size());
    Iterator localIterator1 = localCollection.iterator();
    while (localIterator1.hasNext())
    {
      j localj = (j)localIterator1.next();
      localHashSet1.add(ParticipantSelector.Participant.from(localj, paramc));
      localHashSet2.add(localj.c());
    }
    if (k() != b.b.d)
    {
      HashSet localHashSet3 = new HashSet();
      localHashSet3.addAll(paramc.t());
      localHashSet3.addAll(paramc.u());
      localHashSet3.removeAll(localHashSet2);
      Iterator localIterator2 = localHashSet3.iterator();
      while (localIterator2.hasNext())
        localHashSet1.add(new ParticipantSelector.Participant(null, (String)localIterator2.next(), paramc.k(), paramc.o(), true));
    }
    return localHashSet1;
  }

  String a(Bundle paramBundle)
  {
    if (paramBundle != null)
      return paramBundle.getString("extra_create_chat_origin", "");
    return "";
  }

  protected void a(MenuItem paramMenuItem)
  {
    paramMenuItem.expandActionView();
    this.O = true;
  }

  protected void a(com.viber.voip.model.c paramc, ParticipantSelector.Participant paramParticipant)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      if ((getArguments() == null) || (!getArguments().getBoolean("return_result")))
        break label124;
      if (paramc.n() == null)
        break label118;
    }
    label118: for (String str = paramc.n().c(); ; str = null)
    {
      Intent localIntent2 = new Intent();
      localIntent2.putExtra("compose_data_extra", new ComposeDataContainer(paramc.k(), paramc.l(), paramParticipant.getNumber(), str, paramc.o(), paramc.y()));
      localFragmentActivity.setResult(-1, localIntent2);
      localFragmentActivity.finish();
      return;
    }
    label124: Intent localIntent1 = com.viber.voip.messages.m.a(paramParticipant.getMemberId(), paramParticipant.getNumber(), paramc.k(), false, false, false, false);
    if (this.b)
    {
      this.m.a(true, localIntent1);
      return;
    }
    this.c.a(paramParticipant.getMemberId(), "Create Chat Icon", 2);
    startActivity(localIntent1);
    localFragmentActivity.finish();
  }

  public void c(int paramInt)
  {
  }

  protected void f()
  {
    ((ContactsListView)this.p).a(true, this.mIsTablet);
  }

  public long getConversationId()
  {
    return -1L;
  }

  public long getGroupId()
  {
    return -1L;
  }

  protected String i()
  {
    return getResources().getString(R.string.to_participants);
  }

  public com.viber.voip.contacts.b j()
  {
    return new com.viber.voip.contacts.c(getActivity(), getLoaderManager(), this.h, this);
  }

  public b.b k()
  {
    if (this.M)
    {
      if (this.I == null)
        return b.b.c;
      if (this.I.booleanValue())
        return b.b.e;
      return b.b.f;
    }
    if (this.H)
      return b.b.b;
    return b.b.d;
  }

  public boolean l()
  {
    return true;
  }

  protected boolean m()
  {
    return false;
  }

  protected boolean n()
  {
    return (!this.b) && (!this.M);
  }

  protected int o()
  {
    return R.string.participant_chooser_permission_description;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.s.b(true);
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 10) && (paramInt2 == -1))
    {
      FragmentActivity localFragmentActivity = getActivity();
      if (localFragmentActivity != null)
        localFragmentActivity.finish();
      return;
    }
    if ((paramInt1 == 20) && (paramInt2 == -1))
    {
      getActivity().getIntent().putExtras(paramIntent);
      E();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof com.viber.voip.messages.ui.forward.f))
      this.d = ((com.viber.voip.messages.ui.forward.f)localFragmentActivity);
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.new_num_layout)
    {
      this.a.a(this.D.getText().toString(), paramView);
      return;
    }
    if (i == R.id.new_group)
    {
      b(false, 0);
      return;
    }
    if (i == R.id.new_broadcast_list)
    {
      b(false, 1);
      return;
    }
    if (i == R.id.new_community)
    {
      E();
      return;
    }
    super.onClick(paramView);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getArguments();
    FragmentActivity localFragmentActivity = getActivity();
    this.C = UserManager.from(localFragmentActivity).getRegistrationValues();
    this.a = new ParticipantSelector(localFragmentActivity, av.a(av.e.a), av.a(av.e.f), av.a(av.e.d), this, this.C, (s.a)localFragmentActivity, com.viber.voip.messages.controller.manager.o.a(), a.b(), ViberApplication.getInstance().getEngine(false).getOnlineUserActivityHelper(), ViberApplication.getInstance().getMessagesManager().d(), ViberApplication.getInstance().getMessagesManager().z(), ab.b(), com.viber.voip.messages.controller.manager.ak.a(), 2, a(localBundle), this.c);
    if (!this.y.a(n.j))
      av.a(av.e.a).postDelayed(new Runnable()
      {
        public void run()
        {
          o.this.i.i();
        }
      }
      , 300L);
    if (localBundle != null)
    {
      this.b = localBundle.getBoolean("open_for_forward", false);
      this.H = localBundle.getBoolean("all_filter", false);
      if (localBundle.containsKey("viber_user_filter"))
        this.I = Boolean.valueOf(localBundle.getBoolean("viber_user_filter"));
      this.J = localBundle.getBoolean("extra_ignore_blocked_users", false);
      this.K = localBundle.getBoolean("extra_hide_root_number", false);
      this.L = localBundle.getBoolean("extra_allow_select_self_number", false);
      this.M = localBundle.getBoolean("wallet_filter", false);
    }
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(R.menu.menu_compose_1to1, paramMenu);
    MenuItem localMenuItem = paramMenu.findItem(R.id.menu_search);
    SearchView localSearchView = (SearchView)localMenuItem.getActionView();
    localSearchView.setQueryHint(i());
    localSearchView.setMaxWidth(getResources().getDimensionPixelOffset(R.dimen.search_view_max_width));
    localSearchView.setIconifiedByDefault(false);
    if ((!this.mIsTablet) || (!this.b))
      a(localMenuItem);
    b(localMenuItem);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView1 = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    ViewStub localViewStub = (ViewStub)localView1.findViewById(R.id.contact_list_add_number_view_stub);
    if (localViewStub != null)
      localViewStub.inflate();
    if ((getActivity() instanceof ContactsComposeCombinedActivity))
      a(localView1);
    this.E = localView1.findViewById(R.id.new_num_root_layout);
    this.F = localView1.findViewById(R.id.new_num_layout);
    this.D = ((TextView)localView1.findViewById(R.id.searched_number));
    View localView2 = localView1.findViewById(R.id.compose_header);
    if ((localView2 instanceof ViewStub))
      localView2 = null;
    this.G = localView2;
    this.F.setOnClickListener(this);
    return localView1;
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.d = null;
    if (this.a != null)
    {
      this.a.a();
      this.a = null;
    }
  }

  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    m localm = (m)paramView.getTag();
    if (localm == null)
      return;
    d(localm.a());
  }

  public void onLoadFinished(com.viber.provider.d paramd, boolean paramBoolean)
  {
    super.onLoadFinished(paramd, paramBoolean);
    if (this.e == null);
    do
    {
      return;
      a(this.i.a());
    }
    while (!(paramd instanceof com.viber.voip.contacts.b));
    if ((paramd.getCount() > 0) || (((com.viber.voip.contacts.b)paramd).x_()));
    for (boolean bool = true; ; bool = false)
    {
      d(bool);
      return;
    }
  }

  public void onParticipantAlreadyAdded(String paramString)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
      r.c().a(com.viber.common.d.c.a(localFragmentActivity, R.string.dialog_1004_message_already_participant, new Object[] { paramString })).a(localFragmentActivity);
  }

  public void onParticipantSelected(boolean paramBoolean, ParticipantSelector.Participant paramParticipant)
  {
    d(new v(paramParticipant.getMemberId(), paramParticipant.getNumber(), paramParticipant.getDisplayName()));
  }

  public boolean onQueryTextChange(String paramString)
  {
    this.d.a(this.i.a());
    View localView = dj.a((SearchView)this.i.c());
    if (localView != null)
      if (!TextUtils.isEmpty(paramString))
        break label54;
    label54: for (int i = 0; ; i = 8)
    {
      localView.setVisibility(i);
      return super.onQueryTextChange(paramString);
    }
  }

  public boolean onSearchViewShow(boolean paramBoolean)
  {
    if ((this.mIsTablet) && (this.b));
    while (paramBoolean)
      return true;
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      this.i.i();
      localFragmentActivity.finish();
    }
    return false;
  }

  public void onStart()
  {
    super.onStart();
    if (getActivity() != null)
      at.e();
  }

  public void setSearchQuery(String paramString)
  {
    if (this.i != null)
      this.i.a(paramString);
  }

  public void v_()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.o
 * JD-Core Version:    0.6.2
 */