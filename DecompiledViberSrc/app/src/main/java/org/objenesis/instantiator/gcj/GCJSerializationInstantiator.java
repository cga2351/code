package org.objenesis.instantiator.gcj;

import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.SerializationInstantiatorHelper;

public class GCJSerializationInstantiator<T> extends GCJInstantiatorBase<T>
{
  private Class<? super T> superType;

  public GCJSerializationInstantiator(Class<T> paramClass)
  {
    super(paramClass);
    this.superType = SerializationInstantiatorHelper.getNonSerializableSuperClass(paramClass);
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
      arrayOfObject[1] = this.superType;
      Object localObject = localClass.cast(localMethod.invoke(localObjectInputStream, arrayOfObject));
      return localObject;
    }
    catch (Exception localException)
    {
      throw new ObjenesisException(localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.instantiator.gcj.GCJSerializationInstantiator
 * JD-Core Version:    0.6.2
 */