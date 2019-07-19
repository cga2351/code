package android.support.v7.widget;

import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class AdapterHelper
  implements OpReorderer.Callback
{
  private static final boolean DEBUG = false;
  static final int POSITION_TYPE_INVISIBLE = 0;
  static final int POSITION_TYPE_NEW_OR_LAID_OUT = 1;
  private static final String TAG = "AHT";
  final Callback mCallback;
  final boolean mDisableRecycler;
  private int mExistingUpdateTypes = 0;
  Runnable mOnItemProcessedCallback;
  final OpReorderer mOpReorderer;
  final ArrayList<UpdateOp> mPendingUpdates = new ArrayList();
  final ArrayList<UpdateOp> mPostponedList = new ArrayList();
  private Pools.Pool<UpdateOp> mUpdateOpPool = new Pools.SimplePool(30);

  AdapterHelper(Callback paramCallback)
  {
    this(paramCallback, false);
  }

  AdapterHelper(Callback paramCallback, boolean paramBoolean)
  {
    this.mCallback = paramCallback;
    this.mDisableRecycler = paramBoolean;
    this.mOpReorderer = new OpReorderer(this);
  }

  private void applyAdd(UpdateOp paramUpdateOp)
  {
    postponeAndUpdateViewHolders(paramUpdateOp);
  }

  private void applyMove(UpdateOp paramUpdateOp)
  {
    postponeAndUpdateViewHolders(paramUpdateOp);
  }

  private void applyRemove(UpdateOp paramUpdateOp)
  {
    int i = paramUpdateOp.positionStart;
    int j = paramUpdateOp.positionStart + paramUpdateOp.itemCount;
    int k = -1;
    int m = paramUpdateOp.positionStart;
    int n = 0;
    if (m < j)
      if ((this.mCallback.findViewHolder(m) != null) || (canFindInPreLayout(m)))
      {
        if (k != 0)
          break label220;
        dispatchAndUpdateViewHolders(obtainUpdateOp(2, i, n, null));
      }
    label214: label220: for (int i1 = 1; ; i1 = 0)
    {
      k = 1;
      int i6;
      int i4;
      int i5;
      if (i1 != 0)
      {
        i6 = m - n;
        i4 = j - n;
        i5 = 1;
        label101: int i7 = i6 + 1;
        n = i5;
        j = i4;
        m = i7;
        break;
        if (k != 1)
          break label214;
        postponeAndUpdateViewHolders(obtainUpdateOp(2, i, n, null));
      }
      for (i1 = 1; ; i1 = 0)
      {
        k = 0;
        break;
        int i2 = n + 1;
        int i3 = m;
        i4 = j;
        i5 = i2;
        i6 = i3;
        break label101;
        if (n != paramUpdateOp.itemCount)
        {
          recycleUpdateOp(paramUpdateOp);
          paramUpdateOp = obtainUpdateOp(2, i, n, null);
        }
        if (k == 0)
        {
          dispatchAndUpdateViewHolders(paramUpdateOp);
          return;
        }
        postponeAndUpdateViewHolders(paramUpdateOp);
        return;
      }
    }
  }

  private void applyUpdate(UpdateOp paramUpdateOp)
  {
    int i = paramUpdateOp.positionStart;
    int j = paramUpdateOp.positionStart + paramUpdateOp.itemCount;
    int k = paramUpdateOp.positionStart;
    int m = -1;
    int n = 0;
    if (k < j)
    {
      int i1;
      int i2;
      if ((this.mCallback.findViewHolder(k) != null) || (canFindInPreLayout(k)))
      {
        if (m == 0)
        {
          dispatchAndUpdateViewHolders(obtainUpdateOp(4, i, n, paramUpdateOp.payload));
          n = 0;
          i = k;
        }
        i1 = i;
        i2 = n;
      }
      for (int i3 = 1; ; i3 = 0)
      {
        int i4 = i2 + 1;
        k++;
        int i5 = i3;
        n = i4;
        i = i1;
        m = i5;
        break;
        if (m == 1)
        {
          postponeAndUpdateViewHolders(obtainUpdateOp(4, i, n, paramUpdateOp.payload));
          n = 0;
          i = k;
        }
        i1 = i;
        i2 = n;
      }
    }
    if (n != paramUpdateOp.itemCount)
    {
      Object localObject = paramUpdateOp.payload;
      recycleUpdateOp(paramUpdateOp);
      paramUpdateOp = obtainUpdateOp(4, i, n, localObject);
    }
    if (m == 0)
    {
      dispatchAndUpdateViewHolders(paramUpdateOp);
      return;
    }
    postponeAndUpdateViewHolders(paramUpdateOp);
  }

  private boolean canFindInPreLayout(int paramInt)
  {
    int i = this.mPostponedList.size();
    for (int j = 0; j < i; j++)
    {
      UpdateOp localUpdateOp = (UpdateOp)this.mPostponedList.get(j);
      if (localUpdateOp.cmd == 8)
      {
        if (findPositionOffset(localUpdateOp.itemCount, j + 1) == paramInt)
          return true;
      }
      else if (localUpdateOp.cmd == 1)
      {
        int k = localUpdateOp.positionStart + localUpdateOp.itemCount;
        for (int m = localUpdateOp.positionStart; m < k; m++)
          if (findPositionOffset(m, j + 1) == paramInt)
            return true;
      }
    }
    return false;
  }

  private void dispatchAndUpdateViewHolders(UpdateOp paramUpdateOp)
  {
    if ((paramUpdateOp.cmd == 1) || (paramUpdateOp.cmd == 8))
      throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    int i = updatePositionWithPostponed(paramUpdateOp.positionStart, paramUpdateOp.cmd);
    int j = paramUpdateOp.positionStart;
    int k;
    int m;
    int n;
    int i1;
    int i2;
    label118: int i3;
    int i4;
    switch (paramUpdateOp.cmd)
    {
    case 3:
    default:
      throw new IllegalArgumentException("op should be remove or update." + paramUpdateOp);
    case 4:
      k = 1;
      m = 1;
      n = i;
      i1 = j;
      i2 = 1;
      if (i2 >= paramUpdateOp.itemCount)
        break label296;
      i3 = updatePositionWithPostponed(paramUpdateOp.positionStart + k * i2, paramUpdateOp.cmd);
      switch (paramUpdateOp.cmd)
      {
      case 3:
      default:
        i4 = 0;
        label179: if (i4 != 0)
          m++;
        break;
      case 4:
      case 2:
      }
      break;
    case 2:
    }
    while (true)
    {
      i2++;
      break label118;
      k = 0;
      break;
      if (i3 == n + 1)
      {
        i4 = 1;
        break label179;
      }
      i4 = 0;
      break label179;
      if (i3 == n)
      {
        i4 = 1;
        break label179;
      }
      i4 = 0;
      break label179;
      UpdateOp localUpdateOp2 = obtainUpdateOp(paramUpdateOp.cmd, n, m, paramUpdateOp.payload);
      dispatchFirstPassAndUpdateViewHolders(localUpdateOp2, i1);
      recycleUpdateOp(localUpdateOp2);
      if (paramUpdateOp.cmd == 4)
        i1 += m;
      m = 1;
      n = i3;
    }
    label296: Object localObject = paramUpdateOp.payload;
    recycleUpdateOp(paramUpdateOp);
    if (m > 0)
    {
      UpdateOp localUpdateOp1 = obtainUpdateOp(paramUpdateOp.cmd, n, m, localObject);
      dispatchFirstPassAndUpdateViewHolders(localUpdateOp1, i1);
      recycleUpdateOp(localUpdateOp1);
    }
  }

  private void postponeAndUpdateViewHolders(UpdateOp paramUpdateOp)
  {
    this.mPostponedList.add(paramUpdateOp);
    switch (paramUpdateOp.cmd)
    {
    case 3:
    case 5:
    case 6:
    case 7:
    default:
      throw new IllegalArgumentException("Unknown update op type for " + paramUpdateOp);
    case 1:
      this.mCallback.offsetPositionsForAdd(paramUpdateOp.positionStart, paramUpdateOp.itemCount);
      return;
    case 8:
      this.mCallback.offsetPositionsForMove(paramUpdateOp.positionStart, paramUpdateOp.itemCount);
      return;
    case 2:
      this.mCallback.offsetPositionsForRemovingLaidOutOrNewView(paramUpdateOp.positionStart, paramUpdateOp.itemCount);
      return;
    case 4:
    }
    this.mCallback.markViewHoldersUpdated(paramUpdateOp.positionStart, paramUpdateOp.itemCount, paramUpdateOp.payload);
  }

  private int updatePositionWithPostponed(int paramInt1, int paramInt2)
  {
    int i = -1 + this.mPostponedList.size();
    int j = paramInt1;
    if (i >= 0)
    {
      UpdateOp localUpdateOp2 = (UpdateOp)this.mPostponedList.get(i);
      int m;
      int n;
      label67: label108: int i1;
      if (localUpdateOp2.cmd == 8)
        if (localUpdateOp2.positionStart < localUpdateOp2.itemCount)
        {
          m = localUpdateOp2.positionStart;
          n = localUpdateOp2.itemCount;
          if ((j < m) || (j > n))
            break label207;
          if (m != localUpdateOp2.positionStart)
            break label161;
          if (paramInt2 != 1)
            break label141;
          localUpdateOp2.itemCount = (1 + localUpdateOp2.itemCount);
          i1 = j + 1;
          label114: j = i1;
        }
      while (true)
      {
        i--;
        break;
        m = localUpdateOp2.itemCount;
        n = localUpdateOp2.positionStart;
        break label67;
        label141: if (paramInt2 != 2)
          break label108;
        localUpdateOp2.itemCount = (-1 + localUpdateOp2.itemCount);
        break label108;
        label161: if (paramInt2 == 1)
          localUpdateOp2.positionStart = (1 + localUpdateOp2.positionStart);
        while (true)
        {
          i1 = j - 1;
          break;
          if (paramInt2 == 2)
            localUpdateOp2.positionStart = (-1 + localUpdateOp2.positionStart);
        }
        label207: if (j < localUpdateOp2.positionStart)
        {
          if (paramInt2 == 1)
          {
            localUpdateOp2.positionStart = (1 + localUpdateOp2.positionStart);
            localUpdateOp2.itemCount = (1 + localUpdateOp2.itemCount);
            i1 = j;
            break label114;
          }
          if (paramInt2 == 2)
          {
            localUpdateOp2.positionStart = (-1 + localUpdateOp2.positionStart);
            localUpdateOp2.itemCount = (-1 + localUpdateOp2.itemCount);
          }
        }
        i1 = j;
        break label114;
        if (localUpdateOp2.positionStart <= j)
        {
          if (localUpdateOp2.cmd == 1)
            j -= localUpdateOp2.itemCount;
          else if (localUpdateOp2.cmd == 2)
            j += localUpdateOp2.itemCount;
        }
        else if (paramInt2 == 1)
          localUpdateOp2.positionStart = (1 + localUpdateOp2.positionStart);
        else if (paramInt2 == 2)
          localUpdateOp2.positionStart = (-1 + localUpdateOp2.positionStart);
      }
    }
    int k = -1 + this.mPostponedList.size();
    if (k >= 0)
    {
      UpdateOp localUpdateOp1 = (UpdateOp)this.mPostponedList.get(k);
      if (localUpdateOp1.cmd == 8)
        if ((localUpdateOp1.itemCount == localUpdateOp1.positionStart) || (localUpdateOp1.itemCount < 0))
        {
          this.mPostponedList.remove(k);
          recycleUpdateOp(localUpdateOp1);
        }
      while (true)
      {
        k--;
        break;
        if (localUpdateOp1.itemCount <= 0)
        {
          this.mPostponedList.remove(k);
          recycleUpdateOp(localUpdateOp1);
        }
      }
    }
    return j;
  }

  AdapterHelper addUpdateOp(UpdateOp[] paramArrayOfUpdateOp)
  {
    Collections.addAll(this.mPendingUpdates, paramArrayOfUpdateOp);
    return this;
  }

  public int applyPendingUpdatesToPosition(int paramInt)
  {
    int i = this.mPendingUpdates.size();
    int j = 0;
    int k = paramInt;
    UpdateOp localUpdateOp;
    if (j < i)
    {
      localUpdateOp = (UpdateOp)this.mPendingUpdates.get(j);
      switch (localUpdateOp.cmd)
      {
      default:
      case 1:
      case 2:
      case 8:
      }
    }
    while (true)
    {
      j++;
      break;
      if (localUpdateOp.positionStart <= k)
      {
        k += localUpdateOp.itemCount;
        continue;
        if (localUpdateOp.positionStart <= k)
        {
          if (localUpdateOp.positionStart + localUpdateOp.itemCount > k)
          {
            k = -1;
            return k;
          }
          k -= localUpdateOp.itemCount;
          continue;
          if (localUpdateOp.positionStart == k)
          {
            k = localUpdateOp.itemCount;
          }
          else
          {
            if (localUpdateOp.positionStart < k)
              k--;
            if (localUpdateOp.itemCount <= k)
              k++;
          }
        }
      }
    }
  }

  void consumePostponedUpdates()
  {
    int i = this.mPostponedList.size();
    for (int j = 0; j < i; j++)
      this.mCallback.onDispatchSecondPass((UpdateOp)this.mPostponedList.get(j));
    recycleUpdateOpsAndClearList(this.mPostponedList);
    this.mExistingUpdateTypes = 0;
  }

  void consumeUpdatesInOnePass()
  {
    consumePostponedUpdates();
    int i = this.mPendingUpdates.size();
    int j = 0;
    if (j < i)
    {
      UpdateOp localUpdateOp = (UpdateOp)this.mPendingUpdates.get(j);
      switch (localUpdateOp.cmd)
      {
      case 3:
      case 5:
      case 6:
      case 7:
      default:
      case 1:
      case 2:
      case 4:
      case 8:
      }
      while (true)
      {
        if (this.mOnItemProcessedCallback != null)
          this.mOnItemProcessedCallback.run();
        j++;
        break;
        this.mCallback.onDispatchSecondPass(localUpdateOp);
        this.mCallback.offsetPositionsForAdd(localUpdateOp.positionStart, localUpdateOp.itemCount);
        continue;
        this.mCallback.onDispatchSecondPass(localUpdateOp);
        this.mCallback.offsetPositionsForRemovingInvisible(localUpdateOp.positionStart, localUpdateOp.itemCount);
        continue;
        this.mCallback.onDispatchSecondPass(localUpdateOp);
        this.mCallback.markViewHoldersUpdated(localUpdateOp.positionStart, localUpdateOp.itemCount, localUpdateOp.payload);
        continue;
        this.mCallback.onDispatchSecondPass(localUpdateOp);
        this.mCallback.offsetPositionsForMove(localUpdateOp.positionStart, localUpdateOp.itemCount);
      }
    }
    recycleUpdateOpsAndClearList(this.mPendingUpdates);
    this.mExistingUpdateTypes = 0;
  }

  void dispatchFirstPassAndUpdateViewHolders(UpdateOp paramUpdateOp, int paramInt)
  {
    this.mCallback.onDispatchFirstPass(paramUpdateOp);
    switch (paramUpdateOp.cmd)
    {
    case 3:
    default:
      throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    case 2:
      this.mCallback.offsetPositionsForRemovingInvisible(paramInt, paramUpdateOp.itemCount);
      return;
    case 4:
    }
    this.mCallback.markViewHoldersUpdated(paramInt, paramUpdateOp.itemCount, paramUpdateOp.payload);
  }

  int findPositionOffset(int paramInt)
  {
    return findPositionOffset(paramInt, 0);
  }

  int findPositionOffset(int paramInt1, int paramInt2)
  {
    int i = this.mPostponedList.size();
    int j = paramInt1;
    UpdateOp localUpdateOp;
    if (paramInt2 < i)
    {
      localUpdateOp = (UpdateOp)this.mPostponedList.get(paramInt2);
      if (localUpdateOp.cmd == 8)
        if (localUpdateOp.positionStart == j)
          j = localUpdateOp.itemCount;
    }
    while (true)
    {
      paramInt2++;
      break;
      if (localUpdateOp.positionStart < j)
        j--;
      if (localUpdateOp.itemCount <= j)
      {
        j++;
        continue;
        if (localUpdateOp.positionStart <= j)
          if (localUpdateOp.cmd == 2)
          {
            if (j < localUpdateOp.positionStart + localUpdateOp.itemCount)
            {
              j = -1;
              return j;
            }
            j -= localUpdateOp.itemCount;
          }
          else if (localUpdateOp.cmd == 1)
          {
            j += localUpdateOp.itemCount;
          }
      }
    }
  }

  boolean hasAnyUpdateTypes(int paramInt)
  {
    return (paramInt & this.mExistingUpdateTypes) != 0;
  }

  boolean hasPendingUpdates()
  {
    return this.mPendingUpdates.size() > 0;
  }

  boolean hasUpdates()
  {
    return (!this.mPostponedList.isEmpty()) && (!this.mPendingUpdates.isEmpty());
  }

  public UpdateOp obtainUpdateOp(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    UpdateOp localUpdateOp = (UpdateOp)this.mUpdateOpPool.acquire();
    if (localUpdateOp == null)
      return new UpdateOp(paramInt1, paramInt2, paramInt3, paramObject);
    localUpdateOp.cmd = paramInt1;
    localUpdateOp.positionStart = paramInt2;
    localUpdateOp.itemCount = paramInt3;
    localUpdateOp.payload = paramObject;
    return localUpdateOp;
  }

  boolean onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    int i = 1;
    if (paramInt2 < i)
      return false;
    this.mPendingUpdates.add(obtainUpdateOp(4, paramInt1, paramInt2, paramObject));
    this.mExistingUpdateTypes = (0x4 | this.mExistingUpdateTypes);
    if (this.mPendingUpdates.size() == i);
    while (true)
    {
      return i;
      i = 0;
    }
  }

  boolean onItemRangeInserted(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramInt2 < i)
      return false;
    this.mPendingUpdates.add(obtainUpdateOp(i, paramInt1, paramInt2, null));
    this.mExistingUpdateTypes = (0x1 | this.mExistingUpdateTypes);
    if (this.mPendingUpdates.size() == i);
    while (true)
    {
      return i;
      i = 0;
    }
  }

  boolean onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    if (paramInt1 == paramInt2)
      return false;
    if (paramInt3 != i)
      throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    this.mPendingUpdates.add(obtainUpdateOp(8, paramInt1, paramInt2, null));
    this.mExistingUpdateTypes = (0x8 | this.mExistingUpdateTypes);
    if (this.mPendingUpdates.size() == i);
    while (true)
    {
      return i;
      i = 0;
    }
  }

  boolean onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramInt2 < i)
      return false;
    this.mPendingUpdates.add(obtainUpdateOp(2, paramInt1, paramInt2, null));
    this.mExistingUpdateTypes = (0x2 | this.mExistingUpdateTypes);
    if (this.mPendingUpdates.size() == i);
    while (true)
    {
      return i;
      i = 0;
    }
  }

  void preProcess()
  {
    this.mOpReorderer.reorderOps(this.mPendingUpdates);
    int i = this.mPendingUpdates.size();
    int j = 0;
    if (j < i)
    {
      UpdateOp localUpdateOp = (UpdateOp)this.mPendingUpdates.get(j);
      switch (localUpdateOp.cmd)
      {
      case 3:
      case 5:
      case 6:
      case 7:
      default:
      case 1:
      case 2:
      case 4:
      case 8:
      }
      while (true)
      {
        if (this.mOnItemProcessedCallback != null)
          this.mOnItemProcessedCallback.run();
        j++;
        break;
        applyAdd(localUpdateOp);
        continue;
        applyRemove(localUpdateOp);
        continue;
        applyUpdate(localUpdateOp);
        continue;
        applyMove(localUpdateOp);
      }
    }
    this.mPendingUpdates.clear();
  }

  public void recycleUpdateOp(UpdateOp paramUpdateOp)
  {
    if (!this.mDisableRecycler)
    {
      paramUpdateOp.payload = null;
      this.mUpdateOpPool.release(paramUpdateOp);
    }
  }

  void recycleUpdateOpsAndClearList(List<UpdateOp> paramList)
  {
    int i = paramList.size();
    for (int j = 0; j < i; j++)
      recycleUpdateOp((UpdateOp)paramList.get(j));
    paramList.clear();
  }

  void reset()
  {
    recycleUpdateOpsAndClearList(this.mPendingUpdates);
    recycleUpdateOpsAndClearList(this.mPostponedList);
    this.mExistingUpdateTypes = 0;
  }

  static abstract interface Callback
  {
    public abstract RecyclerView.ViewHolder findViewHolder(int paramInt);

    public abstract void markViewHoldersUpdated(int paramInt1, int paramInt2, Object paramObject);

    public abstract void offsetPositionsForAdd(int paramInt1, int paramInt2);

    public abstract void offsetPositionsForMove(int paramInt1, int paramInt2);

    public abstract void offsetPositionsForRemovingInvisible(int paramInt1, int paramInt2);

    public abstract void offsetPositionsForRemovingLaidOutOrNewView(int paramInt1, int paramInt2);

    public abstract void onDispatchFirstPass(AdapterHelper.UpdateOp paramUpdateOp);

    public abstract void onDispatchSecondPass(AdapterHelper.UpdateOp paramUpdateOp);
  }

  static class UpdateOp
  {
    static final int ADD = 1;
    static final int MOVE = 8;
    static final int POOL_SIZE = 30;
    static final int REMOVE = 2;
    static final int UPDATE = 4;
    int cmd;
    int itemCount;
    Object payload;
    int positionStart;

    UpdateOp(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
    {
      this.cmd = paramInt1;
      this.positionStart = paramInt2;
      this.itemCount = paramInt3;
      this.payload = paramObject;
    }

    String cmdToString()
    {
      switch (this.cmd)
      {
      case 3:
      case 5:
      case 6:
      case 7:
      default:
        return "??";
      case 1:
        return "add";
      case 2:
        return "rm";
      case 4:
        return "up";
      case 8:
      }
      return "mv";
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      UpdateOp localUpdateOp;
      do
      {
        do
        {
          do
          {
            return true;
            if ((paramObject == null) || (getClass() != paramObject.getClass()))
              return false;
            localUpdateOp = (UpdateOp)paramObject;
            if (this.cmd != localUpdateOp.cmd)
              return false;
          }
          while ((this.cmd == 8) && (Math.abs(this.itemCount - this.positionStart) == 1) && (this.itemCount == localUpdateOp.positionStart) && (this.positionStart == localUpdateOp.itemCount));
          if (this.itemCount != localUpdateOp.itemCount)
            return false;
          if (this.positionStart != localUpdateOp.positionStart)
            return false;
          if (this.payload == null)
            break;
        }
        while (this.payload.equals(localUpdateOp.payload));
        return false;
      }
      while (localUpdateOp.payload == null);
      return false;
    }

    public int hashCode()
    {
      return 31 * (31 * this.cmd + this.positionStart) + this.itemCount;
    }

    public String toString()
    {
      return Integer.toHexString(System.identityHashCode(this)) + "[" + cmdToString() + ",s:" + this.positionStart + "c:" + this.itemCount + ",p:" + this.payload + "]";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.AdapterHelper
 * JD-Core Version:    0.6.2
 */