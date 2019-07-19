package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;

public class ThumbnailBranchProducer
  implements Producer<EncodedImage>
{
  private final ThumbnailProducer<EncodedImage>[] mThumbnailProducers;

  public ThumbnailBranchProducer(ThumbnailProducer<EncodedImage>[] paramArrayOfThumbnailProducer)
  {
    this.mThumbnailProducers = ((ThumbnailProducer[])Preconditions.checkNotNull(paramArrayOfThumbnailProducer));
    Preconditions.checkElementIndex(0, this.mThumbnailProducers.length);
  }

  private int findFirstProducerForSize(int paramInt, ResizeOptions paramResizeOptions)
  {
    while (paramInt < this.mThumbnailProducers.length)
    {
      if (this.mThumbnailProducers[paramInt].canProvideImageForSize(paramResizeOptions))
        return paramInt;
      paramInt++;
    }
    return -1;
  }

  private boolean produceResultsFromThumbnailProducer(int paramInt, Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    int i = findFirstProducerForSize(paramInt, paramProducerContext.getImageRequest().getResizeOptions());
    if (i == -1)
      return false;
    this.mThumbnailProducers[i].produceResults(new ThumbnailConsumer(paramConsumer, paramProducerContext, i), paramProducerContext);
    return true;
  }

  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    if (paramProducerContext.getImageRequest().getResizeOptions() == null)
      paramConsumer.onNewResult(null, 1);
    while (produceResultsFromThumbnailProducer(0, paramConsumer, paramProducerContext))
      return;
    paramConsumer.onNewResult(null, 1);
  }

  private class ThumbnailConsumer extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private final ProducerContext mProducerContext;
    private final int mProducerIndex;
    private final ResizeOptions mResizeOptions;

    public ThumbnailConsumer(ProducerContext paramInt, int arg3)
    {
      super();
      Object localObject;
      this.mProducerContext = localObject;
      int i;
      this.mProducerIndex = i;
      this.mResizeOptions = this.mProducerContext.getImageRequest().getResizeOptions();
    }

    protected void onFailureImpl(Throwable paramThrowable)
    {
      if (!ThumbnailBranchProducer.this.produceResultsFromThumbnailProducer(1 + this.mProducerIndex, getConsumer(), this.mProducerContext))
        getConsumer().onFailure(paramThrowable);
    }

    protected void onNewResultImpl(EncodedImage paramEncodedImage, int paramInt)
    {
      if ((paramEncodedImage != null) && ((isNotLast(paramInt)) || (ThumbnailSizeChecker.isImageBigEnough(paramEncodedImage, this.mResizeOptions))))
        getConsumer().onNewResult(paramEncodedImage, paramInt);
      do
      {
        do
          return;
        while (!isLast(paramInt));
        EncodedImage.closeSafely(paramEncodedImage);
      }
      while (ThumbnailBranchProducer.this.produceResultsFromThumbnailProducer(1 + this.mProducerIndex, getConsumer(), this.mProducerContext));
      getConsumer().onNewResult(null, 1);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.ThumbnailBranchProducer
 * JD-Core Version:    0.6.2
 */