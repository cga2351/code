package com.viber.voip.messages.a;

import java.lang.ref.WeakReference;

public abstract class e<T, E>
{
  private final WeakReference<T> a;

  public e(T paramT)
  {
    this.a = new WeakReference(paramT);
  }

  protected final void a(E paramE)
  {
    Object localObject = this.a.get();
    if ((localObject != null) && (!b(paramE)))
      a(localObject, paramE);
  }

  protected abstract void a(T paramT, E paramE);

  protected boolean b(E paramE)
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.a.e
 * JD-Core Version:    0.6.2
 */