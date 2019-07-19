package com.viber.voip.util;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintLayout.a;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.SlidingMenu.c;
import com.slidingmenu.lib.SlidingMenu.e;
import com.slidingmenu.lib.SlidingMenu.g;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ad;
import com.viber.voip.calls.ui.GroupCallDetailsActivity;
import com.viber.voip.calls.ui.GroupCallDetailsFragment;
import com.viber.voip.calls.ui.KeypadFragment;
import com.viber.voip.calls.ui.RecentCallsFragment;
import com.viber.voip.contacts.ui.ContactDetailsFragment;
import com.viber.voip.contacts.ui.ContactsFragment;
import com.viber.voip.contacts.ui.ContactsFragment.a;
import com.viber.voip.messages.controller.manager.al;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.community.CommunityConversationFragment;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationFragment;
import com.viber.voip.messages.conversation.s;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.ConversationFragment.a;
import com.viber.voip.messages.ui.MessagesFragmentModeManager;
import com.viber.voip.messages.ui.bk;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.permissions.n;
import com.viber.voip.phone.CallFragmentManager;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.am;
import com.viber.voip.u.d;
import com.viber.voip.ui.f.f;
import com.viber.voip.user.editinfo.EditInfoFragment;
import com.viber.voip.user.more.MoreFragment;
import java.util.Set;

