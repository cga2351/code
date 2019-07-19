package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ClassInstantiator
  implements Instantiator
{
  private final List<Creator> creators;
  private final Detail detail;
  private final Creator primary;
  private final ParameterMap registry;

  public ClassInstantiator(List<Creator> paramList, Creator paramCreator, ParameterMap paramParameterMap, Detail paramDetail)
  {
    this.creators = paramList;
    this.registry = paramParameterMap;
    this.primary = paramCreator;
    this.detail = paramDetail;
  }

  private Creator getCreator(Criteria paramCriteria)
    throws Exception
  {
    Creator localCreator1 = this.primary;
    Iterator localIterator = this.creators.iterator();
    Object localObject1 = localCreator1;
    double d1 = 0.0D;
    double d2;
    Object localObject2;
    if (localIterator.hasNext())
    {
      Creator localCreator2 = (Creator)localIterator.next();
      d2 = localCreator2.getScore(paramCriteria);
      if (d2 <= d1)
        break label85;
      localObject2 = localCreator2;
    }
    label85: double d3;
    for (double d4 = d2; ; d4 = d3)
    {
      double d5 = d4;
      localObject1 = localObject2;
      d1 = d5;
      break;
      return localObject1;
      d3 = d1;
      localObject2 = localObject1;
    }
  }

  public List<Creator> getCreators()
  {
    return new ArrayList(this.creators);
  }

  public Object getInstance()
    throws Exception
  {
    return this.primary.getInstance();
  }

  public Object getInstance(Criteria paramCriteria)
    throws Exception
  {
    Creator localCreator = getCreator(paramCriteria);
    if (localCreator == null)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.detail;
      throw new PersistenceException("Constructor not matched for %s", arrayOfObject);
    }
    return localCreator.getInstance(paramCriteria);
  }

  public Parameter getParameter(String paramString)
  {
    return (Parameter)this.registry.get(paramString);
  }

  public List<Parameter> getParameters()
  {
    return this.registry.getAll();
  }

  public boolean isDefault()
  {
    if (this.creators.size() <= 1)
      return this.primary != null;
    return false;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.detail;
    return String.format("creator for %s", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ClassInstantiator
 * JD-Core Version:    0.6.2
 */