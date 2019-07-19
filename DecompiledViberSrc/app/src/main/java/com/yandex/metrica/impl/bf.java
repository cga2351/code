package com.yandex.metrica.impl;

import com.yandex.metrica.IReporter;

public class bf extends j
{
  private final IReporter a;

  bf(IReporter paramIReporter, j.a parama)
  {
    super(parama);
    this.a = paramIReporter;
  }

  void b(Throwable paramThrowable)
  {
    this.a.reportUnhandledException(paramThrowable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.bf
 * JD-Core Version:    0.6.2
 */