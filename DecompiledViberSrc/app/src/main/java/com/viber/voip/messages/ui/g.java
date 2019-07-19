package com.viber.voip.messages.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.viber.provider.d.a;
import com.viber.voip.R.anim;
import com.viber.voip.R.layout;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.messages.conversation.n;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.m;
import com.viber.voip.ui.ViberListView;
import java.util.Collections;
import java.util.Map;

public abstract class g extends h
  implements d.a
{
  protected n<RegularConversationLoaderEntity> a;
  protected f b;
  protected ViberListView c;
  private com.viber.voip.services.inbox.a d;

  public g()
  {
    super(-1);
  }

  protected abstract n<RegularConversationLoaderEntity> a(Bundle paramBundle, Context paramContext);

  protected abstract f a(Context paramContext, LayoutInflater paramLayoutInflater);

  public void a(com.viber.voip.messages.adapters.a.a parama, boolean paramBoolean)
  {
    b(parama.i());
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
    {
      Intent localIntent = m.a(new ConversationData(parama), false);
      localIntent.putExtra("clicked", paramBoolean);
      localIntent.setExtrasClassLoader(localFragmentActivity.getClassLoader());
      localFragmentActivity.startActivity(localIntent);
      localFragmentActivity.overridePendingTransition(R.anim.screen_in, R.anim.screen_no_transition);
    }
  }

  public void a(String paramString)
  {
  }

  public void a(boolean paramBoolean)
  {
  }

  protected abstract int b();

  public void b(long paramLong)
  {
    this.b.a(paramLong);
  }

  protected boolean c()
  {
    return (this.a != null) && (this.a.d());
  }

  protected void e()
  {
  }

  protected void h()
  {
    this.a.p();
    this.a.i();
  }

  public void m()
  {
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.b = a(getContext(), getLayoutInflater());
    setListAdapter(this.b);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
    this.d = new com.viber.voip.services.inbox.a(b());
    this.a = a(paramBundle, getContext());
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.fragment_inbox, paramViewGroup, false);
    this.c = ((ViberListView)localView.findViewById(16908298));
    registerForContextMenu(this.c);
    return localView;
  }

  public void onDestroyView()
  {
    this.a.q();
    unregisterForContextMenu(this.c);
    this.c = null;
    super.onDestroyView();
  }

  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }

  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    if (!w().l())
    {
      com.viber.voip.ui.g.d locald = a(paramView.getTag());
      if ((locald != null) && (((com.viber.voip.messages.adapters.a.a)locald.d()).i() > 0L))
        a(paramListView, paramView, paramInt, true);
      return;
    }
    super.onListItemClick(paramListView, paramView, paramInt, paramLong);
  }

  public void onLoadFinished(com.viber.provider.d paramd, boolean paramBoolean)
  {
    if (this.a == paramd)
    {
      this.d.d(false);
      this.b.notifyDataSetChanged();
      if (paramBoolean)
        getListView().setEmptyView(this.d.a());
      w().p();
      if (w().l())
        D();
    }
  }

  public void onLoaderReset(com.viber.provider.d paramd)
  {
  }

  public void onStart()
  {
    super.onStart();
    if (this.a != null)
      this.a.c();
  }

  public void onStop()
  {
    super.onStop();
    if (this.a != null)
      this.a.y_();
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.d.a(paramView, true);
  }

  public boolean p()
  {
    return (this.b != null) && (!this.b.isEmpty());
  }

  public boolean r()
  {
    return false;
  }

  public Map<Long, MessagesFragmentModeManager.b> s()
  {
    if (this.a == null)
      return Collections.emptyMap();
    return this.a.B();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.g
 * JD-Core Version:    0.6.2
 */