package com.viber.voip.util;

import com.viber.common.a.e;
import com.viber.voip.ViberEnv;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class cl
{
  private static final e a = ViberEnv.getLogger();

  public static List<String> a(Class<?> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    for (Field localField : paramClass.getDeclaredFields())
      if (Modifier.isStatic(localField.getModifiers()))
        localArrayList.add(localField.getName());
    return localArrayList;
  }

  public static <T> void a(Class<?> paramClass, Class<T> paramClass1, a<T> parama)
  {
    int i = 0;
    Field[] arrayOfField = paramClass.getDeclaredFields();
    int j = arrayOfField.length;
    int k = 0;
    while (true)
    {
      Field localField;
      if (k < j)
      {
        localField = arrayOfField[k];
        if (((paramClass1 != null) && (!localField.getType().isAssignableFrom(paramClass1))) || (!Modifier.isStatic(localField.getModifiers())));
      }
      try
      {
        parama.a(localField.get(null));
        label69: k++;
        continue;
        Class[] arrayOfClass = paramClass.getDeclaredClasses();
        int m = arrayOfClass.length;
        while (i < m)
        {
          a(arrayOfClass[i], paramClass1, parama);
          i++;
        }
        return;
      }
      catch (Exception localException)
      {
        break label69;
      }
    }
  }

  public static <T> T b(Class<T> paramClass)
  {
    return Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass }, new InvocationHandler()
    {
      public Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
        throws Throwable
      {
        return c.a(paramAnonymousMethod);
      }
    });
  }

  public static Object c(Class<?> paramClass)
  {
    return b(d(paramClass));
  }

  private static Class<?> d(Class<?> paramClass)
  {
    for (Type localType = paramClass.getGenericSuperclass(); !(localType instanceof ParameterizedType); localType = paramClass.getGenericSuperclass())
      paramClass = paramClass.getSuperclass();
    return (Class)((ParameterizedType)localType).getActualTypeArguments()[0];
  }

  public static abstract interface a<T>
  {
    public abstract void a(T paramT);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.cl
 * JD-Core Version:    0.6.2
 */