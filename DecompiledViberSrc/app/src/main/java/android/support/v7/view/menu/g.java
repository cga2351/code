package android.support.v7.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class g extends BaseAdapter
{
  h a;
  private int b = -1;
  private boolean c;
  private final boolean d;
  private final LayoutInflater e;
  private final int f;

  public g(h paramh, LayoutInflater paramLayoutInflater, boolean paramBoolean, int paramInt)
  {
    this.d = paramBoolean;
    this.e = paramLayoutInflater;
    this.a = paramh;
    this.f = paramInt;
    b();
  }

  public h a()
  {
    return this.a;
  }

  public j a(int paramInt)
  {
    if (this.d);
    for (ArrayList localArrayList = this.a.m(); ; localArrayList = this.a.j())
    {
      if ((this.b >= 0) && (paramInt >= this.b))
        paramInt++;
      return (j)localArrayList.get(paramInt);
    }
  }

  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  void b()
  {
    j localj = this.a.s();
    if (localj != null)
    {
      ArrayList localArrayList = this.a.m();
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
    if (this.d);
    for (ArrayList localArrayList = this.a.m(); this.b < 0; localArrayList = this.a.j())
      return localArrayList.size();
    return -1 + localArrayList.size();
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null);
    for (View localView = this.e.inflate(this.f, paramViewGroup, false); ; localView = paramView)
    {
      int i = a(paramInt).getGroupId();
      int j;
      ListMenuItemView localListMenuItemView;
      if (paramInt - 1 >= 0)
      {
        j = a(paramInt - 1).getGroupId();
        localListMenuItemView = (ListMenuItemView)localView;
        if ((!this.a.b()) || (i == j))
          break label127;
      }
      label127: for (boolean bool = true; ; bool = false)
      {
        localListMenuItemView.setGroupDividerEnabled(bool);
        p.a locala = (p.a)localView;
        if (this.c)
          ((ListMenuItemView)localView).setForceShowIcon(true);
        locala.a(a(paramInt), 0);
        return localView;
        j = i;
        break;
      }
    }
  }

  public void notifyDataSetChanged()
  {
    b();
    super.notifyDataSetChanged();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.view.menu.g
 * JD-Core Version:    0.6.2
 */