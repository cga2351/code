package com.facebook.imagepipeline.producers;

import b.g;
import b.i;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.CacheChoice;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

public class DiskCacheReadProducer
  implements Producer<EncodedImage>
{
  public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
  public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
  public static final String PRODUCER_NAME = "DiskCacheProducer";
  private final CacheKeyFactory mCacheKeyFactory;
  private final BufferedDiskCache mDefaultBufferedDiskCache;
  private final Producer<EncodedImage> mInputProducer;
  private final BufferedDiskCache mSmallImageBufferedDiskCache;

  public DiskCacheReadProducer(BufferedDiskCache paramBufferedDiskCache1, BufferedDiskCache paramBufferedDiskCache2, CacheKeyFactory paramCacheKeyFactory, Producer<EncodedImage> paramProducer)
  {
    this.mDefaultBufferedDiskCache = paramBufferedDiskCache1;
    this.mSmallImageBufferedDiskCache = paramBufferedDiskCache2;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mInputProducer = paramProducer;
  }

  @VisibleForTesting
  static Map<String, String> getExtraMap(ProducerListener paramProducerListener, String paramString, boolean paramBoolean, int paramInt)
  {
    if (!paramProducerListener.requiresExtraMap(paramString))
      return null;
    if (paramBoolean)
      return ImmutableMap.of("cached_value_found", String.valueOf(paramBoolean), "encodedImageSize", String.valueOf(paramInt));
    return ImmutableMap.of("cached_value_found", String.valueOf(paramBoolean));
  }

  private static boolean isTaskCancelled(i<?> parami)
  {
    return (parami.c()) || ((parami.d()) && ((parami.f() instanceof CancellationException)));
  }

  private void maybeStartInputProducer(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    if (paramProducerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue())
    {
      paramConsumer.onNewResult(null, 1);
      return;
    }
    this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
  }

  private g<EncodedImage, Void> onFinishDiskReads(final Consumer<EncodedImage> paramConsumer, final ProducerContext paramProducerContext)
  {
    final String str = paramProducerContext.getId();
    return new g()
    {
      public Void then(i<EncodedImage> paramAnonymousi)
        throws Exception
      {
        if (DiskCacheReadProducer.isTaskCancelled(paramAnonymousi))
        {
          this.val$listener.onProducerFinishWithCancellation(str, "DiskCacheProducer", null);
          paramConsumer.onCancellation();
          return null;
        }
        if (paramAnonymousi.d())
        {
          this.val$listener.onProducerFinishWithFailure(str, "DiskCacheProducer", paramAnonymousi.f(), null);
          DiskCacheReadProducer.this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
          return null;
        }
        EncodedImage localEncodedImage = (EncodedImage)paramAnonymousi.e();
        if (localEncodedImage != null)
        {
          this.val$listener.onProducerFinishWithSuccess(str, "DiskCacheProducer", DiskCacheReadProducer.getExtraMap(this.val$listener, str, true, localEncodedImage.getSize()));
          this.val$listener.onUltimateProducerReached(str, "DiskCacheProducer", true);
          paramConsumer.onProgressUpdate(1.0F);
          paramConsumer.onNewResult(localEncodedImage, 1);
          localEncodedImage.close();
          return null;
        }
        this.val$listener.onProducerFinishWithSuccess(str, "DiskCacheProducer", DiskCacheReadProducer.getExtraMap(this.val$listener, str, false, 0));
        DiskCacheReadProducer.this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
        return null;
      }
    };
  }

  private void subscribeTaskForRequestCancellation(final AtomicBoolean paramAtomicBoolean, ProducerContext paramProducerContext)
  {
    paramProducerContext.addCallbacks(new BaseProducerContextCallbacks()
    {
      public void onCancellationRequested()
      {
        paramAtomicBoolean.set(true);
      }
    });
  }

  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    ImageRequest localImageRequest = paramProducerContext.getImageRequest();
    if (!localImageRequest.isDiskCacheEnabled())
    {
      maybeStartInputProducer(paramConsumer, paramProducerContext);
      return;
    }
    paramProducerContext.getListener().onProducerStart(paramProducerContext.getId(), "DiskCacheProducer");
    CacheKey localCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(localImageRequest, paramProducerContext.getCallerContext());
    int i;
    if (localImageRequest.getCacheChoice() == ImageRequest.CacheChoice.SMALL)
    {
      i = 1;
      if (i == 0)
        break label125;
    }
    label125: for (BufferedDiskCache localBufferedDiskCache = this.mSmallImageBufferedDiskCache; ; localBufferedDiskCache = this.mDefaultBufferedDiskCache)
    {
      AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
      localBufferedDiskCache.get(localCacheKey, localAtomicBoolean).a(onFinishDiskReads(paramConsumer, paramProducerContext));
      subscribeTaskForRequestCancellation(localAtomicBoolean, paramProducerContext);
      return;
      i = 0;
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.DiskCacheReadProducer
 * JD-Core Version:    0.6.2
 */