package com.facebook.common.time;

import com.facebook.common.internal.DoNotStrip;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract interface MonotonicClock
{
  @DoNotStrip
  public abstract long now();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.time.MonotonicClock
 * JD-Core Version:    0.6.2
 */