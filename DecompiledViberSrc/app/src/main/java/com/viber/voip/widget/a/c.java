package com.viber.voip.widget.a;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class c extends RecyclerView.ItemDecoration
{
  private int a;
  private boolean b;

  public c(int paramInt)
  {
    this(paramInt, false);
  }

  public c(int paramInt, boolean paramBoolean)
  {
    this.a = paramInt;
    this.b = paramBoolean;
  }

  protected boolean a(int paramInt, RecyclerView.State paramState)
  {
    return paramInt > 0;
  }

  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if (a(paramRecyclerView.getChildLayoutPosition(paramView), paramState))
    {
      if (this.b)
        paramRect.set(0, this.a, 0, 0);
    }
    else
      return;
    paramRect.set(this.a, 0, 0, 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.a.c
 * JD-Core Version:    0.6.2
 */