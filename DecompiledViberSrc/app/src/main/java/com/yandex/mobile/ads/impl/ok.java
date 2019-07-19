package com.yandex.mobile.ads.impl;

public final class ok<T>
{
  public final T a;
  public final ob.a b;
  public final ov c;
  public boolean d = false;

  private ok(ov paramov)
  {
    this.a = null;
    this.b = null;
    this.c = paramov;
  }

  private ok(T paramT, ob.a parama)
  {
    this.a = paramT;
    this.b = parama;
    this.c = null;
  }

  public static <T> ok<T> a(ov paramov)
  {
    return new ok(paramov);
  }

  public static <T> ok<T> a(T paramT, ob.a parama)
  {
    return new ok(paramT, parama);
  }

  public static abstract interface a
  {
    public abstract void a(ov paramov);
  }

  public static abstract interface b<T>
  {
    public abstract void a(T paramT);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ok
 * JD-Core Version:    0.6.2
 */