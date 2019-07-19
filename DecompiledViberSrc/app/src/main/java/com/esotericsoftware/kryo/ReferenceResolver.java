package com.esotericsoftware.kryo;

public abstract interface ReferenceResolver
{
  public abstract int addWrittenObject(Object paramObject);

  public abstract Object getReadObject(Class paramClass, int paramInt);

  public abstract int getWrittenId(Object paramObject);

  public abstract int nextReadId(Class paramClass);

  public abstract void reset();

  public abstract void setKryo(Kryo paramKryo);

  public abstract void setReadObject(int paramInt, Object paramObject);

  public abstract boolean useReferences(Class paramClass);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.ReferenceResolver
 * JD-Core Version:    0.6.2
 */