package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Predicate;
import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;

public abstract interface MemoryCache<K, V>
{
  @Nullable
  public abstract CloseableReference<V> cache(K paramK, CloseableReference<V> paramCloseableReference);

  public abstract boolean contains(Predicate<K> paramPredicate);

  @Nullable
  public abstract CloseableReference<V> get(K paramK);

  public abstract int removeAll(Predicate<K> paramPredicate);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.MemoryCache
 * JD-Core Version:    0.6.2
 */