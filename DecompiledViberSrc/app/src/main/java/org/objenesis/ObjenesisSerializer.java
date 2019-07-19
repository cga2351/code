package org.objenesis;

import org.objenesis.strategy.SerializingInstantiatorStrategy;

public class ObjenesisSerializer extends ObjenesisBase
{
  public ObjenesisSerializer()
  {
    super(new SerializingInstantiatorStrategy());
  }

  public ObjenesisSerializer(boolean paramBoolean)
  {
    super(new SerializingInstantiatorStrategy(), paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.ObjenesisSerializer
 * JD-Core Version:    0.6.2
 */