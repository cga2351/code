package org.simpleframework.xml.core;

import org.simpleframework.xml.stream.OutputNode;

abstract interface Decorator
{
  public abstract void decorate(OutputNode paramOutputNode);

  public abstract void decorate(OutputNode paramOutputNode, Decorator paramDecorator);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Decorator
 * JD-Core Version:    0.6.2
 */