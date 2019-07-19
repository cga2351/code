package com.yandex.mobile.ads.impl;

import java.util.concurrent.TimeUnit;

public abstract class pl<T> extends oi<T>
{
  private static final int a = (int)TimeUnit.SECONDS.toMillis(10L);
  private final a<T> b;

  public pl(int paramInt, String paramString, a<T> parama)
  {
    super(paramInt, paramString, parama);
    l();
    a(new od(a, 0, 1.0F));
    this.b = parama;
  }

  protected final void b(T paramT)
  {
    if (this.b != null)
      this.b.a(paramT);
  }

  public static abstract interface a<T> extends ok.a, ok.b<T>
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.pl
 * JD-Core Version:    0.6.2
 */