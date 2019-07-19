package com.facebook.common.time;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract interface Clock
{
  public static final long MAX_TIME = 9223372036854775807L;

  public abstract long now();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.time.Clock
 * JD-Core Version:    0.6.2
 */