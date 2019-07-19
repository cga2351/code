package com.b.a.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public class a extends BaseAdapter
{
  private List<View> a = null;

  public a(List<View> paramList)
  {
    this.a = paramList;
  }

  protected View a(int paramInt, ViewGroup paramViewGroup)
  {
    throw new RuntimeException("You must override newView()!");
  }

  public boolean a(View paramView)
  {
    return this.a.contains(paramView);
  }

  public boolean areAllItemsEnabled()
  {
    return false;
  }

  public int getCount()
  {
    return this.a.size();
  }

  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = (View)this.a.get(paramInt);
    if (localView == null)
    {
      localView = a(paramInt, paramViewGroup);
      this.a.set(paramInt, localView);
    }
    return localView;
  }

  public int getViewTypeCount()
  {
    return getCount();
  }

  public boolean isEnabled(int paramInt)
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.b.a.b.a
 * JD-Core Version:    0.6.2
 */