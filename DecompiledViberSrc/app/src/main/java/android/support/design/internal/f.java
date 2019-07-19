package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.R.dimen;
import android.support.design.R.layout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.o.a;
import android.support.v7.view.menu.p;
import android.support.v7.view.menu.u;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class f
  implements o
{
  LinearLayout a;
  h b;
  b c;
  LayoutInflater d;
  int e;
  boolean f;
  ColorStateList g;
  ColorStateList h;
  Drawable i;
  int j;
  int k;
  int l;
  final View.OnClickListener m = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      NavigationMenuItemView localNavigationMenuItemView = (NavigationMenuItemView)paramAnonymousView;
      f.this.a(true);
      j localj = localNavigationMenuItemView.getItemData();
      boolean bool = f.this.b.a(localj, f.this, 0);
      if ((localj != null) && (localj.isCheckable()) && (bool))
        f.this.c.a(localj);
      f.this.a(false);
      f.this.updateMenuView(false);
    }
  };
  private NavigationMenuView n;
  private o.a o;
  private int p;
  private int q;

  public j a()
  {
    return this.c.b();
  }

  public p a(ViewGroup paramViewGroup)
  {
    if (this.n == null)
    {
      this.n = ((NavigationMenuView)this.d.inflate(R.layout.design_navigation_menu, paramViewGroup, false));
      if (this.c == null)
        this.c = new b();
      this.a = ((LinearLayout)this.d.inflate(R.layout.design_navigation_item_header, this.n, false));
      this.n.setAdapter(this.c);
    }
    return this.n;
  }

  public void a(int paramInt)
  {
    this.p = paramInt;
  }

  public void a(ColorStateList paramColorStateList)
  {
    this.h = paramColorStateList;
    updateMenuView(false);
  }

  public void a(Drawable paramDrawable)
  {
    this.i = paramDrawable;
    updateMenuView(false);
  }

  public void a(WindowInsetsCompat paramWindowInsetsCompat)
  {
    int i1 = paramWindowInsetsCompat.getSystemWindowInsetTop();
    if (this.q != i1)
    {
      this.q = i1;
      if (this.a.getChildCount() == 0)
        this.n.setPadding(0, this.q, 0, this.n.getPaddingBottom());
    }
    ViewCompat.dispatchApplyWindowInsets(this.a, paramWindowInsetsCompat);
  }

  public void a(j paramj)
  {
    this.c.a(paramj);
  }

  public void a(View paramView)
  {
    this.a.addView(paramView);
    this.n.setPadding(0, 0, 0, this.n.getPaddingBottom());
  }

  public void a(boolean paramBoolean)
  {
    if (this.c != null)
      this.c.a(paramBoolean);
  }

  public int b()
  {
    return this.a.getChildCount();
  }

  public View b(int paramInt)
  {
    View localView = this.d.inflate(paramInt, this.a, false);
    a(localView);
    return localView;
  }

  public void b(ColorStateList paramColorStateList)
  {
    this.g = paramColorStateList;
    updateMenuView(false);
  }

  public void b(View paramView)
  {
    this.a.removeView(paramView);
    if (this.a.getChildCount() == 0)
      this.n.setPadding(0, this.q, 0, this.n.getPaddingBottom());
  }

  public ColorStateList c()
  {
    return this.h;
  }

  public View c(int paramInt)
  {
    return this.a.getChildAt(paramInt);
  }

  public boolean collapseItemActionView(h paramh, j paramj)
  {
    return false;
  }

  public ColorStateList d()
  {
    return this.g;
  }

  public void d(int paramInt)
  {
    this.e = paramInt;
    this.f = true;
    updateMenuView(false);
  }

  public Drawable e()
  {
    return this.i;
  }

  public void e(int paramInt)
  {
    this.j = paramInt;
    updateMenuView(false);
  }

  public boolean expandItemActionView(h paramh, j paramj)
  {
    return false;
  }

  public int f()
  {
    return this.j;
  }

  public void f(int paramInt)
  {
    this.k = paramInt;
    updateMenuView(false);
  }

  public boolean flagActionItems()
  {
    return false;
  }

  public int g()
  {
    return this.k;
  }

  public int getId()
  {
    return this.p;
  }

  public void initForMenu(Context paramContext, h paramh)
  {
    this.d = LayoutInflater.from(paramContext);
    this.b = paramh;
    this.l = paramContext.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
  }

  public void onCloseMenu(h paramh, boolean paramBoolean)
  {
    if (this.o != null)
      this.o.onCloseMenu(paramh, paramBoolean);
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      Bundle localBundle1 = (Bundle)paramParcelable;
      SparseArray localSparseArray1 = localBundle1.getSparseParcelableArray("android:menu:list");
      if (localSparseArray1 != null)
        this.n.restoreHierarchyState(localSparseArray1);
      Bundle localBundle2 = localBundle1.getBundle("android:menu:adapter");
      if (localBundle2 != null)
        this.c.a(localBundle2);
      SparseArray localSparseArray2 = localBundle1.getSparseParcelableArray("android:menu:header");
      if (localSparseArray2 != null)
        this.a.restoreHierarchyState(localSparseArray2);
    }
  }

  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    if (this.n != null)
    {
      SparseArray localSparseArray1 = new SparseArray();
      this.n.saveHierarchyState(localSparseArray1);
      localBundle.putSparseParcelableArray("android:menu:list", localSparseArray1);
    }
    if (this.c != null)
      localBundle.putBundle("android:menu:adapter", this.c.c());
    if (this.a != null)
    {
      SparseArray localSparseArray2 = new SparseArray();
      this.a.saveHierarchyState(localSparseArray2);
      localBundle.putSparseParcelableArray("android:menu:header", localSparseArray2);
    }
    return localBundle;
  }

  public boolean onSubMenuSelected(u paramu)
  {
    return false;
  }

  public void setCallback(o.a parama)
  {
    this.o = parama;
  }

  public void updateMenuView(boolean paramBoolean)
  {
    if (this.c != null)
      this.c.a();
  }

  private static class a extends f.j
  {
    public a(View paramView)
    {
      super();
    }
  }

  private class b extends RecyclerView.Adapter<f.j>
  {
    private final ArrayList<f.d> b = new ArrayList();
    private j c;
    private boolean d;

    b()
    {
      d();
    }

    private void a(int paramInt1, int paramInt2)
    {
      while (paramInt1 < paramInt2)
      {
        ((f.f)this.b.get(paramInt1)).a = true;
        paramInt1++;
      }
    }

    private void d()
    {
      if (this.d)
        return;
      this.d = true;
      this.b.clear();
      this.b.add(new f.c());
      int i = -1;
      int j = 0;
      boolean bool1 = false;
      int k = f.this.b.j().size();
      int m = 0;
      j localj1;
      int i2;
      int n;
      int i1;
      boolean bool2;
      while (true)
        if (m < k)
        {
          localj1 = (j)f.this.b.j().get(m);
          if (localj1.isChecked())
            a(localj1);
          if (localj1.isCheckable())
            localj1.a(false);
          if (localj1.hasSubMenu())
          {
            SubMenu localSubMenu = localj1.getSubMenu();
            if (localSubMenu.hasVisibleItems())
            {
              if (m != 0)
                this.b.add(new f.e(f.this.l, 0));
              this.b.add(new f.f(localj1));
              int i3 = 0;
              int i4 = this.b.size();
              int i5 = localSubMenu.size();
              for (int i6 = 0; i6 < i5; i6++)
              {
                j localj2 = (j)localSubMenu.getItem(i6);
                if (localj2.isVisible())
                {
                  if ((i3 == 0) && (localj2.getIcon() != null))
                    i3 = 1;
                  if (localj2.isCheckable())
                    localj2.a(false);
                  if (localj1.isChecked())
                    a(localj1);
                  this.b.add(new f.f(localj2));
                }
              }
              if (i3 != 0)
                a(i4, this.b.size());
            }
            i2 = i;
            m++;
            i = i2;
          }
          else
          {
            n = localj1.getGroupId();
            if (n != i)
            {
              i1 = this.b.size();
              if (localj1.getIcon() != null)
              {
                bool2 = true;
                label368: if (m != 0)
                {
                  i1++;
                  this.b.add(new f.e(f.this.l, f.this.l));
                }
              }
            }
          }
        }
      while (true)
      {
        f.f localf = new f.f(localj1);
        localf.a = bool2;
        this.b.add(localf);
        bool1 = bool2;
        j = i1;
        i2 = n;
        break;
        bool2 = false;
        break label368;
        if ((!bool1) && (localj1.getIcon() != null))
        {
          bool2 = true;
          a(j, this.b.size());
          i1 = j;
          continue;
          this.d = false;
        }
        else
        {
          bool2 = bool1;
          i1 = j;
        }
      }
    }

    public f.j a(ViewGroup paramViewGroup, int paramInt)
    {
      switch (paramInt)
      {
      default:
        return null;
      case 0:
        return new f.g(f.this.d, paramViewGroup, f.this.m);
      case 1:
        return new f.i(f.this.d, paramViewGroup);
      case 2:
        return new f.h(f.this.d, paramViewGroup);
      case 3:
      }
      return new f.a(f.this.a);
    }

    public void a()
    {
      d();
      notifyDataSetChanged();
    }

    public void a(Bundle paramBundle)
    {
      int i = 0;
      int j = paramBundle.getInt("android:menu:checked", 0);
      int n;
      SparseArray localSparseArray;
      label121: f.d locald1;
      if (j != 0)
      {
        this.d = true;
        int m = this.b.size();
        n = 0;
        if (n < m)
        {
          f.d locald2 = (f.d)this.b.get(n);
          if ((locald2 instanceof f.f))
          {
            j localj2 = ((f.f)locald2).a();
            if ((localj2 != null) && (localj2.getItemId() == j))
              a(localj2);
          }
        }
        else
        {
          this.d = false;
          d();
        }
      }
      else
      {
        localSparseArray = paramBundle.getSparseParcelableArray("android:menu:action_views");
        if (localSparseArray == null)
          return;
        int k = this.b.size();
        if (i >= k)
          return;
        locald1 = (f.d)this.b.get(i);
        if ((locald1 instanceof f.f))
          break label160;
      }
      while (true)
      {
        i++;
        break label121;
        n++;
        break;
        label160: j localj1 = ((f.f)locald1).a();
        if (localj1 != null)
        {
          View localView = localj1.getActionView();
          if (localView != null)
          {
            ParcelableSparseArray localParcelableSparseArray = (ParcelableSparseArray)localSparseArray.get(localj1.getItemId());
            if (localParcelableSparseArray != null)
              localView.restoreHierarchyState(localParcelableSparseArray);
          }
        }
      }
    }

    public void a(f.j paramj)
    {
      if ((paramj instanceof f.g))
        ((NavigationMenuItemView)paramj.itemView).b();
    }

    public void a(f.j paramj, int paramInt)
    {
      switch (getItemViewType(paramInt))
      {
      default:
        return;
      case 0:
        NavigationMenuItemView localNavigationMenuItemView = (NavigationMenuItemView)paramj.itemView;
        localNavigationMenuItemView.setIconTintList(f.this.h);
        if (f.this.f)
          localNavigationMenuItemView.setTextAppearance(f.this.e);
        if (f.this.g != null)
          localNavigationMenuItemView.setTextColor(f.this.g);
        if (f.this.i != null);
        for (Drawable localDrawable = f.this.i.getConstantState().newDrawable(); ; localDrawable = null)
        {
          ViewCompat.setBackground(localNavigationMenuItemView, localDrawable);
          f.f localf = (f.f)this.b.get(paramInt);
          localNavigationMenuItemView.setNeedsEmptyIcon(localf.a);
          localNavigationMenuItemView.setHorizontalPadding(f.this.j);
          localNavigationMenuItemView.setIconPadding(f.this.k);
          localNavigationMenuItemView.a(localf.a(), 0);
          return;
        }
      case 1:
        ((TextView)paramj.itemView).setText(((f.f)this.b.get(paramInt)).a().getTitle());
        return;
      case 2:
      }
      f.e locale = (f.e)this.b.get(paramInt);
      paramj.itemView.setPadding(0, locale.a(), 0, locale.b());
    }

    public void a(j paramj)
    {
      if ((this.c == paramj) || (!paramj.isCheckable()))
        return;
      if (this.c != null)
        this.c.setChecked(false);
      this.c = paramj;
      paramj.setChecked(true);
    }

    public void a(boolean paramBoolean)
    {
      this.d = paramBoolean;
    }

    public j b()
    {
      return this.c;
    }

    public Bundle c()
    {
      Bundle localBundle = new Bundle();
      if (this.c != null)
        localBundle.putInt("android:menu:checked", this.c.getItemId());
      SparseArray localSparseArray = new SparseArray();
      int i = this.b.size();
      int j = 0;
      if (j < i)
      {
        f.d locald = (f.d)this.b.get(j);
        j localj;
        if ((locald instanceof f.f))
        {
          localj = ((f.f)locald).a();
          if (localj == null)
            break label135;
        }
        label135: for (View localView = localj.getActionView(); ; localView = null)
        {
          if (localView != null)
          {
            ParcelableSparseArray localParcelableSparseArray = new ParcelableSparseArray();
            localView.saveHierarchyState(localParcelableSparseArray);
            localSparseArray.put(localj.getItemId(), localParcelableSparseArray);
          }
          j++;
          break;
        }
      }
      localBundle.putSparseParcelableArray("android:menu:action_views", localSparseArray);
      return localBundle;
    }

    public int getItemCount()
    {
      return this.b.size();
    }

    public long getItemId(int paramInt)
    {
      return paramInt;
    }

    public int getItemViewType(int paramInt)
    {
      f.d locald = (f.d)this.b.get(paramInt);
      if ((locald instanceof f.e))
        return 2;
      if ((locald instanceof f.c))
        return 3;
      if ((locald instanceof f.f))
      {
        if (((f.f)locald).a().hasSubMenu())
          return 1;
        return 0;
      }
      throw new RuntimeException("Unknown item type.");
    }
  }

  private static class c
    implements f.d
  {
  }

  private static abstract interface d
  {
  }

  private static class e
    implements f.d
  {
    private final int a;
    private final int b;

    public e(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }

    public int a()
    {
      return this.a;
    }

    public int b()
    {
      return this.b;
    }
  }

  private static class f
    implements f.d
  {
    boolean a;
    private final j b;

    f(j paramj)
    {
      this.b = paramj;
    }

    public j a()
    {
      return this.b;
    }
  }

  private static class g extends f.j
  {
    public g(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
    {
      super();
      this.itemView.setOnClickListener(paramOnClickListener);
    }
  }

  private static class h extends f.j
  {
    public h(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      super();
    }
  }

  private static class i extends f.j
  {
    public i(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      super();
    }
  }

  private static abstract class j extends RecyclerView.ViewHolder
  {
    public j(View paramView)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.internal.f
 * JD-Core Version:    0.6.2
 */