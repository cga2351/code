package org.objenesis.strategy;

import java.io.NotSerializableException;
import java.io.Serializable;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.android.AndroidSerializationInstantiator;
import org.objenesis.instantiator.basic.ObjectStreamClassInstantiator;
import org.objenesis.instantiator.gcj.GCJSerializationInstantiator;
import org.objenesis.instantiator.perc.PercSerializationInstantiator;

public class SerializingInstantiatorStrategy extends BaseInstantiatorStrategy
{
  public <T> ObjectInstantiator<T> newInstantiatorOf(Class<T> paramClass)
  {
    if (!Serializable.class.isAssignableFrom(paramClass))
      throw new ObjenesisException(new NotSerializableException(paramClass + " not serializable"));
    if ((PlatformDescription.JVM_NAME.startsWith("Java HotSpot")) || (PlatformDescription.isThisJVM("OpenJDK")))
      return new ObjectStreamClassInstantiator(paramClass);
    if (PlatformDescription.JVM_NAME.startsWith("Dalvik"))
      return new AndroidSerializationInstantiator(paramClass);
    if (PlatformDescription.JVM_NAME.startsWith("GNU libgcj"))
      return new GCJSerializationInstantiator(paramClass);
    if (PlatformDescription.JVM_NAME.startsWith("PERC"))
      return new PercSerializationInstantiator(paramClass);
    return new ObjectStreamClassInstantiator(paramClass);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.strategy.SerializingInstantiatorStrategy
 * JD-Core Version:    0.6.2
 */