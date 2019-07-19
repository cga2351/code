package com.yandex.metrica.impl.ob;

import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.bt;
import com.yandex.metrica.impl.i;

public class cc extends bx
{
  private final bt a;
  private final ij b;

  public cc(w paramw, bt parambt, ij paramij)
  {
    super(paramw);
    this.a = parambt;
    this.b = paramij;
  }

  public boolean a(i parami, az paramaz)
  {
    CounterConfiguration localCounterConfiguration = paramaz.b().a().b();
    this.a.a(localCounterConfiguration.o());
    boolean bool = oq.a(localCounterConfiguration.g(), true);
    this.b.a(bool);
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.cc
 * JD-Core Version:    0.6.2
 */