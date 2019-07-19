package com.facebook.imagepipeline.core;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap.Config;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskCacheConfig.Builder;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpBitmapFactory.WebpErrorLogger;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.bitmaps.HoneycombBitmapCreator;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheTrimStrategy;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache.CacheTrimStrategy;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultEncodedMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoderConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.memory.PoolConfig;
import com.facebook.imagepipeline.memory.PoolConfig.Builder;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

public class ImagePipelineConfig
{
  private static DefaultImageRequestConfig sDefaultImageRequestConfig = new DefaultImageRequestConfig(null);
  private final Bitmap.Config mBitmapConfig;
  private final Supplier<MemoryCacheParams> mBitmapMemoryCacheParamsSupplier;
  private final CountingMemoryCache.CacheTrimStrategy mBitmapMemoryCacheTrimStrategy;
  private final CacheKeyFactory mCacheKeyFactory;
  private final Context mContext;
  private final boolean mDiskCacheEnabled;
  private final boolean mDownsampleEnabled;
  private final Supplier<MemoryCacheParams> mEncodedMemoryCacheParamsSupplier;
  private final ExecutorSupplier mExecutorSupplier;
  private final FileCacheFactory mFileCacheFactory;
  private final int mHttpNetworkTimeout;
  private final ImageCacheStatsTracker mImageCacheStatsTracker;

  @Nullable
  private final ImageDecoder mImageDecoder;

  @Nullable
  private final ImageDecoderConfig mImageDecoderConfig;
  private final ImagePipelineExperiments mImagePipelineExperiments;
  private final Supplier<Boolean> mIsPrefetchEnabledSupplier;
  private final DiskCacheConfig mMainDiskCacheConfig;
  private final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
  private final NetworkFetcher mNetworkFetcher;

  @Nullable
  private final PlatformBitmapFactory mPlatformBitmapFactory;
  private final PoolFactory mPoolFactory;
  private final ProgressiveJpegConfig mProgressiveJpegConfig;
  private final Set<RequestListener> mRequestListeners;
  private final boolean mResizeAndRotateEnabledForNetwork;
  private final DiskCacheConfig mSmallImageDiskCacheConfig;

