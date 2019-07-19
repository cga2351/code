package com.facebook.cache.common;

import javax.annotation.Nullable;

public abstract interface CacheErrorLogger
{
  public abstract void logError(CacheErrorCategory paramCacheErrorCategory, Class<?> paramClass, String paramString, @Nullable Throwable paramThrowable);

  public static enum CacheErrorCategory
  {
    static
    {
      WRITE_CREATE_TEMPFILE = new CacheErrorCategory("WRITE_CREATE_TEMPFILE", 5);
      WRITE_UPDATE_FILE_NOT_FOUND = new CacheErrorCategory("WRITE_UPDATE_FILE_NOT_FOUND", 6);
      WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND = new CacheErrorCategory("WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND", 7);
      WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND = new CacheErrorCategory("WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND", 8);
      WRITE_RENAME_FILE_OTHER = new CacheErrorCategory("WRITE_RENAME_FILE_OTHER", 9);
      WRITE_CREATE_DIR = new CacheErrorCategory("WRITE_CREATE_DIR", 10);
      WRITE_CALLBACK_ERROR = new CacheErrorCategory("WRITE_CALLBACK_ERROR", 11);
      WRITE_INVALID_ENTRY = new CacheErrorCategory("WRITE_INVALID_ENTRY", 12);
      DELETE_FILE = new CacheErrorCategory("DELETE_FILE", 13);
      EVICTION = new CacheErrorCategory("EVICTION", 14);
      GENERIC_IO = new CacheErrorCategory("GENERIC_IO", 15);
      OTHER = new CacheErrorCategory("OTHER", 16);
      CacheErrorCategory[] arrayOfCacheErrorCategory = new CacheErrorCategory[17];
      arrayOfCacheErrorCategory[0] = READ_DECODE;
      arrayOfCacheErrorCategory[1] = READ_FILE;
      arrayOfCacheErrorCategory[2] = READ_FILE_NOT_FOUND;
      arrayOfCacheErrorCategory[3] = READ_INVALID_ENTRY;
      arrayOfCacheErrorCategory[4] = WRITE_ENCODE;
      arrayOfCacheErrorCategory[5] = WRITE_CREATE_TEMPFILE;
      arrayOfCacheErrorCategory[6] = WRITE_UPDATE_FILE_NOT_FOUND;
      arrayOfCacheErrorCategory[7] = WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND;
      arrayOfCacheErrorCategory[8] = WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
      arrayOfCacheErrorCategory[9] = WRITE_RENAME_FILE_OTHER;
      arrayOfCacheErrorCategory[10] = WRITE_CREATE_DIR;
      arrayOfCacheErrorCategory[11] = WRITE_CALLBACK_ERROR;
      arrayOfCacheErrorCategory[12] = WRITE_INVALID_ENTRY;
      arrayOfCacheErrorCategory[13] = DELETE_FILE;
      arrayOfCacheErrorCategory[14] = EVICTION;
      arrayOfCacheErrorCategory[15] = GENERIC_IO;
      arrayOfCacheErrorCategory[16] = OTHER;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.cache.common.CacheErrorLogger
 * JD-Core Version:    0.6.2
 */