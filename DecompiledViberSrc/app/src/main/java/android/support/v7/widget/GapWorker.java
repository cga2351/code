package android.support.v7.widget;

import android.support.v4.os.TraceCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class GapWorker
  implements Runnable
{
  static final ThreadLocal<GapWorker> sGapWorker = new ThreadLocal();
  static Comparator<Task> sTaskComparator = new Comparator()
  {
    public int compare(GapWorker.Task paramAnonymousTask1, GapWorker.Task paramAnonymousTask2)
    {
      int i = -1;
      int j = 1;
      int k;
      int m;
      if (paramAnonymousTask1.view == null)
      {
        k = j;
        if (paramAnonymousTask2.view != null)
          break label50;
        m = j;
        label27: if (k == m)
          break label58;
        if (paramAnonymousTask1.view != null)
          break label56;
      }
      label50: label56: label58: 
      do
      {
        do
        {
          return j;
          k = 0;
          break;
          m = 0;
          break label27;
          return i;
          if (paramAnonymousTask1.immediate != paramAnonymousTask2.immediate)
          {
            if (paramAnonymousTask1.immediate);
            while (true)
            {
              return i;
              i = j;
            }
          }
          j = paramAnonymousTask2.viewVelocity - paramAnonymousTask1.viewVelocity;
        }
        while (j != 0);
        j = paramAnonymousTask1.distanceToItem - paramAnonymousTask2.distanceToItem;
      }
      while (j != 0);
      return 0;
    }
  };
  long mFrameIntervalNs;
  long mPostTimeNs;
  ArrayList<RecyclerView> mRecyclerViews = new ArrayList();
  private ArrayList<Task> mTasks = new ArrayList();

  private void buildTaskList()
  {
    int i = this.mRecyclerViews.size();
    int j = 0;
    int k = 0;
    RecyclerView localRecyclerView2;
    if (j < i)
    {
      localRecyclerView2 = (RecyclerView)this.mRecyclerViews.get(j);
      if (localRecyclerView2.getWindowVisibility() != 0)
        break label307;
      localRecyclerView2.mPrefetchRegistry.collectPrefetchPositionsFromView(localRecyclerView2, false);
    }
    label283: label307: for (int i5 = k + localRecyclerView2.mPrefetchRegistry.mCount; ; i5 = k)
    {
      j++;
      k = i5;
      break;
      this.mTasks.ensureCapacity(k);
      int m = 0;
      int n = 0;
      RecyclerView localRecyclerView1;
      if (m < i)
      {
        localRecyclerView1 = (RecyclerView)this.mRecyclerViews.get(m);
        if (localRecyclerView1.getWindowVisibility() == 0);
      }
      while (true)
      {
        m++;
        break;
        LayoutPrefetchRegistryImpl localLayoutPrefetchRegistryImpl = localRecyclerView1.mPrefetchRegistry;
        int i1 = Math.abs(localLayoutPrefetchRegistryImpl.mPrefetchDx) + Math.abs(localLayoutPrefetchRegistryImpl.mPrefetchDy);
        int i2 = 0;
        int i3 = n;
        if (i2 < 2 * localLayoutPrefetchRegistryImpl.mCount)
        {
          Task localTask;
          label194: int i4;
          if (i3 >= this.mTasks.size())
          {
            localTask = new Task();
            this.mTasks.add(localTask);
            i4 = localLayoutPrefetchRegistryImpl.mPrefetchArray[(i2 + 1)];
            if (i4 > i1)
              break label283;
          }
          for (boolean bool = true; ; bool = false)
          {
            localTask.immediate = bool;
            localTask.viewVelocity = i1;
            localTask.distanceToItem = i4;
            localTask.view = localRecyclerView1;
            localTask.position = localLayoutPrefetchRegistryImpl.mPrefetchArray[i2];
            i3++;
            i2 += 2;
            break;
            localTask = (Task)this.mTasks.get(i3);
            break label194;
          }
          Collections.sort(this.mTasks, sTaskComparator);
          return;
        }
        n = i3;
      }
    }
  }

  private void flushTaskWithDeadline(Task paramTask, long paramLong)
  {
    if (paramTask.immediate);
    for (long l = 9223372036854775807L; ; l = paramLong)
    {
      RecyclerView.ViewHolder localViewHolder = prefetchPositionWithDeadline(paramTask.view, paramTask.position, l);
      if ((localViewHolder != null) && (localViewHolder.mNestedRecyclerView != null) && (localViewHolder.isBound()) && (!localViewHolder.isInvalid()))
        prefetchInnerRecyclerViewWithDeadline((RecyclerView)localViewHolder.mNestedRecyclerView.get(), paramLong);
      return;
    }
  }

  private void flushTasksWithDeadline(long paramLong)
  {
    for (int i = 0; ; i++)
    {
      Task localTask;
      if (i < this.mTasks.size())
      {
        localTask = (Task)this.mTasks.get(i);
        if (localTask.view != null);
      }
      else
      {
        return;
      }
      flushTaskWithDeadline(localTask, paramLong);
      localTask.clear();
    }
  }

  static boolean isPrefetchPositionAttached(RecyclerView paramRecyclerView, int paramInt)
  {
    int i = paramRecyclerView.mChildHelper.getUnfilteredChildCount();
    for (int j = 0; ; j++)
    {
      boolean bool = false;
      if (j < i)
      {
        RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramRecyclerView.mChildHelper.getUnfilteredChildAt(j));
        if ((localViewHolder.mPosition == paramInt) && (!localViewHolder.isInvalid()))
          bool = true;
      }
      else
      {
        return bool;
      }
    }
  }

  private void prefetchInnerRecyclerViewWithDeadline(RecyclerView paramRecyclerView, long paramLong)
  {
    if (paramRecyclerView == null);
    LayoutPrefetchRegistryImpl localLayoutPrefetchRegistryImpl;
    do
    {
      return;
      if ((paramRecyclerView.mDataSetHasChangedAfterLayout) && (paramRecyclerView.mChildHelper.getUnfilteredChildCount() != 0))
        paramRecyclerView.removeAndRecycleViews();
      localLayoutPrefetchRegistryImpl = paramRecyclerView.mPrefetchRegistry;
      localLayoutPrefetchRegistryImpl.collectPrefetchPositionsFromView(paramRecyclerView, true);
    }
    while (localLayoutPrefetchRegistryImpl.mCount == 0);
    try
    {
      TraceCompat.beginSection("RV Nested Prefetch");
      paramRecyclerView.mState.prepareForNestedPrefetch(paramRecyclerView.mAdapter);
      for (int i = 0; i < 2 * localLayoutPrefetchRegistryImpl.mCount; i += 2)
        prefetchPositionWithDeadline(paramRecyclerView, localLayoutPrefetchRegistryImpl.mPrefetchArray[i], paramLong);
      return;
    }
    finally
    {
      TraceCompat.endSection();
    }
  }

  private RecyclerView.ViewHolder prefetchPositionWithDeadline(RecyclerView paramRecyclerView, int paramInt, long paramLong)
  {
    if (isPrefetchPositionAttached(paramRecyclerView, paramInt))
      return null;
    RecyclerView.Recycler localRecycler = paramRecyclerView.mRecycler;
    try
    {
      paramRecyclerView.onEnterLayoutOrScroll();
      RecyclerView.ViewHolder localViewHolder = localRecycler.tryGetViewHolderForPositionByDeadline(paramInt, false, paramLong);
      if (localViewHolder != null)
      {
        if ((!localViewHolder.isBound()) || (localViewHolder.isInvalid()))
          break label69;
        localRecycler.recycleView(localViewHolder.itemView);
      }
      while (true)
      {
        return localViewHolder;
        label69: localRecycler.addViewHolderToRecycledViewPool(localViewHolder, false);
      }
    }
    finally
    {
      paramRecyclerView.onExitLayoutOrScroll(false);
    }
  }

  public void add(RecyclerView paramRecyclerView)
  {
    this.mRecyclerViews.add(paramRecyclerView);
  }

  void postFromTraversal(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramRecyclerView.isAttachedToWindow()) && (this.mPostTimeNs == 0L))
    {
      this.mPostTimeNs = paramRecyclerView.getNanoTime();
      paramRecyclerView.post(this);
    }
    paramRecyclerView.mPrefetchRegistry.setPrefetchVector(paramInt1, paramInt2);
  }

  void prefetch(long paramLong)
  {
    buildTaskList();
    flushTasksWithDeadline(paramLong);
  }

  public void remove(RecyclerView paramRecyclerView)
  {
    this.mRecyclerViews.remove(paramRecyclerView);
  }

  public void run()
  {
    while (true)
    {
      long l1;
      try
      {
        TraceCompat.beginSection("RV Prefetch");
        boolean bool = this.mRecyclerViews.isEmpty();
        if (bool)
          return;
        int i = this.mRecyclerViews.size();
        int j = 0;
        l1 = 0L;
        if (j < i)
        {
          RecyclerView localRecyclerView = (RecyclerView)this.mRecyclerViews.get(j);
          if (localRecyclerView.getWindowVisibility() != 0)
            break label148;
          long l3 = Math.max(localRecyclerView.getDrawingTime(), l1);
          l2 = l3;
          j++;
          l1 = l2;
          continue;
        }
        if (l1 == 0L)
          return;
        prefetch(TimeUnit.MILLISECONDS.toNanos(l1) + this.mFrameIntervalNs);
        return;
      }
      finally
      {
        this.mPostTimeNs = 0L;
        TraceCompat.endSection();
      }
      label148: long l2 = l1;
    }
  }

  static class LayoutPrefetchRegistryImpl
    implements RecyclerView.LayoutManager.LayoutPrefetchRegistry
  {
    int mCount;
    int[] mPrefetchArray;
    int mPrefetchDx;
    int mPrefetchDy;

    public void addPosition(int paramInt1, int paramInt2)
    {
      if (paramInt1 < 0)
        throw new IllegalArgumentException("Layout positions must be non-negative");
      if (paramInt2 < 0)
        throw new IllegalArgumentException("Pixel distance must be non-negative");
      int i = 2 * this.mCount;
      if (this.mPrefetchArray == null)
      {
        this.mPrefetchArray = new int[4];
        Arrays.fill(this.mPrefetchArray, -1);
      }
      while (true)
      {
        this.mPrefetchArray[i] = paramInt1;
        this.mPrefetchArray[(i + 1)] = paramInt2;
        this.mCount = (1 + this.mCount);
        return;
        if (i >= this.mPrefetchArray.length)
        {
          int[] arrayOfInt = this.mPrefetchArray;
          this.mPrefetchArray = new int[i * 2];
          System.arraycopy(arrayOfInt, 0, this.mPrefetchArray, 0, arrayOfInt.length);
        }
      }
    }

    void clearPrefetchPositions()
    {
      if (this.mPrefetchArray != null)
        Arrays.fill(this.mPrefetchArray, -1);
      this.mCount = 0;
    }

    void collectPrefetchPositionsFromView(RecyclerView paramRecyclerView, boolean paramBoolean)
    {
      this.mCount = 0;
      if (this.mPrefetchArray != null)
        Arrays.fill(this.mPrefetchArray, -1);
      RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.mLayout;
      if ((paramRecyclerView.mAdapter != null) && (localLayoutManager != null) && (localLayoutManager.isItemPrefetchEnabled()))
      {
        if (!paramBoolean)
          break label101;
        if (!paramRecyclerView.mAdapterHelper.hasPendingUpdates())
          localLayoutManager.collectInitialPrefetchPositions(paramRecyclerView.mAdapter.getItemCount(), this);
      }
      while (true)
      {
        if (this.mCount > localLayoutManager.mPrefetchMaxCountObserved)
        {
          localLayoutManager.mPrefetchMaxCountObserved = this.mCount;
          localLayoutManager.mPrefetchMaxObservedInInitialPrefetch = paramBoolean;
          paramRecyclerView.mRecycler.updateViewCacheSize();
        }
        return;
        label101: if (!paramRecyclerView.hasPendingAdapterUpdates())
          localLayoutManager.collectAdjacentPrefetchPositions(this.mPrefetchDx, this.mPrefetchDy, paramRecyclerView.mState, this);
      }
    }

    boolean lastPrefetchIncludedPosition(int paramInt)
    {
      int[] arrayOfInt = this.mPrefetchArray;
      boolean bool = false;
      int i;
      if (arrayOfInt != null)
        i = 2 * this.mCount;
      for (int j = 0; ; j += 2)
      {
        bool = false;
        if (j < i)
        {
          if (this.mPrefetchArray[j] == paramInt)
            bool = true;
        }
        else
          return bool;
      }
    }

    void setPrefetchVector(int paramInt1, int paramInt2)
    {
      this.mPrefetchDx = paramInt1;
      this.mPrefetchDy = paramInt2;
    }
  }

  static class Task
  {
    public int distanceToItem;
    public boolean immediate;
    public int position;
    public RecyclerView view;
    public int viewVelocity;

    public void clear()
    {
      this.immediate = false;
      this.viewVelocity = 0;
      this.distanceToItem = 0;
      this.view = null;
      this.position = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.GapWorker
 * JD-Core Version:    0.6.2
 */