  private ImagePipelineConfig(Builder paramBuilder)
  {
    this.mImagePipelineExperiments = paramBuilder.mExperimentsBuilder.build();
    Object localObject1;
    Object localObject2;
    label62: Bitmap.Config localConfig;
    label79: Object localObject3;
    label97: Object localObject4;
    label140: Object localObject5;
    label170: Object localObject6;
    label188: Object localObject7;
    label219: DiskCacheConfig localDiskCacheConfig1;
    label241: Object localObject8;
    label259: int i;
    label277: Object localObject9;
    label303: PoolFactory localPoolFactory;
    label339: Object localObject10;
    label361: Object localObject11;
    label383: DiskCacheConfig localDiskCacheConfig2;
    label410: Object localObject12;
    if (paramBuilder.mBitmapMemoryCacheParamsSupplier == null)
    {
      localObject1 = new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager)paramBuilder.mContext.getSystemService("activity"));
      this.mBitmapMemoryCacheParamsSupplier = ((Supplier)localObject1);
      if (paramBuilder.mBitmapMemoryCacheTrimStrategy != null)
        break label512;
      localObject2 = new BitmapMemoryCacheTrimStrategy();
      this.mBitmapMemoryCacheTrimStrategy = ((CountingMemoryCache.CacheTrimStrategy)localObject2);
      if (paramBuilder.mBitmapConfig != null)
        break label520;
      localConfig = Bitmap.Config.ARGB_8888;
      this.mBitmapConfig = localConfig;
      if (paramBuilder.mCacheKeyFactory != null)
        break label529;
      localObject3 = DefaultCacheKeyFactory.getInstance();
      this.mCacheKeyFactory = ((CacheKeyFactory)localObject3);
      this.mContext = ((Context)Preconditions.checkNotNull(paramBuilder.mContext));
      if (paramBuilder.mFileCacheFactory != null)
        break label538;
      localObject4 = new DiskStorageCacheFactory(new DynamicDefaultDiskStorageFactory());
      this.mFileCacheFactory = ((FileCacheFactory)localObject4);
      this.mDownsampleEnabled = paramBuilder.mDownsampleEnabled;
      if (paramBuilder.mEncodedMemoryCacheParamsSupplier != null)
        break label547;
      localObject5 = new DefaultEncodedMemoryCacheParamsSupplier();
      this.mEncodedMemoryCacheParamsSupplier = ((Supplier)localObject5);
      if (paramBuilder.mImageCacheStatsTracker != null)
        break label556;
      localObject6 = NoOpImageCacheStatsTracker.getInstance();
      this.mImageCacheStatsTracker = ((ImageCacheStatsTracker)localObject6);
      this.mImageDecoder = paramBuilder.mImageDecoder;
      if (paramBuilder.mIsPrefetchEnabledSupplier != null)
        break label565;
      localObject7 = new Supplier()
      {
        public Boolean get()
        {
          return Boolean.valueOf(true);
        }
      };
      this.mIsPrefetchEnabledSupplier = ((Supplier)localObject7);
      if (paramBuilder.mMainDiskCacheConfig != null)
        break label574;
      localDiskCacheConfig1 = getDefaultMainDiskCacheConfig(paramBuilder.mContext);
      this.mMainDiskCacheConfig = localDiskCacheConfig1;
      if (paramBuilder.mMemoryTrimmableRegistry != null)
        break label583;
      localObject8 = NoOpMemoryTrimmableRegistry.getInstance();
      this.mMemoryTrimmableRegistry = ((MemoryTrimmableRegistry)localObject8);
      if (paramBuilder.mHttpConnectionTimeout >= 0)
        break label592;
      i = 30000;
      this.mHttpNetworkTimeout = i;
      if (paramBuilder.mNetworkFetcher != null)
        break label601;
      localObject9 = new HttpUrlConnectionNetworkFetcher(this.mHttpNetworkTimeout);
      this.mNetworkFetcher = ((NetworkFetcher)localObject9);
      this.mPlatformBitmapFactory = paramBuilder.mPlatformBitmapFactory;
      if (paramBuilder.mPoolFactory != null)
        break label610;
      localPoolFactory = new PoolFactory(PoolConfig.newBuilder().build());
      this.mPoolFactory = localPoolFactory;
      if (paramBuilder.mProgressiveJpegConfig != null)
        break label619;
      localObject10 = new SimpleProgressiveJpegConfig();
      this.mProgressiveJpegConfig = ((ProgressiveJpegConfig)localObject10);
      if (paramBuilder.mRequestListeners != null)
        break label628;
      localObject11 = new HashSet();
      this.mRequestListeners = ((Set)localObject11);
      this.mResizeAndRotateEnabledForNetwork = paramBuilder.mResizeAndRotateEnabledForNetwork;
      if (paramBuilder.mSmallImageDiskCacheConfig != null)
        break label637;
      localDiskCacheConfig2 = this.mMainDiskCacheConfig;
      this.mSmallImageDiskCacheConfig = localDiskCacheConfig2;
      this.mImageDecoderConfig = paramBuilder.mImageDecoderConfig;
      int j = this.mPoolFactory.getFlexByteArrayPoolMaxNumThreads();
      if (paramBuilder.mExecutorSupplier != null)
        break label646;
      localObject12 = new DefaultExecutorSupplier(j);
      label451: this.mExecutorSupplier = ((ExecutorSupplier)localObject12);
      this.mDiskCacheEnabled = paramBuilder.mDiskCacheEnabled;
      WebpBitmapFactory localWebpBitmapFactory1 = this.mImagePipelineExperiments.getWebpBitmapFactory();
      if (localWebpBitmapFactory1 == null)
        break label655;
      HoneycombBitmapCreator localHoneycombBitmapCreator1 = new HoneycombBitmapCreator(getPoolFactory());
      setWebpBitmapFactory(localWebpBitmapFactory1, this.mImagePipelineExperiments, localHoneycombBitmapCreator1);
    }
    label512: label520: label529: label538: label547: label556: label565: label574: label583: label592: label601: label610: label619: label628: label637: WebpBitmapFactory localWebpBitmapFactory2;
    label646: label655: 
    do
    {
      do
      {
        return;
        localObject1 = paramBuilder.mBitmapMemoryCacheParamsSupplier;
        break;
        localObject2 = paramBuilder.mBitmapMemoryCacheTrimStrategy;
        break label62;
        localConfig = paramBuilder.mBitmapConfig;
        break label79;
        localObject3 = paramBuilder.mCacheKeyFactory;
        break label97;
        localObject4 = paramBuilder.mFileCacheFactory;
        break label140;
        localObject5 = paramBuilder.mEncodedMemoryCacheParamsSupplier;
        break label170;
        localObject6 = paramBuilder.mImageCacheStatsTracker;
        break label188;
        localObject7 = paramBuilder.mIsPrefetchEnabledSupplier;
        break label219;
        localDiskCacheConfig1 = paramBuilder.mMainDiskCacheConfig;
        break label241;
        localObject8 = paramBuilder.mMemoryTrimmableRegistry;
        break label259;
        i = paramBuilder.mHttpConnectionTimeout;
        break label277;
        localObject9 = paramBuilder.mNetworkFetcher;
        break label303;
        localPoolFactory = paramBuilder.mPoolFactory;
        break label339;
        localObject10 = paramBuilder.mProgressiveJpegConfig;
        break label361;
        localObject11 = paramBuilder.mRequestListeners;
        break label383;
        localDiskCacheConfig2 = paramBuilder.mSmallImageDiskCacheConfig;
        break label410;
        localObject12 = paramBuilder.mExecutorSupplier;
        break label451;
      }
      while ((!this.mImagePipelineExperiments.isWebpSupportEnabled()) || (!WebpSupportStatus.sIsWebpSupportRequired));
      localWebpBitmapFactory2 = WebpSupportStatus.loadWebpBitmapFactoryIfExists();
    }
    while (localWebpBitmapFactory2 == null);
    HoneycombBitmapCreator localHoneycombBitmapCreator2 = new HoneycombBitmapCreator(getPoolFactory());
    setWebpBitmapFactory(localWebpBitmapFactory2, this.mImagePipelineExperiments, localHoneycombBitmapCreator2);
  }

  public static DefaultImageRequestConfig getDefaultImageRequestConfig()
  {
    return sDefaultImageRequestConfig;
  }

  private static DiskCacheConfig getDefaultMainDiskCacheConfig(Context paramContext)
  {
    return DiskCacheConfig.newBuilder(paramContext).build();
  }

  public static Builder newBuilder(Context paramContext)
  {
    return new Builder(paramContext, null);
  }

  @VisibleForTesting
  static void resetDefaultRequestConfig()
  {
    sDefaultImageRequestConfig = new DefaultImageRequestConfig(null);
  }

  private static void setWebpBitmapFactory(WebpBitmapFactory paramWebpBitmapFactory, ImagePipelineExperiments paramImagePipelineExperiments, BitmapCreator paramBitmapCreator)
  {
    WebpSupportStatus.sWebpBitmapFactory = paramWebpBitmapFactory;
    WebpBitmapFactory.WebpErrorLogger localWebpErrorLogger = paramImagePipelineExperiments.getWebpErrorLogger();
    if (localWebpErrorLogger != null)
      paramWebpBitmapFactory.setWebpErrorLogger(localWebpErrorLogger);
    if (paramBitmapCreator != null)
      paramWebpBitmapFactory.setBitmapCreator(paramBitmapCreator);
  }

  public Bitmap.Config getBitmapConfig()
  {
    return this.mBitmapConfig;
  }

  public Supplier<MemoryCacheParams> getBitmapMemoryCacheParamsSupplier()
  {
    return this.mBitmapMemoryCacheParamsSupplier;
  }

  public CountingMemoryCache.CacheTrimStrategy getBitmapMemoryCacheTrimStrategy()
  {
    return this.mBitmapMemoryCacheTrimStrategy;
  }

  public CacheKeyFactory getCacheKeyFactory()
  {
    return this.mCacheKeyFactory;
  }

  public Context getContext()
  {
    return this.mContext;
  }

  public Supplier<MemoryCacheParams> getEncodedMemoryCacheParamsSupplier()
  {
    return this.mEncodedMemoryCacheParamsSupplier;
  }

  public ExecutorSupplier getExecutorSupplier()
  {
    return this.mExecutorSupplier;
  }

  public ImagePipelineExperiments getExperiments()
  {
    return this.mImagePipelineExperiments;
  }

  public FileCacheFactory getFileCacheFactory()
  {
    return this.mFileCacheFactory;
  }

  public ImageCacheStatsTracker getImageCacheStatsTracker()
  {
    return this.mImageCacheStatsTracker;
  }

  @Nullable
  public ImageDecoder getImageDecoder()
  {
    return this.mImageDecoder;
  }

  @Nullable
  public ImageDecoderConfig getImageDecoderConfig()
  {
    return this.mImageDecoderConfig;
  }

  public Supplier<Boolean> getIsPrefetchEnabledSupplier()
  {
    return this.mIsPrefetchEnabledSupplier;
  }

  public DiskCacheConfig getMainDiskCacheConfig()
  {
    return this.mMainDiskCacheConfig;
  }

  public MemoryTrimmableRegistry getMemoryTrimmableRegistry()
  {
    return this.mMemoryTrimmableRegistry;
  }

  public NetworkFetcher getNetworkFetcher()
  {
    return this.mNetworkFetcher;
  }

  @Nullable
  public PlatformBitmapFactory getPlatformBitmapFactory()
  {
    return this.mPlatformBitmapFactory;
  }

  public PoolFactory getPoolFactory()
  {
    return this.mPoolFactory;
  }

  public ProgressiveJpegConfig getProgressiveJpegConfig()
  {
    return this.mProgressiveJpegConfig;
  }

  public Set<RequestListener> getRequestListeners()
  {
    return Collections.unmodifiableSet(this.mRequestListeners);
  }

  public DiskCacheConfig getSmallImageDiskCacheConfig()
  {
    return this.mSmallImageDiskCacheConfig;
  }

  public boolean isDiskCacheEnabled()
  {
    return this.mDiskCacheEnabled;
  }

  public boolean isDownsampleEnabled()
  {
    return this.mDownsampleEnabled;
  }

  public boolean isResizeAndRotateEnabledForNetwork()
  {
    return this.mResizeAndRotateEnabledForNetwork;
  }

  public static class Builder
  {
    private Bitmap.Config mBitmapConfig;
    private Supplier<MemoryCacheParams> mBitmapMemoryCacheParamsSupplier;
    private CountingMemoryCache.CacheTrimStrategy mBitmapMemoryCacheTrimStrategy;
    private CacheKeyFactory mCacheKeyFactory;
    private final Context mContext;
    private boolean mDiskCacheEnabled = true;
    private boolean mDownsampleEnabled = false;
    private Supplier<MemoryCacheParams> mEncodedMemoryCacheParamsSupplier;
    private ExecutorSupplier mExecutorSupplier;
    private final ImagePipelineExperiments.Builder mExperimentsBuilder = new ImagePipelineExperiments.Builder(this);
    private FileCacheFactory mFileCacheFactory;
    private int mHttpConnectionTimeout = -1;
    private ImageCacheStatsTracker mImageCacheStatsTracker;
    private ImageDecoder mImageDecoder;
    private ImageDecoderConfig mImageDecoderConfig;
    private Supplier<Boolean> mIsPrefetchEnabledSupplier;
    private DiskCacheConfig mMainDiskCacheConfig;
    private MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    private NetworkFetcher mNetworkFetcher;
    private PlatformBitmapFactory mPlatformBitmapFactory;
    private PoolFactory mPoolFactory;
    private ProgressiveJpegConfig mProgressiveJpegConfig;
    private Set<RequestListener> mRequestListeners;
    private boolean mResizeAndRotateEnabledForNetwork = true;
    private DiskCacheConfig mSmallImageDiskCacheConfig;

    private Builder(Context paramContext)
    {
      this.mContext = ((Context)Preconditions.checkNotNull(paramContext));
    }

    public ImagePipelineConfig build()
    {
      return new ImagePipelineConfig(this, null);
    }

    public ImagePipelineExperiments.Builder experiment()
    {
      return this.mExperimentsBuilder;
    }

    public boolean isDiskCacheEnabled()
    {
      return this.mDiskCacheEnabled;
    }

    public boolean isDownsampleEnabled()
    {
      return this.mDownsampleEnabled;
    }

    public Builder setBitmapMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> paramSupplier)
    {
      this.mBitmapMemoryCacheParamsSupplier = ((Supplier)Preconditions.checkNotNull(paramSupplier));
      return this;
    }

    public Builder setBitmapMemoryCacheTrimStrategy(CountingMemoryCache.CacheTrimStrategy paramCacheTrimStrategy)
    {
      this.mBitmapMemoryCacheTrimStrategy = paramCacheTrimStrategy;
      return this;
    }

    public Builder setBitmapsConfig(Bitmap.Config paramConfig)
    {
      this.mBitmapConfig = paramConfig;
      return this;
    }

    public Builder setCacheKeyFactory(CacheKeyFactory paramCacheKeyFactory)
    {
      this.mCacheKeyFactory = paramCacheKeyFactory;
      return this;
    }

    public Builder setDiskCacheEnabled(boolean paramBoolean)
    {
      this.mDiskCacheEnabled = paramBoolean;
      return this;
    }

    public Builder setDownsampleEnabled(boolean paramBoolean)
    {
      this.mDownsampleEnabled = paramBoolean;
      return this;
    }

    public Builder setEncodedMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> paramSupplier)
    {
      this.mEncodedMemoryCacheParamsSupplier = ((Supplier)Preconditions.checkNotNull(paramSupplier));
      return this;
    }

    public Builder setExecutorSupplier(ExecutorSupplier paramExecutorSupplier)
    {
      this.mExecutorSupplier = paramExecutorSupplier;
      return this;
    }

    public Builder setFileCacheFactory(FileCacheFactory paramFileCacheFactory)
    {
      this.mFileCacheFactory = paramFileCacheFactory;
      return this;
    }

    public Builder setHttpConnectionTimeout(int paramInt)
    {
      this.mHttpConnectionTimeout = paramInt;
      return this;
    }

    public Builder setImageCacheStatsTracker(ImageCacheStatsTracker paramImageCacheStatsTracker)
    {
      this.mImageCacheStatsTracker = paramImageCacheStatsTracker;
      return this;
    }

    public Builder setImageDecoder(ImageDecoder paramImageDecoder)
    {
      this.mImageDecoder = paramImageDecoder;
      return this;
    }

    public Builder setImageDecoderConfig(ImageDecoderConfig paramImageDecoderConfig)
    {
      this.mImageDecoderConfig = paramImageDecoderConfig;
      return this;
    }

    public Builder setIsPrefetchEnabledSupplier(Supplier<Boolean> paramSupplier)
    {
      this.mIsPrefetchEnabledSupplier = paramSupplier;
      return this;
    }

    public Builder setMainDiskCacheConfig(DiskCacheConfig paramDiskCacheConfig)
    {
      this.mMainDiskCacheConfig = paramDiskCacheConfig;
      return this;
    }

    public Builder setMemoryTrimmableRegistry(MemoryTrimmableRegistry paramMemoryTrimmableRegistry)
    {
      this.mMemoryTrimmableRegistry = paramMemoryTrimmableRegistry;
      return this;
    }

    public Builder setNetworkFetcher(NetworkFetcher paramNetworkFetcher)
    {
      this.mNetworkFetcher = paramNetworkFetcher;
      return this;
    }

    public Builder setPlatformBitmapFactory(PlatformBitmapFactory paramPlatformBitmapFactory)
    {
      this.mPlatformBitmapFactory = paramPlatformBitmapFactory;
      return this;
    }

    public Builder setPoolFactory(PoolFactory paramPoolFactory)
    {
      this.mPoolFactory = paramPoolFactory;
      return this;
    }

    public Builder setProgressiveJpegConfig(ProgressiveJpegConfig paramProgressiveJpegConfig)
    {
      this.mProgressiveJpegConfig = paramProgressiveJpegConfig;
      return this;
    }

    public Builder setRequestListeners(Set<RequestListener> paramSet)
    {
      this.mRequestListeners = paramSet;
      return this;
    }

    public Builder setResizeAndRotateEnabledForNetwork(boolean paramBoolean)
    {
      this.mResizeAndRotateEnabledForNetwork = paramBoolean;
      return this;
    }

    public Builder setSmallImageDiskCacheConfig(DiskCacheConfig paramDiskCacheConfig)
    {
      this.mSmallImageDiskCacheConfig = paramDiskCacheConfig;
      return this;
    }
  }

  public static class DefaultImageRequestConfig
  {
    private boolean mProgressiveRenderingEnabled = false;

    public boolean isProgressiveRenderingEnabled()
    {
      return this.mProgressiveRenderingEnabled;
    }

    public void setProgressiveRenderingEnabled(boolean paramBoolean)
    {
      this.mProgressiveRenderingEnabled = paramBoolean;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.core.ImagePipelineConfig
 * JD-Core Version:    0.6.2
 */