package org.objenesis.instantiator.gcj;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;

public abstract class GCJInstantiatorBase<T>
  implements ObjectInstantiator<T>
{
  static ObjectInputStream dummyStream;
  static Method newObjectMethod = null;
  protected final Class<T> type;

  public GCJInstantiatorBase(Class<T> paramClass)
  {
    this.type = paramClass;
    initialize();
  }

  private static void initialize()
  {
    if (newObjectMethod == null);
    try
    {
      newObjectMethod = ObjectInputStream.class.getDeclaredMethod("newObject", new Class[] { Class.class, Class.class });
      newObjectMethod.setAccessible(true);
      dummyStream = new DummyStream();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw new ObjenesisException(localRuntimeException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new ObjenesisException(localNoSuchMethodException);
    }
    catch (IOException localIOException)
    {
      throw new ObjenesisException(localIOException);
    }
  }

  public abstract T newInstance();

  private static class DummyStream extends ObjectInputStream
  {
    public DummyStream()
      throws IOException
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.instantiator.gcj.GCJInstantiatorBase
 * JD-Core Version:    0.6.2
 */