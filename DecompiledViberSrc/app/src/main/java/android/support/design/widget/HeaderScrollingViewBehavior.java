package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.math.MathUtils;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import java.util.List;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View>
{
  private int overlayTop;
  final Rect tempRect1 = new Rect();
  final Rect tempRect2 = new Rect();
  private int verticalLayoutGap = 0;

  public HeaderScrollingViewBehavior()
  {
  }

  public HeaderScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private static int resolveGravity(int paramInt)
  {
    if (paramInt == 0)
      paramInt = 8388659;
    return paramInt;
  }

  abstract View findFirstDependency(List<View> paramList);

  final int getOverlapPixelsForOffset(View paramView)
  {
    if (this.overlayTop == 0)
      return 0;
    return MathUtils.clamp((int)(getOverlapRatioForOffset(paramView) * this.overlayTop), 0, this.overlayTop);
  }

  float getOverlapRatioForOffset(View paramView)
  {
    return 1.0F;
  }

  public final int getOverlayTop()
  {
    return this.overlayTop;
  }

  int getScrollRange(View paramView)
  {
    return paramView.getMeasuredHeight();
  }

  final int getVerticalLayoutGap()
  {
    return this.verticalLayoutGap;
  }

  protected void layoutChild(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    View localView = findFirstDependency(paramCoordinatorLayout.getDependencies(paramView));
    if (localView != null)
    {
      CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
      Rect localRect1 = this.tempRect1;
      localRect1.set(paramCoordinatorLayout.getPaddingLeft() + localLayoutParams.leftMargin, localView.getBottom() + localLayoutParams.topMargin, paramCoordinatorLayout.getWidth() - paramCoordinatorLayout.getPaddingRight() - localLayoutParams.rightMargin, paramCoordinatorLayout.getHeight() + localView.getBottom() - paramCoordinatorLayout.getPaddingBottom() - localLayoutParams.bottomMargin);
      WindowInsetsCompat localWindowInsetsCompat = paramCoordinatorLayout.getLastWindowInsets();
      if ((localWindowInsetsCompat != null) && (ViewCompat.getFitsSystemWindows(paramCoordinatorLayout)) && (!ViewCompat.getFitsSystemWindows(paramView)))
      {
        localRect1.left += localWindowInsetsCompat.getSystemWindowInsetLeft();
        localRect1.right -= localWindowInsetsCompat.getSystemWindowInsetRight();
      }
      Rect localRect2 = this.tempRect2;
      GravityCompat.apply(resolveGravity(localLayoutParams.gravity), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect1, localRect2, paramInt);
      int i = getOverlapPixelsForOffset(localView);
      paramView.layout(localRect2.left, localRect2.top - i, localRect2.right, localRect2.bottom - i);
      this.verticalLayoutGap = (localRect2.top - localView.getBottom());
      return;
    }
    super.layoutChild(paramCoordinatorLayout, paramView, paramInt);
    this.verticalLayoutGap = 0;
  }

  public boolean onMeasureChild(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramView.getLayoutParams().height;
    if ((i == -1) || (i == -2))
    {
      View localView = findFirstDependency(paramCoordinatorLayout.getDependencies(paramView));
      if (localView != null)
      {
        if ((ViewCompat.getFitsSystemWindows(localView)) && (!ViewCompat.getFitsSystemWindows(paramView)))
        {
          ViewCompat.setFitsSystemWindows(paramView, true);
          if (ViewCompat.getFitsSystemWindows(paramView))
          {
            paramView.requestLayout();
            return true;
          }
        }
        int j = View.MeasureSpec.getSize(paramInt3);
        if (j == 0)
          j = paramCoordinatorLayout.getHeight();
        int k = j - localView.getMeasuredHeight() + getScrollRange(localView);
        if (i == -1);
        for (int m = 1073741824; ; m = -2147483648)
        {
          paramCoordinatorLayout.onMeasureChild(paramView, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(k, m), paramInt4);
          return true;
        }
      }
    }
    return false;
  }

  public final void setOverlayTop(int paramInt)
  {
    this.overlayTop = paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.HeaderScrollingViewBehavior
 * JD-Core Version:    0.6.2
 */