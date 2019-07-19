package com.viber.voip.widget.a;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class b extends RecyclerView.ItemDecoration
{
  private final int a;
  private final int b;
  private final int c;

  public b(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt1, paramInt2);
  }

  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }

  private boolean a(int paramInt)
  {
    return paramInt == 0;
  }

  private boolean a(int paramInt1, int paramInt2)
  {
    return paramInt1 == paramInt2 - 1;
  }

  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildLayoutPosition(paramView);
    int j = paramRecyclerView.getAdapter().getItemCount();
    boolean bool1 = a(i);
    boolean bool2 = a(i, j);
    if ((!bool1) && (!bool2))
      return;
    if (this.c == 1)
    {
      if (bool1)
      {
        paramRect.set(0, this.a, 0, 0);
        return;
      }
      paramRect.set(0, 0, 0, this.b);
      return;
    }
    if (bool1)
    {
      paramRect.set(this.a, 0, 0, 0);
      return;
    }
    paramRect.set(0, 0, this.b, 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.a.b
 * JD-Core Version:    0.6.2
 */