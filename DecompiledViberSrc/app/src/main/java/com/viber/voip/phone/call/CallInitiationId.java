package com.viber.voip.phone.call;

import java.util.concurrent.atomic.AtomicLong;

public class CallInitiationId
{
  private static final AtomicLong sCallInitiationAttemptId = new AtomicLong(0L);

  public static long getCurrentCallInitiationAttemptId()
  {
    return sCallInitiationAttemptId.get();
  }

  public static long noteNextCallInitiationAttemptId()
  {
    return sCallInitiationAttemptId.incrementAndGet();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.call.CallInitiationId
 * JD-Core Version:    0.6.2
 */