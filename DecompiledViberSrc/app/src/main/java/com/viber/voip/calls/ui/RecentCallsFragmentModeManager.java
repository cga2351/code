package com.viber.voip.calls.ui;

import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.c.a;
import android.support.v7.view.b.a;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import com.viber.voip.R.id;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.calls.c;
import com.viber.voip.messages.ui.aq;
import com.viber.voip.model.AggregatedCall;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RecentCallsFragmentModeManager extends aq<Integer>
{
  private a a;
  private c b;
  private RecentCallsFragment c;
  private MenuItem d;
  private MenuItem e;
  private boolean f = false;
  private AggregatedCall g;
  private boolean h;

  public RecentCallsFragmentModeManager(a parama, RecentCallsFragment paramRecentCallsFragment, c paramc)
  {
    a(false);
    this.c = paramRecentCallsFragment;
    this.a = parama;
    this.b = paramc;
  }

  public RecentCallsFragmentModeManager(a parama, RecentCallsFragment paramRecentCallsFragment, c paramc, RecentCallsFragmentModeManagerData paramRecentCallsFragmentModeManagerData, boolean paramBoolean)
  {
    this(parama, paramRecentCallsFragment, paramc);
    if (paramRecentCallsFragmentModeManagerData != null)
    {
      this.f = paramRecentCallsFragmentModeManagerData.editMode;
      a(paramRecentCallsFragmentModeManagerData.savedSelection);
      if (this.f)
        av.a(av.e.a).postDelayed(new b(this, null), 400L);
    }
    this.h = paramBoolean;
  }

  private void k()
  {
    ListView localListView;
    if (this.c != null)
    {
      localListView = this.c.getListView();
      if (g() <= 0)
        break label106;
    }
    label106: for (int i = 1; ; i = 0)
    {
      if ((localListView == null) || (!this.f) || (i == 0) || (!this.h))
        return;
      localListView.clearChoices();
      localListView.setChoiceMode(2);
      Iterator localIterator = f().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (localInteger != null)
          localListView.setItemChecked(localInteger.intValue(), true);
      }
      localListView = null;
      break;
    }
  }

  private void l()
  {
    if (this.a != null)
      this.a.a(f());
  }

  protected android.support.v7.view.b a(b.a parama)
  {
    if ((this.c == null) || (this.c.getActivity() == null))
      return null;
    return ((AppCompatActivity)this.c.getActivity()).startSupportActionMode(parama);
  }

  public RecentCallsFragmentModeManagerData a()
  {
    return new RecentCallsFragmentModeManagerData(this, null);
  }

  public void a(int paramInt)
  {
    int i;
    if (!this.f)
      if (this.h)
        i = 1;
    while (true)
    {
      ListView localListView = this.c.getListView();
      int j = localListView.getChoiceMode();
      if (i != j)
      {
        if (j != 1)
          break label68;
        localListView.clearChoices();
        label46: localListView.setChoiceMode(i);
        if (i != 1)
          break label81;
        localListView.setItemChecked(paramInt, true);
      }
      label68: label81: 
      while (i != 0)
      {
        return;
        i = 0;
        break;
        if (j != 2)
          break label46;
        localListView.clearChoices();
        break label46;
      }
      localListView.setAdapter(localListView.getAdapter());
      return;
      i = 2;
    }
  }

  public void a(android.support.v7.view.b paramb)
  {
    a(false);
    i();
    if (this.a != null)
      this.a.a(true);
  }

  public void a(AggregatedCall paramAggregatedCall)
  {
    c.a locala = new c.a(this.c.getActivity());
    locala.b(paramAggregatedCall.toString().replace("-[", "\n").replace("[", "#\n").replace(",", "\n").replace("]", "").replace(" ", ""));
    locala.a("Close", null);
    locala.c();
  }

  public void a(boolean paramBoolean)
  {
    if (this.f != paramBoolean)
    {
      this.f = paramBoolean;
      a(this.c.getSelectedItemPosition());
    }
    k();
  }

  public boolean a(int paramInt, AggregatedCall paramAggregatedCall)
  {
    if (this.f)
    {
      if (c(Integer.valueOf(paramInt)))
        b(Integer.valueOf(paramInt));
    }
    else
      return false;
    a(Integer.valueOf(paramInt));
    this.g = paramAggregatedCall;
    return true;
  }

  public boolean a(android.support.v7.view.b paramb, Menu paramMenu)
  {
    a(true);
    b(paramb);
    b();
    paramb.a().inflate(R.menu.action_mode_menu_recent_call, paramMenu);
    this.d = paramMenu.findItem(R.id.menu_delete);
    MenuItem localMenuItem = this.d;
    if (g() > 0);
    for (boolean bool = true; ; bool = false)
    {
      localMenuItem.setVisible(bool);
      this.e = paramMenu.findItem(R.id.menu_recent_system_info);
      this.e.setVisible(false);
      return true;
    }
  }

  public boolean a(android.support.v7.view.b paramb, MenuItem paramMenuItem)
  {
    int i = 0;
    int j = paramMenuItem.getItemId();
    int k;
    if (j == R.id.menu_select_all)
      if ((this.c != null) && (this.c.getListView() != null))
      {
        k = this.c.getListView().getCount();
        if (g() != k)
          break label79;
        i();
        this.c.getListView().clearChoices();
        this.c.D();
      }
    label79: 
    do
    {
      do
      {
        return true;
        b(this.b.s());
        while (i < k)
        {
          this.c.getListView().setItemChecked(i, true);
          i++;
        }
      }
      while (this.a == null);
      this.a.w_();
      return true;
      if (j == R.id.menu_delete)
      {
        l();
        return true;
      }
      if (j != R.id.menu_recent_system_info)
        break;
    }
    while (this.g == null);
    a(this.g);
    return true;
    return false;
  }

  public void b()
  {
    if ((this.c != null) && (this.c.getActivity() != null))
      a(this.c.getActivity().getString(R.string.choose_call_logs), g(), this.c.getLayoutInflater());
  }

  public boolean b(int paramInt, AggregatedCall paramAggregatedCall)
  {
    if (!this.f)
    {
      d(Integer.valueOf(paramInt));
      a(true);
      this.g = paramAggregatedCall;
      if (this.a != null)
        this.a.a(false);
      return true;
    }
    return false;
  }

  public boolean b(android.support.v7.view.b paramb, Menu paramMenu)
  {
    return false;
  }

  public boolean c()
  {
    return this.f;
  }

  protected void d()
  {
    MenuItem localMenuItem;
    if ((this.f) && (h() != null))
    {
      b();
      localMenuItem = this.d;
      if (g() <= 0)
        break label69;
    }
    label69: for (boolean bool = true; ; bool = false)
    {
      localMenuItem.setVisible(bool);
      if (g() == 0)
        j();
      if (this.a != null)
        this.a.a(false);
      return;
    }
  }

  public void e()
  {
    if (this.f)
      j();
  }

  public static class RecentCallsFragmentModeManagerData
    implements Parcelable
  {
    public static final Parcelable.Creator<RecentCallsFragmentModeManagerData> CREATOR = new Parcelable.Creator()
    {
      public RecentCallsFragmentModeManager.RecentCallsFragmentModeManagerData a(Parcel paramAnonymousParcel)
      {
        return new RecentCallsFragmentModeManager.RecentCallsFragmentModeManagerData(paramAnonymousParcel, null);
      }

      public RecentCallsFragmentModeManager.RecentCallsFragmentModeManagerData[] a(int paramAnonymousInt)
      {
        return new RecentCallsFragmentModeManager.RecentCallsFragmentModeManagerData[paramAnonymousInt];
      }
    };
    private boolean editMode;
    private LinkedList<Integer> savedSelection = new LinkedList();

    private RecentCallsFragmentModeManagerData(Parcel paramParcel)
    {
      if (paramParcel.readInt() == i);
      while (true)
      {
        this.editMode = i;
        int k = paramParcel.readInt();
        while (j < k)
        {
          this.savedSelection.add(Integer.valueOf(paramParcel.readInt()));
          j++;
        }
        i = 0;
      }
    }

    private RecentCallsFragmentModeManagerData(RecentCallsFragmentModeManager paramRecentCallsFragmentModeManager)
    {
      this.editMode = paramRecentCallsFragmentModeManager.c();
      this.savedSelection = paramRecentCallsFragmentModeManager.f();
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      if (this.editMode);
      for (int i = 1; ; i = 0)
      {
        paramParcel.writeInt(i);
        paramParcel.writeInt(this.savedSelection.size());
        Iterator localIterator = this.savedSelection.iterator();
        while (localIterator.hasNext())
          paramParcel.writeInt(((Integer)localIterator.next()).intValue());
      }
    }
  }

  public static abstract interface a
  {
    public abstract void a(List<Integer> paramList);

    public abstract void a(boolean paramBoolean);

    public abstract void w_();
  }

  private static class b extends com.viber.voip.d.b<RecentCallsFragmentModeManager>
  {
    private b(RecentCallsFragmentModeManager paramRecentCallsFragmentModeManager)
    {
      super();
    }

    public void a(RecentCallsFragmentModeManager paramRecentCallsFragmentModeManager)
    {
      paramRecentCallsFragmentModeManager.d(null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.RecentCallsFragmentModeManager
 * JD-Core Version:    0.6.2
 */