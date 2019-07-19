package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.i;
import java.util.Collection;
import java.util.List;

public class cp extends ci
{
  private final iz a;
  private ge<Collection<iy>> b;

  public cp(ab paramab, iz paramiz)
  {
    this(paramab, paramiz, hd.a.b(iy.class).a(paramab.c()));
  }

  cp(ab paramab, iz paramiz, ge<Collection<iy>> paramge)
  {
    super(paramab);
    this.a = paramiz;
    this.b = paramge;
  }

  public boolean a(i parami)
  {
    ab localab = a();
    List localList;
    if ((localab.B().d()) && (localab.z()))
    {
      localList = this.a.a(a().c(), (Collection)this.b.a());
      if (localList != null)
        break label59;
      localab.p();
    }
    while (true)
    {
      return false;
      label59: localab.f(i.a(parami, localList));
      this.b.a(localList);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.cp
 * JD-Core Version:    0.6.2
 */