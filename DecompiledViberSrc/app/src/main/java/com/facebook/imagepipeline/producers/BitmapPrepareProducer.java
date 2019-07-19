package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;

public class BitmapPrepareProducer
  implements Producer<CloseableReference<CloseableImage>>
{
  public static final String PRODUCER_NAME = "BitmapPrepareProducer";
  private final Producer<CloseableReference<CloseableImage>> mInputProducer;
  private final int mMaxBitmapSizeBytes;
  private final int mMinBitmapSizeBytes;
  private final boolean mPreparePrefetch;

  public BitmapPrepareProducer(Producer<CloseableReference<CloseableImage>> paramProducer, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 <= paramInt2);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
      this.mMinBitmapSizeBytes = paramInt1;
      this.mMaxBitmapSizeBytes = paramInt2;
      this.mPreparePrefetch = paramBoolean;
      return;
    }
  }

  public void produceResults(Consumer<CloseableReference<CloseableImage>> paramConsumer, ProducerContext paramProducerContext)
  {
    if ((paramProducerContext.isPrefetch()) && (!this.mPreparePrefetch))
    {
      this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
      return;
    }
    this.mInputProducer.produceResults(new BitmapPrepareConsumer(paramConsumer, this.mMinBitmapSizeBytes, this.mMaxBitmapSizeBytes), paramProducerContext);
  }

  private static class BitmapPrepareConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>>
  {
    private final int mMaxBitmapSizeBytes;
    private final int mMinBitmapSizeBytes;

    BitmapPrepareConsumer(Consumer<CloseableReference<CloseableImage>> paramConsumer, int paramInt1, int paramInt2)
    {
      super();
      this.mMinBitmapSizeBytes = paramInt1;
      this.mMaxBitmapSizeBytes = paramInt2;
    }

    private void internalPrepareBitmap(CloseableReference<CloseableImage> paramCloseableReference)
    {
      if ((paramCloseableReference == null) || (!paramCloseableReference.isValid()));
      Bitmap localBitmap;
      int i;
      do
      {
        do
        {
          CloseableImage localCloseableImage;
          do
          {
            return;
            localCloseableImage = (CloseableImage)paramCloseableReference.get();
          }
          while ((localCloseableImage == null) || (localCloseableImage.isClosed()) || (!(localCloseableImage instanceof CloseableStaticBitmap)));
          localBitmap = ((CloseableStaticBitmap)localCloseableImage).getUnderlyingBitmap();
        }
        while (localBitmap == null);
        i = localBitmap.getRowBytes() * localBitmap.getHeight();
      }
      while ((i < this.mMinBitmapSizeBytes) || (i > this.mMaxBitmapSizeBytes));
      localBitmap.prepareToDraw();
    }

    protected void onNewResultImpl(CloseableReference<CloseableImage> paramCloseableReference, int paramInt)
    {
      internalPrepareBitmap(paramCloseableReference);
      getConsumer().onNewResult(paramCloseableReference, paramInt);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.BitmapPrepareProducer
 * JD-Core Version:    0.6.2
 */