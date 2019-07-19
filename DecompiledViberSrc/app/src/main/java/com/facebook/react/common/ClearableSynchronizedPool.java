package com.facebook.react.common;

import android.support.v4.util.Pools.Pool;

public class ClearableSynchronizedPool<T>
  implements Pools.Pool<T>
{
  private final Object[] mPool;
  private int mSize = 0;

  public ClearableSynchronizedPool(int paramInt)
  {
    this.mPool = new Object[paramInt];
  }

  public T acquire()
  {
    try
    {
      int i = this.mSize;
      Object localObject2 = null;
      if (i == 0);
      while (true)
      {
        return localObject2;
        this.mSize = (-1 + this.mSize);
        int j = this.mSize;
        localObject2 = this.mPool[j];
        this.mPool[j] = null;
      }
    }
    finally
    {
    }
  }

  public void clear()
  {
    int i = 0;
    try
    {
      while (i < this.mSize)
      {
        this.mPool[i] = null;
        i++;
      }
      this.mSize = 0;
      return;
    }
    finally
    {
    }
  }

  public boolean release(T paramT)
  {
    try
    {
      int i = this.mSize;
      int j = this.mPool.length;
      if (i == j);
      for (boolean bool = false; ; bool = true)
      {
        return bool;
        this.mPool[this.mSize] = paramT;
        this.mSize = (1 + this.mSize);
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.common.ClearableSynchronizedPool
 * JD-Core Version:    0.6.2
 */