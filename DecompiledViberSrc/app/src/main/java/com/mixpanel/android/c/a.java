package com.mixpanel.android.c;

import android.view.View;
import com.mixpanel.android.b.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class a
{
  private final String a;
  private final Object[] b;
  private final Class<?> c;
  private final Class<?> d;
  private final Method e;

  public a(Class<?> paramClass1, String paramString, Object[] paramArrayOfObject, Class<?> paramClass2)
    throws NoSuchMethodException
  {
    this.a = paramString;
    this.b = paramArrayOfObject;
    this.c = paramClass2;
    this.e = b(paramClass1);
    if (this.e == null)
      throw new NoSuchMethodException("Method " + paramClass1.getName() + "." + this.a + " doesn't exit");
    this.d = this.e.getDeclaringClass();
  }

  private static Class<?> a(Class<?> paramClass)
  {
    if (paramClass == Byte.class)
      paramClass = Byte.TYPE;
    do
    {
      return paramClass;
      if (paramClass == Short.class)
        return Short.TYPE;
      if (paramClass == Integer.class)
        return Integer.TYPE;
      if (paramClass == Long.class)
        return Long.TYPE;
      if (paramClass == Float.class)
        return Float.TYPE;
      if (paramClass == Double.class)
        return Double.TYPE;
      if (paramClass == Boolean.class)
        return Boolean.TYPE;
    }
    while (paramClass != Character.class);
    return Character.TYPE;
  }

  private Method b(Class<?> paramClass)
  {
    Class[] arrayOfClass1 = new Class[this.b.length];
    for (int i = 0; i < this.b.length; i++)
      arrayOfClass1[i] = this.b[i].getClass();
    Method[] arrayOfMethod = paramClass.getMethods();
    int j = arrayOfMethod.length;
    int k = 0;
    if (k < j)
    {
      Method localMethod = arrayOfMethod[k];
      String str = localMethod.getName();
      Class[] arrayOfClass2 = localMethod.getParameterTypes();
      if ((!str.equals(this.a)) || (arrayOfClass2.length != this.b.length));
      boolean bool;
      do
      {
        do
        {
          k++;
          break;
        }
        while (!a(this.c).isAssignableFrom(a(localMethod.getReturnType())));
        bool = true;
        for (int m = 0; (m < arrayOfClass2.length) && (bool); m++)
        {
          Class localClass = a(arrayOfClass1[m]);
          bool = a(arrayOfClass2[m]).isAssignableFrom(localClass);
        }
      }
      while (!bool);
      return localMethod;
    }
    return null;
  }

  public Object a(View paramView)
  {
    return a(paramView, this.b);
  }

  public Object a(View paramView, Object[] paramArrayOfObject)
  {
    Class localClass = paramView.getClass();
    if (this.d.isAssignableFrom(localClass));
    try
    {
      Object localObject = this.e.invoke(paramView, paramArrayOfObject);
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      f.e("MixpanelABTest.Caller", "Method " + this.e.getName() + " appears not to be public", localIllegalAccessException);
      return null;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
        f.e("MixpanelABTest.Caller", "Method " + this.e.getName() + " called with arguments of the wrong type", localIllegalArgumentException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      while (true)
        f.e("MixpanelABTest.Caller", "Method " + this.e.getName() + " threw an exception", localInvocationTargetException);
    }
  }

  public boolean a(Object[] paramArrayOfObject)
  {
    Class[] arrayOfClass = this.e.getParameterTypes();
    if (paramArrayOfObject.length != arrayOfClass.length);
    int i;
    Class localClass;
    do
    {
      return false;
      i = 0;
      if (i >= paramArrayOfObject.length)
        break label128;
      localClass = a(arrayOfClass[i]);
      if (paramArrayOfObject[i] != null)
        break;
    }
    while ((localClass == Byte.TYPE) || (localClass == Short.TYPE) || (localClass == Integer.TYPE) || (localClass == Long.TYPE) || (localClass == Float.TYPE) || (localClass == Double.TYPE) || (localClass == Boolean.TYPE) || (localClass == Character.TYPE));
    while (localClass.isAssignableFrom(a(paramArrayOfObject[i].getClass())))
    {
      i++;
      break;
    }
    return false;
    label128: return true;
  }

  public Object[] a()
  {
    return this.b;
  }

  public String toString()
  {
    return "[Caller " + this.a + "(" + this.b + ")]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.c.a
 * JD-Core Version:    0.6.2
 */