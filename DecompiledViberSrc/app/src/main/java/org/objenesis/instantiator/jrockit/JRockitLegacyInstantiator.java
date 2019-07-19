package org.objenesis.instantiator.jrockit;

import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;

public class JRockitLegacyInstantiator<T>
  implements ObjectInstantiator<T>
{
  private static Method safeAllocObjectMethod = null;
  private final Class<T> type;

  public JRockitLegacyInstantiator(Class<T> paramClass)
  {
    initialize();
    this.type = paramClass;
  }

  private static void initialize()
  {
    if (safeAllocObjectMethod == null);
    try
    {
      safeAllocObjectMethod = Class.forName("jrockit.vm.MemSystem").getDeclaredMethod("safeAllocObject", new Class[] { Class.class });
      safeAllocObjectMethod.setAccessible(true);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw new ObjenesisException(localRuntimeException);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new ObjenesisException(localClassNotFoundException);
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
      Method localMethod = safeAllocObjectMethod;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.type;
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
 * Qualified Name:     org.objenesis.instantiator.jrockit.JRockitLegacyInstantiator
 * JD-Core Version:    0.6.2
 */