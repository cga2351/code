package com.viber.voip.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

public class WrapContentAwareLinearLayoutManager extends LinearLayoutManager
{
  private Rect a;

  public WrapContentAwareLinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
    a();
  }

  public WrapContentAwareLinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a();
  }

  private void a()
  {
    this.a = new Rect();
  }

  private void a(View paramView, RecyclerView.LayoutParams paramLayoutParams, int paramInt1, int paramInt2)
  {
    int i = getPaddingLeft() + getPaddingRight();
    int j = getPaddingTop() + getPaddingBottom();
    int k = paramLayoutParams.leftMargin + paramLayoutParams.rightMargin;
    int m = paramLayoutParams.topMargin + paramLayoutParams.bottomMargin;
    int n = getRightDecorationWidth(paramView) + getLeftDecorationWidth(paramView);
    int i1 = getTopDecorationHeight(paramView) + getBottomDecorationHeight(paramView);
    paramView.measure(getChildMeasureSpec(paramInt1, n + (i + k), paramLayoutParams.width, canScrollHorizontally()), getChildMeasureSpec(paramInt2, i1 + (j + m), paramLayoutParams.height, canScrollVertically()));
  }

  public void onMeasure(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    int n;
    int i1;
    if (i == 1073741824)
    {
      n = 1;
      if (j != 1073741824)
        break label93;
      i1 = 1;
      label46: if (getOrientation() != 1)
        break label99;
    }
    label93: label99: for (int i2 = 1; ; i2 = 0)
    {
      if (((n == 0) || (i2 == 0)) && ((i1 == 0) || (i2 != 0)))
        break label105;
      super.onMeasure(paramRecycler, paramState, paramInt1, paramInt2);
      return;
      n = 0;
      break;
      i1 = 0;
      break label46;
    }
    label105: int i3 = 0;
    int i4 = 0;
    int i5 = getChildCount();
    int i6;
    int i7;
    int i8;
    int i9;
    int i10;
    label140: Object localObject;
    label160: RecyclerView.LayoutParams localLayoutParams;
    label186: int i16;
    int i18;
    int i17;
    int i11;
    label264: int i12;
    if (i5 == 0)
    {
      i6 = paramState.getItemCount();
      i7 = 0;
      i8 = 0;
      i9 = 0;
      i10 = 0;
      if (i10 >= i6)
        break label594;
      if (i7 == 0)
        break label366;
      localObject = getChildAt(i10);
      localLayoutParams = (RecyclerView.LayoutParams)((View)localObject).getLayoutParams();
      if (i2 == 0)
        break label391;
      a((View)localObject, localLayoutParams, k, 0);
      if (i2 == 0)
        break label405;
      i3 = Math.max(i3, getDecoratedMeasuredWidth((View)localObject) + localLayoutParams.leftMargin + localLayoutParams.rightMargin);
      if (i7 != 0)
        break label575;
      int i20 = i9 + (getDecoratedMeasuredHeight((View)localObject) + localLayoutParams.topMargin + localLayoutParams.bottomMargin);
      i16 = i3;
      i18 = i8;
      int i21 = i4;
      i17 = i20;
      i11 = i21;
      if (i7 != 0)
        break label477;
      if ((i2 != 0) && (i17 >= m))
        break label568;
      if ((i2 != 0) || (i18 < k))
        break label477;
      i12 = i16;
    }
    while (true)
    {
      int i13;
      label306: int i14;
      if (n != 0)
      {
        i13 = k;
        if (i1 == 0)
          break label530;
        i14 = m;
        label315: if (i != -2147483648)
          break label561;
      }
      label391: label405: label561: for (int i15 = Math.min(k, i13); ; i15 = i13)
      {
        if (j == -2147483648)
          i14 = Math.min(m, i14);
        setMeasuredDimension(i15, i14);
        return;
        i6 = i5;
        i7 = 1;
        break;
        label366: View localView = paramRecycler.getViewForPosition(i10);
        calculateItemDecorationsForChild(localView, this.a);
        localObject = localView;
        break label160;
        a((View)localObject, localLayoutParams, 0, m);
        break label186;
        i4 = Math.max(i4, getDecoratedMeasuredHeight((View)localObject) + localLayoutParams.topMargin + localLayoutParams.bottomMargin);
        if (i7 != 0)
          break label575;
        int i19 = i8 + (getDecoratedMeasuredWidth((View)localObject) + localLayoutParams.leftMargin + localLayoutParams.rightMargin);
        i16 = i3;
        i18 = i19;
        i11 = i4;
        i17 = i9;
        break label264;
        label477: i10++;
        i8 = i18;
        i9 = i17;
        i3 = i16;
        i4 = i11;
        break label140;
        if (i12 == 0)
        {
          i13 = getMinimumWidth();
          break label306;
        }
        i13 = i12 + (getPaddingLeft() + getPaddingRight());
        break label306;
        if (i11 == 0)
        {
          i14 = getMinimumHeight();
          break label315;
        }
        i14 = i11 + (getPaddingBottom() + getPaddingTop());
        break label315;
      }
      label530: label568: i12 = i16;
      continue;
      label575: i11 = i4;
      i16 = i3;
      i17 = i9;
      i18 = i8;
      break label264;
      label594: i11 = i4;
      i12 = i3;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.WrapContentAwareLinearLayoutManager
 * JD-Core Version:    0.6.2
 */