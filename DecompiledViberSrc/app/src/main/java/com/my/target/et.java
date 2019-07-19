package com.my.target;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

public final class et extends LinearLayoutManager
{
  private final int a;
  private int b;
  private int c;

  public final void measureChildWithMargins(View paramView, int paramInt1, int paramInt2)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = getWidth();
    int j = getHeight();
    if ((j == 0) || (i == 0) || (this.c == 0) || (this.b == 0))
      return;
    float f;
    int k;
    int m;
    int n;
    int i1;
    if (i < j)
    {
      f = 0.125F;
      k = getPaddingRight();
      m = getPaddingLeft();
      if (i / j <= (this.b + 2 * this.a) / this.c)
        break label274;
      n = (int)(j * this.b / this.c) - 2 * this.a;
      i1 = (int)(i - ((i + n) / 2 + f * i)) / 2;
      label146: if (getItemViewType(paramView) != 1)
        break label299;
      localLayoutParams.leftMargin = ((int)((i - m - k - n) / 2.0F));
      localLayoutParams.rightMargin = i1;
    }
    while (true)
    {
      paramView.measure(getChildMeasureSpec(i, getWidthMode(), paramInt1 + (m + k + localLayoutParams.leftMargin + localLayoutParams.rightMargin), n, canScrollHorizontally()), getChildMeasureSpec(getHeight(), getHeightMode(), paramInt2 + (getPaddingTop() + getPaddingBottom() + localLayoutParams.topMargin + localLayoutParams.bottomMargin), localLayoutParams.height, canScrollVertically()));
      return;
      f = 0.05F;
      break;
      label274: n = (int)(i * (1.0F - f * 2.0F)) - k - m;
      i1 = 0;
      break label146;
      label299: if (getItemViewType(paramView) == 2)
      {
        localLayoutParams.rightMargin = ((int)((i - m - k - n) / 2.0F));
        localLayoutParams.leftMargin = i1;
      }
      else
      {
        localLayoutParams.leftMargin = i1;
        localLayoutParams.rightMargin = i1;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.et
 * JD-Core Version:    0.6.2
 */