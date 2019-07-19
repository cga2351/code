package com.viber.voip.util;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class bn<E> extends LinkedBlockingDeque<E>
{
  public boolean add(E paramE)
  {
    return super.offerFirst(paramE);
  }

  public boolean offer(E paramE)
  {
    return super.offerFirst(paramE);
  }

  public boolean offer(E paramE, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return super.offerFirst(paramE, paramLong, paramTimeUnit);
  }

  public void put(E paramE)
    throws InterruptedException
  {
    super.putFirst(paramE);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.bn
 * JD-Core Version:    0.6.2
 */