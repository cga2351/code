package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@VisibleForTesting
@NotThreadSafe
class Bucket<V>
{
  private static final String TAG = "BUCKET";
  private final boolean mFixBucketsReinitialization;
  final Queue mFreeList;
  private int mInUseLength;
  public final int mItemSize;
  public final int mMaxLength;

  public Bucket(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    boolean bool2;
    boolean bool3;
    if (paramInt1 > 0)
    {
      bool2 = bool1;
      Preconditions.checkState(bool2);
      if (paramInt2 < 0)
        break label81;
      bool3 = bool1;
      label28: Preconditions.checkState(bool3);
      if (paramInt3 < 0)
        break label87;
    }
    while (true)
    {
      Preconditions.checkState(bool1);
      this.mItemSize = paramInt1;
      this.mMaxLength = paramInt2;
      this.mFreeList = new LinkedList();
      this.mInUseLength = paramInt3;
      this.mFixBucketsReinitialization = paramBoolean;
      return;
      bool2 = false;
      break;
      label81: bool3 = false;
      break label28;
      label87: bool1 = false;
    }
  }

  void addToFreeList(V paramV)
  {
    this.mFreeList.add(paramV);
  }

  public void decrementInUseCount()
  {
    if (this.mInUseLength > 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool);
      this.mInUseLength = (-1 + this.mInUseLength);
      return;
    }
  }

  @Nullable
  public V get()
  {
    Object localObject = pop();
    if (localObject != null)
      this.mInUseLength = (1 + this.mInUseLength);
    return localObject;
  }

  int getFreeListSize()
  {
    return this.mFreeList.size();
  }

  public int getInUseCount()
  {
    return this.mInUseLength;
  }

  public void incrementInUseCount()
  {
    this.mInUseLength = (1 + this.mInUseLength);
  }

  public boolean isMaxLengthExceeded()
  {
    return this.mInUseLength + getFreeListSize() > this.mMaxLength;
  }

  @Nullable
  public V pop()
  {
    return this.mFreeList.poll();
  }

  public void release(V paramV)
  {
    boolean bool = true;
    Preconditions.checkNotNull(paramV);
    if (this.mFixBucketsReinitialization)
    {
      if (this.mInUseLength > 0);
      while (true)
      {
        Preconditions.checkState(bool);
        this.mInUseLength = (-1 + this.mInUseLength);
        addToFreeList(paramV);
        return;
        bool = false;
      }
    }
    if (this.mInUseLength > 0)
    {
      this.mInUseLength = (-1 + this.mInUseLength);
      addToFreeList(paramV);
      return;
    }
    Object[] arrayOfObject = new Object[bool];
    arrayOfObject[0] = paramV;
    FLog.e("BUCKET", "Tried to release value %s from an empty bucket!", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.Bucket
 * JD-Core Version:    0.6.2
 */