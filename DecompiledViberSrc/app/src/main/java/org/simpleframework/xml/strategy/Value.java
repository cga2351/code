package org.simpleframework.xml.strategy;

public abstract interface Value
{
  public abstract int getLength();

  public abstract Class getType();

  public abstract Object getValue();

  public abstract boolean isReference();

  public abstract void setValue(Object paramObject);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.Value
 * JD-Core Version:    0.6.2
 */