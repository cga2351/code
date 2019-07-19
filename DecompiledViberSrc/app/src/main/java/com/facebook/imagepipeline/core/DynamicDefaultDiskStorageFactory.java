package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.DynamicDefaultDiskStorage;

public class DynamicDefaultDiskStorageFactory
  implements DiskStorageFactory
{
  public DiskStorage get(DiskCacheConfig paramDiskCacheConfig)
  {
    return new DynamicDefaultDiskStorage(paramDiskCacheConfig.getVersion(), paramDiskCacheConfig.getBaseDirectoryPathSupplier(), paramDiskCacheConfig.getBaseDirectoryName(), paramDiskCacheConfig.getCacheErrorLogger());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.core.DynamicDefaultDiskStorageFactory
 * JD-Core Version:    0.6.2
 */