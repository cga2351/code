package com.mopub.common.util;

import com.mopub.common.Preconditions;
import java.util.Collection;
import java.util.Collections;

public class MoPubCollections
{
  public static <T> void addAllNonNull(Collection<? super T> paramCollection, Collection<T> paramCollection1)
  {
    Preconditions.checkNotNull(paramCollection);
    Preconditions.checkNotNull(paramCollection1);
    paramCollection.addAll(paramCollection1);
    paramCollection.removeAll(Collections.singleton(null));
  }

  public static <T> void addAllNonNull(Collection<? super T> paramCollection, T[] paramArrayOfT)
  {
    Collections.addAll(paramCollection, paramArrayOfT);
    paramCollection.removeAll(Collections.singleton(null));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.util.MoPubCollections
 * JD-Core Version:    0.6.2
 */