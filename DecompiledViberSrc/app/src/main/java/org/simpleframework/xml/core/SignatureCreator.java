package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.List;

class SignatureCreator
  implements Creator
{
  private final List<Parameter> list;
  private final Signature signature;
  private final Class type;

  public SignatureCreator(Signature paramSignature)
  {
    this.type = paramSignature.getType();
    this.list = paramSignature.getAll();
    this.signature = paramSignature;
  }

  private double getAdjustment(double paramDouble)
  {
    double d = this.list.size() / 1000.0D;
    if (paramDouble > 0.0D)
      return d + paramDouble / this.list.size();
    return paramDouble / this.list.size();
  }

  private double getPercentage(Criteria paramCriteria)
    throws Exception
  {
    Iterator localIterator = this.list.iterator();
    double d1 = 0.0D;
    if (localIterator.hasNext())
    {
      Parameter localParameter = (Parameter)localIterator.next();
      if (paramCriteria.get(localParameter.getKey()) == null)
      {
        if (localParameter.isRequired())
          return -1.0D;
        if (!localParameter.isPrimitive())
          break label93;
        return -1.0D;
      }
    }
    label93: for (double d2 = 1.0D + d1; ; d2 = d1)
    {
      d1 = d2;
      break;
      return getAdjustment(d1);
    }
  }

  private Object getVariable(Criteria paramCriteria, int paramInt)
    throws Exception
  {
    Variable localVariable = paramCriteria.remove(((Parameter)this.list.get(paramInt)).getKey());
    if (localVariable != null)
      return localVariable.getValue();
    return null;
  }

  public Object getInstance()
    throws Exception
  {
    return this.signature.create();
  }

  public Object getInstance(Criteria paramCriteria)
    throws Exception
  {
    Object[] arrayOfObject = this.list.toArray();
    for (int i = 0; i < this.list.size(); i++)
      arrayOfObject[i] = getVariable(paramCriteria, i);
    return this.signature.create(arrayOfObject);
  }

  public double getScore(Criteria paramCriteria)
    throws Exception
  {
    Signature localSignature = this.signature.copy();
    Iterator localIterator = paramCriteria.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      Parameter localParameter = localSignature.get(localObject);
      Variable localVariable = paramCriteria.get(localObject);
      Contact localContact = localVariable.getContact();
      if ((localParameter != null) && (!Support.isAssignable(localVariable.getValue().getClass(), localParameter.getType())))
        return -1.0D;
      if ((localContact.isReadOnly()) && (localParameter == null))
        return -1.0D;
    }
    return getPercentage(paramCriteria);
  }

  public Signature getSignature()
  {
    return this.signature;
  }

  public Class getType()
  {
    return this.type;
  }

  public String toString()
  {
    return this.signature.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.SignatureCreator
 * JD-Core Version:    0.6.2
 */