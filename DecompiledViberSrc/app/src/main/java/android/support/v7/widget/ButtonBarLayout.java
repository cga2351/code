package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class ButtonBarLayout extends LinearLayout
{
  private static final int PEEK_BUTTON_DP = 16;
  private boolean mAllowStacking;
  private int mLastWidthSize = -1;
  private int mMinimumHeight = 0;

  public ButtonBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ButtonBarLayout);
    this.mAllowStacking = localTypedArray.getBoolean(R.styleable.ButtonBarLayout_allowStacking, true);
    localTypedArray.recycle();
  }

  private int getNextVisibleChildIndex(int paramInt)
  {
    int i = getChildCount();
    for (int j = paramInt; j < i; j++)
      if (getChildAt(j).getVisibility() == 0)
        return j;
    return -1;
  }

  private boolean isStacked()
  {
    return getOrientation() == 1;
  }

  private void setStacked(boolean paramBoolean)
  {
    int i;
    int j;
    label17: View localView;
    if (paramBoolean)
    {
      i = 1;
      setOrientation(i);
      if (!paramBoolean)
        break label86;
      j = 5;
      setGravity(j);
      localView = findViewById(R.id.spacer);
      if (localView != null)
        if (!paramBoolean)
          break label92;
    }
    label86: label92: for (int m = 8; ; m = 4)
    {
      localView.setVisibility(m);
      for (int k = -2 + getChildCount(); k >= 0; k--)
        bringChildToFront(getChildAt(k));
      i = 0;
      break;
      j = 80;
      break label17;
    }
  }

  public int getMinimumHeight()
  {
    return Math.max(this.mMinimumHeight, super.getMinimumHeight());
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    if (this.mAllowStacking)
    {
      if ((i > this.mLastWidthSize) && (isStacked()))
        setStacked(false);
      this.mLastWidthSize = i;
    }
    int j;
    int k;
    int i2;
    label100: int n;
    if ((!isStacked()) && (View.MeasureSpec.getMode(paramInt1) == 1073741824))
    {
      j = View.MeasureSpec.makeMeasureSpec(i, -2147483648);
      k = 1;
      super.onMeasure(j, paramInt2);
      if ((this.mAllowStacking) && (!isStacked()))
      {
        if ((0xFF000000 & getMeasuredWidthAndState()) != 16777216)
          break label256;
        i2 = 1;
        if (i2 != 0)
        {
          setStacked(true);
          k = 1;
        }
      }
      if (k != 0)
        super.onMeasure(paramInt1, paramInt2);
      int m = getNextVisibleChildIndex(0);
      if (m < 0)
        break label274;
      View localView = getChildAt(m);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      n = 0 + (getPaddingTop() + localView.getMeasuredHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin);
      if (!isStacked())
        break label262;
      int i1 = getNextVisibleChildIndex(m + 1);
      if (i1 >= 0)
        n += getChildAt(i1).getPaddingTop() + (int)(16.0F * getResources().getDisplayMetrics().density);
    }
    while (true)
    {
      if (ViewCompat.getMinimumHeight(this) != n)
        setMinimumHeight(n);
      return;
      j = paramInt1;
      k = 0;
      break;
      label256: i2 = 0;
      break label100;
      label262: n += getPaddingBottom();
      continue;
      label274: n = 0;
    }
  }

  public void setAllowStacking(boolean paramBoolean)
  {
    if (this.mAllowStacking != paramBoolean)
    {
      this.mAllowStacking = paramBoolean;
      if ((!this.mAllowStacking) && (getOrientation() == 1))
        setStacked(false);
      requestLayout();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ButtonBarLayout
 * JD-Core Version:    0.6.2
 */