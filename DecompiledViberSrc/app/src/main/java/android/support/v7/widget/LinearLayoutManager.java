package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.helper.ItemTouchHelper.ViewDropHandler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.LayoutManager
  implements RecyclerView.SmoothScroller.ScrollVectorProvider, ItemTouchHelper.ViewDropHandler
{
  static final boolean DEBUG = false;
  public static final int HORIZONTAL = 0;
  public static final int INVALID_OFFSET = -2147483648;
  private static final float MAX_SCROLL_FACTOR = 0.3333333F;
  private static final String TAG = "LinearLayoutManager";
  public static final int VERTICAL = 1;
  final AnchorInfo mAnchorInfo = new AnchorInfo();
  private int mInitialPrefetchItemCount = 2;
  private boolean mLastStackFromEnd;
  private final LayoutChunkResult mLayoutChunkResult = new LayoutChunkResult();
  private LayoutState mLayoutState;
  int mOrientation = 1;
  OrientationHelper mOrientationHelper;
  SavedState mPendingSavedState = null;
  int mPendingScrollPosition = -1;
  int mPendingScrollPositionOffset = -2147483648;
  private boolean mRecycleChildrenOnDetach;
  private boolean mReverseLayout = false;
  boolean mShouldReverseLayout = false;
  private boolean mSmoothScrollbarEnabled = true;
  private boolean mStackFromEnd = false;

  public LinearLayoutManager(Context paramContext)
  {
    this(paramContext, 1, false);
  }

  public LinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    setOrientation(paramInt);
    setReverseLayout(paramBoolean);
  }

  public LinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    RecyclerView.LayoutManager.Properties localProperties = getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setOrientation(localProperties.orientation);
    setReverseLayout(localProperties.reverseLayout);
    setStackFromEnd(localProperties.stackFromEnd);
  }

  private int computeScrollExtent(RecyclerView.State paramState)
  {
    if (getChildCount() == 0)
      return 0;
    ensureLayoutState();
    OrientationHelper localOrientationHelper = this.mOrientationHelper;
    if (!this.mSmoothScrollbarEnabled);
    for (boolean bool1 = true; ; bool1 = false)
    {
      View localView = findFirstVisibleChildClosestToStart(bool1, true);
      boolean bool2 = this.mSmoothScrollbarEnabled;
      boolean bool3 = false;
      if (!bool2)
        bool3 = true;
      return ScrollbarHelper.computeScrollExtent(paramState, localOrientationHelper, localView, findFirstVisibleChildClosestToEnd(bool3, true), this, this.mSmoothScrollbarEnabled);
    }
  }

  private int computeScrollOffset(RecyclerView.State paramState)
  {
    if (getChildCount() == 0)
      return 0;
    ensureLayoutState();
    OrientationHelper localOrientationHelper = this.mOrientationHelper;
    if (!this.mSmoothScrollbarEnabled);
    for (boolean bool1 = true; ; bool1 = false)
    {
      View localView = findFirstVisibleChildClosestToStart(bool1, true);
      boolean bool2 = this.mSmoothScrollbarEnabled;
      boolean bool3 = false;
      if (!bool2)
        bool3 = true;
      return ScrollbarHelper.computeScrollOffset(paramState, localOrientationHelper, localView, findFirstVisibleChildClosestToEnd(bool3, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }
  }

  private int computeScrollRange(RecyclerView.State paramState)
  {
    if (getChildCount() == 0)
      return 0;
    ensureLayoutState();
    OrientationHelper localOrientationHelper = this.mOrientationHelper;
    if (!this.mSmoothScrollbarEnabled);
    for (boolean bool1 = true; ; bool1 = false)
    {
      View localView = findFirstVisibleChildClosestToStart(bool1, true);
      boolean bool2 = this.mSmoothScrollbarEnabled;
      boolean bool3 = false;
      if (!bool2)
        bool3 = true;
      return ScrollbarHelper.computeScrollRange(paramState, localOrientationHelper, localView, findFirstVisibleChildClosestToEnd(bool3, true), this, this.mSmoothScrollbarEnabled);
    }
  }

  private View findFirstPartiallyOrCompletelyInvisibleChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
  }

  private View findFirstReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return findReferenceChild(paramRecycler, paramState, 0, getChildCount(), paramState.getItemCount());
  }

  private View findFirstVisibleChildClosestToEnd(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mShouldReverseLayout)
      return findOneVisibleChild(0, getChildCount(), paramBoolean1, paramBoolean2);
    return findOneVisibleChild(-1 + getChildCount(), -1, paramBoolean1, paramBoolean2);
  }

  private View findFirstVisibleChildClosestToStart(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mShouldReverseLayout)
      return findOneVisibleChild(-1 + getChildCount(), -1, paramBoolean1, paramBoolean2);
    return findOneVisibleChild(0, getChildCount(), paramBoolean1, paramBoolean2);
  }

  private View findLastPartiallyOrCompletelyInvisibleChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return findOnePartiallyOrCompletelyInvisibleChild(-1 + getChildCount(), -1);
  }

  private View findLastReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return findReferenceChild(paramRecycler, paramState, -1 + getChildCount(), -1, paramState.getItemCount());
  }

  private View findPartiallyOrCompletelyInvisibleChildClosestToEnd(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mShouldReverseLayout)
      return findFirstPartiallyOrCompletelyInvisibleChild(paramRecycler, paramState);
    return findLastPartiallyOrCompletelyInvisibleChild(paramRecycler, paramState);
  }

  private View findPartiallyOrCompletelyInvisibleChildClosestToStart(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mShouldReverseLayout)
      return findLastPartiallyOrCompletelyInvisibleChild(paramRecycler, paramState);
    return findFirstPartiallyOrCompletelyInvisibleChild(paramRecycler, paramState);
  }

  private View findReferenceChildClosestToEnd(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mShouldReverseLayout)
      return findFirstReferenceChild(paramRecycler, paramState);
    return findLastReferenceChild(paramRecycler, paramState);
  }

  private View findReferenceChildClosestToStart(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mShouldReverseLayout)
      return findLastReferenceChild(paramRecycler, paramState);
    return findFirstReferenceChild(paramRecycler, paramState);
  }

  private int fixLayoutEndGap(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = this.mOrientationHelper.getEndAfterPadding() - paramInt;
    if (i > 0)
    {
      int j = -scrollBy(-i, paramRecycler, paramState);
      int k = paramInt + j;
      if (paramBoolean)
      {
        int m = this.mOrientationHelper.getEndAfterPadding() - k;
        if (m > 0)
        {
          this.mOrientationHelper.offsetChildren(m);
          j += m;
        }
      }
      return j;
    }
    return 0;
  }

  private int fixLayoutStartGap(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = paramInt - this.mOrientationHelper.getStartAfterPadding();
    if (i > 0)
    {
      int j = -scrollBy(i, paramRecycler, paramState);
      int k = paramInt + j;
      if (paramBoolean)
      {
        int m = k - this.mOrientationHelper.getStartAfterPadding();
        if (m > 0)
        {
          this.mOrientationHelper.offsetChildren(-m);
          j -= m;
        }
      }
      return j;
    }
    return 0;
  }

  private View getChildClosestToEnd()
  {
    if (this.mShouldReverseLayout);
    for (int i = 0; ; i = -1 + getChildCount())
      return getChildAt(i);
  }

  private View getChildClosestToStart()
  {
    if (this.mShouldReverseLayout);
    for (int i = -1 + getChildCount(); ; i = 0)
      return getChildAt(i);
  }

  private void layoutForPredictiveAnimations(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2)
  {
    if ((!paramState.willRunPredictiveAnimations()) || (getChildCount() == 0) || (paramState.isPreLayout()) || (!supportsPredictiveItemAnimations()))
      return;
    int i = 0;
    int j = 0;
    List localList = paramRecycler.getScrapList();
    int k = localList.size();
    int m = getPosition(getChildAt(0));
    int n = 0;
    if (n < k)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localList.get(n);
      int i3;
      int i4;
      if (localViewHolder.isRemoved())
      {
        i3 = j;
        i4 = i;
      }
      while (true)
      {
        n++;
        i = i4;
        j = i3;
        break;
        int i1;
        if (localViewHolder.getLayoutPosition() < m)
        {
          i1 = 1;
          label128: if (i1 == this.mShouldReverseLayout)
            break label176;
        }
        label176: for (int i2 = -1; ; i2 = 1)
        {
          if (i2 != -1)
            break label182;
          i4 = i + this.mOrientationHelper.getDecoratedMeasurement(localViewHolder.itemView);
          i3 = j;
          break;
          i1 = 0;
          break label128;
        }
        label182: i3 = j + this.mOrientationHelper.getDecoratedMeasurement(localViewHolder.itemView);
        i4 = i;
      }
    }
    this.mLayoutState.mScrapList = localList;
    if (i > 0)
    {
      updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), paramInt1);
      this.mLayoutState.mExtra = i;
      this.mLayoutState.mAvailable = 0;
      this.mLayoutState.assignPositionFromScrapList();
      fill(paramRecycler, this.mLayoutState, paramState, false);
    }
    if (j > 0)
    {
      updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), paramInt2);
      this.mLayoutState.mExtra = j;
      this.mLayoutState.mAvailable = 0;
      this.mLayoutState.assignPositionFromScrapList();
      fill(paramRecycler, this.mLayoutState, paramState, false);
    }
    this.mLayoutState.mScrapList = null;
  }

  private void logChildren()
  {
    Log.d("LinearLayoutManager", "internal representation of views on the screen");
    for (int i = 0; i < getChildCount(); i++)
    {
      View localView = getChildAt(i);
      Log.d("LinearLayoutManager", "item " + getPosition(localView) + ", coord:" + this.mOrientationHelper.getDecoratedStart(localView));
    }
    Log.d("LinearLayoutManager", "==============");
  }

  private void recycleByLayoutState(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState)
  {
    if ((!paramLayoutState.mRecycle) || (paramLayoutState.mInfinite))
      return;
    if (paramLayoutState.mLayoutDirection == -1)
    {
      recycleViewsFromEnd(paramRecycler, paramLayoutState.mScrollingOffset);
      return;
    }
    recycleViewsFromStart(paramRecycler, paramLayoutState.mScrollingOffset);
  }

  private void recycleChildren(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2);
    while (true)
    {
      return;
      if (paramInt2 > paramInt1)
        for (int i = paramInt2 - 1; i >= paramInt1; i--)
          removeAndRecycleViewAt(i, paramRecycler);
      else
        while (paramInt1 > paramInt2)
        {
          removeAndRecycleViewAt(paramInt1, paramRecycler);
          paramInt1--;
        }
    }
  }

  private void recycleViewsFromEnd(RecyclerView.Recycler paramRecycler, int paramInt)
  {
    int i = getChildCount();
    if (paramInt < 0);
    while (true)
    {
      return;
      int j = this.mOrientationHelper.getEnd() - paramInt;
      if (this.mShouldReverseLayout)
        for (int m = 0; m < i; m++)
        {
          View localView2 = getChildAt(m);
          if ((this.mOrientationHelper.getDecoratedStart(localView2) < j) || (this.mOrientationHelper.getTransformedStartWithDecoration(localView2) < j))
          {
            recycleChildren(paramRecycler, 0, m);
            return;
          }
        }
      else
        for (int k = i - 1; k >= 0; k--)
        {
          View localView1 = getChildAt(k);
          if ((this.mOrientationHelper.getDecoratedStart(localView1) < j) || (this.mOrientationHelper.getTransformedStartWithDecoration(localView1) < j))
          {
            recycleChildren(paramRecycler, i - 1, k);
            return;
          }
        }
    }
  }

  private void recycleViewsFromStart(RecyclerView.Recycler paramRecycler, int paramInt)
  {
    if (paramInt < 0);
    while (true)
    {
      return;
      int i = getChildCount();
      if (this.mShouldReverseLayout)
        for (int k = i - 1; k >= 0; k--)
        {
          View localView2 = getChildAt(k);
          if ((this.mOrientationHelper.getDecoratedEnd(localView2) > paramInt) || (this.mOrientationHelper.getTransformedEndWithDecoration(localView2) > paramInt))
          {
            recycleChildren(paramRecycler, i - 1, k);
            return;
          }
        }
      else
        for (int j = 0; j < i; j++)
        {
          View localView1 = getChildAt(j);
          if ((this.mOrientationHelper.getDecoratedEnd(localView1) > paramInt) || (this.mOrientationHelper.getTransformedEndWithDecoration(localView1) > paramInt))
          {
            recycleChildren(paramRecycler, 0, j);
            return;
          }
        }
    }
  }

  private void resolveShouldLayoutReverse()
  {
    int i = 1;
    if ((this.mOrientation == i) || (!isLayoutRTL()))
    {
      this.mShouldReverseLayout = this.mReverseLayout;
      return;
    }
    if (!this.mReverseLayout);
    while (true)
    {
      this.mShouldReverseLayout = i;
      return;
      i = 0;
    }
  }

  private boolean updateAnchorFromChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, AnchorInfo paramAnchorInfo)
  {
    if (getChildCount() == 0);
    do
    {
      return false;
      View localView1 = getFocusedChild();
      if ((localView1 != null) && (paramAnchorInfo.isViewValidAsAnchor(localView1, paramState)))
      {
        paramAnchorInfo.assignFromViewAndKeepVisibleRect(localView1, getPosition(localView1));
        return true;
      }
    }
    while (this.mLastStackFromEnd != this.mStackFromEnd);
    View localView2;
    if (paramAnchorInfo.mLayoutFromEnd)
    {
      localView2 = findReferenceChildClosestToEnd(paramRecycler, paramState);
      label70: if (localView2 == null)
        break label191;
      paramAnchorInfo.assignFromView(localView2, getPosition(localView2));
      if ((!paramState.isPreLayout()) && (supportsPredictiveItemAnimations()))
      {
        int i;
        if (this.mOrientationHelper.getDecoratedStart(localView2) < this.mOrientationHelper.getEndAfterPadding())
        {
          int k = this.mOrientationHelper.getDecoratedEnd(localView2);
          int m = this.mOrientationHelper.getStartAfterPadding();
          i = 0;
          if (k >= m);
        }
        else
        {
          i = 1;
        }
        if (i != 0)
          if (!paramAnchorInfo.mLayoutFromEnd)
            break label193;
      }
    }
    label191: label193: for (int j = this.mOrientationHelper.getEndAfterPadding(); ; j = this.mOrientationHelper.getStartAfterPadding())
    {
      paramAnchorInfo.mCoordinate = j;
      return true;
      localView2 = findReferenceChildClosestToStart(paramRecycler, paramState);
      break label70;
      break;
    }
  }

  private boolean updateAnchorFromPendingData(RecyclerView.State paramState, AnchorInfo paramAnchorInfo)
  {
    if ((paramState.isPreLayout()) || (this.mPendingScrollPosition == -1))
      return false;
    if ((this.mPendingScrollPosition < 0) || (this.mPendingScrollPosition >= paramState.getItemCount()))
    {
      this.mPendingScrollPosition = -1;
      this.mPendingScrollPositionOffset = -2147483648;
      return false;
    }
    paramAnchorInfo.mPosition = this.mPendingScrollPosition;
    if ((this.mPendingSavedState != null) && (this.mPendingSavedState.hasValidAnchor()))
    {
      paramAnchorInfo.mLayoutFromEnd = this.mPendingSavedState.mAnchorLayoutFromEnd;
      if (paramAnchorInfo.mLayoutFromEnd)
      {
        paramAnchorInfo.mCoordinate = (this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset);
        return true;
      }
      paramAnchorInfo.mCoordinate = (this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset);
      return true;
    }
    if (this.mPendingScrollPositionOffset == -2147483648)
    {
      View localView = findViewByPosition(this.mPendingScrollPosition);
      if (localView != null)
      {
        if (this.mOrientationHelper.getDecoratedMeasurement(localView) > this.mOrientationHelper.getTotalSpace())
        {
          paramAnchorInfo.assignCoordinateFromPadding();
          return true;
        }
        if (this.mOrientationHelper.getDecoratedStart(localView) - this.mOrientationHelper.getStartAfterPadding() < 0)
        {
          paramAnchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
          paramAnchorInfo.mLayoutFromEnd = false;
          return true;
        }
        if (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(localView) < 0)
        {
          paramAnchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
          paramAnchorInfo.mLayoutFromEnd = true;
          return true;
        }
        if (paramAnchorInfo.mLayoutFromEnd);
        for (int j = this.mOrientationHelper.getDecoratedEnd(localView) + this.mOrientationHelper.getTotalSpaceChange(); ; j = this.mOrientationHelper.getDecoratedStart(localView))
        {
          paramAnchorInfo.mCoordinate = j;
          return true;
        }
      }
      if (getChildCount() > 0)
      {
        int i = getPosition(getChildAt(0));
        if (this.mPendingScrollPosition >= i)
          break label360;
      }
      label360: for (boolean bool1 = true; ; bool1 = false)
      {
        boolean bool2 = this.mShouldReverseLayout;
        boolean bool3 = false;
        if (bool1 == bool2)
          bool3 = true;
        paramAnchorInfo.mLayoutFromEnd = bool3;
        paramAnchorInfo.assignCoordinateFromPadding();
        return true;
      }
    }
    paramAnchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
    if (this.mShouldReverseLayout)
    {
      paramAnchorInfo.mCoordinate = (this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset);
      return true;
    }
    paramAnchorInfo.mCoordinate = (this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset);
    return true;
  }

  private void updateAnchorInfoForLayout(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, AnchorInfo paramAnchorInfo)
  {
    if (updateAnchorFromPendingData(paramState, paramAnchorInfo));
    while (updateAnchorFromChildren(paramRecycler, paramState, paramAnchorInfo))
      return;
    paramAnchorInfo.assignCoordinateFromPadding();
    if (this.mStackFromEnd);
    for (int i = -1 + paramState.getItemCount(); ; i = 0)
    {
      paramAnchorInfo.mPosition = i;
      return;
    }
  }

  private void updateLayoutState(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerView.State paramState)
  {
    int i = -1;
    int j = 1;
    this.mLayoutState.mInfinite = resolveIsInfinite();
    this.mLayoutState.mExtra = getExtraLayoutSpace(paramState);
    this.mLayoutState.mLayoutDirection = paramInt1;
    int k;
    if (paramInt1 == j)
    {
      LayoutState localLayoutState4 = this.mLayoutState;
      localLayoutState4.mExtra += this.mOrientationHelper.getEndPadding();
      View localView2 = getChildClosestToEnd();
      LayoutState localLayoutState5 = this.mLayoutState;
      if (this.mShouldReverseLayout);
      while (true)
      {
        localLayoutState5.mItemDirection = i;
        this.mLayoutState.mCurrentPosition = (getPosition(localView2) + this.mLayoutState.mItemDirection);
        this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedEnd(localView2);
        k = this.mOrientationHelper.getDecoratedEnd(localView2) - this.mOrientationHelper.getEndAfterPadding();
        this.mLayoutState.mAvailable = paramInt2;
        if (paramBoolean)
        {
          LayoutState localLayoutState3 = this.mLayoutState;
          localLayoutState3.mAvailable -= k;
        }
        this.mLayoutState.mScrollingOffset = k;
        return;
        i = j;
      }
    }
    View localView1 = getChildClosestToStart();
    LayoutState localLayoutState1 = this.mLayoutState;
    localLayoutState1.mExtra += this.mOrientationHelper.getStartAfterPadding();
    LayoutState localLayoutState2 = this.mLayoutState;
    if (this.mShouldReverseLayout);
    while (true)
    {
      localLayoutState2.mItemDirection = j;
      this.mLayoutState.mCurrentPosition = (getPosition(localView1) + this.mLayoutState.mItemDirection);
      this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedStart(localView1);
      k = -this.mOrientationHelper.getDecoratedStart(localView1) + this.mOrientationHelper.getStartAfterPadding();
      break;
      j = i;
    }
  }

  private void updateLayoutStateToFillEnd(int paramInt1, int paramInt2)
  {
    this.mLayoutState.mAvailable = (this.mOrientationHelper.getEndAfterPadding() - paramInt2);
    LayoutState localLayoutState = this.mLayoutState;
    if (this.mShouldReverseLayout);
    for (int i = -1; ; i = 1)
    {
      localLayoutState.mItemDirection = i;
      this.mLayoutState.mCurrentPosition = paramInt1;
      this.mLayoutState.mLayoutDirection = 1;
      this.mLayoutState.mOffset = paramInt2;
      this.mLayoutState.mScrollingOffset = -2147483648;
      return;
    }
  }

  private void updateLayoutStateToFillEnd(AnchorInfo paramAnchorInfo)
  {
    updateLayoutStateToFillEnd(paramAnchorInfo.mPosition, paramAnchorInfo.mCoordinate);
  }

  private void updateLayoutStateToFillStart(int paramInt1, int paramInt2)
  {
    this.mLayoutState.mAvailable = (paramInt2 - this.mOrientationHelper.getStartAfterPadding());
    this.mLayoutState.mCurrentPosition = paramInt1;
    LayoutState localLayoutState = this.mLayoutState;
    if (this.mShouldReverseLayout);
    for (int i = 1; ; i = -1)
    {
      localLayoutState.mItemDirection = i;
      this.mLayoutState.mLayoutDirection = -1;
      this.mLayoutState.mOffset = paramInt2;
      this.mLayoutState.mScrollingOffset = -2147483648;
      return;
    }
  }

  private void updateLayoutStateToFillStart(AnchorInfo paramAnchorInfo)
  {
    updateLayoutStateToFillStart(paramAnchorInfo.mPosition, paramAnchorInfo.mCoordinate);
  }

  public void assertNotInLayoutOrScroll(String paramString)
  {
    if (this.mPendingSavedState == null)
      super.assertNotInLayoutOrScroll(paramString);
  }

  public boolean canScrollHorizontally()
  {
    return this.mOrientation == 0;
  }

  public boolean canScrollVertically()
  {
    return this.mOrientation == 1;
  }

  public void collectAdjacentPrefetchPositions(int paramInt1, int paramInt2, RecyclerView.State paramState, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry)
  {
    if (this.mOrientation == 0);
    while ((getChildCount() == 0) || (paramInt1 == 0))
    {
      return;
      paramInt1 = paramInt2;
    }
    ensureLayoutState();
    if (paramInt1 > 0);
    for (int i = 1; ; i = -1)
    {
      updateLayoutState(i, Math.abs(paramInt1), true, paramState);
      collectPrefetchPositionsForLayoutState(paramState, this.mLayoutState, paramLayoutPrefetchRegistry);
      return;
    }
  }

  public void collectInitialPrefetchPositions(int paramInt, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry)
  {
    boolean bool2;
    int i;
    if ((this.mPendingSavedState != null) && (this.mPendingSavedState.hasValidAnchor()))
    {
      bool2 = this.mPendingSavedState.mAnchorLayoutFromEnd;
      i = this.mPendingSavedState.mAnchorPosition;
      if (!bool2)
        break label142;
    }
    label142: for (int j = -1; ; j = 1)
    {
      for (int k = 0; (k < this.mInitialPrefetchItemCount) && (i >= 0) && (i < paramInt); k++)
      {
        paramLayoutPrefetchRegistry.addPosition(i, 0);
        i += j;
      }
      resolveShouldLayoutReverse();
      boolean bool1 = this.mShouldReverseLayout;
      if (this.mPendingScrollPosition == -1)
      {
        if (bool1);
        for (int m = paramInt - 1; ; m = 0)
        {
          i = m;
          bool2 = bool1;
          break;
        }
      }
      i = this.mPendingScrollPosition;
      bool2 = bool1;
      break;
    }
  }

  void collectPrefetchPositionsForLayoutState(RecyclerView.State paramState, LayoutState paramLayoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry)
  {
    int i = paramLayoutState.mCurrentPosition;
    if ((i >= 0) && (i < paramState.getItemCount()))
      paramLayoutPrefetchRegistry.addPosition(i, Math.max(0, paramLayoutState.mScrollingOffset));
  }

  public int computeHorizontalScrollExtent(RecyclerView.State paramState)
  {
    return computeScrollExtent(paramState);
  }

  public int computeHorizontalScrollOffset(RecyclerView.State paramState)
  {
    return computeScrollOffset(paramState);
  }

  public int computeHorizontalScrollRange(RecyclerView.State paramState)
  {
    return computeScrollRange(paramState);
  }

  public PointF computeScrollVectorForPosition(int paramInt)
  {
    int i = 1;
    if (getChildCount() == 0)
      return null;
    int j = getPosition(getChildAt(0));
    int k = 0;
    if (paramInt < j)
      k = i;
    if (k != this.mShouldReverseLayout)
      i = -1;
    if (this.mOrientation == 0)
      return new PointF(i, 0.0F);
    return new PointF(0.0F, i);
  }

  public int computeVerticalScrollExtent(RecyclerView.State paramState)
  {
    return computeScrollExtent(paramState);
  }

  public int computeVerticalScrollOffset(RecyclerView.State paramState)
  {
    return computeScrollOffset(paramState);
  }

  public int computeVerticalScrollRange(RecyclerView.State paramState)
  {
    return computeScrollRange(paramState);
  }

  int convertFocusDirectionToLayoutDirection(int paramInt)
  {
    int i = -1;
    int j = -2147483648;
    int k = 1;
    switch (paramInt)
    {
    default:
      i = j;
    case 1:
    case 2:
    case 33:
    case 130:
    case 17:
      do
      {
        do
        {
          do
          {
            do
              return i;
            while ((this.mOrientation == k) || (!isLayoutRTL()));
            return k;
            if (this.mOrientation == k)
              return k;
          }
          while (isLayoutRTL());
          return k;
        }
        while (this.mOrientation == k);
        return j;
        if (this.mOrientation == k)
          j = k;
        return j;
      }
      while (this.mOrientation == 0);
      return j;
    case 66:
    }
    if (this.mOrientation == 0);
    while (true)
    {
      return k;
      k = j;
    }
  }

  LayoutState createLayoutState()
  {
    return new LayoutState();
  }

  void ensureLayoutState()
  {
    if (this.mLayoutState == null)
      this.mLayoutState = createLayoutState();
  }

  int fill(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = paramLayoutState.mAvailable;
    if (paramLayoutState.mScrollingOffset != -2147483648)
    {
      if (paramLayoutState.mAvailable < 0)
        paramLayoutState.mScrollingOffset += paramLayoutState.mAvailable;
      recycleByLayoutState(paramRecycler, paramLayoutState);
    }
    int j = paramLayoutState.mAvailable + paramLayoutState.mExtra;
    LayoutChunkResult localLayoutChunkResult = this.mLayoutChunkResult;
    if (((paramLayoutState.mInfinite) || (j > 0)) && (paramLayoutState.hasMore(paramState)))
    {
      localLayoutChunkResult.resetInternal();
      layoutChunk(paramRecycler, paramState, paramLayoutState, localLayoutChunkResult);
      if (!localLayoutChunkResult.mFinished)
        break label108;
    }
    while (true)
    {
      return i - paramLayoutState.mAvailable;
      label108: paramLayoutState.mOffset += localLayoutChunkResult.mConsumed * paramLayoutState.mLayoutDirection;
      if ((!localLayoutChunkResult.mIgnoreConsumed) || (this.mLayoutState.mScrapList != null) || (!paramState.isPreLayout()))
      {
        paramLayoutState.mAvailable -= localLayoutChunkResult.mConsumed;
        j -= localLayoutChunkResult.mConsumed;
      }
      if (paramLayoutState.mScrollingOffset != -2147483648)
      {
        paramLayoutState.mScrollingOffset += localLayoutChunkResult.mConsumed;
        if (paramLayoutState.mAvailable < 0)
          paramLayoutState.mScrollingOffset += paramLayoutState.mAvailable;
        recycleByLayoutState(paramRecycler, paramLayoutState);
      }
      if ((!paramBoolean) || (!localLayoutChunkResult.mFocusable))
        break;
    }
  }

  public int findFirstCompletelyVisibleItemPosition()
  {
    View localView = findOneVisibleChild(0, getChildCount(), true, false);
    if (localView == null)
      return -1;
    return getPosition(localView);
  }

  public int findFirstVisibleItemPosition()
  {
    View localView = findOneVisibleChild(0, getChildCount(), false, true);
    if (localView == null)
      return -1;
    return getPosition(localView);
  }

  public int findLastCompletelyVisibleItemPosition()
  {
    View localView = findOneVisibleChild(-1 + getChildCount(), -1, true, false);
    if (localView == null)
      return -1;
    return getPosition(localView);
  }

  public int findLastVisibleItemPosition()
  {
    View localView = findOneVisibleChild(-1 + getChildCount(), -1, false, true);
    if (localView == null)
      return -1;
    return getPosition(localView);
  }

  View findOnePartiallyOrCompletelyInvisibleChild(int paramInt1, int paramInt2)
  {
    ensureLayoutState();
    int i;
    if (paramInt2 > paramInt1)
      i = 1;
    while (i == 0)
    {
      return getChildAt(paramInt1);
      if (paramInt2 < paramInt1)
        i = -1;
      else
        i = 0;
    }
    int j;
    if (this.mOrientationHelper.getDecoratedStart(getChildAt(paramInt1)) < this.mOrientationHelper.getStartAfterPadding())
      j = 16644;
    for (int k = 16388; this.mOrientation == 0; k = 4097)
    {
      return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(paramInt1, paramInt2, j, k);
      j = 4161;
    }
    return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(paramInt1, paramInt2, j, k);
  }

  View findOneVisibleChild(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 320;
    ensureLayoutState();
    int j;
    if (paramBoolean1)
    {
      j = 24579;
      if (!paramBoolean2)
        break label65;
    }
    while (true)
    {
      if (this.mOrientation == 0)
      {
        return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(paramInt1, paramInt2, j, i);
        j = i;
        break;
      }
      return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(paramInt1, paramInt2, j, i);
      label65: i = 0;
    }
  }

  View findReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = null;
    ensureLayoutState();
    int i = this.mOrientationHelper.getStartAfterPadding();
    int j = this.mOrientationHelper.getEndAfterPadding();
    int k;
    Object localObject2;
    label37: Object localObject3;
    Object localObject4;
    if (paramInt2 > paramInt1)
    {
      k = 1;
      localObject2 = null;
      if (paramInt1 == paramInt2)
        break label159;
      localObject3 = getChildAt(paramInt1);
      int m = getPosition((View)localObject3);
      if ((m < 0) || (m >= paramInt3))
        break label178;
      if (!((RecyclerView.LayoutParams)((View)localObject3).getLayoutParams()).isItemRemoved())
        break label115;
      if (localObject2 != null)
        break label178;
      localObject4 = localObject1;
    }
    label159: label178: 
    while (true)
    {
      paramInt1 += k;
      localObject1 = localObject4;
      localObject2 = localObject3;
      break label37;
      k = -1;
      break;
      label115: if ((this.mOrientationHelper.getDecoratedStart((View)localObject3) >= j) || (this.mOrientationHelper.getDecoratedEnd((View)localObject3) < i))
      {
        if (localObject1 == null)
        {
          localObject4 = localObject3;
          localObject3 = localObject2;
          continue;
          if (localObject1 == null);
        }
      }
      else
      {
        while (true)
        {
          localObject3 = localObject1;
          return localObject3;
          localObject1 = localObject2;
        }
        localObject4 = localObject1;
        localObject3 = localObject2;
      }
    }
  }

  public View findViewByPosition(int paramInt)
  {
    int i = getChildCount();
    View localView;
    if (i == 0)
      localView = null;
    do
    {
      return localView;
      int j = paramInt - getPosition(getChildAt(0));
      if ((j < 0) || (j >= i))
        break;
      localView = getChildAt(j);
    }
    while (getPosition(localView) == paramInt);
    return super.findViewByPosition(paramInt);
  }

  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }

  protected int getExtraLayoutSpace(RecyclerView.State paramState)
  {
    if (paramState.hasTargetScrollPosition())
      return this.mOrientationHelper.getTotalSpace();
    return 0;
  }

  public int getInitialPrefetchItemCount()
  {
    return this.mInitialPrefetchItemCount;
  }

  public int getOrientation()
  {
    return this.mOrientation;
  }

  public boolean getRecycleChildrenOnDetach()
  {
    return this.mRecycleChildrenOnDetach;
  }

  public boolean getReverseLayout()
  {
    return this.mReverseLayout;
  }

  public boolean getStackFromEnd()
  {
    return this.mStackFromEnd;
  }

  public boolean isAutoMeasureEnabled()
  {
    return true;
  }

  protected boolean isLayoutRTL()
  {
    return getLayoutDirection() == 1;
  }

  public boolean isSmoothScrollbarEnabled()
  {
    return this.mSmoothScrollbarEnabled;
  }

  void layoutChunk(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LayoutState paramLayoutState, LayoutChunkResult paramLayoutChunkResult)
  {
    View localView = paramLayoutState.next(paramRecycler);
    if (localView == null)
    {
      paramLayoutChunkResult.mFinished = true;
      return;
    }
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
    boolean bool4;
    label66: int i1;
    int k;
    label128: int j;
    int i;
    int m;
    if (paramLayoutState.mScrapList == null)
    {
      boolean bool3 = this.mShouldReverseLayout;
      if (paramLayoutState.mLayoutDirection == -1)
      {
        bool4 = true;
        if (bool3 != bool4)
          break label211;
        addView(localView);
        measureChildWithMargins(localView, 0, 0);
        paramLayoutChunkResult.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(localView);
        if (this.mOrientation != 1)
          break label318;
        if (!isLayoutRTL())
          break label270;
        i1 = getWidth() - getPaddingRight();
        k = i1 - this.mOrientationHelper.getDecoratedMeasurementInOther(localView);
        if (paramLayoutState.mLayoutDirection != -1)
          break label293;
        j = paramLayoutState.mOffset;
        i = paramLayoutState.mOffset - paramLayoutChunkResult.mConsumed;
        m = i1;
      }
    }
    while (true)
    {
      layoutDecoratedWithMargins(localView, k, i, m, j);
      if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged()))
        paramLayoutChunkResult.mIgnoreConsumed = true;
      paramLayoutChunkResult.mFocusable = localView.hasFocusable();
      return;
      bool4 = false;
      break;
      label211: addView(localView, 0);
      break label66;
      boolean bool1 = this.mShouldReverseLayout;
      if (paramLayoutState.mLayoutDirection == -1);
      for (boolean bool2 = true; ; bool2 = false)
      {
        if (bool1 != bool2)
          break label260;
        addDisappearingView(localView);
        break;
      }
      label260: addDisappearingView(localView, 0);
      break label66;
      label270: k = getPaddingLeft();
      i1 = k + this.mOrientationHelper.getDecoratedMeasurementInOther(localView);
      break label128;
      label293: i = paramLayoutState.mOffset;
      j = paramLayoutState.mOffset + paramLayoutChunkResult.mConsumed;
      m = i1;
      continue;
      label318: i = getPaddingTop();
      j = i + this.mOrientationHelper.getDecoratedMeasurementInOther(localView);
      if (paramLayoutState.mLayoutDirection == -1)
      {
        int n = paramLayoutState.mOffset;
        k = paramLayoutState.mOffset - paramLayoutChunkResult.mConsumed;
        m = n;
      }
      else
      {
        k = paramLayoutState.mOffset;
        m = paramLayoutState.mOffset + paramLayoutChunkResult.mConsumed;
      }
    }
  }

  void onAnchorReady(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, AnchorInfo paramAnchorInfo, int paramInt)
  {
  }

  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
  {
    super.onDetachedFromWindow(paramRecyclerView, paramRecycler);
    if (this.mRecycleChildrenOnDetach)
    {
      removeAndRecycleAllViews(paramRecycler);
      paramRecycler.clear();
    }
  }

  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    resolveShouldLayoutReverse();
    if (getChildCount() == 0)
    {
      localView2 = null;
      return localView2;
    }
    int i = convertFocusDirectionToLayoutDirection(paramInt);
    if (i == -2147483648)
      return null;
    ensureLayoutState();
    ensureLayoutState();
    updateLayoutState(i, (int)(0.3333333F * this.mOrientationHelper.getTotalSpace()), false, paramState);
    this.mLayoutState.mScrollingOffset = -2147483648;
    this.mLayoutState.mRecycle = false;
    fill(paramRecycler, this.mLayoutState, paramState, true);
    View localView1;
    if (i == -1)
    {
      localView1 = findPartiallyOrCompletelyInvisibleChildClosestToStart(paramRecycler, paramState);
      label107: if (i != -1)
        break label146;
    }
    label146: for (View localView2 = getChildClosestToStart(); ; localView2 = getChildClosestToEnd())
    {
      if (!localView2.hasFocusable())
        break label155;
      if (localView1 != null)
        break;
      return null;
      localView1 = findPartiallyOrCompletelyInvisibleChildClosestToEnd(paramRecycler, paramState);
      break label107;
    }
    label155: return localView1;
  }

  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0)
    {
      paramAccessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
      paramAccessibilityEvent.setToIndex(findLastVisibleItemPosition());
    }
  }

  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    int i = -1;
    if (((this.mPendingSavedState != null) || (this.mPendingScrollPosition != i)) && (paramState.getItemCount() == 0))
    {
      removeAndRecycleAllViews(paramRecycler);
      return;
    }
    if ((this.mPendingSavedState != null) && (this.mPendingSavedState.hasValidAnchor()))
      this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
    ensureLayoutState();
    this.mLayoutState.mRecycle = false;
    resolveShouldLayoutReverse();
    View localView1 = getFocusedChild();
    int j;
    int k;
    label166: int m;
    int n;
    View localView2;
    int i19;
    label260: label272: label291: int i13;
    int i15;
    if ((!this.mAnchorInfo.mValid) || (this.mPendingScrollPosition != i) || (this.mPendingSavedState != null))
    {
      this.mAnchorInfo.reset();
      this.mAnchorInfo.mLayoutFromEnd = (this.mShouldReverseLayout ^ this.mStackFromEnd);
      updateAnchorInfoForLayout(paramRecycler, paramState, this.mAnchorInfo);
      this.mAnchorInfo.mValid = true;
      j = getExtraLayoutSpace(paramState);
      if (this.mLayoutState.mLastScrollDelta < 0)
        break label698;
      k = 0;
      m = k + this.mOrientationHelper.getStartAfterPadding();
      n = j + this.mOrientationHelper.getEndPadding();
      if ((paramState.isPreLayout()) && (this.mPendingScrollPosition != i) && (this.mPendingScrollPositionOffset != -2147483648))
      {
        localView2 = findViewByPosition(this.mPendingScrollPosition);
        if (localView2 != null)
        {
          if (!this.mShouldReverseLayout)
            break label708;
          i19 = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(localView2) - this.mPendingScrollPositionOffset;
          if (i19 <= 0)
            break label739;
          m += i19;
        }
      }
      if (!this.mAnchorInfo.mLayoutFromEnd)
        break label749;
      if (this.mShouldReverseLayout)
        i = 1;
      onAnchorReady(paramRecycler, paramState, this.mAnchorInfo, i);
      detachAndScrapAttachedViews(paramRecycler);
      this.mLayoutState.mInfinite = resolveIsInfinite();
      this.mLayoutState.mIsPreLayout = paramState.isPreLayout();
      if (!this.mAnchorInfo.mLayoutFromEnd)
        break label761;
      updateLayoutStateToFillStart(this.mAnchorInfo);
      this.mLayoutState.mExtra = m;
      fill(paramRecycler, this.mLayoutState, paramState, false);
      i13 = this.mLayoutState.mOffset;
      int i14 = this.mLayoutState.mCurrentPosition;
      if (this.mLayoutState.mAvailable > 0)
        n += this.mLayoutState.mAvailable;
      updateLayoutStateToFillEnd(this.mAnchorInfo);
      this.mLayoutState.mExtra = n;
      LayoutState localLayoutState2 = this.mLayoutState;
      localLayoutState2.mCurrentPosition += this.mLayoutState.mItemDirection;
      fill(paramRecycler, this.mLayoutState, paramState, false);
      i15 = this.mLayoutState.mOffset;
      if (this.mLayoutState.mAvailable <= 0)
        break label1015;
      int i17 = this.mLayoutState.mAvailable;
      updateLayoutStateToFillStart(i14, i13);
      this.mLayoutState.mExtra = i17;
      fill(paramRecycler, this.mLayoutState, paramState, false);
    }
    label535: label604: label739: label749: label1005: label1015: for (int i16 = this.mLayoutState.mOffset; ; i16 = i13)
    {
      int i3 = i16;
      int i1 = i15;
      if (getChildCount() > 0)
      {
        if ((this.mShouldReverseLayout ^ this.mStackFromEnd))
        {
          int i9 = fixLayoutEndGap(i1, paramRecycler, paramState, true);
          int i10 = i3 + i9;
          int i11 = i1 + i9;
          int i12 = fixLayoutStartGap(i10, paramRecycler, paramState, false);
          i3 = i10 + i12;
          i1 = i11 + i12;
        }
      }
      else
      {
        layoutForPredictiveAnimations(paramRecycler, paramState, i3, i1);
        if (paramState.isPreLayout())
          break label1005;
        this.mOrientationHelper.onLayoutComplete();
      }
      while (true)
      {
        this.mLastStackFromEnd = this.mStackFromEnd;
        return;
        if ((localView1 == null) || ((this.mOrientationHelper.getDecoratedStart(localView1) < this.mOrientationHelper.getEndAfterPadding()) && (this.mOrientationHelper.getDecoratedEnd(localView1) > this.mOrientationHelper.getStartAfterPadding())))
          break;
        this.mAnchorInfo.assignFromViewAndKeepVisibleRect(localView1, getPosition(localView1));
        break;
        k = j;
        j = 0;
        break label166;
        int i18 = this.mOrientationHelper.getDecoratedStart(localView2) - this.mOrientationHelper.getStartAfterPadding();
        i19 = this.mPendingScrollPositionOffset - i18;
        break label260;
        n -= i19;
        break label272;
        if (this.mShouldReverseLayout)
          break label291;
        i = 1;
        break label291;
        label761: updateLayoutStateToFillEnd(this.mAnchorInfo);
        this.mLayoutState.mExtra = n;
        fill(paramRecycler, this.mLayoutState, paramState, false);
        i1 = this.mLayoutState.mOffset;
        int i2 = this.mLayoutState.mCurrentPosition;
        if (this.mLayoutState.mAvailable > 0)
          m += this.mLayoutState.mAvailable;
        updateLayoutStateToFillStart(this.mAnchorInfo);
        this.mLayoutState.mExtra = m;
        LayoutState localLayoutState1 = this.mLayoutState;
        localLayoutState1.mCurrentPosition += this.mLayoutState.mItemDirection;
        fill(paramRecycler, this.mLayoutState, paramState, false);
        i3 = this.mLayoutState.mOffset;
        if (this.mLayoutState.mAvailable <= 0)
          break label535;
        int i4 = this.mLayoutState.mAvailable;
        updateLayoutStateToFillEnd(i2, i1);
        this.mLayoutState.mExtra = i4;
        fill(paramRecycler, this.mLayoutState, paramState, false);
        i1 = this.mLayoutState.mOffset;
        break label535;
        int i5 = fixLayoutStartGap(i3, paramRecycler, paramState, true);
        int i6 = i3 + i5;
        int i7 = i1 + i5;
        int i8 = fixLayoutEndGap(i7, paramRecycler, paramState, false);
        i3 = i6 + i8;
        i1 = i7 + i8;
        break label604;
        this.mAnchorInfo.reset();
      }
    }
  }

  public void onLayoutCompleted(RecyclerView.State paramState)
  {
    super.onLayoutCompleted(paramState);
    this.mPendingSavedState = null;
    this.mPendingScrollPosition = -1;
    this.mPendingScrollPositionOffset = -2147483648;
    this.mAnchorInfo.reset();
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      this.mPendingSavedState = ((SavedState)paramParcelable);
      requestLayout();
    }
  }

  public Parcelable onSaveInstanceState()
  {
    if (this.mPendingSavedState != null)
      return new SavedState(this.mPendingSavedState);
    SavedState localSavedState = new SavedState();
    if (getChildCount() > 0)
    {
      ensureLayoutState();
      boolean bool = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
      localSavedState.mAnchorLayoutFromEnd = bool;
      if (bool)
      {
        View localView2 = getChildClosestToEnd();
        localSavedState.mAnchorOffset = (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(localView2));
        localSavedState.mAnchorPosition = getPosition(localView2);
        return localSavedState;
      }
      View localView1 = getChildClosestToStart();
      localSavedState.mAnchorPosition = getPosition(localView1);
      localSavedState.mAnchorOffset = (this.mOrientationHelper.getDecoratedStart(localView1) - this.mOrientationHelper.getStartAfterPadding());
      return localSavedState;
    }
    localSavedState.invalidateAnchor();
    return localSavedState;
  }

  public void prepareForDrop(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
    ensureLayoutState();
    resolveShouldLayoutReverse();
    int i = getPosition(paramView1);
    int j = getPosition(paramView2);
    int k;
    if (i < j)
      k = 1;
    while (this.mShouldReverseLayout)
      if (k == 1)
      {
        scrollToPositionWithOffset(j, this.mOrientationHelper.getEndAfterPadding() - (this.mOrientationHelper.getDecoratedStart(paramView2) + this.mOrientationHelper.getDecoratedMeasurement(paramView1)));
        return;
        k = -1;
      }
      else
      {
        scrollToPositionWithOffset(j, this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(paramView2));
        return;
      }
    if (k == -1)
    {
      scrollToPositionWithOffset(j, this.mOrientationHelper.getDecoratedStart(paramView2));
      return;
    }
    scrollToPositionWithOffset(j, this.mOrientationHelper.getDecoratedEnd(paramView2) - this.mOrientationHelper.getDecoratedMeasurement(paramView1));
  }

  boolean resolveIsInfinite()
  {
    return (this.mOrientationHelper.getMode() == 0) && (this.mOrientationHelper.getEnd() == 0);
  }

  int scrollBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if ((getChildCount() == 0) || (paramInt == 0))
      return 0;
    this.mLayoutState.mRecycle = true;
    ensureLayoutState();
    if (paramInt > 0);
    int j;
    int k;
    for (int i = 1; ; i = -1)
    {
      j = Math.abs(paramInt);
      updateLayoutState(i, j, true, paramState);
      k = this.mLayoutState.mScrollingOffset + fill(paramRecycler, this.mLayoutState, paramState, false);
      if (k >= 0)
        break;
      return 0;
    }
    if (j > k)
      paramInt = i * k;
    this.mOrientationHelper.offsetChildren(-paramInt);
    this.mLayoutState.mLastScrollDelta = paramInt;
    return paramInt;
  }

  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 1)
      return 0;
    return scrollBy(paramInt, paramRecycler, paramState);
  }

  public void scrollToPosition(int paramInt)
  {
    this.mPendingScrollPosition = paramInt;
    this.mPendingScrollPositionOffset = -2147483648;
    if (this.mPendingSavedState != null)
      this.mPendingSavedState.invalidateAnchor();
    requestLayout();
  }

  public void scrollToPositionWithOffset(int paramInt1, int paramInt2)
  {
    this.mPendingScrollPosition = paramInt1;
    this.mPendingScrollPositionOffset = paramInt2;
    if (this.mPendingSavedState != null)
      this.mPendingSavedState.invalidateAnchor();
    requestLayout();
  }

  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 0)
      return 0;
    return scrollBy(paramInt, paramRecycler, paramState);
  }

  public void setInitialPrefetchItemCount(int paramInt)
  {
    this.mInitialPrefetchItemCount = paramInt;
  }

  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1))
      throw new IllegalArgumentException("invalid orientation:" + paramInt);
    assertNotInLayoutOrScroll(null);
    if ((paramInt != this.mOrientation) || (this.mOrientationHelper == null))
    {
      this.mOrientationHelper = OrientationHelper.createOrientationHelper(this, paramInt);
      this.mAnchorInfo.mOrientationHelper = this.mOrientationHelper;
      this.mOrientation = paramInt;
      requestLayout();
    }
  }

  public void setRecycleChildrenOnDetach(boolean paramBoolean)
  {
    this.mRecycleChildrenOnDetach = paramBoolean;
  }

  public void setReverseLayout(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if (paramBoolean == this.mReverseLayout)
      return;
    this.mReverseLayout = paramBoolean;
    requestLayout();
  }

  public void setSmoothScrollbarEnabled(boolean paramBoolean)
  {
    this.mSmoothScrollbarEnabled = paramBoolean;
  }

  public void setStackFromEnd(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if (this.mStackFromEnd == paramBoolean)
      return;
    this.mStackFromEnd = paramBoolean;
    requestLayout();
  }

  boolean shouldMeasureTwice()
  {
    return (getHeightMode() != 1073741824) && (getWidthMode() != 1073741824) && (hasFlexibleChildInBothOrientations());
  }

  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
  {
    LinearSmoothScroller localLinearSmoothScroller = new LinearSmoothScroller(paramRecyclerView.getContext());
    localLinearSmoothScroller.setTargetPosition(paramInt);
    startSmoothScroll(localLinearSmoothScroller);
  }

  public boolean supportsPredictiveItemAnimations()
  {
    return (this.mPendingSavedState == null) && (this.mLastStackFromEnd == this.mStackFromEnd);
  }

  void validateChildOrder()
  {
    int i = 1;
    Log.d("LinearLayoutManager", "validating child count " + getChildCount());
    if (getChildCount() < i);
    while (true)
    {
      return;
      int k = getPosition(getChildAt(0));
      int m = this.mOrientationHelper.getDecoratedStart(getChildAt(0));
      int j;
      if (this.mShouldReverseLayout)
        for (int i3 = i; i3 < getChildCount(); i3++)
        {
          View localView2 = getChildAt(i3);
          int i4 = getPosition(localView2);
          int i5 = this.mOrientationHelper.getDecoratedStart(localView2);
          if (i4 < k)
          {
            logChildren();
            StringBuilder localStringBuilder2 = new StringBuilder().append("detected invalid position. loc invalid? ");
            if (i5 < m);
            while (true)
            {
              throw new RuntimeException(i);
              j = 0;
            }
          }
          if (i5 > m)
          {
            logChildren();
            throw new RuntimeException("detected invalid location");
          }
        }
      else
        for (int n = j; n < getChildCount(); n++)
        {
          View localView1 = getChildAt(n);
          int i1 = getPosition(localView1);
          int i2 = this.mOrientationHelper.getDecoratedStart(localView1);
          if (i1 < k)
          {
            logChildren();
            StringBuilder localStringBuilder1 = new StringBuilder().append("detected invalid position. loc invalid? ");
            if (i2 < m);
            while (true)
            {
              throw new RuntimeException(j);
              j = 0;
            }
          }
          if (i2 < m)
          {
            logChildren();
            throw new RuntimeException("detected invalid location");
          }
        }
    }
  }

  static class AnchorInfo
  {
    int mCoordinate;
    boolean mLayoutFromEnd;
    OrientationHelper mOrientationHelper;
    int mPosition;
    boolean mValid;

    AnchorInfo()
    {
      reset();
    }

    void assignCoordinateFromPadding()
    {
      if (this.mLayoutFromEnd);
      for (int i = this.mOrientationHelper.getEndAfterPadding(); ; i = this.mOrientationHelper.getStartAfterPadding())
      {
        this.mCoordinate = i;
        return;
      }
    }

    public void assignFromView(View paramView, int paramInt)
    {
      if (this.mLayoutFromEnd);
      for (this.mCoordinate = (this.mOrientationHelper.getDecoratedEnd(paramView) + this.mOrientationHelper.getTotalSpaceChange()); ; this.mCoordinate = this.mOrientationHelper.getDecoratedStart(paramView))
      {
        this.mPosition = paramInt;
        return;
      }
    }

    public void assignFromViewAndKeepVisibleRect(View paramView, int paramInt)
    {
      int i = this.mOrientationHelper.getTotalSpaceChange();
      if (i >= 0)
        assignFromView(paramView, paramInt);
      int k;
      int i1;
      do
      {
        int j;
        do
        {
          int i2;
          int i6;
          do
          {
            do
            {
              return;
              this.mPosition = paramInt;
              if (!this.mLayoutFromEnd)
                break;
              i2 = this.mOrientationHelper.getEndAfterPadding() - i - this.mOrientationHelper.getDecoratedEnd(paramView);
              this.mCoordinate = (this.mOrientationHelper.getEndAfterPadding() - i2);
            }
            while (i2 <= 0);
            int i3 = this.mOrientationHelper.getDecoratedMeasurement(paramView);
            int i4 = this.mCoordinate - i3;
            int i5 = this.mOrientationHelper.getStartAfterPadding();
            i6 = i4 - (i5 + Math.min(this.mOrientationHelper.getDecoratedStart(paramView) - i5, 0));
          }
          while (i6 >= 0);
          this.mCoordinate += Math.min(i2, -i6);
          return;
          j = this.mOrientationHelper.getDecoratedStart(paramView);
          k = j - this.mOrientationHelper.getStartAfterPadding();
          this.mCoordinate = j;
        }
        while (k <= 0);
        int m = j + this.mOrientationHelper.getDecoratedMeasurement(paramView);
        int n = this.mOrientationHelper.getEndAfterPadding() - i - this.mOrientationHelper.getDecoratedEnd(paramView);
        i1 = this.mOrientationHelper.getEndAfterPadding() - Math.min(0, n) - m;
      }
      while (i1 >= 0);
      this.mCoordinate -= Math.min(k, -i1);
    }

    boolean isViewValidAsAnchor(View paramView, RecyclerView.State paramState)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      return (!localLayoutParams.isItemRemoved()) && (localLayoutParams.getViewLayoutPosition() >= 0) && (localLayoutParams.getViewLayoutPosition() < paramState.getItemCount());
    }

    void reset()
    {
      this.mPosition = -1;
      this.mCoordinate = -2147483648;
      this.mLayoutFromEnd = false;
      this.mValid = false;
    }

    public String toString()
    {
      return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.mCoordinate + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + '}';
    }
  }

  protected static class LayoutChunkResult
  {
    public int mConsumed;
    public boolean mFinished;
    public boolean mFocusable;
    public boolean mIgnoreConsumed;

    void resetInternal()
    {
      this.mConsumed = 0;
      this.mFinished = false;
      this.mIgnoreConsumed = false;
      this.mFocusable = false;
    }
  }

  static class LayoutState
  {
    static final int INVALID_LAYOUT = -2147483648;
    static final int ITEM_DIRECTION_HEAD = -1;
    static final int ITEM_DIRECTION_TAIL = 1;
    static final int LAYOUT_END = 1;
    static final int LAYOUT_START = -1;
    static final int SCROLLING_OFFSET_NaN = -2147483648;
    static final String TAG = "LLM#LayoutState";
    int mAvailable;
    int mCurrentPosition;
    int mExtra = 0;
    boolean mInfinite;
    boolean mIsPreLayout = false;
    int mItemDirection;
    int mLastScrollDelta;
    int mLayoutDirection;
    int mOffset;
    boolean mRecycle = true;
    List<RecyclerView.ViewHolder> mScrapList = null;
    int mScrollingOffset;

    private View nextViewFromScrapList()
    {
      int i = this.mScrapList.size();
      int j = 0;
      if (j < i)
      {
        View localView = ((RecyclerView.ViewHolder)this.mScrapList.get(j)).itemView;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.isItemRemoved());
        while (this.mCurrentPosition != localLayoutParams.getViewLayoutPosition())
        {
          j++;
          break;
        }
        assignPositionFromScrapList(localView);
        return localView;
      }
      return null;
    }

    public void assignPositionFromScrapList()
    {
      assignPositionFromScrapList(null);
    }

    public void assignPositionFromScrapList(View paramView)
    {
      View localView = nextViewInLimitedList(paramView);
      if (localView == null)
      {
        this.mCurrentPosition = -1;
        return;
      }
      this.mCurrentPosition = ((RecyclerView.LayoutParams)localView.getLayoutParams()).getViewLayoutPosition();
    }

    boolean hasMore(RecyclerView.State paramState)
    {
      return (this.mCurrentPosition >= 0) && (this.mCurrentPosition < paramState.getItemCount());
    }

    void log()
    {
      Log.d("LLM#LayoutState", "avail:" + this.mAvailable + ", ind:" + this.mCurrentPosition + ", dir:" + this.mItemDirection + ", offset:" + this.mOffset + ", layoutDir:" + this.mLayoutDirection);
    }

    View next(RecyclerView.Recycler paramRecycler)
    {
      if (this.mScrapList != null)
        return nextViewFromScrapList();
      View localView = paramRecycler.getViewForPosition(this.mCurrentPosition);
      this.mCurrentPosition += this.mItemDirection;
      return localView;
    }

    public View nextViewInLimitedList(View paramView)
    {
      int i = this.mScrapList.size();
      Object localObject1 = null;
      int j = 2147483647;
      int k = 0;
      if (k < i)
      {
        View localView = ((RecyclerView.ViewHolder)this.mScrapList.get(k)).itemView;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        int m;
        Object localObject2;
        if (localView != paramView)
          if (localLayoutParams.isItemRemoved())
          {
            m = j;
            localObject2 = localObject1;
          }
        while (true)
        {
          k++;
          localObject1 = localObject2;
          j = m;
          break;
          m = (localLayoutParams.getViewLayoutPosition() - this.mCurrentPosition) * this.mItemDirection;
          if (m < 0)
          {
            m = j;
            localObject2 = localObject1;
          }
          else if (m < j)
          {
            if (m == 0)
              return localView;
            localObject2 = localView;
          }
          else
          {
            m = j;
            localObject2 = localObject1;
          }
        }
      }
      return localObject1;
    }
  }

  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public LinearLayoutManager.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new LinearLayoutManager.SavedState(paramAnonymousParcel);
      }

      public LinearLayoutManager.SavedState[] newArray(int paramAnonymousInt)
      {
        return new LinearLayoutManager.SavedState[paramAnonymousInt];
      }
    };
    boolean mAnchorLayoutFromEnd;
    int mAnchorOffset;
    int mAnchorPosition;

    public SavedState()
    {
    }

    SavedState(Parcel paramParcel)
    {
      this.mAnchorPosition = paramParcel.readInt();
      this.mAnchorOffset = paramParcel.readInt();
      if (paramParcel.readInt() == i);
      while (true)
      {
        this.mAnchorLayoutFromEnd = i;
        return;
        i = 0;
      }
    }

    public SavedState(SavedState paramSavedState)
    {
      this.mAnchorPosition = paramSavedState.mAnchorPosition;
      this.mAnchorOffset = paramSavedState.mAnchorOffset;
      this.mAnchorLayoutFromEnd = paramSavedState.mAnchorLayoutFromEnd;
    }

    public int describeContents()
    {
      return 0;
    }

    boolean hasValidAnchor()
    {
      return this.mAnchorPosition >= 0;
    }

    void invalidateAnchor()
    {
      this.mAnchorPosition = -1;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.mAnchorPosition);
      paramParcel.writeInt(this.mAnchorOffset);
      if (this.mAnchorLayoutFromEnd);
      for (int i = 1; ; i = 0)
      {
        paramParcel.writeInt(i);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager
 * JD-Core Version:    0.6.2
 */