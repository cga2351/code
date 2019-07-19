package com.my.target;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import android.view.View.MeasureSpec;

final class dj extends LinearLayoutManager
{
  private final int a;
  private int b;
  private a c;
  private int d;
  private int e;
  private int f;
  private int g;

  dj(Context paramContext)
  {
    super(paramContext, 0, false);
    this.a = bj.a(paramContext).c(4);
  }

  public final void a(int paramInt)
  {
    this.b = paramInt;
  }

  public final void a(a parama)
  {
    this.c = parama;
  }

  public final void measureChildWithMargins(View paramView, int paramInt1, int paramInt2)
  {
    int i = getHeight();
    int j = getWidth();
    float f1;
    if ((i != this.g) || (j != this.f) || (this.d <= 0) || (this.e <= 0))
    {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), -2147483648), View.MeasureSpec.makeMeasureSpec(getHeight(), -2147483648));
      f1 = getWidth() / paramView.getMeasuredWidth();
      if (f1 <= 1.0F)
        break label239;
    }
    label239: for (this.d = ((int)(j / (0.5D + Math.floor(f1)))); ; this.d = ((int)(j / 1.5F)))
    {
      this.e = i;
      this.f = j;
      this.g = i;
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      if (paramView != getChildAt(0))
        localLayoutParams.leftMargin = bj.a(this.b / 2, paramView.getContext());
      if (paramView != getChildAt(getChildCount()))
        localLayoutParams.rightMargin = bj.a(this.b / 2, paramView.getContext());
      paramView.measure(getChildMeasureSpec(j, getWidthMode(), 0, this.d, canScrollHorizontally()), getChildMeasureSpec(i, getHeightMode(), this.a, i - 2 * this.a, canScrollVertically()));
      return;
    }
  }

  public final void onLayoutCompleted(RecyclerView.State paramState)
  {
    super.onLayoutCompleted(paramState);
    if (this.c != null)
      this.c.a();
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.dj
 * JD-Core Version:    0.6.2
 */