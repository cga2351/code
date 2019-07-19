package com.google.d.b.a;

import com.google.d.d.c;
import com.google.d.f;
import com.google.d.k;
import com.google.d.p;
import com.google.d.s;
import com.google.d.t;
import com.google.d.w;
import com.google.d.x;
import java.io.IOException;
import java.lang.reflect.Type;

public final class l<T> extends w<T>
{
  private final t<T> a;
  private final k<T> b;
  private final f c;
  private final com.google.d.c.a<T> d;
  private final x e;
  private final l<T>.a f = new a(null);
  private w<T> g;

  public l(t<T> paramt, k<T> paramk, f paramf, com.google.d.c.a<T> parama, x paramx)
  {
    this.a = paramt;
    this.b = paramk;
    this.c = paramf;
    this.d = parama;
    this.e = paramx;
  }

  public static x a(com.google.d.c.a<?> parama, Object paramObject)
  {
    return new b(paramObject, parama, false, null);
  }

  private w<T> b()
  {
    w localw1 = this.g;
    if (localw1 != null)
      return localw1;
    w localw2 = this.c.a(this.e, this.d);
    this.g = localw2;
    return localw2;
  }

  public static x b(com.google.d.c.a<?> parama, Object paramObject)
  {
    if (parama.getType() == parama.getRawType());
    for (boolean bool = true; ; bool = false)
      return new b(paramObject, parama, bool, null);
  }

  public void a(c paramc, T paramT)
    throws IOException
  {
    if (this.a == null)
    {
      b().a(paramc, paramT);
      return;
    }
    if (paramT == null)
    {
      paramc.f();
      return;
    }
    com.google.d.b.j.a(this.a.a(paramT, this.d.getType(), this.f), paramc);
  }

  public T b(com.google.d.d.a parama)
    throws IOException
  {
    if (this.b == null)
      return b().b(parama);
    com.google.d.l locall = com.google.d.b.j.a(parama);
    if (locall.j())
      return null;
    return this.b.b(locall, this.d.getType(), this.f);
  }

  private final class a
    implements com.google.d.j, s
  {
    private a()
    {
    }

    public <R> R a(com.google.d.l paraml, Type paramType)
      throws p
    {
      return l.a(l.this).a(paraml, paramType);
    }
  }

  private static final class b
    implements x
  {
    private final com.google.d.c.a<?> a;
    private final boolean b;
    private final Class<?> c;
    private final t<?> d;
    private final k<?> e;

    b(Object paramObject, com.google.d.c.a<?> parama, boolean paramBoolean, Class<?> paramClass)
    {
      t localt;
      k localk;
      if ((paramObject instanceof t))
      {
        localt = (t)paramObject;
        this.d = localt;
        if (!(paramObject instanceof k))
          break label87;
        localk = (k)paramObject;
        label36: this.e = localk;
        if ((this.d == null) && (this.e == null))
          break label93;
      }
      label87: label93: for (boolean bool = true; ; bool = false)
      {
        com.google.d.b.a.a(bool);
        this.a = parama;
        this.b = paramBoolean;
        this.c = paramClass;
        return;
        localt = null;
        break;
        localk = null;
        break label36;
      }
    }

    public <T> w<T> a(f paramf, com.google.d.c.a<T> parama)
    {
      boolean bool;
      if (this.a != null)
        if ((this.a.equals(parama)) || ((this.b) && (this.a.getType() == parama.getRawType())))
          bool = true;
      while (bool)
      {
        return new l(this.d, this.e, paramf, parama, this);
        bool = false;
        continue;
        bool = this.c.isAssignableFrom(parama.getRawType());
      }
      return null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.b.a.l
 * JD-Core Version:    0.6.2
 */