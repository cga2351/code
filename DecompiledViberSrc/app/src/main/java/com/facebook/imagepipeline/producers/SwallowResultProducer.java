package com.facebook.imagepipeline.producers;

public class SwallowResultProducer<T>
  implements Producer<Void>
{
  private final Producer<T> mInputProducer;

  public SwallowResultProducer(Producer<T> paramProducer)
  {
    this.mInputProducer = paramProducer;
  }

  public void produceResults(Consumer<Void> paramConsumer, ProducerContext paramProducerContext)
  {
    DelegatingConsumer local1 = new DelegatingConsumer(paramConsumer)
    {
      protected void onNewResultImpl(T paramAnonymousT, int paramAnonymousInt)
      {
        if (isLast(paramAnonymousInt))
          getConsumer().onNewResult(null, paramAnonymousInt);
      }
    };
    this.mInputProducer.produceResults(local1, paramProducerContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.SwallowResultProducer
 * JD-Core Version:    0.6.2
 */