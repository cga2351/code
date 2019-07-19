package com.facebook.cache.common;

import android.net.Uri;
import com.facebook.common.internal.Preconditions;

public class SimpleCacheKey
  implements CacheKey
{
  final String mKey;

  public SimpleCacheKey(String paramString)
  {
    this.mKey = ((String)Preconditions.checkNotNull(paramString));
  }

  public boolean containsUri(Uri paramUri)
  {
    return this.mKey.contains(paramUri.toString());
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this)
      return true;
    if ((paramObject instanceof SimpleCacheKey))
    {
      SimpleCacheKey localSimpleCacheKey = (SimpleCacheKey)paramObject;
      return this.mKey.equals(localSimpleCacheKey.mKey);
    }
    return false;
  }

  public String getUriString()
  {
    return this.mKey;
  }

  public int hashCode()
  {
    return this.mKey.hashCode();
  }

  public String toString()
  {
    return this.mKey;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.cache.common.SimpleCacheKey
 * JD-Core Version:    0.6.2
 */