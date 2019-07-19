package com.esotericsoftware.kryo;

public abstract interface KryoCopyable<T>
{
  public abstract T copy(Kryo paramKryo);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.KryoCopyable
 * JD-Core Version:    0.6.2
 */