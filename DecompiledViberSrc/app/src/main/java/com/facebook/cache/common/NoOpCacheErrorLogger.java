package com.facebook.cache.common;

import javax.annotation.Nullable;

public class NoOpCacheErrorLogger
  implements CacheErrorLogger
{
  private static NoOpCacheErrorLogger sInstance = null;

  public static NoOpCacheErrorLogger getInstance()
  {
    try
    {
      if (sInstance == null)
        sInstance = new NoOpCacheErrorLogger();
      NoOpCacheErrorLogger localNoOpCacheErrorLogger = sInstance;
      return localNoOpCacheErrorLogger;
    }
    finally
    {
    }
  }

  public void logError(CacheErrorLogger.CacheErrorCategory paramCacheErrorCategory, Class<?> paramClass, String paramString, @Nullable Throwable paramThrowable)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.cache.common.NoOpCacheErrorLogger
 * JD-Core Version:    0.6.2
 */