package com.facebook.react.modules.debug;

import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.common.LongArray;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;

public class DidJSUpdateUiDuringFrameDetector
  implements NotThreadSafeBridgeIdleDebugListener, NotThreadSafeViewHierarchyUpdateDebugListener
{
  private final LongArray mTransitionToBusyEvents = LongArray.createWithInitialCapacity(20);
  private final LongArray mTransitionToIdleEvents = LongArray.createWithInitialCapacity(20);
  private final LongArray mViewHierarchyUpdateEnqueuedEvents = LongArray.createWithInitialCapacity(20);
  private final LongArray mViewHierarchyUpdateFinishedEvents = LongArray.createWithInitialCapacity(20);
  private volatile boolean mWasIdleAtEndOfLastFrame = true;

  private static void cleanUp(LongArray paramLongArray, long paramLong)
  {
    int i = paramLongArray.size();
    int j = 0;
    int k = 0;
    while (j < i)
    {
      if (paramLongArray.get(j) < paramLong)
        k++;
      j++;
    }
    int m = 0;
    if (k > 0)
    {
      while (m < i - k)
      {
        paramLongArray.set(m, paramLongArray.get(m + k));
        m++;
      }
      paramLongArray.dropTail(k);
    }
  }

  private boolean didEndFrameIdle(long paramLong1, long paramLong2)
  {
    long l1 = getLastEventBetweenTimestamps(this.mTransitionToIdleEvents, paramLong1, paramLong2);
    long l2 = getLastEventBetweenTimestamps(this.mTransitionToBusyEvents, paramLong1, paramLong2);
    if ((l1 == -1L) && (l2 == -1L))
      return this.mWasIdleAtEndOfLastFrame;
    return l1 > l2;
  }

  private static long getLastEventBetweenTimestamps(LongArray paramLongArray, long paramLong1, long paramLong2)
  {
    long l1 = -1L;
    int i = 0;
    if (i < paramLongArray.size())
    {
      long l2 = paramLongArray.get(i);
      if ((l2 >= paramLong1) && (l2 < paramLong2))
        l1 = l2;
      while (l2 < paramLong2)
      {
        i++;
        break;
      }
    }
    return l1;
  }

  private static boolean hasEventBetweenTimestamps(LongArray paramLongArray, long paramLong1, long paramLong2)
  {
    for (int i = 0; ; i++)
    {
      int j = paramLongArray.size();
      boolean bool = false;
      if (i < j)
      {
        long l = paramLongArray.get(i);
        if ((l >= paramLong1) && (l < paramLong2))
          bool = true;
      }
      else
      {
        return bool;
      }
    }
  }

  public boolean getDidJSHitFrameAndCleanup(long paramLong1, long paramLong2)
  {
    boolean bool1 = true;
    try
    {
      boolean bool2 = hasEventBetweenTimestamps(this.mViewHierarchyUpdateFinishedEvents, paramLong1, paramLong2);
      boolean bool3 = didEndFrameIdle(paramLong1, paramLong2);
      if (bool2);
      while (true)
      {
        cleanUp(this.mTransitionToIdleEvents, paramLong2);
        cleanUp(this.mTransitionToBusyEvents, paramLong2);
        cleanUp(this.mViewHierarchyUpdateEnqueuedEvents, paramLong2);
        cleanUp(this.mViewHierarchyUpdateFinishedEvents, paramLong2);
        this.mWasIdleAtEndOfLastFrame = bool3;
        return bool1;
        if (bool3)
        {
          boolean bool4 = hasEventBetweenTimestamps(this.mViewHierarchyUpdateEnqueuedEvents, paramLong1, paramLong2);
          if (!bool4);
        }
        else
        {
          bool1 = false;
        }
      }
    }
    finally
    {
    }
  }

  public void onBridgeDestroyed()
  {
  }

  public void onTransitionToBridgeBusy()
  {
    try
    {
      this.mTransitionToBusyEvents.add(System.nanoTime());
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onTransitionToBridgeIdle()
  {
    try
    {
      this.mTransitionToIdleEvents.add(System.nanoTime());
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onViewHierarchyUpdateEnqueued()
  {
    try
    {
      this.mViewHierarchyUpdateEnqueuedEvents.add(System.nanoTime());
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onViewHierarchyUpdateFinished()
  {
    try
    {
      this.mViewHierarchyUpdateFinishedEvents.add(System.nanoTime());
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.debug.DidJSUpdateUiDuringFrameDetector
 * JD-Core Version:    0.6.2
 */