package com.yandex.metrica.impl.ob;

import android.os.Bundle;
import com.yandex.metrica.IIdentifierCallback;
import com.yandex.metrica.IIdentifierCallback.Reason;
import com.yandex.metrica.impl.bj;
import com.yandex.metrica.impl.bw;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class mr
  implements ms
{
  static final Map<mq, IIdentifierCallback.Reason> a = Collections.unmodifiableMap(new HashMap()
  {
  });
  private final bj b;
  private final mu c;
  private final fv d;
  private final Object e = new Object();
  private final Map<IIdentifierCallback, Object> f = new WeakHashMap();
  private final Map<IIdentifierCallback, Object> g = new WeakHashMap();
  private Map<String, String> h;
  private final IIdentifierCallback i = new a(this);

  public mr(bj parambj, fv paramfv)
  {
    this(parambj, paramfv, new mu(paramfv));
  }

  mr(bj parambj, fv paramfv, mu parammu)
  {
    this.b = parambj;
    this.d = paramfv;
    this.c = parammu;
    d();
  }

  public String a()
  {
    return this.c.c();
  }

  public void a(Bundle paramBundle)
  {
    synchronized (this.e)
    {
      this.c.a(paramBundle);
      this.c.a(System.currentTimeMillis() / 1000L);
      d();
      return;
    }
  }

  public void a(IIdentifierCallback paramIIdentifierCallback)
  {
    synchronized (this.e)
    {
      this.b.c();
      this.g.put(paramIIdentifierCallback, null);
      this.g.put(this.i, null);
      if (!this.c.a(mu.a.c))
        this.b.e();
      d();
      return;
    }
  }

  public void a(String paramString)
  {
    this.b.c(paramString);
  }

  public void a(List<String> paramList)
  {
    List localList = this.c.b();
    if (bw.a(paramList))
    {
      if (!bw.a(localList))
      {
        this.c.a(null);
        this.b.a(null);
      }
      return;
    }
    if (!bw.a(paramList, localList))
    {
      this.c.a(paramList);
      this.b.a(paramList);
      return;
    }
    this.b.a(localList);
  }

  public void a(Map<String, String> paramMap)
  {
    Map localMap = ol.c(paramMap);
    this.h = localMap;
    this.b.a(localMap);
  }

  public String b()
  {
    return this.c.d();
  }

  public void b(Bundle paramBundle)
  {
    mq localmq = mq.b(paramBundle);
    IIdentifierCallback.Reason localReason = (IIdentifierCallback.Reason)a.get(localmq);
    WeakHashMap localWeakHashMap1 = new WeakHashMap();
    WeakHashMap localWeakHashMap2 = new WeakHashMap();
    synchronized (this.e)
    {
      localWeakHashMap1.putAll(this.f);
      localWeakHashMap2.putAll(this.g);
      this.f.clear();
      this.g.clear();
      Iterator localIterator1 = localWeakHashMap1.keySet().iterator();
      if (localIterator1.hasNext())
        ((IIdentifierCallback)localIterator1.next()).onRequestError(localReason);
    }
    Iterator localIterator2 = localWeakHashMap2.keySet().iterator();
    while (localIterator2.hasNext())
      ((IIdentifierCallback)localIterator2.next()).onRequestError(localReason);
    localWeakHashMap1.clear();
    localWeakHashMap2.clear();
  }

  public void c()
  {
    if ((!this.c.a(mu.a.c)) || (this.c.a()))
      this.b.e();
  }

  final void d()
  {
    WeakHashMap localWeakHashMap1 = new WeakHashMap();
    HashMap localHashMap1 = new HashMap();
    WeakHashMap localWeakHashMap2 = new WeakHashMap();
    HashMap localHashMap2 = new HashMap();
    synchronized (this.e)
    {
      if (this.c.a(mu.a.a))
      {
        localWeakHashMap1.putAll(this.f);
        this.f.clear();
        this.c.b(localHashMap1);
      }
      if (this.c.a(mu.a.c))
      {
        localWeakHashMap2.putAll(this.g);
        this.g.clear();
        this.c.a(localHashMap2);
      }
      Iterator localIterator1 = localWeakHashMap1.keySet().iterator();
      if (localIterator1.hasNext())
        ((IIdentifierCallback)localIterator1.next()).onReceive(new HashMap(localHashMap1));
    }
    Iterator localIterator2 = localWeakHashMap2.keySet().iterator();
    while (localIterator2.hasNext())
      ((IIdentifierCallback)localIterator2.next()).onReceive(new HashMap(localHashMap2));
    localWeakHashMap1.clear();
    localHashMap1.clear();
    localWeakHashMap2.clear();
    localHashMap2.clear();
  }

  public void e()
  {
    this.b.d();
    this.g.remove(this.i);
  }

  public static class a
    implements IIdentifierCallback
  {
    private mr a;

    public a(mr parammr)
    {
      this.a = parammr;
    }

    public void onReceive(Map<String, String> paramMap)
    {
      this.a.e();
    }

    public void onRequestError(IIdentifierCallback.Reason paramReason)
    {
      this.a.e();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.mr
 * JD-Core Version:    0.6.2
 */