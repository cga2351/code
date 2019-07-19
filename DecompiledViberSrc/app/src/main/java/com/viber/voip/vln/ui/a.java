package com.viber.voip.vln.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.messages.conversation.n;
import com.viber.voip.messages.d.b;
import com.viber.voip.messages.j;
import com.viber.voip.messages.ui.MessagesFragmentModeManager;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.messages.ui.f;
import com.viber.voip.messages.ui.g;
import com.viber.voip.stickers.i;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.av;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.aw;
import com.viber.voip.ui.dialogs.p;
import com.viber.voip.ui.g.d;
import com.viber.voip.util.dg;
import com.viber.voip.util.e.e;
import java.util.Collections;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;

public class a extends g
{

  @Inject
  b d;

  @Inject
  i e;

  private void a(ConversationLoaderEntity paramConversationLoaderEntity)
  {
    p.g().a(new ViberDialogHandlers.aw(paramConversationLoaderEntity.getId(), paramConversationLoaderEntity.getConversationType())).a(getActivity());
  }

  public static a b(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("to_number", paramString);
    a locala = new a();
    locala.setArguments(localBundle);
    return locala;
  }

  private void c(String paramString)
  {
    if (this.a.getCount() == 0)
      return;
    p.f().a(new ViberDialogHandlers.av("vln_" + paramString)).a(getActivity());
  }

  protected n<RegularConversationLoaderEntity> a(Bundle paramBundle, Context paramContext)
  {
    LoaderManager localLoaderManager = getLoaderManager();
    dagger.a locala = this.j;
    EventBus localEventBus = com.viber.voip.h.a.b();
    if (getArguments() != null);
    for (String str = getArguments().getString("to_number"); ; str = null)
      return new c(paramContext, localLoaderManager, locala, paramBundle, this, localEventBus, str);
  }

  protected f a(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    return new f(paramContext, this.a, e.a(paramContext), this.d, new ai(paramContext), new j(paramContext), this.j, w(), this.e, paramLayoutInflater);
  }

  protected int b()
  {
    return R.layout.empty_sms_inbox;
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    d locald = a(((AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo()).targetView.getTag());
    if (locald == null)
      return super.onContextItemSelected(paramMenuItem);
    ConversationLoaderEntity localConversationLoaderEntity = ((com.viber.voip.messages.adapters.a.a)locald.d()).a();
    int i = paramMenuItem.getItemId();
    if (i == R.id.menu_delete_sms)
    {
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
    if (locald == null)
      return;
    String str = dg.b(((com.viber.voip.messages.adapters.a.a)locald.d()).a());
    View localView = getLayoutInflater().inflate(R.layout.context_menu_header, null);
    ((TextView)localView.findViewById(R.id.text)).setText(str);
    paramContextMenu.setHeaderView(localView);
    paramContextMenu.add(0, R.id.menu_delete_sms, 0, R.string.menu_delete_sms);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(R.menu.menu_sms_inbox, paramMenu);
  }

  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == R.id.menu_clear_all)
    {
      if (getArguments() != null)
        c(getArguments().getString("to_number"));
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.vln.ui.a
 * JD-Core Version:    0.6.2
 */