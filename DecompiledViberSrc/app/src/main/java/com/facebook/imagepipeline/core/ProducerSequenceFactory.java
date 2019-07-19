package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.net.Uri;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheKeyMultiplexProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.DiskCacheWriteProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.LocalContentUriFetchProducer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.PartialDiskCacheProducer;
import com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.PostprocessorProducer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.ResizeAndRotateProducer;
import com.facebook.imagepipeline.producers.SwallowResultProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThrottlingProducer;
import com.facebook.imagepipeline.producers.ThumbnailBranchProducer;
import com.facebook.imagepipeline.producers.ThumbnailProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.util.HashMap;
import java.util.Map;

public class ProducerSequenceFactory
{

  @VisibleForTesting
  Producer<EncodedImage> mBackgroundLocalFileFetchToEncodedMemorySequence;

  @VisibleForTesting
  Producer<EncodedImage> mBackgroundNetworkFetchToEncodedMemorySequence;

  @VisibleForTesting
  Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> mBitmapPrepareSequences;

  @VisibleForTesting
  Map<Producer<CloseableReference<CloseableImage>>, Producer<Void>> mCloseableImagePrefetchSequences;
  private Producer<EncodedImage> mCommonNetworkFetchToEncodedMemorySequence;
  private final ContentResolver mContentResolver;

  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mDataFetchSequence;
  private final boolean mDiskCacheEnabled;

  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mLocalAssetFetchSequence;

  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mLocalContentUriFetchSequence;

  @VisibleForTesting
  Producer<CloseableReference<PooledByteBuffer>> mLocalFileEncodedImageProducerSequence;

  @VisibleForTesting
  Producer<Void> mLocalFileFetchToEncodedMemoryPrefetchSequence;

  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mLocalImageFileFetchSequence;

  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mLocalResourceFetchSequence;

  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mLocalVideoFileFetchSequence;

  @VisibleForTesting
  Producer<CloseableReference<PooledByteBuffer>> mNetworkEncodedImageProducerSequence;

  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mNetworkFetchSequence;

  @VisibleForTesting
  Producer<Void> mNetworkFetchToEncodedMemoryPrefetchSequence;
  private final NetworkFetcher mNetworkFetcher;
  private final boolean mPartialImageCachingEnabled;

  @VisibleForTesting
  Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> mPostprocessorSequences;
  private final ProducerFactory mProducerFactory;

  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mQualifiedResourceFetchSequence;
  private final boolean mResizeAndRotateEnabledForNetwork;
  private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;
  private final boolean mUseBitmapPrepareToDraw;
  private final boolean mUseDownsamplingRatio;
  private final boolean mWebpSupportEnabled;

  public ProducerSequenceFactory(ContentResolver paramContentResolver, ProducerFactory paramProducerFactory, NetworkFetcher paramNetworkFetcher, boolean paramBoolean1, boolean paramBoolean2, ThreadHandoffProducerQueue paramThreadHandoffProducerQueue, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    this.mContentResolver = paramContentResolver;
    this.mProducerFactory = paramProducerFactory;
    this.mNetworkFetcher = paramNetworkFetcher;
    this.mResizeAndRotateEnabledForNetwork = paramBoolean1;
    this.mWebpSupportEnabled = paramBoolean2;
    this.mPostprocessorSequences = new HashMap();
    this.mCloseableImagePrefetchSequences = new HashMap();
    this.mBitmapPrepareSequences = new HashMap();
    this.mThreadHandoffProducerQueue = paramThreadHandoffProducerQueue;
    this.mUseDownsamplingRatio = paramBoolean3;
    this.mUseBitmapPrepareToDraw = paramBoolean4;
    this.mPartialImageCachingEnabled = paramBoolean5;
    this.mDiskCacheEnabled = paramBoolean6;
  }

  private Producer<EncodedImage> getBackgroundLocalFileFetchToEncodeMemorySequence()
  {
    try
    {
      if (this.mBackgroundLocalFileFetchToEncodedMemorySequence == null)
      {
        Producer localProducer2 = newEncodedCacheMultiplexToTranscodeSequence(this.mProducerFactory.newLocalFileFetchProducer());
        this.mBackgroundLocalFileFetchToEncodedMemorySequence = this.mProducerFactory.newBackgroundThreadHandoffProducer(localProducer2, this.mThreadHandoffProducerQueue);
      }
      Producer localProducer1 = this.mBackgroundLocalFileFetchToEncodedMemorySequence;
      return localProducer1;
    }
    finally
    {
    }
  }

