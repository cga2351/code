package org.simpleframework.xml.convert;

import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

public abstract interface Converter<T>
{
  public abstract T read(InputNode paramInputNode)
    throws Exception;

  public abstract void write(OutputNode paramOutputNode, T paramT)
    throws Exception;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.convert.Converter
 * JD-Core Version:    0.6.2
 */