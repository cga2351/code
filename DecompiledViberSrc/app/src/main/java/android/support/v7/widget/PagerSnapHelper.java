package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;

public class PagerSnapHelper extends SnapHelper
{
  private static final int MAX_SCROLL_ON_FLING_DURATION = 100;
  private OrientationHelper mHorizontalHelper;
  private OrientationHelper mVerticalHelper;

  private int distanceToCenter(RecyclerView.LayoutManager paramLayoutManager, View paramView, OrientationHelper paramOrientationHelper)
  {
    int i = paramOrientationHelper.getDecoratedStart(paramView) + paramOrientationHelper.getDecoratedMeasurement(paramView) / 2;
    if (paramLayoutManager.getClipToPadding());
    for (int j = paramOrientationHelper.getStartAfterPadding() + paramOrientationHelper.getTotalSpace() / 2; ; j = paramOrientationHelper.getEnd() / 2)
      return i - j;
  }

  private View findCenterView(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper)
  {
    int i = paramLayoutManager.getChildCount();
    Object localObject1 = null;
    if (i == 0)
      return localObject1;
    int j;
    label35: int k;
    int m;
    label42: View localView;
    int n;
    if (paramLayoutManager.getClipToPadding())
    {
      j = paramOrientationHelper.getStartAfterPadding() + paramOrientationHelper.getTotalSpace() / 2;
      k = 2147483647;
      m = 0;
      if (m < i)
      {
        localView = paramLayoutManager.getChildAt(m);
        n = Math.abs(paramOrientationHelper.getDecoratedStart(localView) + paramOrientationHelper.getDecoratedMeasurement(localView) / 2 - j);
        if (n >= k)
          break label115;
      }
    }
    for (Object localObject2 = localView; ; localObject2 = localObject1)
    {
      m++;
      localObject1 = localObject2;
      k = n;
      break label42;
      break;
      j = paramOrientationHelper.getEnd() / 2;
      break label35;
      label115: n = k;
    }
  }

  private View findStartView(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper)
  {
    int i = paramLayoutManager.getChildCount();
    Object localObject1 = null;
    if (i == 0)
      return localObject1;
    int j = 2147483647;
    int k = 0;
    label22: View localView;
    int m;
    if (k < i)
    {
      localView = paramLayoutManager.getChildAt(k);
      m = paramOrientationHelper.getDecoratedStart(localView);
      if (m >= j)
        break label69;
    }
    for (Object localObject2 = localView; ; localObject2 = localObject1)
    {
      k++;
      localObject1 = localObject2;
      j = m;
      break label22;
      break;
      label69: m = j;
    }
  }

  private OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((this.mHorizontalHelper == null) || (this.mHorizontalHelper.mLayoutManager != paramLayoutManager))
      this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(paramLayoutManager);
    return this.mHorizontalHelper;
  }

  private OrientationHelper getVerticalHelper(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((this.mVerticalHelper == null) || (this.mVerticalHelper.mLayoutManager != paramLayoutManager))
      this.mVerticalHelper = OrientationHelper.createVerticalHelper(paramLayoutManager);
    return this.mVerticalHelper;
  }

  public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager paramLayoutManager, View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (paramLayoutManager.canScrollHorizontally())
      arrayOfInt[0] = distanceToCenter(paramLayoutManager, paramView, getHorizontalHelper(paramLayoutManager));
    while (paramLayoutManager.canScrollVertically())
    {
      arrayOfInt[1] = distanceToCenter(paramLayoutManager, paramView, getVerticalHelper(paramLayoutManager));
      return arrayOfInt;
      arrayOfInt[0] = 0;
    }
    arrayOfInt[1] = 0;
    return arrayOfInt;
  }

  protected LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (!(paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider))
      return null;
    return new LinearSmoothScroller(this.mRecyclerView.getContext())
    {
      protected float calculateSpeedPerPixel(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 100.0F / paramAnonymousDisplayMetrics.densityDpi;
      }

      protected int calculateTimeForScrolling(int paramAnonymousInt)
      {
        return Math.min(100, super.calculateTimeForScrolling(paramAnonymousInt));
      }

      protected void onTargetFound(View paramAnonymousView, RecyclerView.State paramAnonymousState, RecyclerView.SmoothScroller.Action paramAnonymousAction)
      {
        int[] arrayOfInt = PagerSnapHelper.this.calculateDistanceToFinalSnap(PagerSnapHelper.this.mRecyclerView.getLayoutManager(), paramAnonymousView);
        int i = arrayOfInt[0];
        int j = arrayOfInt[1];
        int k = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0)
          paramAnonymousAction.update(i, j, k, this.mDecelerateInterpolator);
      }
    };
  }

  public View findSnapView(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (paramLayoutManager.canScrollVertically())
      return findCenterView(paramLayoutManager, getVerticalHelper(paramLayoutManager));
    if (paramLayoutManager.canScrollHorizontally())
      return findCenterView(paramLayoutManager, getHorizontalHelper(paramLayoutManager));
    return null;
  }

  public int findTargetSnapPosition(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    int i = paramLayoutManager.getItemCount();
    if (i == 0);
    View localView;
    label32: int j;
    do
    {
      return -1;
      if (!paramLayoutManager.canScrollVertically())
        break;
      localView = findStartView(paramLayoutManager, getVerticalHelper(paramLayoutManager));
      if (localView == null)
        break label174;
      j = paramLayoutManager.getPosition(localView);
    }
    while (j == -1);
    int k;
    if (paramLayoutManager.canScrollHorizontally())
      if (paramInt1 > 0)
        k = 1;
    while (true)
    {
      boolean bool2 = paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider;
      int m = 0;
      if (bool2)
      {
        PointF localPointF = ((RecyclerView.SmoothScroller.ScrollVectorProvider)paramLayoutManager).computeScrollVectorForPosition(i - 1);
        m = 0;
        if (localPointF != null)
          if (localPointF.x >= 0.0F)
          {
            boolean bool3 = localPointF.y < 0.0F;
            m = 0;
            if (!bool3);
          }
          else
          {
            m = 1;
          }
      }
      if (m == 0)
        break label201;
      if (k == 0)
        break label198;
      return j - 1;
      boolean bool1 = paramLayoutManager.canScrollHorizontally();
      localView = null;
      if (!bool1)
        break label32;
      localView = findStartView(paramLayoutManager, getHorizontalHelper(paramLayoutManager));
      break label32;
      label174: break;
      k = 0;
      continue;
      if (paramInt2 > 0)
        k = 1;
      else
        k = 0;
    }
    label198: return j;
    label201: if (k != 0)
      return j + 1;
    return j;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.PagerSnapHelper
 * JD-Core Version:    0.6.2
 */