  private Producer<EncodedImage> getBackgroundNetworkFetchToEncodedMemorySequence()
  {
    try
    {
      if (this.mBackgroundNetworkFetchToEncodedMemorySequence == null)
        this.mBackgroundNetworkFetchToEncodedMemorySequence = this.mProducerFactory.newBackgroundThreadHandoffProducer(getCommonNetworkFetchToEncodedMemorySequence(), this.mThreadHandoffProducerQueue);
      Producer localProducer = this.mBackgroundNetworkFetchToEncodedMemorySequence;
      return localProducer;
    }
    finally
    {
    }
  }

  private Producer<CloseableReference<CloseableImage>> getBasicDecodedImageSequence(ImageRequest paramImageRequest)
  {
    Preconditions.checkNotNull(paramImageRequest);
    Uri localUri = paramImageRequest.getSourceUri();
    Preconditions.checkNotNull(localUri, "Uri is null.");
    switch (paramImageRequest.getSourceUriType())
    {
    case 1:
    default:
      throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + getShortenedUriString(localUri));
    case 0:
      return getNetworkFetchSequence();
    case 2:
      return getLocalVideoFileFetchSequence();
    case 3:
      return getLocalImageFileFetchSequence();
    case 4:
      if (MediaUtils.isVideo(this.mContentResolver.getType(localUri)))
        return getLocalVideoFileFetchSequence();
      return getLocalContentUriFetchSequence();
    case 5:
      return getLocalAssetFetchSequence();
    case 6:
      return getLocalResourceFetchSequence();
    case 8:
      return getQualifiedResourceFetchSequence();
    case 7:
    }
    return getDataFetchSequence();
  }

  private Producer<CloseableReference<CloseableImage>> getBitmapPrepareSequence(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    try
    {
      Object localObject2 = (Producer)this.mBitmapPrepareSequences.get(paramProducer);
      if (localObject2 == null)
      {
        localObject2 = this.mProducerFactory.newBitmapPrepareProducer(paramProducer);
        this.mBitmapPrepareSequences.put(paramProducer, localObject2);
      }
      return localObject2;
    }
    finally
    {
    }
  }

  private Producer<EncodedImage> getCommonNetworkFetchToEncodedMemorySequence()
  {
    try
    {
      if (this.mCommonNetworkFetchToEncodedMemorySequence == null)
      {
        this.mCommonNetworkFetchToEncodedMemorySequence = ProducerFactory.newAddImageTransformMetaDataProducer(newEncodedCacheMultiplexToTranscodeSequence(this.mProducerFactory.newNetworkFetchProducer(this.mNetworkFetcher)));
        this.mCommonNetworkFetchToEncodedMemorySequence = this.mProducerFactory.newResizeAndRotateProducer(this.mCommonNetworkFetchToEncodedMemorySequence, this.mResizeAndRotateEnabledForNetwork, this.mUseDownsamplingRatio);
      }
      Producer localProducer = this.mCommonNetworkFetchToEncodedMemorySequence;
      return localProducer;
    }
    finally
    {
    }
  }

  private Producer<CloseableReference<CloseableImage>> getDataFetchSequence()
  {
    try
    {
      if (this.mDataFetchSequence == null)
      {
        Object localObject2 = this.mProducerFactory.newDataFetchProducer();
        if ((WebpSupportStatus.sIsWebpSupportRequired) && ((!this.mWebpSupportEnabled) || (WebpSupportStatus.sWebpBitmapFactory == null)))
          localObject2 = this.mProducerFactory.newWebpTranscodeProducer((Producer)localObject2);
        AddImageTransformMetaDataProducer localAddImageTransformMetaDataProducer = ProducerFactory.newAddImageTransformMetaDataProducer((Producer)localObject2);
        this.mDataFetchSequence = newBitmapCacheGetToDecodeSequence(this.mProducerFactory.newResizeAndRotateProducer(localAddImageTransformMetaDataProducer, true, this.mUseDownsamplingRatio));
      }
      Producer localProducer = this.mDataFetchSequence;
      return localProducer;
    }
    finally
    {
    }
  }

  private Producer<Void> getDecodedImagePrefetchSequence(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    try
    {
      if (!this.mCloseableImagePrefetchSequences.containsKey(paramProducer))
      {
        SwallowResultProducer localSwallowResultProducer = ProducerFactory.newSwallowResultProducer(paramProducer);
        this.mCloseableImagePrefetchSequences.put(paramProducer, localSwallowResultProducer);
      }
      Producer localProducer = (Producer)this.mCloseableImagePrefetchSequences.get(paramProducer);
      return localProducer;
    }
    finally
    {
    }
  }

  private Producer<CloseableReference<CloseableImage>> getLocalAssetFetchSequence()
  {
    try
    {
      if (this.mLocalAssetFetchSequence == null)
        this.mLocalAssetFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalAssetFetchProducer());
      Producer localProducer = this.mLocalAssetFetchSequence;
      return localProducer;
    }
    finally
    {
    }
  }

  private Producer<CloseableReference<CloseableImage>> getLocalContentUriFetchSequence()
  {
    try
    {
      if (this.mLocalContentUriFetchSequence == null)
      {
        LocalContentUriFetchProducer localLocalContentUriFetchProducer = this.mProducerFactory.newLocalContentUriFetchProducer();
        ThumbnailProducer[] arrayOfThumbnailProducer = new ThumbnailProducer[2];
        arrayOfThumbnailProducer[0] = this.mProducerFactory.newLocalContentUriThumbnailFetchProducer();
        arrayOfThumbnailProducer[1] = this.mProducerFactory.newLocalExifThumbnailProducer();
        this.mLocalContentUriFetchSequence = newBitmapCacheGetToLocalTransformSequence(localLocalContentUriFetchProducer, arrayOfThumbnailProducer);
      }
      Producer localProducer = this.mLocalContentUriFetchSequence;
      return localProducer;
    }
    finally
    {
    }
  }

  private Producer<Void> getLocalFileFetchToEncodedMemoryPrefetchSequence()
  {
    try
    {
      if (this.mLocalFileFetchToEncodedMemoryPrefetchSequence == null)
        this.mLocalFileFetchToEncodedMemoryPrefetchSequence = ProducerFactory.newSwallowResultProducer(getBackgroundLocalFileFetchToEncodeMemorySequence());
      Producer localProducer = this.mLocalFileFetchToEncodedMemoryPrefetchSequence;
      return localProducer;
    }
    finally
    {
    }
  }

  private Producer<CloseableReference<CloseableImage>> getLocalImageFileFetchSequence()
  {
    try
    {
      if (this.mLocalImageFileFetchSequence == null)
        this.mLocalImageFileFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalFileFetchProducer());
      Producer localProducer = this.mLocalImageFileFetchSequence;
      return localProducer;
    }
    finally
    {
    }
  }

  private Producer<CloseableReference<CloseableImage>> getLocalResourceFetchSequence()
  {
    try
    {
      if (this.mLocalResourceFetchSequence == null)
        this.mLocalResourceFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalResourceFetchProducer());
      Producer localProducer = this.mLocalResourceFetchSequence;
      return localProducer;
    }
    finally
    {
    }
  }

  private Producer<CloseableReference<CloseableImage>> getLocalVideoFileFetchSequence()
  {
    try
    {
      if (this.mLocalVideoFileFetchSequence == null)
        this.mLocalVideoFileFetchSequence = newBitmapCacheGetToBitmapCacheSequence(this.mProducerFactory.newLocalVideoThumbnailProducer());
      Producer localProducer = this.mLocalVideoFileFetchSequence;
      return localProducer;
    }
    finally
    {
    }
  }

  private Producer<CloseableReference<CloseableImage>> getNetworkFetchSequence()
  {
    try
    {
      if (this.mNetworkFetchSequence == null)
        this.mNetworkFetchSequence = newBitmapCacheGetToDecodeSequence(getCommonNetworkFetchToEncodedMemorySequence());
      Producer localProducer = this.mNetworkFetchSequence;
      return localProducer;
    }
    finally
    {
    }
  }

  private Producer<Void> getNetworkFetchToEncodedMemoryPrefetchSequence()
  {
    try
    {
      if (this.mNetworkFetchToEncodedMemoryPrefetchSequence == null)
        this.mNetworkFetchToEncodedMemoryPrefetchSequence = ProducerFactory.newSwallowResultProducer(getBackgroundNetworkFetchToEncodedMemorySequence());
      Producer localProducer = this.mNetworkFetchToEncodedMemoryPrefetchSequence;
      return localProducer;
    }
    finally
    {
    }
  }

  private Producer<CloseableReference<CloseableImage>> getPostprocessorSequence(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    try
    {
      if (!this.mPostprocessorSequences.containsKey(paramProducer))
      {
        PostprocessorProducer localPostprocessorProducer = this.mProducerFactory.newPostprocessorProducer(paramProducer);
        PostprocessedBitmapMemoryCacheProducer localPostprocessedBitmapMemoryCacheProducer = this.mProducerFactory.newPostprocessorBitmapMemoryCacheProducer(localPostprocessorProducer);
        this.mPostprocessorSequences.put(paramProducer, localPostprocessedBitmapMemoryCacheProducer);
      }
      Producer localProducer = (Producer)this.mPostprocessorSequences.get(paramProducer);
      return localProducer;
    }
    finally
    {
    }
  }

  private Producer<CloseableReference<CloseableImage>> getQualifiedResourceFetchSequence()
  {
    try
    {
      if (this.mQualifiedResourceFetchSequence == null)
        this.mQualifiedResourceFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newQualifiedResourceFetchProducer());
      Producer localProducer = this.mQualifiedResourceFetchSequence;
      return localProducer;
    }
    finally
    {
    }
  }

  private static String getShortenedUriString(Uri paramUri)
  {
    String str = String.valueOf(paramUri);
    if (str.length() > 30)
      str = str.substring(0, 30) + "...";
    return str;
  }

  private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToBitmapCacheSequence(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    BitmapMemoryCacheProducer localBitmapMemoryCacheProducer = this.mProducerFactory.newBitmapMemoryCacheProducer(paramProducer);
    BitmapMemoryCacheKeyMultiplexProducer localBitmapMemoryCacheKeyMultiplexProducer = this.mProducerFactory.newBitmapMemoryCacheKeyMultiplexProducer(localBitmapMemoryCacheProducer);
    ThreadHandoffProducer localThreadHandoffProducer = this.mProducerFactory.newBackgroundThreadHandoffProducer(localBitmapMemoryCacheKeyMultiplexProducer, this.mThreadHandoffProducerQueue);
    return this.mProducerFactory.newBitmapMemoryCacheGetProducer(localThreadHandoffProducer);
  }

  private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToDecodeSequence(Producer<EncodedImage> paramProducer)
  {
    return newBitmapCacheGetToBitmapCacheSequence(this.mProducerFactory.newDecodeProducer(paramProducer));
  }

  private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToLocalTransformSequence(Producer<EncodedImage> paramProducer)
  {
    ThumbnailProducer[] arrayOfThumbnailProducer = new ThumbnailProducer[1];
    arrayOfThumbnailProducer[0] = this.mProducerFactory.newLocalExifThumbnailProducer();
    return newBitmapCacheGetToLocalTransformSequence(paramProducer, arrayOfThumbnailProducer);
  }

  private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToLocalTransformSequence(Producer<EncodedImage> paramProducer, ThumbnailProducer<EncodedImage>[] paramArrayOfThumbnailProducer)
  {
    return newBitmapCacheGetToDecodeSequence(newLocalTransformationsSequence(newEncodedCacheMultiplexToTranscodeSequence(paramProducer), paramArrayOfThumbnailProducer));
  }

  private Producer<EncodedImage> newDiskCacheSequence(Producer<EncodedImage> paramProducer)
  {
    PartialDiskCacheProducer localPartialDiskCacheProducer;
    if (this.mPartialImageCachingEnabled)
      localPartialDiskCacheProducer = this.mProducerFactory.newPartialDiskCacheProducer(paramProducer);
    for (DiskCacheWriteProducer localDiskCacheWriteProducer = this.mProducerFactory.newDiskCacheWriteProducer(localPartialDiskCacheProducer); ; localDiskCacheWriteProducer = this.mProducerFactory.newDiskCacheWriteProducer(paramProducer))
      return this.mProducerFactory.newDiskCacheReadProducer(localDiskCacheWriteProducer);
  }

  private Producer<EncodedImage> newEncodedCacheMultiplexToTranscodeSequence(Producer<EncodedImage> paramProducer)
  {
    if ((WebpSupportStatus.sIsWebpSupportRequired) && ((!this.mWebpSupportEnabled) || (WebpSupportStatus.sWebpBitmapFactory == null)))
      paramProducer = this.mProducerFactory.newWebpTranscodeProducer(paramProducer);
    if (this.mDiskCacheEnabled)
      paramProducer = newDiskCacheSequence(paramProducer);
    EncodedMemoryCacheProducer localEncodedMemoryCacheProducer = this.mProducerFactory.newEncodedMemoryCacheProducer(paramProducer);
    return this.mProducerFactory.newEncodedCacheKeyMultiplexProducer(localEncodedMemoryCacheProducer);
  }

  private Producer<EncodedImage> newLocalThumbnailProducer(ThumbnailProducer<EncodedImage>[] paramArrayOfThumbnailProducer)
  {
    ThumbnailBranchProducer localThumbnailBranchProducer = this.mProducerFactory.newThumbnailBranchProducer(paramArrayOfThumbnailProducer);
    return this.mProducerFactory.newResizeAndRotateProducer(localThumbnailBranchProducer, true, this.mUseDownsamplingRatio);
  }

  private Producer<EncodedImage> newLocalTransformationsSequence(Producer<EncodedImage> paramProducer, ThumbnailProducer<EncodedImage>[] paramArrayOfThumbnailProducer)
  {
    AddImageTransformMetaDataProducer localAddImageTransformMetaDataProducer = ProducerFactory.newAddImageTransformMetaDataProducer(paramProducer);
    ResizeAndRotateProducer localResizeAndRotateProducer = this.mProducerFactory.newResizeAndRotateProducer(localAddImageTransformMetaDataProducer, true, this.mUseDownsamplingRatio);
    ThrottlingProducer localThrottlingProducer = this.mProducerFactory.newThrottlingProducer(localResizeAndRotateProducer);
    return ProducerFactory.newBranchOnSeparateImagesProducer(newLocalThumbnailProducer(paramArrayOfThumbnailProducer), localThrottlingProducer);
  }

  private static void validateEncodedImageRequest(ImageRequest paramImageRequest)
  {
    Preconditions.checkNotNull(paramImageRequest);
    if (paramImageRequest.getLowestPermittedRequestLevel().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      return;
    }
  }

  public Producer<Void> getDecodedImagePrefetchProducerSequence(ImageRequest paramImageRequest)
  {
    Producer localProducer = getBasicDecodedImageSequence(paramImageRequest);
    if (this.mUseBitmapPrepareToDraw)
      localProducer = getBitmapPrepareSequence(localProducer);
    return getDecodedImagePrefetchSequence(localProducer);
  }

  public Producer<CloseableReference<CloseableImage>> getDecodedImageProducerSequence(ImageRequest paramImageRequest)
  {
    Producer localProducer = getBasicDecodedImageSequence(paramImageRequest);
    if (paramImageRequest.getPostprocessor() != null)
      localProducer = getPostprocessorSequence(localProducer);
    if (this.mUseBitmapPrepareToDraw)
      localProducer = getBitmapPrepareSequence(localProducer);
    return localProducer;
  }

  public Producer<Void> getEncodedImagePrefetchProducerSequence(ImageRequest paramImageRequest)
  {
    validateEncodedImageRequest(paramImageRequest);
    switch (paramImageRequest.getSourceUriType())
    {
    case 1:
    default:
      Uri localUri = paramImageRequest.getSourceUri();
      throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + getShortenedUriString(localUri));
    case 0:
      return getNetworkFetchToEncodedMemoryPrefetchSequence();
    case 2:
    case 3:
    }
    return getLocalFileFetchToEncodedMemoryPrefetchSequence();
  }

  public Producer<CloseableReference<PooledByteBuffer>> getEncodedImageProducerSequence(ImageRequest paramImageRequest)
  {
    validateEncodedImageRequest(paramImageRequest);
    Uri localUri = paramImageRequest.getSourceUri();
    switch (paramImageRequest.getSourceUriType())
    {
    case 1:
    default:
      throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + getShortenedUriString(localUri));
    case 0:
      return getNetworkFetchEncodedImageProducerSequence();
    case 2:
    case 3:
    }
    return getLocalFileFetchEncodedImageProducerSequence();
  }

  public Producer<CloseableReference<PooledByteBuffer>> getLocalFileFetchEncodedImageProducerSequence()
  {
    try
    {
      if (this.mLocalFileEncodedImageProducerSequence == null)
        this.mLocalFileEncodedImageProducerSequence = new RemoveImageTransformMetaDataProducer(getBackgroundLocalFileFetchToEncodeMemorySequence());
      return this.mLocalFileEncodedImageProducerSequence;
    }
    finally
    {
    }
  }

  public Producer<CloseableReference<PooledByteBuffer>> getNetworkFetchEncodedImageProducerSequence()
  {
    try
    {
      if (this.mNetworkEncodedImageProducerSequence == null)
        this.mNetworkEncodedImageProducerSequence = new RemoveImageTransformMetaDataProducer(getBackgroundNetworkFetchToEncodedMemorySequence());
      return this.mNetworkEncodedImageProducerSequence;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.core.ProducerSequenceFactory
 * JD-Core Version:    0.6.2
 */