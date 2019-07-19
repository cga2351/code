package com.viber.voip.publicaccount.ui.screen.info;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.common.dialogs.DialogCodeProvider;
import com.viber.common.dialogs.m.c;
import com.viber.common.dialogs.m.g;
import com.viber.dexshared.Logger;
import com.viber.provider.d;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.integer;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.StoryConstants.g.a;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.contacts.ui.list.as;
import com.viber.voip.contacts.ui.list.t;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ac;
import com.viber.voip.messages.conversation.adapter.o;
import com.viber.voip.messages.conversation.adapter.q;
import com.viber.voip.messages.conversation.adapter.s;
import com.viber.voip.messages.conversation.ae;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.presenter.DeleteConversationRelatedActionsPresenter;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.util.ViberActionRunner.an;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.util.cb;
import com.viber.voip.util.cd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class a extends com.viber.voip.messages.conversation.chatinfo.presentation.b
  implements m.g, com.viber.voip.messages.conversation.l.a, com.viber.voip.ui.a.a
{
  protected static final Logger H = ViberEnv.getLogger();
  protected PublicGroupConversationItemLoaderEntity I;
  protected PublicAccount J;
  protected b K;
  protected RecyclerView L;
  protected g M;
  protected a N;
  protected int O;
  protected int P;
  private com.viber.voip.messages.conversation.publicaccount.n Q;

  private com.viber.voip.messages.conversation.adapter.m a(ac paramac, com.viber.voip.messages.conversation.adapter.n paramn, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    com.viber.voip.messages.conversation.adapter.m localm = new com.viber.voip.messages.conversation.adapter.m(paramac);
    localm.a(new q(5));
    if (paramn.l())
    {
      com.viber.voip.messages.conversation.adapter.w localw1 = new com.viber.voip.messages.conversation.adapter.w(1, paramn.a(paramInt3), paramn.m());
      localw1.a(paramn.a());
      localm.a(localw1);
      if (paramn.a(paramInt1, paramInt2))
        localm.a(new com.viber.voip.messages.conversation.adapter.w(4, paramn.b(), ""));
      if (paramn.c())
      {
        o localo1 = new o(paramn.d(), paramn.e());
        localo1.a(2L);
        localm.a(localo1);
      }
      if (paramInt3 > 0)
      {
        localm.a(paramInt5, paramInt3);
        if (paramn.b(paramInt5, paramInt3))
        {
          com.viber.voip.messages.conversation.adapter.w localw4 = new com.viber.voip.messages.conversation.adapter.w(3, paramn.n(), "");
          localw4.a(paramn.f());
          localm.a(localw4);
        }
      }
    }
    if (paramn.g())
    {
      com.viber.voip.messages.conversation.adapter.w localw2 = new com.viber.voip.messages.conversation.adapter.w(2, paramn.b(paramInt4), paramn.h());
      localw2.a(5L);
      localm.a(localw2);
      if (paramn.i())
      {
        o localo2 = new o(R.drawable.add_participants_button, paramn.j());
        localo2.a(1L);
        localm.a(localo2);
      }
      if (paramInt4 <= 0)
        break label378;
      localm.a(paramInt6);
      if (paramInt6 < paramInt4)
      {
        com.viber.voip.messages.conversation.adapter.w localw3 = new com.viber.voip.messages.conversation.adapter.w(3, paramn.o(), "");
        localw3.a(paramn.k());
        localm.a(localw3);
      }
    }
    while (true)
    {
      localm.a(new q(6));
      return localm;
      label378: if (!paramn.i())
        localm.a(new q(8));
    }
  }

  protected abstract com.viber.voip.messages.conversation.adapter.n N();

  protected abstract b a(Context paramContext, int paramInt, com.viber.voip.ui.a.a parama);

  protected void a(int paramInt1, int paramInt2)
  {
    this.O = paramInt1;
    this.P = paramInt2;
  }

  public void a(int paramInt, View paramView)
  {
    s locals = this.K.a(paramInt);
    switch (locals.m())
    {
    case 5:
    case 6:
    case 7:
    case 8:
    default:
    case 2:
    case 9:
    case 1:
    case 3:
      do
      {
        return;
        a(1, "Participants List");
        return;
        if (locals.i() == 1L)
        {
          a(1, "Participants List");
          return;
        }
        if (cd.c(this.I.getGroupRole()))
        {
          A();
          return;
        }
        this.y.k();
        return;
        if (locals.i() == 4L)
        {
          u();
          return;
        }
        a(1, "Participants List");
        return;
        if (2L == locals.i())
        {
          v();
          return;
        }
        if (1L == locals.i())
        {
          w();
          return;
        }
      }
      while (3L != locals.i());
      ViberActionRunner.an.b(getActivity(), this.I);
      return;
    case 4:
      this.z.k();
      return;
    case 0:
    }
    this.z.a((ae)locals);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    if ((this.I != null) && (paramConversationItemLoaderEntity != null) && (this.I.hasPublicAccountPublicChat() != paramConversationItemLoaderEntity.hasPublicAccountPublicChat()))
    {
      finish();
      startActivity(ViberActionRunner.aq.c(getActivity(), paramConversationItemLoaderEntity.getPublicAccountGroupUri()));
    }
    this.I = ((PublicGroupConversationItemLoaderEntity)paramConversationItemLoaderEntity);
    a(this.I);
    super.a(paramConversationItemLoaderEntity, paramBoolean);
    this.K.a(this.I, as.a(this.I));
    if (hasOptionsMenu())
    {
      FragmentActivity localFragmentActivity = getActivity();
      if (localFragmentActivity != null)
        localFragmentActivity.supportInvalidateOptionsMenu();
    }
  }

  protected void a(ac paramac, boolean paramBoolean)
  {
    if ((this.I != null) && (this.I.isGroupBehavior()));
    com.viber.voip.messages.conversation.adapter.n localn;
    for (int i = p(); ; i = 2147483647)
    {
      localn = N();
      if (localn != null)
        break;
      return;
    }
    int j = paramac.getCount();
    int k = 0;
    int m = 0;
    int n = 0;
    while (true)
      if (k < j)
        if (paramac.g(k))
        {
          n++;
          label75: k++;
        }
        else
        {
          if ((this.D) || (m < i))
            break;
        }
    label165: label187: for (int i1 = j - n; ; i1 = m)
    {
      int i7;
      if (localn.l())
        if (localn.g())
          i7 = 0;
      label124: for (int i2 = n + i7; ; i2 = 0)
      {
        boolean bool1 = localn.g();
        int i3 = 0;
        int i6;
        int i4;
        if (bool1)
        {
          boolean bool2 = localn.l();
          i6 = 0;
          if (bool2)
            i3 = i6 + i1;
        }
        else
        {
          if (this.C)
            break label265;
          i4 = Math.min(i2, i);
          if (this.D)
            break label272;
        }
        for (int i5 = Math.min(i3, i); ; i5 = i3)
        {
          com.viber.voip.messages.conversation.adapter.m localm = a(paramac, localn, n, i1, i2, i3, i4, i5);
          this.K.a(localm);
          if (!paramBoolean)
            break;
          a(i2, i3);
          return;
          m++;
          break label75;
          i7 = i1;
          break label124;
          i6 = n;
          break label165;
          i4 = i2;
          break label187;
        }
      }
    }
  }

  protected void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    this.J = new PublicAccount(paramPublicGroupConversationItemLoaderEntity);
  }

  protected void b()
  {
    if (this.I.getGroupRole() == 3)
    {
      this.A.c();
      return;
    }
    if ((this.x != null) && (this.x.getCount() > 1))
    {
      com.viber.voip.ui.dialogs.r.f().a(this).b(this);
      return;
    }
    com.viber.voip.ui.dialogs.r.r().a(this).b(this);
  }

  public void c(long paramLong)
  {
    if (this.Q.r() != paramLong)
    {
      this.Q.a(paramLong);
      this.Q.i();
      this.Q.p();
    }
  }

  public void c_(final long paramLong)
  {
    av.a(av.e.a).post(new Runnable()
    {
      public void run()
      {
        if ((a.this.I != null) && (a.this.I.getId() == paramLong))
          a.a(a.this);
      }
    });
  }

  protected com.viber.voip.messages.conversation.chatinfo.presentation.a.b o()
  {
    return this.K;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (this.Q == null)
      this.Q = new com.viber.voip.messages.conversation.publicaccount.n(getContext(), getLoaderManager(), new b(this), this, this);
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.K != null) && (this.K.a(paramInt1, paramInt2, paramIntent)))
      return;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.N = ((a)paramActivity);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.M = g.a();
    this.K = a(getActivity(), this.E, this);
    this.K.k();
    if (paramBundle != null)
      this.K.b(paramBundle);
  }

  public void onDestroyView()
  {
    if (this.Q != null)
      this.Q.q();
    if (this.K != null)
      this.K.n();
    super.onDestroyView();
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    super.onDialogAction(paramm, paramInt);
    if ((paramm.a(DialogCode.D2108)) || (paramm.a(DialogCode.D1009)))
    {
      if (-1 == paramInt)
      {
        this.A.c();
        if (this.I != null)
          this.m.a("Leave and Delete", paramm.c().code(), StoryConstants.g.a.a(this.I), com.viber.voip.analytics.story.n.a(this.I));
      }
      while ((this.I == null) || ((-2 != paramInt) && (-1000 != paramInt)))
        return;
      this.m.a("Cancel", paramm.c().code(), StoryConstants.g.a.a(this.I), com.viber.voip.analytics.story.n.a(this.I));
      return;
    }
    this.K.onDialogAction(paramm, paramInt);
  }

  public void onDialogListAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if (this.K != null)
      this.K.onDialogListAction(paramm, paramInt);
  }

  public void onLoadFinished(d paramd, boolean paramBoolean)
  {
    if ((paramd == this.Q) && (isAdded()))
    {
      if (this.Q.getCount() != 0)
      {
        a(this.Q.f(0), paramBoolean);
        return;
      }
      finish();
      return;
    }
    super.onLoadFinished(paramd, paramBoolean);
  }

  public void onPeerIdentityBreached(String paramString1, String paramString2, String paramString3)
  {
    if (this.K != null)
      this.K.notifyDataSetChanged();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    this.K.a(paramBundle);
    super.onSaveInstanceState(paramBundle);
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.L = ((RecyclerView)paramView.findViewById(R.id.conversationInfo));
    this.L.setAdapter(this.K);
  }

  public int p()
  {
    return getResources().getInteger(R.integer.public_account_displayed_participants_limit);
  }

  protected void t()
  {
    this.K.a(new com.viber.voip.messages.conversation.adapter.m(null));
  }

  public static abstract interface a
  {
    public abstract void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity);

    public abstract void i();

    public abstract boolean j();
  }

  protected static abstract class b extends com.viber.voip.messages.conversation.adapter.b
    implements m.c, m.g, cb
  {
    protected g c = g.a();
    protected int d;
    protected PublicGroupConversationItemLoaderEntity e;
    private SparseArray<com.viber.voip.publicaccount.ui.holders.c[]> f = new SparseArray(2);

    public b(Context paramContext, int paramInt, com.viber.voip.ui.a.a parama, LayoutInflater paramLayoutInflater)
    {
      super(paramInt, 2, parama, paramLayoutInflater);
    }

    private final <T> void a(int paramInt, Class<T> paramClass, List<T> paramList)
    {
      int i = 0;
      com.viber.voip.publicaccount.ui.holders.c[] arrayOfc = (com.viber.voip.publicaccount.ui.holders.c[])this.f.get(paramInt, new com.viber.voip.publicaccount.ui.holders.c[0]);
      int j = arrayOfc.length;
      while (i < j)
      {
        com.viber.voip.publicaccount.ui.holders.c localc = arrayOfc[i];
        if (paramClass.isAssignableFrom(localc.getClass()))
          paramList.add(localc);
        i++;
      }
    }

    private com.viber.voip.publicaccount.ui.holders.c[] a(com.viber.voip.publicaccount.ui.holders.c[] paramArrayOfc)
    {
      int i = paramArrayOfc.length;
      for (int j = 0; j < i; j++)
        paramArrayOfc[j].a();
      return paramArrayOfc;
    }

    public com.viber.voip.messages.conversation.adapter.r a(ViewGroup paramViewGroup, int paramInt)
    {
      switch (paramInt)
      {
      default:
        return super.a(paramViewGroup, paramInt);
      case 5:
        return a(this.a, paramViewGroup, a((com.viber.voip.publicaccount.ui.holders.c[])this.f.get(5)));
      case 6:
      }
      return b(this.a, paramViewGroup, a((com.viber.voip.publicaccount.ui.holders.c[])this.f.get(6)));
    }

    protected abstract a.c a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, com.viber.voip.publicaccount.ui.holders.c[] paramArrayOfc);

    protected final <T> List<T> a(Class<T> paramClass)
    {
      ArrayList localArrayList = new ArrayList();
      a(5, paramClass, localArrayList);
      a(6, paramClass, localArrayList);
      return localArrayList;
    }

    public void a(Bundle paramBundle)
    {
      Iterator localIterator = a(com.viber.voip.publicaccount.ui.holders.c.class).iterator();
      while (localIterator.hasNext())
        ((com.viber.voip.publicaccount.ui.holders.c)localIterator.next()).a(paramBundle);
    }

    public void a(com.viber.voip.messages.conversation.adapter.r paramr, int paramInt)
    {
      switch (paramr.getItemViewType())
      {
      default:
      case 5:
      case 6:
      }
      while (true)
      {
        super.a(paramr, paramInt);
        return;
        if (this.e != null)
          ((a.c)paramr).a(this.e, this.d);
      }
    }

    public void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity, boolean paramBoolean)
    {
      this.e = paramPublicGroupConversationItemLoaderEntity;
      a(paramPublicGroupConversationItemLoaderEntity.getGroupId(), paramPublicGroupConversationItemLoaderEntity.getGroupRole(), paramPublicGroupConversationItemLoaderEntity.getConversationType(), false);
      b(paramPublicGroupConversationItemLoaderEntity, paramBoolean);
    }

    public void a(PublicAccount paramPublicAccount)
    {
      Iterator localIterator = a(com.viber.voip.publicaccount.ui.holders.c.class).iterator();
      while (localIterator.hasNext())
        ((com.viber.voip.publicaccount.ui.holders.c)localIterator.next()).b(paramPublicAccount);
    }

    public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
    {
      Iterator localIterator = a(cb.class).iterator();
      while (localIterator.hasNext())
        if (((cb)localIterator.next()).a(paramInt1, paramInt2, paramIntent))
          return true;
      return false;
    }

    protected abstract a.c b(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, com.viber.voip.publicaccount.ui.holders.c[] paramArrayOfc);

    public void b(int paramInt)
    {
      this.d = paramInt;
      c(paramInt);
    }

    public void b(Bundle paramBundle)
    {
      Iterator localIterator = a(com.viber.voip.publicaccount.ui.holders.c.class).iterator();
      while (localIterator.hasNext())
        ((com.viber.voip.publicaccount.ui.holders.c)localIterator.next()).b(paramBundle);
    }

    protected void b(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity, boolean paramBoolean)
    {
      notifyDataSetChanged();
    }

    protected void c(int paramInt)
    {
      notifyDataSetChanged();
    }

    void k()
    {
      this.f.put(5, l());
      this.f.put(6, m());
    }

    protected abstract com.viber.voip.publicaccount.ui.holders.c[] l();

    protected abstract com.viber.voip.publicaccount.ui.holders.c[] m();

    public void n()
    {
      Iterator localIterator = a(com.viber.voip.publicaccount.ui.holders.c.class).iterator();
      while (localIterator.hasNext())
        ((com.viber.voip.publicaccount.ui.holders.c)localIterator.next()).a();
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      Iterator localIterator = a(cb.class).iterator();
      while (localIterator.hasNext())
        ((cb)localIterator.next()).onDialogAction(paramm, paramInt);
    }

    public void onDialogListAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      Iterator localIterator = a(m.g.class).iterator();
      while (localIterator.hasNext())
        ((m.g)localIterator.next()).onDialogListAction(paramm, paramInt);
    }
  }

  public static class c extends com.viber.voip.messages.conversation.adapter.r
  {
    protected PublicAccount a;
    protected boolean b;
    private final com.viber.voip.publicaccount.ui.holders.c[] c;

    public c(View paramView, com.viber.voip.publicaccount.ui.holders.c[] paramArrayOfc)
    {
      super();
      this.c = paramArrayOfc;
      com.viber.voip.publicaccount.ui.holders.c[] arrayOfc = this.c;
      int i = arrayOfc.length;
      for (int j = 0; j < i; j++)
        arrayOfc[j].a(paramView);
    }

    public void a()
    {
      if (!this.b);
      while (true)
      {
        return;
        PublicAccount localPublicAccount = this.a;
        if (localPublicAccount != null)
        {
          com.viber.voip.publicaccount.ui.holders.c[] arrayOfc = this.c;
          int i = arrayOfc.length;
          for (int j = 0; j < i; j++)
            arrayOfc[j].a(localPublicAccount);
        }
      }
    }

    public void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity, int paramInt)
    {
      if (this.a == null)
      {
        this.a = new PublicAccount(paramPublicGroupConversationItemLoaderEntity);
        this.a.setMediaCount(paramInt);
        this.b = true;
      }
      while (true)
      {
        a();
        return;
        PublicAccount localPublicAccount = new PublicAccount(paramPublicGroupConversationItemLoaderEntity);
        localPublicAccount.setMediaCount(paramInt);
        if (!this.a.equals(localPublicAccount))
        {
          this.a = localPublicAccount;
          this.b = true;
        }
        else
        {
          this.b = false;
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.screen.info.a
 * JD-Core Version:    0.6.2
 */