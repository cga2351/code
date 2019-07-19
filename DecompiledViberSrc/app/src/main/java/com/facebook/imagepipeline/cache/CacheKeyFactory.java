package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;

public abstract interface CacheKeyFactory
{
  public abstract CacheKey getBitmapCacheKey(ImageRequest paramImageRequest, Object paramObject);

  public abstract CacheKey getEncodedCacheKey(ImageRequest paramImageRequest, Uri paramUri, @Nullable Object paramObject);

  public abstract CacheKey getEncodedCacheKey(ImageRequest paramImageRequest, @Nullable Object paramObject);

  public abstract CacheKey getPostprocessedBitmapCacheKey(ImageRequest paramImageRequest, Object paramObject);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.CacheKeyFactory
 * JD-Core Version:    0.6.2
 */