package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

@KeepForSdk
public class ListenerHolders
{
  private final Set<ListenerHolder<?>> zajn = Collections.newSetFromMap(new WeakHashMap());

  @KeepForSdk
  public static <L> ListenerHolder<L> createListenerHolder(L paramL, Looper paramLooper, String paramString)
  {
    Preconditions.checkNotNull(paramL, "Listener must not be null");
    Preconditions.checkNotNull(paramLooper, "Looper must not be null");
    Preconditions.checkNotNull(paramString, "Listener type must not be null");
    return new ListenerHolder(paramLooper, paramL, paramString);
  }

  @KeepForSdk
  public static <L> ListenerHolder.ListenerKey<L> createListenerKey(L paramL, String paramString)
  {
    Preconditions.checkNotNull(paramL, "Listener must not be null");
    Preconditions.checkNotNull(paramString, "Listener type must not be null");
    Preconditions.checkNotEmpty(paramString, "Listener type must not be empty");
    return new ListenerHolder.ListenerKey(paramL, paramString);
  }

  public final void release()
  {
    Iterator localIterator = this.zajn.iterator();
    while (localIterator.hasNext())
      ((ListenerHolder)localIterator.next()).clear();
    this.zajn.clear();
  }

  public final <L> ListenerHolder<L> zaa(L paramL, Looper paramLooper, String paramString)
  {
    ListenerHolder localListenerHolder = createListenerHolder(paramL, paramLooper, paramString);
    this.zajn.add(localListenerHolder);
    return localListenerHolder;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.ListenerHolders
 * JD-Core Version:    0.6.2
 */