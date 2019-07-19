package e.a.a;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class f
{
  protected static HashMap<Class<?>, LinkedHashSet<Class<?>>> a = new HashMap();
  protected static HashMap<Class<?>, HashMap<String, String>> b = new HashMap();

  static
  {
    a(Object.class, h.class);
    a(Object.class, g.class);
  }

  public static void a(Class<?> paramClass1, Class<?> paramClass2)
  {
    synchronized (a)
    {
      LinkedHashSet localLinkedHashSet = (LinkedHashSet)a.get(paramClass1);
      if (localLinkedHashSet == null)
      {
        localLinkedHashSet = new LinkedHashSet();
        a.put(paramClass1, localLinkedHashSet);
      }
      localLinkedHashSet.add(paramClass2);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     e.a.a.f
 * JD-Core Version:    0.6.2
 */