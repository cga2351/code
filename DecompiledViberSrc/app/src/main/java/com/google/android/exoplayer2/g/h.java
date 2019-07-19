package com.google.android.exoplayer2.g;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class h<T>
{
  private final CopyOnWriteArrayList<b<T>> a = new CopyOnWriteArrayList();

  public void a(Handler paramHandler, T paramT)
  {
    if ((paramHandler != null) && (paramT != null));
    for (boolean bool = true; ; bool = false)
    {
      a.a(bool);
      a(paramT);
      this.a.add(new b(paramHandler, paramT));
      return;
    }
  }

  public void a(a<T> parama)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(parama);
  }

  public void a(T paramT)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (b.a(localb) == paramT)
      {
        localb.a();
        this.a.remove(localb);
      }
    }
  }

  public static abstract interface a<T>
  {
    public abstract void a(T paramT);
  }

  private static final class b<T>
  {
    private final Handler a;
    private final T b;
    private boolean c;

    public b(Handler paramHandler, T paramT)
    {
      this.a = paramHandler;
      this.b = paramT;
    }

    public void a()
    {
      this.c = true;
    }

    public void a(h.a<T> parama)
    {
      this.a.post(new i(this, parama));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.h
 * JD-Core Version:    0.6.2
 */