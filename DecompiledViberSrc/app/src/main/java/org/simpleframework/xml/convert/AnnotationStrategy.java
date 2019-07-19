package org.simpleframework.xml.convert;

import java.util.Map;
import org.simpleframework.xml.strategy.Strategy;
import org.simpleframework.xml.strategy.TreeStrategy;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;

public class AnnotationStrategy
  implements Strategy
{
  private final ConverterScanner scanner = new ConverterScanner();
  private final Strategy strategy;

  public AnnotationStrategy()
  {
    this(new TreeStrategy());
  }

  public AnnotationStrategy(Strategy paramStrategy)
  {
    this.strategy = paramStrategy;
  }

  private boolean isReference(Value paramValue)
  {
    return (paramValue != null) && (paramValue.isReference());
  }

  private Value read(Type paramType, NodeMap<InputNode> paramNodeMap, Value paramValue)
    throws Exception
  {
    Converter localConverter = this.scanner.getConverter(paramType, paramValue);
    InputNode localInputNode = (InputNode)paramNodeMap.getNode();
    if (localConverter != null)
    {
      Object localObject = localConverter.read(localInputNode);
      Class localClass = paramType.getType();
      if (paramValue != null)
        paramValue.setValue(localObject);
      paramValue = new Reference(paramValue, localObject, localClass);
    }
    return paramValue;
  }

  private boolean write(Type paramType, Object paramObject, NodeMap<OutputNode> paramNodeMap)
    throws Exception
  {
    Converter localConverter = this.scanner.getConverter(paramType, paramObject);
    OutputNode localOutputNode = (OutputNode)paramNodeMap.getNode();
    if (localConverter != null)
    {
      localConverter.write(localOutputNode, paramObject);
      return true;
    }
    return false;
  }

  public Value read(Type paramType, NodeMap<InputNode> paramNodeMap, Map paramMap)
    throws Exception
  {
    Value localValue = this.strategy.read(paramType, paramNodeMap, paramMap);
    if (isReference(localValue))
      return localValue;
    return read(paramType, paramNodeMap, localValue);
  }

  public boolean write(Type paramType, Object paramObject, NodeMap<OutputNode> paramNodeMap, Map paramMap)
    throws Exception
  {
    boolean bool = this.strategy.write(paramType, paramObject, paramNodeMap, paramMap);
    if (!bool)
      bool = write(paramType, paramObject, paramNodeMap);
    return bool;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.convert.AnnotationStrategy
 * JD-Core Version:    0.6.2
 */