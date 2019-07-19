package com.mopub.mobileads;

import android.os.Handler;
import com.mopub.common.Preconditions;

public class VastVideoViewCountdownRunnable extends RepeatingHandlerRunnable
{
  private final VastVideoViewController c;

  public VastVideoViewCountdownRunnable(VastVideoViewController paramVastVideoViewController, Handler paramHandler)
  {
    super(paramHandler);
    Preconditions.checkNotNull(paramHandler);
    Preconditions.checkNotNull(paramVastVideoViewController);
    this.c = paramVastVideoViewController;
  }

  public void doWork()
  {
    this.c.m();
    if (this.c.l())
      this.c.k();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VastVideoViewCountdownRunnable
 * JD-Core Version:    0.6.2
 */