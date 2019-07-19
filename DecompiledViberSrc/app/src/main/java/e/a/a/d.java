package e.a.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class d<T>
{
  private static ConcurrentHashMap<Class<?>, d<?>> c = new ConcurrentHashMap();
  private HashMap<String, b> a;
  private b[] b;

  public static <P> d<P> a(Class<P> paramClass, j paramj)
  {
    d locald = (d)c.get(paramClass);
    if (locald != null);
    while (true)
    {
      return locald;
      b[] arrayOfb = a.a(paramClass, paramj);
      String str1 = paramClass.getName();
      String str2;
      label63: i locali;
      if (str1.startsWith("java.util."))
      {
        str2 = "net.minidev.asm." + str1 + "AccAccess";
        locali = new i(paramClass.getClassLoader());
      }
      try
      {
        Class localClass4 = locali.loadClass(str2);
        localClass1 = localClass4;
        LinkedList localLinkedList = a(paramClass);
        e locale;
        Iterator localIterator1;
        if (localClass1 == null)
        {
          locale = new e(paramClass, arrayOfb, locali);
          localIterator1 = localLinkedList.iterator();
        }
        while (true)
        {
          while (true)
          {
            if (localIterator1.hasNext())
              break label248;
            localClass1 = locale.a();
            try
            {
              locald = (d)localClass1.newInstance();
              locald.a(arrayOfb);
              c.putIfAbsent(paramClass, locald);
              Iterator localIterator2 = localLinkedList.iterator();
              while (localIterator2.hasNext())
              {
                Class localClass3 = (Class)localIterator2.next();
                a(locald, (HashMap)f.b.get(localClass3));
              }
            }
            catch (Exception localException)
            {
              throw new RuntimeException("Error constructing accessor class: " + str2, localException);
            }
          }
          str2 = str1.concat("AccAccess");
          break label63;
          label248: Class localClass2 = (Class)localIterator1.next();
          locale.a((Iterable)f.a.get(localClass2));
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        while (true)
          Class localClass1 = null;
      }
    }
  }

  private static LinkedList<Class<?>> a(Class<?> paramClass)
  {
    LinkedList localLinkedList = new LinkedList();
    if ((paramClass == null) || (paramClass.equals(Object.class)))
    {
      localLinkedList.addLast(Object.class);
      return localLinkedList;
    }
    localLinkedList.addLast(paramClass);
    Class[] arrayOfClass = paramClass.getInterfaces();
    int i = arrayOfClass.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
      {
        paramClass = paramClass.getSuperclass();
        break;
      }
      localLinkedList.addLast(arrayOfClass[j]);
    }
  }

  private static void a(d<?> paramd, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null)
      return;
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        paramd.a.putAll(localHashMap);
        return;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      b localb = (b)paramd.a.get(localEntry.getValue());
      if (localb != null)
        localHashMap.put((String)localEntry.getValue(), localb);
    }
  }

  public abstract Object a(T paramT, int paramInt);

  protected void a(b[] paramArrayOfb)
  {
    int i = 0;
    this.b = paramArrayOfb;
    this.a = new HashMap();
    int j = paramArrayOfb.length;
    int m;
    for (int k = 0; ; k = m)
    {
      if (i >= j)
        return;
      b localb = paramArrayOfb[i];
      m = k + 1;
      localb.d = k;
      this.a.put(localb.d(), localb);
      i++;
    }
  }

  public b[] a()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     e.a.a.d
 * JD-Core Version:    0.6.2
 */