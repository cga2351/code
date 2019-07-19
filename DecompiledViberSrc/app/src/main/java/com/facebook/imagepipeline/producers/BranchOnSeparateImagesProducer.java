package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;

public class BranchOnSeparateImagesProducer
  implements Producer<EncodedImage>
{
  private final Producer<EncodedImage> mInputProducer1;
  private final Producer<EncodedImage> mInputProducer2;

  public BranchOnSeparateImagesProducer(Producer<EncodedImage> paramProducer1, Producer<EncodedImage> paramProducer2)
  {
    this.mInputProducer1 = paramProducer1;
    this.mInputProducer2 = paramProducer2;
  }

  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    OnFirstImageConsumer localOnFirstImageConsumer = new OnFirstImageConsumer(paramConsumer, paramProducerContext, null);
    this.mInputProducer1.produceResults(localOnFirstImageConsumer, paramProducerContext);
  }

  private class OnFirstImageConsumer extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private ProducerContext mProducerContext;

    private OnFirstImageConsumer(ProducerContext arg2)
    {
      super();
      Object localObject;
      this.mProducerContext = localObject;
    }

    protected void onFailureImpl(Throwable paramThrowable)
    {
      BranchOnSeparateImagesProducer.this.mInputProducer2.produceResults(getConsumer(), this.mProducerContext);
    }

    protected void onNewResultImpl(EncodedImage paramEncodedImage, int paramInt)
    {
      ImageRequest localImageRequest = this.mProducerContext.getImageRequest();
      boolean bool1 = isLast(paramInt);
      boolean bool2 = ThumbnailSizeChecker.isImageBigEnough(paramEncodedImage, localImageRequest.getResizeOptions());
      if ((paramEncodedImage != null) && ((bool2) || (localImageRequest.getLocalThumbnailPreviewsEnabled())))
      {
        if ((!bool1) || (!bool2))
          break label98;
        getConsumer().onNewResult(paramEncodedImage, paramInt);
      }
      while (true)
      {
        if ((bool1) && (!bool2))
        {
          EncodedImage.closeSafely(paramEncodedImage);
          BranchOnSeparateImagesProducer.this.mInputProducer2.produceResults(getConsumer(), this.mProducerContext);
        }
        return;
        label98: int i = turnOffStatusFlag(paramInt, 1);
        getConsumer().onNewResult(paramEncodedImage, i);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.BranchOnSeparateImagesProducer
 * JD-Core Version:    0.6.2
 */