package org.webrtc;

import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

class RefCountDelegate
  implements RefCounted
{
  private final AtomicInteger refCount = new AtomicInteger(1);

  @Nullable
  private final Runnable releaseCallback;

  public RefCountDelegate(@Nullable Runnable paramRunnable)
  {
    this.releaseCallback = paramRunnable;
  }

  public void release()
  {
    if ((this.refCount.decrementAndGet() == 0) && (this.releaseCallback != null))
      this.releaseCallback.run();
  }

  public void retain()
  {
    this.refCount.incrementAndGet();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.RefCountDelegate
 * JD-Core Version:    0.6.2
 */