package com.yandex.metrica.impl;

import com.yandex.metrica.impl.ob.h;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class an
  implements Thread.UncaughtExceptionHandler
{
  private final CopyOnWriteArrayList<j> a = new CopyOnWriteArrayList();
  private final Thread.UncaughtExceptionHandler b;

  public an(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    this.b = paramUncaughtExceptionHandler;
  }

  public void a(j paramj)
  {
    this.a.add(paramj);
  }

  public void b(j paramj)
  {
    this.a.remove(paramj);
  }

  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      h.a().b(new ay());
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
        ((j)localIterator.next()).a(paramThrowable);
    }
    finally
    {
      if (this.b != null)
        this.b.uncaughtException(paramThread, paramThrowable);
    }
    if (this.b != null)
      this.b.uncaughtException(paramThread, paramThrowable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.an
 * JD-Core Version:    0.6.2
 */