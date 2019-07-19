package com.appboy.ui.contentcards.recycler;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;

public class SimpleItemTouchHelperCallback extends ItemTouchHelper.Callback
{
  private final ItemTouchHelperAdapter mAdapter;

  public SimpleItemTouchHelperCallback(ItemTouchHelperAdapter paramItemTouchHelperAdapter)
  {
    this.mAdapter = paramItemTouchHelperAdapter;
  }

  public int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.mAdapter.isItemDismissable(paramViewHolder.getAdapterPosition()));
    for (int i = 16; ; i = 0)
      return makeMovementFlags(0, i);
  }

  public boolean isItemViewSwipeEnabled()
  {
    return true;
  }

  public boolean isLongPressDragEnabled()
  {
    return false;
  }

  public boolean onMove(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    return false;
  }

  public void onSwiped(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    this.mAdapter.onItemDismiss(paramViewHolder.getAdapterPosition());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.contentcards.recycler.SimpleItemTouchHelperCallback
 * JD-Core Version:    0.6.2
 */