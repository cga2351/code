package com.viber.voip.widget.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

public class a extends RecyclerView.ItemDecoration
{
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getPaddingLeft();
    int j = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
    int k = paramRecyclerView.getChildCount();
    int m = 0;
    View localView;
    RecyclerView.ViewHolder localViewHolder;
    if (m < k)
    {
      localView = paramRecyclerView.getChildAt(m);
      localViewHolder = paramRecyclerView.getChildViewHolder(localView);
      if (!(localViewHolder instanceof a))
        break label170;
    }
    label170: for (Drawable localDrawable = ((a)localViewHolder).a(); ; localDrawable = null)
    {
      if (localDrawable == null);
      while (true)
      {
        m++;
        break;
        if ((localViewHolder.getLayoutPosition() != -1 + paramRecyclerView.getLayoutManager().getItemCount()) || (paramRecyclerView.getBottom() > localView.getBottom()))
        {
          RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
          int n = localView.getBottom() + localLayoutParams.bottomMargin + Math.round(localView.getTranslationY());
          localDrawable.setBounds(i, n, j, n + localDrawable.getIntrinsicHeight());
          localDrawable.draw(paramCanvas);
        }
      }
      return;
    }
  }

  public static abstract interface a
  {
    public abstract Drawable a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.a.a
 * JD-Core Version:    0.6.2
 */