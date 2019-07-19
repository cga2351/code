package com.facebook.imagepipeline.producers;

public abstract interface ProducerContextCallbacks
{
  public abstract void onCancellationRequested();

  public abstract void onIsIntermediateResultExpectedChanged();

  public abstract void onIsPrefetchChanged();

  public abstract void onPriorityChanged();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.ProducerContextCallbacks
 * JD-Core Version:    0.6.2
 */