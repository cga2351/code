package com.viber.voip.gallery.selection;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

class m extends RecyclerView.ItemDecoration
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private boolean f;

  m(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
  }

  void a(boolean paramBoolean)
  {
    if (this.f != paramBoolean)
      this.f = paramBoolean;
  }

  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = 1;
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    int j = paramRecyclerView.getChildLayoutPosition(paramView);
    if (j == -1)
      return;
    int k = paramState.getItemCount();
    int m;
    label59: int n;
    label73: label86: int i1;
    if (j < this.a)
    {
      m = i;
      if (m == 0)
        break label181;
      paramRect.top = this.c;
      if (j % this.a != 0)
        break label192;
      n = i;
      if (n == 0)
        break label198;
      paramRect.left = this.b;
      if (j % this.a != -1 + this.a)
        break label209;
      i1 = i;
      label106: if (i1 == 0)
        break label215;
      paramRect.right = this.b;
      label119: int i2 = k % this.a;
      if (i2 == 0)
        i2 = this.a;
      if (j < k - i2)
        break label226;
    }
    while (true)
      if (i != 0)
      {
        if (this.f)
        {
          paramRect.bottom = (this.b + this.e);
          return;
          m = 0;
          break;
          label181: paramRect.top = this.d;
          break label59;
          label192: n = 0;
          break label73;
          label198: paramRect.left = this.d;
          break label86;
          label209: i1 = 0;
          break label106;
          label215: paramRect.right = this.d;
          break label119;
          label226: i = 0;
          continue;
        }
        paramRect.bottom = this.b;
        return;
      }
    paramRect.bottom = this.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.selection.m
 * JD-Core Version:    0.6.2
 */