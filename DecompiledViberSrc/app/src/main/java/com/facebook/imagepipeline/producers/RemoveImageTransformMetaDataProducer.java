package com.facebook.imagepipeline.producers;

import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;

public class RemoveImageTransformMetaDataProducer
  implements Producer<CloseableReference<PooledByteBuffer>>
{
  private final Producer<EncodedImage> mInputProducer;

  public RemoveImageTransformMetaDataProducer(Producer<EncodedImage> paramProducer)
  {
    this.mInputProducer = paramProducer;
  }

  public void produceResults(Consumer<CloseableReference<PooledByteBuffer>> paramConsumer, ProducerContext paramProducerContext)
  {
    this.mInputProducer.produceResults(new RemoveImageTransformMetaDataConsumer(paramConsumer, null), paramProducerContext);
  }

  private class RemoveImageTransformMetaDataConsumer extends DelegatingConsumer<EncodedImage, CloseableReference<PooledByteBuffer>>
  {
    private RemoveImageTransformMetaDataConsumer()
    {
      super();
    }

    protected void onNewResultImpl(EncodedImage paramEncodedImage, int paramInt)
    {
      CloseableReference localCloseableReference = null;
      try
      {
        boolean bool = EncodedImage.isValid(paramEncodedImage);
        localCloseableReference = null;
        if (bool)
          localCloseableReference = paramEncodedImage.getByteBufferRef();
        getConsumer().onNewResult(localCloseableReference, paramInt);
        return;
      }
      finally
      {
        CloseableReference.closeSafely(localCloseableReference);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer
 * JD-Core Version:    0.6.2
 */