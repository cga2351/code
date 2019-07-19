package android.support.v7.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class b
  implements o
{
  private o.a mCallback;
  protected Context mContext;
  private int mId;
  protected LayoutInflater mInflater;
  private int mItemLayoutRes;
  protected h mMenu;
  private int mMenuLayoutRes;
  protected p mMenuView;
  protected Context mSystemContext;
  protected LayoutInflater mSystemInflater;

  public b(Context paramContext, int paramInt1, int paramInt2)
  {
    this.mSystemContext = paramContext;
    this.mSystemInflater = LayoutInflater.from(paramContext);
    this.mMenuLayoutRes = paramInt1;
    this.mItemLayoutRes = paramInt2;
  }

  protected void addItemView(View paramView, int paramInt)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if (localViewGroup != null)
      localViewGroup.removeView(paramView);
    ((ViewGroup)this.mMenuView).addView(paramView, paramInt);
  }

  public abstract void bindItemView(j paramj, p.a parama);

  public boolean collapseItemActionView(h paramh, j paramj)
  {
    return false;
  }

  public p.a createItemView(ViewGroup paramViewGroup)
  {
    return (p.a)this.mSystemInflater.inflate(this.mItemLayoutRes, paramViewGroup, false);
  }

  public boolean expandItemActionView(h paramh, j paramj)
  {
    return false;
  }

  protected boolean filterLeftoverView(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.removeViewAt(paramInt);
    return true;
  }

  public boolean flagActionItems()
  {
    return false;
  }

  public o.a getCallback()
  {
    return this.mCallback;
  }

  public int getId()
  {
    return this.mId;
  }

  public View getItemView(j paramj, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof p.a));
    for (p.a locala = (p.a)paramView; ; locala = createItemView(paramViewGroup))
    {
      bindItemView(paramj, locala);
      return (View)locala;
    }
  }

  public p getMenuView(ViewGroup paramViewGroup)
  {
    if (this.mMenuView == null)
    {
      this.mMenuView = ((p)this.mSystemInflater.inflate(this.mMenuLayoutRes, paramViewGroup, false));
      this.mMenuView.initialize(this.mMenu);
      updateMenuView(true);
    }
    return this.mMenuView;
  }

  public void initForMenu(Context paramContext, h paramh)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(this.mContext);
    this.mMenu = paramh;
  }

  public void onCloseMenu(h paramh, boolean paramBoolean)
  {
    if (this.mCallback != null)
      this.mCallback.onCloseMenu(paramh, paramBoolean);
  }

  public boolean onSubMenuSelected(u paramu)
  {
    if (this.mCallback != null)
      return this.mCallback.onOpenSubMenu(paramu);
    return false;
  }

  public void setCallback(o.a parama)
  {
    this.mCallback = parama;
  }

  public void setId(int paramInt)
  {
    this.mId = paramInt;
  }

  public boolean shouldIncludeItem(int paramInt, j paramj)
  {
    return true;
  }

  public void updateMenuView(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)this.mMenuView;
    if (localViewGroup == null);
    label190: label199: 
    while (true)
    {
      return;
      int i;
      int m;
      if (this.mMenu != null)
      {
        this.mMenu.k();
        ArrayList localArrayList = this.mMenu.j();
        int j = localArrayList.size();
        int k = 0;
        i = 0;
        if (k < j)
        {
          j localj1 = (j)localArrayList.get(k);
          if (!shouldIncludeItem(i, localj1))
            break label190;
          View localView1 = localViewGroup.getChildAt(i);
          if ((localView1 instanceof p.a));
          for (j localj2 = ((p.a)localView1).getItemData(); ; localj2 = null)
          {
            View localView2 = getItemView(localj1, localView1, localViewGroup);
            if (localj1 != localj2)
            {
              localView2.setPressed(false);
              localView2.jumpDrawablesToCurrentState();
            }
            if (localView2 != localView1)
              addItemView(localView2, i);
            m = i + 1;
            k++;
            i = m;
            break;
          }
        }
      }
      while (true)
      {
        if (i >= localViewGroup.getChildCount())
          break label199;
        if (!filterLeftoverView(localViewGroup, i))
        {
          i++;
          continue;
          m = i;
          break;
          i = 0;
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.view.menu.b
 * JD-Core Version:    0.6.2
 */