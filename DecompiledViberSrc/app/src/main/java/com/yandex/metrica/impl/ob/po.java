package com.yandex.metrica.impl.ob;

public class po<T>
  implements pp<T>
{
  private final pp<T> a;
  private final T b;

  public po(pp<T> parampp, T paramT)
  {
    this.a = parampp;
    this.b = paramT;
  }

  public T a(T paramT)
  {
    if (paramT != this.a.a(paramT))
      paramT = this.b;
    return paramT;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.po
 * JD-Core Version:    0.6.2
 */