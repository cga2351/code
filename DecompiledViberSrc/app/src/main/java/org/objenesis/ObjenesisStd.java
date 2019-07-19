package org.objenesis;

import org.objenesis.strategy.StdInstantiatorStrategy;

public class ObjenesisStd extends ObjenesisBase
{
  public ObjenesisStd()
  {
    super(new StdInstantiatorStrategy());
  }

  public ObjenesisStd(boolean paramBoolean)
  {
    super(new StdInstantiatorStrategy(), paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.ObjenesisStd
 * JD-Core Version:    0.6.2
 */