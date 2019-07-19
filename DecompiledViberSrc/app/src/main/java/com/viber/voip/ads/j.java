package com.viber.voip.ads;

import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Handler;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import com.viber.common.a.e;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.d.n;
import com.viber.voip.av.e;
import com.viber.voip.messages.adapters.b;
import com.viber.voip.ui.ViberListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

public class j
{
  private static final e a = ViberEnv.getLogger();
  private static final long b = TimeUnit.SECONDS.toMillis(1L);
  private static final long c = TimeUnit.SECONDS.toMillis(2L);
  private Handler d = av.e.f.a();
  private List<Runnable> e = Collections.synchronizedList(new ArrayList());
  private k f;

  @NotNull
  private final ViberListView g;

  @NotNull
  private final ListAdapter h;
  private int i = 0;
  private DataSetObserver j = new DataSetObserver()
  {
    public void onChanged()
    {
      super.onChanged();
      j.a(j.this, -1 + j.a(j.this).getCount());
      j.a(j.this, j.b(j.this));
    }
  };
  private AbsListView.OnScrollListener k = new AbsListView.OnScrollListener()
  {
    public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
    }

    public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
    {
      switch (paramAnonymousInt)
      {
      default:
        return;
      case 0:
        j.a(j.this, paramAnonymousAbsListView);
        return;
      case 1:
      case 2:
      }
      j.c(j.this);
    }
  };

  public j(k paramk, ViberListView paramViberListView, ListAdapter paramListAdapter)
  {
    this.f = paramk;
    this.g = paramViberListView;
    this.h = paramListAdapter;
    paramViberListView.a(this.k);
    paramListAdapter.registerDataSetObserver(this.j);
  }

  private Pair<n, Boolean> a(AbsListView paramAbsListView)
  {
    int m = paramAbsListView.getFirstVisiblePosition();
    Rect localRect = new Rect();
    paramAbsListView.getDrawingRect(localRect);
    int n = paramAbsListView.getChildCount();
    for (int i1 = 0; i1 < n; i1++)
    {
      View localView = paramAbsListView.getChildAt(i1);
      if ((localView != null) && (m + i1 < ((ListAdapter)paramAbsListView.getAdapter()).getCount()))
      {
        Object localObject = ((ListAdapter)paramAbsListView.getAdapter()).getItem(m + i1);
        if ((localObject instanceof b))
        {
          n localn = ((b)localObject).j();
          float f1 = localView.getY();
          int i2 = localView.getHeight();
          if ((f1 >= localRect.top) && (f1 + localView.getHeight() <= localRect.bottom))
            return Pair.create(localn, Boolean.valueOf(true));
          if ((f1 + i2 / 2 >= localRect.top) || (f1 + i2 / 2 >= localRect.bottom))
            return Pair.create(localn, Boolean.valueOf(false));
        }
      }
    }
    return null;
  }

  private boolean a(Pair<n, Boolean> paramPair)
  {
    if ((paramPair != null) && (paramPair.first != null) && (!this.f.b(((n)paramPair.first).b(), 1)))
    {
      if (((Boolean)paramPair.second).booleanValue());
      for (long l = b; ; l = c)
      {
        a locala = new a((n)paramPair.first, l);
        this.e.add(locala);
        this.d.postDelayed(locala, l);
        return true;
      }
    }
    return false;
  }

  private void b(AbsListView paramAbsListView)
  {
    a(a(paramAbsListView));
  }

  private void c()
  {
    ArrayList localArrayList = new ArrayList(this.e);
    this.e.clear();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      this.d.removeCallbacks(localRunnable);
    }
  }

  public void a()
  {
    c();
  }

  public void b()
  {
    c();
    this.g.b(this.k);
    this.h.unregisterDataSetObserver(this.j);
  }

  private class a
    implements Runnable
  {
    private n b;
    private long c;

    a(n paramLong, long arg3)
    {
      this.b = paramLong;
      Object localObject;
      this.c = localObject;
    }

    public void run()
    {
      j.e(j.this).c(this.b, j.d(j.this));
      j.f(j.this).remove(this);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.j
 * JD-Core Version:    0.6.2
 */