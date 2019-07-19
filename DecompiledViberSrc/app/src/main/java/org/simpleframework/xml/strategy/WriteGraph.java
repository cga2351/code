package org.simpleframework.xml.strategy;

import java.lang.reflect.Array;
import java.util.IdentityHashMap;
import org.simpleframework.xml.stream.NodeMap;

class WriteGraph extends IdentityHashMap<Object, String>
{
  private final String label;
  private final String length;
  private final String mark;
  private final String refer;

  public WriteGraph(Contract paramContract)
  {
    this.refer = paramContract.getReference();
    this.mark = paramContract.getIdentity();
    this.length = paramContract.getLength();
    this.label = paramContract.getLabel();
  }

  private Class writeArray(Class paramClass, Object paramObject, NodeMap paramNodeMap)
  {
    int i = Array.getLength(paramObject);
    if (!containsKey(paramObject))
      paramNodeMap.put(this.length, String.valueOf(i));
    return paramClass.getComponentType();
  }

  private boolean writeReference(Object paramObject, NodeMap paramNodeMap)
  {
    String str1 = (String)get(paramObject);
    int i = size();
    if (str1 != null)
    {
      paramNodeMap.put(this.refer, str1);
      return true;
    }
    String str2 = String.valueOf(i);
    paramNodeMap.put(this.mark, str2);
    put(paramObject, str2);
    return false;
  }

  public boolean write(Type paramType, Object paramObject, NodeMap paramNodeMap)
  {
    Class localClass1 = paramObject.getClass();
    Class localClass2 = paramType.getType();
    if (localClass1.isArray());
    for (Class localClass3 = writeArray(localClass1, paramObject, paramNodeMap); ; localClass3 = localClass1)
    {
      if (localClass1 != localClass2)
        paramNodeMap.put(this.label, localClass3.getName());
      return writeReference(paramObject, paramNodeMap);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.WriteGraph
 * JD-Core Version:    0.6.2
 */