package android.arch.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class a
{
  static a a = new a();
  private final Map<Class, a> b = new HashMap();
  private final Map<Class, Boolean> c = new HashMap();

  private a a(Class paramClass, Method[] paramArrayOfMethod)
  {
    Class localClass = paramClass.getSuperclass();
    HashMap localHashMap = new HashMap();
    if (localClass != null)
    {
      a locala2 = b(localClass);
      if (locala2 != null)
        localHashMap.putAll(locala2.b);
    }
    Class[] arrayOfClass1 = paramClass.getInterfaces();
    int i = arrayOfClass1.length;
    for (int j = 0; j < i; j++)
    {
      Iterator localIterator = b(arrayOfClass1[j]).b.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        a(localHashMap, (b)localEntry.getKey(), (e.a)localEntry.getValue(), paramClass);
      }
    }
    if (paramArrayOfMethod != null);
    boolean bool1;
    Method localMethod;
    o localo;
    boolean bool2;
    while (true)
    {
      int k = paramArrayOfMethod.length;
      int m = 0;
      for (bool1 = false; ; bool1 = bool2)
      {
        if (m >= k)
          break label352;
        localMethod = paramArrayOfMethod[m];
        localo = (o)localMethod.getAnnotation(o.class);
        if (localo != null)
          break;
        bool2 = bool1;
        m++;
      }
      paramArrayOfMethod = c(paramClass);
    }
    Class[] arrayOfClass2 = localMethod.getParameterTypes();
    if (arrayOfClass2.length > 0)
      if (!arrayOfClass2[0].isAssignableFrom(h.class))
        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
    for (int n = 1; ; n = 0)
    {
      e.a locala = localo.a();
      if (arrayOfClass2.length > 1)
      {
        if (!arrayOfClass2[1].isAssignableFrom(e.a.class))
          throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
        if (locala != e.a.ON_ANY)
          throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
        n = 2;
      }
      if (arrayOfClass2.length > 2)
        throw new IllegalArgumentException("cannot have more than 2 params");
      a(localHashMap, new b(n, localMethod), locala, paramClass);
      bool2 = true;
      break;
      label352: a locala1 = new a(localHashMap);
      this.b.put(paramClass, locala1);
      this.c.put(paramClass, Boolean.valueOf(bool1));
      return locala1;
    }
  }

  private void a(Map<b, e.a> paramMap, b paramb, e.a parama, Class paramClass)
  {
    e.a locala = (e.a)paramMap.get(paramb);
    if ((locala != null) && (parama != locala))
    {
      Method localMethod = paramb.b;
      throw new IllegalArgumentException("Method " + localMethod.getName() + " in " + paramClass.getName() + " already declared with different @OnLifecycleEvent value: previous value " + locala + ", new value " + parama);
    }
    if (locala == null)
      paramMap.put(paramb, parama);
  }

  private Method[] c(Class paramClass)
  {
    try
    {
      Method[] arrayOfMethod = paramClass.getDeclaredMethods();
      return arrayOfMethod;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", localNoClassDefFoundError);
    }
  }

  boolean a(Class paramClass)
  {
    if (this.c.containsKey(paramClass))
      return ((Boolean)this.c.get(paramClass)).booleanValue();
    Method[] arrayOfMethod = c(paramClass);
    int i = arrayOfMethod.length;
    for (int j = 0; j < i; j++)
      if ((o)arrayOfMethod[j].getAnnotation(o.class) != null)
      {
        a(paramClass, arrayOfMethod);
        return true;
      }
    this.c.put(paramClass, Boolean.valueOf(false));
    return false;
  }

  a b(Class paramClass)
  {
    a locala = (a)this.b.get(paramClass);
    if (locala != null)
      return locala;
    return a(paramClass, null);
  }

  static class a
  {
    final Map<e.a, List<a.b>> a;
    final Map<a.b, e.a> b;

    a(Map<a.b, e.a> paramMap)
    {
      this.b = paramMap;
      this.a = new HashMap();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        e.a locala = (e.a)localEntry.getValue();
        Object localObject = (List)this.a.get(locala);
        if (localObject == null)
        {
          localObject = new ArrayList();
          this.a.put(locala, localObject);
        }
        ((List)localObject).add(localEntry.getKey());
      }
    }

    private static void a(List<a.b> paramList, h paramh, e.a parama, Object paramObject)
    {
      if (paramList != null)
        for (int i = -1 + paramList.size(); i >= 0; i--)
          ((a.b)paramList.get(i)).a(paramh, parama, paramObject);
    }

    void a(h paramh, e.a parama, Object paramObject)
    {
      a((List)this.a.get(parama), paramh, parama, paramObject);
      a((List)this.a.get(e.a.ON_ANY), paramh, parama, paramObject);
    }
  }

  static class b
  {
    final int a;
    final Method b;

    b(int paramInt, Method paramMethod)
    {
      this.a = paramInt;
      this.b = paramMethod;
      this.b.setAccessible(true);
    }

    void a(h paramh, e.a parama, Object paramObject)
    {
      try
      {
        switch (this.a)
        {
        case 0:
          this.b.invoke(paramObject, new Object[0]);
          return;
        case 1:
        case 2:
        }
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new RuntimeException("Failed to call observer method", localInvocationTargetException.getCause());
        this.b.invoke(paramObject, new Object[] { paramh });
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException(localIllegalAccessException);
      }
      this.b.invoke(paramObject, new Object[] { paramh, parama });
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      b localb;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        localb = (b)paramObject;
      }
      while ((this.a == localb.a) && (this.b.getName().equals(localb.b.getName())));
      return false;
    }

    public int hashCode()
    {
      return 31 * this.a + this.b.getName().hashCode();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.lifecycle.a
 * JD-Core Version:    0.6.2
 */