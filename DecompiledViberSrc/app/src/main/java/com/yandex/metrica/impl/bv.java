package com.yandex.metrica.impl;

import com.yandex.metrica.impl.ob.ag;
import com.yandex.metrica.impl.ob.nc;
import java.io.Closeable;

public class bv<C extends ag>
  implements Closeable
{
  final Object a = new Object();
  final ap b;
  boolean c = false;
  private C d;
  private final nc e;

  public bv(C paramC, nc paramnc, ap paramap)
  {
    this.d = paramC;
    this.e = paramnc;
    this.b = paramap;
  }

  void a()
  {
  }

  void c()
  {
    this.e.a(this.b);
  }

  public void close()
  {
    synchronized (this.a)
    {
      if (!this.c)
      {
        a();
        if (this.b.isAlive())
          this.b.a();
        this.c = true;
      }
      return;
    }
  }

  public void d()
  {
    synchronized (this.a)
    {
      if (!this.c)
      {
        e();
        a();
      }
      return;
    }
  }

  void e()
  {
    synchronized (this.a)
    {
      if (!this.c)
        c();
      return;
    }
  }

  public C f()
  {
    return this.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.bv
 * JD-Core Version:    0.6.2
 */