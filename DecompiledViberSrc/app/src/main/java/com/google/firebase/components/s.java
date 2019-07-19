package com.google.firebase.components;

import com.google.firebase.b.a;

class s<T>
  implements a<T>
{
  private static final Object a = new Object();
  private volatile Object b = a;
  private volatile a<T> c;

  s(a<T> parama)
  {
    this.c = parama;
  }

  public T a()
  {
    Object localObject1 = this.b;
    if (localObject1 == a)
      try
      {
        Object localObject3 = this.b;
        if (localObject3 == a)
        {
          localObject3 = this.c.a();
          this.b = localObject3;
          this.c = null;
        }
        return localObject3;
      }
      finally
      {
      }
    return localObject1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.components.s
 * JD-Core Version:    0.6.2
 */