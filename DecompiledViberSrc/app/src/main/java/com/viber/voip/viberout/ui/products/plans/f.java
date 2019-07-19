package com.viber.voip.viberout.ui.products.plans;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.viber.voip.R.dimen;

class f extends RecyclerView.ItemDecoration
{
  private final int a;
  private final int b;
  private final int c;

  public f(Resources paramResources)
  {
    this.b = paramResources.getDimensionPixelOffset(R.dimen.vo_plan_item_horizontal_offset);
    this.a = paramResources.getDimensionPixelOffset(R.dimen.vo_plan_item_vertical_offset);
    this.c = paramResources.getDimensionPixelOffset(R.dimen.vo_plan_between_item_horizontal_offset);
  }

  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = 1;
    int j;
    if (paramRecyclerView.getChildAdapterPosition(paramView) == 0)
    {
      j = i;
      if (paramRecyclerView.getChildAdapterPosition(paramView) != -1 + paramRecyclerView.getAdapter().getItemCount())
        break label84;
      label32: if (j == 0)
        break label90;
    }
    label84: label90: for (int k = this.b; ; k = this.c)
    {
      int m = this.a;
      int n = 0;
      if (i != 0)
        n = this.b;
      paramRect.set(k, m, n, this.a);
      return;
      j = 0;
      break;
      i = 0;
      break label32;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.plans.f
 * JD-Core Version:    0.6.2
 */