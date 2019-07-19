package com.viber.voip.ui;

import android.content.Context;
import android.util.SparseArray;
import java.util.HashSet;
import java.util.Iterator;

public abstract class ap<T>
{
  protected final Context a;
  private final SparseArray<T> b;
  private final HashSet<a<T>> c;
  private int d = 0;

  public ap(Context paramContext)
  {
    this.a = paramContext;
    this.b = new SparseArray();
    this.c = new HashSet();
  }

  private void c()
  {
    if (this.c.isEmpty());
    while (true)
    {
      return;
      Object localObject = a();
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
        ((a)localIterator.next()).a(localObject);
    }
  }

  public final T a()
  {
    int i = b();
    Object localObject = this.b.get(i);
    if (localObject == null)
    {
      localObject = b(i);
      this.b.put(i, localObject);
    }
    return localObject;
  }

  public final void a(a<T> parama)
  {
    this.c.add(parama);
  }

  public int b()
  {
    return this.d;
  }

  protected abstract T b(int paramInt);

  public final void b(a<T> parama)
  {
    this.c.remove(parama);
  }

  public final void d(int paramInt)
  {
    if (this.d != paramInt)
    {
      this.d = paramInt;
      c();
    }
  }

  public static abstract interface a<T>
  {
    public abstract void a(T paramT);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.ap
 * JD-Core Version:    0.6.2
 */