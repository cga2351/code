package com.viber.voip.contacts.ui.list;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.app.c.a;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.voip.R.id;
import com.viber.voip.R.menu;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.bm;
import com.viber.voip.model.h;
import com.viber.voip.permissions.n;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.d;
import com.viber.voip.ui.dialogs.e.b;
import com.viber.voip.ui.dialogs.k;
import com.viber.voip.ui.dialogs.l;
import com.viber.voip.ui.dialogs.r;
import com.viber.voip.user.PublicGroupParticipantDetailsActivity;
import com.viber.voip.util.ViberActionRunner.an;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.util.ViberActionRunner.bf;
import com.viber.voip.util.ViberActionRunner.o;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;

public class y
  implements x
{
  private Fragment a;
  private boolean b;
  private t c;
  private com.viber.common.permission.c d;
  private bm e;
  private final int f;
  private ContextMenu g;

  public y(Fragment paramFragment, boolean paramBoolean, t paramt, com.viber.common.permission.c paramc, bm parambm, int paramInt)
  {
    this.a = paramFragment;
    this.b = paramBoolean;
    this.c = paramt;
    this.d = paramc;
    this.e = parambm;
    this.f = paramInt;
  }

  public void E_()
  {
    d.n().a(this.a).b(this.a);
  }

  public void F_()
  {
    d.s().a(this.a).b(this.a);
  }

  public void X_()
  {
    if (this.a.getActivity() != null)
      ViberActionRunner.bf.a(this.a.getActivity(), this.b);
  }

  public void a()
  {
    View localView = this.a.getView();
    this.a.registerForContextMenu(localView);
    this.a.getActivity().openContextMenu(localView);
    this.a.unregisterForContextMenu(localView);
  }

  public void a(ContextMenu paramContextMenu)
  {
    this.a.getActivity().getMenuInflater().inflate(R.menu.context_menu_chat_info, paramContextMenu);
    this.g = paramContextMenu;
  }

  public void a(Menu paramMenu)
  {
    this.g = null;
  }

  public void a(s params)
  {
    if (this.g == null)
      return;
    SparseArrayCompat localSparseArrayCompat = params.a();
    int i = 0;
    label15: int j;
    s.a locala;
    MenuItem localMenuItem;
    if (i < localSparseArrayCompat.size())
    {
      j = localSparseArrayCompat.keyAt(i);
      locala = (s.a)localSparseArrayCompat.valueAt(i);
      localMenuItem = this.g.findItem(j);
      if (locala != null)
        break label75;
      this.g.removeItem(j);
    }
    while (true)
    {
      i++;
      break label15;
      break;
      label75: if (localMenuItem == null)
        this.g.add(0, j, 0, locala.a);
      else
        localMenuItem.setTitle(locala.a);
    }
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    ViberActionRunner.aq.b(this.a.getActivity(), paramConversationItemLoaderEntity.getPublicAccountGroupUri());
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, h paramh)
  {
    if ((!paramConversationItemLoaderEntity.isPublicGroupBehavior()) && (this.e.a(paramh, paramConversationItemLoaderEntity)))
      return;
    ViberActionRunner.o.a(this.a.getActivity(), paramConversationItemLoaderEntity.getConversationType(), paramConversationItemLoaderEntity.getGroupRole(), paramh);
  }

  public void a(h paramh)
  {
    new c.a(this.a.getActivity()).a("System info").b(paramh.toString()).a("Close", null).b().show();
  }

  public void a(h paramh, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intent localIntent = com.viber.voip.messages.m.a(paramh.p(), paramh.p(), paramh.getViberName(), paramh.getContactName(), false, paramBoolean1, paramBoolean2, false);
    this.a.startActivity(localIntent);
  }

  public void a(h paramh, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Intent localIntent = com.viber.voip.messages.m.a(paramh.h(), paramh.getNumber(), paramh.getViberName(), paramh.getContactName(), paramBoolean1, paramBoolean2, paramBoolean3, false);
    this.a.startActivity(localIntent);
  }

  public void a(String paramString, Uri paramUri, boolean paramBoolean)
  {
    this.a.startActivity(PublicGroupParticipantDetailsActivity.buildIntentForSingleShowing(this.a.getActivity(), paramUri, paramString, paramBoolean));
  }

  public void a(boolean paramBoolean)
  {
    dj.a(this.a, paramBoolean);
  }

  public boolean a(MenuItem paramMenuItem)
  {
    if (this.g == null);
    do
    {
      return false;
      if (R.id.participant_item == paramMenuItem.getItemId())
      {
        this.c.e();
        return true;
      }
      if (R.id.menu_message == paramMenuItem.getItemId())
      {
        this.c.f();
        return true;
      }
      if (R.id.menu_call == paramMenuItem.getItemId())
      {
        if (this.d.a(n.h))
          this.c.g();
        while (true)
        {
          return true;
          this.d.a(this.a, 62, n.h, Boolean.valueOf(false));
        }
      }
      if (R.id.menu_view == paramMenuItem.getItemId())
      {
        this.c.j();
        return true;
      }
      if (R.id.menu_start_secret_chat == paramMenuItem.getItemId())
      {
        this.c.h();
        return true;
      }
      if (R.id.menu_start_anonymous_chat == paramMenuItem.getItemId())
      {
        this.c.i();
        return true;
      }
      if (R.id.admin_assign_role_action == paramMenuItem.getItemId())
      {
        this.c.l();
        return true;
      }
      if (R.id.admin_add_group_members_action == paramMenuItem.getItemId())
      {
        this.c.m();
        return true;
      }
      if (R.id.remove_from_chat == paramMenuItem.getItemId())
      {
        this.c.n();
        return true;
      }
      if (R.id.menu_ban == paramMenuItem.getItemId())
      {
        this.c.p();
        return true;
      }
    }
    while (R.id.menu_unban != paramMenuItem.getItemId());
    this.c.q();
    return true;
  }

  public boolean a(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.D521))
    {
      if (paramInt == -1)
        this.c.o();
      return true;
    }
    if (paramm.a(DialogCode.D1037))
    {
      if (paramInt == -1)
        this.c.r();
      return true;
    }
    if (paramm.a(DialogCode.D1039))
    {
      if (paramInt == -1)
        this.c.s();
      return true;
    }
    boolean bool2;
    if ((paramm.a(DialogCode.D1029a)) && (-3 == paramInt))
    {
      e.b localb2 = (e.b)paramm.d();
      t localt2 = this.c;
      long l3 = localb2.k;
      String str3 = localb2.m;
      int j = localb2.n;
      String str4 = localb2.o;
      long l4 = localb2.l;
      if (!localb2.d)
      {
        bool2 = true;
        localt2.a(l3, str3, j, str4, l4, bool2, true);
      }
    }
    while (true)
    {
      return false;
      bool2 = false;
      break;
      if ((paramm.a(DialogCode.D1029)) || (paramm.a(DialogCode.D1029a)))
      {
        t localt1;
        long l1;
        String str1;
        int i;
        String str2;
        long l2;
        if (-1 == paramInt)
        {
          e.b localb1 = (e.b)paramm.d();
          localt1 = this.c;
          l1 = localb1.k;
          str1 = localb1.m;
          i = localb1.n;
          str2 = localb1.o;
          l2 = localb1.l;
          if (localb1.d)
            break label284;
        }
        label284: for (boolean bool1 = true; ; bool1 = false)
        {
          localt1.a(l1, str1, i, str2, l2, bool1, false);
          return true;
        }
      }
      if (paramm.a(DialogCode.D1030))
      {
        if (paramInt == -1)
          this.c.t();
        return true;
      }
      if ((paramm.a(DialogCode.D1041)) && (paramInt == -1))
        this.c.u();
    }
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    ViberActionRunner.an.a(this.a.getContext(), paramConversationItemLoaderEntity);
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, h paramh)
  {
    if (paramConversationItemLoaderEntity.isCommunityType())
    {
      l.a locala2 = l.f();
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = paramh.a(paramConversationItemLoaderEntity.getGroupRole(), paramConversationItemLoaderEntity.getConversationType());
      arrayOfObject2[1] = dg.b(paramConversationItemLoaderEntity);
      locala2.b(-1, arrayOfObject2).a(this.a).b(this.a);
      return;
    }
    l.a locala1 = l.e();
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = paramh.a(paramConversationItemLoaderEntity.getGroupRole(), paramConversationItemLoaderEntity.getConversationType());
    arrayOfObject1[1] = dg.b(paramConversationItemLoaderEntity);
    locala1.b(-1, arrayOfObject1).a(this.a).b(this.a);
  }

  public void c()
  {
    ad.a().b(this.a);
  }

  public void c(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    ViberActionRunner.an.a(this.a.getContext(), paramConversationItemLoaderEntity.getId());
  }

  public void c(ConversationItemLoaderEntity paramConversationItemLoaderEntity, h paramh)
  {
    d.b(paramh.a(paramConversationItemLoaderEntity.getGroupRole(), paramConversationItemLoaderEntity.getConversationType())).a(this.a).b(this.a);
  }

  public void d()
  {
    k.z().b(this.a);
  }

  public void d_(String paramString)
  {
    d.a(paramString).a(this.a).b(this.a);
  }

  public void e()
  {
    d.p().a(this.a).b(this.a);
  }

  public void f()
  {
    k.n().b(this.a);
  }

  public void g()
  {
    r.k().b(this.a);
  }

  public void h()
  {
    if (com.viber.voip.messages.m.b(this.f))
      d.j().b(this.a);
  }

  public void k()
  {
    if (this.g != null)
      this.g.close();
  }

  public void l()
  {
    this.e.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.y
 * JD-Core Version:    0.6.2
 */