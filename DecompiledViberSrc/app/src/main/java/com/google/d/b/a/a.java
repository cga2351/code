package com.google.d.b.a;

import com.google.d.d.c;
import com.google.d.f;
import com.google.d.w;
import com.google.d.x;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class a<E> extends w<Object>
{
  public static final x a = new x()
  {
    public <T> w<T> a(f paramAnonymousf, com.google.d.c.a<T> paramAnonymousa)
    {
      Type localType1 = paramAnonymousa.getType();
      if ((!(localType1 instanceof GenericArrayType)) && ((!(localType1 instanceof Class)) || (!((Class)localType1).isArray())))
        return null;
      Type localType2 = com.google.d.b.b.g(localType1);
      return new a(paramAnonymousf, paramAnonymousf.a(com.google.d.c.a.get(localType2)), com.google.d.b.b.e(localType2));
    }
  };
  private final Class<E> b;
  private final w<E> c;

  public a(f paramf, w<E> paramw, Class<E> paramClass)
  {
    this.c = new m(paramf, paramw, paramClass);
    this.b = paramClass;
  }

  public void a(c paramc, Object paramObject)
    throws IOException
  {
    if (paramObject == null)
    {
      paramc.f();
      return;
    }
    paramc.b();
    int i = 0;
    int j = Array.getLength(paramObject);
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      this.c.a(paramc, localObject);
      i++;
    }
    paramc.c();
  }

  public Object b(com.google.d.d.a parama)
    throws IOException
  {
    if (parama.f() == com.google.d.d.b.i)
    {
      parama.j();
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    parama.a();
    while (parama.e())
      localArrayList.add(this.c.b(parama));
    parama.b();
    Object localObject = Array.newInstance(this.b, localArrayList.size());
    for (int i = 0; i < localArrayList.size(); i++)
      Array.set(localObject, i, localArrayList.get(i));
    return localObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.b.a.a
 * JD-Core Version:    0.6.2
 */