package com.esotericsoftware.kryo;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public abstract class Serializer<T>
{
  private boolean acceptsNull;
  private boolean immutable;

  public Serializer()
  {
  }

  public Serializer(boolean paramBoolean)
  {
    this.acceptsNull = paramBoolean;
  }

  public Serializer(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.acceptsNull = paramBoolean1;
    this.immutable = paramBoolean2;
  }

  public T copy(Kryo paramKryo, T paramT)
  {
    if (this.immutable)
      return paramT;
    throw new KryoException("Serializer does not support copy: " + getClass().getName());
  }

  public boolean getAcceptsNull()
  {
    return this.acceptsNull;
  }

  public boolean isImmutable()
  {
    return this.immutable;
  }

  public abstract T read(Kryo paramKryo, Input paramInput, Class<T> paramClass);

  public void setAcceptsNull(boolean paramBoolean)
  {
    this.acceptsNull = paramBoolean;
  }

  public void setGenerics(Kryo paramKryo, Class[] paramArrayOfClass)
  {
  }

  public void setImmutable(boolean paramBoolean)
  {
    this.immutable = paramBoolean;
  }

  public abstract void write(Kryo paramKryo, Output paramOutput, T paramT);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.Serializer
 * JD-Core Version:    0.6.2
 */