package org.simpleframework.xml.strategy;

import java.util.Map;
import org.simpleframework.xml.stream.NodeMap;

public class CycleStrategy
  implements Strategy
{
  private final Contract contract;
  private final ReadState read;
  private final WriteState write;

  public CycleStrategy()
  {
    this("id", "reference");
  }

  public CycleStrategy(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, "class");
  }

  public CycleStrategy(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3, "length");
  }

  public CycleStrategy(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.contract = new Contract(paramString1, paramString2, paramString3, paramString4);
    this.write = new WriteState(this.contract);
    this.read = new ReadState(this.contract);
  }

  public Value read(Type paramType, NodeMap paramNodeMap, Map paramMap)
    throws Exception
  {
    ReadGraph localReadGraph = this.read.find(paramMap);
    if (localReadGraph != null)
      return localReadGraph.read(paramType, paramNodeMap);
    return null;
  }

  public boolean write(Type paramType, Object paramObject, NodeMap paramNodeMap, Map paramMap)
  {
    WriteGraph localWriteGraph = this.write.find(paramMap);
    if (localWriteGraph != null)
      return localWriteGraph.write(paramType, paramObject, paramNodeMap);
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.CycleStrategy
 * JD-Core Version:    0.6.2
 */