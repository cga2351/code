package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.util.Map;

public class EncodedMemoryCacheProducer
  implements Producer<EncodedImage>
{
  public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
  public static final String PRODUCER_NAME = "EncodedMemoryCacheProducer";
  private final CacheKeyFactory mCacheKeyFactory;
  private final Producer<EncodedImage> mInputProducer;
  private final MemoryCache<CacheKey, PooledByteBuffer> mMemoryCache;

  public EncodedMemoryCacheProducer(MemoryCache<CacheKey, PooledByteBuffer> paramMemoryCache, CacheKeyFactory paramCacheKeyFactory, Producer<EncodedImage> paramProducer)
  {
    this.mMemoryCache = paramMemoryCache;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mInputProducer = paramProducer;
  }

  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    String str = paramProducerContext.getId();
    ProducerListener localProducerListener = paramProducerContext.getListener();
    localProducerListener.onProducerStart(str, "EncodedMemoryCacheProducer");
    ImageRequest localImageRequest = paramProducerContext.getImageRequest();
    CacheKey localCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(localImageRequest, paramProducerContext.getCallerContext());
    CloseableReference localCloseableReference = this.mMemoryCache.get(localCacheKey);
    if (localCloseableReference != null)
      try
      {
        EncodedImage localEncodedImage = new EncodedImage(localCloseableReference);
        try
        {
          boolean bool4 = localProducerListener.requiresExtraMap(str);
          Map localMap3 = null;
          if (bool4)
            localMap3 = ImmutableMap.of("cached_value_found", "true");
          localProducerListener.onProducerFinishWithSuccess(str, "EncodedMemoryCacheProducer", localMap3);
          localProducerListener.onUltimateProducerReached(str, "EncodedMemoryCacheProducer", true);
          paramConsumer.onProgressUpdate(1.0F);
          paramConsumer.onNewResult(localEncodedImage, 1);
          return;
        }
        finally
        {
        }
      }
      finally
      {
        CloseableReference.closeSafely(localCloseableReference);
      }
    if (paramProducerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue())
    {
      boolean bool3 = localProducerListener.requiresExtraMap(str);
      Map localMap2 = null;
      if (bool3)
        localMap2 = ImmutableMap.of("cached_value_found", "false");
      localProducerListener.onProducerFinishWithSuccess(str, "EncodedMemoryCacheProducer", localMap2);
      localProducerListener.onUltimateProducerReached(str, "EncodedMemoryCacheProducer", false);
      paramConsumer.onNewResult(null, 1);
      CloseableReference.closeSafely(localCloseableReference);
      return;
    }
    boolean bool1 = paramProducerContext.getImageRequest().isMemoryCacheEnabled();
    EncodedMemoryCacheConsumer localEncodedMemoryCacheConsumer = new EncodedMemoryCacheConsumer(paramConsumer, this.mMemoryCache, localCacheKey, bool1);
    boolean bool2 = localProducerListener.requiresExtraMap(str);
    Map localMap1 = null;
    if (bool2)
      localMap1 = ImmutableMap.of("cached_value_found", "false");
    localProducerListener.onProducerFinishWithSuccess(str, "EncodedMemoryCacheProducer", localMap1);
    this.mInputProducer.produceResults(localEncodedMemoryCacheConsumer, paramProducerContext);
    CloseableReference.closeSafely(localCloseableReference);
  }

  private static class EncodedMemoryCacheConsumer extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private final boolean mIsMemoryCacheEnabled;
    private final MemoryCache<CacheKey, PooledByteBuffer> mMemoryCache;
    private final CacheKey mRequestedCacheKey;

    public EncodedMemoryCacheConsumer(Consumer<EncodedImage> paramConsumer, MemoryCache<CacheKey, PooledByteBuffer> paramMemoryCache, CacheKey paramCacheKey, boolean paramBoolean)
    {
      super();
      this.mMemoryCache = paramMemoryCache;
      this.mRequestedCacheKey = paramCacheKey;
      this.mIsMemoryCacheEnabled = paramBoolean;
    }

    // ERROR //
    public void onNewResultImpl(EncodedImage paramEncodedImage, int paramInt)
    {
      // Byte code:
      //   0: iload_2
      //   1: invokestatic 29	com/facebook/imagepipeline/producers/EncodedMemoryCacheProducer$EncodedMemoryCacheConsumer:isNotLast	(I)Z
      //   4: ifne +16 -> 20
      //   7: aload_1
      //   8: ifnull +12 -> 20
      //   11: iload_2
      //   12: bipush 10
      //   14: invokestatic 33	com/facebook/imagepipeline/producers/EncodedMemoryCacheProducer$EncodedMemoryCacheConsumer:statusHasAnyFlag	(II)Z
      //   17: ifeq +15 -> 32
      //   20: aload_0
      //   21: invokevirtual 37	com/facebook/imagepipeline/producers/EncodedMemoryCacheProducer$EncodedMemoryCacheConsumer:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
      //   24: aload_1
      //   25: iload_2
      //   26: invokeinterface 43 3 0
      //   31: return
      //   32: aload_1
      //   33: invokevirtual 49	com/facebook/imagepipeline/image/EncodedImage:getByteBufferRef	()Lcom/facebook/common/references/CloseableReference;
      //   36: astore_3
      //   37: aload_3
      //   38: ifnull +125 -> 163
      //   41: aload_0
      //   42: getfield 23	com/facebook/imagepipeline/producers/EncodedMemoryCacheProducer$EncodedMemoryCacheConsumer:mIsMemoryCacheEnabled	Z
      //   45: istore 5
      //   47: aconst_null
      //   48: astore 6
      //   50: iload 5
      //   52: ifeq +23 -> 75
      //   55: aload_0
      //   56: getfield 19	com/facebook/imagepipeline/producers/EncodedMemoryCacheProducer$EncodedMemoryCacheConsumer:mMemoryCache	Lcom/facebook/imagepipeline/cache/MemoryCache;
      //   59: aload_0
      //   60: getfield 21	com/facebook/imagepipeline/producers/EncodedMemoryCacheProducer$EncodedMemoryCacheConsumer:mRequestedCacheKey	Lcom/facebook/cache/common/CacheKey;
      //   63: aload_3
      //   64: invokeinterface 55 3 0
      //   69: astore 7
      //   71: aload 7
      //   73: astore 6
      //   75: aload_3
      //   76: invokestatic 61	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   79: aload 6
      //   81: ifnull +82 -> 163
      //   84: new 45	com/facebook/imagepipeline/image/EncodedImage
      //   87: dup
      //   88: aload 6
      //   90: invokespecial 63	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
      //   93: astore 8
      //   95: aload 8
      //   97: aload_1
      //   98: invokevirtual 67	com/facebook/imagepipeline/image/EncodedImage:copyMetaDataFrom	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
      //   101: aload 6
      //   103: invokestatic 61	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   106: aload_0
      //   107: invokevirtual 37	com/facebook/imagepipeline/producers/EncodedMemoryCacheProducer$EncodedMemoryCacheConsumer:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
      //   110: fconst_1
      //   111: invokeinterface 71 2 0
      //   116: aload_0
      //   117: invokevirtual 37	com/facebook/imagepipeline/producers/EncodedMemoryCacheProducer$EncodedMemoryCacheConsumer:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
      //   120: aload 8
      //   122: iload_2
      //   123: invokeinterface 43 3 0
      //   128: aload 8
      //   130: invokestatic 73	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
      //   133: return
      //   134: astore 4
      //   136: aload_3
      //   137: invokestatic 61	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   140: aload 4
      //   142: athrow
      //   143: astore 9
      //   145: aload 6
      //   147: invokestatic 61	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   150: aload 9
      //   152: athrow
      //   153: astore 10
      //   155: aload 8
      //   157: invokestatic 73	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
      //   160: aload 10
      //   162: athrow
      //   163: aload_0
      //   164: invokevirtual 37	com/facebook/imagepipeline/producers/EncodedMemoryCacheProducer$EncodedMemoryCacheConsumer:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
      //   167: aload_1
      //   168: iload_2
      //   169: invokeinterface 43 3 0
      //   174: return
      //
      // Exception table:
      //   from	to	target	type
      //   41	47	134	finally
      //   55	71	134	finally
      //   84	101	143	finally
      //   106	128	153	finally
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer
 * JD-Core Version:    0.6.2
 */