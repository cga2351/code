package com.esotericsoftware.kryo.factories;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;

public abstract interface SerializerFactory
{
  public abstract Serializer makeSerializer(Kryo paramKryo, Class<?> paramClass);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.factories.SerializerFactory
 * JD-Core Version:    0.6.2
 */