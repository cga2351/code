package com.google.a.a.f;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  private final Map<String, a> a = a.a();
  private final Map<Field, a> b = a.a();
  private final Object c;

  public b(Object paramObject)
  {
    this.c = paramObject;
  }

  public void a()
  {
    Iterator localIterator1 = this.a.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)localIterator1.next();
      ((Map)this.c).put(localEntry2.getKey(), ((a)localEntry2.getValue()).a());
    }
    Iterator localIterator2 = this.b.entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator2.next();
      m.a((Field)localEntry1.getKey(), this.c, ((a)localEntry1.getValue()).a());
    }
  }

  public void a(Field paramField, Class<?> paramClass, Object paramObject)
  {
    a locala = (a)this.b.get(paramField);
    if (locala == null)
    {
      locala = new a(paramClass);
      this.b.put(paramField, locala);
    }
    locala.a(paramClass, paramObject);
  }

  static class a
  {
    final Class<?> a;
    final ArrayList<Object> b = new ArrayList();

    a(Class<?> paramClass)
    {
      this.a = paramClass;
    }

    Object a()
    {
      return ag.a(this.b, this.a);
    }

    void a(Class<?> paramClass, Object paramObject)
    {
      if (paramClass == this.a);
      for (boolean bool = true; ; bool = false)
      {
        z.a(bool);
        this.b.add(paramObject);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.f.b
 * JD-Core Version:    0.6.2
 */