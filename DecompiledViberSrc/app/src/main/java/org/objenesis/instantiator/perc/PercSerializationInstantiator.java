package org.objenesis.instantiator.perc;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;

public class PercSerializationInstantiator<T>
  implements ObjectInstantiator<T>
{
  private final Method newInstanceMethod;
  private Object[] typeArgs;

  public PercSerializationInstantiator(Class<T> paramClass)
  {
    for (Object localObject1 = paramClass; Serializable.class.isAssignableFrom((Class)localObject1); localObject1 = ((Class)localObject1).getSuperclass());
    try
    {
      this.newInstanceMethod = ObjectInputStream.class.getDeclaredMethod("noArgConstruct", new Class[] { Class.class, Object.class, Class.forName("COM.newmonics.PercClassLoader.Method") });
      this.newInstanceMethod.setAccessible(true);
      Object localObject2 = Class.forName("COM.newmonics.PercClassLoader.PercClass").getDeclaredMethod("getPercClass", new Class[] { Class.class }).invoke(null, new Object[] { localObject1 });
      this.typeArgs = new Object[] { localObject1, paramClass, localObject2.getClass().getDeclaredMethod("findMethod", new Class[] { String.class }).invoke(localObject2, new Object[] { "<init>()V" }) };
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new ObjenesisException(localClassNotFoundException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new ObjenesisException(localNoSuchMethodException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new ObjenesisException(localInvocationTargetException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new ObjenesisException(localIllegalAccessException);
    }
  }

  public T newInstance()
  {
    try
    {
      Object localObject = this.newInstanceMethod.invoke(null, this.typeArgs);
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new ObjenesisException(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new ObjenesisException(localInvocationTargetException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.instantiator.perc.PercSerializationInstantiator
 * JD-Core Version:    0.6.2
 */