package com.viber.voip.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.view.View;

public class SmoothScrollingLinearLayoutManager extends LinearLayoutManager
{
  private int a;

  public SmoothScrollingLinearLayoutManager(Context paramContext, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    super(paramContext, paramInt1, paramBoolean);
    this.a = paramInt2;
  }

  public SmoothScrollingLinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
  {
    View localView = paramRecyclerView.getChildAt(0);
    if (localView == null)
    {
      super.smoothScrollToPosition(paramRecyclerView, paramState, paramInt);
      return;
    }
    if (getOrientation() == 1);
    for (int i = localView.getHeight(); ; i = localView.getWidth())
    {
      int j = Math.abs(i * (paramRecyclerView.getChildLayoutPosition(localView) - paramInt));
      if (j == 0)
        j = (int)Math.abs(localView.getY());
      a locala = new a(paramRecyclerView.getContext(), j, this.a);
      locala.setTargetPosition(paramInt);
      startSmoothScroll(locala);
      return;
    }
  }

  private class a extends LinearSmoothScroller
  {
    private final float b;
    private final float c;

    public a(Context paramInt1, int paramInt2, int arg4)
    {
      super();
      this.b = paramInt2;
      int i;
      this.c = i;
    }

    protected int calculateTimeForScrolling(int paramInt)
    {
      return (int)(paramInt / this.b * this.c);
    }

    public PointF computeScrollVectorForPosition(int paramInt)
    {
      return SmoothScrollingLinearLayoutManager.this.computeScrollVectorForPosition(paramInt);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.SmoothScrollingLinearLayoutManager
 * JD-Core Version:    0.6.2
 */