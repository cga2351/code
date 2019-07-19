package com.viber.voip.contacts.ui.list;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v7.d.c.b;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.m.c;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.ViberApplication;
import com.viber.voip.analytics.g;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.i.c.f;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.p;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ac;
import com.viber.voip.messages.conversation.l.a;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.publicaccount.n;
import com.viber.voip.messages.conversation.ui.bm;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.registration.af;
import com.viber.voip.ui.aq;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner.d;
import com.viber.voip.util.cj;
import com.viber.voip.util.cn;
import java.util.List;
import javax.inject.Inject;

public class ae extends aq
  implements m.c, com.viber.provider.d.a, ab.a, at, w, l.a
{

  @Inject
  com.viber.voip.app.b a;

  @Inject
  com.viber.voip.analytics.story.e.c b;

  @Inject
  com.viber.voip.invitelinks.d c;

  @Inject
  dagger.a<com.viber.voip.messages.k> d;

  @Inject
  dagger.a<GroupController> e;

  @Inject
  dagger.a<com.viber.voip.messages.controller.a> f;

  @Inject
  PhoneController g;

  @Inject
  EngineDelegatesManager h;

  @Inject
  dagger.a<bv> i;

  @Inject
  com.viber.voip.contacts.c.d.m j;

  @Inject
  dagger.a<com.viber.voip.analytics.story.b.a.h> k;

  @Inject
  com.viber.common.permission.c l;

  @Inject
  Im2Exchanger m;
  private ak n;
  private t o;
  private x p;
  private ac q;
  private com.viber.voip.messages.conversation.l r;
  private ab s;
  private Menu t;
  private final com.viber.common.permission.b u;

  public ae()
  {
    FragmentActivity localFragmentActivity = getActivity();
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(62);
    this.u = new com.viber.voip.permissions.f(localFragmentActivity, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 62:
        }
        ae.a(ae.this).g();
      }
    };
  }

  public void E_()
  {
    this.p.E_();
  }

  public void F_()
  {
    this.p.F_();
  }

  public void X_()
  {
    this.p.X_();
  }

  public void a()
  {
    this.p.a();
  }

  public void a(int paramInt)
  {
    this.s.a(paramInt);
  }

  public void a(aj paramaj)
  {
    if (this.t == null)
      return;
    this.t.findItem(R.id.menu_share_group_link).setVisible(paramaj.a);
    this.t.findItem(R.id.menu_add_members).setVisible(paramaj.b);
  }

  public void a(s params)
  {
    this.p.a(params);
  }

  public void a(z paramz)
  {
    this.o.a(paramz.a);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.p.a(paramConversationItemLoaderEntity);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt)
  {
    ViberActionRunner.d.a(this, paramConversationItemLoaderEntity, paramInt);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, com.viber.voip.model.h paramh)
  {
    this.p.a(paramConversationItemLoaderEntity, paramh);
  }

  public void a(com.viber.voip.messages.conversation.adapter.a.c.a.e parame)
  {
    this.s.a(parame);
  }

  public void a(com.viber.voip.model.h paramh)
  {
    this.p.a(paramh);
  }

  public void a(com.viber.voip.model.h paramh, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.p.a(paramh, paramBoolean1, paramBoolean2);
  }

  public void a(com.viber.voip.model.h paramh, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.p.a(paramh, paramBoolean1, paramBoolean2, paramBoolean3);
  }

  public void a(String paramString, Uri paramUri, boolean paramBoolean)
  {
    this.p.a(paramString, paramUri, paramBoolean);
  }

  public void a(List<z> paramList)
  {
    this.s.a(paramList);
  }

  public void a(List<z> paramList, int paramInt1, int paramInt2)
  {
    this.s.a(paramList, paramInt1, paramInt2);
  }

  public void a(List<z> paramList, c.b paramb)
  {
    this.s.a(paramList, paramb);
  }

  public void a(boolean paramBoolean)
  {
    this.p.a(paramBoolean);
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.p.b(paramConversationItemLoaderEntity);
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, com.viber.voip.model.h paramh)
  {
    this.p.b(paramConversationItemLoaderEntity, paramh);
  }

  public void b(boolean paramBoolean)
  {
    this.p.a(paramBoolean);
  }

  public void c()
  {
    this.p.c();
  }

  public void c(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.p.c(paramConversationItemLoaderEntity);
  }

  public void c(ConversationItemLoaderEntity paramConversationItemLoaderEntity, com.viber.voip.model.h paramh)
  {
    this.p.c(paramConversationItemLoaderEntity, paramh);
  }

  public void c(boolean paramBoolean)
  {
    this.s.a(paramBoolean);
  }

  public void c_(long paramLong)
  {
  }

  public void d()
  {
    this.p.d();
  }

  public void d_(String paramString)
  {
    this.p.d_(paramString);
  }

  public void e()
  {
    this.p.e();
  }

  public void f()
  {
    this.p.f();
  }

  public void g()
  {
    this.p.g();
  }

  public void h()
  {
    this.p.h();
  }

  public void k()
  {
    this.p.k();
  }

  public void l()
  {
    ad.a().b(this);
  }

  public void m()
  {
    com.viber.voip.ui.dialogs.l.g().b(this);
  }

  public void n()
  {
    com.viber.voip.ui.dialogs.k.n().b(this);
  }

  public void o()
  {
    com.viber.voip.ui.dialogs.l.p().b(this);
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    if (this.p.a(paramMenuItem))
      return true;
    return super.onContextItemSelected(paramMenuItem);
  }

  public void onContextMenuClosed(Menu paramMenu)
  {
    super.onContextMenuClosed(paramMenu);
    this.p.a(paramMenu);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    this.p.a(paramContextMenu);
    this.o.d();
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(R.menu.menu_participants_list, paramMenu);
    this.t = paramMenu;
    this.n.e();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.fragment_participants_list, paramViewGroup, false);
    Bundle localBundle = getArguments();
    long l1 = localBundle.getLong("extra_conversation_id");
    int i1 = localBundle.getInt("extra_conversation_type");
    int i2 = localBundle.getInt("extra_group_role");
    long l2 = localBundle.getLong("extra_group_id");
    af localaf = UserManager.from(getActivity()).getRegistrationValues();
    CallHandler localCallHandler = ViberApplication.getInstance().getEngine(false).getCallHandler();
    g localg = g.a();
    cj localcj = cj.a(getActivity());
    com.viber.voip.invitelinks.f localf = new com.viber.voip.invitelinks.f(this.c, localcj);
    com.viber.voip.messages.conversation.adapter.a.c.a.e locale = new com.viber.voip.messages.conversation.adapter.a.c.a.e(getActivity(), i2, i1);
    locale.a(l2);
    this.q = new ac(getActivity(), true, true, getLoaderManager(), this.d, this, com.viber.voip.h.a.b());
    this.q.r();
    this.q.b(l1);
    this.q.i();
    this.q.p();
    if (com.viber.voip.messages.m.e(i1));
    for (this.r = new n(getActivity(), getLoaderManager(), this.d, this, this); ; this.r = new com.viber.voip.messages.conversation.l(getActivity(), getLoaderManager(), this.d, this, this))
    {
      this.r.a(l1);
      this.r.i();
      this.r.p();
      Handler localHandler1 = av.a(av.e.f);
      Handler localHandler2 = av.a(av.e.a);
      this.n = new al(this, locale, new p(this.g, this.h, localHandler1), localf, new com.viber.voip.invitelinks.linkscreen.f(requireActivity(), localg, null), this.j, (bv)this.i.get(), this.h.getConnectionListener(), this.b, localHandler2, localHandler1);
      this.o = new u(this.m, this, this.e, this.f, localaf, localCallHandler, this.i, new cn(getResources()), this.g, localHandler2, null, this.b, this.k, com.viber.voip.h.a.b(), c.f.d, "Participants List", this.a.a(getContext()));
      com.viber.voip.registration.changephonenumber.d.a locala = ViberApplication.getInstance().getChangePhoneNumberController().b();
      bm localbm = new bm(requireActivity(), locala, this.j);
      this.p = new y(this, this.mIsTablet, this.o, this.l, localbm, i1);
      this.s = new ab(this, com.viber.voip.util.e.e.a(getActivity()), com.viber.voip.util.e.f.b(getActivity()), locale, getLayoutInflater());
      RecyclerView localRecyclerView = (RecyclerView)localView.findViewById(R.id.recycler_view);
      ((SimpleItemAnimator)localRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
      localRecyclerView.addItemDecoration(new ah(getActivity(), this.s));
      localRecyclerView.setAdapter(this.s);
      localRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener()
      {
        public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
        }

        public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager();
          int i = localLinearLayoutManager.getChildCount();
          int j = localLinearLayoutManager.getItemCount();
          if (i + localLinearLayoutManager.findFirstVisibleItemPosition() >= j)
            ae.b(ae.this).f();
        }
      });
      return localView;
    }
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    this.q.q();
    this.r.q();
    this.n.i();
    this.n = null;
    this.o.c();
    this.o = null;
    this.p.l();
    this.p = null;
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    this.p.a(paramm, paramInt);
  }

  public void onLoadFinished(com.viber.provider.d paramd, boolean paramBoolean)
  {
    if ((paramd instanceof ac))
      this.n.a(this.q, paramBoolean);
    while (!(paramd instanceof com.viber.voip.messages.conversation.l))
      return;
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.r.e(0);
    this.n.a((PublicGroupConversationItemLoaderEntity)localConversationItemLoaderEntity, paramBoolean);
    this.o.a(localConversationItemLoaderEntity);
  }

  public void onLoaderReset(com.viber.provider.d paramd)
  {
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i1 = paramMenuItem.getItemId();
    if (R.id.menu_share_group_link == i1)
      this.n.g();
    while (true)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      if (R.id.menu_add_members == i1)
        this.n.h();
    }
  }

  public void onOptionsMenuClosed(Menu paramMenu)
  {
    this.t = null;
  }

  public void onStart()
  {
    super.onStart();
    this.l.a(this.u);
    this.o.a();
  }

  public void onStop()
  {
    super.onStop();
    this.l.b(this.u);
    this.o.b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.ae
 * JD-Core Version:    0.6.2
 */