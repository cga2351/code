package com.facebook.react.bridge;

import javax.annotation.concurrent.GuardedBy;

public class JavaScriptContextHolder
{

  @GuardedBy("this")
  private long mContext;

  public JavaScriptContextHolder(long paramLong)
  {
    this.mContext = paramLong;
  }

  public void clear()
  {
    try
    {
      this.mContext = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @GuardedBy("this")
  public long get()
  {
    return this.mContext;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JavaScriptContextHolder
 * JD-Core Version:    0.6.2
 */