package org.simpleframework.xml.strategy;

import java.util.HashMap;
import org.simpleframework.xml.stream.Node;
import org.simpleframework.xml.stream.NodeMap;

class ReadGraph extends HashMap
{
  private final String label;
  private final String length;
  private final Loader loader;
  private final String mark;
  private final String refer;

  public ReadGraph(Contract paramContract, Loader paramLoader)
  {
    this.refer = paramContract.getReference();
    this.mark = paramContract.getIdentity();
    this.length = paramContract.getLength();
    this.label = paramContract.getLabel();
    this.loader = paramLoader;
  }

  private Value readArray(Type paramType, Class paramClass, NodeMap paramNodeMap)
    throws Exception
  {
    Node localNode = paramNodeMap.remove(this.length);
    int i = 0;
    if (localNode != null)
      i = Integer.parseInt(localNode.getValue());
    return new ArrayValue(paramClass, i);
  }

  private Value readInstance(Type paramType, Class paramClass, NodeMap paramNodeMap)
    throws Exception
  {
    Node localNode = paramNodeMap.remove(this.mark);
    if (localNode == null)
      return readReference(paramType, paramClass, paramNodeMap);
    String str = localNode.getValue();
    if (containsKey(str))
      throw new CycleException("Element '%s' already exists", new Object[] { str });
    return readValue(paramType, paramClass, paramNodeMap, str);
  }

  private Value readReference(Type paramType, Class paramClass, NodeMap paramNodeMap)
    throws Exception
  {
    Node localNode = paramNodeMap.remove(this.refer);
    if (localNode == null)
      return readValue(paramType, paramClass, paramNodeMap);
    String str = localNode.getValue();
    Object localObject = get(str);
    if (!containsKey(str))
      throw new CycleException("Invalid reference '%s' found", new Object[] { str });
    return new Reference(localObject, paramClass);
  }

  private Value readValue(Type paramType, Class paramClass, NodeMap paramNodeMap)
    throws Exception
  {
    if (paramType.getType().isArray())
      return readArray(paramType, paramClass, paramNodeMap);
    return new ObjectValue(paramClass);
  }

  private Value readValue(Type paramType, Class paramClass, NodeMap paramNodeMap, String paramString)
    throws Exception
  {
    Value localValue = readValue(paramType, paramClass, paramNodeMap);
    if (paramString != null)
      return new Allocate(localValue, this, paramString);
    return localValue;
  }

  public Value read(Type paramType, NodeMap paramNodeMap)
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
    return readInstance(paramType, localClass, paramNodeMap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.ReadGraph
 * JD-Core Version:    0.6.2
 */