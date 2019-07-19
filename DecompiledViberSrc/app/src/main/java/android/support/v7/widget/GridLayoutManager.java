package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager
{
  private static final boolean DEBUG = false;
  public static final int DEFAULT_SPAN_COUNT = -1;
  private static final String TAG = "GridLayoutManager";
  int[] mCachedBorders;
  final Rect mDecorInsets = new Rect();
  boolean mPendingSpanCountChange = false;
  final SparseIntArray mPreLayoutSpanIndexCache = new SparseIntArray();
  final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();
  View[] mSet;
  int mSpanCount = -1;
  SpanSizeLookup mSpanSizeLookup = new DefaultSpanSizeLookup();

  public GridLayoutManager(Context paramContext, int paramInt)
  {
    super(paramContext);
    setSpanCount(paramInt);
  }

  public GridLayoutManager(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramContext, paramInt2, paramBoolean);
    setSpanCount(paramInt1);
  }

  public GridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setSpanCount(getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2).spanCount);
  }

  private void assignSpans(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int k;
    int j;
    if (paramBoolean)
    {
      k = 1;
      j = 0;
    }
    while (true)
    {
      int m = 0;
      int n = j;
      while (n != paramInt1)
      {
        View localView = this.mSet[n];
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        localLayoutParams.mSpanSize = getSpanSize(paramRecycler, paramState, getPosition(localView));
        localLayoutParams.mSpanIndex = m;
        m += localLayoutParams.mSpanSize;
        n += k;
      }
      int i = paramInt1 - 1;
      paramInt1 = -1;
      j = i;
      k = -1;
    }
  }

  private void cachePreLayoutSpanMapping()
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      LayoutParams localLayoutParams = (LayoutParams)getChildAt(j).getLayoutParams();
      int k = localLayoutParams.getViewLayoutPosition();
      this.mPreLayoutSpanSizeCache.put(k, localLayoutParams.getSpanSize());
      this.mPreLayoutSpanIndexCache.put(k, localLayoutParams.getSpanIndex());
    }
  }

  private void calculateItemBorders(int paramInt)
  {
    this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, paramInt);
  }

  static int[] calculateItemBorders(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length != paramInt1 + 1) || (paramArrayOfInt[(-1 + paramArrayOfInt.length)] != paramInt2))
      paramArrayOfInt = new int[paramInt1 + 1];
    paramArrayOfInt[0] = 0;
    int j = paramInt2 / paramInt1;
    int k = paramInt2 % paramInt1;
    int m = 1;
    int n = 0;
    int i1;
    if (m <= paramInt1)
    {
      i += k;
      if ((i <= 0) || (paramInt1 - i >= k))
        break label104;
      i1 = j + 1;
      i -= paramInt1;
    }
    while (true)
    {
      n += i1;
      paramArrayOfInt[m] = n;
      m++;
      break;
      return paramArrayOfInt;
      label104: i1 = j;
    }
  }

  private void clearPreLayoutSpanMappingCache()
  {
    this.mPreLayoutSpanSizeCache.clear();
    this.mPreLayoutSpanIndexCache.clear();
  }

  private void ensureAnchorIsInCorrectSpan(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo, int paramInt)
  {
    int i = 1;
    if (paramInt == i);
    int j;
    while (true)
    {
      j = getSpanIndex(paramRecycler, paramState, paramAnchorInfo.mPosition);
      if (i == 0)
        break;
      while ((j > 0) && (paramAnchorInfo.mPosition > 0))
      {
        paramAnchorInfo.mPosition = (-1 + paramAnchorInfo.mPosition);
        j = getSpanIndex(paramRecycler, paramState, paramAnchorInfo.mPosition);
      }
      i = 0;
    }
    int k = -1 + paramState.getItemCount();
    int m = paramAnchorInfo.mPosition;
    int i1;
    for (int n = j; m < k; n = i1)
    {
      i1 = getSpanIndex(paramRecycler, paramState, m + 1);
      if (i1 <= n)
        break;
      m++;
    }
    paramAnchorInfo.mPosition = m;
  }

  private void ensureViewSet()
  {
    if ((this.mSet == null) || (this.mSet.length != this.mSpanCount))
      this.mSet = new View[this.mSpanCount];
  }

  private int getSpanGroupIndex(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    if (!paramState.isPreLayout())
      return this.mSpanSizeLookup.getSpanGroupIndex(paramInt, this.mSpanCount);
    int i = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1)
    {
      Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + paramInt);
      return 0;
    }
    return this.mSpanSizeLookup.getSpanGroupIndex(i, this.mSpanCount);
  }

  private int getSpanIndex(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    int i;
    if (!paramState.isPreLayout())
      i = this.mSpanSizeLookup.getCachedSpanIndex(paramInt, this.mSpanCount);
    do
    {
      return i;
      i = this.mPreLayoutSpanIndexCache.get(paramInt, -1);
    }
    while (i != -1);
    int j = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (j == -1)
    {
      Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + paramInt);
      return 0;
    }
    return this.mSpanSizeLookup.getCachedSpanIndex(j, this.mSpanCount);
  }

  private int getSpanSize(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    int i;
    if (!paramState.isPreLayout())
      i = this.mSpanSizeLookup.getSpanSize(paramInt);
    do
    {
      return i;
      i = this.mPreLayoutSpanSizeCache.get(paramInt, -1);
    }
    while (i != -1);
    int j = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (j == -1)
    {
      Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + paramInt);
      return 1;
    }
    return this.mSpanSizeLookup.getSpanSize(j);
  }

  private void guessMeasurement(float paramFloat, int paramInt)
  {
    calculateItemBorders(Math.max(Math.round(paramFloat * this.mSpanCount), paramInt));
  }

  private void measureChild(View paramView, int paramInt, boolean paramBoolean)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.mDecorInsets;
    int i = localRect.top + localRect.bottom + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
    int j = localRect.left + localRect.right + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
    int k = getSpaceForSpanRange(localLayoutParams.mSpanIndex, localLayoutParams.mSpanSize);
    int n;
    if (this.mOrientation == 1)
      n = getChildMeasureSpec(k, paramInt, j, localLayoutParams.width, false);
    int m;
    for (int i1 = getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), i, localLayoutParams.height, true); ; i1 = m)
    {
      measureChildWithDecorationsAndMargin(paramView, n, i1, paramBoolean);
      return;
      m = getChildMeasureSpec(k, paramInt, i, localLayoutParams.height, false);
      n = getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), j, localLayoutParams.width, true);
    }
  }

  private void measureChildWithDecorationsAndMargin(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    if (paramBoolean);
    for (boolean bool = shouldReMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams); ; bool = shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams))
    {
      if (bool)
        paramView.measure(paramInt1, paramInt2);
      return;
    }
  }

  private void updateMeasurements()
  {
    if (getOrientation() == 1);
    for (int i = getWidth() - getPaddingRight() - getPaddingLeft(); ; i = getHeight() - getPaddingBottom() - getPaddingTop())
    {
      calculateItemBorders(i);
      return;
    }
  }

  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }

  void collectPrefetchPositionsForLayoutState(RecyclerView.State paramState, LinearLayoutManager.LayoutState paramLayoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry)
  {
    int i = this.mSpanCount;
    for (int j = 0; (j < this.mSpanCount) && (paramLayoutState.hasMore(paramState)) && (i > 0); j++)
    {
      int k = paramLayoutState.mCurrentPosition;
      paramLayoutPrefetchRegistry.addPosition(k, Math.max(0, paramLayoutState.mScrollingOffset));
      i -= this.mSpanSizeLookup.getSpanSize(k);
      paramLayoutState.mCurrentPosition += paramLayoutState.mItemDirection;
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
        break label181;
      localObject3 = getChildAt(paramInt1);
      int m = getPosition((View)localObject3);
      if ((m < 0) || (m >= paramInt3))
        break label200;
      if (getSpanIndex(paramRecycler, paramState, m) == 0)
        break label111;
      localObject4 = localObject1;
      localObject3 = localObject2;
    }
    label181: label200: 
    while (true)
    {
      paramInt1 += k;
      localObject1 = localObject4;
      localObject2 = localObject3;
      break label37;
      k = -1;
      break;
      label111: if (((RecyclerView.LayoutParams)((View)localObject3).getLayoutParams()).isItemRemoved())
      {
        if (localObject2 == null)
          localObject4 = localObject1;
      }
      else if ((this.mOrientationHelper.getDecoratedStart((View)localObject3) >= j) || (this.mOrientationHelper.getDecoratedEnd((View)localObject3) < i))
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

  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    if (this.mOrientation == 0)
      return new LayoutParams(-2, -1);
    return new LayoutParams(-1, -2);
  }

  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new LayoutParams(paramContext, paramAttributeSet);
  }

  public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    return new LayoutParams(paramLayoutParams);
  }

  public int getColumnCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 1)
      return this.mSpanCount;
    if (paramState.getItemCount() < 1)
      return 0;
    return 1 + getSpanGroupIndex(paramRecycler, paramState, -1 + paramState.getItemCount());
  }

  public int getRowCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 0)
      return this.mSpanCount;
    if (paramState.getItemCount() < 1)
      return 0;
    return 1 + getSpanGroupIndex(paramRecycler, paramState, -1 + paramState.getItemCount());
  }

  int getSpaceForSpanRange(int paramInt1, int paramInt2)
  {
    if ((this.mOrientation == 1) && (isLayoutRTL()))
      return this.mCachedBorders[(this.mSpanCount - paramInt1)] - this.mCachedBorders[(this.mSpanCount - paramInt1 - paramInt2)];
    return this.mCachedBorders[(paramInt1 + paramInt2)] - this.mCachedBorders[paramInt1];
  }

  public int getSpanCount()
  {
    return this.mSpanCount;
  }

  public SpanSizeLookup getSpanSizeLookup()
  {
    return this.mSpanSizeLookup;
  }

  void layoutChunk(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.LayoutState paramLayoutState, LinearLayoutManager.LayoutChunkResult paramLayoutChunkResult)
  {
    int i = this.mOrientationHelper.getModeInOther();
    int j;
    int k;
    label38: boolean bool;
    label58: int m;
    int n;
    int i1;
    if (i != 1073741824)
    {
      j = 1;
      if (getChildCount() <= 0)
        break label210;
      k = this.mCachedBorders[this.mSpanCount];
      if (j != 0)
        updateMeasurements();
      if (paramLayoutState.mItemDirection != 1)
        break label216;
      bool = true;
      m = this.mSpanCount;
      n = 0;
      i1 = 0;
      if (!bool)
        m = getSpanIndex(paramRecycler, paramState, paramLayoutState.mCurrentPosition) + getSpanSize(paramRecycler, paramState, paramLayoutState.mCurrentPosition);
    }
    while (true)
    {
      int i26;
      if ((n < this.mSpanCount) && (paramLayoutState.hasMore(paramState)) && (m > 0))
      {
        int i25 = paramLayoutState.mCurrentPosition;
        i26 = getSpanSize(paramRecycler, paramState, i25);
        if (i26 > this.mSpanCount)
        {
          throw new IllegalArgumentException("Item at position " + i25 + " requires " + i26 + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
          j = 0;
          break;
          label210: k = 0;
          break label38;
          label216: bool = false;
          break label58;
        }
        m -= i26;
        if (m >= 0)
          break label246;
      }
      label246: View localView5;
      do
      {
        if (n != 0)
          break;
        paramLayoutChunkResult.mFinished = true;
        return;
        localView5 = paramLayoutState.next(paramRecycler);
      }
      while (localView5 == null);
      i1 += i26;
      this.mSet[n] = localView5;
      n++;
    }
    assignSpans(paramRecycler, paramState, n, i1, bool);
    int i2 = 0;
    float f1 = 0.0F;
    int i3 = 0;
    View localView4;
    label335: float f2;
    if (i2 < n)
    {
      localView4 = this.mSet[i2];
      if (paramLayoutState.mScrapList == null)
        if (bool)
        {
          addView(localView4);
          calculateItemDecorationsForChild(localView4, this.mDecorInsets);
          measureChild(localView4, i, false);
          int i24 = this.mOrientationHelper.getDecoratedMeasurement(localView4);
          if (i24 > i3)
            i3 = i24;
          LayoutParams localLayoutParams3 = (LayoutParams)localView4.getLayoutParams();
          f2 = 1.0F * this.mOrientationHelper.getDecoratedMeasurementInOther(localView4) / localLayoutParams3.mSpanSize;
          if (f2 <= f1)
            break label1104;
        }
    }
    while (true)
    {
      i2++;
      f1 = f2;
      break;
      addView(localView4, 0);
      break label335;
      if (bool)
      {
        addDisappearingView(localView4);
        break label335;
      }
      addDisappearingView(localView4, 0);
      break label335;
      int i22;
      int i23;
      if (j != 0)
      {
        guessMeasurement(f1, k);
        i3 = 0;
        i22 = 0;
        if (i22 < n)
        {
          View localView3 = this.mSet[i22];
          measureChild(localView3, 1073741824, true);
          i23 = this.mOrientationHelper.getDecoratedMeasurement(localView3);
          if (i23 <= i3)
            break label1097;
        }
      }
      while (true)
      {
        i22++;
        i3 = i23;
        break;
        int i4 = 0;
        if (i4 < n)
        {
          View localView2 = this.mSet[i4];
          LayoutParams localLayoutParams2;
          int i17;
          int i18;
          int i19;
          int i20;
          if (this.mOrientationHelper.getDecoratedMeasurement(localView2) != i3)
          {
            localLayoutParams2 = (LayoutParams)localView2.getLayoutParams();
            Rect localRect = localLayoutParams2.mDecorInsets;
            i17 = localRect.top + localRect.bottom + localLayoutParams2.topMargin + localLayoutParams2.bottomMargin;
            i18 = localRect.left + localRect.right + localLayoutParams2.leftMargin + localLayoutParams2.rightMargin;
            i19 = getSpaceForSpanRange(localLayoutParams2.mSpanIndex, localLayoutParams2.mSpanSize);
            if (this.mOrientation != 1)
              break label704;
            i20 = getChildMeasureSpec(i19, 1073741824, i18, localLayoutParams2.width, false);
          }
          for (int i21 = View.MeasureSpec.makeMeasureSpec(i3 - i17, 1073741824); ; i21 = getChildMeasureSpec(i19, 1073741824, i17, localLayoutParams2.height, false))
          {
            measureChildWithDecorationsAndMargin(localView2, i20, i21, true);
            i4++;
            break;
            label704: i20 = View.MeasureSpec.makeMeasureSpec(i3 - i18, 1073741824);
          }
        }
        paramLayoutChunkResult.mConsumed = i3;
        int i7;
        int i8;
        int i6;
        int i5;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        label799: View localView1;
        LayoutParams localLayoutParams1;
        if (this.mOrientation == 1)
          if (paramLayoutState.mLayoutDirection == -1)
          {
            i7 = paramLayoutState.mOffset;
            i8 = i7 - i3;
            i6 = 0;
            i5 = 0;
            i9 = i7;
            i10 = i8;
            i11 = i6;
            i12 = i5;
            i13 = 0;
            if (i13 >= n)
              break label1088;
            localView1 = this.mSet[i13];
            localLayoutParams1 = (LayoutParams)localView1.getLayoutParams();
            if (this.mOrientation != 1)
              break label1054;
            if (!isLayoutRTL())
              break label1020;
            i11 = getPaddingLeft() + this.mCachedBorders[(this.mSpanCount - localLayoutParams1.mSpanIndex)];
            i12 = i11 - this.mOrientationHelper.getDecoratedMeasurementInOther(localView1);
          }
        while (true)
        {
          layoutDecoratedWithMargins(localView1, i12, i10, i11, i9);
          if ((localLayoutParams1.isItemRemoved()) || (localLayoutParams1.isItemChanged()))
            paramLayoutChunkResult.mIgnoreConsumed = true;
          paramLayoutChunkResult.mFocusable |= localView1.hasFocusable();
          i13++;
          break label799;
          int i16 = paramLayoutState.mOffset;
          i7 = i16 + i3;
          i8 = i16;
          i6 = 0;
          i5 = 0;
          break;
          if (paramLayoutState.mLayoutDirection == -1)
          {
            int i14 = paramLayoutState.mOffset;
            int i15 = i14 - i3;
            i6 = i14;
            i5 = i15;
            i7 = 0;
            i8 = 0;
            break;
          }
          i5 = paramLayoutState.mOffset;
          i6 = i3 + i5;
          i7 = 0;
          i8 = 0;
          break;
          label1020: i12 = getPaddingLeft() + this.mCachedBorders[localLayoutParams1.mSpanIndex];
          i11 = i12 + this.mOrientationHelper.getDecoratedMeasurementInOther(localView1);
          continue;
          label1054: i10 = getPaddingTop() + this.mCachedBorders[localLayoutParams1.mSpanIndex];
          i9 = i10 + this.mOrientationHelper.getDecoratedMeasurementInOther(localView1);
        }
        label1088: Arrays.fill(this.mSet, null);
        return;
        label1097: i23 = i3;
      }
      label1104: f2 = f1;
    }
  }

  void onAnchorReady(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo, int paramInt)
  {
    super.onAnchorReady(paramRecycler, paramState, paramAnchorInfo, paramInt);
    updateMeasurements();
    if ((paramState.getItemCount() > 0) && (!paramState.isPreLayout()))
      ensureAnchorIsInCorrectSpan(paramRecycler, paramState, paramAnchorInfo, paramInt);
    ensureViewSet();
  }

  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    View localView1 = findContainingItemView(paramView);
    View localView2;
    if (localView1 == null)
    {
      localView2 = null;
      return localView2;
    }
    LayoutParams localLayoutParams1 = (LayoutParams)localView1.getLayoutParams();
    int i = localLayoutParams1.mSpanIndex;
    int j = localLayoutParams1.mSpanIndex + localLayoutParams1.mSpanSize;
    if (super.onFocusSearchFailed(paramView, paramInt, paramRecycler, paramState) == null)
      return null;
    int k;
    label74: int m;
    label86: int i3;
    int i1;
    int i2;
    label105: int i4;
    label123: Object localObject1;
    int i5;
    int i6;
    Object localObject2;
    int i7;
    int i8;
    int i9;
    int i10;
    label156: int i11;
    if (convertFocusDirectionToLayoutDirection(paramInt) == 1)
    {
      k = 1;
      if (k == this.mShouldReverseLayout)
        break label203;
      m = 1;
      if (m == 0)
        break label209;
      i3 = -1 + getChildCount();
      i1 = -1;
      i2 = -1;
      if ((this.mOrientation != 1) || (!isLayoutRTL()))
        break label228;
      i4 = 1;
      localObject1 = null;
      i5 = -1;
      i6 = 0;
      localObject2 = null;
      i7 = -1;
      i8 = 0;
      i9 = getSpanGroupIndex(paramRecycler, paramState, i3);
      i10 = i3;
      if (i10 != i2)
      {
        i11 = getSpanGroupIndex(paramRecycler, paramState, i10);
        localView2 = getChildAt(i10);
        if (localView2 != localView1)
          break label234;
      }
      label189: if (localObject1 == null)
        break label677;
    }
    while (true)
    {
      return localObject1;
      k = 0;
      break label74;
      label203: m = 0;
      break label86;
      label209: int n = getChildCount();
      i1 = 1;
      i2 = n;
      i3 = 0;
      break label105;
      label228: i4 = 0;
      break label123;
      label234: int i20;
      int i22;
      int i19;
      Object localObject3;
      int i21;
      Object localObject4;
      if ((localView2.hasFocusable()) && (i11 != i9))
      {
        if (localObject1 != null)
          break label189;
        i20 = i8;
        i22 = i5;
        i19 = i7;
        localObject3 = localObject2;
        i21 = i6;
        localObject4 = localObject1;
      }
      while (true)
      {
        i10 += i1;
        localObject1 = localObject4;
        i6 = i21;
        i5 = i22;
        localObject2 = localObject3;
        i7 = i19;
        i8 = i20;
        break label156;
        LayoutParams localLayoutParams2 = (LayoutParams)localView2.getLayoutParams();
        int i12 = localLayoutParams2.mSpanIndex;
        int i13 = localLayoutParams2.mSpanIndex + localLayoutParams2.mSpanSize;
        if ((localView2.hasFocusable()) && (i12 == i) && (i13 == j))
          break;
        int i16;
        if (((localView2.hasFocusable()) && (localObject1 == null)) || ((!localView2.hasFocusable()) && (localObject2 == null)))
          i16 = 1;
        while (true)
          label393: if (i16 != 0)
          {
            if (!localView2.hasFocusable())
              break label634;
            int i23 = localLayoutParams2.mSpanIndex;
            int i24 = Math.min(i13, j) - Math.max(i12, i);
            int i25 = i8;
            i19 = i7;
            localObject3 = localObject2;
            i21 = i24;
            i20 = i25;
            localObject4 = localView2;
            i22 = i23;
            break;
            int i14 = Math.max(i12, i);
            int i15 = Math.min(i13, j) - i14;
            if (localView2.hasFocusable())
            {
              if (i15 > i6)
              {
                i16 = 1;
              }
              else
              {
                i16 = 0;
                if (i15 == i6)
                {
                  if (i12 > i5);
                  for (int i26 = 1; ; i26 = 0)
                  {
                    int i27 = i26;
                    i16 = 0;
                    if (i4 != i27)
                      break;
                    i16 = 1;
                    break;
                  }
                }
              }
            }
            else
            {
              i16 = 0;
              if (localObject1 == null)
              {
                boolean bool = isViewPartiallyVisible(localView2, false, true);
                i16 = 0;
                if (bool)
                  if (i15 > i8)
                  {
                    i16 = 1;
                  }
                  else
                  {
                    i16 = 0;
                    if (i15 == i8)
                      if (i12 <= i7)
                        break label628;
                  }
              }
            }
          }
        label628: for (int i17 = 1; ; i17 = 0)
        {
          int i18 = i17;
          i16 = 0;
          if (i4 != i18)
            break label393;
          i16 = 1;
          break label393;
          break;
        }
        label634: i19 = localLayoutParams2.mSpanIndex;
        i20 = Math.min(i13, j) - Math.max(i12, i);
        localObject3 = localView2;
        i21 = i6;
        i22 = i5;
        localObject4 = localObject1;
      }
      label677: localObject1 = localObject2;
    }
  }

  public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof LayoutParams))
    {
      super.onInitializeAccessibilityNodeInfoForItem(paramView, paramAccessibilityNodeInfoCompat);
      return;
    }
    LayoutParams localLayoutParams1 = (LayoutParams)localLayoutParams;
    int i = getSpanGroupIndex(paramRecycler, paramState, localLayoutParams1.getViewLayoutPosition());
    if (this.mOrientation == 0)
    {
      int m = localLayoutParams1.getSpanIndex();
      int n = localLayoutParams1.getSpanSize();
      if ((this.mSpanCount > 1) && (localLayoutParams1.getSpanSize() == this.mSpanCount));
      for (boolean bool2 = true; ; bool2 = false)
      {
        paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(m, n, i, 1, bool2, false));
        return;
      }
    }
    int j = localLayoutParams1.getSpanIndex();
    int k = localLayoutParams1.getSpanSize();
    if ((this.mSpanCount > 1) && (localLayoutParams1.getSpanSize() == this.mSpanCount));
    for (boolean bool1 = true; ; bool1 = false)
    {
      paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i, 1, j, k, bool1, false));
      return;
    }
  }

  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }

  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }

  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }

  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }

  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }

  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (paramState.isPreLayout())
      cachePreLayoutSpanMapping();
    super.onLayoutChildren(paramRecycler, paramState);
    clearPreLayoutSpanMappingCache();
  }

  public void onLayoutCompleted(RecyclerView.State paramState)
  {
    super.onLayoutCompleted(paramState);
    this.mPendingSpanCountChange = false;
  }

  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    updateMeasurements();
    ensureViewSet();
    return super.scrollHorizontallyBy(paramInt, paramRecycler, paramState);
  }

  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    updateMeasurements();
    ensureViewSet();
    return super.scrollVerticallyBy(paramInt, paramRecycler, paramState);
  }

  public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
  {
    if (this.mCachedBorders == null)
      super.setMeasuredDimension(paramRect, paramInt1, paramInt2);
    int i = getPaddingLeft() + getPaddingRight();
    int j = getPaddingTop() + getPaddingBottom();
    int m;
    int k;
    if (this.mOrientation == 1)
    {
      m = chooseSize(paramInt2, j + paramRect.height(), getMinimumHeight());
      k = chooseSize(paramInt1, i + this.mCachedBorders[(-1 + this.mCachedBorders.length)], getMinimumWidth());
    }
    while (true)
    {
      setMeasuredDimension(k, m);
      return;
      k = chooseSize(paramInt1, i + paramRect.width(), getMinimumWidth());
      m = chooseSize(paramInt2, j + this.mCachedBorders[(-1 + this.mCachedBorders.length)], getMinimumHeight());
    }
  }

  public void setSpanCount(int paramInt)
  {
    if (paramInt == this.mSpanCount)
      return;
    this.mPendingSpanCountChange = true;
    if (paramInt < 1)
      throw new IllegalArgumentException("Span count should be at least 1. Provided " + paramInt);
    this.mSpanCount = paramInt;
    this.mSpanSizeLookup.invalidateSpanIndexCache();
    requestLayout();
  }

  public void setSpanSizeLookup(SpanSizeLookup paramSpanSizeLookup)
  {
    this.mSpanSizeLookup = paramSpanSizeLookup;
  }

  public void setStackFromEnd(boolean paramBoolean)
  {
    if (paramBoolean)
      throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    super.setStackFromEnd(false);
  }

  public boolean supportsPredictiveItemAnimations()
  {
    return (this.mPendingSavedState == null) && (!this.mPendingSpanCountChange);
  }

  public static final class DefaultSpanSizeLookup extends GridLayoutManager.SpanSizeLookup
  {
    public int getSpanIndex(int paramInt1, int paramInt2)
    {
      return paramInt1 % paramInt2;
    }

    public int getSpanSize(int paramInt)
    {
      return 1;
    }
  }

  public static class LayoutParams extends RecyclerView.LayoutParams
  {
    public static final int INVALID_SPAN_ID = -1;
    int mSpanIndex = -1;
    int mSpanSize = 0;

    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }

    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }

    public LayoutParams(RecyclerView.LayoutParams paramLayoutParams)
    {
      super();
    }

    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }

    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }

    public int getSpanIndex()
    {
      return this.mSpanIndex;
    }

    public int getSpanSize()
    {
      return this.mSpanSize;
    }
  }

  public static abstract class SpanSizeLookup
  {
    private boolean mCacheSpanIndices = false;
    final SparseIntArray mSpanIndexCache = new SparseIntArray();

    int findReferenceIndexFromCache(int paramInt)
    {
      int i = 0;
      int j = -1 + this.mSpanIndexCache.size();
      while (i <= j)
      {
        int m = i + j >>> 1;
        if (this.mSpanIndexCache.keyAt(m) < paramInt)
          i = m + 1;
        else
          j = m - 1;
      }
      int k = i - 1;
      if ((k >= 0) && (k < this.mSpanIndexCache.size()))
        return this.mSpanIndexCache.keyAt(k);
      return -1;
    }

    int getCachedSpanIndex(int paramInt1, int paramInt2)
    {
      int i;
      if (!this.mCacheSpanIndices)
        i = getSpanIndex(paramInt1, paramInt2);
      do
      {
        return i;
        i = this.mSpanIndexCache.get(paramInt1, -1);
      }
      while (i != -1);
      int j = getSpanIndex(paramInt1, paramInt2);
      this.mSpanIndexCache.put(paramInt1, j);
      return j;
    }

    public int getSpanGroupIndex(int paramInt1, int paramInt2)
    {
      int i = getSpanSize(paramInt1);
      int j = 0;
      int k = 0;
      int m = 0;
      int n;
      int i1;
      if (j < paramInt1)
      {
        n = getSpanSize(j);
        i1 = m + n;
        if (i1 == paramInt2)
        {
          k++;
          n = 0;
        }
      }
      while (true)
      {
        j++;
        m = n;
        break;
        if (i1 > paramInt2)
        {
          k++;
          continue;
          if (m + i > paramInt2)
            k++;
          return k;
        }
        else
        {
          n = i1;
        }
      }
    }

    public int getSpanIndex(int paramInt1, int paramInt2)
    {
      int i = getSpanSize(paramInt1);
      if (i == paramInt2)
        return 0;
      int k;
      int j;
      if ((this.mCacheSpanIndices) && (this.mSpanIndexCache.size() > 0))
      {
        int i2 = findReferenceIndexFromCache(paramInt1);
        if (i2 >= 0)
        {
          k = this.mSpanIndexCache.get(i2) + getSpanSize(i2);
          j = i2 + 1;
        }
      }
      while (true)
      {
        int m = j;
        if (m < paramInt1)
        {
          int n = getSpanSize(m);
          int i1 = k + n;
          if (i1 == paramInt2)
            n = 0;
          while (true)
          {
            m++;
            k = n;
            break;
            if (i1 <= paramInt2)
              n = i1;
          }
        }
        if (k + i > paramInt2)
          break;
        return k;
        j = 0;
        k = 0;
      }
    }

    public abstract int getSpanSize(int paramInt);

    public void invalidateSpanIndexCache()
    {
      this.mSpanIndexCache.clear();
    }

    public boolean isSpanIndexCacheEnabled()
    {
      return this.mCacheSpanIndices;
    }

    public void setSpanIndexCacheEnabled(boolean paramBoolean)
    {
      this.mCacheSpanIndices = paramBoolean;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.GridLayoutManager
 * JD-Core Version:    0.6.2
 */