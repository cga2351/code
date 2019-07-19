package com.google.d.b.a;

import com.google.d.b.g;
import com.google.d.d.b;
import com.google.d.d.c;
import com.google.d.f;
import com.google.d.w;
import com.google.d.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class h extends w<Object>
{
  public static final x a = new x()
  {
    public <T> w<T> a(f paramAnonymousf, com.google.d.c.a<T> paramAnonymousa)
    {
      if (paramAnonymousa.getRawType() == Object.class)
        return new h(paramAnonymousf);
      return null;
    }
  };
  private final f b;

  h(f paramf)
  {
    this.b = paramf;
  }

  public void a(c paramc, Object paramObject)
    throws IOException
  {
    if (paramObject == null)
    {
      paramc.f();
      return;
    }
    w localw = this.b.a(paramObject.getClass());
    if ((localw instanceof h))
    {
      paramc.d();
      paramc.e();
      return;
    }
    localw.a(paramc, paramObject);
  }

  public Object b(com.google.d.d.a parama)
    throws IOException
  {
    b localb = parama.f();
    switch (2.a[localb.ordinal()])
    {
    default:
      throw new IllegalStateException();
    case 1:
      ArrayList localArrayList = new ArrayList();
      parama.a();
      while (parama.e())
        localArrayList.add(b(parama));
      parama.b();
      return localArrayList;
    case 2:
      g localg = new g();
      parama.c();
      while (parama.e())
        localg.put(parama.g(), b(parama));
      parama.d();
      return localg;
    case 3:
      return parama.h();
    case 4:
      return Double.valueOf(parama.k());
    case 5:
      return Boolean.valueOf(parama.i());
    case 6:
    }
    parama.j();
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.b.a.h
 * JD-Core Version:    0.6.2
 */