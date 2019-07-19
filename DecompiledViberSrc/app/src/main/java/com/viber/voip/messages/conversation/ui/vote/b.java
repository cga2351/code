package com.viber.voip.messages.conversation.ui.vote;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;

class b extends ItemTouchHelper.Callback
{
  private final a a;

  b(a parama)
  {
    this.a = parama;
  }

  public int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    if (paramViewHolder.getItemViewType() == 0)
      return makeFlag(2, 3);
    return makeFlag(0, 0);
  }

  public boolean onMove(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    return this.a.a(paramViewHolder1.getAdapterPosition(), paramViewHolder2.getAdapterPosition());
  }

  public void onSwiped(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
  }

  public static abstract interface a
  {
    public abstract boolean a(int paramInt1, int paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.vote.b
 * JD-Core Version:    0.6.2
 */