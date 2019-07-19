package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.listener.RequestListener;
import java.io.File;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public class ImageRequest
{

  @Nullable
  private final BytesRange mBytesRange;
  private final CacheChoice mCacheChoice;
  private final ImageDecodeOptions mImageDecodeOptions;
  private final boolean mIsDiskCacheEnabled;
  private final boolean mIsMemoryCacheEnabled;
  private final boolean mLocalThumbnailPreviewsEnabled;
  private final RequestLevel mLowestPermittedRequestLevel;

  @Nullable
  private final Postprocessor mPostprocessor;
  private final boolean mProgressiveRenderingEnabled;

  @Nullable
  private final RequestListener mRequestListener;
  private final Priority mRequestPriority;

  @Nullable
  private final ResizeOptions mResizeOptions;
  private final RotationOptions mRotationOptions;
  private File mSourceFile;
  private final Uri mSourceUri;
  private final int mSourceUriType;

  protected ImageRequest(ImageRequestBuilder paramImageRequestBuilder)
  {
    this.mCacheChoice = paramImageRequestBuilder.getCacheChoice();
    this.mSourceUri = paramImageRequestBuilder.getSourceUri();
    this.mSourceUriType = getSourceUriType(this.mSourceUri);
    this.mProgressiveRenderingEnabled = paramImageRequestBuilder.isProgressiveRenderingEnabled();
    this.mLocalThumbnailPreviewsEnabled = paramImageRequestBuilder.isLocalThumbnailPreviewsEnabled();
    this.mImageDecodeOptions = paramImageRequestBuilder.getImageDecodeOptions();
    this.mResizeOptions = paramImageRequestBuilder.getResizeOptions();
    if (paramImageRequestBuilder.getRotationOptions() == null);
    for (RotationOptions localRotationOptions = RotationOptions.autoRotate(); ; localRotationOptions = paramImageRequestBuilder.getRotationOptions())
    {
      this.mRotationOptions = localRotationOptions;
      this.mBytesRange = paramImageRequestBuilder.getBytesRange();
      this.mRequestPriority = paramImageRequestBuilder.getRequestPriority();
      this.mLowestPermittedRequestLevel = paramImageRequestBuilder.getLowestPermittedRequestLevel();
      this.mIsDiskCacheEnabled = paramImageRequestBuilder.isDiskCacheEnabled();
      this.mIsMemoryCacheEnabled = paramImageRequestBuilder.isMemoryCacheEnabled();
      this.mPostprocessor = paramImageRequestBuilder.getPostprocessor();
      this.mRequestListener = paramImageRequestBuilder.getRequestListener();
      return;
    }
  }

  public static ImageRequest fromFile(@Nullable File paramFile)
  {
    if (paramFile == null)
      return null;
    return fromUri(UriUtil.getUriForFile(paramFile));
  }

  public static ImageRequest fromUri(@Nullable Uri paramUri)
  {
    if (paramUri == null)
      return null;
    return ImageRequestBuilder.newBuilderWithSource(paramUri).build();
  }

  public static ImageRequest fromUri(@Nullable String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return null;
    return fromUri(Uri.parse(paramString));
  }

  private static int getSourceUriType(Uri paramUri)
  {
    if (paramUri == null);
    do
    {
      return -1;
      if (UriUtil.isNetworkUri(paramUri))
        return 0;
      if (UriUtil.isLocalFileUri(paramUri))
      {
        if (MediaUtils.isVideo(MediaUtils.extractMime(paramUri.getPath())))
          return 2;
        return 3;
      }
      if (UriUtil.isLocalContentUri(paramUri))
        return 4;
      if (UriUtil.isLocalAssetUri(paramUri))
        return 5;
      if (UriUtil.isLocalResourceUri(paramUri))
        return 6;
      if (UriUtil.isDataUri(paramUri))
        return 7;
    }
    while (!UriUtil.isQualifiedResourceUri(paramUri));
    return 8;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ImageRequest));
    ImageRequest localImageRequest;
    do
    {
      return false;
      localImageRequest = (ImageRequest)paramObject;
    }
    while ((!Objects.equal(this.mSourceUri, localImageRequest.mSourceUri)) || (!Objects.equal(this.mCacheChoice, localImageRequest.mCacheChoice)) || (!Objects.equal(this.mSourceFile, localImageRequest.mSourceFile)) || (!Objects.equal(this.mBytesRange, localImageRequest.mBytesRange)) || (!Objects.equal(this.mImageDecodeOptions, localImageRequest.mImageDecodeOptions)) || (!Objects.equal(this.mResizeOptions, localImageRequest.mResizeOptions)) || (!Objects.equal(this.mRotationOptions, localImageRequest.mRotationOptions)));
    if (this.mPostprocessor != null);
    for (CacheKey localCacheKey1 = this.mPostprocessor.getPostprocessorCacheKey(); ; localCacheKey1 = null)
    {
      Postprocessor localPostprocessor = localImageRequest.mPostprocessor;
      CacheKey localCacheKey2 = null;
      if (localPostprocessor != null)
        localCacheKey2 = localImageRequest.mPostprocessor.getPostprocessorCacheKey();
      return Objects.equal(localCacheKey1, localCacheKey2);
    }
  }

  @Deprecated
  public boolean getAutoRotateEnabled()
  {
    return this.mRotationOptions.useImageMetadata();
  }

  @Nullable
  public BytesRange getBytesRange()
  {
    return this.mBytesRange;
  }

  public CacheChoice getCacheChoice()
  {
    return this.mCacheChoice;
  }

  public ImageDecodeOptions getImageDecodeOptions()
  {
    return this.mImageDecodeOptions;
  }

  public boolean getLocalThumbnailPreviewsEnabled()
  {
    return this.mLocalThumbnailPreviewsEnabled;
  }

  public RequestLevel getLowestPermittedRequestLevel()
  {
    return this.mLowestPermittedRequestLevel;
  }

  @Nullable
  public Postprocessor getPostprocessor()
  {
    return this.mPostprocessor;
  }

  public int getPreferredHeight()
  {
    if (this.mResizeOptions != null)
      return this.mResizeOptions.height;
    return 2048;
  }

  public int getPreferredWidth()
  {
    if (this.mResizeOptions != null)
      return this.mResizeOptions.width;
    return 2048;
  }

  public Priority getPriority()
  {
    return this.mRequestPriority;
  }

  public boolean getProgressiveRenderingEnabled()
  {
    return this.mProgressiveRenderingEnabled;
  }

  @Nullable
  public RequestListener getRequestListener()
  {
    return this.mRequestListener;
  }

  @Nullable
  public ResizeOptions getResizeOptions()
  {
    return this.mResizeOptions;
  }

  public RotationOptions getRotationOptions()
  {
    return this.mRotationOptions;
  }

  public File getSourceFile()
  {
    try
    {
      if (this.mSourceFile == null)
        this.mSourceFile = new File(this.mSourceUri.getPath());
      File localFile = this.mSourceFile;
      return localFile;
    }
    finally
    {
    }
  }

  public Uri getSourceUri()
  {
    return this.mSourceUri;
  }

  public int getSourceUriType()
  {
    return this.mSourceUriType;
  }

  public int hashCode()
  {
    if (this.mPostprocessor != null);
    for (CacheKey localCacheKey = this.mPostprocessor.getPostprocessorCacheKey(); ; localCacheKey = null)
    {
      Object[] arrayOfObject = new Object[8];
      arrayOfObject[0] = this.mCacheChoice;
      arrayOfObject[1] = this.mSourceUri;
      arrayOfObject[2] = this.mSourceFile;
      arrayOfObject[3] = this.mBytesRange;
      arrayOfObject[4] = this.mImageDecodeOptions;
      arrayOfObject[5] = this.mResizeOptions;
      arrayOfObject[6] = this.mRotationOptions;
      arrayOfObject[7] = localCacheKey;
      return Objects.hashCode(arrayOfObject);
    }
  }

  public boolean isDiskCacheEnabled()
  {
    return this.mIsDiskCacheEnabled;
  }

  public boolean isMemoryCacheEnabled()
  {
    return this.mIsMemoryCacheEnabled;
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("uri", this.mSourceUri).add("cacheChoice", this.mCacheChoice).add("decodeOptions", this.mImageDecodeOptions).add("postprocessor", this.mPostprocessor).add("priority", this.mRequestPriority).add("resizeOptions", this.mResizeOptions).add("rotationOptions", this.mRotationOptions).add("bytesRange", this.mBytesRange).toString();
  }

  public static enum CacheChoice
  {
    static
    {
      DEFAULT = new CacheChoice("DEFAULT", 1);
      CacheChoice[] arrayOfCacheChoice = new CacheChoice[2];
      arrayOfCacheChoice[0] = SMALL;
      arrayOfCacheChoice[1] = DEFAULT;
    }
  }

  public static enum RequestLevel
  {
    private int mValue;

    static
    {
      DISK_CACHE = new RequestLevel("DISK_CACHE", 1, 2);
      ENCODED_MEMORY_CACHE = new RequestLevel("ENCODED_MEMORY_CACHE", 2, 3);
      BITMAP_MEMORY_CACHE = new RequestLevel("BITMAP_MEMORY_CACHE", 3, 4);
      RequestLevel[] arrayOfRequestLevel = new RequestLevel[4];
      arrayOfRequestLevel[0] = FULL_FETCH;
      arrayOfRequestLevel[1] = DISK_CACHE;
      arrayOfRequestLevel[2] = ENCODED_MEMORY_CACHE;
      arrayOfRequestLevel[3] = BITMAP_MEMORY_CACHE;
    }

    private RequestLevel(int paramInt)
    {
      this.mValue = paramInt;
    }

    public static RequestLevel getMax(RequestLevel paramRequestLevel1, RequestLevel paramRequestLevel2)
    {
      if (paramRequestLevel1.getValue() > paramRequestLevel2.getValue())
        return paramRequestLevel1;
      return paramRequestLevel2;
    }

    public int getValue()
    {
      return this.mValue;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.request.ImageRequest
 * JD-Core Version:    0.6.2
 */