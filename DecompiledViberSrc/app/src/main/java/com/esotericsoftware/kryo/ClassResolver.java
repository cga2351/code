package com.esotericsoftware.kryo;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public abstract interface ClassResolver
{
  public abstract Registration getRegistration(int paramInt);

  public abstract Registration getRegistration(Class paramClass);

  public abstract Registration readClass(Input paramInput);

  public abstract Registration register(Registration paramRegistration);

  public abstract Registration registerImplicit(Class paramClass);

  public abstract void reset();

  public abstract void setKryo(Kryo paramKryo);

  public abstract Registration writeClass(Output paramOutput, Class paramClass);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.ClassResolver
 * JD-Core Version:    0.6.2
 */