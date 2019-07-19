package com.yandex.mobile.ads.mediation.nativeads;

import com.yandex.mobile.ads.nativeads.q;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

final class e
{
  private final WeakHashMap<q, Object> a = new WeakHashMap();

  public final void a()
  {
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
      ((q)localIterator.next()).b();
  }

  final void a(q paramq)
  {
    this.a.put(paramq, null);
  }

  public final void b()
  {
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
      ((q)localIterator.next()).c();
  }

  public final void c()
  {
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
      ((q)localIterator.next()).d();
  }

  public final void d()
  {
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
      ((q)localIterator.next()).e();
  }

  public final void e()
  {
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
      ((q)localIterator.next()).f();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.nativeads.e
 * JD-Core Version:    0.6.2
 */