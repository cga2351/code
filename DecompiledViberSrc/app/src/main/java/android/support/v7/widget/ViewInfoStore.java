package android.support.v7.widget;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;

class ViewInfoStore
{
  private static final boolean DEBUG;
  final ArrayMap<RecyclerView.ViewHolder, InfoRecord> mLayoutHolderMap = new ArrayMap();
  final LongSparseArray<RecyclerView.ViewHolder> mOldChangedHolders = new LongSparseArray();

  private RecyclerView.ItemAnimator.ItemHolderInfo popFromLayoutStep(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = this.mLayoutHolderMap.indexOfKey(paramViewHolder);
    RecyclerView.ItemAnimator.ItemHolderInfo localItemHolderInfo = null;
    if (i < 0);
    while (true)
    {
      return localItemHolderInfo;
      InfoRecord localInfoRecord = (InfoRecord)this.mLayoutHolderMap.valueAt(i);
      localItemHolderInfo = null;
      if (localInfoRecord != null)
      {
        int j = paramInt & localInfoRecord.flags;
        localItemHolderInfo = null;
        if (j != 0)
        {
          localInfoRecord.flags &= (paramInt ^ 0xFFFFFFFF);
          if (paramInt == 4);
          for (localItemHolderInfo = localInfoRecord.preInfo; (0xC & localInfoRecord.flags) == 0; localItemHolderInfo = localInfoRecord.postInfo)
          {
            this.mLayoutHolderMap.removeAt(i);
            InfoRecord.recycle(localInfoRecord);
            return localItemHolderInfo;
            if (paramInt != 8)
              break label127;
          }
        }
      }
    }
    label127: throw new IllegalArgumentException("Must provide flag PRE or POST");
  }

