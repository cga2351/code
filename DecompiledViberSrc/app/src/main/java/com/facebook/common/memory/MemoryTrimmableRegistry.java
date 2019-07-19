package com.facebook.common.memory;

public abstract interface MemoryTrimmableRegistry
{
  public abstract void registerMemoryTrimmable(MemoryTrimmable paramMemoryTrimmable);

  public abstract void unregisterMemoryTrimmable(MemoryTrimmable paramMemoryTrimmable);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.memory.MemoryTrimmableRegistry
 * JD-Core Version:    0.6.2
 */