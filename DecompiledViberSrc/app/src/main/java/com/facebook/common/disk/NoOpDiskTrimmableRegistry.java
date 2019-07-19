package com.facebook.common.disk;

import javax.annotation.Nullable;

public class NoOpDiskTrimmableRegistry
  implements DiskTrimmableRegistry
{

  @Nullable
  private static NoOpDiskTrimmableRegistry sInstance = null;

  public static NoOpDiskTrimmableRegistry getInstance()
  {
    try
    {
      if (sInstance == null)
        sInstance = new NoOpDiskTrimmableRegistry();
      NoOpDiskTrimmableRegistry localNoOpDiskTrimmableRegistry = sInstance;
      return localNoOpDiskTrimmableRegistry;
    }
    finally
    {
    }
  }

  public void registerDiskTrimmable(DiskTrimmable paramDiskTrimmable)
  {
  }

  public void unregisterDiskTrimmable(DiskTrimmable paramDiskTrimmable)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.disk.NoOpDiskTrimmableRegistry
 * JD-Core Version:    0.6.2
 */