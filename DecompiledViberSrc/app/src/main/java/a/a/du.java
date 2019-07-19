package a.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class du
{
  public static Object a(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    try
    {
      Object localObject = paramMethod.invoke(paramObject, paramArrayOfObject);
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      return null;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
    }
    return null;
  }

  public static Method a(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass)
  {
    try
    {
      Method localMethod = paramClass.getMethod(paramString, paramArrayOfClass);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
    }
    return null;
  }

  public static Method a(String paramString1, String paramString2, Class<?>[] paramArrayOfClass)
  {
    try
    {
      Method localMethod = a(Class.forName(paramString1), paramString2, paramArrayOfClass);
      return localMethod;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.du
 * JD-Core Version:    0.6.2
 */