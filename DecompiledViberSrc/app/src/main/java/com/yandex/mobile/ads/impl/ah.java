package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class ah
{
  private static final Object a = new Object();
  private static volatile ah b;
  private final Map<a, Object> c = new WeakHashMap();

  public static ah a()
  {
    if (b == null);
    synchronized (a)
    {
      if (b == null)
        b = new ah();
      return b;
    }
  }

  public final void a(Context paramContext, et paramet)
  {
    synchronized (a)
    {
      es.a().a(paramContext, paramet);
      Iterator localIterator = this.c.keySet().iterator();
      if (localIterator.hasNext())
        ((a)localIterator.next()).a(paramet);
    }
  }

  public final void a(a parama)
  {
    synchronized (a)
    {
      if (!this.c.containsKey(parama))
        this.c.put(parama, null);
      return;
    }
  }

  public static abstract interface a
  {
    public abstract void a(et paramet);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ah
 * JD-Core Version:    0.6.2
 */