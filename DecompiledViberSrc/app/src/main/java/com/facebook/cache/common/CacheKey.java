package com.facebook.cache.common;

import android.net.Uri;

public abstract interface CacheKey
{
  public abstract boolean containsUri(Uri paramUri);

  public abstract boolean equals(Object paramObject);

  public abstract String getUriString();

  public abstract int hashCode();

  public abstract String toString();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.cache.common.CacheKey
 * JD-Core Version:    0.6.2
 */