package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class ex
{
  private final eo a;
  private final List<ev> b;

  public ex(eo parameo)
  {
    this.a = parameo;
    this.b = new CopyOnWriteArrayList();
  }

  public final void a(ew paramew)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      paramew.b((ev)localIterator.next());
  }

  public final void a(ew paramew, final a parama)
  {
    ev local1 = new ev()
    {
      public final void a()
      {
        ex.a(ex.this).remove(this);
        parama.b();
      }

      public final void a(Map<String, String> paramAnonymousMap)
      {
        ex.a(ex.this).remove(this);
        ex.a(ex.this, paramAnonymousMap);
        parama.a();
      }
    };
    this.b.add(local1);
    paramew.a(local1);
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ex
 * JD-Core Version:    0.6.2
 */