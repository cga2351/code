package org.simpleframework.xml.strategy;

import org.simpleframework.xml.util.WeakCache;

class ReadState extends WeakCache<ReadGraph>
{
  private final Contract contract;
  private final Loader loader = new Loader();

  public ReadState(Contract paramContract)
  {
    this.contract = paramContract;
  }

  private ReadGraph create(Object paramObject)
    throws Exception
  {
    ReadGraph localReadGraph = (ReadGraph)fetch(paramObject);
    if (localReadGraph == null)
    {
      localReadGraph = new ReadGraph(this.contract, this.loader);
      cache(paramObject, localReadGraph);
    }
    return localReadGraph;
  }

  public ReadGraph find(Object paramObject)
    throws Exception
  {
    ReadGraph localReadGraph = (ReadGraph)fetch(paramObject);
    if (localReadGraph != null)
      return localReadGraph;
    return create(paramObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.ReadState
 * JD-Core Version:    0.6.2
 */