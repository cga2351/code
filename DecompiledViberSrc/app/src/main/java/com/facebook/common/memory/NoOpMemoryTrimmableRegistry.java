package com.facebook.common.memory;

public class NoOpMemoryTrimmableRegistry
  implements MemoryTrimmableRegistry
{
  private static NoOpMemoryTrimmableRegistry sInstance = null;

  public static NoOpMemoryTrimmableRegistry getInstance()
  {
    try
    {
      if (sInstance == null)
        sInstance = new NoOpMemoryTrimmableRegistry();
      NoOpMemoryTrimmableRegistry localNoOpMemoryTrimmableRegistry = sInstance;
      return localNoOpMemoryTrimmableRegistry;
    }
    finally
    {
    }
  }

  public void registerMemoryTrimmable(MemoryTrimmable paramMemoryTrimmable)
  {
  }

  public void unregisterMemoryTrimmable(MemoryTrimmable paramMemoryTrimmable)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.memory.NoOpMemoryTrimmableRegistry
 * JD-Core Version:    0.6.2
 */