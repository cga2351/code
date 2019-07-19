package org.objenesis.instantiator.android;

import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;

public class Android10Instantiator<T>
  implements ObjectInstantiator<T>
{
  private final Method newStaticMethod;
  private final Class<T> type;

  public Android10Instantiator(Class<T> paramClass)
  {
    this.type = paramClass;
    this.newStaticMethod = getNewStaticMethod();
  }

  private static Method getNewStaticMethod()
  {
    try
    {
      Method localMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Class.class });
      localMethod.setAccessible(true);
      return localMethod;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw new ObjenesisException(localRuntimeException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new ObjenesisException(localNoSuchMethodException);
    }
  }

  public T newInstance()
  {
    try
    {
      Class localClass = this.type;
      Method localMethod = this.newStaticMethod;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.type;
      arrayOfObject[1] = Object.class;
      Object localObject = localClass.cast(localMethod.invoke(null, arrayOfObject));
      return localObject;
    }
    catch (Exception localException)
    {
      throw new ObjenesisException(localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.instantiator.android.Android10Instantiator
 * JD-Core Version:    0.6.2
 */