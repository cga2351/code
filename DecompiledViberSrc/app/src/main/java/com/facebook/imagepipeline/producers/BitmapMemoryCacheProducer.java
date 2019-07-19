package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.util.Map;

public class BitmapMemoryCacheProducer
  implements Producer<CloseableReference<CloseableImage>>
{
  public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
  public static final String PRODUCER_NAME = "BitmapMemoryCacheProducer";
  private final CacheKeyFactory mCacheKeyFactory;
  private final Producer<CloseableReference<CloseableImage>> mInputProducer;
  private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

  public BitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> paramMemoryCache, CacheKeyFactory paramCacheKeyFactory, Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    this.mMemoryCache = paramMemoryCache;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mInputProducer = paramProducer;
  }

  protected String getProducerName()
  {
    return "BitmapMemoryCacheProducer";
  }

  public void produceResults(Consumer<CloseableReference<CloseableImage>> paramConsumer, ProducerContext paramProducerContext)
  {
    ProducerListener localProducerListener = paramProducerContext.getListener();
    String str1 = paramProducerContext.getId();
    localProducerListener.onProducerStart(str1, getProducerName());
    ImageRequest localImageRequest = paramProducerContext.getImageRequest();
    Object localObject = paramProducerContext.getCallerContext();
    CacheKey localCacheKey = this.mCacheKeyFactory.getBitmapCacheKey(localImageRequest, localObject);
    CloseableReference localCloseableReference = this.mMemoryCache.get(localCacheKey);
    if (localCloseableReference != null)
    {
      boolean bool2 = ((CloseableImage)localCloseableReference.get()).getQualityInfo().isOfFullQuality();
      String str4;
      if (bool2)
      {
        str4 = getProducerName();
        if (!localProducerListener.requiresExtraMap(str1))
          break label181;
      }
      label181: for (Map localMap3 = ImmutableMap.of("cached_value_found", "true"); ; localMap3 = null)
      {
        localProducerListener.onProducerFinishWithSuccess(str1, str4, localMap3);
        localProducerListener.onUltimateProducerReached(str1, getProducerName(), true);
        paramConsumer.onProgressUpdate(1.0F);
        paramConsumer.onNewResult(localCloseableReference, BaseConsumer.simpleStatusForIsLast(bool2));
        localCloseableReference.close();
        if (!bool2)
          break;
        return;
      }
    }
    if (paramProducerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue())
    {
      String str3 = getProducerName();
      if (localProducerListener.requiresExtraMap(str1));
      for (Map localMap2 = ImmutableMap.of("cached_value_found", "false"); ; localMap2 = null)
      {
        localProducerListener.onProducerFinishWithSuccess(str1, str3, localMap2);
        localProducerListener.onUltimateProducerReached(str1, getProducerName(), false);
        paramConsumer.onNewResult(null, 1);
        return;
      }
    }
    Consumer localConsumer = wrapConsumer(paramConsumer, localCacheKey, paramProducerContext.getImageRequest().isMemoryCacheEnabled());
    String str2 = getProducerName();
    boolean bool1 = localProducerListener.requiresExtraMap(str1);
    Map localMap1 = null;
    if (bool1)
      localMap1 = ImmutableMap.of("cached_value_found", "false");
    localProducerListener.onProducerFinishWithSuccess(str1, str2, localMap1);
    this.mInputProducer.produceResults(localConsumer, paramProducerContext);
  }

  protected Consumer<CloseableReference<CloseableImage>> wrapConsumer(Consumer<CloseableReference<CloseableImage>> paramConsumer, final CacheKey paramCacheKey, final boolean paramBoolean)
  {
    return new DelegatingConsumer(paramConsumer)
    {
      // ERROR //
      public void onNewResultImpl(CloseableReference<CloseableImage> paramAnonymousCloseableReference, int paramAnonymousInt)
      {
        // Byte code:
        //   0: iload_2
        //   1: invokestatic 33	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer$1:isLast	(I)Z
        //   4: istore_3
        //   5: aload_1
        //   6: ifnonnull +19 -> 25
        //   9: iload_3
        //   10: ifeq +14 -> 24
        //   13: aload_0
        //   14: invokevirtual 37	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer$1:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
        //   17: aconst_null
        //   18: iload_2
        //   19: invokeinterface 43 3 0
        //   24: return
        //   25: aload_1
        //   26: invokevirtual 49	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
        //   29: checkcast 51	com/facebook/imagepipeline/image/CloseableImage
        //   32: invokevirtual 55	com/facebook/imagepipeline/image/CloseableImage:isStateful	()Z
        //   35: ifne +12 -> 47
        //   38: iload_2
        //   39: bipush 8
        //   41: invokestatic 59	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer$1:statusHasFlag	(II)Z
        //   44: ifeq +15 -> 59
        //   47: aload_0
        //   48: invokevirtual 37	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer$1:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
        //   51: aload_1
        //   52: iload_2
        //   53: invokeinterface 43 3 0
        //   58: return
        //   59: iload_3
        //   60: ifne +101 -> 161
        //   63: aload_0
        //   64: getfield 20	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer$1:this$0	Lcom/facebook/imagepipeline/producers/BitmapMemoryCacheProducer;
        //   67: invokestatic 63	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer:access$000	(Lcom/facebook/imagepipeline/producers/BitmapMemoryCacheProducer;)Lcom/facebook/imagepipeline/cache/MemoryCache;
        //   70: aload_0
        //   71: getfield 22	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer$1:val$cacheKey	Lcom/facebook/cache/common/CacheKey;
        //   74: invokeinterface 68 2 0
        //   79: astore 8
        //   81: aload 8
        //   83: ifnull +78 -> 161
        //   86: aload_1
        //   87: invokevirtual 49	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
        //   90: checkcast 51	com/facebook/imagepipeline/image/CloseableImage
        //   93: invokevirtual 72	com/facebook/imagepipeline/image/CloseableImage:getQualityInfo	()Lcom/facebook/imagepipeline/image/QualityInfo;
        //   96: astore 10
        //   98: aload 8
        //   100: invokevirtual 49	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
        //   103: checkcast 51	com/facebook/imagepipeline/image/CloseableImage
        //   106: invokevirtual 72	com/facebook/imagepipeline/image/CloseableImage:getQualityInfo	()Lcom/facebook/imagepipeline/image/QualityInfo;
        //   109: astore 11
        //   111: aload 11
        //   113: invokeinterface 77 1 0
        //   118: ifne +20 -> 138
        //   121: aload 11
        //   123: invokeinterface 81 1 0
        //   128: aload 10
        //   130: invokeinterface 81 1 0
        //   135: if_icmplt +21 -> 156
        //   138: aload_0
        //   139: invokevirtual 37	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer$1:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
        //   142: aload 8
        //   144: iload_2
        //   145: invokeinterface 43 3 0
        //   150: aload 8
        //   152: invokestatic 85	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
        //   155: return
        //   156: aload 8
        //   158: invokestatic 85	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
        //   161: aload_0
        //   162: getfield 24	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer$1:val$isMemoryCacheEnabled	Z
        //   165: istore 4
        //   167: aconst_null
        //   168: astore 5
        //   170: iload 4
        //   172: ifeq +22 -> 194
        //   175: aload_0
        //   176: getfield 20	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer$1:this$0	Lcom/facebook/imagepipeline/producers/BitmapMemoryCacheProducer;
        //   179: invokestatic 63	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer:access$000	(Lcom/facebook/imagepipeline/producers/BitmapMemoryCacheProducer;)Lcom/facebook/imagepipeline/cache/MemoryCache;
        //   182: aload_0
        //   183: getfield 22	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer$1:val$cacheKey	Lcom/facebook/cache/common/CacheKey;
        //   186: aload_1
        //   187: invokeinterface 89 3 0
        //   192: astore 5
        //   194: iload_3
        //   195: ifeq +13 -> 208
        //   198: aload_0
        //   199: invokevirtual 37	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer$1:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
        //   202: fconst_1
        //   203: invokeinterface 93 2 0
        //   208: aload_0
        //   209: invokevirtual 37	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer$1:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
        //   212: astore 7
        //   214: aload 5
        //   216: ifnull +6 -> 222
        //   219: aload 5
        //   221: astore_1
        //   222: aload 7
        //   224: aload_1
        //   225: iload_2
        //   226: invokeinterface 43 3 0
        //   231: aload 5
        //   233: invokestatic 85	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
        //   236: return
        //   237: astore 9
        //   239: aload 8
        //   241: invokestatic 85	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
        //   244: aload 9
        //   246: athrow
        //   247: astore 6
        //   249: aload 5
        //   251: invokestatic 85	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
        //   254: aload 6
        //   256: athrow
        //
        // Exception table:
        //   from	to	target	type
        //   86	138	237	finally
        //   138	150	237	finally
        //   198	208	247	finally
        //   208	214	247	finally
        //   222	231	247	finally
      }
    };
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer
 * JD-Core Version:    0.6.2
 */