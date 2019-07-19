package android.support.design.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class BaselineLayout extends ViewGroup
{
  private int a = -1;

  public BaselineLayout(Context paramContext)
  {
    super(paramContext, null, 0);
  }

  public BaselineLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }

  public BaselineLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public int getBaseline()
  {
    return this.a;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    int j = getPaddingLeft();
    int k = paramInt3 - paramInt1 - getPaddingRight() - j;
    int m = getPaddingTop();
    int n = 0;
    while (n < i)
    {
      View localView = getChildAt(n);
      if (localView.getVisibility() == 8)
      {
        n++;
      }
      else
      {
        int i1 = localView.getMeasuredWidth();
        int i2 = localView.getMeasuredHeight();
        int i3 = j + (k - i1) / 2;
        if ((this.a != -1) && (localView.getBaseline() != -1));
        for (int i4 = m + this.a - localView.getBaseline(); ; i4 = m)
        {
          localView.layout(i3, i4, i1 + i3, i2 + i4);
          break;
        }
      }
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    int j = 0;
    int k = 0;
    int m = -1;
    int n = 0;
    int i1 = 0;
    int i2 = -1;
    if (j < i)
    {
      View localView = getChildAt(j);
      int i10;
      int i6;
      int i7;
      if (localView.getVisibility() == 8)
      {
        i10 = k;
        i6 = m;
        i7 = i2;
      }
      int i5;
      for (int i8 = i10; ; i8 = i5)
      {
        j++;
        int i9 = i8;
        i2 = i7;
        m = i6;
        k = i9;
        break;
        measureChild(localView, paramInt1, paramInt2);
        int i4 = localView.getBaseline();
        if (i4 != -1)
        {
          m = Math.max(m, i4);
          i2 = Math.max(i2, localView.getMeasuredHeight() - i4);
        }
        i1 = Math.max(i1, localView.getMeasuredWidth());
        n = Math.max(n, localView.getMeasuredHeight());
        i5 = View.combineMeasuredStates(k, localView.getMeasuredState());
        i6 = m;
        i7 = i2;
      }
    }
    if (m != -1)
    {
      n = Math.max(n, m + Math.max(i2, getPaddingBottom()));
      this.a = m;
    }
    int i3 = Math.max(n, getSuggestedMinimumHeight());
    setMeasuredDimension(View.resolveSizeAndState(Math.max(i1, getSuggestedMinimumWidth()), paramInt1, k), View.resolveSizeAndState(i3, paramInt2, k << 16));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.internal.BaselineLayout
 * JD-Core Version:    0.6.2
 */