package com.adsnative.c;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class j
{
  public static Method a(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass)
    throws NoSuchMethodException
  {
    while (paramClass != null)
      try
      {
        Method localMethod = paramClass.getDeclaredMethod(paramString, paramArrayOfClass);
        return localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        paramClass = paramClass.getSuperclass();
      }
    throw new NoSuchMethodException();
  }

  public static class a
  {
    private final Object a;
    private final String b;
    private Class<?> c;
    private List<Class<?>> d;
    private List<Object> e;
    private boolean f;
    private boolean g;

    public a(Object paramObject, String paramString)
    {
      this.a = paramObject;
      this.b = paramString;
      this.d = new ArrayList();
      this.e = new ArrayList();
      if (paramObject != null);
      for (Class localClass = paramObject.getClass(); ; localClass = null)
      {
        this.c = localClass;
        return;
      }
    }

    public Object a()
      throws Exception
    {
      Class[] arrayOfClass1 = new Class[this.d.size()];
      Class[] arrayOfClass2 = (Class[])this.d.toArray(arrayOfClass1);
      Method localMethod = j.a(this.c, this.b, arrayOfClass2);
      if (this.f)
        localMethod.setAccessible(true);
      Object[] arrayOfObject = this.e.toArray();
      if (this.g)
        return localMethod.invoke(null, arrayOfObject);
      return localMethod.invoke(this.a, arrayOfObject);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.c.j
 * JD-Core Version:    0.6.2
 */