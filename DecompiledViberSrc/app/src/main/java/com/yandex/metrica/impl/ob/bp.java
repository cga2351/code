package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.i;
import java.util.Iterator;
import java.util.List;

public class bp<T, C extends af>
{
  private final bv<T> a;
  private final C b;

  protected bp(bv<T> parambv, C paramC)
  {
    this.a = parambv;
    this.b = paramC;
  }

  bs<T> a(i parami)
  {
    return this.a.a(parami.e());
  }

  protected boolean a(i parami, a<T> parama)
  {
    Iterator localIterator = a(parami).a().iterator();
    while (localIterator.hasNext())
      if (parama.a(localIterator.next(), parami))
        return true;
    return false;
  }

  protected static abstract interface a<T>
  {
    public abstract boolean a(T paramT, i parami);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.bp
 * JD-Core Version:    0.6.2
 */