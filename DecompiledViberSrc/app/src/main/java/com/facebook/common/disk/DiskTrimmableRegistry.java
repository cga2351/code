package com.facebook.common.disk;

public abstract interface DiskTrimmableRegistry
{
  public abstract void registerDiskTrimmable(DiskTrimmable paramDiskTrimmable);

  public abstract void unregisterDiskTrimmable(DiskTrimmable paramDiskTrimmable);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.disk.DiskTrimmableRegistry
 * JD-Core Version:    0.6.2
 */