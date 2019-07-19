package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

public class ThrottlingProducer<T>
  implements Producer<T>
{
  public static final String PRODUCER_NAME = "ThrottlingProducer";
  private final Executor mExecutor;
  private final Producer<T> mInputProducer;
  private final int mMaxSimultaneousRequests;

  @GuardedBy("this")
  private int mNumCurrentRequests;

  @GuardedBy("this")
  private final ConcurrentLinkedQueue<Pair<Consumer<T>, ProducerContext>> mPendingRequests;

  public ThrottlingProducer(int paramInt, Executor paramExecutor, Producer<T> paramProducer)
  {
    this.mMaxSimultaneousRequests = paramInt;
    this.mExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
    this.mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
    this.mPendingRequests = new ConcurrentLinkedQueue();
    this.mNumCurrentRequests = 0;
  }

  public void produceResults(Consumer<T> paramConsumer, ProducerContext paramProducerContext)
  {
    paramProducerContext.getListener().onProducerStart(paramProducerContext.getId(), "ThrottlingProducer");
    try
    {
      if (this.mNumCurrentRequests >= this.mMaxSimultaneousRequests)
        this.mPendingRequests.add(Pair.create(paramConsumer, paramProducerContext));
      for (int i = 1; ; i = 0)
      {
        if (i == 0)
          produceResultsInternal(paramConsumer, paramProducerContext);
        return;
        this.mNumCurrentRequests = (1 + this.mNumCurrentRequests);
      }
    }
    finally
    {
    }
  }

  void produceResultsInternal(Consumer<T> paramConsumer, ProducerContext paramProducerContext)
  {
    paramProducerContext.getListener().onProducerFinishWithSuccess(paramProducerContext.getId(), "ThrottlingProducer", null);
    this.mInputProducer.produceResults(new ThrottlerConsumer(paramConsumer, null), paramProducerContext);
  }

  private class ThrottlerConsumer extends DelegatingConsumer<T, T>
  {
    private ThrottlerConsumer()
    {
      super();
    }

    private void onRequestFinished()
    {
      synchronized (ThrottlingProducer.this)
      {
        final Pair localPair = (Pair)ThrottlingProducer.this.mPendingRequests.poll();
        if (localPair == null)
          ThrottlingProducer.access$210(ThrottlingProducer.this);
        if (localPair != null)
          ThrottlingProducer.this.mExecutor.execute(new Runnable()
          {
            public void run()
            {
              ThrottlingProducer.this.produceResultsInternal((Consumer)localPair.first, (ProducerContext)localPair.second);
            }
          });
        return;
      }
    }

    protected void onCancellationImpl()
    {
      getConsumer().onCancellation();
      onRequestFinished();
    }

    protected void onFailureImpl(Throwable paramThrowable)
    {
      getConsumer().onFailure(paramThrowable);
      onRequestFinished();
    }

    protected void onNewResultImpl(T paramT, int paramInt)
    {
      getConsumer().onNewResult(paramT, paramInt);
      if (isLast(paramInt))
        onRequestFinished();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.ThrottlingProducer
 * JD-Core Version:    0.6.2
 */