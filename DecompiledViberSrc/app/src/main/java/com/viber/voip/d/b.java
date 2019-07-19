package com.viber.voip.d;

import java.lang.ref.WeakReference;

public abstract class b<T>
  implements Runnable
{
  WeakReference<T> a;

  public b(T paramT)
  {
    this.a = new WeakReference(paramT);
  }

  public abstract void a(T paramT);

  public final void run()
  {
    Object localObject = this.a.get();
    if (localObject != null)
      a(localObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.d.b
 * JD-Core Version:    0.6.2
 */