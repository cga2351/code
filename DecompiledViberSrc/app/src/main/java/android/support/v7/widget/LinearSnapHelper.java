package android.support.v7.widget;

import android.graphics.PointF;
import android.view.View;

public class LinearSnapHelper extends SnapHelper
{
  private static final float INVALID_DISTANCE = 1.0F;
  private OrientationHelper mHorizontalHelper;
  private OrientationHelper mVerticalHelper;

  private float computeDistancePerChild(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper)
  {
    Object localObject1 = null;
    int i = 2147483647;
    int j = paramLayoutManager.getChildCount();
    if (j == 0)
      return 1.0F;
    int k = 0;
    Object localObject2 = null;
    int m = -2147483648;
    View localView;
    int i2;
    int i3;
    Object localObject3;
    Object localObject4;
    if (k < j)
    {
      localView = paramLayoutManager.getChildAt(k);
      i2 = paramLayoutManager.getPosition(localView);
      if (i2 == -1)
      {
        i3 = i;
        localObject3 = localObject1;
        localObject4 = localObject2;
      }
    }
    while (true)
    {
      k++;
      localObject2 = localObject4;
      localObject1 = localObject3;
      i = i3;
      break;
      if (i2 < i)
      {
        i = i2;
        localObject2 = localView;
      }
      if (i2 > m)
      {
        m = i2;
        localObject4 = localObject2;
        i3 = i;
        localObject3 = localView;
        continue;
        if ((localObject2 == null) || (localObject1 == null))
          return 1.0F;
        int n = Math.min(paramOrientationHelper.getDecoratedStart(localObject2), paramOrientationHelper.getDecoratedStart(localObject1));
        int i1 = Math.max(paramOrientationHelper.getDecoratedEnd(localObject2), paramOrientationHelper.getDecoratedEnd(localObject1)) - n;
        if (i1 == 0)
          return 1.0F;
        return 1.0F * i1 / (1 + (m - i));
      }
      else
      {
        i3 = i;
        localObject3 = localObject1;
        localObject4 = localObject2;
      }
    }
  }

  private int distanceToCenter(RecyclerView.LayoutManager paramLayoutManager, View paramView, OrientationHelper paramOrientationHelper)
  {
    int i = paramOrientationHelper.getDecoratedStart(paramView) + paramOrientationHelper.getDecoratedMeasurement(paramView) / 2;
    if (paramLayoutManager.getClipToPadding());
    for (int j = paramOrientationHelper.getStartAfterPadding() + paramOrientationHelper.getTotalSpace() / 2; ; j = paramOrientationHelper.getEnd() / 2)
      return i - j;
  }

  private int estimateNextPositionDiffForFling(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = calculateScrollDistance(paramInt1, paramInt2);
    float f = computeDistancePerChild(paramLayoutManager, paramOrientationHelper);
    if (f <= 0.0F)
      return 0;
    if (Math.abs(arrayOfInt[0]) > Math.abs(arrayOfInt[1]));
    for (int i = arrayOfInt[0]; ; i = arrayOfInt[1])
      return Math.round(i / f);
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
    int n;
    if (!(paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider))
      n = -1;
    int i;
    label150: label170: label176: label183: 
    do
    {
      return n;
      i = paramLayoutManager.getItemCount();
      if (i == 0)
        return -1;
      View localView = findSnapView(paramLayoutManager);
      if (localView == null)
        return -1;
      int j = paramLayoutManager.getPosition(localView);
      if (j == -1)
        return -1;
      PointF localPointF = ((RecyclerView.SmoothScroller.ScrollVectorProvider)paramLayoutManager).computeScrollVectorForPosition(i - 1);
      if (localPointF == null)
        return -1;
      int k;
      int m;
      if (paramLayoutManager.canScrollHorizontally())
      {
        k = estimateNextPositionDiffForFling(paramLayoutManager, getHorizontalHelper(paramLayoutManager), paramInt1, 0);
        if (localPointF.x < 0.0F)
          k = -k;
        if (!paramLayoutManager.canScrollVertically())
          break label170;
        m = estimateNextPositionDiffForFling(paramLayoutManager, getVerticalHelper(paramLayoutManager), 0, paramInt2);
        if (localPointF.y < 0.0F)
          m = -m;
        if (!paramLayoutManager.canScrollVertically())
          break label176;
      }
      while (true)
      {
        if (m != 0)
          break label183;
        return -1;
        k = 0;
        break;
        m = 0;
        break label150;
        m = k;
      }
      n = j + m;
      if (n < 0)
        n = 0;
    }
    while (n < i);
    return i - 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.LinearSnapHelper
 * JD-Core Version:    0.6.2
 */