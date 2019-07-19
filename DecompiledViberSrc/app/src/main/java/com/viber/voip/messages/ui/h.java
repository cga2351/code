package com.viber.voip.messages.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.au;
import com.viber.voip.banner.e;
import com.viber.voip.messages.adapters.a.b.s;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.k;
import com.viber.voip.ui.o;
import com.viber.voip.util.dj;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;

public abstract class h extends o
  implements View.OnTouchListener, AdapterView.OnItemLongClickListener, MessagesFragmentModeManager.a, MessagesFragmentModeManager.c
{
  private MessagesFragmentModeManager a;
  private boolean b;
  protected boolean f = false;
  protected boolean g = false;
  protected boolean h = false;
  protected long i;

  @Inject
  protected dagger.a<k> j;

  @Inject
  protected dagger.a<ai> k;

  @Inject
  protected dagger.a<com.viber.voip.messages.controller.publicaccount.d> l;

  public h(int paramInt)
  {
    super(paramInt);
  }

  private void a(MessagesFragmentModeManager.MessagesFragmentModeManagerData paramMessagesFragmentModeManagerData, final boolean paramBoolean)
  {
    this.a = a(paramMessagesFragmentModeManagerData, new MessagesFragmentModeManager.d()
    {
      public void a()
      {
        if ((paramBoolean) && (h.a(h.this) != null))
          h.a(h.this).d();
      }
    });
  }

  private boolean a(MessagesFragmentModeManager.MessagesFragmentModeManagerData paramMessagesFragmentModeManagerData, Bundle paramBundle)
  {
    boolean bool = dj.c(getActivity());
    if ((paramMessagesFragmentModeManagerData != null) && (this.mIsTablet))
    {
      if ((!bool) && (paramMessagesFragmentModeManagerData.savedMode == 1))
        return true;
      if ((paramMessagesFragmentModeManagerData.savedMode == 2) && (TextUtils.isEmpty(paramMessagesFragmentModeManagerData.getSavedQuery())))
      {
        paramMessagesFragmentModeManagerData.savedMode = 0;
        paramMessagesFragmentModeManagerData.clearSavedQuery();
        paramBundle.remove("conversation_search_result");
      }
    }
    return false;
  }

  protected MessagesFragmentModeManager a(MessagesFragmentModeManager.MessagesFragmentModeManagerData paramMessagesFragmentModeManagerData, MessagesFragmentModeManager.d paramd)
  {
    return new MessagesFragmentModeManager(this, this, paramMessagesFragmentModeManagerData, paramd, this.mIsTablet);
  }

  protected com.viber.voip.ui.g.d<com.viber.voip.messages.adapters.a.a, com.viber.voip.messages.adapters.a.c.a> a(Object paramObject)
  {
    if (paramObject == null)
      return null;
    if ((paramObject instanceof com.viber.voip.ui.g.a))
      return ((com.viber.voip.ui.g.a)paramObject).a();
    if ((paramObject instanceof com.viber.voip.ui.g.d))
      return (com.viber.voip.ui.g.d)paramObject;
    return null;
  }

  protected String a(Context paramContext)
  {
    return paramContext.getResources().getString(R.string.messages_search);
  }

  public void a(long paramLong, int paramInt)
  {
    if (this.a != null)
      this.a.n();
    ((ai)this.k.get()).a(Collections.singleton(Long.valueOf(paramLong)), paramInt);
  }

  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    int m = 1;
    if (this.a != null)
      this.a.n();
    if (!paramBoolean)
      Toast.makeText(getContext(), R.string.snooze_community_pref_body, m).show();
    ai localai = (ai)this.k.get();
    if (!paramBoolean);
    while (true)
    {
      localai.a(paramLong, m, paramInt, System.currentTimeMillis());
      return;
      int n = 0;
    }
  }

  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((getActivity() == null) || (getActivity().isFinishing()));
    while (true)
    {
      return;
      ListAdapter localListAdapter = getListAdapter();
      if ((localListAdapter != null) && ((paramBoolean2) || (getListView().getItemIdAtPosition(u()) != paramLong)) && (!w().k()))
      {
        int m = localListAdapter.getCount();
        for (int n = 0; ; n++)
        {
          if (n >= m)
            break label166;
          if (paramLong == localListAdapter.getItemId(n))
          {
            if ((this.mIsTablet) && (!this.f) && (!this.b))
              a((com.viber.voip.messages.adapters.a.a)localListAdapter.getItem(n), false);
            while (!w().l())
            {
              d(n);
              D();
              return;
              b(paramLong);
            }
            break;
          }
        }
        label166: if ((paramBoolean1) && (localListAdapter.getCount() > 0) && (this.mIsTablet))
        {
          Object localObject = localListAdapter.getItem(0);
          int i1;
          if ((localObject instanceof com.viber.voip.messages.adapters.b))
          {
            i1 = 1;
            localObject = localListAdapter.getItem(i1);
          }
          while ((localObject instanceof com.viber.voip.messages.adapters.a.a))
          {
            a((com.viber.voip.messages.adapters.a.a)localObject, false);
            d(i1);
            D();
            return;
            i1 = 0;
          }
        }
      }
    }
  }

  protected void a(ListView paramListView, View paramView, int paramInt, boolean paramBoolean)
  {
    d(paramInt);
    com.viber.voip.ui.g.d locald = a(paramView.getTag());
    if (locald == null);
    do
    {
      com.viber.voip.messages.adapters.a.a locala;
      do
      {
        return;
        locala = (com.viber.voip.messages.adapters.a.a)locald.d();
      }
      while ((locala == null) || (w().l()));
      a(locala, paramBoolean);
    }
    while ((!r()) && (!v()));
    paramListView.setEnabled(false);
    paramListView.postDelayed(new a(paramListView, null), 1000L);
  }

  public abstract void a(com.viber.voip.messages.adapters.a.a parama, boolean paramBoolean);

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramConversationItemLoaderEntity != null))
    {
      c(paramConversationItemLoaderEntity.getId());
      a(paramConversationItemLoaderEntity.getId(), false, paramBoolean);
    }
  }

  public void a(Map<Long, MessagesFragmentModeManager.b> paramMap)
  {
    if (this.a != null)
      this.a.n();
    ((ai)this.k.get()).a(paramMap.keySet(), ((MessagesFragmentModeManager.b)paramMap.values().iterator().next()).f);
  }

  public final boolean a()
  {
    MessagesFragmentModeManager localMessagesFragmentModeManager = w();
    return (localMessagesFragmentModeManager != null) && (localMessagesFragmentModeManager.k());
  }

  public void b(int paramInt)
  {
    if (this.mIsTablet)
    {
      if (1 == paramInt)
        break label34;
      a(this.i, false, false);
    }
    while (paramInt == 0)
    {
      this.mRemoteBannerDisplayController.c();
      return;
      label34: getListView().setItemChecked(0, false);
    }
    this.mRemoteBannerDisplayController.d();
  }

  public abstract void b(long paramLong);

  public void b(Map<Long, MessagesFragmentModeManager.b> paramMap)
  {
    if (this.a != null)
      this.a.n();
    ((ai)this.k.get()).a(paramMap.keySet(), true, ((MessagesFragmentModeManager.b)paramMap.values().iterator().next()).f);
    Toast.makeText(getActivity(), R.string.conversation_muted_toast, 1).show();
  }

  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  public void c(long paramLong)
  {
    this.i = paramLong;
  }

  public void c(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }

  public void d(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getListView().setOnTouchListener(this);
    getListView().setOnItemLongClickListener(this);
    this.a.b(u());
  }

  public boolean onActivitySearchRequested()
  {
    if (this.a != null)
      return this.a.q();
    return false;
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
  }

  public boolean onBackPressed()
  {
    if (getActivity() == null);
    while ((this.a == null) || (!this.a.r()))
      return false;
    return true;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    MessagesFragmentModeManager.MessagesFragmentModeManagerData localMessagesFragmentModeManagerData = null;
    boolean bool = false;
    if (paramBundle != null)
    {
      localMessagesFragmentModeManagerData = (MessagesFragmentModeManager.MessagesFragmentModeManagerData)paramBundle.getParcelable("mode_manager");
      bool = a(localMessagesFragmentModeManagerData, paramBundle);
      this.i = paramBundle.getLong("last_selected_conversation", 0L);
    }
    a(localMessagesFragmentModeManagerData, bool);
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    if (this.a != null)
      this.a.a(paramMenu, g(), a(ViberApplication.getApplication()));
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
  }

  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    MessagesFragmentModeManager localMessagesFragmentModeManager = this.a;
    boolean bool1 = false;
    com.viber.voip.ui.g.d locald;
    if (localMessagesFragmentModeManager != null)
    {
      boolean bool2 = r();
      bool1 = false;
      if (!bool2)
      {
        Object localObject = paramView.getTag();
        locald = a(localObject);
        boolean bool3 = localObject instanceof s;
        bool1 = false;
        if (!bool3)
          break label74;
      }
    }
    while (true)
    {
      if (bool1)
        getListView().setItemChecked(paramInt, true);
      return bool1;
      label74: bool1 = false;
      if (locald != null)
      {
        MessagesFragmentModeManager.b localb = this.a.a((com.viber.voip.messages.adapters.a.a)locald.d());
        bool1 = this.a.a(((com.viber.voip.messages.adapters.a.a)locald.d()).i(), localb);
      }
    }
  }

  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    com.viber.voip.ui.g.d locald;
    if (this.a.l())
    {
      Object localObject = paramView.getTag();
      locald = a(localObject);
      if (!(localObject instanceof s))
        break label33;
    }
    label33: 
    while (locald == null)
      return;
    com.viber.voip.messages.adapters.a.a locala = (com.viber.voip.messages.adapters.a.a)locald.d();
    MessagesFragmentModeManager.b localb = this.a.a(locala);
    this.a.b(locala.i(), localb);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == R.id.menu_search)
    {
      this.a.b(false);
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (g())
    {
      paramBundle.putParcelable("mode_manager", this.a.a());
      paramBundle.putLong("last_selected_conversation", this.i);
    }
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.a != null) && (getView() != null) && ((paramView == getListView()) || (paramView.getId() == 16908292)) && (paramMotionEvent.getAction() == 0))
      this.a.s();
    return false;
  }

  public void q()
  {
  }

  public abstract boolean r();

  public boolean v()
  {
    FragmentActivity localFragmentActivity = getActivity();
    return ((localFragmentActivity instanceof au)) && (((au)localFragmentActivity).s());
  }

  public MessagesFragmentModeManager w()
  {
    return this.a;
  }

  private class a extends com.viber.voip.d.b<ListView>
  {
    private a(ListView arg2)
    {
      super();
    }

    public void a(ListView paramListView)
    {
      paramListView.setEnabled(true);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.h
 * JD-Core Version:    0.6.2
 */