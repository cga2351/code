package com.facebook.cache.common;

import android.net.Uri;
import com.facebook.common.internal.Preconditions;
import java.util.List;

public class MultiCacheKey
  implements CacheKey
{
  final List<CacheKey> mCacheKeys;

  public MultiCacheKey(List<CacheKey> paramList)
  {
    this.mCacheKeys = ((List)Preconditions.checkNotNull(paramList));
  }

  public boolean containsUri(Uri paramUri)
  {
    for (int i = 0; ; i++)
    {
      int j = this.mCacheKeys.size();
      boolean bool = false;
      if (i < j)
      {
        if (((CacheKey)this.mCacheKeys.get(i)).containsUri(paramUri))
          bool = true;
      }
      else
        return bool;
    }
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this)
      return true;
    if ((paramObject instanceof MultiCacheKey))
    {
      MultiCacheKey localMultiCacheKey = (MultiCacheKey)paramObject;
      return this.mCacheKeys.equals(localMultiCacheKey.mCacheKeys);
    }
    return false;
  }

  public List<CacheKey> getCacheKeys()
  {
    return this.mCacheKeys;
  }

  public String getUriString()
  {
    return ((CacheKey)this.mCacheKeys.get(0)).getUriString();
  }

  public int hashCode()
  {
    return this.mCacheKeys.hashCode();
  }

  public String toString()
  {
    return "MultiCacheKey:" + this.mCacheKeys.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.cache.common.MultiCacheKey
 * JD-Core Version:    0.6.2
 */