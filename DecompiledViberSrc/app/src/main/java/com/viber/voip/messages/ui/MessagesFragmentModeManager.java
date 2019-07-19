package com.viber.voip.messages.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewParent;
import android.widget.ListView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.k.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.dexshared.Logger;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.contacts.ui.MultiTabsParticipantSelectorActivity;
import com.viber.voip.messages.adapters.a.a;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.ui.MenuSearchMediator;
import com.viber.voip.ui.ac;
import com.viber.voip.ui.ac.a;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.ai;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.aj;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.ak;
import com.viber.voip.ui.dialogs.k;
import com.viber.voip.util.cd;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.z;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MessagesFragmentModeManager extends ar<Long, b>
{
  private static final Logger l = ViberEnv.getLogger();
  protected a b;
  protected c c;
  protected m d;
  private boolean e;
  private MenuSearchMediator f;
  private int g;
  private String h = "";
  private MenuItem i;
  private MenuItem j;
  private MenuItem k;

  public MessagesFragmentModeManager(a parama, c paramc, final MessagesFragmentModeManagerData paramMessagesFragmentModeManagerData, final d paramd, boolean paramBoolean)
  {
    this(parama, paramc, paramBoolean);
    if (paramMessagesFragmentModeManagerData != null)
    {
      this.g = paramMessagesFragmentModeManagerData.savedMode;
      this.h = paramMessagesFragmentModeManagerData.savedQuery;
      a(paramMessagesFragmentModeManagerData.savedSelection);
      if (this.g == 1)
        av.a(av.e.a).postDelayed(new Runnable()
        {
          public void run()
          {
            MessagesFragmentModeManager.this.h();
            paramd.a();
            if ((paramMessagesFragmentModeManagerData.doShowDeleteDialog) && (!MessagesFragmentModeManager.a(MessagesFragmentModeManager.this)))
              MessagesFragmentModeManager.this.u();
          }
        }
        , 1000L);
    }
  }

  public MessagesFragmentModeManager(a parama, c paramc, boolean paramBoolean)
  {
    this.e = paramBoolean;
    this.g = 0;
    this.b = parama;
    this.c = paramc;
    if (this.b.x() != null)
      this.f = new MenuSearchMediator(new ac.a()
      {
        public boolean onQueryTextChange(String paramAnonymousString)
        {
          if ((MessagesFragmentModeManager.this.b != null) && (MessagesFragmentModeManager.this.b.g()))
          {
            if (MessagesFragmentModeManager.this.c != null)
              MessagesFragmentModeManager.this.c.a(paramAnonymousString);
            return true;
          }
          return false;
        }

        public boolean onQueryTextSubmit(String paramAnonymousString)
        {
          return false;
        }

        public boolean onSearchViewShow(boolean paramAnonymousBoolean)
        {
          if ((MessagesFragmentModeManager.this.b != null) && (MessagesFragmentModeManager.this.b.g()))
          {
            MessagesFragmentModeManager.this.a(paramAnonymousBoolean);
            if (!paramAnonymousBoolean)
              MessagesFragmentModeManager.this.b.q();
          }
          return true;
        }
      });
  }

  private boolean B()
  {
    return (this.d != null) && (this.d.isVisible());
  }

  static z a(a parama)
  {
    Activity localActivity = parama.x();
    if (!(localActivity instanceof z))
    {
      Fragment localFragment = parama.getParentFragment();
      if ((localFragment instanceof z))
        return (z)localFragment;
    }
    else
    {
      return (z)localActivity;
    }
    return null;
  }

  private void a(Activity paramActivity, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ViberDialogHandlers.aj localaj = new ViberDialogHandlers.aj();
      localaj.a = this.c;
      localaj.b = f();
      this.d = k.i().a(localaj).a(paramActivity);
      return;
    }
    ViberDialogHandlers.ai localai = new ViberDialogHandlers.ai();
    localai.a = this.c;
    localai.b = f();
    this.d = k.h().a(localai).a(paramActivity);
  }

  private void b(Activity paramActivity, boolean paramBoolean)
  {
    ViberDialogHandlers.ak localak = new ViberDialogHandlers.ak();
    localak.a = this.c;
    localak.b = f();
    if (paramBoolean)
    {
      this.d = k.k().a(localak).a(paramActivity);
      return;
    }
    this.d = k.j().a(localak).a(paramActivity);
  }

  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(2);
      return;
    }
    a(0);
  }

  public void A()
  {
    if ((this.f != null) && (this.f.e()))
      this.f.f();
  }

  protected b a(b.a parama)
  {
    if ((this.b == null) || (this.b.x() == null))
      return null;
    return ((AppCompatActivity)this.b.x()).startSupportActionMode(parama);
  }

  public MessagesFragmentModeManagerData a()
  {
    return new MessagesFragmentModeManagerData(this);
  }

  public b a(a parama)
  {
    ConversationLoaderEntity localConversationLoaderEntity = parama.a();
    return new b(localConversationLoaderEntity.isGroupBehavior(), localConversationLoaderEntity.isMuteConversation(), parama.g(), localConversationLoaderEntity.getConversationType(), localConversationLoaderEntity.getGroupRole(), localConversationLoaderEntity.getFlags(), localConversationLoaderEntity.getAppId(), localConversationLoaderEntity.getWatchersCount(), localConversationLoaderEntity.isDisabledConversation());
  }

  public void a(int paramInt)
  {
    if (this.g != paramInt)
    {
      this.g = paramInt;
      b(this.b.getSelectedItemPosition());
      p();
      if (this.c != null)
        this.c.b(this.g);
    }
    if (this.g == 2)
      MessageComposerView.a = false;
  }

  protected void a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    if ((!paramBoolean4) && ((paramBoolean2) || (paramBoolean1)))
      if ((paramBoolean1) && (paramBoolean5))
        if (this.c != null)
          this.c.a(f());
    while (this.c == null)
    {
      return;
      if (paramBoolean3)
      {
        b(paramActivity, paramBoolean2);
        return;
      }
      a(paramActivity, paramBoolean2);
      return;
    }
    this.c.a(f());
  }

  public void a(b paramb)
  {
    a(0);
    d();
    if (this.c != null)
      this.c.m();
  }

  public void a(Menu paramMenu, boolean paramBoolean, String paramString)
  {
    if ((this.b != null) && (this.b.x() != null))
    {
      this.k = paramMenu.findItem(R.id.menu_search);
      if (this.k != null)
        break label40;
    }
    label40: 
    do
    {
      return;
      Resources localResources = ViberApplication.getApplication().getResources();
      SearchView localSearchView = (SearchView)this.k.getActionView();
      if (localSearchView != null)
      {
        localSearchView.setQueryHint(paramString);
        localSearchView.setMaxWidth(localResources.getDimensionPixelOffset(R.dimen.search_view_max_width));
      }
    }
    while (!paramBoolean);
    MenuSearchMediator localMenuSearchMediator = this.f;
    MenuItem localMenuItem = this.k;
    if (this.g == 2);
    for (boolean bool = true; ; bool = false)
    {
      localMenuSearchMediator.a(localMenuItem, bool, this.h);
      if (this.g != 2)
        break;
      c(true);
      return;
    }
  }

  public void a(String paramString)
  {
    this.f.d();
    this.f.a(paramString);
  }

  public void a(Set<Long> paramSet)
  {
  }

  public void a(boolean paramBoolean)
  {
    if ((this.b != null) && (this.b.x() != null))
    {
      if (!c())
        break label58;
      ((MultiTabsParticipantSelectorActivity)this.b.x()).a(paramBoolean);
      this.b.a(paramBoolean);
      d(paramBoolean);
    }
    label58: 
    while (!b())
      return;
    c(paramBoolean);
    d(paramBoolean);
  }

  public boolean a(long paramLong, b paramb)
  {
    if (this.g == 0)
    {
      a(Long.valueOf(paramLong), paramb);
      if (this.c != null)
        this.c.m();
      return true;
    }
    return false;
  }

  public boolean a(b paramb, Menu paramMenu)
  {
    a(1);
    b(paramb);
    o();
    paramb.a().inflate(R.menu.action_mode_menu_messages, paramMenu);
    this.i = paramMenu.findItem(R.id.menu_delete);
    MenuItem localMenuItem = this.i;
    if (g() > 0);
    for (boolean bool = true; ; bool = false)
    {
      localMenuItem.setVisible(bool);
      this.j = paramMenu.findItem(R.id.menu_conversation_system_info);
      this.j.setVisible(false);
      return true;
    }
  }

  public boolean a(b paramb, MenuItem paramMenuItem)
  {
    int m = 0;
    int n = paramMenuItem.getItemId();
    if (n == R.id.menu_select_all)
    {
      int i1;
      if ((this.b != null) && (this.b.getListView() != null))
      {
        i1 = this.b.getListView().getCount();
        if (g() != i1)
          break label78;
        d();
        this.b.getListView().clearChoices();
      }
      while (true)
      {
        return true;
        label78: b(this.b.s());
        while (m < i1)
        {
          this.b.getListView().setItemChecked(m, true);
          m++;
        }
      }
    }
    if (n == R.id.menu_delete)
    {
      u();
      return true;
    }
    if (n == R.id.menu_conversation_system_info)
    {
      a(f().keySet());
      return true;
    }
    return false;
  }

  public void b(int paramInt)
  {
    int m;
    if ((this.g == 0) || (this.g == 2))
      if ((this.e) || (this.b.r()))
        m = 1;
    while (true)
    {
      ListView localListView = this.b.getListView();
      int n = localListView.getChoiceMode();
      if (m != n)
      {
        if ((n == 1) || (n == 2))
          localListView.clearChoices();
        localListView.setChoiceMode(m);
        if (m != 1)
          break label96;
        localListView.setItemChecked(paramInt, true);
      }
      label96: 
      while (m != 0)
      {
        return;
        m = 0;
        break;
      }
      localListView.invalidateViews();
      return;
      m = 2;
    }
  }

  public void b(boolean paramBoolean)
  {
    if (this.g == 0)
      if (paramBoolean)
        this.f.d();
    while ((this.g != 2) || (!paramBoolean))
      return;
    this.f.f();
  }

  boolean b()
  {
    return a(this.b) != null;
  }

  public boolean b(long paramLong, b paramb)
  {
    if (this.g == 1)
    {
      if (b(Long.valueOf(paramLong)))
        a(Long.valueOf(paramLong));
    }
    else
      return false;
    b(Long.valueOf(paramLong), paramb);
    return true;
  }

  public boolean b(b paramb, Menu paramMenu)
  {
    return false;
  }

  public void c(boolean paramBoolean)
  {
    z localz = a(this.b);
    if (localz != null)
    {
      localz.a(paramBoolean);
      this.b.a(paramBoolean);
    }
    p();
  }

  public boolean c()
  {
    return this.b.x() instanceof MultiTabsParticipantSelectorActivity;
  }

  protected void e()
  {
    int m = 1;
    if (m == this.g)
    {
      o();
      if (this.i != null)
      {
        localMenuItem = this.i;
        if (g() > 0)
          localMenuItem.setVisible(m);
      }
      else
      {
        if (g() == 0)
          i();
        if (this.c != null)
          this.c.m();
      }
    }
    while (this.g != 0)
      while (true)
      {
        MenuItem localMenuItem;
        return;
        int n = 0;
      }
    this.f.a(m());
  }

  public int j()
  {
    return this.g;
  }

  public boolean k()
  {
    return this.g == 2;
  }

  public boolean l()
  {
    return this.g == 1;
  }

  public boolean m()
  {
    return (this.b != null) && (this.b.p());
  }

  public void n()
  {
    if (l())
      i();
  }

  public void o()
  {
    if (this.b != null);
    for (Activity localActivity = this.b.x(); localActivity == null; localActivity = null)
      return;
    a(localActivity.getString(R.string.choose_conversations), g(), this.b.getLayoutInflater());
    if (this.a != null);
    for (View localView = this.a.i(); ; localView = null)
    {
      ViewParent localViewParent = null;
      if (localView != null)
        localViewParent = localView.getParent();
      if (!(localViewParent instanceof View))
        break;
      dj.a((View)localViewParent, dc.g(localActivity, R.attr.toolbarBackground));
      return;
    }
  }

  public void p()
  {
    if ((this.b == null) || (this.b.x() == null));
    do
    {
      return;
      if (this.k != null)
        this.k.setVisible(true);
    }
    while (this.g != 2);
    this.f.a(true);
  }

  public boolean q()
  {
    b(true);
    return false;
  }

  public boolean r()
  {
    if ((this.f != null) && (this.f.e()))
    {
      this.f.f();
      return true;
    }
    return false;
  }

  public void s()
  {
    if (this.g == 2)
      this.f.i();
  }

  public String t()
  {
    String str = "";
    if (this.g == 2)
      str = this.f.a();
    return str;
  }

  protected void u()
  {
    if (this.b != null);
    for (Activity localActivity = this.b.x(); localActivity == null; localActivity = null)
      return;
    int m;
    label36: boolean bool1;
    int n;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    label71: b localb;
    boolean bool7;
    if (g() > 0)
    {
      m = 1;
      if (m == 0)
        break label204;
      Iterator localIterator = f().values().iterator();
      bool1 = false;
      n = 1;
      bool2 = true;
      bool3 = true;
      bool4 = false;
      bool5 = false;
      while (true)
        if (localIterator.hasNext())
        {
          localb = (b)localIterator.next();
          if (!localb.e)
            if ((!bool5) && (localb.a))
              bool7 = true;
        }
    }
    while (true)
    {
      label115: if (localb.a)
      {
        bool3 &= localb.b;
        if (!localb.d)
          n = 0;
        if (localb.f == 5)
          bool1 = cd.f(localb.g);
      }
      for (int i1 = n; ; i1 = n)
      {
        if ((!localb.c) || (bool2))
          bool2 &= localb.c;
        n = i1;
        bool5 = bool7;
        break label71;
        m = 0;
        break label36;
        label204: break;
        if ((!bool5) || (!localb.a))
          break label278;
        bool4 = true;
        bool7 = bool5;
        break label115;
        boolean bool6 = false;
        if (n != 0)
          if (!bool5)
          {
            bool6 = false;
            if (!bool4);
          }
          else
          {
            bool6 = true;
          }
        a(localActivity, bool5, bool4, bool3, bool2, bool6, bool1);
        return;
      }
      label278: bool7 = bool5;
    }
  }

  public boolean v()
  {
    return this.b.r();
  }

  protected void w()
  {
    if (B())
      this.d.dismiss();
  }

  public ac x()
  {
    return this.f;
  }

  public void y()
  {
    if (this.f.c() != null)
      this.f.c().clearFocus();
  }

  public void z()
  {
    if (this.f != null)
      this.f.h();
  }

  public static class MessagesFragmentModeManagerData
    implements Parcelable
  {
    public static final Parcelable.Creator<MessagesFragmentModeManagerData> CREATOR = new Parcelable.Creator()
    {
      public MessagesFragmentModeManager.MessagesFragmentModeManagerData a(Parcel paramAnonymousParcel)
      {
        return new MessagesFragmentModeManager.MessagesFragmentModeManagerData(paramAnonymousParcel);
      }

      public MessagesFragmentModeManager.MessagesFragmentModeManagerData[] a(int paramAnonymousInt)
      {
        return new MessagesFragmentModeManager.MessagesFragmentModeManagerData[paramAnonymousInt];
      }
    };
    protected boolean doShowDeleteDialog;
    public int savedMode;
    protected String savedQuery;
    protected Map<Long, MessagesFragmentModeManager.b> savedSelection = new HashMap();

    protected MessagesFragmentModeManagerData()
    {
    }

    protected MessagesFragmentModeManagerData(Parcel paramParcel)
    {
      this.savedMode = paramParcel.readInt();
      this.savedQuery = paramParcel.readString();
      int i = paramParcel.readInt();
      int j = 0;
      if (j < i)
      {
        Map localMap = this.savedSelection;
        Long localLong = Long.valueOf(paramParcel.readLong());
        boolean bool2;
        label69: boolean bool3;
        if (paramParcel.readByte() == 1)
        {
          bool2 = true;
          if (paramParcel.readByte() != 1)
            break label146;
          bool3 = true;
          label80: if (paramParcel.readByte() != 1)
            break label152;
        }
        label146: label152: for (boolean bool4 = true; ; bool4 = false)
        {
          localMap.put(localLong, new MessagesFragmentModeManager.b(bool2, bool3, bool4, paramParcel.readInt(), paramParcel.readInt(), paramParcel.readLong(), paramParcel.readInt(), paramParcel.readInt()));
          j++;
          break;
          bool2 = false;
          break label69;
          bool3 = false;
          break label80;
        }
      }
      if (paramParcel.readByte() == 1);
      for (boolean bool1 = true; ; bool1 = false)
      {
        this.doShowDeleteDialog = bool1;
        return;
      }
    }

    protected MessagesFragmentModeManagerData(MessagesFragmentModeManager paramMessagesFragmentModeManager)
    {
      this.savedMode = paramMessagesFragmentModeManager.j();
      this.savedQuery = paramMessagesFragmentModeManager.t();
      this.savedSelection = paramMessagesFragmentModeManager.f();
      this.doShowDeleteDialog = MessagesFragmentModeManager.a(paramMessagesFragmentModeManager);
      paramMessagesFragmentModeManager.w();
    }

    public void clearSavedQuery()
    {
      this.savedQuery = "";
    }

    public int describeContents()
    {
      return 0;
    }

    public String getSavedQuery()
    {
      return this.savedQuery;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      paramParcel.writeInt(this.savedMode);
      paramParcel.writeString(this.savedQuery);
      paramParcel.writeInt(this.savedSelection.size());
      Iterator localIterator = this.savedSelection.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramParcel.writeLong(((Long)localEntry.getKey()).longValue());
        MessagesFragmentModeManager.b localb = (MessagesFragmentModeManager.b)localEntry.getValue();
        int j;
        label109: int k;
        if (localb.a)
        {
          j = i;
          paramParcel.writeByte((byte)j);
          if (!localb.b)
            break label206;
          k = i;
          label127: paramParcel.writeByte((byte)k);
          if (!localb.c)
            break label212;
        }
        label206: label212: for (int m = i; ; m = 0)
        {
          paramParcel.writeByte((byte)m);
          paramParcel.writeInt(localb.f);
          paramParcel.writeInt(localb.g);
          paramParcel.writeLong(localb.h);
          paramParcel.writeInt(localb.i);
          paramParcel.writeInt(localb.j);
          break;
          j = 0;
          break label109;
          k = 0;
          break label127;
        }
      }
      if (this.doShowDeleteDialog);
      while (true)
      {
        paramParcel.writeByte((byte)i);
        return;
        i = 0;
      }
    }
  }

  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);

    public abstract boolean g();

    public abstract LayoutInflater getLayoutInflater();

    public abstract ListView getListView();

    public abstract Fragment getParentFragment();

    public abstract int getSelectedItemPosition();

    public abstract boolean p();

    public abstract void q();

    public abstract boolean r();

    public abstract Map<Long, MessagesFragmentModeManager.b> s();

    public abstract Activity x();
  }

  public static class b
  {
    protected boolean a;
    protected boolean b;
    protected boolean c;
    protected boolean d;
    public boolean e;
    public int f;
    public int g;
    public long h;
    public int i;
    public int j;

    public b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4)
    {
      this.a = paramBoolean1;
      this.b = paramBoolean2;
      this.f = paramInt1;
      this.c = paramBoolean3;
      this.g = paramInt2;
      this.h = paramLong;
      this.i = paramInt3;
      this.j = paramInt4;
    }

    public b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, boolean paramBoolean4)
    {
      this(paramBoolean1, paramBoolean2, paramBoolean3, paramInt1, paramInt2, paramLong, paramInt3, paramInt4);
      this.d = paramBoolean4;
    }
  }

  public static abstract interface c
  {
    public abstract void a(long paramLong, int paramInt);

    public abstract void a(long paramLong, int paramInt, boolean paramBoolean);

    public abstract void a(String paramString);

    public abstract void a(Map<Long, MessagesFragmentModeManager.b> paramMap);

    public abstract void b(int paramInt);

    public abstract void b(Map<Long, MessagesFragmentModeManager.b> paramMap);

    public abstract void m();
  }

  public static abstract interface d
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.MessagesFragmentModeManager
 * JD-Core Version:    0.6.2
 */