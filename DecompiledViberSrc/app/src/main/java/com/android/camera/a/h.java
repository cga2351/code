package com.android.camera.a;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class h<K, V>
{
  private final HashMap<K, V> a;
  private final HashMap<K, a<K, V>> b = new HashMap();
  private ReferenceQueue<V> c = new ReferenceQueue();

  public h(final int paramInt)
  {
    this.a = new LinkedHashMap(16, 0.75F, true)
    {
      protected boolean removeEldestEntry(Map.Entry<K, V> paramAnonymousEntry)
      {
        return size() > paramInt;
      }
    };
  }

  private void b()
  {
    for (a locala = (a)this.c.poll(); locala != null; locala = (a)this.c.poll())
      this.b.remove(locala.a);
  }

  public V a(K paramK)
  {
    try
    {
      b();
      Object localObject2 = this.a.get(paramK);
      Object localObject3 = localObject2;
      if (localObject3 != null);
      while (true)
      {
        return localObject3;
        a locala = (a)this.b.get(paramK);
        if (locala == null)
        {
          localObject3 = null;
        }
        else
        {
          Object localObject4 = locala.get();
          localObject3 = localObject4;
        }
      }
    }
    finally
    {
    }
  }

  public V a(K paramK, V paramV)
  {
    try
    {
      b();
      this.a.put(paramK, paramV);
      a locala = (a)this.b.put(paramK, new a(paramK, paramV, this.c));
      if (locala == null);
      Object localObject2;
      for (Object localObject3 = null; ; localObject3 = localObject2)
      {
        return localObject3;
        localObject2 = locala.get();
      }
    }
    finally
    {
    }
  }

  public void a()
  {
    try
    {
      this.a.clear();
      this.b.clear();
      this.c = new ReferenceQueue();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private static class a<K, V> extends WeakReference<V>
  {
    K a;

    public a(K paramK, V paramV, ReferenceQueue<V> paramReferenceQueue)
    {
      super(paramReferenceQueue);
      this.a = paramK;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.camera.a.h
 * JD-Core Version:    0.6.2
 */