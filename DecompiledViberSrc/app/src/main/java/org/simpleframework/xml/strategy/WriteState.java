package org.simpleframework.xml.strategy;

import org.simpleframework.xml.util.WeakCache;

class WriteState extends WeakCache<WriteGraph>
{
  private Contract contract;

  public WriteState(Contract paramContract)
  {
    this.contract = paramContract;
  }

  public WriteGraph find(Object paramObject)
  {
    WriteGraph localWriteGraph = (WriteGraph)fetch(paramObject);
    if (localWriteGraph == null)
    {
      localWriteGraph = new WriteGraph(this.contract);
      cache(paramObject, localWriteGraph);
    }
    return localWriteGraph;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.WriteState
 * JD-Core Version:    0.6.2
 */