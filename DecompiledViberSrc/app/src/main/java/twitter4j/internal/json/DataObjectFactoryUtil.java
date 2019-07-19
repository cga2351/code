package twitter4j.internal.json;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import twitter4j.json.DataObjectFactory;

public class DataObjectFactoryUtil
{
  private static final Method CLEAR_THREAD_LOCAL_MAP;
  private static final Method REGISTER_JSON_OBJECT;

  static
  {
    Method[] arrayOfMethod = DataObjectFactory.class.getDeclaredMethods();
    int i = arrayOfMethod.length;
    int j = 0;
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3;
    if (j < i)
    {
      localObject3 = arrayOfMethod[j];
      if (((Method)localObject3).getName().equals("clearThreadLocalMap"))
        ((Method)localObject3).setAccessible(true);
    }
    while (true)
    {
      j++;
      localObject1 = localObject3;
      break;
      if (((Method)localObject3).getName().equals("registerJSONObject"))
      {
        ((Method)localObject3).setAccessible(true);
        localObject2 = localObject3;
        localObject3 = localObject1;
        continue;
        if ((localObject1 == null) || (localObject2 == null))
          throw new AssertionError();
        CLEAR_THREAD_LOCAL_MAP = localObject1;
        REGISTER_JSON_OBJECT = localObject2;
      }
      else
      {
        localObject3 = localObject1;
      }
    }
  }

  private DataObjectFactoryUtil()
  {
    throw new AssertionError("not intended to be instantiated.");
  }

  public static void clearThreadLocalMap()
  {
    try
    {
      CLEAR_THREAD_LOCAL_MAP.invoke(null, new Object[0]);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new AssertionError(localInvocationTargetException);
    }
  }

  public static <T> T registerJSONObject(T paramT, Object paramObject)
  {
    try
    {
      Object localObject = REGISTER_JSON_OBJECT.invoke(null, new Object[] { paramT, paramObject });
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new AssertionError(localInvocationTargetException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.json.DataObjectFactoryUtil
 * JD-Core Version:    0.6.2
 */