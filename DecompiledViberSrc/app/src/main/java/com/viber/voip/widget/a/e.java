package com.viber.voip.widget.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseBooleanArray;
import android.view.View;

public class e extends RecyclerView.ItemDecoration
{
  private final Drawable a;
  private final SparseBooleanArray b = new SparseBooleanArray();

  public e(Drawable paramDrawable)
  {
    this.a = paramDrawable;
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    this.b.put(paramInt, paramBoolean);
  }

  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getPaddingLeft();
    int j = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
    int k = paramRecyclerView.getChildCount();
    int m = 0;
    if (m < k)
    {
      View localView = paramRecyclerView.getChildAt(m);
      RecyclerView.ViewHolder localViewHolder = paramRecyclerView.getChildViewHolder(localView);
      if (this.b.get(localViewHolder.getItemViewType()));
      while (true)
      {
        m++;
        break;
        if ((localViewHolder.getLayoutPosition() != -1 + paramRecyclerView.getLayoutManager().getItemCount()) || (paramRecyclerView.getBottom() > localView.getBottom()))
        {
          RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
          int n = localView.getBottom() + localLayoutParams.bottomMargin + Math.round(localView.getTranslationY());
          int i1 = n + this.a.getIntrinsicHeight();
          this.a.setBounds(i, n, j, i1);
          this.a.draw(paramCanvas);
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.a.e
 * JD-Core Version:    0.6.2
 */