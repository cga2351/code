package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.s.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class bt extends bv<ci>
{
  private final dk a;
  private final Map<s.a, dd<ci>> b;
  private db<ci> c;
  private db<ci> d;

  public bt(ab paramab)
  {
    this.a = new dk(paramab);
    this.c = new da(this.a);
    HashMap localHashMap = new HashMap();
    localHashMap.put(s.a.A, new cz(this.a));
    localHashMap.put(s.a.C, new dn(this.a));
    localHashMap.put(s.a.c, new dh(this.a));
    df localdf = new df(this.a);
    localHashMap.put(s.a.e, localdf);
    localHashMap.put(s.a.v, localdf);
    localHashMap.put(s.a.t, localdf);
    localHashMap.put(s.a.D, localdf);
    localHashMap.put(s.a.E, new dj(this.a));
    localHashMap.put(s.a.g, new dp(this.a));
    localHashMap.put(s.a.m, new dg(this.a));
    localHashMap.put(s.a.n, new dm(this.a, this.a.n()));
    do localdo = new do(this.a);
    localHashMap.put(s.a.z, localdo);
    localHashMap.put(s.a.p, new de(this.a));
    localHashMap.put(s.a.h, new dl(this.a));
    localHashMap.put(s.a.i, new dm(this.a, this.a.i()));
    localHashMap.put(s.a.x, new dm(this.a, this.a.k()));
    localHashMap.put(s.a.y, new dm(this.a, this.a.l()));
    localHashMap.put(s.a.j, localdf);
    localHashMap.put(s.a.k, new dm(this.a, this.a.q()));
    localHashMap.put(s.a.l, localdf);
    this.b = localHashMap;
  }

  public bs<ci> a(int paramInt)
  {
    LinkedList localLinkedList = new LinkedList();
    s.a locala = s.a.a(paramInt);
    if (this.c != null)
      this.c.a(locala, localLinkedList);
    dd localdd = (dd)this.b.get(locala);
    if (localdd != null)
      localdd.a(localLinkedList);
    if (this.d != null)
      this.d.a(locala, localLinkedList);
    return new br(localLinkedList);
  }

  public dk a()
  {
    return this.a;
  }

  public void a(s.a parama, dd<ci> paramdd)
  {
    this.b.put(parama, paramdd);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.bt
 * JD-Core Version:    0.6.2
 */