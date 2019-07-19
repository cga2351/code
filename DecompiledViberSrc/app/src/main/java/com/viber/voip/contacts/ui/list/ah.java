package com.viber.voip.contacts.ui.list;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.viber.voip.R.dimen;

class ah extends RecyclerView.ItemDecoration
{
  private a a;
  private int b;
  private int c;

  ah(Context paramContext, a parama)
  {
    this.a = parama;
    Resources localResources = paramContext.getResources();
    this.b = localResources.getDimensionPixelOffset(R.dimen.participants_list_divider_vertical_padding);
    this.c = localResources.getDimensionPixelOffset(R.dimen.participants_list_loadmore_vertical_padding);
  }

  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    if (i == -1)
      return;
    if (this.a.c(i));
    for (int j = 0 + this.b; ; j = 0)
    {
      if (this.a.d(i));
      for (int k = 0 + this.b; ; k = 0)
      {
        if (this.a.e(i))
          k += this.c;
        paramRect.set(0, j, 0, k);
        return;
      }
    }
  }

  public static abstract interface a
  {
    public abstract boolean c(int paramInt);

    public abstract boolean d(int paramInt);

    public abstract boolean e(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.ah
 * JD-Core Version:    0.6.2
 */