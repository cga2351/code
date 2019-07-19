package com.google.d.b.a;

import com.google.d.b.h;
import com.google.d.f;
import com.google.d.w;
import com.google.d.x;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

public final class b
  implements x
{
  private final com.google.d.b.c a;

  public b(com.google.d.b.c paramc)
  {
    this.a = paramc;
  }

  public <T> w<T> a(f paramf, com.google.d.c.a<T> parama)
  {
    Type localType1 = parama.getType();
    Class localClass = parama.getRawType();
    if (!Collection.class.isAssignableFrom(localClass))
      return null;
    Type localType2 = com.google.d.b.b.a(localType1, localClass);
    return new a(paramf, localType2, paramf.a(com.google.d.c.a.get(localType2)), this.a.a(parama));
  }

  private static final class a<E> extends w<Collection<E>>
  {
    private final w<E> a;
    private final h<? extends Collection<E>> b;

    public a(f paramf, Type paramType, w<E> paramw, h<? extends Collection<E>> paramh)
    {
      this.a = new m(paramf, paramw, paramType);
      this.b = paramh;
    }

    public Collection<E> a(com.google.d.d.a parama)
      throws IOException
    {
      if (parama.f() == com.google.d.d.b.i)
      {
        parama.j();
        return null;
      }
      Collection localCollection = (Collection)this.b.a();
      parama.a();
      while (parama.e())
        localCollection.add(this.a.b(parama));
      parama.b();
      return localCollection;
    }

    public void a(com.google.d.d.c paramc, Collection<E> paramCollection)
      throws IOException
    {
      if (paramCollection == null)
      {
        paramc.f();
        return;
      }
      paramc.b();
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        this.a.a(paramc, localObject);
      }
      paramc.c();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.b.a.b
 * JD-Core Version:    0.6.2
 */