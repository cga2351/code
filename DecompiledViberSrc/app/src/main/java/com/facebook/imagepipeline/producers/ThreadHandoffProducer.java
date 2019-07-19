package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;

public class ThreadHandoffProducer<T>
  implements Producer<T>
{
  public static final String PRODUCER_NAME = "BackgroundThreadHandoffProducer";
  private final Producer<T> mInputProducer;
  private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

  public ThreadHandoffProducer(Producer<T> paramProducer, ThreadHandoffProducerQueue paramThreadHandoffProducerQueue)
  {
    this.mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
    this.mThreadHandoffProducerQueue = paramThreadHandoffProducerQueue;
  }

  public void produceResults(final Consumer<T> paramConsumer, final ProducerContext paramProducerContext)
  {
    final ProducerListener localProducerListener = paramProducerContext.getListener();
    final String str = paramProducerContext.getId();
    final StatefulProducerRunnable local1 = new StatefulProducerRunnable(paramConsumer, localProducerListener, "BackgroundThreadHandoffProducer", str)
    {
      protected void disposeResult(T paramAnonymousT)
      {
      }

      protected T getResult()
        throws Exception
      {
        return null;
      }

      protected void onSuccess(T paramAnonymousT)
      {
        localProducerListener.onProducerFinishWithSuccess(str, "BackgroundThreadHandoffProducer", null);
        ThreadHandoffProducer.this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
      }
    };
    paramProducerContext.addCallbacks(new BaseProducerContextCallbacks()
    {
      public void onCancellationRequested()
      {
        local1.cancel();
        ThreadHandoffProducer.this.mThreadHandoffProducerQueue.remove(local1);
      }
    });
    this.mThreadHandoffProducerQueue.addToQueueOrExecute(local1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.ThreadHandoffProducer
 * JD-Core Version:    0.6.2
 */