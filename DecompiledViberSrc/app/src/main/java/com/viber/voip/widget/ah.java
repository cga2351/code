package com.viber.voip.widget;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper.SimpleCallback;
import android.view.View;

public abstract class ah extends ItemTouchHelper.SimpleCallback
{
  public ah()
  {
    super(0, 1);
  }

  public void clearView(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder.itemView.setAlpha(1.0F);
    paramViewHolder.itemView.setTranslationY(0.0F);
  }

  public void onChildDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1)
    {
      float f = 1.0F + paramFloat2 / paramViewHolder.itemView.getWidth();
      paramViewHolder.itemView.setAlpha(f);
      paramViewHolder.itemView.setTranslationY(paramFloat2);
      return;
    }
    super.onChildDraw(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, paramBoolean);
  }

  public boolean onMove(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.ah
 * JD-Core Version:    0.6.2
 */