package com.facebook.cache.common;

import android.net.Uri;
import javax.annotation.Nullable;

public class DebuggingCacheKey extends SimpleCacheKey
{
  private final Object mCallerContext;
  private final Uri mSourceUri;

  public DebuggingCacheKey(String paramString, @Nullable Object paramObject, Uri paramUri)
  {
    super(paramString);
    this.mCallerContext = paramObject;
    this.mSourceUri = paramUri;
  }

  @Nullable
  public Object getCallerContext()
  {
    return this.mCallerContext;
  }

  public Uri getSourceUri()
  {
    return this.mSourceUri;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.cache.common.DebuggingCacheKey
 * JD-Core Version:    0.6.2
 */