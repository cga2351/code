package com.facebook.imagepipeline.core;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.AndroidPredicates;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedFactoryProvider;
import com.facebook.imagepipeline.bitmaps.ArtBitmapFactory;
import com.facebook.imagepipeline.bitmaps.EmptyJpegGenerator;
import com.facebook.imagepipeline.bitmaps.GingerbreadBitmapFactory;
import com.facebook.imagepipeline.bitmaps.HoneycombBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BitmapCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.decoder.DefaultImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoderConfig;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.platform.ArtDecoder;
import com.facebook.imagepipeline.platform.GingerbreadPurgeableDecoder;
import com.facebook.imagepipeline.platform.KitKatPurgeableDecoder;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class ImagePipelineFactory
{
  private static final Class<?> TAG = ImagePipelineFactory.class;
  private static ImagePipelineFactory sInstance = null;
  private AnimatedFactory mAnimatedFactory;
  private CountingMemoryCache<CacheKey, CloseableImage> mBitmapCountingMemoryCache;
  private InstrumentedMemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
  private final ImagePipelineConfig mConfig;
  private CountingMemoryCache<CacheKey, PooledByteBuffer> mEncodedCountingMemoryCache;
  private InstrumentedMemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
  private ImageDecoder mImageDecoder;
  private ImagePipeline mImagePipeline;
  private BufferedDiskCache mMainBufferedDiskCache;
  private FileCache mMainFileCache;
  private PlatformBitmapFactory mPlatformBitmapFactory;
  private PlatformDecoder mPlatformDecoder;
  private ProducerFactory mProducerFactory;
  private ProducerSequenceFactory mProducerSequenceFactory;
  private BufferedDiskCache mSmallImageBufferedDiskCache;
  private FileCache mSmallImageFileCache;
  private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

  public ImagePipelineFactory(ImagePipelineConfig paramImagePipelineConfig)
  {
    this.mConfig = ((ImagePipelineConfig)Preconditions.checkNotNull(paramImagePipelineConfig));
    this.mThreadHandoffProducerQueue = new ThreadHandoffProducerQueue(paramImagePipelineConfig.getExecutorSupplier().forLightweightBackgroundTasks());
  }

  public static PlatformBitmapFactory buildPlatformBitmapFactory(PoolFactory paramPoolFactory, PlatformDecoder paramPlatformDecoder)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return new ArtBitmapFactory(paramPoolFactory.getBitmapPool());
    if (Build.VERSION.SDK_INT >= 11)
      return new HoneycombBitmapFactory(new EmptyJpegGenerator(paramPoolFactory.getPooledByteBufferFactory()), paramPlatformDecoder);
    return new GingerbreadBitmapFactory();
  }

  public static PlatformDecoder buildPlatformDecoder(PoolFactory paramPoolFactory, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      int i = paramPoolFactory.getFlexByteArrayPoolMaxNumThreads();
      return new ArtDecoder(paramPoolFactory.getBitmapPool(), i, new Pools.SynchronizedPool(i));
    }
    if ((paramBoolean) && (Build.VERSION.SDK_INT < 19))
      return new GingerbreadPurgeableDecoder();
    return new KitKatPurgeableDecoder(paramPoolFactory.getFlexByteArrayPool());
  }

  private AnimatedFactory getAnimatedFactory()
  {
    if (this.mAnimatedFactory == null)
      this.mAnimatedFactory = AnimatedFactoryProvider.getAnimatedFactory(getPlatformBitmapFactory(), this.mConfig.getExecutorSupplier(), getBitmapCountingMemoryCache());
    return this.mAnimatedFactory;
  }

  private ImageDecoder getImageDecoder()
  {
    if (this.mImageDecoder == null)
    {
      if (this.mConfig.getImageDecoder() != null)
        this.mImageDecoder = this.mConfig.getImageDecoder();
    }
    else
      return this.mImageDecoder;
    AnimatedFactory localAnimatedFactory = getAnimatedFactory();
    ImageDecoder localImageDecoder2;
    ImageDecoder localImageDecoder1;
    if (localAnimatedFactory != null)
    {
      localImageDecoder2 = localAnimatedFactory.getGifDecoder(this.mConfig.getBitmapConfig());
      localImageDecoder1 = localAnimatedFactory.getWebPDecoder(this.mConfig.getBitmapConfig());
    }
    while (true)
    {
      if (this.mConfig.getImageDecoderConfig() == null)
      {
        this.mImageDecoder = new DefaultImageDecoder(localImageDecoder2, localImageDecoder1, getPlatformDecoder());
        break;
      }
      this.mImageDecoder = new DefaultImageDecoder(localImageDecoder2, localImageDecoder1, getPlatformDecoder(), this.mConfig.getImageDecoderConfig().getCustomImageDecoders());
      ImageFormatChecker.getInstance().setCustomImageFormatCheckers(this.mConfig.getImageDecoderConfig().getCustomImageFormats());
      break;
      localImageDecoder1 = null;
      localImageDecoder2 = null;
    }
  }

  public static ImagePipelineFactory getInstance()
  {
    return (ImagePipelineFactory)Preconditions.checkNotNull(sInstance, "ImagePipelineFactory was not initialized!");
  }

  private ProducerFactory getProducerFactory()
  {
    if (this.mProducerFactory == null)
      this.mProducerFactory = this.mConfig.getExperiments().getProducerFactoryMethod().createProducerFactory(this.mConfig.getContext(), this.mConfig.getPoolFactory().getSmallByteArrayPool(), getImageDecoder(), this.mConfig.getProgressiveJpegConfig(), this.mConfig.isDownsampleEnabled(), this.mConfig.isResizeAndRotateEnabledForNetwork(), this.mConfig.getExperiments().isDecodeCancellationEnabled(), this.mConfig.getExecutorSupplier(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(), getBitmapMemoryCache(), getEncodedMemoryCache(), getMainBufferedDiskCache(), getSmallImageBufferedDiskCache(), this.mConfig.getCacheKeyFactory(), getPlatformBitmapFactory(), this.mConfig.getExperiments().getBitmapPrepareToDrawMinSizeBytes(), this.mConfig.getExperiments().getBitmapPrepareToDrawMaxSizeBytes(), this.mConfig.getExperiments().getBitmapPrepareToDrawForPrefetch());
    return this.mProducerFactory;
  }

  private ProducerSequenceFactory getProducerSequenceFactory()
  {
    if ((Build.VERSION.SDK_INT >= 24) && (this.mConfig.getExperiments().getUseBitmapPrepareToDraw()));
    for (boolean bool = true; ; bool = false)
    {
      if (this.mProducerSequenceFactory == null)
        this.mProducerSequenceFactory = new ProducerSequenceFactory(this.mConfig.getContext().getApplicationContext().getContentResolver(), getProducerFactory(), this.mConfig.getNetworkFetcher(), this.mConfig.isResizeAndRotateEnabledForNetwork(), this.mConfig.getExperiments().isWebpSupportEnabled(), this.mThreadHandoffProducerQueue, this.mConfig.getExperiments().getUseDownsamplingRatioForResizing(), bool, this.mConfig.getExperiments().isPartialImageCachingEnabled(), this.mConfig.isDiskCacheEnabled());
      return this.mProducerSequenceFactory;
    }
  }

  private BufferedDiskCache getSmallImageBufferedDiskCache()
  {
    if (this.mSmallImageBufferedDiskCache == null)
      this.mSmallImageBufferedDiskCache = new BufferedDiskCache(getSmallImageFileCache(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(), this.mConfig.getPoolFactory().getPooledByteStreams(), this.mConfig.getExecutorSupplier().forLocalStorageRead(), this.mConfig.getExecutorSupplier().forLocalStorageWrite(), this.mConfig.getImageCacheStatsTracker());
    return this.mSmallImageBufferedDiskCache;
  }

  public static boolean hasBeenInitialized()
  {
    try
    {
      ImagePipelineFactory localImagePipelineFactory = sInstance;
      if (localImagePipelineFactory != null)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public static void initialize(Context paramContext)
  {
    try
    {
      initialize(ImagePipelineConfig.newBuilder(paramContext).build());
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static void initialize(ImagePipelineConfig paramImagePipelineConfig)
  {
    try
    {
      if (sInstance != null)
        FLog.w(TAG, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
      sInstance = new ImagePipelineFactory(paramImagePipelineConfig);
      return;
    }
    finally
    {
    }
  }

  public static void setInstance(ImagePipelineFactory paramImagePipelineFactory)
  {
    sInstance = paramImagePipelineFactory;
  }

  public static void shutDown()
  {
    try
    {
      if (sInstance != null)
      {
        sInstance.getBitmapMemoryCache().removeAll(AndroidPredicates.True());
        sInstance.getEncodedMemoryCache().removeAll(AndroidPredicates.True());
        sInstance = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public DrawableFactory getAnimatedDrawableFactory(Context paramContext)
  {
    AnimatedFactory localAnimatedFactory = getAnimatedFactory();
    if (localAnimatedFactory == null)
      return null;
    return localAnimatedFactory.getAnimatedDrawableFactory(paramContext);
  }

  public CountingMemoryCache<CacheKey, CloseableImage> getBitmapCountingMemoryCache()
  {
    if (this.mBitmapCountingMemoryCache == null)
      this.mBitmapCountingMemoryCache = BitmapCountingMemoryCacheFactory.get(this.mConfig.getBitmapMemoryCacheParamsSupplier(), this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getBitmapMemoryCacheTrimStrategy());
    return this.mBitmapCountingMemoryCache;
  }

  public InstrumentedMemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache()
  {
    if (this.mBitmapMemoryCache == null)
      this.mBitmapMemoryCache = BitmapMemoryCacheFactory.get(getBitmapCountingMemoryCache(), this.mConfig.getImageCacheStatsTracker());
    return this.mBitmapMemoryCache;
  }

  public CountingMemoryCache<CacheKey, PooledByteBuffer> getEncodedCountingMemoryCache()
  {
    if (this.mEncodedCountingMemoryCache == null)
      this.mEncodedCountingMemoryCache = EncodedCountingMemoryCacheFactory.get(this.mConfig.getEncodedMemoryCacheParamsSupplier(), this.mConfig.getMemoryTrimmableRegistry());
    return this.mEncodedCountingMemoryCache;
  }

  public InstrumentedMemoryCache<CacheKey, PooledByteBuffer> getEncodedMemoryCache()
  {
    if (this.mEncodedMemoryCache == null)
      this.mEncodedMemoryCache = EncodedMemoryCacheFactory.get(getEncodedCountingMemoryCache(), this.mConfig.getImageCacheStatsTracker());
    return this.mEncodedMemoryCache;
  }

  public ImagePipeline getImagePipeline()
  {
    if (this.mImagePipeline == null)
      this.mImagePipeline = new ImagePipeline(getProducerSequenceFactory(), this.mConfig.getRequestListeners(), this.mConfig.getIsPrefetchEnabledSupplier(), getBitmapMemoryCache(), getEncodedMemoryCache(), getMainBufferedDiskCache(), getSmallImageBufferedDiskCache(), this.mConfig.getCacheKeyFactory(), this.mThreadHandoffProducerQueue, Suppliers.of(Boolean.valueOf(false)), this.mConfig.getExperiments().isLazyDataSource());
    return this.mImagePipeline;
  }

  public BufferedDiskCache getMainBufferedDiskCache()
  {
    if (this.mMainBufferedDiskCache == null)
      this.mMainBufferedDiskCache = new BufferedDiskCache(getMainFileCache(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(), this.mConfig.getPoolFactory().getPooledByteStreams(), this.mConfig.getExecutorSupplier().forLocalStorageRead(), this.mConfig.getExecutorSupplier().forLocalStorageWrite(), this.mConfig.getImageCacheStatsTracker());
    return this.mMainBufferedDiskCache;
  }

  public FileCache getMainFileCache()
  {
    if (this.mMainFileCache == null)
    {
      DiskCacheConfig localDiskCacheConfig = this.mConfig.getMainDiskCacheConfig();
      this.mMainFileCache = this.mConfig.getFileCacheFactory().get(localDiskCacheConfig);
    }
    return this.mMainFileCache;
  }

  public PlatformBitmapFactory getPlatformBitmapFactory()
  {
    if (this.mPlatformBitmapFactory == null)
      this.mPlatformBitmapFactory = buildPlatformBitmapFactory(this.mConfig.getPoolFactory(), getPlatformDecoder());
    return this.mPlatformBitmapFactory;
  }

  public PlatformDecoder getPlatformDecoder()
  {
    if (this.mPlatformDecoder == null)
      this.mPlatformDecoder = buildPlatformDecoder(this.mConfig.getPoolFactory(), this.mConfig.getExperiments().isWebpSupportEnabled());
    return this.mPlatformDecoder;
  }

  public FileCache getSmallImageFileCache()
  {
    if (this.mSmallImageFileCache == null)
    {
      DiskCacheConfig localDiskCacheConfig = this.mConfig.getSmallImageDiskCacheConfig();
      this.mSmallImageFileCache = this.mConfig.getFileCacheFactory().get(localDiskCacheConfig);
    }
    return this.mSmallImageFileCache;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.core.ImagePipelineFactory
 * JD-Core Version:    0.6.2
 */