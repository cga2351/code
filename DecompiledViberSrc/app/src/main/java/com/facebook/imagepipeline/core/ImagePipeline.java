package com.facebook.imagepipeline.core;

import android.net.Uri;
import b.g;
import b.i;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.SimpleDataSource;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter;
import com.facebook.imagepipeline.datasource.ProducerToDataSourceAdapter;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.CacheChoice;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class ImagePipeline
{
  private static final CancellationException PREFETCH_EXCEPTION = new CancellationException("Prefetching is not enabled");
  private final MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
  private final CacheKeyFactory mCacheKeyFactory;
  private final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
  private AtomicLong mIdCounter = new AtomicLong();
  private final Supplier<Boolean> mIsPrefetchEnabledSupplier;
  private final Supplier<Boolean> mLazyDataSource;
  private final BufferedDiskCache mMainBufferedDiskCache;
  private final ProducerSequenceFactory mProducerSequenceFactory;
  private final RequestListener mRequestListener;
  private final BufferedDiskCache mSmallImageBufferedDiskCache;
  private final Supplier<Boolean> mSuppressBitmapPrefetchingSupplier;
  private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

  public ImagePipeline(ProducerSequenceFactory paramProducerSequenceFactory, Set<RequestListener> paramSet, Supplier<Boolean> paramSupplier1, MemoryCache<CacheKey, CloseableImage> paramMemoryCache, MemoryCache<CacheKey, PooledByteBuffer> paramMemoryCache1, BufferedDiskCache paramBufferedDiskCache1, BufferedDiskCache paramBufferedDiskCache2, CacheKeyFactory paramCacheKeyFactory, ThreadHandoffProducerQueue paramThreadHandoffProducerQueue, Supplier<Boolean> paramSupplier2, Supplier<Boolean> paramSupplier3)
  {
    this.mProducerSequenceFactory = paramProducerSequenceFactory;
    this.mRequestListener = new ForwardingRequestListener(paramSet);
    this.mIsPrefetchEnabledSupplier = paramSupplier1;
    this.mBitmapMemoryCache = paramMemoryCache;
    this.mEncodedMemoryCache = paramMemoryCache1;
    this.mMainBufferedDiskCache = paramBufferedDiskCache1;
    this.mSmallImageBufferedDiskCache = paramBufferedDiskCache2;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mThreadHandoffProducerQueue = paramThreadHandoffProducerQueue;
    this.mSuppressBitmapPrefetchingSupplier = paramSupplier2;
    this.mLazyDataSource = paramSupplier3;
  }

  private String generateUniqueFutureId()
  {
    return String.valueOf(this.mIdCounter.getAndIncrement());
  }

  private RequestListener getRequestListenerForRequest(ImageRequest paramImageRequest, @Nullable RequestListener paramRequestListener)
  {
    if (paramRequestListener == null)
    {
      if (paramImageRequest.getRequestListener() == null)
        return this.mRequestListener;
      RequestListener[] arrayOfRequestListener3 = new RequestListener[2];
      arrayOfRequestListener3[0] = this.mRequestListener;
      arrayOfRequestListener3[1] = paramImageRequest.getRequestListener();
      return new ForwardingRequestListener(arrayOfRequestListener3);
    }
    if (paramImageRequest.getRequestListener() == null)
    {
      RequestListener[] arrayOfRequestListener2 = new RequestListener[2];
      arrayOfRequestListener2[0] = this.mRequestListener;
      arrayOfRequestListener2[1] = paramRequestListener;
      return new ForwardingRequestListener(arrayOfRequestListener2);
    }
    RequestListener[] arrayOfRequestListener1 = new RequestListener[3];
    arrayOfRequestListener1[0] = this.mRequestListener;
    arrayOfRequestListener1[1] = paramRequestListener;
    arrayOfRequestListener1[2] = paramImageRequest.getRequestListener();
    return new ForwardingRequestListener(arrayOfRequestListener1);
  }

  private Predicate<CacheKey> predicateForUri(final Uri paramUri)
  {
    return new Predicate()
    {
      public boolean apply(CacheKey paramAnonymousCacheKey)
      {
        return paramAnonymousCacheKey.containsUri(paramUri);
      }
    };
  }

  private <T> DataSource<CloseableReference<T>> submitFetchRequest(Producer<CloseableReference<T>> paramProducer, ImageRequest paramImageRequest, ImageRequest.RequestLevel paramRequestLevel, Object paramObject, @Nullable RequestListener paramRequestListener)
  {
    RequestListener localRequestListener = getRequestListenerForRequest(paramImageRequest, paramRequestListener);
    while (true)
    {
      try
      {
        ImageRequest.RequestLevel localRequestLevel = ImageRequest.RequestLevel.getMax(paramImageRequest.getLowestPermittedRequestLevel(), paramRequestLevel);
        String str = generateUniqueFutureId();
        if (!paramImageRequest.getProgressiveRenderingEnabled())
        {
          boolean bool2 = UriUtil.isNetworkUri(paramImageRequest.getSourceUri());
          bool1 = false;
          if (bool2)
          {
            DataSource localDataSource = CloseableProducerToDataSourceAdapter.create(paramProducer, new SettableProducerContext(paramImageRequest, str, localRequestListener, paramObject, localRequestLevel, false, bool1, paramImageRequest.getPriority()), localRequestListener);
            return localDataSource;
          }
        }
      }
      catch (Exception localException)
      {
        return DataSources.immediateFailedDataSource(localException);
      }
      boolean bool1 = true;
    }
  }

  private DataSource<Void> submitPrefetchRequest(Producer<Void> paramProducer, ImageRequest paramImageRequest, ImageRequest.RequestLevel paramRequestLevel, Object paramObject, Priority paramPriority)
  {
    RequestListener localRequestListener = getRequestListenerForRequest(paramImageRequest, null);
    try
    {
      ImageRequest.RequestLevel localRequestLevel = ImageRequest.RequestLevel.getMax(paramImageRequest.getLowestPermittedRequestLevel(), paramRequestLevel);
      DataSource localDataSource = ProducerToDataSourceAdapter.create(paramProducer, new SettableProducerContext(paramImageRequest, generateUniqueFutureId(), localRequestListener, paramObject, localRequestLevel, true, false, paramPriority), localRequestListener);
      return localDataSource;
    }
    catch (Exception localException)
    {
      return DataSources.immediateFailedDataSource(localException);
    }
  }

  public void clearCaches()
  {
    clearMemoryCaches();
    clearDiskCaches();
  }

  public void clearDiskCaches()
  {
    this.mMainBufferedDiskCache.clearAll();
    this.mSmallImageBufferedDiskCache.clearAll();
  }

  public void clearMemoryCaches()
  {
    Predicate local4 = new Predicate()
    {
      public boolean apply(CacheKey paramAnonymousCacheKey)
      {
        return true;
      }
    };
    this.mBitmapMemoryCache.removeAll(local4);
    this.mEncodedMemoryCache.removeAll(local4);
  }

  public void evictFromCache(Uri paramUri)
  {
    evictFromMemoryCache(paramUri);
    evictFromDiskCache(paramUri);
  }

  public void evictFromDiskCache(Uri paramUri)
  {
    evictFromDiskCache(ImageRequest.fromUri(paramUri));
  }

  public void evictFromDiskCache(ImageRequest paramImageRequest)
  {
    CacheKey localCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(paramImageRequest, null);
    this.mMainBufferedDiskCache.remove(localCacheKey);
    this.mSmallImageBufferedDiskCache.remove(localCacheKey);
  }

  public void evictFromMemoryCache(Uri paramUri)
  {
    Predicate localPredicate = predicateForUri(paramUri);
    this.mBitmapMemoryCache.removeAll(localPredicate);
    this.mEncodedMemoryCache.removeAll(localPredicate);
  }

  public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest paramImageRequest, Object paramObject)
  {
    return fetchDecodedImage(paramImageRequest, paramObject, ImageRequest.RequestLevel.FULL_FETCH);
  }

  public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest paramImageRequest, Object paramObject, @Nullable RequestListener paramRequestListener)
  {
    return fetchDecodedImage(paramImageRequest, paramObject, ImageRequest.RequestLevel.FULL_FETCH, paramRequestListener);
  }

  public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest paramImageRequest, Object paramObject, ImageRequest.RequestLevel paramRequestLevel)
  {
    return fetchDecodedImage(paramImageRequest, paramObject, paramRequestLevel, null);
  }

  public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest paramImageRequest, Object paramObject, ImageRequest.RequestLevel paramRequestLevel, @Nullable RequestListener paramRequestListener)
  {
    try
    {
      DataSource localDataSource = submitFetchRequest(this.mProducerSequenceFactory.getDecodedImageProducerSequence(paramImageRequest), paramImageRequest, paramRequestLevel, paramObject, paramRequestListener);
      return localDataSource;
    }
    catch (Exception localException)
    {
      return DataSources.immediateFailedDataSource(localException);
    }
  }

  public DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(ImageRequest paramImageRequest, Object paramObject)
  {
    return fetchEncodedImage(paramImageRequest, paramObject, null);
  }

  public DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(ImageRequest paramImageRequest, Object paramObject, @Nullable RequestListener paramRequestListener)
  {
    Preconditions.checkNotNull(paramImageRequest.getSourceUri());
    while (true)
    {
      try
      {
        Producer localProducer = this.mProducerSequenceFactory.getEncodedImageProducerSequence(paramImageRequest);
        if (paramImageRequest.getResizeOptions() != null)
        {
          localImageRequest = ImageRequestBuilder.fromRequest(paramImageRequest).setResizeOptions(null).build();
          DataSource localDataSource = submitFetchRequest(localProducer, localImageRequest, ImageRequest.RequestLevel.FULL_FETCH, paramObject, paramRequestListener);
          return localDataSource;
        }
      }
      catch (Exception localException)
      {
        return DataSources.immediateFailedDataSource(localException);
      }
      ImageRequest localImageRequest = paramImageRequest;
    }
  }

  public DataSource<CloseableReference<CloseableImage>> fetchImageFromBitmapCache(ImageRequest paramImageRequest, Object paramObject)
  {
    return fetchDecodedImage(paramImageRequest, paramObject, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE);
  }

  public MemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache()
  {
    return this.mBitmapMemoryCache;
  }

  public CacheKeyFactory getCacheKeyFactory()
  {
    return this.mCacheKeyFactory;
  }

  public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(final ImageRequest paramImageRequest, final Object paramObject, final ImageRequest.RequestLevel paramRequestLevel)
  {
    return new Supplier()
    {
      public DataSource<CloseableReference<CloseableImage>> get()
      {
        return ImagePipeline.this.fetchDecodedImage(paramImageRequest, paramObject, paramRequestLevel);
      }

      public String toString()
      {
        return Objects.toStringHelper(this).add("uri", paramImageRequest.getSourceUri()).toString();
      }
    };
  }

  public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(final ImageRequest paramImageRequest, final Object paramObject, final ImageRequest.RequestLevel paramRequestLevel, @Nullable final RequestListener paramRequestListener)
  {
    return new Supplier()
    {
      public DataSource<CloseableReference<CloseableImage>> get()
      {
        return ImagePipeline.this.fetchDecodedImage(paramImageRequest, paramObject, paramRequestLevel, paramRequestListener);
      }

      public String toString()
      {
        return Objects.toStringHelper(this).add("uri", paramImageRequest.getSourceUri()).toString();
      }
    };
  }

  public Supplier<DataSource<CloseableReference<PooledByteBuffer>>> getEncodedImageDataSourceSupplier(final ImageRequest paramImageRequest, final Object paramObject)
  {
    return new Supplier()
    {
      public DataSource<CloseableReference<PooledByteBuffer>> get()
      {
        return ImagePipeline.this.fetchEncodedImage(paramImageRequest, paramObject);
      }

      public String toString()
      {
        return Objects.toStringHelper(this).add("uri", paramImageRequest.getSourceUri()).toString();
      }
    };
  }

  public boolean isInBitmapMemoryCache(Uri paramUri)
  {
    if (paramUri == null)
      return false;
    Predicate localPredicate = predicateForUri(paramUri);
    return this.mBitmapMemoryCache.contains(localPredicate);
  }

  public boolean isInBitmapMemoryCache(ImageRequest paramImageRequest)
  {
    if (paramImageRequest == null)
      return false;
    CacheKey localCacheKey = this.mCacheKeyFactory.getBitmapCacheKey(paramImageRequest, null);
    CloseableReference localCloseableReference = this.mBitmapMemoryCache.get(localCacheKey);
    try
    {
      boolean bool = CloseableReference.isValid(localCloseableReference);
      return bool;
    }
    finally
    {
      CloseableReference.closeSafely(localCloseableReference);
    }
  }

  public DataSource<Boolean> isInDiskCache(Uri paramUri)
  {
    return isInDiskCache(ImageRequest.fromUri(paramUri));
  }

  public DataSource<Boolean> isInDiskCache(ImageRequest paramImageRequest)
  {
    final CacheKey localCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(paramImageRequest, null);
    final SimpleDataSource localSimpleDataSource = SimpleDataSource.create();
    this.mMainBufferedDiskCache.contains(localCacheKey).b(new g()
    {
      public i<Boolean> then(i<Boolean> paramAnonymousi)
        throws Exception
      {
        if ((!paramAnonymousi.c()) && (!paramAnonymousi.d()) && (((Boolean)paramAnonymousi.e()).booleanValue()))
          return i.a(Boolean.valueOf(true));
        return ImagePipeline.this.mSmallImageBufferedDiskCache.contains(localCacheKey);
      }
    }).a(new g()
    {
      public Void then(i<Boolean> paramAnonymousi)
        throws Exception
      {
        SimpleDataSource localSimpleDataSource = localSimpleDataSource;
        if ((!paramAnonymousi.c()) && (!paramAnonymousi.d()) && (((Boolean)paramAnonymousi.e()).booleanValue()));
        for (boolean bool = true; ; bool = false)
        {
          localSimpleDataSource.setResult(Boolean.valueOf(bool));
          return null;
        }
      }
    });
    return localSimpleDataSource;
  }

  public boolean isInDiskCacheSync(Uri paramUri)
  {
    return (isInDiskCacheSync(paramUri, ImageRequest.CacheChoice.SMALL)) || (isInDiskCacheSync(paramUri, ImageRequest.CacheChoice.DEFAULT));
  }

  public boolean isInDiskCacheSync(Uri paramUri, ImageRequest.CacheChoice paramCacheChoice)
  {
    return isInDiskCacheSync(ImageRequestBuilder.newBuilderWithSource(paramUri).setCacheChoice(paramCacheChoice).build());
  }

  public boolean isInDiskCacheSync(ImageRequest paramImageRequest)
  {
    CacheKey localCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(paramImageRequest, null);
    ImageRequest.CacheChoice localCacheChoice = paramImageRequest.getCacheChoice();
    switch (8.$SwitchMap$com$facebook$imagepipeline$request$ImageRequest$CacheChoice[localCacheChoice.ordinal()])
    {
    default:
      return false;
    case 1:
      return this.mMainBufferedDiskCache.diskCheckSync(localCacheKey);
    case 2:
    }
    return this.mSmallImageBufferedDiskCache.diskCheckSync(localCacheKey);
  }

  public Supplier<Boolean> isLazyDataSource()
  {
    return this.mLazyDataSource;
  }

  public boolean isPaused()
  {
    return this.mThreadHandoffProducerQueue.isQueueing();
  }

  public void pause()
  {
    this.mThreadHandoffProducerQueue.startQueueing();
  }

  public DataSource<Void> prefetchToBitmapCache(ImageRequest paramImageRequest, Object paramObject)
  {
    if (!((Boolean)this.mIsPrefetchEnabledSupplier.get()).booleanValue())
      return DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
    try
    {
      if (((Boolean)this.mSuppressBitmapPrefetchingSupplier.get()).booleanValue());
      Producer localProducer;
      for (Object localObject = this.mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(paramImageRequest); ; localObject = localProducer)
      {
        return submitPrefetchRequest((Producer)localObject, paramImageRequest, ImageRequest.RequestLevel.FULL_FETCH, paramObject, Priority.MEDIUM);
        localProducer = this.mProducerSequenceFactory.getDecodedImagePrefetchProducerSequence(paramImageRequest);
      }
    }
    catch (Exception localException)
    {
      return DataSources.immediateFailedDataSource(localException);
    }
  }

  public DataSource<Void> prefetchToDiskCache(ImageRequest paramImageRequest, Object paramObject)
  {
    return prefetchToDiskCache(paramImageRequest, paramObject, Priority.MEDIUM);
  }

  public DataSource<Void> prefetchToDiskCache(ImageRequest paramImageRequest, Object paramObject, Priority paramPriority)
  {
    if (!((Boolean)this.mIsPrefetchEnabledSupplier.get()).booleanValue())
      return DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
    try
    {
      DataSource localDataSource = submitPrefetchRequest(this.mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(paramImageRequest), paramImageRequest, ImageRequest.RequestLevel.FULL_FETCH, paramObject, paramPriority);
      return localDataSource;
    }
    catch (Exception localException)
    {
      return DataSources.immediateFailedDataSource(localException);
    }
  }

  public void resume()
  {
    this.mThreadHandoffProducerQueue.stopQueuing();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.core.ImagePipeline
 * JD-Core Version:    0.6.2
 */