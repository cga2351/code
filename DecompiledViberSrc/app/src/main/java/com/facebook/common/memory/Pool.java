package com.facebook.common.memory;

import com.facebook.common.references.ResourceReleaser;

public abstract interface Pool<V> extends MemoryTrimmable, ResourceReleaser<V>
{
  public abstract V get(int paramInt);

  public abstract void release(V paramV);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.memory.Pool
 * JD-Core Version:    0.6.2
 */