package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.image.CloseableImage;

public class BitmapCountingMemoryCacheFactory
{
  public static CountingMemoryCache<CacheKey, CloseableImage> get(Supplier<MemoryCacheParams> paramSupplier, MemoryTrimmableRegistry paramMemoryTrimmableRegistry)
  {
    return get(paramSupplier, paramMemoryTrimmableRegistry, new BitmapMemoryCacheTrimStrategy());
  }

  public static CountingMemoryCache<CacheKey, CloseableImage> get(Supplier<MemoryCacheParams> paramSupplier, MemoryTrimmableRegistry paramMemoryTrimmableRegistry, CountingMemoryCache.CacheTrimStrategy paramCacheTrimStrategy)
  {
    CountingMemoryCache localCountingMemoryCache = new CountingMemoryCache(new ValueDescriptor()
    {
      public int getSizeInBytes(CloseableImage paramAnonymousCloseableImage)
      {
        return paramAnonymousCloseableImage.getSizeInBytes();
      }
    }
    , paramCacheTrimStrategy, paramSupplier);
    paramMemoryTrimmableRegistry.registerMemoryTrimmable(localCountingMemoryCache);
    return localCountingMemoryCache;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.BitmapCountingMemoryCacheFactory
 * JD-Core Version:    0.6.2
 */