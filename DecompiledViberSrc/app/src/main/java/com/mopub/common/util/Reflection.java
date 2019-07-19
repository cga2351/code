package com.mopub.common.util;

import com.mopub.common.Preconditions;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Reflection
{
  public static boolean classFound(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    try
    {
      Class.forName(paramString);
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    return false;
  }

  public static Method getDeclaredMethodWithTraversal(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass)
    throws NoSuchMethodException
  {
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramArrayOfClass);
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

  public static Field getPrivateField(Class paramClass, String paramString)
    throws NoSuchFieldException
  {
    Field localField = paramClass.getDeclaredField(paramString);
    localField.setAccessible(true);
    return localField;
  }

  public static <T> T instantiateClassWithConstructor(String paramString, Class<? extends T> paramClass, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
    throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
  {
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramClass);
    Preconditions.checkNotNull(paramArrayOfClass);
    Preconditions.checkNotNull(paramArrayOfObject);
    Constructor localConstructor = Class.forName(paramString).asSubclass(paramClass).getDeclaredConstructor(paramArrayOfClass);
    localConstructor.setAccessible(true);
    return localConstructor.newInstance(paramArrayOfObject);
  }

  public static <T> T instantiateClassWithEmptyConstructor(String paramString, Class<? extends T> paramClass)
    throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NullPointerException
  {
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramClass);
    Constructor localConstructor = Class.forName(paramString).asSubclass(paramClass).getDeclaredConstructor((Class[])null);
    localConstructor.setAccessible(true);
    return localConstructor.newInstance(new Object[0]);
  }

  public static class MethodBuilder
  {
    private final Object a;
    private final String b;
    private Class<?> c;
    private List<Class<?>> d;
    private List<Object> e;
    private boolean f;
    private boolean g;

    public MethodBuilder(Object paramObject, String paramString)
    {
      Preconditions.checkNotNull(paramString);
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

    public <T> MethodBuilder addParam(Class<T> paramClass, T paramT)
    {
      Preconditions.checkNotNull(paramClass);
      this.d.add(paramClass);
      this.e.add(paramT);
      return this;
    }

    public MethodBuilder addParam(String paramString, Object paramObject)
      throws ClassNotFoundException
    {
      Preconditions.checkNotNull(paramString);
      Class localClass = Class.forName(paramString);
      this.d.add(localClass);
      this.e.add(paramObject);
      return this;
    }

    public Object execute()
      throws Exception
    {
      Class[] arrayOfClass1 = new Class[this.d.size()];
      Class[] arrayOfClass2 = (Class[])this.d.toArray(arrayOfClass1);
      Method localMethod = Reflection.getDeclaredMethodWithTraversal(this.c, this.b, arrayOfClass2);
      if (this.f)
        localMethod.setAccessible(true);
      Object[] arrayOfObject = this.e.toArray();
      if (this.g)
        return localMethod.invoke(null, arrayOfObject);
      return localMethod.invoke(this.a, arrayOfObject);
    }

    public MethodBuilder setAccessible()
    {
      this.f = true;
      return this;
    }

    public MethodBuilder setStatic(Class<?> paramClass)
    {
      Preconditions.checkNotNull(paramClass);
      this.g = true;
      this.c = paramClass;
      return this;
    }

    public MethodBuilder setStatic(String paramString)
      throws ClassNotFoundException
    {
      Preconditions.checkNotNull(paramString);
      this.g = true;
      this.c = Class.forName(paramString);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.util.Reflection
 * JD-Core Version:    0.6.2
 */