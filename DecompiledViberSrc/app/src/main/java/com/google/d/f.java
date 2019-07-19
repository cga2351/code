package com.google.d;

import com.google.d.b.a.g;
import com.google.d.b.a.k;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class f
{
  private static final com.google.d.c.a<?> a = new com.google.d.c.a()
  {
  };
  private final ThreadLocal<Map<com.google.d.c.a<?>, a<?>>> b = new ThreadLocal();
  private final Map<com.google.d.c.a<?>, w<?>> c = new ConcurrentHashMap();
  private final List<x> d;
  private final com.google.d.b.c e;
  private final com.google.d.b.d f;
  private final e g;
  private final boolean h;
  private final boolean i;
  private final boolean j;
  private final boolean k;
  private final boolean l;
  private final com.google.d.b.a.d m;

  public f()
  {
    this(com.google.d.b.d.a, d.a, Collections.emptyMap(), false, false, false, true, false, false, false, v.a, Collections.emptyList());
  }

  f(com.google.d.b.d paramd, e parame, Map<Type, h<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, v paramv, List<x> paramList)
  {
    this.e = new com.google.d.b.c(paramMap);
    this.f = paramd;
    this.g = parame;
    this.h = paramBoolean1;
    this.j = paramBoolean3;
    this.i = paramBoolean4;
    this.k = paramBoolean5;
    this.l = paramBoolean6;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(com.google.d.b.a.n.Y);
    localArrayList.add(com.google.d.b.a.h.a);
    localArrayList.add(paramd);
    localArrayList.addAll(paramList);
    localArrayList.add(com.google.d.b.a.n.D);
    localArrayList.add(com.google.d.b.a.n.m);
    localArrayList.add(com.google.d.b.a.n.g);
    localArrayList.add(com.google.d.b.a.n.i);
    localArrayList.add(com.google.d.b.a.n.k);
    w localw = a(paramv);
    localArrayList.add(com.google.d.b.a.n.a(Long.TYPE, Long.class, localw));
    localArrayList.add(com.google.d.b.a.n.a(Double.TYPE, Double.class, a(paramBoolean7)));
    localArrayList.add(com.google.d.b.a.n.a(Float.TYPE, Float.class, b(paramBoolean7)));
    localArrayList.add(com.google.d.b.a.n.x);
    localArrayList.add(com.google.d.b.a.n.o);
    localArrayList.add(com.google.d.b.a.n.q);
    localArrayList.add(com.google.d.b.a.n.a(AtomicLong.class, a(localw)));
    localArrayList.add(com.google.d.b.a.n.a(AtomicLongArray.class, b(localw)));
    localArrayList.add(com.google.d.b.a.n.s);
    localArrayList.add(com.google.d.b.a.n.z);
    localArrayList.add(com.google.d.b.a.n.F);
    localArrayList.add(com.google.d.b.a.n.H);
    localArrayList.add(com.google.d.b.a.n.a(BigDecimal.class, com.google.d.b.a.n.B));
    localArrayList.add(com.google.d.b.a.n.a(BigInteger.class, com.google.d.b.a.n.C));
    localArrayList.add(com.google.d.b.a.n.J);
    localArrayList.add(com.google.d.b.a.n.L);
    localArrayList.add(com.google.d.b.a.n.P);
    localArrayList.add(com.google.d.b.a.n.R);
    localArrayList.add(com.google.d.b.a.n.W);
    localArrayList.add(com.google.d.b.a.n.N);
    localArrayList.add(com.google.d.b.a.n.d);
    localArrayList.add(com.google.d.b.a.c.a);
    localArrayList.add(com.google.d.b.a.n.U);
    localArrayList.add(k.a);
    localArrayList.add(com.google.d.b.a.j.a);
    localArrayList.add(com.google.d.b.a.n.S);
    localArrayList.add(com.google.d.b.a.a.a);
    localArrayList.add(com.google.d.b.a.n.b);
    localArrayList.add(new com.google.d.b.a.b(this.e));
    localArrayList.add(new g(this.e, paramBoolean2));
    this.m = new com.google.d.b.a.d(this.e);
    localArrayList.add(this.m);
    localArrayList.add(com.google.d.b.a.n.Z);
    localArrayList.add(new com.google.d.b.a.i(this.e, parame, paramd, this.m));
    this.d = Collections.unmodifiableList(localArrayList);
  }

  private static w<Number> a(v paramv)
  {
    if (paramv == v.a)
      return com.google.d.b.a.n.t;
    return new w()
    {
      public Number a(com.google.d.d.a paramAnonymousa)
        throws IOException
      {
        if (paramAnonymousa.f() == com.google.d.d.b.i)
        {
          paramAnonymousa.j();
          return null;
        }
        return Long.valueOf(paramAnonymousa.l());
      }

      public void a(com.google.d.d.c paramAnonymousc, Number paramAnonymousNumber)
        throws IOException
      {
        if (paramAnonymousNumber == null)
        {
          paramAnonymousc.f();
          return;
        }
        paramAnonymousc.b(paramAnonymousNumber.toString());
      }
    };
  }

  private static w<AtomicLong> a(w<Number> paramw)
  {
    return new w()
    {
      public AtomicLong a(com.google.d.d.a paramAnonymousa)
        throws IOException
      {
        return new AtomicLong(((Number)this.a.b(paramAnonymousa)).longValue());
      }

      public void a(com.google.d.d.c paramAnonymousc, AtomicLong paramAnonymousAtomicLong)
        throws IOException
      {
        this.a.a(paramAnonymousc, Long.valueOf(paramAnonymousAtomicLong.get()));
      }
    }
    .a();
  }

  private w<Number> a(boolean paramBoolean)
  {
    if (paramBoolean)
      return com.google.d.b.a.n.v;
    return new w()
    {
      public Double a(com.google.d.d.a paramAnonymousa)
        throws IOException
      {
        if (paramAnonymousa.f() == com.google.d.d.b.i)
        {
          paramAnonymousa.j();
          return null;
        }
        return Double.valueOf(paramAnonymousa.k());
      }

      public void a(com.google.d.d.c paramAnonymousc, Number paramAnonymousNumber)
        throws IOException
      {
        if (paramAnonymousNumber == null)
        {
          paramAnonymousc.f();
          return;
        }
        f.a(paramAnonymousNumber.doubleValue());
        paramAnonymousc.a(paramAnonymousNumber);
      }
    };
  }

  static void a(double paramDouble)
  {
    if ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble)))
      throw new IllegalArgumentException(paramDouble + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
  }

  private static void a(Object paramObject, com.google.d.d.a parama)
  {
    if (paramObject != null)
      try
      {
        if (parama.f() != com.google.d.d.b.j)
          throw new m("JSON document was not fully consumed.");
      }
      catch (com.google.d.d.d locald)
      {
        throw new u(locald);
      }
      catch (IOException localIOException)
      {
        throw new m(localIOException);
      }
  }

  private static w<AtomicLongArray> b(w<Number> paramw)
  {
    return new w()
    {
      public AtomicLongArray a(com.google.d.d.a paramAnonymousa)
        throws IOException
      {
        ArrayList localArrayList = new ArrayList();
        paramAnonymousa.a();
        while (paramAnonymousa.e())
          localArrayList.add(Long.valueOf(((Number)this.a.b(paramAnonymousa)).longValue()));
        paramAnonymousa.b();
        int i = localArrayList.size();
        AtomicLongArray localAtomicLongArray = new AtomicLongArray(i);
        for (int j = 0; j < i; j++)
          localAtomicLongArray.set(j, ((Long)localArrayList.get(j)).longValue());
        return localAtomicLongArray;
      }

      public void a(com.google.d.d.c paramAnonymousc, AtomicLongArray paramAnonymousAtomicLongArray)
        throws IOException
      {
        paramAnonymousc.b();
        int i = 0;
        int j = paramAnonymousAtomicLongArray.length();
        while (i < j)
        {
          this.a.a(paramAnonymousc, Long.valueOf(paramAnonymousAtomicLongArray.get(i)));
          i++;
        }
        paramAnonymousc.c();
      }
    }
    .a();
  }

  private w<Number> b(boolean paramBoolean)
  {
    if (paramBoolean)
      return com.google.d.b.a.n.u;
    return new w()
    {
      public Float a(com.google.d.d.a paramAnonymousa)
        throws IOException
      {
        if (paramAnonymousa.f() == com.google.d.d.b.i)
        {
          paramAnonymousa.j();
          return null;
        }
        return Float.valueOf((float)paramAnonymousa.k());
      }

      public void a(com.google.d.d.c paramAnonymousc, Number paramAnonymousNumber)
        throws IOException
      {
        if (paramAnonymousNumber == null)
        {
          paramAnonymousc.f();
          return;
        }
        f.a(paramAnonymousNumber.floatValue());
        paramAnonymousc.a(paramAnonymousNumber);
      }
    };
  }

  public com.google.d.d.a a(Reader paramReader)
  {
    com.google.d.d.a locala = new com.google.d.d.a(paramReader);
    locala.a(this.l);
    return locala;
  }

  public com.google.d.d.c a(Writer paramWriter)
    throws IOException
  {
    if (this.j)
      paramWriter.write(")]}'\n");
    com.google.d.d.c localc = new com.google.d.d.c(paramWriter);
    if (this.k)
      localc.c("  ");
    localc.d(this.h);
    return localc;
  }

  public l a(Object paramObject)
  {
    if (paramObject == null)
      return n.a;
    return a(paramObject, paramObject.getClass());
  }

  public l a(Object paramObject, Type paramType)
  {
    com.google.d.b.a.f localf = new com.google.d.b.a.f();
    a(paramObject, paramType, localf);
    return localf.a();
  }

  public <T> w<T> a(com.google.d.c.a<T> parama)
  {
    Map localMap1 = this.c;
    if (parama == null);
    Object localObject2;
    for (Object localObject1 = a; ; localObject1 = parama)
    {
      localObject2 = (w)localMap1.get(localObject1);
      if (localObject2 == null)
        break;
      return localObject2;
    }
    Map localMap2 = (Map)this.b.get();
    Object localObject3;
    if (localMap2 == null)
    {
      HashMap localHashMap = new HashMap();
      this.b.set(localHashMap);
      localObject3 = localHashMap;
    }
    for (int n = 1; ; n = 0)
    {
      while (true)
      {
        localObject2 = (a)((Map)localObject3).get(parama);
        if (localObject2 != null)
          break;
        try
        {
          a locala = new a();
          ((Map)localObject3).put(parama, locala);
          Iterator localIterator = this.d.iterator();
          while (localIterator.hasNext())
          {
            localObject2 = ((x)localIterator.next()).a(this, parama);
            if (localObject2 != null)
            {
              locala.a((w)localObject2);
              this.c.put(parama, localObject2);
              return localObject2;
            }
          }
          throw new IllegalArgumentException("GSON cannot handle " + parama);
        }
        finally
        {
          ((Map)localObject3).remove(parama);
          if (n != 0)
            this.b.remove();
        }
      }
      localObject3 = localMap2;
    }
  }

  public <T> w<T> a(x paramx, com.google.d.c.a<T> parama)
  {
    if (!this.d.contains(paramx))
      paramx = this.m;
    Iterator localIterator = this.d.iterator();
    int n = 0;
    while (localIterator.hasNext())
    {
      x localx = (x)localIterator.next();
      if (n == 0)
      {
        if (localx == paramx)
          n = 1;
      }
      else
      {
        w localw = localx.a(this, parama);
        if (localw != null)
          return localw;
      }
    }
    throw new IllegalArgumentException("GSON cannot serialize " + parama);
  }

  public <T> w<T> a(Class<T> paramClass)
  {
    return a(com.google.d.c.a.get(paramClass));
  }

  // ERROR //
  public <T> T a(com.google.d.d.a parama, Type paramType)
    throws m, u
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_1
    //   3: invokevirtual 479	com/google/d/d/a:q	()Z
    //   6: istore 4
    //   8: aload_1
    //   9: iload_3
    //   10: invokevirtual 361	com/google/d/d/a:a	(Z)V
    //   13: aload_1
    //   14: invokevirtual 328	com/google/d/d/a:f	()Lcom/google/d/d/b;
    //   17: pop
    //   18: iconst_0
    //   19: istore_3
    //   20: aload_0
    //   21: aload_2
    //   22: invokestatic 482	com/google/d/c/a:get	(Ljava/lang/reflect/Type;)Lcom/google/d/c/a;
    //   25: invokevirtual 472	com/google/d/f:a	(Lcom/google/d/c/a;)Lcom/google/d/w;
    //   28: aload_1
    //   29: invokevirtual 485	com/google/d/w:b	(Lcom/google/d/d/a;)Ljava/lang/Object;
    //   32: astore 10
    //   34: aload_1
    //   35: iload 4
    //   37: invokevirtual 361	com/google/d/d/a:a	(Z)V
    //   40: aload 10
    //   42: areturn
    //   43: astore 8
    //   45: iload_3
    //   46: ifeq +11 -> 57
    //   49: aload_1
    //   50: iload 4
    //   52: invokevirtual 361	com/google/d/d/a:a	(Z)V
    //   55: aconst_null
    //   56: areturn
    //   57: new 340	com/google/d/u
    //   60: dup
    //   61: aload 8
    //   63: invokespecial 343	com/google/d/u:<init>	(Ljava/lang/Throwable;)V
    //   66: athrow
    //   67: astore 6
    //   69: aload_1
    //   70: iload 4
    //   72: invokevirtual 361	com/google/d/d/a:a	(Z)V
    //   75: aload 6
    //   77: athrow
    //   78: astore 7
    //   80: new 340	com/google/d/u
    //   83: dup
    //   84: aload 7
    //   86: invokespecial 343	com/google/d/u:<init>	(Ljava/lang/Throwable;)V
    //   89: athrow
    //   90: astore 5
    //   92: new 340	com/google/d/u
    //   95: dup
    //   96: aload 5
    //   98: invokespecial 343	com/google/d/u:<init>	(Ljava/lang/Throwable;)V
    //   101: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   13	18	43	java/io/EOFException
    //   20	34	43	java/io/EOFException
    //   13	18	67	finally
    //   20	34	67	finally
    //   57	67	67	finally
    //   80	90	67	finally
    //   92	102	67	finally
    //   13	18	78	java/lang/IllegalStateException
    //   20	34	78	java/lang/IllegalStateException
    //   13	18	90	java/io/IOException
    //   20	34	90	java/io/IOException
  }

  public <T> T a(l paraml, Class<T> paramClass)
    throws u
  {
    Object localObject = a(paraml, paramClass);
    return com.google.d.b.i.a(paramClass).cast(localObject);
  }

  public <T> T a(l paraml, Type paramType)
    throws u
  {
    if (paraml == null)
      return null;
    return a(new com.google.d.b.a.e(paraml), paramType);
  }

  public <T> T a(Reader paramReader, Class<T> paramClass)
    throws u, m
  {
    com.google.d.d.a locala = a(paramReader);
    Object localObject = a(locala, paramClass);
    a(localObject, locala);
    return com.google.d.b.i.a(paramClass).cast(localObject);
  }

  public <T> T a(Reader paramReader, Type paramType)
    throws m, u
  {
    com.google.d.d.a locala = a(paramReader);
    Object localObject = a(locala, paramType);
    a(localObject, locala);
    return localObject;
  }

  public <T> T a(String paramString, Class<T> paramClass)
    throws u
  {
    Object localObject = a(paramString, paramClass);
    return com.google.d.b.i.a(paramClass).cast(localObject);
  }

  public <T> T a(String paramString, Type paramType)
    throws u
  {
    if (paramString == null)
      return null;
    return a(new StringReader(paramString), paramType);
  }

  public String a(l paraml)
  {
    StringWriter localStringWriter = new StringWriter();
    a(paraml, localStringWriter);
    return localStringWriter.toString();
  }

  public void a(l paraml, com.google.d.d.c paramc)
    throws m
  {
    boolean bool1 = paramc.g();
    paramc.b(true);
    boolean bool2 = paramc.h();
    paramc.c(this.i);
    boolean bool3 = paramc.i();
    paramc.d(this.h);
    try
    {
      com.google.d.b.j.a(paraml, paramc);
      return;
    }
    catch (IOException localIOException)
    {
      throw new m(localIOException);
    }
    finally
    {
      paramc.b(bool1);
      paramc.c(bool2);
      paramc.d(bool3);
    }
  }

  public void a(l paraml, Appendable paramAppendable)
    throws m
  {
    try
    {
      a(paraml, a(com.google.d.b.j.a(paramAppendable)));
      return;
    }
    catch (IOException localIOException)
    {
      throw new m(localIOException);
    }
  }

  public void a(Object paramObject, Type paramType, com.google.d.d.c paramc)
    throws m
  {
    w localw = a(com.google.d.c.a.get(paramType));
    boolean bool1 = paramc.g();
    paramc.b(true);
    boolean bool2 = paramc.h();
    paramc.c(this.i);
    boolean bool3 = paramc.i();
    paramc.d(this.h);
    try
    {
      localw.a(paramc, paramObject);
      return;
    }
    catch (IOException localIOException)
    {
      throw new m(localIOException);
    }
    finally
    {
      paramc.b(bool1);
      paramc.c(bool2);
      paramc.d(bool3);
    }
  }

  public void a(Object paramObject, Type paramType, Appendable paramAppendable)
    throws m
  {
    try
    {
      a(paramObject, paramType, a(com.google.d.b.j.a(paramAppendable)));
      return;
    }
    catch (IOException localIOException)
    {
      throw new m(localIOException);
    }
  }

  public String b(Object paramObject)
  {
    if (paramObject == null)
      return a(n.a);
    return b(paramObject, paramObject.getClass());
  }

  public String b(Object paramObject, Type paramType)
  {
    StringWriter localStringWriter = new StringWriter();
    a(paramObject, paramType, localStringWriter);
    return localStringWriter.toString();
  }

  public String toString()
  {
    return "{serializeNulls:" + this.h + "factories:" + this.d + ",instanceCreators:" + this.e + "}";
  }

  static class a<T> extends w<T>
  {
    private w<T> a;

    public void a(com.google.d.d.c paramc, T paramT)
      throws IOException
    {
      if (this.a == null)
        throw new IllegalStateException();
      this.a.a(paramc, paramT);
    }

    public void a(w<T> paramw)
    {
      if (this.a != null)
        throw new AssertionError();
      this.a = paramw;
    }

    public T b(com.google.d.d.a parama)
      throws IOException
    {
      if (this.a == null)
        throw new IllegalStateException();
      return this.a.b(parama);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.f
 * JD-Core Version:    0.6.2
 */