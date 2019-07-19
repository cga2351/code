package org.greenrobot.eventbus;

import java.util.concurrent.ExecutorService;

class AsyncPoster
  implements Runnable, Poster
{
  private final EventBus eventBus;
  private final PendingPostQueue queue;

  AsyncPoster(EventBus paramEventBus)
  {
    this.eventBus = paramEventBus;
    this.queue = new PendingPostQueue();
  }

  public void enqueue(Subscription paramSubscription, Object paramObject)
  {
    PendingPost localPendingPost = PendingPost.obtainPendingPost(paramSubscription, paramObject);
    this.queue.enqueue(localPendingPost);
    this.eventBus.getExecutorService().execute(this);
  }

  public void run()
  {
    PendingPost localPendingPost = this.queue.poll();
    if (localPendingPost == null)
      throw new IllegalStateException("No pending post available");
    this.eventBus.invokeSubscriber(localPendingPost);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.greenrobot.eventbus.AsyncPoster
 * JD-Core Version:    0.6.2
 */