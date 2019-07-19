package com.viber.voip.services.inbox.screen;

import android.arch.lifecycle.e.b;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.b.c.b.a;
import com.viber.voip.ads.b.c.b.a.a;
import com.viber.voip.i.c.b;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.messages.conversation.n;
import com.viber.voip.messages.j;
import com.viber.voip.messages.ui.MessagesFragmentModeManager;
import com.viber.voip.messages.ui.MessagesFragmentModeManager.b;
import com.viber.voip.messages.ui.g;
import com.viber.voip.stickers.i;
import com.viber.voip.ui.ViberListView;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.as;
import com.viber.voip.ui.dialogs.p;
import com.viber.voip.ui.g.d;
import com.viber.voip.util.bm;
import com.viber.voip.util.dg;
import com.viber.voip.util.e.e;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;

public class a extends g
{
  private static final Logger t = ViberEnv.getLogger();

  @Inject
  com.viber.voip.messages.d.b d;

  @Inject
  i e;

  @Inject
  Engine m;

  @Inject
  ICdrController n;

  @Inject
  @Named("com.viber.voip.BusinessInboxAdsController")
  com.viber.voip.ads.b.c.b.f o;

  @Inject
  e p;

  @Inject
  com.viber.voip.ads.b.c.a.b q;

  @Inject
  com.viber.voip.analytics.story.e.c r;

  @Inject
  com.viber.voip.analytics.story.a.a s;
  private com.viber.voip.messages.ui.a u;
  private final com.viber.voip.ads.b.c.a<com.viber.voip.ads.b.c.c.c> v = new com.viber.voip.ads.b.c.a()
  {
    public void a()
    {
      if (!bm.a(a.this.getLifecycle(), e.b.d))
        return;
      a.a(a.this).a(null);
    }

    public void a(com.viber.voip.ads.b.c.c.c paramAnonymousc)
    {
      if (!bm.a(a.this.getLifecycle(), e.b.d))
        return;
      a.a(a.this).a(paramAnonymousc);
    }
  };

  private void a(ConversationLoaderEntity paramConversationLoaderEntity)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Long.valueOf(paramConversationLoaderEntity.getId()), new MessagesFragmentModeManager.b(paramConversationLoaderEntity.isGroupBehavior(), paramConversationLoaderEntity.isMuteConversation(), true, paramConversationLoaderEntity.getConversationType(), paramConversationLoaderEntity.getGroupRole(), paramConversationLoaderEntity.getFlags(), paramConversationLoaderEntity.getAppId(), paramConversationLoaderEntity.getWatchersCount()));
    a(localHashMap);
  }

  public static a d()
  {
    return new a();
  }

  private void f()
  {
    if (this.a.getCount() == 0)
      return;
    p.c().a(new ViberDialogHandlers.as("Business Inbox settings")).a(getActivity());
  }

  protected n<RegularConversationLoaderEntity> a(Bundle paramBundle, Context paramContext)
  {
    return new c(paramContext, getLoaderManager(), this.j, paramBundle, this, com.viber.voip.h.a.b());
  }

  protected com.viber.voip.messages.ui.f a(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    return new com.viber.voip.messages.ui.f(paramContext, this.a, e.a(paramContext), this.d, new com.viber.voip.messages.ui.ai(paramContext), new j(paramContext), this.j, w(), this.e, paramLayoutInflater);
  }

  protected int b()
  {
    return R.layout.empty_business_inbox;
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    d locald = a(((AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo()).targetView.getTag());
    if (locald == null)
      return super.onContextItemSelected(paramMenuItem);
    ConversationLoaderEntity localConversationLoaderEntity = ((com.viber.voip.messages.adapters.a.a)locald.d()).a();
    int i = paramMenuItem.getItemId();
    if (i == R.id.menu_move_to_main_chat_list)
    {
      this.s.e("From Business Inbox");
      ((com.viber.voip.messages.controller.ai)this.k.get()).b(localConversationLoaderEntity.getId(), localConversationLoaderEntity.getConversationType());
      return true;
    }
    if (i == R.id.menu_delete_chat)
    {
      this.r.a(localConversationLoaderEntity);
      a(localConversationLoaderEntity);
      return true;
    }
    if (i == R.id.menu_debug_options)
    {
      w().a(Collections.singleton(Long.valueOf(localConversationLoaderEntity.getId())));
      return true;
    }
    return super.onContextItemSelected(paramMenuItem);
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    d locald = a(((AdapterView.AdapterContextMenuInfo)paramContextMenuInfo).targetView.getTag());
    if (locald == null);
    ConversationLoaderEntity localConversationLoaderEntity;
    do
    {
      return;
      localConversationLoaderEntity = ((com.viber.voip.messages.adapters.a.a)locald.d()).a();
    }
    while (localConversationLoaderEntity == null);
    String str = dg.b(localConversationLoaderEntity);
    View localView = getLayoutInflater().inflate(R.layout.context_menu_header, null);
    ((TextView)localView.findViewById(R.id.text)).setText(str);
    paramContextMenu.setHeaderView(localView);
    paramContextMenu.add(0, R.id.menu_delete_chat, 0, R.string.menu_delete_chat);
    if (localConversationLoaderEntity.getAppId() != 12829)
      paramContextMenu.add(0, R.id.menu_move_to_main_chat_list, 0, getString(R.string.menu_move_to_main_chat_list));
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(R.menu.menu_business_inbox, paramMenu);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }

  public void onDestroy()
  {
    super.onDestroy();
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.o != null)
      this.o.m();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == R.id.menu_clear_all)
    {
      f();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public void onPause()
  {
    super.onPause();
    if (this.o != null)
      this.o.k();
  }

  public void onResume()
  {
    super.onResume();
    if (this.u != null)
    {
      FragmentActivity localFragmentActivity = getActivity();
      if (localFragmentActivity != null)
      {
        b.a locala = new b.a.a(localFragmentActivity).a(false).a();
        this.o.a(locala, this.v);
      }
    }
  }

  public void setListAdapter(ListAdapter paramListAdapter)
  {
    Context localContext = getContext();
    if ((c.b.m.e()) && (localContext != null))
    {
      if (this.u == null)
      {
        com.viber.voip.ads.b.c.b.f localf = this.o;
        ViberListView localViberListView = this.c;
        MessagesFragmentModeManager localMessagesFragmentModeManager = w();
        com.viber.voip.ads.b.c.a.c localc = new com.viber.voip.ads.b.c.a.c(localContext, this, localf, localViberListView, paramListAdapter, localMessagesFragmentModeManager);
        com.viber.voip.ads.b.b.b.c localc1 = com.viber.voip.ads.b.b.b.c.e;
        com.viber.voip.ads.b.c.a.b localb = this.q;
        int i = R.layout.view_business_inbox_ad_cell;
        this.u = new com.viber.voip.messages.ui.a(localContext, paramListAdapter, null, localc, localc1, localb, i);
        this.o.b(this.c, this.u);
      }
      paramListAdapter = this.u;
    }
    super.setListAdapter(paramListAdapter);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.services.inbox.screen.a
 * JD-Core Version:    0.6.2
 */