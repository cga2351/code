package com.facebook.cache.common;

import java.io.IOException;
import javax.annotation.Nullable;

public abstract interface CacheEvent
{
  @Nullable
  public abstract CacheKey getCacheKey();

  public abstract long getCacheLimit();

  public abstract long getCacheSize();

  @Nullable
  public abstract CacheEventListener.EvictionReason getEvictionReason();

  @Nullable
  public abstract IOException getException();

  public abstract long getItemSize();

  @Nullable
  public abstract String getResourceId();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.cache.common.CacheEvent
 * JD-Core Version:    0.6.2
 */