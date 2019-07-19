package com.facebook.react.uimanager;

import com.facebook.react.common.ClearableSynchronizedPool;
import com.facebook.yoga.YogaNode;

public class YogaNodePool
{
  private static final Object sInitLock = new Object();
  private static ClearableSynchronizedPool<YogaNode> sPool;

  public static ClearableSynchronizedPool<YogaNode> get()
  {
    if (sPool != null)
      return sPool;
    synchronized (sInitLock)
    {
      if (sPool == null)
        sPool = new ClearableSynchronizedPool(1024);
      ClearableSynchronizedPool localClearableSynchronizedPool = sPool;
      return localClearableSynchronizedPool;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.YogaNodePool
 * JD-Core Version:    0.6.2
 */