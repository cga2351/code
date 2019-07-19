package com.viber.voip.util.j.a;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewParent;

public final class a
{
  public static RecyclerView a(View paramView)
  {
    if (paramView == null)
      return null;
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent instanceof RecyclerView))
      return (RecyclerView)localViewParent;
    if ((localViewParent instanceof View))
      return a((View)localViewParent);
    return null;
  }

  public static void a(RecyclerView paramRecyclerView, int paramInt)
  {
    RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
    if ((localLayoutManager instanceof LinearLayoutManager))
    {
      ((LinearLayoutManager)localLayoutManager).scrollToPositionWithOffset(paramInt, 0);
      return;
    }
    paramRecyclerView.scrollToPosition(paramInt);
  }

  public static RecyclerView.ViewHolder b(View paramView)
  {
    RecyclerView localRecyclerView = a(paramView);
    if (localRecyclerView == null)
      return null;
    return localRecyclerView.findContainingViewHolder(paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.j.a.a
 * JD-Core Version:    0.6.2
 */