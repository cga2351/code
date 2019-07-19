package com.facebook.cache.common;

public abstract interface CacheEventListener
{
  public abstract void onCleared();

  public abstract void onEviction(CacheEvent paramCacheEvent);

  public abstract void onHit(CacheEvent paramCacheEvent);

  public abstract void onMiss(CacheEvent paramCacheEvent);

  public abstract void onReadException(CacheEvent paramCacheEvent);

  public abstract void onWriteAttempt(CacheEvent paramCacheEvent);

  public abstract void onWriteException(CacheEvent paramCacheEvent);

  public abstract void onWriteSuccess(CacheEvent paramCacheEvent);

  public static enum EvictionReason
  {
    static
    {
      CACHE_MANAGER_TRIMMED = new EvictionReason("CACHE_MANAGER_TRIMMED", 3);
      EvictionReason[] arrayOfEvictionReason = new EvictionReason[4];
      arrayOfEvictionReason[0] = CACHE_FULL;
      arrayOfEvictionReason[1] = CONTENT_STALE;
      arrayOfEvictionReason[2] = USER_FORCED;
      arrayOfEvictionReason[3] = CACHE_MANAGER_TRIMMED;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.cache.common.CacheEventListener
 * JD-Core Version:    0.6.2
 */