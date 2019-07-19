package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import java.util.Map;

public class PostprocessedBitmapMemoryCacheProducer
  implements Producer<CloseableReference<CloseableImage>>
{
  public static final String PRODUCER_NAME = "PostprocessedBitmapMemoryCacheProducer";

  @VisibleForTesting
  static final String VALUE_FOUND = "cached_value_found";
  private final CacheKeyFactory mCacheKeyFactory;
  private final Producer<CloseableReference<CloseableImage>> mInputProducer;
  private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

  public PostprocessedBitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> paramMemoryCache, CacheKeyFactory paramCacheKeyFactory, Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    this.mMemoryCache = paramMemoryCache;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mInputProducer = paramProducer;
  }

  protected String getProducerName()
  {
    return "PostprocessedBitmapMemoryCacheProducer";
  }

  public void produceResults(Consumer<CloseableReference<CloseableImage>> paramConsumer, ProducerContext paramProducerContext)
  {
    ProducerListener localProducerListener = paramProducerContext.getListener();
    String str1 = paramProducerContext.getId();
    ImageRequest localImageRequest = paramProducerContext.getImageRequest();
    Object localObject = paramProducerContext.getCallerContext();
    Postprocessor localPostprocessor = localImageRequest.getPostprocessor();
    if ((localPostprocessor == null) || (localPostprocessor.getPostprocessorCacheKey() == null))
    {
      this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
      return;
    }
    localProducerListener.onProducerStart(str1, getProducerName());
    CacheKey localCacheKey = this.mCacheKeyFactory.getPostprocessedBitmapCacheKey(localImageRequest, localObject);
    CloseableReference localCloseableReference = this.mMemoryCache.get(localCacheKey);
    if (localCloseableReference != null)
    {
      String str3 = getProducerName();
      if (localProducerListener.requiresExtraMap(str1));
      for (Map localMap2 = ImmutableMap.of("cached_value_found", "true"); ; localMap2 = null)
      {
        localProducerListener.onProducerFinishWithSuccess(str1, str3, localMap2);
        localProducerListener.onUltimateProducerReached(str1, "PostprocessedBitmapMemoryCacheProducer", true);
        paramConsumer.onProgressUpdate(1.0F);
        paramConsumer.onNewResult(localCloseableReference, 1);
        localCloseableReference.close();
        return;
      }
    }
    boolean bool1 = localPostprocessor instanceof RepeatedPostprocessor;
    boolean bool2 = paramProducerContext.getImageRequest().isMemoryCacheEnabled();
    CachedPostprocessorConsumer localCachedPostprocessorConsumer = new CachedPostprocessorConsumer(paramConsumer, localCacheKey, bool1, this.mMemoryCache, bool2);
    String str2 = getProducerName();
    boolean bool3 = localProducerListener.requiresExtraMap(str1);
    Map localMap1 = null;
    if (bool3)
      localMap1 = ImmutableMap.of("cached_value_found", "false");
    localProducerListener.onProducerFinishWithSuccess(str1, str2, localMap1);
    this.mInputProducer.produceResults(localCachedPostprocessorConsumer, paramProducerContext);
  }

  public static class CachedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>>
  {
    private final CacheKey mCacheKey;
    private final boolean mIsMemoryCachedEnabled;
    private final boolean mIsRepeatedProcessor;
    private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

    public CachedPostprocessorConsumer(Consumer<CloseableReference<CloseableImage>> paramConsumer, CacheKey paramCacheKey, boolean paramBoolean1, MemoryCache<CacheKey, CloseableImage> paramMemoryCache, boolean paramBoolean2)
    {
      super();
      this.mCacheKey = paramCacheKey;
      this.mIsRepeatedProcessor = paramBoolean1;
      this.mMemoryCache = paramMemoryCache;
      this.mIsMemoryCachedEnabled = paramBoolean2;
    }

    protected void onNewResultImpl(CloseableReference<CloseableImage> paramCloseableReference, int paramInt)
    {
      if (paramCloseableReference == null)
        if (isLast(paramInt))
          getConsumer().onNewResult(null, paramInt);
      while ((isNotLast(paramInt)) && (!this.mIsRepeatedProcessor))
        return;
      boolean bool = this.mIsMemoryCachedEnabled;
      CloseableReference localCloseableReference = null;
      if (bool)
        localCloseableReference = this.mMemoryCache.cache(this.mCacheKey, paramCloseableReference);
      try
      {
        getConsumer().onProgressUpdate(1.0F);
        Consumer localConsumer = getConsumer();
        if (localCloseableReference != null)
          paramCloseableReference = localCloseableReference;
        localConsumer.onNewResult(paramCloseableReference, paramInt);
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
 * Qualified Name:     com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer
 * JD-Core Version:    0.6.2
 */