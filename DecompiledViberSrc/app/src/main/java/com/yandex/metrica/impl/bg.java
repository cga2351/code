package com.yandex.metrica.impl;

import android.os.Bundle;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.ob.ms;
import com.yandex.metrica.impl.ob.pl;

class bg
{
  protected final CounterConfiguration a;
  protected r b;
  protected ax c;
  private final com.yandex.metrica.impl.ob.u d;
  private u e = new u();

  protected bg(com.yandex.metrica.impl.ob.u paramu, CounterConfiguration paramCounterConfiguration)
  {
    this.d = paramu;
    this.a = paramCounterConfiguration;
  }

  void a(ax paramax)
  {
    this.c = paramax;
  }

  void a(ms paramms)
  {
    b(paramms);
  }

  void a(pl parampl)
  {
    this.b = new r(parampl);
  }

  void a(String paramString1, String paramString2)
  {
    this.b.a(paramString1, paramString2);
  }

  boolean a()
  {
    return this.e.c();
  }

  CounterConfiguration b()
  {
    return this.a;
  }

  void b(ms paramms)
  {
    if (paramms != null)
      this.a.c(paramms.a());
  }

  Bundle c()
  {
    Bundle localBundle = new Bundle();
    this.a.a(localBundle);
    this.d.b(localBundle);
    return localBundle;
  }

  void d()
  {
    this.e.b();
  }

  boolean e()
  {
    return this.e.a();
  }

  String f()
  {
    return this.b.a();
  }

  ax g()
  {
    return this.c;
  }

  public com.yandex.metrica.impl.ob.u h()
  {
    return this.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.bg
 * JD-Core Version:    0.6.2
 */