  void addToAppearedInPreLayoutHolders(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    InfoRecord localInfoRecord = (InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    if (localInfoRecord == null)
    {
      localInfoRecord = InfoRecord.obtain();
      this.mLayoutHolderMap.put(paramViewHolder, localInfoRecord);
    }
    localInfoRecord.flags = (0x2 | localInfoRecord.flags);
    localInfoRecord.preInfo = paramItemHolderInfo;
  }

  void addToDisappearedInLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    InfoRecord localInfoRecord = (InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    if (localInfoRecord == null)
    {
      localInfoRecord = InfoRecord.obtain();
      this.mLayoutHolderMap.put(paramViewHolder, localInfoRecord);
    }
    localInfoRecord.flags = (0x1 | localInfoRecord.flags);
  }

  void addToOldChangeHolders(long paramLong, RecyclerView.ViewHolder paramViewHolder)
  {
    this.mOldChangedHolders.put(paramLong, paramViewHolder);
  }

  void addToPostLayout(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    InfoRecord localInfoRecord = (InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    if (localInfoRecord == null)
    {
      localInfoRecord = InfoRecord.obtain();
      this.mLayoutHolderMap.put(paramViewHolder, localInfoRecord);
    }
    localInfoRecord.postInfo = paramItemHolderInfo;
    localInfoRecord.flags = (0x8 | localInfoRecord.flags);
  }

  void addToPreLayout(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    InfoRecord localInfoRecord = (InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    if (localInfoRecord == null)
    {
      localInfoRecord = InfoRecord.obtain();
      this.mLayoutHolderMap.put(paramViewHolder, localInfoRecord);
    }
    localInfoRecord.preInfo = paramItemHolderInfo;
    localInfoRecord.flags = (0x4 | localInfoRecord.flags);
  }

  void clear()
  {
    this.mLayoutHolderMap.clear();
    this.mOldChangedHolders.clear();
  }

  RecyclerView.ViewHolder getFromOldChangeHolders(long paramLong)
  {
    return (RecyclerView.ViewHolder)this.mOldChangedHolders.get(paramLong);
  }

  boolean isDisappearing(RecyclerView.ViewHolder paramViewHolder)
  {
    InfoRecord localInfoRecord = (InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    return (localInfoRecord != null) && ((0x1 & localInfoRecord.flags) != 0);
  }

  boolean isInPreLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    InfoRecord localInfoRecord = (InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    return (localInfoRecord != null) && ((0x4 & localInfoRecord.flags) != 0);
  }

  void onDetach()
  {
    InfoRecord.drainCache();
  }

  public void onViewDetached(RecyclerView.ViewHolder paramViewHolder)
  {
    removeFromDisappearedInLayout(paramViewHolder);
  }

  RecyclerView.ItemAnimator.ItemHolderInfo popFromPostLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    return popFromLayoutStep(paramViewHolder, 8);
  }

  RecyclerView.ItemAnimator.ItemHolderInfo popFromPreLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    return popFromLayoutStep(paramViewHolder, 4);
  }

  void process(ProcessCallback paramProcessCallback)
  {
    int i = -1 + this.mLayoutHolderMap.size();
    if (i >= 0)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mLayoutHolderMap.keyAt(i);
      InfoRecord localInfoRecord = (InfoRecord)this.mLayoutHolderMap.removeAt(i);
      if ((0x3 & localInfoRecord.flags) == 3)
        paramProcessCallback.unused(localViewHolder);
      while (true)
      {
        InfoRecord.recycle(localInfoRecord);
        i--;
        break;
        if ((0x1 & localInfoRecord.flags) != 0)
        {
          if (localInfoRecord.preInfo == null)
            paramProcessCallback.unused(localViewHolder);
          else
            paramProcessCallback.processDisappeared(localViewHolder, localInfoRecord.preInfo, localInfoRecord.postInfo);
        }
        else if ((0xE & localInfoRecord.flags) == 14)
          paramProcessCallback.processAppeared(localViewHolder, localInfoRecord.preInfo, localInfoRecord.postInfo);
        else if ((0xC & localInfoRecord.flags) == 12)
          paramProcessCallback.processPersistent(localViewHolder, localInfoRecord.preInfo, localInfoRecord.postInfo);
        else if ((0x4 & localInfoRecord.flags) != 0)
          paramProcessCallback.processDisappeared(localViewHolder, localInfoRecord.preInfo, null);
        else if ((0x8 & localInfoRecord.flags) != 0)
          paramProcessCallback.processAppeared(localViewHolder, localInfoRecord.preInfo, localInfoRecord.postInfo);
        else if ((0x2 & localInfoRecord.flags) == 0);
      }
    }
  }

  void removeFromDisappearedInLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    InfoRecord localInfoRecord = (InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    if (localInfoRecord == null)
      return;
    localInfoRecord.flags = (0xFFFFFFFE & localInfoRecord.flags);
  }

  void removeViewHolder(RecyclerView.ViewHolder paramViewHolder)
  {
    for (int i = -1 + this.mOldChangedHolders.size(); ; i--)
      if (i >= 0)
      {
        if (paramViewHolder == this.mOldChangedHolders.valueAt(i))
          this.mOldChangedHolders.removeAt(i);
      }
      else
      {
        InfoRecord localInfoRecord = (InfoRecord)this.mLayoutHolderMap.remove(paramViewHolder);
        if (localInfoRecord != null)
          InfoRecord.recycle(localInfoRecord);
        return;
      }
  }

  static class InfoRecord
  {
    static final int FLAG_APPEAR = 2;
    static final int FLAG_APPEAR_AND_DISAPPEAR = 3;
    static final int FLAG_APPEAR_PRE_AND_POST = 14;
    static final int FLAG_DISAPPEARED = 1;
    static final int FLAG_POST = 8;
    static final int FLAG_PRE = 4;
    static final int FLAG_PRE_AND_POST = 12;
    static Pools.Pool<InfoRecord> sPool = new Pools.SimplePool(20);
    int flags;
    RecyclerView.ItemAnimator.ItemHolderInfo postInfo;
    RecyclerView.ItemAnimator.ItemHolderInfo preInfo;

    static void drainCache()
    {
      while (sPool.acquire() != null);
    }

    static InfoRecord obtain()
    {
      InfoRecord localInfoRecord = (InfoRecord)sPool.acquire();
      if (localInfoRecord == null)
        localInfoRecord = new InfoRecord();
      return localInfoRecord;
    }

    static void recycle(InfoRecord paramInfoRecord)
    {
      paramInfoRecord.flags = 0;
      paramInfoRecord.preInfo = null;
      paramInfoRecord.postInfo = null;
      sPool.release(paramInfoRecord);
    }
  }

  static abstract interface ProcessCallback
  {
    public abstract void processAppeared(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2);

    public abstract void processDisappeared(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2);

    public abstract void processPersistent(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2);

    public abstract void unused(RecyclerView.ViewHolder paramViewHolder);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ViewInfoStore
 * JD-Core Version:    0.6.2
 */