public class bd
  implements View.OnClickListener, SlidingMenu.c, SlidingMenu.e, SlidingMenu.g, ContactsFragment.a, ConversationFragment.a
{
  private static final Logger a = ViberEnv.getLogger("HomeActivity");
  private int A;
  private ad B;
  private final dagger.a<com.viber.voip.analytics.story.e.c> C;
  private b b;
  private bk c;
  private ContactsFragment d;
  private RecentCallsFragment e;
  private KeypadFragment f;
  private MoreFragment g;
  private ConversationFragment h;
  private ConversationFragment i;
  private CommunityConversationFragment j;
  private ContactDetailsFragment k;
  private GroupCallDetailsFragment l;
  private EditInfoFragment m;
  private AppCompatActivity n;
  private a o;
  private bc p;
  private SparseArray<Intent> q = new SparseArray(4);
  private Intent r;
  private Intent s;
  private boolean t;
  private String u;
  private String v;
  private f w;
  private CallFragmentManager x;
  private com.viber.voip.messages.controller.manager.k y;
  private int z;

  public bd(ad paramad, dagger.a<com.viber.voip.analytics.story.e.c> parama)
  {
    this.B = paramad;
    this.C = parama;
  }

  private CharSequence a(CharSequence paramCharSequence)
  {
    if (this.w == null)
      return paramCharSequence;
    return this.w.a(paramCharSequence);
  }

  private void a(int paramInt, Bundle paramBundle)
  {
    Intent localIntent = (Intent)paramBundle.getParcelable("extra_intent_" + paramInt);
    if (localIntent != null)
      this.q.put(paramInt, localIntent);
  }

  private static void a(Fragment paramFragment, boolean paramBoolean)
  {
    if ((paramFragment instanceof com.viber.voip.b))
      ((com.viber.voip.b)paramFragment).onFragmentVisibilityChanged(paramBoolean);
  }

  private static void a(FragmentTransaction paramFragmentTransaction, Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null);
    do
    {
      return;
      if ((paramBoolean) && (!paramFragment.isVisible()))
      {
        paramFragmentTransaction.show(paramFragment);
        a(paramFragment, true);
        return;
      }
    }
    while ((paramBoolean) || (paramFragment.isHidden()));
    paramFragmentTransaction.hide(paramFragment);
    a(paramFragment, false);
  }

  private void b(int paramInt)
  {
    if (paramInt == 1)
    {
      if ((!this.B.a()) && (!this.B.b()))
        this.q.remove(1);
      this.q.remove(11);
      this.q.remove(12);
      return;
    }
    this.q.remove(paramInt);
  }

  private int t()
  {
    return com.viber.voip.ac.a;
  }

  private void u()
  {
    b(true);
  }

  private boolean v()
  {
    int i1 = this.B.c();
    Intent localIntent = (Intent)this.q.get(i1);
    if (localIntent == null)
      return false;
    ComponentName localComponentName = localIntent.getComponent();
    if (localComponentName == null)
      return false;
    return GroupCallDetailsActivity.class.getName().equals(localComponentName.getClassName());
  }

  private void w()
  {
    this.b.a(t());
  }

  private void x()
  {
    dj.c(this.n.getCurrentFocus());
  }

  public void a()
  {
    w();
    this.h.ai();
  }

  public void a(int paramInt)
  {
    if (paramInt == 0)
      ViberApplication.getInstance().getMessagesManager().n().a(false, false);
  }

  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      this.y.d();
      this.q.remove(0);
    }
    if (this.x != null)
    {
      if (paramInt2 == 0)
      {
        this.x.onStart(this.n);
        this.x.onResume(this.n);
      }
    }
    else
      switch (paramInt2)
      {
      case 1:
      default:
      case 0:
      }
    while (true)
    {
      this.b.b(paramInt2);
      x();
      if (!this.n.isFinishing())
        u();
      return;
      this.x.onPause(this.n);
      this.x.onStop(this.n);
      break;
      if ((!this.t) && (!this.b.c()))
      {
        this.p.a = true;
        this.p.a(false);
        this.b.a(false);
      }
      this.B.a(false);
      this.B.b(false);
    }
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
      switch (paramInt1)
      {
      default:
      case 1000:
      case 1001:
      case 9:
      case 10:
      }
    do
    {
      Bundle localBundle1;
      do
      {
        do
        {
          MessageEntity[] arrayOfMessageEntity;
          Bundle localBundle3;
          do
          {
            do
              return;
            while (paramIntent == null);
            Bundle localBundle2 = (Bundle)paramIntent.getParcelableExtra("data");
            arrayOfMessageEntity = (MessageEntity[])ParcelableUtils.a(localBundle2.getParcelable("pending_messages"));
            localBundle3 = (Bundle)localBundle2.getParcelable("options");
          }
          while (this.h == null);
          this.h.b(arrayOfMessageEntity, localBundle3);
          return;
        }
        while (paramIntent == null);
        localBundle1 = (Bundle)paramIntent.getParcelableExtra("data");
      }
      while ((localBundle1 == null) || (this.h == null));
      this.h.b(localBundle1);
      return;
    }
    while ((paramIntent == null) || (this.h == null));
    this.h.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void a(int paramInt, Fragment paramFragment)
  {
    int i1;
    if ((paramFragment instanceof bk))
    {
      i1 = 0;
      if (paramInt == 0)
        this.b.b();
    }
    while (true)
    {
      if (paramInt == 0)
        b(i1);
      if ((t() == i1) && (paramInt == 0) && ((i1 == 0) || (this.B.b())))
        u();
      return;
      if (!(paramFragment instanceof ContactsFragment))
      {
        boolean bool = paramFragment instanceof RecentCallsFragment;
        i1 = 0;
        if (!bool);
      }
      else
      {
        i1 = 1;
      }
    }
  }

  public void a(Intent paramIntent)
  {
    SparseArray localSparseArray = this.q;
    if (this.B.b());
    for (int i1 = 12; ; i1 = 1)
    {
      localSparseArray.put(i1, paramIntent);
      if (1 == t())
        u();
      return;
    }
  }

  public void a(AppCompatActivity paramAppCompatActivity, a parama, bc parambc, f paramf, Bundle paramBundle)
  {
    this.n = paramAppCompatActivity;
    this.o = parama;
    this.p = parambc;
    this.t = dj.c(paramAppCompatActivity);
    this.w = paramf;
    this.u = paramAppCompatActivity.getString(R.string.app_name);
    this.v = paramAppCompatActivity.getString(R.string.recent_calls);
    if (paramBundle != null);
    for (int i1 = 1; ; i1 = 0)
    {
      this.y = ViberApplication.getInstance().getMessagesManager().a();
      if (i1 != 0)
      {
        this.B.a(paramBundle);
        a(0, paramBundle);
        a(1, paramBundle);
        a(12, paramBundle);
        a(2, paramBundle);
        a(11, paramBundle);
      }
      this.p.a(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (bd.a(bd.this) == 0)
            bd.b(bd.this).b();
        }
      });
      Resources localResources = this.n.getResources();
      float f1 = dj.a(localResources);
      this.z = localResources.getDisplayMetrics().widthPixels;
      this.A = ((int)(f1 * this.z));
      this.b = new b();
      FragmentManager localFragmentManager = this.n.getSupportFragmentManager();
      this.B.a(localFragmentManager);
      this.f = ((KeypadFragment)localFragmentManager.findFragmentById(R.id.keypad_fragment));
      this.e = ((RecentCallsFragment)localFragmentManager.findFragmentById(R.id.phone_fragment));
      this.k = ((ContactDetailsFragment)localFragmentManager.findFragmentById(R.id.contact_details_fragment));
      this.m = ((EditInfoFragment)localFragmentManager.findFragmentById(R.id.edit_your_details_fragment));
      this.i = ((ConversationFragment)localFragmentManager.findFragmentById(R.id.conversation_fragment));
      this.j = ((CommunityConversationFragment)localFragmentManager.findFragmentById(R.id.community_conversation_fragment));
      this.l = ((GroupCallDetailsFragment)localFragmentManager.findFragmentById(R.id.group_call_details_fragment));
      this.h = this.i;
      this.b.a(false);
      return;
    }
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt, String paramString)
  {
    Intent localIntent = ViberActionRunner.d.a(paramConversationItemLoaderEntity, al.a().d(paramConversationItemLoaderEntity.getId()));
    this.n.startActivity(localIntent);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    if (paramConversationItemLoaderEntity.isHiddenConversation())
      this.y.a(paramConversationItemLoaderEntity.getId(), paramConversationItemLoaderEntity.getConversationType(), paramConversationItemLoaderEntity.isHiddenConversation());
    if (!this.y.b().contains(Long.valueOf(paramConversationItemLoaderEntity.getId())))
      this.y.d();
    if (this.n.getIntent() != null)
      this.c.b(this.n.getIntent().getBooleanExtra("forward", false));
    bk localbk = this.c;
    if ((this.h != null) && (this.h.ad()));
    for (boolean bool = true; ; bool = false)
    {
      localbk.d(bool);
      this.c.a(paramConversationItemLoaderEntity, paramBoolean);
      this.c.d(false);
      return;
    }
  }

  public void a(ConversationData paramConversationData)
  {
  }

  public void a(CallFragmentManager paramCallFragmentManager)
  {
    this.x = paramCallFragmentManager;
  }

  public void a(boolean paramBoolean)
  {
    com.viber.voip.messages.controller.manager.k localk = ViberApplication.getInstance().getMessagesManager().a();
    if ((t() == 0) && (paramBoolean));
    for (boolean bool = true; ; bool = false)
    {
      localk.a(bool);
      return;
    }
  }

  public void a(boolean paramBoolean, Intent paramIntent)
  {
    if (1 != t());
    Intent localIntent;
    do
    {
      return;
      localIntent = (Intent)this.q.get(1);
    }
    while ((!paramBoolean) && (localIntent != null) && (bh.a(localIntent, paramIntent)));
    this.q.put(1, paramIntent);
    u();
  }

  public boolean a(Fragment paramFragment)
  {
    return paramFragment == this.h;
  }

  public boolean a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString)
  {
    return false;
  }

  public void addConversationIgnoredView(View paramView)
  {
    if (!this.t)
      this.b.a(paramView);
  }

  public void b()
  {
    w();
  }

  public void b(Intent paramIntent)
  {
    this.q.put(11, paramIntent);
    if (1 == t())
      u();
  }

  public void b(Fragment paramFragment)
  {
    if ((paramFragment instanceof bk))
      this.c = ((bk)paramFragment);
    do
    {
      return;
      if ((paramFragment instanceof ContactsFragment))
      {
        this.d = ((ContactsFragment)paramFragment);
        return;
      }
      if ((paramFragment instanceof KeypadFragment))
      {
        this.f = ((KeypadFragment)paramFragment);
        return;
      }
      if ((paramFragment instanceof RecentCallsFragment))
      {
        this.e = ((RecentCallsFragment)paramFragment);
        return;
      }
    }
    while (!(paramFragment instanceof MoreFragment));
    this.g = ((MoreFragment)paramFragment);
  }

  public void b(boolean paramBoolean)
  {
    int i1 = 1;
    int i2 = t();
    if (!paramBoolean)
      b(i2);
    label31: label39: FragmentTransaction localFragmentTransaction;
    int i9;
    label94: boolean bool2;
    boolean bool1;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    boolean bool6;
    boolean bool7;
    if (i2 == 0)
    {
      int i3 = i1;
      if (i1 != i2)
        break label288;
      int i5 = i1;
      if (2 != i2)
        break label294;
      int i7 = i1;
      this.b.a(i3, i2);
      this.b.a(i5, i2);
      this.b.a(i7, i2);
      localFragmentTransaction = this.n.getSupportFragmentManager().beginTransaction();
      if (this.f.isHidden())
        break label300;
      i9 = i1;
      a(i1);
      switch (i2)
      {
      default:
        bool2 = false;
        bool1 = false;
        bool3 = false;
        bool4 = false;
        bool5 = false;
        bool6 = false;
        bool7 = false;
      case 0:
      case 1:
      case 2:
      }
    }
    while (true)
      while (true)
      {
        a(localFragmentTransaction, this.f, bool7);
        a(localFragmentTransaction, this.e, bool6);
        if (i2 == i1)
        {
          ContactsFragment localContactsFragment = this.d;
          if (!bool6)
            a(localFragmentTransaction, localContactsFragment, i1);
        }
        else
        {
          a(localFragmentTransaction, this.i, bool5);
          a(localFragmentTransaction, this.j, bool4);
          a(localFragmentTransaction, this.k, bool3);
          a(localFragmentTransaction, this.m, bool1);
          a(localFragmentTransaction, this.l, bool2);
          if (localFragmentTransaction.isEmpty());
        }
        try
        {
          localFragmentTransaction.commitAllowingStateLoss();
          label264: if ((bool7) && (i9 == 0))
            this.f.f();
          return;
          int i4 = 0;
          break;
          label288: int i6 = 0;
          break label31;
          label294: int i8 = 0;
          break label39;
          label300: int i10 = 0;
          break label94;
          Intent localIntent2 = (Intent)this.q.get(0);
          label339: int i15;
          label364: int i17;
          label401: int i18;
          if ((this.h != null) && ((this.h instanceof PublicGroupConversationFragment)))
          {
            int i13 = i1;
            if (((this.c == null) || (!this.c.p())) && (localIntent2 == null))
              break label509;
            i15 = i1;
            if ((i15 == 0) || (((localIntent2 == null) || (!"com.viber.voip.action.COMMUNITY_CONVERSATION".equals(localIntent2.getAction()))) && ((localIntent2 != null) || (i13 == 0))))
              break label515;
            i17 = i1;
            if ((i15 == 0) || (i17 != 0))
              break label521;
            i18 = i1;
            label414: if (i17 != i13)
            {
              this.h.setHasOptionsMenu(false);
              this.h.A();
              if (i17 == 0)
                break label527;
            }
          }
          label509: boolean bool12;
          label515: label521: boolean bool13;
          label527: for (Object localObject = this.j; ; localObject = this.i)
          {
            this.h = ((ConversationFragment)localObject);
            this.h.setHasOptionsMenu(i1);
            if (i15 == 0)
              break label536;
            this.h.a(localIntent2, i1);
            bool5 = i18;
            bool4 = i17;
            bool2 = false;
            bool1 = false;
            bool3 = false;
            bool6 = false;
            bool7 = false;
            break;
            int i14 = 0;
            break label339;
            int i16 = 0;
            break label364;
            bool12 = false;
            break label401;
            bool13 = false;
            break label414;
          }
          label536: this.h.A();
          this.p.a(false, a(this.u));
          bool5 = bool13;
          bool4 = bool12;
          bool2 = false;
          bool1 = false;
          bool3 = false;
          bool6 = false;
          bool7 = false;
          continue;
          SparseArray localSparseArray = this.q;
          int i11;
          label605: Intent localIntent1;
          if (this.B.b())
          {
            i11 = 12;
            localIntent1 = (Intent)localSparseArray.get(i11);
            if ((this.B.b()) && (localIntent1 == null))
              localIntent1 = this.e.i();
            bool8 = this.B.a();
            bool9 = this.B.b();
            bool10 = v();
            if ((bool10) || (bool8))
              break label739;
          }
          label739: for (int i12 = i1; ; bool11 = false)
          {
            if ((this.s == null) || (this.d == null))
              break label745;
            e(this.s);
            this.s = null;
            bool2 = bool10;
            bool6 = bool9;
            bool7 = bool8;
            bool3 = i12;
            bool1 = false;
            bool4 = false;
            bool5 = false;
            break;
            i11 = i1;
            break label605;
          }
          label745: if (localIntent1 != null)
          {
            if (bool11)
            {
              this.k.a(localIntent1);
              bool2 = bool10;
              bool6 = bool9;
              bool7 = bool8;
              bool3 = bool11;
              bool1 = false;
              bool4 = false;
              bool5 = false;
              continue;
            }
            if ((bool10) && (localIntent1.getExtras() != null))
            {
              this.l.a(localIntent1.getExtras());
              bool2 = bool10;
              bool6 = bool9;
              bool7 = bool8;
              bool3 = bool11;
              bool1 = false;
              bool4 = false;
              bool5 = false;
              continue;
              if (this.r != null)
              {
                this.g.reloadFromArguments(this.r);
                this.r = null;
              }
              bool1 = i1;
              bool2 = false;
              bool3 = false;
              bool4 = false;
              bool5 = false;
              bool6 = false;
              bool7 = false;
              continue;
              i1 = 0;
            }
          }
        }
        catch (IllegalStateException localIllegalStateException)
        {
          boolean bool8;
          boolean bool9;
          boolean bool10;
          boolean bool11;
          break label264;
          bool2 = bool10;
          bool6 = bool9;
          bool7 = bool8;
          bool3 = bool11;
          bool1 = false;
          bool4 = false;
          bool5 = false;
        }
      }
  }

  public void c()
  {
    if (this.c != null)
      this.c.c(0L);
    this.q.remove(0);
  }

  public void c(Intent paramIntent)
  {
    this.q.put(0, paramIntent);
    if (t() == 0)
      u();
  }

  public void c(boolean paramBoolean)
  {
    this.y.d();
    b(false);
  }

  public void d()
  {
    int i1 = 1;
    int i3;
    int i2;
    int i4;
    int i5;
    int i6;
    int i7;
    switch (t())
    {
    default:
      i3 = 0;
      i2 = 0;
      i4 = 0;
      i5 = 0;
      i6 = 0;
      i7 = 0;
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      if (i5 == 0)
        a(this.h, false);
      if (i7 == 0)
        a(this.f, false);
      if (i6 == 0)
        a(this.e, false);
      if (i4 == 0)
        a(this.k, false);
      if (i3 == 0)
        a(this.l, false);
      if (i2 == 0)
        a(this.m, false);
      return;
      if ((this.c != null) && ((this.c.p()) || (this.q.get(0) != null)));
      while (true)
      {
        i5 = i1;
        i3 = 0;
        i2 = 0;
        i4 = 0;
        i6 = 0;
        i7 = 0;
        break;
        i1 = 0;
      }
      boolean bool1 = this.B.a();
      boolean bool2 = this.B.b();
      boolean bool3 = v();
      if ((!bool3) && (this.q.get(i1) != null));
      while (true)
      {
        i6 = bool2;
        i7 = bool1;
        i4 = i1;
        i3 = bool3;
        i2 = 0;
        i5 = 0;
        break;
        i1 = 0;
      }
      i2 = i1;
      i3 = 0;
      i4 = 0;
      i5 = 0;
      i6 = 0;
      i7 = 0;
    }
  }

  public void d(Intent paramIntent)
  {
    this.r = paramIntent;
    if (2 == t())
      b(false);
  }

  public void d(boolean paramBoolean)
  {
    this.b.b(paramBoolean);
  }

  public void e()
  {
    this.B.b(true);
    if (1 == t())
      u();
  }

  public void e(Intent paramIntent)
  {
    if (this.d != null)
    {
      this.d.a(paramIntent);
      return;
    }
    this.s = paramIntent;
  }

  public void e(boolean paramBoolean)
  {
    if ((this.B.b()) && (!this.e.isHidden()));
    for (int i1 = 1; ; i1 = 0)
    {
      bc localbc = this.p;
      boolean bool;
      if (!paramBoolean)
      {
        bool = false;
        if (i1 == 0);
      }
      else
      {
        bool = true;
      }
      localbc.a(bool, true, t());
      return;
    }
  }

  public void f()
  {
    if (!this.t)
      this.b.a();
  }

  public void f(Intent paramIntent)
  {
    this.B.a(true);
    u();
    if (paramIntent != null)
      this.f.a(paramIntent);
  }

  public void g()
  {
    if (!this.t)
      this.b.b();
  }

  public void h()
  {
    if (t() == 1)
      this.b.a(1);
  }

  public void i()
  {
    if (this.B.b())
      k();
  }

  public void j()
  {
    this.B.a(false);
    this.q.remove(11);
    u();
  }

  public void k()
  {
    this.B.b(false);
    this.q.remove(12);
    u();
  }

  public boolean l()
  {
    int i1 = 1;
    if (t() == 0)
      i1 = this.b.d();
    do
    {
      do
      {
        return i1;
        if (t() != i1)
          break label98;
        if (!this.B.a())
          break;
      }
      while (this.f.onBackPressed());
      j();
      return i1;
      if (this.B.b())
      {
        k();
        return i1;
      }
    }
    while ((this.t) && (this.k.isVisible()) && (this.k.onBackPressed()));
    return false;
    label98: return false;
  }

  public void m()
  {
  }

  public TextView n()
  {
    return null;
  }

  public TextView o()
  {
    return null;
  }

  public void onClick(View paramView)
  {
    if (t() == 0)
      this.b.b();
  }

  public void p()
  {
    s locals;
    ConversationItemLoaderEntity localConversationItemLoaderEntity;
    com.viber.voip.messages.conversation.ac localac;
    if (this.h != null)
    {
      locals = this.h.ah();
      if (locals != null)
      {
        localConversationItemLoaderEntity = locals.j();
        localac = locals.h();
        if (localac == null)
          break label85;
      }
    }
    label85: for (int i1 = localac.getCount(); ; i1 = 0)
    {
      if ((localConversationItemLoaderEntity != null) && (i1 > 0))
      {
        ((com.viber.voip.analytics.story.e.c)this.C.get()).b("Add participant Icon - Chat", localConversationItemLoaderEntity);
        ViberActionRunner.d.a(this.h, localConversationItemLoaderEntity, i1);
      }
      return;
      locals = null;
      break;
    }
  }

  public void q()
  {
    this.b.e();
  }

  public boolean r()
  {
    return this.b.h();
  }

  public void removeConversationIgnoredView(View paramView)
  {
    if (!this.t)
      this.b.b(paramView);
  }

  public Bundle s()
  {
    Bundle localBundle = new Bundle();
    this.B.b(localBundle);
    int i1 = this.q.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      int i3 = this.q.keyAt(i2);
      Intent localIntent = (Intent)this.q.get(i3);
      if (localIntent != null)
        localBundle.putParcelable("extra_intent_" + i3, localIntent);
    }
    return localBundle;
  }

  public static abstract interface a
  {
    public abstract void d(boolean paramBoolean);
  }

  private class b
  {
    private SlidingMenu b = (SlidingMenu)bd.c(bd.this).findViewById(R.id.tablet_home_sliding_menu);
    private ConstraintLayout c;
    private View d;
    private View e;

    b()
    {
      this.b.setContent(R.layout.view_home_tablet_sliding_content);
      this.b.setMenu(R.layout.view_home_tablet_sliding_menu);
      this.b.setMode(0);
      this.b.setRightSwipeInitialAvailableArea(bd.c(bd.this).getResources().getDimensionPixelSize(R.dimen.replyable_distance_requirements));
      this.b.setShadowDrawable(R.drawable.shadow_left);
      this.b.setShadowWidthRes(R.dimen.shadow_width);
      this.b.setFadeDegree(0.35F);
      this.b.setBehindWidth(bd.d(bd.this));
      this.b.setSlidingEnabled(false);
      this.b.setTouchModeBehind(2);
      this.b.setOnOpenedListener(bd.this);
      this.b.setOnClosedListener(bd.this);
      this.b.setOnStartDragListener(bd.this);
      this.c = ((ConstraintLayout)this.b.findViewById(R.id.tablet_home_sliding_content));
      k();
      if (bd.a(bd.this) == 1)
        j();
    }

    private void j()
    {
      l();
      if (!com.viber.common.permission.c.a(bd.c(bd.this)).a(n.j));
      for (boolean bool = true; ; bool = false)
      {
        b(bool);
        return;
      }
    }

    private void k()
    {
      if (ao.f())
        return;
      this.e = this.c.findViewById(R.id.empty_no_permissions_tablet_root);
      ImageView localImageView = (ImageView)this.e.findViewById(R.id.permission_icon);
      TextView localTextView = (TextView)this.e.findViewById(R.id.permission_description);
      View localView = this.e.findViewById(R.id.button_request_permission);
      localImageView.setImageResource(R.drawable.ic_permission_contacts);
      localTextView.setText(R.string.contact_list_permission_description);
      localView.setOnClickListener((View.OnClickListener)bd.c(bd.this));
    }

    @SuppressLint({"InflateParams"})
    private void l()
    {
      if ((ao.f()) && (d.am.b.d()) && (this.d == null))
      {
        this.d = LayoutInflater.from(bd.c(bd.this)).inflate(R.layout.contacts_start_conversation_intro, null);
        ConstraintLayout.a locala = new ConstraintLayout.a(bd.h(bd.this) - bd.d(bd.this), 0);
        locala.h = 0;
        locala.d = 0;
        locala.k = 0;
        this.c.addView(this.d, locala);
      }
    }

    void a()
    {
      this.b.c();
    }

    void a(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return;
      case 0:
        boolean bool2;
        boolean bool4;
        MessagesFragmentModeManager localMessagesFragmentModeManager;
        if ((bd.e(bd.this)) || (this.b.f()))
        {
          bool2 = true;
          if (!bd.e(bd.this))
          {
            bc localbc = bd.n(bd.this);
            if (bool2)
              break label217;
            bool4 = true;
            localbc.a(bool4);
            if (!bool2)
            {
              if (bd.g(bd.this) != null)
                break label223;
              localMessagesFragmentModeManager = null;
              if (localMessagesFragmentModeManager != null)
              {
                if (!localMessagesFragmentModeManager.l())
                  break label238;
                localMessagesFragmentModeManager.n();
                localMessagesFragmentModeManager.d();
              }
            }
          }
        }
        while (true)
        {
          bd.o(bd.this).d(bool2);
          if (bd.g(bd.this) != null)
            bd.g(bd.this).setHasOptionsMenu(bool2);
          ConversationFragment localConversationFragment = bd.f(bd.this);
          boolean bool3;
          if (!bd.e(bd.this))
          {
            bool3 = false;
            if (bool2);
          }
          else
          {
            bool3 = true;
          }
          localConversationFragment.setHasOptionsMenu(bool3);
          bd.f(bd.this).D();
          return;
          bool2 = false;
          break;
          bool4 = false;
          break label79;
          localMessagesFragmentModeManager = bd.g(bd.this).w();
          break label104;
          if (localMessagesFragmentModeManager.k())
            localMessagesFragmentModeManager.b(true);
        }
      case 1:
        label79: label104: label238: ContactsFragment localContactsFragment;
        label217: label223: if (bd.p(bd.this) != null)
        {
          localContactsFragment = bd.p(bd.this);
          if (bd.k(bd.this).b())
            break label339;
        }
        label339: for (boolean bool1 = true; ; bool1 = false)
        {
          localContactsFragment.setHasOptionsMenu(bool1);
          bd.q(bd.this).setHasOptionsMenu(true);
          bd.n(bd.this).a(bd.k(bd.this).b(), false);
          bd.o(bd.this).d(true);
          return;
        }
      case 2:
      }
      bd.n(bd.this).a(false, false);
      bd.o(bd.this).d(true);
    }

    void a(View paramView)
    {
      this.b.a(paramView);
    }

    void a(boolean paramBoolean)
    {
      this.b.a(paramBoolean);
    }

    void a(boolean paramBoolean, int paramInt)
    {
      if (paramBoolean)
      {
        a(paramInt);
        switch (paramInt)
        {
        default:
        case 0:
        case 1:
        case 2:
        }
      }
      while (true)
        switch (paramInt)
        {
        default:
          bd.n(bd.this).a(false, null);
          return;
          int i;
          label99: int k;
          label159: SlidingMenu localSlidingMenu1;
          if ((bd.g(bd.this) != null) && (bd.g(bd.this).c()))
          {
            i = 1;
            if ((i != 0) && (!bd.e(bd.this)) && (bd.g(bd.this) != null))
            {
              SlidingMenu localSlidingMenu2 = this.b;
              if ((!bd.g(bd.this).a()) && (!bd.g(bd.this).p()))
                break label316;
              k = 0;
              localSlidingMenu2.setTouchModeBehind(k);
            }
            if (bd.e(bd.this))
              break label322;
            int j = (int)(0.5F * bd.h(bd.this));
            this.b.setTouchModeAbove(0);
            this.b.setTouchmodeMarginThreshold(j);
            this.b.a(bd.i(bd.this).Z());
            this.b.a(bd.i(bd.this).aa());
            this.b.a(bd.j(bd.this).Z());
            this.b.a(bd.j(bd.this).aa());
            label276: localSlidingMenu1 = this.b;
            if (bd.e(bd.this))
              break label333;
          }
          label316: label322: label333: for (boolean bool2 = true; ; bool2 = false)
          {
            localSlidingMenu1.setSlidingEnabled(bool2);
            b(false);
            break;
            i = 0;
            break label99;
            k = 2;
            break label159;
            this.b.setTouchModeAbove(2);
            break label276;
          }
          this.b.setTouchModeAbove(2);
          if (!this.b.f())
            this.b.post(new be(this));
          else
            this.b.setSlidingEnabled(false);
          break;
        case 1:
        case 2:
        }
      bc localbc = bd.n(bd.this);
      boolean bool1 = bd.k(bd.this).b();
      if (bd.k(bd.this).b());
      for (Object localObject = bd.l(bd.this); ; localObject = bd.a(bd.this, bd.m(bd.this)))
      {
        localbc.a(bool1, (CharSequence)localObject);
        return;
      }
      bd.n(bd.this).a(false, bd.a(bd.this, bd.m(bd.this)));
    }

    void b()
    {
      a(true);
    }

    void b(int paramInt)
    {
      boolean bool1 = true;
      boolean bool2;
      switch (paramInt)
      {
      default:
        return;
      case 0:
        if (bd.e(bd.this))
        {
          bd.n(bd.this).a(false);
          bool2 = bool1;
          if (bd.g(bd.this) != null)
            bd.g(bd.this).setHasOptionsMenu(bool2);
          bd.f(bd.this).setHasOptionsMenu(bool1);
          g();
          return;
        }
        if (this.b.f())
        {
          bd.n(bd.this).a(false);
          bd.c(bd.this).getSupportActionBar().c(false);
          bool2 = bool1;
          bool1 = false;
        }
        break;
      case 1:
      case 2:
      }
      while (true)
      {
        bd.n(bd.this).a = false;
        break;
        if (!bd.n(bd.this).a)
        {
          bd.n(bd.this).a(bool1);
          bool2 = false;
          continue;
          f();
          j();
          return;
          b(false);
          g();
        }
        else
        {
          bool1 = false;
          bool2 = false;
        }
      }
    }

    void b(View paramView)
    {
      this.b.b(paramView);
    }

    void b(boolean paramBoolean)
    {
      dj.b(this.e, paramBoolean);
    }

    boolean c()
    {
      return this.b.f();
    }

    boolean d()
    {
      if ((!bd.e(bd.this)) && (!this.b.d()))
        if ((!bd.f(bd.this).isVisible()) || (!bd.f(bd.this).onBackPressed()))
          this.b.a();
      while ((bd.e(bd.this)) && (bd.f(bd.this).isVisible()) && (bd.f(bd.this).onBackPressed()))
        return true;
      return false;
    }

    void e()
    {
      if (this.d != null)
      {
        this.c.removeView(this.d);
        this.d = null;
        d.am.b.a(false);
      }
    }

    void f()
    {
      dj.c(this.d, 0);
    }

    void g()
    {
      dj.c(this.d, 8);
    }

    boolean h()
    {
      return this.d != null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.bd
 * JD-Core Version:    0.6.2
 */