package org.simpleframework.xml.strategy;

import java.lang.reflect.Array;
import java.util.Map;
import org.simpleframework.xml.stream.Node;
import org.simpleframework.xml.stream.NodeMap;

public class TreeStrategy
  implements Strategy
{
  private final String label;
  private final String length;
  private final Loader loader = new Loader();

  public TreeStrategy()
  {
    this("class", "length");
  }

  public TreeStrategy(String paramString1, String paramString2)
  {
    this.length = paramString2;
    this.label = paramString1;
  }

  private Value readArray(Class paramClass, NodeMap paramNodeMap)
    throws Exception
  {
    Node localNode = paramNodeMap.remove(this.length);
    int i = 0;
    if (localNode != null)
      i = Integer.parseInt(localNode.getValue());
    return new ArrayValue(paramClass, i);
  }

  private Class readValue(Type paramType, NodeMap paramNodeMap)
    throws Exception
  {
    Node localNode = paramNodeMap.remove(this.label);
    Class localClass = paramType.getType();
    if (localClass.isArray())
      localClass = localClass.getComponentType();
    if (localNode != null)
    {
      String str = localNode.getValue();
      localClass = this.loader.load(str);
    }
    return localClass;
  }

  private Class writeArray(Class paramClass, Object paramObject, NodeMap paramNodeMap)
  {
    int i = Array.getLength(paramObject);
    if (this.length != null)
      paramNodeMap.put(this.length, String.valueOf(i));
    return paramClass.getComponentType();
  }

  public Value read(Type paramType, NodeMap paramNodeMap, Map paramMap)
    throws Exception
  {
    Class localClass1 = readValue(paramType, paramNodeMap);
    Class localClass2 = paramType.getType();
    if (localClass2.isArray())
      return readArray(localClass1, paramNodeMap);
    if (localClass2 != localClass1)
      return new ObjectValue(localClass1);
    return null;
  }

  public boolean write(Type paramType, Object paramObject, NodeMap paramNodeMap, Map paramMap)
  {
    Class localClass1 = paramObject.getClass();
    Class localClass2 = paramType.getType();
    if (localClass1.isArray());
    for (Class localClass3 = writeArray(localClass2, paramObject, paramNodeMap); ; localClass3 = localClass1)
    {
      if (localClass1 != localClass2)
        paramNodeMap.put(this.label, localClass3.getName());
      return false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.TreeStrategy
 * JD-Core Version:    0.6.2
 */