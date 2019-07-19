package com.viber.voip.widget.a;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class d extends RecyclerView.ItemDecoration
{
  private final int a;
  private final int b;
  private final int c;

  public d(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt2;
    this.b = paramInt3;
    this.c = paramInt1;
  }

  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildLayoutPosition(paramView);
    if (this.c == 0)
    {
      if (i >= this.b);
      for (int n = this.a; ; n = 0)
      {
        paramRect.left = n;
        int i1 = i % this.b;
        int i2 = 0;
        if (i1 != 0)
          i2 = this.a;
        paramRect.top = i2;
        return;
      }
    }
    if (i % this.b != 0);
    for (int j = this.a; ; j = 0)
    {
      paramRect.left = j;
      int k = this.b;
      int m = 0;
      if (i >= k)
        m = this.a;
      paramRect.top = m;
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.a.d
 * JD-Core Version:    0.6.2
 */