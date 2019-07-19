package com.google.a.a.d;

import com.google.a.a.f.ag;
import com.google.a.a.f.i;
import com.google.a.a.f.k;
import com.google.a.a.f.m;
import com.google.a.a.f.n;
import com.google.a.a.f.z;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class d
{
  private void a(boolean paramBoolean, Object paramObject)
    throws IOException
  {
    boolean bool1 = true;
    if (paramObject == null)
      return;
    Class localClass = paramObject.getClass();
    if (i.a(paramObject))
    {
      f();
      return;
    }
    if ((paramObject instanceof String))
    {
      b((String)paramObject);
      return;
    }
    if ((paramObject instanceof Number))
    {
      if (paramBoolean)
      {
        b(paramObject.toString());
        return;
      }
      if ((paramObject instanceof BigDecimal))
      {
        a((BigDecimal)paramObject);
        return;
      }
      if ((paramObject instanceof BigInteger))
      {
        a((BigInteger)paramObject);
        return;
      }
      if ((paramObject instanceof Long))
      {
        a(((Long)paramObject).longValue());
        return;
      }
      if ((paramObject instanceof Float))
      {
        float f = ((Number)paramObject).floatValue();
        if ((!Float.isInfinite(f)) && (!Float.isNaN(f)));
        for (boolean bool4 = bool1; ; bool4 = false)
        {
          z.a(bool4);
          a(f);
          return;
        }
      }
      if (((paramObject instanceof Integer)) || ((paramObject instanceof Short)) || ((paramObject instanceof Byte)))
      {
        a(((Number)paramObject).intValue());
        return;
      }
      double d = ((Number)paramObject).doubleValue();
      if ((!Double.isInfinite(d)) && (!Double.isNaN(d)));
      while (true)
      {
        z.a(bool1);
        a(d);
        return;
        bool1 = false;
      }
    }
    if ((paramObject instanceof Boolean))
    {
      a(((Boolean)paramObject).booleanValue());
      return;
    }
    if ((paramObject instanceof k))
    {
      b(((k)paramObject).b());
      return;
    }
    if (((paramObject instanceof Iterable)) || (localClass.isArray()))
    {
      b();
      Iterator localIterator1 = ag.a(paramObject).iterator();
      while (localIterator1.hasNext())
        a(paramBoolean, localIterator1.next());
      c();
      return;
    }
    if (localClass.isEnum())
    {
      String str2 = m.a((Enum)paramObject).b();
      if (str2 == null)
      {
        f();
        return;
      }
      b(str2);
      return;
    }
    d();
    boolean bool2;
    com.google.a.a.f.h localh;
    label403: label419: Object localObject;
    String str1;
    boolean bool3;
    if (((paramObject instanceof Map)) && (!(paramObject instanceof n)))
    {
      bool2 = bool1;
      if (!bool2)
        break label498;
      localh = null;
      Iterator localIterator2 = i.b(paramObject).entrySet().iterator();
      Map.Entry localEntry;
      do
      {
        if (!localIterator2.hasNext())
          break;
        localEntry = (Map.Entry)localIterator2.next();
        localObject = localEntry.getValue();
      }
      while (localObject == null);
      str1 = (String)localEntry.getKey();
      if (!bool2)
        break label508;
      bool3 = paramBoolean;
    }
    while (true)
    {
      a(str1);
      a(bool3, localObject);
      break label419;
      bool2 = false;
      break;
      label498: localh = com.google.a.a.f.h.a(localClass);
      break label403;
      label508: Field localField = localh.b(str1);
      if ((localField != null) && (localField.getAnnotation(h.class) != null))
        bool3 = bool1;
      else
        bool3 = false;
    }
    e();
  }

  public abstract void a()
    throws IOException;

  public abstract void a(double paramDouble)
    throws IOException;

  public abstract void a(float paramFloat)
    throws IOException;

  public abstract void a(int paramInt)
    throws IOException;

  public abstract void a(long paramLong)
    throws IOException;

  public final void a(Object paramObject)
    throws IOException
  {
    a(false, paramObject);
  }

  public abstract void a(String paramString)
    throws IOException;

  public abstract void a(BigDecimal paramBigDecimal)
    throws IOException;

  public abstract void a(BigInteger paramBigInteger)
    throws IOException;

  public abstract void a(boolean paramBoolean)
    throws IOException;

  public abstract void b()
    throws IOException;

  public abstract void b(String paramString)
    throws IOException;

  public abstract void c()
    throws IOException;

  public abstract void d()
    throws IOException;

  public abstract void e()
    throws IOException;

  public abstract void f()
    throws IOException;

  public void g()
    throws IOException
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.d.d
 * JD-Core Version:    0.6.2
 */