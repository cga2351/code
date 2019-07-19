package com.viber.voip.messages.extensions.b;

import android.app.Activity;
import android.arch.lifecycle.e.b;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.b.c.a.j;
import com.viber.voip.ads.b.c.b.a;
import com.viber.voip.ads.b.c.b.a.a;
import com.viber.voip.ads.b.c.b.f.c;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import com.viber.voip.messages.extensions.ui.ChatExtensionListConstraintHelper;
import com.viber.voip.messages.extensions.ui.p;
import com.viber.voip.ui.aq;
import com.viber.voip.util.bm;
import javax.inject.Inject;
import javax.inject.Named;

public class d extends aq
  implements com.viber.provider.d.a, f.c
{
  private static final Logger f = ViberEnv.getLogger();

  @Inject
  dagger.a<bv> a;

  @Inject
  com.viber.voip.util.e.e b;

  @Inject
  com.viber.voip.app.b c;

  @Inject
  @Named("com.viber.voip.ChatExtAdsController")
  com.viber.voip.ads.b.c.b.f d;

  @Inject
  com.viber.voip.ads.b.c.a.b e;
  private ChatExtensionListConstraintHelper g;
  private RecyclerView h;
  private RecyclerView i;
  private com.viber.voip.messages.extensions.c.d j;
  private com.viber.voip.messages.extensions.c.c k;
  private p l;
  private com.viber.voip.messages.extensions.ui.a m;
  private com.viber.voip.ui.a.b n;
  private final com.viber.voip.ui.a.a o = new e(this);
  private final com.viber.voip.ui.a.a p = new f(this);
  private a q;
  private final com.viber.voip.ads.b.c.a<com.viber.voip.ads.b.c.c.c> r = new com.viber.voip.ads.b.c.a()
  {
    public void a()
    {
      if (!bm.a(d.this.getLifecycle(), e.b.d));
      while (d.a(d.this) == null)
        return;
      d.a(d.this).a(null);
    }

    public void a(com.viber.voip.ads.b.c.c.c paramAnonymousc)
    {
      if (!bm.a(d.this.getLifecycle(), e.b.d));
      do
      {
        return;
        if (d.a(d.this) != null)
          d.a(d.this).a(paramAnonymousc);
      }
      while (d.this.d == null);
      d.b(d.this).post(new g(this));
    }
  };

  private void a(Activity paramActivity)
  {
    if (c())
    {
      b.a locala = new b.a.a(paramActivity).a(false).a();
      this.d.a(locala, this.r);
    }
  }

  private void a(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof ChatExtensionLoaderEntity)))
      a((ChatExtensionLoaderEntity)localObject);
  }

  public static d b()
  {
    return new d();
  }

  private boolean c()
  {
    return (this.d != null) && (this.d.e()) && (!this.d.d()) && ((this.c.a(requireContext())) || (!this.c.a()));
  }

  public void N_()
  {
    if (this.n != null)
      this.n.a(false);
  }

  void a(ChatExtensionLoaderEntity paramChatExtensionLoaderEntity)
  {
    if ((paramChatExtensionLoaderEntity == null) || (this.q == null))
      return;
    this.q.a(paramChatExtensionLoaderEntity);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    LoaderManager localLoaderManager = getLoaderManager();
    Context localContext = requireContext();
    this.j = new com.viber.voip.messages.extensions.c.d(localContext, localLoaderManager, this.a, this);
    this.k = new com.viber.voip.messages.extensions.c.c(localContext, localLoaderManager, this.a, this);
    this.l = new p(localContext, this.b, this.j, this.o);
    this.m = new com.viber.voip.messages.extensions.ui.a(localContext, this.b, this.c, this.k, this.p);
    Object localObject = this.m;
    if ((this.d != null) && (this.d.e()) && ((this.c.a(requireContext())) || (!this.c.a())))
    {
      j localj = new j(localContext, this.d, this.m);
      this.n = new com.viber.voip.ui.a.b(localContext, this.m, localj, com.viber.voip.ads.b.b.b.c.j, this.e, R.layout.view_chat_ext_ad_cell, R.id.chat_ext_ad_tag, 3);
      this.n.a(this.d.j());
      localObject = this.n;
    }
    this.h.setAdapter(this.l);
    this.i.setAdapter((RecyclerView.Adapter)localObject);
    this.j.i();
    this.k.i();
    if (this.d != null)
    {
      this.d.b(this.i, this.m);
      this.d.a(this);
    }
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
    Fragment localFragment = getParentFragment();
    if (!(localFragment instanceof a))
      throw new RuntimeException("parent must implement ChatExtensionListFragment.Callback interface");
    this.q = ((a)localFragment);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i1;
    if ((this.c.a(requireContext())) || (!this.c.a()))
    {
      i1 = 1;
      if (i1 == 0)
        break label167;
    }
    label167: for (int i2 = R.layout.fragment_chat_extension_list_port; ; i2 = R.layout.fragment_chat_extension_list_land)
    {
      View localView = paramLayoutInflater.inflate(i2, paramViewGroup, false);
      Resources localResources = localView.getResources();
      this.g = ((ChatExtensionListConstraintHelper)localView.findViewById(R.id.chatExtensionListHelper));
      this.h = ((RecyclerView)localView.findViewById(R.id.recentExtensionsList));
      this.i = ((RecyclerView)localView.findViewById(R.id.chatExtensionsList));
      this.i.setItemAnimator(null);
      this.h.addItemDecoration(new com.viber.voip.widget.a.b(localResources.getDimensionPixelSize(R.dimen.chatex_recents_header_footer_size), 0));
      if (i1 == 0)
        this.i.addItemDecoration(new com.viber.voip.widget.a.b(localResources.getDimensionPixelSize(R.dimen.chatex_recents_header_footer_size), 0));
      return localView;
      i1 = 0;
      break;
    }
  }

  public void onDestroyView()
  {
    this.j.j();
    this.k.j();
    if (this.d != null)
    {
      this.d.m();
      this.d.b(this);
    }
    super.onDestroyView();
  }

  public void onDetach()
  {
    this.q = null;
    super.onDetach();
  }

  public void onLoadFinished(com.viber.provider.d paramd, boolean paramBoolean)
  {
    boolean bool = true;
    if (getActivity() == null);
    do
    {
      return;
      if (paramd == this.j)
      {
        ChatExtensionListConstraintHelper localChatExtensionListConstraintHelper2 = this.g;
        if (this.j.getCount() > 0);
        while (true)
        {
          localChatExtensionListConstraintHelper2.setRecentsSectionVisible(bool);
          this.l.notifyDataSetChanged();
          return;
          bool = false;
        }
      }
    }
    while (paramd != this.k);
    ChatExtensionListConstraintHelper localChatExtensionListConstraintHelper1 = this.g;
    if (this.k.getCount() > 0);
    while (true)
    {
      localChatExtensionListConstraintHelper1.setGeneralSectionVisible(bool);
      this.m.notifyDataSetChanged();
      FragmentActivity localFragmentActivity = getActivity();
      if (localFragmentActivity == null)
        break;
      a(localFragmentActivity);
      return;
      bool = false;
    }
  }

  public void onLoaderReset(com.viber.provider.d paramd)
  {
  }

  public void onPause()
  {
    super.onPause();
    if (this.d != null)
      this.d.k();
  }

  public void onStart()
  {
    super.onStart();
    this.j.p();
    this.k.p();
  }

  public void onStop()
  {
    this.j.q();
    this.k.q();
    super.onStop();
  }

  public static abstract interface a
  {
    public abstract void a(ChatExtensionLoaderEntity paramChatExtensionLoaderEntity);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.b.d
 * JD-Core Version:    0.6.2
 */