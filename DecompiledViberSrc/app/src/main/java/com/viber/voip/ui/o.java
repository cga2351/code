package com.viber.voip.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.aa;
import com.viber.voip.analytics.story.g.a;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.banner.e;
import com.viber.voip.banner.notificationsoff.d;
import com.viber.voip.banner.notificationsoff.f.a;
import com.viber.voip.util.dj;
import com.viber.voip.z;
import java.util.HashSet;
import java.util.Set;

public abstract class o extends au
  implements AbsListView.OnScrollListener
{
  private static final Logger a = ViberEnv.getLogger();
  protected int N = -1;
  protected boolean O;
  protected String P = "";
  protected boolean Q = true;
  protected com.viber.voip.banner.notificationsoff.f R;
  protected boolean S;
  private int b = -1;
  private int c = -1;
  private final int d;
  private Runnable e;
  private Set<Integer> f;
  private Handler g = av.a(av.e.a);

  protected o(int paramInt)
  {
    this.d = paramInt;
  }

  private void a(boolean paramBoolean, com.viber.voip.banner.view.b paramb)
  {
    a(paramBoolean, com.viber.voip.banner.view.c.a(paramb));
  }

  protected boolean B_()
  {
    return false;
  }

  public void D()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (getView() != null)
      b(this.b, true);
    if ((localFragmentActivity != null) && (getView() != null) && (this.mIsTablet))
      v_();
  }

  protected void a(int paramInt)
  {
  }

  public void a(ListView paramListView, View paramView, int paramInt, long paramLong, boolean paramBoolean)
  {
    onListItemClick(paramListView, paramView, paramInt, paramLong);
  }

  protected void a(boolean paramBoolean, int paramInt)
  {
    ListView localListView = getListView();
    if (localListView == null);
    do
    {
      return;
      if ((paramBoolean) && (localListView.getPaddingBottom() < paramInt))
      {
        localListView.setPadding(localListView.getPaddingLeft(), localListView.getPaddingTop(), localListView.getPaddingRight(), paramInt + localListView.getPaddingBottom());
        return;
      }
    }
    while ((paramBoolean) || (localListView.getPaddingBottom() < paramInt));
    localListView.setPadding(localListView.getPaddingLeft(), localListView.getPaddingTop(), localListView.getPaddingRight(), localListView.getPaddingBottom() - paramInt);
  }

  protected boolean a()
  {
    return false;
  }

  protected void b(int paramInt, boolean paramBoolean)
  {
    getListView().setItemChecked(paramInt, paramBoolean);
  }

  protected void b(View paramView)
  {
    ViewStub localViewStub = (ViewStub)paramView.findViewById(R.id.empty_stub);
    if (localViewStub != null)
      localViewStub.inflate();
  }

  protected boolean c()
  {
    return false;
  }

  protected final e createRemoteBannerDisplayController()
  {
    if (B_())
    {
      final f.a locala = y();
      com.viber.voip.banner.b localb = new com.viber.voip.banner.b(com.viber.voip.banner.f.a(this, new com.viber.voip.g.b.b()
      {
        protected a a()
        {
          return com.viber.voip.analytics.g.a().c().c();
        }
      }
      , this.mIsTablet), new f.a()
      {
        public boolean a()
        {
          if (!o.this.g());
          while ((locala != null) && (!locala.a()))
            return false;
          return true;
        }

        public boolean b()
        {
          if (!o.this.g());
          f.a locala;
          do
          {
            return false;
            locala = o.this.y();
          }
          while ((locala != null) && (!locala.b()));
          return true;
        }
      }
      , ViberApplication.getInstance().getNotificationManagerWrapper(), com.viber.voip.analytics.g.a(), getLayoutInflater());
      localb.a(new p(this, localb));
      this.R = localb;
      return localb;
    }
    this.R = new d();
    return super.createRemoteBannerDisplayController();
  }

  protected void d(int paramInt)
  {
    this.b = paramInt;
  }

  protected abstract void e();

  public boolean g()
  {
    z localz = aa.b(this);
    if (localz != null)
      return localz.a(this.d);
    return true;
  }

  protected abstract void h();

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    h();
    if (this.e != null)
    {
      this.g.removeCallbacks(this.e);
      this.g.postDelayed(this.e, 2000L);
    }
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return (getUserVisibleHint()) && (this.f.contains(Integer.valueOf(paramMenuItem.getItemId())));
  }

  public void onCreate(Bundle paramBundle)
  {
    if (this.Q)
      this.e = new b(this, null);
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      this.O = paramBundle.getBoolean("cont_mode", false);
      if (!paramBundle.containsKey("search_query"))
        break label87;
    }
    label87: for (String str = paramBundle.getString("search_query"); ; str = "")
    {
      this.P = str;
      this.c = paramBundle.getInt("position");
      this.f = new HashSet();
      return;
    }
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    this.f.clear();
    int i = 0;
    int j = paramContextMenu.size();
    while (i < j)
    {
      this.f.add(Integer.valueOf(paramContextMenu.getItem(i).getItemId()));
      i++;
    }
  }

  public void onDestroy()
  {
    super.onDestroy();
    if (this.e != null)
      this.g.removeCallbacks(this.e);
  }

  public void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    super.onFragmentVisibilityChanged(paramBoolean);
    if (paramBoolean)
      this.R.i();
  }

  public void onRemoteBannerVisibilityChange(boolean paramBoolean, com.viber.voip.banner.d.c paramc, com.viber.voip.banner.view.b paramb)
  {
    super.onRemoteBannerVisibilityChange(paramBoolean, paramc, paramb);
    a(paramBoolean, paramb);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("position", this.b);
    if (g())
    {
      paramBundle.putBoolean("cont_mode", this.O);
      paramBundle.putString("search_query", this.P);
    }
    super.onSaveInstanceState(paramBundle);
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((a()) && (paramInt == 1))
    {
      FragmentActivity localFragmentActivity = getActivity();
      if (localFragmentActivity != null)
        dj.c(localFragmentActivity.getCurrentFocus());
    }
  }

  public void onStart()
  {
    super.onStart();
    if ((g()) && (!isHidden()))
      onFragmentVisibilityChanged(true);
  }

  public void onTabReselected()
  {
    t();
  }

  public boolean shouldDisplayBanner(com.viber.voip.banner.d.g paramg, com.viber.voip.banner.d.c paramc, com.viber.voip.banner.d.b paramb)
  {
    return (g()) && (paramb == com.viber.voip.banner.d.b.a(this, this.mIsTablet));
  }

  protected void t()
  {
    if (getView() != null)
    {
      getListView().dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0));
      getListView().setSelectionFromTop(0, 0);
    }
  }

  protected int u()
  {
    return this.b;
  }

  protected void v_()
  {
    ListView localListView;
    int j;
    if ((c()) && (getListAdapter() != null) && (this.N != getListAdapter().getCount()) && (!a()))
    {
      localListView = getListView();
      this.N = localListView.getAdapter().getCount();
      if (this.b > this.N)
        this.b = -1;
      if (this.c > this.N)
        this.c = -1;
      if ((this.N <= 0) || ((this.b != -1) && (this.N != 1)))
        break label235;
      int i = this.c;
      j = 0;
      if (i != -1)
        break label211;
    }
    while (true)
    {
      this.b = j;
      try
      {
        ListAdapter localListAdapter = localListView.getAdapter();
        long l = localListAdapter.getItemId(this.b);
        if (-10L == l)
          if (this.b != 0)
            break label219;
        label211: label219: for (this.b = (1 + this.b); ; this.b = (-1 + this.b))
        {
          l = localListAdapter.getItemId(this.b);
          a(localListView, localListAdapter.getView(this.b, null, localListView), this.b, l, false);
          return;
          j = this.c;
          break;
        }
      }
      catch (Exception localException)
      {
        return;
      }
    }
    label235: a(this.N);
  }

  protected f.a y()
  {
    return null;
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt, Fragment paramFragment);
  }

  private static class b extends com.viber.voip.d.b<o>
  {
    private b(o paramo)
    {
      super();
    }

    public void a(o paramo)
    {
      if (paramo.isAdded())
      {
        paramo.S = true;
        paramo.e();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.o
 * JD-Core Version:    0.6.2
 */