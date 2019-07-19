package com.viber.voip.block;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView.LayoutParams;
import com.viber.provider.d.a;
import com.viber.voip.R.attr;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.ViberApplication;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.d.b;
import com.viber.voip.model.entity.m;
import com.viber.voip.ui.au;
import com.viber.voip.util.dc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;

public class d extends au
  implements d.a, c.b, q.b
{

  @Inject
  com.viber.voip.analytics.story.d.c a;

  @Inject
  com.viber.voip.analytics.story.a.a b;
  private com.b.a.a.a c;
  private i d;
  private c e;
  private p f;
  private q g;
  private s h;
  private q i;
  private o j;
  private View k;
  private View l;

  private View a(Context paramContext)
  {
    View localView = new View(paramContext);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, com.viber.voip.util.e.j.a(15.0F)));
    localView.setBackgroundColor(dc.d(paramContext, R.attr.listItemHeaderColor));
    return localView;
  }

  private void a(ArrayList<ParticipantSelector.Participant> paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    int m = 0;
    if (localIterator.hasNext())
    {
      Member localMember = Member.from((ParticipantSelector.Participant)localIterator.next());
      if (g.a(localMember))
        break label78;
      c().a(localMember, false);
    }
    label78: for (int n = m + 1; ; n = m)
    {
      m = n;
      break;
      if (m > 0)
        this.a.a(m, "Settings Block List");
      return;
    }
  }

  private void b()
  {
    b localb = com.viber.voip.messages.d.c.c();
    Member[] arrayOfMember = g.a();
    ArrayList localArrayList = new ArrayList(arrayOfMember.length);
    int m = arrayOfMember.length;
    int n = 0;
    if (n < m)
    {
      Member localMember = arrayOfMember[n];
      m localm = localb.c(localMember.getId(), 1);
      if (localm != null)
        localArrayList.add(ParticipantSelector.Participant.from(localm));
      while (true)
      {
        n++;
        break;
        localArrayList.add(ParticipantSelector.Participant.from(localMember));
      }
    }
    Intent localIntent = new Intent("com.viber.voip.action.BLOCK_NUMBERS_SELECT");
    localIntent.putParcelableArrayListExtra("already_added_participants", localArrayList);
    startActivityForResult(localIntent, 501);
  }

  private void b(ArrayList<ParticipantSelector.Participant> paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    int m = 0;
    if (localIterator.hasNext())
    {
      Member localMember = Member.from((ParticipantSelector.Participant)localIterator.next());
      if (!g.a(localMember))
        break label77;
      c().a(localMember);
    }
    label77: for (int n = m + 1; ; n = m)
    {
      m = n;
      break;
      if (m > 0)
        this.a.b(m, "Settings Block List");
      return;
    }
  }

  private static com.viber.voip.contacts.c.a.a c()
  {
    return ViberApplication.getInstance().getContactManager().f();
  }

  public void a(j paramj)
  {
    Set localSet = Collections.singleton(new Member(paramj.a(), paramj.b(), null, paramj.c(), null));
    g.a(getActivity(), localSet, paramj.c(), false, new e(this));
    this.a.b(1.0D, "Settings Block List");
  }

  public void a(r paramr)
  {
    if (paramr.a() == 0)
    {
      localc = (r.c)paramr.b();
      this.j.a(localc.a, false);
    }
    while (1 != paramr.a())
    {
      r.c localc;
      return;
    }
    this.b.b("Block List Settings");
    r.a locala = (r.a)paramr.b();
    this.j.b(locala.a, false);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.c = new com.b.a.a.a();
    FragmentActivity localFragmentActivity = getActivity();
    LayoutInflater localLayoutInflater = getLayoutInflater();
    LoaderManager localLoaderManager = getLoaderManager();
    this.d = new i(localFragmentActivity, localLoaderManager, this);
    this.d.i();
    this.d.p();
    this.e = new c(this.d, this, localLayoutInflater);
    this.c.a(this.e);
    this.k = a(localFragmentActivity);
    this.c.a(this.k);
    this.f = new p(localFragmentActivity, localLoaderManager, this);
    this.f.i();
    this.f.p();
    this.g = new q(localFragmentActivity, this.f, this, localLayoutInflater);
    this.c.a(this.g);
    this.l = a(localFragmentActivity);
    this.c.a(this.l);
    this.h = new s(localFragmentActivity, localLoaderManager, this);
    this.h.i();
    this.h.p();
    this.i = new q(localFragmentActivity, this.h, this, localLayoutInflater);
    this.c.a(this.i);
    this.j = new o(localFragmentActivity.getWindow().getDecorView());
    setListAdapter(this.c);
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((501 == paramInt1) && (-1 == paramInt2) && (paramIntent != null))
    {
      a(paramIntent.getParcelableArrayListExtra("added_participants"));
      b(paramIntent.getParcelableArrayListExtra("removed_participants"));
    }
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(R.menu.menu_block_list, paramMenu);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.fragment_block_list, null);
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    this.d.q();
    this.f.q();
    this.h.q();
  }

  public void onLoadFinished(com.viber.provider.d paramd, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramd instanceof i))
      this.e.notifyDataSetChanged();
    do
    {
      return;
      if ((paramd instanceof p))
      {
        com.b.a.a.a locala2 = this.c;
        View localView2 = this.k;
        if (paramd.getCount() > 0);
        while (true)
        {
          locala2.b(localView2, bool);
          this.g.notifyDataSetChanged();
          return;
          bool = false;
        }
      }
    }
    while (!(paramd instanceof s));
    com.b.a.a.a locala1 = this.c;
    View localView1 = this.l;
    if (paramd.getCount() > 0);
    while (true)
    {
      locala1.b(localView1, bool);
      this.i.notifyDataSetChanged();
      return;
      bool = false;
    }
  }

  public void onLoaderReset(com.viber.provider.d paramd)
  {
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == R.id.menu_block_number)
    {
      b();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.block.d
 * JD-Core Version:    0.6.2
 */