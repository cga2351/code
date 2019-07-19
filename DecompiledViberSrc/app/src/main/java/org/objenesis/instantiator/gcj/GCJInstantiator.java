package org.objenesis.instantiator.gcj;

import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;

public class GCJInstantiator<T> extends GCJInstantiatorBase<T>
{
  public GCJInstantiator(Class<T> paramClass)
  {
    super(paramClass);
  }

  public T newInstance()
  {
    try
    {
      Class localClass = this.type;
      Method localMethod = newObjectMethod;
      ObjectInputStream localObjectInputStream = dummyStream;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.type;
      arrayOfObject[1] = Object.class;
      Object localObject = localClass.cast(localMethod.invoke(localObjectInputStream, arrayOfObject));
      return localObject;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw new ObjenesisException(localRuntimeException);
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
 * Qualified Name:     org.objenesis.instantiator.gcj.GCJInstantiator
 * JD-Core Version:    0.6.2
 */