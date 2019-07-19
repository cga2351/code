package com.viber.voip.widget;

import android.database.DataSetObserver;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public final class m extends DataSetObserver
{
  private a a;
  private d b;
  private List<c> c;
  private int d = -1;
  private final SparseArray<b> e = new SparseArray();
  private final FragmentManager f;

  public m(FragmentManager paramFragmentManager)
  {
    this.f = paramFragmentManager;
  }

  private void a(int paramInt)
  {
    ViewGroup localViewGroup = this.a.a(paramInt);
    Fragment localFragment = (Fragment)this.a.instantiateItem(localViewGroup, paramInt);
    this.e.put(paramInt, new b(localViewGroup, localFragment));
  }

  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.a == null) || (this.a.getCount() <= 0));
    int i;
    label62: label249: 
    do
    {
      ViewGroup localViewGroup;
      do
      {
        do
          return;
        while ((paramInt == -1) || ((!paramBoolean1) && (this.d == paramInt) && (this.e.size() != 0)));
        if (paramInt >= 0)
          break;
        paramInt = 0;
        if (this.d == paramInt)
          break label249;
        i = 1;
        this.d = paramInt;
        localViewGroup = this.a.a(this.d);
      }
      while (localViewGroup == null);
      if (this.e.get(this.d) == null)
      {
        this.a.startUpdate(localViewGroup);
        a(this.d);
        this.a.finishUpdate(localViewGroup);
      }
      int j = this.e.size();
      Object localObject1 = null;
      if (j > 0)
      {
        FragmentTransaction localFragmentTransaction = this.f.beginTransaction();
        int k = this.e.size();
        int m = 0;
        if (m < k)
        {
          int n = this.e.keyAt(m);
          Object localObject2 = ((b)this.e.get(n)).a;
          if (n == this.d)
            localFragmentTransaction.show((Fragment)localObject2);
          while (true)
          {
            m++;
            localObject1 = localObject2;
            break label163;
            if (paramInt < this.a.getCount())
              break;
            paramInt = -1 + this.a.getCount();
            break;
            i = 0;
            break label62;
            localFragmentTransaction.hide((Fragment)localObject2);
            localObject2 = localObject1;
          }
        }
        localFragmentTransaction.commitNowAllowingStateLoss();
      }
      if (localObject1 != null)
        this.a.setPrimaryItem(localViewGroup, this.d, localObject1);
    }
    while ((!paramBoolean2) || (i == 0));
    label163: b(paramInt);
  }

  private void b(int paramInt)
  {
    if (this.c != null)
    {
      int i = this.c.size();
      for (int j = 0; j < i; j++)
      {
        c localc = (c)this.c.get(j);
        if (localc != null)
          localc.f(paramInt);
      }
    }
  }

  private void c()
  {
    int i = 0;
    int j = this.e.size();
    for (int k = 0; k < j; k++)
    {
      int n = this.e.keyAt(k);
      b localb = (b)this.e.get(n);
      this.a.startUpdate(localb.b);
      this.a.destroyItem(localb.b, n, localb.a);
      this.a.finishUpdate(localb.b);
    }
    int m = this.e.size();
    while (i < m)
    {
      ((b)this.e.get(this.e.keyAt(i))).b.removeAllViews();
      i++;
    }
    this.e.clear();
  }

  private void d()
  {
    int i = this.a.getCount();
    int j = 0;
    if (j < this.e.size())
    {
      int k = this.e.keyAt(j);
      b localb = (b)this.e.get(k);
      int m = this.a.getItemPosition(localb.a);
      if (m == -1);
      while (true)
      {
        j++;
        break;
        if (m == -2)
        {
          this.e.remove(j);
          this.a.startUpdate(localb.b);
          this.a.destroyItem(localb.b, k, localb.a);
          this.a.finishUpdate(localb.b);
        }
      }
    }
    a(Math.min(this.d, i - 1), true, false);
  }

  public a a()
  {
    return this.a;
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, false, paramBoolean);
  }

  public void a(a parama)
  {
    if (this.a != null)
    {
      this.a.unregisterDataSetObserver(this.b);
      c();
      this.d = 0;
    }
    this.a = parama;
    if (this.a != null)
    {
      if (this.b == null)
        this.b = new d();
      this.a.registerDataSetObserver(this.b);
      a(this.d, true, false);
    }
  }

  public void a(c paramc)
  {
    if (this.c == null)
      this.c = new ArrayList();
    this.c.add(paramc);
  }

  public int b()
  {
    return this.d;
  }

  public void b(c paramc)
  {
    if (this.c != null)
      this.c.remove(paramc);
  }

  public static abstract class a extends FragmentPagerAdapter
  {
    public a(FragmentManager paramFragmentManager)
    {
      super();
    }

    public abstract ViewGroup a(int paramInt);
  }

  private static final class b
  {
    final Fragment a;
    final ViewGroup b;

    b(ViewGroup paramViewGroup, Fragment paramFragment)
    {
      this.a = paramFragment;
      this.b = paramViewGroup;
    }
  }

  public static abstract interface c
  {
    public abstract void f(int paramInt);
  }

  private class d extends DataSetObserver
  {
    d()
    {
    }

    public void onChanged()
    {
      m.a(m.this);
    }

    public void onInvalidated()
    {
      m.a(m.this);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.m
 * JD-Core Version:    0.6.2
 */