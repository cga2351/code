package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ConstructorScanner
{
  private Signature primary;
  private ParameterMap registry = new ParameterMap();
  private List<Signature> signatures = new ArrayList();
  private Support support;

  public ConstructorScanner(Detail paramDetail, Support paramSupport)
    throws Exception
  {
    this.support = paramSupport;
    scan(paramDetail);
  }

  private void scan(Constructor paramConstructor)
    throws Exception
  {
    SignatureScanner localSignatureScanner = new SignatureScanner(paramConstructor, this.registry, this.support);
    if (localSignatureScanner.isValid())
    {
      Iterator localIterator = localSignatureScanner.getSignatures().iterator();
      while (localIterator.hasNext())
      {
        Signature localSignature = (Signature)localIterator.next();
        if (localSignature.size() == 0)
          this.primary = localSignature;
        this.signatures.add(localSignature);
      }
    }
  }

  private void scan(Detail paramDetail)
    throws Exception
  {
    int i = 0;
    Constructor[] arrayOfConstructor = paramDetail.getConstructors();
    if (!paramDetail.isInstantiable())
      throw new ConstructorException("Can not construct inner %s", new Object[] { paramDetail });
    int j = arrayOfConstructor.length;
    while (i < j)
    {
      Constructor localConstructor = arrayOfConstructor[i];
      if (!paramDetail.isPrimitive())
        scan(localConstructor);
      i++;
    }
  }

  public ParameterMap getParameters()
  {
    return this.registry;
  }

  public Signature getSignature()
  {
    return this.primary;
  }

  public List<Signature> getSignatures()
  {
    return new ArrayList(this.signatures);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ConstructorScanner
 * JD-Core Version:    0.6.2
 */