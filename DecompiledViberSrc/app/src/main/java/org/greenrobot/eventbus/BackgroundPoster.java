package org.greenrobot.eventbus;

import java.util.concurrent.ExecutorService;

final class BackgroundPoster
  implements Runnable, Poster
{
  private final EventBus eventBus;
  private volatile boolean executorRunning;
  private final PendingPostQueue queue;

  BackgroundPoster(EventBus paramEventBus)
  {
    this.eventBus = paramEventBus;
    this.queue = new PendingPostQueue();
  }

  public void enqueue(Subscription paramSubscription, Object paramObject)
  {
    PendingPost localPendingPost = PendingPost.obtainPendingPost(paramSubscription, paramObject);
    try
    {
      this.queue.enqueue(localPendingPost);
      if (!this.executorRunning)
      {
        this.executorRunning = true;
        this.eventBus.getExecutorService().execute(this);
      }
      return;
    }
    finally
    {
    }
  }

  public void run()
  {
    try
    {
      localPendingPost = this.queue.poll(1000);
      if (localPendingPost != null);
    }
    catch (InterruptedException localInterruptedException)
    {
    }
    finally
    {
      PendingPost localPendingPost;
      this.executorRunning = false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.greenrobot.eventbus.BackgroundPoster
 * JD-Core Version:    0.6.2
 */