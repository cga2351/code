package android.support.v7.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.appcompat.R.layout;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

public class f
  implements o, AdapterView.OnItemClickListener
{
  Context a;
  LayoutInflater b;
  h c;
  ExpandedMenuView d;
  int e;
  int f;
  int g;
  a h;
  private o.a i;
  private int j;

  public f(int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    this.f = paramInt2;
  }

  public f(Context paramContext, int paramInt)
  {
    this(paramInt, 0);
    this.a = paramContext;
    this.b = LayoutInflater.from(this.a);
  }

  public p a(ViewGroup paramViewGroup)
  {
    if (this.d == null)
    {
      this.d = ((ExpandedMenuView)this.b.inflate(R.layout.abc_expanded_menu_layout, paramViewGroup, false));
      if (this.h == null)
        this.h = new a();
      this.d.setAdapter(this.h);
      this.d.setOnItemClickListener(this);
    }
    return this.d;
  }

  public ListAdapter a()
  {
    if (this.h == null)
      this.h = new a();
    return this.h;
  }

  public void a(Bundle paramBundle)
  {
    SparseArray localSparseArray = new SparseArray();
    if (this.d != null)
      this.d.saveHierarchyState(localSparseArray);
    paramBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
  }

  public void b(Bundle paramBundle)
  {
    SparseArray localSparseArray = paramBundle.getSparseParcelableArray("android:menu:list");
    if (localSparseArray != null)
      this.d.restoreHierarchyState(localSparseArray);
  }

  public boolean collapseItemActionView(h paramh, j paramj)
  {
    return false;
  }

  public boolean expandItemActionView(h paramh, j paramj)
  {
    return false;
  }

  public boolean flagActionItems()
  {
    return false;
  }

  public int getId()
  {
    return this.j;
  }

  public void initForMenu(Context paramContext, h paramh)
  {
    if (this.f != 0)
    {
      this.a = new ContextThemeWrapper(paramContext, this.f);
      this.b = LayoutInflater.from(this.a);
    }
    while (true)
    {
      this.c = paramh;
      if (this.h != null)
        this.h.notifyDataSetChanged();
      return;
      if (this.a != null)
      {
        this.a = paramContext;
        if (this.b == null)
          this.b = LayoutInflater.from(this.a);
      }
    }
  }

  public void onCloseMenu(h paramh, boolean paramBoolean)
  {
    if (this.i != null)
      this.i.onCloseMenu(paramh, paramBoolean);
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.c.a(this.h.a(paramInt), this, 0);
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    b((Bundle)paramParcelable);
  }

  public Parcelable onSaveInstanceState()
  {
    if (this.d == null)
      return null;
    Bundle localBundle = new Bundle();
    a(localBundle);
    return localBundle;
  }

  public boolean onSubMenuSelected(u paramu)
  {
    if (!paramu.hasVisibleItems())
      return false;
    new i(paramu).a(null);
    if (this.i != null)
      this.i.onOpenSubMenu(paramu);
    return true;
  }

  public void setCallback(o.a parama)
  {
    this.i = parama;
  }

  public void updateMenuView(boolean paramBoolean)
  {
    if (this.h != null)
      this.h.notifyDataSetChanged();
  }

  private class a extends BaseAdapter
  {
    private int b = -1;

    public a()
    {
      a();
    }

    public j a(int paramInt)
    {
      ArrayList localArrayList = f.this.c.m();
      int i = paramInt + f.this.e;
      if ((this.b >= 0) && (i >= this.b))
        i++;
      return (j)localArrayList.get(i);
    }

    void a()
    {
      j localj = f.this.c.s();
      if (localj != null)
      {
        ArrayList localArrayList = f.this.c.m();
        int i = localArrayList.size();
        for (int j = 0; j < i; j++)
          if ((j)localArrayList.get(j) == localj)
          {
            this.b = j;
            return;
          }
      }
      this.b = -1;
    }

    public int getCount()
    {
      int i = f.this.c.m().size() - f.this.e;
      if (this.b < 0)
        return i;
      return i - 1;
    }

    public long getItemId(int paramInt)
    {
      return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null);
      for (View localView = f.this.b.inflate(f.this.g, paramViewGroup, false); ; localView = paramView)
      {
        ((p.a)localView).a(a(paramInt), 0);
        return localView;
      }
    }

    public void notifyDataSetChanged()
    {
      a();
      super.notifyDataSetChanged();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.view.menu.f
 * JD-Core Version:    0.6.2
 */