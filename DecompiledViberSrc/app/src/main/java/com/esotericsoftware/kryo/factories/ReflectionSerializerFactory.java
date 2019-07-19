package com.esotericsoftware.kryo.factories;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.util.Util;
import java.lang.reflect.Constructor;

public class ReflectionSerializerFactory
  implements SerializerFactory
{
  private final Class<? extends Serializer> serializerClass;

  public ReflectionSerializerFactory(Class<? extends Serializer> paramClass)
  {
    this.serializerClass = paramClass;
  }

  public static Serializer makeSerializer(Kryo paramKryo, Class<? extends Serializer> paramClass, Class<?> paramClass1)
  {
    try
    {
      Serializer localSerializer4 = (Serializer)paramClass.getConstructor(new Class[] { Kryo.class, Class.class }).newInstance(new Object[] { paramKryo, paramClass1 });
      return localSerializer4;
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      try
      {
        Serializer localSerializer3 = (Serializer)paramClass.getConstructor(new Class[] { Kryo.class }).newInstance(new Object[] { paramKryo });
        return localSerializer3;
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        try
        {
          Serializer localSerializer2 = (Serializer)paramClass.getConstructor(new Class[] { Class.class }).newInstance(new Object[] { paramClass1 });
          return localSerializer2;
        }
        catch (NoSuchMethodException localNoSuchMethodException3)
        {
          Serializer localSerializer1 = (Serializer)paramClass.newInstance();
          return localSerializer1;
        }
      }
    }
    catch (Exception localException)
    {
      throw new IllegalArgumentException("Unable to create serializer \"" + paramClass.getName() + "\" for class: " + Util.className(paramClass1), localException);
    }
  }

  public Serializer makeSerializer(Kryo paramKryo, Class<?> paramClass)
  {
    return makeSerializer(paramKryo, this.serializerClass, paramClass);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.factories.ReflectionSerializerFactory
 * JD-Core Version:    0.6.2
 */