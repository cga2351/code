package com.viber.voip.messages.conversation.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.b.a;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m.c;
import com.viber.common.permission.c;
import com.viber.provider.d;
import com.viber.provider.d.a;
import com.viber.voip.R.attr;
import com.viber.voip.R.id;
import com.viber.voip.R.integer;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.adapter.j;
import com.viber.voip.messages.conversation.p;
import com.viber.voip.messages.conversation.v;
import com.viber.voip.messages.k;
import com.viber.voip.messages.ui.ConversationGalleryListView;
import com.viber.voip.permissions.e;
import com.viber.voip.permissions.n;
import com.viber.voip.ui.aq;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.o;
import com.viber.voip.util.ViberActionRunner.bm;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;

public class ax extends aq
  implements b.a, View.OnClickListener, View.OnLongClickListener, m.c, d.a
{

  @Inject
  com.viber.voip.util.e.g a;

  @Inject
  c b;
  private j c;
  private ConversationGalleryListView d;
  private v e;
  private View f;
  private View g;
  private int h;
  private android.support.v7.view.b i;
  private Set<Long> j;
  private com.viber.common.permission.b k;
  private final Runnable l;

  public ax()
  {
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(110);
    this.k = new e(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        if ((paramAnonymousObject instanceof Long))
          ax.a(ax.this, (Long)paramAnonymousObject);
      }
    };
    this.l = new Runnable()
    {
      public void run()
      {
        ax.a(ax.this).i();
      }
    };
  }

  private void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      for (long l1 : paramBundle.getLongArray("selected_ids"))
        this.j.add(Long.valueOf(l1));
      if (!this.j.isEmpty())
      {
        this.i = ((AppCompatActivity)getActivity()).startSupportActionMode(this);
        a(getActivity(), this.j.size());
      }
    }
  }

  private void a(Long paramLong)
  {
    if (this.b.a(n.m))
    {
      b(paramLong);
      return;
    }
    this.b.a(this, 110, n.m, paramLong);
  }

  private void b(Long paramLong)
  {
    Bundle localBundle = getArguments();
    ViberActionRunner.bm.a(getActivity(), localBundle.getLong("conversation_id"), localBundle.getInt("conversation_type"), paramLong.longValue(), localBundle.getString("conversation_name"), null, true, false, localBundle.getBoolean("is_share_and_forward_available", true), localBundle.getInt("group_role", -1), true);
  }

  private void c(Long paramLong)
  {
    if (this.j.contains(paramLong))
      this.j.remove(paramLong);
    while (true)
    {
      this.c.a(this.j);
      if (!this.j.isEmpty())
        break;
      this.i.c();
      this.i = null;
      return;
      this.j.add(paramLong);
    }
    a(getActivity(), this.j.size());
  }

  public void a(Context paramContext, int paramInt)
  {
    View localView1 = this.i.i();
    if (localView1 == null)
    {
      localView1 = View.inflate(paramContext, R.layout.view_custom_action_mode, null);
      localView1.findViewById(R.id.count).setVisibility(8);
      this.i.a(localView1);
    }
    View localView2 = localView1;
    ((TextView)localView2.findViewById(R.id.title)).setText(String.valueOf(paramInt));
    ViewParent localViewParent = localView2.getParent();
    if ((localViewParent instanceof View))
      dj.a((View)localViewParent, dc.g(paramContext, R.attr.toolbarBackground));
  }

  public void a(android.support.v7.view.b paramb)
  {
    this.i = null;
    this.j.clear();
    this.c.a(null);
  }

  public boolean a(android.support.v7.view.b paramb, Menu paramMenu)
  {
    paramb.a().inflate(R.menu.action_mode_menu_messages, paramMenu);
    paramMenu.findItem(R.id.menu_select_all).setVisible(false);
    paramMenu.findItem(R.id.menu_conversation_system_info).setVisible(false);
    return true;
  }

  public boolean a(android.support.v7.view.b paramb, MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == R.id.menu_delete)
    {
      if (this.j.size() > 1);
      for (l.a locala = o.b(); ; locala = o.a())
      {
        locala.a(this).b(this);
        return true;
      }
    }
    return false;
  }

  public boolean b(android.support.v7.view.b paramb, Menu paramMenu)
  {
    return false;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.h = getResources().getInteger(R.integer.gallery_images_per_row);
    this.e = new p(getActivity(), getActivity().getSupportLoaderManager(), ViberApplication.getInstance().getLazyMessagesManager(), this, com.viber.voip.h.a.b(), this.h);
    this.e.p();
    this.e.a(getArguments().getLong("conversation_id"));
    dj.a(this.d, this.l);
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
  }

  public void onClick(View paramView)
  {
    FragmentActivity localFragmentActivity;
    if (paramView.getId() == R.id.emptyButton)
    {
      localFragmentActivity = getActivity();
      if (localFragmentActivity == null)
        break label111;
    }
    label111: for (int m = localFragmentActivity.getIntent().getIntExtra("conversation_type", 0); ; m = 0)
    {
      Intent localIntent = com.viber.voip.messages.m.a(this.e.I(), m, false, false, false, false);
      localIntent.addFlags(67108864);
      localIntent.putExtra("open_custom_menu", "gallery");
      startActivity(localIntent);
      getActivity().finish();
      return;
      Long localLong = (Long)paramView.getTag();
      if (this.i == null)
      {
        a(localLong);
        return;
      }
      c(localLong);
      return;
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    ((AppCompatActivity)getActivity()).getSupportActionBar().b(R.string.media);
    ((AppCompatActivity)getActivity()).getSupportActionBar().b(getArguments().getString("conversation_name"));
    View localView = paramLayoutInflater.inflate(R.layout.layout_conversation_gallery, null);
    this.d = ((ConversationGalleryListView)localView.findViewById(R.id.list));
    this.f = localView.findViewById(R.id.progress);
    this.g = localView.findViewById(R.id.emptyView);
    localView.findViewById(R.id.emptyButton).setOnClickListener(this);
    this.j = new HashSet();
    a(paramBundle);
    return localView;
  }

  public void onDestroyView()
  {
    if (this.e != null)
      this.e.q();
    super.onDestroyView();
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if (((paramm.a(DialogCode.D245)) || (paramm.a(DialogCode.D245a))) && (paramInt == -1))
    {
      ViberApplication.getInstance().getMessagesManager().c().a(new HashSet(this.j), true, null);
      this.i.c();
      this.i = null;
    }
  }

  public void onLoadFinished(d paramd, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c = new j(getActivity(), this.a, this.h, (p)paramd, this.j);
      this.c.a(this);
      this.c.a(this);
      this.c.b(com.viber.voip.backgrounds.g.a(getActivity(), this.d));
      this.d.setAdapter(this.c);
      this.f.setVisibility(8);
    }
    while (true)
    {
      if (paramd.getCount() == 0)
      {
        this.g.setVisibility(0);
        this.d.setVisibility(8);
      }
      return;
      this.c.notifyDataSetChanged();
    }
  }

  public void onLoaderReset(d paramd)
  {
  }

  public boolean onLongClick(View paramView)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null)
      return false;
    if (com.viber.voip.messages.m.e(localFragmentActivity.getIntent().getIntExtra("conversation_type", 0)))
      return false;
    if (this.i == null)
      this.i = ((AppCompatActivity)localFragmentActivity).startSupportActionMode(this);
    c((Long)paramView.getTag());
    return true;
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    long[] arrayOfLong = new long[this.j.size()];
    Iterator localIterator = this.j.iterator();
    int n;
    for (int m = 0; localIterator.hasNext(); m = n)
    {
      Long localLong = (Long)localIterator.next();
      n = m + 1;
      arrayOfLong[m] = localLong.longValue();
    }
    paramBundle.putLongArray("selected_ids", arrayOfLong);
  }

  public void onStart()
  {
    super.onStart();
    this.b.a(this.k);
  }

  public void onStop()
  {
    super.onStop();
    this.b.b(this.k);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.ax
 * JD-Core Version:    0.6.2
 */