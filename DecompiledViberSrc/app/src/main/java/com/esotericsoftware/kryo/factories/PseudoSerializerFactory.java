package com.esotericsoftware.kryo.factories;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;

public class PseudoSerializerFactory
  implements SerializerFactory
{
  private final Serializer<?> serializer;

  public PseudoSerializerFactory(Serializer<?> paramSerializer)
  {
    this.serializer = paramSerializer;
  }

  public Serializer makeSerializer(Kryo paramKryo, Class<?> paramClass)
  {
    return this.serializer;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.factories.PseudoSerializerFactory
 * JD-Core Version:    0.6.2
 */