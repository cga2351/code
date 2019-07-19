package com.esotericsoftware.kryo;

import com.esotericsoftware.kryo.util.Util;
import com.esotericsoftware.minlog.Log;
import org.objenesis.instantiator.ObjectInstantiator;

public class Registration
{
  private final int id;
  private ObjectInstantiator instantiator;
  private Serializer serializer;
  private final Class type;

  public Registration(Class paramClass, Serializer paramSerializer, int paramInt)
  {
    if (paramClass == null)
      throw new IllegalArgumentException("type cannot be null.");
    if (paramSerializer == null)
      throw new IllegalArgumentException("serializer cannot be null.");
    this.type = paramClass;
    this.serializer = paramSerializer;
    this.id = paramInt;
  }

  public int getId()
  {
    return this.id;
  }

  public ObjectInstantiator getInstantiator()
  {
    return this.instantiator;
  }

  public Serializer getSerializer()
  {
    return this.serializer;
  }

  public Class getType()
  {
    return this.type;
  }

  public void setInstantiator(ObjectInstantiator paramObjectInstantiator)
  {
    if (paramObjectInstantiator == null)
      throw new IllegalArgumentException("instantiator cannot be null.");
    this.instantiator = paramObjectInstantiator;
  }

  public void setSerializer(Serializer paramSerializer)
  {
    if (paramSerializer == null)
      throw new IllegalArgumentException("serializer cannot be null.");
    this.serializer = paramSerializer;
    if (Log.TRACE)
      Log.trace("kryo", "Update registered serializer: " + this.type.getName() + " (" + paramSerializer.getClass().getName() + ")");
  }

  public String toString()
  {
    return "[" + this.id + ", " + Util.className(this.type) + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.Registration
 * JD-Core Version:    0.6.2
 */