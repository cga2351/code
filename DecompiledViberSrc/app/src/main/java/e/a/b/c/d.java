package e.a.b.c;

import e.a.b.f;
import e.a.b.g;
import e.a.b.i;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  public static final e<f> a = new e()
  {
    public <E extends f> void a(E paramAnonymousE, Appendable paramAnonymousAppendable, g paramAnonymousg)
      throws IOException
    {
      paramAnonymousE.a(paramAnonymousAppendable);
    }
  };
  public static final e<f> b = new e()
  {
    public <E extends f> void a(E paramAnonymousE, Appendable paramAnonymousAppendable, g paramAnonymousg)
      throws IOException
    {
      paramAnonymousE.a(paramAnonymousAppendable, paramAnonymousg);
    }
  };
  public static final e<e.a.b.c> c = new e()
  {
    public <E extends e.a.b.c> void a(E paramAnonymousE, Appendable paramAnonymousAppendable, g paramAnonymousg)
      throws IOException
    {
      paramAnonymousAppendable.append(paramAnonymousE.a(paramAnonymousg));
    }
  };
  public static final e<e.a.b.b> d = new e()
  {
    public <E extends e.a.b.b> void a(E paramAnonymousE, Appendable paramAnonymousAppendable, g paramAnonymousg)
      throws IOException
    {
      paramAnonymousAppendable.append(paramAnonymousE.b());
    }
  };
  public static final e<Iterable<? extends Object>> e = new e()
  {
    public <E extends Iterable<? extends Object>> void a(E paramAnonymousE, Appendable paramAnonymousAppendable, g paramAnonymousg)
      throws IOException
    {
      int i = 1;
      paramAnonymousg.g(paramAnonymousAppendable);
      Iterator localIterator = paramAnonymousE.iterator();
      if (!localIterator.hasNext())
      {
        paramAnonymousg.h(paramAnonymousAppendable);
        return;
      }
      Object localObject = localIterator.next();
      if (i != 0)
      {
        i = 0;
        paramAnonymousg.i(paramAnonymousAppendable);
        label54: if (localObject != null)
          break label84;
        paramAnonymousAppendable.append("null");
      }
      while (true)
      {
        paramAnonymousg.k(paramAnonymousAppendable);
        break;
        paramAnonymousg.j(paramAnonymousAppendable);
        break label54;
        label84: i.a(localObject, paramAnonymousAppendable, paramAnonymousg);
      }
    }
  };
  public static final e<Enum<?>> f = new e()
  {
    public <E extends Enum<?>> void a(E paramAnonymousE, Appendable paramAnonymousAppendable, g paramAnonymousg)
      throws IOException
    {
      paramAnonymousg.a(paramAnonymousAppendable, paramAnonymousE.name());
    }
  };
  public static final e<Map<String, ? extends Object>> g = new e()
  {
    public <E extends Map<String, ? extends Object>> void a(E paramAnonymousE, Appendable paramAnonymousAppendable, g paramAnonymousg)
      throws IOException
    {
      paramAnonymousg.a(paramAnonymousAppendable);
      Iterator localIterator = paramAnonymousE.entrySet().iterator();
      int i = 1;
      Map.Entry localEntry;
      Object localObject;
      do
      {
        if (!localIterator.hasNext())
        {
          paramAnonymousg.b(paramAnonymousAppendable);
          return;
        }
        localEntry = (Map.Entry)localIterator.next();
        localObject = localEntry.getValue();
      }
      while ((localObject == null) && (paramAnonymousg.a()));
      if (i != 0)
      {
        paramAnonymousg.c(paramAnonymousAppendable);
        i = 0;
      }
      while (true)
      {
        d.a(localEntry.getKey().toString(), localObject, paramAnonymousAppendable, paramAnonymousg);
        break;
        paramAnonymousg.d(paramAnonymousAppendable);
      }
    }
  };
  public static final e<Object> h = new c();
  public static final e<Object> i = new b();
  public static final e<Object> j = new a();
  public static final e<Object> k = new e()
  {
    public void a(Object paramAnonymousObject, Appendable paramAnonymousAppendable, g paramAnonymousg)
      throws IOException
    {
      paramAnonymousAppendable.append(paramAnonymousObject.toString());
    }
  };
  private ConcurrentHashMap<Class<?>, e<?>> l = new ConcurrentHashMap();
  private LinkedList<a> m = new LinkedList();

  public d()
  {
    a();
  }

  public static void a(String paramString, Object paramObject, Appendable paramAppendable, g paramg)
    throws IOException
  {
    if (paramString == null)
    {
      paramAppendable.append("null");
      paramg.f(paramAppendable);
      if (!(paramObject instanceof String))
        break label86;
      paramg.a(paramAppendable, (String)paramObject);
    }
    while (true)
    {
      paramg.e(paramAppendable);
      return;
      if (!paramg.a(paramString))
      {
        paramAppendable.append(paramString);
        break;
      }
      paramAppendable.append('"');
      i.a(paramString, paramAppendable, paramg);
      paramAppendable.append('"');
      break;
      label86: i.a(paramObject, paramAppendable, paramg);
    }
  }

  public e a(Class<?> paramClass)
  {
    Iterator localIterator = this.m.iterator();
    a locala;
    do
    {
      if (!localIterator.hasNext())
        return null;
      locala = (a)localIterator.next();
    }
    while (!locala.a.isAssignableFrom(paramClass));
    return locala.b;
  }

  public void a()
  {
    a(new e()
    {
      public void a(String paramAnonymousString, Appendable paramAnonymousAppendable, g paramAnonymousg)
        throws IOException
      {
        paramAnonymousg.a(paramAnonymousAppendable, paramAnonymousString);
      }
    }
    , new Class[] { String.class });
    a(new e()
    {
      public void a(Double paramAnonymousDouble, Appendable paramAnonymousAppendable, g paramAnonymousg)
        throws IOException
      {
        if (paramAnonymousDouble.isInfinite())
        {
          paramAnonymousAppendable.append("null");
          return;
        }
        paramAnonymousAppendable.append(paramAnonymousDouble.toString());
      }
    }
    , new Class[] { Double.class });
    a(new e()
    {
      public void a(Date paramAnonymousDate, Appendable paramAnonymousAppendable, g paramAnonymousg)
        throws IOException
      {
        paramAnonymousAppendable.append('"');
        i.a(paramAnonymousDate.toString(), paramAnonymousAppendable, paramAnonymousg);
        paramAnonymousAppendable.append('"');
      }
    }
    , new Class[] { Date.class });
    a(new e()
    {
      public void a(Float paramAnonymousFloat, Appendable paramAnonymousAppendable, g paramAnonymousg)
        throws IOException
      {
        if (paramAnonymousFloat.isInfinite())
        {
          paramAnonymousAppendable.append("null");
          return;
        }
        paramAnonymousAppendable.append(paramAnonymousFloat.toString());
      }
    }
    , new Class[] { Float.class });
    a(k, new Class[] { Integer.class, Long.class, Byte.class, Short.class, BigInteger.class, BigDecimal.class });
    a(k, new Class[] { Boolean.class });
    a(new e()
    {
      public void a(int[] paramAnonymousArrayOfInt, Appendable paramAnonymousAppendable, g paramAnonymousg)
        throws IOException
      {
        int i = 0;
        paramAnonymousg.g(paramAnonymousAppendable);
        int j = paramAnonymousArrayOfInt.length;
        int k = 0;
        if (k >= j)
        {
          paramAnonymousg.h(paramAnonymousAppendable);
          return;
        }
        int m = paramAnonymousArrayOfInt[k];
        if (i != 0)
          paramAnonymousg.d(paramAnonymousAppendable);
        while (true)
        {
          paramAnonymousAppendable.append(Integer.toString(m));
          k++;
          break;
          i = 1;
        }
      }
    }
    , new Class[] { [I.class });
    a(new e()
    {
      public void a(short[] paramAnonymousArrayOfShort, Appendable paramAnonymousAppendable, g paramAnonymousg)
        throws IOException
      {
        int i = 0;
        paramAnonymousg.g(paramAnonymousAppendable);
        int j = paramAnonymousArrayOfShort.length;
        int k = 0;
        if (k >= j)
        {
          paramAnonymousg.h(paramAnonymousAppendable);
          return;
        }
        short s = paramAnonymousArrayOfShort[k];
        if (i != 0)
          paramAnonymousg.d(paramAnonymousAppendable);
        while (true)
        {
          paramAnonymousAppendable.append(Short.toString(s));
          k++;
          break;
          i = 1;
        }
      }
    }
    , new Class[] { [S.class });
    a(new e()
    {
      public void a(long[] paramAnonymousArrayOfLong, Appendable paramAnonymousAppendable, g paramAnonymousg)
        throws IOException
      {
        int i = 0;
        paramAnonymousg.g(paramAnonymousAppendable);
        int j = paramAnonymousArrayOfLong.length;
        int k = 0;
        if (k >= j)
        {
          paramAnonymousg.h(paramAnonymousAppendable);
          return;
        }
        long l = paramAnonymousArrayOfLong[k];
        if (i != 0)
          paramAnonymousg.d(paramAnonymousAppendable);
        while (true)
        {
          paramAnonymousAppendable.append(Long.toString(l));
          k++;
          break;
          i = 1;
        }
      }
    }
    , new Class[] { [J.class });
    a(new e()
    {
      public void a(float[] paramAnonymousArrayOfFloat, Appendable paramAnonymousAppendable, g paramAnonymousg)
        throws IOException
      {
        int i = 0;
        paramAnonymousg.g(paramAnonymousAppendable);
        int j = paramAnonymousArrayOfFloat.length;
        int k = 0;
        if (k >= j)
        {
          paramAnonymousg.h(paramAnonymousAppendable);
          return;
        }
        float f = paramAnonymousArrayOfFloat[k];
        if (i != 0)
          paramAnonymousg.d(paramAnonymousAppendable);
        while (true)
        {
          paramAnonymousAppendable.append(Float.toString(f));
          k++;
          break;
          i = 1;
        }
      }
    }
    , new Class[] { [F.class });
    a(new e()
    {
      public void a(double[] paramAnonymousArrayOfDouble, Appendable paramAnonymousAppendable, g paramAnonymousg)
        throws IOException
      {
        int i = 0;
        paramAnonymousg.g(paramAnonymousAppendable);
        int j = paramAnonymousArrayOfDouble.length;
        int k = 0;
        if (k >= j)
        {
          paramAnonymousg.h(paramAnonymousAppendable);
          return;
        }
        double d = paramAnonymousArrayOfDouble[k];
        if (i != 0)
          paramAnonymousg.d(paramAnonymousAppendable);
        while (true)
        {
          paramAnonymousAppendable.append(Double.toString(d));
          k++;
          break;
          i = 1;
        }
      }
    }
    , new Class[] { [D.class });
    a(new e()
    {
      public void a(boolean[] paramAnonymousArrayOfBoolean, Appendable paramAnonymousAppendable, g paramAnonymousg)
        throws IOException
      {
        int i = 0;
        paramAnonymousg.g(paramAnonymousAppendable);
        int j = paramAnonymousArrayOfBoolean.length;
        int k = 0;
        if (k >= j)
        {
          paramAnonymousg.h(paramAnonymousAppendable);
          return;
        }
        int m = paramAnonymousArrayOfBoolean[k];
        if (i != 0)
          paramAnonymousg.d(paramAnonymousAppendable);
        while (true)
        {
          paramAnonymousAppendable.append(Boolean.toString(m));
          k++;
          break;
          i = 1;
        }
      }
    }
    , new Class[] { [Z.class });
    b(f.class, b);
    b(e.a.b.e.class, a);
    b(e.a.b.c.class, c);
    b(e.a.b.b.class, d);
    b(Map.class, g);
    b(Iterable.class, e);
    b(Enum.class, f);
    b(Number.class, k);
  }

  public <T> void a(e<T> parame, Class<?>[] paramArrayOfClass)
  {
    int n = paramArrayOfClass.length;
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= n)
        return;
      Class<?> localClass = paramArrayOfClass[i1];
      this.l.put(localClass, parame);
    }
  }

  public void a(Class<?> paramClass, e<?> parame)
  {
    this.m.addLast(new a(paramClass, parame));
  }

  public e b(Class paramClass)
  {
    return (e)this.l.get(paramClass);
  }

  public void b(Class<?> paramClass, e<?> parame)
  {
    a(paramClass, parame);
  }

  static class a
  {
    public Class<?> a;
    public e<?> b;

    public a(Class<?> paramClass, e<?> parame)
    {
      this.a = paramClass;
      this.b = parame;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     e.a.b.c.d
 * JD-Core Version:    0.6.2
 */