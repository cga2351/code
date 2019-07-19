package com.viber.voip.ui.h;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class c extends RecyclerView.ItemDecoration
{
  private final g a;

  public c(g paramg)
  {
    this.a = paramg;
  }

  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    if (i == -1);
    Pair localPair1;
    Pair localPair2;
    do
    {
      return;
      localPair1 = this.a.a(i);
      localPair2 = this.a.a(localPair1.first);
    }
    while (!((b)localPair2.first).a());
    ((b)localPair2.first).a(paramRect, ((Integer)localPair1.second).intValue());
  }

  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildCount();
    int j = 0;
    if (j < i)
    {
      View localView = paramRecyclerView.getChildAt(j);
      int k = paramRecyclerView.getChildAdapterPosition(localView);
      if (k == -1);
      while (true)
      {
        j++;
        break;
        Pair localPair1 = this.a.a(k);
        Pair localPair2 = this.a.a(localPair1.first);
        if (((b)localPair2.first).a())
          ((b)localPair2.first).a(paramCanvas, paramRecyclerView, localView, ((Integer)localPair1.second).intValue());
      }
    }
  }

  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    View localView = paramRecyclerView.getChildAt(0);
    if (localView == null);
    Pair localPair1;
    Pair localPair2;
    do
    {
      int i;
      do
      {
        return;
        i = paramRecyclerView.getChildAdapterPosition(localView);
      }
      while (i == -1);
      localPair1 = this.a.a(i);
      localPair2 = this.a.a(localPair1.first);
    }
    while (!((b)localPair2.first).a());
    ((b)localPair2.first).a(paramCanvas, paramRecyclerView, ((Integer)localPair1.second).intValue());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.h.c
 * JD-Core Version:    0.6.2
 */