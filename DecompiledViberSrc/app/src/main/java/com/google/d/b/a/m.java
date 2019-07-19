package com.google.d.b.a;

import com.google.d.d.c;
import com.google.d.f;
import com.google.d.w;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class m<T> extends w<T>
{
  private final f a;
  private final w<T> b;
  private final Type c;

  m(f paramf, w<T> paramw, Type paramType)
  {
    this.a = paramf;
    this.b = paramw;
    this.c = paramType;
  }

  private Type a(Type paramType, Object paramObject)
  {
    if ((paramObject != null) && ((paramType == Object.class) || ((paramType instanceof TypeVariable)) || ((paramType instanceof Class))))
      paramType = paramObject.getClass();
    return paramType;
  }

  public void a(c paramc, T paramT)
    throws IOException
  {
    w localw = this.b;
    Type localType = a(this.c, paramT);
    if (localType != this.c)
    {
      localw = this.a.a(com.google.d.c.a.get(localType));
      if ((localw instanceof i.a))
        break label52;
    }
    while (true)
    {
      localw.a(paramc, paramT);
      return;
      label52: if (!(this.b instanceof i.a))
        localw = this.b;
    }
  }

  public T b(com.google.d.d.a parama)
    throws IOException
  {
    return this.b.b(parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.b.a.m
 * JD-Core Version:    0.6.2
 */