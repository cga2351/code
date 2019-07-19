package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.CounterConfiguration;

public class at
{
  private final fw a;
  private final on b;
  private my c;
  private long d;

  public at(Context paramContext, y paramy)
  {
    this(new fw(fj.a(paramContext).b(paramy)), new om());
  }

  public at(fw paramfw, on paramon)
  {
    this.a = paramfw;
    this.b = paramon;
    this.d = this.a.h(0L);
  }

  public void a()
  {
    this.d = this.b.a();
    this.a.i(this.d).i();
  }

  public void a(my parammy)
  {
    this.c = parammy;
  }

  public boolean a(t paramt)
  {
    return (Boolean.FALSE.equals(paramt.b().o())) && (this.c != null) && (this.b.a() - this.d > this.c.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.at
 * JD-Core Version:    0.6.2
 */