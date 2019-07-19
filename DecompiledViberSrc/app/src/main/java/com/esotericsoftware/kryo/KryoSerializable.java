package com.esotericsoftware.kryo;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public abstract interface KryoSerializable
{
  public abstract void read(Kryo paramKryo, Input paramInput);

  public abstract void write(Kryo paramKryo, Output paramOutput);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.KryoSerializable
 * JD-Core Version:    0.6.2
 */